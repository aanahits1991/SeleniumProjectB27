package com.cydeo.tests.day9_properties_configuration_reader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homeworkConfigurationReader extends TestBase {

//    Do task 1 with using ConfigurationReader class:
//    TC #1: Login scenario


//1. Create new test and make set ups

    @Test
    public void Login() {

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get(ConfigurationReader.getProperty("env"));
        //            3. Enter valid username
        WebElement validUserNameInputBtn = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        validUserNameInputBtn.sendKeys(ConfigurationReader.getProperty("username"));
        //4. Enter valid password
        WebElement validPasswordInputBtn = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        validPasswordInputBtn.sendKeys(ConfigurationReader.getProperty("password"));
        //5. Click to Log In button
        WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        LoginBtn.click();
        //6. Verify title is as expected:
        //    Expected: Portal
        String actualTitle = driver.getTitle();
        String expectedTitle = ConfigurationReader.getProperty("search.keyword");
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
