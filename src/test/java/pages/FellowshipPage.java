package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FellowshipPage {

    private WebDriver pageDriver;

    public FellowshipPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void selectFellow(String fellowName) {
        pageDriver.findElement(By.xpath("//h1[contains(text(),'" + fellowName + "')]")).click();
    }

    public List<WebElement> getFellowElements() {
        return pageDriver.findElements(By.cssSelector("ul.list-of-fellows li"));
    }

}
