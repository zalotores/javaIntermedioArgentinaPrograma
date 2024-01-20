package com.mycompany.hibernateanotaciones2;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Column(name = "cod_factura", unique = true)
	private int cod_factura;
	
	@Column(name = "desc_factura", nullable = false)
    private String descripcion_factura;
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
    
    
   
}
