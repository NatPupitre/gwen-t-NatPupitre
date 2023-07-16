package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta
import cl.uchile.dcc.gwent.Carta.{AbstractCarta, CartaT}
import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Tablero.TableroJuego

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

abstract class AbstractJugador (private var nombre: String, private var stablero: String,
                       private var cgemas: Int) extends Jugador {

  private var mano: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var mazo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  /**
   * CartasEnTablero son arreglos que irán definidos como arreglos en la clase tablero, siendo estos los
   * arreglos que contienen las cartas en cierta zona del tablero, pero como aún no definimos esa clase
   * lo dejaré como arreglos en esta clase.
   */
  private var CartasEnTableroCuerpo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var CartasEnTableroDistancia: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var CartasEnTableroAsedio: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var CartasEnTableroClima: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  /** Getters */

  def getNombre(): String = {
    return nombre
  }

  def getStablero(): String = {
    return stablero
  }

  def getCgemas(): Int = {
    return cgemas
  }

  def getMano(): ArrayBuffer[CartaT] = {
    return mano
  }

  def getMazo(): ArrayBuffer[CartaT] = {
    return mazo
  }

  def getCartasEnTableroCuerpo(): ArrayBuffer[CartaT] = {
    return CartasEnTableroCuerpo
  }

  def getCartasEnTableroDistancia(): ArrayBuffer[CartaT] = {
    return CartasEnTableroDistancia
  }

  def getCartasEnTableroAsedio(): ArrayBuffer[CartaT] = {
    return CartasEnTableroAsedio
  }

  def getCartasEnTableroClima(): ArrayBuffer[CartaT] = {
    return CartasEnTableroClima
  }

  /** Setters */

  def setNombre(aNombre: String): Unit = {
    nombre = aNombre
  }

  def setStablero(aStablero: String): Unit = {
    stablero = aStablero
  }

  def setCgemas(aCgemas: Int): Unit = {
    cgemas = aCgemas
  }

  def setMano(aMano: ArrayBuffer[CartaT]): Unit = {
    mano = aMano
  }

  def setMazo(aMazo: ArrayBuffer[CartaT]): Unit = {
    mazo = aMazo
  }

  def setCartasEnTableroCuerpo(tabCuerpo: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroCuerpo = tabCuerpo
  }

  def setCartasEnTableroDistancia(tabDistancia: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroDistancia = tabDistancia
  }

  def setCartasEnTableroAsedio(tabAsedio: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroAsedio = tabAsedio
  }

  def setCartasEnTableroClima(tabClima: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroClima = tabClima
  }


  /** RobarCarta(): Permite tomar el ultimo objeto de tipo CartaT del mazo y lo agrega a la mano */
  def RobarCarta(): Unit = {
    var CartaRobada: CartaT = this.mazo.last
    var i: Int = this.mazo.length - 1
    this.mazo.remove(i)
    this.mano :+= CartaRobada
  }

  /** ColocarCarta(aCarta: CartaT): selecciona una carta de la mano y se agrega a una zona dentro del jugador
   * que se podría considerar como IMAGINARIA, ya que aun no se aceptan en el tablero, pero indica donde el
   * jugador desea colocar sus cartas */
  def ColocarCarta(aCarta: CartaT, tab: TableroJuego): Unit = {
    //Quitamos carta de la mano
    var manoActual = this.getMano()
    var i: Int = manoActual.indexOf(aCarta)
    manoActual.remove(i)
    this.setMano(manoActual)

    //Colocamos carta en el tablero según su clasificación
    aCarta.ColocarCarta(this, tab)
  }

  def BarajarMazo(): Unit = {
    this.mazo = Random.shuffle(mazo)
  }

  /** equals: Verifica que 2 objetos sean iguales a partir de las clases hijas */
  override def equals(o: Any): Boolean = {
    if (this.getClass().getName == o.getClass().getName) {
      val Jugador2 = o.asInstanceOf[AbstractJugador]
      this.nombre == Jugador2.nombre &&
        this.stablero == Jugador2.stablero &&
        this.cgemas == Jugador2.cgemas &&
        this.mano.sameElements(Jugador2.mano) &&
        this.mazo.sameElements(Jugador2.mazo)
    } else false
  }

  /** hashCode: Retorna el numero que identifica al objeto */
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + this.getClass().getName.##
    result = prime * result + nombre.##
    result = prime * result + stablero.##
    result = prime * result + cgemas.##
    result
  }


}
