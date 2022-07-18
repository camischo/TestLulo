package com.conexia.qa.mensajero.modelos;

public class Usuario {
    private String nombreEmpleado;
    private String salarioEmpleado;
    private String edadEmpleado;
    private String idEmpleado;

    public Usuario(String nombreEmpleado, String salarioEmpleado, String edadEmpleado, String idEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.edadEmpleado = edadEmpleado;
        this.idEmpleado = idEmpleado;
    }

    public Usuario() {
    }


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(String salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(String loginUsuario) {
        this.edadEmpleado = edadEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
