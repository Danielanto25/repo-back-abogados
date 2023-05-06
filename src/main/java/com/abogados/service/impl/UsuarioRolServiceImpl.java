package com.abogados.service.impl;

import com.abogados.model.usuario.UsuarioRol;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.usuariorol.IUsuarioRolRepository;
import com.abogados.service.IUsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl extends GeneralServiceImpl<UsuarioRol, Integer> implements IUsuarioRolService {

    @Autowired
    IUsuarioRolRepository repo;

    @Override
    protected GeneralRepo<UsuarioRol, Integer> getRepo() { return repo; }

}
