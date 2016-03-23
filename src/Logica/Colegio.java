
package Logica;

import javax.swing.JOptionPane;


public class Colegio {
    
public String guardarCol(String a,String b,String c,String d,String ee,String f){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            int IDcol= Integer.parseInt(a);
            String Nom=b;
            String Dir= c;
            int IDMun=Integer.parseInt(d);
            int IDJur=Integer.parseInt(ee);
            int NumMes=Integer.parseInt(f);
            
           

            String instruccion="insert into COLEGIO.VOTACIONES values (?,?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, IDcol);
            conexion.sentencia.setString(2, Nom);
            conexion.sentencia.setString(3, Dir);
            conexion.sentencia.setInt(4, IDMun);
            conexion.sentencia.setInt(5, IDJur);
            conexion.sentencia.setInt(6, NumMes);
            
            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;

        } 
return men;
}
}
