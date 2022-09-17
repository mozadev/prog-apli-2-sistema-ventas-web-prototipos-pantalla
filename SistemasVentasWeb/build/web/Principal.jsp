<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>MODULO DE SISTEMA DE INVENTARIOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body background="img/fondoweb.jpg">
         <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">


            <div class="collapse navbar-collapse  " id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Home" target="myFrame" >Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar"  target="myFrame" onclick="remove_home()" >Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame" onclick="remove_home()" >Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar" onclick="remove_home()" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" onclick="remove_home()" target="myFrame">Nueva Venta</a>
                    </li>


                </ul>




            </div>
            <div class="dropdown">
                <button style="border:none; width:200px" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNom() }
                </button>
                <div class="dropdown-menu text-center" >
                    <a class="dropdown-item" href="#">
                        <img src="img/usuario.png" alt="60" width="60"/>

                    </a>

                    <a class="dropdown-item" href="#">${usuario.getUser() }</a>
                    <a class="dropdown-item" href="#">${usuario.getId() }</a>
                    <a class="dropdown-item" href="#">usuario@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>


                </div>
            </div>
 
        </nav>
           <div class="m-4"  style="height:750px;" id="image" >
                        
            <div   class="container"  style="height:100%; width: 100%;border:4px ">
              
                 <!--AQUI VA LA PAG WEB PRINCIPAL -->
                
            </div>
            

        </div>
     
        <div class="m-4" id="frame_home" style="height:750px;display:none " >
            <!--PROBANDO EL IFRAME -->
             
              
            <iframe   name=myFrame  style="height:100%; width: 100%;border:4px ">
               
            </iframe>
            

        </div>
  

        <script src="js/funcion_principal.js" type="text/javascript"></script>
         <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    
    
    
    
    </body>
</html>
