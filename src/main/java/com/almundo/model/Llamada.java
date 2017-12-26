package com.almundo.model;

import java.util.Date;

public class Llamada {
	
	private Date fechaEntrada;
	private Date fechaSalida;
	private Usuario usuario;
	private Boolean fueAtendida;
	private Integer numero;
	private Integer tiempoDuracion;
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getFueAtendida() {
		return fueAtendida;
	}

	public void setFueAtendida(Boolean fueAtendida) {
		this.fueAtendida = fueAtendida;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Integer getTiempoDuracion() {
		return tiempoDuracion;
	}

	public void setTiempoDuracion(Integer tiempoDuracion) {
		this.tiempoDuracion = tiempoDuracion;
	}

	public Llamada() {
		super();
	}

	public Llamada(Integer numero) {
		this.fechaEntrada = new Date();
		this.setFueAtendida(false);
		this.numero = numero;
		this.tiempoDuracion = (int) (Math.random() * 5000) + 5000;
	}

}
