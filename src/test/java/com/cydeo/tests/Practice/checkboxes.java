package com.cydeo.tests.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class checkboxes {

    public static void main(String[] args) {

        /*
1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/checkboxes");


       // 2. Confirm checkbox #1 is NOT selected by default

        WebElement checkbox1Btn = driver.findElement(By.xpath("//input[@id='box1']"));
        System.out.println("checkbox1Btn.isSelected() = false " + checkbox1Btn.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.

        WebElement checkbox2Btn = driver.findElement(By.xpath("//input[@id='box2']"));
        System.out.println("checkbox2Btn.isSelected() = " + checkbox2Btn.isSelected());

        //4. Click checkbox #1 to select it.
        checkbox1Btn.click();

        //Click checkbox #2 to deselect it.
        checkbox2Btn.click();

        //6. Confirm checkbox #1 is SELECTED.

        System.out.println("checkbox1Btn.isSelected() = " + checkbox1Btn.isSelected());

        System.out.println("checkbox2Btn.isSelected() = " + checkbox2Btn.isSelected());
    }
}
