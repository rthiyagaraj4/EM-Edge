<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/Common.jsp" %> 


<html>
<head>
	<title><fmt:message key="eAM.ShiftforPosition.label" bundle="${am_labels}"/> </title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eRS/js/RsCommon.js"></script>
 	<script>function_id = "<%=request.getParameter("function_id")%>";</script>
	<script language="javascript" src="../js/ShiftForPosition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<%
	request.setCharacterEncoding("UTF-8");	
		String facility_id = (String)session.getValue( "facility_id" );
		String operational_yn="";
		Connection con = null;
		Statement stmt=null;
		ResultSet rset=null ;
	

try
	{

	con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		rset = stmt.executeQuery("select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'OR'");
		if(rset!= null && rset.next())
		{
			operational_yn = rset.getString("operational_yn");
			if(operational_yn !=null) operational_yn="";
			if(operational_yn.equals("N") )
			{	
				%>
				<script>alert(getMessage("CA_NOT_INSTALLED","Common"));history.go(-1);
				</script>
		<%	}
			else
			{	%>
</head>
	<iframe name='frameSearch' id='frameSearch' src='../../eAM/jsp/ShiftForPositionAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
		<iframe name= "frameSelect" src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:42vh;width:100vw'></iframe>
		<iframe name="frameList" id="frameList" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:53vh;width:100vw'></iframe>

<%
			}
		}else
		{
		%>
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));history.go(-1);
				</script>
	
	<%
		}
	}catch(Exception e)
	{
		out.print("Exception "+e);
	}
	finally
	{
		try{
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();
		}catch(Exception e){}
		 if( con != null) ConnectionManager.returnConnection(con,request);
	}
%>	
</html>

