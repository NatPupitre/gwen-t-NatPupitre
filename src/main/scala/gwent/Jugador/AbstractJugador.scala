package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.Carta

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

abstract class AbstractJugador (private var nombre: String, private var stablero: String,
                       private var cgemas: Int) extends Jugador {

  var mano: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var mazo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  def ColocarCarta(aCarta: Carta): Unit
  
  def getNombre(): String = {
    return nombre
  }

  def getStablero(): String = {
    return stablero
  }

  def getCgemas(): Int = {
    return cgemas
  }

  /**
   * setters para la clase Computadora
   */

  def setNombre(aNombre: String): Unit = {
    nombre = aNombre
  }

  def setStablero(aStablero: String): Unit = {
    stablero = aStablero
  }

  def setCgemas(aCgemas: Int): Unit = {
    cgemas = aCgemas
  }




  

  override def RobarCarta(): Unit = {
    var CartaRobada: Carta = this.mazo.last
    var i: Int = this.mazo.length-1
    this.mazo.remove(i)
    this.mano :+= CartaRobada
  }

  override def BarajarMazo(): Unit = {
    this.mazo = Random.shuffle(mazo)
  }
}
