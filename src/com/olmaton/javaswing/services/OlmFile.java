package com.olmaton.javaswing.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author olmaton
 */
public class OlmFile {
    private final String ruta;

    public OlmFile(String ruta) {
        this.ruta = ruta;
    }
    
    public ArrayList<String> getListaLineas()  {
        ArrayList<String> listaString = new ArrayList<>();
        FileReader f = null;
        try {
            if(!ruta.isEmpty()){
                f = new FileReader(ruta);
                try (BufferedReader b = new BufferedReader(f)) {
                    String cadena;
                    while((cadena = b.readLine())!=null) {                        
                        listaString.add(cadena.trim());
                    }
                }
            }            
        } catch (FileNotFoundException ex) {
            OlmLog.getInstance().error(ex.getMessage(),this.getClass().getName()+", getListaLineas: ");
        } catch (IOException ex) {
            OlmLog.getInstance().error(ex.getMessage(),this.getClass().getName()+", getListaLineas: ");
        } finally {
            try {
                if(f!=null)f.close();
            } catch (IOException ex) {
                OlmLog.getInstance().error(ex.getMessage(),this.getClass().getName()+", getListaLineas: ");
            }
        }
        return listaString;
    }
    
    public boolean setLinea(String linea) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(ruta, true);
            try (BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                bfwriter.write(linea+"\n");
                return true;
            }                   
        } catch (IOException ex) {
            OlmLog.getInstance().error(ex.getMessage(),this.getClass().getName()+", setLinea: ");
            return false;
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException ex) {
                   OlmLog.getInstance().error(ex.getMessage(),this.getClass().getName()+", setLinea: ");
                    return false;
                }
            }
        }
    }
}
