package com.ruan.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruan.helpdesk.domain.Pessoa;

public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

}
