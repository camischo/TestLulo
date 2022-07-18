package com.conexia.qa.mensajero.interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionaOpcion implements Task {

    private Target lista;
    private Target opcionSeleecionar;

    public SeleccionaOpcion(Target lista, Target opcionSeleecionar) {
        this.lista = lista;
        this.opcionSeleecionar = opcionSeleecionar;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(lista));
        actor.attemptsTo(Espero.estosMilisegundos(300));
        actor.attemptsTo(Click.on(opcionSeleecionar));
        actor.attemptsTo(Espero.estosMilisegundos(300));

    }

    public static SeleccionaOpcion deLaLista(Target lista, Target opcionSeleecionar) {
        return new SeleccionaOpcion(lista, opcionSeleecionar);
    }

}
