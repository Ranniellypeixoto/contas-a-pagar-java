package com.macroclinics.contas.pagar.controllers;


import com.macroclinics.contas.pagar.domain.Fornecedor;
import com.macroclinics.contas.pagar.domain.dto.FornecedorRequestDto;
import com.macroclinics.contas.pagar.services.FornecedorService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Api(tags = "Fornecedores")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrar(@RequestBody @Valid FornecedorRequestDto request){
        return  ResponseEntity.ok(service.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listar() {
        List<Fornecedor> meusFornecedores = service.listar();
        return ResponseEntity.ok(meusFornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> visualizar(@PathVariable(value = "id")Integer id) {
        Optional<Fornecedor> meuFornecedorOpitional = service.visualizar(id);
        if (!meuFornecedorOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(meuFornecedorOpitional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable(value = "id") Integer id,
                                                    @RequestBody @Valid FornecedorRequestDto fornecedorRequestDto){
        Optional<Fornecedor> fornecedorOptional = service.visualizar(id);
        if (!fornecedorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        var fornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorRequestDto, fornecedor);
        fornecedor.setId(fornecedorOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Integer id){
        Optional<Fornecedor> meuFornecedorOpitional = service.visualizar(id);
        if (!meuFornecedorOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        service.excluir(meuFornecedorOpitional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor excluído com sucesso.");
    }

}
