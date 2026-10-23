package src;

public class Professor extends Usuario {
    private String cpf;
    private String departamento;
    private int instituicaoId;

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public int getInstituicaoId() { return instituicaoId; }
    public void setInstituicaoId(int instituicaoId) { this.instituicaoId = instituicaoId; }
}