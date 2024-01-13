# Karate Template

Refer to the [Getting Started Guide](https://github.com/karatelabs/karate/wiki/Get-Started:-Maven-and-Gradle#github-template) for instructions.

* To start an app from Terminal
  * java -jar -Dserver.port=9898 jar/jobportal-0.0.1-SNAPSHOT.jar
    * Keep the terminal open otherwise the app will go down.

* To Access swagger documentation:
  * http://localhost:9898/swagger-ui.html

Karate Documentation: https://karatelabs.github.io/karate/

JSON Path Documentation: https://github.com/json-path/JsonPath
JSONPath Online Evaluator: https://jsonpath.com/

* Terminal Run Command: 
    * gradle clean test "-Dkarate.options=--tags @debug"

Mock Server Documentation: https://mock-server.com/versions/5.3.0/apidocs/index.html