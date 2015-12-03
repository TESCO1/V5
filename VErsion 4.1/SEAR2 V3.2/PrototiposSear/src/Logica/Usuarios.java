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
public class Usuarios {
    
    Connection cn;
     private Statement st;
     private PreparedStatement pS;
     private String respuestaS ;
     private String[] respuestaAr;

    
    public Usuarios()
    {
        
        conectar conec = new conectar();
        cn = conec.conexion();
    }
    
    public String registrarEmpleado (String[] datos)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT * \n" +
                                            "FROM  `empleado` \n" +
                                            "WHERE ( `Matricula` =  '"+datos[0]+"'\n" +
                                            "AND  `Apellidos` =  '"+datos[1]+"'\n" +
                                            "AND  `Nombre` =  '"+datos[2]+"') OR `Matricula` =  '"+datos[0]+"'");

             ResultSet rs2 = pS2.executeQuery();
        
             
             if(!rs2.next())
             {
                 pS = cn.prepareStatement("INSERT INTO  `sear2`.`empleado` (\n" +
                                "`Matricula` ,\n" +
                                "`Apellidos` ,\n" +
                                "`Nombre` ,\n" +
                                "`Dirección` ,\n" +
                                "`Telefono`\n" +
                                ")\n" +
                                "VALUES (\n" +
                                "'"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+" ',  '"+datos[4]+"'\n" +
                                ");");

                 System.out.println("INSERT INTO  `sear2`.`empleado` (\n" +
                                "`Matricula` ,\n" +
                                "`Apellidos` ,\n" +
                                "`Nombre` ,\n" +
                                "`Dirección` ,\n" +
                                "`Telefono` \n" +
                                ")\n" +
                                "VALUES (\n" +
                                "'"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+" ',  '"+datos[4]+"'\n" +
                                ");");
                 
                int n = pS.executeUpdate();

                if(n>0)
                {
                    return respuestaS = "1"; 

                }
                else
                {
                   return respuestaS = "Error al registrar al nuevo empleado";               
                }
                        
                 
             }
             else
                 return respuestaS = "El Empleado ya ha sido registrado.";
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             return respuestaS = "Error en el servidor"; 
         }
            

    }    
    
    public String consultarUsuario (String NombreUsuario)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT * \n" +
                                    "FROM  `usuario` \n" +
                                    "WHERE  `NombreUsuario` LIKE  '"+NombreUsuario+"'");

             ResultSet rs2 = pS2.executeQuery();
        
             
             if(!rs2.next())
             {
                       
                 return respuestaS = "1";
                 
             }
             else
                 return respuestaS = "2";
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             return respuestaS = "Error en el servidor"; 
         }
            

    }    
    
    public String registrarUsuario (String[] datos)
    {
        
         PreparedStatement pS2;
         try {
             
             pS = cn.prepareStatement("INSERT INTO  `sear2`.`usuario` (\n" +
                                            "`IdUsuario` ,\n" +
                                            "`NombreUsuario` ,\n" +
                                            "`Contraseña` ,\n" +
                                            "`Matricula` ,\n" +
                                            "`TipoUsuario`\n" +
                                            ")\n" +
                                            "VALUES (\n" +
                                            "NULL ,  '"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+"'\n" +
                                            ");");

                 System.out.println("INSERT INTO  `sear2`.`usuario` (\n" +
                                            "`IdUsuario` ,\n" +
                                            "`NombreUsuario` ,\n" +
                                            "`Contraseña` ,\n" +
                                            "`Matricula` ,\n" +
                                            "`TipoUsuario`\n" +
                                            ")\n" +
                                            "VALUES (\n" +
                                            "NULL ,  '"+datos[0]+"',  '"+datos[1]+"',  '"+datos[2]+"',  '"+datos[3]+"'\n" +
                                            ");");
                 
                int n = pS.executeUpdate();

                if(n>0)
                {
                    return respuestaS = "Datos dados de alta correctamente"; 

                }
                else
                {
                   return respuestaS = "Error al registrar los datos del nuevo usuario";               
                }
                        
                       
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             return respuestaS = "Error en el servidor"; 
         }
            

    }    
    
    public String[] consultarUsuEm (String Matricula)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT  `NombreUsuario` ,`Nombre` ,  `Apellidos` ,  `TipoUsuario` \n" +
                        "FROM  `empleado` ,  `usuario` \n" +
                        "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                        "AND  `usuario`.`Matricula` =  '"+Matricula+"'");

             System.out.println("*********Preparando consulta*********\n"+"SELECT  `NombreUsuario` ,`Nombre` ,  `Apellidos` ,  `TipoUsuario` \n" +
                        "FROM  `empleado` ,  `usuario` \n" +
                        "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                        "AND  `usuario`.`Matricula` =  '"+Matricula+"'");
             
             ResultSet rs2 = pS2.executeQuery();
        
             
             if(rs2.next())
             {
                 respuestaAr = new String[3];   
                 respuestaAr[0] = rs2.getString("NombreUsuario");
                 respuestaAr[1] = rs2.getString("Apellidos").concat(" ").concat(rs2.getString("Nombre"));
                 respuestaAr[2] = rs2.getString("TipoUsuario");
                 return respuestaAr;
                 
             }
             else{
                  respuestaAr = new String[1]; 
                  respuestaAr[0] = "No se obtuvieron datos";
                 return respuestaAr;
             }
                 
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             respuestaAr = new String[1]; 
                  respuestaAr[0] = "Error con el servidor";
                 return respuestaAr;
         }
            

    }    
    
    public String EliminarUsuario(String Matricula)
    {
        
         try 
        {
            pS = cn.prepareStatement("DELETE FROM  usuario "
                                        + "WHERE `Matricula` = '"+Matricula+"'");
         
            int n = pS.executeUpdate();
             
            if(n>0)
            {
                return "El usuario asociado a esta cuenta fue dado de baja correctamente";
            }
            else
                return "Error al dar de baja";

         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("MEnsaje:"+ ex.getMessage());
             return "Error con la base de datos";
         }
        
    }
    
    
     public String EliminarEmpleado(String Matricula)
    {
        
         try 
        {
            pS = cn.prepareStatement("DELETE FROM empleado "
                                        + "WHERE `Matricula` = '"+Matricula+"'");
         
            int n = pS.executeUpdate();
             
            if(n>0)
            {
                return "Datos del empleado dados de baja correctamente";
            }
            else
                return "Error al dar de baja";

         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("MEnsaje:"+ ex.getMessage());
             return "Error con la base de datos";
         }
        
    }
     
     
     public String[] consultarUsuEDatos (String Matricula)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT  `NombreUsuario` ,`Nombre` ,  `Apellidos` ,  `TipoUsuario` \n" +
                        "FROM  `empleado` ,  `usuario` \n" +
                        "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                        "AND  `usuario`.`Matricula` =  '"+Matricula+"'");

             System.out.println("*********Preparando consulta*********\n"+"SELECT  `NombreUsuario` ,`Nombre` ,  `Apellidos` ,  `TipoUsuario` \n" +
                        "FROM  `empleado` ,  `usuario` \n" +
                        "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                        "AND  `usuario`.`Matricula` =  '"+Matricula+"'");
             
             ResultSet rs2 = pS2.executeQuery();
        
             
             if(rs2.next())
             {
                 respuestaAr = new String[4];   
                 respuestaAr[0] = rs2.getString("Nombre");
                 respuestaAr[1] = rs2.getString("Apellidos");
                 respuestaAr[2] = rs2.getNString("NombreUsuario");
                 respuestaAr[3] = rs2.getString("TipoUsuario");
                 return respuestaAr;
                 
             }
             else{
                  respuestaAr = new String[1]; 
                  respuestaAr[0] = "No se obtuvieron datos";
                 return respuestaAr;
             }
                 
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             respuestaAr = new String[1]; 
                  respuestaAr[0] = "Error con el servidor";
                 return respuestaAr;
         }
            

    }
    
     
    public String[] consultarDatosMo (String Matricula)
    {
        
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT  `Nombre` ,  `Apellidos` ,  `Telefono` ,  `Dirección` ,  `NombreUsuario` ,  `Contraseña` ,  `TipoUsuario` \n" +
                    "FROM  `empleado` ,  `usuario` \n" +
                    "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                    "AND  `usuario`.`Matricula` =  '"+Matricula+"'");

             System.out.println("*********Preparando consulta*********\n"+"SELECT  `Nombre` ,  `Apellidos` ,  `Telefono` ,  `Dirección` ,  `NombreUsuario` ,  `Contraseña` ,  `TipoUsuario` \n" +
                    "FROM  `empleado` ,  `usuario` \n" +
                    "WHERE  `empleado`.`Matricula` =  `usuario`.`Matricula` \n" +
                    "AND  `usuario`.`Matricula` =  '"+Matricula+"'");
             
             ResultSet rs2 = pS2.executeQuery();
        
             
             if(rs2.next())
             {
                 respuestaAr = new String[7];   
                 respuestaAr[0] = rs2.getString("Nombre");
                 respuestaAr[1] = rs2.getString("Apellidos");
                 respuestaAr[2] = rs2.getNString("Telefono");
                 respuestaAr[3] = rs2.getString("Dirección");
                 respuestaAr[4] = rs2.getNString("NombreUsuario");
                 respuestaAr[5] = rs2.getString("Contraseña");
                 respuestaAr[6] = rs2.getNString("TipoUsuario");
                 
                 return respuestaAr;
                 
             }
             else{
                  respuestaAr = new String[1]; 
                  respuestaAr[0] = "No se obtuvieron datos";
                 return respuestaAr;
             }
                 
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             respuestaAr = new String[1]; 
                  respuestaAr[0] = "Error con el servidor";
                 return respuestaAr;
         }
            

    }
    
    
    public String MoificarUsuario(String[] datos)
    {
        
        try {
             pS = cn.prepareStatement("UPDATE  `sear2`.`usuario` SET  `NombreUsuario` =  '"+datos[0]+"',\n" +
                                "`Contraseña` =  '"+datos[1]+"',\n" +
                                "`TipoUsuario` =  '"+datos[3]+"' WHERE  `usuario`.`Matricula` ="+datos[2]+";");
             
             
           System.out.println("UPDATE  `sear2`.`usuario` SET  `NombreUsuario` =  '"+datos[0]+"',\n" +
                                "`Contraseña` =  '"+datos[1]+"',\n" +
                                "`TipoUsuario` =  '"+datos[3]+"' WHERE  `usuario`.`Matricula` ="+datos[2]+";");
           
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
    
    public String ModificarEmpleado(String[] datos)
    {
        
        try {
             pS = cn.prepareStatement("UPDATE  `sear2`.`empleado` SET  `Matricula` =  '"+datos[1]+"',\n" +
                    "`Apellidos` =  '"+datos[2]+"',\n" +
                    "`Nombre` =  '"+datos[3]+"',\n" +
                    "`Dirección` =  '"+datos[4]+"',\n" +
                    "`Telefono` =  '"+datos[5]+"' WHERE `empleado`.`Matricula` =  '"+datos[0]+"';");
             
             
           System.out.println("UPDATE  `sear2`.`empleado` SET  `Matricula` =  '"+datos[1]+"',\n" +
                    "`Apellidos` =  '"+datos[2]+"',\n" +
                    "`Nombre` =  '"+datos[3]+"',\n" +
                    "`Dirección` =  '"+datos[4]+"',\n" +
                    "`Telefono` =  '"+datos[5]+"' WHERE `empleado`.`Matricula` =  '"+datos[0]+"';");
           
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
    
    public String[] ConsultarLogueo(String usuario, String contraseña)
    {
         
         PreparedStatement pS2;
         try {
             
             pS2 = cn.prepareStatement("SELECT  `TipoUsuario` \n" +
                                    "FROM  `usuario` \n" +
                                    "WHERE  `NombreUsuario` =  '"+usuario+"'\n" +
                                    "AND  `Contraseña` =  '"+contraseña+"'");

             System.out.println("*********Preparando consulta*********\n"+"SELECT  `TipoUsuario` \n" +
                                    "FROM  `usuario` \n" +
                                    "WHERE  `NombreUsuario` =  '"+usuario+"'\n" +
                                    "AND  `Contraseña` =  '"+contraseña+"'");
             
             ResultSet rs2 = pS2.executeQuery();
        
             
             if(rs2.next())
             {
                 respuestaAr = new String[2];   
                 respuestaAr[0] = "1";
                 respuestaAr[1] = rs2.getString("TipoUsuario");
                 
                 
                 return respuestaAr;
                 
             }
             else{
                  respuestaAr = new String[1]; 
                  respuestaAr[0] = "Error en el usuario o contraseña";
                 return respuestaAr;
             }
                 
             
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
             respuestaAr = new String[1]; 
                  respuestaAr[0] = "Error con el servidor";
                 return respuestaAr;
         }
            
    }
            
     
}
   

