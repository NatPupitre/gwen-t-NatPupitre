package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego

/**
 * Niebla impenetrable: Establece el valor de fuerza de todas las cartas de combate a distancia a 1.
 */
class NieblaImpenetrable extends AbstractEfectClima {

  /**
   * Al aplicar el efecto, las cartas de unidad Cuerpo a Distancia se establecen en 1 mediante la copia
   * de las cartas que el jugador planeaba jugar, de esta forma no se cambian las cartas planeadas
   * y luego podemos revertir el efecto
   *
   * @param tab
   */
  def AplicarEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que se establecerán con el valor de fuerza  en 1
    var CartasUDistancia = tab.getJugadorUsuario().getCartasEnTableroDistancia().map(_.copiarCarta())
    var CartasCDistancia = tab.getJugadorComputadora().getCartasEnTableroDistancia().map(_.copiarCarta())

    //Modificamos las cartas sólo en el tablero
    CartasUDistancia.foreach { carta =>
      carta.setFuerza(1)
    }
    CartasCDistancia.foreach { carta =>
      carta.setFuerza(1)
    }

    tab.setUCartasEnTableroDistancia(CartasUDistancia)
    tab.setCCartasEnTableroDistancia(CartasCDistancia)
  }

  /** Como sólo se modificaron las cartas en el tablero, para revertir el efecto, basta colocar las cartas como
   * están puestas en los sectores cuando el jugador planeaba jugarlas, i.e. los sectores dentro de cada clase
   * de jugador */
  def RevertirEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que los jugadores habían planeado para los sectores cuerpo a cuerpo
    var CartasDistanciaU = tab.getJugadorUsuario().getCartasEnTableroDistancia().map(_.copiarCarta())
    var CartasDistanciaC = tab.getJugadorComputadora().getCartasEnTableroDistancia().map(_.copiarCarta())

    tab.setUCartasEnTableroDistancia(CartasDistanciaU)
    tab.setCCartasEnTableroDistancia(CartasDistanciaC)
  }

}
