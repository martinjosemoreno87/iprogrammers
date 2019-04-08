package com.iprogrammers.conversordivisas.model;

import java.util.List;

public class DivisasExpuestas {

	private String from;
	private List<Divisa> conversion;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<Divisa> getConversion() {
		return conversion;
	}

	public void setConversion(List<Divisa> conversion) {
		this.conversion = conversion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversion == null) ? 0 : conversion.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
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
		DivisasExpuestas other = (DivisasExpuestas) obj;
		if (conversion == null) {
			if (other.conversion != null)
				return false;
		} else if (!conversion.equals(other.conversion))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DivisasExpuestas [from=" + from + ", conversion=" + conversion + "]";
	}

}
