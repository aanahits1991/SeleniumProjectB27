package com.cydeo.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StaleElementReferenceException1 {


    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
     /*   1. Open Chrome browser
        2. Go to https://practice.cydeo.com/add_remove_elements/  */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");

    }


    @Test
    public void StaleElementExp(){
        /*

3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.  USE
XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */


        //3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementBtn.click();

        //4 . Verify “Delete” button is displayed after clicking.

        WebElement deleteBtn = driver.findElement(By.xpath("//button[text()='Delete']"));

        String actual = deleteBtn.getText();
        String expected ="Delete";
        Assert.assertEquals(actual,expected);

        //5. Click to “Delete” button.

        deleteBtn.click();

       // 6. Verify “Delete” button is NOT displayed after clicking.

        try {

            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());

        }catch (StaleElementReferenceException e){

            System.out.println("exception is thrown");
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
