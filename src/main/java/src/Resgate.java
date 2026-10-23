package src;

import java.time.LocalDateTime;

public class Resgate {
    private int id;
    private LocalDateTime data;
    private String codigoCupom;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public String getCodigoCupom() { return codigoCupom; }
    public void setCodigoCupom(String codigoCupom) { this.codigoCupom = codigoCupom; }
}
