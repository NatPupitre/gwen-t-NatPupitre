package cl.uchile.dcc

import gwent.Carta.Carta

class CartaTest extends munit.FunSuite {
  var carta_1: Carta = null
  var carta_2: Carta = null
  var carta_3: Carta = null

  override def beforeEach(context: BeforeEach): Unit = {
    carta_1 = new Carta("Unidad", "zona 1", "cuerpo a cuerpo" )
    carta_2 = new Carta("Clima", "poder 1")
    carta_3 = new Carta("Clima", "poder 1")
  }

  /**
   * debo definir el equals dentro de la clase Carta, pero primero quería arreglar esto porque tenía problemas
   * al usar la clase Carta
   */
  test("equals") {
    assertEquals(carta_2, carta_3)
    assertEquals(new Carta("Clima", "poder 1"), new Carta("Clima", "poder 1"))
  }
}
