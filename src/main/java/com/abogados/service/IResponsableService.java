package com.abogados.service;


import java.util.List;

import com.abogados.model.responsable.Responsable;

public interface IResponsableService extends IGeneralService< Responsable,Integer>{

	List<Responsable> listarPorIdAgendarTarea(Integer id);

}