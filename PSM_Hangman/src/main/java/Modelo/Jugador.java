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

    private int vidas;
    private String palabraIntento;
    private final int idJugador;
    private int partidasGanadas;
    private int partidasRestantes;
    private final Scanner teclado;
    private final Partida partida;

    public Jugador(int idJugador, Partida partida) {
        this.idJugador = idJugador;
        this.vidas = 5;
        this.palabraIntento = "";
        this.partidasGanadas = 0;
        this.partidasRestantes = 6;
        this.teclado = new Scanner(System.in);
        this.partida = partida;
    }

    public boolean intentarAdivinar() {
        System.out.println("Cual es tu palabra a probar?");
        palabraIntento = teclado.nextLine();
        
        partida.comprobarPalabra(this.idJugador,this.palabraIntento);
    }

}
