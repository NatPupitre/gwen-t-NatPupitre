package cl.uchile.dcc.gwent.Carta;

/**
 *
 * @param nombre : Nombre de la carta
 * @param clasificacion : Clima o Unidad
 * @param ubicacion : Ubicación, es la 2da clasificacion:  Cuerpo a cuepo, distancia o asedio
 * @param fuerza : Puntos de fuerza de la carta
 * @param habilidad :
 */
class CartaUnidad (nombre: String, ubicacion: String, private var fuerza: Int,
                   private var habilidad: String) extends Carta(nombre, clasificacion = "Unidad", ubicacion) {


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

    override def equals(o: Any): Boolean = {
        if (this.getClass().getName == o.getClass().getName) {
            val carta2 = o.asInstanceOf[CartaUnidad]
            this.getNombre() == carta2.getNombre() &&
            this.getClasificacion() == carta2.getClasificacion() &&
            this.getUbicacion() == carta2.getUbicacion() &&
            this.getFuerza() == carta2.getFuerza() &&
            this.getHabilidad() == carta2.getHabilidad()
        } else false
    }

    override def hashCode: Int = {
        val prime = 31
        var result = 1
        result = prime * result + classOf[CartaUnidad].##
        result = prime * result + nombre.##
        result = prime * result + ubicacion.##
        result = prime * result + fuerza.##
        result = prime * result + habilidad.##
        result
    }

    override def toString: String = s"Carta Unidad(nombre=$nombre, clasificación=Unidad, ubicación=$ubicacion, fuerza=$fuerza, habilidad=$habilidad)"

    /** esta funcion solo s3erá comentada ya que aun no consideramos el tablero
     * override def jugarcarta(): Unit = {
     * return
     * }
     */
}
