# Project Name

## Description
This document highlights setup, test run, conventions followed, and structure of the project Campaign Scheduling
## Prerequisites
Before initiating the setup, please ensure the following requirements are met:
- Java: JDK version 17 or higher
- Maven: Version 3.6.0 or higher
- Campaign Scheduling Project setup - https://gist.github.com/shivam-inflection-io/edda29879786e996d997e8963c7c2435

## Installation
To install and run the project along with all tests, proceed with the following steps:
1. Clone the repository: git clone [repository URL] cd [repository directory]
2. For a clean installation and to execute tests: mvn clean install This command compiles the project and executes all test cases. For future executions, use: mvn verify This command will run all tests without re-compiling the entire project.

## Cucumber Tags
Use Cucumber tags to segregate and run specific subsets of tests. Available tags include:
- `@E2E` for end-to-end tests.
- `@Integration` for integration tests.
- `@Smoke` for critical path smoke tests.
  Examples of how to use these tags in your Cucumber test cases:
- To run only tests tagged with @Smoke, you can execute: mvn verify -Dcucumber.filter.tags="@Smoke"
- To exclude tests tagged with @ignore, use: mvn verify -Dcucumber.filter.tags="not @ignore"

## Reports
Post-testing, locate the test reports here: target/cucumber-html-report.html

## Project Folder Structure
- src/test/..
   - configuration: Contains Spring Boot and Cucumber configurations.
   - dto: Data Transfer Objects (DTOs).
   - pom: Page Object Model files.
   - stepDefinitions: Test Step files linked to Cucumber BDD steps.
   - utils: Utility files.
- src/resources
   - features: Cucumber BDD test cases.
   - application.yml: Configuration properties file; additional build profiles can be integrated.
- target/: Directory for compiled files.
- pom.xml: Maven project file.
- README.md: Documentation for the project.
- TESTPLAN.md: Test Plan document for the project.

## Naming Convention
For maintaining clarity and consistency, adhere to the following naming conventions:
- Classes and Interfaces: Start with a capital letter, and use camel case for subsequent words. Example: SampleClass, MyInterface.
- Methods: Start with a lower case letter, followed by camel case. Example: myMethod().
- Variables: Use descriptive names with camel case starting with a lower case letter. Example: myVariable.
- Constants: Use uppercase letters with underscores to separate words. Example: MY_CONSTANT.

## Git Tags
Utilize Git tags to manage different types of changes within the project. Follow these guidelines:
- Features: [feat] - Tag new features or significant additions to the project.
- Refactoring: [refactor] - Tag code refactoring that neither fixes a bug nor adds a feature.
- Bug Fixes: [fix] - Tag any corrections or fixes to existing functionality.
- Documentation: [docs] - Tag updates or improvements to documentation.
- Style: [style] - Tag changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc).
- Performance: [perf] - Tag changes that improve performance.
- Tests: [test] - Tag when adding missing tests or correcting existing tests.
