package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.Carta

import scala.collection.mutable.ArrayBuffer

trait Jugador {

  def getNombre(): String
  def getStablero(): String
  def getCgemas(): Int
  def setNombre(aNombre: String): Unit
  def setStablero(aStablero: String): Unit
  def setCgemas(aCgemas: Int): Unit
  def ColocarCarta(aCarta: Carta): Unit
  def RobarCarta(): Unit
  def BarajarMazo(): Unit


}
