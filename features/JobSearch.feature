Feature: To Test labcorp site for automation
  Verify user is able to search a job post

  Scenario Outline: Search for job
    Given user navigate to URL "https://www.labcorp.com/"
    When user click on careers link
    And user search for "QA Test Automation Developer"
    And user selects "Senior Software QA Analyst"
    Then User verify "<jobTitle>", "<jobLocation>" and "<jobId>" 
    And user confirms introduction contains "Manual Senior Software"
    And user confirms Requirements is there in page
    Then user confirms shift in page
    And user click on Apply button
    Then I verify "<jobTitle>", "<jobLocation>" and "<jobId>" 
    And user click on page to close popup
    And user clicks on return to job search button
    Then user close the browser
 

   Examples:
       |               jobTitle          |      jobLocation          |  jobId  |
       | Senior Software QA Analyst      | Burlington, North Carolina| 21-85987|