/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HECTOR
 */
public class Municipio {
    
     public String guardarMun(String a,String b,String c,String d){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
             int Municipio_id = Integer.parseInt(a);
        String nombre =  b;
        int poblacion_total = Integer.parseInt(c);
        int poblacion_a_votar = Integer.parseInt(d);
        int votos_totales = 0;        
            
           

            String instruccion="insert into MUNICIPIO values (?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, Municipio_id);
            conexion.sentencia.setString(2, nombre);
            conexion.sentencia.setInt(3, poblacion_total);
            conexion.sentencia.setInt(4, poblacion_a_votar);
            conexion.sentencia.setInt(5, votos_totales);
            conexion.sentencia.execute();
            
         JOptionPane.showMessageDialog(null,"Registro Insertado","Información",
                                                    JOptionPane.INFORMATION_MESSAGE);
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;
            JOptionPane.showMessageDialog(null,"Error:"+e,"Información",
                                                    JOptionPane.WARNING_MESSAGE);

        }

return men;

}  
     
     
      public String eliminarMun(String a)
   {
       
       String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int id = Integer.parseInt(a);
            
            String instruccion= "Delete from MUNICIPIO "
                     + "where MUNICIPIO_ID=" +id;
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.execute();
            
            conexion.getConexion().close();
            
             JOptionPane.showMessageDialog(null,"REGISTRO ELIMINADO","Información",
                                                    JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException e)
            {
                men ="Error://"+e;
                JOptionPane.showMessageDialog(null,"Error:"+e,"Información",
                                                    JOptionPane.WARNING_MESSAGE);
            }
            return men;
       
       
   }
  
  
    
}
