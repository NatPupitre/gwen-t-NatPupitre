package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador

import cl.uchile.dcc.gwent.Carta.Efectos.Efect

import scala.collection.mutable.ArrayBuffer
class CartaAsedio (nombre: String, clasificacion: String, fuerza: Int, efecto: Efect)
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, efecto) {

  /** ColocarCarta(jugador: Jugador): permite al jugador del input colocar la carta en su respectiva
   * zona IMAGINARIA del tablero */
  def ColocarCarta(jugador: Jugador): Unit = {
    var cartas = jugador.getCartasEnTableroAsedio()
    cartas :+= this
    jugador.setCartasEnTableroAsedio(cartas)
  }

  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaAsedio]
      super.equals(carta2)
    } else false
  }

  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT] = {
    return jugador.getCartasEnTableroAsedio()
  }

  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit = {
    jugador.setCartasEnTableroAsedio(cartasNuevas)
  }
}
