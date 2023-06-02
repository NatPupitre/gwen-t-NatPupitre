package cl.uchile.dcc
package gwent.Tablero

import gwent.Carta.CartaT

import scala.collection.mutable.ArrayBuffer
import gwent.Jugador.{Computadora, Usuario, Jugador}

class TableroJuego (private val JugadorUsuario: Usuario, private val JugadorComputadora: Computadora){

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

  def ActualizarCartasTablero(): Unit ={
    CCartasEnTableroCuerpo = JugadorComputadora.getCartasEnTableroCuerpo()
    CCartasEnTableroDistancia = JugadorComputadora.getCartasEnTableroDistancia()
    CCartasEnTableroAsedio = JugadorComputadora.getCartasEnTableroAsedio()

    UCartasEnTableroCuerpo = JugadorUsuario.getCartasEnTableroCuerpo()
    UCartasEnTableroDistancia = JugadorUsuario.getCartasEnTableroDistancia()
    UCartasEnTableroAsedio = JugadorUsuario.getCartasEnTableroAsedio()

    if (CartasEnTableroClima.isEmpty && TurnoJugador == JugadorUsuario){
      CartasEnTableroClima = JugadorUsuario.getCartasEnTableroClima()
    }
    if (CartasEnTableroClima.isEmpty && TurnoJugador == JugadorComputadora) {
      CartasEnTableroClima = JugadorComputadora.getCartasEnTableroClima()
    }
  }

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
