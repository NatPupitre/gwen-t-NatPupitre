package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.CartaT
import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Tablero.TableroJuego

/** 
 * Efecto cuyo unico propósito es testear los otros aspectos del juego sin considerar los efectos de clima 
 * */
class ParaTestSInEfectos extends AbstractEfectClima {

  /** Print del efecto */
  def AplicarEfecto(tab: TableroJuego): Unit = {
    println("No hay efecto activo")
  }
  
  /** Print al revertir el efecto */
  def RevertirEfecto(tab: TableroJuego): Unit = {
    println("No hay efecto activo")
  }

}
