Feature: Create tweet

Scenario: Post a tweet
Given Open Chrome Browser
And Go to "https://twitter.com/" site
And Click Login Button on landing page
And User enters Valid Username and Password then click Login Button on Login Page
When User enters a tweet on home page textbox area
And User clicks Tweet Button
Then Tweet should be posted
And Close browser