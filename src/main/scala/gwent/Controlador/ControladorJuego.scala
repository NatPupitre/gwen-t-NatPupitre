package cl.uchile.dcc.gwent.Controlador

import cl.uchile.dcc.gwent.Jugador.{Computadora, Usuario};

class ControladorJuego(Usu: Usuario, Compu: Computadora) {


    private var EstadoActual: Unit = new Menu(Usu, Compu)

    def CambiarEstado(NuevoEstado: EstadoJuego): Unit = {
        EstadoActual = NuevoEstado
    }

}
