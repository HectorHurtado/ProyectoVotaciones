
package Logica;


public class Mesa {
    public String guardarMes(String a,String b,String c,String d,String ee,String f,String g){
    String men="";
try{
            ConectarBD conexion= new ConectarBD();
            int IDMes= Integer.parseInt(a);
            int VotBLa=Integer.parseInt(b);
            int VotNul=Integer.parseInt(c);
            int VotVal=Integer.parseInt(d);
            int tolVot=Integer.parseInt(ee);
            int IDCol=Integer.parseInt(f);
            int IDJur=Integer.parseInt(g);
            
            
           

            String instruccion="insert into MESA.VOTACIONES values (?,?,?,?,?,?,?,?)";
            conexion.sentencia=conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, IDMes);
            conexion.sentencia.setInt(2, VotBLa);
            conexion.sentencia.setInt(3,VotNul);
            conexion.sentencia.setInt(4, VotVal);
            conexion.sentencia.setInt(5,tolVot);
            conexion.sentencia.setInt(6, IDCol);
            conexion.sentencia.setInt(7, IDJur);
            
            conexion.sentencia.execute();
            men= "Registro insertado";
        }
        catch (Exception e){
            men="Error sql "+e;

        } 
return men;
}  
}
