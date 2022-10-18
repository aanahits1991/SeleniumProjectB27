package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_1_homework {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");


    }

    @Test
    public void NumberOfLinks(){

//        Count the number of the links on the page and verify
//        Expected: 332

        List<WebElement> allLinks= driver.findElements(By.xpath("//a[contains(@href,'https')]"));
        Integer numOfLinks = 0;

        for(WebElement eachLink: allLinks){
            numOfLinks++;
        }

        System.out.println(numOfLinks);

        Assert.assertEquals(allLinks.size(),332);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
