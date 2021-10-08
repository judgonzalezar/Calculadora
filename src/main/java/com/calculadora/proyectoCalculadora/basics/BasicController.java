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





@RestController
@RequestMapping("/basic")
public class BasicController {


   @GetMapping("/add")
   public ApiResult add(@RequestParam(value = "augend", defaultValue = "0") BigDecimal augend, @RequestParam(value = "addend", defaultValue = "0") BigDecimal addend ) {
      return getResult(augend.add(addend));
   }
   

   @GetMapping("/subtract")
   public ApiResult subtract(@RequestParam(value = "minuent", defaultValue = "0") BigDecimal minuent, @RequestParam(value = "subtrahend", defaultValue = "0") BigDecimal subtrahend) {
      return getResult(minuent.subtract(subtrahend));
   }

   @GetMapping("/multiply")
   public ApiResult multiply(@RequestParam(value = "multiplier", defaultValue = "0") BigDecimal multiplier, @RequestParam(value = "multiplicand", defaultValue = "0") BigDecimal multiplicand) {
      return getResult(multiplier.multiply(multiplicand));
   }

   @GetMapping("/divide")
   public ApiResult divide(@RequestParam(value = "dividend", defaultValue = "0") BigDecimal dividend, @RequestParam(value = "divisor", defaultValue = "0") BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO)) {
         return getResultFromError("no division by null");
      }
      return getResult(dividend.divide(divisor, RoundingMode.HALF_EVEN));
   }

}