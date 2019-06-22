<%-- 
    Document   : Ejemplos
    Author     : amontess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplos JSTL</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" flush="true"/>
        <div id="contenido">
            <h1 class="center">Ejemplo de JSTL</h1>
            En este segmento encontraremos ejemplos de algunos de los componentes que se utilizarán
            <ol>
                
                <li>
                < c : out > Tag , este nos permite mostrar el contenido de una variable similar a < % =
                </li>
                <li>Ejemplo :
                    <table style="width: 40%" >
                        <tr>
                            <td>Codigo :< c :out value="$ {'< tag >,contenido'}" / > </td>
                            <td>Salida :<c:out value="${'<tag>,contenido'}"/></td>
                        </tr>
                    </table>
                </li>
                <li>< c : set > tag, evalua una expresión y usa el resultado para asignarlo a un JavaBeans o java.util.Map
                    Ejemplo :
                    <table style="width: 45%" >
                        <tr>
                            <td>Codigo :< c :set var="variableNombreX" value="$ {((10+10)*50)} scope="session"  / > 
                                Codigo :< c out value="$ {variableNombreX}" }" / > </td>
                            <td>Salida :<c:set var="variableNombreX" value="${((10+10)*50)}" scope="session"/>
                                <c:out  value="${variableNombreX}"/>
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : catch > tag, Permite manejar un error... manejo de exception

                    Ejemplo :
                    <table style="width: 50%" >
                        <tr>
                            <td>Codigo :< c : catch var="catchException" > 
                                < % int x=5/0; %>
                                < / c : catch>
                                < c : if test="$ {catchException!=null}"/>
                                < p > la exception es: $ {catchException} < br/ >
                                y la especificacion de la exception es: $ {catchException.message}
                                < / c: if >

                            <td>Salida :<c:catch var="catchException" > 
                                    <% int x = 5 / 0;%>
                                </c:catch>
                                <c:if test="${catchException!=null}">
                                    <p> la exception es: ${catchException} <br/>
                                        y la especificacion de la exception es: ${catchException.message}
                                    </c:if>                                
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : remove > tag, Elimina una variable desde su correspondiente scope o el primer scope que se encuentre la variable(si no)
                    es especificado el scope
                    Ejemplo :
                    <table style="width: 50%" >
                        <tr>
                            <td>Codigo :< c :set var="variableNombreX" value="$ {((10+10)*50)} scope="session"  / > 
                                Codigo :valor antes de remover< c out value="$ {variableNombreX}" }" / > 
                                Codigo :< c : remove var="variableNombreX" / >
                                Codigo :valor despues de remover< c out value="$ {variableNombreX}" }" / >
                            <td>Salida :<c:set var="variableNombreX" value="${((10+10)*50)}" scope="session"/>
                                Valor antes de remover : <b><c:out  value="${variableNombreX}"/></b>
                                <br>
                                <c:remove var="variableNombreX"/>
                                Valor despues de remover<c:out  value="${variableNombreX}"/>
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : if > tag que evalua una expresión lógica Ejemplo :
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : set var="sueldo" scope="session" value="$ {500 }" />
                                < c : if test="$ {sueldo>100}" >
                                <p>El sueldo es mayor que 100,y es de < c : out value="$ {sueldo}" /></p>
                                < / c :if>
                            <td>Salida :<c:set var="sueldo" scope="session" value="${500}" />
                                <c:if test="${sueldo>100}">
                                    <p>El sueldo es mayor que 100,y es de <c:out value="${sueldo}" /></p>
                                </c:if>                                
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : choose > tag que trabaja como lo haría un switch el cual evalua la opción entre un número de alternativas 
                    esta compuesto de:
                    <ul>
                        <li>< c : choose> tag sin atributos</li>
                        <li>< c : when > tag con un atributo el cual es evaluado</li>
                        <li>< c :otherwise > tag sin atributos </li>
                    </ul>                    
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : set var="sueldo" scope="session" value="$ {500}"/>
                                su sueldo es de: < c : out value="$ "value"/>
                                < c :choose>
                                < c : when test="$ {sueldo<=0}">
                                sueldo es muy bajo 0
                                </ c : when>
                                < c : when test="$ {sueldo==500}">
                                sueldo es normalito
                                </ c : when>
                                < c : otherwise >
                                Sin comentarios
                                </ c : when>                                    
                                </ c : choose>
                            </td>
                            <td>Salida :<c:choose>
                                    <c:when test="${sueldo<=0}">
                                        sueldo es muy bajo 0
                                    </c:when>
                                    <c:when test="${sueldo==500}">
                                        sueldo es normalito
                                    </c:when>
                                    <c:otherwise >
                                        Sin comentarios
                                    </c:otherwise>                                    
                                </c:choose>                               
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : import > tag que permite todas las funcionalidades que provee < include >pero solo en la inclusión de urls absolutas               
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : import var="data" url="http://www.algo.com" />
                                < c : out  value="$ {data}"/>
                            <td>Salida :

                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : forEach > tag que permite realizar las acciones de un while do-while o for, este itera sobre una coleción de objetos
                    tambien tenemos < c :forTokends> tag que permite romper una cadena o descomponerla e iterar en cada uno de los elementos
                    ejemplo forEach
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : forEach var="i" begin="1" end="5">
                                item :< c : out value="$ {i}"/>
                                </ c : forEach>
                            <td>Salida :<c:forEach var="i" begin="1" end="5">
                                    item :<c:out value="${i}"/>
                                </c:forEach>                                
                            </td>
                        </tr>
                    </table>
                    ejemplo forTokens
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : forTokens items="uno,dos,tres" delims="," var="numeros">
                                item :< c : out value="$ {numero}"/>
                                </ c : fortokens>
                            <td>Salida :<c:forTokens items="uno,dos,tres" delims="," var="numeros">
                                    item :<c:out value="${numeros}"/>
                                </c:forTokens>                                
                            </td>
                        </tr>
                    </table>
                </li>
                <li>< c : param> Este tag permite incoporar parametros de salida a una url especifica
                    <table style="width: 50%" >
                        <tr>
                            <td>< c : url value="/algo.jsp" var="urlDestino">
                                < c :param name="valorUno" value="123"/>
                                < c :param name="valorDos" value="totalX"/>
                                < / c :url>
                                < c :import url="$ {urlDestino}"/>
                            <td>Salida :
                                /algo.jsp?valorUno=123;valorDos=totalX
                            </td>
                        </tr>
                    </table>                    
                </li>
                <li>< c : redirect> tag que redirecciona el browser a una URL alternativa se suele usar con < c :param>
                    <table style="width: 50%" >
                        <tr>
                            <td>
                                < c : redirect url="http://www.x.com"/>
                            <td>Salida :
                                Redireccionamiento a pagina x
                            </td>
                        </tr>
                    </table>                    
                </li>
                <li>< c : url> tag que permite crear una url de destino, en si una alternativa para llamar al metodo response.encodeURL ()
                    <table style="width: 50%" >
                        <tr>
                            <td>
                                < a href ="< c : url value="http://www.x.com"/>"> prueba < /a> 
                            <td>Salida :
                                Redireccionamiento a pagina x
                                <a href="<c:url value="http://www.x.com"/>"> Redirecionamiento  </a>
                            </td>
                        </tr>
                    </table>                    
                </li>
                <li>recueracion de información get post
                    <table style="width: 50%" >
                        <tr>
                            <td>                                                            
                                //Solo recupera parametros Strings que se han mandado por la url, vía Post o Get.
                                ${param.test} --> request.getParameter("test") ;
                            <td>
                        </tr>
                        <tr>
                            <td>
                            //Recuperan un objeto cuya clave se pasa como parametro, es un hashMap definido.
                            $ {requestScope.test} --> request.getAttribute("test");
                            </td>
                        </tr>
                        <tr>
                            <td>
                                $ {sessionScope.test} --> session.getAttribute("test");   
                            </td>
                        </tr>
                        <tr>
                            <td>
                                $ {applicationScope.test} --> application.getAttribute("test");
                            </td>
                        </tr>
                        <tr>
                            <td>
                                $ {pageScope.test} --> pageContext.getAttribute("test");
                            </td>
                        </tr>
                        <tr>
                            <td>
                                $ {test} --> pageContext.findAttribute("test");
                            </td>
                        </tr>
                    </table>                    
                </li>
            </ol>
            <h1 class="capital">Ejemplo usando consultas</h1>    
            <jsp:include page="./listadoPerfil" flush="true"/>
            <jsp:useBean id="tipoPerfil" class="duoc.cl.dej4501.ejemploJstl.entidades.Perfil" scope="page"/>
            <table style=" width: 30%">
                <thead>
                    <tr>
                        <th>codigo perfil</th>
                        <th>Nombre perfil</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaPerfil}" var="tipoPerfil">
                        <tr>
                            <td><c:out value="${tipoPerfil.codigo_perfil}"/></td>
                            <td><c:out value="${tipoPerfil.nombre_perfil}"/></td>                    
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
        <jsp:include page="MenuPie.jsp" flush="true"/>      
    </body>
</html>
