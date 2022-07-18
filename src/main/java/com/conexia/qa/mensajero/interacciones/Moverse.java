package com.conexia.qa.mensajero.interacciones;

import com.conexia.qa.mensajero.drivers.OwnWebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

public class Moverse implements Interaction {

	private Target objeto;

	public Moverse(Target objeto) {
		this.objeto = objeto;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		Actions actions = new Actions(OwnWebDriver.getDriver());
		actions.moveToElement(objeto.resolveFor(actor));
		actions.perform();
		while (!objeto.resolveFor(actor).isEnabled()||!objeto.resolveFor(actor).isDisplayed()) {
			Espero.estosMilisegundos(1000);
		}
	}

	public static Moverse hasta(Target objeto) {
		return Tasks.instrumented(Moverse.class, objeto);

	}

}
