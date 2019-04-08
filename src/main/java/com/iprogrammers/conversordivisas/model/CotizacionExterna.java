package com.iprogrammers.conversordivisas.model;

public class CotizacionExterna {

	private Cotizacion result;
	private String status;

	public CotizacionExterna() {
	}
	
	public CotizacionExterna(Cotizacion result, String status) {
		this.result = result;
		this.status = status;
	}

	public Cotizacion getResult() {
		return result;
	}

	public void setResult(Cotizacion result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotizacionExterna other = (CotizacionExterna) obj;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", status=" + status + "]";
	}

}
