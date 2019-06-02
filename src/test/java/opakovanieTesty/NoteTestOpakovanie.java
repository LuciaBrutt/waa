package opakovanieTesty;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import opakovaniePages.NotePageOpakovanie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

import static junit.framework.TestCase.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class NoteTestOpakovanie extends TestBase {
    private NotePageOpakovanie notePage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
        notePage = new NotePageOpakovanie(driver);
    }

    @Test
    public void itShouldAddNewNote() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String title = "Title " + timestamp.getTime();

        driver.findElement(name("title")).sendKeys(title);
        driver.findElement(name("author")).sendKeys(person.getFirstName());
        driver.findElement(name("message")).sendKeys("Ahoj ako sa mas");

        driver.findElement(cssSelector("button.btn-block")).click();

        WebElement lastNoteAdded = driver.findElement(By.xpath("//ul[contains(@class,'list-of-sins')]/li[last()]"));
        assertTrue(lastNoteAdded.getText().contains(title));
    }

    @Test
    public void itShouldAddNewNoteWithTags() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String title = "Title " + timestamp.getTime();

        driver.findElement(name("title")).sendKeys(title);
        driver.findElement(name("author")).sendKeys(person.getFirstName());
        driver.findElement(name("message")).sendKeys("Ahoj ako sa mas");
        driver.findElement(By.xpath("//input[@value='sport']")).click();
        driver.findElement(cssSelector("button.btn-block")).click();

        WebElement lastNoteAdded = driver.findElement(By.xpath("//ul[contains(@class,'list-of-sins')]/li[last()]"));
        assertTrue(lastNoteAdded.getText().contains(title));
    }

    @Test
    public void itShouldAddNote() throws InterruptedException {
        //vytvorim si casovu peciatku pre unikatnost title
        Fairy fairy = Fairy.create();
        Person fakePerson = fairy.person();
        //ulozim si hodnoty do premennych
        String title = generateUniqueTitle();
        String author = fakePerson.getFirstName() + " " + fakePerson.getLastName();
        String message = "toto je velmi dlhy a zmysluplny odkaz";

        notePage.enterNoteData(title, author, message);
        notePage.submitNewNote();
        notePage.checkNoteInList(title);
        notePage.getLastNoteFromList().click();
        //overim detail zaznamu
        Thread.sleep(1000);
        notePage.checkNoteDetail(title, author, message);
    }

    private String generateUniqueTitle() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "Title " + timestamp.getTime();
    }

}

