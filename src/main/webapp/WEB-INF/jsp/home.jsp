<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<jsp:include page="cabeceraTag.jsp" />
		
	
	</head>
	<body>
		<jsp:include page="cabecera.jsp"/>
		<div class="container principal">
    		<div class="wrapper principal">
    			<div class="row">
    				<jsp:include page="menu.jsp"/>
    				<div id="cuerpo" class="cuerpo">
    				 	<jsp:include page="inicio.jsp"/>
        	
            		</div><!-- cuerpo -->
    			</div> <!-- row -->
    		</div><!-- wrapper principal -->
    	</div> <!--  container principal -->
			<jsp:include page="footer.jsp"/>

	</body>
</html>