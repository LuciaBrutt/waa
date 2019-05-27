package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GosslingatorPage {
    @FindBy(id = "addRyan")
    private WebElement addRyanButton;

    @FindBy(css = "div.ryan-counter h3")
    private WebElement ryanDescription;

    private WebDriver pageDriver;

    public GosslingatorPage(WebDriver driver) {

        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void addRyan (){
        addRyanButton.click();
    }

    public String getRyanCounterNumber(){
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription () {
        //vrati napis ryan alebo ryans
        return ryanDescription.getText();
    }

    public int getNumberOfRyanImages () {
        //vrati pocet obrazkov ryana
        return pageDriver.findElements(By.cssSelector("img")).size();
    }
}
