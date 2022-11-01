package com.macroclinics.contas.pagar.controllers;


import com.macroclinics.contas.pagar.domain.Contas;
import com.macroclinics.contas.pagar.domain.Fornecedor;
import com.macroclinics.contas.pagar.domain.dto.ContasRequestDto;
import com.macroclinics.contas.pagar.domain.repository.FornecedorRepository;
import com.macroclinics.contas.pagar.services.ContasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/contas")
@Api(tags = "Contas")
public class ContasController {

    @Autowired
    private ContasService service;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    @ApiOperation(value = "cadastrar")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public ResponseEntity<Contas> cadastrar(@RequestBody @Valid ContasRequestDto request){
        return ResponseEntity.ok(service.cadastrar(request));
    }

    @GetMapping
    @ApiOperation(value = "listar")
    @ApiResponses(
            value = {@ApiResponse(code = 200, message = "?")}
    )
    public ResponseEntity<List<Contas>> listar() {
        List<Contas> minhasContas = service.listar();
        return ResponseEntity.ok(minhasContas);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Visualiza conta"),
            @ApiResponse(code = 404, message = "Registro não localizado")
    })
    public ResponseEntity<Object> visualizar(@PathVariable(value = "id")Integer id) {
        Optional<Contas> minhaContaOpitional = service.visualizar(id);
        if (!minhaContaOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(minhaContaOpitional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable(value = "id") Integer id,
                                          @RequestBody @Valid ContasRequestDto contasRequestDto){
        Optional<Contas> contasOptional = service.visualizar(id);
        if (!contasOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
        }
        var contas = new Contas();
        Fornecedor fornecedor = fornecedorRepository
                .findById(contasRequestDto.getFornecedorId())
                .orElseThrow(EntityNotFoundException::new);
        contas.setFornecedor(fornecedor);

        BeanUtils.copyProperties(contasRequestDto, contas);
        contas.setId(contasOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(contas));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id")Integer id){
        Optional<Contas> minhaContaOpitional = service.visualizar(id);
        if (!minhaContaOpitional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrado.");
        }
        service.excluir(minhaContaOpitional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta excluída com sucesso.");
        }
    }

