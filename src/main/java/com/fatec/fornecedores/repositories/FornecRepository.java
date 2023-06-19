package com.fatec.fornecedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.fornecedores.entities.Fornec;

public interface FornecRepository extends JpaRepository <Fornec, Integer>{
    
}
