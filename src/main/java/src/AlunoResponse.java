package src;

public record AlunoResponse(
        Integer id,
        String nome,
        String email,
        String login,
        String cpf,
        String rg,
        String endereco,
        String curso,
        Integer instituicaoId
) {
    static AlunoResponse from(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getLogin(),
                aluno.getCpf(),
                aluno.getRg(),
                aluno.getEndereco(),
                aluno.getCurso(),
                aluno.getInstituicao().getId()
        );
    }
}
