package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.{CartaT}

import cl.uchile.dcc.gwent.Carta.Efectos.Efect

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

trait Jugador {
  
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

  def getNombre(): String 

  def getStablero(): String 

  def getCgemas(): Int 

  def getMano(): ArrayBuffer[CartaT] 

  def getMazo(): ArrayBuffer[CartaT] 

  def getCartasEnTableroCuerpo(): ArrayBuffer[CartaT] 

  def getCartasEnTableroDistancia(): ArrayBuffer[CartaT] 

  def getCartasEnTableroAsedio(): ArrayBuffer[CartaT] 

  def getCartasEnTableroClima(): ArrayBuffer[CartaT] 

  /**
   * setters para la clase Computadora
   */

  def setNombre(aNombre: String): Unit 

  def setStablero(aStablero: String): Unit 

  def setCgemas(aCgemas: Int): Unit 

  def setMano(aMano: ArrayBuffer[CartaT]): Unit 

  def setMazo(aMazo: ArrayBuffer[CartaT]): Unit 

  def setCartasEnTableroCuerpo(tabCuerpo: ArrayBuffer[CartaT]): Unit 

  def setCartasEnTableroDistancia(tabDistancia: ArrayBuffer[CartaT]): Unit 

  def setCartasEnTableroAsedio(tabAsedio: ArrayBuffer[CartaT]): Unit 

  def setCartasEnTableroClima(tabClima: ArrayBuffer[CartaT]): Unit 

  def RobarCarta(): Unit 

  def BarajarMazo(): Unit

  def update(aCarta: CartaT): Unit
}
