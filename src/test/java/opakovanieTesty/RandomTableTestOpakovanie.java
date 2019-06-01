package opakovanieTesty;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTestOpakovanie {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/tabulka.php");
    }

    @Test
    public void itShouldPrintLastRow() {
        //2.najdem a vypisem posledny riadok
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());

        //3.najdem a vypisem meno z predposledneho riadku
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());

    }

    @Test
    public void itShouldContainDataForEachRow() {
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainNameForEachRow() {
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            tableRow.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());

        }
    }

    @After
    public void tearDown(){
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }
}
