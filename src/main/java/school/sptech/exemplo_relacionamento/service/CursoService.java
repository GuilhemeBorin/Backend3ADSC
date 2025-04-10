package school.sptech.exemplo_relacionamento.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_relacionamento.entity.Curso;
import school.sptech.exemplo_relacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.exemplo_relacionamento.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<Curso> listarTodosCursos() {
    return cursoRepository.findAll();
    }

    public Optional<Curso> buscarCursoPorId(Integer id) {
        Optional<Curso> cursoEncontrado = cursoRepository.findById(id);
        if (cursoEncontrado.isEmpty()) {
        throw new EntidadeNaoEncontradaException();
        }

        return cursoEncontrado;
    }

    public Optional<Curso> atualizarCurso(Integer id, Curso cursoParaAtualizar) {
        Optional<Curso> cursoEncontrado = cursoRepository.findById(id);

        if (cursoEncontrado.isEmpty()) {
            throw new EntidadeNaoEncontradaException();
        }

        Curso cursoAtualizado = cursoEncontrado.get();
        cursoAtualizado.setId(cursoAtualizado.getId());
        cursoAtualizado.setDescricao(cursoParaAtualizar.getDescricao());
        cursoAtualizado.setNome(cursoParaAtualizar.getNome());
        cursoAtualizado.setCategoria(cursoParaAtualizar.getCategoria());
        cursoAtualizado.setPreco(cursoParaAtualizar.getPreco());

        return Optional.of(cursoRepository.save(cursoAtualizado));
    }

    public Curso cadastrarNovoCurso(Curso cursoParaCadastro){
        cursoParaCadastro.setId(cursoParaCadastro.getId());
        return cursoRepository.save(cursoParaCadastro);
    }

    public void deletarCurso(Integer id) {
        Optional<Curso> cursoEncontrado = cursoRepository.findById(id);

        if (cursoEncontrado.isEmpty()) {
        throw new EntidadeNaoEncontradaException();
        }

        cursoRepository.deleteById(id);
    }

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
}
