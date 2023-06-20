package com.fatec.fornecedores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fornecedores.entities.Fornec;
import com.fatec.fornecedores.repositories.FornecRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecService {

    @Autowired
    private FornecRepository fornecRepository;

    public Fornec getFornecById(int id) {
        return fornecRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrado!!!")
        );
    }

    public List<Fornec> getFornecs() {
        return fornecRepository.findAll();
    }

    public Fornec save(Fornec fornec) {
        return fornecRepository.save(fornec);
    }

    public void update(int id, Fornec fornec) {
        getFornecById(id);
        fornecRepository.save(fornec);
    }

    public void deleteById(int id) {
        Fornec fornec = getFornecById(id);
        fornecRepository.delete(fornec);
    }
    
}
