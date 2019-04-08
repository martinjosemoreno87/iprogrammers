package com.iprogrammers.conversordivisas.web;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.iprogrammers.conversordivisas.model.Cotizacion;
import com.iprogrammers.conversordivisas.model.DivisasExpuestas;
import com.iprogrammers.conversordivisas.model.RespuestaBase;

public interface DivisaController {
	
	public RespuestaBase<HttpStatus, DivisasExpuestas> getDivisasExpuestas(String source);
	
	public RespuestaBase<HttpStatus, Cotizacion> cotizar(Cotizacion cotizacion);
	
	public RespuestaBase<HttpStatus, List<Cotizacion> > getCotizaciones();
	
}
