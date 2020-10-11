
function validar(email){
  
  expr= /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
  esCorreo=expr.test(email);
  if (esCorreo  ){       
    alert("El correo es correcto");
  } else {
    alert("Ingresa una dirección de correo valida");
  }
}

  
  