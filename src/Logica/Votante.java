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
public class Votante {
    
    
      public String guardarVot(String a,String b,String c,String d, String ee,String f,String g){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            
            int cedula = Integer.parseInt(a);
            String nombre =  b;
            String sexo = c;
            int edad = Integer.parseInt(d);
            String direccion= ee;
            int municipio= Integer.parseInt(f);
            int mesa = Integer.parseInt(g);       
            
           

            String instruccion="insert into VOTANTE values (?,?,?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, cedula);
            conexion.sentencia.setString(2, nombre);
            conexion.sentencia.setString(3, sexo);
            conexion.sentencia.setInt(4, edad);
            conexion.sentencia.setString(5, direccion);
            conexion.sentencia.setInt(6, municipio);
            conexion.sentencia.setInt(7, mesa);
            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;
            System.out.println(men);

        }

return men;

}  
  
  public String actualizarVot(String a,String b,String c,String d,String ee,String f,String g)
  {   
         String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int cedula = Integer.parseInt(a);
            String nombre =  b;
            String sexo = c;
            int edad = Integer.parseInt(d);
            String direccion= ee;
            int municipio= Integer.parseInt(f);
            int mesa = Integer.parseInt(g);       
            
           

             String instruccion= "Update VOTANTE set NOMBRE=?,SEXO=?,,EDAD=?,DIRECCION=?,MUNICIPIO_ID=?,MESA_ID=? "
                     + "where CEDULA='" +cedula+"'";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            
            conexion.sentencia.setString(1, nombre);
            conexion.sentencia.setString(2, sexo);
            conexion.sentencia.setInt(3, edad);
            conexion.sentencia.setString(4, direccion);
            conexion.sentencia.setInt(5, municipio);
            conexion.sentencia.setInt(6, mesa);
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
            int cedula = Integer.parseInt(a);
            
            String instruccion= "Delete from VOTANTE "
                     + "where CEDULA='" +cedula+"'";
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
