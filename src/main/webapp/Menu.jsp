<%-- 
    Document   : Menu
    Author     : amontess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Sistema usando JSTL</title>
        <script type="text/javascript" src="js/prototype.js"></script>
        <script type="text/javascript" src="js/validation.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
    </head>
    <body>        
        <jsp:include page="/menu" flush="true"/>
        <jsp:useBean id="usuarioConectado" class="duoc.cl.dej4501.ejemploJstl.entidades.Usuario" scope="session"/>
        <jsp:useBean id="objMenuPadre" class="duoc.cl.dej4501.ejemploJstl.entidades.Menu" scope="page"></jsp:useBean>
        <jsp:useBean id="objMenuHijo" class="duoc.cl.dej4501.ejemploJstl.entidades.Menu" scope="page"></jsp:useBean> 
        <h4 style="background-color: red">Usuario Conectado :<c:out value="${usuarioConectado.nombre_usuario}"/></h4>
        <a href=".\cerrarSesion">Cerrar Sesion</a>
        <div id="encabezado">
            <h1>Sistema Usuarios Desarrollo en Java usando JSTL</h1>
        </div>
        <div id="menu">
            <ul>
                <c:forEach items="${listaMenu}" var="objMenuPadre">                    
                    <c:if test="${objMenuPadre.padre_menu==0}">
                    	<c:if test="${objMenuPadre.codigo_menu == 14 || objMenuPadre.codigo_menu == 15}">
                    		<li><a class="verSub" href="${objMenuPadre.destino_menu}">${objMenuPadre.nombre_menu}</a></li>
                    	</c:if>
                    	<c:if test="${objMenuPadre.codigo_menu != 14 && objMenuPadre.codigo_menu != 15}">
                    	
	                        <li><a class="verSub" href="javascript:;"><c:out value="${objMenuPadre.nombre_menu}"></c:out></a>
	                                <ul class="subMenu">                                    
	                                <c:forEach items="${listaMenu}" var="objMenuHijo"> 
	                                    <c:if test="${objMenuHijo.codigo_menu!=0 && objMenuPadre.codigo_menu==objMenuHijo.padre_menu}">                                                             
	                                        <li><a href="<c:out value="${objMenuHijo.destino_menu}"/>"><c:out value="${objMenuHijo.nombre_menu}"></c:out></a></li>                       
		                                 </c:if>
		                             </c:forEach>
		                        </ul>
		                    </li>
                    	</c:if>
                    </c:if>
                </c:forEach>
            </ul>
        </div>

        <script type="text/javascript">
            $$('.subMenu').each(function(e) {
                var menu = e.previous().innerHTML,
                        menOpen = 'Movimientos';
                if (menu !== menOpen) {
                    e.hide();
                }
            });
            $$('.verSub').each(function(e) {
                e.observe('click', function() {
                    e.next().toggle();
                });
            });
        </script>    
    </body>
</html>
