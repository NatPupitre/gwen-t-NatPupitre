package cl.uchile.dcc
package gwent.Tablero

import gwent.Carta.{CartaClima, CartaT}

import scala.collection.mutable.ArrayBuffer
import gwent.Jugador.{Computadora, Jugador, Usuario}
import cl.uchile.dcc.gwent.Efectos.Efect
import cl.uchile.dcc.gwent.Efectos.EfectosClima.ParaTestSInEfectos

/** TableroJuego: representa el tablero del juego y recibe a los 2 jugadores de este como input*/
class TableroJuego (private var JugadorUsuario: Usuario, private var JugadorComputadora: Computadora){

  //TurnoJugador: Jugador cuyo actual turno es el suyo
  private var EfectoActivo: Efect = null
  
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
    CCartasEnTableroCuerpo = JugadorComputadora.getCartasEnTableroCuerpo().map(_.copiarCarta())
    CCartasEnTableroDistancia = JugadorComputadora.getCartasEnTableroDistancia().map(_.copiarCarta())
    CCartasEnTableroAsedio = JugadorComputadora.getCartasEnTableroAsedio().map(_.copiarCarta())
    
    UCartasEnTableroCuerpo = JugadorUsuario.getCartasEnTableroCuerpo().map(_.copiarCarta())
    UCartasEnTableroDistancia = JugadorUsuario.getCartasEnTableroDistancia().map(_.copiarCarta())
    UCartasEnTableroAsedio = JugadorUsuario.getCartasEnTableroAsedio().map(_.copiarCarta())

    if(EfectoActivo != null) {
      EfectoActivo.AplicarEfecto(this)
    }
  }

  // Getters
  def getEfectoActivo(): Efect = {
    return EfectoActivo
  }
  def getTurnoJugador(): Jugador = {
    return TurnoJugador
  }
  def setTurnoJugador(TJ: Jugador): Unit = {
    TurnoJugador = TJ
  }

  def getJugadorUsuario(): Jugador = {
    return JugadorUsuario
  }

  def getJugadorComputadora(): Jugador = {
    return JugadorComputadora
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
  def setEfectoActivo(aEfect: Efect): Unit = {
    EfectoActivo = aEfect
  }
  def setJugadorUsuario(aJugador: Usuario): Unit = {
    JugadorUsuario = aJugador
  }

  def setJugadorComputadora(aJugador: Computadora): Unit = {
    JugadorComputadora = aJugador
  }
  def setCCartasEnTableroCuerpo(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroCuerpo = cartas.clone()
  }
  def setCCartasEnTableroDistancia(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroDistancia = cartas.clone()
  }
  def setCCartasEnTableroAsedio(cartas: ArrayBuffer[CartaT]): Unit = {
    CCartasEnTableroAsedio = cartas.clone()
  }
  def setUCartasEnTableroCuerpo(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroCuerpo = cartas.clone()
  }
  def setUCartasEnTableroDistancia(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroDistancia = cartas.clone()
  }
  def setUCartasEnTableroAsedio(cartas: ArrayBuffer[CartaT]): Unit = {
    UCartasEnTableroAsedio = cartas.clone()
  }
  def setCartasEnTableroClima(cartas: ArrayBuffer[CartaT]): Unit = {
    CartasEnTableroClima = cartas
  }
}
