package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;
import pages.CalculatorPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalculatorTest extends TestBase {
    private CalculatorPage calculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/kalkulacka.php");
        calculatorPage = new CalculatorPage(driver);
    }

    @Test
    public void itShouldSumTwoNumbers() {
        calculatorPage.enterFirstInput("1");
        calculatorPage.enterSecondInput("2");
        calculatorPage.sumNumbers();

        Assert.assertEquals("3", calculatorPage.getResult());
    }

    @Test
    public void itShouldDeductTwoNumbers() {
        calculatorPage.enterFirstInput("5");
        calculatorPage.enterSecondInput("4");
        calculatorPage.deductNumbers();

        Assert.assertEquals("1", calculatorPage.getResult());
    }

    @Test
    public void itShouldResetCalculator() {
        calculatorPage.enterFirstInput("5");
        calculatorPage.enterSecondInput("4");
        calculatorPage.deductNumbers();
        calculatorPage.resetCalculator();
        Assert.assertTrue(calculatorPage.getFirstInput().getAttribute("value").isEmpty());
        Assert.assertTrue(calculatorPage.getSecondInput().getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        calculatorPage.enterFirstInput("10");
        calculatorPage.enterSecondInput("8");
        calculatorPage.sumNumbers();
        Assert.assertEquals("10+8 = 18", calculatorPage.getLatestCalculation().getText());
        Assert.assertEquals(1, calculatorPage.getLatestCalculations().size());
    }

    //@Test
    //public void chceckPlaceHolder(){
        //System.out.println(driver.findElement(By.id("firstInput")).getAttribute("placeholder");
        //System.out.println(driver.findElement(By.id("firstInput")).getAttribute("class");
        //System.out.println(driver.findElement(By.id("count")).getCssValue("background-color");
    //}
}
