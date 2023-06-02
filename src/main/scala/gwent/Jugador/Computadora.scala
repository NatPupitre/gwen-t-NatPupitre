package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.{AbstractCarta, CartaT, CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia}

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
  
  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Compu = o.asInstanceOf[Computadora]
      super.equals(Compu)
    } else false
  }

  /** toString: Retorna un print con las características del objeto */
  override def toString: String = s"Computadora(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
}
