package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_2_homework {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
//2. Go to https://www.openxcell.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");

    }



//            3. Print out all of the texts of the links on the page

    @Test
    public void textOfLinks(){

        List<WebElement> textAllLinks = driver.findElements(By.tagName("a"));

        for (WebElement eachText: textAllLinks){
            System.out.println(eachText.getText());
        }

    }

}
