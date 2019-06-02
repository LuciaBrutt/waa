package opakovanieTesty;

import base.TestBase;
import opakovaniePages.GosslingatorPageOpakovanie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GosslingatorTestOpakovanie extends TestBase {

    private GosslingatorPageOpakovanie gossPage;
    private String actualNumberOfRyans;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
        gossPage = new GosslingatorPageOpakovanie(driver);
    }

    @Test
    public void itShouldAddOneRyan() {
        gossPage.addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());
        // vypisem si do console aktualny pocet z pocitadla ryanov
        Assert.assertEquals("ryan", gossPage.getCounterDescription());
    }

    @Test
    public void itShouldTwoRyans() {
        //2.kliknut na tlacidlo pridat
        GosslingatorPageOpakovanie gossPage = new GosslingatorPageOpakovanie(driver);
        gossPage.addRyan();
        gossPage.addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("2", gossPage.getRyanCounterNumber());
        Assert.assertEquals("ryans", gossPage.getCounterDescription());
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        GosslingatorPageOpakovanie gossPage = new GosslingatorPageOpakovanie(driver);
        //toto raz bude for cyklus
        for (int i = 0; i < 50; i++) {
            gossPage.addRyan();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), gossPage.getRyanCounterNumber());

            //overit sklonovanie pomocou podmienky
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", gossPage.getCounterDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", gossPage.getCounterDescription());
            }

            //overim pocet obrazkov ryana
            Assert.assertEquals(i + 1, gossPage.getNumberOfRyanImages());

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + gossPage.getRyanCounterNumber());
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
        GosslingatorPageOpakovanie gossPage = new GosslingatorPageOpakovanie(driver);
        int clicksLimit = 30;
        int clicks = 0;
        while (!gossPage.getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            gossPage.addRyan();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        GosslingatorPageOpakovanie gossPage = new GosslingatorPageOpakovanie(driver);
        Assert.assertEquals(
                0,
                gossPage.getNumberOfRyanImages());
    }

}
