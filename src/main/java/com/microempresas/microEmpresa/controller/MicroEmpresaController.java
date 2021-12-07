package com.microempresas.microEmpresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microempresas.microEmpresa.api.MicroEmpresaDto;
import com.microempresas.microEmpresa.entity.MicroEmpresa;
import com.microempresas.microEmpresa.service.MicroEmpresaService;

@RestController
public class MicroEmpresaController {
	private final MicroEmpresaService microEmpresaService;
	
	public MicroEmpresaController(MicroEmpresaService microEmpresaService) {
		this.microEmpresaService = microEmpresaService;
	}
	
	@GetMapping("/microempresas/{id}")
	public MicroEmpresaDto getById(@PathVariable String id) {
		var empresa = microEmpresaService.get(id);
		
		return new MicroEmpresaDto(empresa);
	}
	
	@GetMapping("/microempresas")
	public List<MicroEmpresaDto> getAll() {
		var empresas = microEmpresaService.getAll();
		var empresaDtos = new ArrayList<MicroEmpresaDto>();
		
		for(var empresa: empresas) {
			empresaDtos.add(new MicroEmpresaDto(empresa));
		}
		return empresaDtos;
	}
	
	@PostMapping("/microempresas")
	public MicroEmpresaDto create(@RequestBody MicroEmpresaDto me) {
		var empresa = new MicroEmpresa(me);
		
		empresa = microEmpresaService.create(empresa);
		
		return new MicroEmpresaDto(empresa);
	}
	
	@PutMapping("/microempresas/{id}")
	public MicroEmpresaDto update(@PathVariable String id, @RequestBody MicroEmpresaDto me) {
		var empresa = new MicroEmpresa(me);
		
		empresa = microEmpresaService.update(id, empresa);
		
		return new MicroEmpresaDto(empresa);
	}
	
	@DeleteMapping("/microempresas/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		microEmpresaService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
