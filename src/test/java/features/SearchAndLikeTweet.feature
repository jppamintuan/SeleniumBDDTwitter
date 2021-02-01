Feature: Search and like a tweet

Scenario: Search a tweet and like
Given Chrome Browser is initialized
And Navigate To "https://twitter.com/"
And Click on Login button on Landing page
And User enters valid username and password clicks Login Button on Login Page
When User enters "Wishclusive performance of Panalo now on Wish USA!" and clicks enter key on search text box area on home page
And User clicks like button
Then Tweet should be liked
And Tweet is to be unliked for data cleanup
And Quit Browser