package opakovanieTesty;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
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

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String title = "Title " + timestamp.getTime();
        String author = "Ignac";
        String message = "toto je velmi dlhy a zmysluplny odkaz";

        Integer numberOfNotes = Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText());
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(author);
        driver.findElement(By.name("message")).sendKeys(message);
        driver.findElement(By.cssSelector("button.btn-block")).click();

        WebElement listItem = driver.findElement(By.cssSelector("ul.list-of-sins > li:last-child"));
        //overim ze sa pridal novy zaznam do zoznamu
        Assert.assertTrue(listItem.getText().contains(title));
        //overenie linku
        Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());

        Assert.assertEquals(
                Integer.valueOf(numberOfNotes + 1),
                Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText())
        );
        listItem.click();
        //overim detail zaznamu
        Thread.sleep(1000);
        WebElement detail = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
    }

}

