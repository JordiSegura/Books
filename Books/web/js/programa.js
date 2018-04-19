const ajax = new XMLHttpRequest();
const objDiv = document.getElementById("desc")
const URL = "booksCtrl?identificadorLibro="


function mostrarDescripcion(){

    //representacion js del combo html
    const combo = document.getElementById("libros")
    //pillamos el valor de combo seleccionado, si no hay uno seleciconado devuelve -1
    const selec = combo.selectedIndex - 1
    if (selec == -1){
        objDiv.innerHTML = ""
        return false
    }else {
        ajax.open("GET", URL + selec, true)
        ajax.onreadystatechange = procesarRespuesta//es una callback, funcion que se ejecutara a su debido momento si al metodo le ponemos los () se ejecuta si ponemos solo el nombre le indicamos que metodo ha de llamar cuando sea oportuno
        //si fuera eso por post se envia el form, se envia lo que queramos(foto.etc)
        ajax.send(null)
    }

}

function procesarRespuesta(){
    //si ha acabado miramos que devuelva cod 200
    //tres === igual en valor i coherencia
    if (ajax.readyState === 4){
        if (ajax.status ==200){
            const description = ajax.responseText
            paintDescription(description)
        }

    }
}
function paintDescription(description){
    objDiv.innerHTML = description
}