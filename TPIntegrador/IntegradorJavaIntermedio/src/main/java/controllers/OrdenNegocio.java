package controllers;

import modelos.Orden;
import util.ConectorHibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenNegocio {

    ConectorHibernate conn = new ConectorHibernate();

    public boolean ingresar(Orden orden) {

        return conn.create(orden);
    }

    public List<Object> listar(Date fechaInicio, Date fechaFin) {

        String query = "FROM Orden O WHERE O.fecha >= " + fechaInicio +
                " AND O.fecha <=3 " + fechaFin;
        return conn.leerLista(query);
    }
}
