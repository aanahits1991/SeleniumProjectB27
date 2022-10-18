package com.cydeo.tests.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class getText_getAttribute {

    /*
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement loginBoxButton = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));

        loginBoxButton.sendKeys("ghagh");

        WebElement resetPasswordBtn= driver.findElement(By.xpath("//button[.='Reset password']"));
        resetPasswordBtn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='errortext']"));

        String actualResult = errorMessage.getText();
        String expectedResult = "Login or E-mail not found";


        if(actualResult.equals(expectedResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }


        driver.quit();
    }

}
