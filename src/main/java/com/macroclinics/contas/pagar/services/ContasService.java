package com.macroclinics.contas.pagar.services;

import com.macroclinics.contas.pagar.domain.Contas;
import com.macroclinics.contas.pagar.domain.Fornecedor;
import com.macroclinics.contas.pagar.domain.dto.ContasRequestDto;
import com.macroclinics.contas.pagar.domain.repository.ContasRepository;
import com.macroclinics.contas.pagar.domain.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContasService {
    @Autowired
    private ContasRepository contasRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Contas cadastrar(ContasRequestDto request) {

        Contas contas = new Contas();
        contas.setDescricao(request.getDescricao());
        contas.setDataCompetencia(request.getDataCompetencia());
        contas.setDataVencimento(request.getDataVencimento());
        contas.setValor(request.getValor());
        contas.setDataPagamento(request.getDataPagamento());
        contas.setDesconto(request.getDesconto());
        contas.setJuros(request.getJuros());
        contas.setMulta(request.getMulta());
        contas.setValorPago(request.getValorPago());

        Fornecedor fornecedor = fornecedorRepository
                .findById(request.getFornecedorId())
                .orElseThrow(EntityNotFoundException::new);

        contas.setFornecedor(fornecedor);

        return contasRepository.save(contas);
    }
    public List<Contas> listar() {
        return contasRepository.findAll();
    }

    public Optional<Contas> visualizar(Integer id) {
        return contasRepository.findById(id);
    }
    @Transactional
    public void excluir(Contas contas) {
        contasRepository.delete(contas);
    }

    public Object salvar(Contas contas) {
        return contasRepository.save(contas);
    }
}


