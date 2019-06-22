/***************************************************
 Funcion valida entero mayor o igual que cero.
***************************************************/
function validaIntMayorIgualCero(objName){
var numfield = objName;
if (objName.value==""){
	alert("Debe colocar un numero. Intentelo de nuevo.");
	//numfield.value="0";
	return false;
}else if (chkInt(objName.value)==false) {
	alert("Este numero es invalido. Coloque numeros solamente. Intentelo de nuevo.");
	//numfield.value="0";
	return false;
}else{
	if(parseInt(objName.value,10)<0){
		alert("Este campo debe ser mayor o igual que cero. Coloque numeros solamente. Intentelo de nuevo.");
		//numfield.value="0";
		return false;
	}else{
		return true;
	}
}
}

/***************************************************
 Funcion que verifica que el valor ingresado sea de
 tipo INT.
***************************************************/
function checkInt(objName) {
  var numfield = objName;

  if(chkInt(objName.value) == false) {
    numfield.select();
    alert("Campo numerico. Coloque numeros solamente. Intentelo de nuevo.");
    //numfield.value="";
    numfield.focus();
    return false;
  }
  else {
    return true;
  }
}

/***************************************************
 Funcion que verifica que el valor ingresado sea de
 tipo INT.
***************************************************/
function chkInt(num)
{
  var parsednum;
  var pat;
  var res = new Array();
  pat = /(\.)/g;
  res = num.match(pat);

  if(res != null)
    if(res.length>0)
      return false;

  pat=/(\D)/g;
  res=num.match(pat);

  if(res != null)
    if(res.length > 1)
      return false;
    else
      if(res[0]=='-') {
        parsednum=parseInt(num);

        if(parsednum == num)
          return true;
        else
          return false;
      }
      else
        return false;
  else
    return true;
}

/***************************************************
 Función que Valida que un Texto no sea vacío.
***************************************************/
function validaTexto(elemento) {
  if(elemento.type == "text" || elemento.type == "textarea") {
    if(elemento.value == "" || AllTrim(elemento.value).length == 0) {
       elemento.focus();
       return false;
    }
  }
    return true;

}


/***************************************************
 Función que Valida que una Fecha sea correcta.
***************************************************/
function validaFecha(dateStr) {
  // Checks for the following valid date format:
  // DD-MM-YYYY
  // Also separates date into month, day, and year variables
  var datePat = /^(\d{2})(-)(\d{2})(-)(\d{4})$/;
  var matchArray = dateStr.match(datePat); // is the format ok?

  if(matchArray == null) {
    alert("La fecha no tiene un formato v" + String.fromCharCode(225) + "lido(dd-mm-aaaa).")
    return false;
  }

  day = matchArray[1]; // parse date into variables
  month = matchArray[3];
  year = matchArray[5];

  if(month < 1 || month > 12) { // check month range
    alert("El mes debe ser entre 1 y 12.");
    return false;
  }

  if(day < 1 || day > 31) {
    alert("El d"+String.fromCharCode(237)+"a debe ser entre 1 y 31.");
    return false;
  }

  if((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
    alert("Este mes " + month + " no tiene 31d" + String.fromCharCode(237) + "as.");
    return false;
  }

  if(month == 2) { // check for february 29th
    var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

    if(day > 29 || (day == 29 && !isleap)) {
      alert("Febrero " + year + " no tiene " + day + "d" + String.fromCharCode(237) + "as.");
      return false;
    }
  }
  return true;  // date is valid
}