package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import models.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.NotePage;


import java.sql.Timestamp;

//import java.security.Timestamp;

public class NoteTest extends TestBase {
    private NotePage notePage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
        notePage = new NotePage(driver);
    }

    @Test
    public void itShouldAddNote() throws InterruptedException {
        //vytvorim si casovu peciatku pre unikatnost title

        //Fairy fairy = Fairy.create();
        //Person fakePerson = fairy.person();

        //ulozim si hodnoty do premennych
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //String title = generateUniqueTitle();
        //String author = "Ignac";
        //String message = "toto je velmi dlhy a zmysluplny odkaz";
        //Note noteToAdd = new Note(title, author, message);

        Note noteToAdd = new Note(
                generateUniqueTitle(),
                "Anton",
                "toto je velmi dlhy a zmysluplny odkaz"
        );

        notePage.enterNoteData(noteToAdd);
        notePage.submitNewNote();
        notePage.checkNoteInList(noteToAdd.getTitle());
        notePage.openLastNote();
        notePage.checkNoteDetail(noteToAdd);
    }

    // WebElement listItem = getLastNoteFromList();
    //overim ze sa pridal novy zaznam do zoznamu
    //Assert.assertTrue(listItem.getText().contains(title));
    //overenie linku
    // Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());
    // Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());

    // Assert.assertEquals(
    // Integer.valueOf(numberOfNotes + 1),
    // Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText())
    //  );
    // listItem.click();
    //overim detail zaznamu
    // Thread.sleep(1000);
    // checkNoteDetail (title, author, message);
    //}

    private String generateUniqueTitle() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "Title " + timestamp.getTime();
    }
}