@usps
  Feature: USPS functions validation

    @usps1
    Scenario: Validate ZIP code functionality
      Given I open "USPS" page
      When go to lookup ZIP page by address
      And I fill out "4970 El Camino Real" street, "Los	Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result