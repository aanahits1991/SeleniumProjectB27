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

public class SelectingData {


    WebDriver driver;

    @BeforeMethod
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //this line will allow our driver to wait up to given time, if the driver cannot immediately locate web element. Driver does not have to wait until given time. If it's find the web element in 2 sec. it will continue with execution

        driver.get("https://practice.cydeo.com/dropdown");
//        TC #5: Selecting date on dropdown and verifying
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
//        3. Select “December 1st, 1923” and verify it is selected.
//                Select year using   : visible text
//        Select month using    : value attribute Select
//        day using : index number

    }


    @Test
    public void SelectData() {


//        3. Select “December 1st, 1923” and verify it is selected.
//                Select year using   : visible text
//        Select month using    : value attribute Select
//        day using : index number


        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");
        String actualYear = year.getFirstSelectedOption().getText();
        String expectedYear = "1923";
        Assert.assertEquals(actualYear, expectedYear);


        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");

        String actualMonth = month.getFirstSelectedOption().getText();
        String expectedMonth = "December";
        Assert.assertEquals(actualMonth, expectedMonth);


        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);

        String actualDay = day.getFirstSelectedOption().getText();
        String expectedDay = "1";

        Assert.assertEquals(actualDay, expectedDay);

    }


}
