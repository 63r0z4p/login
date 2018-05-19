/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Gerardo
 */
public class PersonaDAO {
    conectorBD conexion;
    public  PersonaDAO(){
        conexion = new conectorBD();
    }
    
    public String insertPersona(String Cedula, String Apellidos, String Nombres, String Fecha_Nacimiento, String Lugar_Nacimineto){
        String rptaRegistro = null;
        try {
            Connection accesoBD = conexion.getConnection();
            CallableStatement cs = accesoBD.prepareCall("(call sp_insertPersona(?,?,?,?,?))");
            cs.setString(1, Cedula);
            cs.setString(2, Apellidos);
            cs.setString(3, Nombres);
            cs.setString(4, Fecha_Nacimiento);
            cs.setString(5, Lugar_Nacimineto);
            int numAfectadas = cs.executeUpdate();
            
            if(numAfectadas>0){
                rptaRegistro ="Registro Exitoso.";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }
    
    public ArrayList<Persona> ListPersona(){
        ArrayList ListPersona = new ArrayList();
        Persona persona;
        try {
            Connection accesoBD = conexion.getConnection();
            PreparedStatement ps = accesoBD.prepareStatement("select * From persona");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = new Persona();
                persona.setCedula(rs.getString(1));
                persona.setApellidos(rs.getString(2));
                persona.setNombres(rs.getString(3));
                persona.setFecha_Nacimineto(rs.getString(4));
                persona.setLugar_Nacimineto(rs.getString(5));
                ListPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return ListPersona;
    }
            
}

