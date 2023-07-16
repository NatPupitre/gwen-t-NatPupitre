package cl.uchile.dcc
package gwent.Efectos.EfectosUnidad

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego

import cl.uchile.dcc.gwent.Efectos.Efect

abstract class AbstractEfectUnidad extends Efect{

  /**
   * Las cartas de Unidad aplican su efecto y luego se agregan, ya que a la carta agregada no se le aplica el efecto
   * a excepción del efecto Vinculo Estrecho
   * @param jugador
   * @param aCarta
   * @param tab
   */
  def ColocarCarta(jugador: Jugador, aCarta: CartaT, tab: TableroJuego): Unit = {
    this.AplicarEfecto(jugador, aCarta, tab)
    var cartas = aCarta.CartasEnFila(jugador)
    cartas :+= aCarta
    aCarta.ActualizarCartasEnFila(jugador, cartas)
  }

  /**
   * Aplicar efecto mediante estos inputs implica que el efecto lo está aplicando una carta de Clima
   * Lo cual no es correcto y por ende lanzamos una excepción
   *
   * @param tab
   */
  def AplicarEfecto(tab: TableroJuego): Unit = {
    try {
      throw new UnsupportedOperationException("Este efecto no es un efecto de Clima")
    } catch {
      case ex: UnsupportedOperationException =>
        println(ex.getMessage)
    }
  }

  /**
   * Los efectos de unidad no se revierten y por ende lanzamos una excepción
   *
   * @param tab
   */
  def RevertirEfecto(tab: TableroJuego): Unit = {
    try {
      throw new UnsupportedOperationException("Esta carta no puede revertir sus efectos")
    } catch {
      case ex: UnsupportedOperationException =>
        println(ex.getMessage)
    }
  }

  /**
   * Colocar la carta con este efecto de esta forma implica que el efecto lo está aplicando una carta de Clima
   * Lo cual no es correcto y por ende lanzamos una excepción
   *
   * @param aCarta
   * @param tab
   */
  def ColocarCarta(aCarta: CartaT, tab: TableroJuego): Unit = {
    try {
      throw new UnsupportedOperationException("Esta carta no puede jugar efectos de Clima")
    } catch {
      case ex: UnsupportedOperationException =>
        println(ex.getMessage)
    }
  }

  //Método abstracto
  def AplicarEfecto(jugador: Jugador, carta: CartaT, tab: TableroJuego): Unit

}
