package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Before
    public void openPage() {

        //1.otvorit stranku
        driver.get(BASE_URL + "/registracia.php");
    }

    @Test
    public void itShouldRegisterValidUser() {
        //Fairy fairy = Fairy.create();
        //Person person = fairy.person();
        String email = "brano@mojsej.sk";
        String meno = "branislav";
        String priezvisko = "mojsej";
        String heslo = "123456";

        //zadam zakladne udaje

        //driver.findElement(By.name("email")).sendKeys(person.getEmail());
        //driver.findElement(By.name("name")).sendKeys(person.getFirstName());
        //driver.findElement(By.name("surname")).sendKeys(person.getLastName());
        //driver.findElement(By.name("password")).sendKeys(person.getPassword());
        //driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterData(email, meno, priezvisko, heslo);

        //kliknut na checkbox som robot
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
