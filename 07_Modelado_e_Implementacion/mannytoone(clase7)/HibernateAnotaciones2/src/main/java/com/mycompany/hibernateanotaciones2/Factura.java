package com.mycompany.hibernateanotaciones2;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esteban
 */
@Entity
// Defines the name of the table created for the entity
@Table(name = "Factura")
public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_factura", unique = true)
	private int cod_factura;
	
	@Column(name = "desc_factura", nullable = false)
    private String descripcion_factura;
    
        @Column(name = "monto_total_factura", nullable = false)
    private int monto_total;    
        
      /*OK
        @OneToMany(cascade= CascadeType.MERGE, orphanRemoval=true)
        @JoinColumn(name = "id_factura_cliente")
    private List<Cliente> lista_cliente;    
        */
        
        @ManyToOne(cascade= CascadeType.ALL)
        @JoinColumn(name = "id_cliente_factura")
    private Cliente cli;  
        
        public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public String getDescripcion_factura() {
        return descripcion_factura;
    }

    public void setDescripcion_factura(String descripcion_factura) {
        this.descripcion_factura = descripcion_factura;
    }

    /**
     * @return the monto_total
     */
    public int getMonto_total() {
        return monto_total;
    }

    /**
     * @param monto_total the monto_total to set
     */
    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    /**
     * @return the cli
     */
    public Cliente getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    /**
     * @return the cli
     */


    /**
     * @return the lista_cliente
     */
  
    
   /* public List<Cliente> getLista_cliente() {
        return lista_cliente;
    }

  
    public void setLista_cliente(List<Cliente> lista_cliente) {
        this.lista_cliente = lista_cliente;
    }
    ¨*/
    
   
}
