package src;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmpresaRequest(
        @NotBlank @Size(max = 120) String nome,
        @NotBlank @Email @Size(max = 160) String email,
        @NotBlank @Size(max = 80) String login,
        @Pattern(regexp = "^$|^.{8,}$", message = "A senha deve ter pelo menos 8 caracteres.")
        String senha,
        @NotBlank
        @Pattern(regexp = "^(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$", message = "Informe um CNPJ com 14 dígitos.")
        String cnpj
) {
}
