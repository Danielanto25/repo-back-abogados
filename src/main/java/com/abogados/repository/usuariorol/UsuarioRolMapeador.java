package com.abogados.repository.usuariorol;

import com.abogados.model.usuario.Rol;
import com.abogados.model.usuario.Usuario;
import com.abogados.model.usuario.UsuarioRol;
import com.abogados.repository.rol.IRolRepository;
import com.abogados.repository.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UsuarioRolMapeador implements RowMapper<UsuarioRol> {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Autowired
    private IRolRepository rolRepo;

    @Override
    public UsuarioRol mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("usr_id");
        Usuario usuario = usuarioRepo.listarPorId(rs.getInt("usu_id"));
        Rol rol = rolRepo.listarPorId(rs.getInt("rol_id"));

        return new UsuarioRol(id, usuario, rol);
    }
}
