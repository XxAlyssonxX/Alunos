package com.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.entities.Alunos;
import com.alunos.sevices.AlunosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Alunos")
@CrossOrigin(origins = "*")
public class AlunosController {

	private final AlunosService AlunosService;

	@Autowired
	public AlunosController(AlunosService AlunosService) {
		this.AlunosService = AlunosService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alunos> buscaAlunosControlId(@PathVariable Long id) {
		Alunos Alunos = AlunosService.getAlunosById(id);
		if (Alunos != null) {
			return ResponseEntity.ok(Alunos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Alunos>> buscaTodasLigacoesControl() {
		List<Alunos> Alunos = AlunosService.getAllAlunoss();
		return ResponseEntity.ok(Alunos);
	}

	@PostMapping
	public ResponseEntity<Alunos> saveAlunosControl(@RequestBody @Valid Alunos Alunos) {
		Alunos saveAlunos = AlunosService.saveAlunos(Alunos);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAlunos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alunos> alteraAlunosControl(@PathVariable Long id, @RequestBody @Valid Alunos Alunos) {
		Alunos alteraAlunos = AlunosService.changeAlunos(id, Alunos);

		if (alteraAlunos != null) {
			return ResponseEntity.ok(Alunos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAlunosControl(@PathVariable Long id) {
		boolean delete = AlunosService.deleteAlunos(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}