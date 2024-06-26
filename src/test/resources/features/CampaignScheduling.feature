Feature: Campaign Creation
# This feature encompasses all scenarios related to the creation, updating, and management of email campaigns.

@E2E @Smoke
Scenario Outline: Campaign Creation
Given I fetch all email templates
When I fetch all recipients lists
And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
Then the response status should be <resCode>

# Test Cases:
Examples:
| sendTime    | recListId | emailTemp  | resCode | TestCaseNumber | Test Description                                                                 |
| 0           | any       | any        | 201     | TC1.1_1        | Create a campaign with send time as 0, any recipient list, any email template; expect success (201).        |
| 1           | any       | EM-001     | 201     | TC1.1_2        | Create a campaign with send time as 1, any recipient list, email template "EM-001"; expect success (201).   |
| 2147483647  | RL-001    | any        | 201     | TC1.1_3        | Create a campaign with send time as 2147483647, recipient list "RL-001", any email template; expect success (201). |
| 200         | any       | template1  | 404     | TC1.1_4        | Create a campaign with send time as 200, any recipient list, email template "template1"; expect failure (404). |
| 300         | 123       | any        | 404     | TC1.1_5        | Create a campaign with send time as 300, recipient list "123", any email template; expect failure (404).    |
| 400         | 456       | template2  | 404     | TC1.1_6        | Create a campaign with send time as 400, recipient list "456", email template "template2"; expect failure (404). |
| -2147483647 | any       | any        | 400     | TC1.1_7        | Create a campaign with a negative send time (-2147483647), any recipient list, any email template; expect failure (400). |
| -1          | any       | any        | 400     | TC1.1_8        | Create a campaign with a negative send time (-1), any recipient list, any email template; expect failure (400). |
| 1687694400  | any       | any        | 201     | TC1.1_9        | Typical valid timestamp (June 25, 2023, 12:00:00 UTC).                                                         |
| 1678586400  | any       | any        | 201     | TC1.1_10       | DST start time (March 12, 2023, 02:00:00 UTC, start of DST in the US).                                         |
| 1687651200  | any       | any        | 201     | TC1.1_11       | Start of day (June 25, 2023, 00:00:00 UTC).                                                                    |
| 1687737599  | any       | any        | 201     | TC1.1_12       | End of day (June 25, 2023, 23:59:59 UTC).                                                                      |
| 1709251199  | any       | any        | 201     | TC1.1_13       | Leap year Feb end (February 29, 2024, 23:59:59 UTC).                                                           |
| 1677628799  | any       | any        | 201     | TC1.1_14       | Non-leap year Feb end (February 28, 2023, 23:59:59 UTC).                                                       |
| 1678586399  | any       | any        | 201     | TC1.1_15       | Before DST change (March 12, 2023, 01:59:59 UTC).                                                              |
| 1678590000  | any       | any        | 201     | TC1.1_16       | After DST change (March 12, 2023, 03:00:00 UTC).                                                               |
| 1704067199  | any       | any        | 201     | TC1.1_17       | Year end (December 31, 2023, 23:59:59 UTC).                                                                    |
| 1704067200  | any       | any        | 201     | TC1.1_18       | Year start (January 1, 2024, 00:00:00 UTC).                                                                    |

@Integration
Scenario Outline: Campaign Creation Integration
  And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
  Then the response status should be <resCode>

# Test Cases:
  Examples:
  | sendTime    | recListId | emailTemp  | resCode | TestCaseNumber | Test Description                                                                 |
  | 1687694400  | RL-001    | EM-001     | 201     | TC1.1_9        | Typical valid timestamp (June 25, 2023, 12:00:00 UTC).                                                         |
  | 1678586400  | RL-001    | EM-001     | 201     | TC1.1_10       | DST start time (March 12, 2023, 02:00:00 UTC, start of DST in the US).                                         |
  | 1687651200  | RL-001    | EM-001     | 201     | TC1.1_11       | Start of day (June 25, 2023, 00:00:00 UTC).                                                                    |
  | 1687737599  | RL-001    | EM-001     | 201     | TC1.1_12       | End of day (June 25, 2023, 23:59:59 UTC).                                                                      |
  | 1709251199  | RL-001    | EM-001     | 201     | TC1.1_13       | Leap year Feb end (February 29, 2024, 23:59:59 UTC).                                                           |
  | 1677628799  | RL-001    | EM-001     | 201     | TC1.1_14       | Non-leap year Feb end (February 28, 2023, 23:59:59 UTC).                                                       |
  | 1678586399  | RL-001    | EM-001     | 201     | TC1.1_15       | Before DST change (March 12, 2023, 01:59:59 UTC).                                                              |
  | 1678590000  | RL-001    | EM-001     | 201     | TC1.1_16       | After DST change (March 12, 2023, 03:00:00 UTC).                                                               |
  | 1704067199  | RL-001    | EM-001     | 201     | TC1.1_17       | Year end (December 31, 2023, 23:59:59 UTC).                                                                    |
  | 1704067200  | RL-001    | EM-001     | 201     | TC1.1_18       | Year start (January 1, 2024, 00:00:00 UTC).                                                                    |


@E2E
Scenario Outline: Campaign Creation for email template
When I fetch all recipients lists
And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
Then the response status should be <resCode>

# Test Cases:
Examples:
| sendTime | recListId | emailTemp | resCode | TestCaseNumber | Test Description                                          |
| 1        | any       | EM-001    | 201     | TC1.2_1        | Use specific template "EM-001"; expect success (201).     |

@E2E
Scenario Outline: Campaign Creation for recipients list
When I fetch all recipients lists
And I create a new email campaign with send time <sendTime>, email template "<emailTemp>" and recipients list "<recListId>"
Then the response status should be <resCode>

# Test Cases:
Examples:
| sendTime | recListId | emailTemp | resCode | TestCaseNumber | Test Description                                        |
| 2147483647 | RL-001   | any      | 201     | TC1.3_1        | Maximum time, specific list "RL-001"; expect success (201). |

@E2E
Scenario: Update Campaign
Given I fetch all email templates
And I fetch all recipients lists
When I create a new email campaign with send time 100, email template "any" and recipients list "any"
And I update campaign name
Then the response status should be 200
And I get last campaign and verify name
Then the response status should be 200

@E2E
Scenario Outline: Get recipients list with id
Given I fetch recipients list for "<id>"
Then the response status should be <resCode>

# Test Cases:
Examples:
| id       | resCode | TestCaseNumber | Test Description                            |
| RL-001   | 200     | TC1.5_1        | Fetch valid recipient list ID "RL-001"; expect success (200). |
| negative | 404     | TC1.5_2        | Fetch invalid ID; expect failure (404).    |

@E2E
Scenario Outline: Get email template with id
Given I fetch email template with "<id>"
Then the response status should be <resCode>

# Test Cases:
Examples:
| id         | resCode | TestCaseNumber | Test Description                                 |
| EM-001     | 200     | TC1.6_1        | Fetch valid email template ID "EM-001"; expect success (200). |
| negative   | 404     | TC1.6_2        | Fetch invalid ID; expect failure (404).          |
