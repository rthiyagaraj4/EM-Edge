<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<html>
     <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../js/ShiftForLocationType.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function changeColor(Obj)
			{
			if(Obj.name == 'facility')
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('shift').className='IPCAHIGHERLEVELCOLOR'
				}
				else
				{
					Obj.className='IPCASELECTEDCOLOR';
					document.getElementById('facility').className='IPCAHIGHERLEVELCOLOR'
				}
				
			}
		</script>
		
	 </head>
	 	 <% String facility_id = (String)session.getValue( "facility_id" );
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
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));history.go(-1);
				</script>
		<%	}
			else
			{	
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="50%">
	<tr>
		<td class='BODYCOLORFILLED' width='10%'>&nbsp;</td>
		<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showFacility();changeColor(this);' align='left' name='facility'  id='facility'>&nbsp; <fmt:message key="eAM.ByLocationType.label" bundle="${am_labels}"/></td>
		<td class='IPCAHIGHERLEVELCOLOR' onClick='javascript:showShift();changeColor(this);' align='left' name='shift'  id='shift'> &nbsp; <fmt:message key="Common.ByShift.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
</body>
</frameset>	
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

