package modelos;

import javax.persistence.*;

/*
- javax.persistence.Entity annotation is used to mark a class as Entity bean that can be
  persisted by hibernate, since hibernate provides JPA implementation.
- javax.persistence.Table annotation is used to define the table mapping and unique constraints
  for the columns.
- javax.persistence.Id annotation is used to define the primary key for the table.
- javax.persistence.GeneratedValue is used to define that the field will be auto generated and
- GenerationType.IDENTITY strategy is used so that the generated “id” value is mapped to the
  bean and can be retrieved in the java program.
- javax.persistence.Column is used to map the field with table column, we can also specify
  length, nullable and uniqueness for the bean properties.
 */

@Entity
@Table(name = "canciones", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Cancion {

    private int id;
    private String nombre;
    private String duracion;
    private String interprete;
    private String genero;
    private String disco;

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

    @Column(name="nombre", length=50, nullable=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="duracion", length=50, nullable=true)
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Column(name="interprete_id", length=50, nullable=true)
    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    @Column(name="genero_id", length=50, nullable=true)
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name="disco_id", length=50, nullable=true)
    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    //metodos

}
