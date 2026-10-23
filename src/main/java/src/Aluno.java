package src;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "alunos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_aluno_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_aluno_login", columnNames = "login"),
        @UniqueConstraint(name = "uk_aluno_cpf", columnNames = "cpf"),
        @UniqueConstraint(name = "uk_aluno_rg", columnNames = "rg")
})
public class Aluno extends Usuario {
    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 30)
    private String rg;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false, length = 120)
    private String curso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instituicao_id", nullable = false)
    private Instituicao instituicao;

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public Instituicao getInstituicao() { return instituicao; }
    public void setInstituicao(Instituicao instituicao) { this.instituicao = instituicao; }
}
