package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Tablero.TableroJuego

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

trait CartaT {

  def copiarCarta(): CartaT
  def getFuerza(): Int
  def getNombre(): String
  def getClasificacion(): String
  def getEfecto(): Efect

  def setFuerza(aFuerza: Int): Unit
  def setNombre(aNombre: String): Unit
  def setClasificacion(aClasificacion: String): Unit
  def setEfecto(aEfecto: Efect): Unit
  def ColocarCarta(jugador: Jugador, tab: TableroJuego): Unit

  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT]
  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit

}
