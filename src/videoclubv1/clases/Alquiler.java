/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubv1.clases;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 *
 * @author juancarlos
 */
public class Alquiler {
    private LocalDateTime diaHoraInicio;
    private Pelicula pelicula; //OJO CON ESTO, SE DEBE CREAR UNA NUEVA PELICULA, POR SI EN EL FUTURO CAMBIA POR EJEMPLO LA CATEGORIA DE LA PELICULA
    private int tiempo; //tiempo que ha durado el alquiler en dias (un solo minuto ya cuenta como un día más)
    
    public Alquiler (Pelicula pelicula)  {
        diaHoraInicio =  LocalDateTime. now();
        this.pelicula = new Pelicula(pelicula.getTitulo(), pelicula.getCategoria());
        tiempo = 0;
    }
    
    //Creo este getter porque lo pide el enunciado pero no se usa para nada
    public LocalDateTime getDiaInicio() {
      return diaHoraInicio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public int getDias() {
        return tiempo;        
    }
    
    public void close() {
        tiempo = difDias(diaHoraInicio, LocalDateTime.now());
    }
    
    private int difDias(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        double duracion = Duration.between(fechaInicial, fechaFinal).getSeconds();
        return (int) (Math.ceil(duracion / 86400.0));   
    }
        
} //class
