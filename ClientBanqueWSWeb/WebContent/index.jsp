<%@page import="soapws.BanqueServiceProxy"%>
<%@page import="soapws.BanqueService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
 	double mt = 0;
 	double res = 0;
 	if (request.getParameter("montant")!=null){
 		mt = Double.parseDouble(request.getParameter("montant"));
 		BanqueServiceProxy banque = new BanqueServiceProxy();
 		res = banque.conversion_euro_to_dh(mt);
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="index.jsp">
		Montant : <input type="text" name="montant" value=<%=mt%>>
		<input type="submit" value="submit"/>
	</form>
	<%=mt%> en euro = <%=res%> en dh
</body>
</html>