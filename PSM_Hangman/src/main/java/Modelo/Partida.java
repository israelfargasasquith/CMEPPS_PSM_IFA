/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author israe
 */
public class Partida {

    private final String palabraSecreta;
    private int nLetrasPalabraSecreta;
    private char[] letrasAdivinadas;
    private String[] palabrasProbadas;
    private final int idJugador1;
    private final int idJugador2;
    private int vidasJugador1;
    private int vidasJugador2;
    private int partidasGanadasJugador1;
    private int partidasGanadasJugador2;
    private int partidasRestantesJugador1;
    private int partidasRestantesJugador2;
    private final Random rand;

    public Partida() {
        this.palabraSecreta = this.generarPalabra();
        this.idJugador1 = 1;
        this.idJugador2 = 2;
        this.partidasGanadasJugador1 = 0;
        this.partidasGanadasJugador2 = 0;
        this.partidasRestantesJugador1 = 5;
        this.partidasRestantesJugador2 = 5;
        this.vidasJugador1 = 6;
        this.vidasJugador2 = 6;
        this.rand = new Random(System.nanoTime());
    }

    public boolean comprobarPalabra(int idJugador, String palabraPrueba) {

        return palabraPrueba.equalsIgnoreCase(this.palabraSecreta);
    }

    private String generarPalabra() {
        String poolPalabras[] = {"Viktor", "Joel", "Huevo", "Mango", "Tomar", "Motora", "Mosca", "Piel", "Feliz", "Navidad", "Año", "Nuevo"};
        int elegida = rand.nextInt(0, 12);
        System.out.println("La palabra secreta es: " + palabraSecreta);
        this.nLetrasPalabraSecreta = palabraSecreta.length();
        return poolPalabras[elegida];
    }

    public int getnLetrasPalabraSecreta() {
        return nLetrasPalabraSecreta;
    }

    public void setnLetrasPalabraSecreta(int nLetrasPalabraSecreta) {
        this.nLetrasPalabraSecreta = nLetrasPalabraSecreta;
    }

    public char[] getLetrasAdivinadas() {
        return letrasAdivinadas;
    }

    public void setLetrasAdivinadas(char[] letrasAdivinadas) {
        this.letrasAdivinadas = letrasAdivinadas;
    }

    public String[] getPalabrasProbadas() {
        return palabrasProbadas;
    }

    public void setPalabrasProbadas(String[] palabrasProbadas) {
        this.palabrasProbadas = palabrasProbadas;
    }

    public int getPartidasGanadasJugador1() {
        return partidasGanadasJugador1;
    }

    public void setPartidasGanadasJugador1(int partidasGanadasJugador1) {
        this.partidasGanadasJugador1 = partidasGanadasJugador1;
    }

    public int getPartidasGanadasJugador2() {
        return partidasGanadasJugador2;
    }

    public void setPartidasGanadasJugador2(int partidasGanadasJugador2) {
        this.partidasGanadasJugador2 = partidasGanadasJugador2;
    }

    public int getPartidasRestantesJugador1() {
        return partidasRestantesJugador1;
    }

    public void setPartidasRestantesJugador1(int partidasRestantesJugador1) {
        this.partidasRestantesJugador1 = partidasRestantesJugador1;
    }

    public int getPartidasRestantesJugador2() {
        return partidasRestantesJugador2;
    }

    public void setPartidasRestantesJugador2(int partidasRestantesJugador2) {
        this.partidasRestantesJugador2 = partidasRestantesJugador2;
    }

}
