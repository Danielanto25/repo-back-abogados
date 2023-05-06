package com.abogados.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EjecutarTareasPendientes {
	
	@Scheduled(cron = "0 0/2 * * * ?")
	@Async
	public void ejecutarAlertas() {
		
	//	System.out.println("Hola soy una alerta programada =======!!!!!!!!!");
		
	// inset en la tabla notificacion con las tareas 
    // select a notificaciones y va a revisar las del dia 
    // where fecha = GETDATE()		
		
//		la tarea que se menciona en el if es la tarea que se trae en la lista del pojo o objeto de la base de datos 
// 		for que recorra notificaciones	
//		if(notificaciones.id== tarea.id)
//		
	}
	

}
