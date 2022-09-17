package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarVenta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <title>VENTAS</title>\n");
      out.write("        <style> \n");
      out.write("            @media print{\n");
      out.write("                .parte01, .parte02 ,.accion1{\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("              \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\" integrity=\"sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=\" crossorigin=\"anonymous\"></script>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("        <div class=\"d-flex\">\n");
      out.write("            <div class=\"col-sm-4 parte01\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <form action=\"Controlador?menu=NuevaVenta\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <!-- DATOS DEL CLIENTE!!!-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Datos del Cliente</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("                                <div class=\"col-sm-6 d-flex\">\n");
      out.write("                                    <input type=\"text\" name=\"codigocliente\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getDni()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control \" placeholder=\"Codigo\" required oninvalid=\"setCustomValidity('Ingrese el código')\" onchange=\"try{setCustomValidity('')}catch(e){}\"  pattern=\"[0-9]{1,3}\" >\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"BuscarCliente\"   class=\"btn btn-outline-info\">Buscar</button>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-6\" id=\"datos_del_cliente\">\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"nombrescliente\"   placeholder=\"Datos Cliente\" class=\"form-control \" readonly>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- DATOS DEL PRODUCTO!!!-->\n");
      out.write("                            <div class=\"form-group\" >\n");
      out.write("                                <label>Datos Producto</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-6 d-flex \" id=\"tejada\" onclick=\"desactivar()\">\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" name=\"codigoproducto\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"    class=\"form-control\"  placeholder=\"Codigo\"  readonly required   oninvalid=\"setCustomValidity('Ingrese el código')\" onchange=\"try{setCustomValidity('')}catch(e){}\"  pattern=\"[0-9]{1,3}\">\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"BuscarProducto\" id=\"chau\"  class=\"btn btn-outline-info\"  >Buscar</button>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-6\" id=\"tejada33\">\n");
      out.write("                                    <input type=\"text\" name=\"nomproducto\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Datos producto\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("                                <div class=\"col-sm-6 d-flex\"  >\n");
      out.write("                                    <input type=\"text\" name=\"precio\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getPrecio()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly class=\"form-control\" placeholder=\"S/.0.00\" required   oninvalid=\"setCustomValidity('Ingrese la cantidad')\" onchange=\"try{setCustomValidity('')}catch(e){}\"  pattern=\"^[0-9]+([,][0-9]+)\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-3\">\n");
      out.write("                                    <input type=\"number\" name=\"cant\"  value=\"1\" placeholder=\"\" class=\"form-control\" min=\"1\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-3\">\n");
      out.write("                                    <input type=\"text\" name=\"stock\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getStock()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Stock\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- BOTON AGREGAR PRODUCTO AL REGISTRO-->\n");
      out.write("                            <div class=\"form-group\" >\n");
      out.write("                                \n");
      out.write("                                <div class=\"col-sm\" id=\"tejada_boton\" >\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"Agregar\" id=\"btn_Agregar\" class=\"btn btn-secondary \" disabled>Agregar Producto</button>\n");
      out.write("                                  \n");
      out.write("                                \t<input class=\"formulario__checkbox\" type=\"checkbox\" name=\"terminos\" class=\"foo\" id=\"terminos\">\n");
      out.write("\t\t\t\t\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                                \n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"d-flex col-sm-5 ml-auto\">\n");
      out.write("                            <label class=\"text-right mt-2 col-sm-6\">NRO. SERIE</label>\n");
      out.write("                            <input type=\"text\" name=\"numeroserie\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nserie}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <table class=\"table table-hover\">\n");
      out.write("                            <thead style=\"background-color: #e3f2fd;\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Nro</th>\n");
      out.write("                                    <th>Codigo</th>\n");
      out.write("                                    <th>Descripcion</th>\n");
      out.write("                                    <th>Precio</th>\n");
      out.write("                                    <th>Cantidad</th>\n");
      out.write("                                    <th>SubTotal</th>\n");
      out.write("                                    <th class=\"accion1\">Acciones</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("             \n");
      out.write("                         <!--FORMULARIO PAGOS- VENTAS -->\n");
      out.write("                          <form action=\"Controlador?menu=NuevaVenta\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("                          <div class=\"card-footer d-flex \">\n");
      out.write("                        <div class=\"col-sm-6 d-flex\" id=\"chequear\"  >\n");
      out.write("                            <div id=\"boton_chequear\" style=\"padding-right:6px; padding-left:6px\" class=\"parte02\">\n");
      out.write("                            <input class=\"formulario__checkbox\" type=\"checkbox\" name=\"terminos\" class=\"foo\" id=\"terminos\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"boton_generar\" style=\"padding-right:6px; padding-left:6px\" class=\"parte02\">\n");
      out.write("                            <button type=\"submit\" name=\"accion\" value=\"GenerarVenta\" onclick=\"print()\" id=\"btn_GenerarVenta\"  class=\"btn btn-secondary\" disabled >Generar Venta</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"boton_limpiar\" style=\"padding-right:6px; padding-left:6px\" class=\"parte02\">\n");
      out.write("                            <button type=\"submit\" name=\"accion\" value=\"Cancelar\" id=\"btn_Limpiar\"  class=\"btn btn-secondary\"  disabled >Limpiar todo</button>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                          \n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-4 ml-auto\" id=\"cajapagar\">\n");
      out.write("                            <input type=\"text\" name=\"txtTotal\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalpagar}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly style=\"font-size: 20px; font-weight: bold\" class=\"form-control\" >\n");
      out.write("                             \n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                          </form>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/funciones.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\" integrity=\"sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("list");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("                                     <form action=\"Controlador?menu=NuevaVenta\" method=\"POST\" autocomplete=\"off\">\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getItem()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdproducto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getDesccripcionP()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getPrecio()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td style=\"width: 100px;\">\n");
          out.write("                                            <div id=\"Perro_11\">\n");
          out.write("                                                <input type=\"hidden\" id=\"idpro\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdproducto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                           </div>\n");
          out.write("                                            <div id=\"Perro\">\n");
          out.write("                                            <input type=\"number\"  id=\"Cantidad\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getCantidad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"  class=\"form-control text-center\" min=\"1\">\n");
          out.write("                                          </div>\n");
          out.write("                                        </td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getSubtotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                             \n");
          out.write("                                        <td class=\"d-flex\">\n");
          out.write("                                            <div class=\"parte02\">\n");
          out.write("                                               \n");
          out.write("                                                <button type=\"submit\" name=\"accion\" value=\"RegistrarCantidad\"   class=\"btn btn-warning\"  >Registrar</button>\n");
          out.write("                                                \n");
          out.write("                                                <a href=\"#\" class=\"btn btn-danger\" style=\"margin-left:10px\">Eliminar</a>\n");
          out.write("                                            </div>\n");
          out.write("                                        </td>\n");
          out.write("                              </form>\n");
          out.write("                                        \n");
          out.write("                                        \n");
          out.write("\n");
          out.write("                                    </tr>\n");
          out.write("\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
