package cl.uchile.dcc
package gwent.Carta

/**
 * La clase abstracta Carta define a las subclases con los campos
 * en común (nombre y clasificación)
 */
abstract class AbstractCarta (private var nombre: String, private var clasificacion: String) extends CartaT {

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

  /**
   * Método abstracto
   */

  // def jugarcarta(): Unit   este método se implementará luego cuando veamos la sección 1.4 (efectos)

}
