<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="eFM.InvalidFile.label" bundle="${fm_labels}"/></title>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
	<FORM name = 'OutstandingInvalidList_form' >
		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left'>
			<tr>
				<td class='label' colspan='2'> <b>Following File(s) are Not Associated to FS Location</b><td>
			</tr>
			<tr><th width='30%'><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></th>
			<th width='70%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th><tr>
	<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	try
	{
		String classValue	= "";

		StringBuffer SelectSqlBuffer	= null;
		SelectSqlBuffer					= new StringBuffer();
		
		int i = 0;

		String Reqno		= request.getParameter("Reqno");

		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  A.FILE_NO" );
		SelectSqlBuffer.append("  , Get_patient_line(a.PATIENT_ID,'"+localeName+"') PLINE " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  FM_REQ_DTL A" );
		SelectSqlBuffer.append("WHERE a.REQ_NO = ? " );
		SelectSqlBuffer.append("  AND a.ISS_YN = 'N' " );
		SelectSqlBuffer.append("  AND A.FILE_NO NOT IN (" );
		SelectSqlBuffer.append("  SELECT" );
		SelectSqlBuffer.append("    A.FILE_NO " );
		SelectSqlBuffer.append("  FROM" );
		SelectSqlBuffer.append("    FM_REQ_DTL A" );
		SelectSqlBuffer.append("    , FM_CURR_LOCN B" );
		SelectSqlBuffer.append("    , FM_REQ_HDR C " );
		SelectSqlBuffer.append("  WHERE A.REQ_NO = ? " );
		SelectSqlBuffer.append("    AND A.ISS_YN = 'N' " );
		SelectSqlBuffer.append("    AND A.FILE_NO = B.FILE_NO " );
		SelectSqlBuffer.append("    AND A.REQ_NO = C.REQ_NO " );
		SelectSqlBuffer.append("    AND A.CURR_FACILITY_ID = B.CURR_FACILITY_ID" );
		SelectSqlBuffer.append("  ) " );
		SelectSqlBuffer.append("ORDER BY" );
		SelectSqlBuffer.append("  1" );
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		pstmt.setString(1,Reqno);
		pstmt.setString(2,Reqno);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{ 
			if(i % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD" ;

			out.println("<tr><td class='"+classValue+"'><font size=1>");
			out.println(rs.getString("FILE_NO"));
			out.println("</font></td><td class='"+classValue+"'><font size=1>");
			out.println(rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6));
			out.println("</font></td></tr>");
			i++;
		} //endwhile
		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
	if(rs!=null)    rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
	</TABLE>
</FORM>
</BODY>
</HTML>

