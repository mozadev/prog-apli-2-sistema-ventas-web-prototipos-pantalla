
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bd_ventas";
    String user="root";
    String pass="";
    public Connection Conexion(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con= (Connection) DriverManager.getConnection(url,user,pass);
       }catch (Exception e){
           
       }
        
        return con;
    }
}
