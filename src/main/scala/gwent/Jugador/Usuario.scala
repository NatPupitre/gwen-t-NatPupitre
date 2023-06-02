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
class Usuario (nombre: String, stablero: String, cgemas: Int)
  extends AbstractJugador (nombre, stablero, cgemas) {

  
  def ConsultarMano(): Unit = {
    print(this.getMano().mkString("/n"))
  }

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Usuario2 = o.asInstanceOf[Usuario]
      super.equals(Usuario2)
    } else false
  }
  
  override def toString: String = s"Usuario(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
  
}
