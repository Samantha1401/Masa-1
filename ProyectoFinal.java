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

        // Etiquetas y campos
        JLabel lblTitulo = new JLabel("Título:");
        JLabel lblAutor = new JLabel("Autor:");
        JLabel lblFecha = new JLabel("Fecha:");
        JLabel lblCategoria = new JLabel("Categoría:");
        JLabel lblEditorial = new JLabel("Editorial:");

        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtFecha = new JTextField();
        JTextField txtCategoria = new JTextField();
        JTextField txtEditorial = new JTextField();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        // Tabla y modelo de datos
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Título", "Autor", "Fecha", "Categoría", "Editorial"}, 0
        );
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        // Posiciones
        lblTitulo.setBounds(500, 20, 100, 30);
        txtTitulo.setBounds(600, 20, 150, 30);
        lblAutor.setBounds(500, 60, 100, 30);
        txtAutor.setBounds(600, 60, 150, 30);
        lblFecha.setBounds(500, 100, 100, 30);
        txtFecha.setBounds(600, 100, 150, 30);
        lblCategoria.setBounds(500, 140, 100, 30);
        txtCategoria.setBounds(600, 140, 150, 30);
        lblEditorial.setBounds(500, 180, 100, 30);
        txtEditorial.setBounds(600, 180, 150, 30);

        btnAgregar.setBounds(500, 230, 90, 30);
        btnEditar.setBounds(600, 230, 90, 30);
        btnEliminar.setBounds(700, 230, 90, 30);
        scroll.setBounds(20, 20, 450, 400);

        // Agregar libro
        btnAgregar.addActionListener(e -> {
            Libro libro = new Libro(
                txtTitulo.getText(), txtAutor.getText(), txtFecha.getText(),
                txtCategoria.getText(), txtEditorial.getText()
            );
            libros.add(libro);
            modelo.addRow(new Object[]{
                libro.getTitulo(), libro.getAutor(), libro.getFechaPublicacion(),
                libro.getCategoria(), libro.getEditorial()
            });
        });

        // Editar libro seleccionado
        btnEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                Libro libro = libros.get(fila);
                libro.setTitulo(txtTitulo.getText());
                libro.setAutor(txtAutor.getText());
                libro.setFechaPublicacion(txtFecha.getText());
                libro.setCategoria(txtCategoria.getText());
                libro.setEditorial(txtEditorial.getText());

                modelo.setValueAt(libro.getTitulo(), fila, 0);
                modelo.setValueAt(libro.getAutor(), fila, 1);
                modelo.setValueAt(libro.getFechaPublicacion(), fila, 2);
                modelo.setValueAt(libro.getCategoria(), fila, 3);
                modelo.setValueAt(libro.getEditorial(), fila, 4);
            }
        });

        // Eliminar libro seleccionado
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                libros.remove(fila);
                modelo.removeRow(fila);
            }
        });

        // Añadir todo al panel
        panel.add(lblTitulo); panel.add(txtTitulo);
        panel.add(lblAutor); panel.add(txtAutor);
        panel.add(lblFecha); panel.add(txtFecha);
        panel.add(lblCategoria); panel.add(txtCategoria);
        panel.add(lblEditorial); panel.add(txtEditorial);
        panel.add(btnAgregar); panel.add(btnEditar); panel.add(btnEliminar);
        panel.add(scroll);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProyectoFinal::new);
    }
}

//Clase que representa a un usuario del sistema.

class Usuario {
    private String nombre, usuario, email, contrasena;

    public Usuario(String nombre, String usuario, String email, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getUsuario() { return usuario; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }
}

// Clase que representa un libro en la biblioteca.
 
class Libro {
    private String titulo, autor, fechaPublicacion, categoria, editorial;

    public Libro(String titulo, String autor, String fechaPublicacion, String categoria, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.categoria = categoria;
        this.editorial = editorial;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
}

  
