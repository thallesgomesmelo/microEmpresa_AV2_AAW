package com.microempresas.microEmpresa.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.microempresas.microEmpresa.api.MicroEmpresaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroEmpresa {
	@Id
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDate dataDeCadastro;
	
	public MicroEmpresa(MicroEmpresaDto me) {
		this.nome = me.getNome();
		this.cnpj = me.getCnpj();
		this.email = me.getEmail();
		this.dataDeCadastro = me.getDataDeCadastro();
	}
}
