package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

    @Test
    public void itShouldOpenPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
    }

}
