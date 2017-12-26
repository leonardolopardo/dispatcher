package com.almundo.model;

public class Director extends Empleado {

	public Director(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		super(dispatcher, nombre, apellido, estado);
		super.setPrioridadAtencion(3);
	}

	@Override
	void addEmpleadoDisponible(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		dispatcher.addEmpleado(new Director(dispatcher, nombre, apellido, estado));
	}
}
