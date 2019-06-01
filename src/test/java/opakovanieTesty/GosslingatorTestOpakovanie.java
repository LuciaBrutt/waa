package opakovanieTesty;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTestOpakovanie extends TestBase {

    private String actualNumberOfRyans;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
    }

    @Test
    public void itShouldAddOneRyan() {
        addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("1", getRyanCounterNumber());
        // vypisem si do console aktualny pocet z pocitadla ryanov
        Assert.assertEquals("ryan", getCounterDescription());
    }

    @Test
    public void itShouldTwoRyans() {
        //2.kliknut na tlacidlo pridat
        addRyan();
        addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("2", getRyanCounterNumber());
        Assert.assertEquals("ryans", getCounterDescription());
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        //toto raz bude for cyklus
        for (int i = 0; i < 50; i++) {
            addRyan();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), getRyanCounterNumber());

            //overit sklonovanie pomocou podmienky
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", getCounterDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", getCounterDescription());
            }

            //overim pocet obrazkov ryana
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
            Assert.assertEquals(i + 1, numberOfRyanImages);

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + getRyanCounterNumber());
        }

        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        //while cyklus sa vykona vzdy ak je podmienka "true"
        int clicksLimit = 30;
        int clicks = 0;
        while (!getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            addRyan();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(
                0,
                getNumberOfRyanImages());
    }

    private void addRyan() {
        WebElement ryanButton = driver.findElement(By.id("addRyan"));
        ryanButton.click();
    }

    private String getRyanCounterNumber() {
        return driver.findElement(By.id("ryanCounter")).getText();
    }

    private String getCounterDescription() {
        return driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    private int getNumberOfRyanImages() {
        return driver.findElements(By.cssSelector("img")).size();
    }

}
