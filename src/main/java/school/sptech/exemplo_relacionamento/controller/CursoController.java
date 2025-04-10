package school.sptech.exemplo_relacionamento.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_relacionamento.dto.CursoAtualizacaoDto;
import school.sptech.exemplo_relacionamento.dto.CursoCadastroDto;
import school.sptech.exemplo_relacionamento.dto.CursoListagemDto;
import school.sptech.exemplo_relacionamento.dto.CursoMapper;
import school.sptech.exemplo_relacionamento.entity.Curso;
import school.sptech.exemplo_relacionamento.service.CursoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoListagemDto>> listagem() {
        List<Curso> buscarCursos = cursoService.listarTodosCursos();

        if (buscarCursos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<CursoListagemDto> respostaCursosDto = new ArrayList<>();

        for (int i = 0; i < buscarCursos.size(); i++) {
            respostaCursosDto.add(CursoMapper.transformarEmRespostaDTO(buscarCursos.get(i)));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(respostaCursosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoListagemDto> listagemId(@PathVariable Integer id) {
        Optional<Curso> cursoEncontrado = cursoService.buscarCursoPorId(id);

        if (cursoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        CursoListagemDto respostaCursoDTO = CursoMapper.transformarEmRespostaDTO(cursoEncontrado.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(respostaCursoDTO);
    }

    @PostMapping
    public ResponseEntity<CursoListagemDto> cadastrar(@Valid @RequestBody CursoCadastroDto cursoParaCadastro) {
        Curso novoCurso = cursoService.cadastrarNovoCurso(CursoMapper.transformarEmEntidade(cursoParaCadastro));

        CursoListagemDto respostaCursoDto = CursoMapper.transformarEmRespostaDTO(novoCurso);

        return ResponseEntity.status(HttpStatus.CREATED).body(respostaCursoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoListagemDto> atualizar(@PathVariable Integer id, @Valid @RequestBody CursoAtualizacaoDto cursoAtualizar) {
        Optional<Curso> cursoParaAtualizar = cursoService.atualizarCurso(id, CursoMapper.transformarEmEntidade(cursoAtualizar));

        CursoListagemDto cursoAtualizado = CursoMapper.transformarEmRespostaDTO(cursoParaAtualizar.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/media-preco")
    public ResponseEntity<Double> getMedia(){
        return ResponseEntity.status(200).body(CursoService.buscarMedia());
    }

    @GetMapping("/preco/menor-que")
    public ResponseEntity<List<Curso>> getValorMenor(@RequestParam Double valor){
        return ResponseEntity.status(200).body(cursoService.buscarPorPrecoMenorQue(valor));
    }

    @DeleteMapping("/preco/menor-que")
    public ResponseEntity<Void> deleteByValor(@RequestParam Double valor){
        cursoService.deleteByValor(valor);
       return ResponseEntity.status(200).build();
    }
}
