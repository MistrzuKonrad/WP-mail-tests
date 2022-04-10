# Testing web https://profil.wp.pl/login/login.html 

## Getting Started

### Dependencies

* Selenium WebDriver with Java 
* Maven

## Installing

# To use the system:
* install all dependencies

### Executing program

## How to run the program
* configure the environment
* contract all dependencies
* go to FunctionalTest\Testcases\VerifyLogin.java
* run the test by using the green arrow under @Test

## How to use this test on CI/CD
if you want to run a test in github action, follow the instructions below
https://docs.gitlab.com/ee/ci/examples/end_to_end_testing_webdriverio/

##Test cases
* Verify if a user will be able to login with a valid username and valid password
* Verify if a user cannot login with a valid username and an invalid password 
* Verify the messages for invalid login
* Verify the login page for blank  email  and password
* Verify the ‘Forgot Password’ functionality
* Verify if the ‘Enter’ key of the keyboard is working correctly on the login page


## Authors
Konrad Mamla
