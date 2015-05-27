package bingofinal;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public final class Carton extends JFrame {

    JPanel panelCarton, panelCeldas;
    JButton[] celda;
    private int[][] carton = new int[3][9];
    int[] columEmpty = new int[9];
    int totalEmpy, lineaEmpy;
    ArrayList<Integer> Numeros = null;
    public static boolean LINEA = false;
    public static boolean BINGO = false;

    public Carton() {
        setSize(550, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cargarCeldas();

        setVisible(true);
    }

    //Cargamos el array de numeros en los botones para mostrarlos
    void cargarCeldas() {

        panelCarton = new JPanel();
        panelCarton.setLayout(new BorderLayout());
        panelCeldas = new JPanel();
        panelCeldas.setLayout(new GridLayout(3, 9, 8, 8));

        panelCarton.add("Center", panelCeldas);
        getContentPane().add(panelCarton);

        celda = new JButton[27];

        llenarCARTON();

        int countCelda = 0;
        for (int columna = 0; columna < 3; columna++) {
            for (int fila = 0; fila < 9; fila++) {

                celda[countCelda] = new JButton("" + getCarton()[columna][fila]);

                if (getCarton()[columna][fila] == 0) {
                    celda[countCelda].setBackground(Color.GRAY);
                    celda[countCelda].setText("");
                }
                panelCeldas.add(celda[countCelda]);
                countCelda++;
            }
        }
    }

    //Llenamos el array carton con los numeros correctamente
    private void meterNumeros() {

        for (int columna = 0; columna < 9; columna++) {
            generarNumeros(columna);
            for (int fila = 0; fila < 3; fila++) {
                if (columna == 0) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 1) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 2) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 3) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 4) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 5) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 6) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 7) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
                if (columna == 8) {
                    getCarton()[fila][columna] = Numeros.get(fila);
                }
            }
        }
    }

    //Llenamos el arrya con los huecos aleatoriamente
    private void llenarCARTON() {

        do {

            totalEmpy = 0;
            lineaEmpy = 0;

            for (int f = 0; f < 9; f++) {
                columEmpty[f] = 0;
            }

            meterNumeros();

            for (int col = 0; col < 3; col++) {
                for (int f = 0; f < 9; f++) {
                    int aux = (int) (Math.random() * 10) + 1;

                    if (aux % 2 == 0 && lineaEmpy < 4 && columEmpty[f] < 2) {
                        getCarton()[col][f] = 0;
                        lineaEmpy++;
                        columEmpty[f]++;
                        totalEmpy++;
                    }
                }
                lineaEmpy = 0;
            }
        } while (totalEmpy != 12);
    }

    //Metodo para crear los nummeros que se introduciran en el carton ordenados
    public void generarNumeros(int opcion) {
        int num1, cont;

        switch (opcion) {
            case 0:
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 1:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (19 - 10 + 1) + 10);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 2:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (29 - 20 + 1) + 20);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 3:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (39 - 30 + 1) + 30);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 4:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (49 - 40 + 1) + 40);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 5:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (59 - 50 + 1) + 50);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 6:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (69 - 60 + 1) + 60);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 7:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (79 - 70 + 1) + 70);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
            case 8:
                Numeros.clear();
                Numeros = new ArrayList<>();
                cont = 0;

                do {
                    num1 = (int) Math.floor(Math.random() * (89 - 80 + 1) + 80);

                    if (Numeros.contains(num1) == false) {
                        Numeros.add(num1);
                        cont++;
                    }
                } while (cont != 3);

                Collections.sort(Numeros);
                break;
        }
    }

    //Metodo para buscar el numero de la bola
    public void buscarNumero(int bola) {
        int ncelda = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (carton[fila][columna] == bola) {
                    celda[ncelda].setBackground(Color.GREEN);

                    //Buscamos la linea
                    if (LINEA == false) {
                        buscarLinea();
                    }
                    
                    //Buscamos el bingo una vez hayamos hecho linea
                    if ((LINEA == true) && (BINGO == false)) {
                        buscarBingo();
                    }
                }
                ncelda++;
            }
        }
    }

    //Buscamos si hay alguna linea completa
    public void buscarLinea() {
        int aciertos = 0;
        int ncelda = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (celda[ncelda].getBackground().equals(Color.GREEN) || celda[ncelda].getBackground().equals(Color.GRAY)) {
                    aciertos++;
                }
                ncelda++;
            }
            if (aciertos == 9) {
                LINEA = true;
                JOptionPane.showMessageDialog(null, "Linea en " + getTitle(), " -- LINEA --", JOptionPane.INFORMATION_MESSAGE);
            }
            aciertos = 0;
        }
    }

    //Buscamos el Bingo
    public void buscarBingo() {
        int aciertos = 0;
        int ncelda = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (celda[ncelda].getBackground().equals(Color.GREEN) || celda[ncelda].getBackground().equals(Color.GRAY)) {
                    aciertos++;
                }
                ncelda++;
            }
        }

        if (aciertos == 27) {
            BINGO = true;
            JOptionPane.showMessageDialog(null, "BINGO " + getTitle(), " -- BINGO --", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * @return the carton
     */
    public int[][] getCarton() {
        return carton;
    }

    /**
     * @param carton the carton to set
     */
    public void setCarton(int[][] carton) {
        this.carton = carton;
    }

}
