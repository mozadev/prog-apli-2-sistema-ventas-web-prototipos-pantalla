package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                
            }
        }catch(Exception e){
            
        }
        return c;
        
    }
    
    
    
    
    
    
    
    
    //*******Operaciones CRUD *****************//
    //Operaciones con CRUD
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);

            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Cliente cl) {
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente emp = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setDireccion(rs.getString(4));
                emp.setEstado(rs.getString(5));

            }
        } catch (Exception e) {

        }
        return emp;
    }

    public int actualizar(Cliente em) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getDireccion());
            ps.setString(4, em.getEstado());
           ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}
