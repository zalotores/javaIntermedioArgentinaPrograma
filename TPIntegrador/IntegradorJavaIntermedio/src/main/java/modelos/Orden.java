package modelos;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ordenes", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Orden {
    private int id;
    private String descripcion;
    private String costo;
    private Date fecha;
    private String estado;
    private int idCliente;
    private int idCategoria;
    private int idTecnico;

    public Orden() {
    }

    //getters y setters

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
    @Column(name="costo", length=250, nullable=true)
    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    @Column(name="fecha_orden", length=250, nullable=true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @Column(name="estado", length=250, nullable=true)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Column(name="id_cliente", length=250, nullable=true)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    @Column(name="id_categoria", length=250, nullable=true)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    @Column(name="id_tecnico", length=250, nullable=true)
    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }
}
