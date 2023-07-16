package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.{CartaClima, CartaT}
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego
import cl.uchile.dcc.gwent.Efectos.Efect

import scala.collection.mutable.ArrayBuffer

abstract class AbstractEfectClima extends Efect{

  def ColocarCarta(aCarta: CartaT, tab: TableroJuego): Unit = {
    //revisa si hay cartas de clima en el tablero
    var cartaEnTablero = tab.getCartasEnTableroClima()
    var cartaNueva: ArrayBuffer[CartaT] = ArrayBuffer(aCarta)

    /** Si no hay cartas, sólo la ponemos en el tablero y dejamos que este considere el
    efecto de esta carta como activo */
    if (cartaEnTablero.isEmpty) {
      tab.setEfectoActivo(this)
      tab.setCartasEnTableroClima(cartaNueva)
    }

      /** Si ya hay una carta de clima en el tablero, la eliminamos reemplazandola por la carta actual
       * y revertimos su efecto para luego dejar el efecto de esta carta como activo */
    else {
      //Revertimos el efecto de la carta en el tablero
      cartaEnTablero(0).getEfecto().RevertirEfecto(tab)

      //se quita la anterior al cambiarla por la nueva carta
      tab.setEfectoActivo(this)
      tab.setCartasEnTableroClima(cartaNueva)
    }
  }

  /**Aplicar el efecto de esta forma implica que el efecto lo está aplicando una carta de Unidad
   * Lo cual no es correcto y por ende lanzamos una excepción
   * @param jugador
   * @param carta
   * @param tab
   */
  def AplicarEfecto(jugador: Jugador, carta: CartaT, tab: TableroJuego): Unit = {
    try {
      throw new UnsupportedOperationException("Este efecto no es un efecto de Unidad")
    } catch {
      case ex: UnsupportedOperationException =>
        println(ex.getMessage)
    }
  }

  /**Colocar la carta con este efecto de esta forma implica que el efecto lo está aplicando una carta de Unidad
   * Lo cual no es correcto y por ende lanzamos una excepción
   *
   * @param jugador
   * @param aCarta
   * @param tab
   * */
  
  def ColocarCarta(jugador: Jugador, aCarta: CartaT, tab: TableroJuego): Unit = {
    try {
      throw new UnsupportedOperationException("Esta carta no puede jugar efectos de clima")
    } catch {
      case ex: UnsupportedOperationException => 
        println(ex.getMessage)
    }
  }
  
    //Método abstracto
   def RevertirEfecto(tab: TableroJuego): Unit
}
