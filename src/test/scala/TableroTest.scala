package cl.uchile.dcc

import gwent.Carta.{AbstractCarta, CartaT, CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia}
import gwent.Jugador.{Computadora, Usuario}
import gwent.Tablero.TableroJuego
import scala.collection.mutable.ArrayBuffer

class TableroTest extends munit.FunSuite{

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

  /** El límite de jugadores será 1 de cda uno en la implementación, pero para efectos del testing crearemos
   * cuantos sean necesarios para verificar los métodos
   */
  var hue: Computadora = null
  var gato: Usuario = null

  // mazo que tendrán ambos jugadores antes de barajar el mazo:
  var mazoOrdenado: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mano esperada tras el robo de 10 cartas:
  var manoEsperada1: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var manoEsperada2: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)

  // mazo esperado tras el robo de 10 cartas:
  var mazoTrasRobo: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](100)
  var arregloVacio: ArrayBuffer[CartaT] = new ArrayBuffer[CartaT](1)


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
    carta_C2 = new CartaClima("Nombre igual 2.3", "Clima", "habilidad 2.3")
    carta_C3 = new CartaClima("Nombre igual 2.3", "Clima", "habilidad 2.3")
    carta_C4 = new CartaClima("Nombre 4", "Clima", "Efecto 2")
    carta_C5 = new CartaClima("mismo Nombre", "Clima", "misma habilidad")
    carta_C6 = new CartaClima("mismo Nombre", "Clima", "misma habilidad")
    carta_C7 = new CartaClima("Nombre C7", "Clima", "habilidad 7")

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

    manoEsperada1 = ArrayBuffer(carta_U16, carta_U13, carta_U12, carta_C1, carta_C2,
      carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
    manoEsperada2 = ArrayBuffer(carta_U16, carta_U13, carta_U12, carta_C1, carta_C2,
      carta_U7, carta_C4, carta_U2, carta_U3, carta_C7)
  }

  test("Setters y Getters") {

    Tablero.setCCartasEnTableroCuerpo(mazoOrdenado)
    Tablero.setCCartasEnTableroDistancia(mazoOrdenado)
    Tablero.setCCartasEnTableroAsedio(mazoOrdenado)
    Tablero.setUCartasEnTableroCuerpo(mazoOrdenado)
    Tablero.setUCartasEnTableroDistancia(mazoOrdenado)
    Tablero.setUCartasEnTableroAsedio(mazoOrdenado)

    assert(Tablero.getCCartasEnTableroCuerpo() == mazoOrdenado)
    assert(Tablero.getCCartasEnTableroDistancia() == mazoOrdenado)
    assert(Tablero.getCCartasEnTableroAsedio() == mazoOrdenado)
    assert(Tablero.getUCartasEnTableroCuerpo() == mazoOrdenado)
    assert(Tablero.getUCartasEnTableroDistancia() == mazoOrdenado)
    assert(Tablero.getUCartasEnTableroAsedio() == mazoOrdenado)

    Tablero.setTurnoJugador(hue)
    assert(Tablero.getTurnoJugador() == hue)

    Tablero.setTurnoJugador(gato)
    assert(Tablero.getTurnoJugador() == gato)
  }

  test("Actualizar cartas en el tablero"){

    /** Ambos Jugadores tendrán la misma mano:
     * manoEsperada1 = ArrayBuffer(carta_U16, carta_U13, carta_U14, carta_C1, carta_C2,
     *  carta_U7, carta_C4, carta_U2, carta_U3, carta_C7) */
    hue.setMano(manoEsperada1)
    gato.setMano(manoEsperada2)

    /** Comprobamos que el tablero tiene todas las zonas vacías */
    assert(Tablero.getCCartasEnTableroCuerpo().isEmpty)
    assert(Tablero.getCCartasEnTableroDistancia().isEmpty)
    assert(Tablero.getCCartasEnTableroAsedio().isEmpty)
    assert(Tablero.getUCartasEnTableroCuerpo().isEmpty)
    assert(Tablero.getUCartasEnTableroDistancia().isEmpty)
    assert(Tablero.getUCartasEnTableroAsedio().isEmpty)
    assert(Tablero.getCartasEnTableroClima().isEmpty)

    /** Para este test partirá hue jugando cartas (el orden no afecta la funcionalidad de los test) */
    Tablero.setTurnoJugador(hue)

    /** Colocar en tablero Cartas de Unidad para la clase Computadora*/
    // Carta de Cuerpo a Cuerpo
    hue.ColocarCarta(carta_U2)
    assert(hue.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))

    // Carta de Distancia
    hue.ColocarCarta(carta_U12)
    assert(hue.getCartasEnTableroDistancia() == ArrayBuffer(carta_U12))

    // Carta de Asedio
    hue.ColocarCarta(carta_U16)
    assert(hue.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16))

    // Carta de Clima
    hue.ColocarCarta(carta_C2)
    assert(hue.getCartasEnTableroClima() == ArrayBuffer(carta_C2))

    Tablero.ActualizarCartasTablero()
    assert(Tablero.getCCartasEnTableroDistancia() == ArrayBuffer(carta_U12))
    assert(Tablero.getCCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))
    assert(Tablero.getCCartasEnTableroAsedio() == ArrayBuffer(carta_U16))
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer(carta_C2))

    /** Termina el turno de la computadora y comienza la del usuario */
    Tablero.setTurnoJugador(gato)

    /** Colocar en tablero Cartas de Unidad para la clase Usuario */
    // Carta de Cuerpo a Cuerpo
    gato.ColocarCarta(carta_U2)
    assert(gato.getCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))

    // Carta de Distancia
    gato.ColocarCarta(carta_U12)
    assert(gato.getCartasEnTableroDistancia() == ArrayBuffer(carta_U12))

    // Carta de Asedio
    gato.ColocarCarta(carta_U16)
    assert(gato.getCartasEnTableroAsedio() == ArrayBuffer(carta_U16))

    // Carta de Clima
    gato.ColocarCarta(carta_C7)
    assert(gato.getCartasEnTableroClima() == ArrayBuffer(carta_C7))

    Tablero.ActualizarCartasTablero()
    assert(Tablero.getUCartasEnTableroDistancia() == ArrayBuffer(carta_U12))
    assert(Tablero.getUCartasEnTableroCuerpo() == ArrayBuffer(carta_U2))
    assert(Tablero.getUCartasEnTableroAsedio() == ArrayBuffer(carta_U16))
    // Como el primer jugador ya ocupó el espacio de Clima:
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer(carta_C2))

    //En cambio si este está vacío:
    Tablero.setCartasEnTableroClima(arregloVacio)

    // gato si puede colocar su carta en la zona de clima mientras es su turno
    Tablero.ActualizarCartasTablero()
    assert(Tablero.getCartasEnTableroClima() == ArrayBuffer(carta_C7))

  }
}
