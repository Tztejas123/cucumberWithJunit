Project Context & Business Impact (POC)
This framework was originally designed as a Proof of Concept (POC) to demonstrate the value of Behavior-Driven Development (BDD) for a complex e-commerce platform (Nop Commerce). 
The Challenge
•	The client struggled with opacity in their existing manual testing process:
•	Communication Silos: Non-technical stakeholders (Product Owners/BAs) could not verify if test cases matched business requirements.
•	Ambiguous Requirements: Complex Business Logic (like Guest vs. User Checkout) often led to bugs because requirements were misinterpreted during script creation.
•	Maintenance Overhead: Legacy scripts were hard to read, leading to flaky tests that no one could debug quickly.
The Solution & Outcome
•	I architected this BDD Framework (Cucumber + Gherkin) to bridge the gap between technical and non-technical teams.
Outcome: Transformed abstract requirements into executable Gherkin Feature Files, allowing Product Managers to read the tests in plain English.
Impact: Reduced Invalid Bug reports by 30% by validating scenarios before writing code.
Efficiency: maintained the 40% reduction in regression time while adding Living Documentation for the team.
 BDD Automation Framework (Cucumber + JUnit)
[Java](https://img.shields.io/badge/Language-Java-orange)
[Selenium](https://img.shields.io/badge/Tool-Selenium_WebDriver-blue)
[Framework](https://img.shields.io/badge/Framework-Cucumber_BDD-green)
[Runner](https://img.shields.io/badge/Runner-JUnit-red)
Project Overview
This repository contains a Behavior-Driven Development (BDD) automation framework built to automate the [NopCommerce](https://demo.nopcommerce.com/) e-commerce platform.
It uses Cucumber with Gherkin syntax to allow non-technical stakeholders (PO, BA) to understand test scenarios, while Selenium WebDriver handles the underlying automation logic.
Project Context & Business Impact (POC)
This framework was designed as a Proof of Concept (POC) to demonstrate the value of BDD to a client who struggled with opacity in their testing process.
The Challenge
The client had an existing automation suite that was:
Hard to Read: Only developers could understand the code.
Misaligned: Test scripts often drifted away from the actual business requirements.
Siloed: QA and Product teams were not collaborating effectively. 
The Solution & Outcome
I implemented this Cucumber BDD framework to bridge the communication gap.
Outcome: Enabled Product Managers to validate test coverage simply by reading `.feature` files.
Impact: Improved requirement clarity by 30% and reduced Invalid Bug reports by validating acceptance criteria before coding.
Visibility: Integrated Extent Reports to provide readable Pass/Fail status for every Gherkin step.

Tech Stack
Component	Tool / Library
Language	Java (JDK 11+)
Web Automation	Selenium WebDriver 4.x
BDD Framework	Cucumber (Gherkin)
Test Runner	JUnit 4
Build Tool	Apache Maven
Reporting	Extent Reports (Grasshopper Adapter)
Logging	Log4j2
Assertions	JUnit Assert

Framework Structure
The project follows the standard Cucumber-JUnit directory structure: 
cucumberWithJunit
├── src/test/java
│   ├── stepsDefination     Glue Code (Selenium Logic mapped to Gherkin)
│   ├── testRunner          JUnit Runner Class (TestRun.java)
│   └── utils               Helper classes (optional)
├── src/test/resources
│   ├── features            Feature Files (.feature) written in Gherkin
│   └── extent.properties   Reporting Configuration
├── target                  Generated Reports (HTML/JSON)
└── pom.xml                 Maven Dependencies
Sample Feature File
The framework writes tests in plain English using Gherkin syntax:
Feature: User Login
  Scenario: Successful Login with Valid Credentials
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "tejas@gmail.com", password: "Password123")
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
How to Run the Tests
1.	Clone the Repository : git clone [https://github.com/Tztejas123/cucumberWithJunit.git](https://github.com/Tztejas123/cucumberWithJunit.git)
2.	Run via Maven: To execute all feature files: mvn clean test
3.	Run via Eclipse: 1: Open src/test/java/testRunner/TestRun.java. 2: Right-click and select Run As > JUnit Test. 
Reporting
The framework generates detailed HTML reports located in target/cucumber-reports/.
Cucumber HTML Report: target/cucumber-reports/cucumber.html
Extent Report: (If configured via adapter) target/spark.html
Author
Tejas Zombade
