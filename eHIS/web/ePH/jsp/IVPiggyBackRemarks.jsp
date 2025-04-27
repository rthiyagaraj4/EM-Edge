<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
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

	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/IVPiggyBack.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<TITLE><fmt:message key="ePH.FluidRemarks.label" bundle="${ph_labels}"/> </TITLE>
</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
	
	String patient_id		= request.getParameter( "patient_id" ) ;
	String encounter_id		= request.getParameter( "encounter_id" ) ;
	String bean_id		= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String default_fluid_name		= request.getParameter( "default_fluid_name" ) ;

	String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name			= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

	String	diag_text	 = "";
		diag_text = bean.getFluidRemarks();

	
%>
<FORM name="IVPiggyBackFluidRemarksForm" id="IVPiggyBackFluidRemarksForm" ><BR>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="left" BORDER="0">
<tr><td class="label" >
<textarea rows="5" cols="50" size="420" name='fluidremarks' onKeyPress='return checkMaxLimit(this,420);'><%=diag_text%></textarea></td>

</tr>
<tr>
<td ><input type='button' class="button" name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="storeFluidRemarks(fluidremarks,'<%=patient_id%>','<%=encounter_id%>');parent.window.returnValue='Y';">
<input type='button' class="button" name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.window.close()"><td/><tr>
</TABLE>
	 <input type="hidden" name="bean_id" id="bean_id"	value="<%=bean_id%>"	>
 	 <input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"	>
	 <input type="hidden" name="default_fluid_name" id="default_fluid_name"	value="<%=default_fluid_name%>"	>
	 
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(iv_bean_id,bean,request);
%>

