<!DOCTYPE html>
<HTML>
<%@ page import="java.util.*"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page
	import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<HEAD>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eXH/js/CommnClients.js'></script>
<script language="javascript" src="../../eXH/js/Validate.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<TITLE><fmt:message key="eXH.Protocol.Label"
		bundle="${xh_labels}" /></TITLE>

</HEAD>

<%
	String code_desc = com.ehis.util.BundleMessage.getBundleMessage(
			pageContext, "Common.code.label", "common_labels");
	String desc_desc = com.ehis.util.BundleMessage.getBundleMessage(
			pageContext, "Common.description.label", "common_labels");

	String applicationName = request.getParameter("applicationName");
	String applicationID = request.getParameter("applicationID");
	//	String facilityName = request.getParameter("facilityName");
	//	String facilityID = request.getParameter("facilityID");
	String protocol_mode = request.getParameter("protocol_mode");
	//String protocol_link_id = request.getParameter("protocol_link_id");
	String client_id = request.getParameter("client_id");

	/*
	 if(facilityID == null || facilityID.equals(""))
	 {
	 facilityID = "XX";
	 }
	 */

	ResultSet rs = null;
	Statement stmt = null;
	Connection con = null;

	int count = 0;
	int tempCount = 0;

	String sqlStmt = "SELECT protocol_link_id,protocol_link_name FROM xh_protocol_link "
			+ " WHERE APPLICATION_ID LIKE '"
			+ applicationID
			+ "%'"
			+ " AND protocol_link_id NOT IN"
			+ " (SELECT protocol_link FROM XH_COMM_CLIENT_APPLICATION WHERE application_id='"
			+ applicationID
			+ "'"
			+ " AND CLIENT_ID='"
			+ client_id
			+ "' AND COMM_TYPE ='"
			+ protocol_mode
			+ "')"
			+ " AND protocol_id"
			+ " IN (SELECT protocol_id FROM xh_protocol WHERE protcol_mode='"
			+ protocol_mode + "')ORDER BY 1";
	try {
		con = ConnectionManager.getConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(sqlStmt);
		if (rs.next())
			tempCount = 1;
		else
			tempCount = 0;
		rs.beforeFirst();
	} catch (Exception ex) {
		System.out.println("(AddProtocolLinkId:Exception-1) :"
				+ ex.toString());
	}
%>


<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()"
	onKeyDown="lockKey()" onLoad="recordsNotFound()">
	<input type="hidden" name="count" id="count" value="<%=tempCount%>">
	<form name="AddProtocolLinkID" id="AddProtocolLinkID" method='post'
		action="../../servlet/eXH.AddProtocolLinkIDServlet">
		<table border="0" width="102%" cellspacing="0" cellpadding="0">
			<tr>
				<td class="label"><fmt:message key="eXH.ApplicationName.Label"
						bundle="${xh_labels}" /></td>
				<td><INPUT TYPE="text" name="applicationName"
					id="applicationName" value="<%=applicationName%>" readonly="true"></td>
				<td class="label"><fmt:message key="eXH.ApplicationID.Label"
						bundle="${xh_labels}" /></td>
				<td><INPUT TYPE="text" name="applicationID" id="applicationID"
					value="<%=applicationID%>" readonly="true"></td>
			</tr>
			<table>
				<table border="1" width="102%" cellspacing="0" cellpadding="0"
					align="center" id="ResultTab">
					<th width="10%"><fmt:message key="Common.defaultSelect.label"
							bundle="${common_labels}" /></th>
					<th><%=desc_desc%></th>
					<th><%=code_desc%></th>
					<%
						try {
							boolean classFlag = true;
							String classValue = "QRYEVEN";
							while (rs.next()) {
								count++;
								if (classFlag) {
									classValue = "QRYEVEN";
									classFlag = false;
								} else {
									classValue = "QRYODD";
									classFlag = true;
								}
					%>
					<tr>
						<td class="<%=classValue%>" width="15"><input type="checkbox"
							name="check_<%=rs.getString("PROTOCOL_LINK_ID")%>"
							id="check_<%=rs.getString("PROTOCOL_LINK_ID")%>"></td>
						<td cl
							
						=rs.getString("PROTOCOL_LINK_ID")%></td>
					</tr>
					<%
						}
							if (count < 1) {
					%>
					<script>
			//parent.f_query_footer.location.href='../../eCommon/html/blank.html';
			//	recordsNotFound();
			</script>
					<%
						}
						} catch (Exception exp) {
							System.out.println("(AddProtocolLinkId:Exception-2) "
									+ exp.toString());
							exp.printStackTrace(System.err);
						} finally {
							ConnectionManager.returnConnection(con);
							if (stmt != null)
								stmt.close();
							if (rs != null)
								rs.close();
						}
					%>
				</table>
				<table border="0" width="102%" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr align="center">
						<td><INPUT class="BUTTON" TYPE="button"
							onclick="addProtocol()"
							value="<fmt:message key="Common.Add.label" bundle="${common_labels}"/>">
						</td>
					</tr>
				</table>
				<INPUT TYPE="hidden" name="protocol_mode" id="protocol_mode"
					VALUE="<%=protocol_mode%>">
				<INPUT TYPE="hidden" name="client_id" id="client_id"
					VALUE="<%=client_id%>">
</BODY>
</HTML>

