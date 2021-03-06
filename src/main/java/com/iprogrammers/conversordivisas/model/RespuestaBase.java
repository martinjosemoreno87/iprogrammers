package com.iprogrammers.conversordivisas.model;

public class RespuestaBase<T, F> {

	private T code;
	private F value;

	public RespuestaBase(T code, F value) {
		this.code = code;
		this.value = value;
	}

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public F getValue() {
		return value;
	}

	public void setValue(F value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		RespuestaBase<?, ?> other = (RespuestaBase<?, ?>) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RespuestaBase [code=" + code + ", value=" + value + "]";
	}

}
