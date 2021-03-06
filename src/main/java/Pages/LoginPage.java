package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

  WebDriverWait wait;
  private WebDriver driver = null; // хранилище
  private By userNameInput = By.id("login-form-username");
  private By passwordInput = By.id("login-form-password");
  private By loginButton = By.id("login");
  private By loginFormSubmit = By.id("login-form-submit");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterUserName(String name) {
    driver.findElement(userNameInput).clear();
    driver.findElement(userNameInput).sendKeys(name);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordInput).sendKeys(password);
  }

  public void clickLogin() {
    driver.findElement(loginButton).click();
  }

  public void clickLoginFormSubmit(){
    driver.findElement(loginFormSubmit).click();
  }

  public void navigateToDashboard(){
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public void navigateToTask12061(){
    driver.get("https://jira.hillel.it/browse/WEBINAR-12061");
  }

  public boolean errorMessageIsPresent(String message){
    wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
    return wait.until(presenceOfElementLocated(By.xpath("//*[contains(text()," + message + ")]"))).isDisplayed();
  }
}
