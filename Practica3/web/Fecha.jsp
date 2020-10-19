<%-- 
    Document   : Inicio
    Created on : 16/10/2020, 12:14:17 PM
    Author     : darka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Date" %>
<%@page import="java.util.Random" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <link rel="stylesheet" href="css/fecha.css">
        <title>Date random</title>
    </head>
    <body>
        <h1>JSP xd</h1>
        <div class="divchido">
            <div>
                <p>La fecha es: <% 
                    Date fecha=new Date();
                    String cadena=fecha.toString();
                    %><%=cadena
                    %></p>
                <p>Arreglo de números random:<%
                    Random ran = new Random();
                    int[] arr = new int[5];
                    for(int i=0; i<arr.length;i++){
                        arr[i]=ran.nextInt(10);
                    }
                    int i=0;
                    while(i<arr.length){
                        out.print(arr[i]);
                        i++;
                    }
                %></p>
                
            </div>
                <div>
                    <form >
                        
                    </form>
                </div>
        <div>
            
            </div>
        </div>
        
    </body>
</html>
