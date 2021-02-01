Feature: Login with valid and invalid credentials

Scenario Outline: Negative and positive test for validating login
Given Chrome browser is initialized
And Navigate to "https://twitter.com/"
And Click on Login button on landing page
When User enters <username> and <password> and clicks Login button on Login Page
Then Verify that user is succesfully logged in or not depending on <credentials>
And Quit browser

Examples:
|username			|password		|
|invalid@user.xxx	|619tezcka39	|
|HoolahTesting		|619tezcka39    |


