<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
   	<script language="Javascript" src="../../ePH/js/ReturnMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
    String bean_id		= "ReturnMedicationBean"+login_at_ws_no ; ;
    String bean_name	= "ePH.ReturnMedicationBean";
	ReturnMedicationBean bean		= (ReturnMedicationBean)getBeanObject( bean_id, bean_name, request);
// Removed URL Decoder& encoder  for remark_desc  Regarding incident num:25634=By Sandhya on 06-Jan-2011 
	//String remark_desc=java.net.URLDecoder.decode(java.net.URLEncoder.encode(CommonBean.checkForNull(request.getParameter("remark_desc"))));
	String remark_desc=CommonBean.checkForNull(request.getParameter("remark_desc"));
	//out.println("remark_desc=====>" +remark_desc);
	String querymode =	CommonBean.checkForNull(request.getParameter("querymode") );
	   String query_read_only ="";
	   if(querymode.equals("2")){
		   query_read_only ="readonly"	;

	   }
	%>
     
</head>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </title>


<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="Returnremarksform" id="Returnremarksform">
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	
	<td  class="label"></td>
	<td><textarea rows="7" cols="60" name="remarks_desc" maxLength="500" <%=query_read_only%>><%=remark_desc%></textarea></td>
	
		

	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
</tr>
	<TR>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
		<td align='left'>
			<input type='Button' class='Button' name='Ok' id='Ok'  value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick="ReturnRemarks(); parent.document.getElementById('dialog_tag').close();" >
		</TD>
	</TR>
</table>
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">
	
	
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

