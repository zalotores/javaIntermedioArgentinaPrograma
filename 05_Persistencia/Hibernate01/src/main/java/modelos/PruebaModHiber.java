package modelos;


import javax.persistence.*;

@Entity
@Table(name = "prueba_hibernate")
public class PruebaModHiber {
    private int id;
    private String atributo;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
}
