package cl.uchile.dcc
package gwent.Carta

/**
 *
 * @param nombre : Nombre de la carta
 * @param clasificacion : Clima o Unidad
 * @param fuerza : Puntos de fuerza de la carta
 * @param habilidad :
 */
abstract class AbstractCartaUnidad (nombre: String, clasificacion: String, private var fuerza: Int,
                   private var habilidad: String) extends AbstractCarta(nombre, clasificacion) {


    /**
     * getters
     *
     * @return
     */
    def getFuerza(): Int = {
        return fuerza
    }
    def getHabilidad(): String = {
        return habilidad
    }
    
    /**
     * setters
     *
     * @param aNombre
     * @param aClasificacion
     * @param aEfecto
     */
    def setFuerza(aFuerza: Int): Unit = {
        this.fuerza = aFuerza
    }

    def setHabilidad(aHabilidad: String): Unit = {
        this.habilidad = aHabilidad
    }
    
    override def toString: String = s"Carta Unidad(nombre=$nombre, clasificación=$clasificacion, fuerza=$fuerza, habilidad=$habilidad)"
    


    /** equals: verifica que 2 objetos sean iguales */
    override def equals(o: Any): Boolean = {
        if (this.getClass().getName == o.getClass().getName) {
            val carta2 = o.asInstanceOf[AbstractCartaUnidad]
            this.getNombre() == carta2.getNombre() &&
              this.getClasificacion() == carta2.getClasificacion() &&
              this.getFuerza() == carta2.getFuerza() &&
              this.getHabilidad() == carta2.getHabilidad()
        } else false
    }

    override def hashCode: Int = {
        val prime = 31
        var result = 1
        result = prime * result + this.getClass().getName.##
        result = prime * result + nombre.##
        result = prime * result + fuerza.##
        result = prime * result + habilidad.##
        result
    }
}
