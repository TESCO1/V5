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
public class GestionAlumnos {
    
     Connection cn;
     private Statement st;
     private PreparedStatement pS;
     private String respuestaS ;
     private String[] respuestaAr;

    
    public GestionAlumnos()
    {
       
        conectar conec = new conectar();
        cn = conec.conexion();
              
    }
    
    
    public String registrar (String[] datos)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT * \n" +
                     "FROM  `alumno` \n" +
                     "WHERE  (`Matricula` =  '"+datos[0]+"'\n" +
                     "AND  `Ap_pat` =  '"+datos[1]+"'\n" +
                     "AND  `Ap_mat` =  '"+datos[2]+"'\n" +
                     "AND  `Nombre` =  '"+datos[3]+"'\n" +
                     "AND  `NombreTutor` =  '"+datos[4]+"') OR  `Matricula` =  '"+datos[0]+"'");
             
             ResultSet rs2 = pS2.executeQuery();
        
             
             if(!rs2.next())
             {
                 pS = cn.prepareStatement("INSERT INTO  `sear2`.`alumno` (\n" +
                            "`Matricula` ,\n" +
                            "`Ap_pat` ,\n" +
                            "`Ap_mat` ,\n" +
                            "`Nombre` ,\n" +
                            "`NombreTutor` ,\n" +
                            "`Calle` ,\n" +
                            "`Municipio` ,\n" +
                            "`CPostal` ,\n" +
                            "`Telefono` ,\n" +
                            "`Celular`,\n" +
                            "`Periodo`\n" +
                            ")\n" +
                            "VALUES (\n" +
                            "'"+datos[0]+"',  '"+datos[1]+" ',  '"+datos[2]+"',  '"+datos[3]+"',  '"+datos[4]+"',  '"+datos[5]+"',  '"+datos[6]+"', '"+datos[7]+"', '"+datos[8]+"',  '"+datos[9]+"',  '"+datos[10]+"'" +
                            ");");

                 System.out.println("************Consulta Emitida en el sistema ******************* \nIINSERT INTO  `sear2`.`alumno` (\n" +
                            "`Matricula` ,\n" +
                            "`Ap_pat` ,\n" +
                            "`Ap_mat` ,\n" +
                            "`Nombre` ,\n" +
                            "`NombreTutor` ,\n" +
                            "`Calle` ,\n" +
                            "`Municipio` ,\n" +
                            "`CPostal` ,\n" +
                            "`Telefono` ,\n" +
                            "`Celular`,\n" +
                            "`Periodo`\n" +
                            ")\n" +
                            "VALUES (\n" +
                            "'"+datos[0]+"',  '"+datos[1]+" ',  '"+datos[2]+"',  '"+datos[3]+"',  '"+datos[4]+"',  '"+datos[5]+"',  '"+datos[6]+"', '"+datos[7]+"', '"+datos[8]+"',  '"+datos[9]+"',  '"+datos[10]+"'" +
                            ");");
                 
                int n = pS.executeUpdate();

                if(n>0)
                {
                    return respuestaS = "Datos dados de alta correctamente."; 

                }
                else
                {
                   return respuestaS = "Error al registrar al nuevo alumno";               
                }
                        
                 
             }
             else
                 return respuestaS = "El alumno ya ha sido registrado.";
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             return respuestaS = "Error en el servidor"; 
         }
            

    }    
    
    public String[] consultar(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT  `Ap_pat` ,  `Ap_mat` ,  `Nombre` ,  `NombreTutor` ,  `Calle` ,  `Municipio` ,  `CPostal` ,  `Telefono` ,  `Celular`, \n" +
                        "`Periodo`\n" +
                        "FROM  `alumno` \n" +
                        "WHERE  `Matricula` LIKE  '"+Matricula+"' ");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `Ap_pat` ,  `Ap_mat` ,  `Nombre` ,  `NombreTutor` ,  `Calle` ,  `Municipio` ,  `CPostal` ,  `Telefono` ,  `Celular`, \n" +
                        "`Periodo`\n" +
                        "FROM  `alumno` \n" +
                        "WHERE  `Matricula` LIKE  '"+Matricula+"' ");
             
             ResultSet rs = pS.executeQuery();
             
                         
             if(rs.next())
             {
                
                 respuestaAr = new String[10];
                 
                 respuestaAr[0] = rs.getString("Ap_pat").toString();
                 respuestaAr[1] = rs.getString("Ap_mat").toString();
                 respuestaAr[2] = rs.getString("Nombre").toString();
                 respuestaAr[3] = rs.getString("NombreTutor").toString();
                 respuestaAr[4] = rs.getString("Calle").toString();
                 respuestaAr[5] = rs.getString("Municipio").toString();
                 respuestaAr[6] = rs.getString("CPostal").toString();
                 respuestaAr[7] = rs.getString("Telefono").toString();
                 respuestaAr[8] = rs.getString("Celular").toString();
                 respuestaAr[9] = rs.getString("Periodo").toString();
                 return respuestaAr;
             }
             else
             {
                  respuestaAr = new String[1];
                  respuestaAr[0] = "No se obtuvieron datos";
                  return respuestaAr;
             }
                         
             
             
          
        
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Este es un error: \t"+ex.getMessage());
             respuestaAr = new String[1];
             respuestaAr[0] = "Error en el sistema";
             return respuestaAr;
             
         }
     
        
    }
    
    public String Moificar(String[] datos)
    {
        
        try {
             pS = cn.prepareStatement("UPDATE  `sear2`.`alumno` SET  `Ap_pat` =  '"+datos[1]+"',\n" +
                                            "`Ap_mat` =  '"+datos[2]+"',\n" +
                                            "`Nombre` =  '"+datos[3]+"',\n" +
                                            "`NombreTutor` =  '"+datos[4]+"',\n" +
                                            "`Calle` =  '"+datos[5]+"',\n" +
                                            "`Municipio` =  '"+datos[6]+"',\n" +
                                            "`CPostal` =  '"+datos[7]+"',\n" +
                                            "`Telefono` =  '"+datos[8]+"',\n" +
                                            "`Celular` =  '"+datos[9]+"', "+
                                            "`Periodo` =  '"+datos[10]+"' "
                                            + " WHERE  `alumno`.`Matricula`  =  '"+datos[0]+"' ;");
             
             
           System.out.println("UPDATE  `sear2`.`alumno` SET  `Ap_pat` =  '"+datos[1]+"',\n" +
                                            "`Ap_mat` =  '"+datos[2]+"',\n" +
                                            "`Nombre` =  '"+datos[3]+"',\n" +
                                            "`NombreTutor` =  '"+datos[4]+"',\n" +
                                            "`Calle` =  '"+datos[5]+"',\n" +
                                            "`Municipio` =  '"+datos[6]+"',\n" +
                                            "`CPostal` =  '"+datos[7]+"',\n" +
                                            "`Telefono` =  '"+datos[8]+"',\n" +
                                            "`Celular` =  '"+datos[9]+"', "+
                                            "`Periodo` =  '"+datos[10]+"' "
                                            + " WHERE  `alumno`.`Matricula`  =  '"+datos[0]+"' ;");
             int rs = pS.executeUpdate();
             
             if(rs>0)
             {
                 return "Actualización Correctamente";
             }
             else
             {
                 return "Error al actualizar intente mas tarde";
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Mensaje: "+ex.getMessage());
             return "Error con el servidor";
         }
        
        
    }
    
    public String Eliminar(String Matricula)
    {
        
         try 
        {
            pS = cn.prepareStatement("DELETE FROM alumno "
                                        + "WHERE `Matricula` = '"+Matricula+"'");
         
            int n = pS.executeUpdate();
             
            if(n>0)
            {
                return "Datos dados de baja correctamente";
            }
            else
                return "Error al dar de baja";

         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("MEnsaje:"+ ex.getMessage());
             return "Error con la base de datos";
         }
        
    }
    
    
    public String[] consultarDatos()
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
             System.out.println("****Datos Optenidos:\n****");
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
    
   public String[] consultarNonbre(String Matricula)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT  `Ap_pat` ,  `Ap_mat` ,  `Nombre` ,  `NombreTutor` ,  `Calle` ,  `Municipio` ,  `CPostal` ,  `Telefono` ,  `Celular`, \n" +
                        "`Periodo`\n" +
                        "FROM  `alumno` \n" +
                        "WHERE  `Matricula` LIKE  '"+Matricula+"' ");
             
             System.out.println("************Consulta a la base de datos*************** "+"SSELECT  `Ap_pat` ,  `Ap_mat` ,  `Nombre` ,  `NombreTutor` ,  `Calle` ,  `Municipio` ,  `CPostal` ,  `Telefono` ,  `Celular`, \n" +
                        "`Periodo`\n" +
                        "FROM  `alumno` \n" +
                        "WHERE  `Matricula` LIKE  '"+Matricula+"' ");
             
             ResultSet rs = pS.executeQuery();
             
                         
             if(rs.next())
             {
                
                 respuestaAr = new String[11];
                 
                 respuestaAr[0] = rs.getString("Ap_pat").toString();
                 respuestaAr[1] = rs.getString("Ap_mat").toString();
                 respuestaAr[2] = rs.getString("Nombre").toString();
                                 
                 return respuestaAr;
             }
             else
             {
                  respuestaAr = new String[1];
                  respuestaAr[0] = "No se obtuvieron datos relacionados con la matricula ingresada";
                  return respuestaAr;
             }
                         
             
             
          
        
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Este es un error: \t"+ex.getMessage());
             respuestaAr = new String[1];
             respuestaAr[0] = "Error en el sistema";
             return respuestaAr;
             
         }
     
        
    }
   
   
   public String[] consultarDatosCali(String grupo)
    {
        
        int contador= 0;
        int i;
        String tipoUsu;
        

        try {
             
             pS = cn.prepareStatement("SELECT  `alumno`.`Matricula` ,  `Ap_pat` ,  `Ap_mat` ,  `Nombre` \n" +
                                "FROM  `alumno` ,  `controlgrupos` \n" +
                                "WHERE  `alumno`.`Matricula` =  `controlgrupos`.`Matricula` \n" +
                                "AND  `ClaveGrupo` =  '"+grupo+"'");
             
             System.out.println("************Consulta a la base de datos*************** "+"SELECT  `alumno`.`Matricula` ,  `Ap_pat` ,  `Ap_mat` ,  `Nombre` \n" +
                                "FROM  `alumno` ,  `controlgrupos` \n" +
                                "WHERE  `alumno`.`Matricula` =  `controlgrupos`.`Matricula` \n" +
                                "AND  `ClaveGrupo` =  '"+grupo+"'");
             
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

                    respuestaAr[x] = rs.getString("Matricula").concat("¬").concat(rs.getString("Nombre")).concat("¬").concat(rs.getString("Ap_pat")).concat(" ").concat(rs.getString("Ap_mat")).concat("¬").concat("0");
                    System.out.println(respuestaAr[x]);
                    rs.next();
                }
 
             }
             else
             {
                respuestaAr = new String[1];
                respuestaAr[0] = "No se obtuviero datos alumnos del grupo seleccionado";
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
   
   
   
   
    
}
