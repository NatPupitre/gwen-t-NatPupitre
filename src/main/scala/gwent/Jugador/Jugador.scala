package cl.uchile.dcc
package gwent.Jugador

import gwent.Carta.Carta

class Jugador(private var nombre: String, private var stablero: String,
              private var cgemas: Int, private var mazo: Mazo, private var mano: Mano) {

  def setNombre(aNombre: String): Unit =  {
    nombre = aNombre
  }

  def setStablero(aStablero: String): Unit = {
    stablero = aStablero
  }

  def setCgemas(aCgemas: Int): Unit = {
    cgemas = aCgemas
  }

  def setMazo(aMazo: Mazo): Unit = {

  }

  def setMano(aMano: Mano): Unit = {

  }

  def JugarCarta(aCarta: Carta): Unit = {

  }

  def RobarCarta(aCarta: Carta): Unit = {

  }
}
