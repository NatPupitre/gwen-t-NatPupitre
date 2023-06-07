package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador

trait CartaT {

  def getNombre(): String
  def getClasificacion(): String
  def setNombre(aNombre: String): Unit
  def setClasificacion(aClasificacion: String): Unit
  def ColocarCarta(jugador: Jugador): Unit

  // def ActivarEfecto(): Unit

}
