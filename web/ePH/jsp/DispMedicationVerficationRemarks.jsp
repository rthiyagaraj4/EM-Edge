<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<title><fmt:message key="ePH.VerificationRemarks.label" bundle="${ph_labels}"/></title>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="frmauditlogheader" id="frmauditlogheader" >
<%
	String order_id	            = request.getParameter("order_id");	
	String order_line_no			= request.getParameter("order_line_no");
	String verify_remark="";
	String	bean_id				= "DispMedicationBean" ;
	String	bean_name			= "ePH.DispMedicationBean";
	DispMedicationBean bean		= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
	//bean.setLanguageId(locale);
	HashMap verifyremarks   = (HashMap)bean.getverifyremarks();
	if(verifyremarks.size()>0)
	     verify_remark    = (String)verifyremarks.get(order_id+order_line_no);
	if(verify_remark==null)
		 verify_remark="";
	
		
   %>	
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="patientiddisplaytable">
		  <tr>	<!-- checkMaxLimitTextarea added for ml-mmoh-crf-1755 -->	 
			  <td  width="20%"><textarea name="verify_remarks" cols="60" rows="5" onblur=" checkMaxLimitTextarea(this,255);" onKeyPress="return checkMaxLimit(this,255);"   ><%=verify_remark%></textarea></td>
          </tr>
		  <tr>
			  <TD > <INPUT TYPE="button" CLASS="button" name="record" id="record" VALUE='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onClick="recordverificationremarks(document.frmauditlogheader.verify_remarks,'<%=order_id%>',<%=order_line_no%>);window.close();" ></TD>
		  </tr>	  
	   </table>  			  

</form>
</body>

</html>
	
<%
//putObjectInBean(bean_id,bean,request);
%>

