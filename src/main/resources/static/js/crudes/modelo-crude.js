(function ($) {
  "use strict";

  var idMarca = $(location).attr("href").split("/").pop();
  var urlGet =
    "http://localhost:8080/spring-mvc-udemy-prueba-concepto/api/marca/modelos/get/" +
    idMarca;

  var urlGetMarca =
    "http://localhost:8080/spring-mvc-udemy-prueba-concepto/api/marca/get/" +
    idMarca;

  var jsonModelos = [];
  var jsonMarca = {};

  $.getJSON(urlGet, function (json) {
    jsonModelos = json;
    loadTable(json);

    $("#add").click(function () {
      var model = $("#modelo").val();
      var code = $("#codigo").val();

      var modelo = { id: 0, modelo: model, codigo: code, estado: true };
      jsonModelos.push(modelo);
      loadTable(jsonModelos);
      $("#modelo").val("");
      $("#codigo").val("");
    });
  });

  $.getJSON(urlGetMarca, function (json) {});

  $(document).delegate(".delete", "click", function () {
    Swal.fire({
      title: "Borrar Modelos",
      text: "¿Desea Eliminar el Modelo?",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si",
      cancelButtonText: "No",
    }).then((result) => {
      if (result.value) {
        var id = $(this).attr("id");
        var code = $(this).attr("codigo");

        var urlDelete =
          "http://localhost:8080/spring-mvc-udemy-prueba-concepto/api/modelo/eliminar/" +
          id;

        if (existeEnMarca(jsonMarca.modelos, code)) {
          // $.ajax({
          //   type: "DELETE",
          //   url: urlDelete,
          //   cache: false,
          //   success: function () {
          //     Swal.fire(
          //       "Borrar Modelos",
          //       "El Modelo Fue Borrado Exitosamente.",
          //       "success"
          //     );
          //   },
          //   error: function () {
          //     Swal.fire({
          //       type: "error",
          //       title: "Error Borrando Modelos",
          //       text:
          //         "Hubo un Error al momento de Borrar El Modelo Seleccionado.",
          //     });
          //   },
          // });

          deleteModeloFromJson(jsonModelos, code);
        } else {
          deleteModeloFromJson(jsonModelos, code);
        }
        // location.reload();
      }
    });
  });

  $(document).delegate("#saveModel", "click", function (event) {
    event.preventDefault();
    jsonMarca.modelos = jsonModelos;
    var urlSaveMarca =
      "http://localhost:8080/spring-mvc-udemy-prueba-concepto/api/marca/save";

    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf-8",
      url: urlSaveMarca,
      data: JSON.stringify(jsonMarca),
      cache: false,
      success: function (result) {
        Swal.fire({
          type: "success",
          title: "Modelos Disponibles",
          text: "Los Modelos Fueron Actualizados de Forma Exitosa",
        });
      },
      error: function (err) {
        Swal.fire({
          type: "error",
          title: "Error en Modelos Disponibles",
          text:
            "Hubo un Error al momento de Guardar la Información de los Modelos",
        });
      },
    });
  });

  function loadTable(json) {
    var tr = [];
    for (var i = 0; i < json.length; i++) {
      tr.push("<tr>");
      tr.push("<td>" + json[i].codigo + "</td>");
      tr.push("<td>" + json[i].modelo + "</td>");
      tr.push(
        "<td align='center'><button class='btn btn-danger delete' id=" +
          json[i].id +
          "codigo=" +
          json[i].codigo +
          "><i class='fa fa-trash'></i></button></td>"
      );
      tr.push("</tr>");
      $("#rows").html("");
      $("#rows").append($(tr.join("")));
    }
  }

  function existeEnMarca(jsonModelos, codigo) {
    $.each(jsonModelos, function (i, item) {
      if (item.codigo === codigo) {
        console.log(true);
        return true;
      }
    });
    return false;
  }

  function deleteModeloFromJson(jsonModelos, codigo) {
    var jsonNoEliminados = [];

    $.each(jsonModelos, function (i, item) {
      if (item.codigo != codigo) {
        
      }
    });
  }
})(jQuery);
