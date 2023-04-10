package cl.uchile.dcc.gwent.Carta;

/** Una clase que representa la clase Carta
 * La clase Carta se define por su tipo (Unidad o Clima)
 */
public class Carta (private var tipo: String) {
  /** Para diferenciar ambos tipos de Cartas se usan 2 constructores:
   * Unidad: se diferencian por la zona en que pueden ser utilizadas y por su clasificación, por
   * lo que tienen 2 campos que las diferencian entre si.
   *
   * Clima: si o si se colocan en la zona de clima y tienen un tipo de clima,
   * por lo que sólo tienen un campo que las diferencian de otras cartas de clima.
   */
  private var _zona: String = None
  private var _clasificacion: String = None
  private var _poder: String = None

  /** Constructor para el tipo de carta "Unidad"
   * @param tipo
   * @param zona
   * @param clasificacion
   */
  def this(tipo: String, zona: String, clasificacion: String) = {
    this(tipo)
    _zona = zona
    _clasificacion = clasificacion
  }

  /** Constructor para el tipo de carta "Clima"
   * @param tipo
   * @param poder
   */
  def this(tipo: String, poder: String) = {
    this(tipo)
    _poder = poder
  }
}
