package com.microempresas.microEmpresa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microempresas.microEmpresa.entity.MicroEmpresa;

public interface MicroEmpresaRepository extends MongoRepository<MicroEmpresa, String> {

}
