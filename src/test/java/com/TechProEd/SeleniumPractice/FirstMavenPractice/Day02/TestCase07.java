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

import java.time.Duration;

public class TestCase07 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.de");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void titleTest() {

        String title = driver.getTitle();
        Assert.assertEquals("Google", title);

    }

    @Test
    public void imageTest() {

        WebElement imageText = driver.findElement(By.linkText("Bilder"));
        imageText.isDisplayed();

    }

    @Test
    public void gmailLinkTest(){

        WebElement gmailLinkText = driver.findElement(By.linkText("Gmail"));
        gmailLinkText.isDisplayed();

    }

    @After
    public void tearDown() {

        driver.quit();

    }



}
