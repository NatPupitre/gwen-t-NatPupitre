package cl.uchile.dcc
package gwent.Efectos.EfectosUnidad

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego
import cl.uchile.dcc.gwent.Efectos.Efect

/**
 * Refuerzo moral: Cuando la carta entra en el campo, añade +1 a la fuerza de todas las cartas en su fila,
 * excepto a sí misma.
 */
class RefuerzoMoral extends AbstractEfectUnidad {

  /** El efecto agrega uno de fuerza a las cartas de la misma fila de la carta que juega el efecto */
  def AplicarEfecto(jugador: Jugador, carta: CartaT, tab: TableroJuego): Unit = {
    var CartasMismaFila = carta.CartasEnFila(jugador)
    CartasMismaFila.foreach { carta => 
      var fuerza = carta.getFuerza() + 1
      carta.setFuerza(fuerza)
    }
    carta.ActualizarCartasEnFila(jugador, CartasMismaFila)
  }


}
