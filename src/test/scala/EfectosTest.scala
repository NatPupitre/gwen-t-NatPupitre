package cl.uchile.dcc

import gwent.Carta.{CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia, CartaT}
import gwent.Jugador.{Computadora, Jugador, Usuario}
import gwent.Tablero.TableroJuego

import cl.uchile.dcc.gwent.Efectos.EfectosClima.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, ParaTestSInEfectos}
import cl.uchile.dcc.gwent.Efectos.EfectosUnidad.{RefuerzoMoral, SinEfecto, VinculoEstrecho}

import scala.collection.mutable.ArrayBuffer

class EfectosTest extends munit.FunSuite {

  /** Tablero con turnos y registro de cartas a colocar */
  var Tablero: TableroJuego = null

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

  // Efectos
  var SinE: SinEfecto = null
  var ClimaD: ClimaDespejado = null
  var EscarchaM: EscarchaMordiente = null
  var LluviaT: LluviaTorrencial = null
  var NieblaI: NieblaImpenetrable = null
  var RefuerzoM: RefuerzoMoral = null
  var VinculoE: VinculoEstrecho = null

  /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
   * cuantos sean necesarios para verificar los métodos
   */
  var hue: Computadora = null
  var gato: Usuario = null

  // mazo que tendrán ambos jugadores antes de barajar el mazo:
  var mazoOrdenado: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mano esperada tras el robo de 10 cartas:
  var cartasEnAsedio1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var cartasEnCuerpo1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var cartasEnDistancia1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var cartasEnAsedio2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var cartasEnCuerpo2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var cartasEnDistancia2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  var manoHue: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var manoGato: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  var manoHueSinEfecto: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var manoGatoSinEfecto: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)


  override def beforeEach(context: BeforeEach): Unit = {

    SinE = new SinEfecto
    ClimaD = new ClimaDespejado
    EscarchaM = new EscarchaMordiente
    LluviaT = new LluviaTorrencial
    NieblaI = new NieblaImpenetrable

    RefuerzoM = new RefuerzoMoral
    VinculoE = new VinculoEstrecho

    /**
     * 18 cartas de Unidad repartidas equitativamente entre las 3 clasificaciones: Cuerpo, Distancia y Asedio
     * 2 cartas de cada 6 cartas de unidad de acuerdo a su clasificación
     * 7 cartas de clima
     * todas con su respectivo input:
     */
    carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
    carta_U2 = new CartaCuerpo("mismo Nombre", "Cuerpo", 11, RefuerzoM)
    carta_U3 = new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE)
    carta_U4 = new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE)
    carta_U5 = new CartaCuerpo("mismo Nombre", "Cuerpo", 14, VinculoE)
    carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)
    carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
    carta_U8 = new CartaDistancia("mismo Nombre", "Distancia", 17, RefuerzoM)
    carta_U9 = new CartaDistancia("mismo Nombre", "Distancia", 18, SinE)
    carta_U10 = new CartaDistancia("mismo Nombre", "Distancia", 19, SinE)
    carta_U11 = new CartaDistancia("mismo Nombre", "Distancia", 20, VinculoE)
    carta_U12 = new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)
    carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
    carta_U14 = new CartaAsedio("mismo Nombre", "Asedio", 23, RefuerzoM)
    carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
    carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
    carta_U17 = new CartaAsedio("mismo Nombre", "Asedio", 26, VinculoE)
    carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)

    carta_C1 = new CartaClima("Nombre 1", "Clima", ClimaD)
    carta_C2 = new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)
    carta_C3 = new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)
    carta_C4 = new CartaClima("Nombre 4", "Clima", ClimaD)
    carta_C5 = new CartaClima("mismo Nombre", "Clima", LluviaT)
    carta_C6 = new CartaClima("mismo Nombre", "Clima", LluviaT)
    carta_C7 = new CartaClima("Nombre C7", "Clima", NieblaI)

    /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
     * cuantos sean necesarios para verificar los métodos
     */
    hue = new Computadora("H.U.E", "arriba", 0)
    gato = new Usuario("Gastón Gatuso", "abajo", 0)

    /** Tablero con los 2 jugadores */
    Tablero = new TableroJuego(gato, hue)

    /** Definición de los elementos en los mazos y manos antes descritos */
    mazoOrdenado = ArrayBuffer(carta_U1, carta_U2, carta_U3, carta_U4, carta_U17, carta_U18, carta_U7,
      carta_U8, carta_C4, carta_U10, carta_U11, carta_U12, carta_U13,
      carta_U14, carta_U15, carta_U16, carta_U5, carta_U6, carta_C1,
      carta_C2, carta_C3, carta_U9, carta_C5, carta_C6, carta_C7)

    manoHue = ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14, carta_U17, carta_C1, carta_C2,
      carta_C3, carta_C4, carta_C5, carta_C6, carta_C7)

    manoGato = ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14, carta_U17, carta_C1, carta_C2,
      carta_C3, carta_C4, carta_C5, carta_C6, carta_C7)

    manoHueSinEfecto = ArrayBuffer(carta_U1, carta_U7, carta_U13)

    manoGatoSinEfecto = ArrayBuffer(carta_U1, carta_U7, carta_U13)

    cartasEnAsedio1 = ArrayBuffer(carta_U13, carta_U15, carta_U16, carta_U18)
    cartasEnCuerpo1 = ArrayBuffer(carta_U1, carta_U3, carta_U4, carta_U6)
    cartasEnDistancia1 = ArrayBuffer(carta_U7, carta_U9, carta_U10, carta_U12)

    cartasEnAsedio2 = ArrayBuffer(carta_U13, carta_U15, carta_U16, carta_U18)
    cartasEnCuerpo2 = ArrayBuffer(carta_U1, carta_U3, carta_U4, carta_U6)
    cartasEnDistancia2 = ArrayBuffer(carta_U7, carta_U9, carta_U10, carta_U12)

    cartasEnCuerpo2 = ArrayBuffer(carta_U1, carta_U3, carta_U4, carta_U6)

    cartasEnDistancia2 = ArrayBuffer(carta_U7, carta_U9, carta_U10, carta_U12)
    // Los jugadores tendrán la misma mano

    gato.setMano(manoGato)
    hue.setMano(manoHue)

    // Los jugadores tendrán las mismas cartas en sus respectivas zonas de cuerpo, Asedio y Distancia

    gato.setCartasEnTableroAsedio(cartasEnAsedio1)
    gato.setCartasEnTableroCuerpo(cartasEnCuerpo1)
    gato.setCartasEnTableroDistancia(cartasEnDistancia1)

    hue.setCartasEnTableroAsedio(cartasEnAsedio2)
    hue.setCartasEnTableroCuerpo(cartasEnCuerpo2)
    hue.setCartasEnTableroDistancia(cartasEnDistancia2)

  }

  test("Refuerzo Moral") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de cuerpo a cuerpo con el efecto Refuerzo Moral
     * (carta_U2 = new CartaCuerpo("mismo Nombre", "Cuerpo", 11, RefuerzoM))
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * carta_U3 = new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE)
     * carta_U4 = new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE)
     * carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)
     */
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    gato.ColocarCarta(carta_U2, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(/** carta_U2, */
      carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.

    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 11, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 14, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 16, SinE),
      carta_U2))

    // turno de Hue
    Tablero.setTurnoJugador(hue)

    /** hue va a jugar una carta de Distancia con el efecto Refuerzo Moral
     * carta_U8 = new CartaDistancia("mismo Nombre", "Distancia", 17, RefuerzoM)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * carta_U9 = new CartaDistancia("mismo Nombre", "Distancia", 18, SinE)
     * carta_U10 = new CartaDistancia("mismo Nombre", "Distancia", 19, SinE)
     * carta_U12 = new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)
     */
    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    hue.ColocarCarta(carta_U8, Tablero)

    // quitamos la carta_U8 de la mano
    assert(hue.getMano() == ArrayBuffer(carta_U2, carta_U5,

      /** carta_U8 */
      carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.


    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 17, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 20, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 22, SinE),
      carta_U8))


    // Turno de gato
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de Asedio con el efecto Refuerzo Moral
     * carta_U14 = new CartaAsedio("mismo Nombre", "Asedio", 23, RefuerzoM)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
     * carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
     * carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)
     */
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    gato.ColocarCarta(carta_U14, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(/** carta_U2, */
      carta_U5, carta_U8, carta_U11,

      /** carta_U14, */
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.

    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 23, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 26, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 28, SinE),
      carta_U14))
  }

  test("Vinculo Estrecho") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de cuerpo a cuerpo con el efecto Vinculo Estrecho
     * carta_U5 = new CartaCuerpo("mismo Nombre", "Cuerpo", 14, VinculoE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * carta_U3 = new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE)
     * carta_U4 = new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE)
     * carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)
     */
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    gato.ColocarCarta(carta_U5, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2,

      /** carta_U5, */
      carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.

    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    ( // Esta carta tiene nombre distinto por lo que a ella no se le aplica el efecto
      new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 24, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 26, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 30, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 28, VinculoE)))


    // turno de Hue
    Tablero.setTurnoJugador(hue)

    /** hue va a jugar una carta de Distancia con el efecto Vinculo Estrecho
     * carta_U11 = new CartaDistancia("mismo Nombre", "Distancia", 20, VinculoE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * carta_U9 = new CartaDistancia("mismo Nombre", "Distancia", 18, SinE)
     * carta_U10 = new CartaDistancia("mismo Nombre", "Distancia", 19, SinE)
     * carta_U12 = new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)
     */
    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    hue.ColocarCarta(carta_U11, Tablero)

    // quitamos la carta_U8 de la mano
    assert(hue.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8,

      /** carta_U11, */
      carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.


    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    ( // Esta carta tiene nombre distinto por lo que a ella no se le aplica el efecto
      new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 36, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 38, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 42, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 40, VinculoE)))


    // Turno de gato
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de Asedio con el efecto Vinculo Estrecho
     * carta_U17 = new CartaAsedio("mismo Nombre", "Asedio", 26, VinculoE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
     * carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
     * carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)
     */
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    gato.ColocarCarta(carta_U17, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2,

      /** carta_U5, */
      carta_U8, carta_U11, carta_U14,

      /** carta_U17, */
      carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //este efecto añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma, por lo que el tablero
    // ahora debería ser así:.

    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 48, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 50, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 54, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 52, VinculoE)))
  }

  test("Sin Efecto") {

    /** ahora gato y hue contienen las cartas:
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE) */

    gato.setMano(manoGatoSinEfecto)
    hue.setMano(manoHueSinEfecto)

    // ahora todas estas  cartas están en el tablero:
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de cuerpo a cuerpo SinEfecto
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * carta_U3 = new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE)
     * carta_U4 = new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE)
     * carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)
     */
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    gato.ColocarCarta(carta_U1, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(/** carta_U1, */
      carta_U7, carta_U13))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //Como no tiene ningún efecto, las cartas deben permanecer iguales junto a la carta que se jugó:
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE),
      new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)))


    // turno de Hue
    Tablero.setTurnoJugador(hue)

    /** hue va a jugar una carta de Distancia sin efecto
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * carta_U9 = new CartaDistancia("mismo Nombre", "Distancia", 18, SinE)
     * carta_U10 = new CartaDistancia("mismo Nombre", "Distancia", 19, SinE)
     * carta_U12 = new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)
     */
    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    hue.ColocarCarta(carta_U7, Tablero)

    // quitamos la carta_U8 de la mano
    assert(hue.getMano() == ArrayBuffer(carta_U1,

      /** carta_U7, */
      carta_U13))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //Como no tiene ningún efecto, las cartas deben permanecer iguales junto a la carta que se jugó:
    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE),
      new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)))


    // Turno de gato
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de Asedio con el efecto Vinculo Estrecho
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
     * carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
     * carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)
     */
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    gato.ColocarCarta(carta_U13, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(/** carta_U1, */
      carta_U7

      /** , carta_U13 */))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    //Como no tiene ningún efecto, las cartas deben permanecer iguales junto a la carta que se jugó:
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE),
      new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)))
  }

  test("Escarcha Mordiente") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de clima con el efecto Escarcha Mordiente
     * carta_C2 = new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U1 = new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE)
     * carta_U3 = new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE)
     * carta_U4 = new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE)
     * carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)
     */
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    assert(Tablero.getCCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    // Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.
    gato.ColocarCarta(carta_C2, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1

      /** , carta_C2 */
      , carta_C3, carta_C4, carta_C5, carta_C6, carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    /** este efecto establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.
     * Por lo que el tablero ahora debería ser así: */

    // Verificamos que la carta de clima está en el tablero
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer
    (new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)))

    //Verificamos que ahora el efecto está activo
    assert(Tablero.getEfectoActivo() == EscarchaM)

    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    ( // Esta carta tiene nombre distinto por lo que a ella no se le aplica el efecto
      new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE)))

    assert(Tablero.getCCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 1, SinE)))

    //Verificamos que las cartas de las otras zonas no fueron editadas
    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    /** Ahora veremos que este efecto se puede revertir */

    //revertimos el efecto
    Tablero.getEfectoActivo().RevertirEfecto(Tablero)

    //Verificamos que al colocarla los efectos se revirtieron
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))

    assert(Tablero.getCCartasEnTableroCuerpo() == ArrayBuffer
    (new CartaCuerpo("Nombre DISTINTO", "Cuerpo", 10, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 12, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 13, SinE),
      new CartaCuerpo("mismo Nombre", "Cuerpo", 15, SinE)))
  }

  test("Niebla Impenetrable") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de clima con el efecto Niebla impenetrable
     * carta_C7 = new CartaClima("Nombre C7", "Clima", NieblaI)
     * y recordemos que las cartas en la zona de cuerpo a cuerpo son:
     * carta_U7 = new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE)
     * carta_U9 = new CartaDistancia("mismo Nombre", "Distancia", 18, SinE)
     * carta_U10 = new CartaDistancia("mismo Nombre", "Distancia", 19, SinE)
     * carta_U12 = new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)
     */
    assert(Tablero.getUCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    // Niebla impenetrable: Establece el valor de fuerza de todas las cartas de combate a distancia a 1
    gato.ColocarCarta(carta_C7, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5, carta_C6

      /** , carta_C7 */))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    /** este efecto establece el valor de fuerza de todas las cartas de combate a distancia a 1 */

    // Verificamos que la carta de clima está en el tablero
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer
    (new CartaClima("Nombre C7", "Clima", NieblaI)))

    //Verificamos que ahora el efecto está activo
    assert(Tablero.getEfectoActivo() == NieblaI)

    assert(Tablero.getUCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE)))

    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 1, SinE)))

    //Verificamos que las cartas de las otras zonas no fueron editadas
    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)

    /** Ahora veremos que este efecto se puede revertir */

    //revertimos el efecto
    Tablero.getEfectoActivo().RevertirEfecto(Tablero)

    //Verificamos que al colocarla los efectos se revirtieron
    assert(Tablero.getUCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))

    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer
    (new CartaDistancia("Nombre DISTINTO", "Distancia", 16, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 18, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 19, SinE),
      new CartaDistancia("mismo Nombre", "Distancia", 21, SinE)))
  }

  test("Lluvia Torrencial") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de clima con el efecto Lluvia torrencial
     * carta_C6 = new CartaClima("mismo Nombre", "Clima", LluviaT)
     * y recordemos que las cartas en la zona de aseddio son:
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
     * carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
     * carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)
     */
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    // Niebla impenetrable: Establece el valor de fuerza de todas las cartas de combate a distancia a 1
    gato.ColocarCarta(carta_C6, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5

      /** , carta_C6 */
      , carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    /** este efecto establece el valor de fuerza de todas las cartas de combate a distancia a 1 */

    // Verificamos que la carta de clima está en el tablero
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer
    (new CartaClima("mismo Nombre", "Clima", LluviaT)))

    //Verificamos que ahora el efecto está activo
    assert(Tablero.getEfectoActivo() == LluviaT)

    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE)))

    //Verificamos que las cartas de las otras zonas no fueron editadas
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    /** Ahora veremos que este efecto se puede revertir */

    //revertimos el efecto
    Tablero.getEfectoActivo().RevertirEfecto(Tablero)

    //Verificamos que al colocarla los efectos se revirtieron
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))
  }

  test("Clima Despejado") {

    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    // El jugador gato inicia
    Tablero.setTurnoJugador(gato)

    /** gato va a jugar una carta de clima con el efecto Lluvia torrencial, para luego jugar
     * una carta de clima despejado,y revertir el efecto.
     * carta_C6 = new CartaClima("mismo Nombre", "Clima", LluviaT)
     * y recordemos que las cartas en la zona de aseddio son:
     * carta_U13 = new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE)
     * carta_U15 = new CartaAsedio("mismo Nombre", "Asedio", 24, SinE)
     * carta_U16 = new CartaAsedio("mismo Nombre", "Asedio", 25, SinE)
     * carta_U18 = new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)
     */
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    // Niebla impenetrable: Establece el valor de fuerza de todas las cartas de combate a distancia a 1
    gato.ColocarCarta(carta_C6, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17, carta_C1, carta_C2, carta_C3, carta_C4, carta_C5

      /** , carta_C6 */
      , carta_C7))

    // se actualiza la jugada en el tablero
    Tablero.ActualizarCartasTablero()

    /** este efecto establece el valor de fuerza de todas las cartas de combate a distancia a 1 */

    // Verificamos que la carta de clima está en el tablero
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer
    (new CartaClima("mismo Nombre", "Clima", LluviaT)))

    //Verificamos que ahora el efecto está activo
    assert(Tablero.getEfectoActivo() == LluviaT)

    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 1, SinE)))

    /** Ahora veremos que este efecto se puede revertir mediante la carta Clima Despejado
     * carta_C1 = new CartaClima("Nombre 1", "Clima", ClimaD)
     * */

    // Clima despejado: Elimina todos los efectos climáticos actualmente en efecto en el campo de batalla.
    gato.ColocarCarta(carta_C1, Tablero)

    // quitamos la carta_U2 de la mano
    assert(gato.getMano() == ArrayBuffer(carta_U2, carta_U5, carta_U8, carta_U11, carta_U14,
      carta_U17

      /** , carta_C1 */
      , carta_C2, carta_C3, carta_C4, carta_C5

      /** , carta_C6 */
      , carta_C7))

    //Verificamos que al colocarla los efectos se revirtieron
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer
    (new CartaAsedio("Nombre DISTINTO", "Asedio", 22, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 24, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 25, SinE),
      new CartaAsedio("mismo Nombre", "Asedio", 27, SinE)))

    Tablero.ActualizarCartasTablero()

    //Ahora las cartas están como antes de aplicar las cartas de clima
    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    carta_C1.getEfecto().RevertirEfecto(Tablero)
  }

  test("Para Test Sin Efectos"){

    /** Este efecto fue diseñado para los otros test y solo retorna un print sin cambiar nada en el tablero */
    var CartaSinEfecto = new CartaAsedio("Nula", "Asedio", 7, new ParaTestSInEfectos)

    hue.setMano(ArrayBuffer(CartaSinEfecto))
    // ahora todas estas  cartas están en el tablero
    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    Tablero.setTurnoJugador(hue)
    hue.ColocarCarta(CartaSinEfecto, Tablero)

    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)

    CartaSinEfecto.getEfecto().AplicarEfecto(Tablero)
    CartaSinEfecto.getEfecto().RevertirEfecto(Tablero)

    Tablero.ActualizarCartasTablero()

    assert(Tablero.getUCartasEnTableroAsedio() == cartasEnAsedio1)
    assert(Tablero.getCCartasEnTableroAsedio() == cartasEnAsedio2)
    assert(Tablero.getUCartasEnTableroCuerpo() == cartasEnCuerpo1)
    assert(Tablero.getCCartasEnTableroCuerpo() == cartasEnCuerpo2)
    assert(Tablero.getUCartasEnTableroDistancia() == cartasEnDistancia1)
    assert(Tablero.getCCartasEnTableroDistancia() == cartasEnDistancia2)
  }

  test("Excepciones"){

    /**Las efectos de clima no se aplican mediante este input:
     * (jugador: Jugador, carta: CartaT, tab: TableroJuego)
     * eso lo hacen las cartas de unidad, pues de invocarse de esta foma, significa que la carta de Unidad
     * posee un efecto de clima y eso no es correcto*/

    carta_C1.getEfecto().AplicarEfecto(hue,carta_C1,Tablero)

    /** Al colocar una carta de Clima es Análogo*/

    carta_C1.getEfecto().ColocarCarta(hue,carta_C1,Tablero)


    /** Los efectos de las cartas de Unidad no son revertibles, y también se aplican a través de un constructor
     * diferente, por lo que un uso de otro constructor implica que la carta de Clima posee un efecto de
     * unidad por lo que se atrapa la excepción imprimiendo los siguiuente mensajes*/

    carta_U1.getEfecto().AplicarEfecto(Tablero)

    carta_U1.getEfecto().RevertirEfecto(Tablero)

    carta_U1.getEfecto().ColocarCarta(carta_U1, Tablero)

  }

}
