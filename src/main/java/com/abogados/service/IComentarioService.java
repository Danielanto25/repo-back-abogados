package com.abogados.service;

import java.util.List;
import com.abogados.model.comentario.Comentario;

public interface IComentarioService extends IGeneralService<Comentario,Integer>{

	List<Comentario> listarPorIdComentario(Integer id);
}
