package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;

public class CalculatorTest extends TestBase {
    @Before
    public void openPage() {
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    public void itShouldSumTwoNumbers() {
        driver.findElement(By.id("firstInput")).sendKeys("1");
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();

        Assert.assertEquals(
                "3",
                driver.findElement(By.id("result")).getText()
        );
    }

    @Test
    public void itShouldDeductTwoNumbers() {
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).sendKeys("4");
        driver.findElement(By.id("deduct")).click();

        Assert.assertEquals(
                "1",
                driver.findElement(By.id("result")).getText()
        );
    }

    @Test
    public void itShouldResetCalculator() {
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).sendKeys("4");
        driver.findElement(By.id("deduct")).click();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        driver.findElement(By.id("firstInput")).sendKeys("10");
        driver.findElement(By.id("secondInput")).sendKeys("8");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals(
                "10 + 8 = 18",
                driver.findElement(By.cssSelector("ul.latest-results li")).getText()
        );
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul.latest-results li")));
    }
}
