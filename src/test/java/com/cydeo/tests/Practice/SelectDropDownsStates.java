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

public class SelectDropDownsStates {
    /*
    TC #4: Selecting state from State dropdown and verifying
result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)

     */


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

//        1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/dropdown


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //this line will allow our driver to wait up to given time, if the driver cannot immediately locate web element. Driver does not have to wait until given time. If it's find the web element in 2 sec. it will continue with execution

        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void States() {

        Select states = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        System.out.println("states.getFirstSelectedOption() = " + states.getFirstSelectedOption());


//        3. Select Illinois
        states.selectByValue("IL");

//        4. Select Virginia

        states.deselectByVisibleText("Virginia");


//        5. Select California

        states.selectByIndex(5);


//        6. Verify final selected option is California.
//        Use all Select options. (visible text, value, index)

        String actualCalifornia= states.getFirstSelectedOption().getText();
        String expectedCalifornia = "California";

        Assert.assertEquals(actualCalifornia,expectedCalifornia);



    }
}
