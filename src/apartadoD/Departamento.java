/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoD;

/**
 *
 * @author Morad
 */
public class Departamento {
    int numDep;
    String nombre, Localidad;

    public Departamento(int numDep, String nombre, String Localidad) {
        this.numDep = numDep;
        this.nombre = nombre;
        this.Localidad = Localidad;
    }

    @Override
    public String toString() {
        return "Departamento{" + "numDep=" + numDep + ", nombre=" + nombre + ", Localidad=" + Localidad + '}';
    }

    public int getNumDep() {
        return numDep;
    }

    public void setNumDep(int numDep) {
        this.numDep = numDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }
    
            
}
