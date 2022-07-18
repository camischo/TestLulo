package com.conexia.qa.mensajero.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarLosEmpleados implements Task
{
    private int idEmpleado;

    public ConsultarLosEmpleados(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(idEmpleado!=0){
            actor.attemptsTo(
                    Get.resource("/employees/"+idEmpleado)
                            .with(
                                    request -> request.header("Content-Type", "application/json")
                            )
            );
        }else {
            actor.attemptsTo(
                    Get.resource("/employees")
                            .with(
                                    request -> request.header("Content-Type", "application/json")
                            )
            );
        }
    }

    public static ConsultarLosEmpleados creados(){
        return Tasks.instrumented(ConsultarLosEmpleados.class,0);
    }

    public static ConsultarLosEmpleados creado(int idEmpleado){
        return Tasks.instrumented(ConsultarLosEmpleados.class,idEmpleado);
    }
}
