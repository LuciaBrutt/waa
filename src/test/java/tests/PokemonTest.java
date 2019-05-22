package tests;

import Base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest extends TestBase {

        @Before
        public void openPage() {
            //1.otvorit stranku
            driver.get(BASE_URL + "/vybersi.php");
        }

    @Test
    public void itShouldSelectPokemons(){
            String[] selectedPokemons = {"Pikachu", "Bulbasaur" , "Charmander", "Diglett", "Geodude"};

            for (String pokemon: selectedPokemons) {
                //vyberiem pokemona
                selectPokemon(pokemon);
                //overim hlasku
                //String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
                //String expectedMessage = "I choose you " + pokemon + " !";

                //String expectedMessageByFormmat = String.format("I choose you %s !", pokemon);
                //bud pouzit zakomentovane (krajsi zapis toho vyssie) alebo to povodne
                Assert.assertEquals(getExpectedMessage (pokemon), getActualMessage ());
            }
    }
    //zmenili sme signaturu metody
    private void selectPokemon (String pokemonToSelect){
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    private String getActualMessage (){
            return driver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    private String getExpectedMessage (String pokemonName){
            //metoda mi vrati ocakavanu hlasku I choose you {pokemon}} !
       return String.format("I choose you %s !", pokemonName);
    }
}
