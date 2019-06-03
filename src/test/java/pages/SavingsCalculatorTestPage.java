package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavingsCalculatorTestPage {

    WebDriver pageDriver;

    public SavingsCalculatorTestPage(WebDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void enterInvestment(String textToInput) {
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(textToInput);
    }

    public void enterEmail(String textToInput) {
        pageDriver.findElement(By.id("emailInput")).sendKeys(textToInput);
    }

    public void enterYears(String textToInput) {
        pageDriver.findElement(By.id("yearsInput")).sendKeys(textToInput);
    }

    public void buttonClick() {
        pageDriver.findElement(By.cssSelector("button.btn-success")).click();
    }

}
