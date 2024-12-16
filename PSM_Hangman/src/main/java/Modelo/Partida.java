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
            acierto = true;
        } else {
            System.out.println("Fallaste");

            palabrasProbadas.add(palabraPrueba);
            acierto = false;
        }
        this.actualizarDatos(idJugador, acierto);
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
                        + "\nHa ganado " + partidasGanadasJugador1 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador1 + " partidas");
                System.out.println("Palabras probadas jugador1: ");
                for (String palabraProbada : palabrasProbadas) {
                    System.out.print(palabraProbada + ", ");
                }
                System.out.println("");
                //System.out.println(letrasAdivinadas);
                break;
            case 2:
                System.out.println("\n\nTurno jugador2\nEl jugador2 tiene: " + vidasJugador2 + " vidas "
                        + "\nHa ganado " + partidasGanadasJugador2 + " de " + 5 + " intentos\nLe quedan: " + partidasRestantesJugador2 + " partidas");
                System.out.println("Palabras probadas jugador2: ");
                for (String palabraProbada : palabrasProbadas) {
                    System.out.print(palabraProbada + ", ");
                }
                System.out.println("");
                //System.out.println(letrasAdivinadas);
                break;
            case -1:
                System.out.println("FIN DE PARTIDA RESUMEN:");
                System.out.println("El jugador 1 tiene: " + vidasJugador1
                        + "\nHa ganado " + partidasGanadasJugador1 + " de " + 5 + " intentos");
                System.out.println("El jugador 2 tiene: " + vidasJugador2
                        + "\nHa ganado " + partidasGanadasJugador2 + " de " + 5 + " intentos");

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

    private void actualizarDatos(int idJugador, boolean fueAcierto) {
        if (idJugador == idJugador1) {
            if (fueAcierto) {
                partidasGanadasJugador1++;
                partidasRestantesJugador1--;
                vidasJugador1 = 6;
            } else if (vidasJugador1 == 0 && partidasRestantesJugador1 == 0) {
                System.out.println("Perdiste amigo/a");
            } else if (vidasJugador1 == 0 && partidasRestantesJugador1 > 0) {
                vidasJugador1 = 6;
                partidasRestantesJugador1--;
                System.out.println("Perdiste una ronda, te queda: " + partidasRestantesJugador1);
            } else {
                vidasJugador1--;
            }
        } else {
            if (fueAcierto) {
                partidasGanadasJugador2++;
                partidasRestantesJugador2--;
                vidasJugador2 = 6;
            } else if (vidasJugador2 == 0 && partidasRestantesJugador2 == 0) {
                System.out.println("Perdiste amigo/a");
            } else if (vidasJugador2 == 0 && partidasRestantesJugador2 > 0) {
                vidasJugador2 = 6;
                partidasRestantesJugador2--;
                System.out.println("Perdiste una ronda, te queda: " + partidasRestantesJugador2);
            } else {
                vidasJugador2--;
            }
        }

    }

    private void generarPalabra() {
        String poolPalabras[] = {"Viktor", "Joel", "Huevo", "Mango", "Tomar", "Motora", "Mosca", "Piel", "Feliz", "Navidad", "Año", "Nuevo"};
        int elegida = rand.nextInt(0, 11);
        palabraSecreta = poolPalabras[elegida];
        System.out.println("La palabra secreta es: " + palabraSecreta + " numero generado " + elegida);
        this.nLetrasPalabraSecreta = palabraSecreta.length();
    }
}
