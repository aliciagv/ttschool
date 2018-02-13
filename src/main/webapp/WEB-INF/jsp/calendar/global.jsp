<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<jsp:include page="../cabeceraTag.jsp" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css"/>
		<link href="<c:url value="/fullcalendar/fullcalendar.css" />" rel="stylesheet" />
		<link href="<c:url value="/css/calendar.css" />" rel="stylesheet" />

	</head>
	<body>
		<jsp:include page="../cabecera.jsp"/>
		<div class="container principal">
    		<div class="wrapper principal">
    			<div class="row">
    				<jsp:include page="../menu.jsp"/>
    				<div id="cuerpo" class="cuerpo">
    				 	<jsp:include page="gcalendar.jsp"/>
        	
            		</div><!-- cuerpo -->
    			</div> <!-- row -->
    		</div><!-- wrapper principal -->
    	</div> <!--  container principal -->

		<jsp:include page="../footer.jsp"/>	
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
		<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
		<script src="<c:url value="/js/validation.js" />"></script>
    	<script src="<c:url value="/js/moment.min.js" />"></script>
    	<script src="<c:url value="/js/fullcalendar.js" />"></script>
    	<script src="<c:url value="/js/calendar.js" />"></script>
    	<script src="<c:url value="/js/locale/locale-all.js" />"></script>
	</body>
</html>