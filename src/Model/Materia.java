/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase que modela una Materia la cual cuenta un codigo y nombre
 *
 * @version 1.0
 * @author JHONATHAN
 */
public class Materia {

    private String codigo;
    private String nombre;

    /**
     * @param codigo codigo de la materia
     * @param nombre nombre de la materia
     */
    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo(){
        return this.codigo;
    }
}
