package cl.uchile.dcc
package gwent.Carta

import cl.uchile.dcc.gwent.Carta.Efectos.Efect
import cl.uchile.dcc.gwent.Jugador.Jugador

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * La clase abstracta Carta define a las subclases con los campos
 * en común (nombre y clasificación)
 */
abstract class AbstractCarta (private var nombre: String,
                              private var clasificacion: String, private var efecto: Efect) extends CartaT{

  private var observadores: ListBuffer[Jugador] = ListBuffer()

  def agregarObservador(Obs: Jugador): Unit = {
    observadores += Obs
  }

  def quitarObservador(Obs: Jugador):Unit = {
    observadores -= Obs
  }
  

  /**
   * getters
   * @return
   */
  def getEfecto(): Efect = {
    return efecto
  }
  def getFuerza(): Int = {
    throw new UnsupportedOperationException("Las cartas de clima no poseen fuerza")
  }
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

  def setFuerza(aFuerza: Int): Unit = {
    throw new UnsupportedOperationException("Las cartas de clima no poseen fuerza")
  }
  def setNombre(aNombre: String): Unit = {
    this.nombre = aNombre
  }

  def setClasificacion(aClasificacion: String): Unit = {
    this.clasificacion = aClasificacion
  }
  def setEfecto(aEfecto: Efect): Unit = {
    this.efecto = aEfecto
  }
  
  /**
   * Métodos abstracto
   */
  def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT]
  def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit

}
