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
public class Partido {
    
     public String guardarPar(String a,String b,String c,String d){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            
            int id = Integer.parseInt(a);
            String nombre =  b;
            String siglas = c;
            String direccion= d;
         
            String instruccion="insert into PARTIDO values (?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, id);
            conexion.sentencia.setString(2, nombre);
            conexion.sentencia.setString(3, siglas);
            conexion.sentencia.setString(4, direccion);
            
        

            conexion.sentencia.execute();
            men= "Registro insertado";
            conexion.getConexion().close();
            JOptionPane.showMessageDialog(null,"Registro Insertado","Información",
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
  
  public String actualizarPar(String a,String b,String c,String d)
  {   
         String men="";    
         try{
            
            ConectarBD conexion= new ConectarBD();
            int id = Integer.parseInt(a);
            String nombre =  b;
            String siglas = c;
            String direccion= d;   
            
           

             String instruccion= "Update PARTIDO set NOMBRE=?,SIGLAS=?,DIRECCION=?"
                     + "where PARTIDO_ID='" +id+"'";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            
            conexion.sentencia.setString(1, nombre);
            conexion.sentencia.setString(2, siglas);
            conexion.sentencia.setString(3, direccion);
            conexion.sentencia.execute();
            men="reguistro modificado";


            conexion.getConexion().close();
            
            JOptionPane.showMessageDialog(null,"Registro Actualizado","Información",
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
    
  
   public String eliminarPar(String a)
   {
       
       String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int id = Integer.parseInt(a);
            
          
            String instruccion2= "Delete from MUNICIPIO_PARTIDO "
                     + "where PARTIDO_ID='" +id+"'";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion2);
            conexion.sentencia.execute();
 
            
            
            String instruccion= "Delete from PARTIDO "
                     + "where PARTIDO_ID='" +id+"'";
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
   
   
   public String registrarMunicipios(String a, String b)
   {
       
         String men="";
    try{
            ConectarBD conexion= new ConectarBD();
            
            int id_partido = Integer.parseInt(a);
            int id_municipio = Integer.parseInt(b);
         
            String instruccion="insert into MUNICIPIO_PARTIDO values (?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, id_municipio);
            conexion.sentencia.setInt(2, id_partido);

            conexion.sentencia.execute();
            men= "Registro insertado";
        JOptionPane.showMessageDialog(null,"Registro Insertado","Información",
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
   
   
    public String eliminarMunicipio(String a, String b)
   {
       
       String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int id_partido = Integer.parseInt(a);
            int id_municipio = Integer.parseInt(b);
            
            String instruccion= "Delete from MUNICIPIO_PARTIDO "
                     + "where PARTIDO_ID= " +id_partido+" AND MUNICIPIO_ID ="+id_municipio;
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
