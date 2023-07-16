package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador
import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Tablero.TableroJuego

import scala.collection.mutable.ArrayBuffer

class CartaClima (nombre: String, clasificacion: String, efecto: Efect)
                                   extends AbstractCarta(nombre, clasificacion, efecto) {

  private var observadores: ArrayBuffer[Jugador] = new ArrayBuffer[Jugador](2)

  /** ColocarCarta(jugador: Jugador): permite al jugador del input colocar la carta en su respectiva
   *  zona IMAGINARIA del tablero */


  /** equals: verifica que 2 objetos sean iguales */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaClima]
      this.getNombre() == carta2.getNombre() &&
      this.getClasificacion() == carta2.getClasificacion() &&
      this.getEfecto() == carta2.getEfecto()
    } else false
  }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[CartaClima].##
    result = prime * result + nombre.##
    result = prime * result + efecto.##
    result
  }

  override def toString: String = s"Carta Clima(nombre=$nombre, clasificación=Clima, efecto=$efecto)"

  def setObservadores(obs: ArrayBuffer[Jugador]): Unit = {
    observadores = obs
  }

  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT] = {
    return jugador.getCartasEnTableroClima()
  }

  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit = {
    jugador.setCartasEnTableroClima(cartasNuevas)
  }

  def ColocarCarta(jugador: Jugador, tab: TableroJuego): Unit = {
    this.getEfecto().ColocarCarta(this, tab)
  }

  def copiarCarta(): CartaT = {
    return new CartaClima (nombre, clasificacion, efecto)
  }
}
