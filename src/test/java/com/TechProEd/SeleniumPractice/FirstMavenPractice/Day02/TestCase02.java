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

public class TestCase02 {

    /*
        1. Go to ”https://www.thetrainline.com/”
        2. Select return button
        3. Check the return is selected
        4. Verify the returnDate input box is Enabled
        5. Check the one way is not selected
    */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase02() {
        driver.navigate().to("https://www.thetrainline.com/");

        WebElement rejectButton = driver.findElement(By.id("onetrust-reject-all-handler"));
        rejectButton.click();

        WebElement returnButton = driver.findElement(By.id("return"));
        returnButton.click();
        Assert.assertTrue(returnButton.isSelected());

        WebElement returnDate = driver.findElement(By.id("page.journeySearchForm.inbound.title"));
        Assert.assertTrue(returnDate.isEnabled());

        WebElement oneWayButton = driver.findElement(By.id("single"));
        Assert.assertFalse(oneWayButton.isSelected());

    }

    @After
    public void closeBrowserUp() {
        driver.quit();
    }

}
