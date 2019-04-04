/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de controlar y procesar el archivo con los datos
 * de las materias inscritas
 * @author Julian Salgado
 * @version 1.0
 */
public class ProcesarDatosInscripciones {

    List<Estudiante> estudiantes;

    public ProcesarDatosInscripciones() {
        this.estudiantes = new ArrayList<>();
    }

    /**
     * se encarga de leer el archivo y consolidar los datos de cada estudiante
     * @param archivo planos con las incribciones de las materias de los
     * estudiantes 
     * @return la lista del consolidado de materias de cada estudiante
     * @throws java.io.IOException
     */
    public List<String> consolidarDatosInscripciones(File archivo) throws IOException {
        LectorArchivo file = new LectorArchivo(archivo);
        List<String> datos =file.leer();
        List<String> consolidado = new ArrayList<>();
        if(datos ==null){
            throw new IOException("Archivo no valido");
        }
        procesarDatosArchivo(datos);
        for (Estudiante estudiante:estudiantes){
            consolidado.add(estudiante.toString());
        }
        return consolidado;
    }

    /**
     * se encarga de recorrer la lista datos inscritos para mandarle linea 
     * por linea al procesarLineaInscripcion
     * @param datosInscritos un lista de los datos inscritos que se obtienen
     * del archivo
     */
    private void procesarDatosArchivo(List<String> datosInscritos) {
        for (String linea : datosInscritos) {
            procesarLineaInscripcion(linea);
        }
    }

    /**
     * se encarga de tomar la linea de inscripcion y dividirla entre cedula,
     * nombre, codigo, materia para buscar el estudainte y crear uno nuevo
     * si es que el estudiante no existe y adicionar la materia inscrita.
     * @param lineaInscripcion linea en donde esta el estudainte con su materia
     * inscrita
     */
    private void procesarLineaInscripcion(String lineaInscripcion) {
        String[] datos = lineaInscripcion.split(",");
        Estudiante nuevoEstudiante = null;
        if ((buscarEstudiante(datos[0])) == null) {
            nuevoEstudiante = new Estudiante(datos[0], datos[1]);
        }
        nuevoEstudiante.adicionarMateria(datos[2], datos[3]);
    }

    /**
     * se encarga de buscar un estudiante por medio de su cedula en la lista de
     * estudaintes
     *
     * @param cedula del estudiante que desea buscar
     * @return el un estudiante si este fue encontrado de lo contrario retorna
     * null
     */
    private Estudiante buscarEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

}
