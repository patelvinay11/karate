pipeline{
    agent any

    tools {
        gradle '7.5.1'
    }

    parameters {
    	choice(name: 'Environment', choices: ['staging', 'preprod', 'prod'], description: '')
	}

    stages{
        stage ('Clean WorkSpace Directory'){
            steps {
                //define the single or multiple step
                sh 'echo CleanUp Stage'
                cleanWs notFailBuild: true
            }
        }
        stage ('Git CheckOut'){
            steps {
               //define the single or multiple step
                sh 'echo Git Checkout'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/patelvinay11/karate.git']])
            }

        }
        stage ('Restore Packages'){
            steps {
                //define the single or multiple step
                sh 'echo Restore Package'
            }
        }
        stage ('Build'){
            steps {
               //define the single or multiple step
                sh 'echo Build'
                sh 'gradle clean build -x test'
            }
        }
        stage ('Deploy'){
            steps {
                sh 'echo Deploying the application..'
            }
        }
        stage ('Run the Test') {
            steps {
                 //define the single or multiple step
                sh 'echo Test Execution Started'
                sh 'gradle test -Dkarate.options="--tags @debug" -Dkarate.env="${Environment}"'
            }
        }
    }
    post {
        always {
            junit 'build/karate-reports/*.xml'
            cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'build/karate-reports', pendingStepsNumber: -1, reportTitle: 'Karate Test Execution', skipEmptyJSONFiles: true, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            zip zipFile:'build/test-result.zip', archive: true, dir: 'build/karate-reports', overwrite: true
            //emailext subject: "Job '${env.JOB_NAME} - ${env.BUILD_NUMBER} '", body: 'Refer to the attachment', attachmentsPattern: 'build/test-result.zip', to: 'user2@autoreply.com'
        }

    }
}