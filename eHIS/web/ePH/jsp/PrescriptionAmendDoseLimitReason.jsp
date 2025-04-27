<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale = (String) session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>Override Reason</title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="amend_dose_limit" id="amend_dose_limit" >
<%
	String patient_id		=	request.getParameter("pat_id");
	String encounter_id		=	request.getParameter("enc_id");
	String drug_desc		=	request.getParameter("drug_desc");
	String mono_graph		=	request.getParameter("mono_graph");
	String daily_dose		=	request.getParameter("daily_dose");
	String unit_dose		=	request.getParameter("unit_dose");
	String limit_ind		=	request.getParameter("limit_ind");
	String drug_code		=	request.getParameter("drug_code");
	String srl_no			=	request.getParameter("srl_no");
	String	bean_id			=	"@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		=	"ePH.PrescriptionBean_1";
	
	PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	HashMap remarkMap=(HashMap)bean.getAmendDoseRemarks();	
	String exceed_dose=(String)remarkMap.get(srl_no);
%>

<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<tr>
	<td   class="data">&nbsp;<fmt:message key="ePH.ExceedDosageOverrideReason.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
	<td  ><label onClick="sub_showMonoGraphDetail('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>')" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.OverdoseDetails.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
	<td  class='fields' colspan="2">&nbsp;<textarea rows="3" cols="80" name="exceed_dose" onKeyPress="return checkMaxLimit(this,255);"><%=exceed_dose%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></td>
</tr>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<tr><td  class='fields' colspan="2"><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="parent.validateAmend(document.amend_dose_limit)"></td></tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="limit_ind" id="limit_ind" value="<%=limit_ind%>">
<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
<input type="hidden" name="mode" id="mode" value="">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

