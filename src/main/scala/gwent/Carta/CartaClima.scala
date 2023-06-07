package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.{Jugador}

class CartaClima (nombre: String, clasificacion: String, private var efecto: String)
                                   extends AbstractCarta(nombre, clasificacion) {


  /**
   * getters
   *
   * @return
   */


  def getEfecto(): String = {
    return efecto
  }

  /**
   * setters
   *
   * @param aNombre
   * @param aClasificacion
   * @param aEfecto
   */



  def setEfecto(aEfecto: String): Unit = {
    this.efecto = aEfecto
  }

  /** ColocarCarta(jugador: Jugador): permite al jugador del input colocar la carta en su respectiva
   *  zona IMAGINARIA del tablero */
  def ColocarCarta(jugador: Jugador): Unit = {
    var cartas = jugador.getCartasEnTableroClima()
    if (cartas.isEmpty) {
      cartas :+= this
      jugador.setCartasEnTableroClima(cartas)
    } else {
      println(" Ya hay una carta en la zona de Clima ")
      var nuevasCartas = jugador.getMano()
      nuevasCartas :+= this
      jugador. setMano(nuevasCartas)
    }
  }

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

  /** esta funcion solo s3erá comentada ya que aun no consideramos el tablero
   * override def jugarcarta(): Unit = {
   * return
   * }
   */
}
