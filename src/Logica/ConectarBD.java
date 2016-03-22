/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HECTOR
 */
public class ConectarBD {
    
    public Connection conexion; 
    public PreparedStatement sentencia; 
    
    
    
    public ConectarBD()
      { 
    
    String ruta = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
            try { 
                Class.forName("oracle.jdbc.OracleDriver"); 
                conexion=DriverManager.getConnection(ruta,"system","123456"); 
                } 
            catch(ClassNotFoundException e ) 
            { 
                System.out.println("Error:"+e); 
            } 
            catch(SQLException e ) 
            { 
                System.out.println("Error en la conexion: "+e); 
            } 
            
      }
    
    
    
    
    public Connection getConexion() 
 { 
    return conexion; 
 } 


 public void setConexion(Connection conexion) 
 { 
    this.conexion = conexion; 
 } 
 
    
}
