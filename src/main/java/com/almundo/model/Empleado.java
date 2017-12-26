package com.almundo.model;

import java.util.Date;

public abstract class Empleado extends Thread implements Comparable<Empleado> {

	private String nombre;
	private String apellido;
	private EstadoEmpleado estado;
	private Integer prioridadAtencion;
	private Llamada llamadaAtendida;
	private Dispatcher dispatcher;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public EstadoEmpleado getEstado() {
		return estado;
	}

	public void setEstado(EstadoEmpleado estado) {
		this.estado = estado;
	}
	
	public Integer getPrioridadAtencion() {
		return prioridadAtencion;
	}

	public void setPrioridadAtencion(Integer prioridadAtencion) {
		this.prioridadAtencion = prioridadAtencion;
	}

	private Date calcularFechaSalida(Date fechaEntrada) {
		Integer tiempoAtencion = (int) (Math.random() * 5000) + 5000;
		Long tiempoMilisegundos = fechaEntrada.getTime() + tiempoAtencion;

		Date fechaSalida = new Date(tiempoMilisegundos);

		return fechaSalida;
	}
	
	abstract void addEmpleadoDisponible(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado);
	
	/**
	 * Constructor
	 * @param dispatcher
	 * @param nombre
	 * @param apellido
	 * @param estado
	 */
	public Empleado(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		this.dispatcher = dispatcher;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
	}

	/**
	 * Atiende una llamada
	 * @param llamada
	 */
	public void atender(Llamada llamada) {
		this.llamadaAtendida = llamada;
		this.start();
		
		Date fechaEntrada = llamada.getFechaEntrada();
		Date fechaSalida = calcularFechaSalida(fechaEntrada);

		llamada.setFechaEntrada(fechaEntrada);
		llamada.setFueAtendida(true);
		llamada.setFechaSalida(fechaSalida);
	}

	/**
	 * Ordeno a los empleados segun PrioridadAtencion
	 */
	public int compareTo(Empleado empleado) {
		return this.getPrioridadAtencion() - empleado.getPrioridadAtencion();
	}
	
	/**
	 * Hilo de ejecucion para atender una llamada
	 */
	public void run() {
		try {
			long tiempoDuracion = llamadaAtendida.getTiempoDuracion();
			Thread.sleep(tiempoDuracion);
			System.out.println("Llamada " + llamadaAtendida.getNumero() + " finalizada. Duracion :" + tiempoDuracion);
			this.addEmpleadoDisponible(dispatcher, this.getNombre(), this.getApellido(), this.getEstado());
			System.out.println("Empleado " + this.getNombre() + " disponible");
		} catch (InterruptedException e) {
			System.out.println("Error atendiendo llamada " + llamadaAtendida.getNumero());
			e.printStackTrace();
		}
	}
}
