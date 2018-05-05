@webdriver
  Feature: Webdriver functions

    @webdriver1
    Scenario: Open the page
      Given I go to "sample" page and print details
      And I go to "google" page and print details
      And I go back and forward, then refresh the page
      And I print logs to the console

      @webdriver2
      Scenario: Loop throgh urls
        Given I open "https://www.google.com" then "https://www.bing.com" then "https://www.yahoo.com"
        
        @webdriver3
        Scenario: Window sizes
          Given I go to "https://www.google.com/" page and print details
          And I change resolution to "desktop"
          And I change resolution to "phone"

          @webdriver4
          Scenario: Element steps
            Given I go to "sample" page and print details
#            When I fill out first name "Elena" and last name "Iskhacova"
            When I fill out required fields
            And I submit the page
            Then I verify fields values recorded correctly

            @webdriver5
            Scenario: Validate Zip code for Portnov Computer School
              Given I open "usps" page
              When I go to Lookup ZIP page by address
              And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
              Then I validate "94022" zip code exists in the result






