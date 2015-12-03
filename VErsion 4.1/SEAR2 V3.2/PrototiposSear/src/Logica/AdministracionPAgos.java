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
public class AdministracionPAgos {
    
     Connection cn;
     private Statement st;
     private PreparedStatement pS;
     private String respuestaS ;
     private String[] respuestaAr;
    
     public AdministracionPAgos()
    {
        conectar conec = new conectar();
        cn = conec.conexion();
              
    }
     
     public String registrarPago (String[] datos)
    {
        
         PreparedStatement pS2;
         try {
             
             pS = cn.prepareStatement("INSERT INTO  `sear2`.`pagoscolegiatura` (\n" +
                                        "`IdPago` ,\n" +
                                        "`Monto` ,\n" +
                                        "`Fecha` ,\n" +
                                        "`NombrePago` ,\n" +
                                        "`Matricula`\n" +
                                        ")\n" +
                                        "VALUES (\n" +
                                        "NULL ,  '"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+"'\n" +
                                        ");");

                 System.out.println("********Preparando Cunsulta**********\n"+"INSERT INTO  `sear2`.`pagoscolegiatura` (\n" +
                                        "`IdPago` ,\n" +
                                        "`Monto` ,\n" +
                                        "`Fecha` ,\n" +
                                        "`NombrePago` ,\n" +
                                        "`Matricula`\n" +
                                        ")\n" +
                                        "VALUES (\n" +
                                        "NULL ,  '"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+"'\n" +
                                        ");");
                 
                int n = pS.executeUpdate();

                if(n>0)
                {
                    return respuestaS = "Registro guardado satisfactoriamente"; 

                }
                else
                {
                   return respuestaS = "Error al registrar el pago para el alumno";               
                }
                        
                       
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             return respuestaS = "Error en el servidor"; 
         }
            

    }    
     
     
    public String[] consultarPagos()
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT  `Matricula` ,  `Ap_pat` ,  `Ap_mat` ,  `Nombre` \n" +
                                    "FROM  `alumno`  ");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `Matricula` ,  `Ap_pat` ,  `Ap_mat` ,  `Nombre` \n" +
                                    "FROM  `alumno`  ");
             
             ResultSet rs = pS.executeQuery();
             
                         
             while(rs.next())
             {
                 contador++;
             }
             
             rs.first();
             System.out.println("****Datos Obtenidos:\n****");
             respuestaAr = new String[contador];
             for(int x=0 ; x<contador; x++)
             {
                 
                 respuestaAr[x] = rs.getString("Matricula").concat("-").concat(rs.getString("Ap_pat")).concat(" ").concat(rs.getString("Ap_pat"));
                 System.out.println(respuestaAr[x]);
                 rs.next();
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
    
    
    public String[] consultarPagosAlumno(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT   `IdPago`,`NombrePago` ,  `Monto` ,  `Fecha` \n" +
                                "FROM  `pagoscolegiatura` \n" +
                                "WHERE  `Matricula` = '"+Matricula+"'"
                                + "ORDER BY  `Fecha` DESC ");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `IdPago`, `NombrePago` ,  `Monto` ,  `Fecha` \n" +
                                "FROM  `pagoscolegiatura` \n" +
                                "WHERE  `Matricula` = '"+Matricula+"'"
                                + "ORDER BY  `Fecha` DESC ");
             
             ResultSet rs = pS.executeQuery();
             
                         
             while(rs.next())
             {
                 contador++;
             }
             
             rs.first();
             System.out.println("****Datos Obtenidos:\n****");
             respuestaAr = new String[contador];
             rs.first();
             
             for(int x=0 ; x < contador; x++)
             {
                 
                 respuestaAr[x] = rs.getString("NombrePago").concat("¬").concat(rs.getString("Monto")).concat("¬").concat(rs.getString("Fecha"));
                 System.out.println(respuestaAr[x]);
                 rs.next();
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
    
    public String EliminarPagos(String[] datos)
    {
        
         try 
        {
            pS = cn.prepareStatement("DELETE FROM  pagoscolegiatura "
                                        + "WHERE `Matricula` = '"+datos[0]+"' AND `Monto` = '"+datos[1]+"'");
            System.out.println("*******Preparando consulta*******"+"DELETE FROM  pagoscolegiatura "
                                        + "WHERE `Matricula` = '"+datos[0]+"' AND `Monto` = '"+datos[1]+"'");
         
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
    
    
    public String[] MoificarPagos(String[] datos)
    {
        String[] splitt;
        respuestaAr = new String[datos.length];
        System.out.println("Tamaño del array"+" "+respuestaAr.length);
        for(int i=0 ; i<datos.length; i++)
        {
            splitt = datos[i].split("¬");
            
            
            try {
                pS = cn.prepareStatement("UPDATE  `sear2`.`pagoscolegiatura` SET  `Monto` =  '"+splitt[0]+"',\n" +
                            "`Fecha` =  '"+splitt[1]+"',\n" +
                            "`NombrePago` =  '"+splitt[2]+"' WHERE  `Matricula` = '"+splitt[3]+"' AND"
                            + "`IdPago` = '"+splitt[4]+"'");


              System.out.println("********Preparando consulta********"+"UPDATE  `sear2`.`pagoscolegiatura` SET  `Monto` =  '"+splitt[0]+"',\n" +
                            "`Fecha` =  '"+splitt[1]+"',\n" +
                            "`NombrePago` =  '"+splitt[2]+"' WHERE  `Matricula` = '"+splitt[3]+"' AND"
                            + "`IdPago` = '"+splitt[4]+"'");
               
              int rs = pS.executeUpdate();

                if(rs>0)
                {
                    respuestaAr[i] = "Dado de alta correctamente"+" "+splitt[2];
                    System.out.println("Resultado:"+" "+respuestaAr[i]);
                }
                else
                {
                    respuestaAr[i] =  "Error al dar de alta"+" "+splitt[2];
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
    
    
    public String[] consultarPagosAlumnoId(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT   `IdPago`,`NombrePago` ,  `Monto` ,  `Fecha` \n" +
                                "FROM  `pagoscolegiatura` \n" +
                                "WHERE  `Matricula` = '"+Matricula+"'"
                                + "ORDER BY  `Fecha` DESC ");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `IdPago`, `NombrePago` ,  `Monto` ,  `Fecha` \n" +
                                "FROM  `pagoscolegiatura` \n" +
                                "WHERE  `Matricula` = '"+Matricula+"'"
                                + "ORDER BY  `Fecha` DESC ");
             
             ResultSet rs = pS.executeQuery();
             
                         
             while(rs.next())
             {
                 contador++;
             }
             
             rs.first();
             System.out.println("****Datos Obtenidos:\n****");
             respuestaAr = new String[contador];
             rs.first();
             
             for(int x=0 ; x < contador; x++)
             {
                 
                 respuestaAr[x] = rs.getString("IdPago").concat("¬").concat(rs.getString("NombrePago")).concat("¬").concat(rs.getString("Monto")).concat("¬").concat(rs.getString("Fecha"));
                 System.out.println(respuestaAr[x]);
                 rs.next();
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
     
}
