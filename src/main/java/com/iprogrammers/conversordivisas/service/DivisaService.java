package com.iprogrammers.conversordivisas.service;

import java.util.List;

import com.iprogrammers.conversordivisas.model.Cotizacion;

public interface DivisaService {

	public void saveCotizacion(Cotizacion cotizacion);

	public List<Cotizacion> getCotizaciones();

}
