/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubv1.clases;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author juancarlos
 */
public class Cliente {

  private final int MAX_ALQUILERES = 5;

  private String nombre;
  private Alquiler[] alquileres;
  private int nAlquileresLleva;

  public Cliente(String nombre) {
    this.nombre = nombre;
    nAlquileresLleva = 0;
    alquileres = new Alquiler[MAX_ALQUILERES];
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the alquileres
   */
  public Alquiler[] getAlquileres() {
    return Arrays.copyOf(alquileres, nAlquileresLleva);
  }

  public void openAlquiler(Pelicula peli) {
    if (nAlquileresLleva < MAX_ALQUILERES - 1) {
      alquileres[nAlquileresLleva] = new Alquiler(peli);
      nAlquileresLleva++;
    }
  }

  public void closeAlquiler(String titulo) {
    int indiceAlquiler = findAlquiler(titulo);
    if (indiceAlquiler > -1) {
      alquileres[indiceAlquiler].close();
    }
  }

  private int lastAlquiler() {
    return (nAlquileresLleva - 1);
  }

  private int findAlquiler(String titulo) {
    int indice = -1;
    for (int i = 0; i <= lastAlquiler(); i++) {
      if (alquileres[i].getPelicula().getTitulo().equals(titulo) && alquileres[i].getDias() == 0) {
        indice = i;
        i = lastAlquiler() + 1;
      }
    }
    return indice;
  }
    
  public String toString(){
    
    String nombre = getNombre();
    
    
    // for para el arrray alquiler que no esté a null
    for (Alquiler alquiler : this.alquileres) {
      if(alquiler.getDias()> 0 ){
        
      }
    }
      
     
    //String[] alquileres = getAlquileres();
    String resultado;
    resultado = "Nombre:" +nombre + "Alquileres" ;
    return resultado;
    
    //recorrer el array cliente y para alquiler fializado (getdias = 0); alquiler.getpeliculas alquiler.getprecios alquiler.getdias 
  }
  

} //class
