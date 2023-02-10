# Magento Selenium WebSite for automation practice

## Page Object Model project for E-commerce

### Acknowledgements

- QA automation specialist: **Kliment Hristov**

### Requirements:

> - IntelliJ idea
> - Java sdk 17+
> - JUnit5 and Selenium dependencies
> - Faker library for java
> - Chrome installed
> - Maven installed

### Pre-requisites

Assume basic competence in software design and development,
as well as some background in computer science.
Specifically, to get started you need:

- Familiarity with the general software development process
  using an IDE (Integrated Development Environment).
- At least 1 year of experience with object-oriented
  programming and the Java programming language.

### Usage

Automate real user interactions in E-Commerce website with
Chrome browser

### Source

The source is structured along the lines of the maven
standard folder structure for a jar project.

- Core classes [src/main/java]
  - folders: helpers, pages, reports, utils, faker, itemsUtils
- Setup test plan before tests
  - folder: base
- Tests [src/test/java/scenarios]
- Constants [src/test/java/constants]
- The source includes a pom.xml for building with Maven
- Screenshots after each test [projectName/resource]

### Release Notes:
version 1.0

#### Covered scenarios
- Create Accounts tests
- Account validation fields before creating account
- Login/Logout tests
- Required fields checks
- Empty fields checks
- Sorting all products by some value
- Set Ascending and Descending order when list a products
- Search valid/invalid data
- Subscribe emails
- Add/Remove products items in the card container
- Purchase and proceed to checkout tests
- Grid/List view for items



