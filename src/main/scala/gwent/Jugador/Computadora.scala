package cl.uchile.dcc
package gwent.Jugador

import cl.uchile.dcc.gwent.Carta.Carta

import scala.annotation.meta.param
import scala.collection.mutable.ArrayBuffer
import scala.util.Random;

/**
 * 
 * @param nombre
 * @param stablero
 * @param cgemas
 */
class Computadora (nombre: String, stablero: String, cgemas: Int) 
  extends AbstractJugador (nombre, stablero, cgemas) {

  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  var CCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var CCartasEnTableroClima: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  
  def ColocarCarta(aCarta: Carta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)
    if (aCarta.getClasificacion() == "Clima") {
      CCartasEnTableroClima :+= aCarta
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
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Compu = o.asInstanceOf[Computadora]
      this.nombre == Compu.getNombre() &&
      this.stablero == Compu.getStablero() &&
      this.cgemas == Compu.getCgemas() &&
      this.mano.sameElements(Compu.mano) &&
      this.mazo.sameElements(Compu.mazo)
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
