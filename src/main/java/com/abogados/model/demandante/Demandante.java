package com.abogados.model.demandante;

import com.abogados.model.proceso.Proceso;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Demandante {
	
	private Integer id;
	private String demandante;
	private String docDemandante;
	private Proceso proceso;
	
	public Demandante(Integer id, String demandante,String docDemandante, Proceso proceso) {

		this.id = id;
		this.demandante = demandante;
		this.docDemandante = docDemandante;
		this.proceso = proceso;
	}
	
	public Demandante( String demandante,  String docDemandante, Proceso proceso) {
		
		this.demandante = demandante;
		this.docDemandante = docDemandante;
		this.proceso = proceso;
	}

	public Demandante(Integer id, String demandante,  String docDemandante) {
		this.id = id;
		this.demandante = demandante;
		this.docDemandante = docDemandante;
	}

}
