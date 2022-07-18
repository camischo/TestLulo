package com.conexia.qa.mensajero.utilitarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraerExprexion {

	/**
	 * Realiza la obtencion de un expresion regular
	 * 
	 * @param texto        texto al cual se le va hacer la extraxion
	 * @param expresion    regular a ser aplicada al texto
	 * @param coincidencia numero de la coincidencia que deseo retornar
	 * 
	 * @return El valor que se extrae al texto.
	 **/
	public static String deUnTexto(String texto, String expresion, int coincidencia) {
		String mensaje = texto;
		Pattern RegularExpresion = Pattern.compile(expresion);
		Matcher Coincidencias = RegularExpresion.matcher(mensaje);
		if (Coincidencias.matches()) {
			return Coincidencias.group(coincidencia);
		}
		return null;
	}
}
