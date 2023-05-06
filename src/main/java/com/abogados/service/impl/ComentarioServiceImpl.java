package com.abogados.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.comentario.Comentario;
import com.abogados.repository.comentario.IComentarioRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IComentarioService;

@Service

public class ComentarioServiceImpl extends GeneralServiceImpl<Comentario,Integer>  implements IComentarioService {
	
	@Autowired
	private IComentarioRepository repo;

	@Override
	protected GeneralRepo<Comentario,Integer> getRepo(){
		return repo;
	}

	@Override
	public Integer insertar(Comentario t) {
		// TODO Auto-generated method stub
		return repo.insertar(t);
	}

	@Override
	public void actualizar(Comentario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		repo.eliminar(id);
		
	}

	@Override
	public Comentario listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comentario> listarPorIdComentario(Integer id) {
		// TODO Auto-generated method stub
		return repo.listarPorIdComentario(id);
	}
}
