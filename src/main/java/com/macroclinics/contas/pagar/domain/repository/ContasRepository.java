package com.macroclinics.contas.pagar.domain.repository;


import com.macroclinics.contas.pagar.domain.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContasRepository extends JpaRepository<Contas, Integer> {

    List<Contas> findAll();
}
