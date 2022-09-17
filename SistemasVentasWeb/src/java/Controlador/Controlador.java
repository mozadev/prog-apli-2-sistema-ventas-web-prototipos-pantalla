package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.DatosUsuario;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Numero_captura;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Numero_captura num_c = new Numero_captura();
    DatosUsuario datos = new DatosUsuario();
    int ide;
    int idc;
    int idp;
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    List<Venta> lista2 = new ArrayList<>();
    int item;
    int cantd;
    int cod;
    int ite = 0;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie = "";
    int id_empleadoV = 1;
    int cont = 0;
    int cont_null = 0;

    int idepro = 0;
    VentaDAO vdao = new VentaDAO();
    java.util.Date ahora = new java.util.Date();
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String str = session.getAttribute("txtuser").toString();
        String id_emp_logeados = session.getAttribute("id_empleados").toString();
        System.out.println("LOS IDES LOGEADOS SON: "+id_emp_logeados);
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
            // System.out.println("EL NOMBRE DE USUARIO ES: "+datos.getId());
            
        }
        if (menu.equals("Home")) {
         
        
           request.getRequestDispatcher("Home.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtestado");
                    String user = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtestado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.Eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Empleado.jsp").forward(request, response);

        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":

                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Eliminar":

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":

                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Eliminar":

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {

            switch (accion) {
                case "BuscarCliente":
                    cont=0;
                    String dni = request.getParameter("codigocliente");

                    c.setDni(dni);
                    c = cdao.buscar(dni);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    lista.clear();
                    totalPagar = 0;
                    item = 0;

                    break;
                case "BuscarProducto":

                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    System.out.println("esto es el id: " + id);
                    p = pdao.listarId(id);
                    request.setAttribute("producto", p);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);

                    break;
                case "Agregar":
                    int pos = 0;
                    
                    cant = Integer.parseInt(request.getParameter("cant"));
                    idp = p.getId();
                    p = pdao.listarId(idp);

                    if (lista.size() > 0) {
                        for (int i = 0; i < lista.size(); i++) {
                            if (idp == lista.get(i).getIdproducto()) {
                                pos = i;
                            }

                        }
                        if (idp == lista.get(pos).getIdproducto()) {
                          int stock_total= p.getStock();
                            int cant2 = lista.get(pos).getCantidad() ;
                             if(cant2<stock_total){
                                
                                 if((lista.get(pos).getCantidad() + cant)> stock_total){
                                     cant = stock_total;
                                 }
                                 else{
                                    cant = lista.get(pos).getCantidad() + cant;
                                 }
                              }
                              else{
                                 cant = lista.get(pos).getCantidad();
                              }
                                
                            
                            totalPagar = 0.0;
                            
                            
                            //cant = lista.get(pos).getCantidad() + cant;
                            subtotal = lista.get(pos).getPrecio() * cant;
                            lista.get(pos).setCantidad(cant);
                            lista.get(pos).setSubtotal(subtotal);

                            for (int i = 0; i < lista.size(); i++) {
                                totalPagar = totalPagar + lista.get(i).getSubtotal();
                            }
                       
                        
                        
                        } else {
                            totalPagar = 0.0;
                            item = item + 1;
                            cod = p.getId();

                            descripcion = request.getParameter("nomproducto");
                            precio = Double.parseDouble(request.getParameter("precio"));
                            cant = Integer.parseInt(request.getParameter("cant"));
                            subtotal = precio * cant;
                            v = new Venta();
                            v.setItem(item);
                            v.setIdproducto(cod);
                            v.setDesccripcionP(descripcion);
                            v.setPrecio(precio);
                            v.setCantidad(cant);
                            v.setSubtotal(subtotal);
                            lista.add(v);

                            for (int i = 0; i < lista.size(); i++) {
                                totalPagar = totalPagar + lista.get(i).getSubtotal();
                            }
                            cont++;
                         
                        }
                    } else {
                        totalPagar = 0.0;
                        item = item + 1;
                        cod = p.getId();

                        descripcion = request.getParameter("nomproducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDesccripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);

                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                        }
                        cont++;
                    }

                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "EliminarProducto":
                  
                    int idproduct = Integer.parseInt(request.getParameter("idp"));

                    idepro = idproduct;

                    num_c.setNumero_posicion(idepro);

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getIdproducto() == idproduct) {
                            ite = lista.get(i).getItem();
                            System.out.println("ESTE ES EL ITE ORIGINAL: " + ite);

                            lista.remove(i);
                            //lista.get(i+1).setItem(ite);

                        }
                    }

                    //ite = ite - 1;
                    break;
                case "GenerarVenta":
                    //Obteniendo el Idempleado

                    int id_total_emp = Integer.parseInt(id_emp_logeados);
                    //Actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr = aO.buscar(idproducto);
                        int sac = pr.getStock() - cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setIdcliente(c.getId());
                    v.setIdempleado(+id_total_emp);
                    v.setNumserie(numeroserie);
                    v.setFecha(formateador.format(ahora));
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);

                    //Guardar Detalle Ventas
                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);

                    }
                    int obt = Integer.parseInt(numeroserie);
                    numeroserie = "0000000" + (obt + 1);
                    request.setAttribute("nserie", numeroserie);
                    lista.clear();

                    break;
                case "Cancelar":
                    lista.clear();
                    request.setAttribute("producto", p);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    item = 0;

                    break;
                case "RegistrarCantidad":

                    int idpro = Integer.parseInt(request.getParameter("idp"));
                    int canti = Integer.parseInt(request.getParameter("Cantidad"));

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getIdproducto() == idpro) {
                            lista.get(i).setCantidad(canti);
                            double st = lista.get(i).getPrecio() * canti;
                            lista.get(i).setSubtotal(st);
                        }
                    }

                    break;
                case "Carrito":

                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("producto", p);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "ActualizarNro":
                    int pos1 = 0;
                    cont = cont - 1;
               

                    System.out.println("LA POSICION DEL ITE ES: " + (ite + 1));
                    System.out.println("DINOS EL TOTAL CONTADOR: " + cont);
                    if (lista.size() > 0) {
                        for (int i = 0; i < lista.size(); i++) {
                            if ((ite + 1) == lista.get(i).getItem()) {
                                pos1 = i;
                                System.out.println("LA POSICION ES: " + pos1);
                                
                            }
                            
                          
                           
                        }
//pondremos los metodos aqui abajo
                    if(ite==(cont+1)){
                        System.out.println("EJECUTAMOS EL DE AQUI!!");
                    }else{
                        System.out.println("SINO ES ASI EJECUTAMOS ESTE!!");
                       for (int j = 0; j < lista.size() - pos1; j++) {
                                    lista.get((pos1 + j)).setItem((ite + j));
                                } 
                    }
                             
                        
                        //Comprobando los numeros y ordenandolos

                    } else {
                        
                    }
                    item = cont;
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("producto", p);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;

                default:

                    VentaDAO xdao = new VentaDAO();

                    numeroserie = xdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "000000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }

                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

            }

            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
