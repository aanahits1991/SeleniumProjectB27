package com.cydeo.tests.day11_upload_actions_javascriptexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {

    @Test
    public void guru99_upload_test(){
//        1. Go to  “https://demo.guru99.com/test/upload”

        //‪C:\Users\anahi\Downloads\some-file.txt

        Driver.getDriver().get("https://demo.guru99.com/test/upload");
//        2. Upload file into Choose File

        WebElement chooseFile =Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));

        chooseFile.sendKeys("C:\\Users\\anahi\\Downloads\\some-file.txt");
//        3. Click terms of servide check box

        WebElement termsOfService = Driver.getDriver().findElement(By.id("terms"));
        termsOfService.click();
//        4. Click Submit File button

        WebElement submitFile = Driver.getDriver().findElement(By.id("submitbutton"));
        submitFile.click();

//        5. Verify expected message appeared. Expected:
//“1 file
//        has been successfully uploaded.”


        WebElement resultMessage = Driver.getDriver().findElement(By.id("res"));

        String expectedResult= "1 file\nhas been successfully uploaded.";
        String actualResult = resultMessage.getText();
        BrowserUtils.sleep(30);
        Assert.assertEquals(actualResult,expectedResult);

    }
}
