package vistas;

import controllers.*;
import modelos.Cliente;
import modelos.Orden;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrdenesVista {

    Cliente cliente;
    ClienteNegocio clienteNegocio = new ClienteNegocio();
    OrdenNegocio ordenNegocio = new OrdenNegocio();
    Scanner scan = new Scanner(System.in);
    public void alta() {
        System.out.print("\nIngrese el número de Cliente: ");
        int dniCliente = Integer.parseInt(scan.nextLine());
        cliente = new Cliente(dniCliente);

        if(!(clienteNegocio.validar(dniCliente))) {

            //pido datos del nuevo cliente
            System.out.println("\n----\nCarga de nuevo Cliente.\nDNI: " + cliente.getDni());
            System.out.print("\nIngrese el nombre del Cliente: ");
            cliente.setNombre(scan.nextLine());
            System.out.print("\nIngrese la dirección del Cliente: ");
            cliente.setDireccion(scan.nextLine());
            System.out.print("\nIngrese el mail del Cliente: ");
            cliente.setMail(scan.nextLine());

            if(clienteNegocio.nuevoCliente(cliente))
                System.out.println("\nCliente agregado exitosamente\n----\n");
            else
                System.out.println("\nError al cargar el cliente\n----\n"); //cambiar a throw

        }

        Orden orden = new Orden();
        System.out.print("\nIngrese el problema declarado: ");
        orden.setDescripcion(scan.nextLine());
        System.out.print("\nIngrese el costo estimado: ");
        orden.setCosto(scan.nextLine());
        //carga de fecha
        System.out.print("\nIngrese la cantidad de dias de espera: ");
        int dias = Integer.parseInt(scan.nextLine());
        Date fecha = new Date();
        LocalDateTime x = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusDays(dias);
        fecha = Date.from(x.atZone(ZoneId.systemDefault()).toInstant());
        orden.setFecha(fecha);
        orden.setEstado("Abierto");
        orden.setIdCliente(cliente.getDni());
        System.out.print("\nIngrese el codigo de Categoria para la orden: ");
        orden.setIdCategoria(Integer.parseInt(scan.nextLine()));
        System.out.print("\nIngrese el codigo de Técnico: ");
        orden.setIdTecnico(Integer.parseInt(scan.nextLine()));

        if(ordenNegocio.ingresar(orden))
            System.out.println("\nOrden ingresada con éxito");
        else
            System.out.println("\nError al cargar la orden!");
    }

    public void lista() {
        Date fechaInicio, fechaFin;
        System.out.print("\nBusqueda de Ordenes por fecha - formato YYYY-MM-DD.");
        System.out.print("Ingrese la fecha inicial: ");
        String fechaDato = scan.nextLine();
        try
        {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-mm-dd");
            fechaInicio = (Date)formatador.parseObject(fechaDato);
            System.out.print("Ingrese la fecha final: ");
            fechaDato = scan.nextLine();
            fechaFin = (Date)formatador.parseObject(fechaDato);

            List<Object> listado = ordenNegocio.listar(fechaInicio, fechaFin);
        }
        catch (ParseException ex) {
            System.out.println("\nError al cargar fecha!");
        }
    }
}
