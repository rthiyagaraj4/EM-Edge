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

	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseLocation.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
    String	bean_id				= "ReturnMedicationBean" ;
	String	bean_name			= "ePH.ReturnMedicationBean";
	ReturnMedicationBean bean		= (ReturnMedicationBean)getBeanObject( bean_id, bean_name, request);
				
	String dis_cont_reason =request.getParameter("dis_cont_reason");
	String DISC_DATE_TIME = request.getParameter("DISC_DATE_TIME");
	String pract_name = request.getParameter("pract_name");
	//out.println("dis_cont_reason=======>" +dis_cont_reason);
	
	
%>
     
</head>
<title><fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/> </title>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="formDiscontinueReason" id="formDiscontinueReason">
<table width='100%' border='0' cellspacing='1' cellpadding='1'  align='left'>
	<TR>
			
			<td class="label" colspan=2>
			<textarea rows="7" cols="70" maxLength="400"  size="400" readonly  name="Discontinue_reason"><%=dis_cont_reason%></textarea>
			</td>
	</TR>
	
	<tr>
	    
	    <td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/>
	    <fmt:message key="Common.and.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
		<td class="label"><b><%=DISC_DATE_TIME%></b></td>
	</TR>

	
	<TR> 
	     <td class="label"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td class="label"><b><%=pract_name%></b></td>
	</TR> 
	
	<TR>
	  <td align='right' colspan=2> 
	  <input type='Button' class='Button' name='DisClose' id='DisClose'  value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick='window.close();' ></td>
	</TR>

</table>
	
</form>
</body>

</html>
	
<% 

%>

