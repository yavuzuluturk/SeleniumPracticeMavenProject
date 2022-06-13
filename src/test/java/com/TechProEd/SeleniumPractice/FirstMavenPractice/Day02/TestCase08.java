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

public class TestCase08 {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void checkBox1() throws InterruptedException {

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        //Thread.sleep(5000);
        if(!checkBox1.isSelected()){

            checkBox1.click();
        }
        //Assert.assertTrue(checkBox1.isSelected());

    }

    @Test
    public void checkBox2(){

        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
        //Assert.assertTrue(checkBox2.isSelected());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
