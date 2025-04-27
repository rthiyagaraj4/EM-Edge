<%
/* 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
16/06/2016	  IN060379      Raja S						Ramesh G			AAKH-SCF-0279
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>  <!-- Added for IN060379 -->
<HTML>
<HEAD> <TITLE></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//	String locale = (String) p.getProperty("LOCALE");
	String strValidpatientId = "";
	PreparedStatement pstmt = null;
	Connection con = null;
	ResultSet rs = null;
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	patient_id = patient_id.trim();
	String strCheckPatientId = "select VALID_PATIENT_ID from dr_mp_patient where duplicate_patient_id = ? ";
	String strCheck = "select install_yn from sm_module where module_id = 'DR' and install_yn ='Y' ";

	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strCheck);
		rs =  pstmt.executeQuery();

		if(rs!=null && rs.next())
		{
			if(pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();

			pstmt = con.prepareStatement(strCheckPatientId);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{
				strValidpatientId = rs.getString(1);
			}

		}
	}
	catch(Exception e)
	{
		//out.println("Exception: "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
		{
		try
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		catch(Exception e)
		{
		}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(strValidpatientId!=null && !strValidpatientId.equals(""))
	{
		%>
		<script>
			var msg1=getMessage("PAT_MERGED_VALID","MP");
			var msg2=msg1.replace("#","<%=strValidpatientId%>");
			</script>
				<%
	out.println("<script>alert(msg2);</script>");
		out.println("<script>top.content.workAreaFrame.PatCriteriaFr.document.forms[0].patientId.value='"+strValidpatientId+"'</script>");
	}
	out.println("<script>location.href='../../eCommon/jsp/error.jsp'</script>");
%>
</HEAD><BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()"></BODY></HTML>

