<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/WardReturn.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHMessages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "WardReturnBean"+login_at_ws_no;
		String bean_name	= "ePH.WardReturnBean";
		String count		= request.getParameter("countRows");
		String facilityId			= (String)session.getValue("facility_id");
		String patientid		= request.getParameter( "patientid" );
		// ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 
		//String countReturnValue  =request.getParameter("countReturn") ;
		String	countReturn =	request.getParameter("countReturn") == null?"":request.getParameter("countReturn") ;
		%>
		<form name='formWardReturn' id='formWardReturn'>
			<table width="100%" border="0">
				<TR>
					<TD align="right">
					
<%    // ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
if(countReturn.equals("1")){
	%>
	<INPUT TYPE="button" class="button" name="CancelReturn" id="CancelReturn" value='<fmt:message key="ePH.CancelReturn.label" bundle="${common_labels}"/>' onClick="cancelReturn()">	
	<%
}
else{            if(countReturn.equals("0")){
	
}
              else{	if (count.equals("0")) {
%>
						<INPUT TYPE="button"  class="button" name="Return" id="Return" value='<fmt:message key="Common.Return.label" bundle="${common_labels}"/>' onClick="apply()" disabled>	
<%
					}
					else{
%>
						<INPUT TYPE="button"  class="button" name="Return" id="Return" value='<fmt:message key="Common.Return.label" bundle="${common_labels}"/>' onClick="apply()">	
<%
					}
%>
					<INPUT TYPE="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelAction()">	
					<%}} // ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end %>
					</TD>
				</TR>
			</TABLE>
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
			<input type="hidden" name="patientid" id="patientid" value="<%=patientid%>">
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
		</form>
	</body>
</html>

