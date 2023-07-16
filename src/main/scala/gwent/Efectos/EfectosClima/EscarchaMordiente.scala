package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego

/**
 * Escarcha mordiente: Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.
 */
class EscarchaMordiente extends AbstractEfectClima {

  /**
   * Al aplicar el efecto, las cartas de unidad Cuerpo a cuerpo se establecen en 1 mediante la copia
   * de las cartas que el jugador planeaba jugar, de esta forma no se cambian las cartas planeadas
   * y luego podemos revertir el efecto
   *
   * @param tab
   */
  def AplicarEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que se establecerán con el valor de fuerza  en 1
    var CartasUCuerpo = tab.getJugadorUsuario().getCartasEnTableroCuerpo().map(_.copiarCarta())
    var CartasCCuerpo = tab.getJugadorComputadora().getCartasEnTableroCuerpo().map(_.copiarCarta())

    //Modificamos las cartas sólo en el tablero
    CartasUCuerpo.foreach { carta =>
      carta.setFuerza(1)
    }
    CartasCCuerpo.foreach { carta =>
      carta.setFuerza(1)
    }

    tab.setUCartasEnTableroCuerpo(CartasUCuerpo)
    tab.setCCartasEnTableroCuerpo(CartasCCuerpo)

  }

  /** Como sólo se modificaron las cartas en el tablero, para revertir el efecto, basta colocar las cartas como
   * están puestas en los sectores cuando el jugador planeaba jugarlas, i.e. los sectores dentro de cada clase
   * de jugador*/
  def RevertirEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que los jugadores habían planeado para los sectores cuerpo a cuerpo
    var CartasCuerpoU = tab.getJugadorUsuario().getCartasEnTableroCuerpo().map(_.copiarCarta())
    var CartasCuerpoC = tab.getJugadorComputadora().getCartasEnTableroCuerpo().map(_.copiarCarta())

    tab.setUCartasEnTableroCuerpo(CartasCuerpoU)
    tab.setCCartasEnTableroCuerpo(CartasCuerpoC)
  }

}
