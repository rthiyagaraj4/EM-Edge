<!DOCTYPE html>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <%
 
 String sql_image_flag = request.getParameter("sql_image_flag"); 
//RUT-CRF-0091 by MuthuN Starts Here
// String ic_image = request.getParameter("image"); 
 String st_location = checkForNull(request.getParameter("st_location")); 
//RUT-CRF-0091 by MuthuN Ends Here
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
 String imageUrl = "";
 try{
	String facility_id	= (String) session.getValue("facility_id");
	String sql_instr_cssd = "select cssd_image_location from ot_param_for_facility where operating_facility_id ='"+facility_id+"'";
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(sql_instr_cssd) ;
	rs = stmt.executeQuery();
	while(rs.next()){
		imageUrl=checkForNull(rs.getString(1));			
	}

	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
}
catch(Exception e){
	System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
}
finally{
	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request); 
}

try{
	sql_image_flag = imageUrl+(char)92+sql_image_flag;
	System.err.println("sql_image_flag-> "+sql_image_flag);
}
catch(Exception e){
	System.err.println("Err Msg Copying File "+e.getMessage());
}
 %>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='center'>
<table  cellpadding='0' cellspacing='0' >
<br><br>
	<tr>
		<td>
			<img src ='<%=sql_image_flag%>' width="400" height="400" align="middle">
		</td>		
	</tr>
	<tr>
<!-- RUT-CRF-0091 by MuthuN Starts Here-->
	<td><br><br><center>
	<%=st_location%>
	</td></center>
	<!-- RUT-CRF-0091 by MuthuN Ends Here-->
	</tr>
</table>
</div>
</body>
</html>


