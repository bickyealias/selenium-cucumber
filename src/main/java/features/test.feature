Feature:Amazon Test

@BasicSearch
Scenario Outline:Launch Amazon and Select product
Given User is on shopping site "http://amazon.com" Home Page
When Page is loaded search for <products>
Then User is taken to the respective landing pages

Examples:
|products|
|mobile|
|laptops|