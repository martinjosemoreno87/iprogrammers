package com.iprogrammers.conversordivisas.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iprogrammers.conversordivisas.model.Cotizacion;

@Repository
@Transactional
public class DivisaDaoImpl implements DivisaDao {

	private final SessionFactory sessionFactory;
	
	@Autowired
	public DivisaDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Cotizacion cotizacion) {
		cotizacion = (Cotizacion) sessionFactory.getCurrentSession().merge(cotizacion);
		sessionFactory.getCurrentSession().saveOrUpdate(cotizacion);
	}

	@Override
	public List<Cotizacion> getCotizaciones() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Cotizacion", Cotizacion.class)
				.list();
	}
}
