package cl.uchile.dcc.gwent.Carta;

/**
 * La clase abstracta Carta define a las subclases con los campos
 * en común (nombre y clasificación)
 */
abstract class Carta (private var nombre: String, private var clasificacion: String, private var ubicacion: String) {

  /**
   * getters
   * @return
   */
  def getNombre(): String = {
    return nombre
  }

  def getClasificacion(): String = {
    return clasificacion
  }

  def getUbicacion(): String = {
    return ubicacion
  }
  /**
   * setters
   * @param aNombre
   * @param aClasificacion
   */
  def setNombre(aNombre: String): Unit = {
    this.nombre = aNombre
  }

  def setClasificacion(aClasificacion: String): Unit = {
    this.clasificacion = aClasificacion
  }

  def setUbicacion(aUbicacion: String): Unit = {
    this.ubicacion = aUbicacion
  }

  /**
   * Método abstracto
   */

  // def jugarcarta(): Unit   este método se implementará luego cuando veamos la sección 1.4 (efectos)

}
