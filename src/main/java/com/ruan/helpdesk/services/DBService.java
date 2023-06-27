package com.ruan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ruan.helpdesk.domain.Chamado;
import com.ruan.helpdesk.domain.Cliente;
import com.ruan.helpdesk.domain.Tecnico;
import com.ruan.helpdesk.domain.enums.Perfil;
import com.ruan.helpdesk.domain.enums.Prioridade;
import com.ruan.helpdesk.domain.enums.Status;
import com.ruan.helpdesk.repository.ChamadoRepository;
import com.ruan.helpdesk.repository.PessoaRepository;

@Service
public class DBService {

		// Fazer com que o Spring adicione os dados do método run automaticamente no BD H2:
		@Autowired
		private PessoaRepository pessoaRepository;
		@Autowired
		private ChamadoRepository chamadoRepository;
		
		//Para criptografar a senha
		@Autowired
		private BCryptPasswordEncoder encoder;
		
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Ruan Gemmer", "903.347.070-56", "ruan@teste.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "José da Silva", "271.068.470-54", "jose@teste.com", encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 001", "Primeiro Chamado", tec1,
				cli1);
		
		Tecnico tec2 = new Tecnico(null, "Linus Torvals", "162.720.120-39", "torvals@teste.com", encoder.encode("123"));
		tec2.addPerfil(Perfil.TECNICO);

		Cliente cli2 = new Cliente(null, "João Antonio de Souza", "778.556.170-27", "joao@teste.com", encoder.encode("123"));

		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 002", "Segundo Chamado", tec1,
				cli2);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, cli1, cli2));
		chamadoRepository.saveAll(Arrays.asList(c1, c2));

	}
}
