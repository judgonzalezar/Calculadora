package com.calculadora.proyectoCalculadora.basics;

import static com.calculadora.proyectoCalculadora.model.ResultBuilder.getResult;
import static com.calculadora.proyectoCalculadora.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.calculadora.proyectoCalculadora.model.ApiResult;

/**
* <h1>Calculadora</h1>
* El programa de BasicControler implementa una aplicación que
* simplemente realiza las operaciones de suma, resta,
* multiplicación y división de dos números de tipo BigDecimal
* y los retorna como un valor de tipo ApiResult.
* @RestController Indica que la clase es un controlador
* @RequestMapping("/basic") Indica que la URL raíz comienza por /basic
* <p>
* @author  Juan David González
* @version 1.0
* @since   2021-10-12
*/
@RestController
@RequestMapping("/basic")
public class BasicController {

   /**
   * Este método es usado para sumar dos valores de 
   * tipo Bigdecimal, la firma del método describe
   * un método de tipo ApiResult es decir que retorna
   * un objeto de este tipo
   * @GetMapping("/add") indica que se agrega /add a la URL 
   * raíz para ingresar al método 
   * @RequestParam augend este es el primer parámetro para
   * ingresar al método
   * @RequestParam addend este es el segundo parámetro para
   * ingresar al método
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   @GetMapping("/add")
   public ApiResult add(@RequestParam(value = "augend", defaultValue = "0") BigDecimal augend, @RequestParam(value = "addend", defaultValue = "0") BigDecimal addend ) {
      return getResult(augend.add(addend));//retorna el resultado de invocar el metodo getResult
   }
   
   /**
   * Este método es usado para restar dos valores de 
   * tipo Bigdecimal, la firma del método describe
   * un método de tipo ApiResult es decir que retorna
   * un objeto de este tipo
   * @GetMapping("/subtract") indica que se agrega /subtract 
   * a la URL raíz para ingresar al método 
   * @RequestParam minuent este es el primer parámetro para
   * ingresar al método
   * @RequestParam subtrahend este es el segundo parámetro para
   * ingresar al método
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   @GetMapping("/subtract")
   public ApiResult subtract(@RequestParam(value = "minuent", defaultValue = "0") BigDecimal minuent, @RequestParam(value = "subtrahend", defaultValue = "0") BigDecimal subtrahend) {
      return getResult(minuent.subtract(subtrahend));
   }

   /**
   * Este método es usado para multiplicar dos valores de 
   * tipo Bigdecimal, la firma del método describe
   * un método de tipo ApiResult es decir que retorna
   * un objeto de este tipo
   * @GetMapping("/multiply") indica que se agrega /multiply 
   * a la URL raíz para ingresar al método 
   * @RequestParam multiplier este es el primer parámetro para
   * ingresar al metodo
   * @RequestParam multiplicand este es el segundo parámetro para
   * ingresar al método
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   @GetMapping("/multiply")
   public ApiResult multiply(@RequestParam(value = "multiplier", defaultValue = "0") BigDecimal multiplier, @RequestParam(value = "multiplicand", defaultValue = "0") BigDecimal multiplicand) {
      return getResult(multiplier.multiply(multiplicand));
   }

   /**
   * Este método es usado para dividir dos valores de 
   * tipo Bigdecimal, la firma del método describe
   * un método de tipo ApiResult es decir que retorna
   * un objeto de este tipo
   * @GetMapping("/divide") indica que se agrega /divide 
   * a la URL raíz para ingresar al método 
   * @RequestParam dividend este es el primer parámetro para
   * ingresar al método
   * @RequestParam divisor este es el segundo parámetro para
   * ingresar al método
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   @GetMapping("/divide")
   public ApiResult divide(@RequestParam(value = "dividend", defaultValue = "0") BigDecimal dividend, @RequestParam(value = "divisor", defaultValue = "0") BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO)) {
         return getResultFromError("no division by null");
      }
      return getResult(dividend.divide(divisor, RoundingMode.HALF_EVEN));
   }

}