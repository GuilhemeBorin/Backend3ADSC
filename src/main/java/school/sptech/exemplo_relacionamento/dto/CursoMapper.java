package school.sptech.exemplo_relacionamento.dto;

import school.sptech.exemplo_relacionamento.entity.Curso;

public class CursoMapper {

    public static Curso transformarEmEntidade(CursoCadastroDto RequisicaoDto) {
        Curso entidadeCurso = new Curso();
        entidadeCurso.setNome(RequisicaoDto.getNome());
        entidadeCurso.setDescricao(RequisicaoDto.getDescricao());
        entidadeCurso.setPreco(RequisicaoDto.getPreco());
        entidadeCurso.setCategoria(RequisicaoDto.getCategoria());
        return entidadeCurso;
    }

    public static Curso transformarEmEntidade(CursoAtualizacaoDto RequisicaoDto) {
        Curso entidadeCursoParaAtualizar = new Curso();
        entidadeCursoParaAtualizar.setNome(RequisicaoDto.getNome());
        entidadeCursoParaAtualizar.setDescricao(RequisicaoDto.getDescricao());
        entidadeCursoParaAtualizar.setPreco(RequisicaoDto.getPreco());
        entidadeCursoParaAtualizar.setCategoria(RequisicaoDto.getCategoria());
        return entidadeCursoParaAtualizar;
    }

    public static CursoListagemDto transformarEmRespostaDTO(Curso entidadeResposta) {
        CursoListagemDto respostaEmDTO = new CursoListagemDto();
        respostaEmDTO.setNome(entidadeResposta.getNome());
        respostaEmDTO.setDescricao(entidadeResposta.getDescricao());
        respostaEmDTO.setPreco(entidadeResposta.getPreco());
        respostaEmDTO.setCategoria(entidadeResposta.getCategoria());
        return respostaEmDTO;
    }
}
