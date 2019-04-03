/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela el lector y la lectura de un archivo 
 * @version 1.0
 * @author JHONATHAN
 */
public class LectorArchivo {

    private File archivo;

    /**
     * Constructor por defecto de la clase archivo, el cual por 
     * parametro recibe una archivo de tipo file, el cual 
     * posteriormente va a leer
     * @param archivo 
     */
    public LectorArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * Metodo que al recibir un archivo lo lee linea por linea hasta obtener una
     * lista de todas las lineas del archivo y retornarlas
     * @param archivo archivo de tipo File, el cual se leera
     * @return una lista de las lineas que contiene el archivo
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<String> leer() throws FileNotFoundException, IOException {
        String cadena;
        List<String> cadenas = new ArrayList<String>();
        FileReader fr = new FileReader(this.archivo);
        BufferedReader b = new BufferedReader(fr);
        while ((cadena = b.readLine()) != null) {
            cadenas.add(cadena);
        }
        b.close();
        return cadenas;
    }

}
