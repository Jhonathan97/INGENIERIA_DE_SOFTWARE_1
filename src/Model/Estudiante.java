/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela a un estudiante el cual cuenta con una cedula, un nombre y
 * una lista de materias
 * @version 1.0
 * @author JHONATHAN
 */
public class Estudiante {

    private String cedula;
    private String nombre;
    private List<Materia> materias;

    /**
     * Constructor el cual recibe una cedula y un nombre e inicializa la lista
     * de materias del estudiante
     * @param cedula cedula del estudiante
     * @param nombre nombre del estudiante
     */
    public Estudiante(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        materias = new ArrayList<>();
    }

    /**
     *Metodo que adiciona una materia de acuerdo a sus atributos 
     * busca en la lista de materias del estudiante y si no posee 
     * esta materia la adiciona
     * @param codigo codigo de la materia
     * @param nombre nombre de la materia
     */
    public void adicionarMateria(String codigo, String nombre) {
        Materia materia = buscarMateria(codigo);
        if (materia != null) {

        }
        materias.add(materia);
    }

    /**
     * Metodo que busca una materia dentro de la lista de materias 
     * del estudiante de acuerdo a su codigo, si encuentra una materia
     * la materia dada por el codigo, la retorna y si no retorna null
     * @param codigo
     * @return 
     */
    public Materia buscarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                return materia;
            }
        }
        return null;
    }
}
