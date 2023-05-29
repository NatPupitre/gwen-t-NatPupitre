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
class Usuario (nombre: String, stablero: String, cgemas: Int)
  extends AbstractJugador (nombre, stablero, cgemas) {



  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  var UCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroClima: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  def ColocarCarta(aCarta: AbstractCarta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)
    if (aCarta.isInstanceOf[CartaClima]) {
      UCartasEnTableroClima :+= aCarta
    } else if (aCarta.isInstanceOf[CartaCuerpo]) {
      UCartasEnTableroCuerpo :+= aCarta
    } else if (aCarta.isInstanceOf[CartaDistancia]) {
      UCartasEnTableroDistancia :+= aCarta
    } else if (aCarta.isInstanceOf[CartaAsedio]) {
      UCartasEnTableroAsedio :+= aCarta
    }
  }
  
  def ConsultarMano(): Unit = {
    print(mano.mkString("/n"))
  }

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Usuario2 = o.asInstanceOf[Usuario]
      super.equals(Usuario2)
    } else false
  }
  
  override def toString: String = s"Usuario(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
  
}
