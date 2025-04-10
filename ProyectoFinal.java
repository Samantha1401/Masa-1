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
