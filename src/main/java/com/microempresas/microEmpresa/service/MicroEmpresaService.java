package com.microempresas.microEmpresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microempresas.microEmpresa.entity.MicroEmpresa;
import com.microempresas.microEmpresa.exception.NotFoundException;
import com.microempresas.microEmpresa.repository.MicroEmpresaRepository;

@Service
public class MicroEmpresaService {
	private final MicroEmpresaRepository microEmpresaRepository;
	
	public MicroEmpresaService(MicroEmpresaRepository microEmpresaRepository) {
		this.microEmpresaRepository = microEmpresaRepository;
	}
	
	public MicroEmpresa create(MicroEmpresa me) {
		microEmpresaRepository.save(me);
		return me;
	}
	
	public MicroEmpresa update(String id, MicroEmpresa me) {
		var existente = get(id);
		
		existente.setNome(me.getNome());
		existente.setCnpj(me.getCnpj());
		existente.setEmail(me.getEmail());
		existente.setDataDeCadastro(me.getDataDeCadastro());
		
		microEmpresaRepository.save(existente);
		return existente;
	}
	
	public MicroEmpresa get(String id) {
		var microEmpresa = microEmpresaRepository.findById(id);
		
		if(microEmpresa.isEmpty()) {
			throw new NotFoundException("Id " + id + " not found!");
		}
		return microEmpresa.get();
	}
	
	public List<MicroEmpresa> getAll() {
		return microEmpresaRepository.findAll();
	}
	
	public void delete(String id) {
		microEmpresaRepository.deleteById(id);
	}
}
