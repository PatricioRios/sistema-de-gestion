$(document).ready(function () {
    // on ready
});


//registrar ariculo function
async function registrarArticulo() {

    let datos = {};
    datos.nombre = document.getElementById("nameArticle").value;
    datos.precio = document.getElementById("priceArticle").value;
    datos.descripcion = document.getElementById("descriptionArticle").value;
    datos.fecha = getFechaActual();

    const request = await fetch("api/articulos", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    location.reload()
    
}

//esta funcion me dara retornara la fecha actual
function getFechaActual() {
    var fecha = new Date();
    var dia = fecha.getDate();
    var mes = fecha.getMonth() + 1;
    var anio = fecha.getFullYear();
    var fechaActual = anio + "-" + mes + "-" + dia;
    return fechaActual;
}
