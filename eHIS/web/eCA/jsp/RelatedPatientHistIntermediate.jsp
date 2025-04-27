<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
 <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	con = ConnectionManager.getConnection(request);
	String arr[]={"","",""};
	int count = 0;
	String patient_id ="";
	String facilityId ="";
	String encounter_id ="";
	String term_set_id ="";

	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	facilityId=request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	

	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    <head>
	</head>
	<body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form >

<%

try
	{
	//String dfltdiagSql="select diag_code||'-'||DIAG_DESC Diag from pr_diagnosis where patient_id=? and ONSET_FACILITY_ID = ? and ONSET_ENCOUNTER_ID=? and term_set_id=?  ";
	String dfltdiagSql="select a.TERM_CODE||'-'||SHORT_DESC Diag from pr_diagnosis a,mr_term_code b where patient_id=? and ONSET_FACILITY_ID = ? and ONSET_ENCOUNTER_ID=? and a.term_set_id=? and a.TERM_SET_ID =b.TERM_SET_ID and a.TERM_CODE =b.TERM_CODE ";


			pstmt = con.prepareStatement(dfltdiagSql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,encounter_id);
			pstmt.setString(4,term_set_id);
			rs = pstmt.executeQuery();
			while(rs.next() && count < 3)
			{
				arr[count]=(rs.getString("Diag")==null)?"":rs.getString("Diag");
			//	out.println("<script>alert('diag"+arr[count]+"');</script>");
				count++;
			}

			out.println("<script>");
			out.println("top.content.workAreaFrame.frames[0].document.forms[0].diag.value='"+arr[0]+"'");
			out.println("top.content.workAreaFrame.frames[0].document.forms[0].diag2.value='"+arr[1]+"'");
			out.println("top.content.workAreaFrame.frames[0].document.forms[0].diag3.value='"+arr[2]+"'");
			//out.println("top.content.workAreaFrame.frames[0].document.forms[0].diag.value='abcd'");
			out.println("</script>");
			
			if(rs!=null) rs.close();
  		    if(pstmt!=null) pstmt.close();

	}
	catch(Exception e )
		{
			
			//out.println("Exception in JSP RelatedPatientHistIntermediate.jsp.."+e.toString());//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}


%>

	</form>
 </body>
</html>

