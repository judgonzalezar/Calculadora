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


@SpringBootTest
class ProyectoCalculadoraApplicationTests {
    
	//Valores para la suma
	String expectedAdd= "10";
	BigDecimal augend= new BigDecimal(5);
	BigDecimal addend= new BigDecimal(5);
	
	//Valores para la resta
	String expectedSubtract= "10";
	BigDecimal minuent= new BigDecimal(20);
	BigDecimal subtrahend= new BigDecimal(10);

	//Valores para la multiplicación 
	String expectedMultiply= "200";
	BigDecimal multiplier= new BigDecimal(20);
	BigDecimal multiplicand= new BigDecimal(10);

	//Valores para la división
	String expectedDivide= "2";
	BigDecimal dividend= new BigDecimal(20);
	BigDecimal divisor= new BigDecimal(0);

	BasicController apiResult1 = new BasicController();

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


