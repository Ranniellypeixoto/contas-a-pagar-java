package com.macroclinics.contas.pagar.domain.repository;

import com.macroclinics.contas.pagar.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    List<Fornecedor> findAll();

}
