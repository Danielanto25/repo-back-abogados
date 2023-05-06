package com.abogados.model.demandado;

import com.abogados.model.proceso.Proceso;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Demandado {
	
	private Integer id;
	private String demandado;
	private String docDemandado;
	private Proceso proceso;
	
	public Demandado(Integer id, String demandado, String docDemandado, Proceso proceso) {

		this.id = id;
		this.demandado = demandado;
		this.docDemandado = docDemandado;
		this.proceso = proceso;
	}
	
	public Demandado( String demandado, String docDemandado, Proceso proceso) {
		
		this.demandado = demandado;
		this.docDemandado = docDemandado;
		this.proceso = proceso;
	}

	public Demandado(Integer id, String demandado, String docDemandado) {
		this.id = id;
		this.demandado = demandado;
		this.docDemandado = docDemandado;
	}

}
