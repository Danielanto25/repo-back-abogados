package com.abogados.repository.usuario;


import java.util.List;

import com.abogados.model.usuario.Usuario;
import com.abogados.repository.generico.GeneralRepo;

public interface IUsuarioRepository extends GeneralRepo<Usuario,Integer>{

	Usuario buscarUsuarioClaveEstadoPorUsuario(String username);

	List<String> buscarRolePorUsuario(String usuario);
	
	Usuario info(String usuario);

	List<Usuario> listarSinCliente();

}
