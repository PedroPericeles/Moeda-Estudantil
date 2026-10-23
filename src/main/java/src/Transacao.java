package src;

import java.time.LocalDateTime;

public class Transacao {
    private int id;
    private LocalDateTime data;
    private int valor;
    private String tipo;
    private String motivo;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
