package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown_practices {

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
    public void SetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void dropDownTask4() {

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //. Select Illinois
        selectState.selectByVisibleText("Illinois");


        //4. Select Virginia
        selectState.selectByValue("VA");

        //   5. Select California
        selectState.selectByIndex(5);


        //  6. Verify final selected option is California.

        String actualFinalOption = selectState.getFirstSelectedOption().getText();
        String expectedFinalOption = "California";

        Assert.assertEquals(actualFinalOption, expectedFinalOption, "Final selected option verification is failed");

        //finding index number from options

        int index = 0;
        for (WebElement eachState : selectState.getOptions()) {
            index++;
            if (eachState.getText().equals("California")) {
                System.out.println(index);
            }


        }


    }


    @Test
    public void multipleSelectDropDown() throws InterruptedException {

        Select selectLanguage = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        Thread.sleep(300);
        //  3. Select all the options from multiple select dropdown.
        //  4. Print out all selected values.
        for (WebElement eachLanguage : selectLanguage.getOptions()) {
            eachLanguage.click();
            System.out.println("eachLanguage.getText() = " + eachLanguage.getText());  //  4. Print out all selected values.
        }




        // 5. Deselect all values.

        selectLanguage.deselectAll();


    }
}
