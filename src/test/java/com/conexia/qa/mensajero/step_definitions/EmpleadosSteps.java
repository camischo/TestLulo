package com.conexia.qa.mensajero.step_definitions;

import com.conexia.qa.mensajero.modelos.Selenium;
import com.conexia.qa.mensajero.modelos.Usuario;
import com.conexia.qa.mensajero.tareas.ActualizarLosEmpleados;
import com.conexia.qa.mensajero.tareas.ConsultarLosEmpleados;
import com.conexia.qa.mensajero.tareas.CrearLosEmpleados;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.Matchers.hasItems;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EmpleadosSteps {

    @Given("^(.+?) Inicia sesion en el sistema$")
    public void iniciaSesionEnElSistema(String usuario) {
        setTheStage(Cast.ofStandardActors());
        theActorCalled(usuario);
        theActorInTheSpotlight().whoCan(CallAnApi.at(Selenium.parameters().getProperty("getEmpleados")));
    }

    @When("Consulta los empleados")
    public void consultaLosEmpleados() {
        theActorInTheSpotlight().attemptsTo(ConsultarLosEmpleados.creados());
    }

    @When("Crea un empleado")
    public void consultaLosEmpleados(DataTable Usuarios) {
        List<Usuario> usuario = Usuarios.asList(Usuario.class);
        theActorInTheSpotlight().attemptsTo(
                CrearLosEmpleados.conLosDatos(
                        usuario.get(1).getNombreEmpleado(),
                        usuario.get(1).getSalarioEmpleado(),
                        usuario.get(1).getEdadEmpleado()));
    }

    @When("Consulta el primer empleado")
    public void consultaElPrimerEmpleado() {
        theActorInTheSpotlight().attemptsTo(ConsultarLosEmpleados.creado(1));
    }

    @When("Actualiza el empleado")
    public void actualizaElUsuario(DataTable Usuarios) {
        List<Usuario> usuario = Usuarios.asList(Usuario.class);
        theActorInTheSpotlight().attemptsTo(ActualizarLosEmpleados.conLosDatos(
                usuario.get(1).getIdEmpleado(),
                usuario.get(1).getNombreEmpleado(),
                usuario.get(1).getSalarioEmpleado(),
                usuario.get(1).getEdadEmpleado()
        ));
    }

    @Then("Puede ver los empleados")
    public void puedeVerLosEmpleados(DataTable Usuarios) {
        List<Usuario> usuario = Usuarios.asList(Usuario.class);
        theActorInTheSpotlight().should(seeThatResponse("Empleados",
                response -> response.
                        statusCode(200).body("data.employee_name",hasItems(
                                usuario.get(1).getNombreEmpleado(),
                                usuario.get(1).getNombreEmpleado(),
                                usuario.get(1).getNombreEmpleado()))
                ) );
    }

    @Then("Puede ver el empleado")
    public void puedeVerElEmpleado(DataTable Usuarios) {
        List<Usuario> usuario = Usuarios.asList(Usuario.class);
        theActorInTheSpotlight().should(seeThatResponse("Empleados",
                response -> response.
                        statusCode(200).body("data.name",hasItems(
                        usuario.get(1).getNombreEmpleado()))
        ) );
    }

}
