package com.iprogrammers.conversordivisas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iprogrammers.conversordivisas.dao.DivisaDao;
import com.iprogrammers.conversordivisas.model.Cotizacion;

@Service
public class DivisaServiceImpl implements DivisaService {
	
	private final DivisaDao divisaDao;

	@Autowired
	public DivisaServiceImpl(DivisaDao divisaDao) {
		this.divisaDao = divisaDao;
	}
	
	public void saveCotizacion(Cotizacion cotizacion) {
		divisaDao.save(cotizacion);
	}

	@Override
	public List<Cotizacion> getCotizaciones() {
		return divisaDao.getCotizaciones();
	}
	
}
