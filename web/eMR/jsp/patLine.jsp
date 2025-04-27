<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
	String locale			= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs=null;
	try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	
	String Patient_Id = request.getParameter("Patient_Id");
	String patdtl = "select get_patient_line('"+Patient_Id+"','"+locale+"') from dual";
	String Pat_Details="";
	String PatDetails=""; 
	try
	{
	 rs=stmt.executeQuery(patdtl);
	 if(rs !=null) {
	 	if(rs.next()) {
	 	Pat_Details = rs.getString(1);
	 	}
	  }
	 }
	 catch(Exception e){
	   //out.println(e.toString());
	   e.printStackTrace();
	}
	PatDetails=Pat_Details.substring(0,(Pat_Details.indexOf('#')));
%>	
<html>
<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
<td class='PATIENTLINECOLOROTHLANG' width='100%'  style='position:relative;'><%=PatDetails%></td><td class='PATIENTLINECOLOROTHLANG' width='0%' ></td>
</tr>
</body>
</html>
<%
	}catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();}
finally{
	try
	{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	}
	catch(Exception e){}
	ConnectionManager.returnConnection(con,request);
}
%>

