package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador
import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Efectos.EfectosUnidad.RefuerzoMoral

import scala.collection.mutable.ArrayBuffer
class CartaDistancia (nombre: String, clasificacion: String, fuerza: Int, efecto: Efect)
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, efecto) {


  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaDistancia]
      super.equals(carta2)
    } else false
  }

  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT] = {
    return jugador.getCartasEnTableroDistancia()
  }

  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit = {
    jugador.setCartasEnTableroDistancia(cartasNuevas)
  }

  def copiarCarta(): CartaT = {
    return new CartaDistancia(this.getNombre(), this.getClasificacion(), this.getFuerza(), this.getEfecto())
  }
}
