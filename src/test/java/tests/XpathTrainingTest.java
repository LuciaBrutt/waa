package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTest {
    WebDriver driver;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
        //objekt sa bude volat driver
        //1.otvorit stranku
        driver.get("http://localhost/xpathtrainingcenter.php");
    }

    @After
    public void tearDown () {
        driver.close();
        driver.quit();

        System.out.println("s panom bohom idem od vas");
    }

    @Test
    public void itShouldDisplayAction() {

        //2. kliknut na tlacidlo pridat
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();

        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();

        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
        actualMessage
        );
}

    @Test
    public void itShouldDisplayEnteredMessage() {

        String message = "vonku neprsi";

        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.id("hitme")).click();

        //vytiahnem /precitam hodnotu zo stranky a ulozim ju do premennej
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals(
                "you entered " + message, actualMessage);

    }

}