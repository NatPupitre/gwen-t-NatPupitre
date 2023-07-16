package cl.uchile.dcc
package gwent.Efectos.EfectosUnidad

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego
import cl.uchile.dcc.gwent.Efectos.Efect

/** Carta sin efecto para las cartas de unidad que no tienen uno */
class SinEfecto extends AbstractEfectUnidad {

  /**
   * El efecto no se aplica a nada y lo señala mediante un print
   * @param jugador
   * @param carta
   * @param tab
   */
  def AplicarEfecto(jugador: Jugador, carta: CartaT, tab: TableroJuego): Unit = {
    println("Carta sin Efecto")
  }
  
}
