package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse  \" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"#\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Producto&accion=Listar\" target=\"myFrame\">Producto</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Empleado&accion=Listar\" target=\"myFrame\">Empleado</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Clientes&accion=Listar\" target=\"myFrame\">Clientes</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=NuevaVenta&accion=default&emple_ident=99\" target=\"myFrame\">Nueva Venta</a>\n");
      out.write("                    </li>\n");
      out.write("                  \n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("              \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <button style=\"border:none; width:200px\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getNom() }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </button>\n");
      out.write("                <div class=\"dropdown-menu text-center\" >\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                        <img src=\"img/usuario.png\" alt=\"60\" width=\"60\"/>\n");
      out.write("                        \n");
      out.write("                    </a>\n");
      out.write("                    \n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getUser() }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                     <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getId() }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">usuario@gmail.com</a>\n");
      out.write("                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <form action=\"Validar\" method=\"POST\">\n");
      out.write("                        <button name=\"accion\" value=\"Salir\" class=\"dropdown-item\" href=\"#\">Salir</button>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
