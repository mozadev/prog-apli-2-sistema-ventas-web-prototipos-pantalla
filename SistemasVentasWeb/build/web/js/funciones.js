



/* global swal */

function activar() {
    // let input = document.querySelector('#tejada input');
    let input2 = document.querySelector('#tejada input');
    //input.setAttribute('readonly', true);
    input2.setAttribute('readonly', true);
  

}


function desactivar() {
    let input2 = document.querySelector('#tejada input');
    let nom = document.querySelector("#datos_del_cliente input").value;

    if (!!nom) {
        input2.removeAttribute('readonly');
    } else {
        input2.setAttribute('readonly', true);
    }

}


function  desac_nuevo() {
    let input2 = document.querySelector('#tejada input');
    let nom = document.querySelector("#datos_del_cliente input").value;

    if (!!nom) {
        input2.removeAttribute('readonly');
    } else {
        input2.setAttribute('readonly', true);
    }
    
}

function boton_quitar() {
    let btn = document.querySelector('#tejada_boton button');
    let nom = document.querySelector("#tejada33 input").value;
    let idcheck = document.getElementById('#tejada_boton input');





    if (!!nom) {
        btn.removeAttribute('disabled');
        document.getElementById('btn_Agregar').classList.remove('btn-secondary');
        document.getElementById('btn_Agregar').classList.add('btn-success');
    } else {
        btn.setAttribute('disabled', true);
        document.getElementById('btn_Agregar').classList.remove('btn-success');
        document.getElementById('btn_Agregar').classList.add('btn-secondary');
    }
    //btnAdd2.setAttribute('disabled',true);

}



//Analizando valores de la tabla
$(".selected").click(function () {
    var row = $(this).parent().parent().parent().html();
    console.log("Imprimiendo valores: " + row);
});

//Es lo mismo que document.ready, pero mas cordo
$(function () {

//Aquí es donde te digo que le hablo al document, le ligo el evento, le digo que selectores y le paso lo que quiero que haga
    $(document).on('click', '#tejada_boton input', function () {

        let val = $(this).val();
        //Revisa en que status está el checkbox y controlalo según lo //desees
        if ($(this).is(':checked')) {

            let btn = document.querySelector('#tejada_boton button');
            let nom = document.querySelector("#tejada33 input").value;
            let idcheck = document.getElementById('#tejada_boton input');

            console.log(nom);

            if (!!nom) {
                btn.removeAttribute('disabled');
                document.getElementById('btn_Agregar').classList.remove('btn-secondary');
                document.getElementById('btn_Agregar').classList.add('btn-success');
            } else {
                btn.setAttribute('disabled', true);
                document.getElementById('btn_Agregar').classList.remove('btn-success');
                document.getElementById('btn_Agregar').classList.add('btn-secondary');
            }
        } else {

            let btn = document.querySelector('#tejada_boton button');
            let nom = document.querySelector("#tejada33 input").value;
            let idcheck = document.getElementById('#tejada_boton input');
            btn.setAttribute('disabled', true);
            document.getElementById('btn_Agregar').classList.remove('btn-success');
            document.getElementById('btn_Agregar').classList.add('btn-secondary');
        }
    });



});




$(document).ready(function () {

    $("tr #Perro").click(function () {

        var producto = $(this).parent().find("#idpro").val();


        var cantidad = $(this).parent().find("#Cantidad").val();

        console.log("IDPRODUCTO: " + producto + " CANTIDAD: " + cantidad);

        var url = "Controlador?menu=NuevaVenta&accion=RegistrarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + producto + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "Controlador?menu=NuevaVenta&accion=Carrito";
            }
        });

    });


    $("tr #btnDelete").click(function () {

        var idpa = $(this).parent().find("#idpe").val();

        swal({
            title: "Está Seguro de Eliminar?",
            text: "No se preocupe, podrá agregar de nuevo el mismo producto si lo desea",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        eliminar(idpa);
                        swal("Tu producto fue eliminado de la lista!!", {
                            icon: "success",
                        }).then((willDelete) =>{
                            if(willDelete){
                                location.href="Controlador?menu=NuevaVenta&accion=ActualizarNro";
                            }
                        });
                    } else {
                        swal("Tu producto no se eliminó!");
                    }
                });

        function eliminar() {
            var url = "Controlador?menu=NuevaVenta&accion=EliminarProducto";
            $.ajax({
                type: 'POST',
                url: url,
                data: "idp=" + idpa,
                success: function (data, textStatus, jqXHR) {
                    
                }

            });
        }

    });
    
     $("#boton_generar").click(function () {
       
        Swal.fire({
  position: 'top-end',
  icon: 'success',
  title: 'Your work has been saved',
  showConfirmButton: false,
  timer: 1500
})
 
        
        
     });

});





$(function () {
    $(document).on('click', '#Perro input', function () {
        console.log("Prueba si funciona");


    });
});




$(function () {
    $(document).on('click', '#boton_chequear input', function () {
        console.log("VEREMEOS SI FUUUUUNCIONA");
        let val = $(this).val();
        //Revisa en que status está el checkbox y controlalo según lo //desees
        if ($(this).is(':checked')) {

            let btn = document.querySelector('#boton_generar button');
            let btn2 = document.querySelector('#boton_limpiar button');
            let nom = document.querySelector("#cajapagar input").value;
            let idcheck = document.getElementById('#boton_chequear input');
            let validarnumero = parseInt(nom);


            console.log(validarnumero);
            console.log("Prueba si funciona");
            if (!!nom) {
                if (validarnumero >= 1) {
                    btn.removeAttribute('disabled');
                    btn2.removeAttribute('disabled');
                    document.getElementById('btn_GenerarVenta').classList.remove('btn-secondary');
                    document.getElementById('btn_GenerarVenta').classList.add('btn-success');
                    document.getElementById('btn_Limpiar').classList.remove('btn-secondary');
                    document.getElementById('btn_Limpiar').classList.add('btn-danger');
                } else {
                    btn.setAttribute('disabled', true);
                    btn2.setAttribute('disabled', true);
                }
            } else {

                btn.setAttribute('disabled', true);
                btn2.setAttribute('disabled', true);

            }
        } else {

            let btn = document.querySelector('#chequear button');
            let btn2 = document.querySelector('#boton_limpiar button');
            let nom = document.querySelector("#cajapagar input").value;
            let idcheck = document.getElementById('#boton_chequear input');
            btn.setAttribute('disabled', true);
            btn2.setAttribute('disabled', true);

        }
    });
});



function highlight(e) {
    if (selected[0])
        selected[0].className = '';
    e.target.parentNode.className = 'selected';
}

var table = document.getElementById('table'),
        selected = table.getElementsByClassName('selected');
table.onclick = highlight;

function fnselect() {
    var arr = Array.prototype.slice.call(selected);
    let arry = Array.from(selected);
    var anSelected = $("tr.selected td:first").html();

    console.log("LOS ELEMENTOS SON: " + anSelected);
    alert($("tr.selected td:first").html());


}

function show_hide(){
    var a;
    if(a===1){
        document.getElementById("image").style.display="inline";
        return a=0;
    }else{
        document.getElementById("image").style.display="none";
        return a=1;
    }
}

function probando(){
    console.log("Prueba si funciona");
}


