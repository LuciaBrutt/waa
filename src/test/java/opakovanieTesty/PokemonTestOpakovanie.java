package opakovanieTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTestOpakovanie {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/vybersi.php");
    }

    @Test
    public void itShouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(pokemon);
            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessageByFormat = String.format("I choose you %s !", pokemon);
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }
}
