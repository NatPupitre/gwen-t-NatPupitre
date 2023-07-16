package cl.uchile.dcc
package gwent.Efectos.EfectosClima

import gwent.Carta.CartaT
import gwent.Jugador.Jugador
import gwent.Tablero.TableroJuego

/**
 * Lluvia torrencial: Establece el valor de todas las cartas de asedio a 1.
 */
class LluviaTorrencial extends AbstractEfectClima {

  /**
   * Al aplicar el efecto, las cartas de unidad Asedio se establecen en 1 mediante la copia
   * de las cartas que el jugador planeaba jugar, de esta forma no se cambian las cartas planeadas
   * y luego podemos revertir el efecto
   *
   * @param tab
   */
  def AplicarEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que se establecerán con el valor de fuerza  en 1
    var CartasUAsedio = tab.getJugadorUsuario().getCartasEnTableroAsedio().map(_.copiarCarta())
    var CartasCAsedio = tab.getJugadorComputadora().getCartasEnTableroAsedio().map(_.copiarCarta())

    //Modificamos las cartas sólo en el tablero
    CartasUAsedio.foreach { carta =>
      carta.setFuerza(1)
    }
    CartasCAsedio.foreach { carta =>
      carta.setFuerza(1)
    }

    tab.setUCartasEnTableroAsedio(CartasUAsedio)
    tab.setCCartasEnTableroAsedio(CartasCAsedio)
  }

  /** Como sólo se modificaron las cartas en el tablero, para revertir el efecto, basta colocar las cartas como
   * están puestas en los sectores cuando el jugador planeaba jugarlas, i.e. los sectores dentro de cada clase
   * de jugador */
  def RevertirEfecto(tab: TableroJuego): Unit = {

    //Tomamos las cartas que los jugadores habían planeado para los sectores cuerpo a cuerpo
    var CartasAsedioU = tab.getJugadorUsuario().getCartasEnTableroAsedio().map(_.copiarCarta())
    var CartasAsedioC = tab.getJugadorComputadora().getCartasEnTableroAsedio().map(_.copiarCarta())

    tab.setUCartasEnTableroAsedio(CartasAsedioU)
    tab.setCCartasEnTableroAsedio(CartasAsedioC)
  }

}
