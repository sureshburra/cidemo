Feature: to perform regression test

Scenario Outline: Google Search
Given user enter <website> in firefox
And enter <keyword> in search textbox
When click on <button>
Then system should return <rows>

Examples:
|website|keyword|button|rows|
|"Google"|"Leanpitch"|"Search"|"10000"|
|"Google"|"CSD"|"Search"|"2000"|
|"Google"|"CSM"|"Search"|"1000"|
