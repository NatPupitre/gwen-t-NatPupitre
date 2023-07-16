package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego

/**
 * Clima despejado: Elimina todos los efectos climáticos actualmente en efecto en el campo de batalla.
 */
class ClimaDespejado extends AbstractEfectClima {

  //El efecto no hace nada ya que al colocar la carta ya se revierten los efectos
  def AplicarEfecto(tab: TableroJuego): Unit = {
    println("El clima está despejado")
  }

  //Como la carta no hace nada, no hay nada que revertir
  def RevertirEfecto(tab: TableroJuego): Unit = {
    println("No hay efecto por revertir")
  }

}
