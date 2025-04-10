package school.sptech.exemplo_relacionamento.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.sptech.exemplo_relacionamento.entity.Curso;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    /*
    *  1 - Buscadores dinamicos (Jpa query methods)
    *  2 - JPQL @Query (Se preciso de mais controle)
    *  3 - Specification (Preciso fazer mais Join)
    *  4 - Query native (CUIDADO) (Se Specification não for tão preciso)
    * */

    //JPQL - Java Persistence Query Language
    //Estratégia para fazer consulta SQL orientada a objeto, é do JAVA, apesar de parecer do SQL
    @Query("SELECT AVG(c.preco) FROM Curso c")
    Double buscarMedia();

    @Query("SELECT c FROM Curso c WHERE c.preco < :valor")
    List<Curso> buscarCursosComValorMenorQue(double valor);

    @Modifying //Deixar claro que tem pretenção de alterar o dado
    @Transactional //ação que precisa ser confirmada para ocorrer
    @Query("DELETE FROM Curso c WHERE c.preco < :valor")
    void deleteByValor(double valor);

}
