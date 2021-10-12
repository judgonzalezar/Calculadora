package com.calculadora.proyectoCalculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
* <h1>Calculadora</h1>
* El programa ProyectoCalculadoraApplication implementa 
* una aplicación que realiza los cálculos matemáticos 
* de suma, resta, multiplicación y división y los muestra
* como un documento json en el navegador.
* 
*
* @author  Juan David González
* @version 1.0
* @since   2021-10-11 
*/
@SpringBootApplication
public class ProyectoCalculadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCalculadoraApplication.class, args);
	}

}
