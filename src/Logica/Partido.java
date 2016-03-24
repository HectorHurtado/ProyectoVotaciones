/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;

/**
 *
 * @author HECTOR
 */
public class Partido {
    
     public String guardarPar(String a,String b,String c,String d, String ee){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            
            int id = Integer.parseInt(a);
            String nombre =  b;
            String siglas = c;
            String direccion= d;
            int municipio= Integer.parseInt(ee);
      
            
           

            String instruccion="insert into PARTIDO values (?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, id);
            conexion.sentencia.setString(2, nombre);
            conexion.sentencia.setString(3, siglas);
            conexion.sentencia.setString(4, direccion);
            conexion.sentencia.setInt(5, municipio);
        

            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;
            System.out.println(men);

        }

return men;

}  
  
  public String actualizarPar(String a,String b,String c,String d,String ee)
  {   
         String men="";    
         try{
            
            ConectarBD conexion= new ConectarBD();
            int id = Integer.parseInt(a);
            String nombre =  b;
            String siglas = c;
            String direccion= d;
            int municipio= Integer.parseInt(ee);    
            
           

             String instruccion= "Update VOTANTE set NOMBRE=?,SIGLAS=?,DIRECCION=?,MUNICIPIO=?"
                     + "where PARTIDO_ID='" +id+"'";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            
            conexion.sentencia.setInt(1, id);
            conexion.sentencia.setString(2, nombre);
            conexion.sentencia.setString(3, siglas);
            conexion.sentencia.setString(4, direccion);
            conexion.sentencia.setInt(5, municipio);
            conexion.sentencia.execute();
            men="reguistro modificado";


            conexion.getConexion().close();
            }
            catch(SQLException e)
            {
                men ="Erros://"+e;
            }
            return men;
  }
    
  
   public String eliminarVot(String a)
   {
       
       String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int id = Integer.parseInt(a);
            
            String instruccion= "Delete from PARTIDO "
                     + "where PARTIDO_ID='" +id+"'";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            
            conexion.getConexion().close();
            }
            catch(SQLException e)
            {
                men ="Erros://"+e;
            }
            return men;
       
       
   }
    
}
