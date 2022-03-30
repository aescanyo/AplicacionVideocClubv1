/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubv1.clases;

import java.util.Arrays;

/**
 *
 * @author masquy
 */
public class VideoClub {
  private final int MAX_PELICULAS = 5;
  private final int MAX_CLIENTES = 5;
    
  private Pelicula[] peliculas;
  private int nPeliculasHay;
  
  private Cliente[] clientes;
  private int nClientesHay;
  
  public VideoClub() {
    peliculas = new Pelicula[MAX_PELICULAS];
    nPeliculasHay = 0;
    
    clientes = new Cliente[MAX_CLIENTES];
    nClientesHay = 0;
  }
  
  
  public void addCliente(String nombre) {
    clientes[nClientesHay++] = new Cliente(nombre);
    //nClientesHay++;
  }
  
  public void delCliente(String nombre) {
    int indiceCliente = findCliente(nombre);
    //Cliente[] nuevosClientes = null;
    if (indiceCliente > -1) {
      //nuevosClientes = new Cliente[--nClientesHay];
      //int j = 0;
      for (int c = indiceCliente; c < lastCliente(); c++) {
        clientes[c] = clientes[c+1];
        }
      clientes[nClientesHay--] = null;
      }
  }
    
  public Cliente[] getClientes() {
    return Arrays.copyOf(clientes, nClientesHay);
  }
  
  public Cliente getCliente(String nombre) {
     int indiceCliente = findCliente(nombre);
     Cliente retorno = (indiceCliente < 0 ? null : clientes[indiceCliente]);
     return retorno;
  }
  
  private int findCliente(String nombre) {
	  //devuelve el indice del nombre del cliente
    int indice = -1;
    for (int i = 0; i <= lastCliente(); i++) {
      if (clientes[i].getNombre().equals(nombre)) {
        indice = i;
        i = lastCliente() + 1;
      }
    }
    return indice;
  }
  
  private int lastCliente() {
    return (nClientesHay - 1);
  }
  
  public void addPelicula(String titulo, Categoria categoria) {
	  //añade el valor y luego suma 1, si el ++ estubiera antes lo guardaba en la posicion 1
    peliculas[nPeliculasHay++] = new Pelicula(titulo, categoria);
    //nPeliculasHay++;
  }
  
  public void delPelicula(String titulo) {
    int indicePelicula = findPelicula(titulo);
    //Cliente[] nuevosClientes = null;
    if (indicePelicula > -1) {
      //nuevosClientes = new Cliente[--nClientesHay];
      //int j = 0;
      for (int p = indicePelicula; p< lastPelicula(); p++) {
        peliculas[p] = peliculas[p+1];
        }
      peliculas[nPeliculasHay--] = null;
      }
  }  
  
  public Pelicula[] getPeliculas() {
    return Arrays.copyOf(peliculas, nPeliculasHay);
  }
  
  public Pelicula getPelicula(String titulo) {
    int indicePelicula = findPelicula(titulo);
    Pelicula retorno = (indicePelicula < 0 ? null : peliculas[indicePelicula]);
    return retorno;
  }
  
  private int findPelicula(String titulo) {
    int indice = -1;
    for (int i = 0; i <= lastPelicula(); i++) {
      if (peliculas[i].getTitulo().equals(titulo)) {
        indice = i;
        i = lastPelicula() + 1;
      }
    }
    return indice;
  }
  
  private int lastPelicula() {
	  //devueve el numero de peliculas pero para el array es decir, empieza por 0 el array,
    return (nPeliculasHay -1);
  }
  
} //class
