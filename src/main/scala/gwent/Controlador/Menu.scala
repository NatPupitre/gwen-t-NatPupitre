package cl.uchile.dcc.gwent.Controlador;
import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.Jugador.{Computadora, Usuario}
import scala.util.Random

class Menu(Usu: Usuario, Compu: Computadora) extends EstadoJuego {

    private var N: Int = 1
    private var i: Int = 0
    
    def IniciarJuego(): Unit = {

    }
    def SalirJuego(): Unit = {

    }

    def InicioRonda(N: Int): Unit = {
        println("Inicio ronda" + N)
        if(N == 1) {
            Usu.BarajarMazo()
            Compu.BarajarMazo()
            while (i < 10) {
                Usu.RobarCarta()
                Compu.RobarCarta()
            }
        }
        else{
            Usu.BarajarMazo()
            Compu.BarajarMazo()
        }
    }
}
