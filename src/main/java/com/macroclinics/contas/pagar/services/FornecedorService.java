package com.macroclinics.contas.pagar.services;

import com.macroclinics.contas.pagar.domain.Fornecedor;
import com.macroclinics.contas.pagar.domain.dto.FornecedorRequestDto;
import com.macroclinics.contas.pagar.domain.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor cadastrar(FornecedorRequestDto request) {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(request.getNome());
        fornecedor.setCnpj_cpf(request.getCnpj_cpf());
        fornecedor.setSituacao(request.getSituacao());

        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> visualizar(Integer id) {
        return fornecedorRepository.findById(id);
    }

    @Transactional
    public void excluir(Fornecedor fornecedor) {
        fornecedorRepository.delete(fornecedor);
    }

    public Object salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }
}