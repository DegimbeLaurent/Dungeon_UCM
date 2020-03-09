package be.dungeon_ucm.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/java/be/dungeon_ucm/demo",strict = true,extraGlue = {"be.dungeon_ucm.demo.Outils.Factory.Generateur","be.dungeon_ucm.demo.BL.Services.ServiceImpl"})
public class CucumberTest {
}

