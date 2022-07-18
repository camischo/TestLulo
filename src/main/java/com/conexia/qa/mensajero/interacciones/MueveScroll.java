package com.conexia.qa.mensajero.interacciones;

import com.conexia.qa.mensajero.drivers.OwnWebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;

public class MueveScroll implements Interaction{

	private int size;
	private String ubication;

	public MueveScroll(int size, String ubication) {
		this.size = size;
		this.ubication = ubication;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		JavascriptExecutor jse = (JavascriptExecutor) OwnWebDriver.getDriver();
		switch (ubication) {
		case "vertical":
			jse.executeScript("window.scrollBy(0," + size + ")");
			break;
		case "horizontal":
			jse.executeScript("window.scrollBy(" + size + ",0)");
			break;
		default:
			break;
		}


		
	}
	public static MueveScroll vertical(int size) {
		return Tasks.instrumented(MueveScroll.class, size, "vertical");
	}

	public static MueveScroll horizontal(int size) {
		return Tasks.instrumented(MueveScroll.class, size, "horizontal");
	}

}
