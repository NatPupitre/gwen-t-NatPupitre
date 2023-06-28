package cl.uchile.dcc
package gwent.Controlador
import gwent.Jugador.Computadora

import scala.util.Random

class TurnoComputadora(Compu: Computadora) extends EstadoJuego {

  // Número de cartas que se roban por ronda
  private var i: Int = 3

  def TurnoNormal(): Unit = {

  }

  def TurnoVentaja(): Unit = {

  }

  def RoboPorRonda(): Unit = {

    var rand: Int = Random.nextInt(i) + 1
    var j: Int = 0

    if ((Compu.getMano().length + rand) > 10 && rand > 1) {
      i = rand - 1
      RoboPorRonda()
    }

    if ((Compu.getMano().length + rand) > 10 && rand == 1) {
      return
    }

    else {
      while (j <= rand) {
        Compu.RobarCarta()
      }
    }
  }

}
