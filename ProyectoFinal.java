import javax.swing.*;

public class ProyectoFinal {
public static void main(String[] args) {
JFrame frame = new JFrame("Mi primera Ventana");
  frame.setSize(600, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.setLayout(null);

  JLabel etiqueta_anuncio = new JLabel(" ¡Hola, somos Mafer y Sam! ");
  JLabel etiqueta_2 = new JLabel("Prueba");
  JLabel etiqueta_3 = new JLabel("Prueba encima 1");
  JLabel etiqueta_4 = new JLabel("Prueba encima 2");
  JButton button = new JButton ("Enviar");
  JLabel nombre_usuario = new  JLabel ("Nombre de Usuario");
  JTextField textField = new JTextField(20);

  etiqueta_anuncio.setBounds(30, 50, 100, 30); 
  etiqueta_2.setBounds(300, 50, 200, 30);
  etiqueta_3.setBounds(30,90, 100,30);
  etiqueta_4.setBounds( 300, 90, 150, 30);
  button.setBounds(100, 120, 150, 30); 
  nombre_usuario.setBounds(100, 180, 200, 30);
  textField.setBounds(200, 160, 200, 30);

  // Agregar los componentes al JFrame
  frame.add(etiqueta_anuncio);
  frame.add(etiqueta_2);
  frame.add(etiqueta_3);
  frame.add(etiqueta_4);
  frame.add(button);
  frame.add(nombre_usuario);

  // Hacer visible la ventana
  frame.setVisible(true);
  }

  
