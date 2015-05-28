package bingofinal;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public final class BingoFinal extends JFrame {

    //Creamos los botonen
    static JButton btn_Jugar = new JButton("1. Jugar");
    JButton btn_Carton = new JButton("2. Cartón");
    JButton btn_Salir = new JButton("3. Fin");
    static JLabel lbl_info = new JLabel();
    static ArrayList<Carton> Cartones = new ArrayList<>();
    static ArrayList<Integer> Bolas = new ArrayList<>();
    static int nCartones, bola;
    static boolean jugar = false;

    //Creamos el panel
    JPanel contentpanel;

    public BingoFinal() {
        setSize(320, 300);
        setTitle(" -- Bingo --");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(BingoFinal.EXIT_ON_CLOSE);
        setVisible(true);

        insertarComponentes();
    }

    public void insertarComponentes() {
        //Creamos el panel contenedor
        contentpanel = (JPanel) this.getContentPane();
        contentpanel.setLayout(null);
        contentpanel.setBackground(Color.darkGray);

        //Asignamos posicion y tamaño a los botones
        btn_Jugar.setBounds(50, 50, 200, 40);
        btn_Carton.setBounds(50, 100, 200, 40);
        btn_Salir.setBounds(50, 150, 200, 40);
        lbl_info.setBounds(50, 200, 200, 20);
        lbl_info.setForeground(Color.red);

        //Añadimos los botones al panel
        contentpanel.add(btn_Jugar);
        contentpanel.add(btn_Carton);
        contentpanel.add(btn_Salir);
        contentpanel.add(lbl_info);

        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        //Damos Funcionalidades a los Botones
        //Boton de Iniciar El Juego
        btn_Jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (nCartones < 1) {
                        lbl_info.setText("No hay cartones Creados");
                    } else {

                        if (jugar == false) {
                            lbl_info.setText("Hay " + nCartones + " creados.");
                            JOptionPane.showMessageDialog(null, "Vamos para LINEA", " -- Informacion --", JOptionPane.INFORMATION_MESSAGE);
                            jugar = true;
                        } else {
                            inicioJuego();
                        }

                    }
                } catch (Exception err) {
                }
            }
        });

        //Boton de Crear Cartones
        btn_Carton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (nCartones == 6 || jugar == true) {
                        JOptionPane.showMessageDialog(null, "Has superado el limite de Cartones", "Alerta", JOptionPane.INFORMATION_MESSAGE, null);
                    } else {
                        Carton carton = new Carton();
                        carton.setTitle(" -- Carton " + (nCartones + 1) + " --");
                        Cartones.add(carton);
                        nCartones++;
                    }
                } catch (Exception err) {
                    System.out.println("Error 87: " + err);
                }
            }
        });

        //Boton de Salir
        btn_Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
    }

    //Metodo para iniciar el juego
    public void inicioJuego() {

        boolean existe = false;

        do {
            bola = (int) Math.floor(Math.random() * (90 - 1 + 1) + 1);

            if (Bolas.contains(bola) == false && bola != 0) {
                Bolas.add(bola);
                existe = true;
            }
        } while (!existe);

        btn_Jugar.setText(Integer.toString(bola));

        for (Carton nCarton : Cartones) {
            nCarton.buscarNumero(bola);
        }
    }

    //Clase principal
    public static void main(String[] args) {
        BingoFinal main = new BingoFinal();
    }

}
