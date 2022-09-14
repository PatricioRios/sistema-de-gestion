// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarTodosLosArticulos();
    cargarTarjetas();
    $("#usuarios").DataTable();
});

async function cargarTodosLosArticulos() {
    const rawResponse = await fetch("api/articulos/getallArticles", {
        method: "GET",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
    });

    const response = await rawResponse.json();
    let HTMLTablaUsuarios = `
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Descripcion</th>
            <th>Fecha</th>
        </tr>
    </thead>
    `;
    for (let i = 0; i < response.length; i++) {
        HTMLTablaUsuarios += `
      <tr>
        <td>${response[i].id}</td>
        <td>${response[i].nombre}</td>
        <td>${response[i].precio}</td>
        <td>${response[i].descripcion}</td>
        <td>${response[i].fecha}</td> 
      </tr>
        `;
    }
    document.getElementById("articulos").innerHTML = HTMLTablaUsuarios;
    console.log(response);
}

async function cargarTarjetas() {
    const rawResponse = await fetch("api/presupuestos/getpresupuestos", {
        method: "GET",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
    });

    const response = await rawResponse.json();

    console.log(response);
    document.getElementById(
        "CardsCantidadInicial"
    ).innerHTML = `$${response[0].cantidadInicial}`;
    document.getElementById(
        "CardsCantidadActual"
    ).innerHTML = `$${response[0].cantidadActual}`;
    document.getElementById(
        "CardsCostos"
    ).innerHTML = `$${response[0].gastoTotal}`;
    document.getElementById("CardsFecha").innerHTML = `${response[0].fecha}`;
}

async function eliminarArticulo(id) {
    if (!confirm("¿Desea eliminar este articulo?")) {
        return;
    }

    const request = await fetch("api/articulos/eliminar/" + id, {
        method: "DELETE",
        headers: getHeaders(),
    });

    location.reload();
}

function getHeaders() {
    return {
        Accept: "application/json",
        "Content-Type": "application/json",
    };
}
