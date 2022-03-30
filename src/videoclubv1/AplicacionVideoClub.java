/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubv1;


import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import videoclubv1.clases.Alquiler;
import videoclubv1.clases.Categoria;
import videoclubv1.clases.Pelicula;
import videoclubv1.clases.Cliente;
import videoclubv1.clases.VideoClub;

/**
 *
 * @author masquy
 */
public class AplicacionVideoClub {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Pelicula[] pelisIniciales = {
      new Pelicula("Superman 1", Categoria.NORMAL), 
      new Pelicula("Superman 2", Categoria.NORMAL),
      new Pelicula("Superman 14", Categoria.ESTRENO),
      new Pelicula("Cars 6", Categoria.INFANTIL)
    };
    
    Cliente[] clientesIniciales = {
      new Cliente("Alberto Fernández"),
      new Cliente("Lucio Pérez"),
      new Cliente("María González")
    };
    
    VideoClub miVideoClub = new VideoClub();
    for (int i = 0; i < pelisIniciales.length; i++) {
      miVideoClub.addPelicula(pelisIniciales[i].getTitulo(), pelisIniciales[i].getCategoria());
      
    }
    
    for (int i = 0; i < clientesIniciales.length; i++) {
      miVideoClub.addCliente(clientesIniciales[i].getNombre());
    }
    
    System.out.println ("***** Situación inicial:\n");
    mostrarArrayGenerico(clientesIniciales);
    mostrarArrayGenerico(pelisIniciales);
    
    System.out.println("***** Borro al Cliente: " + "Alberto Fernández");
    miVideoClub.delCliente("Alberto Fernández");
    mostrarArrayGenerico(miVideoClub.getClientes());
    
    System.out.println("***** Borro la pelicula: " + "Superman 2");
    miVideoClub.delPelicula("Superman 2");
    mostrarArrayGenerico(miVideoClub.getPeliculas());
    
    System.out.println ("***** Alquilo Superman 14 a Lucio Pérez");
    miVideoClub.getCliente("Lucio Pérez").openAlquiler(miVideoClub.getPelicula("Superman 14"));
    mostrarArrayGenerico(miVideoClub.getClientes());
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException ex) {
      Logger.getLogger(AplicacionVideoClub.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println ("***** Espero dos segundos y Lucio Pérez devuelve Superman 14");
    miVideoClub.getCliente("Lucio Pérez").closeAlquiler("Superman 14");
    mostrarArrayGenerico(miVideoClub.getClientes());
    
    System.out.println("***** Cambio Superman 14 a categoria NORMAL");
    miVideoClub.getPelicula("Superman 14").setCategoria(Categoria.NORMAL);
    mostrarArrayGenerico(miVideoClub.getClientes());
    mostrarArrayGenerico(miVideoClub.getPeliculas());
    
    System.out.println ("***** Vuelvo a alquilar Superman 14 a Lucio Pérez");
    miVideoClub.getCliente("Lucio Pérez").openAlquiler(miVideoClub.getPelicula("Superman 14"));
    mostrarArrayGenerico(miVideoClub.getClientes());
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException ex) {
      Logger.getLogger(AplicacionVideoClub.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println ("***** Espero dos segundos y Lucio Pérez devuelve Superman 14");
    miVideoClub.getCliente("Lucio Pérez").closeAlquiler("Superman 14");
    mostrarArrayGenerico(miVideoClub.getClientes());
    
    System.out.println("***** Borro la pelicula: " + "Superman 14");
    miVideoClub.delPelicula("Superman 14");
    mostrarArrayGenerico(miVideoClub.getClientes());
    mostrarArrayGenerico(miVideoClub.getPeliculas());
    
    System.out.println("***** Borro al Cliente: " + "Lucio Pérez");
    miVideoClub.delCliente("Lucio Pérez");
    mostrarArrayGenerico(miVideoClub.getClientes());
    
    System.out.println("***** Creo un alquiler para la película Cars 6");
    Pelicula miPelicula = miVideoClub.getPelicula("Cars 6");
    Alquiler miAlquiler = new Alquiler(miPelicula);
    System.out.println ("miAlquiler de Cars 6 --> " + miAlquiler.toString());
    
    System.out.println ("***** Cambio el tipo de Cars 6 a NORMAL a ver que pasa con el alquiler");
    miPelicula.setCategoria(Categoria.NORMAL);
    System.out.println ("miPelicula.toString() = " + miPelicula.toString());
    System.out.println ("miAlquiler de Cars 6 --> " + miAlquiler.toString());
    
  } //main

  private static void mostrarArrayGenerico(Object[] array) {
    for (Object obj : array) {
      String mensaje;
      //if (obj != null) {
        mensaje = obj.toString();
        System.out.println(mensaje);
      //}
    }
  }
  
  
  
} //class

//ejercicio 4
//conjuntos para listas ordenadas usa internamente compare

//hacer  tostring , hash, iguals, compare (para añadir) 