package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GosslingatorTest {

    WebDriver driver;

    String actualNumberOfRyans;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
        //objekt sa bude volat driver
        //1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();

    }


    @Test
    public void itShouldAddOneRyan() {

        //2. kliknut na tlacidlo pridat
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        // vypisem si do logu aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());


        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

    }

    @Test
    public void itShouldDisplayTitle() {

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

    }


    @Test
    public void itShouldAddTwoRyans() {

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

    }

    @Test

    public void itShouldDisplayWarningMessage() {

        //toto raz bude cyklus

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));

        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohla porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

            //overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }

            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);
        }
        //alt + J oznacenie kazdeho dalsieho vyskytu


        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());

    }

    @Test

    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        //while cyklus sa vykona vzdy ak je podmienka true

        int clicksLimit = 30;
        int clicks = 0;

        while (!actualNumberOfRyans.equals("50") || clicks < clicksLimit) {
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;


            //System.out.println("ahoj");
        }
    }
}
