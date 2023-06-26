package com.ruan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruan.helpdesk.domain.Chamado;
import com.ruan.helpdesk.domain.Cliente;
import com.ruan.helpdesk.domain.Tecnico;
import com.ruan.helpdesk.domain.enums.Perfil;
import com.ruan.helpdesk.domain.enums.Prioridade;
import com.ruan.helpdesk.domain.enums.Status;
import com.ruan.helpdesk.repository.ChamadoRepository;
import com.ruan.helpdesk.repository.ClienteRepository;
import com.ruan.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {

	// Fazer com que o Spring adicione os dados do método run automaticamente no BD H2:
		@Autowired
		private TecnicoRepository tecnicoRepository;
		@Autowired
		private ClienteRepository clienteRepository;
		@Autowired
		private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Ruan Gemmer", "63653230268", "ruan@teste.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "José da Silva", "80527954780", "jose@teste.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 001", "Primeiro Chamado", tec1,
				cli1);
		
		Tecnico tec2 = new Tecnico(null, "Linus Torvals", "11111111111", "torvals@teste.com", "123");
		tec2.addPerfil(Perfil.TECNICO);

		Cliente cli2 = new Cliente(null, "João Antonio de Souza", "22222222222", "joao@teste.com", "123");

		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 002", "Segundo Chamado", tec1,
				cli2);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		chamadoRepository.saveAll(Arrays.asList(c1, c2));

	}
}
