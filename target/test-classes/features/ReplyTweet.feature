Feature: Reply tweet

Scenario: Reply to recent tweet
Given Initialize Chrome browser
And Go to "https://twitter.com/"
And Click on Login Button on Landing page
And User enters Valid Username and Password then clicks Login Button on Login Page
When User clicks reply button and enters a tweet on reply textbox area
And User clicks Reply Tweet Button
Then Replied Tweet should be displayed
And Close Browser