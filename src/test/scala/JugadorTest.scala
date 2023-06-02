package cl.uchile.dcc

import gwent.Carta.{AbstractCarta, CartaT, CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia}
import gwent.Jugador.{Computadora, Usuario}


import scala.collection.mutable.ArrayBuffer

class JugadorTest extends munit.FunSuite {

  /**
   * Cartas de una baraja estándar
   */

  // 18 Cartas, clasificación: Unidad
  var carta_U1: CartaCuerpo = null
  var carta_U2: CartaCuerpo = null
  var carta_U3: CartaCuerpo = null
  var carta_U4: CartaCuerpo = null
  var carta_U5: CartaCuerpo = null
  var carta_U6: CartaCuerpo = null
  var carta_U7: CartaDistancia = null
  var carta_U8: CartaDistancia = null
  var carta_U9: CartaDistancia = null
  var carta_U10: CartaDistancia = null
  var carta_U11: CartaDistancia = null
  var carta_U12: CartaDistancia = null
  var carta_U13: CartaAsedio = null
  var carta_U14: CartaAsedio = null
  var carta_U15: CartaAsedio = null
  var carta_U16: CartaAsedio = null
  var carta_U17: CartaAsedio = null
  var carta_U18: CartaAsedio = null

  // 7 Cartas, clasificación: Clima
  var carta_C1: CartaClima = null
  var carta_C2: CartaClima = null
  var carta_C3: CartaClima = null
  var carta_C4: CartaClima = null
  var carta_C5: CartaClima = null
  var carta_C6: CartaClima = null
  var carta_C7: CartaClima = null

  /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
   * cuantos sean necesarios para verificar los métodos
   */
  var hue: Computadora = null
  var jiu: Computadora = null
  var jarvis: Computadora = null
  var gato: Usuario = null
  var gatito: Usuario = null
  var gatoBotas: Usuario = null

  var gatoBot1: Computadora = null
  var gatoBot2: Usuario = null

  // mazo que tendrán ambos jugadores antes de barajar el mazo:
  var mazoOrdenado: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mazo desordenado para el robo de cartas:
  var mazoDesodenado1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var mazoDesodenado2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mano esperada tras el robo de 10 cartas:
  var manoEsperada1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var manoEsperada2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mazo esperado tras el robo de 10 cartas:
  var mazoTrasRobo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)


  override def beforeEach(context: BeforeEach): Unit = {

    /**
     * 18 cartas de Unidad repartidas equitativamente entre las 3 clasificaciones: Cuerpo, Distancia y Asedio
     * 2 cartas de cada 6 cartas de unidad de acuerdo a su clasificación
     * 7 cartas de clima
     * todas con su respectivo input:
     */
    carta_U1 = new CartaCuerpo("Nombre 1", "Cuerpo", 1, "habilidad 1")
    carta_U2 = new CartaCuerpo("Nombre igual 2.3", "Cuerpo", 23, "habilidad 2.3")
    carta_U3 = new CartaCuerpo("Nombre igual 2.3", "Cuerpo", 23, "habilidad 2.3")
    carta_U4 = new CartaCuerpo("Nombre 4", "Cuerpo", 1, "habilidad 4")
    carta_U5 = new CartaCuerpo("mismo Nombre", "Cuerpo", 56, "misma habilidad")
    carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 56, "misma habilidad")
    carta_U7 = new CartaDistancia("Nombre igual 7.8", "Distancia", 78, "habilidad 7.8")
    carta_U8 = new CartaDistancia("Nombre igual 7.8", "Distancia", 78, "habilidad 7.8")
    carta_U9 = new CartaDistancia("Nombre 1", "Distancia", 9, "habilidad 1")
    carta_U10 = new CartaDistancia("Nombre 1", "Distancia", 10, "habilidad 1")
    carta_U11 = new CartaDistancia("Nombre 1", "Distancia", 11, "habilidad 1")
    carta_U12 = new CartaDistancia("Nombre 1", "Distancia", 12, "habilidad 1")
    carta_U13 = new CartaAsedio("Nombre igual 13.14", "Asedio", 1314, "habilidad 13.14")
    carta_U14 = new CartaAsedio("Nombre igual 13.14", "Asedio", 1314, "habilidad 13.14")
    carta_U15 = new CartaAsedio("Nombre 1", "Asedio", 15, "habilidad 1")
    carta_U16 = new CartaAsedio("Nombre 1", "Asedio", 16, "habilidad 1")
    carta_U17 = new CartaAsedio("Nombre 1", "Asedio", 17, "habilidad 1")
    carta_U18 = new CartaAsedio("Nombre 1", "Asedio", 18, "habilidad 1")

    carta_C1 = new CartaClima("Nombre 1", "Clima", "Habilidad 1")
    carta_C2 = new CartaClima("Nombre igual 2.3","Clima", "habilidad 2.3")
    carta_C3 = new CartaClima("Nombre igual 2.3", "Clima", "habilidad 2.3")
    carta_C4 = new CartaClima("Nombre 4", "Clima", "Efecto 2")
    carta_C5 = new CartaClima("mismo Nombre", "Clima", "misma habilidad")
    carta_C6 = new CartaClima("mismo Nombre", "Clima", "misma habilidad")
    carta_C7 = new CartaClima("Nombre C7", "Clima", "habilidad 7")

    /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
     * cuantos sean necesarios para verificar los métodos
     */
    hue = new Computadora("H.U.E", "arriba", 0)
    jiu = new Computadora("H.U.E", "arriba", 0) // 2 Computadoras iguales

    jarvis = new Computadora("J.A.R.V.I.S", "arriba", 0) // 1 computadora distinta

    gato = new Usuario("Gastón Gatuso", "abajo", 0)
    gatito = new Usuario("Gastón Gatuso", "abajo", 0) // 2 usuarios iguales

    gatoBotas = new Usuario("Gato con Botas", "abajo", 0) // 1 usuarios distinto

    gatoBot1 = new Computadora("gatoBot", "arriba", 0)
    gatoBot2 = new Usuario("gatoBot", "arriba", 0) // 2 Jugadores, mismos inputs, distintas clases

    /** Definición de los elementos en los mazos y manos antes descritos */
    mazoOrdenado = ArrayBuffer(carta_U1, carta_U2, carta_U3, carta_U4, carta_U17, carta_U18, carta_U7,
      carta_U8, carta_C4, carta_U10, carta_U11, carta_U12, carta_U13,
      carta_U14, carta_U15, carta_U16, carta_U5, carta_U6, carta_C1,
      carta_C2, carta_C3, carta_U9, carta_C5, carta_C6, carta_C7)

    mazoDesodenado1 = ArrayBuffer(carta_U1, carta_C5, carta_C6, carta_U4, carta_U5, carta_U6, carta_C3,
      carta_U8, carta_U9, carta_U10, carta_U11, carta_U12, carta_U17,
      carta_U18, carta_U15, carta_U16, carta_U13, carta_U14, carta_C1,
      carta_C2, carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
    mazoDesodenado2 = ArrayBuffer(carta_U1, carta_C5, carta_C6, carta_U4, carta_U5, carta_U6, carta_C3,
      carta_U8, carta_U9, carta_U10, carta_U11, carta_U12, carta_U17,
      carta_U18, carta_U15, carta_U16, carta_U13, carta_U14, carta_C1,
      carta_C2, carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)


    manoEsperada1 = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
      carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
    manoEsperada2 = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
      carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)


    mazoTrasRobo = ArrayBuffer(carta_U1, carta_C5, carta_C6, carta_U4, carta_U5, carta_U6, carta_C3,
      carta_U8, carta_U9, carta_U10, carta_U11, carta_U12, carta_U17,
      carta_U18, carta_U15)
  }

  test("equals") {

    /** equals de la clase Usuario */
    assertEquals(gato, gatito)
    assert(gato.equals(gatito))
    assertEquals(new Usuario("a", "b", 1),
      new Usuario("a", "b", 1))

    /** equals de la clase Computadora */
    assertEquals(hue, jiu)
    assert(hue.equals(jiu))
    assertEquals(new Computadora("a", "b", 1),
      new Computadora("a", "b", 1))
  }

  test("not equals Cartas") {

    // misma clase distintos inputs para la clase Computadora
    assertNotEquals(hue, jarvis)
    assert(!hue.equals(jarvis))
    assertNotEquals(new Computadora("a", "b", 1),
      new Computadora("a", "c", 2))

    // misma clase distintos inputs para la clase Usuario
    assertNotEquals(gato, gatoBotas)
    assert(!gatoBotas.equals(gato))
    assertNotEquals(new Usuario("a", "b", 1),
      new Usuario("a", "c", 2))

    // Distintas clases
    assert(!gato.equals(hue))

    assert(!hue.equals(gato))

  }

  test("hashcode") {

    /** Si 2 elementos son iguales deberían tener el mismo hashcode y sin son distintas no */

    //Clase Computadora
    assert(hue.hashCode == jiu.hashCode)
    assert(hue.hashCode != jarvis.hashCode)

    //Clase Usuario
    assert(gato.hashCode == gatito.hashCode)
    assert(gato.hashCode != gatoBotas.hashCode)
  }

  test("getters") {

    /** Previamente se definió hue con los siguientes inputs:
     * hue = new Computadora("H.U.E", "arriba", 0)
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase Computadora
     */
    assert(hue.getNombre() == "H.U.E")
    assert(hue.getStablero() == "arriba")
    assert(hue.getCgemas() == 0)

    /** Previamente se definió hue con los siguientes inputs:
     * gato = new Usuario("Gastón Gatuso", "abajo", 0)
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase Computadora
     */
    assert(gato.getNombre() == "Gastón Gatuso")
    assert(gato.getStablero() == "abajo")
    assert(gato.getCgemas() == 0)

    /** Getters de sus respectivas zonas del tablero */

    //Clase Computadora
    assert(jiu.getCartasEnTableroCuerpo().isEmpty)
    assert(jiu.getCartasEnTableroDistancia().isEmpty)
    assert(jiu.getCartasEnTableroAsedio().isEmpty)
    assert(jiu.getCartasEnTableroClima().isEmpty)

    //Clase Usuario
    assert(gatito.getCartasEnTableroCuerpo().isEmpty)
    assert(gatito.getCartasEnTableroDistancia().isEmpty)
    assert(gatito.getCartasEnTableroAsedio().isEmpty)
    assert(gatito.getCartasEnTableroClima().isEmpty)
  }

  test("setters") {

    //Clase Computadora
    jiu.setNombre("Otro Nombre")
    assert(jiu.getNombre() == "Otro Nombre")
    jiu.setStablero("otro lado")
    assert(jiu.getStablero() == "otro lado")
    jiu.setCgemas(10)
    assert(jiu.getCgemas() == 10)

    //Clase Usuario
    gatito.setNombre("Otro Nombre")
    assert(gatito.getNombre() == "Otro Nombre")
    gatito.setStablero("otro lado")
    assert(gatito.getStablero() == "otro lado")
    gatito.setCgemas(10)
    assert(gatito.getCgemas() == 10)

    /** Setters de sus respectivas zonas del tablero */

    //Clase Computadora
    jiu.setCartasEnTableroCuerpo(mazoOrdenado)
    assert(jiu.getCartasEnTableroCuerpo() == mazoOrdenado)
    jiu.setCartasEnTableroDistancia(mazoOrdenado)
    assert(jiu.getCartasEnTableroDistancia() == mazoOrdenado)
    jiu.setCartasEnTableroAsedio(mazoOrdenado)
    assert(jiu.getCartasEnTableroAsedio() == mazoOrdenado)
    jiu.setCartasEnTableroClima(mazoOrdenado)
    assert(jiu.getCartasEnTableroClima() == mazoOrdenado)

    //Clase Usuario
    gatito.setCartasEnTableroCuerpo(mazoOrdenado)
    assert(gatito.getCartasEnTableroCuerpo() == mazoOrdenado)
    gatito.setCartasEnTableroDistancia(mazoOrdenado)
    assert(gatito.getCartasEnTableroDistancia() == mazoOrdenado)
    gatito.setCartasEnTableroAsedio(mazoOrdenado)
    assert(gatito.getCartasEnTableroAsedio() == mazoOrdenado)
    gatito.setCartasEnTableroClima(mazoOrdenado)
    assert(gatito.getCartasEnTableroClima() == mazoOrdenado)

  }

  test("Barajar Mazo") {

    /** Ambos Jugadores tendrán el mismo mazo de 18 cartas */
    hue.setMazo(mazoOrdenado)
    gato.setMazo(mazoOrdenado)

    /**
     * Por como se definió se sabe que los mazos (mazoOrdenado) de ambos jugadores están ordenados, por lo que
     * se barajan con la funcion BarajarMazo y comprobamos que ya no son iguales a mazoOrdenado
     */
    hue.BarajarMazo()
    gato.BarajarMazo()

    assert(hue.getMazo() != mazoOrdenado)
    assert(gato.getMazo() != mazoOrdenado)

    /**
     * ahora verificamos que los elementos siguen estando ahí a pesar de que ya no tienen el mismo orden
     */
    //contienen la misma cantidad de elementos
    assert(hue.getMazo().length == mazoOrdenado.length)
    assert(gato.getMazo().length == mazoOrdenado.length)

    // contienen los mismos elementos
    assert(hue.getMazo().toSet == mazoOrdenado.toSet)
    assert(gato.getMazo().toSet == mazoOrdenado.toSet)

  }

  test("Robar Carta") {

    /** por como se definió robo de carta, los jugadores deberán robar los últimos elementos del
     * ArrayBuffer mazo, que en este caso será mazoDesordenaod, por lo que se tiene una mano esperada
     * (manoEsperada) tras el robo de cartas
     */
    hue.setMazo(mazoDesodenado1)
    gato.setMazo(mazoDesodenado2)

    // inicialmente se tiene la mano vacía

    assert(hue.getMano().isEmpty)
    assert(gato.getMano().isEmpty)

    /** hue y gato roban 10 cartas de su mazo desordenado (no usamos shuffle ya que sabemos que barajarCartas
     * funciona y conociendo sus mazos podemos conocer su mano tras el robo)
     */
    for (i <- 0 until 10) {
      hue.RobarCarta()
      gato.RobarCarta()
    }

    /** Verificamos que a cada mazo de los jugadores se les descontó la carta robada */
    assert(hue.getMazo() == mazoTrasRobo)
    assert(gato.getMazo() == mazoTrasRobo)

    /** Verificamos que los jugadores robaron las 10 ultimas cartas, las cuales serían las de manoEsperada pero
     * en reverse, dado que las cartas se sacan desde lo ultimo del array hacia atrás */
    assert(hue.getMano() == manoEsperada1.reverse)
    assert(gato.getMano() == manoEsperada2.reverse)
  }

  test("Consultar Mano"){
    /** luego como sabemos que los otros metodos para agregar cartas a la mano funcionan, solo estableceremos
     * una mano que tienen en cierto momento del juego los 2 jugadores hue y gato
     * recordando que la mano que tendrán ambos es:
     *
     * manoEsperada = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     * carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
     */
    gato.setMano(manoEsperada2)

    gato.ConsultarMano()
  }

  test("Colocar Carta") {

    //COMPUTADORA
    /**
     * Para comprobar si este método funciona, primero se comprueba que inicialmente
     * las zonas del tablero están vacías, para ello se usarán las secciones del tablero
     * definidas en los jugadores
     */

    //Clase Computadora:
    hue.getCartasEnTableroClima().isEmpty
    hue.getCartasEnTableroCuerpo().isEmpty
    hue.getCartasEnTableroDistancia().isEmpty
    hue.getCartasEnTableroDistancia().isEmpty
    hue.getCartasEnTableroAsedio().isEmpty

    /** luego como sabemos que los otros metodos para agregar cartas a la mano funcionan, solo estableceremos
     * una mano que tienen en cierto momento del juego los 2 jugadores hue y gato
     * recordando que la mano que tendrán ambos es:
     *
     * manoEsperada = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     * carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
     */
    hue.setMano(manoEsperada1)

    /** Como el computador solo pone cartas de la mano, sabemos que esta sabe que cartas puede o no poner,
     * mientras que jugador puede consultar su mano con una función, por lo que también sabe que cartas
     * puede colocar en el tablero, de otra forma si coloca una carta que no está en su mano habría
     * errores de ejecución
     */

    /** verificamos que al colocar una carta esta se agrega al arreglo que representa al tablero y se quita
     * de la mano */

    //hue coloca 2 cartas de Clima
    hue.ColocarCarta(carta_C4)
    assert(hue.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2, carta_U7
      /** , carta_C4 */ , carta_U2, carta_U3, carta_C7))
    assert(hue.getCartasEnTableroClima() == ArrayBuffer(carta_C4))

    hue.ColocarCarta(carta_C2)  // La carta C2 no se juega ya que solo se puede colocar 1 carta clima en el tablero
    assert(hue.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_U7
      /** , carta_C4 */, carta_U2, carta_U3, carta_C7, carta_C2))
    assert(hue.getCartasEnTableroClima() == ArrayBuffer(carta_C4))

    //hue coloca 2 cartas de Unidad Cuerpo a Cuerpo
    hue.ColocarCarta(carta_U2)
    assert(hue.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1
      , carta_U7

      /** , carta_C4 , carta_U2 */
      , carta_U3, carta_C7, carta_C2))
    assert(hue.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))

    hue.ColocarCarta(carta_U3)
    assert(hue.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1
      , carta_U7

      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(hue.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2, carta_U3))

    //hue coloca 1 carta de Unidad Distancia
    hue.ColocarCarta(carta_U7)
    assert(hue.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1

      /**  , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7,carta_C2))
    assert(hue.getCartasEnTableroDistancia() == ArrayBuffer(carta_U7))

    //hue coloca 2 cartas de Unidad Asedio
    hue.ColocarCarta(carta_U16)
    assert(hue.getMano() == ArrayBuffer(/** carta_U16 , */
      carta_U13, carta_U14, carta_C1

      /** , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(hue.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16))

    hue.ColocarCarta(carta_U13)
    assert(hue.getMano() == ArrayBuffer(/** carta_U16, carta_U13 , */
      carta_U14, carta_C1

      /** , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(hue.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16, carta_U13))


    //USUARIO
    /**
     * Para comprobar si este método funciona, primero se comprueba que inicialmente
     * las zonas del tablero están vacías, para ello se usarán las secciones del tablero
     * definidas en los jugadores, ya que aún no se implementa el tablero.
     */

    //Clase Usuario:
    gato.getCartasEnTableroClima().isEmpty
    gato.getCartasEnTableroCuerpo().isEmpty
    gato.getCartasEnTableroDistancia().isEmpty
    gato.getCartasEnTableroDistancia().isEmpty
    gato.getCartasEnTableroAsedio().isEmpty

    /** luego como sabemos que los otros metodos para agregar cartas a la mano funcionan, solo estableceremos
     * una mano que tienen en cierto momento del juego los 2 jugadores hue y gato
     * recordando que la mano que tendrán ambos es:
     *
     * manoEsperada = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     * carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
     */
    gato.setMano(manoEsperada2)

    /** Como el computador solo pone cartas de la mano, sabemos que esta sabe que cartas puede o no poner,
     * mientras que jugador puede consultar su mano con una función, por lo que también sabe que cartas
     * puede colocar en el tablero, de otra forma si coloca una carta que no está en su mano habría
     * errores de ejecución
     */

    /** verificamos que al colocar una carta esta se agrega al arreglo que representa al tablero y se quita
     * de la mano */

    //gato coloca 2 cartas de Clima
    gato.ColocarCarta(carta_C4)
    assert(gato.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2, carta_U7

      /** , carta_C4 */
      , carta_U2, carta_U3, carta_C7))
    assert(gato.getCartasEnTableroClima() == ArrayBuffer(carta_C4))

    gato.ColocarCarta(carta_C2)
    assert(gato.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1
      , carta_U7

      /** , carta_C4 */
      , carta_U2, carta_U3, carta_C7, carta_C2))
    assert(hue.getCartasEnTableroClima() == ArrayBuffer(carta_C4))

    //gato coloca 2 cartas de Unidad Cuerpo a Cuerpo
    gato.ColocarCarta(carta_U2)
    assert(gato.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1

      , carta_U7

      /** , carta_C4 , carta_U2 */
      , carta_U3, carta_C7, carta_C2))
    assert(gato.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))

    gato.ColocarCarta(carta_U3)
    assert(gato.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1

      , carta_U7

      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(gato.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2, carta_U3))

    //hue coloca 1 carta de Unidad Distancia
    gato.ColocarCarta(carta_U7)
    assert(gato.getMano() == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1

      /** , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(gato.getCartasEnTableroDistancia() == ArrayBuffer(carta_U7))

    //gato coloca 2 cartas de Unidad Asedio
    gato.ColocarCarta(carta_U16)
    assert(gato.getMano() == ArrayBuffer(/** carta_U16 , */
      carta_U13, carta_U14, carta_C1

      /** , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(gato.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16))

    gato.ColocarCarta(carta_U13)
    assert(gato.getMano() == ArrayBuffer(/** carta_U16, carta_U13 , */
      carta_U14, carta_C1

      /** , carta_U7 */
      /** , carta_C4 , carta_U2 , carta_U3 */
      , carta_C7, carta_C2))
    assert(gato.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16, carta_U13))
  }
}
