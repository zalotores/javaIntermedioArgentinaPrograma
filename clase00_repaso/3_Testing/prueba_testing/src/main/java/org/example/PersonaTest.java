package org.example;

import dominio.Persona;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

public class PersonaTest {

    //Los metodos de los test siempre tienen que ser public y void

    @Test
    public void juanPerezSePresentaDeFormaCorrecta () {

        Persona unaPersona = new Persona("Juan", "Perez");

        Assert.assertEquals("Hola! me llamo Juan Perez", unaPersona.presentate());

    }

    //los test son atomicos
}
