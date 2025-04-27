<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<body class='message' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

Connection conn  =  null;
PreparedStatement stmt = null;
ResultSet rset = null;

out.println("<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script Language='JavaScript' src='../../eCommon/js/ValidateControl.js'></Script><script language='javascript' src='../../eCA/js/LocationforPract.js'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><BODY onKeyDown = 'lockKey()' class='CONTENT' >");

try{
    String practitioner_id  = request.getParameter("practitioner_id");
	String facility_id=(String) session.getValue("facility_id");

	String Prac_name ="";
	String practitioner_name="";
	//String Prac_name_sql = "SELECT practitioner_name FROM am_pract_for_facility_vw	WHERE practitioner_id= '"+practitioner_id+"' AND operating_facility_id = '"+facility_id+"'"  ;
	String Prac_name_sql = "SELECT practitioner_name FROM am_pract_for_facility_vw	WHERE practitioner_id= ? AND operating_facility_id = ?"  ;//common-icn-0180
	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.prepareStatement(Prac_name_sql);
	stmt.setString(1,practitioner_id);//common-icn-0180
	stmt.setString(2,facility_id);//common-icn-0180
	rset = stmt.executeQuery();

	while(rset.next()) 
	{
		Prac_name = rset.getString("PRACTITIONER_NAME");
		practitioner_name = (Prac_name==null)?"":Prac_name ;
		out.println("<script>parent.frames[1].frames[0].document.forms[0].pract_name.value='"+practitioner_name+"';</script>");

		out.println("<script>parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?MstCodeError=0';</script>");

	}
	if(rset != null)rset.close();
	if(stmt != null)stmt.close();

}
catch(Exception e)
{
	//out.println("Exception in fetching connection"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}


%>

</body>
</html>

