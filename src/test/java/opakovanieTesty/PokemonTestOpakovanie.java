package opakovanieTesty;

import base.TestBase;
import opakovaniePages.PokemonPageOpakovanie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTestOpakovanie extends TestBase {
    private PokemonPageOpakovanie pokemonPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
        pokemonPage = new PokemonPageOpakovanie(driver);
    }

    @Test
    public void itShouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            pokemonPage.selectPokemon(pokemon);
            Assert.assertEquals(getExpectedMessage(pokemon), pokemonPage.getActualMessage());
        }
    }

    private String getExpectedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }

}
