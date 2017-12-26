package com.almundo.model;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher extends Thread {

	private BlockingQueue<Empleado> empleadosDisponibles;
	private BlockingQueue<Llamada> llamadas;

	public Queue<Llamada> getLLamadas() {
		return llamadas;
	}
	
	public Queue<Empleado> getEmpleadosDisponibles() {
		return empleadosDisponibles;
	}
	
	public void addEmpleado(Empleado empleado) {
		this.empleadosDisponibles.add(empleado);
	}

	public Dispatcher() {
		empleadosDisponibles = new PriorityBlockingQueue<Empleado>();
		llamadas = new LinkedBlockingQueue<Llamada>();
	}

	public void addEmpleadoDisponible(Empleado empleado) {
		this.empleadosDisponibles.add(empleado);
	}

	public void dispatchCall(Llamada llamada) throws InterruptedException {
		System.out.println("Llamada entrante numero: " + llamada.getNumero());
		this.llamadas.put(llamada);
	}

	/**
	 * Hilo de ejecucion de la llamada
	 */
	public void run() {
		Llamada llamada;
		Empleado empleado;
		try {
			while (true) {
				llamada = llamadas.take();
				System.out.println("Esperando a tomar la llamada entrante numero: " + llamada.getNumero());
				empleado = empleadosDisponibles.take();
				System.out.println("Rol: " + empleado.getClass().getSimpleName() + " " + empleado.getNombre() + " "
						+ empleado.getApellido() + " va a tomar la llamada " + llamada.getNumero());
				empleado.atender(llamada);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
