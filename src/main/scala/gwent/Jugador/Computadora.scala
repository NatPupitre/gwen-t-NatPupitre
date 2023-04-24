package cl.uchile.dcc.gwent.Jugador

import cl.uchile.dcc.gwent.Carta.Carta
import cl.uchile.dcc.gwent.Carta.CartaUnidad
import cl.uchile.dcc.gwent.Carta.CartaClima

import scala.annotation.meta.param
import scala.collection.mutable.ArrayBuffer
import scala.util.Random;

/**
 *
 * @param nombre
 * @param stablero
 * @param cgemas
 */
class Computadora(private var nombre: String, private var stablero: String,
                  private var cgemas: Int) extends Jugador {

  var mano: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var mazo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  var CCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
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




  def ColocarCarta(aCarta: Carta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)
    if (aCarta.getClasificacion() == "Clima") {
      CartasEnTableroClima :+= aCarta
    } else if (aCarta.getClasificacion() == "Unidad") {
      if (aCarta.getUbicacion() == "Cuerpo") {
        CCartasEnTableroCuerpo :+= aCarta
      } else if (aCarta.getUbicacion() == "Distancia") {
        CCartasEnTableroDistancia :+= aCarta
      } else if (aCarta.getUbicacion() == "Asedio") {
        CCartasEnTableroAsedio :+= aCarta
      }
    }
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

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[Computadora]
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

  override def toString: String = s"Computadora(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
}
