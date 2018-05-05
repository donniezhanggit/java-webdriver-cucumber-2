@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Java" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//*[@name='btnK']"
    Then I wait for element with xpath "//*[@id='ires']" to be present
    Then element with xpath "//*[@id='ires']" should contain text "Java"
    
    @predefined2
    Scenario: Steps for Yandex
      Given I open url "http://yandex.com"
      Then I should see page title as "Yandex"
      Then element with xpath "//*[@id='text']" should be present
      When I type "java" into element with xpath "//*[@id='text']"
      And I click on element with xpath "//*[@type='submit']"
      And I wait for element with xpath "//div[@class='content__left']" to be present
      Then element with xpath "//div[@class='content__left']" should contain text "java"


