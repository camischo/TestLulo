package com.conexia.qa.mensajero.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Empleado.feature",
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        glue = "com.conexia.qa.mensajero.step_definitions",
        tags = "@TODO"
)


public class TestEmpleados {

}
