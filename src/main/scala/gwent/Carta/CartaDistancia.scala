package cl.uchile.dcc
package gwent.Carta

class CartaDistancia (nombre: String, clasificacion: String, fuerza: Int, habilidad: String)
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, habilidad) {

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaDistancia]
      super.equals(carta2)
    } else false
  }
}
