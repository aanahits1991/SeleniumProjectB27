package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) {

       /*
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
        Expected: Gmail
        5- Go back to Google by using the .back();
        6- Verify title equals:
        Expected: Google
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement name = driver.findElement(By.className("gb_d"));

        name.click();

        String expectedTitleResult = "Gmail";
        String actualTitleResult = driver.getTitle();

        if (actualTitleResult.contains(expectedTitleResult)) {
            System.out.println("Verification is passed");
        } else {
            System.out.println("Failed");
        }

        driver.navigate().back();


        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }

        driver.quit();
    }
}
