<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<jsp:include page="../cabeceraTag.jsp" />

		<link href="<c:url value="/css/book.css" />" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="../cabecera.jsp"/>
		<div class="container principal">
    		<div class="wrapper principal">
    			<div class="row">
    				<jsp:include page="../menu.jsp"/>
    				<div id="cuerpo" class="cuerpo">
						<jsp:include page="listar.jsp"/>
            		</div><!-- cuerpo -->
    			</div> <!-- row -->
    		</div><!-- wrapper principal -->
    	</div> <!--  container principal -->
    	<jsp:include page="../footer.jsp"/>
    	

  
  		<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	
		


	</body>
</html>