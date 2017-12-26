package com.almundo.model;

public class Supervisor extends Empleado {

	public Supervisor(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		super(dispatcher, nombre, apellido, estado);
		super.setPrioridadAtencion(2);
	}

	@Override
	void addEmpleadoDisponible(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		dispatcher.addEmpleado(new Director(dispatcher, nombre, apellido, estado));
	}

}
