package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.ProfesssorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoService alunoservice;
	
	@Autowired
	ProfesssorService professsorService;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Rodrigo");
		alunoservice.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Thais");
		alunoservice.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Daniel");
		alunoservice.salvar(aluno3);
		
		List<Aluno> listaAluno = alunoservice.buscarTodosAlunos();
		
		for(Aluno aluno:listaAluno) {
			System.out.println(aluno.getNome());
		}
		
		Professor prof1 = new Professor();
		prof1.setNome("Johnny");
		professsorService.salvarProf(prof1);
		
		Professor prof2 = new Professor();
		prof2.setNome("Clayton");
		professsorService.salvarProf(prof2);
		
		Professor prof3 = new Professor();
		prof3.setNome("Marcelo");
		professsorService.salvarProf(prof3);
		
		List<Professor> listaProfessor = professsorService.buscarTodosProfessores();
		
		for(Professor professor:listaProfessor) {
			System.out.println(professor.getNome());
		}
	}
}
