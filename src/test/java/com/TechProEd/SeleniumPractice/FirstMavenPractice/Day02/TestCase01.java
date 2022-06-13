package com.TechProEd.SeleniumPractice.FirstMavenPractice.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase01 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase01() {
        driver.navigate().to("http://zero.webappsecurity.com/");
        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();

        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("username");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
        driver.navigate().back();

        WebElement onlineBankingMenu = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBankingMenu.click();

        //WebElement payBillsMenu = driver.findElement(By.xpath("//div/h4/span[@id='pay_bills_link']"));
        WebElement payBillsMenu = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
        payBillsMenu.click();

        WebElement inputAmount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        inputAmount.sendKeys("1000");

        WebElement inputDate = driver.findElement(By.xpath("//input[@name='date']"));
        inputDate.sendKeys("2022-06-02");

        WebElement payButton = driver.findElement(By.id("pay_saved_payees"));
        payButton.click();

        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = driver.findElement(By.id("alert_content")).getText();

        Assert.assertEquals(expectedMessage,actualMessage);

     }

    @After
    public void closeBrowserUp() {
       driver.quit();
    }

}
