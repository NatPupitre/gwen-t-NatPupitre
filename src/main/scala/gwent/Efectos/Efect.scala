package cl.uchile.dcc
package gwent.Efectos

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Carta.CartaT
import cl.uchile.dcc.gwent.Tablero.TableroJuego

trait Efect {

  def AplicarEfecto(jugador: Jugador, carta: CartaT, tab: TableroJuego): Unit

  def AplicarEfecto(tab: TableroJuego): Unit

  def ColocarCarta(aCarta: CartaT, tab: TableroJuego): Unit

  def ColocarCarta(jugador: Jugador, aCarta: CartaT, tab: TableroJuego): Unit

  def RevertirEfecto(tab: TableroJuego): Unit
}
