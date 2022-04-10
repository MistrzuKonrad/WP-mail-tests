package FunctionalTest.Testcases;

import FunctionalTest.Fixtures.Utils;
import FunctionalTest.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyLogin {

  private static final WebDriver driver = new ChromeDriver();

  @BeforeSuite
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
  }

  @AfterSuite
  public static void cleanUp(){
    driver.manage().deleteAllCookies();
    driver.close();
  }

  @Test(testName = "Verify if a user will be able to login with a valid username and valid password")
  public static void verifyValidLogin(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterValidUsername();
    loginPage.enterValidPassword();
    loginPage.pressCookieButton();
    loginPage.pressSubmitLoginButton();

    String expectedUrl="https://poczta.wp.pl/w/#/mails/?label=1";
    String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);
  }

  @Test(testName = "Verify if a user cannot login with a valid username and an invalid password")
  public static void verifyValidUsernameAndInvalidPassword(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterValidUsername();
    loginPage.enterWrongPassword();
    loginPage.pressCookieButton();
    loginPage.pressSubmitLoginButton();

    String expectedUrl="https://profil.wp.pl/login/login.html#bad_login";
    String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);

  }

  @Test(testName = "Verify the messages for invalid login")
  public static void verifyMessageForInvalidLogin(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterValidUsername();
    loginPage.enterWrongPassword();
    loginPage.pressCookieButton();
    loginPage.pressSubmitLoginButton();

    //Verify Tooltip
    loginPage.verifyAlertWarning();
  }

  @Test(testName = "Verify the login page for blank  email  and password")
  public static void verifyBlankLoginData(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.pressCookieButton();
    loginPage.pressSubmitLoginButton();

    String expectedUrl= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl,Utils.BASE_URL);
  }

  @Test(testName = "Verify the ‘Forgot Password’ functionality")
  public static void verifyForgotPasswordFunctionality(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.pressCookieButton();
    loginPage.pressSubmitLoginButton();
    loginPage.pressForgetPasswordButton();

    String expectedUrl="https://poczta.wp.pl/odzyskaj";
    String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl,expectedUrl);
  }

  @Test(testName = "Verify if the ‘Enter’ key of the keyboard is working correctly on the login page")
  public static void verifyEnterKey(){

    driver.get(Utils.BASE_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterValidUsername();
    loginPage.enterValidPassword();
    loginPage.pressCookieButton();

    loginPage.clickEnter();

    String expectedUrl="https://poczta.wp.pl/w/#/mails/?label=1";
    String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);
  }



}
