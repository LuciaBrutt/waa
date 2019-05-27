package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class XpathTrainingTest extends TestBase {

    @Before
    public void openPage (){

        //1.otvorit stranku
        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }

    @Test
    public void itShouldDisplayAction() {

        //2. kliknut na tlacidlo pridat
        String buttonText = "One more button";
        clickOnButton(buttonText);

        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
        getActualMessage()
        );
}

    private String getActualMessage() {
        return driver.findElement(By.cssSelector("div.output h2 span")).getText();
    }

    private void clickOnButton(String buttonText) {
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
    }

    @Test
    public void itShouldDisplayEnteredMessage() {

        String message = "vonku neprsi";

        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.id("hitme")).click();

        //vytiahnem /precitam hodnotu zo stranky a ulozim ju do premennej
        Assert.assertEquals(
                "you entered " + message, getActualMessage());

    }

}