package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static junit.framework.TestCase.assertTrue;

public class SavingsCalculatorTest extends TestBase{

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
    }

    @Test
    public void itShouldInspectIfApplyIsEnabled (){

        String selectedFond = "Tom & Jerry corp";
        WebElement fondSelect = driver.findElement(By.id("fundSelect"));
        new Select(fondSelect).selectByVisibleText(selectedFond);

        enterInvestment("1000");
        enterYears("5");
        enterEmail("test@mail.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isEnabled());
    }

    @Test
    public void itShouldInspectThatAmountsAreNotEmpty () {

        String selectedFond = "Tom & Jerry corp";
        WebElement fondSelect = driver.findElement(By.id("fundSelect"));
        new Select(fondSelect).selectByVisibleText(selectedFond);

        enterInvestment("1000");
        enterYears("5");
        enterEmail("test@mail.sk");


        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[1]/p")).getText());
        System.out.println(container.findElement(By.xpath("./div[2]/p")).getText());

        Assert.assertFalse(container.findElement(By.xpath("./div[1]/p")).getText().isEmpty());
        Assert.assertFalse(container.findElement(By.xpath("./div[2]/p")).getText().isEmpty());
    }

    @Test
    public void itShouldInspectThatRiskIsNotEmpty () {

        String selectedFond = "Tom & Jerry corp";
        WebElement fondSelect = driver.findElement(By.id("fundSelect"));
        new Select(fondSelect).selectByVisibleText(selectedFond);

        enterInvestment("1000");
        enterYears("5");
        enterEmail("test@mail.sk");


        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[3]/p")).getText());

        Assert.assertFalse(container.findElement(By.xpath("./div[3]/p")).getText().isEmpty());
    }

    @Test
    public void itShouldDisplayNewRecord () {

        String selectedFond = "Tom & Jerry corp";
        WebElement fondSelect = driver.findElement(By.id("fundSelect"));
        new Select(fondSelect).selectByVisibleText(selectedFond);

        enterInvestment("1000");
        enterYears("5");
        enterEmail("test@mail.sk");

        buttonClick();

        WebElement lastNoteAdded = driver.findElement(By.xpath("//div[contains(@class,'saving-detail')]"));
        assertTrue(lastNoteAdded.getText().contains(selectedFond));
    }

    private void enterInvestment(String textToInput) {
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(textToInput);
    }

    private void enterEmail(String textToInput) {
        driver.findElement(By.id("emailInput")).sendKeys(textToInput);
    }

    private void enterYears(String textToInput) {
        driver.findElement(By.id("yearsInput")).sendKeys(textToInput);
    }

    private void buttonClick() {
        driver.findElement(By.cssSelector("button.btn-success")).click();
    }

}
