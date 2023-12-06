/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterchef.by.neb.v10;

/**
 *
 * @author Nelson
 */
// Politecnico Internacional
// Programacion I
// Nelson Bazuto
// Nelson.Bazuto@pi.edu.co
// Ciclo: 3 

//Clase abstracta que se utiliza para que las subclases hereden atributos, es accesible desde cualquier parte del codigo
    //se crean atributos privados del Menu para almacenar información específica

public class Menu {
 
//    private String Jurado;
    private String Restaurante;
    private String Direccion; 
    private String Entrada;
    private String PlatoFuerte;
    private String Ingrediente;
    private int TiempoPrepara;
    private String Postre;
    private String Coctel;
////


    // Constructor para iniciar los atributos de las clases 
    public Menu(String Restaurante,String Direccion, String Entrada, String PlatoFuerte,String Ingrediente, int TiempoPrepara, String Postre,String Coctel) 
    {
    //    this.Jurado = Jurado;
        this.Restaurante = Restaurante;
        this.Direccion = Direccion;        
        this.Entrada = Entrada;
        this.PlatoFuerte = PlatoFuerte;
        this.Ingrediente = Ingrediente;
        this.TiempoPrepara = TiempoPrepara;
        this.Postre = Postre;
        this.Coctel = Coctel;
    }

    // Métodos get para acceder a la información de los atributos. 
    //Encapsulamiento y métodos set para modificar información de los atributos 
    


    public String getRestaurantE() 
    {
        return Restaurante;
    }

    public void setRestaurantE(String Restaurante) 
    {
        this.Restaurante = Restaurante;
    }

   
    public String getDireccioN() 
    {
        return Direccion;
    }

    public void setDireccioN(String Direccion) 
    {
        this.Direccion = Direccion;
    } 
    
    
    public String getEntradA() {
        return Entrada;
    }

    public void setEntradA(String Entrada) {
        this.Entrada = Entrada;
    }

    public String getPlatoFuertE() {
        return PlatoFuerte;
    }

    public void setPlatoFuertE(String PlatoFuerte) {
        this.PlatoFuerte = PlatoFuerte;
    }

    public String getIngredientE() {
        return Ingrediente;
    }

    public void setIngredientE(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public int getTiempoPreparA() {
        return TiempoPrepara;
    }

    public void setTiempoPreparA(int TiempoPrepara) {
        this.TiempoPrepara = TiempoPrepara;
    }

    public String getPostrE() {
        return Postre;
    }

    public void setPostrE(String Postre) {
        this.Postre = Postre;
    }

    public String getCocteL() {
        return Coctel;
    }

    public void setCocteL(String Coctel) {
        this.Coctel = Coctel;
    }    
}
