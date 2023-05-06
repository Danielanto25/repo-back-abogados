package com.abogados.service.impl;

import com.abogados.exception.ExcepcionArgumento;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.usuario.IUsuarioRepository;
import com.abogados.service.IUsuarioService;
import com.abogados.util.TokenHelperComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Service
public class UsuarioServiceImpl extends GeneralServiceImpl<Usuario, Integer> implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Autowired
	private TokenHelperComponent token;

    @Override
    protected GeneralRepo<Usuario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Usuario buscarUsuarioClaveEstadoPorUsuario(String username) {
        return repo.buscarUsuarioClaveEstadoPorUsuario(username);
    }

    @Override
    public List<String> buscarRolePorUsuario(String usuario) {
        return repo.buscarRolePorUsuario(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        validarClaveNORepetida(usuario.getPassword(), usuario.getId());
        this.repo.actualizar(usuario);

    }

    private void validarClaveNORepetida(String clave, Integer id) {
        Usuario usuario = this.repo.listarPorId(id);
        if (encoder.matches(clave, usuario.getPassword()))
            throw new ExcepcionArgumento("La contraseña que Ingreso no puede ser la misma ingresada anteriormente");

    }

	@Override
	public Usuario info(HttpServletRequest request) {

		String usuario = token.obtenerUsuarioDelToken(request.getHeader("Authorization"));

		return repo.info(usuario);	
	}
}
