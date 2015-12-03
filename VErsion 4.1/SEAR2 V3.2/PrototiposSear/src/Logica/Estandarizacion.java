/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alexX
 */
public class Estandarizacion {
    
    int i=0;
    Matcher mat;
    Pattern pat;
    
    public boolean verificarNumerico(char caracter)
    {
      
        if(caracter<'0' || caracter>'9')
            return true;
        else
            return false;
            
    }
    
    public boolean verificarDatos(char caracter)
    {
      
        if(caracter<'0' || caracter>'9')
            return true;
        else
            return false;
            
    }
    
    public boolean max8(String cadena)
    {
        if(cadena.length()>=8)
            return true;
        else
            return false;
    }
    
    public boolean max10(String cadena)
    {
        if(cadena.length()>=10)
            return true;
        else
            return false;
    }
    
    public boolean max5(String cadena)
    {
        if(cadena.length()>=5)
            return true;
        else
            return false;
    }
}
