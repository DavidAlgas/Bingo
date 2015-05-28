package bingofinal;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public final class Carton extends JFrame {

    //Inicializo los componentes
    JPanel panelCarton, panelCeldas;
    JButton[] celda;
    private int[][] carton = new int[3][9];
    int[] columEmpty = new int[9];
    int totalEmpy, lineaEmpy;
    ArrayList<Integer> Numeros = null;
    public static boolean LINEA = false;
    public static boolean BINGO = false;

    //Constructor de la Clase
    public Carton() {
        setSize(550, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cargarCeldas();

        setVisible(true);
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para cargar el array con los numeros ya insertado en los botonoes para su visualizacion
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

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para llenar el array con los numeros del bingo ordenadamente y sin repetir
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

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para llenar el array de los huecos corresondientes de manera aleatoria
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

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para generar los numeros segun la columna del carton
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

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo al que le pasamos la bola para buscar en el array de numeros si esta y marcarlo como encontrado
    //Si esta en el array buscaremos si se ha completado la linea o el bingo.
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

                        if (BINGO == true) {
                            int seleccion = JOptionPane.showOptionDialog(null, "¿Que desea Hacer?", "Fin de Juego", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Otra Partida", "Salir"}, "Otra Partida");

                            if (seleccion == 0) {

                                BingoFinal.nCartones = 0;
                                BingoFinal.lbl_info.setText("");
                                BingoFinal.jugar = false;
                                BingoFinal.btn_Jugar.setText("1. Jugar");
                                BingoFinal.Bolas.clear();
                                BINGO = false;
                                LINEA = false;
                                for (Carton cartonq : BingoFinal.Cartones) {
                                    cartonq.dispose();
                                }
                                BingoFinal.Cartones.clear();

                            } else {
                                System.exit(0);
                            }
                        }
                    }
                }
                ncelda++;
            }
        }
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para buscar si hay alguna linea completa y asi poder cantar LINEA!
    public void buscarLinea() {
        int aciertos = 0;
        int ncelda = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (celda[ncelda].getBackground().equals(Color.GREEN) || celda[ncelda].getBackground().equals(Color.GRAY)) {
                    aciertos++;
                }
                if (aciertos == 9) {

                    LINEA = true;
                    if ((ncelda >= 0) && (ncelda <= 8)) {
                        int pos = 0;
                        for (int columnaa = 0; columnaa < 9; columnaa++) {
                            if (celda[pos].getBackground().equals(Color.GREEN)) {
                                celda[pos].setBackground(Color.MAGENTA);
                            }
                            pos++;
                        }
                    }
                    if ((ncelda >= 9) && (ncelda <= 17)) {
                        int pos = 9;
                        for (int columnab = 0; columnab < 9; columnab++) {
                            if (celda[pos].getBackground().equals(Color.GREEN)) {
                                celda[pos].setBackground(Color.MAGENTA);
                            }
                            pos++;
                        }
                    }
                    if ((ncelda >= 18) && (ncelda <= 27)) {
                        int pos = 18;
                        for (int columnac = 0; columnac < 9; columnac++) {
                            if (celda[pos].getBackground().equals(Color.GREEN)) {
                                celda[pos].setBackground(Color.MAGENTA);
                            }
                            pos++;
                        }
                    }
                    System.out.println(" -- Comprobamos LINEA --");
                    for (Integer comprobamos : BingoFinal.Bolas) {
                        System.out.print(comprobamos + ", ");
                    }
                    JOptionPane.showMessageDialog(null, "Linea en " + getTitle(), " -- LINEA --", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Vamos para BINGO", " -- Informacion --", JOptionPane.INFORMATION_MESSAGE);
                }
                ncelda++;
            }
            aciertos = 0;
        }

    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //Metodo para buscar en el carton tiene BINGO y ganar el juego
    public void buscarBingo() {
        int aciertos = 0;
        int ncelda = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (celda[ncelda].getBackground().equals(Color.GREEN) || celda[ncelda].getBackground().equals(Color.GRAY) || celda[ncelda].getBackground().equals(Color.MAGENTA)) {
                    aciertos++;
                }
                ncelda++;
            }
        }

        if (aciertos == 27) {
            BINGO = true;
            System.out.println(" -- Comprobamos BINGO --");
            for (Integer comprobamos : BingoFinal.Bolas) {
                System.out.print(comprobamos + ", ");
            }
            ncelda = 0;

            for (int fila = 0; fila < 3; fila++) {
                for (int columna = 0; columna < 9; columna++) {
                    if (celda[ncelda].getBackground().equals(Color.GREEN)) {
                        celda[ncelda].setBackground(Color.MAGENTA);
                    }
                    ncelda++;
                }
            }
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
