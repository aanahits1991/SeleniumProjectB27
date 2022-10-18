package com.cydeo.tests.day5_testNG_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T1_RadioButton {
    public static void main(String[] args) {

        /*
        1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.

         */
//1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//2
        driver.get("https://practice.cydeo.com/radio_buttons");

//3
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();

        System.out.println(hockeyButton.isSelected());
//4

        if (hockeyButton.isSelected()) {
            System.out.println("Verification is selected");
        } else {
            System.out.println("Verification is not selected");
        }


        //Test all radio buttons if they are clickable






    }
}
