package school.sptech.exemplo_relacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_relacionamento.entity.Aluno;
import school.sptech.exemplo_relacionamento.repository.AlunoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public List<Aluno> buscarPorNomeCurso(String nome){
        return repository.findByCursoNomeContainingIgnoreCase(nome);
    }

}
