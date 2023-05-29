package cl.uchile.dcc
package gwent.Carta

class CartaCuerpo (nombre: String, clasificacion: String, fuerza: Int, habilidad: String) 
  extends AbstractCartaUnidad(nombre, clasificacion, fuerza, habilidad) {

  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val carta2 = o.asInstanceOf[CartaCuerpo]
      super.equals(carta2)
    } else false
  }
}
