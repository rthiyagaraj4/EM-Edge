<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	//String btnDisplay = request.getParameter("btnDisplay") == null ? "Y" : request.getParameter("btnDisplay");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");

	
	//newly added
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		The below Query was changed by
		Name   : DINESH T
		Date   : 2010-08-05
		INCNO  : 23119
		Changes: used decode function in the query to get the thai value from the patient details if thai 
		         character is available and if not get the english character itself.
		*/
		String sql = "select decode(?,'en',a.patient_name,nvl(a.patient_name_loc_lang,a.patient_name)) patient_name, a.sex, GET_AGE(a.date_of_birth) age from mp_patient a where patient_id = ?";
		String patient_name = "",		age = "";
		String sex = "",pat_line ="";

		try
		{
			//con = ConnectionManager.getConnection(p);
			con = ConnectionManager.getConnection(request);
			if(con != null)
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,localeName);
				pstmt.setString(2,patient_id.trim());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					patient_name = rs.getString(1)== null ? "" : rs.getString(1);
					sex = rs.getString(2)== null ? "" : rs.getString(2);
					age = rs.getString(3)== null ? "" : rs.getString(3);
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	
						
			if(sex.equals("M"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else
			if(sex.equals("F"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			
			pat_line = patient_name+","+age+","+sex+","+patient_id;

			
		
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}

	// new add ends....

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>
<html>
	<head>
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='groupCloseForm' id='groupCloseForm'>
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td align='right'>
						<input class='button' type='button' name='grpButtonPrint' id='grpButtonPrint' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onclick='printing()' >
						<input class='button' type='button' name='grpButtonClose' id='grpButtonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='window.close()' >			
					</td>
				</tr>
			</table>
			<input type='hidden' name='selected_events_uom' id='selected_events_uom' value='<%=request.getParameter("selected_events_uom")%>'>
			<input type='hidden' name='no_of_selections' id='no_of_selections' value='<%=request.getParameter("no_of_selections")%>'>
			<input type='hidden' name='noOfGroups' id='noOfGroups' value='<%=request.getParameter("noOfGroups")%>'>
			<input type='hidden' name='grpDetails' id='grpDetails' value='<%=request.getParameter("grpDetails")%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			<input type='hidden' name='pat_line' id='pat_line' value="<%=java.net.URLEncoder.encode(pat_line,"UTF-8")%>">
		</form>
	</body>
</html>

