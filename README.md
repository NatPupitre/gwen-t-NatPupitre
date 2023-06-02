# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
Para esta entrega (tarea 2) se consideró el feedback brindado de la tarea 1, por lo que se agregó una clase 
abstracta para las cartas de Unidad.

Principalmente se agregó la clase tablero, la cual permite pasar las cartas que los jugadores tenían en sus 
respectivas zonas IMAGINARIAS mediante el patrón Double Dispatch al tablero con zonas reales dentro del juego 
mediante la autorización de este a partir del turno de los jugadores.

finalmente se testearon todos los métodos a excepción de los que retornan un print dado que estos se testean mejor 
solamente observando la salida de estos al ser ejecutados y no mediante testing, con lo cual se obtiene un coverage 
mayor a 90%, lo que nos indica una mayor confianza en los métodos de las clases y en el como se implementarán para 
el juego.

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)
