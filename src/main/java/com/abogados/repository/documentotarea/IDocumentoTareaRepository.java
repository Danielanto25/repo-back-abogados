package com.abogados.repository.documentotarea;



import com.abogados.model.documentotarea.DocumentoTarea;
import com.abogados.repository.generico.GeneralRepo;

public interface IDocumentoTareaRepository extends GeneralRepo<DocumentoTarea,Integer>{

	void actualizarSinArchivo(DocumentoTarea documentoTarea);

}
