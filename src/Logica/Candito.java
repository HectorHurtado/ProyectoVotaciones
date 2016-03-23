
package Logica;

import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Candito {
  public String guardarCol(String a,String b,String c,String d,String ee,String f,String g){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            int IDCed= Integer.parseInt(a);
            String Nom=b;
            String sexo=c;
            int  edad=Integer.parseInt(d);
            String tipo=ee;
            int CanVot=Integer.parseInt(f);
            int IDPar=Integer.parseInt(g);
            
            
           

            String instruccion="insert into CANDIDATO.VOTACIONES values (?,?,?,?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, IDCed);
            conexion.sentencia.setString(2, Nom);
           
            conexion.sentencia.setString(3, sexo);
            conexion.sentencia.setInt(4, edad);
            conexion.sentencia.setString(5, tipo);
            conexion.sentencia.setInt(6, CanVot);
            conexion.sentencia.setInt(7, IDPar);
            
            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;

        } 
return men;
}  
  
  public String actualizar(String a,String b,String c,String d,String ee,String f,String g)
  {   
         String men="";    
         try{
             ConectarBD conexion= new ConectarBD();
            int IDCed= Integer.parseInt(a);
            String Nom=b;
            String sexo=c;
            int  edad=Integer.parseInt(d);
            String tipo=ee;
            int CanVot=Integer.parseInt(f);
            int IDPar=Integer.parseInt(g);
             
 
 String instruccion= "Update CANDIDATO.VOTACIONES set TIPO=?,CANTIDAD_VOTOS=?,PARTIDO_ID=? where CANDIDATO_ID='" +IDCed+"'";
 conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
 
 conexion.sentencia.setString(1, tipo);
 conexion.sentencia.setInt(2, CanVot);
 conexion.sentencia.setInt(3, IDPar);
 
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
  
}
