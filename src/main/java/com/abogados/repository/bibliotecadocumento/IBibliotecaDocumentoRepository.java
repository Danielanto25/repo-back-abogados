package com.abogados.repository.bibliotecadocumento;



import java.util.List;

import com.abogados.model.bibliotecadocumento.BibliotecaDocumento;
import com.abogados.repository.generico.GeneralRepo;


public interface IBibliotecaDocumentoRepository extends GeneralRepo<BibliotecaDocumento,Integer>{

	List<BibliotecaDocumento> listarPorCliente(String cliente);

	void actualizarSinArchivo(BibliotecaDocumento json);
	
	List<BibliotecaDocumento> listarPorClienteId(Integer clienteId);
	
}
