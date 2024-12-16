/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Jugador;
import Modelo.Partida;

/**
 *
 * @author israe
 */
public class ControladorAhorcado {

    private Partida partida;
    private Jugador jugador1;
    private Jugador jugador2;

    public ControladorAhorcado() {
        partida = new Partida();
        jugador1 = new Jugador(1, partida);
        jugador2 = new Jugador(2, partida);
    }

    public void lanzarJuego() {
        boolean acabada = false;
        boolean aciertoPalabra = false;
        int turno = 1;
        System.out.println("Bienvenidos al juego del ahorcado de IFA");
        System.out.println("Comienza el juegador 1");

        do {
            acabada = partida.mostrarDatos(turno);
            turno = partida.comprobarPartidasRestantes();
            if (turno == 1) {
                aciertoPalabra = jugador1.intentarAdivinar();
            } else {
                aciertoPalabra = jugador2.intentarAdivinar();
            }
//            if(aciertoPalabra){
//                System.out.println("Felicidades ganaste una ronda");
//            }else{
//                System.out.println("A ver si la siguiente si...");
//            }
//            

        } while (!acabada);

    }

}
