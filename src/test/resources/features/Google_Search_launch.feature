
Feature: Demo_script

  @UserStory
  @TestId_1003

  Scenario: Sample script showing google serach and launch
    Given user loads the data from "excel" located at "src\test\resources\Fixture\TestData.xlsx"
    Then user launches browser with url "#url"
    Then user search for keyword "#Keyword"
   
  @UserStory
  @TestId_1001  

  Scenario: Sample script showing google serach and launch
    Given user loads the data from "excel" located at "src\test\resources\Fixture\TestData.xlsx"
    Then user launches browser with url "#url"
    Then user search for keyword "#Keyword"
    Then user click on the first hyperlink
    
 
 
 
 