function validarFormularioLogin() {

    //Variables como expresiones regulares
    var expRegNombre = /^[a-zA-ZÑñÁáÉéÍíÓóÚúÜü\s]{4,25}$/;
    //Variables recuperadas del formulario
    var nombre = document.getElementById("nombre");
    var password = document.getElementById("password");



    //Campo nombre
    if (!nombre.value) {
        alert("El campo nombre es necesario");
        nombre.focus();
        return false;
    }
    if (!expRegNombre.exec(nombre.value)) {
        alert("El campo Nombre puede fallar por: \n-Algún número ingresado\
            \n-Nombre demasiado corto\n-Nombre demasiado largo");
        nombre.focus();
        return false;
    }


    //Campo Password
    if (password.length > 30 || password.length < 5) {
        alert("La contraseña no debe ser mayor a caracteres");
        password.focus();
        return false;
    }
    if (!password.value) {
        alert("Campo Password necesario");
        password.focus();
        return false;
    }


    return true;
}



function validarFormularioNU() {

    //Variables como expresiones regulares
    var expRegNombre = /^[a-zA-ZÑñÁáÉéÍíÓóÚúÜü\s]{4,25}$/;
    var expRegCorreo = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    var expRegTel = /^([0-9]+){9}$/;


    //Variables recuperadas del formulario
    var nombre = document.getElementById("name");
    var password = document.getElementById("password");
    var correo = document.getElementById("email");
    var telefono = document.getElementById("phome");


    //Campo nombre
    if (!nombre.value) {
        alert("El campo nombre es necesario");
        nombre.focus();
        return false;
    }
    if (!expRegNombre.exec(nombre.value)) {
        alert("El campo Nombre puede fallar por: \n-Algún número ingresado\
            \n-Nombre demasiado corto\n-Nombre demasiado largo");
        nombre.focus();
        return false;
    }


    //Campo Password
    if (password.length > 30 || password.length < 5) {
        alert("La contraseña no debe ser mayor a caracteres");
        password.focus();
        return false;
    }
    if (!password.value) {
        alert("Campo Password necesario");
        password.focus();
        return false;
    }


    //Campo correo
    if (!correo.value) {
        alert("El campo correo es necesario");
        correo.focus();
        return false;
    }
    if (!expRegCorreo.exec(correo.value)) {
        alert("El correo ingresado no tiene el formato correcto");
        correo.focus();
        return false;
    }


    //Campo telefono
    if (!telefono.value) {
        alert("El campo telefono es necesario");
        telefono.focus();
        return false;
    }
    if (!expRegTel.exec(telefono.value)) {
        alert("Telefono es invalido");
        telefono.focus();
        return false;
    }

    return true;
}
