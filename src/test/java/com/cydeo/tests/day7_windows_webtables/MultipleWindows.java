package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindows {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Set up browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void multiple_windows_test() {

//        3. Assert: Title is “Windows”

        Assert.assertEquals(driver.getTitle(), "Windows");


//        4. Click to: “Click Here” link

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

//        5. Click to: “CYDEO” link

        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        cydeoLink.click();

//        6. Switch to Cydeo page.

        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows){
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());

            if(driver.getTitle().equals("Cydeo")){
                break;
            }
        }



//        7. Assert: Title is “Cydeo”

       // Assert.assertEquals(driver.getTitle(),"Cydeo");
        BrowserUtils.verifyTitle(driver,"Cydeo");
    }

   @AfterMethod
   public void tearDown() {
        driver.close();
   }
}

