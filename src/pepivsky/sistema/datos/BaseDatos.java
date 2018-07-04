/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepivsky.sistema.datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pepivsky.sistema.pojos.CategoriaProd;
import pepivsky.sistema.pojos.Producto;
import pepivsky.sistema.pojos.Proveedor;
//import pepivsky.sistema.pojos.Proveedor;
import pepivsky.sistema.pojos.Venta;

/**
 *
 * @author PP
 */
public class BaseDatos {
    Connection conexion = null;
    PreparedStatement pst = null;
    Statement statement = null;
    ResultSet rs = null;
    
   
    public BaseDatos(){
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
       
    }
    }
    
    //Recibe un objeto de tipo Producto
    public void insertarProducto(Producto producto){
        try {
            //Obtener conexión a partir del driver
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            File fileFoto = producto.getFotoProducto();
            FileInputStream fis = new FileInputStream(fileFoto);
            
             String sql = "INSERT INTO cat_productos (id_producto, nombre_producto, descripcion_producto, stock_producto, foto_producto, unidad_producto,"
                    + "precio_compra_producto, precio_venta_producto, existencias_producto, id_categoria_producto, id_proveedor) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            pst = conexion.prepareStatement(sql);
            
            
            pst.setString(1, producto.getIdProducto());
            pst.setString(2, producto.getNombreProducto());
            pst.setString(3, producto.getDescripcionProducto());
            pst.setDouble(4, producto.getStockProducto());
            //Guardar la foto en la BD
            long tamanoFoto = fileFoto.length();
            pst.setBinaryStream(5, fis, tamanoFoto);
            pst.setString(6, producto.getUnidadProducto());
            pst.setDouble(7, producto.getPrecioCompaProducto());
            pst.setDouble(8, producto.getPrecioVentaProducto());
            pst.setDouble(9, producto.getExistenciasProducto());
            pst.setInt(10, producto.getIdCategoriaProd());
            pst.setInt(11, producto.getIdProveedor());
            
            
            pst.executeUpdate();
            
            } catch (SQLException ex) {
            ex.printStackTrace();
            
        } catch(FileNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        
            }
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    
    
    /**
     * Este método devuelve el stream de bytes de la fotografía de un producto guardada en la base de datos.
     * @param producto es el objeto Producto del cual se necesita obtener la fotografía.
     */
    public InputStream buscarFoto(Producto producto){
        InputStream streamFoto = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123");
            
            String sql = "SELECT foto_producto from cat_productos where id_producto = ?";
            
            pst = conexion.prepareStatement(sql);
            pst.setString(1, producto.getIdProducto());
                       
            rs = pst.executeQuery();
            
            while(rs.next()){
                streamFoto = rs.getBinaryStream("foto_producto");
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return streamFoto;
    }
    
    
    
    
    public void actualizarInventario (Producto producto, double cantidad){
        
        try {
            //Obtener conexión a partir del driver
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            //FileInputStream fis = FileInputStream(producto.getFotoProducto());
            
            String sql = "UPDATE cat_productos SET existencias_producto = ? WHERE id_producto = ?";
            
            
            pst = conexion.prepareStatement(sql);
            
            pst.setDouble(1, cantidad);
            pst.setString(2, producto.getIdProducto());
           
            
            
            pst.executeUpdate();
            
           
                    
            
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        //return listaProductos;
        
    }
    
    
    public ArrayList<Producto> obtenerProductos(){
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        try {
            //Obtener conexión a partir del driver
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            //FileInputStream fis = FileInputStream(producto.getFotoProducto());
            
            String sql = "SELECT * FROM cat_productos ORDER BY nombre_producto";
            
            
            pst = conexion.prepareStatement(sql);
            
            
           
            
            
            rs= pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion_producto");
                double stock = rs.getDouble("stock_producto");
                String unidad = rs.getString("unidad_producto");
                double precioCompra = rs.getDouble("precio_compra_producto");
                double precioVenta = rs.getDouble("precio_venta_producto");
                double existencias = rs.getDouble("existencias_producto");
                int idCategoriaProd = rs.getInt("id_categoria_producto");
                int idProveedor = rs.getInt("id_proveedor");
                
                
                Producto producto = new Producto(id, nombre, descripcion, stock,null, unidad, precioCompra, precioVenta, existencias, idCategoriaProd, idProveedor);
                
                listaProductos.add(producto);
            }
                    
            
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return listaProductos;
        
        
    }
    
    
    
    /*
    *Este método obtiene los productos de la base de datos en base a un criterio que se debe cumplir en la clave 
    *del producto o en el nombre del producto.
    *
    */
    
    
    public ArrayList <Producto> obtenerProductosPorCriterio (String criterio){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        try {
            //Obtener conexión a partir del driver
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            
            String sql = "SELECT * FROM cat_productos "
                    + "WHERE id_producto LIKE '%" + criterio + "%'"
                    + "OR nombre_producto LIKE '%" + criterio +"%'"
                    + "order by nombre_producto";
            
            
            statement = conexion.createStatement();
            
            rs= statement.executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion_producto");
                double stock = rs.getDouble("stock_producto");
                String unidad = rs.getString("unidad_producto");
                double precioCompra = rs.getDouble("precio_compra_producto");
                double precioVenta = rs.getDouble("precio_venta_producto");
                double existencias = rs.getDouble("existencias_producto");
                int idCategoriaProd = rs.getInt("id_categoria_producto");
                int idProveedor = rs.getInt("id_proveedor");
                
                
                Producto producto = new Producto(id, nombre, descripcion, stock,null, unidad, precioCompra, precioVenta, existencias, idCategoriaProd, idProveedor);
                
                listaProductos.add(producto);
            }
                    
            
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return listaProductos;
    }
    
    
    
    
    /**
     * Este método permite la actualización de los datos de un producto.
     * @param producto Es el objeto producto que será actualizado.
     * @param cambiarFoto Determina si la fotografía del producto será o no actualizada.
     */
    public void actualizarProducto(Producto producto, boolean cambiarFoto){
        try {
            
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123");
            
            if(cambiarFoto == true){
                File fileFoto = producto.getFotoProducto();
                FileInputStream fis = new FileInputStream(fileFoto);

                String sql = "UPDATE cat_productos SET descripcion_producto=?, stock_producto=?, foto_producto=?, unidad_producto=?, "
                        + "precio_compra_producto=?, precio_venta_producto=?, id_categoria_producto=?, id_proveedor=? "
                        + "WHERE id_producto=?";

                pst = conexion.prepareStatement(sql);

                pst.setString(1, producto.getDescripcionProducto());
                pst.setDouble(2, producto.getStockProducto());
                long tamanoFoto = fileFoto.length();
                pst.setBinaryStream(3, fis, tamanoFoto);
                pst.setString(4, producto.getUnidadProducto());
                pst.setDouble(5, producto.getPrecioCompaProducto());
                pst.setDouble(6, producto.getPrecioVentaProducto());
                pst.setInt(7, producto.getIdCategoriaProd());
                pst.setInt(8, producto.getIdProveedor());
                pst.setString(9, producto.getIdProducto());
            }
            else{

                String sql = "UPDATE cat_productos SET desc_producto=?, stock_producto=?, unidad_producto=?, "
                        + "precio_compra_producto=?, precio_venta_producto=?, id_categoria_producto=?, id_proveedor=? "
                        + "WHERE id_producto=?";

                pst = conexion.prepareStatement(sql);

                pst.setString(1, producto.getDescripcionProducto());
                pst.setDouble(2, producto.getStockProducto());
                pst.setString(3, producto.getUnidadProducto());
                pst.setDouble(4, producto.getPrecioCompaProducto());
                pst.setDouble(5, producto.getPrecioVentaProducto());
                pst.setInt(6, producto.getIdCategoriaProd());
                pst.setInt(7, producto.getIdProveedor());
                pst.setString(8, producto.getIdProducto());
            }

            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    
    public void insertarCategoriaProducto(CategoriaProd categoria){
        try {
            
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            String sql = "INSERT INTO cat_categorias (nom_categoria_producto, descripcion_categoria_producto) "
                    + "values(?, ?)";
            
            pst = conexion.prepareStatement(sql);
            
            pst.setString(1, categoria.getNomCategoria());
            pst.setString(2, categoria.getDescriCategoriaProd());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public ArrayList<CategoriaProd> obtenerCategorias(){
        ArrayList<CategoriaProd> listaCategorias = new ArrayList<CategoriaProd>();
        try {
            
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            String sql = "SELECT * FROM cat_categorias";
            
            pst = conexion.prepareStatement(sql);
            rs= pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_categoria_producto");
                String nombreCategoria = rs.getString("nom_categoria_producto");
                String descripcion = rs.getString("descripcion_categoria_producto");
                
                CategoriaProd categoria = new CategoriaProd(id, nombreCategoria, descripcion);
                listaCategorias.add(categoria);
                
            }
        
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return listaCategorias;
        
        
    }
    
    
    
    
    public void insertarProveedor (Proveedor proveedor){
      try {
            //Obtener conexión a partir del driver
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            String sql = "INSERT INTO cat_proveedores (nom_proveedor, dir_proveedor, telefono_proveedor, "
                    + "email_proveedor, contacto_proveedor) "
                    + "values(?, ?, ?, ?, ? )";
            
            pst = conexion.prepareStatement(sql);
            
            pst.setString(1, proveedor.getNomProveedor());
            pst.setString(2, proveedor.getDirProveedor());
            pst.setString(3, proveedor.getTelefonoProveedor());
            pst.setString(4, proveedor.getEmailProveedor());
            pst.setString(5, proveedor.getContactoProveedor());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<Proveedor> obtenerProveedores(){
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        try {
            
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            String sql = "select * from cat_proveedores";
            
            
            pst = conexion.prepareStatement(sql);
            rs= pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombreProveedor = rs.getString("nom_proveedor");
                String dirProveedor = rs.getString("dir_proveedor");
                String telefonoProveedor = rs.getString("telefono_proveedor");
                String emailProveedor = rs.getString("email_proveedor");
                String contactoProveedor = rs.getString("contacto_proveedor");
                
                
                
                //Proveedor proveedor = new Proveedor(nombreCategoria, descripcion, descripcion, descripcion, descripcion);
                Proveedor proveedor = new Proveedor(id, nombreProveedor, dirProveedor, telefonoProveedor, emailProveedor, contactoProveedor);
                listaProveedores.add(proveedor);
                
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return listaProveedores;
        
        
    }
    
    
    
    
    
    
    public void insertarVenta(Venta venta){
       try {
            //Obtener conexión a partir del driver
           conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base-sistema","postgres","1997"); //Url BD, usuario, password
            
            //FileInputStream fis = FileInputStream(producto.getFotoProducto());
            
            String sql = "insert into ventas (monto_venta ,fecha_venta) "
                    + "values (?,?)"
                    ;
            
            
            pst = conexion.prepareStatement(sql);
            
            
            pst.setDouble(1, venta.getMontoVenta());
            pst.setDate(2, venta.getFechaVenta());
            
            
            
            
            pst.executeUpdate();
            
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Cerrar conexion al terminar
        finally{
            try {
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    
    public static void main(String[] args) {
        /*CategoriaProd categoria = new CategoriaProd(1, "Categoria de prueba", "Descripción de la categoria de prueba");
        BaseDatos base = new BaseDatos();
        
        base.insertarCategoriaProducto(categoria);*/
        
        /*Producto producto = new Producto("ubm123458", "Cocacola", "Refresco", 2, "pieza", 12.35, 13.00, 100, 1, 1);
        BaseDatos base = new BaseDatos();
        base.insertarProducto(producto);*/
        
        /*Venta venta = new Venta(14.6, );
        BaseDatos base = new BaseDatos();
        base.insertarVenta(venta);*/
        
        //Proveedor prov = new Proveedor()
        
        
       
                
                
    }

    
    
    
}
