# Test Plan for Marketing Campaign Scheduling Feature

## Feature Description
The Marketing Campaign Scheduling feature enables users to schedule email campaigns to be sent at specific dates and times (in UTC). Users can configure various parameters for their campaigns, including selecting recipient lists and specifying email templates. This feature ensures that campaigns are sent out accurately and can efficiently handle large volumes of emails.

## Test Objective
To perform end-to-end testing to ensure the high quality of the Marketing Campaign Scheduling feature.

## Test Scope
- The tests utilize UTC timestamps.
- Deleting campaigns is not covered due to the unavailability of a suitable API.
- Database validation is not included in this testing.
- Schema validation is part of the testing.
- Frontend testing is not included.

## Test Environment
A local test environment is set up using a Docker Compose file.

## Testing Tools
- Automated testing tools: RestAssured with Cucumber and Spring Boot.

## Test Data
- Sample recipient lists and email templates are used in the test environment.
- Mock data for dates, times, and user inputs to simulate various scenarios and boundary conditions.

## Reporting
- Document all test cases, their execution status, and outcomes in a detailed HTML test report.

## Further Enhancements
- Test IDs and descriptions from Cucumber examples can be reused in a test management tool such as TestRail or Jira.
- Automated execution can be set up with tools such as Jenkins.
- Recipient lists and email templates can be fetched based on additional user parameters.
