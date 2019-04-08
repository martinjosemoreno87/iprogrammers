package com.iprogrammers.conversordivisas.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iprogrammers.conversordivisas.model.Cotizacion;
import com.iprogrammers.conversordivisas.model.CotizacionExterna;
import com.iprogrammers.conversordivisas.model.DivisasExpuestas;
import com.iprogrammers.conversordivisas.model.RespuestaBase;
import com.iprogrammers.conversordivisas.model.DivisasExpuestasExternas;
import com.iprogrammers.conversordivisas.service.DivisaService;

@RestController
@RequestMapping("/divisas")
public class DivisaControllerImpl implements DivisaController {
	
	private final String myKey;
	private final RestTemplate restTemplate;
	private final HttpEntity<String> entity;
	private final DivisaService divisaService;
	
	@Autowired
	public DivisaControllerImpl(@Qualifier("myKey") String myKey, 
			RestTemplate restTemplate, HttpEntity<String> entity, DivisaService divisaService) {
		
		this.myKey = myKey;
		this.restTemplate = restTemplate;
		this.entity = entity;
		this.divisaService = divisaService;
	}
	
	@Override
	@GetMapping("/divisasexpuestas")
	public RespuestaBase<HttpStatus, DivisasExpuestas> getDivisasExpuestas(@RequestParam("source") String source) {
		
		ResponseEntity<DivisasExpuestasExternas> response = restTemplate.exchange("http://api.valuta.money/v1/full/" + source + "/json?key=" + myKey, 
				HttpMethod.GET , entity , DivisasExpuestasExternas.class);
		
		return new RespuestaBase<HttpStatus, DivisasExpuestas>(HttpStatus.OK, response.getBody().getResult());
	}

	@Override
	@PostMapping("/cotizar")
	public RespuestaBase<HttpStatus, Cotizacion> cotizar(@RequestBody Cotizacion cotizacion) {
		
        ResponseEntity<CotizacionExterna> response = restTemplate.exchange("https://api.cambio.today/v1/quotes/" + cotizacion.getSource() + "/" 
        		+ cotizacion.getTarget() + "/json?quantity=" + cotizacion.getQuantity() + "&key=" + myKey, HttpMethod.GET , entity , CotizacionExterna.class);
        
        Cotizacion result = response.getBody().getResult();
        divisaService.saveCotizacion(result);
        
		return new RespuestaBase<>(HttpStatus.OK, result);
		
	}

	@Override
	@GetMapping("/cotizaciones")
	public RespuestaBase<HttpStatus, List<Cotizacion>> getCotizaciones(Cotizacion cotizacion) {
		
		return new RespuestaBase<>(HttpStatus.OK, divisaService.getCotizaciones());
	}

}
