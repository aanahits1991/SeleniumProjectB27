package com.cydeo.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleDropdown {

    /*
    TC#3: Verifying “Simple dropdown” and “State selection”
dropdown default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”

     */
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
       /* 1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown*/

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }


    @Test
    public void dropDown() {


//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”

        Select SimpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualResult = SimpleDropDown.getFirstSelectedOption().getText();
        String expectedResult = "Please select an option";

        Assert.assertEquals(actualResult,expectedResult);


//        4. Verify “State selection” default selected value is correct
//        Expected: “Select a State”


        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualResult2 = stateSelection.getFirstSelectedOption().getText();
        String expectedResult2 = "Select a State";

        Assert.assertEquals(actualResult2,expectedResult2);





    }
}
