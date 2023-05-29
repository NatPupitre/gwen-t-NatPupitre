package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta

import cl.uchile.dcc.gwent.Carta.{AbstractCarta, Carta}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

abstract class AbstractJugador (private var nombre: String, private var stablero: String,
                       private var cgemas: Int) {

  var mano: ArrayBuffer[AbstractCarta] = new ArrayBuffer[AbstractCarta](100)
  var mazo: ArrayBuffer[AbstractCarta] = new ArrayBuffer[AbstractCarta](100)
  
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




  

  def RobarCarta(): Unit = {
    var CartaRobada: AbstractCarta = this.mazo.last
    var i: Int = this.mazo.length-1
    this.mazo.remove(i)
    this.mano :+= CartaRobada
  }

  def BarajarMazo(): Unit = {
    this.mazo = Random.shuffle(mazo)
  }

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Jugador2 = o.asInstanceOf[AbstractJugador]
      this.nombre == Jugador2.nombre &&
        this.stablero == Jugador2.stablero &&
        this.cgemas == Jugador2.cgemas &&
        this.mano.sameElements(Jugador2.mano) &&
        this.mazo.sameElements(Jugador2.mazo)
    } else false
  }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + this.getClass().getName.##
    result = prime * result + nombre.##
    result = prime * result + stablero.##
    result = prime * result + cgemas.##
    result
  }
}
