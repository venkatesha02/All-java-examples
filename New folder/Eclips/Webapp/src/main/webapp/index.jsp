<%@include file="/index.html" %>
<%@page import="java.util.Date"%>
<%@page errorPage="/error.jsp" %>
<%@page isThreadSafe="false" %>
<%@page session="false" %>

<%!private int i = 10;
	private String name = "Venki";

	public void printName() {
		System.out.println(name);
	}%>

<%!public void jspInit() {
	System.out.println("Init method");
	}%>

<%! public void jspDestroy(){
		System.out.println("destroy method");
	}	
	%>
<html>
<head>
<title>My First JSP</title>
</head>
<body>

	<%
		Date date = new Date();
		try {
			printName();

		} catch (Exception e) {

		}
	%>
	<h1 style="color: blue;"><%=i%></h1>
	<h1 style="color: pink;"><%=date%></h1>
	<h1><%=name%></h1>
</body>
</html>