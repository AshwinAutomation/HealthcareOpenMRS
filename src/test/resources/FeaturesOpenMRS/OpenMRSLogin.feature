Feature: OpenMRS Login feature for various location

  Background: 
    Given user already logged in to application
      | username | password |
      | Admin    | Admin123 |

  Scenario: Login OpenMRS for Inpatient Ward
    Then user Logged in as Super User (admin) at Inpatient Ward
    When user navigates to homepage
    Then Page title should be "Home"

  Scenario: Login OpenMRS for Isolation Ward
    Then user Logged in as Super User (admin) at Isolation Ward
    When user navigates to homepage
    Then Page title should be "Home"

  Scenario: Login OpenMRS for  Laboratory
    Then user Logged in as Super User (admin) at Laboratory
    When user navigates to homepage
    Then Page title should be "Home"

  Scenario: Login OpenMRS for Outpatient Clinic
    Then user Logged in as Super User (admin) at Outpatient Clinic
    When user navigates to homepage
    Then Page title should be "Home"

  Scenario: Login OpenMRS for Pharmacy
    Then user Logged in as Super User (admin) at Pharmacy
    When user navigates to homepage
    Then Page title should be "Home"

  Scenario: Login OpenMRS for Registration Desk
    Then user Logged in as Super User (admin) at Registration Desk
    When user navigates to homepage
    Then Page title should be "Home"



    