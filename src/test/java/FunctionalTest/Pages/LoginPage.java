package FunctionalTest.Pages;

import FunctionalTest.Fixtures.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//class store all locator and methods
public class LoginPage extends PageObject {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  private final String VALID_LOGIN = "test_login123";
  private final String VALID_PASSWORD = "Passsword123";
  private final String WRONG_PASSWORD = "password321";


  @FindBy(id = "login")
  private WebElement username;

  @FindBy(id = "password")
  private WebElement password, enterButton;


  @FindBy(xpath = "//button[contains(text(),'AKCEPTUJĘ I PRZECHODZĘ DO SERWISU')]")
  private WebElement cookie_button;


  @FindBy(xpath = "//*[@id=\"stgMain\"]/div/div/div[1]/form/button")
  private WebElement submit_button;

  @FindBy(xpath = "//*[@id=\"stgMain\"]/div/div/div[1]/a[1]")
  private WebElement forget_password_button;

  @FindBy(xpath = "//*[@id=\"stgMain\"]/div/div/div[1]/form/div[3]/span")
  private WebElement alertWarning;

  public void enterValidUsername(){
    this.username.sendKeys(VALID_LOGIN);
  }

  public void enterValidPassword(){
    this.password.sendKeys(VALID_PASSWORD);
  }

  public void enterWrongPassword(){
    this.password.sendKeys(WRONG_PASSWORD);
  }

  public void pressCookieButton(){
    this.cookie_button.click();
  }

  public void pressSubmitLoginButton(){
    this.submit_button.click();
  }

  public void pressForgetPasswordButton(){
    this.forget_password_button.click();
  }

  public void verifyAlertWarning(){
    this.alertWarning.isDisplayed();
  }

  public void clickEnter(){
    this.enterButton.sendKeys(Keys.ENTER);
  }


}
