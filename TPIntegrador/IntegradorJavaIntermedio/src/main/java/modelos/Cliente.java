package modelos;

import javax.persistence.*;

@Entity
@Table(name = "clientes", uniqueConstraints={@UniqueConstraint(columnNames={"dni"})})
public class Cliente {
    private int dni;
    private String nombre;
    private String direccion;
    private String mail;

    public Cliente() {
    }

    //constructor para no repetir dni
    public Cliente(int dni) {
        this.dni = dni;
    }


    //getters y setters

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="dni", nullable=false, unique=true, length=11)
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    @Column(name="nombre", length=250, nullable=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name="direccion", length=250, nullable=true)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Column(name="mail", length=250, nullable=true)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
