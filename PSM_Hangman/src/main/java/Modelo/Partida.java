/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author israe
 */
public class Partida {

    private final String palabraSecreta;
    private final int idJugador1;
    private final int idJugador2;
    private int partidasGanadasJugador1;
    private int partidasGanadasJugador2;
    private int partidasRestantesJugador1;
    private int partidasRestantesJugador2;

    public Partida() {
        this.palabraSecreta = this.generarPalabra();
        this.idJugador1 = 1;
        this.idJugador2 = 2;
        this.partidasGanadasJugador1 = 0;
        this.partidasGanadasJugador2 = 0;
        this.partidasRestantesJugador1 = 5;
        this.partidasRestantesJugador2 = 5;
    }
    
    private String generarPalabra(){
        
    }

}
