/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author darka
 */
public class Conexion {

    Connection con = null;
    
    public Conexion(){
       try{   //Inicio del try
         
         Class.forName("com.mysql.jdbc.Driver");    
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica4","root","");   
        if (con!=null){                         
            System.out.println("Conexión a base de datos funcionando");                
         }
      }//cerramos el try
         catch(SQLException e)        
         {
         System.out.println(e);          
         }
         catch(ClassNotFoundException e)       
         {
          System.out.println(e);              
         }
      }
    
    public Connection conectado(){  //Este metodo de tipo Connection nos devuelve el estado del objeto
      return con;
}

    public void desconectar(){     //Por seguridad, cuando terminemos sentencias, cerramos la conexion o si la necesitamos cerrar por otro caso
      con = null;                  //Ahora de nuevo con sera null
      System.out.println("La conexion la BD se ha cerrado");

    } 
    public String consulta(String nombre, String cont) throws SQLException, ClassNotFoundException {
      String consulta="no existes";
       try{   //Inicio del try
            
             String query = "select * from usuario where usuario = '"+nombre+"' and cont='"+cont+"'"; 
             Statement estate = con.prepareStatement(query);
             ResultSet resultado = estate.executeQuery(query);
             if(resultado.next()){
                 consulta= "Si esta";
             }
          }
             catch(SQLException e)        //Agarramos excepciones de tipo SQL
             {
             System.out.println(e);          //las mostramos en consola
             }
     
       return consulta;
   }
}
