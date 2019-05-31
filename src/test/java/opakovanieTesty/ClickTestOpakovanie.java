package opakovanieTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickTestOpakovanie {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
    }

    @Test
    public void itShouldInspectDeclension() {
        WebElement addClick = driver.findElement(By.id("clickMe"));
        for (int i = 0; i < 6; i++) {
            addClick.click();
            String actualNumberOfClicks = driver.findElement(By.id("clicks")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfClicks);

            //overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("p.description")).getText();

            if (i + 1 == 1) {
                Assert.assertEquals("klik", actualDescription);
            }
            if (i + 1 >= 2 && i + 1 <= 4) {
                Assert.assertEquals("kliky", actualDescription);
            }
            if (i + 1 >= 5) {
                Assert.assertEquals("klikov", actualDescription);
            }

            System.out.println("index i = " + i);
            System.out.println("pocet klikov = " + actualNumberOfClicks);
        }
    }

}
