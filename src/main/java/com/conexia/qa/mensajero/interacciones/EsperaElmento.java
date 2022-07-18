package com.conexia.qa.mensajero.interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsperaElmento implements Interaction {

	private Target target;
	private String state;

	public EsperaElmento(Target target, String state) {
		this.target = target;
		this.state = state;
	}

	@Override
	@Step("{0} espera el #target hasta que este #state")
	public <T extends Actor> void performAs(T actor) {
		switch (state) {
		case "Visible":
			waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
			break;
		case "Invisible":
			waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));
			break;
		case "Desaparezca":
			waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));
			break;
		default:
			break;
		}
	}

	private WebDriverWait waitAs(Actor actor) {
		return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 35);
	}

	public static EsperaElmento hastaQueAparezca(Target target) {
		return Tasks.instrumented(EsperaElmento.class, target, "Visible");
	}

	public static EsperaElmento hastaQueDesaparezca(Target target) {
		return Tasks.instrumented(EsperaElmento.class, target, "Invisible");
	}

	public static EsperaElmento hastaQueEsteHabilitado(Target target) {
		return Tasks.instrumented(EsperaElmento.class, target, "Desaparezca");
	}

}