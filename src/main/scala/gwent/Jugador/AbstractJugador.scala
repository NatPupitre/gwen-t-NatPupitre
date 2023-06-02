package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta

import cl.uchile.dcc.gwent.Carta.{AbstractCarta, CartaT}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

abstract class AbstractJugador (private var nombre: String, private var stablero: String,
                       private var cgemas: Int) extends Jugador{

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

  /**
   * setters para la clase Computadora
   */

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

  def RobarCarta(): Unit = {
    var CartaRobada: CartaT = this.mazo.last
    var i: Int = this.mazo.length-1
    this.mazo.remove(i)
    this.mano :+= CartaRobada
  }

  def ColocarCarta(aCarta: CartaT): Unit = {
    var manoActual = this.getMano()
    var i: Int = manoActual.indexOf(aCarta)
    manoActual.remove(i)
    this.setMano(manoActual)
    aCarta.ColocarCarta(this)
  }

  def BarajarMazo(): Unit = {
    this.mazo = Random.shuffle(mazo)
  }

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
