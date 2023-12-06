    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterchef.by.neb.v10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

import javax.swing.*;
import java.util.LinkedList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author Nelson
 */
// Politecnico Internacional
// Programacion I
// Nelson Bazuto
// Nelson.Bazuto@pi.edu.co
// Ciclo: 3 
 
public class VInicio {
 
       private JFrame frame; // Se declara la variable ´frame´ de tipo JFrame. Para representar interfaz grafica

    // Constructor de la clase
    public VInicio() {
        // Crea la instacia JFrame para la ventana de autenticación
        frame = new JFrame("MasterChef By 2neb V1.0");
        //configura la accion de cierre de ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //establece el tamaño de la ventana de autenticacion
        frame.setSize(500, 300);
        
        
        // Crear un JPanel que cubra toda la ventana y configurar el color de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {//se llama este metodo para pintar el panel 
                super.paintComponent(g);// para mantener la funcionalidad adicional que se haga
                g.setColor(new Color(216, 214, 220)); // configuracion de color
                // Dibuja un rectángulo del tamaño del panel que será el fondo que vamos a pintar
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

            
            panelFondo.setLayout(new GridBagLayout());  // Establece el layout del panel como GridBagLayout
            //Es un gestor de diseño flexible 
            GridBagConstraints gbc = new GridBagConstraints();  // Crea un objeto para las restricciones del layout
            gbc.insets = new Insets(5, 5, 5, 5);  // Se establecen margénes 
            
            // Etiqueta del título
        JLabel labelTitulo = new JLabel("Bienvenido -- MasterChef By 2neb");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 15)); // Establece fuente y tamaño
        labelTitulo.setForeground(Color.BLACK); // Color del texto
        //Establece la posición de la etiqueta en la cuadrícula del GridBagLayout. En este caso, se coloca en la columna 0 y fila 0.
        gbc.gridx = 0;  // Posición en la columna 0
        gbc.gridy = 0;  // Posición en la fila 0
        gbc.gridwidth = 3; // Ocupar dos columnas
        gbc.anchor = GridBagConstraints.PAGE_START; // Alinear al principio del panel

        panelFondo.add(labelTitulo, gbc);  // Agrega la etiqueta al panelFondo

        gbc.insets = new Insets(25, 10, 0, 5); // Establece márgenes para los siguientes componentes

        // Etiqueta y campo de texto para el nombre de usuario
        JLabel labelUsuario = new JLabel("Usuario:");  // Crea la etiqueta Usuario 
        labelUsuario.setFont(new Font("Arial", Font.BOLD, 15)); // Establece fuente y tamaño
        labelUsuario.setForeground(new Color(1, 21, 6)); // Establece el color del texto como blanco
        JTextField campoUsuario = new JTextField(20);  // Crea un campo de texto con una longitud de 20 caracteres
        gbc.gridx = 0;  // Posición en la columna 0
        gbc.gridy = 1;  // Ajustado a la siguiente fila
        gbc.gridwidth = 1; // Restaura el valor a 1 (para que no ocupe más de una columna)
        panelFondo.add(labelUsuario, gbc);  // Agrega la etiqueta al panelFondo
        gbc.gridx = 1;  // Posición en la columna 1
        gbc.gridy = 1;  // Ajustado a la siguiente fila
        panelFondo.add(campoUsuario, gbc);  // Agrega el campo de texto al panelFondo


        // Etiqueta y campo de texto para la contraseña
        JLabel labelContraseña = new JLabel("Contraseña:");  // Crea la Contraseña
        labelContraseña.setFont(new Font("Arial", Font.BOLD, 15)); // Establece fuente y tamaño
        labelContraseña.setForeground(new Color(1, 21, 6)); // Establece el color del texto como blanco
        JPasswordField campoContraseña = new JPasswordField(20);  // Crea un campo de contraseña con una longitud inicial de 20 caracteres

        gbc.gridx = 0;  // Posición en la columna 0
        gbc.gridy = 2;  // Ajustado a la siguiente fila
        panelFondo.add(labelContraseña, gbc);  // Agrega la etiqueta al panelFondo
        gbc.gridx = 1;  // Posición en la columna 1
        gbc.gridy = 2;  // Ajustado a la siguiente fila
        panelFondo.add(campoContraseña, gbc);  // Agrega el campo de contraseña al panelFondo


        // Botón para ingresar
        JButton botonIngresar = new JButton("Ingresar");  // Crea botón Ingresar

        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();  // Obtiene el texto del campo de usuario
                String contraseña = new String(campoContraseña.getPassword());  // Obtiene la contraseña como texto

                if (autenticar(usuario, contraseña)) {  // Verifica la autenticación
                    mostrarVentanaMenu();  // Muestra la ventana del menú
                    frame.dispose();  // Cierra la ventana de autenticación
                } else {
                    // Muestra un mensaje de error si la autenticación falla
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos," + "\n"+ "! Para entrar consulte el Boton datos de inicio !", "Error de inicio", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        botonIngresar.setBackground(new Color(86, 177, 136)); // Cambiar el color del botón
        
        JButton BotonDatos = new JButton("Datos de inicio");

        BotonDatos.addActionListener(e -> {
        JPanel panel = new JPanel(new GridLayout(4, 1)); // Cambio a GridLayout

        JLabel labelUsu = new JLabel("Usuario: Hola");
        labelUsu.setForeground(Color.BLACK);

        JLabel labelPsw = new JLabel("Contraseña: Mundo");
        labelPsw.setForeground(Color.BLACK);

        panel.setBackground(new Color(216, 214, 220));
        panel.add(labelUsu);
        panel.add(labelPsw);
        JOptionPane.showMessageDialog(null, panel, "Datos de Ingreso", JOptionPane.PLAIN_MESSAGE);
        
        });
        BotonDatos.setBackground(new Color(149, 140, 184)); // Cambiar el color del botón 

        gbc.gridx = 0;  // Posición en la columna 0
        gbc.gridy = 4;  // Posición en la fila 4
        gbc.gridwidth = 2; // Ocupar dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Alinear al centro del panel
        panelFondo.add(BotonDatos, gbc);  // Agrega el botón de datos al panelFondo
        
        
        //propiedad del objeto GridBagLayout en que componentes se organizan en una cuadrícula 
        gbc.gridx = 0;  // Posición en la columna 0
        gbc.gridy = 3;  // Posición en la fila 3
        gbc.gridwidth = 2; // Ocupar dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Alinear al centro del panel
        panelFondo.add(botonIngresar, gbc);  // Agrega el botón de ingreso al panelFondo
        
        // Obtener las dimensiones de la pantalla
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Calcular las coordenadas x e y para que la ventana aparezca en el centro
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        // Establecer la ubicación de la ventana en el centro de la pantalla
        frame.setLocation(x, y);
        // Agregar el panelFondo al frame en lugar del panelAutenticacion
        frame.add(panelFondo);  // Agrega el panelFondo al frame
        frame.setVisible(true);  // Hace visible el frame (ventana)
    }


    // Método para autenticar el usuario
    private boolean autenticar(String usuario, String contraseña) {
        return usuario.equals("Hola") && contraseña.equals("Mundo");
    }


    // Método para mostrar la ventana del menú principal
private void mostrarVentanaMenu() {
    // Crear un JFrame para el menú principal
    JFrame menuFrame = new JFrame("MasterChef - Menú Principal");
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuFrame.setSize(400, 300);// tañamo
    menuFrame.setLocationRelativeTo(null);//centrar la ventana

    // Crear un JPanel para el menú con GridBagLayout
    JPanel panelMenu = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(20, 20, 20, 20); // Espaciado en todos los lados
    panelMenu.setBackground(new Color(216, 214, 220));// se define el color del panel

    // Añadir título centrado en la parte superior
    JLabel labelTitulo = new JLabel("Seleccione la opción que desea consultar");  // Crea una etiqueta con el texto
    labelTitulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));  // fuente de texto
    labelTitulo.setHorizontalAlignment(JLabel.CENTER);  // Centrar el texto horizontal
    labelTitulo.setForeground(new Color(3, 3, 3)); // Color de texto

    gbc.gridx = 0;  // Posición en la columna 0
    gbc.gridy = 0;  // Posición en la fila 0
    gbc.gridwidth = 2; // Ocupar dos columnas
    gbc.anchor = GridBagConstraints.PAGE_START; // Alinear al principio del panel
    panelMenu.add(labelTitulo, gbc);  // Agrega la etiqueta al panelMenu
    


    // Crear un JComboBox personalizado para el menú desplegable
    String[] opcionesMenu = {
        "Jurados",
        "Participantes",
        "Restaurantes",
        "Entradas",
        "Platos fuertes",
        "Ingrediente principal",
        "Tiempo de preparación",
        "Postres",
        "Recomendado",
        "Mapa del sitio"
    };
    
    JComboBox<String> comboBoxMenu = new JComboBox<String>(opcionesMenu);
    comboBoxMenu.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar en X
    comboBoxMenu.setPreferredSize(new Dimension(200, 40)); // Tamaño menu

    // Crear un botón para seleccionar una opción del menú
    JButton botonSeleccionar = new JButton("Entrar");  // Crea botón Entrar

    botonSeleccionar.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) {
            // Obtener el nombre del menu seleccionado del JComboBox
            String nombreMenuSeleccionado = (String) comboBoxMenu.getSelectedItem();

       // Obtener la instancia del menu
       
           String menu = nombreMenuSeleccionado;

            // Mostrar la información del menu
//            mostrarInformacion(menu);

                switch (nombreMenuSeleccionado) 
                {
                    case "Jurados":                                                
                    // utilizacion  de jtable
                        
                                JFrame Jurado = new JFrame("Jurados - Uso Jtable | Politecnico Internacional");
                                Jurado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la operación de cierre predeterminada
                                Jurado.setLocationRelativeTo(null);//centrar la ventana
                                DefaultTableModel TablaJurado = new DefaultTableModel(); // Crear la tabla de datos
                                Jurado.setSize(400, 300); // Establecer el tamaño de la ventana
                                
                                // Agregar columnas al modelo de datos
                                TablaJurado.addColumn("Nombre");
                                TablaJurado.addColumn("Ciudad");
                                TablaJurado.addColumn("Restaurante principal");

                                // Agregar filas al modelo de datos
                                TablaJurado.addRow(new Object[]{"Jorge Rausch", "Bogotá", "Criterión"});
                                TablaJurado.addRow(new Object[]{"Nicolás de Zubiría", "Cartagena", "Kong"});
                                TablaJurado.addRow(new Object[]{"Christopher Carpentier", "Santiago de Chile", "Patrón Bistro"});
                                TablaJurado.addRow(new Object[]{"", "", ""});
                                TablaJurado.addRow(new Object[]{"Nombre", "Ciudad", "Rol en el programa"});
                                TablaJurado.addRow(new Object[]{"Claudia Bahamón", "Neiva", "Presentadora"});
                                                                
                                JTable table = new JTable(TablaJurado); // Crear una instancia de JTable con el modelo de datos
                                JScrollPane scrollPane = new JScrollPane(table); // Agregar la tabla a un JScrollPane

                                // Crear un panel separado para el botón Volver
                               JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

                                // Crea botón volver
                                JButton botonVolver1 = new JButton("Volver");
                                botonVolver1.setPreferredSize(new Dimension(80, 30)); // Ajustar el ancho y alto del botón
                                    botonVolver1.addActionListener(V1 -> {
                                    Jurado.dispose();
//                                        System.exit(0);
                                    });                                

                                    
                                // Crear un panel para contener el contenido
                                JPanel panelContenido = new JPanel(new BorderLayout());

                                // Agregar el JScrollPane al panel de contenido
                                panelContenido.add(scrollPane, BorderLayout.CENTER);

                                // Agregar el botón Salir al panel de contenido
                              //  GridLayout(4, 2)); // Cambio a GridLayout
                                panelContenido.add(botonVolver1, BorderLayout.SOUTH);

                                Jurado.setContentPane(panelContenido); // Establecer el panel de contenido en el JFrame Jurado
                                Jurado.setSize(800, 300); // Establecer el tamaño de la ventana
                                Jurado.setLocationRelativeTo(null);// Establecer la ubicación de la ventana en el centro de la pantalla
                                Jurado.setVisible(true);                                 // Hacer que la ventana sea visible
                                break;
                                
//                        return new Jurados2();
                    case "Participantes":
                                // Crear y configurar el JFrame de participantes
                            JFrame frame2 = new JFrame("Participantes - Uso ListaEnlazada | Politecnico Internacional");
                            frame2.setSize(500, 200);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
  
                            // Configurar el diseño del panel principal
                            JPanel mainPanel2 = new JPanel(new BorderLayout());

                            // Crear una lista enlazada de objetos Restaurante
                            LinkedList<Ganadores> ganadores = new LinkedList<>();
                            ganadores.add(new Ganadores("Piter Albeiro", "Temporada 1", 2018));
                            ganadores.add(new Ganadores("Adriana Lucía", "Temporada 2", 2019));
                            ganadores.add(new Ganadores("Carla Giraldo", "Temporada 3", 2021));
                            ganadores.add(new Ganadores("Ramiro Meneses", "Temporada 4", 2022));
                            ganadores.add(new Ganadores("Carolina Acevedo", "Temporada 5", 2023));

/////////////////////////////////////////////////////
                           // Crear un JTextArea para mostrar la lista de restaurantes
                            JTextArea ganadoresTextArea = new JTextArea();
                            ganadoresTextArea.setEditable(false);

                            // Agregar la lista de restaurantes al JTextArea
                            for (int i = 0; i < ganadores.size(); i++) {
                                ganadoresTextArea.append((i + 1) + ". " + ganadores.get(i) + "\n");
                            }

                            // Botón para mostrar mensaje de volver
                            JButton btnSalir2 = new JButton("Volver");
                            btnSalir2.addActionListener(ea -> {
//                                JOptionPane.showMessageDialog(frame2, "Acabaste de ver los ganadores de MasterChef Celebrity.  | nelson.bazurto@pi.edu.co");
                                frame2.dispose();
                            });
/////////////////////////////////////////////
                            // Agregar componentes al panel principal
                            mainPanel2.add(new JLabel("Ganadores :"), BorderLayout.NORTH);
                            mainPanel2.add(new JScrollPane(ganadoresTextArea), BorderLayout.CENTER);
                            mainPanel2.add(btnSalir2, BorderLayout.SOUTH);

                            // Agregar el panel principal al JFrame
                            frame2.add(mainPanel2);

                            // Hacer visible el JFrame
                            frame2.setVisible(true);                                                    
                          break;
                          
                    case "Restaurantes":
                            JFrame Menu10 = new JFrame("Restaurantes - Uso de JTable | Politecnico Internacional");
                            DefaultTableModel Tabla10 = new DefaultTableModel();

                            // Agregar columnas al modelo de datos
                            Tabla10.addColumn("Chef");
                            Tabla10.addColumn("Restaurante");
                            Tabla10.addColumn("Ciudad");

                            // Agregar filas al modelo de datos
                            Tabla10.addRow(new Object[]{"Jorge Rausch", "Criterión", "Bogotá"});
                            Tabla10.addRow(new Object[]{"Nicolás de Zubiría", "Kong", "Cartagena" });
                            Tabla10.addRow(new Object[]{"Christopher Carpentier", "Patrón Bistro", "Santiago de Chile"});

                            // Crear una instancia de JTable con el modelo de datos
                            JTable Tablaa = new JTable(Tabla10);

                            // Crear un JPanel para contener la tabla y los botones
                            JPanel panel = new JPanel(new BorderLayout());

                            // Agregar la tabla al panel
                            panel.add(new JScrollPane(Tablaa), BorderLayout.CENTER);

                            // Crear botones
                            JButton volverButton10 = new JButton("Volver");
                            JButton salirButton = new JButton("Salir");

                            // Crear un JPanel para contener los botones
                            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            buttonPanel.add(volverButton10);
                            buttonPanel.add(salirButton);

                            // Agregar el panel de botones al panel principal en la parte inferior
                            panel.add(buttonPanel, BorderLayout.SOUTH);

                            // Agregar el panel al JFrame
                            Menu10.add(panel);

                            // Establecer el tamaño de la ventana
                            Menu10.setSize(400, 200);

                            // Centrar la ventana en la pantalla
                            Menu10.setLocationRelativeTo(null);

                            // Establecer la operación de cierre predeterminada
                            Menu10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                            // Hacer que la ventana sea visible
                            Menu10.setVisible(true);

                            // Agregar ActionListener para los botones
                            volverButton10.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Lógica para el botón Volver
                                Menu10.dispose();                                    
//                                    JOptionPane.showMessageDialog(null, "Botón Volver presionado");
                                }
                            });

                            salirButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Lógica para el botón Salir
                                    System.exit(0);
                                }
                            });                        
                          break;
                           
                    case "Entradas":
                          Entradaa Entraa = new Entradaa();                        
                          Entraa.MiEntrada();                       
                          break;
                          
                    case "Platos fuertes":
                          PlatoFuerte PlatoF = new PlatoFuerte();                        
                          PlatoF.MiPLato();                        
                          break;
                          
                    case "Ingrediente principal":
                          IngredientePrincipal Ingred = new IngredientePrincipal();
                          Ingred.MiIngrediente();
                          break;

                    case  "Tiempo de preparación":
                          TiempoPrepara TiempoP = new TiempoPrepara();
                          TiempoP.MiTiempo();
                          break;                          

                    case  "Postres":
                        Postree post = new Postree();
                        post.MiPostre();
                          break;                                                   
                          
                    case "Recomendado":
                          Restaurantes restaurante = new Restaurantes();                        
                          mostrarInformacion(restaurante);
                          break;
                    
                    case "Mapa del sitio":
                        // Crear una instancia de JFrame
                        JFrame FrameArbol = new JFrame("MasterChef By 2neb JTree");

                        // Crear el nodo raíz
                        DefaultMutableTreeNode MiArbolito = new DefaultMutableTreeNode("MasterChef");

                        // nodo 2
                        DefaultMutableTreeNode Nivel1Node1 = new DefaultMutableTreeNode("Restaurantes recomendados");
                        // Crear nodos para el 2 nivel
                        DefaultMutableTreeNode Nivel2Node1 = new DefaultMutableTreeNode("Criterión");
                        DefaultMutableTreeNode Nivel3Node1 = new DefaultMutableTreeNode("Kong");
                        DefaultMutableTreeNode Nivel4Node1 = new DefaultMutableTreeNode("Patrón Bistro");        
                        // Agregar nodos al 1 nivel
                        Nivel1Node1.add(Nivel2Node1);
                        Nivel1Node1.add(Nivel3Node1);
                        Nivel1Node1.add(Nivel4Node1);

                        // Crear nodos para el primer nivel
                        DefaultMutableTreeNode Nivel1Node2 = new DefaultMutableTreeNode("Chef y Jurados");
                        // Crear nodos para el 1 nivel
                        DefaultMutableTreeNode Nivel2Node2 = new DefaultMutableTreeNode("Jorge Rausch");
                        DefaultMutableTreeNode Nivel3Node2 = new DefaultMutableTreeNode("Nicolás de Zubiría");
                        DefaultMutableTreeNode Nivel4Node2 = new DefaultMutableTreeNode("Christopher Carpentier");
                        // Agregar nodos al 1 nivel
                        Nivel1Node2.add(Nivel2Node2);
                        Nivel1Node2.add(Nivel3Node2);
                        Nivel1Node2.add(Nivel4Node2);

                        //nodo 3
                        DefaultMutableTreeNode Nivel1Node3 = new DefaultMutableTreeNode("Entradas recomendadas");
                        // Crear menu nodo 3
                        DefaultMutableTreeNode Nivel2Node3 = new DefaultMutableTreeNode("Pulpo al Olivo");
                        DefaultMutableTreeNode Nivel3Node3 = new DefaultMutableTreeNode("Carpaccio de Salmon");
                        DefaultMutableTreeNode Nivel4Node3 = new DefaultMutableTreeNode("Sopa de tomate");
                        // Agregar nodos al 1 nivel
                        Nivel1Node3.add(Nivel2Node3);
                        Nivel1Node3.add(Nivel3Node3);
                        Nivel1Node3.add(Nivel4Node3);

                        //nodo 4        
                        DefaultMutableTreeNode Nivel1Node4 = new DefaultMutableTreeNode("Platos Fuertes recomendados");
                        // Crear menu nodo 4
                        DefaultMutableTreeNode Nivel2Node4 = new DefaultMutableTreeNode("TomaHawk");
                        DefaultMutableTreeNode Nivel3Node4 = new DefaultMutableTreeNode("Pasta a la marinera");
                        DefaultMutableTreeNode Nivel4Node4 = new DefaultMutableTreeNode("Lomo pimienta y queso azul");
                        // Agregar nodos al 1 nivel
                        Nivel1Node4.add(Nivel2Node4);
                        Nivel1Node4.add(Nivel3Node4);
                        Nivel1Node4.add(Nivel4Node4);

                        //nodo 5  
                        DefaultMutableTreeNode Nivel1Node5 = new DefaultMutableTreeNode("Ingrediente principal del plato fuerte");
                        // Crear menu nodo 4
                        DefaultMutableTreeNode Nivel2Node5 = new DefaultMutableTreeNode("Carne - Lomo y costilla");
                        DefaultMutableTreeNode Nivel3Node5 = new DefaultMutableTreeNode("Pasta - Mariscos");
                        DefaultMutableTreeNode Nivel4Node5 = new DefaultMutableTreeNode("Carne - BabyBeef - Pimienta y queso azul");
                        // Agregar nodos al 1 nivel
                        Nivel1Node5.add(Nivel2Node5);
                        Nivel1Node5.add(Nivel3Node5);
                        Nivel1Node5.add(Nivel4Node5);        

                        //nodo 6 
                        DefaultMutableTreeNode Nivel1Node6 = new DefaultMutableTreeNode("tiempo de preparación del plato fuerte");
                        // Crear menu nodo 4
                        DefaultMutableTreeNode Nivel2Node6 = new DefaultMutableTreeNode("35 minutos");
                        DefaultMutableTreeNode Nivel3Node6 = new DefaultMutableTreeNode("30 minutos");
                        DefaultMutableTreeNode Nivel4Node6 = new DefaultMutableTreeNode("35 minutos");
                        // Agregar nodos al 1 nivel
                        Nivel1Node6.add(Nivel2Node6);
                        Nivel1Node6.add(Nivel3Node6);
                        Nivel1Node6.add(Nivel4Node6);        

                        //nodo 7
                        DefaultMutableTreeNode Nivel1Node7 = new DefaultMutableTreeNode("Postres recomendados");
                        // Crear menu nodo 4
                        DefaultMutableTreeNode Nivel2Node7 = new DefaultMutableTreeNode("Tartufino de avellana");
                        DefaultMutableTreeNode Nivel3Node7 = new DefaultMutableTreeNode("Volcan de chocolate");
                        DefaultMutableTreeNode Nivel4Node7 = new DefaultMutableTreeNode("Strudel de manzana");
                        // Agregar nodos al 1 nivel
                        Nivel1Node7.add(Nivel2Node7);
                        Nivel1Node7.add(Nivel3Node7);
                        Nivel1Node7.add(Nivel4Node7);                

                /////////////////////////////////////////////////////////        
                        // Agregar nodos al PanelArboll
                        MiArbolito.add(Nivel1Node1);
                        MiArbolito.add(Nivel1Node2);
                        MiArbolito.add(Nivel1Node3);
                        MiArbolito.add(Nivel1Node4);
                        MiArbolito.add(Nivel1Node5);
                        MiArbolito.add(Nivel1Node6);
                        MiArbolito.add(Nivel1Node7);

                        // Crear un modelo de árbol con el nodo raíz
                        DefaultTreeModel treeModel = new DefaultTreeModel(MiArbolito);

                        // Crear una instancia de JTree con el modelo de árbol
                        JTree tree = new JTree(treeModel);

                        // Agregar el JTree a un JScrollPane
                //        JScrollPane scrollPane = new JScrollPane(tree);

                        // Agregar el JScrollPane al JFrame
                //        FrameArbol.add(scrollPane);

                ///
                        // Crear un JPanel para contener el JTree y los botones
                        JPanel PanelArbol = new JPanel();
                        PanelArbol.add(new JScrollPane(tree));

                        // Agregar botones
                        JButton volverButton2 = new JButton("Volver");
                            volverButton2.addActionListener(e2a -> {
//                                JOptionPane.showMessageDialog(frame2, "Acabaste de ver los ganadores de MasterChef Celebrity.  | nelson.bazurto@pi.edu.co");
                                FrameArbol.dispose();
                            });
                            
                        // boton salir
                        JButton botonSalir2 = new JButton("Salir");
                           botonSalir2.addActionListener(es -> {
                           System.exit(0);
                    });
                            botonSalir2.setBackground(new Color(149, 140, 184)); // Cambiar el color del botón             

                        // Agregar ActionListener a los botones si es necesario

                        PanelArbol.add(volverButton2);
                        PanelArbol.add(botonSalir2);

                        // Agregar el JPanel al JFrame
                        FrameArbol.add(PanelArbol);
                        // Agregar el panel de botones en la parte inferior del JFrame
                //        FrameArbol.add(PanelArbol, BorderLayout.SOUTH);
                ///

                        // Establecer el tamaño de la ventana
                        FrameArbol.setSize(400, 500);

                        // Establecer la operación de cierre predeterminada
                        FrameArbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        FrameArbol.setLocationRelativeTo(null);//centrar la ventana
                        // Hacer que la ventana sea visible
                        FrameArbol.setVisible(true);                    
                         break;   
                    
                    default:
//                        return null;
                }
        }


class Ganadores {
    private String nombre;
    private String tipoCocina;
    private int calificacion;

    public Ganadores(String nombre, String tipoCocina, int calificacion) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipoCocina + " (año: " + calificacion + ")";
    }
}
        
        
        
        
        

    });
        
    
    botonSeleccionar.setBackground(new Color(211, 136, 245)); // Cambiar el color del botón     

    // Crea botón Salir
    JButton botonSalir = new JButton("Salir y creditos");
        botonSalir.addActionListener(e -> {
        JPanel panel = new JPanel(new GridLayout(4, 2)); // Cambio a GridLayout

        JLabel label1 = new JLabel("MasterChef By 2neb");
//        label1.setForeground(Color.BLACK);

        JLabel label2 = new JLabel("Nelson.Bazurto@pi.edu.co");
//        label2.setForeground(Color.BLACK);

        JLabel label3 = new JLabel("Extructura de Datos y Programación I");
//        label3.setForeground(Color.BLACK);
        JLabel label4 = new JLabel("Ciclo 3");
        
        panel.setBackground(new Color(216, 214, 220));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        JOptionPane.showMessageDialog(null, panel, "Desarrollado por:", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    });
    botonSalir.setBackground(new Color(149, 140, 184)); // Cambiar el color del botón             

    
    // Agregar el JComboBox y los botones al panel usando GridBagConstraints
    gbc.gridx = 0;
    gbc.gridy = 1; // se configura para que el indice este debajo del titulo
    panelMenu.add(comboBoxMenu, gbc);  // Agrega el JComboBox al panel en la fila 1

    gbc.gridy = 2;// Agrega el botón "Seleccionar" al panel en la fila 2
    panelMenu.add(botonSeleccionar, gbc);   
    
    gbc.gridx = 1;
    gbc.gridy = 3; // Cambia la coordenada Y para posicionar el botón en la fila 2
    gbc.anchor = GridBagConstraints.SOUTHEAST; // Alinea el componente en la esquina inferior derecha
    panelMenu.add(botonSalir, gbc);  

    // Agregar el panel al marco del menú
    menuFrame.add(panelMenu, BorderLayout.CENTER);  

    // Hacer visible el menú
    menuFrame.setVisible(true);  
}



    // Método para mostrar información detallada de un equipo en un cuadro de diálogo
private void mostrarInformacion (Menu menu) {
    // Verificar si el equipo no es nulo
    if (menu != null) {
        // Crear un cuadro de diálogo con la información del Menu
        JOptionPane optionPane = new JOptionPane(
            // Construir el mensaje con detalles del Menu
            "Información del restaurante recomendado "+ "\n" +
            "Restaurante : " + menu.getRestaurantE()+ "\n" +
            "Dirección : " + menu.getDireccioN() + "\n" +
            "Entrada: " + menu.getEntradA() + "\n" +
            "Plato fuerte : " + menu.getPlatoFuertE() + "\n" +
            "Ingrediente principal : " + menu.getIngredientE() + "\n" +
            "Tiempo de preparacion : " + menu.getTiempoPreparA()+ "\n" +
            "Postre : " + menu.getPostrE() + "\n" +
            "Coctel : " + menu.getCocteL(), // + "\n" +
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            new Object[]{"Regresar"}, // Etiqueta del botón
            null 
        );

        // Crear y mostrar el diálogo
        JDialog dialog = optionPane.createDialog("Uso del - JOptionPane ");
        dialog.setVisible(true);

        // Restaurar el color de texto por defecto
        UIManager.put("OptionPane.messageForeground", UIManager.getColor("OptionPane.messageForeground"));
    }
}


      
} //cierra clase
