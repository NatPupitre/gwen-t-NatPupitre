package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.Carta

import scala.collection.mutable.ArrayBuffer

trait Jugador {

  def ColocarCarta(aCarta: Carta): Unit
  def RobarCarta(): Unit
  def BarajarMazo(): Unit


}
