package com.macroclinics.contas.pagar.controllers;


import com.macroclinics.contas.pagar.domain.Contas;
import com.macroclinics.contas.pagar.domain.Fornecedor;
import com.macroclinics.contas.pagar.domain.dto.ContasRequestDto;
import com.macroclinics.contas.pagar.services.ContasService;
import com.macroclinics.contas.pagar.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/contas")
public class ContasController {

    @Autowired
    private ContasService service;

    @PostMapping
    public ResponseEntity<Contas> cadastrar(@RequestBody @Valid ContasRequestDto request){
        return ResponseEntity.ok(service.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<Contas>> listar() {
        List<Contas> minhasContas = service.listar();
        return ResponseEntity.ok(minhasContas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> visualizar(@PathVariable(value = "id")Integer id) {
        Optional<Contas> minhaContaOpitional = service.visualizar(id);
        if (!minhaContaOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(minhaContaOpitional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id")Integer id){
        Optional<Contas> minhaContaOpitional = service.visualizar(id);
        if (!minhaContaOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrado.");
        }
        service.delete(minhaContaOpitional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta excluída com sucesso.");
        }
    }

