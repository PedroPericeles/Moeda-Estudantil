package src;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "empresas", uniqueConstraints = {
        @UniqueConstraint(name = "uk_empresa_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_empresa_login", columnNames = "login"),
        @UniqueConstraint(name = "uk_empresa_cnpj", columnNames = "cnpj")
})
public class EmpresaParceira extends Usuario {
    @Column(nullable = false, length = 14)
    private String cnpj;

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
