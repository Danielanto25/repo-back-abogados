package com.abogados.repository.cliente;



import com.abogados.model.cliente.Cliente;
import com.abogados.repository.generico.GeneralRepo;

import java.util.List;

public interface IClienteRepository extends GeneralRepo<Cliente,Integer>{
	Cliente listarPorCliente(String cliente);

	void actualizarSinArchivo(Cliente json);

}
