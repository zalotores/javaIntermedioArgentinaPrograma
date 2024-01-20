package modelos;
import javax.persistence.*;

@Entity
@Table(name = "tecnicos", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Tecnico {
    private int id;
    private String nombre;

    public Tecnico() {
    }

    //getters and setters

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true, length=11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="nombre", length=250, nullable=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
