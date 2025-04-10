package school.sptech.exemplo_relacionamento.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ra;
    private String nome;

    @ManyToOne
    private Curso curso;
}
