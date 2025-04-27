<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	String patient_id	= request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id");
//	String order_id		= request.getParameter("order_id");
	String srl_no		= request.getParameter("srl_no");
	String page_mode	= request.getParameter("mode");
	String bean_name	= "ePH.PrescriptionBean_1";
	String remarks		="";

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	
	if(page_mode!=null && (page_mode.equals("curr_rx"))){
		HashMap remarkMap=(HashMap)bean.getAmendRxRemarks();
		remarks=(String)remarkMap.get(srl_no);
	}else if(page_mode!=null && (page_mode.equals("allergy"))){
		HashMap remarkMap=(HashMap)bean.getAmendAllergyRemarks();
		remarks=(String)remarkMap.get(srl_no);
	}else if(page_mode!=null && (page_mode.equals("over_dose"))){
		HashMap remarkMap=(HashMap)bean.getAmendDoseRemarks();	
		remarks=(String)remarkMap.get(srl_no);
	}else{	
	remarks= (String)bean.getAmendOrderRemarks();
	}
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_remarks" id="prescription_remarks">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
 <td  class="label"><textarea cols="78" rows="10" name="order_remarks" ><%=remarks%></textarea><input type="hidden" value="<%=bean_id%>" name="bean_id"><input type="hidden" value="<%=bean_name%>" name="bean_name"><input type='hidden' value='<%=page_mode%>' name='page_mode'><input type="hidden" value="<%=srl_no%>" name="srl_no"><input type='hidden' value='' name='mode' id='mode'></td>
</tr>
</table>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

