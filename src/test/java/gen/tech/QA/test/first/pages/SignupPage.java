package gen.tech.QA.test.first.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
  Created by ashavlovskyi on 7/22/17.
  Page objects for Rozetka Sign Up page
 */
public class SignupPage {
    private By usernameLocator = By.name("title");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");

    private final WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;

        if (!driver.getCurrentUrl().contains("signup")) {
            throw new IllegalStateException("This is not the signup page");
        }
    }

    public SignupPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public SignupPage typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public SignupPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public MyHomePage submitSignup() {
        //driver.findElement(SingupButtonLocator).submit();
        driver.findElement(usernameLocator).submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(MyHomePage.Title));
        return new MyHomePage(driver);
    }

    public MyHomePage loginAs(String username, String email, String password) {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        return submitSignup();
    }
}
