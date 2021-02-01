Feature: Delete tweet

Scenario: Delete recent tweet
Given Chrome browser initialization
And Go to "https://twitter.com/" website
And Click login button on landing Page
And User enters valid Username and Password then click Login Button on Login Page
When User clicks caret button
And User clicks delete button
And User clicks delete confirmation button
Then Most recent tweet should be deleted
And Close the browser