package com.iprogrammers.conversordivisas.system;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iprogrammers.conversordivisas.model.RespuestaBase;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler
	@ResponseBody
	public RespuestaBase<HttpStatus, String> handleDefault(Exception e) {
		e.printStackTrace();		
		return new RespuestaBase<HttpStatus, String>(HttpStatus.INTERNAL_SERVER_ERROR, 
				"No hemos podido procesar la acción. Por favor, intente más tarde");
	}
}
