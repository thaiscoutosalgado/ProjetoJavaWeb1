package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Professor;

import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfesssorService {
	
	@Autowired
	ProfessorRepository repoProfessor;
	
	public List<Professor> buscarTodosProfessores(){
		return repoProfessor.findAll();
	}
	
	public Professor salvarProf(Professor professor) {
		return repoProfessor.save(professor);
	}
}
