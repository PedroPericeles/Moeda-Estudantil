package src;

public record EmpresaResponse(Integer id, String nome, String email, String login, String cnpj) {
    static EmpresaResponse from(EmpresaParceira empresa) {
        return new EmpresaResponse(
                empresa.getId(),
                empresa.getNome(),
                empresa.getEmail(),
                empresa.getLogin(),
                empresa.getCnpj()
        );
    }
}
