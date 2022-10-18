package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_Homework {
    public static void main(String[] args) {


        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        // 1- Open a chrome browser

       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //  2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");


        // 3- Enter incorrect username into login box:

        WebElement incorrectUserName = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));

        incorrectUserName.sendKeys("incorrect");

        // 4- Click to `Reset password` button

        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        resetPasswordButton.click();


        //  5- Verify “error” label is as expected
        //  Expected: Login or E-mail not found

        WebElement errorLable = driver.findElement(By.cssSelector("div[class='errortext']"));

        String actualResult = errorLable.getText();
        String expectedResult = "Login or E-mail not found";

        if (actualResult.equals(expectedResult)) {
            System.out.println("Verification of Error Label is passed");
        } else {
            System.out.println("Verification of Error Label is failed");
        }

     /*   PS:
        Inspect and decide which locator you should be using to locate web
        elements.
                PS2:Pay attention to where to get the text of this button from
*/

    }

}
