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
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class TestCase04 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void testCase04() throws InterruptedException {
        driver.navigate().to("https://facebook.com");

        WebElement cookiesButton = driver.findElement(By.xpath("//button[text()='Only allow essential cookies']"));
        cookiesButton.click();
        WebElement createButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createButton.click();
                //Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ali");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Cin");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("alicin@gmail.com");
        WebElement email2 = driver.findElement(By.name("reg_email_confirmation__"));
        email2.sendKeys("alicin@gmail.com");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("123456");

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("1");

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("8");

        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1985");

        WebElement sexMale = driver.findElement(By.xpath("//input[@value='2']"));
        sexMale.click();

        WebElement sexFemale = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement sexCustom = driver.findElement(By.xpath("//input[@value='-1']"));

        Assert.assertTrue(sexMale.isSelected());
        Assert.assertFalse(sexFemale.isSelected());
        Assert.assertFalse(sexCustom.isSelected());

        }

    @After
    public void closeBrowserUp() {
        driver.quit();
    }
}
