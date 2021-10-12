package com.calculadora.proyectoCalculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.proyectoCalculadora.basics.BasicController;
import com.calculadora.proyectoCalculadora.model.ApiResult;
import com.calculadora.proyectoCalculadora.model.ResultBuilder;

import java.math.*;

/**
* <h1>Calculadora</h1>
* El programa de ProyectoCalculadoraApplicationTests implementa
* las pruebas del código con el que se está trabajando,
* ya sea testeando los métodos de suma, resta, multiplicación
* división y los demás métodos involucrados en la api.
* @pringBootTest Indica que esta es la clase para hacer Test.
*
* @author  Juan David González
* @version 1.0
* @since   2021-10-12
*/
@SpringBootTest
class ProyectoCalculadoraApplicationTests {
    
	//Parámetros para la suma
	String expectedAdd= "10";
	BigDecimal augend= new BigDecimal(5);
	BigDecimal addend= new BigDecimal(5);
	
	//Parámetros para la resta
	String expectedSubtract= "10";
	BigDecimal minuent= new BigDecimal(20);
	BigDecimal subtrahend= new BigDecimal(10);

	//Parámetros para la multiplicación 
	String expectedMultiply= "200";
	BigDecimal multiplier= new BigDecimal(20);
	BigDecimal multiplicand= new BigDecimal(10);

	//Parámetros para la división
	String expectedDivide= "2";
	BigDecimal dividend= new BigDecimal(20);
	BigDecimal divisor= new BigDecimal(0);

	BasicController apiResult1 = new BasicController();


   /**
   * Este método no recibe ni devuelve parametros, pero
   * evalua tres metodos utilizados en la solución de la 
   * api los cuales son:
   * add, getResult y With Result cuyo resultado es comparado
   * con un valor esperado seteado al inicio de esta clase.
   */
	@Test
	void addTest() {

        ApiResult add1 = this.apiResult1.add(augend, addend);
		String result1 = add1.result;
        
		ApiResult add2 = ResultBuilder.getResult(augend.add(addend));
		String result2 = add2.result;

		ApiResult add3 = ApiResult.withResult((augend.add(addend)).toString());
		String result3 = add3.result;

		assertEquals(expectedAdd,result1);
		assertEquals(expectedAdd,result2);
		assertEquals(expectedAdd,result3);

        System.out.println("Add");

	}

   /**
   * Este método no recibe ni devuelve parametros, pero
   * evalua tres metodos utilizados en la solución de la 
   * api los cuales son:
   * subtract, getResult y With Result cuyo resultado es comparado
   * con un valor esperado seteado al inicio de esta clase.
   */
	@Test
	void subtractTest() {

        ApiResult subtract1 = this.apiResult1.subtract(minuent, subtrahend);
		String result1 = subtract1.result;
        
		ApiResult subtract2 = ResultBuilder.getResult(minuent.subtract(subtrahend));
		String result2 = subtract2.result;

		ApiResult subtract3 = ApiResult.withResult((minuent.subtract(subtrahend)).toString());
		String result3 = subtract3.result;

		assertEquals(expectedSubtract,result1);
		assertEquals(expectedSubtract,result2);
		assertEquals(expectedSubtract,result3);

        System.out.println("Subtract");

	}

   /**
   * Este método no recibe ni devuelve parametros, pero
   * evalua tres metodos utilizados en la solución de la 
   * api los cuales son:
   * multiply, getResult y With Result cuyo resultado es comparado
   * con un valor esperado seteado al inicio de esta clase.
   */
	@Test
	void multiplyTest() {

        ApiResult multiply1 = this.apiResult1.multiply(multiplier, multiplicand);
		String result1 = multiply1.result;
        
		ApiResult multiply2 = ResultBuilder.getResult(multiplier.multiply(multiplicand));
		String result2 = multiply2.result;

		ApiResult multiply3 = ApiResult.withResult((multiplier.multiply(multiplicand)).toString());
		String result3 = multiply3.result;

		assertEquals(expectedMultiply,result1);
		assertEquals(expectedMultiply,result2);
		assertEquals(expectedMultiply,result3);

        System.out.println("multiply");

	}
   

   /**
   * Este método no recibe ni devuelve parametros, pero
   * evalua tres metodos utilizados en la solución de la 
   * api los cuales son:
   * divide, getResultFromError, getResult y With Result 
   * cuyo resultado es comparad con un valor esperado 
   * seteado al inicio de esta clase, excepto para el metodo 
   * getResultFromError el cual se compara con la cadena 
   * "no division by null"
   */
	@Test
	void divideTest() {

			String result2, result3;

			ApiResult divide1 = this.apiResult1.divide(dividend, divisor);
			String result1 = divide1.getError();

			if (divisor.equals(BigDecimal.ZERO)) {
				ApiResult divide2 = ResultBuilder.getResultFromError("no division by null");
				result2 = divide2.getError();

			 }else{
			ApiResult divide2 = ResultBuilder.getResult(dividend.divide(divisor));
			result2 = divide2.getResult();
	        }

			if (divisor.equals(BigDecimal.ZERO)) {
				ApiResult divide3 = ApiResult.withError("no division by null");
				result3 = divide3.getError();
			 }else{
			ApiResult divide3 = ApiResult.withResult((dividend.divide(divisor)).toString());
			result3 = divide3.result;
		    }
			
		
			assertEquals("no division by null", result1);
			
			if (divisor.equals(BigDecimal.ZERO)) {
				assertEquals("no division by null",result2);
			 }else{
	            assertEquals(expectedDivide,result2);
		    }

			if (divisor.equals(BigDecimal.ZERO)) {
				assertEquals("no division by null",result3);
			 }else{
	            assertEquals(expectedDivide,result3);
		    }

        System.out.println("divide");
		



	}


	//-------------------------------------------------------------------------------------------
    
   /**
   * Estos métodos se ejecutan despues de la ejecución 
   * ya sea despues de todo el test en general o despues
   * de cada test individual.
   * @BeforeAll Se ejecuta antes del test en general.
   * @BeforeEach Se ejecuta antes de cada test individual/
   * @AfterEach Se ejecuta despues de cada test individual/
   * @BeforeAll Se ejecuta despues del test en general.
   */
	@BeforeEach
	public void beforeEach(){
		System.out.println("BeforeEach");
	}

	@AfterEach
	public void afterEach(){
		System.out.println("AfterEach");
	}

	@BeforeAll
	public static void beforeAll(){
		System.out.println("BeforeAll");
	}

	@AfterAll
	public static void afterAll(){
		System.out.println("AfterAll");
	}


}


