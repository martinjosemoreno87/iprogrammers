package com.iprogrammers.conversordivisas.dao;

import java.util.List;

import com.iprogrammers.conversordivisas.model.Cotizacion;

public interface DivisaDao {

	public void save(Cotizacion cotizacion);

	public List<Cotizacion> getCotizaciones();
	
}
