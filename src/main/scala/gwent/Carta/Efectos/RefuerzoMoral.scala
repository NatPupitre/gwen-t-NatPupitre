package cl.uchile.dcc
package gwent.Carta.Efectos

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Carta.CartaT

class RefuerzoMoral extends Efect{

  def AplicarEfecto(jugador: Jugador, carta: CartaT): Unit = {
    var CartasMismaFila = carta.CartasEnFila(jugador)
    CartasMismaFila.foreach { carta => 
      var fuerza = carta.getFuerza() + 1
      carta.setFuerza(fuerza)
    }
    carta.ActualizarCartasEnFila(jugador, CartasMismaFila)
  }

}
