/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepivsky.sistema.gui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pepivsky.sistema.datos.BaseDatos;
import pepivsky.sistema.pojos.CategoriaProd;
import pepivsky.sistema.pojos.Producto;
import pepivsky.sistema.pojos.Proveedor;

/**
 *
 * @author PP
 */
public class NuevoProductoFrame extends javax.swing.JDialog {
    
    DefaultComboBoxModel <CategoriaProd> modeloCategorias;
    DefaultComboBoxModel <Proveedor> modeloProveedor;
    
    BaseDatos base = new BaseDatos();
    boolean estaActualizando;
    String informacion = "";

    /**
     * nuevo constructor
     */
    
    public NuevoProductoFrame(java.awt.Frame parent, boolean modal, Producto producto, ImageIcon icon, String titulo, boolean actualizando) {
        super(parent, modal);
        modeloCategorias = new DefaultComboBoxModel<CategoriaProd>();
        modeloProveedor = new DefaultComboBoxModel<Proveedor>();
        base = new BaseDatos();
        cargarModeloCategoria();
        cargarModeloProveedor();
        initComponents();
        this.estaActualizando = actualizando;
        this.setTitle(titulo);
        if(producto!=null){
            cargarProducto(producto, icon);
        }
        
    }
    
    /**
     * Constructo antiguo
     */
    /*public NuevoProductoFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        modeloCategorias = new DefaultComboBoxModel<CategoriaProd>();
        modeloProveedor = new DefaultComboBoxModel<Proveedor>();
        
        cargarModeloCategoria();
        cargarModeloProveedor();

        initComponents();
    }*/
    
    
    private void cargarProducto(Producto producto, ImageIcon icono){
        
        /*//Redimensión de imagen para ajustarla al tamaño del JLabel.
        Image imgProd = icono.getImage();
        int anchoEtiqueta = lblImagenArticulo.getWidth(); //Obtiene ancho de la imagen
        int altoEtiqueta = lblImagenArticulo.getHeight(); //Obtiene alto de la imagen
                
        //Se crea un nuevo objeto Image con la imagen redimensionada.
        Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
               
        //Se crea un nuevo objeto ImageIcon a partir de la imagen redimensionada.
        ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);*/
        
        lblImagenArticulo.setIcon(icono);
        String clave = producto.getIdProducto();
        String nombre = producto.getNombreProducto();
        String descripcion = producto.getDescripcionProducto();
        double stockRequerido = producto.getStockProducto();
        String unidad = producto.getUnidadProducto();
        double precioCompra = producto.getPrecioCompaProducto();
        double precioVenta = producto.getPrecioVentaProducto();
        
        campoClave.setText(clave);
        campoNombre.setText(nombre);
        campoDesc.setText(descripcion);
        campoStock.setText(String.valueOf(stockRequerido));
        comboUnidad.setSelectedItem(unidad);
        campoPrecioCompra.setText(String.valueOf(precioCompra));
        campoPrecioVenta.setText(String.valueOf(precioVenta));
        
        //Campos inhabilitados para que no se puedan modificar
        campoClave.setEnabled(false);
        campoNombre.setEnabled(false);
    }
    
    private void cargarModeloCategoria(){
        ArrayList<CategoriaProd> listaCategorias;
        listaCategorias= base.obtenerCategorias(); //Metodo de la clase Base que obtiene los datos de la base de datos
        //Pasar lista al modelo de categorias con foreach
        for(CategoriaProd categoria: listaCategorias){
            modeloCategorias.addElement(categoria);
        }
        
    }

    private void cargarModeloProveedor(){
        ArrayList<Proveedor> listaProveedores;
        listaProveedores= base.obtenerProveedores(); //Metodo de la clase Base que obtiene los datos de la base de datos
        //Pasar lista al modelo de categorias con foreach
        for(Proveedor proveedor: listaProveedores){
            modeloProveedor.addElement(proveedor);
        }
        
    }
    
    public String getInformacion(){
        return this.informacion;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboUnidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        campoPrecioCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoPrecioVenta = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImagenArticulo = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Clave:");

        jLabel2.setText("Stock requerido:");

        jLabel3.setText("Categoría:");

        comboCategoria.setModel(modeloCategorias);

        jButton1.setText("Nueva categoría");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Unidad de medida:");

        comboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Pieza", "Litro" }));

        jLabel6.setText("Precio de compra:");

        jLabel7.setText("Precio de venta:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblImagenArticulo.setText("imagen");
        lblImagenArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboProveedor.setModel(modeloProveedor);

        jLabel8.setText("Proveedor");

        jLabel9.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboUnidad, 0, 104, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(campoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(comboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton3))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File imgArticleFile;
    private void lblImagenArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMousePressed
        // TODO add your handling code here:
        JFileChooser chooser  = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Carga archivos de imagen", "jpg","gif","png");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            int anchoImagen = lblImagenArticulo.getWidth();
            int altoImagen = lblImagenArticulo.getHeight();
            
            imgArticleFile = chooser.getSelectedFile();
            ImageIcon icono = new ImageIcon(imgArticleFile.getAbsolutePath());
            Image imagen = icono.getImage();
            imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);
            
            ImageIcon iconoRedimensionado = new ImageIcon(imagen);
            
            lblImagenArticulo.setIcon(iconoRedimensionado);
            
            
            
            
        }
        
    }//GEN-LAST:event_lblImagenArticuloMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Obteniendo los valores del frame
        String clave = campoClave.getText();
        String nombre = campoNombre.getText();
        String desc = campoDesc.getText();
        double stock = Double.parseDouble(campoStock.getText()); //Convierte a double
        double precioCompra = Double.parseDouble(campoPrecioCompra.getText());
        double precioVenta= Double.parseDouble(campoPrecioVenta.getText());
        
        String unidad = comboUnidad.getSelectedItem().toString();
        CategoriaProd categoria = (CategoriaProd) comboCategoria.getSelectedItem();
        Proveedor  proveedor = (Proveedor)comboProveedor.getSelectedItem();
        
        
        
        /*
        if(estaActualizando){
            
        }
        
        if (imgArticleFile == null) {
            Producto producto = new Producto(clave, nombre, desc, 
                    stock, null, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                
                 base.actualizarProducto(producto, false);
            
        }else{
         
            //Creando el objeto Producto
        Producto producto = new Producto(clave, nombre, desc, 
                    stock, imgArticleFile, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                    
                    base.actualizarProducto(producto, true);
        }
        
        JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
        this.dispose();
                
        
        //Creando el objeto Producto
        Producto producto = new Producto(clave, nombre, desc, 
                    stock, imgArticleFile, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                    
                    base.insertarProducto(producto);*/
        
        if(estaActualizando){
            if(imgArticleFile == null){
                Producto producto = new Producto(clave, nombre, desc, 
                    stock, null, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                
                 base.actualizarProducto(producto, false);
            }
            else{
                Producto producto = new Producto(clave, nombre, desc, 
                    stock, imgArticleFile, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                
                 base.actualizarProducto(producto, true);
            }
            
            JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
            this.dispose();
            informacion = "1";
            
            if(imgArticleFile == null ){
                JOptionPane.showMessageDialog(this, "No ha elegido una fotografía de producto");
            }
            else{
                Producto producto = new Producto(clave, nombre, desc, 
                    stock, imgArticleFile, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());

                base.insertarProducto(producto);

                JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
                this.dispose();
            }
        }else{
            
            
            if(imgArticleFile == null ){
                JOptionPane.showMessageDialog(this, "No ha elegido una fotografía de producto");
            }
            else{
                Producto producto = new Producto(clave, nombre, desc, 
                    stock, imgArticleFile, unidad, precioCompra, precioVenta, 
                    0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());

                base.insertarProducto(producto);

                JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoProductoFrame dialog = new NuevoProductoFrame(new javax.swing.JFrame(), true, null, null, null, false);
                //NuevoProductoFrame dialog = new NuevoProductoFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoDesc;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioCompra;
    private javax.swing.JTextField campoPrecioVenta;
    private javax.swing.JTextField campoStock;
    private javax.swing.JComboBox<CategoriaProd> comboCategoria;
    private javax.swing.JComboBox<Proveedor> comboProveedor;
    private javax.swing.JComboBox<String> comboUnidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagenArticulo;
    // End of variables declaration//GEN-END:variables
}
