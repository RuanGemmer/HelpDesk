package com.ruan.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruan.helpdesk.domain.Chamado;

public interface ChamadoRepository  extends JpaRepository<Chamado, Integer>{

}
