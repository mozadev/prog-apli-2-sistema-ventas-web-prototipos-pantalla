
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENTAS</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <style> 
            @media print{
                .parte01, .parte02 ,.accion1{
                    display: none;
                }
            }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
       
        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST" autocomplete="off">
                        <div class="card-body">
                            <!-- DATOS DEL CLIENTE!!!-->
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                 <i class="fa fa-user icon"></i>
                                <div class="col-sm-6 d-flex">
                                   
                                    
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control " placeholder="Codigo" required oninvalid="setCustomValidity('Ingrese el código')" onchange="try {
                                                setCustomValidity('')
                                            } catch (e) {
                                            }"  pattern="[0-9]{1,3}" >
                                  
                                    <button type="submit" name="accion" value="BuscarCliente"   class="btn btn-outline-info">Buscar</button>
                                      
                                </div>

                                <div class="col-sm-6" id="datos_del_cliente">
                                    <input type="text" value="${c.getNom()}" name="nombrescliente"   placeholder="Datos Cliente" class="form-control " readonly>
                                </div>
                            </div>
                            <!-- DATOS DEL PRODUCTO!!!-->
                            <div class="form-group" >
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6 d-flex " id="tejada" onclick="desac_nuevo()">

                                    <input type="text" name="codigoproducto" value="${producto.getId()}"    class="form-control"  placeholder="Codigo"  readonly required   oninvalid="setCustomValidity('Ingrese el código')" onchange="try {
                                                setCustomValidity('')
                                            } catch (e) {
                                            }"  pattern="[0-9]{1,3}">
                                    <button type="submit" name="accion" value="BuscarProducto" id="chau"  class="btn btn-outline-info" onclick="document.getElementById('stockt').disabled = true">Buscar</button>
                                </div>

                                <div class="col-sm-6" id="tejada33">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos producto" class="form-control" readonly>
                                </div>

                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex"  >
                                    <input type="text" name="precio" value="${producto.getPrecio()}" readonly class="form-control" placeholder="S/.0.00" required   oninvalid="setCustomValidity('Ingrese la cantidad')" onchange="try {
                                                setCustomValidity('')
                                            } catch (e) {
                                            }"  pattern="^[0-9]+([,][0-9]+)">

                                </div>

                                <div class="col-sm-3" id="cant-null-stock">
                                    <input type="number" name="cant"  value="1" placeholder="" id="stockt" class="form-control" min="1" max="${producto.getStock()}">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control" readonly>
                                </div>
                            </div>
                            <!-- BOTON AGREGAR PRODUCTO AL REGISTRO-->
                            <div class="form-group" >

                                <div class="col-sm" id="tejada_boton" >
                                    <button type="submit" name="accion" value="Agregar" id="btn_Agregar" class="btn btn-secondary " disabled>Agregar Producto</button>

                                    <input class="formulario__checkbox" type="checkbox" name="terminos" class="foo" id="terminos">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label class="text-right mt-2 col-sm-6">NRO. SERIE</label>
                            <input type="text" name="numeroserie" value="${nserie}" class="form-control" readonly>
                        </div>
                        <br>
                        <table class="table table-hover" id="table">
                            <thead style="background-color: #e3f2fd;">
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion1">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}"> 
                                <form action="Controlador?menu=NuevaVenta" method="POST" autocomplete="off">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDesccripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td style="width: 100px;">
                                            <div id="Perro">
                                                <input type="hidden" id="idpro" value="${list.getIdproducto()}">

                                                <input type="number"  id="Cantidad" value="${list.getCantidad()}"  class="form-control prueba_number" min="1" max="${producto.getStock()}">
                                            </div>
                                        </td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <div id="Borrardata">
                                                <input type="hidden" id="idpe" value="${list.getIdproducto()}">
                                                <!-- <button type="submit" name="accion" value="RegistrarCantidad"   class="btn btn-warning"  >Registrar</button>-->
                                               
                                                <a href="#" class="btn btn-danger fa fa-trash" id="btnDelete" style="margin-left:20px"  ></a>
                                            </div>
                                        </td>
                                </form>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!--FORMULARIO PAGOS- VENTAS -->
                    <form action="Controlador?menu=NuevaVenta" method="POST" autocomplete="off">
                        <div class="card-footer d-flex ">
                            <div class="col-sm-6 d-flex" id="chequear"  >
                                <div id="boton_chequear" style="padding-right:6px; padding-left:6px" class="parte02">
                                    <input class="formulario__checkbox" type="checkbox" name="terminos" class="foo" id="terminos">
                                </div>
                                <div id="boton_generar" style="padding-right:6px; padding-left:6px" class="parte02">
                                    <button type="submit" name="accion" value="GenerarVenta"  id="btn_GenerarVenta" onclick="print()" class="btn btn-secondary" disabled >Generar Venta</button>
                                </div>
                                <div id="boton_limpiar" style="padding-right:6px; padding-left:6px" class="parte02">
                                    <button type="submit" name="accion" value="Cancelar" id="btn_Limpiar"  class="btn btn-secondary"  disabled >Limpiar todo</button>
                                </div>
                            </div>                          
                            <div class="col-sm-4 ml-auto" id="cajapagar">                                   
                                <input type="text" name="txtTotal"  value="${totalpagar}" readonly style="font-size: 20px; font-weight: bold" class="form-control" >
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
 
        
        <script src="js/funcion_inputs.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/funciones.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>
