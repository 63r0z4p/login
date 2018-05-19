/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import FrmPrincipal.Bienvenido_Administrador;
import Modelo.*;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gerardo
 */
public class controladorCrud implements ActionListener{

    Bienvenido_Administrador vistaCRUD = new Bienvenido_Administrador();
    PersonaDAO modeloCRUD = new PersonaDAO();

    public controladorCrud(Bienvenido_Administrador vistaCRUD, PersonaDAO modeloCRUD) {
        this.modeloCRUD =  modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.BTN_LISTAR.addActionListener(this);
        this.vistaCRUD.BTN_REGISTRAR.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCRUD.BTN_REGISTRAR){
            String Cedula = vistaCRUD.TXT_CEDULA.getText();
            String Apellidos = vistaCRUD.TXT_CEDULA.getText();
            String nombres = vistaCRUD.TXT_CEDULA.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String FechaNacimineto = formatoFecha.format(vistaCRUD.JD_FECHA.getDate());
            String LugarNacimineto  = vistaCRUD.TXT_LUGAR_N.getText();
            
            String rptaRegistro = modeloCRUD.insertPersona(Cedula, Apellidos, nombres, FechaNacimineto, LugarNacimineto);
            
            if(rptaRegistro!=null){
                JOptionPane.showMessageDialog(null, rptaRegistro);
            }else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
        }
        
        if(e.getSource() == vistaCRUD.BTN_LISTAR){
            LenarTabla(vistaCRUD.TB_DATOS);
            
        }
        
    }

   public void inicilaizarCrud(){
       
   }
       
   public void LenarTabla(JTable tablaD){
       DefaultTableModel modeloT = new DefaultTableModel();
       tablaD.setModel(modeloT);
       
       modeloT.addColumn("CEDULA");
       modeloT.addColumn("APELLIDOS");
       modeloT.addColumn("NOMBRES");
       modeloT.addColumn("FECHA NACIMIENTO");
       modeloT.addColumn("LUGAR LACIMINETO");
       
       Object[] columna = new Object[5];
       int numRegistros = modeloCRUD.ListPersona().size();
       for (int i = 0; i < numRegistros; i++) {
           columna[0] = modeloCRUD.ListPersona().get(i).getCedula();
           columna[1] = modeloCRUD.ListPersona().get(i).getApellidos();
           columna[2] = modeloCRUD.ListPersona().get(i).getNombres();
           columna[3] = modeloCRUD.ListPersona().get(i).getFecha_Nacimineto();
           columna[4] = modeloCRUD.ListPersona().get(i).getLugar_Nacimineto();
           modeloT.addRow(columna);
       }
   }
   
   
    
}
