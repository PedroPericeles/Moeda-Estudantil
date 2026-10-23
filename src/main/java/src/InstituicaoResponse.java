package src;

public record InstituicaoResponse(Integer id, String nome) {
    static InstituicaoResponse from(Instituicao instituicao) {
        return new InstituicaoResponse(instituicao.getId(), instituicao.getNome());
    }
}
