import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// ProyectoFinal representa una aplicación de biblioteca con GUI usando Java Swing.
//Permite registro, inicio de sesión y gestión de libros (agregar, editar, eliminar).

public class ProyectoFinal extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;
    private Usuario usuarioActual;

    public ProyectoFinal() {
        setTitle("Sistema de Biblioteca Completo");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialización de listas y layout
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear e integrar paneles en el contenedor principal
        JPanel registroPanel = crearPanelRegistro();
        JPanel loginPanel = crearPanelLogin();
        JPanel bibliotecaPanel = crearPanelBiblioteca();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registroPanel, "Registro");
        mainPanel.add(bibliotecaPanel, "Biblioteca");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login"); // Vista inicial
        setVisible(true);
    }

    //Crea y retorna el panel de registro de nuevos usuarios.

    private JPanel crearPanelRegistro() {
        JPanel panel = new JPanel(null);

        // Etiquetas y campos
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Contraseña:");

        JTextField txtNombre = new JTextField();
        JTextField txtUsuario = new JTextField();
        JTextField txtEmail = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnVolver = new JButton("Volver");

        // Posicionamiento
        lblNombre.setBounds(100, 50, 100, 30);
        txtNombre.setBounds(200, 50, 200, 30);
        lblUsuario.setBounds(100, 90, 100, 30);
        txtUsuario.setBounds(200, 90, 200, 30);
        lblEmail.setBounds(100, 130, 100, 30);
        txtEmail.setBounds(200, 130, 200, 30);
        lblPassword.setBounds(100, 170, 100, 30);
        txtPassword.setBounds(200, 170, 200, 30);
        btnRegistrar.setBounds(200, 220, 100, 30);
        btnVolver.setBounds(100, 220, 80, 30);

        // Lógica del botón "Registrar"
        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String usuario = txtUsuario.getText();
            String email = txtEmail.getText();
            String contrasena = new String(txtPassword.getPassword());
            if (!nombre.isEmpty() && !usuario.isEmpty() && !email.isEmpty() && !contrasena.isEmpty()) {
                usuarios.add(new Usuario(nombre, usuario, email, contrasena));
                JOptionPane.showMessageDialog(this, "¡Registro exitoso!");
                cardLayout.show(mainPanel, "Login");
            } else {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
            }
        });

        // Botón para regresar al panel de login
        btnVolver.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        // Agregar componentes al panel
        panel.add(lblNombre); panel.add(txtNombre);
        panel.add(lblUsuario); panel.add(txtUsuario);
        panel.add(lblEmail); panel.add(txtEmail);
        panel.add(lblPassword); panel.add(txtPassword);
        panel.add(btnRegistrar); panel.add(btnVolver);

        return panel;
    }

    //Crea y retorna el panel de inicio de sesión.
     
    private JPanel crearPanelLogin() {
        JPanel panel = new JPanel(null);

        JLabel lblUsuario = new JLabel("Usuario o Email:");
        JLabel lblPassword = new JLabel("Contraseña:");
        JTextField txtUsuario = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnIngresar = new JButton("Ingresar");
        JButton btnRegistro = new JButton("Registrarse");

        lblUsuario.setBounds(100, 80, 120, 30);
        txtUsuario.setBounds(230, 80, 200, 30);
        lblPassword.setBounds(100, 120, 120, 30);
        txtPassword.setBounds(230, 120, 200, 30);
        btnIngresar.setBounds(230, 170, 100, 30);
        btnRegistro.setBounds(100, 170, 100, 30);

        // Validación de credenciales
        btnIngresar.addActionListener(e -> {
            String user = txtUsuario.getText();
            String pass = new String(txtPassword.getPassword());
            for (Usuario u : usuarios) {
                if ((u.getUsuario().equals(user) || u.getEmail().equals(user)) && u.getContrasena().equals(pass)) {
                    usuarioActual = u;
                    cardLayout.show(mainPanel, "Biblioteca");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Credenciales inválidas");
        });

        // Ir al panel de registro
        btnRegistro.addActionListener(e -> cardLayout.show(mainPanel, "Registro"));

        panel.add(lblUsuario); panel.add(txtUsuario);
        panel.add(lblPassword); panel.add(txtPassword);
        panel.add(btnIngresar); panel.add(btnRegistro);

        return panel;
    }

    //Crea y retorna el panel principal de gestión de libros.
     
    private JPanel crearPanelBiblioteca() {
        JPanel panel = new JPanel(null);

  
