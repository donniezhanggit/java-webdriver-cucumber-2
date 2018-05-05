@sample
  Feature: Predefine steps for Sample page

    @sample1
    Scenario: Responsive UI test
      Given I open url "http://skryabin.com/webdriver/html/sample.html"
      And I resize window to 1280 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      And I resize window to 400 and 1024
      Then element with xpath "//b[@id='location']" should not be displayed

      @sample2
      Scenario: Username field test
        Given I open url "http://skryabin.com/webdriver/html/sample.html"
        When I type "a" into element with xpath "//input[@ng-model='formData.username']"
        And I click on element with xpath "//input[@id='password']"
        Then element with xpath "//label[@id='username-error']" should be displayed

        Given I clear element with xpath "//input[@ng-model='formData.username']"
        When I type "ap" into element with xpath "//input[@ng-model='formData.username']"
        Then element with xpath "//label[@id='username-error']" should not be displayed

        @sample3
        Scenario: Email field behavior
          Given I open url "http://skryabin.com/webdriver/html/sample.html"

          When I type "b_elene" into element with xpath "//input[@name='email']"
          And I click on element with xpath "//button[@id='formSubmit']"
          Then element with xpath "//*[@id='email-error']" should be displayed
          And element with xpath "//*[@id='email-error']" should contain text "Please enter a valid email address."
          
          When I clear element with xpath "//input[@name='email']"
          Then element with xpath "//*[@id='email-error']" should be displayed
          And element with xpath "//*[@id='email-error']" should contain text "This field is required."

          When I type "b_elene@me.com" into element with xpath "//input[@name='email']"
          And I click on element with xpath "//button[@id='formSubmit']"
          Then element with xpath "//*[@id='email-error']" should not be displayed

          @sample4
          Scenario: Confirm password field
            Given I open url "http://skryabin.com/webdriver/html/sample.html"
            Then element with xpath "//input[@id='confirmPassword']" should be disabled
            
            When I type "123" into element with xpath "//input[@id='password']"
            Then element with xpath "//input[@id='confirmPassword']" should be enabled
            
            When I clear element with xpath "//input[@id='password']"
            And I click on element with xpath "//button[@id='formSubmit']"
            Then element with xpath "//input[@id='confirmPassword']" should be disabled

            @sample5
            Scenario: Name filed behaviour
              Given I open url "http://skryabin.com/webdriver/html/sample.html"

              When I click on element with xpath "//input[@id='name']"
              Then element with xpath "//*[@role='dialog']" should be displayed

              When I type "1" into element with xpath "//input[@id='firstName']"
              And I type "2" into element with xpath "//input[@id='firstName']"
              And I type "3" into element with xpath "//input[@id='firstName']"
              And I click on element with xpath "//span[@class='ui-button-text'][contains(text(),'Save')]"
#              Then element with xpath "//input[@id='name']" should contain text "1 2 3"
  
                @sample6
                Scenario: Validation of name field
                  Given I open url "http://skryabin.com/webdriver/html/sample.html"
                  
                  When I click on element with xpath "//*[@name='name']"
                  Then element with xpath "//*[@id='nameDialog']/.." should be displayed
                  
                  And I type "Elena" into element with xpath "//input[@id='firstName']"
                  And I type "S" into element with xpath "//input[@id='middleName']"
                  And I type "Isk" into element with xpath "//input[@id='lastName']"
                  And I click on element with xpath "//span[@class='ui-button-text'][contains(text(),'Save')]"
                  Then element with xpath "//input[@id='name']" should have attribute "value" as "Elena S Isk"
                  
                  @sample7
                  Scenario: Date picker validation
                    Given I open url "http://skryabin.com/webdriver/html/sample.html"
                    
                    When I click on element with xpath "//input[@id='dateOfBirth']"
                    Then element with xpath "//*[@id='ui-datepicker-div']" should be displayed
                    
                    When I click on element with xpath "//select[@data-handler='selectMonth']/option[@value='1']"
                    Then element with xpath "//select[@data-handler='selectMonth']/option[@value='1']" should be selected
                    
                    When I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1988']"
                    Then element with xpath "//select[@data-handler='selectYear']/option[@value='1988']" should be selected
                    
                    When I click on element with xpath "//*[@data-handler='selectDay']/*[text()='7']"
                    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "02/07/1988"
                    
                    @sample8
                    Scenario: Iframes
                      Given I open url "http://skryabin.com/webdriver/html/sample.html"
                      When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
                      And I type "Elena" into element with xpath "//*[@id='contactPersonName']"
                      And I type "S" into element with xpath "//*[@id='contactPersonPhone']"
                      And I switch to default content
                      And I click on element with xpath "//*[contains(text(),'Privacy Policy')]"

                      @sample9
                      Scenario: New windows
                        Given I open url "http://skryabin.com/webdriver/html/sample.html"
                        When I click on element with xpath "//*[contains(@onclick,'new_window')]"
                        When I switch to new window
                        Then element with xpath "/html" should contain text "Document 2"
                        When I switch to first window








        

