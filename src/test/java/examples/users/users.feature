Feature: sample karate test script
  for help, see: https://github.com/karatelabs/karate/wiki/IDE-Support

  Background:
    * url 'https://reqres.in/api/'

  Scenario: get all users and then get the first user by id and then get the users on 2nd page
    Given path 'users'
    When method get
    Then status 200

    * def first = response.data[0]

    Given path 'users', first.id
    When method get
    Then status 200

    Given path 'users'
    And param page = '2'
    When method get
    Then status 200
    Then response.page == '2'

  Scenario: create a user and then get it by id
    * def user =
      """
      {
        "name": "morpheus",
        "job": "leader"
      }
      """

    Given url 'https://reqres.in/api/users'
    And request user
    When method post
    Then status 201
    Then match response == '#object'
    Then match response.name == 'morpheus'

    * def id = response.id
    * print 'created id is: ', id

    Given path id
    # When method get
    # Then status 200
    # And match response contains user
  