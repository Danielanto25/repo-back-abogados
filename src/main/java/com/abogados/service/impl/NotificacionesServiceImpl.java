package com.abogados.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abogados.model.notificaciones.Notificaciones;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.notificaciones.INotificacionesRepository;
import com.abogados.service.INotificacionesService;

public class NotificacionesServiceImpl extends GeneralServiceImpl<Notificaciones,Integer> implements INotificacionesService {

	@Autowired
	private INotificacionesRepository repo;
	
	
	@Override
	protected GeneralRepo<Notificaciones, Integer> getRepo() {
		return repo;
	}
	
	

}
