Feature: Campaign Creation

  Scenario Outline: Campaign Creation
    Given I fetch all email templates
    When I fetch all recipients lists
    And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
    Then the response status should be <resCode>

    # Test cases for creating an email campaign
    Examples:
      | sendTime    | recListId | emailTemp  | resCode |
      # Create a campaign with send time as 0, any recipient list, any email template; expect success (201).
      | 0           | any       | any        | 201     |
      # Create a campaign with send time as 1, any recipient list, email template "EM-001"; expect success (201).
      | 1           | any       | EM-001     | 201     |
      # Create a campaign with send time as 2147483647, recipient list "RL-001", any email template; expect success (201).
      | 2147483647  | RL-001    | any        | 201     |
      # Create a campaign with send time as 200, any recipient list, email template "template1"; expect failure (404).
      | 200         | any       | template1  | 404     |
      # Create a campaign with send time as 300, recipient list "123", any email template; expect failure (404).
      | 300         | 123       | any        | 404     |
      # Create a campaign with send time as 400, recipient list "456", email template "template2"; expect failure (404).
      | 400         | 456       | template2  | 404     |
      # Create a campaign with a negative send time (-2147483647), any recipient list, any email template; expect failure (400).
      | -2147483647 | any       | any        | 400     |
      # Create a campaign with a negative send time (-1), any recipient list, any email template; expect failure (400).
      | -1          | any       | any        | 400     |

  Scenario Outline: Campaign Creation for email template
    When I fetch all recipients lists
    And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
    Then the response status should be <resCode>

    # Test cases for creating an email campaign with specific email templates
    Examples:
      | sendTime | recListId | emailTemp | resCode |
      # Create a campaign with send time as 1, any recipient list, email template "EM-001"; expect success (201).
      | 1        | any       | EM-001    | 201     |

  Scenario Outline: Campaign Creation for recipients list
    When I fetch all recipients lists
    And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
    Then the response status should be <resCode>

    # Test cases for creating an email campaign with specific recipient lists
    Examples:
      | sendTime | recListId | emailTemp | resCode |
      # Create a campaign with send time as 2147483647, recipient list "RL-001", any email template; expect success (201).
      | 2147483647 | RL-001   | any      | 201     |

  Scenario: Update Campaign
    Given I fetch all email templates
    And I fetch all recipients lists
    When I create a new email campaign with send time 100, email template "any" and recipients list "any"
    And I update campaign name
    Then the response status should be 200
    And I get last campaign and verify name
    Then the response status should be 200

  Scenario Outline: Get recipients list with id
    Given I fetch recipients list for "<id>"
    Then the response status should be <resCode>

    Examples:
      | id         | resCode |
      # Fetch recipient list with id "RL-001"; expect success (200).
      | RL-001     | 200     |
      # Fetch recipient list with invalid id; expect failure (400).
      | negative   | 404     |

  Scenario Outline: Get email template with id
    Given I fetch email template with "<id>"
    Then the response status should be <resCode>

    Examples:
      | id         | resCode |
      # Fetch email template with id "EM-001"; expect success (200).
      | EM-001     | 200     |
      # Fetch email template with invalid id; expect failure (400).
      | negative   | 404     |