package com.conexia.qa.mensajero.utilitarios;


public class testmain {

	public static void main(String[] args) {
		System.out.println(ExtraerExprexion.deUnTexto("El cargue N° 2625 se almaceno correctamente e iniciara el proceso de validación, por favor este pendiente del estado", "El cargue N° (.*) se almaceno .*", 1));
	}

}
