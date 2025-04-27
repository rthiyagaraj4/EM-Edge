<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	

<%
	request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	Connection conn = null;
	Statement stmt1=null;
	ResultSet rset=null;
	
	try{
			conn = ConnectionManager.getConnection(request);
			stmt1 = conn.createStatement();
			Boolean MRWCHSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","ACKNOWLEDGMENT_LETTER");
		
			String call_function=request.getParameter("call_function");
			if(call_function == null) call_function="";		



		%>
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
			<script language='javascript' src="../../eMR/js/MRInternalReportReprint.js"></script>
			<script language='javascript' src='../../eCommon/js/common.js' ></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		</head>
		<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
		<form name="InternalReportSearch" id="InternalReportSearch" action="" method="post" target="messageFrame">

		<BR>
		<div align="left">
		<table border="0" cellpadding="3" cellspacing="0"  align='center' width='50%'>
			<tr>
			  <td width='20%' >&nbsp;</td>
			  <td class="label" width='30%'><fmt:message key="eFM.OnlineReport.label" bundle="${fm_labels}"/></td>
				<td class='fields' width='40%'><select name="ReportName" id="ReportName" onChange="codeCheck(this);" >
			   <option value='' selected>------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------</option>

			  <%
				  rset = stmt1.executeQuery("select report_id,report_desc from sm_report where module_id = 'MR'and report_id in ('MRBPATVL','MRDGRCSM') and internal_request_yn ='Y'");
					if(rset != null)
					{
					   while(rset.next())
					   {
							String report_id	= rset.getString("report_id");
							String report_desc	= rset.getString("report_desc");
							out.println("<option value='"+report_id+"'>"+report_desc+"</option>");
					   }
					}
					if(rset != null)rset.close();
					if(stmt1 != null)stmt1.close();

			  %>

			 <%if(MRWCHSiteSpecific){%>
			  <option value='MR'><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></option>
			 <%}%>
			  </td>
			</tr>

			<input type='hidden' name='call_function' id='call_function' value='<%=call_function%>'>
		</table></div>
		</body>
<%}catch(Exception ex){
		ex.printStackTrace();
}finally{
	if (conn !=null)  ConnectionManager.returnConnection(conn,request);
}

%>
</form>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

