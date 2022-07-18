package com.conexia.qa.mensajero.interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Espero implements Interaction {

    private String tipoDeEspera;
    private int segundos;
    private long milisegundos;
    private int intentos;
    private Target elemento;

    public Espero(String tipoDeEspera, int segundos, long milisegundos, int intentos, Target elemento) {
        this.tipoDeEspera = tipoDeEspera;
        this.segundos = segundos;
        this.milisegundos = milisegundos;
        this.intentos = intentos;
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            switch (tipoDeEspera) {
                case "Segundos":
                    this.milisegundos = segundos * 1000;
                    Thread.sleep(milisegundos);
                    break;
                case "Milisegundos":
                    Thread.sleep(milisegundos);
                    break;
                case "Habilitado":
                    int indice = 0;
                    while (!elemento.resolveFor(actor).isEnabled() || intentos >= indice) {
                        Thread.sleep(400);
                        indice = indice + 1;
                    }
            }
        } catch (InterruptedException e) {
        }
    }

    public static Espero estosSegundos(int segundos) {
        return Tasks.instrumented(Espero.class, "Segundos", segundos, 0, 0, null);
    }

    public static Espero estosMilisegundos(long milisegundos) {
        return Tasks.instrumented(Espero.class, "Milisegundos", 0, milisegundos, 0, null);
    }

    public static Espero aQueEsteHabilitado(Target elemento, int intentos) {
        return Tasks.instrumented(Espero.class, "Habilitado", 0, 0, intentos, elemento);
    }
}
