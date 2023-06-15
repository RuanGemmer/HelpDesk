package com.ruan.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruan.helpdesk.domain.Tecnico;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer>{

}
