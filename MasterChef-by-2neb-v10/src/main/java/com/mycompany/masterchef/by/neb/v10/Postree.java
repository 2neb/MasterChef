/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterchef.by.neb.v10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
  * @author Nelson
 */
// Politecnico Internacional
// Programacion I
// Nelson Bazuto
// Nelson.Bazuto@pi.edu.co
// Ciclo: 3 
public class Postree {
    
/*    
    public Postree()
    {
        
    }
*/    
  
public void MiPostre()
{
                            JFrame Menu11 = new JFrame("Postres - Uso de JTable | Politecnico Internacional");
                            DefaultTableModel Tabla11 = new DefaultTableModel();

                            // Agregar columnas al modelo de datos
                            Tabla11.addColumn("Chef");
                            Tabla11.addColumn("Restaurante");
                            Tabla11.addColumn("Ciudad");
                            Tabla11.addColumn("Postres");
                            

                            // Agregar filas al modelo de datos
                            Tabla11.addRow(new Object[]{"Jorge Rausch", "Criterión", "Bogotá", "Tartufino de avellana"});
                            Tabla11.addRow(new Object[]{"Nicolás de Zubiría", "Kong", "Cartagena", "Volcan de chocolate"});
                            Tabla11.addRow(new Object[]{"Christopher Carpentier", "Patrón Bistro", "Santiago de Chile", "Strudel de manzana"});

                            // Crear una instancia de JTable con el modelo de datos
                            JTable Tablaa11 = new JTable(Tabla11);

                            // Crear un JPanel para contener la tabla y los botones
                            JPanel panel11 = new JPanel(new BorderLayout());

                            // Agregar la tabla al panel
                            panel11.add(new JScrollPane(Tablaa11), BorderLayout.CENTER);

                            // Crear botones
                            JButton volverButton11 = new JButton("Volver");
                            JButton salirButton11 = new JButton("Salir");

                            // Crear un JPanel para contener los botones
                            JPanel buttonPanel11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            buttonPanel11.add(volverButton11);
                            buttonPanel11.add(salirButton11);

                            // Agregar el panel de botones al panel principal en la parte inferior
                            panel11.add(buttonPanel11, BorderLayout.SOUTH);

                            // Agregar el panel al JFrame
                            Menu11.add(panel11);

                            // Establecer el tamaño de la ventana
                            Menu11.setSize(800, 200);

                            // Centrar la ventana en la pantalla
                            Menu11.setLocationRelativeTo(null);

                            // Establecer la operación de cierre predeterminada
                            Menu11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                            // Hacer que la ventana sea visible
                            Menu11.setVisible(true);

                            // Agregar ActionListener para los botones
                            volverButton11.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Lógica para el botón Volver
                                Menu11.dispose();                                    
//                                    JOptionPane.showMessageDialog(null, "Botón Volver presionado");
                                }
                            });

                            salirButton11.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Lógica para el botón Salir
                                    System.exit(0);
                                }
                            });                         
}
    
    
}
