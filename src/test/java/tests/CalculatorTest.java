package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalculatorTest extends TestBase {
    @Before
    public void openPage() {
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    public void itShouldSumTwoNumbers() {
        enterFirstInput("1");
        enterSecondInput("2");
        sumNumbers();

        Assert.assertEquals("3", getResult());Assert.assertEquals("3", getResult());
    }

    @Test
    public void itShouldDeductTwoNumbers() {
        enterFirstInput("5");
        enterSecondInput("4");
        deductNumbers();

        Assert.assertEquals("1", getResult());
    }

    @Test
    public void itShouldResetCalculator() {
        enterFirstInput("5");
        enterSecondInput("4");
        deductNumbers();
        resetCalculator();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        enterFirstInput("10");
        enterSecondInput("8");
        sumNumbers();
        Assert.assertEquals("10+8 = 18", getLatestCalculation().getText());
        Assert.assertEquals(1, getLatestCalculations().size());
    }

    private WebElement getLatestCalculation() {
        return driver.findElement(By.cssSelector("ul.latest-results li"));
    }

    private List<WebElement> getLatestCalculations() {
        return driver.findElements(By.cssSelector("ul.latest-results li"));
    }

    private void sumNumbers() {
        driver.findElement(By.id("count")).click();
    }
    private void enterFirstInput(String textToInput) {
        driver.findElement(By.id("firstInput")).sendKeys(textToInput);
    }

    private void enterSecondInput(String textToInput) {
        driver.findElement(By.id("secondInput")).sendKeys(textToInput);
    }

    private String getResult() {
        return driver.findElement(By.id("result")).getText();
    }

    private void deductNumbers() {
        driver.findElement(By.id("deduct")).click();
    }

    private void resetCalculator() {
        driver.findElement(By.id("reset")).click();
    }
}
