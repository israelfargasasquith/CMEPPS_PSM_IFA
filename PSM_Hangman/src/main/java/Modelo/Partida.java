/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author israe
 */
public class Partida {

    private String palabraSecreta;
    private int nLetrasPalabraSecreta;
    private String letrasAdivinadas;
    private ArrayList<String> palabrasProbadas;
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
        this.rand = new Random(System.nanoTime());
        for (int i = 0; i < nLetrasPalabraSecreta; i++) {
            this.letrasAdivinadas = "_ ";
        }
        this.palabrasProbadas = new ArrayList<>();
        this.idJugador1 = 1;
        this.idJugador2 = 2;
        this.partidasGanadasJugador1 = 0;
        this.partidasGanadasJugador2 = 0;
        this.partidasRestantesJugador1 = 5;
        this.partidasRestantesJugador2 = 5;
        this.vidasJugador1 = 6;
        this.vidasJugador2 = 6;
        this.generarPalabra();
    }

    public boolean comprobarPalabra(int idJugador, String palabraPrueba) {
        boolean acierto = false;
        if (palabraPrueba.equalsIgnoreCase(this.palabraSecreta)) {
            //this.actualizarValores(idJugador,true);
            System.out.println("Palabra acertada " + palabraPrueba + " == " + palabraSecreta);
            if (idJugador == 1) {
                partidasGanadasJugador1++;
                partidasRestantesJugador1--;
                vidasJugador1 = 6;
                this.generarPalabra();

            } else {
                partidasGanadasJugador2++;
                partidasRestantesJugador2--;
                vidasJugador2 = 6;
                this.generarPalabra();
            }
            acierto = true;
        } else {
            //this.actualizarValores(idJugador,false);
            palabrasProbadas.add(palabraPrueba);
            if (idJugador == 1) {
                vidasJugador1--;

            } else {
                vidasJugador2--;

            }
            if (vidasJugador1 == 0 && partidasRestantesJugador1 > 0) {
                partidasRestantesJugador1--;
                vidasJugador1 = 6;
                this.generarPalabra();
            } else if (vidasJugador2 == 0 && partidasRestantesJugador2 > 0) {
                partidasRestantesJugador2--;
                vidasJugador2 = 6;
                this.generarPalabra();
            }
            acierto = false;
        }
        return acierto;
    }

    public int comprobarPartidasRestantes() {
        if (partidasRestantesJugador1 > 0) {
            return 1;
        } else if (partidasRestantesJugador2 > 0) {
            return 2;
        } else {
            return -1;
        }
    }

    public boolean mostrarDatos(int id) {
        boolean acabada = false;
        System.out.print("\nPalabra secreta: ");
        for (int i = 0; i < nLetrasPalabraSecreta; i++) {
            System.out.print("_ ");
        }
        switch (id) {
            case 1:
                System.out.println("\n\nTurno jugador1\nEl jugador1 tiene: " + vidasJugador1 + " vidas "
                        + "\nHa ganado " + partidasGanadasJugador1 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador1);
                System.out.println("Palabras probadas jugador1: ");
                for (String palabraProbada : palabrasProbadas) {
                    System.out.println(palabraProbada);
                }
                //System.out.println(letrasAdivinadas);
                break;
            case 2:
                System.out.println("\n\nTurno jugador2\nEl jugador2 tiene: " + vidasJugador2 + " vidas "
                        + "\nHa ganado " + partidasGanadasJugador2 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador2);
                System.out.println("Palabras probadas jugador2: ");
                for (String palabraProbada : palabrasProbadas) {
                    System.out.println(palabraProbada);
                }
                //System.out.println(letrasAdivinadas);
                break;
            case -1:
                System.out.println("FIN DE PARTIDA RESUMEN:");
                System.out.println("El jugador 1 tiene: " + vidasJugador1
                        + "\nHa ganado " + partidasGanadasJugador1 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador1);
                System.out.println("El jugador 2 tiene: " + vidasJugador2
                        + "\nHa ganado " + partidasGanadasJugador2 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador2);

                if (partidasGanadasJugador1 > partidasGanadasJugador2) {
                    System.out.println("VICTORIA MAGISTRAL PARA EL JUGADOR 1");
                } else if (partidasGanadasJugador1 < partidasGanadasJugador2) {
                    System.out.println("VICTORIA MAGISTRAL PARA EL JUGADOR 2");
                } else {
                    System.out.println("HA SIDO EMPATE");
                }
                acabada = true;
                break;
            default:
                System.out.println("Error en los turnos...");
                break;
        }
        return acabada;
    }

    private void generarPalabra() {
        String poolPalabras[] = {"Viktor", "Joel", "Huevo", "Mango", "Tomar", "Motora", "Mosca", "Piel", "Feliz", "Navidad", "Año", "Nuevo"};
        int elegida = rand.nextInt(0, 11);
        palabraSecreta = poolPalabras[elegida];
        System.out.println("La palabra secreta es: " + palabraSecreta + " numero generado " + elegida);
        this.nLetrasPalabraSecreta = palabraSecreta.length();
    }

    public int getnLetrasPalabraSecreta() {
        return nLetrasPalabraSecreta;
    }

    public void setnLetrasPalabraSecreta(int nLetrasPalabraSecreta) {
        this.nLetrasPalabraSecreta = nLetrasPalabraSecreta;
    }

    public String getLetrasAdivinadas() {
        return letrasAdivinadas;
    }

    public void setLetrasAdivinadas(String letrasAdivinadas) {
        this.letrasAdivinadas = letrasAdivinadas;
    }

    public ArrayList<String> getPalabrasProbadas() {
        return palabrasProbadas;
    }

    public void setPalabrasProbadas(ArrayList<String> palabrasProbadas) {
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
