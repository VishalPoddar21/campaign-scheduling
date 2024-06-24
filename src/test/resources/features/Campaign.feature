Feature: Campaign Creation

  Scenario: Email Campaign Creation
    Given I fetch all email templates.
    When I fetch all recipients lists.
    And I create a new email campaign with send time 100
