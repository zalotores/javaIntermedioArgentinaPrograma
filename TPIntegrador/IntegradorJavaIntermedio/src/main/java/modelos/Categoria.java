package modelos;

import javax.persistence.*;

@Entity
@Table(name = "categorias", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Categoria {
    private int id;
    private String descripcion;

    public Categoria() {
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
    @Column(name="descripcion", length=250, nullable=true)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
