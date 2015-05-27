package bingofinal;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public final class BingoFinal extends JFrame {

    //Creamos los botonen
    JButton btnInicio = new JButton("1. Jugar");
    JButton btnCarton = new JButton("2. Cartón");
    JButton btnFin = new JButton("3. Fin");
    JLabel lbl_info = new JLabel();
    static ArrayList<Carton> Cartones = new ArrayList<>();
    ArrayList<Integer> Bolas = new ArrayList<>();
    public int nCartones, bola;

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
        btnInicio.setBounds(50, 50, 200, 40);
        btnCarton.setBounds(50, 100, 200, 40);
        btnFin.setBounds(50, 150, 200, 40);
        lbl_info.setBounds(50, 200, 200, 20);
        lbl_info.setForeground(Color.red);

        //Añadimos los botones al panel
        contentpanel.add(btnInicio);
        contentpanel.add(btnCarton);
        contentpanel.add(btnFin);
        contentpanel.add(lbl_info);

        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        //Damos Funcionalidades a los Botones
        //Boton de Iniciar El Juego
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (nCartones < 1) {
                        lbl_info.setText("No hay cartones Creados");
                    } else {
                        nCartones = 6;
                        lbl_info.setText("Hay " + nCartones + " creados.");
                        inicioJuego();
                    }
                } catch (Exception err) {
                }
            }
        });

        //Boton de Crear Cartones
        btnCarton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (nCartones == 6) {
                        JOptionPane.showMessageDialog(null, "Has superado el limite de Cartones", "Alerta", JOptionPane.INFORMATION_MESSAGE, null);
                    } else {
                        Carton carton = new Carton();
                        carton.setTitle(" -- Carton " + (nCartones + 1) + " --");
                        Cartones.add(carton);
                        nCartones++;
                    }
                } catch (Exception err) {
                }
            }
        });

        //Boton de Salir
        btnFin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
    }

    public void inicioJuego() {

        boolean existe = false;

        do {
            bola = (int) Math.floor(Math.random() * (90 - 1 + 1) + 1);
            
            if (Bolas.contains(bola) == false && bola != 0) {
                Bolas.add(bola);
                existe = true;
            }
        } while (!existe);
        
        btnInicio.setText(Integer.toString(bola));

        for (Carton nCarton : Cartones) {
            nCarton.buscarNumero(bola);
        }
    }

    public static void main(String[] args) {
        BingoFinal main = new BingoFinal();
    }

}
