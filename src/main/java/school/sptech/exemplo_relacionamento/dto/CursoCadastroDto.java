package school.sptech.exemplo_relacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoCadastroDto {
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;


}
