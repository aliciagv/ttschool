<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- Archivos CSS BOOTSTRAP -->
 	<link href="/bootstrap-3.3.7/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/> <!--TEMA POR DEFECTO -->
	<link href="/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<!-- Archivos CSS Propios -->
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
	<div id="wrapper">
		<jsp:include page="menu.jsp"/>
	
	<div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                    <h1>Welcome Admin!</h1>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <div id="footer">
    <jsp:include page="footer.jsp"/>
</div> 
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->

    



</body>
</html>