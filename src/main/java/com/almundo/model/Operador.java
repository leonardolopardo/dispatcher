package com.almundo.model;

public class Operador extends Empleado {

	public Operador(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		super(dispatcher, nombre, apellido, estado);
		super.setPrioridadAtencion(1);
	}

	@Override
	void addEmpleadoDisponible(Dispatcher dispatcher, String nombre, String apellido, EstadoEmpleado estado) {
		dispatcher.addEmpleado(new Director(dispatcher, nombre, apellido, estado));
	}

}
