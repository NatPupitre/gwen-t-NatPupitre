package cl.uchile.dcc
package gwent.Carta

import gwent.Jugador.Jugador
import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Tablero.TableroJuego

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @param nombre : Nombre de la carta
 * @param clasificacion : Clima o Unidad
 * @param fuerza : Puntos de fuerza de la carta
 * @param habilidad :
 */
abstract class AbstractCartaUnidad (nombre: String, clasificacion: String, private var fuerza: Int,
                   efecto: Efect) extends AbstractCarta(nombre, clasificacion, efecto) {


    /**
     * getters
     *
     * @return
     */
    override def getFuerza(): Int = {
        return fuerza
    }

    /**
     * setters
     *
     * @param aNombre
     * @param aClasificacion
     * @param aEfecto
     */
    override def setFuerza(aFuerza: Int): Unit = {
        this.fuerza = aFuerza
    }
    
    override def toString: String = s"Carta Unidad(nombre=$nombre, clasificación=$clasificacion, fuerza=$fuerza, efecto=$efecto)"



    /** equals: verifica que 2 objetos sean iguales */
    override def equals(o: Any): Boolean = {
        if (this.getClass().getName == o.getClass().getName) {
            val carta2 = o.asInstanceOf[AbstractCartaUnidad]
            this.getNombre() == carta2.getNombre() &&
              this.getClasificacion() == carta2.getClasificacion() &&
              this.getFuerza() == carta2.getFuerza() &&
              this.getEfecto() == carta2.getEfecto()
        } else false
    }

    override def hashCode: Int = {
        val prime = 31
        var result = 1
        result = prime * result + this.getClass().getName.##
        result = prime * result + nombre.##
        result = prime * result + fuerza.##
        result = prime * result + efecto.##
        result
    }

    def ColocarCarta(jugador: Jugador, tab: TableroJuego): Unit = {
        this.getEfecto().ColocarCarta(jugador, this, tab)
    }

    /**
     * Métodos abstracto
     */
    def copiarCarta(): CartaT
    def CartasEnFila(jugador: Jugador): ArrayBuffer[CartaT]
    def ActualizarCartasEnFila(jugador: Jugador, cartasNuevas: ArrayBuffer[CartaT]): Unit
}
