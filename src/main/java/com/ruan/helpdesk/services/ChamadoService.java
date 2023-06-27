package com.ruan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruan.helpdesk.domain.Chamado;
import com.ruan.helpdesk.repository.ChamadoRepository;
import com.ruan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById (Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}
}
