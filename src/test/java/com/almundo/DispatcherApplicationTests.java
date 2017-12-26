package com.almundo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.almundo.model.Director;
import com.almundo.model.Dispatcher;
import com.almundo.model.EstadoEmpleado;
import com.almundo.model.Llamada;
import com.almundo.model.Operador;
import com.almundo.model.Supervisor;

public class DispatcherApplicationTests {

	@Test
	public void llamadas3() {
		try {
			System.out.println("TEST DE 3 LLAMADAS");
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.start();
			dispatcher.addEmpleado(new Director(dispatcher, "Ramino", "Lucero", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Supervisor(dispatcher, "Roxana", "Lopez", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Operador(dispatcher, "Ana", "Lombardo", EstadoEmpleado.DISPONIBLE));
			
			Llamada llamada0 = new Llamada(0);
			Llamada llamada1 = new Llamada(1);
			Llamada llamada2 = new Llamada(2);
			
			Integer tiempoDuracionTotal = llamada0.getTiempoDuracion() + llamada1.getTiempoDuracion()
					+ llamada2.getTiempoDuracion();
			
			dispatcher.dispatchCall(llamada0);
			dispatcher.dispatchCall(llamada1);
			dispatcher.dispatchCall(llamada2);
			
			Thread.sleep(tiempoDuracionTotal);
			
			assertTrue(dispatcher.getLLamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void llamadas5() {
		try {
			System.out.println("TEST DE 5 LLAMADAS");
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.start();
			dispatcher.addEmpleado(new Director(dispatcher, "Ramino", "Lucero", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Director(dispatcher, "Rodolfo", "San Martin", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Supervisor(dispatcher, "Roxana", "Lopez", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Operador(dispatcher, "Ana", "Lombardo", EstadoEmpleado.DISPONIBLE));
			
			Llamada llamada0 = new Llamada(0);
			Llamada llamada1 = new Llamada(1);
			Llamada llamada2 = new Llamada(2);
			Llamada llamada3 = new Llamada(3);
			Llamada llamada4 = new Llamada(4);
			
			Integer tiempoDuracionTotal = llamada0.getTiempoDuracion() + llamada1.getTiempoDuracion()
					+ llamada2.getTiempoDuracion() + llamada3.getTiempoDuracion() + llamada4.getTiempoDuracion();
			
			dispatcher.dispatchCall(llamada0);
			dispatcher.dispatchCall(llamada1);
			dispatcher.dispatchCall(llamada2);
			dispatcher.dispatchCall(llamada3);
			dispatcher.dispatchCall(llamada4);
			
			Thread.sleep(tiempoDuracionTotal);
			
			assertTrue(dispatcher.getLLamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void llamadas7() {
		try {
			System.out.println("TEST DE 7 LLAMADAS");
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.start();
			dispatcher.addEmpleado(new Director(dispatcher, "Ramino", "Lucero", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Supervisor(dispatcher, "Roxana", "Lopez", EstadoEmpleado.DISPONIBLE));
			dispatcher.addEmpleado(new Operador(dispatcher, "Ana", "Lombardo", EstadoEmpleado.DISPONIBLE));
			
			Llamada llamada0 = new Llamada(0);
			Llamada llamada1 = new Llamada(1);
			Llamada llamada2 = new Llamada(2);
			Llamada llamada3 = new Llamada(3);
			Llamada llamada4 = new Llamada(4);
			Llamada llamada5 = new Llamada(5);
			Llamada llamada6 = new Llamada(6);
			
			Integer tiempoDuracionTotal = llamada0.getTiempoDuracion() + llamada1.getTiempoDuracion()
					+ llamada2.getTiempoDuracion() + llamada3.getTiempoDuracion() + llamada4.getTiempoDuracion()
					+ llamada5.getTiempoDuracion() + llamada6.getTiempoDuracion();
			
			dispatcher.dispatchCall(llamada0);
			dispatcher.dispatchCall(llamada1);
			dispatcher.dispatchCall(llamada2);
			dispatcher.dispatchCall(llamada3);
			dispatcher.dispatchCall(llamada4);
			dispatcher.dispatchCall(llamada5);
			dispatcher.dispatchCall(llamada6);
			
			Thread.sleep(tiempoDuracionTotal);
			
			assertTrue(dispatcher.getLLamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
