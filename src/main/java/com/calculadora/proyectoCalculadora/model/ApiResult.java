package com.calculadora.proyectoCalculadora.model;

public class ApiResult{

   public String result;
   private String error;

   public ApiResult(){
   }

   public static ApiResult withResult(String resultMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.result = resultMessage;
      return apiResult;
   }

   public static ApiResult withError(String errorMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.error = errorMessage;
      return apiResult;
   }

   public String getResult() {
      return result;
   }

   public String getError() {
      return error;
   }
}
