package school.sptech.exemplo_relacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.exemplo_relacionamento.entity.Aluno;
import school.sptech.exemplo_relacionamento.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = service.listar();

        if (alunos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.ok(alunos);
    }

}
