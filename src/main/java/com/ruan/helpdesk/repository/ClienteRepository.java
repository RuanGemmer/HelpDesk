package com.ruan.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruan.helpdesk.domain.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
