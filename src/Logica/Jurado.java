package Logica;

import java.sql.SQLException;


public class Jurado {
    public String guardarJur(String a,String b,String c,String d,String ee){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            int IDCed= Integer.parseInt(a);
            String Nom=b;
            int  edad=Integer.parseInt(c);
            int IDMes=Integer.parseInt(d);
            int IDCol=Integer.parseInt(ee);
            
            
           

            String instruccion="insert into JURADO.VOTACIONES values (?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, IDCed);
            conexion.sentencia.setString(2, Nom);
            conexion.sentencia.setInt(3, edad);
            conexion.sentencia.setInt(4, IDMes);
            conexion.sentencia.setInt(5, IDCol);
            
            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;

        } 
return men;
}  
  public String actualizarJur(String a,String b,String c,String d,String ee)
  {   
         String men="";    
         try{
            ConectarBD conexion= new ConectarBD();
            int IDCed= Integer.parseInt(a);
            String Nom=b;
            int  edad=Integer.parseInt(c);
            int IDMes=Integer.parseInt(d);
            int IDCol=Integer.parseInt(ee);
             
 
 String instruccion= "Update JURADO.VOTACIONES set EDAD=?,MESA_ID=?,COLEGIO_ID=? where JURADO_ID='" +IDCed+"'";
 conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
 
 conexion.sentencia.setInt(1,edad);
 conexion.sentencia.setInt(2, IDMes);
 conexion.sentencia.setInt(3, IDCol);
 
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
