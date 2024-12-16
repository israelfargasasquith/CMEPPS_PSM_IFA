/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Scanner;

/**
 *
 * @author israe
 */
public class Jugador {

    private String palabraIntento;
    private final int idJugador;
    private final Scanner teclado;
    private final Partida partida;

    public Jugador(int idJugador, Partida partida) {
        this.idJugador = idJugador;
        this.palabraIntento = "";
        this.teclado = new Scanner(System.in);
        this.partida = partida;
    }

    public boolean intentarAdivinar() {
        boolean acierto = false;
        System.out.println("Cual es tu palabra a probar? Jagador"+idJugador);
        palabraIntento = teclado.nextLine();

        acierto = partida.comprobarPalabra(this.idJugador, this.palabraIntento);
        return acierto;
    }

}
