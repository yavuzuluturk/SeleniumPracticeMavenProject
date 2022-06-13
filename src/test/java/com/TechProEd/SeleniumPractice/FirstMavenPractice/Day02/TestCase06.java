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

public class TestCase06 {

    /*
    1. Go to “https://www.saucedemo.com/”
    2. Enter “standard_user” userName input box
    3. Enter “secret_sauce” password input box
    4. Click Login button
    5. Get the first Item name
    6. Click Add to Cart
    7. Click Shopping Cart
    8. Verify that is you add the item successfully.
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
        driver.navigate().to("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        WebElement firstItem = driver.findElement(By.id("item_4_title_link"));
        String firstItemText = firstItem.getText();
        System.out.println(firstItemText);

        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();

        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();

        WebElement addedItem = driver.findElement(By.className("inventory_item_name"));
        String addedItemText = addedItem.getText();
        System.out.println(addedItemText);

        Assert.assertEquals(firstItemText,addedItemText);
    }

    @After
    public void closeBrowserUp() {
        //driver.quit();
    }

}
