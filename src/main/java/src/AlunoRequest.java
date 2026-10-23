package src;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AlunoRequest(
        @NotBlank @Size(max = 120) String nome,
        @NotBlank @Email @Size(max = 160) String email,
        @NotBlank @Size(max = 80) String login,
        @Pattern(regexp = "^$|^.{8,}$", message = "A senha deve ter pelo menos 8 caracteres.")
        String senha,
        @NotBlank
        @Pattern(regexp = "^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "Informe um CPF com 11 dígitos.")
        String cpf,
        @NotBlank @Size(max = 30) String rg,
        @NotBlank @Size(max = 200) String endereco,
        @NotBlank @Size(max = 120) String curso,
        @Positive int instituicaoId
) {
}
