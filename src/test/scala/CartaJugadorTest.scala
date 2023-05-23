package cl.uchile.dcc

import gwent.Carta.{Carta, CartaClima, CartaUnidad}
import gwent.Jugador.{Computadora, Jugador, Usuario}

import scala.collection.mutable.ArrayBuffer

class CartaJugadorTest extends munit.FunSuite {

  /**
   * Cartas de una baraja estándar
   */

  // 18 Cartas, clasificación: Unidad
  var carta_U1: CartaUnidad = null
  var carta_U2: CartaUnidad = null
  var carta_U3: CartaUnidad = null
  var carta_U4: CartaUnidad = null
  var carta_U5: CartaUnidad = null
  var carta_U6: CartaUnidad = null
  var carta_U7: CartaUnidad = null
  var carta_U8: CartaUnidad = null
  var carta_U9: CartaUnidad = null
  var carta_U10: CartaUnidad = null
  var carta_U11: CartaUnidad = null
  var carta_U12: CartaUnidad = null
  var carta_U13: CartaUnidad = null
  var carta_U14: CartaUnidad = null
  var carta_U15: CartaUnidad = null
  var carta_U16: CartaUnidad = null
  var carta_U17: CartaUnidad = null
  var carta_U18: CartaUnidad = null

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
  var mazoOrdenado: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  // mazo desordenado para el robo de cartas:
  var mazoDesodenado1: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var mazoDesodenado2: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  // mano esperada tras el robo de 10 cartas:
  var manoEsperada1: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)
  var manoEsperada2: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)

  // mazo esperado tras el robo de 10 cartas:
  var mazoTrasRobo: ArrayBuffer[Carta] = new ArrayBuffer[Carta](100)



  override def beforeEach(context: BeforeEach): Unit = {

    /**
     * 18 cartas de Unidad repartidas equitativamente entre las 3 clasificaciones: Cuerpo, Distancia y Asedio
     * 2 cartas de cada 6 cartas de unidad de acuerdo a su clasificación
     * 7 cartas de clima
     * todas con su respectivo input:
     */
    carta_U1 = new CartaUnidad("Nombre 1", "Cuerpo", 1, "habilidad 1")
    carta_U2 = new CartaUnidad("Nombre igual 2.3", "Cuerpo", 23, "habilidad 2.3")
    carta_U3 = new CartaUnidad("Nombre igual 2.3", "Cuerpo", 23, "habilidad 2.3")
    carta_U4 = new CartaUnidad("Nombre 4", "Cuerpo", 1, "habilidad 4")
    carta_U5 = new CartaUnidad("mismo Nombre", "Cuerpo", 56, "misma habilidad")
    carta_U6 = new CartaUnidad("mismo Nombre", "Cuerpo", 56, "misma habilidad")
    carta_U7 = new CartaUnidad("Nombre igual 7.8", "Distancia", 78, "habilidad 7.8")
    carta_U8 = new CartaUnidad("Nombre igual 7.8", "Distancia", 78, "habilidad 7.8")
    carta_U9 = new CartaUnidad("Nombre 1", "Distancia", 9, "habilidad 1")
    carta_U10 = new CartaUnidad("Nombre 1", "Distancia", 10, "habilidad 1")
    carta_U11 = new CartaUnidad("Nombre 1", "Distancia", 11, "habilidad 1")
    carta_U12 = new CartaUnidad("Nombre 1", "Distancia", 12, "habilidad 1")
    carta_U13 = new CartaUnidad("Nombre igual 13.14", "Asedio", 1314, "habilidad 13.14")
    carta_U14 = new CartaUnidad("Nombre igual 13.14", "Asedio", 1314, "habilidad 13.14")
    carta_U15 = new CartaUnidad("Nombre 1", "Asedio", 15, "habilidad 1")
    carta_U16 = new CartaUnidad("Nombre 1", "Asedio", 16, "habilidad 1")
    carta_U17 = new CartaUnidad("Nombre 1", "Asedio", 17, "habilidad 1")
    carta_U18 = new CartaUnidad("Nombre 1", "Asedio", 18, "habilidad 1")

    carta_C1 = new CartaClima("Nombre 1", "Habilidad 1")
    carta_C2 = new CartaClima("Nombre igual 2.3", "habilidad 2.3")
    carta_C3 = new CartaClima("Nombre igual 2.3", "habilidad 2.3")
    carta_C4 = new CartaClima("Nombre 4", "Efecto 2")
    carta_C5 = new CartaClima("mismo Nombre", "misma habilidad")
    carta_C6 = new CartaClima("mismo Nombre", "misma habilidad")
    carta_C7 = new CartaClima("Nombre C7", "habilidad 7")

    /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
     * cuantos sean necesarios para verificar los métodos
     */
    hue = new Computadora("H.U.E", "arriba", 0)
    jiu = new Computadora("H.U.E", "arriba", 0)  // 2 Computadoras iguales

    jarvis = new Computadora("J.A.R.V.I.S", "arriba", 0) // 1 computadora distinta

    gato = new Usuario("Gastón Gatuso", "abajo", 0)
    gatito = new Usuario("Gastón Gatuso", "abajo", 0) // 2 usuarios iguales

    gatoBotas = new Usuario("Gato con Botas", "abajo", 0) // 1 usuarios distinto

    gatoBot1 = new Computadora("gatoBot", "arriba", 0)
    gatoBot2 = new Usuario("gatoBot", "arriba", 0) // 2 Jugadores, mismos inputs, distintas clases

    /** Definición de los elementos en los mazos y manos antes descritos */
    mazoOrdenado = ArrayBuffer(carta_U1, carta_U2, carta_U3, carta_U4, carta_U17, carta_U18, carta_U7,
                               carta_U8, carta_C4, carta_U10, carta_U11,  carta_U12, carta_U13,
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

    /** equals de la clase Unidad */
    // Ubicación Cuerpo
    assertEquals(carta_U2, carta_U3)
    assert(carta_U2.equals(carta_U3))
    assertEquals(new CartaUnidad("a", "b", 1, "c"),
                 new CartaUnidad("a", "b", 1, "c"))

    // Ubicación Distancia
    assertEquals(carta_U7, carta_U8)
    assert(carta_U7.equals(carta_U8))

    // Ubicación Asedio
    assertEquals(carta_U13, carta_U14)
    assert(carta_U13.equals(carta_U14))

    /** equals de la clase Unidad */
    assertEquals(carta_C2, carta_C3)
    assert(carta_C2.equals(carta_C3))
    assertEquals(new CartaClima("a", "b"),
      new CartaClima("a", "b"))

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

    // misma clase distintos inputs para cartas de Unidad
    assertNotEquals(carta_U1, carta_U4)
    assert(!carta_U1.equals(carta_U4))
    assertNotEquals(new CartaUnidad("a", "b", 1, "c"),
      new CartaUnidad("a", "b", 2, "c"))

    // misma clase distintos inputs para cartas de Clima
    assertNotEquals(carta_C1, carta_C5)
    assert(!carta_C1.equals(carta_C5))
    assertNotEquals(new CartaClima("a", "b"),
      new CartaClima("a", "c"))

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

    // distintas clase, mismos inputs (a excepción de Cartas, que tienen distinto número de inputs)
    assert(!carta_U1.equals(carta_C1)) // usa equals de clase cartaUnidad y carta_C1 es de clase cartaClima
    assert(!carta_C1.equals(carta_U1)) // usa equals de clase cartaClima y carta_U1 es de clase cartaUnidad

    assert(!gatoBot1.equals(gatoBot2)) // usa equals de clase Computadora  gatoBot2 es de clase Usuario
    assert(!gatoBot2.equals(gatoBot1)) // usa equals de clase Usuario  gatoBot1 es de clase Computadora
  }

  test("hashcode") {

    /** Si 2 elementos son iguales deberían tener el mismo hashcode y sin son distintas no */

    //Clase CartaUnidad
    assert(carta_U2.hashCode == carta_U3.hashCode)
    assert(carta_U1.hashCode != carta_U4.hashCode)

    //Clase CartaClima
    assert(carta_C2.hashCode == carta_C3.hashCode)
    assert(carta_C1.hashCode != carta_C5.hashCode)

    //Clase Computadora
    assert(hue.hashCode == jiu.hashCode)
    assert(hue.hashCode != jarvis.hashCode)

    //Clase Usuario
    assert(gato.hashCode == gatito.hashCode)
    assert(gato.hashCode != gatoBotas.hashCode)
  }

  test("getters") {

    /** Previamente se definió Carta_U1 con los siguientes inputs:
     * carta_U1 = new CartaUnidad("Nombre 1", "Cuerpo", 1, "habilidad 1")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaUnidad
     */
    assert(carta_U1.getNombre() == "Nombre 1")
    assert(carta_U1.getClasificacion() == "Unidad")
    assert(carta_U1.getUbicacion() == "Cuerpo")
    assert(carta_U1.getFuerza() == 1)
    assert(carta_U1.getHabilidad() == "habilidad 1")

    /** Previamente se definió Carta_C1 con los siguientes inputs:
     * carta_C1 = new CartaClima("Nombre 1", "Habilidad 1")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaClima
     */
    assert(carta_C1.getNombre() == "Nombre 1")
    assert(carta_C1.getClasificacion() == "Clima")
    assert(carta_C1.getUbicacion() == "Clima")
    assert(carta_C1.getEfecto() == "Habilidad 1")

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
  }

  test("setters") {

    /** Como se comprobó que los getters funcionan, se usarán para comprobar que los setters
     * también lo hacen
     */

    // Clase CartaUnidad
    carta_U5.setNombre("Distinto Nombre")
    assert(carta_U5.getNombre() == "Distinto Nombre")

    carta_U5.setClasificacion("Distinta Clasificacion")
    assert(carta_U5.getClasificacion() == "Distinta Clasificacion")

    carta_U5.setUbicacion("Distinta Ubicacion")
    assert(carta_U5.getUbicacion() == "Distinta Ubicacion")

    carta_U5.setFuerza(0)
    assert(carta_U5.getFuerza() == 0)

    carta_U5.setHabilidad("Distinta Habilidad")
    assert(carta_U5.getHabilidad() == "Distinta Habilidad")

    // Clase CartaClima
    carta_C5.setNombre("Distinto Nombre")
    assert(carta_C5.getNombre() == "Distinto Nombre")

    carta_C5.setClasificacion("Distinta Clasificacion")
    assert(carta_C5.getClasificacion() == "Distinta Clasificacion")

    carta_C5.setUbicacion("Distinta Ubicacion")
    assert(carta_C5.getUbicacion() == "Distinta Ubicacion")

    carta_C5.setEfecto("Distinto Efecto")
    assert(carta_C5.getEfecto() == "Distinto Efecto")

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
  }

  test("Barajar Mazo"){

    /** Ambos Jugadores tendrán el mismo mazo de 18 cartas */
    hue.mazo = mazoOrdenado
    gato.mazo = mazoOrdenado

    /**
     * Por como se definió se sabe que los mazos (mazoOrdenado) de ambos jugadores están ordenados, por lo que
     * se barajan con la funcion BarajarMazo y comprobamos que ya no son iguales a mazoOrdenado
     */
    hue.BarajarMazo()
    gato.BarajarMazo()

    assert(hue.mazo != mazoOrdenado)
    assert(gato.mazo != mazoOrdenado)

    /**
     * ahora verificamos que los elementos siguen estando ahí a pesar de que ya no tienen el mismo orden
     */
    //contienen la misma cantidad de elementos
    assert(hue.mazo.length == mazoOrdenado.length)
    assert(gato.mazo.length == mazoOrdenado.length)

    // contienen los mismos elementos
    assert(hue.mazo.toSet == mazoOrdenado.toSet)
    assert(gato.mazo.toSet == mazoOrdenado.toSet)

  }

  test("Robar Carta"){

    /** por como se definió robo de carta, los jugadores deberán robar los últimos elementos del
     * ArrayBuffer mazo, que en este caso será mazoDesordenaod, por lo que se tiene una mano esperada
     * (manoEsperada) tras el robo de cartas
     */
    hue.mazo = mazoDesodenado1
    gato.mazo = mazoDesodenado2

    // inicialmente se tiene la mano vacía

    assert(hue.mano.isEmpty)
    assert(gato.mano.isEmpty)

    /** hue y gato roban 10 cartas de su mazo desordenado (no usamos shuffle ya que sabemos que barajarCartas
     * funciona y conociendo sus mazos podemos conocer su mano tras el robo)
     */

    for (i <- 0 until 10) {
      hue.RobarCarta()
      gato.RobarCarta()
    }

    /** Verificamos que a cada mazo de los jugadores se les descontó la carta robada */
    assert(hue.mazo == mazoTrasRobo)
    assert(gato.mazo == mazoTrasRobo)

    /** Verificamos que los jugadores robaron las 10 ultimas cartas, las cuales serían las de manoEsperada pero
     * en reverse, dado que las cartas se sacan desde lo ultimo del array hacia atrás */
    assert(hue.mano == manoEsperada1.reverse)
    assert(gato.mano == manoEsperada2.reverse)
  }

  test("Colocar Carta") {

    //COMPUTADORA
    /**
     * Para comprobar si este método funciona, primero se comprueba que inicialmente
     * las zonas del tablero están vacías, para ello se usarán las secciones del tablero
     * definidas en los jugadores, ya que aún no se implementa el tablero.
     */

    //Clase Computadora:
    hue.CCartasEnTableroClima.isEmpty
    hue.CCartasEnTableroCuerpo.isEmpty
    hue.CCartasEnTableroDistancia.isEmpty
    hue.CCartasEnTableroDistancia.isEmpty
    hue.CCartasEnTableroAsedio.isEmpty

    /** luego como sabemos que los otros metodos para agregar cartas a la mano funcionan, solo estableceremos
     * una mano que tienen en cierto momento del juego los 2 jugadores hue y gato
     * recordando que la mano que tendrán ambos es:
     *
     * manoEsperada = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     *                            carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
     */
    hue.mano = manoEsperada1

    /** Como el computador solo pone cartas de la mano, sabemos que esta sabe que cartas puede o no poner,
     * mientras que jugador puede consultar su mano con una función, por lo que también sabe que cartas
     * puede colocar en el tablero, de otra forma si coloca una carta que no está en su mano habría
     * errores de ejecución
     */

    /** verificamos que al colocar una carta esta se agrega al arreglo que representa al tablero y se quita
     * de la mano */

    //hue coloca 2 cartas de Clima
    hue.ColocarCarta(carta_C4)
    assert(hue.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2, carta_U7
                                    /** , carta_C4 */, carta_U2, carta_U3, carta_C7))
    assert(hue.CCartasEnTableroClima == ArrayBuffer(carta_C4))

    hue.ColocarCarta(carta_C2)
    assert(hue.mano == ArrayBuffer(carta_U16, carta_U13 , carta_U14, carta_C1 /**, carta_C2 */, carta_U7
                                   /** , carta_C4 */, carta_U2, carta_U3, carta_C7))
    assert(hue.CCartasEnTableroClima == ArrayBuffer(carta_C4, carta_C2))

    //hue coloca 2 cartas de Unidad Cuerpo a Cuerpo
    hue.ColocarCarta(carta_U2)
    assert(hue.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 */, carta_U7
                                   /** , carta_C4 , carta_U2 */, carta_U3, carta_C7))
    assert(hue.CCartasEnTableroCuerpo == ArrayBuffer(carta_U2))

    hue.ColocarCarta(carta_U3)
    assert(hue.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 */, carta_U7
                                   /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(hue.CCartasEnTableroCuerpo == ArrayBuffer(carta_U2, carta_U3))

    //hue coloca 1 carta de Unidad Distancia
    hue.ColocarCarta(carta_U7)
    assert(hue.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                   /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(hue.CCartasEnTableroDistancia == ArrayBuffer(carta_U7))

    //hue coloca 2 cartas de Unidad Asedio
    hue.ColocarCarta(carta_U16)
    assert(hue.mano == ArrayBuffer(/** carta_U16 ,*/ carta_U13, carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                   /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(hue.CCartasEnTableroAsedio == ArrayBuffer(carta_U16))

    hue.ColocarCarta(carta_U13)
    assert(hue.mano == ArrayBuffer(/** carta_U16, carta_U13 ,*/ carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                   /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(hue.CCartasEnTableroAsedio == ArrayBuffer(carta_U16, carta_U13))


    //USUARIO
    /**
     * Para comprobar si este método funciona, primero se comprueba que inicialmente
     * las zonas del tablero están vacías, para ello se usarán las secciones del tablero
     * definidas en los jugadores, ya que aún no se implementa el tablero.
     */

    //Clase Usuario:
    gato.UCartasEnTableroClima.isEmpty
    gato.UCartasEnTableroCuerpo.isEmpty
    gato.UCartasEnTableroDistancia.isEmpty
    gato.UCartasEnTableroDistancia.isEmpty
    gato.UCartasEnTableroAsedio.isEmpty

    /** luego como sabemos que los otros metodos para agregar cartas a la mano funcionan, solo estableceremos
     * una mano que tienen en cierto momento del juego los 2 jugadores hue y gato
     * recordando que la mano que tendrán ambos es:
     *
     * manoEsperada = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     * carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
     */
    gato.mano = manoEsperada2

    /** Como el computador solo pone cartas de la mano, sabemos que esta sabe que cartas puede o no poner,
     * mientras que jugador puede consultar su mano con una función, por lo que también sabe que cartas
     * puede colocar en el tablero, de otra forma si coloca una carta que no está en su mano habría
     * errores de ejecución
     */

    /** verificamos que al colocar una carta esta se agrega al arreglo que representa al tablero y se quita
     * de la mano */

    //gato coloca 2 cartas de Clima
    gato.ColocarCarta(carta_C4)
    assert(gato.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2, carta_U7
                                    /** , carta_C4 */, carta_U2, carta_U3, carta_C7))
    assert(gato.UCartasEnTableroClima == ArrayBuffer(carta_C4))

    gato.ColocarCarta(carta_C2)
    assert(gato.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 */, carta_U7
                                    /** , carta_C4 */, carta_U2, carta_U3, carta_C7))
    assert(hue.CCartasEnTableroClima == ArrayBuffer(carta_C4, carta_C2))

    //gato coloca 2 cartas de Unidad Cuerpo a Cuerpo
    gato.ColocarCarta(carta_U2)
    assert(gato.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 */, carta_U7
                                    /** , carta_C4 , carta_U2 */, carta_U3, carta_C7))
    assert(gato.UCartasEnTableroCuerpo == ArrayBuffer(carta_U2))

    gato.ColocarCarta(carta_U3)
    assert(gato.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 */, carta_U7
                                    /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(gato.UCartasEnTableroCuerpo == ArrayBuffer(carta_U2, carta_U3))

    //hue coloca 1 carta de Unidad Distancia
    gato.ColocarCarta(carta_U7)
    assert(gato.mano == ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                  /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(gato.UCartasEnTableroDistancia == ArrayBuffer(carta_U7))

    //gato coloca 2 cartas de Unidad Asedio
    gato.ColocarCarta(carta_U16)
    assert(gato.mano == ArrayBuffer(/** carta_U16 , */carta_U13, carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                    /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(gato.UCartasEnTableroAsedio == ArrayBuffer(carta_U16))

    gato.ColocarCarta(carta_U13)
    assert(gato.mano == ArrayBuffer(/** carta_U16, carta_U13 , */carta_U14, carta_C1 /** , carta_C2 , carta_U7 */
                                    /** , carta_C4 , carta_U2 , carta_U3 */, carta_C7))
    assert(gato.UCartasEnTableroAsedio == ArrayBuffer(carta_U16, carta_U13))
  }
}
