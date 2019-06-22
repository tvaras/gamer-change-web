<%-- 
    Document   : DefinicionesJSTL
    Author     : amontess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Definciones JSTL</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" flush="true"/>
        <div id="contenido">
            <h1 class="center"> Deiniciones de JSTL por libreria</h1>
            <table style=" width: 80%">
                <tr>
                    <td>Core C</td>
                    <td><img src="images/coreC.png"/></td>
                </tr>
                <tr>
                    <td>Core FMT</td>
                    <td><img src="images/coreFMT.png"/></td>
                </tr>
                <tr>
                    <td>Core SQL</td>
                    <td><img src="images/coreSQL.png"/></td>
                </tr>
                <tr>
                    <td>Core XML</td>
                    <td><img src="images/coreXML.png"/></td>
                </tr>                
            </table>
        </div>
        <jsp:include page="MenuPie.jsp" flush="true"/>
</html>
