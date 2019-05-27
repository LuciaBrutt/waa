package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FellowshipPage;
import pages.NotePage;

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest extends TestBase {

    private FellowshipPage fellowshipPage;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/fellowship.php");
        fellowshipPage = new FellowshipPage(driver);
    }

    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellowElements = fellowshipPage.getFellowElements();
        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());
        }

    }



    @Test
    public void itShouldContainSpecifiedFellows() {
        //najdem zoznam elementov kachliciek
        List<WebElement> fellowElements = fellowshipPage.getFellowElements();
        //prepripravim si zoznam stringov do ktoreho si ulozim jednotlive mena
        List<String> fellowNames = new ArrayList<String>();
        //prejdem zozznam elementov, kachliciek
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            //v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());

        }
        System.out.println(fellowNames);
        //over ze list obsahuje Gandalf-a a Aragorn-a
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
            fellowshipPage.selectFellow(fellowToSelect);
        }
        Assert.assertEquals( "Complete", driver.findElement(By.cssSelector("div.points-left h3")).getText());
    }



    @Test
    public void itShouldDisplayPointsForEachFellows () {
        //najdem si zoznam vs. spolocnikov z ringu a ulozim ich do listu webelementov
        List<WebElement> displayedFellows = fellowshipPage.getFellowElements();
        for (WebElement displayedFellow : displayedFellows) {
            //pre kazdeho najdem elemeent v kt je ulozeny pocet bodov a zistim jeho text
            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();
           // System.out.println(displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText().isEmpty());
            //overim ze hodnota actual points nie je prazdna
            Assert.assertFalse (actualPoints.isEmpty());
        }
    }


}


