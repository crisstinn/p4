package com.pract4.demo.model;

//me defino las clases y metodos que va a emplear la clase controller para gestionar las peticiones

public class Animal
{
    String nombre; //variable global
    String ecosistema;
    String imagen;


    public Animal() {} //constructor vacio

    public Animal(String nombre, String ecosistema, String imagen)
    {
        this.nombre=nombre; //a la global le asigno la local que le estoy pasando
        this.ecosistema=ecosistema;
        this.imagen=imagen;
    }

    //setter y getters para el nombre del animal
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }

    //setter y getters para el ecosistema
    public void setEcosistema(String ecosistema)
    {
        this.ecosistema = ecosistema;
    }
    public String getEcosistema()
    {
        return ecosistema;
    }

    //setter y getters para la foto del animal
    public void setImagen(String imagen)
    {
        this.imagen= imagen;
    }
    public String getImagen()
    {
        return imagen;
    }

}
