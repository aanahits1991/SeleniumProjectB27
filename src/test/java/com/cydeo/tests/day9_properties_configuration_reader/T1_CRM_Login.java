package com.cydeo.tests.day9_properties_configuration_reader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_CRM_Login extends TestBase {

    @Test
    public void crm_login_test() {

//        2. Go to : http://login1.nextbasecrm.com/

        driver.get("http://login1.nextbasecrm.com/");

//        3. Enter valid username  // hr2@cydeo.com
        WebElement validUsernameInputBtn = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        validUsernameInputBtn.sendKeys("hr2@cydeo.com");

//        4. Enter valid password // UserUser
        WebElement validPasswordInputBtn = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        validPasswordInputBtn.sendKeys("UserUser");

//        5. Click to Log In button
        WebElement loginBut = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBut.click();

//        6. Verify title is as expected:
//        Expected: Portal
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Portal");
    }


    @Test
    public void crm_login_test2(){

        driver.get("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);
        BrowserUtils.verifyTitle(driver, "Portal");


    }

    @Test
    public void crm_login_test3(){
        driver.get("http://login1.nextbasecrm.com/");

        CRM_Utilities.login_crm(driver,"hr3@cydeo.com","UserUser");

        BrowserUtils.sleep(2);

        // verification of title is failing sometimes; it is a bug
        BrowserUtils.verifyTitle(driver,"Portal");

    }
}
