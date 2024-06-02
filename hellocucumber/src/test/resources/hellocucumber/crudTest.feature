Feature: Test crud for https://qauto2.forstudy.space/api

  Scenario: Create user and update profile info
    Given URI is set to "https://qauto2.forstudy.space"
    When new user is created
    Then status code is 201
    And session cookies stored

    When user profile is updated
    Then status code is 201

    When user profile info is requested
    Then status code is 201
