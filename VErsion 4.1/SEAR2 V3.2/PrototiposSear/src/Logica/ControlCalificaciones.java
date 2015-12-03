/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexX
 */
public class ControlCalificaciones {
    
    
       Connection cn;
     private Statement st;
     private PreparedStatement pS;
     private String respuestaS ;
     private String[] respuestaAr;
    
     public ControlCalificaciones()
    {
        conectar conec = new conectar();
        cn = conec.conexion();
              
    }
    
    public String[] RegistrarCalificaciones(String[] datos)
    {
        String[] splitt;
        respuestaAr = new String[datos.length];
        System.out.println("Tamaño del array"+" "+respuestaAr.length);
        
        for(int i=0 ; i<datos.length; i++)
        {
            splitt = datos[i].split("¬");
           

                    PreparedStatement pS2;
                 try {

                     pS2 = cn.prepareStatement("SELECT * \n" +
                                    "FROM  `calificaciones` \n" +
                                    "WHERE  `Bimestre` =  '"+splitt[0]+"'\n" +
                                    "AND  `ClaveGrupo` =  '"+splitt[2]+"'\n" +
                                    "AND  `ClaveMateria` =  '"+splitt[3]+"'\n" +
                                    "AND  `Matricula` =  '"+splitt[4]+"'");
                     
                     System.out.println("***Consulta antes de registrar*****\n"+"SELECT * \n" +
                                    "FROM  `calificaciones` \n" +
                                    "WHERE  `Bimestre` =  '"+splitt[0]+"'\n" +
                                    "AND  `ClaveGrupo` =  '"+splitt[2]+"'\n" +
                                    "AND  `ClaveMateria` =  '"+splitt[3]+"'\n" +
                                    "AND  `Matricula` =  '"+splitt[4]+"'");

                     ResultSet rs2 = pS2.executeQuery();


                     if(!rs2.next())
                     {
                         pS = cn.prepareStatement("INSERT INTO  `SEAR2`.`calificaciones` (\n" +
                                    " `IDCalificacion` ,\n" +
                                    " `Bimestre` ,\n" +
                                    " `Fecha` ,\n" +
                                    " `ClaveGrupo` ,\n" +
                                    " `ClaveMateria` ,\n" +
                                    " `Matricula` ,\n" +
                                    " `Calificacion`\n" +
                                    ")\n" +
                                    "VALUES (\n" +
                                    " NULL,  '"+splitt[0]+"',  '"+splitt[1]+"',  '"+splitt[2]+"',  '"+splitt[3]+"',  '"+splitt[4]+"','"+splitt[5]+"'\n" +
                                    ")");

                         System.out.println("************Consulta Emitida en el sistema *******************\n"+"INSERT INTO  `SEAR2`.`calificaciones` (\n" +
                                    " `IDCalificacion` ,\n" +
                                    " `Bimestre` ,\n" +
                                    " `Fecha` ,\n" +
                                    " `ClaveGrupo` ,\n" +
                                    " `ClaveMateria` ,\n" +
                                    " `Matricula` ,\n" +
                                    " `Calificacion`\n" +
                                    ")\n" +
                                    "VALUES (\n" +
                                    " NULL,  '"+splitt[0]+"',  '"+splitt[1]+"',  '"+splitt[2]+"',  '"+splitt[3]+"',  '"+splitt[4]+"','"+splitt[5]+"'\n" +
                                    ")");

                        int n = pS.executeUpdate();

                        if(n>0)
                        {
                             respuestaAr[i] = "Dado de alta correctamente Matricula:"+" "+splitt[4]+" "+"Materia"+" "+splitt[3]+" "+"Calificación"+" "+splitt[5]; 

                        }
                        else
                        {
                             respuestaAr[i] = "Error al registrar Matricula:"+" "+splitt[4]+" "+"Materia"+" "+splitt[3]+" "+"Calificación"+" "+splitt[5];               
                        }


                     }
                     else
                              respuestaAr[i] = "Ya existe calificacion para la matricula"+" "+splitt[4]+" "+"En la Materia:"+" "+splitt[3];


                 } catch (SQLException ex) {
                     Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                      respuestaAr = new String[1];
                      respuestaAr[0] = "Error en el servidor";
                      System.out.println("Resuntado:"+" "+respuestaAr[0]);
                      return respuestaAr;
                 }



        }
        
         return respuestaAr;
        
        
    }
    
    
    
    public String[] consultarDatosCali(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT  IDCalificacion,`materias`.`Nombre` ,  `Bimestre` ,  `Calificacion` \n" +
                    "FROM  `calificaciones` ,  `materias` \n" +
                    "WHERE  `materias`.`ClaveMateria` =  `calificaciones`.`ClaveMateria` \n" +
                    "AND  `Matricula` =  '"+Matricula+"'");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `materias`.`Nombre` ,  `Bimestre` ,  `Calificacion` \n" +
                        "FROM  `calificaciones` ,  `materias` \n" +
                        "WHERE  `materias`.`ClaveMateria` =  `calificaciones`.`ClaveMateria` \n" +
                        "AND  `Matricula` =  '"+Matricula+"'");
             
             ResultSet rs = pS.executeQuery();
             
                         
             while(rs.next())
             {
                 contador++;
             }
             
             rs.first();
             System.out.println("****Datos Optenidos:\n****");
             respuestaAr = new String[contador];
             if(contador>=1)
             {
                 
                 for(int x=0 ; x<contador; x++)
                {

                    respuestaAr[x] = rs.getString("IDCalificacion").concat("¬").concat(rs.getString("Nombre")).concat("¬").concat(rs.getString("Bimestre")).concat("¬").concat(rs.getString("Calificacion"));
                    System.out.println(respuestaAr[x]);
                    rs.next();
                }
 
             }
             else
             {
                respuestaAr = new String[1];
                respuestaAr[0] = "No se obtuviero datos alumnos seleccionado";
                return respuestaAr;
             }
             
             return respuestaAr;
            
             
          
        
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Este es un error: \t"+ex.getMessage());
             respuestaAr = new String[1];
             respuestaAr[0] = "Error en el sistema";
             return respuestaAr;
             
         }
     
        
    }
    
    public String[] consultarDatosCali2(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT `calificaciones`.`ClaveMateria` ,  `Bimestre` ,  `Calificacion` \n" +
                    "FROM  `calificaciones` ,  `materias` \n" +
                    "WHERE  `materias`.`ClaveMateria` =  `calificaciones`.`ClaveMateria` \n" +
                    "AND  `Matricula` =  '"+Matricula+"'");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `materias`.`Nombre` ,  `Bimestre` ,  `Calificacion` \n" +
                        "FROM  `calificaciones` ,  `materias` \n" +
                        "WHERE  `materias`.`ClaveMateria` =  `calificaciones`.`ClaveMateria` \n" +
                        "AND  `Matricula` =  '"+Matricula+"'");
             
             ResultSet rs = pS.executeQuery();
             
                         
             while(rs.next())
             {
                 contador++;
             }
             
             rs.first();
             System.out.println("****Datos Optenidos:\n****");
             respuestaAr = new String[contador];
             if(contador>=1)
             {
                 
                 for(int x=0 ; x<contador; x++)
                {

                    respuestaAr[x] = rs.getString("ClaveMateria").concat("¬").concat(rs.getString("Bimestre")).concat("¬").concat(rs.getString("Calificacion"));
                    System.out.println(respuestaAr[x]);
                    rs.next();
                }
 
             }
             else
             {
                respuestaAr = new String[1];
                respuestaAr[0] = "No se obtuviero datos alumnos seleccionado";
                return respuestaAr;
             }
             
             return respuestaAr;
            
             
          
        
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Este es un error: \t"+ex.getMessage());
             respuestaAr = new String[1];
             respuestaAr[0] = "Error en el sistema";
             return respuestaAr;
             
         }
     
        
    }
    
    public String[] MoificarCalificaciones(String[] datos)
    {
        String[] splitt;
        respuestaAr = new String[datos.length];
        System.out.println("Tamaño del array"+" "+respuestaAr.length);
        for(int i=0 ; i<datos.length; i++)
        {
            splitt = datos[i].split("¬");
            
            
            try {
                pS = cn.prepareStatement("UPDATE  `SEAR2`.`calificaciones` SET  "+
            " `Calificacion` =  '"+splitt[0]+"' WHERE  `Matricula` =  '"+splitt[1]+"' AND  `ClaveMateria` =  '"+splitt[2]+"' AND  `Bimestre` =  '"+splitt[3]+"'");


              System.out.println("********Preparando consulta********"+"UPDATE  `SEAR2`.`calificaciones` SET  "+
            " `Calificacion` =  '"+splitt[0]+"' WHERE  `Matricula` =  '"+splitt[1]+"' AND  `ClaveMateria` =  '"+splitt[2]+"' AND  `Bimestre` =  '"+splitt[3]+"'");
               
              int rs = pS.executeUpdate();

                if(rs>0)
                {
                    respuestaAr[i] = "Dado de alta correctamente Materia"+" "+splitt[2]+" "+"Bimestre"+" "+splitt[3]+" "+"Calificación"+" "+splitt[0];
                    System.out.println("Resultado:"+" "+respuestaAr[i]);
                }
                else
                {
                    respuestaAr[i] =  "Error al dar de alta Materia"+" "+splitt[2]+" "+"Bimestre"+" "+splitt[3]+" "+"Calificación"+" "+splitt[0];
                    System.out.println("Resultado:"+" "+respuestaAr[i]);
                }
                
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Mensaje: "+ex.getMessage());
             respuestaAr = new String[1];
             respuestaAr[0] = "Error en el servidor";
             System.out.println("Resuntado:"+" "+respuestaAr[0]);
             return respuestaAr;
         }
        
        }
        
         return respuestaAr;
        
        
    }
    
    
    public String eliminarCalificaciones (String datos[]){
        
        PreparedStatement ps2;
         try {
            
            ps2 = cn.prepareStatement("SELECT * \n" +
                                        "FROM  `calificaciones` \n" +
                                        "WHERE  `IDCalificacion` LIKE  '"+datos[0]+"'\n" +
                                        "AND  `Bimestre` LIKE  '"+datos[1]+"'");
            
            ResultSet rs2 = ps2.executeQuery(); 
            
            if(rs2.next())
            {
                pS = cn.prepareStatement("DELETE FROM `calificaciones` WHERE `IDCalificacion` LIKE '"+datos[0]+"' AND `Bimestre` LIKE '"+datos[1]+"'");
                int n = pS.executeUpdate();

                if(n>0){
                    
                    respuestaS = "Calificación eliminada correctamente";
                    return respuestaS;
                }
                else
                {
                    return respuestaS = "Error al eliminar la calificación"; 
                }
                
            }
            else
            {
                respuestaS = "Calificacion no existente";
                return respuestaS;
            }
             
            
            
            
         } catch (SQLException ex) {
             Logger.getLogger(AdministracionGrupos.class.getName()).log(Level.SEVERE, null, ex);
             respuestaS = "Error del sistema";
             return respuestaS;
         }
    }
    
    public String eliminarCalificacion(String datoID)
    {
        
         try 
        {
            pS = cn.prepareStatement("DELETE FROM   calificaciones "
                                        + "WHERE `IDCalificacion` = '"+datoID+"'");
            System.out.println("*******Preparando consulta*******"+"DELETE FROM   calificaciones "
                                        + "WHERE `IDCalificacion` = '"+datoID+"'");
         
            int n = pS.executeUpdate();
             
            if(n>0)
            {
                return "Datos elimnados correctamente";
            }
            else
                return "Error al dar de baja";

         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("MEnsaje:"+ ex.getMessage());
             return "Error con la base de datos";
         }
        
    }
    
    
}
