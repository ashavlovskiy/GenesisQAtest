package gen.tech.QA.test.first.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ashavlovskyi on 7/22/17.
 */
public class MyHomePage {


    static public String Title = "Личные данные";
    By email = By.xpath ("//*[@id=\"personal_information\"]/div/div/div[2]/div/div/div[2]/div[2]"); // не лучший вариант, но я ничего более красивого не придумал

    private final WebDriver driver;

    public MyHomePage (WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().contains(Title)) {
            throw new IllegalStateException("This is not the My.home page");
        }
    }

    public String getEmail() {
        return driver.findElement(email).getText();
    }


}