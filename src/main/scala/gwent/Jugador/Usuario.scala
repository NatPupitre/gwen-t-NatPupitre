package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.Carta
import gwent.Carta.CartaClima
import gwent.Carta.CartaUnidad

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * 
 * @param nombre
 * @param stablero
 * @param cgemas
 */
class Usuario (private var nombre: String, private var stablero: String,
               private var cgemas: Int) extends Jugador {

  var mano: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var mazo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  var UCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CartasEnTableroClima: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

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
   * setters para la clase usuario
   */

  def setNombre(aNombre: String): Unit =  {
    nombre = aNombre
  }

  def setStablero(aStablero: String): Unit = {
    stablero = aStablero
  }

  def setCgemas(aCgemas: Int): Unit = {
    cgemas = aCgemas
  }

  def ConsultarMano(): Unit = {
    print(mano.mkString("/n"))
  }

  def ColocarCarta(aCarta: Carta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)

    if (aCarta.getClasificacion() == "Clima") {
      CartasEnTableroClima :+= aCarta
    } else if (aCarta.getClasificacion() == "Unidad") {
      if (aCarta.getUbicacion() == "Cuerpo"){
        UCartasEnTableroCuerpo :+= aCarta
      } else if (aCarta.getUbicacion() == "Distancia") {
        UCartasEnTableroDistancia :+= aCarta
      } else if (aCarta.getUbicacion() == "Asedio") {
        UCartasEnTableroAsedio :+= aCarta
      }
    }
  }

  override def RobarCarta(): Unit = {
    var CartaRobada: Carta = this.mazo.last
    var i: Int = this.mazo.length - 1
    this.mazo.remove(i)
    this.mano :+= CartaRobada
  }

  override def BarajarMazo(): Unit = {
    this.mazo = Random.shuffle(this.mazo)
  }

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[Usuario]
      this.nombre == carta2.nombre &&
        this.stablero == carta2.stablero &&
        this.cgemas == carta2.cgemas &&
        this.mano.sameElements(carta2.mano) &&
        this.mazo.sameElements(carta2.mazo)
    } else false
  }
  
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[Computadora].##
    result = prime * result + nombre.##
    result = prime * result + stablero.##
    result = prime * result + cgemas.##
    result
  }
  
  override def toString: String = s"Usuario(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
  
}
