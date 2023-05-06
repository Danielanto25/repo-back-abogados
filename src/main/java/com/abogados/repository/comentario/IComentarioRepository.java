package com.abogados.repository.comentario;



import java.util.List;

import com.abogados.model.comentario.Comentario;
import com.abogados.repository.generico.GeneralRepo;

public interface IComentarioRepository extends GeneralRepo<Comentario,Integer>{

	List<Comentario> listarPorIdComentario(Integer id);
}
