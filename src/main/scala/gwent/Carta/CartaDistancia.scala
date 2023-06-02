package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.{Jugador}
class CartaDistancia (nombre: String, clasificacion: String, fuerza: Int, habilidad: String)
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, habilidad) {

  def ColocarCarta(jugador: Jugador): Unit = {
    var cartas = jugador.getCartasEnTableroDistancia()
    cartas :+= this
    jugador.setCartasEnTableroDistancia(cartas)
  }
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaDistancia]
      super.equals(carta2)
    } else false
  }
}
