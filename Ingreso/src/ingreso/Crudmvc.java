/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingreso;
import Modelo.*;
import FrmPrincipal.*;
import controlador.*;

/**
 *
 * @author Gerardo
 */
public class Crudmvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Bienvenido_Administrador vistaC= new Bienvenido_Administrador();
       PersonaDAO ModeloC = new PersonaDAO();
       controladorCrud controlaC = new controladorCrud(vistaC, ModeloC);
       
       
       vistaC.setVisible(true);
       vistaC.setLocationRelativeTo(null);
        // TODO code application logic here
    }
    
}
