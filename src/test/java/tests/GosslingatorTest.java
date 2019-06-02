package tests;

import base.TestBase;
import pages.GosslingatorPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GosslingatorTest extends TestBase {
    private GosslingatorPage gossPage;


    private String actualNumberOfRyans;


    @Before
    public void openPage() {

        //1.otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
        gossPage = new GosslingatorPage(driver);
    }


    @Test
    public void itShouldAddOneRyan() {

        gossPage.addRyan();

        //2. kliknut na tlacidlo pridat
        //driver.findElement(By.id("addRyan")).click();
        //driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());

        // vypisem si do logu aktualny pocet z pocitadla ryanov
        Assert.assertEquals("ryan", gossPage.getCounterDescription());

    }

    @Test
    public void itShouldDisplayTitle() {

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

    }


    @Test
    public void itShouldAddTwoRyans() {

        //2. kliknut na tlacidlo pridat
        gossPage.addRyan();
        gossPage.addRyan();
        gossPage.addRyan();

        //addRyanButton.click();
        //addRyanButton.click();
        //addRyanButton.click();

        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov

        Assert.assertEquals("2", gossPage.getRyanCounterNumber());
        Assert.assertEquals("ryans", gossPage.getCounterDescription());

    }

    @Test

    public void itShouldDisplayWarningMessage() {
        //toto raz bude cyklus

        for (int i = 0; i < 50; i++) {
            gossPage.addRyan();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohla porovnat
            Assert.assertEquals(String.valueOf(i + 1), gossPage.getRyanCounterNumber());

            //overit sklonovanie pomocou podmienky
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", gossPage.getCounterDescription());
            }

            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", gossPage.getCounterDescription());
            }

            // overim pocet obrazkov ryana

            Assert.assertEquals(i + 1, gossPage.getNumberOfRyanImages());

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + gossPage.getRyanCounterNumber());
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
        String actualNumberOfRyans = gossPage.getRyanCounterNumber();
        //while cyklus sa vykona vzdy ak je podmienka true

        int clicksLimit = 30;
        int clicks = 0;

        while (!gossPage.getRyanCounterNumber().equals("50") || clicks < clicksLimit) {
            //addRyanButton.click();
            gossPage.addRyan();
            clicks++;
            //System.out.println("ahoj");
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(0,
                gossPage.getNumberOfRyanImages()
        );
    }

}
