package ifce.edu.br.MeuPrimeiroSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Aluno;
@Repository
public interface Alunos extends JpaRepository <Aluno, Long> {
	
	Optional<Aluno> findById(@Param("id") Long id);
	
	
	@Query("select a from Aluno a where a.email like :email")    
	Optional<Aluno> findByAlunoEmail(String email);

	
}
