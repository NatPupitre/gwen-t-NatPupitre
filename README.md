# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Contexto
Para esta entrega quité el controlador ya que no alcancé a testearlo, por lo que se puede apreciar en la entrega parcial
correspondiente a este en donde se planeaba implementar mediante el siguiente diagrama de estados.

Las funciones del controlador permiten los distintos estados del juego, el cual se observa en el siguiente diagrama
de estados:
![img.png](img.png)![img_1.png](img_1.png)

Luego para esta entrega se testean los efectos, los cuales se aplican mediante el como se colocan las cartas en el 
tablero, todo esto mediante el patrón Double Dispatch, de foma que se identifique el tipo de carta, aplicando su forma
de colocarse en la jugada que planea el jugador y en el tablero, luego se coloca a partir del efecto, pues las de 
unidad tienen distinto orden al agregarse ya que un efecto (Refuerzo Moral), aplica el efecto a todas las cartas en la 
misma fila a excepción de la carta que aplica el efecto y viceversa para las cartas con el efecto Vinculo Estrecho.

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)
