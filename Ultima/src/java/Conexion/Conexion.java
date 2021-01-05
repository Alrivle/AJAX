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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void desconectar(){     
      con = null;                 
      System.out.println("La conexion la BD se ha cerrado");

    }
    
    /**
     * @param nombre
     * @param cont
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException 
     */
    public int consulta(String nombre, String cont) throws SQLException, ClassNotFoundException {
        int res=1;
        try{              
            String query = "select * from usuario where usuario = '"+nombre+"' and cont='"+cont+"'"; 
            Statement estate = con.prepareStatement(query);            
            ResultSet resultado = estate.executeQuery(query);
            if(!resultado.next()){
                res=0;
            }
        }
            catch(SQLException e)        //Agarramos excepciones de tipo SQL
            {
            System.out.println(e);          //las mostramos en consola
            }
        return res;
   }
    
    public String consultaImg(int id) throws SQLException, ClassNotFoundException {
        String res="";
        try{              
            String query = "select * from imagenes where idImagen='"+id+"'"; 
            Statement estate = con.prepareStatement(query);            
            ResultSet resultado = estate.executeQuery(query);
            if(resultado.next()){
                res=resultado.getString(3);
            }
        }
            catch(SQLException e)        //Agarramos excepciones de tipo SQL
            {
            System.out.println(e);          //las mostramos en consola
            }
        return res;
   }
}
