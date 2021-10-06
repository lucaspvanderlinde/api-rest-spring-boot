package br.com.estudo.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estudo.forum.dtos.TopicoDto;
import br.com.estudo.forum.model.Topico;
import br.com.estudo.forum.service.TopicoService;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoService topicoService;
	
	@GetMapping
	public ResponseEntity<List<TopicoDto>> lista() {
		List<TopicoDto> topicos = TopicoDto.converter(topicoService.findAll());
		return ResponseEntity.ok(topicos);
	}
	
	@PostMapping
	public ResponseEntity<Topico>cadastrar(@RequestBody @Valid Topico topico, UriComponentsBuilder uriBuilder) {
		topicoService.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(topico);
	}

}
