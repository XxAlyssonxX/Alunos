package com.alunos.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alunos.entities.Alunos;
import com.alunos.repository.AlunosRepository;

@Service
public class AlunosService {
	private final AlunosRepository AlunosRepository;
	

	@Autowired
	public AlunosService(AlunosRepository AlunosRepository) {
		this.AlunosRepository = AlunosRepository;
	}

	public List<Alunos> getAllAlunoss() {
		return AlunosRepository.findAll();
	}

	public Alunos getAlunosById(Long id) {
		Optional<Alunos> Alunos = AlunosRepository.findById(id);
		return Alunos.orElse(null);
	}

	public Alunos saveAlunos(Alunos Alunos) {
		return AlunosRepository.save(Alunos);
	}

	public Alunos changeAlunos(Long id, Alunos changeU) {
		Optional<Alunos> existeAlunos = AlunosRepository.findById(id);
		if (existeAlunos.isPresent()) {
			changeU.setId(id);
			return AlunosRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteAlunos(Long id) {
		Optional<Alunos> existeAlunos= AlunosRepository.findById(id);
		if (existeAlunos.isPresent()) {
			AlunosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

