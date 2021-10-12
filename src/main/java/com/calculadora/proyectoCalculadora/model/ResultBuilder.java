package com.calculadora.proyectoCalculadora.model;

import java.math.BigDecimal;


public class ResultBuilder{

   public ResultBuilder(){
   }

   /**
   * Este método recibe un parámetro de tipo Objeto
   * el cual convierte a tipo String para ser ingresado
   * al método withResult el cual retorna un objeto de 
   * tipo ApiResult 
   * @Param result este es el primer parámetro para
   * ingresar al método getResult 
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   public static ApiResult getResult( Object result ) {
      return ApiResult.withResult(result.toString());
   }

   /**
   * Este método recibe un parámetro de tipo BigDecimal
   * el cual convierte a tipo String para ser ingresado
   * al método withResult el cual retorna un objeto de 
   * tipo ApiResult 
   * @Param result este es el primer parámetro para
   * ingresar al método getResult 
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   public static ApiResult getResult( BigDecimal result ) {
      return ApiResult.withResult(result.toPlainString());
   }

   /**
   * Este método recibe un parámetro de tipo String
   * el cual ingresa al método withError el cual 
   * retorna un objeto de tipo ApiResult 
   * @Param errorMessage este es el primer parámetro para
   * ingresar al método getResultFromError
   * @return ApiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   public static ApiResult getResultFromError(String errorMessage) {
      return ApiResult.withError(errorMessage);
   }
}
