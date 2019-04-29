package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class registracia {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
        //objekt sa bude volat driver
        //1.otvorit stranku
        driver.get("http://localhost/registracia.php");
    }

    //@After
    public void tearDown() {
        driver.close();
        driver.quit();

    }

    @Test
    public void itShouldRegisterValidUser() {
        String email = "text@azet.sk";
        String meno = "Elena";
        String priezvisko = "Lenovska";
        String heslo = "123456";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);
//kliknut na tlacidlo robot
        driver.findElement(By.name("robot")).click();
        //klik na tlacidlo registrovat sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
//over, ze nie je pravda, ze lement je zobrazeny
        //Assert.assertFalse(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty() {

//kliknut na tlacidlo robot
        driver.findElement(By.name("robot")).click();
        //klik na tlacidlo registrovat sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
//over, ze nie je pravda, ze lement je zobrazeny
        //Assert.assertFalse(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

    }

}
