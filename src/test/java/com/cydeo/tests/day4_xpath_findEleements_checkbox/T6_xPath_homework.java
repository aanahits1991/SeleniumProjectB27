package com.cydeo.tests.day4_xpath_findEleements_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T6_xPath_homework {

    public static void main(String[] args) {


        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        // 3. Click on Button 1
        WebElement clickButton1 = driver.findElement(By.xpath("//button[.='Button 1']"));
        clickButton1.click();


        // 4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”

        WebElement clickButton = driver.findElement(By.xpath("//p[@id='result']"));

        String actualResult = clickButton.getText();
        String expectedResult = "Clicked on button one!";

        if(actualResult.equals(expectedResult)){
            System.out.println("Verification is Passed");
        } else{
            System.out.println("Verification is Failed");
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        driver.quit();
    }
}
