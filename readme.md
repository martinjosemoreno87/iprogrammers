# Simulador de Conversión de divisas

## Documentación

La siguiente documentación describe la configuración y utilización del api desarrollado para la conversión de divisas. 

### Tecnologías utilizadas

1 - Todos​ ​ los​ ​ Web​ ​ Services​ ​ están​ ​ implementados​ ​ como​ REST​ / JSON​.

2 - Spring Boot

3 - Hibernate

4 - Postgresql

5 - Java 8

6 - Tomcat 8

### Setup

1 - Crear una base de datos en postgresql llamada "cotizaciones".

2 - Dentro de la base de datos creada en el paso 1 crear el siguiente usuario y password: (iprogrammers, iprogrammers1234).

3 - Dentro de la base de datos creada en el paso 1 crear un schema llamado "iprogrammers".

4 - Agregar el api key correspondiente en el método getMyKey() del archivo de configuración AppConfig. 

### Detalles​ ​ para​ ​ la​ ​ ejecución

Método: GET

URL: /iprogrammers/divisas/cotizaciones

Descripción: El presente método se encarga de retornar un histórico de cotizaciones.

Ejemplo de respuesta:  {	"code": "OK",
							"value": 
							[
							  {
								"updated": "2019-04-08",
								"source": "USD",
								"target": "ARS",
								"quantity": 100,
								"amount": 4387.9
							  }
							]
						}
				
------------------------------------------------------

Método: GET

URL: /iprogrammers/divisas/divisasexpuestas

Descripción: El presente método se encarga de retornar las divisas expuestas.

Parámetros: source

Ejemplo de pedido: /iprogrammers/divisas/divisasexpuestas?source=EUR

Ejemplo de respuesta: {
							"code": "OK",
							"value": 
							{
								"from": "EUR",
								"conversion": 
								[
									{
										"to": "AED",
										"date": "2019-04-08T14:59:09.000+0000",
										"rate": 4.137546
									}
								]
							}
						}

------------------------------------------------------

Método:	POST

URL: /iprogrammers/divisas/cotizar

Descripción: El presente método se encarga de retornar la cotización requerida teniendo en cuenta la cotización de la divisa origen, la divisa destino y la cantidad.

Parámetros: {"source":"USD","target":"ARS","quantity":100}

Ejemplo de pedido: /iprogrammers/divisas/divisasexpuestas?source=EUR

Ejemplo de respuesta:  {
							"code": "OK",
							"value": 
							{
								"updated": "2019-04-08",
								"source": "USD",
								"target": "ARS",
								"quantity": 100,
								"amount": 4387.9
							}
						}
