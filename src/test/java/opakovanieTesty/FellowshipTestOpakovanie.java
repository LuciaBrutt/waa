package opakovanieTesty;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FellowshipTestOpakovanie extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/fellowship.php");
    }

    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));

        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainSpecifiedFellows() {
        //najdem si zoznam elementov (kachliciek)
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        //predpripravim si zoznam stringov do ktoreho si ulozim jednotlive mena
        List<String> fellowNames = new ArrayList<String>();

        //prejdem zoznam elementov, kachliciek
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            //v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        //over ze list obsahuje Gandalf-a, a Aragorn-a
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
    }

    @Test
    public void itShouldDisplayMessageComplete() {
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            driver.findElement(By.xpath("//h1[contains(text(),'" + fellowToSelect + "')]")).click();
        }

        Assert.assertEquals("Complete", driver.findElement(By.cssSelector("div.points-left h3")).getText());
    }

    @Test
    public void itShouldDisplayPointsForEachFellow() {
        //najdem si zoznam vsetkych spolocnikov z ringu a ulozim ich do listu webelementov
        List<WebElement> displayedFellows = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        for (WebElement displayedFellow : displayedFellows) {

            // /pre kazdeho najdem element v ktorom je ulozeny pocet bodov a zistim jeho text
            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();

            //overim ze hodnota actual points nie je prazdna
            Assert.assertFalse(actualPoints.isEmpty());
        }
    }
}
