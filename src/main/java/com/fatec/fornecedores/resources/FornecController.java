package com.fatec.fornecedores.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.fornecedores.entities.Fornec;
import com.fatec.fornecedores.services.FornecService;

@RestController
@RequestMapping("fornecedores")
@CrossOrigin
public class FornecController {
    
    @Autowired
    private FornecService fornecService;

    @GetMapping("{id}")
    public ResponseEntity<Fornec> getFornec(@PathVariable int id){
        Fornec fornec = fornecService.getFornecById(id);
        return ResponseEntity.ok().body(fornec);
    }

    @GetMapping
    public ResponseEntity<List<Fornec>> getFornecs(){
        List<Fornec> fornecs = fornecService.getFornecs();
        return ResponseEntity.ok().body(fornecs);
    }

    @PostMapping
    public ResponseEntity<Fornec> serveFornec(@RequestBody Fornec fornec){
        Fornec newFornec = fornecService.save(fornec);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fornec.getId())
                .toUri();

        return ResponseEntity.created(location).body(newFornec);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editFornec(@PathVariable int id, @RequestBody Fornec fornec){
        fornecService.update(id, fornec);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFornec(@PathVariable int id){
        fornecService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
