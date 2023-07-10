package cl.uchile.dcc

import gwent.Carta.{CartaAsedio, CartaClima, CartaCuerpo, CartaDistancia, CartaT}

import cl.uchile.dcc.gwent.Carta.Efectos.{Efect, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, RefuerzoMoral, VinculoEstrecho}

import scala.collection.mutable.ArrayBuffer

class CartaTest extends munit.FunSuite {

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
  var ClimaD: ClimaDespejado = null
  var EscarchaM: EscarchaMordiente =  null
  var LluviaT: LluviaTorrencial = null
  var NieblaI: NieblaImpenetrable = null
  var RefuerzoM: RefuerzoMoral = null
  var VinculoE: VinculoEstrecho = null

  override def beforeEach(context: BeforeEach): Unit = {


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
    carta_U1 = new CartaCuerpo("Nombre 1", "Cuerpo", 1, RefuerzoM)
    carta_U2 = new CartaCuerpo("Nombre igual 2.3", "Cuerpo", 23, VinculoE)
    carta_U3 = new CartaCuerpo("Nombre igual 2.3", "Cuerpo", 23, VinculoE)
    carta_U4 = new CartaCuerpo("Nombre 1", "Asedio", 18, RefuerzoM)
    carta_U5 = new CartaCuerpo("mismo Nombre", "Cuerpo", 56, VinculoE)
    carta_U6 = new CartaCuerpo("mismo Nombre", "Cuerpo", 56, VinculoE)
    carta_U7 = new CartaDistancia("Nombre igual 7.8", "Distancia", 78, VinculoE)
    carta_U8 = new CartaDistancia("Nombre igual 7.8", "Distancia", 78, VinculoE)
    carta_U9 = new CartaDistancia("Nombre 1", "Distancia", 9, VinculoE)
    carta_U10 = new CartaDistancia("Nombre 1", "Asedio", 18, VinculoE)
    carta_U11 = new CartaDistancia("Nombre 1", "Distancia", 11, VinculoE)
    carta_U12 = new CartaDistancia("Nombre 1", "Distancia", 12, VinculoE)
    carta_U13 = new CartaAsedio("Nombre igual 13.14", "Asedio", 1314, VinculoE)
    carta_U14 = new CartaAsedio("Nombre igual 13.14", "Asedio", 1314, VinculoE)
    carta_U15 = new CartaAsedio("Nombre 1", "Asedio", 15, VinculoE)
    carta_U16 = new CartaAsedio("Nombre 1", "Asedio", 16, VinculoE)
    carta_U17 = new CartaAsedio("Nombre 1", "Asedio", 17, VinculoE)
    carta_U18 = new CartaAsedio("Nombre 1", "Asedio", 18, VinculoE)

    carta_C1 = new CartaClima("Nombre 1", "Clima", ClimaD)
    carta_C2 = new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)
    carta_C3 = new CartaClima("Nombre igual 2.3", "Clima", EscarchaM)
    carta_C4 = new CartaClima("Nombre 4", "Clima", NieblaI)
    carta_C5 = new CartaClima("mismo Nombre", "Clima", LluviaT)
    carta_C6 = new CartaClima("mismo Nombre", "Clima", LluviaT)
    carta_C7 = new CartaClima("Nombre C7", "Clima", NieblaI)

  }

  test("equals") {

    /** equals de la clase Unidad */
    // Ubicación Cuerpo
    assertEquals(carta_U2, carta_U3)
    assert(carta_U2.equals(carta_U3))
    assertEquals(new CartaCuerpo("a", "b", 1, RefuerzoM),
      new CartaCuerpo("a", "b", 1, RefuerzoM))

    // Ubicación Distancia
    assertEquals(carta_U7, carta_U8)
    assert(carta_U7.equals(carta_U8))

    // Ubicación Asedio
    assertEquals(carta_U13, carta_U14)
    assert(carta_U13.equals(carta_U14))

    /** equals de la clase CartaClima */
    assertEquals(carta_C2, carta_C3)
    assert(carta_C2.equals(carta_C3))
    assertEquals(new CartaClima("a", "Clima", ClimaD),
      new CartaClima("a", "Clima", ClimaD))

  }

  test("not equals Cartas") {

    // misma clase distintos inputs para cartas de Unidad

    // Ubicación Cuerpo
    assertNotEquals(carta_U1, carta_U4)
    assert(!carta_U1.equals(carta_U4))
    assertNotEquals(new CartaCuerpo("a", "b", 1, VinculoE),
      new CartaCuerpo("a", "b", 2, VinculoE))

    // Ubicación Distancia
    assertNotEquals(carta_U7, carta_U9)
    assert(!carta_U7.equals(carta_U9))

    // Ubicación Asedio
    assertNotEquals(carta_U13, carta_U15)
    assert(!carta_U13.equals(carta_U15))

    // misma clase distintos inputs para cartas de Clima
    assertNotEquals(carta_C1, carta_C5)
    assert(!carta_C1.equals(carta_C5))
    assertNotEquals(new CartaClima("a","Clima", EscarchaM),
      new CartaClima("a","Clima" , ClimaD))

    /** Test para distintas clases */

    // Ubicación Cuerpo
    assert(!carta_U4.equals(carta_U18))

    // Ubicación Distancia
    assert(!carta_U10.equals(carta_U18))

    // Ubicación Asedio
    assert(!carta_U18.equals(carta_U4))

    // Carta Clima
    assert(!carta_C1.equals(carta_U4))

  }

  test("hashcode") {

    /** Si 2 elementos son iguales deberían tener el mismo hashcode y sin son distintas no */

    //Clase CartaUnidad

    // Ubicación Cuerpo
    assert(carta_U2.hashCode == carta_U3.hashCode)
    assert(carta_U1.hashCode != carta_U4.hashCode)

    // Ubicación Distancia
    assert(carta_U7.hashCode == carta_U8.hashCode)
    assert(carta_U7.hashCode != carta_U9.hashCode)

    // Ubicación Asedio
    assert(carta_U13.hashCode == carta_U14.hashCode)
    assert(carta_U13.hashCode != carta_U15.hashCode)

    //Clase CartaClima
    assert(carta_C2.hashCode == carta_C3.hashCode)
    assert(carta_C1.hashCode != carta_C5.hashCode)
  }

  test("getters") {

    /** Previamente se definió Carta_U1 con los siguientes inputs:
     * carta_U1 = new CartaUnidad("Nombre 1", "Cuerpo", 1, "habilidad 1")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaCuerpo
     */
    assert(carta_U1.getNombre() == "Nombre 1")
    assert(carta_U1.getClasificacion() == "Cuerpo")
    assert(carta_U1.getFuerza() == 1)
    assert(carta_U1.getEfecto() == RefuerzoM)

    /** Previamente se definió carta_U7 con los siguientes inputs:
     * carta_U7 = new CartaDistancia("Nombre igual 7.8", "Distancia", 78, "habilidad 7.8")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaDistancia
     */
    assert(carta_U7.getNombre() == "Nombre igual 7.8")
    assert(carta_U7.getClasificacion() == "Distancia")
    assert(carta_U7.getFuerza() == 78)
    assert(carta_U7.getEfecto() == VinculoE)

    /** Previamente se definió carta_U15 con los siguientes inputs:
     * carta_U15 = new CartaAsedio("Nombre 1", "Asedio", 15, "habilidad 1")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaAsedio
     */
    assert(carta_U15.getNombre() == "Nombre 1")
    assert(carta_U15.getClasificacion() == "Asedio")
    assert(carta_U15.getFuerza() == 15)
    assert(carta_U15.getEfecto() == VinculoE)

    /** Previamente se definió Carta_C1 con los siguientes inputs:
     * carta_C1 = new CartaClima("Nombre 1", "Habilidad 1")
     * por lo que se sabe lo que deberían entregar los getters y se puede comprobar
     * si funcionan para la clase CartaClima
     */
    assert(carta_C1.getNombre() == "Nombre 1")
    assert(carta_C1.getClasificacion() == "Clima")
    assert(carta_C1.getEfecto() == ClimaD)
  }

  test("setters") {

    /** Como se comprobó que los getters funcionan, se usarán para comprobar que los setters
     * también lo hacen
     */

    // Clase CartaCuerpo
    carta_U5.setNombre("Distinto Nombre")
    assert(carta_U5.getNombre() == "Distinto Nombre")

    carta_U5.setClasificacion("Distinta Clasificacion")
    assert(carta_U5.getClasificacion() == "Distinta Clasificacion")

    carta_U5.setFuerza(0)
    assert(carta_U5.getFuerza() == 0)

    carta_U5.setEfecto(RefuerzoM)
    assert(carta_U5.getEfecto() == RefuerzoM)

    // Clase CartaDistancia
    carta_U7.setNombre("Distinto Nombre")
    assert(carta_U7.getNombre() == "Distinto Nombre")

    carta_U7.setClasificacion("Distinta Clasificacion")
    assert(carta_U7.getClasificacion() == "Distinta Clasificacion")

    carta_U7.setFuerza(0)
    assert(carta_U7.getFuerza() == 0)

    carta_U7.setEfecto(RefuerzoM)
    assert(carta_U7.getEfecto() == RefuerzoM)

    // Clase CartaAsedio
    carta_U15.setNombre("Distinto Nombre")
    assert(carta_U15.getNombre() == "Distinto Nombre")

    carta_U15.setClasificacion("Distinta Clasificacion")
    assert(carta_U15.getClasificacion() == "Distinta Clasificacion")

    carta_U15.setFuerza(0)
    assert(carta_U15.getFuerza() == 0)

    carta_U15.setEfecto(RefuerzoM)
    assert(carta_U15.getEfecto() == RefuerzoM)

    // Clase CartaClima
    carta_C5.setNombre("Distinto Nombre")
    assert(carta_C5.getNombre() == "Distinto Nombre")

    carta_C5.setClasificacion("Distinta Clasificacion")
    assert(carta_C5.getClasificacion() == "Distinta Clasificacion")

    carta_C5.setEfecto(ClimaD)
    assert(carta_C5.getEfecto() == ClimaD)
  }
}
