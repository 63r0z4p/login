/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gerardo
 */
public class Persona {
   
    String Cedula, Apellidos, Nombres, Fecha_Nacimineto, Lugar_Nacimineto;
    
    public Persona(){
       
        Cedula="";
        Apellidos="";
        Nombres="";
        Fecha_Nacimineto="";
        Lugar_Nacimineto="";
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getFecha_Nacimineto() {
        return Fecha_Nacimineto;
    }

    public void setFecha_Nacimineto(String Fecha_Nacimineto) {
        this.Fecha_Nacimineto = Fecha_Nacimineto;
    }

    public String getLugar_Nacimineto() {
        return Lugar_Nacimineto;
    }

    public void setLugar_Nacimineto(String Lugar_Nacimineto) {
        this.Lugar_Nacimineto = Lugar_Nacimineto;
    }
    
    
}
