package controllers;

import modelos.Cliente;
import util.ConectorHibernate;

import java.util.List;

public class ClienteNegocio {

    ConectorHibernate conn = new ConectorHibernate();
    //cargar nuevo cliente
    public  boolean nuevoCliente(Cliente cliente) {

        return conn.create(cliente);
    }

    //validar si existe cliente
    public  boolean validar (int dni) {

        String query = "FROM Cliente C WHERE C.dni = " + dni;
        List listado = conn.leerLista(query);

        return !listado.isEmpty();

    }

}
