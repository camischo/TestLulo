package com.conexia.qa.mensajero.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ActualizarLosEmpleados implements Task {
    private String idEmpleado;
    private String nombre;
    private String salario;
    private String edad;

    public ActualizarLosEmpleados(String idEmpleado, String nombre, String salario, String edad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/update/"+idEmpleado)
                        .with(
                                request -> request.header("Content-Type", "application/json")
                                        .body("" +
                                                "{\n" +
                                                "    \"name\": \"" + nombre + "\",\n" +
                                                "    \"salary\": \"" + salario + "\",\n" +
                                                "    \"age\": \"" + edad + "\"\n" +
                                                "}")
                        )
        );
    }

    public static ActualizarLosEmpleados conLosDatos(String idEmpleado, String nombre, String salario, String edad) {
        return Tasks.instrumented(ActualizarLosEmpleados.class, idEmpleado, nombre, salario, edad);
    }
}
