
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
       Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where idproducto="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                 p.setPrecio(rs.getDouble(3));
                 p.setStock(rs.getInt(4));
                 p.setEstado(rs.getString(5));
            }
        } catch(Exception e){
            
        }
        return p;
    }
    
    public int actualizarstock(int id,int stock){
        String sql="update  producto set Stock=? where idproducto=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2,id);
            ps.executeUpdate();
        
        } catch(Exception e){
            
        }
        return r;
    }
    
    //*******Operaciones CRUD *****************//
    //Operaciones con CRUD
    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto cl = new Producto();
                cl.setId(rs.getInt(1));
                cl.setNom(rs.getString(2));
                cl.setPrecio(rs.getDouble(3));
                cl.setStock(rs.getInt(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);

            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Producto cl) {
        String sql = "insert into producto( Nombres,Precio,Stock, Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNom());
            ps.setDouble(2, cl.getPrecio());
            ps.setInt(3, cl.getStock());
            ps.setString(4, cl.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public Producto listarId(int id) {
        Producto emp = new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
              
                emp.setNom(rs.getString(2));
                emp.setPrecio(rs.getDouble(3));
                emp.setStock(rs.getInt(4));
                emp.setEstado(rs.getString(5));
                emp.setId(rs.getInt(1));
                  
               

            }
        } catch (Exception e) {

        }
        return emp;
    }

    public int actualizar(Producto em) {
        String sql = "update producto set  Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPrecio());
            ps.setInt(3, em.getStock());
            ps.setString(4, em.getEstado());
           ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}
