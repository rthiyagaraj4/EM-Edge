<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<title>myHIX Audit Log</title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMP/js/MyHixSearch.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	try
	{	
		con		= ConnectionManager.getConnection(request);	
		request.setCharacterEncoding("UTF-8");
		
		String class_val		= "QRYEVENSMALL";		
		String locale			= checkForNull((String)session.getValue("locale"));
		String doc_id		= checkForNull(request.getParameter("doc_id"));
		String pat_id		= checkForNull(request.getParameter("pat_id"));
		String my_hix_pat_id		= checkForNull(request.getParameter("my_hix_pat_id"));
		
		pstmt = con.prepareStatement(" select USER_ID,(select appl_user_name from sm_appl_user where appl_user_id=USER_ID) USER_NAME,MACHINE_NAME,to_char(MESSAGE_DATE,'dd/mm/yyyy HH24:mi:ss') MESSAGE_DATE from XH_INTERACTIVE_INTEGRATION where PGM_ID='MYHIX2' and EVENT_TYPE = 'X03' and upper(substr(ACCESSION_NUM,instr(ACCESSION_NUM,'<MYHIX_DOC_ID>')+14,instr(ACCESSION_NUM,'<REQ_TYPE>')-instr(ACCESSION_NUM,'<MYHIX_DOC_ID>')-17))=upper(?)");
					
		//out.println(" select USER_ID,(select appl_user_name from sm_appl_user where appl_user_id=USER_ID) USER_NAME,MACHINE_NAME,MESSAGE_DATE  from XH_INTERACTIVE_INTEGRATION where PGM_ID='MYHIX2' and EVENT_TYPE = 'X03' and upper(substr(ACCESSION_NUM,instr(ACCESSION_NUM,'<MYHIX_DOC_ID>')+14,instr(ACCESSION_NUM,'<REQ_TYPE>')-instr(ACCESSION_NUM,'<MYHIX_DOC_ID>')-17))=upper(?)");

		//out.println("doc_id-->"+doc_id);

		pstmt.setString(1, doc_id);
		rs = pstmt.executeQuery();

		int i=0;
		
			
	%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='myHixAuditLog' id='myHixAuditLog' method="post" target='messageFrame'>

<% if(rs != null && rs.next()){ %>

		<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
<tr>
<td class="columnheadercenter" align='center'  colspan="4"><b>Audit Log</b></td>
</tr>
	
			<tr>
				<td colspan=4 width='50%' class="columnheader" align='left'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:-&nbsp;&nbsp;<%=pat_id%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Document Id:-&nbsp;&nbsp;<%=doc_id%></td>
			</tr>
			<tr>
		<td>
			<tr>
				<td width='25%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.userid.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='25%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.username.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='25%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
				<td width='25%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.WorkStation.label" bundle="${common_labels}"/></td>
			</tr>		
			<%
				if(class_val.equals("QRYEVENSMALL")){
					class_val = "QRYODDSMALL";
				}else{
					class_val = "QRYEVENSMALL";
				}
			
			String user_id="";
			String user_name="";
			String view_date="";
			String workstation_id="";

			while(rs.next()) {
			
				user_id		= rs.getString("USER_ID");
				user_name		= rs.getString("USER_NAME");
				view_date		= rs.getString("MESSAGE_DATE");
				workstation_id		= rs.getString("MACHINE_NAME");
				

			%>
			<tr>
				<td width='25%' nowrap class='<%=class_val%>'><%=user_id%></td>
				<td width='25%' nowrap class='<%=class_val%>'><%=user_name%></td>
				<td width='25%' nowrap class='<%=class_val%>'><%=view_date%></td>
				<td width='25%' nowrap class='<%=class_val%>'><%=workstation_id%></td>
				
			</tr>
			<% } %>
		</td>
	</tr>
</table>
	
<% }else{ %>
	
	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		window.close();
	</script>



<% } %>
</form>
</body>
		
<%	
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e)
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);

}	
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

