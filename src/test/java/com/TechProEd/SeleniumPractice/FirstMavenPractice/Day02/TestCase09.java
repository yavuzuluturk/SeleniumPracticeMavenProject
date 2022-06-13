package com.TechProEd.SeleniumPractice.FirstMavenPractice.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase09 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void testCase09() {
        driver.navigate().to("https://facebook.com");

        WebElement cookiesButton = driver.findElement(By.xpath("//button[text()='Only allow essential cookies']"));
        cookiesButton.click();

        WebElement createButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createButton.click();

        WebElement sexMale = driver.findElement(By.xpath("//input[@value='2']"));
        sexMale.click();

    }

    @After
    public void tearDown() {

        driver.quit();

    }

}
