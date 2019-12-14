package com.ipl;
 public class IPLMatchException extends Exception{
     
     enum ExceptionType {
        FILE_NOT_FOUND;
     }
     
     ExceptionType type;
   
     public IPLMatchException(ExceptionType type) {
         this.type = type;
     }

     public IPLMatchException(String message, ExceptionType type) {
         super(message);
         this.type = type;
     }
 }

