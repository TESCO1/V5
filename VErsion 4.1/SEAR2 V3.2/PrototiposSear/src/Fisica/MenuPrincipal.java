/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fisica;

import Logica.AdministracionGrupos;
import Logica.AdministracionPAgos;
import Logica.ControlCalificaciones;
import Logica.ControlarMaterias;
import Logica.Estandarizacion;
import Logica.GestionAlumnos;
import Logica.GestionCriterios;
import Logica.Usuarios;
import Logica.VO;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author alexX
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    DefaultTableModel modelo3 = new DefaultTableModel();
    DefaultTableModel modelo4 = new DefaultTableModel();
    DefaultTableModel modelo5 = new DefaultTableModel();
    DefaultTableModel modelo6 = new DefaultTableModel();
    DefaultTableModel modelo7 = new DefaultTableModel();
    ControlarMaterias consulMaterias;
    GestionAlumnos ConsulAlumnos;
    AdministracionGrupos consulGrupos;
    GestionCriterios consulCriterios;
    Usuarios ConsulUsuarios;
    AdministracionPAgos ConsultasPagos;
    ControlCalificaciones consultasCalificaciones;
    private String[] datosEnviar;
    private String[] mensjRArr;
    private String mensj;
    private String usuario, contraseña;
    private String claveMateria, claveGrupoCombo;
    private String[] usoSplit;
    private Estandarizacion comprobar;
    
    
    public MenuPrincipal() {
        initComponents();
        
        comprobar = new Estandarizacion();
        ConsulAlumnos = new GestionAlumnos();
        ConsulUsuarios = new Usuarios();
        consulGrupos = new AdministracionGrupos();
        consulCriterios = new GestionCriterios();
        consulMaterias = new ControlarMaterias();
        ConsultasPagos = new AdministracionPAgos();
        consultasCalificaciones = new ControlCalificaciones();
        modelo.addColumn("Clave del grupo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Grado");
        tableModificar.setModel(modelo);
        modelo1.addColumn("Matricula");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("Apellido paterno");
        modelo1.addColumn("Apellido materno");
        modelo1.addColumn("Año de estudio");
        tableAAG.setModel(modelo1);
        modelo2.addColumn("Clave del criterio");
        modelo2.addColumn("Nombre del criterio");
        TablaConsCriterios.setModel(modelo2);
        modelo3.addColumn("Clave del criterio");
        modelo3.addColumn("Nombre");
        TablaModificarCri.setModel(modelo3);
        modelo4.addColumn("Clave del criterio");
        modelo4.addColumn("Nombre");
        TablaModificarMaterias.setModel(modelo4);
        modelo5.addColumn("Clave del criterio");
        modelo5.addColumn("Nombre");
        modelo6.addColumn("Clave del criterio");
        modelo6.addColumn("Nombre");
        TablaModificarMat.setModel(modelo6);
        modelo7.addColumn("Identificador");
        modelo7.addColumn("Materia");
        modelo7.addColumn("Bimestre");
        modelo7.addColumn("Calificación");
        TablaModificarMat.setModel(modelo7);
    }

   
    void llenarTablaAAG(String[] datosTa)
    {
        
        String[] datosT;
        
        for(int i=0 ; i< datosTa.length; i++)
        {
            datosT = datosTa[i].split("-");
            modelo1.addRow(datosT);
        }     
       
    }
    
    void llenarTablaCM(String[] datosTa)
    {      
        String[] datosT;
        
        for(int i=0 ; i< datosTa.length; i++)
        {
            datosT = datosTa[i].split("-");
            modelo4.addRow(datosT);
        }     
       
    }
    
    void llenarTablaRM(String[] datosTa)
    {      
        String[] datosT;
        
        for(int i=0 ; i< datosTa.length; i++)
        {
            datosT = datosTa[i].split("-");
            modelo5.addRow(datosT);
        }     
       
    }

    void llenarTablaMM(String[] datosTa)
    {      
        String[] datosT;
        
        for(int i=0 ; i< datosTa.length; i++)
        {
            datosT = datosTa[i].split("-");
            modelo6.addRow(datosT);
        }     
       
    }
        
    public int ComoboMunicipio(String dato)
    {
        int numero;
        
        
        
        for(int i=0; i< MunicipioCon.getItemCount(); i++)
        {
            
            if(MunicipioCon.getItemAt(i).equals(dato))
            {
                return i;
            }
            else
                System.out.println("Valor:"+ MunicipioCon.getItemAt(i));
            
        }
        return 0;
        
    }
    
     public int ComoboTipo(String dato)
    {
        int numero;
        
        
        
        for(int i=0; i< TipoUsuMo.getItemCount(); i++)
        {
            
            if(TipoUsuMo.getItemAt(i).equals(dato))
            {
                return i;
            }
            else
                System.out.println("Valor:"+ TipoUsuMo.getItemAt(i));
            
        }
        return 0;
        
    }
     
     
     void mostrarDatosPagosCon(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre del pago");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        TablaPagoCon.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
   
      void mostrarDatosPagosEli(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre del pago");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        TablaPagosEli.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
      
      

      
    void mostrarDatosPagosMo(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdentificadorPago");
        modelo.addColumn("Nombre del pago");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        TablaPagosModificar.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
    
    
    
    
    void mostrarDatosAlumnosCaliR(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Caificación");
        TablaAlumnosCaliR.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
    
    void mostrarDatosCalificacionesCon(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Materia");
        modelo.addColumn("Bimestre");
        modelo.addColumn("Calificación");
        TablaCaliCon.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
    
    void mostrarDatosCalificacionesMon(String[] datos)
    {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Materia");
        modelo.addColumn("Bimestre");
        modelo.addColumn("Calificación");
        TablaCalicacionesMo.setModel(modelo);
        
        String[] datosT;
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
    
    void mostrarCalifEliminar(String[] datos)
    {
        String[] datosT;
        
         
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Identificador");
        modelo.addColumn("Materia");
        modelo.addColumn("Bimestre");
        modelo.addColumn("Calificación");
        TablaEliminarCalificaciones.setModel(modelo);
        
        for(int i=0 ; i< datos.length; i++)
        {
            datosT = datos[i].split("¬");
            modelo.addRow(datosT);
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AdministrarUsuarios = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        MenuPrincipalDirectora = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jButton21 = new javax.swing.JButton();
        Eliminarpagos = new javax.swing.JPopupMenu();
        EliminarPago = new javax.swing.JMenuItem();
        Controldecalificaciones = new javax.swing.JDialog();
        jPanel27 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        ConsultarCalificaciones = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        MatriculaCaliCon = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCaliCon = new javax.swing.JTable();
        jButton48 = new javax.swing.JButton();
        ModificarCalificaciones = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaCalicacionesMo = new javax.swing.JTable();
        jButton49 = new javax.swing.JButton();
        MatriculaCaliMo = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
        EliminarCalificaciones = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaEliminarCalificaciones = new javax.swing.JTable();
        jButton51 = new javax.swing.JButton();
        matEliminarCalif = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        RegistrarCalificaciones = new javax.swing.JPanel();
        GrupoCaliR = new javax.swing.JComboBox();
        MateriaCaliR = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaAlumnosCaliR = new javax.swing.JTable();
        DiaCaliR = new javax.swing.JComboBox();
        MesCaliR = new javax.swing.JComboBox();
        AnioCaliR = new javax.swing.JComboBox();
        BimestreCaliR = new javax.swing.JComboBox();
        jButton47 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar9 = new javax.swing.JMenuBar();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        MenuCalificaciones = new javax.swing.JPopupMenu();
        EliminarCalificacion = new javax.swing.JMenuItem();
        AdministracionGrupos = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        ConsultarGrupos = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        ClaveGConsulta = new javax.swing.JTextField();
        jButton52 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        periodoConsulta = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        gradoConsulta = new javax.swing.JTextField();
        EliminarGrupos = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        claveEliminar = new javax.swing.JTextField();
        jButton53 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jButton54 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        ModificarGrupos = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        claveModificar = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableModificar = new javax.swing.JTable();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        RegistroGrupos = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        periodoGrup = new javax.swing.JComboBox();
        claveGrupo = new javax.swing.JTextField();
        GradoGru = new javax.swing.JComboBox();
        jButton56 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        AgregarAlumnos = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        claveAAG = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableAAG = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        jMenuBar10 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        ContralarMaterias = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        ConsultarMaterias = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        descripMatConsultar = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        claveMatConsultar = new javax.swing.JTextField();
        jButton66 = new javax.swing.JButton();
        nombreMatConsultar = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaModificarMaterias = new javax.swing.JTable();
        EliminarMaterias = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        claveEliminarMat = new javax.swing.JTextField();
        jButton64 = new javax.swing.JButton();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        NombMatEliminar = new javax.swing.JTextField();
        jButton65 = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        DescripMatEliminar = new javax.swing.JTextArea();
        ModificarMaterias = new javax.swing.JPanel();
        jButton70 = new javax.swing.JButton();
        descripMatModificar = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        nombreMatModificar = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        claveModificarMat = new javax.swing.JTextField();
        jButton63 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablaModificarMat = new javax.swing.JTable();
        jLabel147 = new javax.swing.JLabel();
        RegistroMaterias = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        nombreMatRegistrar = new javax.swing.JTextField();
        DescripMatRegistrar = new javax.swing.JTextField();
        jButton68 = new javax.swing.JButton();
        jLabel125 = new javax.swing.JLabel();
        claveMatRegistrar = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaAgregarMat = new javax.swing.JTable();
        labelagregarCri = new javax.swing.JLabel();
        jMenuBar11 = new javax.swing.JMenuBar();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        GestionCriterios = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jButton67 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        ConsultarCriterios = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TablaConsCriterios = new javax.swing.JTable();
        jLabel142 = new javax.swing.JLabel();
        ClaveCRConsultar = new javax.swing.JTextField();
        jButton80 = new javax.swing.JButton();
        EliminarCriterios = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        claveEliminarCri = new javax.swing.JTextField();
        jButton74 = new javax.swing.JButton();
        jLabel132 = new javax.swing.JLabel();
        nomCriEliminar = new javax.swing.JTextField();
        jButton75 = new javax.swing.JButton();
        jLabel137 = new javax.swing.JLabel();
        ModificarCriterios = new javax.swing.JPanel();
        jButton76 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        TablaModificarCri = new javax.swing.JTable();
        jLabel140 = new javax.swing.JLabel();
        ClaveModificarCri = new javax.swing.JTextField();
        jButton77 = new javax.swing.JButton();
        RegistroCriterios = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        NombreCrRegistrar = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        ClaveCrRegistro = new javax.swing.JTextField();
        jButton78 = new javax.swing.JButton();
        jMenuBar12 = new javax.swing.JMenuBar();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        MenuPrincipalProfesor = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jButton81 = new javax.swing.JButton();
        jMenuBar13 = new javax.swing.JMenuBar();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenu26 = new javax.swing.JMenu();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jLabel136 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        AgregarAlumnosGrupo = new javax.swing.JPopupMenu();
        jMenuItem38 = new javax.swing.JMenuItem();
        AgregarCriterio = new javax.swing.JPopupMenu();
        jMenuItem39 = new javax.swing.JMenuItem();
        ModificarCriterio = new javax.swing.JPopupMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        LogeoUsuario = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Contraseña = new javax.swing.JPasswordField();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        AdministracionPagos = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ConsultarPagos = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        MatriculaPagoCon = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        NombrePagoCon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPagoCon = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        EliminarPagos = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        MatriculaPagosEli = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        AlumnosPagosEli = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPagosEli = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        ModificarPagos = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        MatriculaPagoMo = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        AlumnoPagoMo = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        TablaPagosModificar = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        RegistroPagos = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        NombrePagoR = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        MontoPagoR = new javax.swing.JTextField();
        AlumnoPagoR = new javax.swing.JComboBox();
        DiaPagoR = new javax.swing.JComboBox();
        MesPagoR = new javax.swing.JComboBox();
        AnioPagoR = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        Eliminarpagos1 = new javax.swing.JPopupMenu();
        EliminarPago1 = new javax.swing.JMenuItem();
        MenuPagoEli = new javax.swing.JPopupMenu();
        EliminarPagoItem = new javax.swing.JMenuItem();
        AdministrarUsuariosOPC = new javax.swing.JDialog();
        Registrar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        ClaveEmpleadoR = new javax.swing.JTextField();
        NombreUsuarioR = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        NombreEmR = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        ApellidosUsuR = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        TelUsuR = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        DireccionUsuR = new javax.swing.JTextField();
        TiposUsuR = new javax.swing.JComboBox();
        ContraUsuR = new javax.swing.JPasswordField();
        VContraUsuR = new javax.swing.JPasswordField();
        Eliminar = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        ClaveUsuEli = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        MensajeUsuEli = new javax.swing.JLabel();
        LableNomUsuEli = new javax.swing.JLabel();
        NombreComUsuEli = new javax.swing.JTextField();
        LabelNDUsuELi = new javax.swing.JLabel();
        NombreDUsuEli = new javax.swing.JTextField();
        LabelTipo = new javax.swing.JLabel();
        TipoUSuEli = new javax.swing.JTextField();
        ButonUsuELi = new javax.swing.JButton();
        Consultar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ClaveUsuCon = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        NombreUsuCon = new javax.swing.JTextField();
        ApellidosUsuCon = new javax.swing.JTextField();
        NombreDUsuCon = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jButton28 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        TipoUsuCon = new javax.swing.JTextField();
        Modificar = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jButton41 = new javax.swing.JButton();
        TipoUsuMo = new javax.swing.JComboBox();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        NombreDUsuMo = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        ClaveEmMo = new javax.swing.JTextField();
        NombreEmMo = new javax.swing.JTextField();
        ApellidosUsuMo = new javax.swing.JTextField();
        TelefonoUsuMo = new javax.swing.JTextField();
        DireccionUsuMo = new javax.swing.JTextField();
        jButton73 = new javax.swing.JButton();
        ContraseñaUsuMo = new javax.swing.JPasswordField();
        VContraseñaUsuMo = new javax.swing.JPasswordField();
        ModificarOPC = new javax.swing.JPanel();
        OpcionUsuario = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        OpcionContraseña = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        OpcionUsuContra = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        GestionDeInscripcionesAlumno = new javax.swing.JDialog();
        jPanel19 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        ConsultarAlumno1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        Ap_patCon = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        Ap_matCon = new javax.swing.JTextField();
        NombreCon = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        MatriculaCon = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        TutorCon = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        PeriodoConAlum = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        CalleCon = new javax.swing.JTextField();
        MunicipioCon = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        CPostaCon = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        TeLocCon = new javax.swing.JTextField();
        CelCon = new javax.swing.JTextField();
        ModificarAlumno1 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        CalleMo = new javax.swing.JTextField();
        MunicipioMo = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        CPostalMo = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        TelLocMo = new javax.swing.JTextField();
        CelMo = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        Ap_patMo = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        AP_matMo = new javax.swing.JTextField();
        NombreMo = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        MatriculaMo = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        TutorMo = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jLabel157 = new javax.swing.JLabel();
        PeriodoModAlumno = new javax.swing.JTextField();
        EliminarAlumno1 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        Ap_patEli = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        Ap_matEli = new javax.swing.JTextField();
        NombreEli = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        TutorEli = new javax.swing.JTextField();
        BotonAceptarEli = new javax.swing.JButton();
        MensajePreventivoEli = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        MatriculaEli = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        RegistrarAlumno1 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        ap_patR = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        ap_matR = new javax.swing.JTextField();
        NombreR = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        MatriculaR = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        TutorR = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        PeriodoAlumno = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        CalleR = new javax.swing.JTextField();
        MunicipioR = new javax.swing.JComboBox();
        jLabel113 = new javax.swing.JLabel();
        CPostalR = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        TelLocalR = new javax.swing.JTextField();
        CelR = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        AdministrarUsuarios.setMinimumSize(new java.awt.Dimension(442, 363));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(442, 363));
        jPanel2.setMinimumSize(new java.awt.Dimension(442, 363));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro boton.png"))); // NOI18N
        jToggleButton1.setText("Registrar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultarboton.png"))); // NOI18N
        jToggleButton2.setText("Consultar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficar boton.png"))); // NOI18N
        jToggleButton3.setText("Modificar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar boton.png"))); // NOI18N
        jToggleButton4.setText("Eliminar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("Administracion de Usuarios");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(jToggleButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jToggleButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(240, 240, 240))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)))))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jMenu3.setText("Menu");

        jMenuItem4.setText("Logeo Usuario");
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Administrar Usuarios");
        jMenu3.add(jMenuItem6);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Otras Opciones");

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar2.add(jMenu4);

        AdministrarUsuarios.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout AdministrarUsuariosLayout = new javax.swing.GroupLayout(AdministrarUsuarios.getContentPane());
        AdministrarUsuarios.getContentPane().setLayout(AdministrarUsuariosLayout);
        AdministrarUsuariosLayout.setHorizontalGroup(
            AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AdministrarUsuariosLayout.setVerticalGroup(
            AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jLabel8.setText("jLabel8");

        jLabel11.setText("jLabel11");

        jLabel28.setText("jLabel28");

        jTextField14.setText("jTextField14");

        jLabel37.setText("jLabel37");

        jButton8.setText("jButton8");

        MenuPrincipalDirectora.setMinimumSize(new java.awt.Dimension(460, 440));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(460, 440));
        jPanel10.setMinimumSize(new java.awt.Dimension(460, 440));
        jPanel10.setPreferredSize(new java.awt.Dimension(460, 440));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 0));
        jLabel46.setText("Portal Directora");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InscripcionB.png"))); // NOI18N
        jButton16.setText("Gestionar Inscripciones de alumnos");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ColegiaturaB.png"))); // NOI18N
        jButton17.setText("Administrar pagos de colegiatura");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calificacionesB.png"))); // NOI18N
        jButton18.setText("Control de calificaciones");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grupoB.png"))); // NOI18N
        jButton19.setText("Admnistrar Grupos");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/materiaB.png"))); // NOI18N
        jButton20.setText("Control de materias");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/criteriosB.png"))); // NOI18N
        jButton22.setText("Gestionar los criterios de evaluación");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel47)
                .addGap(74, 74, 74)
                .addComponent(jLabel46)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton22))
                .addGap(82, 82, 82))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel47))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addGap(11, 11, 11)
                .addComponent(jButton18)
                .addGap(18, 18, 18)
                .addComponent(jButton19)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addGap(18, 18, 18)
                .addComponent(jButton22)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jMenu13.setText("Menu");

        jMenuItem16.setText("Administrar Usuarios");
        jMenu13.add(jMenuItem16);

        jMenuBar7.add(jMenu13);

        jMenu14.setText("Otras Opciones");

        jMenuItem17.setText("Salir del sistema");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem17);

        jMenuItem18.setText("Cerrar Sesión");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem18);

        jMenuBar7.add(jMenu14);

        MenuPrincipalDirectora.setJMenuBar(jMenuBar7);

        javax.swing.GroupLayout MenuPrincipalDirectoraLayout = new javax.swing.GroupLayout(MenuPrincipalDirectora.getContentPane());
        MenuPrincipalDirectora.getContentPane().setLayout(MenuPrincipalDirectoraLayout);
        MenuPrincipalDirectoraLayout.setHorizontalGroup(
            MenuPrincipalDirectoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPrincipalDirectoraLayout.setVerticalGroup(
            MenuPrincipalDirectoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton21.setText("jButton21");

        EliminarPago.setText("Eliminar el pago seleccionado");
        EliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPagoActionPerformed(evt);
            }
        });
        Eliminarpagos.add(EliminarPago);

        Controldecalificaciones.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel27.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(102, 102, 0));
        jLabel119.setText("Control de calificaciones");

        jButton33.setText("Registrar");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton39.setText("Consultar");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Modificar");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        ConsultarCalificaciones.setBackground(new java.awt.Color(255, 255, 255));

        jLabel58.setText("Ingrese la matricula del alumno:");

        TablaCaliCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Materia ", "Bimestre ", "Calificacion "
            }
        ));
        jScrollPane4.setViewportView(TablaCaliCon);

        jButton48.setText("Mostrar calficaciones");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultarCalificacionesLayout = new javax.swing.GroupLayout(ConsultarCalificaciones);
        ConsultarCalificaciones.setLayout(ConsultarCalificacionesLayout);
        ConsultarCalificacionesLayout.setHorizontalGroup(
            ConsultarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarCalificacionesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ConsultarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultarCalificacionesLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MatriculaCaliCon, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarCalificacionesLayout.createSequentialGroup()
                        .addComponent(jButton48)
                        .addGap(194, 194, 194)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        ConsultarCalificacionesLayout.setVerticalGroup(
            ConsultarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarCalificacionesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(ConsultarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(MatriculaCaliCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton48)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        ModificarCalificaciones.setBackground(new java.awt.Color(255, 255, 255));

        TablaCalicacionesMo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Materia ", "Bimestre ", "Calificacion "
            }
        ));
        jScrollPane5.setViewportView(TablaCalicacionesMo);

        jButton49.setText("Mostrar calficaciones");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jLabel59.setText("Ingrese la matricula del alumno:");

        jButton50.setText("Guardar Cambios");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificarCalificacionesLayout = new javax.swing.GroupLayout(ModificarCalificaciones);
        ModificarCalificaciones.setLayout(ModificarCalificacionesLayout);
        ModificarCalificacionesLayout.setHorizontalGroup(
            ModificarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarCalificacionesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ModificarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarCalificacionesLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MatriculaCaliMo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ModificarCalificacionesLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jButton50))
                    .addGroup(ModificarCalificacionesLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jButton49)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        ModificarCalificacionesLayout.setVerticalGroup(
            ModificarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarCalificacionesLayout.createSequentialGroup()
                .addGroup(ModificarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(MatriculaCaliMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton49)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton50)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        EliminarCalificaciones.setBackground(new java.awt.Color(255, 255, 255));

        TablaEliminarCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identificador", " Materia", "Bimestre ", "Calificacion  "
            }
        ));
        TablaEliminarCalificaciones.setComponentPopupMenu(MenuCalificaciones);
        TablaEliminarCalificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(TablaEliminarCalificaciones);

        jButton51.setText("Mostrar calficaciones");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jLabel60.setText("Ingrese la matricula del alumno:");

        jLabel61.setText("Seleccione la opción deseada sobre la tabla y de click derecho eliminar.");

        javax.swing.GroupLayout EliminarCalificacionesLayout = new javax.swing.GroupLayout(EliminarCalificaciones);
        EliminarCalificaciones.setLayout(EliminarCalificacionesLayout);
        EliminarCalificacionesLayout.setHorizontalGroup(
            EliminarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCalificacionesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(EliminarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EliminarCalificacionesLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(jLabel60)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(matEliminarCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarCalificacionesLayout.createSequentialGroup()
                            .addComponent(jButton51)
                            .addGap(194, 194, 194)))
                    .addGroup(EliminarCalificacionesLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        EliminarCalificacionesLayout.setVerticalGroup(
            EliminarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCalificacionesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(EliminarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(matEliminarCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton51)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel61)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        RegistrarCalificaciones.setBackground(new java.awt.Color(255, 255, 255));

        GrupoCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el grupo", " " }));
        GrupoCaliR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GrupoCaliRItemStateChanged(evt);
            }
        });

        MateriaCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione la materia", " " }));
        MateriaCaliR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MateriaCaliRItemStateChanged(evt);
            }
        });

        TablaAlumnosCaliR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre ", "Apellidos", "Calificacion"
            }
        ));
        jScrollPane3.setViewportView(TablaAlumnosCaliR);

        DiaCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        MesCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        AnioCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));

        BimestreCaliR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el binestre a evaluar", "Primer bimestre", "Segundo bimestre", "Tercer bimestre", "Cuarto bimestre ", "Quinto bimestre", "Sexto Bimestre", " ", " " }));

        jButton47.setText("Registrar");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarCalificacionesLayout = new javax.swing.GroupLayout(RegistrarCalificaciones);
        RegistrarCalificaciones.setLayout(RegistrarCalificacionesLayout);
        RegistrarCalificacionesLayout.setHorizontalGroup(
            RegistrarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarCalificacionesLayout.createSequentialGroup()
                .addGroup(RegistrarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarCalificacionesLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(BimestreCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiaCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MesCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnioCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton47))
                    .addGroup(RegistrarCalificacionesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarCalificacionesLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(MateriaCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GrupoCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        RegistrarCalificacionesLayout.setVerticalGroup(
            RegistrarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarCalificacionesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(RegistrarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GrupoCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MateriaCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RegistrarCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnioCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BimestreCaliR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton47))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jButton26.setText("Imprimir actas de calificaciones");

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegistrarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel119)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton33)
                        .addGap(18, 18, 18)
                        .addComponent(jButton39)
                        .addGap(18, 18, 18)
                        .addComponent(jButton40)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(27, 27, 27)
                        .addComponent(jButton26)
                        .addGap(109, 109, 109))))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ConsultarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ModificarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(EliminarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel118))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel119)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton39)
                    .addComponent(jButton40)
                    .addComponent(jButton26)
                    .addComponent(jButton33)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegistrarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(ConsultarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(ModificarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(EliminarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu17.setText("Menu");

        jMenuItem22.setText("Administrar Usuarios");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem22);

        jMenuBar9.add(jMenu17);

        jMenu18.setText("Otras Opciones");

        jMenuItem23.setText("Salir del sistema");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem23);

        jMenuItem24.setText("Cerrar Sesión");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem24);

        jMenuItem42.setText("Regresar al portal Directora");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem42);

        jMenuBar9.add(jMenu18);

        Controldecalificaciones.setJMenuBar(jMenuBar9);

        javax.swing.GroupLayout ControldecalificacionesLayout = new javax.swing.GroupLayout(Controldecalificaciones.getContentPane());
        Controldecalificaciones.getContentPane().setLayout(ControldecalificacionesLayout);
        ControldecalificacionesLayout.setHorizontalGroup(
            ControldecalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ControldecalificacionesLayout.setVerticalGroup(
            ControldecalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        EliminarCalificacion.setText("Eliminar");
        EliminarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCalificacionActionPerformed(evt);
            }
        });
        MenuCalificaciones.add(EliminarCalificacion);

        AdministracionGrupos.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel5.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(102, 102, 0));
        jLabel63.setText("Administrar grupos");

        jButton42.setText("Registrar");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Consultar");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Modificar");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Eliminar");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        ConsultarGrupos.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarGrupos.setMaximumSize(new java.awt.Dimension(644, 352));
        ConsultarGrupos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel64.setText("Ingrese clave del grupo");

        jButton52.setText("Mostrar datos del grupo");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jLabel69.setText("Periodo del grupo:");

        periodoConsulta.setEditable(false);

        jLabel70.setText("Grado del grupo:");

        gradoConsulta.setEditable(false);
        gradoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradoConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultarGruposLayout = new javax.swing.GroupLayout(ConsultarGrupos);
        ConsultarGrupos.setLayout(ConsultarGruposLayout);
        ConsultarGruposLayout.setHorizontalGroup(
            ConsultarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarGruposLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ConsultarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultarGruposLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(ClaveGConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton52))
                    .addGroup(ConsultarGruposLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(periodoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel70)
                        .addGap(18, 18, 18)
                        .addComponent(gradoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConsultarGruposLayout.setVerticalGroup(
            ConsultarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarGruposLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(ConsultarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(ClaveGConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52))
                .addGap(57, 57, 57)
                .addGroup(ConsultarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addComponent(periodoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EliminarGrupos.setBackground(new java.awt.Color(255, 255, 255));
        EliminarGrupos.setMaximumSize(new java.awt.Dimension(644, 352));
        EliminarGrupos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel81.setText("Ingrese la clave del grupo ");

        jButton53.setText("Eliminar grupo");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jLabel67.setText("Periodo del grupo:");

        jLabel68.setText("Grado del grupo:");

        jTextField33.setEditable(false);

        jTextField34.setEditable(false);
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        jButton54.setText("Aceptar");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jLabel66.setForeground(new java.awt.Color(204, 0, 0));
        jLabel66.setText("Seguro que desea eliminar el siguiente grupo:");

        javax.swing.GroupLayout EliminarGruposLayout = new javax.swing.GroupLayout(EliminarGrupos);
        EliminarGrupos.setLayout(EliminarGruposLayout);
        EliminarGruposLayout.setHorizontalGroup(
            EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarGruposLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarGruposLayout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EliminarGruposLayout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addGroup(EliminarGruposLayout.createSequentialGroup()
                                .addComponent(claveEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton53))))
                    .addGroup(EliminarGruposLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jButton54)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EliminarGruposLayout.setVerticalGroup(
            EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarGruposLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(claveEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53))
                .addGap(52, 52, 52)
                .addComponent(jLabel66)
                .addGap(18, 18, 18)
                .addGroup(EliminarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jButton54)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        ModificarGrupos.setBackground(new java.awt.Color(255, 255, 255));
        ModificarGrupos.setMaximumSize(new java.awt.Dimension(644, 352));
        ModificarGrupos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel73.setText("Clave de grupo ");

        tableModificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave del grupo", "Periodo ", "Grado"
            }
        ));
        jScrollPane9.setViewportView(tableModificar);

        jButton57.setText("Filtrar");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setText("Guardar cambios");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jLabel71.setText("Modifique los datos directamente el la tabla al finalizar dar click en guardar cambios");

        javax.swing.GroupLayout ModificarGruposLayout = new javax.swing.GroupLayout(ModificarGrupos);
        ModificarGrupos.setLayout(ModificarGruposLayout);
        ModificarGruposLayout.setHorizontalGroup(
            ModificarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarGruposLayout.createSequentialGroup()
                .addGroup(ModificarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarGruposLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButton58))
                    .addGroup(ModificarGruposLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel71))
                    .addGroup(ModificarGruposLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(ModificarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ModificarGruposLayout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(claveModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton57)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ModificarGruposLayout.setVerticalGroup(
            ModificarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarGruposLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(ModificarGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(claveModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addGap(15, 15, 15)
                .addComponent(jButton58)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        RegistroGrupos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel72.setText("Clave de grupo ");

        periodoGrup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el periodo", "14/15", "15/16", "17/18", "19/20", "20/21", "21/22", "22/23", "23/24", "24/25", "25/26", "26/27", "27/28", "28/29", "30/31", " " }));

        GradoGru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el grado para el grupo", "1", "2", "3" }));

        jButton56.setText("Registrar grupo");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistroGruposLayout = new javax.swing.GroupLayout(RegistroGrupos);
        RegistroGrupos.setLayout(RegistroGruposLayout);
        RegistroGruposLayout.setHorizontalGroup(
            RegistroGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroGruposLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(RegistroGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroGruposLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(GradoGru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistroGruposLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton56))
                    .addGroup(RegistroGruposLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(periodoGrup, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        RegistroGruposLayout.setVerticalGroup(
            RegistroGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroGruposLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(RegistroGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(periodoGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(GradoGru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton56)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jButton55.setText("Agregar alumnos al grupo");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        AgregarAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        AgregarAlumnos.setMaximumSize(new java.awt.Dimension(644, 352));
        AgregarAlumnos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel65.setText("Ingrese la clave del grupo");

        tableAAG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Año de estudio"
            }
        ));
        tableAAG.setComponentPopupMenu(AgregarAlumnosGrupo);
        jScrollPane7.setViewportView(tableAAG);

        jLabel76.setText("Seleccione el alumno y dar click derecho agregar al grupo ");

        javax.swing.GroupLayout AgregarAlumnosLayout = new javax.swing.GroupLayout(AgregarAlumnos);
        AgregarAlumnos.setLayout(AgregarAlumnosLayout);
        AgregarAlumnosLayout.setHorizontalGroup(
            AgregarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarAlumnosLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(AgregarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarAlumnosLayout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addGap(18, 18, 18)
                        .addComponent(claveAAG, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgregarAlumnosLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel76))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AgregarAlumnosLayout.setVerticalGroup(
            AgregarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarAlumnosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(AgregarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(claveAAG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel76)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(RegistroGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton42)
                                .addGap(35, 35, 35)
                                .addComponent(jButton43))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel62)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton44)
                                .addGap(36, 36, 36)
                                .addComponent(jButton45)
                                .addGap(18, 18, 18)
                                .addComponent(jButton55))
                            .addComponent(jLabel63))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(ConsultarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(ModificarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AgregarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel62))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel63)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton43)
                        .addComponent(jButton44)
                        .addComponent(jButton45)
                        .addComponent(jButton55))
                    .addComponent(jButton42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(RegistroGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(ConsultarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(EliminarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(ModificarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(AgregarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(141, 141, 141)))
        );

        jMenu19.setText("Menu");

        jMenuItem25.setText("Administrar Usuarios");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem25);

        jMenuBar10.add(jMenu19);

        jMenu20.setText("Otras Opciones");

        jMenuItem37.setText("Regresar al portal Directora");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem37);

        jMenuItem26.setText("Salir del sistema");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem26);

        jMenuItem27.setText("Cerrar Sesión");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem27);

        jMenuBar10.add(jMenu20);

        AdministracionGrupos.setJMenuBar(jMenuBar10);

        javax.swing.GroupLayout AdministracionGruposLayout = new javax.swing.GroupLayout(AdministracionGrupos.getContentPane());
        AdministracionGrupos.getContentPane().setLayout(AdministracionGruposLayout);
        AdministracionGruposLayout.setHorizontalGroup(
            AdministracionGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AdministracionGruposLayout.setVerticalGroup(
            AdministracionGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        ContralarMaterias.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel6.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(102, 102, 0));
        jLabel75.setText("Control materias");

        jButton59.setText("Registrar");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setText("Consultar");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setText("Modificar");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setText("Eliminar");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        ConsultarMaterias.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarMaterias.setMaximumSize(new java.awt.Dimension(644, 352));
        ConsultarMaterias.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel134.setText("Descripcion");

        jLabel126.setText("Filtrar por clave de materia");

        jButton66.setText("Filtrar");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jLabel146.setText("Nombre");

        TablaModificarMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave del criterio", "Nombre"
            }
        ));
        jScrollPane8.setViewportView(TablaModificarMaterias);

        javax.swing.GroupLayout ConsultarMateriasLayout = new javax.swing.GroupLayout(ConsultarMaterias);
        ConsultarMaterias.setLayout(ConsultarMateriasLayout);
        ConsultarMateriasLayout.setHorizontalGroup(
            ConsultarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarMateriasLayout.createSequentialGroup()
                .addGroup(ConsultarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultarMateriasLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claveMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarMateriasLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descripMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConsultarMateriasLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConsultarMateriasLayout.setVerticalGroup(
            ConsultarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarMateriasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ConsultarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(claveMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ConsultarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(descripMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreMatConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        EliminarMaterias.setBackground(new java.awt.Color(255, 255, 255));
        EliminarMaterias.setMaximumSize(new java.awt.Dimension(644, 352));
        EliminarMaterias.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel121.setText("Clave de la materia");

        jButton64.setText("Eliminar");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jLabel122.setText("Nombre Materia");

        jLabel123.setText("Descripcion ");

        NombMatEliminar.setEditable(false);

        jButton65.setText("Aceptar");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jLabel124.setForeground(new java.awt.Color(204, 0, 0));
        jLabel124.setText("Seguro que desea eliminar la materia correspondiente a los siguietes datos:");

        DescripMatEliminar.setColumns(20);
        DescripMatEliminar.setRows(5);
        jScrollPane10.setViewportView(DescripMatEliminar);

        javax.swing.GroupLayout EliminarMateriasLayout = new javax.swing.GroupLayout(EliminarMaterias);
        EliminarMaterias.setLayout(EliminarMateriasLayout);
        EliminarMateriasLayout.setHorizontalGroup(
            EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarMateriasLayout.createSequentialGroup()
                .addGroup(EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarMateriasLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombMatEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EliminarMateriasLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jButton65))
                    .addGroup(EliminarMateriasLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel124))
                    .addGroup(EliminarMateriasLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel121)
                        .addGap(41, 41, 41)
                        .addComponent(claveEliminarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton64)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EliminarMateriasLayout.setVerticalGroup(
            EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarMateriasLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(claveEliminarMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton64))
                .addGap(44, 44, 44)
                .addComponent(jLabel124)
                .addGap(27, 27, 27)
                .addGroup(EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel122)
                        .addComponent(jLabel123)
                        .addComponent(NombMatEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jButton65)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        ModificarMaterias.setBackground(new java.awt.Color(255, 255, 255));
        ModificarMaterias.setMaximumSize(new java.awt.Dimension(644, 352));
        ModificarMaterias.setMinimumSize(new java.awt.Dimension(644, 352));

        jButton70.setText("Guardar Cambios");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        jLabel133.setText("Descripcion de la materia");

        jLabel77.setText("Nombre materia");

        jLabel78.setText("Ingrese clave de la materia");

        jButton63.setText("Buscar");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        TablaModificarMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave del criterio ", "Nombre"
            }
        ));
        TablaModificarMat.setComponentPopupMenu(ModificarCriterio);
        jScrollPane11.setViewportView(TablaModificarMat);

        javax.swing.GroupLayout ModificarMateriasLayout = new javax.swing.GroupLayout(ModificarMaterias);
        ModificarMaterias.setLayout(ModificarMateriasLayout);
        ModificarMateriasLayout.setHorizontalGroup(
            ModificarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarMateriasLayout.createSequentialGroup()
                .addGroup(ModificarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarMateriasLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claveModificarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton63))
                    .addGroup(ModificarMateriasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreMatModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel133)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descripMatModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ModificarMateriasLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jButton70))
                    .addGroup(ModificarMateriasLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ModificarMateriasLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel147)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ModificarMateriasLayout.setVerticalGroup(
            ModificarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarMateriasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ModificarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(claveModificarMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63))
                .addGap(18, 18, 18)
                .addGroup(ModificarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(descripMatModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77)
                    .addComponent(nombreMatModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton70)
                .addGap(7, 7, 7)
                .addComponent(jLabel147)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        RegistroMaterias.setBackground(new java.awt.Color(255, 255, 255));

        jLabel130.setText("Nombre de la materia");

        jLabel131.setText("Descripcion de la materia");

        DescripMatRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripMatRegistrarActionPerformed(evt);
            }
        });

        jButton68.setText("Registrar materia");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jLabel125.setText("Clave de la materia");

        tablaAgregarMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ClaveCriterio", "Nombre"
            }
        ));
        tablaAgregarMat.setComponentPopupMenu(AgregarCriterio);
        jScrollPane13.setViewportView(tablaAgregarMat);

        labelagregarCri.setText("Registrar la materia para poder agregar criterios a la materia");

        javax.swing.GroupLayout RegistroMateriasLayout = new javax.swing.GroupLayout(RegistroMaterias);
        RegistroMaterias.setLayout(RegistroMateriasLayout);
        RegistroMateriasLayout.setHorizontalGroup(
            RegistroMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroMateriasLayout.createSequentialGroup()
                .addGroup(RegistroMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroMateriasLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel125)
                        .addGap(18, 18, 18)
                        .addComponent(claveMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistroMateriasLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton68))
                    .addGroup(RegistroMateriasLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistroMateriasLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel131)
                        .addGap(46, 46, 46)
                        .addComponent(DescripMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistroMateriasLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(labelagregarCri)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        RegistroMateriasLayout.setVerticalGroup(
            RegistroMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroMateriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistroMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(nombreMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125)
                    .addComponent(claveMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistroMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(DescripMatRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton68)
                .addGap(9, 9, 9)
                .addComponent(labelagregarCri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(RegistroMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel74)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel75)
                        .addGap(0, 223, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton59)
                .addGap(35, 35, 35)
                .addComponent(jButton60)
                .addGap(34, 34, 34)
                .addComponent(jButton61)
                .addGap(36, 36, 36)
                .addComponent(jButton62)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(ConsultarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(ModificarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel74))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel75)))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton60)
                        .addComponent(jButton61)
                        .addComponent(jButton62))
                    .addComponent(jButton59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(RegistroMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(ConsultarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(EliminarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(ModificarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        jMenu21.setText("Menu");

        jMenuItem28.setText("Administrar Usuarios");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem28);

        jMenuBar11.add(jMenu21);

        jMenu22.setText("Otras Opciones");

        jMenuItem29.setText("Salir del sistema");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem29);

        jMenuItem30.setText("Cerrar Sesión");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem30);

        jMenuItem43.setText("Regresar al portal directora");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem43);

        jMenuBar11.add(jMenu22);

        ContralarMaterias.setJMenuBar(jMenuBar11);

        javax.swing.GroupLayout ContralarMateriasLayout = new javax.swing.GroupLayout(ContralarMaterias.getContentPane());
        ContralarMaterias.getContentPane().setLayout(ContralarMateriasLayout);
        ContralarMateriasLayout.setHorizontalGroup(
            ContralarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContralarMateriasLayout.setVerticalGroup(
            ContralarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        GestionCriterios.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel7.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(102, 102, 0));
        jLabel127.setText("Gestión de criterios de evaluación");

        jButton67.setText("Registrar");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton69.setText("Consultar");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jButton71.setText("Modificar");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        jButton72.setText("Eliminar");
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        ConsultarCriterios.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarCriterios.setMaximumSize(new java.awt.Dimension(644, 352));
        ConsultarCriterios.setMinimumSize(new java.awt.Dimension(644, 352));

        TablaConsCriterios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave del criterio", "Nombre del criterio"
            }
        ));
        jScrollPane17.setViewportView(TablaConsCriterios);

        jLabel142.setText("Ingrese clave del criterio");

        jButton80.setText("Filtrar");
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultarCriteriosLayout = new javax.swing.GroupLayout(ConsultarCriterios);
        ConsultarCriterios.setLayout(ConsultarCriteriosLayout);
        ConsultarCriteriosLayout.setHorizontalGroup(
            ConsultarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarCriteriosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarCriteriosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClaveCRConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton80)
                .addGap(194, 194, 194))
        );
        ConsultarCriteriosLayout.setVerticalGroup(
            ConsultarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarCriteriosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(ConsultarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton80)
                    .addComponent(jLabel142)
                    .addComponent(ClaveCRConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EliminarCriterios.setBackground(new java.awt.Color(255, 255, 255));
        EliminarCriterios.setMaximumSize(new java.awt.Dimension(644, 352));
        EliminarCriterios.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel129.setText("Clave del criterio");

        jButton74.setText("Eliminar");
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });

        jLabel132.setText("Nombre del criterio");

        nomCriEliminar.setEditable(false);

        jButton75.setText("Aceptar");
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });

        jLabel137.setForeground(new java.awt.Color(204, 0, 0));
        jLabel137.setText("Seguro que desea eliminar la materia correspondiente a los siguietes datos:");

        javax.swing.GroupLayout EliminarCriteriosLayout = new javax.swing.GroupLayout(EliminarCriterios);
        EliminarCriterios.setLayout(EliminarCriteriosLayout);
        EliminarCriteriosLayout.setHorizontalGroup(
            EliminarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                .addGroup(EliminarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jButton75))
                    .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel137))
                    .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel129)
                        .addGap(41, 41, 41)
                        .addComponent(claveEliminarCri, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton74))
                    .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomCriEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EliminarCriteriosLayout.setVerticalGroup(
            EliminarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCriteriosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(EliminarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(claveEliminarCri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton74))
                .addGap(44, 44, 44)
                .addComponent(jLabel137)
                .addGap(33, 33, 33)
                .addGroup(EliminarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(nomCriEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jButton75)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        ModificarCriterios.setBackground(new java.awt.Color(255, 255, 255));
        ModificarCriterios.setMaximumSize(new java.awt.Dimension(644, 352));
        ModificarCriterios.setMinimumSize(new java.awt.Dimension(644, 352));

        jButton76.setText("Guardar Cambios");
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });

        TablaModificarCri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave del criterio", "Nombre del criterio"
            }
        ));
        jScrollPane16.setViewportView(TablaModificarCri);

        jLabel140.setText("Ingrese clave del criterio");

        jButton77.setText("Filtrar");
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificarCriteriosLayout = new javax.swing.GroupLayout(ModificarCriterios);
        ModificarCriterios.setLayout(ModificarCriteriosLayout);
        ModificarCriteriosLayout.setHorizontalGroup(
            ModificarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarCriteriosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(ModificarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarCriteriosLayout.createSequentialGroup()
                        .addComponent(jButton76)
                        .addGap(194, 194, 194)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarCriteriosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClaveModificarCri, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton77)
                .addGap(194, 194, 194))
        );
        ModificarCriteriosLayout.setVerticalGroup(
            ModificarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarCriteriosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(ModificarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel140)
                        .addComponent(ClaveModificarCri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton77))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton76)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        RegistroCriterios.setBackground(new java.awt.Color(255, 255, 255));

        jLabel141.setText("Nombre del criterio");

        jLabel143.setText("Clave del criterio");

        jButton78.setText("Registrar");
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistroCriteriosLayout = new javax.swing.GroupLayout(RegistroCriterios);
        RegistroCriterios.setLayout(RegistroCriteriosLayout);
        RegistroCriteriosLayout.setHorizontalGroup(
            RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                .addGroup(RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                                .addComponent(jLabel143)
                                .addGap(18, 18, 18)
                                .addComponent(ClaveCrRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NombreCrRegistrar))))
                    .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton78)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        RegistroCriteriosLayout.setVerticalGroup(
            RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroCriteriosLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(ClaveCrRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(RegistroCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(NombreCrRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton78)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(RegistroCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel120)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel127)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton67)
                .addGap(35, 35, 35)
                .addComponent(jButton69)
                .addGap(34, 34, 34)
                .addComponent(jButton71)
                .addGap(36, 36, 36)
                .addComponent(jButton72)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(ConsultarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(ModificarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel120))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel127)))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton69)
                        .addComponent(jButton71)
                        .addComponent(jButton72))
                    .addComponent(jButton67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(RegistroCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(ConsultarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(EliminarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(ModificarCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        jMenu23.setText("Menu");

        jMenuItem31.setText("Administrar Usuarios");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem31);

        jMenuBar12.add(jMenu23);

        jMenu24.setText("Otras Opciones");

        jMenuItem32.setText("Salir del sistema");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem32);

        jMenuItem33.setText("Cerrar Sesión");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem33);

        jMenuItem44.setText("Regresar al menu directora");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem44);

        jMenuBar12.add(jMenu24);

        GestionCriterios.setJMenuBar(jMenuBar12);

        javax.swing.GroupLayout GestionCriteriosLayout = new javax.swing.GroupLayout(GestionCriterios.getContentPane());
        GestionCriterios.getContentPane().setLayout(GestionCriteriosLayout);
        GestionCriteriosLayout.setHorizontalGroup(
            GestionCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GestionCriteriosLayout.setVerticalGroup(
            GestionCriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        MenuPrincipalProfesor.setMinimumSize(new java.awt.Dimension(460, 440));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(460, 440));
        jPanel11.setMinimumSize(new java.awt.Dimension(460, 440));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(102, 102, 0));
        jLabel128.setText("Portal Profesores");

        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jButton81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calificacionesB.png"))); // NOI18N
        jButton81.setText("Control de calificaciones");
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel135)
                .addGap(74, 74, 74)
                .addComponent(jLabel128)
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton81)
                .addGap(146, 146, 146))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel135))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel128)))
                .addGap(91, 91, 91)
                .addComponent(jButton81)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        jMenu25.setText("Menu");

        jMenuItem34.setText("Administrar Usuarios");
        jMenu25.add(jMenuItem34);

        jMenuBar13.add(jMenu25);

        jMenu26.setText("Otras Opciones");

        jMenuItem35.setText("Salir del sistema");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem35);

        jMenuItem36.setText("Cerrar Sesión");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem36);

        jMenuBar13.add(jMenu26);

        MenuPrincipalProfesor.setJMenuBar(jMenuBar13);

        javax.swing.GroupLayout MenuPrincipalProfesorLayout = new javax.swing.GroupLayout(MenuPrincipalProfesor.getContentPane());
        MenuPrincipalProfesor.getContentPane().setLayout(MenuPrincipalProfesorLayout);
        MenuPrincipalProfesorLayout.setHorizontalGroup(
            MenuPrincipalProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPrincipalProfesorLayout.setVerticalGroup(
            MenuPrincipalProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel136.setText("jLabel136");

        jLabel138.setText("jLabel138");

        AgregarAlumnosGrupo.setToolTipText("Agregar");

        jMenuItem38.setText("Agregar");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        AgregarAlumnosGrupo.add(jMenuItem38);

        jMenuItem39.setText("Agregar");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        AgregarCriterio.add(jMenuItem39);

        jMenuItem40.setText("Quitar");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        ModificarCriterio.add(jMenuItem40);

        jMenuItem41.setText("Agregar");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        ModificarCriterio.add(jMenuItem41);

        LogeoUsuario.setMinimumSize(new java.awt.Dimension(400, 351));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(400, 351));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 351));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 0));
        jLabel9.setText("Logueo Usuario");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 0));
        jLabel10.setText("Usuario");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 0));
        jLabel12.setText("Contraseña");

        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1)
                            .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(Contraseña))
                        .addContainerGap(99, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9)))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jMenu7.setText("Menu");

        jMenuItem7.setText("Administración de usuarios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem8.setText("Logeo Usuarios");
        jMenu7.add(jMenuItem8);

        jMenuBar4.add(jMenu7);

        jMenu8.setText("Otras Opciones");

        jMenuItem9.setText("Salir");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem9);

        jMenuBar4.add(jMenu8);

        LogeoUsuario.setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout LogeoUsuarioLayout = new javax.swing.GroupLayout(LogeoUsuario.getContentPane());
        LogeoUsuario.getContentPane().setLayout(LogeoUsuarioLayout);
        LogeoUsuarioLayout.setHorizontalGroup(
            LogeoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogeoUsuarioLayout.setVerticalGroup(
            LogeoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogeoUsuarioLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        AdministracionPagos.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel4.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 0));
        jLabel51.setText("Administrar pagos de colegiaturas");

        jButton11.setText("Registrar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Consultar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Modificar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Eliminar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        ConsultarPagos.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarPagos.setMaximumSize(new java.awt.Dimension(644, 352));
        ConsultarPagos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel49.setText("Ingrese matricula del alumno:");

        jLabel52.setText("Nombre del alumno:");

        TablaPagoCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del pago", "Monto", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPagoCon);

        jButton23.setText("Mostrar pagos ");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultarPagosLayout = new javax.swing.GroupLayout(ConsultarPagos);
        ConsultarPagos.setLayout(ConsultarPagosLayout);
        ConsultarPagosLayout.setHorizontalGroup(
            ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarPagosLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ConsultarPagosLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConsultarPagosLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(18, 18, 18)
                                .addComponent(MatriculaPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton23))
                            .addGroup(ConsultarPagosLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(26, 26, 26)
                                .addComponent(NombrePagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConsultarPagosLayout.setVerticalGroup(
            ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarPagosLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(MatriculaPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23))
                .addGap(26, 26, 26)
                .addGroup(ConsultarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(NombrePagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EliminarPagos.setBackground(new java.awt.Color(255, 255, 255));
        EliminarPagos.setMaximumSize(new java.awt.Dimension(644, 352));
        EliminarPagos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel80.setText("Matricula");

        jButton27.setText("Buscar pagos");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel79.setText("Nombre del alumno:");

        AlumnosPagosEli.setEditable(false);

        TablaPagosEli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del pago", "Monto", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPagosEli.setComponentPopupMenu(MenuPagoEli);
        jScrollPane2.setViewportView(TablaPagosEli);

        jLabel57.setText("Click Derecho sobre el pago de la tabla para eliminar");

        javax.swing.GroupLayout EliminarPagosLayout = new javax.swing.GroupLayout(EliminarPagos);
        EliminarPagos.setLayout(EliminarPagosLayout);
        EliminarPagosLayout.setHorizontalGroup(
            EliminarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPagosLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(EliminarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarPagosLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MatriculaPagosEli, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton27))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EliminarPagosLayout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlumnosPagosEli, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarPagosLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel57)
                        .addGap(88, 88, 88)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EliminarPagosLayout.setVerticalGroup(
            EliminarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPagosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(EliminarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(MatriculaPagosEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27))
                .addGap(40, 40, 40)
                .addGroup(EliminarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlumnosPagosEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        ModificarPagos.setBackground(new java.awt.Color(255, 255, 255));
        ModificarPagos.setMaximumSize(new java.awt.Dimension(644, 352));
        ModificarPagos.setMinimumSize(new java.awt.Dimension(644, 352));

        jLabel53.setText("Imgresar matricula del alumno a modificar:");

        jButton24.setText("Buscar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel25.setText("Nombre del alumno");

        TablaPagosModificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(TablaPagosModificar);

        jButton4.setText("Guardar Cambios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel54.setForeground(new java.awt.Color(0, 102, 255));
        jLabel54.setText("Modifique los datos dentro de la tabla presione enter y click en el botón para guardar las modificaciones");

        jLabel55.setForeground(new java.awt.Color(204, 0, 0));
        jLabel55.setText("Recuerde no cambiar el identificador ya que es propio del sistema");

        javax.swing.GroupLayout ModificarPagosLayout = new javax.swing.GroupLayout(ModificarPagos);
        ModificarPagos.setLayout(ModificarPagosLayout);
        ModificarPagosLayout.setHorizontalGroup(
            ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarPagosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(258, 258, 258))
            .addGroup(ModificarPagosLayout.createSequentialGroup()
                .addGroup(ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarPagosLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlumnoPagoMo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ModificarPagosLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ModificarPagosLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MatriculaPagoMo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton24))))
                    .addGroup(ModificarPagosLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ModificarPagosLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        ModificarPagosLayout.setVerticalGroup(
            ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarPagosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(MatriculaPagoMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ModificarPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(AlumnoPagoMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(32, 32, 32))
        );

        RegistroPagos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel116.setText("Nombre del pago:");

        jLabel117.setText("Monto  de pago realizado :");

        AlumnoPagoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un alumno", " " }));

        DiaPagoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        MesPagoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        AnioPagoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", " " }));

        jLabel48.setText("Selecciones la fecha actual");

        jButton2.setText("Guardar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistroPagosLayout = new javax.swing.GroupLayout(RegistroPagos);
        RegistroPagos.setLayout(RegistroPagosLayout);
        RegistroPagosLayout.setHorizontalGroup(
            RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroPagosLayout.createSequentialGroup()
                .addGroup(RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroPagosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombrePagoR, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistroPagosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(AlumnoPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroPagosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MontoPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroPagosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroPagosLayout.createSequentialGroup()
                                .addComponent(DiaPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MesPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnioPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroPagosLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(118, 118, 118))))))
            .addGroup(RegistroPagosLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegistroPagosLayout.setVerticalGroup(
            RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroPagosLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(NombrePagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(MontoPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addGroup(RegistroPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlumnoPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiaPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnioPagoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(RegistroPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel50)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel51))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jButton11)
                                .addGap(35, 35, 35)
                                .addComponent(jButton12)
                                .addGap(34, 34, 34)
                                .addComponent(jButton13)
                                .addGap(36, 36, 36)
                                .addComponent(jButton14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(ConsultarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(ModificarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel50))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(jButton13)
                        .addComponent(jButton14))
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(RegistroPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(ConsultarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(EliminarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(ModificarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        jMenu11.setText("Menu");

        jMenuItem13.setText("Administrar Usuarios");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem13);

        jMenuBar6.add(jMenu11);

        jMenu12.setText("Otras Opciones");

        jMenuItem14.setText("Salir del sistema");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem14);

        jMenuItem15.setText("Cerrar Sesión");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem15);

        jMenuItem45.setText("Regresar al portal directora");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem45);

        jMenuBar6.add(jMenu12);

        AdministracionPagos.setJMenuBar(jMenuBar6);

        javax.swing.GroupLayout AdministracionPagosLayout = new javax.swing.GroupLayout(AdministracionPagos.getContentPane());
        AdministracionPagos.getContentPane().setLayout(AdministracionPagosLayout);
        AdministracionPagosLayout.setHorizontalGroup(
            AdministracionPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AdministracionPagosLayout.setVerticalGroup(
            AdministracionPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        EliminarPago1.setText("Eliminar el pago seleccionado");
        Eliminarpagos1.add(EliminarPago1);

        EliminarPagoItem.setText("Eliminar");
        EliminarPagoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPagoItemActionPerformed(evt);
            }
        });
        MenuPagoEli.add(EliminarPagoItem);

        Registrar.setBackground(new java.awt.Color(255, 255, 255));
        Registrar.setMaximumSize(new java.awt.Dimension(597, 452));
        Registrar.setMinimumSize(new java.awt.Dimension(597, 452));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 0));
        jLabel14.setText("Registro nuevo usuario");

        jLabel15.setText("Numero de empleado");

        jLabel16.setText("Nombre de Usuario");

        jLabel17.setText("Contraseña");

        jLabel18.setText("Confirmar Contrasaña");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton5.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro boton.png"))); // NOI18N
        jToggleButton5.setText("Registrar");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultarboton.png"))); // NOI18N
        jToggleButton6.setText("Consultar");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficar boton.png"))); // NOI18N
        jToggleButton7.setText("Modificar");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jToggleButton8.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar boton.png"))); // NOI18N
        jToggleButton8.setText("Eliminar");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton5)
                    .addComponent(jToggleButton6)
                    .addComponent(jToggleButton7)
                    .addComponent(jToggleButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton5)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton6)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton7)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton8)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel139.setText("Nombre:");

        jLabel144.setText("Apellidos");

        jLabel145.setText("Telefono Celular");

        TelUsuR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelUsuRKeyTyped(evt);
            }
        });

        jLabel148.setText("Direccion");

        TiposUsuR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el tipo de usuario", "Director(a)", "Profesor(a)", " " }));

        javax.swing.GroupLayout RegistrarLayout = new javax.swing.GroupLayout(Registrar);
        Registrar.setLayout(RegistrarLayout);
        RegistrarLayout.setHorizontalGroup(
            RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarLayout.createSequentialGroup()
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel14))
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(NombreUsuarioR, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RegistrarLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel145)
                                            .addGroup(RegistrarLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel144)
                                                    .addComponent(jLabel139)))))
                                    .addGroup(RegistrarLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel148)))
                                .addGap(12, 12, 12)
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TelUsuR)
                                    .addComponent(NombreEmR)
                                    .addComponent(ApellidosUsuR)
                                    .addComponent(ClaveEmpleadoR)
                                    .addComponent(DireccionUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(TiposUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RegistrarLayout.createSequentialGroup()
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(RegistrarLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ContraUsuR)
                                    .addComponent(VContraUsuR, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))))
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(291, 291, 291))
        );
        RegistrarLayout.setVerticalGroup(
            RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarLayout.createSequentialGroup()
                .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel14)
                        .addGap(34, 34, 34)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(ClaveEmpleadoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(NombreEmR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel144)
                            .addComponent(ApellidosUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel145)
                            .addComponent(TelUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel148)
                            .addComponent(DireccionUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreUsuarioR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(ContraUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(VContraUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(TiposUsuR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addGap(14, 14, 14)
                .addComponent(jButton3)
                .addGap(52, 52, 52))
        );

        Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Eliminar.setMaximumSize(new java.awt.Dimension(599, 413));
        Eliminar.setMinimumSize(new java.awt.Dimension(599, 413));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 0));
        jLabel43.setText("Eliminar Usuario ");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jLabel45.setText("Ingrese la clave del empleado:");

        jButton10.setText("Eliminar ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton13.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro boton.png"))); // NOI18N
        jToggleButton13.setText("Registrar");
        jToggleButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton13ActionPerformed(evt);
            }
        });

        jToggleButton14.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultarboton.png"))); // NOI18N
        jToggleButton14.setText("Consultar");
        jToggleButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton14ActionPerformed(evt);
            }
        });

        jToggleButton15.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficar boton.png"))); // NOI18N
        jToggleButton15.setText("Modificar");
        jToggleButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton15ActionPerformed(evt);
            }
        });

        jToggleButton16.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar boton.png"))); // NOI18N
        jToggleButton16.setText("Eliminar");
        jToggleButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton13)
                    .addComponent(jToggleButton14)
                    .addComponent(jToggleButton15)
                    .addComponent(jToggleButton16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton13)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton14)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton15)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MensajeUsuEli.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        MensajeUsuEli.setForeground(new java.awt.Color(204, 0, 0));
        MensajeUsuEli.setText("Desea eliminar el empleado(Usuario) con los siguientes datos:");

        LableNomUsuEli.setText("Nonbre");

        NombreComUsuEli.setEditable(false);

        LabelNDUsuELi.setText("Nombre de Usuario");

        NombreDUsuEli.setEditable(false);

        LabelTipo.setText("Tipo de Usuario");

        TipoUSuEli.setEditable(false);

        ButonUsuELi.setText("Aceptar");
        ButonUsuELi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonUsuELiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EliminarLayout = new javax.swing.GroupLayout(Eliminar);
        Eliminar.setLayout(EliminarLayout);
        EliminarLayout.setHorizontalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EliminarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel44)))
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EliminarLayout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(ClaveUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(jButton10))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarLayout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(LableNomUsuEli)
                                    .addGap(35, 35, 35)
                                    .addComponent(NombreComUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(EliminarLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel43)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(LabelNDUsuELi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NombreDUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(EliminarLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(LabelTipo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TipoUSuEli)))
                    .addGroup(EliminarLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(ButonUsuELi))
                    .addGroup(EliminarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MensajeUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        EliminarLayout.setVerticalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel43)
                .addGap(59, 59, 59)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClaveUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MensajeUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LableNomUsuEli)
                    .addComponent(NombreComUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNDUsuELi)
                    .addComponent(NombreDUsuEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTipo)
                    .addComponent(TipoUSuEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButonUsuELi)
                .addGap(35, 35, 35))
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Consultar.setBackground(new java.awt.Color(255, 255, 255));
        Consultar.setMaximumSize(new java.awt.Dimension(599, 413));
        Consultar.setMinimumSize(new java.awt.Dimension(599, 413));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 0));
        jLabel21.setText("Consultar Usuario");

        jLabel22.setText("Clave del empleado:");

        jLabel23.setText("Nombre");

        jLabel24.setText("Apellidos");

        jLabel26.setText("Nombre de Usuario");

        NombreUsuCon.setEditable(false);
        NombreUsuCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreUsuConActionPerformed(evt);
            }
        });

        ApellidosUsuCon.setEditable(false);

        NombreDUsuCon.setEditable(false);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton9.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro boton.png"))); // NOI18N
        jToggleButton9.setText("Registrar");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });

        jToggleButton10.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultarboton.png"))); // NOI18N
        jToggleButton10.setText("Consultar");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });

        jToggleButton11.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficar boton.png"))); // NOI18N
        jToggleButton11.setText("Modificar");
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });

        jToggleButton12.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar boton.png"))); // NOI18N
        jToggleButton12.setText("Eliminar");
        jToggleButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton9)
                    .addComponent(jToggleButton10)
                    .addComponent(jToggleButton11)
                    .addComponent(jToggleButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton9)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton10)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton11)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton12)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jButton28.setText("Buscar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel29.setText("Tipo de usuario");

        TipoUsuCon.setEditable(false);

        javax.swing.GroupLayout ConsultarLayout = new javax.swing.GroupLayout(Consultar);
        Consultar.setLayout(ConsultarLayout);
        ConsultarLayout.setHorizontalGroup(
            ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(ConsultarLayout.createSequentialGroup()
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConsultarLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ClaveUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton28))
                            .addGroup(ConsultarLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ConsultarLayout.createSequentialGroup()
                                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ConsultarLayout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(53, 53, 53))
                                            .addGroup(ConsultarLayout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(40, 40, 40)))
                                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NombreUsuCon)
                                            .addComponent(ApellidosUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ConsultarLayout.createSequentialGroup()
                                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarLayout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addGap(36, 36, 36)))
                                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NombreDUsuCon, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(TipoUsuCon))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(ConsultarLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(165, 165, 165))
        );
        ConsultarLayout.setVerticalGroup(
            ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarLayout.createSequentialGroup()
                .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(ConsultarLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel21)))
                .addGap(29, 29, 29)
                .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ConsultarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ClaveUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(NombreUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(ApellidosUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(NombreDUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(TipoUsuCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Modificar.setBackground(new java.awt.Color(255, 255, 255));
        Modificar.setMaximumSize(new java.awt.Dimension(599, 500));
        Modificar.setMinimumSize(new java.awt.Dimension(599, 500));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 0));
        jLabel20.setText("Modificar Usuario");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton17.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro boton.png"))); // NOI18N
        jToggleButton17.setText("Registrar");
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });

        jToggleButton18.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultarboton.png"))); // NOI18N
        jToggleButton18.setText("Consultar");
        jToggleButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ActionPerformed(evt);
            }
        });

        jToggleButton19.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficar boton.png"))); // NOI18N
        jToggleButton19.setText("Modificar");
        jToggleButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton19ActionPerformed(evt);
            }
        });

        jToggleButton20.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar boton.png"))); // NOI18N
        jToggleButton20.setText("Eliminar");
        jToggleButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton17)
                    .addComponent(jToggleButton18)
                    .addComponent(jToggleButton19)
                    .addComponent(jToggleButton20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton17)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton18)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton19)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton41.setText("Modificar");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        TipoUsuMo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el tipo de usuario", "Director(a)", "Profesor(a)", " " }));

        jLabel149.setText("Confirmar Contrasaña");

        jLabel150.setText("Contraseña");

        jLabel151.setText("Nombre de Usuario");

        jLabel152.setText("Direccion");

        jLabel153.setText("Telefono Celular");

        jLabel154.setText("Apellidos");

        jLabel155.setText("Nombre:");

        jLabel156.setText("Numero de empleado");

        TelefonoUsuMo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoUsuMoKeyTyped(evt);
            }
        });

        jButton73.setText("Mostrar");
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificarLayout = new javax.swing.GroupLayout(Modificar);
        Modificar.setLayout(ModificarLayout);
        ModificarLayout.setHorizontalGroup(
            ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarLayout.createSequentialGroup()
                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel20))
                    .addGroup(ModificarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ModificarLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel151)
                                .addGap(18, 18, 18)
                                .addComponent(NombreDUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ModificarLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(TipoUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ModificarLayout.createSequentialGroup()
                                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ModificarLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel153)
                                            .addGroup(ModificarLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel154)
                                                    .addComponent(jLabel155)))))
                                    .addGroup(ModificarLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel152)))
                                .addGap(35, 35, 35)
                                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TelefonoUsuMo)
                                    .addComponent(NombreEmMo)
                                    .addComponent(ApellidosUsuMo)
                                    .addComponent(DireccionUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ModificarLayout.createSequentialGroup()
                                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel149)
                                    .addGroup(ModificarLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel150)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ContraseñaUsuMo)
                                    .addComponent(VContraseñaUsuMo, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ModificarLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(31, 31, 31)
                .addComponent(jLabel156)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClaveEmMo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton73)
                .addGap(0, 76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton41)
                .addGap(195, 195, 195))
        );
        ModificarLayout.setVerticalGroup(
            ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarLayout.createSequentialGroup()
                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel20)
                        .addGap(23, 23, 23)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel156)
                            .addComponent(ClaveEmMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton73)))
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarLayout.createSequentialGroup()
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel155)
                            .addComponent(NombreEmMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel154)
                            .addComponent(ApellidosUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel153)
                            .addComponent(TelefonoUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel152)
                            .addComponent(DireccionUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreDUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel151))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel150)
                            .addComponent(ContraseñaUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel149)
                            .addComponent(VContraseñaUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(TipoUsuMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton41)
                .addGap(0, 85, Short.MAX_VALUE))
        );

        OpcionUsuario.setBackground(new java.awt.Color(255, 255, 255));
        OpcionUsuario.setMaximumSize(new java.awt.Dimension(335, 250));
        OpcionUsuario.setMinimumSize(new java.awt.Dimension(335, 250));

        jLabel30.setText("Nombre de usuario actual:");

        jLabel31.setText("Nuevo nombre de usuario");

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 0));
        jLabel32.setText("Modificar nombre de usuario");

        jButton6.setText("Guardar Cambios");

        javax.swing.GroupLayout OpcionUsuarioLayout = new javax.swing.GroupLayout(OpcionUsuario);
        OpcionUsuario.setLayout(OpcionUsuarioLayout);
        OpcionUsuarioLayout.setHorizontalGroup(
            OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionUsuarioLayout.createSequentialGroup()
                .addGroup(OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OpcionUsuarioLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField13)
                            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                    .addGroup(OpcionUsuarioLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel32))
                    .addGroup(OpcionUsuarioLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton6)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        OpcionUsuarioLayout.setVerticalGroup(
            OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionUsuarioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel32)
                .addGap(38, 38, 38)
                .addGroup(OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(OpcionUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton6)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        OpcionContraseña.setBackground(new java.awt.Color(255, 255, 255));
        OpcionContraseña.setMaximumSize(new java.awt.Dimension(419, 320));
        OpcionContraseña.setMinimumSize(new java.awt.Dimension(419, 320));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 0));
        jLabel33.setText("Modificar Contraseña");

        jLabel34.setText("Digite contraseña actual ");

        jLabel35.setText("Nueva contraseña");

        jLabel36.setText("Confirmar contraseña");

        jButton7.setText("Enviar datos");

        javax.swing.GroupLayout OpcionContraseñaLayout = new javax.swing.GroupLayout(OpcionContraseña);
        OpcionContraseña.setLayout(OpcionContraseñaLayout);
        OpcionContraseñaLayout.setHorizontalGroup(
            OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OpcionContraseñaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(120, 120, 120))
            .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36))
                                .addGap(18, 18, 18)
                                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextField18)))))
                    .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jButton7)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        OpcionContraseñaLayout.setVerticalGroup(
            OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionContraseñaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel33)
                .addGap(48, 48, 48)
                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(OpcionContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(33, 33, 33))
        );

        OpcionUsuContra.setBackground(new java.awt.Color(255, 255, 255));
        OpcionUsuContra.setMaximumSize(new java.awt.Dimension(429, 331));
        OpcionUsuContra.setMinimumSize(new java.awt.Dimension(429, 331));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 0));
        jLabel38.setText("Modificar Usuario y contraseña");

        jLabel39.setText("Contraseña actual");

        jLabel40.setText("Nueva contraseña");

        jLabel41.setText("Confirmar contraseña");

        jLabel42.setText("Nuevo nombre de usuario");

        jButton9.setText("Guardar Cambios");

        javax.swing.GroupLayout OpcionUsuContraLayout = new javax.swing.GroupLayout(OpcionUsuContra);
        OpcionUsuContra.setLayout(OpcionUsuContraLayout);
        OpcionUsuContraLayout.setHorizontalGroup(
            OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OpcionUsuContraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addGap(91, 91, 91))
            .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField22))
                                .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                                    .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39)
                                        .addComponent(jLabel41))
                                    .addGap(39, 39, 39)
                                    .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField20)
                                        .addComponent(jTextField19)
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton9)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        OpcionUsuContraLayout.setVerticalGroup(
            OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionUsuContraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(46, 46, 46)
                .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(OpcionUsuContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ModificarOPCLayout = new javax.swing.GroupLayout(ModificarOPC);
        ModificarOPC.setLayout(ModificarOPCLayout);
        ModificarOPCLayout.setHorizontalGroup(
            ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OpcionUsuContra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarOPCLayout.createSequentialGroup()
                    .addComponent(OpcionContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarOPCLayout.createSequentialGroup()
                    .addComponent(OpcionUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ModificarOPCLayout.setVerticalGroup(
            ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OpcionUsuContra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarOPCLayout.createSequentialGroup()
                    .addComponent(OpcionContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(ModificarOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarOPCLayout.createSequentialGroup()
                    .addComponent(OpcionUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenu9.setText("Menu");

        jMenuItem10.setText("Administración de Usuarios");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenuItem11.setText("Logeo Usuario ");
        jMenu9.add(jMenuItem11);

        jMenuBar5.add(jMenu9);

        jMenu10.setText("Otras Opciones");

        jMenuItem12.setText("Salir");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenuBar5.add(jMenu10);

        AdministrarUsuariosOPC.setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout AdministrarUsuariosOPCLayout = new javax.swing.GroupLayout(AdministrarUsuariosOPC.getContentPane());
        AdministrarUsuariosOPC.getContentPane().setLayout(AdministrarUsuariosOPCLayout);
        AdministrarUsuariosOPCLayout.setHorizontalGroup(
            AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addComponent(ModificarOPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 100, Short.MAX_VALUE)))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 99, Short.MAX_VALUE)))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        AdministrarUsuariosOPCLayout.setVerticalGroup(
            AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addComponent(ModificarOPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(AdministrarUsuariosOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosOPCLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(Consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );

        GestionDeInscripcionesAlumno.setMinimumSize(new java.awt.Dimension(630, 600));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(630, 600));
        jPanel19.setMinimumSize(new java.awt.Dimension(630, 600));

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sear logo.png"))); // NOI18N

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(102, 102, 0));
        jLabel83.setText("Gestion de inscripción de alumnos");

        jButton29.setText("Registrar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("Consultar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Modificar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Eliminar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        ConsultarAlumno1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 0))); // NOI18N

        jLabel84.setText("Apellido Paterno ");

        Ap_patCon.setEditable(false);

        jLabel85.setText("Apellido Materno:");

        Ap_matCon.setEditable(false);

        NombreCon.setEditable(false);

        jLabel86.setText("Nombre");

        jLabel87.setText("Ingrese la matricula del alumno");

        jLabel88.setText("Tutor");

        TutorCon.setEditable(false);

        jButton34.setText("Consultar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel158.setText("Periodo");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel158)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ap_matCon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PeriodoConAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel86))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NombreCon, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(Ap_patCon))
                                .addGap(79, 79, 79)
                                .addComponent(jLabel88)
                                .addGap(18, 18, 18)
                                .addComponent(TutorCon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MatriculaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton34)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(MatriculaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(Ap_patCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85)
                    .addComponent(Ap_matCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel86))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel88)
                        .addComponent(TutorCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeriodoConAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel158))
                .addGap(5, 5, 5))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Domiciliaros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 0))); // NOI18N
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));

        jLabel89.setText("Calle");

        CalleCon.setEditable(false);

        MunicipioCon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el municipio", "Acambay", "Acolman", "Aculco", "Almoloya de Alquisiras", "Almoloya de Juárez", "Almoloya del Río", "Amanalco", "Amatepec", "Amecameca", "Apaxco", "Atenco", "Atizapán", "Atizapán de Zaragoza", "Atlacomulco", "Atlautla", "Axapusco", "Ayapango", "Calimaya", "Capulhuac", "Coacalco de Berriozábal", "Coatepec Harinas", "Cocotitlán", "Coyotepec", "Cuautitlán", "Chalco", "Chapa de Mota", "Chapultepec", "Chiautla", "Chicoloapan", "Chiconcuac", "Chimalhuacán", "Donato Guerra", "Ecatepec de Morelos", "Ecatzingo", "Huehuetoca", "Hueypoxtla", "Huixquilucan", "Isidro Fabela", "Ixtapaluca", "Ixtapan de la Sal", "Ixtapan del Oro", "Ixtlahuaca", "Xalatlaco", "Jaltenco", "Jilotepec", "Jilotzingo", "Jiquipilco", "Jocotitlán", "Joquicingo", "Juchitepec", "Lerma", "Malinalco", "Melchor Ocampo", "Metepec", "Mexicaltzingo", "Morelos", "Naucalpan de Juárez", "Nezahualcóyotl", "Nextlalpan", "Nicolás Romero", "Nopaltepec", "Ocoyoacac", "Ocuilan" }));

        jLabel90.setText("Código Postal");

        CPostaCon.setEditable(false);

        jLabel91.setText("Telefono local");

        jLabel92.setText("Celular");

        TeLocCon.setEditable(false);

        CelCon.setEditable(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalleCon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MunicipioCon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CPostaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TeLocCon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CelCon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(CalleCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MunicipioCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90)
                    .addComponent(CPostaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(TeLocCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(CelCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ConsultarAlumno1Layout = new javax.swing.GroupLayout(ConsultarAlumno1);
        ConsultarAlumno1.setLayout(ConsultarAlumno1Layout);
        ConsultarAlumno1Layout.setHorizontalGroup(
            ConsultarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarAlumno1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        ConsultarAlumno1Layout.setVerticalGroup(
            ConsultarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarAlumno1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ModificarAlumno1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Domiciliaros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 0))); // NOI18N
        jPanel22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel93.setText("Calle");

        MunicipioMo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el municipio", "Acambay", "Acolman", "Aculco", "Almoloya de Alquisiras", "Almoloya de Juárez", "Almoloya del Río", "Amanalco", "Amatepec", "Amecameca", "Apaxco", "Atenco", "Atizapán", "Atizapán de Zaragoza", "Atlacomulco", "Atlautla", "Axapusco", "Ayapango", "Calimaya", "Capulhuac", "Coacalco de Berriozábal", "Coatepec Harinas", "Cocotitlán", "Coyotepec", "Cuautitlán", "Chalco", "Chapa de Mota", "Chapultepec", "Chiautla", "Chicoloapan", "Chiconcuac", "Chimalhuacán", "Donato Guerra", "Ecatepec de Morelos", "Ecatzingo", "Huehuetoca", "Hueypoxtla", "Huixquilucan", "Isidro Fabela", "Ixtapaluca", "Ixtapan de la Sal", "Ixtapan del Oro", "Ixtlahuaca", "Xalatlaco", "Jaltenco", "Jilotepec", "Jilotzingo", "Jiquipilco", "Jocotitlán", "Joquicingo", "Juchitepec", "Lerma", "Malinalco", "Melchor Ocampo", "Metepec", "Mexicaltzingo", "Morelos", "Naucalpan de Juárez", "Nezahualcóyotl", "Nextlalpan", "Nicolás Romero", "Nopaltepec", "Ocoyoacac", "Ocuilan" }));

        jLabel94.setText("Código Postal");

        CPostalMo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPostalMoKeyTyped(evt);
            }
        });

        jLabel95.setText("Telefono local");

        jLabel96.setText("Celular");

        TelLocMo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelLocMoKeyTyped(evt);
            }
        });

        CelMo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CelMoKeyTyped(evt);
            }
        });

        jButton35.setText("Guardar Cambios");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalleMo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MunicipioMo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CPostalMo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton35)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TelLocMo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel96)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CelMo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(CalleMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MunicipioMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94)
                    .addComponent(CPostalMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(TelLocMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96)
                    .addComponent(CelMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 0))); // NOI18N

        jLabel97.setText("Apellido Paterno ");

        jLabel98.setText("Apellido Materno:");

        jLabel99.setText("Nombre");

        jLabel100.setText("Ingrese la matricula del alumno");

        jLabel101.setText("Tutor");

        jButton36.setText("Consultar");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel157.setText("Periodo");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MatriculaMo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel99)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreMo, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(Ap_patMo))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AP_matMo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel101)
                                .addGap(18, 18, 18)
                                .addComponent(TutorMo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel157)
                        .addGap(18, 18, 18)
                        .addComponent(PeriodoModAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(MatriculaMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(Ap_patMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(AP_matMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(TutorMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeriodoModAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel157))
                .addContainerGap())
        );

        javax.swing.GroupLayout ModificarAlumno1Layout = new javax.swing.GroupLayout(ModificarAlumno1);
        ModificarAlumno1.setLayout(ModificarAlumno1Layout);
        ModificarAlumno1Layout.setHorizontalGroup(
            ModificarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarAlumno1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ModificarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        ModificarAlumno1Layout.setVerticalGroup(
            ModificarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarAlumno1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        EliminarAlumno1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 0))); // NOI18N

        jLabel102.setText("Apellido Paterno ");

        Ap_patEli.setEditable(false);

        jLabel103.setText("Apellido Materno:");

        Ap_matEli.setEditable(false);

        NombreEli.setEditable(false);

        jLabel104.setText("Nombre");

        jLabel105.setText("Tutor");

        TutorEli.setEditable(false);

        BotonAceptarEli.setText("Aceptar");
        BotonAceptarEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarEliActionPerformed(evt);
            }
        });

        MensajePreventivoEli.setForeground(new java.awt.Color(204, 0, 0));
        MensajePreventivoEli.setText("Presione el botón aceptar si desea eliminar el alumno con la siguiente información");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel105)
                        .addGap(39, 39, 39)
                        .addComponent(TutorEli, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(BotonAceptarEli)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MensajePreventivoEli)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(Ap_patEli, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ap_matEli, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel104)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NombreEli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MensajePreventivoEli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(Ap_patEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(Ap_matEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TutorEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105)
                    .addComponent(BotonAceptarEli))
                .addGap(22, 22, 22))
        );

        jLabel106.setText("Matricula");

        jButton37.setText("Eliminar");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EliminarAlumno1Layout = new javax.swing.GroupLayout(EliminarAlumno1);
        EliminarAlumno1.setLayout(EliminarAlumno1Layout);
        EliminarAlumno1Layout.setHorizontalGroup(
            EliminarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarAlumno1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MatriculaEli, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton37)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(EliminarAlumno1Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EliminarAlumno1Layout.setVerticalGroup(
            EliminarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarAlumno1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(EliminarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(MatriculaEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37))
                .addGap(38, 38, 38)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        RegistrarAlumno1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 0))); // NOI18N

        jLabel107.setText("Apellido Paterno ");

        jLabel108.setText("Apellido Materno:");

        jLabel109.setText("Nombre");

        jLabel110.setText("Matricula");

        jLabel111.setText("Tutor");

        jLabel56.setText("Periodo");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MatriculaR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel111))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ap_patR, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ap_matR, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(TutorR, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PeriodoAlumno)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(ap_patR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(ap_matR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(MatriculaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(TutorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(PeriodoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Domiciliaros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 0))); // NOI18N
        jPanel26.setForeground(new java.awt.Color(255, 255, 255));

        jLabel112.setText("Calle");

        MunicipioR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el municipio", "Acambay", "Acolman", "Aculco", "Almoloya de Alquisiras", "Almoloya de Juárez", "Almoloya del Río", "Amanalco", "Amatepec", "Amecameca", "Apaxco", "Atenco", "Atizapán", "Atizapán de Zaragoza", "Atlacomulco", "Atlautla", "Axapusco", "Ayapango", "Calimaya", "Capulhuac", "Coacalco de Berriozábal", "Coatepec Harinas", "Cocotitlán", "Coyotepec", "Cuautitlán", "Chalco", "Chapa de Mota", "Chapultepec", "Chiautla", "Chicoloapan", "Chiconcuac", "Chimalhuacán", "Donato Guerra", "Ecatepec de Morelos", "Ecatzingo", "Huehuetoca", "Hueypoxtla", "Huixquilucan", "Isidro Fabela", "Ixtapaluca", "Ixtapan de la Sal", "Ixtapan del Oro", "Ixtlahuaca", "Xalatlaco", "Jaltenco", "Jilotepec", "Jilotzingo", "Jiquipilco", "Jocotitlán", "Joquicingo", "Juchitepec", "Lerma", "Malinalco", "Melchor Ocampo", "Metepec", "Mexicaltzingo", "Morelos", "Naucalpan de Juárez", "Nezahualcóyotl", "Nextlalpan", "Nicolás Romero", "Nopaltepec", "Ocoyoacac", "Ocuilan" }));

        jLabel113.setText("Código Postal");

        CPostalR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPostalRKeyTyped(evt);
            }
        });

        jLabel114.setText("Telefono local");

        jLabel115.setText("Celular");

        TelLocalR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelLocalRKeyTyped(evt);
            }
        });

        CelR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CelRKeyTyped(evt);
            }
        });

        jButton38.setText("Registrar");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TelLocalR, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel115)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CelR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jButton38)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalleR, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MunicipioR, 0, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CPostalR, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(CalleR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MunicipioR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113)
                    .addComponent(CPostalR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(TelLocalR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115)
                    .addComponent(CelR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton38)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout RegistrarAlumno1Layout = new javax.swing.GroupLayout(RegistrarAlumno1);
        RegistrarAlumno1.setLayout(RegistrarAlumno1Layout);
        RegistrarAlumno1Layout.setHorizontalGroup(
            RegistrarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarAlumno1Layout.createSequentialGroup()
                .addGroup(RegistrarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarAlumno1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarAlumno1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegistrarAlumno1Layout.setVerticalGroup(
            RegistrarAlumno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarAlumno1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton15.setText("Imprimir reporte de registro ");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegistrarAlumno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel83)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton30)
                        .addGap(18, 18, 18)
                        .addComponent(jButton31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addGap(109, 109, 109))))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ConsultarAlumno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ModificarAlumno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(EliminarAlumno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel82))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel83)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton29)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton30)
                        .addComponent(jButton31)
                        .addComponent(jButton32)
                        .addComponent(jButton15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegistrarAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(ConsultarAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(ModificarAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(EliminarAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu15.setText("Menu");

        jMenuItem19.setText("Administrar Usuarios");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem19);

        jMenuBar8.add(jMenu15);

        jMenu16.setText("Otras Opciones");

        jMenuItem20.setText("Salir del sistema");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem20);

        jMenuItem21.setText("Cerrar Sesión");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem21);

        jMenuItem46.setText("Regresar al portal directora");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem46);

        jMenuBar8.add(jMenu16);

        GestionDeInscripcionesAlumno.setJMenuBar(jMenuBar8);

        javax.swing.GroupLayout GestionDeInscripcionesAlumnoLayout = new javax.swing.GroupLayout(GestionDeInscripcionesAlumno.getContentPane());
        GestionDeInscripcionesAlumno.getContentPane().setLayout(GestionDeInscripcionesAlumnoLayout);
        GestionDeInscripcionesAlumnoLayout.setHorizontalGroup(
            GestionDeInscripcionesAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GestionDeInscripcionesAlumnoLayout.setVerticalGroup(
            GestionDeInscripcionesAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 215));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 215));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 215));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo SEAR Mini_1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Sistema Educativo de Administración");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 0));
        jLabel4.setText(" y Registro ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu ");

        jMenuItem1.setText("Administrar Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Logear Usuario ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Otras Opciones");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(false);
        AdministrarUsuariosOPC.setVisible(true);
        AdministrarUsuariosOPC.setSize(400, 300);
        Registrar.setVisible(true);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        AdministrarUsuarios.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LogeoUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
        AdministrarUsuarios.setVisible(false);
        AdministrarUsuariosOPC.setVisible(true);
        AdministrarUsuariosOPC.setSize(472, 400);
        Registrar.setVisible(false);
        Consultar.setVisible(true);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(false);
        AdministrarUsuariosOPC.setVisible(true);
        AdministrarUsuariosOPC.setSize(430, 330);
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Modificar.setVisible(true);
        Eliminar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        
        AdministrarUsuarios.setVisible(false);
        AdministrarUsuariosOPC.setVisible(true);
        AdministrarUsuariosOPC.setSize(399, 340);
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Modificar.setVisible(false);
        Eliminar.setVisible(true);
        ModificarOPC.setVisible(false);
        ModificarOPC.setSize(429, 331);
        OpcionContraseña.setVisible(false);
        OpcionUsuContra.setVisible(false);
        OpcionUsuario.setVisible(false);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    
        MenuPrincipalDirectora.setVisible(false);
        GestionDeInscripcionesAlumno.setVisible(true);
        RegistrarAlumno1.setVisible(false);
        ConsultarAlumno1.setVisible(false);
        ModificarAlumno1.setVisible(false);
        EliminarAlumno1.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jToggleButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton21ActionPerformed

    private void jToggleButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton22ActionPerformed

    private void jToggleButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton23ActionPerformed

    private void jToggleButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton24ActionPerformed

    private void jToggleButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton25ActionPerformed

    private void jToggleButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton26ActionPerformed

    private void jToggleButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton27ActionPerformed

    private void jToggleButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton28ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipalDirectora.setVisible(false);
        AdministracionPagos.setVisible(true);
        RegistroPagos.setVisible(false);
        ConsultarPagos.setVisible(false);
        ModificarPagos.setVisible(false);
        EliminarPagos.setVisible(false);
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        Controldecalificaciones.setVisible(true);
        RegistrarCalificaciones.setVisible(false);
        ConsultarCalificaciones.setVisible(true);
        ModificarCalificaciones.setVisible(false);
        EliminarCalificaciones.setVisible(false);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        Controldecalificaciones.setVisible(true);
        RegistrarCalificaciones.setVisible(false);
        ConsultarCalificaciones.setVisible(false);
        ModificarCalificaciones.setVisible(false);
        EliminarCalificaciones.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(true);
        ConsultarGrupos.setVisible(false);
        ModificarGrupos.setVisible(false);
        EliminarGrupos.setVisible(false);
        AgregarAlumnos.setVisible(false);
        claveGrupo.setText("");
        periodoGrup.setSelectedIndex(0);
        GradoGru.setSelectedIndex(0);
     
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(false);
        ConsultarGrupos.setVisible(true);
        ModificarGrupos.setVisible(false);
        EliminarGrupos.setVisible(false);
        AgregarAlumnos.setVisible(false);
        ClaveGConsulta.setText("");
        periodoConsulta.setText("");
        gradoConsulta.setText("");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(false);
        ConsultarGrupos.setVisible(false);
        ModificarGrupos.setVisible(true);
        EliminarGrupos.setVisible(false);
        AgregarAlumnos.setVisible(false);
        claveModificar.setText("");
        tableModificar.setVisible(false);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(false);
        ConsultarGrupos.setVisible(false);
        ModificarGrupos.setVisible(false);
        EliminarGrupos.setVisible(true);
        AgregarAlumnos.setVisible(false);
        claveEliminar.setText("");
        jTextField33.setText("");
        jTextField34.setText("");
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void gradoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradoConsultaActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(false);
        ConsultarGrupos.setVisible(false);
        ModificarGrupos.setVisible(false);
        EliminarGrupos.setVisible(false);
        AgregarAlumnos.setVisible(false);
        
   
        
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        AdministracionGrupos.setVisible(true);
        RegistroGrupos.setVisible(false);
        ConsultarGrupos.setVisible(false);
        ModificarGrupos.setVisible(false);
        EliminarGrupos.setVisible(false);
        AgregarAlumnos.setVisible(true);
        claveAAG.setText("");
        datosEnviar=consulGrupos.consultarAlumnos();
        llenarTablaAAG(datosEnviar);
        
        
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        ContralarMaterias.setVisible(true);
        RegistroMaterias.setVisible(true);
        ConsultarMaterias.setVisible(false);
        ModificarMaterias.setVisible(false);
        EliminarMaterias.setVisible(false);
        tablaAgregarMat.setVisible(false);
        claveMatRegistrar.setText("");
        nombreMatRegistrar.setText("");
        DescripMatRegistrar.setText("");
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        ContralarMaterias.setVisible(true);
        RegistroMaterias.setVisible(false);
        ConsultarMaterias.setVisible(true);
        ModificarMaterias.setVisible(false);
        EliminarMaterias.setVisible(false);
        TablaModificarMaterias.setVisible(false);
        claveMatConsultar.setText("");
        nombreMatConsultar.setText("");
        descripMatConsultar.setText("");
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        ContralarMaterias.setVisible(true);
        RegistroMaterias.setVisible(false);
        ConsultarMaterias.setVisible(false);
        ModificarMaterias.setVisible(true);
        EliminarMaterias.setVisible(false);
        TablaModificarMat.setVisible(false);
        claveModificarMat.setText("");
        nombreMatModificar.setText("");
        descripMatModificar.setText("");
        
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        ContralarMaterias.setVisible(true);
        RegistroMaterias.setVisible(false);
        ConsultarMaterias.setVisible(false);
        ModificarMaterias.setVisible(false);
        EliminarMaterias.setVisible(true);
        claveEliminarMat.setText("");
        NombMatEliminar.setText("");
        DescripMatEliminar.setText("");
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        ContralarMaterias.setVisible(true);
        RegistroMaterias.setVisible(false);
        ConsultarMaterias.setVisible(false);
        ModificarMaterias.setVisible(false);
        EliminarMaterias.setVisible(false);
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        GestionCriterios.setVisible(true);
        RegistroCriterios.setVisible(true);
        ConsultarCriterios.setVisible(false);
        ModificarCriterios.setVisible(false);
        EliminarCriterios.setVisible(false);
        ClaveCrRegistro.setText("");
        NombreCrRegistrar.setText("");
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        GestionCriterios.setVisible(true);
        RegistroCriterios.setVisible(false);
        ConsultarCriterios.setVisible(true);
        ModificarCriterios.setVisible(false);
        EliminarCriterios.setVisible(false);
        TablaConsCriterios.setVisible(false);
        ClaveCRConsultar.setText("");
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        GestionCriterios.setVisible(true);
        RegistroCriterios.setVisible(false);
        ConsultarCriterios.setVisible(false);
        ModificarCriterios.setVisible(true);
        EliminarCriterios.setVisible(false);
        TablaModificarCri.setVisible(false);
        ClaveModificarCri.setText("");
        
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        GestionCriterios.setVisible(true);
        RegistroCriterios.setVisible(false);
        ConsultarCriterios.setVisible(false);
        ModificarCriterios.setVisible(false);
        EliminarCriterios.setVisible(true);
        claveEliminarCri.setText("");
        nomCriEliminar.setText("");
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipalDirectora.setVisible(false);
        GestionCriterios.setVisible(true);
        RegistroCriterios.setVisible(false);
        ConsultarCriterios.setVisible(false);
        ModificarCriterios.setVisible(false);
        EliminarCriterios.setVisible(false);
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalProfesor.setVisible(false);
        Controldecalificaciones.setVisible(true);
        RegistrarCalificaciones.setVisible(false);
        ConsultarCalificaciones.setVisible(false);
        ModificarCalificaciones.setVisible(false);
        EliminarCalificaciones.setVisible(false);
        
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        Controldecalificaciones.setVisible(true);
        RegistrarCalificaciones.setVisible(false);
        ConsultarCalificaciones.setVisible(false);
        ModificarCalificaciones.setVisible(true);
        EliminarCalificaciones.setVisible(false);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(false);
        Controldecalificaciones.setVisible(true);
        RegistrarCalificaciones.setVisible(true);
        ConsultarCalificaciones.setVisible(false);
        ModificarCalificaciones.setVisible(false);
        EliminarCalificaciones.setVisible(false);
        
        
        GrupoCaliR.removeAllItems();;
        mensjRArr = consulGrupos.consultarGruposCombo();
        GrupoCaliR.addItem("Seleccione el grupo");
        for(String dato : mensjRArr)
        {
            
            GrupoCaliR.addItem(dato);
                        
        }
        
        
        MateriaCaliR.removeAllItems();;
        mensjRArr = consulMaterias.consultarMateriaCombo();
        MateriaCaliR.addItem("Seleccione la materia");
        for(String dato : mensjRArr)
        {
            
            MateriaCaliR.addItem(dato);
                        
        }
        
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(true);
        AdministracionGrupos.setVisible(false);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        
        if (!claveGrupo.getText().equals("") && !periodoGrup.getSelectedItem().toString().equals("Seleccione el periodo") && !GradoGru.getSelectedItem().toString().equals("Seleccione el grado para el grupo"))
        {
            datosEnviar = new String[3];
            datosEnviar[0]=claveGrupo.getText();
            datosEnviar[1]= periodoGrup.getSelectedItem().toString();
            datosEnviar[2]= GradoGru.getSelectedItem().toString();
           
            mensj=consulGrupos.registroGrupo(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Faltan datos por definir para el registro");
        }
        
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        
        if(!ClaveGConsulta.getText().equals("")){
            mensj = ClaveGConsulta.getText();
            String recibir[]=consulGrupos.consultarGrupos(mensj);
            if(recibir.length>=3)
            {
                periodoConsulta.setText(recibir[1].toString());
                gradoConsulta.setText(recibir[2].toString());
            }
            else
            {
                JOptionPane.showMessageDialog(null, recibir);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe introducir la clave de grupo para realizar la consulta");
        }
        
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        tableModificar.setVisible(true);
        int x = modelo.getRowCount();
        if(!claveModificar.getText().equals("")){
            if(x==1)
            {
                modelo.removeRow(0);
                mensj = claveModificar.getText(); 
                String recibir[]=consulGrupos.consultarGrupos(mensj);
            
                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulGrupos.consultarGrupos(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    modelo.addRow(recibir);
                }
            }
            else
            {
                mensj = claveModificar.getText(); 
                String recibir[]=consulGrupos.consultarGrupos(mensj);

                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulGrupos.consultarGrupos(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    x=modelo.getRowCount()+1;
                    modelo.addRow(recibir);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe introducir la clave de grupo para realizar la consulta");
        } 
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        if(modelo.getValueAt(0,0).equals("")||modelo.getValueAt(0,1).equals("")||modelo.getValueAt(0,2).equals(""))
        {
            JOptionPane.showMessageDialog(null, "Datos faltantes");
        }
        else
        {
            tableModificar.setModel(modelo);
            datosEnviar = new String[3];
            datosEnviar[0]=(String) modelo.getValueAt(0,0);
            datosEnviar[1]=(String) modelo.getValueAt(0,1);
            datosEnviar[2]=(String) modelo.getValueAt(0,2);

            mensj=consulGrupos.modificarGrupo(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
            claveModificar.setText("");
            tableModificar.setVisible(false);
        }
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        
        if(claveEliminar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");
                    
        }
        else
        {
            mensj=claveEliminar.getText();
            String recibir[]= consulGrupos.consultarGrupos(mensj);
            if(recibir.length>=2){
                jTextField33.setText(recibir[1]);
                jTextField34.setText(recibir[2]);
            }
            else
            {
                JOptionPane.showMessageDialog(null, recibir);
            }

        }
        
        
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
        
        datosEnviar = new String[2];
        
        int fila = tableAAG.getSelectedRow();
        System.out.println("numero de fila"+fila);
        if(fila>=0)
        {
            datosEnviar[0] = claveAAG.getText();
            datosEnviar[1] = tableAAG.getValueAt(fila, 0).toString();
            mensj = consulGrupos.agregarAlumGru(datosEnviar);
            JOptionPane.showMessageDialog(null,mensj);
            claveAAG.setText("");
        }
        else
        {
           JOptionPane.showMessageDialog(null,"No selecciono fila");
        }
        
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        
        if(claveEliminar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");
                    
        }
        else
        {
            String recibir=claveEliminar.getText();
            mensj= consulGrupos.eliminarGrupos(recibir);
            JOptionPane.showMessageDialog(null, mensj);
            claveEliminar.setText("");
            jTextField33.setText("");
            jTextField34.setText("");
        }
        
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        // TODO add your handling code here:
        
        if(ClaveCrRegistro.getText().equals("") && NombreCrRegistrar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
        }
        else
        {
            String datosEnviar[]=new String [2];
            datosEnviar[0]=ClaveCrRegistro.getText();
            datosEnviar[1]=NombreCrRegistrar.getText();
            mensj=consulCriterios.agregarCriterio(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
            ClaveCrRegistro.setText("");
            NombreCrRegistrar.setText("");
        }
        
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        // TODO add your handling code here:
        TablaConsCriterios.setVisible(true);
        int x = modelo2.getRowCount();
        if(!ClaveCRConsultar.getText().equals("")){
            if(x==1)
            {
                modelo2.removeRow(0);
                mensj = ClaveCRConsultar.getText(); 
                String recibir[]=consulCriterios.consultarCriterios(mensj);

                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulCriterios.consultarCriterios(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    modelo2.addRow(recibir);
                }
            }
            else
            {
                mensj = ClaveCRConsultar.getText(); 
                String recibir[]=consulCriterios.consultarCriterios(mensj);

                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulCriterios.consultarCriterios(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    x=modelo2.getRowCount()+1;
                    modelo2.addRow(recibir);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe introducir la clave de grupo para realizar la consulta");
        }
        
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        // TODO add your handling code here:
        TablaModificarCri.setVisible(true);
        int x = modelo3.getRowCount();
        if(!ClaveModificarCri.getText().equals("")){
            if(x==1)
            {
                modelo3.removeRow(0);
                mensj = ClaveModificarCri.getText(); 
                String recibir[]=consulCriterios.consultarCriterios(mensj);

                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulCriterios.consultarCriterios(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    modelo3.addRow(recibir);  
                }     
            
            }
            else
            {
                mensj = ClaveModificarCri.getText(); 
                String recibir[]=consulCriterios.consultarCriterios(mensj);

                if(recibir.length==1)
                {
                    String datosEnviar[]=new String[1];
                    datosEnviar=consulCriterios.consultarCriterios(mensj);
                    JOptionPane.showMessageDialog(null, datosEnviar);
                }
                else
                {
                    x=modelo3.getRowCount()+1;
                    modelo3.addRow(recibir);  
                }     
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe introducir la clave de criterio para realizar la busqueda");
        }
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        // TODO add your handling code here:
        
        if(modelo3.getValueAt(0,0).equals("")||modelo3.getValueAt(0,1).equals(""))
        {
            JOptionPane.showMessageDialog(null, "Datos faltantes");
        }
        else
        {
            TablaModificarCri.setModel(modelo3);
            datosEnviar = new String[3];
            datosEnviar[0]= ClaveModificarCri.getText();
            datosEnviar[1]=(String) modelo3.getValueAt(0,0);
            datosEnviar[2]=(String) modelo3.getValueAt(0,1);
            
            mensj=consulCriterios.modificarCriterio(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
            ClaveModificarCri.setText("");
            TablaModificarCri.setVisible(false);
        }
        
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        // TODO add your handling code here:
        if(claveEliminarCri.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");
        }
        else
        {
            mensj=claveEliminarCri.getText();
            String recibir[]= consulCriterios.consultarCriterios(mensj);
            if(recibir.length>=2){
                nomCriEliminar.setText(recibir[1]);
            }
            else
            {
                JOptionPane.showMessageDialog(null, recibir);
            }

        }
        
        
    }//GEN-LAST:event_jButton74ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        // TODO add your handling code here:
        
        if(claveEliminarCri.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");
                    
        }
        else
        {
            String recibir=claveEliminarCri.getText();
            mensj= consulCriterios.eliminarCriterio(mensj);
            JOptionPane.showMessageDialog(null, mensj);
            claveEliminarCri.setText("");
            nomCriEliminar.setText("");
        }
        
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        
         if(claveEliminarMat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave de la materia a eliminar");
        }
        else
        {
            mensj=claveEliminarMat.getText();
            String recibir[]= consulMaterias.consultarMaterias(mensj);
            if(recibir.length>=2){
                NombMatEliminar.setText(recibir[1]);
                DescripMatEliminar.setText(recibir[2]);
            }
            else
            {
                JOptionPane.showMessageDialog(null, recibir);
            }

        }
        
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        
        if(claveEliminarMat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");
                    
        }
        else
        {
            String recibir=claveEliminarMat.getText();
            mensj= consulMaterias.eliminarMaterias(mensj);
            JOptionPane.showMessageDialog(null, mensj);
            claveEliminarMat.setText("");
            NombMatEliminar.setText("");
            DescripMatEliminar.setText("");
        }
        
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
                
    if(claveModificarMat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave del grupo a eliminar");         
        }
        else
        {
            String enviar=claveModificarMat.getText();
            String mensArre[]=consulMaterias.consultarMaterias(enviar);
            if(mensArre.length>=3)
            {
                nombreMatModificar.setText(mensArre[1].toString());
                descripMatModificar.setText(mensArre[2].toString());
            }
            else
            {
                JOptionPane.showMessageDialog(null, mensArre);
            }
        }
                
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
        TablaModificarMaterias.setVisible(true);
        int x = modelo4.getRowCount();
        if(!claveMatConsultar.getText().equals("")){
            if(x>0)
            {
                for(int i=0;i<x;i++)
                {
                    modelo4.removeRow(0);  
                }
                mensj = claveMatConsultar.getText();
                String recibir[]=consulMaterias.consultarMaterias(mensj);
                String recibirCri[] = consulMaterias.consultarMateriasCri(mensj);
                if(recibir.length>=3)
                {    
                    nombreMatConsultar.setText(recibir[1].toString());
                    descripMatConsultar.setText(recibir[2].toString());
                    llenarTablaCM(recibirCri);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, recibir);
                }

      
            }
            else
            {
                mensj = claveMatConsultar.getText();
                String recibir[]=consulMaterias.consultarMaterias(mensj);
                String recibirCri[] = consulMaterias.consultarMateriasCri(mensj);
                if(recibir.length>=3)
                {
                    nombreMatConsultar.setText(recibir[1].toString());
                    descripMatConsultar.setText(recibir[2].toString());
                    llenarTablaCM(recibirCri);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, recibir);
                }
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe introducir la clave de grupo para realizar la consulta");
        }
        
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
        
        if(!claveMatRegistrar.getText().equals("") && !nombreMatRegistrar.getText().equals("") && !DescripMatRegistrar.getText().equals(""))
        {
            String datosEnviar []= new String [3];
            datosEnviar[0]=claveMatRegistrar.getText();
            datosEnviar[1]=nombreMatRegistrar.getText();
            datosEnviar[2]=DescripMatRegistrar.getText();
            mensj=consulMaterias.agregarMaterias(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
            if(mensj=="Materia registrada correctamente")
            {
                JOptionPane.showMessageDialog(null, "Agregue los criterios a la materia");
                tablaAgregarMat.setVisible(true);
                labelagregarCri.setText("Seleccione el criterio y de clic derecho Agregar");
                String recibirCri[]=consulMaterias.consultarTodosCriterios();
                tablaAgregarMat.setModel(modelo5);
                llenarTablaRM(recibirCri);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
        }
        
    }//GEN-LAST:event_jButton68ActionPerformed

    private void DescripMatRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripMatRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripMatRegistrarActionPerformed
    
    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:

        if(!claveMatRegistrar.getText().equals(""))
        {
            String datosEnviar []= new String [2];
            datosEnviar[0]=claveMatRegistrar.getText();
            datosEnviar[1]=modelo5.getValueAt(tablaAgregarMat.getSelectedRow(), 0).toString();
            mensj=consulMaterias.agregarControlCriterios(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe definir una clave para registrar el criterio");
        }
        
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
        if(claveModificarMat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe definir la clave de la materia a eliminar");         
        }
        else
        {
            String datosEnviar []= new String [3];
            datosEnviar[0]=claveModificarMat.getText();
            datosEnviar[1]=nombreMatModificar.getText();
            datosEnviar[2]=descripMatModificar.getText();
            mensj=consulMaterias.modificarMateria(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
            if(mensj=="Materia modificada correctamente")
            {    
                String res =JOptionPane.showInputDialog("Desea modificar la asignacion de criterios a esta materia");
                if(res.contains("Si")||res.contains("SI")||res.contains("sI")||res.contains("si"))
                {
                    TablaModificarMat.setVisible(true);
                    String recibirCri[]=consulMaterias.consultarMateriasCri(datosEnviar[0]);
                    llenarTablaMM(recibirCri);

                }
            }

        }
        
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
        
        if(!claveModificarMat.getText().equals(""))
        {
            String datosEnviar []= new String [2];
            datosEnviar[0]=claveModificarMat.getText();
            datosEnviar[1]=modelo6.getValueAt(TablaModificarMat.getSelectedRow(), 0).toString();
            mensj=consulMaterias.agregarControlCriterios(datosEnviar);
            JOptionPane.showMessageDialog(null, mensj);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe definir una clave para registrar el criterio");
        }
        
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        
        if(!claveModificarMat.getText().equals(""))
        {
            String env;
            env=modelo6.getValueAt(TablaModificarMat.getSelectedRow(), 0).toString();
            mensj=consulMaterias.eliminarControlCriterios(env);
            JOptionPane.showMessageDialog(null, mensj);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe definir una clave para registrar el criterio");
        }
        
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
        ContralarMaterias.setVisible(false);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
        AdministracionGrupos.setVisible(false);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
        GestionCriterios.setVisible(false);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if(!Usuario.getText().equals("")&&!Contraseña.getText().equals(""))
        {
            usuario = Usuario.getText();
            contraseña = Contraseña.getText();

            mensjRArr = ConsulUsuarios.ConsultarLogueo(usuario, contraseña);

            if(mensjRArr.length>1)
            {
                if(mensjRArr[0].equals("1")&&mensjRArr[1].equals("Director(a)"))
                {
                    LogeoUsuario.setVisible(false);
                    MenuPrincipalDirectora.setVisible(true);
                }
                else
                {

                    if(mensjRArr[0].equals("1")&&mensjRArr[1].equals("Profesor(a)"))
                    {

                        LogeoUsuario.setVisible(false);
                        MenuPrincipalProfesor.setVisible(true);

                    }

                }

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "Debe de ingresar el nombre y contraseña");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        RegistroPagos.setVisible(true);
        ConsultarPagos.setVisible(false);
        ModificarPagos.setVisible(false);
        EliminarPagos.setVisible(false);

        mensjRArr = ConsulAlumnos.consultarDatos();

        AlumnoPagoR.removeAllItems();
        AlumnoPagoR.addItem("Seleccione un alumno");

        for(String x :mensjRArr)
        {

            AlumnoPagoR.addItem(x);

        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        RegistroPagos.setVisible(false);
        ConsultarPagos.setVisible(true);
        ModificarPagos.setVisible(false);
        EliminarPagos.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        RegistroPagos.setVisible(false);
        ConsultarPagos.setVisible(false);
        ModificarPagos.setVisible(true);
        EliminarPagos.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        RegistroPagos.setVisible(false);
        ConsultarPagos.setVisible(false);
        ModificarPagos.setVisible(false);
        EliminarPagos.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaPagoCon.getText().equals(""))
        {
            mensjRArr = ConsulAlumnos.consultarNonbre(MatriculaPagoCon.getText());

            if(mensjRArr.length>1)
            {
                NombrePagoCon.setText(mensjRArr[0].concat(mensjRArr[1]).concat(" ").concat(mensjRArr[2]));
                mensjRArr = ConsultasPagos.consultarPagosAlumno(MatriculaPagoCon.getText());
                mostrarDatosPagosCon(mensjRArr);

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "El campo de la matricula del alumno se encuentra vacío");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaPagosEli.getText().equals(""))
        {
            mensjRArr = ConsulAlumnos.consultarNonbre(MatriculaPagosEli.getText());

            if(mensjRArr.length>1)
            {
                AlumnosPagosEli.setText(mensjRArr[0].concat(mensjRArr[1]).concat(" ").concat(mensjRArr[2]));
                mensjRArr = ConsultasPagos.consultarPagosAlumno(MatriculaPagosEli.getText());
                mostrarDatosPagosEli(mensjRArr);

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "El campo de la matricula del alumno se encuentra vacío");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaPagoMo.getText().equals(""))
        {
            mensjRArr = ConsulAlumnos.consultarNonbre(MatriculaPagoMo.getText());

            if(mensjRArr.length>1)
            {
                AlumnoPagoMo.setText(mensjRArr[0].concat(" ").concat(mensjRArr[1]).concat(" ").concat(mensjRArr[2]));
                mensjRArr = ConsultasPagos.consultarPagosAlumnoId(MatriculaPagoMo.getText());
                mostrarDatosPagosMo(mensjRArr);

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "El campo de la matricula del alumno se encuentra vacío");

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mensjRArr = new String[TablaPagosModificar.getRowCount()];

        System.err.println("Tamaño de la tabla"+" "+TablaPagosModificar.getRowCount());
        for(int i=0; i<TablaPagosModificar.getRowCount(); i++)
        {

            mensjRArr[i] = TablaPagosModificar.getValueAt(i, 2).toString().concat("¬").concat(TablaPagosModificar.getValueAt(i, 3).toString()).concat("¬")
            .concat(TablaPagosModificar.getValueAt(i, 1).toString()).concat("¬").concat(MatriculaPagoMo.getText()).concat("¬").concat(TablaPagosModificar.getValueAt(i, 0).toString());

            System.out.println(i+" : "+mensjRArr[i]);
        }

        mensjRArr = ConsultasPagos.MoificarPagos(mensjRArr);

        JOptionPane.showMessageDialog(null, "Detalles de modificación en los pagos del alumno:"+" "+AlumnoPagoMo.getText()+"\n");

        mensj="";
        for(int i =0; i < mensjRArr.length; i++)
        {

            //            JOptionPane.showMessageDialog(null, mensjRArr[i]);
            mensj = mensj.concat("\n").concat(mensjRArr[i]).concat("\n");

        }

        JOptionPane.showMessageDialog(null, mensj);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String[] splitt;

        if(!NombrePagoR.getText().equals("")&&!MontoPagoR.getText().equals("")&&!AlumnoPagoR.getSelectedItem().toString().equals("Seleccione un alumno")
            &&!DiaPagoR.getSelectedItem().toString().equals("Dia")&&!MesPagoR.getSelectedItem().toString().equals("Mes")&&!AnioPagoR.getSelectedItem().toString().equals("Año"))
        {

            mensjRArr = new String[4];
            mensjRArr[0] = MontoPagoR.getText();
            mensjRArr[1] = AnioPagoR.getSelectedItem().toString().concat("-").concat(MesPagoR.getSelectedItem().toString().concat("-").concat(DiaPagoR.getSelectedItem().toString()));
            mensjRArr[2] = NombrePagoR.getText();
            splitt = AlumnoPagoR.getSelectedItem().toString().split("-");

            mensjRArr[3] = splitt[0];

            mensj = ConsultasPagos.registrarPago(mensjRArr);

            JOptionPane.showMessageDialog(null, mensj);
        }
        else
        JOptionPane.showMessageDialog(null, "Hace falta llenar campos del formulario");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EliminarPagoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPagoItemActionPerformed
        // TODO add your handling code here:

        int fila = TablaPagosEli.getSelectedRow();
        System.out.println("numero de fila"+fila);
        if(fila>=0)
        {

            mensj = JOptionPane.showInputDialog("Seguro que desea eliminar el pago:"+TablaPagosEli.getValueAt(fila, 0).toString());

            if(mensj.equals("si")||mensj.equals("Si")||mensj.equals("sI")||mensj.equals("SI")||mensj.equals("s"))
            {

                mensjRArr = new String[2];

                mensjRArr[0] = MatriculaPagosEli.getText();
                mensjRArr[1] = TablaPagosEli.getValueAt(fila, 1).toString();

                DefaultTableModel m = (DefaultTableModel) TablaPagosEli.getModel();
                String menRecibido=ConsultasPagos.EliminarPagos(mensjRArr);
                JOptionPane.showMessageDialog(null, menRecibido);
                m.removeRow(fila);
                MatriculaPagosEli.setText("");
                AlumnosPagosEli.setText("");

//                if(menRecibido.equals("Datos elimnados correctamente"))
//                {
//                    TablaPagosEli.removeRowSelectionInterval(fila, fila);
//                }
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null,"No selecciono una fila de la tabla");
        }

    }//GEN-LAST:event_EliminarPagoItemActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:

        Registrar.setVisible(true);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);

    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:

        Registrar.setVisible(false);
        Consultar.setVisible(true);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(true);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(true);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
        NombreComUsuEli.setVisible(false);
        NombreDUsuEli.setVisible(false);
        TipoUSuEli.setVisible(false);
        LabelNDUsuELi.setVisible(false);
        LabelTipo.setVisible(false);
        LableNomUsuEli.setVisible(false);
        ButonUsuELi.setVisible(false);
        MensajeUsuEli.setVisible(false);
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String nombreTem;

        if(!ClaveEmpleadoR.getText().equals("")&&!NombreEmR.getText().equals("")&&!ApellidosUsuR.getText().equals("")&&!TelUsuR.getText().equals("")
            &&!DireccionUsuR.getText().equals("")&&!NombreUsuarioR.getText().equals("")&&!ContraUsuR.getText().equals("")
            &&!VContraUsuR.getText().equals("")&&!TiposUsuR.getSelectedItem().toString().equals("Seleccione"))
        {
            if(ContraUsuR.getText().equals(VContraUsuR.getText()))
            {

                mensj = ConsulUsuarios.consultarUsuario(NombreUsuarioR.getText());

                if(mensj.equals("1"))
                {
                    mensjRArr = new String[5];

                    mensjRArr[0] = ClaveEmpleadoR.getText();
                    mensjRArr[1] = ApellidosUsuR.getText();
                    mensjRArr[2] = NombreEmR.getText();
                    mensjRArr[3] = DireccionUsuR.getText();
                    mensjRArr[4] = TelUsuR.getText();

                    mensj = ConsulUsuarios.registrarEmpleado(mensjRArr);

                    if(mensj.equals("1"))
                    {

                        mensjRArr = new String[4];

                        mensjRArr[0] = NombreUsuarioR.getText();
                        mensjRArr[1] = ContraUsuR.getText();
                        mensjRArr[2] = ClaveEmpleadoR.getText();
                        mensjRArr[3] = TiposUsuR.getSelectedItem().toString();

                        mensj = ConsulUsuarios.registrarUsuario(mensjRArr);

                        JOptionPane.showMessageDialog(null, mensj);

                    }
                    else
                    {JOptionPane.showMessageDialog(null, mensj);}

                }
                else
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya ha sido registrado");

            }
            else
            {JOptionPane.showMessageDialog(null, "La contraseña no coincide");}

        }
        else
        {JOptionPane.showMessageDialog(null, "Debe de llenar todos lo campos");}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(!ClaveUsuEli.getText().equals(""))
        {
            mensjRArr = ConsulUsuarios.consultarUsuEm(ClaveUsuEli.getText());

            if(mensjRArr.length>1)
            {
                NombreComUsuEli.setVisible(false);
                NombreDUsuEli.setVisible(false);
                TipoUSuEli.setVisible(false);
                LabelNDUsuELi.setVisible(false);
                LabelTipo.setVisible(false);
                LableNomUsuEli.setVisible(false);
                ButonUsuELi.setVisible(false);
                MensajeUsuEli.setVisible(false);
                NombreComUsuEli.setText(mensjRArr[1]);
                NombreDUsuEli.setText(mensjRArr[0]);
                TipoUSuEli.setText(mensjRArr[2]);

                NombreComUsuEli.setVisible(true);
                NombreDUsuEli.setVisible(true);
                TipoUSuEli.setVisible(true);
                LabelNDUsuELi.setVisible(true);
                LabelTipo.setVisible(true);
                LableNomUsuEli.setVisible(true);
                ButonUsuELi.setVisible(true);

                MensajeUsuEli.setVisible(true);

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "DEbe de llenar el campo de la clave del empleado");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jToggleButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton13ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(true);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton13ActionPerformed

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton14ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(true);
        Eliminar.setVisible(false);
        Modificar.setVisible(true);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton14ActionPerformed

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton15ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(true);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton15ActionPerformed

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton16ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(true);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
        NombreComUsuEli.setVisible(false);
        NombreDUsuEli.setVisible(false);
        TipoUSuEli.setVisible(false);
        LabelNDUsuELi.setVisible(false);
        LabelTipo.setVisible(false);
        LableNomUsuEli.setVisible(false);
        ButonUsuELi.setVisible(false);

        MensajeUsuEli.setVisible(false);
    }//GEN-LAST:event_jToggleButton16ActionPerformed

    private void ButonUsuELiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonUsuELiActionPerformed
        // TODO add your handling code here:

        mensj = ConsulUsuarios.EliminarEmpleado(ClaveUsuEli.getText());
        JOptionPane.showMessageDialog(null, mensj);
        mensj = ConsulUsuarios.EliminarUsuario(ClaveUsuEli.getText());
        JOptionPane.showMessageDialog(null, mensj);

    }//GEN-LAST:event_ButonUsuELiActionPerformed

    private void NombreUsuConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreUsuConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuConActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(true);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(true);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(true);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton12ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(true);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);

        NombreComUsuEli.setVisible(false);
        NombreDUsuEli.setVisible(false);
        TipoUSuEli.setVisible(false);
        LabelNDUsuELi.setVisible(false);
        LabelTipo.setVisible(false);
        LableNomUsuEli.setVisible(false);
        ButonUsuELi.setVisible(false);
        MensajeUsuEli.setVisible(false);

    }//GEN-LAST:event_jToggleButton12ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:

        if(!ClaveUsuCon.getText().equals(""))
        {
            mensjRArr = ConsulUsuarios.consultarUsuEDatos(ClaveUsuCon.getText());

            if(mensjRArr.length>1)
            {
                NombreUsuCon.setText(mensjRArr[0]);
                ApellidosUsuCon.setText(mensjRArr[1]);
                NombreDUsuCon.setText(mensjRArr[2]);
                TipoUsuCon.setText(mensjRArr[3]);
            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "Debes de ingresar una clave de usuario");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton17ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(true);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton17ActionPerformed

    private void jToggleButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(true);
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton18ActionPerformed

    private void jToggleButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton19ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(false);
        Modificar.setVisible(true);
        ModificarOPC.setVisible(false);
    }//GEN-LAST:event_jToggleButton19ActionPerformed

    private void jToggleButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton20ActionPerformed
        // TODO add your handling code here:
        Registrar.setVisible(false);
        Consultar.setVisible(false);
        Eliminar.setVisible(true);
        Modificar.setVisible(false);
        ModificarOPC.setVisible(false);

        NombreComUsuEli.setVisible(false);
        NombreDUsuEli.setVisible(false);
        TipoUSuEli.setVisible(false);
        LabelNDUsuELi.setVisible(false);
        LabelTipo.setVisible(false);
        LableNomUsuEli.setVisible(false);
        ButonUsuELi.setVisible(false);
        MensajeUsuEli.setVisible(false);
    }//GEN-LAST:event_jToggleButton20ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:

        if(!ClaveEmMo.getText().equals("")&&!NombreEmMo.getText().equals("")&&!ApellidosUsuMo.getText().equals("")&&!TelefonoUsuMo.getText().equals("")&&!DireccionUsuMo.getText().equals("")
            &&!NombreDUsuMo.getText().equals("")&&!ContraseñaUsuMo.getText().equals("")&&!VContraseñaUsuMo.getText().equals("")&&TipoUsuMo.getSelectedItem().toString().equals("Seleccione el tipo de usuario"))
        {
            if(ContraseñaUsuMo.getText().equalsIgnoreCase(VContraseñaUsuMo.getText()))
            {

                mensjRArr = new String[4];
                mensjRArr[0] = NombreDUsuMo.getText();
                mensjRArr[1] = ContraseñaUsuMo.getText();
                mensjRArr[2] = ClaveEmMo.getText();
                mensjRArr[3] = TipoUsuMo.getSelectedItem().toString();

                mensj = ConsulUsuarios.MoificarUsuario(mensjRArr);

                JOptionPane.showMessageDialog(null, mensj);

                mensjRArr = new String[6];
                mensjRArr[0] = mensj;
                mensjRArr[1] = ClaveEmMo.getText();
                mensjRArr[2] = ApellidosUsuMo.getText();
                mensjRArr[3] = NombreEmMo.getText();
                mensjRArr[4] = DireccionUsuMo.getText();
                mensjRArr[5] = TelefonoUsuMo.getText();

                mensj = ConsulUsuarios.MoificarUsuario(mensjRArr);
                JOptionPane.showMessageDialog(null, mensj);
            }
            else
            JOptionPane.showMessageDialog(null, "La contraseña no coincide");
        }
        JOptionPane.showMessageDialog(null, "Todos los campos deben de estar llenos");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        // TODO add your handling code here:
        int b;
        if(!ClaveEmMo.getText().equals(""))
        {
            mensjRArr = ConsulUsuarios.consultarDatosMo(ClaveEmMo.getText());
            mensj = ClaveEmMo.getText();
            if(mensjRArr.length>1)
            {
                NombreEmMo.setText(mensjRArr[0]);
                ApellidosUsuMo.setText(mensjRArr[1]);
                TelefonoUsuMo.setText(mensjRArr[2]);
                DireccionUsuMo.setText(mensjRArr[3]);
                NombreDUsuMo.setText(mensjRArr[4]);
                ContraseñaUsuMo.setText(mensjRArr[5]);
                VContraseñaUsuMo.setText(mensjRArr[5]);
                b= this.ComoboTipo(mensjRArr[6]);
                TipoUsuMo.setSelectedIndex(b);

            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr[0]);

        }
        else
        JOptionPane.showMessageDialog(null, "Debes de ingresar una clave de usuario");

    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        RegistrarAlumno1.setVisible(true);
        ConsultarAlumno1.setVisible(false);
        ModificarAlumno1.setVisible(false);
        EliminarAlumno1.setVisible(false);

        ap_patR.setText("");
        ap_matR.setText("");
        NombreR.setText("");
        MatriculaR.setText("");
        TutorR.setText("");
        CalleR.setText("");
        CPostalR.setText("");
        TelLocalR.setText("");
        CelR.setText("");
        MunicipioR.setSelectedIndex(0);
        PeriodoAlumno.setText("");

    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        RegistrarAlumno1.setVisible(false);
        ConsultarAlumno1.setVisible(true);
        ModificarAlumno1.setVisible(false);
        EliminarAlumno1.setVisible(false);
        PeriodoConAlum.setText("");
        Ap_patCon.setText("");
        Ap_matCon.setText("");
        NombreCon.setText("");
        MatriculaCon.setText("");
        TutorCon.setText("");
        CalleCon.setText("");
        CPostaCon.setText("");
        TeLocCon.setText("");
        CelCon.setText("");
        MunicipioCon.setSelectedIndex(0);

    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        RegistrarAlumno1.setVisible(false);
        ConsultarAlumno1.setVisible(false);
        ModificarAlumno1.setVisible(true);
        EliminarAlumno1.setVisible(false);
        PeriodoModAlumno.setText("");
        Ap_patMo.setText("");
        AP_matMo.setText("");
        NombreMo.setText("");
        MatriculaMo.setText("");
        TutorMo.setText("");
        CalleMo.setText("");
        CPostalMo.setText("");
        TelLocMo.setText("");
        CelMo.setText("");
        MunicipioMo.setSelectedIndex(0);
        MatriculaCon.setEditable(true);

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        RegistrarAlumno1.setVisible(false);
        ConsultarAlumno1.setVisible(false);
        ModificarAlumno1.setVisible(false);
        EliminarAlumno1.setVisible(true);

        MatriculaEli.setText("");
        Ap_patEli.setText("");
        Ap_matEli.setText("");
        NombreEli.setText("");
        TutorEli.setText("");
        MensajePreventivoEli.setVisible(false);
        BotonAceptarEli.setVisible(false);
        MatriculaEli.setEditable(true);

    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaCon.getText().equals(""))
        {

            mensjRArr = ConsulAlumnos.consultar(MatriculaCon.getText());

            if(mensjRArr.length>1)
            {
                Ap_patCon.setText(mensjRArr[0]);
                Ap_matCon.setText(mensjRArr[1]);
                NombreCon.setText(mensjRArr[2]);
                TutorCon.setText(mensjRArr[3]);
                CalleCon.setText(mensjRArr[4]);
                MunicipioCon.setSelectedIndex(ComoboMunicipio(mensjRArr[5]));
                CPostaCon.setText(mensjRArr[6]);
                TeLocCon.setText(mensjRArr[7]);
                CelCon.setText(mensjRArr[8]);
                PeriodoConAlum.setText(mensjRArr[9]);
            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr);

        }
        else
        JOptionPane.showMessageDialog(null, "Debes de llenar el campo de matricula");

    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:

        if(!Ap_patMo.getText().equals("")&&!AP_matMo.getText().equals("")&&!NombreMo.getText().equals("")&&!TutorMo.getText().equals("")
            &&!CalleMo.getText().equals("")&&!MunicipioMo.getSelectedItem().toString().equals("")&&!CPostalMo.getText().equals("")&&!TelLocMo.getText().equals("")&&!CelMo.getText().equals("")&&!PeriodoModAlumno.getText().equals(""))
        {

            mensjRArr = new String[11];

            mensjRArr[0] = MatriculaMo.getText();
            mensjRArr[1] = Ap_patMo.getText();
            mensjRArr[2] = AP_matMo.getText();
            mensjRArr[3] = NombreMo.getText();
            mensjRArr[4] = TutorMo.getText();
            mensjRArr[5] = CalleMo.getText();
            mensjRArr[6] = MunicipioMo.getSelectedItem().toString();
            mensjRArr[7] = CPostalMo.getText();
            mensjRArr[8] = TelLocMo.getText();
            mensjRArr[9] = CelMo.getText();
            mensjRArr[10] =PeriodoModAlumno.getText();

            mensj = ConsulAlumnos.Moificar(mensjRArr);

            JOptionPane.showMessageDialog(null, mensj);
            
            MatriculaMo.setEditable(true);
            

        }
        else
        JOptionPane.showMessageDialog(null, "Todos los campos deben de estar llenos");

    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaMo.getText().equals(""))
        {

            mensjRArr = ConsulAlumnos.consultar(MatriculaMo.getText());

            if(mensjRArr.length>1)
            {
                Ap_patMo.setText(mensjRArr[0]);
                AP_matMo.setText(mensjRArr[1]);
                NombreMo.setText(mensjRArr[2]);
                TutorMo.setText(mensjRArr[3]);
                CalleMo.setText(mensjRArr[4]);
                MunicipioMo.setSelectedIndex(ComoboMunicipio(mensjRArr[5]));
                CPostalMo.setText(mensjRArr[6]);
                TelLocMo.setText(mensjRArr[7]);
                CelMo.setText(mensjRArr[8]);
                PeriodoModAlumno.setText(mensjRArr[9]);
                MatriculaMo.setEditable(false);
            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr);

        }
        else
        JOptionPane.showMessageDialog(null, "Debes de llenar el campo de matricula");

    }//GEN-LAST:event_jButton36ActionPerformed

    private void BotonAceptarEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarEliActionPerformed
        // TODO add your handling code here:

        mensj = ConsulAlumnos.Eliminar(MatriculaEli.getText());

        JOptionPane.showMessageDialog(null, mensj);

    }//GEN-LAST:event_BotonAceptarEliActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:

        if(!MatriculaEli.getText().equals(""))
        {

            mensjRArr = ConsulAlumnos.consultar(MatriculaEli.getText());

            if(mensjRArr.length>1)
            {
                Ap_patEli.setText(mensjRArr[0]);
                Ap_matEli.setText(mensjRArr[1]);
                NombreEli.setText(mensjRArr[2]);
                TutorEli.setText(mensjRArr[3]);
                MensajePreventivoEli.setVisible(true);
                BotonAceptarEli.setVisible(true);
                MatriculaEli.setEditable(false);
            }
            else
            JOptionPane.showMessageDialog(null, mensjRArr);

        }

    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:

        if(!ap_patR.getText().equals("")&&!ap_matR.getText().equals("")&&!NombreR.getText().equals("")&&!MatriculaR.getText().equals("")&&!TutorR.getText().equals("")
            &&!CalleR.getText().equals("")&&!CPostalR.getText().equals("")&&!TelLocalR.getText().equals("")&&!CelR.getText().equals("")&&!MunicipioR.getSelectedItem().toString().equals("Seleccione el municipio")&&!PeriodoAlumno.getText().equals(""))
        {
            datosEnviar = new String[11];

            datosEnviar[0] = MatriculaR.getText();
            datosEnviar[1] = ap_patR.getText();
            datosEnviar[2] = ap_matR.getText();
            datosEnviar[3] = NombreR.getText();
            datosEnviar[4] = TutorR.getText();
            datosEnviar[5] = CalleR.getText();
            datosEnviar[6] = MunicipioR.getSelectedItem().toString();
            datosEnviar[7] = CPostalR.getText();
            datosEnviar[8] = TelLocalR.getText();
            datosEnviar[9] = CelR.getText();
            datosEnviar[10] = PeriodoAlumno.getText();
            mensj = ConsulAlumnos.registrar(datosEnviar);

            JOptionPane.showMessageDialog(null,mensj);

        }
        else
        JOptionPane.showMessageDialog(null,"Hace falta llenar los datos.");

    }//GEN-LAST:event_jButton38ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
         AdministrarUsuarios.setVisible(true);
        Controldecalificaciones.setVisible(false);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        
        AdministrarUsuarios.setVisible(true);
        Controldecalificaciones.setVisible(false);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
        AdministracionPagos.setVisible(false);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        AdministrarUsuarios.setVisible(true);
        GestionDeInscripcionesAlumno.setVisible(false);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipalDirectora.setVisible(true);
        Controldecalificaciones.setVisible(false);
        
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(true);
        ContralarMaterias.setVisible(false);
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(true);
        GestionCriterios.setVisible(false);
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        // TODO add your handling code here:
        MenuPrincipalDirectora.setVisible(true);
        AdministracionPagos.setVisible(false);
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipalDirectora.setVisible(true);
        GestionDeInscripcionesAlumno.setVisible(false);
        
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        MenuPrincipalDirectora.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        Controldecalificaciones.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        AdministracionGrupos.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        ContralarMaterias.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        GestionCriterios.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        MenuPrincipalProfesor.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        
        LogeoUsuario.setVisible(true);
        AdministracionPagos.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        LogeoUsuario.setVisible(true);
        GestionDeInscripcionesAlumno.setVisible(false);
        usuario= "";
        contraseña = "";
        Usuario.setText("");
        Contraseña.setText("");
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void GrupoCaliRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GrupoCaliRItemStateChanged
        // TODO add your handling code here:
        
        if(evt.getStateChange() == ItemEvent.SELECTED && !GrupoCaliR.getSelectedItem().toString().equals("Seleccione el grupo"))
        {
           usoSplit = GrupoCaliR.getSelectedItem().toString().split("¬");
           claveGrupoCombo = usoSplit[1];
           
           mensjRArr = ConsulAlumnos.consultarDatosCali(claveGrupoCombo);
           
           if(!mensjRArr[0].equals("Error en el sistema")||!mensjRArr[0].equals("No se obtuviero datos alumnos del grupo seleccionado"))
           {
               
               mostrarDatosAlumnosCaliR(mensjRArr);
               
           }
           else
               JOptionPane.showMessageDialog(null, mensjRArr[0]);
            
        }
                
        
    }//GEN-LAST:event_GrupoCaliRItemStateChanged

    private void MateriaCaliRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MateriaCaliRItemStateChanged
        // TODO add your handling code here:
        
        
        
        
        if(evt.getStateChange() == ItemEvent.SELECTED && !MateriaCaliR.getSelectedItem().toString().equals("Seleccione la materia"))
        {
            usoSplit = MateriaCaliR.getSelectedItem().toString().split("¬");
            claveMateria = usoSplit[0];
            System.out.println("Clave materia"+" "+claveMateria);                        
        }
                
        
    }//GEN-LAST:event_MateriaCaliRItemStateChanged

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        
        if(!MateriaCaliR.getSelectedItem().toString().equals("Seleccione la materia") && !GrupoCaliR.getSelectedItem().toString().equals("Seleccione el grupo")&&!BimestreCaliR.getSelectedItem().toString().equals("Seleccione el binestre a evaluar")
                &&!DiaCaliR.getSelectedItem().toString().equals("Dia")&&!MesCaliR.getSelectedItem().toString().equals("Mes")&&!AnioCaliR.getSelectedItem().toString().equals("Año"))
        {
            
             mensjRArr = new String[TablaAlumnosCaliR.getRowCount()];

                System.err.println("Tamaño de la tabla"+" "+TablaAlumnosCaliR.getRowCount());
                for(int i=0; i<TablaAlumnosCaliR.getRowCount(); i++)
                {

                    mensjRArr[i] = BimestreCaliR.getSelectedItem().toString().concat("¬").concat(AnioCaliR.getSelectedItem().toString().concat("-").concat(MesCaliR.getSelectedItem().toString().concat("-").concat(DiaCaliR.getSelectedItem().toString())))
                            .concat("¬").concat(claveGrupoCombo).concat("¬").concat(claveMateria).concat("¬").concat(TablaAlumnosCaliR.getValueAt(i, 0).toString()).concat("¬")
                            .concat(TablaAlumnosCaliR.getValueAt(i, 3).toString());
                            
                          
                    System.out.println(i+" : "+mensjRArr[i]);
                }

                mensjRArr = consultasCalificaciones.RegistrarCalificaciones(mensjRArr);

                JOptionPane.showMessageDialog(null, "Detalles de calificaciones:\n");

                mensj="";
                for(int i =0; i < mensjRArr.length; i++)
                {

                    //            JOptionPane.showMessageDialog(null, mensjRArr[i]);
                    mensj = mensj.concat("\n").concat(mensjRArr[i]).concat("\n");

                }

                JOptionPane.showMessageDialog(null, mensj);


            
        }
        
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        
        if(!MatriculaCaliCon.getText().equals(""))
        {
            
            mensjRArr = consultasCalificaciones.consultarDatosCali(MatriculaCaliCon.getText());
            
            if(!mensjRArr[0].equals("Error en el sistema") || mensjRArr[0].equals("No se obtuviero datos alumnos seleccionado"))
            {
                
                mostrarDatosCalificacionesCon(mensjRArr);
                
            }
            else
                JOptionPane.showMessageDialog(null, mensjRArr[0]);
            
        }
        
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        
        
        if(!MatriculaCaliMo.getText().equals(""))
        {
            
            mensjRArr = consultasCalificaciones.consultarDatosCali2(MatriculaCaliMo.getText());
            
            if(!mensjRArr[0].equals("Error en el sistema") || !mensjRArr[0].equals("No se obtuviero datos alumnos seleccionado"))
            {
                
                mostrarDatosCalificacionesMon(mensjRArr);
                
            }
            else
                JOptionPane.showMessageDialog(null, mensjRArr[0]);
            
        }
        
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
//        String 
         mensjRArr = new String[TablaCalicacionesMo.getRowCount()];

        System.err.println("Tamaño de la tabla"+" "+TablaCalicacionesMo.getRowCount());
        for(int i=0; i<TablaCalicacionesMo.getRowCount(); i++)
        {

            mensjRArr[i] = TablaCalicacionesMo.getValueAt(i, 2).toString().concat("¬").concat(MatriculaCaliMo.getText()).concat("¬").concat(TablaCalicacionesMo.getValueAt(i, 0).toString()).concat("¬").concat(TablaCalicacionesMo.getValueAt(i, 1).toString());
            
            System.out.println(i+" : "+mensjRArr[i]);
        }

        mensjRArr = consultasCalificaciones.MoificarCalificaciones(mensjRArr);

        JOptionPane.showMessageDialog(null, "Detalles de modificación en las calificaciones:"+" "+MatriculaCaliMo.getText()+"\n");

        mensj="";
        for(int i =0; i < mensjRArr.length; i++)
        {

            //            JOptionPane.showMessageDialog(null, mensjRArr[i]);
            mensj = mensj.concat("\n").concat(mensjRArr[i]).concat("\n");

        }

        JOptionPane.showMessageDialog(null, mensj);
        
        
    }//GEN-LAST:event_jButton50ActionPerformed

    private void EliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarPagoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ConsultarCalificaciones.setVisible(false);
        ModificarCalificaciones.setVisible(false);
        RegistrarCalificaciones.setVisible(false);
        EliminarCalificaciones.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        if(matEliminarCalif.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la matricula del alumno");
        }
        else{
            mensj=matEliminarCalif.getText();
            String recibir[]=consultasCalificaciones.consultarDatosCali(mensj);
            mostrarCalifEliminar(recibir);
        }
    }//GEN-LAST:event_jButton51ActionPerformed

    private void EliminarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCalificacionActionPerformed
        // TODO add your handling code here:
        
         int fila = TablaEliminarCalificaciones.getSelectedRow();
        System.out.println("numero de fila"+fila);
        if(fila>=0)
        {

            mensj = JOptionPane.showInputDialog("Seguro que desea la califiación de la materia:"+TablaEliminarCalificaciones.getValueAt(fila, 1).toString());

            if(mensj.equals("si")||mensj.equals("Si")||mensj.equals("sI")||mensj.equals("SI")||mensj.equals("s"))
            {

                mensj = TablaEliminarCalificaciones.getValueAt(fila, 0).toString();

                String menRecibido=consultasCalificaciones.eliminarCalificacion(mensj);
            

                if(menRecibido.equals("Datos elimnados correctamente"))
                {
                     DefaultTableModel m = (DefaultTableModel) TablaEliminarCalificaciones.getModel();
                     m.removeRow(fila);
                    
                }
                
                JOptionPane.showMessageDialog(null, menRecibido);
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null,"No selecciono una fila de la tabla");
        }
        
    }//GEN-LAST:event_EliminarCalificacionActionPerformed

    private void TelLocalRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelLocalRKeyTyped
        // TODO add your handling code here:
        
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max8(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
 
    }//GEN-LAST:event_TelLocalRKeyTyped

    private void CelRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CelRKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max10(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
        
    }//GEN-LAST:event_CelRKeyTyped

    private void CPostalRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPostalRKeyTyped
        
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max5(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
    }//GEN-LAST:event_CPostalRKeyTyped

    private void TelLocMoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelLocMoKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max10(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
    }//GEN-LAST:event_TelLocMoKeyTyped

    private void CelMoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CelMoKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max8(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
    }//GEN-LAST:event_CelMoKeyTyped

    private void CPostalMoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPostalMoKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max5(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
    }//GEN-LAST:event_CPostalMoKeyTyped

    private void TelUsuRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelUsuRKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max10(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
        
    }//GEN-LAST:event_TelUsuRKeyTyped

    private void TelefonoUsuMoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoUsuMoKeyTyped
        System.err.print(evt.getKeyChar());
        
        if(comprobar.verificarNumerico(evt.getKeyChar()))
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if(comprobar.max10(TelLocalR.getText()))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Maximo numero de caracteres permitidos");
        }
        
    }//GEN-LAST:event_TelefonoUsuMoKeyTyped

    /** 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AP_matMo;
    private javax.swing.JDialog AdministracionGrupos;
    private javax.swing.JDialog AdministracionPagos;
    private javax.swing.JDialog AdministrarUsuarios;
    private javax.swing.JDialog AdministrarUsuariosOPC;
    private javax.swing.JPanel AgregarAlumnos;
    private javax.swing.JPopupMenu AgregarAlumnosGrupo;
    private javax.swing.JPopupMenu AgregarCriterio;
    private javax.swing.JTextField AlumnoPagoMo;
    private javax.swing.JComboBox AlumnoPagoR;
    private javax.swing.JTextField AlumnosPagosEli;
    private javax.swing.JComboBox AnioCaliR;
    private javax.swing.JComboBox AnioPagoR;
    private javax.swing.JTextField Ap_matCon;
    private javax.swing.JTextField Ap_matEli;
    private javax.swing.JTextField Ap_patCon;
    private javax.swing.JTextField Ap_patEli;
    private javax.swing.JTextField Ap_patMo;
    private javax.swing.JTextField ApellidosUsuCon;
    private javax.swing.JTextField ApellidosUsuMo;
    private javax.swing.JTextField ApellidosUsuR;
    private javax.swing.JComboBox BimestreCaliR;
    private javax.swing.JButton BotonAceptarEli;
    private javax.swing.JButton ButonUsuELi;
    private javax.swing.JTextField CPostaCon;
    private javax.swing.JTextField CPostalMo;
    private javax.swing.JTextField CPostalR;
    private javax.swing.JTextField CalleCon;
    private javax.swing.JTextField CalleMo;
    private javax.swing.JTextField CalleR;
    private javax.swing.JTextField CelCon;
    private javax.swing.JTextField CelMo;
    private javax.swing.JTextField CelR;
    private javax.swing.JTextField ClaveCRConsultar;
    private javax.swing.JTextField ClaveCrRegistro;
    private javax.swing.JTextField ClaveEmMo;
    private javax.swing.JTextField ClaveEmpleadoR;
    private javax.swing.JTextField ClaveGConsulta;
    private javax.swing.JTextField ClaveModificarCri;
    private javax.swing.JTextField ClaveUsuCon;
    private javax.swing.JTextField ClaveUsuEli;
    private javax.swing.JPanel Consultar;
    private javax.swing.JPanel ConsultarAlumno1;
    private javax.swing.JPanel ConsultarCalificaciones;
    private javax.swing.JPanel ConsultarCriterios;
    private javax.swing.JPanel ConsultarGrupos;
    private javax.swing.JPanel ConsultarMaterias;
    private javax.swing.JPanel ConsultarPagos;
    private javax.swing.JPasswordField ContraUsuR;
    private javax.swing.JDialog ContralarMaterias;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JPasswordField ContraseñaUsuMo;
    private javax.swing.JDialog Controldecalificaciones;
    private javax.swing.JTextArea DescripMatEliminar;
    private javax.swing.JTextField DescripMatRegistrar;
    private javax.swing.JComboBox DiaCaliR;
    private javax.swing.JComboBox DiaPagoR;
    private javax.swing.JTextField DireccionUsuMo;
    private javax.swing.JTextField DireccionUsuR;
    private javax.swing.JPanel Eliminar;
    private javax.swing.JPanel EliminarAlumno1;
    private javax.swing.JMenuItem EliminarCalificacion;
    private javax.swing.JPanel EliminarCalificaciones;
    private javax.swing.JPanel EliminarCriterios;
    private javax.swing.JPanel EliminarGrupos;
    private javax.swing.JPanel EliminarMaterias;
    private javax.swing.JMenuItem EliminarPago;
    private javax.swing.JMenuItem EliminarPago1;
    private javax.swing.JMenuItem EliminarPagoItem;
    private javax.swing.JPanel EliminarPagos;
    private javax.swing.JPopupMenu Eliminarpagos;
    private javax.swing.JPopupMenu Eliminarpagos1;
    private javax.swing.JDialog GestionCriterios;
    private javax.swing.JDialog GestionDeInscripcionesAlumno;
    private javax.swing.JComboBox GradoGru;
    private javax.swing.JComboBox GrupoCaliR;
    private javax.swing.JLabel LabelNDUsuELi;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel LableNomUsuEli;
    private javax.swing.JDialog LogeoUsuario;
    private javax.swing.JComboBox MateriaCaliR;
    private javax.swing.JTextField MatriculaCaliCon;
    private javax.swing.JTextField MatriculaCaliMo;
    private javax.swing.JTextField MatriculaCon;
    private javax.swing.JTextField MatriculaEli;
    private javax.swing.JTextField MatriculaMo;
    private javax.swing.JTextField MatriculaPagoCon;
    private javax.swing.JTextField MatriculaPagoMo;
    private javax.swing.JTextField MatriculaPagosEli;
    private javax.swing.JTextField MatriculaR;
    private javax.swing.JLabel MensajePreventivoEli;
    private javax.swing.JLabel MensajeUsuEli;
    private javax.swing.JPopupMenu MenuCalificaciones;
    private javax.swing.JPopupMenu MenuPagoEli;
    private javax.swing.JDialog MenuPrincipalDirectora;
    private javax.swing.JDialog MenuPrincipalProfesor;
    private javax.swing.JComboBox MesCaliR;
    private javax.swing.JComboBox MesPagoR;
    private javax.swing.JPanel Modificar;
    private javax.swing.JPanel ModificarAlumno1;
    private javax.swing.JPanel ModificarCalificaciones;
    private javax.swing.JPopupMenu ModificarCriterio;
    private javax.swing.JPanel ModificarCriterios;
    private javax.swing.JPanel ModificarGrupos;
    private javax.swing.JPanel ModificarMaterias;
    private javax.swing.JPanel ModificarOPC;
    private javax.swing.JPanel ModificarPagos;
    private javax.swing.JTextField MontoPagoR;
    private javax.swing.JComboBox MunicipioCon;
    private javax.swing.JComboBox MunicipioMo;
    private javax.swing.JComboBox MunicipioR;
    private javax.swing.JTextField NombMatEliminar;
    private javax.swing.JTextField NombreComUsuEli;
    private javax.swing.JTextField NombreCon;
    private javax.swing.JTextField NombreCrRegistrar;
    private javax.swing.JTextField NombreDUsuCon;
    private javax.swing.JTextField NombreDUsuEli;
    private javax.swing.JTextField NombreDUsuMo;
    private javax.swing.JTextField NombreEli;
    private javax.swing.JTextField NombreEmMo;
    private javax.swing.JTextField NombreEmR;
    private javax.swing.JTextField NombreMo;
    private javax.swing.JTextField NombrePagoCon;
    private javax.swing.JTextField NombrePagoR;
    private javax.swing.JTextField NombreR;
    private javax.swing.JTextField NombreUsuCon;
    private javax.swing.JTextField NombreUsuarioR;
    private javax.swing.JPanel OpcionContraseña;
    private javax.swing.JPanel OpcionUsuContra;
    private javax.swing.JPanel OpcionUsuario;
    private javax.swing.JTextField PeriodoAlumno;
    private javax.swing.JTextField PeriodoConAlum;
    private javax.swing.JTextField PeriodoModAlumno;
    private javax.swing.JPanel Registrar;
    private javax.swing.JPanel RegistrarAlumno1;
    private javax.swing.JPanel RegistrarCalificaciones;
    private javax.swing.JPanel RegistroCriterios;
    private javax.swing.JPanel RegistroGrupos;
    private javax.swing.JPanel RegistroMaterias;
    private javax.swing.JPanel RegistroPagos;
    private javax.swing.JTable TablaAlumnosCaliR;
    private javax.swing.JTable TablaCaliCon;
    private javax.swing.JTable TablaCalicacionesMo;
    private javax.swing.JTable TablaConsCriterios;
    private javax.swing.JTable TablaEliminarCalificaciones;
    private javax.swing.JTable TablaModificarCri;
    private javax.swing.JTable TablaModificarMat;
    private javax.swing.JTable TablaModificarMaterias;
    private javax.swing.JTable TablaPagoCon;
    private javax.swing.JTable TablaPagosEli;
    private javax.swing.JTable TablaPagosModificar;
    private javax.swing.JTextField TeLocCon;
    private javax.swing.JTextField TelLocMo;
    private javax.swing.JTextField TelLocalR;
    private javax.swing.JTextField TelUsuR;
    private javax.swing.JTextField TelefonoUsuMo;
    private javax.swing.JTextField TipoUSuEli;
    private javax.swing.JTextField TipoUsuCon;
    private javax.swing.JComboBox TipoUsuMo;
    private javax.swing.JComboBox TiposUsuR;
    private javax.swing.JTextField TutorCon;
    private javax.swing.JTextField TutorEli;
    private javax.swing.JTextField TutorMo;
    private javax.swing.JTextField TutorR;
    private javax.swing.JTextField Usuario;
    private javax.swing.JPasswordField VContraUsuR;
    private javax.swing.JPasswordField VContraseñaUsuMo;
    private javax.swing.JTextField ap_matR;
    private javax.swing.JTextField ap_patR;
    private javax.swing.JTextField claveAAG;
    private javax.swing.JTextField claveEliminar;
    private javax.swing.JTextField claveEliminarCri;
    private javax.swing.JTextField claveEliminarMat;
    private javax.swing.JTextField claveGrupo;
    private javax.swing.JTextField claveMatConsultar;
    private javax.swing.JTextField claveMatRegistrar;
    private javax.swing.JTextField claveModificar;
    private javax.swing.JTextField claveModificarMat;
    private javax.swing.JTextField descripMatConsultar;
    private javax.swing.JTextField descripMatModificar;
    private javax.swing.JTextField gradoConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar10;
    private javax.swing.JMenuBar jMenuBar11;
    private javax.swing.JMenuBar jMenuBar12;
    private javax.swing.JMenuBar jMenuBar13;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JMenuBar jMenuBar9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JLabel labelagregarCri;
    private javax.swing.JTextField matEliminarCalif;
    private javax.swing.JTextField nomCriEliminar;
    private javax.swing.JTextField nombreMatConsultar;
    private javax.swing.JTextField nombreMatModificar;
    private javax.swing.JTextField nombreMatRegistrar;
    private javax.swing.JTextField periodoConsulta;
    private javax.swing.JComboBox periodoGrup;
    private javax.swing.JTable tablaAgregarMat;
    private javax.swing.JTable tableAAG;
    private javax.swing.JTable tableModificar;
    // End of variables declaration//GEN-END:variables
}
