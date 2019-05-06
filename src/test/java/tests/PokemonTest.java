package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest {

        WebDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            //0.spustit prehliadac
            driver = new ChromeDriver();
            //vyssie sme si vytvorili novu instanciu z triedy webdriver chcem novy onjekt vytvorit - nova instancia google chrome to bude
            //objekt sa bude volat driver
            //1.otvorit stranku
            driver.get("http://localhost/vybersi.php");
        }

        @After
        public void tearDown() {
            driver.close();
            driver.quit();

        }

    @Test
    public void itShouldSelectPokemons(){

            String[] selectedPokemons = {"Pikachu", "Bulbasaur" , "Charmander", "Diglett", "Geodude"};

            WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

            for (String pokemon: selectedPokemons) {


                //vyberiem pokemona
                new Select(pokemonSelect).selectByVisibleText(pokemon);
                //overim hlasku
                String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
                String expectedMessage = "I choose you " + pokemon + " !";
                //String expectedMessageByFormmat = String.format("I choose you %s !", pokemon);
                //bud pouzit zakomentovane (krajsi zapis toho vyssie) alebo to povodne
                Assert.assertEquals(expectedMessage, actualMessage);
            }
    }
}
