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
        driver.findElement(By.id("addRyan")).click();
        //3.overit pocitanie ryanov
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        Assert.assertEquals("1", actualNumberOfRyans);
        // vypisem si do console aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
    }

    @Test
    public void itShouldTwoRyans() {
        //2.kliknut na tlacidlo pridat
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        addRyanBtn.click();
        addRyanBtn.click();
        //3.overit pocitanie ryanov
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        //toto raz bude for cyklus
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

            //overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }

            //overim pocet obrazkov ryana
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
            Assert.assertEquals(i + 1, numberOfRyanImages);

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);
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
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        //while cyklus sa vykona vzdy ak je podmienka "true"
        int clicksLimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(
                0,
                driver.findElements(By.cssSelector("img")).size()
        );
    }

}
