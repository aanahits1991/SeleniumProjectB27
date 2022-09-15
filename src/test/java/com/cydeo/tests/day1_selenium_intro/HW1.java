package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.navigate().to("https://practice.cydeo.com");

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "cydeo";

        Thread.sleep(3000);

        if (currentURL.contains(expectedURL)) {
            System.out.println("URL is passed");
        } else {
            System.out.println("URL is failed");
        }


        String getTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if (getTitle.equals(expectedTitle)) {
            System.out.println("Title is passed");
        } else {
            System.out.println("Title is Failed");
        }


        driver.quit();
    }
}
