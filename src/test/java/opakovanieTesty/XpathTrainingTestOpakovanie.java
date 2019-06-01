package opakovanieTesty;

import base.TestBase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class XpathTrainingTestOpakovanie extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }

    @Test
    public void itShouldDisplayAction() {
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
                actualMessage
        );
    }

    @Test
    public void itShouldDisplayEnteredMessage() {
        String message = "vonku prsi";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        //stlacim tlacidlo Hit ME!
        driver.findElement(By.id("hitme")).click();

        //precitam hodnotu zo stranky a ulozim ju do premennej
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();

        Assert.assertEquals(
                "you entered " + message,
                actualMessage
        );
    }

    @Test
    public void itShouldSelectAllOptions() {
        String[] selectedOptions = {"Moznost 1", "Moznost 2", "Moznost 3", "Moznost 4", "Moznost 5", "Moznost 6"};

        //najdem element select
        WebElement optionSelect = driver.findElement(By.xpath("//select[1]"));
        for (String option : selectedOptions) {
            //vyberiem moznost
            new Select(optionSelect).selectByVisibleText(option);
            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
            String expectedMessage = "you have chosen " + option.toLowerCase();
           // String expectedMessageByFormat = String.format("I choose you %s !", pokemon);
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

}

