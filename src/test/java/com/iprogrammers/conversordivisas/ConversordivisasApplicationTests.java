package com.iprogrammers.conversordivisas;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.iprogrammers.conversordivisas.model.Cotizacion;
import com.iprogrammers.conversordivisas.model.DivisasExpuestas;
import com.iprogrammers.conversordivisas.model.RespuestaBase;
import com.iprogrammers.conversordivisas.web.DivisaController;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ConversordivisasApplicationTests {

	@Autowired
	private DivisaController divisaController;
	
	@Test
	public void getDivisasExpuestasTest() {
		
		RespuestaBase<HttpStatus, DivisasExpuestas> respuestaObtenida = divisaController.getDivisasExpuestas("EUR");
		assertEquals(HttpStatus.OK, respuestaObtenida.getCode());
	}
	
	@Test
	public void cotizar() {
		
		Cotizacion cotizacion = new Cotizacion(null, null, "USD", "ARS", 0.0, 100, 0.0);
		
		RespuestaBase<HttpStatus, Cotizacion> respuestaObtenida = divisaController.cotizar(cotizacion);
		assertEquals(HttpStatus.OK, respuestaObtenida.getCode());
	}

	@Test
	public void getCotizaciones() {
		
		RespuestaBase<HttpStatus, List<Cotizacion>> respuestaObtenida = divisaController.getCotizaciones();
		assertEquals(HttpStatus.OK, respuestaObtenida.getCode());
	}

}
