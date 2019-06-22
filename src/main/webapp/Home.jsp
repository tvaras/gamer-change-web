<%-- 
    Document   : Home
    Author     : amontess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <jsp:include page="imports-header.jsp" flush="true"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp" flush="true"></jsp:include>
            <div id="contenido">
                <h1 class="center"><b>Introducción a JSTL</b></h1>
                <table  style="width: 75%;background-color: #999999">
                    <tr>
                        <td>La libreria JSTL es un componente dentro de la especificación del Java 2, por definición son un conjunto de librerias simples, formando un standard </td>
                    </tr>
                    <tr>
                        <td>lo que permite encapsular la funcionalidades principales al momento de desarrollar una página JSP.</td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>JSTL al standarizar  y encapsular permite eliminar los scriplets, logrando un codigo más limpio y simple</td>
                    </tr>
                    <tr>
                        <td>Esto se logra gracias a que JSTL en realidad es XML, por lo cual las etiquetas son mas limpias y uniformes a las de HTML</td>
                    </tr>
                    <tr>
                        <td>JSTL esta contenido en 4 librerias </td>
                    </tr>
                </table>
                <h1 class="center"><b>Librerias JSTL</b></h1>
                <table style="width: 50%;background-color: darkgrey">
                    <tr>
                        <td>core</td>
                        <td>< % @ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %></td>
                    </tr>
                    <tr>
                        <td>ftm</td>
                        <td>< % @ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %></td>
                    </tr>
                    <tr>
                        <td>sql</td>
                        <td>< % @ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %></td>
                    </tr>
                    <tr>
                        <td>x</td>
                        <td>< % @ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %></td>
                    </tr>
                </table>
            </div>
        <jsp:include page="MenuPie.jsp" flush="true"></jsp:include>
    </body>
</html>
