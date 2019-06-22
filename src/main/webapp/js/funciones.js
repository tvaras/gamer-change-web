/**
 * Función que valida y devuelve el rut con formato 0012345678-9
 * @param String rut Cadena con el rut a validar y formatear
 * @param Boolean usaAlerta Indica si se usa la la función alerta o el alert de javascript.
 * @return String r
 *
 * @author
 */
function validaRut(rut, usaAlerta){
    if(rut.length < 2) return;
    var rexp = new RegExp(/^([0-9])+\-([kK0-9])+$/);
    if(usaAlerta == undefined){ var usaAlerta = true; }
    if(rut.match(rexp)){
        var RUT=rut.split("-"), elRut=RUT[0].toArray(), factor=2, suma=0, dv, erl=elRut.length;
        for(i=(erl-1); i>=0; i--){
            factor = factor > 7 ? 2 : factor;
            suma += parseInt(elRut[i])*parseInt(factor++);
        }
        dv = 11 - (suma % 11);
        if(dv == 11){
            dv = 0;
        }else if (dv == 10){
            dv = "k";
        }
        if(dv == RUT[1].toLowerCase()){
            var r=rut, rl=rut.length;
            for(var i=rl; i<12; i++){ r= '0'+r; }
            return r;
        }else{
            if(usaAlerta==true){
                alerta("Error 113: El rut es incorrecto");
            }else{
                alert("Error 113: El rut es incorrecto");
            }
            return false;
        }
    }else{
        if(usaAlerta==true){
            alerta("Error 112: Error en el rut ingresado. El formato aceptado es 12345678-9");
        }else{
            alert("Error 112: Error en el rut ingresado. El formato aceptado es 12345678-9");
        }
        return false;
    }
}
/**
* Calcula la edad para fechas de formato aaaa/mm/dd
* @param fecNac Fecha de nacimiento en formato aaaa/mm/dd
*/
function getEdad(fecNac){
	var fn=fecNac.split('/'), fnDia=parseInt(fn[2]) , fnMes=parseInt(fn[1]), fnAnio=parseInt(fn[0]),
		hoy=new Date(), hDia=parseInt(hoy.getDate()), hMes=parseInt(hoy.getMonth()+1), hAnio=parseInt(hoy.getFullYear()),
		edad = 0;
	if(fnMes < hMes){
		edad = hAnio-fnAnio;
	}else if(fnMes == hMes) {
		if (fnDia <= hDia) {
			edad = hAnio-fnAnio;
		}else{
			edad = (hAnio-fnAnio)-1;
		}
	}else{
		edad = (hAnio-fnAnio)-1;
	}	
	return parseInt(edad);
}

/**
* Crea un tooltip a partir del title de objeto HTML que tenga la clase toolTip
* @author 
*/
var ToolTip = Class.create({
	initialize:function(){
		$$('.toolTip, .tooltip').each(function(e){
			if(!e.title || e.title==''){ return false; }
				
			//variables base
			var toolTip = '', txt = e.title, padre = e.up();
			//remuevo title y alt para que no molesten
			e.removeAttribute('title');
			if(e.alt){ e.removeAttribute('alt'); }
			
			e.observe('mouseover',function(){		
				if(!toolTip){
					toolTip = new Element('div',{'class':'divTooltip'}).update(txt);
					toolTip.setOpacity(0.9);
					toolTip.style.position = 'absolute';
					toolTip.style.zIndex = 999999;//para tenerlo en las narices
					toolTip.style.width = 'auto';
					toolTip.style.padding = '6px';
					document.body.appendChild(toolTip);
				}else{
					toolTip.show();
				}
			});
			e.observe('mousemove',function(ev){
				if(toolTip!=''){
					var x = ev.pointerX()+10, y = ev.pointerY()+10, b = document.viewport.getWidth(), _x = b-x;
					x = (_x)<=150 ? (b-150) : x ;
					toolTip.style.top = y+'px';
					toolTip.style.left = x+'px';					
				}
			});
			
			e.observe('mouseout',function(){
				if(toolTip!=''){ toolTip.hide(); }
			});	
		});		
	}
});

function numConPuntos(number){	
    number += '';
    x = number.split(',');
    x1 = x[0];
    x2 = x.length > 1 ? ',' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + '.' + '$2');
    }	
    return x1 + x2;
}
