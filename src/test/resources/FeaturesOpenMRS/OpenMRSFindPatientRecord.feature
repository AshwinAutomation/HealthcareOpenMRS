Feature: Patient Record Details

  Scenario: Find Patient Record option
  
    Given select patient record
    When user navigates to FindPatientRecordPage
    Then Page title should "OpenMRS Electronic Medical Record"
