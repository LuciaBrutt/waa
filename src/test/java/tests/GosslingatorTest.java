package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    String actualNumberOfRyans;

    @Test
    public void itShouldAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
        //objekt sa bude volat driver
        //1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
        //2. kliknut na tlacidlo pridat
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        // vypisem si do logu aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());


        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/gosslingator.php");

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME",driver.findElement(By.cssSelector(".ryan-title")).getText());

        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldAddTwoRyans() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
        //objekt sa bude volat driver
        //1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
        //2. kliknut na tlacidlo pridat

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));

        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();

        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov

        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldInspectText() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/gosslingator.php");
        //toto raz bude cyklus

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        //alt + J oznacenie kazdeho dalsieho vyskytu
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();

        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());

        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

}
