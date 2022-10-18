package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {


        //Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");


        // 3- Verify “remember me” label text is as expected:
        // Expected: Remember me on this computer


        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberLabel = "Remember me on this computer";
        String actualRememberLabel = rememberMe.getText();

        if (actualRememberLabel.equals(expectedRememberLabel)) {
            System.out.println("Verification is passed");
        } else {
            System.out.println("Verification is failed");
        }

        //  4- Verify “forgot password” link text is as expected:
        //   Expected: FORGOT YOUR PASSWORD?

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedResult = "FORGOT YOUR PASSWORD?";
        String actualResult = forgotPasswordLink.getText();


        if (expectedResult.equals(actualResult)) {
            System.out.println("Forgot password link verification is passed");
        } else {

            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
            System.out.println("Forgot password link verification is failed");
        }

        //       5- Verify “forgot password” href attribute’s value contains expected:
        // Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPasswordLink.getAttribute("href");

        if (actualInHref.contains(expectedInHref)) {
            System.out.println("Href attribute value is Passed");
        } else {
            System.out.println("Href attribute value is Failed");
        }

        driver.quit();
    }
}
