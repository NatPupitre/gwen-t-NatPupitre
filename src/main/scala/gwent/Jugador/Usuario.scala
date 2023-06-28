package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.{AbstractCarta, CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia, CartaT}

import cl.uchile.dcc.gwent.Carta.Efectos.Efect

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
  
  /** Permite al usuario ver las cartas en su mano para luego decidir cual jugar, a diferencia de computadora
   * que no requiere consultar su mano */
  def ConsultarMano(): Unit = {
    print(this.getMano().mkString("/n"))
  }

  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Usuario2 = o.asInstanceOf[Usuario]
      super.equals(Usuario2)
    } else false
  }

  /** toString: Retorna un print con las características del objeto */
  override def toString: String = s"Usuario(nombre=$nombre, stablero=$stablero, cgemas=$cgemas)"
  
}
