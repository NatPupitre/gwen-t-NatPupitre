package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.{AbstractCarta, Carta, CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia}

import scala.annotation.meta.param
import scala.collection.mutable.ArrayBuffer
import scala.util.Random;

/**
 * 
 * @param nombre
 * @param stablero
 * @param cgemas
 */
class Computadora (nombre: String, stablero: String, cgemas: Int) extends AbstractJugador (nombre, stablero, cgemas) {


  
  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  var CCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroClima: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  
  def ColocarCarta(aCarta: AbstractCarta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)
    if (aCarta.isInstanceOf[CartaClima]) {
      CCartasEnTableroClima :+= aCarta
    }else if (aCarta.isInstanceOf[CartaCuerpo]) {
        CCartasEnTableroCuerpo :+= aCarta
    } else if (aCarta.isInstanceOf[CartaDistancia]) {
        CCartasEnTableroDistancia :+= aCarta
    } else if (aCarta.isInstanceOf[CartaAsedio]) {
        CCartasEnTableroAsedio :+= aCarta
    }
  }
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Compu = o.asInstanceOf[Computadora]
      super.equals(Compu)
    } else false
  }

  override def toString: String = s"Computadora(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
}
