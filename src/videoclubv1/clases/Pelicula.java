/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubv1.clases;

import java.io.PrintStream;

/**
 *
 * @author masquy
 */
public class Pelicula {
  private String titulo;
  private Categoria categoria;
  
  //No es necesario crear el constructor por defecto
  
  /* Constructor no pedido
  public Pelicula(String titulo) {
    this(titulo, Categoria.ESTRENO);
  }
*/
  
  public Pelicula(String titulo, Categoria categoria) {
    this.titulo = titulo;
    this.categoria = categoria;
  }

  public String getTitulo() {
    return titulo;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
  
  public double getPrecio(int dias) {
    double precio = 0.0;
    switch (categoria) {
      case NORMAL:
        precio = (dias > 2 ? dias * 1.5 : dias * 2.0);
        break;
      case INFANTIL:
        precio = dias * 1.5;
        break;
      case ESTRENO:
        precio = dias * 3;
        break;
    }
    return precio;
  }
  
  public int getPuntos(int dias) {
    int puntos = 0;
    if (dias > 0) {
      puntos = 1;
      if (dias > 1 && categoria == Categoria.ESTRENO) {
        puntos++;
      }
    }
    return puntos;
  }
  
  @Override
  /**
   * Titulo: Superman 1, Categoría: NORMAL
   */
  public String toString(){
    String titulo = getTitulo();
    Categoria categoriaString = getCategoria();
     //String test=System.out.printf("Titulo %1s, Categoria %2s", titulo,categoriaString);
    String resultado = "Título: " + titulo + "Categoria: " + categoriaString;
    return resultado;
  }

} //class

