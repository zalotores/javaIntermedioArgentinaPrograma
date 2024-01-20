package com.mycompany.hibernateanotaciones2;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
// Defines the name of the table created for the entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_cliente", unique = true)
	private int cod_cliente;
	
	@Column(name = "nombre_cliente", nullable = false)
    private String nombre_cliente;

      /*  @ManyToOne(fetch = FetchType.LAZY)
        private Factura miFact;
        */
     /*    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
        @JoinColumn(name = "cod_cliente")
    private List<Factura> lista_factura;   
       */ 
        
    /**
     * @return the cod_cliente
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the nombre_cliente
     */
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    /**
     * @param nombre_cliente the nombre_cliente to set
     */
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    /**
     * @return the miFact
     */
  /*  public Factura getMiFact() {
        return miFact;
    }

    
    public void setMiFact(Factura miFact) {
        this.miFact = miFact;
    }
    */
}