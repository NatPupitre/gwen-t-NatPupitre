package cl.uchile.dcc.gwent.Carta;

class CartaClima (nombre: String, private var efecto: String)
                                   extends Carta(nombre, clasificacion = "Clima", "Clima") {


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
