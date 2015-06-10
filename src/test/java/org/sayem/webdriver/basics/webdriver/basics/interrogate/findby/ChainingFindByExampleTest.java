package org.sayem.webdriver.basics.webdriver.basics.interrogate.findby;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.junit.Assert.assertEquals;


public class ChainingFindByExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage() {
        //driver = new FirefoxDriver();
        //driver.get("http://www.compendiumdev.co.uk" +
        //        "/selenium/find_by_playground.php");
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.quit();
    }

    @Test
    public void chainingWithFindElement() {

        WebElement element = driver.findElement(By.id("div1")).
                findElement(By.name("pName3")).
                findElement(By.tagName("a"));

        assertEquals("expected a different id",
                "a3",
                element.getAttribute("id"));
    }

    @Test
    public void chainingWithSupportClassByChained() {

        WebElement element;
        element = driver.findElement(
                new ByChained(
                        By.id("div1"),
                        By.name("pName9"),
                        By.tagName("a")));

        assertEquals("expected a different id",
                "a9",
                element.getAttribute("id"));
    }
}