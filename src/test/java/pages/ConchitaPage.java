package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConchitaPage {
    private WebDriver pageDriver;

    public ConchitaPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void selectWurst() {
        pageDriver.findElement(By.xpath("//input[@value='wurst']")).click();
    }
}
