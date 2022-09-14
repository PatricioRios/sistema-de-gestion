// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  cargarTarjetas();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
  const rawResponse = await fetch('api/articulo/getLast10',{
      method: 'GET',
      headers: {
        'Accept':'application/json',
        'Content-Type': 'application/json'
      }
    }
  );

  const response = await rawResponse.json();
  let boton=`<a href="#" onClick="eliminar(12)" class="btn btn-danger btn-circle">
  <i class="fas fa-trash"></i>
</a>`;
  let HTMLTablaUsuarios = `
  <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Descripcion</th>
        <th>Fecha</th>
        <th>actions</th>
    </tr>
  </thead>
  `;
  for(let i = 0; i < response.length; i++){
    let boton=
    `<a href="#" onClick="eliminarArticulo(${response[i].id})" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>`;
    HTMLTablaUsuarios += `
    <tr>
      <td>${response[i].id}</td>
      <td>${response[i].nombre}</td>
      <td>${response[i].precio}</td>
      <td>${response[i].descripcion}</td>
      <td>${response[i].fecha}</td> 
      <td>${boton}</td>
    </tr>
      `;
    }
  document.getElementById("articulos").innerHTML = HTMLTablaUsuarios;
}

async function cargarTarjetas(){

  const rawResponse = await fetch('api/presupuestos/getpresupuestos',{
    method: 'GET',
    headers: {
      'Accept':'application/json',
      'Content-Type': 'application/json'
    }
  }
);

const response = await rawResponse.json();

console.log(response);
  document.getElementById("CardsCantidadInicial").innerHTML = `$${response[0].cantidadInicial}`;
  document.getElementById("CardsCantidadActual").innerHTML =  `$${response[0].cantidadActual}`;
  document.getElementById("CardsCostos").innerHTML =          `$${response[0].gastoTotal}`;
  document.getElementById("CardsFecha").innerHTML =           `${response[0].fecha}`;

}

async function eliminarArticulo(id) {

  if (!confirm('¿Desea eliminar este articulo?')) {
    return;
  }

  const request = await fetch('api/articulos/eliminar/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}

function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  };
}

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
