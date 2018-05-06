@java
  Feature: Java scenarios

    @java1
    Scenario: Java steps
      Given I write java code

      @java2
      Scenario: Java steps with argument
        Given I print "Elena" argument

        @java3
        Scenario: Java steps with two variables
          Given I perform actions with "my var" and "my VAR"

          @java4
          Scenario: Java steps with numbers
            Given I run operators with 7 and 18

            @java5
            Scenario: Java step with strings
              Given I compare "string" and "String2"

              @java6
              Scenario: Url printing
                Given I print url for "yahoo" page

                @java7
                Scenario: Java arrays
                  Given I print arrays

                  @java8
                  Scenario: ForEach Loop
                    Given I open "https://www.google.com" then ""

                    @ja