package br.com.estudo.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.forum.dtos.TopicoDto;
import br.com.estudo.forum.model.Curso;
import br.com.estudo.forum.model.Topico;

@RestController
public class TopicosController {
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		
		Topico topico = Topico.builder()
				.titulo("Duvida")
				.mensagem("Duvida com Spring")
				.curso(Curso.builder()
						.nome("Spring")
						.categoria("Programação")
						.build())
				.build();
		
		// Uitilizando Arrays.asList para retornar uma lista com varios topicos
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		
		
		
	}

}
