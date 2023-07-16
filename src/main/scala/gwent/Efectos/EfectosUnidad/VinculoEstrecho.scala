package cl.uchile.dcc
package gwent.Efectos.EfectosUnidad

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego
import cl.uchile.dcc.gwent.Efectos.Efect

/**
 * Vínculo estrecho: Si ya existe una carta con el mismo nombre en la fila, duplica la fuerza de esa(s) carta(s),
 * incluyéndose a sí misma.
 */
class VinculoEstrecho extends AbstractEfectUnidad {

  /** El efecto duplica la fuerza a las cartas con el mismo nombre de la misma fila */
  def AplicarEfecto(jugador: Jugador, aCarta: CartaT, tab: TableroJuego): Unit = {
    var CartasMismaFila = aCarta.CartasEnFila(jugador)
    CartasMismaFila.foreach { carta =>
      if (carta.getNombre() == aCarta.getNombre()){
        var fuerza = carta.getFuerza()*2
        carta.setFuerza(fuerza)
      }
    }
    aCarta.ActualizarCartasEnFila(jugador, CartasMismaFila)
  }

  /**
   * Override de Colocar Carta ya que a diferencia de Refuerzo Moral, a la carta que aplique este efecto si se le aplica
   * el efecto, por lo que se agrega a la jugada que planea el jugador y luego de esto se aplica el efecto
   * @param jugador
   * @param aCarta
   * @param tab
   */
  override def ColocarCarta(jugador: Jugador, aCarta: CartaT, tab: TableroJuego): Unit = {
    var cartas = aCarta.CartasEnFila(jugador)
    cartas :+= aCarta
    aCarta.ActualizarCartasEnFila(jugador, cartas)
    this.AplicarEfecto(jugador, aCarta, tab)
  }

}
