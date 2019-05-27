package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PokemonPage;

public class PokemonTest extends TestBase {

    private PokemonPage pokemonPage;

        @Before
        public void openPage() {
            //1.otvorit stranku
            driver.get(BASE_URL + "/vybersi.php");
            pokemonPage = new PokemonPage (driver);
        }

    @Test
    public void itShouldSelectPokemons(){
            String[] selectedPokemons = {"Pikachu", "Bulbasaur" , "Charmander", "Diglett", "Geodude"};

            for (String pokemon: selectedPokemons) {
                //vyberiem pokemona
                pokemonPage.selectPokemon(pokemon);
                //overim hlasku
                //String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
                //String expectedMessage = "I choose you " + pokemon + " !";

                //String expectedMessageByFormmat = String.format("I choose you %s !", pokemon);
                //bud pouzit zakomentovane (krajsi zapis toho vyssie) alebo to povodne
                Assert.assertEquals(getExpectedMessage (pokemon), pokemonPage.getActualMessage ());
            }
    }
    //zmenili sme signaturu metody
    private String getExpectedMessage (String pokemonName){
        //metoda mi vrati ocakavanu hlasku I choose you {pokemon}} !
        return String.format("I choose you %s !", pokemonName);
    }
}
