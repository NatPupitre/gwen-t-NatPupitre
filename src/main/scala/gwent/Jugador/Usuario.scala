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
class Usuario (nombre: String, stablero: String, cgemas: Int)
  extends AbstractJugador (nombre, stablero, cgemas) {

  var UCartasEnTableroCuerpo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroDistancia: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroAsedio: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var UCartasEnTableroClima: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  def ColocarCarta(aCarta: Carta): Unit = {
    var i: Int = mano.indexOf(aCarta)
    this.mano.remove(i)
    if (aCarta.getClasificacion() == "Clima") {
      UCartasEnTableroClima :+= aCarta
    } else if (aCarta.getClasificacion() == "Unidad") {
      if (aCarta.getUbicacion() == "Cuerpo") {
        UCartasEnTableroCuerpo :+= aCarta
      } else if (aCarta.getUbicacion() == "Distancia") {
        UCartasEnTableroDistancia :+= aCarta
      } else if (aCarta.getUbicacion() == "Asedio") {
        UCartasEnTableroAsedio :+= aCarta
      }
    }
  }
  
  def ConsultarMano(): Unit = {
    print(mano.mkString("/n"))
  }
  
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[Usuario]
      this.nombre == carta2.getNombre() &&
        this.stablero == carta2.getStablero() &&
        this.cgemas == carta2.getCgemas() &&
        this.mano.sameElements(carta2.mano) &&
        this.mazo.sameElements(carta2.mazo)
    } else false
  }
  
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[Usuario].##
    result = prime * result + nombre.##
    result = prime * result + stablero.##
    result = prime * result + cgemas.##
    result
  }
  
  override def toString: String = s"Usuario(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
  
}
