package school.sptech.exemplo_relacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CursoListagemDto {
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}
