package com.microempresas.microEmpresa.api;

import java.time.LocalDate;
import com.microempresas.microEmpresa.entity.MicroEmpresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroEmpresaDto {
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDate dataDeCadastro;
	
	public MicroEmpresaDto(MicroEmpresa me) {
		this.id = me.getId();
		this.nome = me.getNome();
		this.cnpj = me.getCnpj();
		this.email = me.getEmail();
		this.dataDeCadastro = me.getDataDeCadastro();		
	}
}
