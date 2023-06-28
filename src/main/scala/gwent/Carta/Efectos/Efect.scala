package cl.uchile.dcc
package gwent.Carta.Efectos

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Carta.CartaT

trait Efect {

  def AplicarEfecto(jugador: Jugador, carta: CartaT): Unit

}
