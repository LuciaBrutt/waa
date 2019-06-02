package opakovaniePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GosslingatorPageOpakovanie {

    WebDriver pageDriver;

    public GosslingatorPageOpakovanie(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void addRyan() {
        WebElement ryanButton = pageDriver.findElement(By.id("addRyan"));
        ryanButton.click();
    }

    public String getRyanCounterNumber() {
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription() {
        return pageDriver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    public int getNumberOfRyanImages() {
        return pageDriver.findElements(By.cssSelector("img")).size();
    }
}
