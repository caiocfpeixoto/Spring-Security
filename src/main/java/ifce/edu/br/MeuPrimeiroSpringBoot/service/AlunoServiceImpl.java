package ifce.edu.br.MeuPrimeiroSpringBoot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Aluno;
import ifce.edu.br.MeuPrimeiroSpringBoot.repository.Alunos;

@Service
@Transactional(readOnly = false)
public class AlunoServiceImpl implements AlunoService{
	
	@Autowired
	private Alunos repository;
		
	@Transactional(readOnly = false)
	public void salvar (Aluno a) {
		repository.save(a);	
	}
	
	public List<Aluno> buscarTodos() {
		return repository.findAll();
	}
	
	public Aluno buscarPorId(Long id) {
		return repository.getById(id);
		
	}

	public void editar(Aluno aluno) {
		repository.save(aluno);
		
	}

	public void excluir(Aluno aluno) {
		repository.delete(aluno);
		
		
	}

}
