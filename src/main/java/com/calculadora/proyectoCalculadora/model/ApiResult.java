package com.calculadora.proyectoCalculadora.model;

public class ApiResult{

   /**
   * Estos son los dos parámetros determinados para el 
   * objeto de la clase ApiResult
   */
   public String result;
   private String error;

   public ApiResult(){
   }
   
   /**
   * Este método recibe un parámetro de tipo String
   * el cual es un valor que asigna al atributo result de 
   * el objeto de tipo ApiResult que se instancia 
   * en este método que a su vez retorna un objeto de tipo 
   * ApiResult
   * @Param resultMessage este es el primer parámetro para
   * ingresar al metodo withResult 
   * @return apiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   public static ApiResult withResult(String resultMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.result = resultMessage;
      return apiResult;
   }

   /**
   * Este método recibe un parámetro de tipo String
   * el cual es un valor que asigna al atributo error de 
   * el objeto de tipo ApiResult que se instancia 
   * en este método que a su vez retorna un objeto de tipo 
   * ApiResult
   * @Param errorMessage este es el primer parámetro para
   * ingresar al método withError
   * @return apiResult Este retorna un objeto de tipo ApiResult
   * que tiene dos atributos result y error.
   */
   public static ApiResult withError(String errorMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.error = errorMessage;
      return apiResult;
   }


   /**
   * Este método no recibe parámetros, pero se utiliza 
   * para consultar el valor de un atributo de tipo private
   * en el objeto de la clase ApiResult
   * @return result Este retorna el atributo de tipo ApiResult
   */
   public String getResult() {
      return result;
   }

   /**
   * Este método no recibe parámetros, pero se utiliza 
   * para consultar el valor de un atributo de tipo private
   * en el objeto de la clase ApiResult
   * @return error Este retorna el atributo de tipo ApiResult
   */
   public String getError() {
      return error;
   }
}
