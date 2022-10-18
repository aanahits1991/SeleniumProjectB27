package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_StateDropDown {

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

   // 1. Open Chrome browser

    WebDriver driver;

@BeforeMethod
    public void setUpMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@Test
    public void SelectingStates(){
    driver.get("http://practice.cybertekschool.com/dropdown");


    /*
     3. Select Illinois
    4. Select Virginia
    5. Select California
    6. Verify final selected option is California.
    Use all Select options. (visible text, value, index)
     */

    Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        dropdown.selectByValue("IL");
        dropdown.selectByVisibleText("Virginia");
        dropdown.selectByIndex(5);

        String actualOption = dropdown.getFirstSelectedOption().getText();
        String expectedOption ="California";
        Assert.assertEquals(actualOption,expectedOption);
    }


@AfterMethod
    public void tearDownMethod(){
    driver.quit();
}


}










