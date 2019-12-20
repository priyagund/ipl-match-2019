package com.ipl2019;
 public class IPLMatchException extends Exception{

     enum ExceptionType {
        FILE_NOT_FOUND,SUME_ERROR_IN_FILE,NO_DATA_FOUND,INVALID_PLAYER;
     }
     
     ExceptionType type;
   
     public IPLMatchException(ExceptionType type) {
         this.type = type;
     }

     public IPLMatchException(String message, ExceptionType type) {
         super(message);
         this.type = type;
     }
     public IPLMatchException(String message,String name) {
         super(message);
         this.type =ExceptionType.valueOf(name);
     }

 }

