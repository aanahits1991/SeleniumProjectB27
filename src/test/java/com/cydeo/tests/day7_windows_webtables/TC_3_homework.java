package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_3_homework {

    /*
    TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109
     */

    WebDriver driver;

    @BeforeMethod
    public void Setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");


    }

    @Test
    public void numsOfLinksWithoutText(){
        List<WebElement> allLinks =driver.findElements(By.xpath("//a[contains(@href,'https')]"));
         for(WebElement eachLink: allLinks){
             System.out.println("eachLink.getText() = " + eachLink);
         }
    }

}
