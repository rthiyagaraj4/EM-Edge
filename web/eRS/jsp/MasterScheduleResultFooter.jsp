<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterScheduleResultFooter.jsp
*	Purpose 			:   
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<% 	
	String workplace_code=request.getParameter("workplace_code") ;
	String facility_id = request.getParameter("facility_id") ;
	Connection conn 		    = null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Shift_Data		= new ArrayList() ;
	String[] record				= null;
	//String sql_shift="select a.shift_code, a.shift_mnemonic, b.short_desc from rs_shift_for_workplace a, am_shift b where facility_id=? and workplace_code=? and a.shift_code=b.shift_code";
	String sql_shift="select a.shift_code, a.shift_mnemonic, b.short_desc from rs_shift_for_workplace a, am_shift_lang_vw b where facility_id=? and workplace_code=? and a.shift_code=b.shift_code and b.language_id = ?";
	conn = ConnectionManager.getConnection(request);
	try {
		//to get the shift_code & desc
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[3];				
			record[0] = resultSet.getString("shift_code");
			record[1] = resultSet.getString("short_desc");
			record[2] = resultSet.getString("shift_mnemonic");
			Shift_Data.add(record) ;
		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		resultSet.close() ;
		pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);

	}

%>
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=formResultFooter>
<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
<tr><td colspan='<%=Shift_Data.size()%>'>
<table border='1' cellpadding='0' cellspacing='0' align='left' width="100%">
<tr>
<td width='15%' class='OPTIMAL'><fmt:message key="eRS.Optimal.label" bundle="${rs_labels}"/></td>
<td width='15%' class='BELOWOPTIMAL'><fmt:message key="eRS.BelowOptimal.label" bundle="${rs_labels}"/></td>
<td width='15%' class='ABOVEOPTIMAL'><fmt:message key="eRS.AboveOptimal.label" bundle="${rs_labels}"/></td>
<td>&nbsp;</td>
<td width='15%' class='UNPRODUCTIVE'><fmt:message key="eRS.Unproductive.label" bundle="${rs_labels}"/></td>
<td width='15%' class='ONCALL'><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/></td>
</tr>
</table>
</td>
</tr>
</table>
</form>
</body>
</html>

