package cl.uchile.dcc
package gwent.Tablero

import gwent.Carta.CartaT

import scala.collection.mutable.ArrayBuffer
import gwent.Jugador.{Computadora, Usuario, Jugador}

/** TableroJuego: representa el tablero del juego y recibe a los 2 jugadores de este como input*/
class TableroJuego (private val JugadorUsuario: Usuario, private val JugadorComputadora: Computadora){

  //TurnoJugador: Jugador cuyo actual turno es el suyo
  private var TurnoJugador: Jugador = null

  // Cartas en la zona del Jugador Computadora
  private var CCartasEnTableroCuerpo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var CCartasEnTableroDistancia: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var CCartasEnTableroAsedio: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // Cartas en la zona del Jugador Usuario
  private var UCartasEnTableroCuerpo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var UCartasEnTableroDistancia: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  private var UCartasEnTableroAsedio: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // Carta en la zona clima
  private var CartasEnTableroClima: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](1)

  /** ActualizarCartasTablero(): Los jugadores ya tienen pensadas las cartas que quieren colocar en sus
   * respectivas zonas las cuales se ven en sus respectivas zonas del tablero dentro de cda jugador,
   * pero esta función es la que da el permiso para que las cartas sean colocadas realmente en el tablero */
  def ActualizarCartasTablero(): Unit ={
    CCartasEnTableroCuerpo = JugadorComputadora.getCartasEnTableroCuerpo()
    CCartasEnTableroDistancia = JugadorComputadora.getCartasEnTableroDistancia()
    CCartasEnTableroAsedio = JugadorComputadora.getCartasEnTableroAsedio()

    UCartasEnTableroCuerpo = JugadorUsuario.getCartasEnTableroCuerpo()
    UCartasEnTableroDistancia = JugadorUsuario.getCartasEnTableroDistancia()
    UCartasEnTableroAsedio = JugadorUsuario.getCartasEnTableroAsedio()

    /** Para la carta clima importa de quien es el turno, ya que el primero que ponga la carta no
     * permitira que el otro jugador ponga la suya (solo puede haber una carta de clima en la zona) */
    if (CartasEnTableroClima.isEmpty && TurnoJugador == JugadorUsuario){
      CartasEnTableroClima = JugadorUsuario.getCartasEnTableroClima()
    }
    if (CartasEnTableroClima.isEmpty && TurnoJugador == JugadorComputadora) {
      CartasEnTableroClima = JugadorComputadora.getCartasEnTableroClima()
    }
  }

  // Getters
  def getTurnoJugador(): Jugador = {
    return TurnoJugador
  }
  def setTurnoJugador(TJ: Jugador): Unit = {
    TurnoJugador = TJ
  }
  def getCCartasEnTableroCuerpo(): ArrayBuffer[CartaT] ={
    return CCartasEnTableroCuerpo
  }
  def getCCartasEnTableroDistancia(): ArrayBuffer[CartaT] = {
    return CCartasEnTableroDistancia
  }
  def getCCartasEnTableroAsedio(): ArrayBuffer[CartaT] = {
    return CCartasEnTableroAsedio
  }
  def getUCartasEnTableroCuerpo(): ArrayBuffer[CartaT] = {
    return UCartasEnTableroCuerpo
  }
  def getUCartasEnTableroDistancia(): ArrayBuffer[CartaT] = {
    return UCartasEnTableroDistancia
  }
  def getUCartasEnTableroAsedio(): ArrayBuffer[CartaT] = {
    return UCartasEnTableroAsedio
  }
  def getCartasEnTableroClima(): ArrayBuffer[CartaT] = {
    return CartasEnTableroClima
  }

  // Setters
  def setCCartasEnTableroCuerpo(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroCuerpo = cartas
  }
  def setCCartasEnTableroDistancia(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroDistancia = cartas
  }
  def setCCartasEnTableroAsedio(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroAsedio = cartas
  }
  def setUCartasEnTableroCuerpo(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroCuerpo = cartas
  }
  def setUCartasEnTableroDistancia(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroDistancia = cartas
  }
  def setUCartasEnTableroAsedio(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroAsedio = cartas
  }
  def setCartasEnTableroClima(cartas: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroClima = cartas
  }
}
