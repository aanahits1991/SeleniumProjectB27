package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarInsuranceAppVerification {

    public static void main(String[] args) {


        //  1. Open Chrome browser

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2. Go to
        //  https://www.qa1.excelsoirinsurance.com/login

        driver.get("https://www.qa1.excelsoirinsurance.com/login");


        //  3. Verify URL contains
        //  Expected: "excelsoirinsurance"

        String expectedURL = "excelsoirinsurance"; // comes from requirement

        String actualURL = driver.getCurrentUrl(); // comes from browser

        if (actualURL.contains(actualURL)) {
            System.out.println("URL verification is passed");
        } else {
            System.out.println("URL verification is failed");
        }

        //   4. Verify title:
        //  Expected: "Login | Excelsoir Insurance"

        String expectedTitle = "Login | Excelsoir Insurance";

        String actualTitel = driver.getTitle();

        if (actualTitel.equals(expectedTitle)){
            System.out.println("Titel verification is passed");
        } else {
            System.out.println("Titel verification is failed");
        }


        driver.quit();
    }
}
