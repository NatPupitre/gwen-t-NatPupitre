# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
Para esta entrega (entreaga tarea 1) se usó una clase abstracta para las clases CartaClima y CartaUnidad dado que 
compartían métodos concretos, pero requerían de una clase abstracta pues las cartas al ser jugadas, se jugarán de 
forma distinta dependiendo de su clase, luego para los jugadores Computadora y Usuario se decidió hacer uso de sólo 
una interfaz dado que sólo compartián métodos abstractos, pues los métodos que incluyen a las cartas dependían 
estrictamente de la clase, ya que cada jugador posee su propio mazo y mano.

finalmente se testearon todos los métodos a excepción de los que retornan un print dado que estos se testean mejor 
solamente observando la salida de estos al ser ejecutados y no mediante testing, con lo cual se obtiene un coverage 
mayor a 90%, lo que nos indica una mayor confianza en los métodos de las clases y en el como se implementarán para 
el juego.

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**