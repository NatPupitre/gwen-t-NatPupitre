package cl.uchile.dcc
package gwent.Carta

import gwent.Tablero.TableroJuego
import gwent.Jugador.{Jugador}

class CartaCuerpo (nombre: String, clasificacion: String, fuerza: Int, habilidad: String) 
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, habilidad) {

  /** ColocarCarta(jugador: Jugador): permite al jugador del input colocar la carta en su respectiva
   * zona IMAGINARIA del tablero */
  def ColocarCarta(jugador: Jugador): Unit = {
    var cartas= jugador.getCartasEnTableroCuerpo()
    cartas :+= this
    jugador.setCartasEnTableroCuerpo(cartas)
  }

  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaCuerpo]
      super.equals(carta2)
    } else false
  }
}
