package school.sptech.exemplo_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_relacionamento.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
