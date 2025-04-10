package school.sptech.exemplo_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_relacionamento.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
