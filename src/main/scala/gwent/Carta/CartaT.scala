package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Carta.Efectos
import cl.uchile.dcc.gwent.Carta.Efectos.Efect

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

trait CartaT {

  def getFuerza(): Int
  def getNombre(): String
  def getClasificacion(): String
  def getEfecto(): Efect

  def setFuerza(aFuerza: Int): Unit
  def setNombre(aNombre: String): Unit
  def setClasificacion(aClasificacion: String): Unit
  def setEfecto(aEfecto: Efect): Unit
  def ColocarCarta(jugador: Jugador): Unit

  def NotificarObservadores(aJugador: Jugador): Unit
  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT]
  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit

}
