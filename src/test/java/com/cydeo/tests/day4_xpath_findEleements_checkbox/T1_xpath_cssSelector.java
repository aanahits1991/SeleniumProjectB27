package com.cydeo.tests.day4_xpath_findEleements_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector {

    public static void main(String[] args) {

        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password

        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        // locator only (total of 6)
        // a. “Home” link
//locate using cssSelector with class attribute

        WebElement homeLink1 = driver.findElement(By.cssSelector(".nav-link"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));


        //locate using Xpath

        WebElement homeLink3 = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //
        // b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div.example>h2"));

        //WebElement forgotPassword3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPassword3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        WebElement forgotPassword4 = driver.findElement(By.xpath("//div[@class='example']/h2"));


        // c. “E-mail” text

        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));


        //d. E-mail input box
        WebElement inputBox = driver.findElement(By.xpath("//input[contains(@pattern,'[a-z0-9._')]"));

        //e. “Retrieve password” button

        WebElement retrivePasword = driver.findElement(By.cssSelector("button[id='form_submit']>i"));

        // f. “Powered by Cydeo text

        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.

        //isDisplayed() method return to boolean true/false

        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());

        System.out.println("forgotPassword3.isDisplayed() = " + forgotPassword3.isDisplayed());

        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());

        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());

        System.out.println("retrivePasword.isDisplayed() = " + retrivePasword.isDisplayed());

        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());

    }
}
