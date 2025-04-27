<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
       request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OncologyRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE><fmt:message key="ePH.FluidRemarks.label" bundle="${ph_labels}"/> </TITLE>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String patient_id			= request.getParameter( "patient_id" ) ;
	String encounter_id			= request.getParameter( "encounter_id" ) ;
	String bean_id				= request.getParameter( "bean_id" ) ;
	String bean_name			= request.getParameter( "bean_name" ) ;
	String default_fluid_name	= request.getParameter( "default_fluid_name" ) ;	
	OncologyRegimenBean bean = (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
    
	String	diag_text	     = 	 bean.getDefaultFluidremarks();
    if(diag_text.equals(""))
	  diag_text="Default fluid "+default_fluid_name+" changed. Remarks : ";

%>
<FORM name="OncologyFluidRemarksForm" id="OncologyFluidRemarksForm" ><BR>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="left" BORDER="0">

<tr><td class="label" >
<textarea rows="5" cols="60" size="255" name='fluidremarks'><%=diag_text%></textarea></td>
</tr>
<tr>
<td ><input type='button' class="button" name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="storeFluidRemarks(fluidremarks,'<%=patient_id%>','<%=encounter_id%>');parent.window.returnValue='Y';">
<input type='button' class="button" name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.window.close()"><td/><tr>
</TABLE>
	 <input type="hidden" name="bean_id" id="bean_id"	value="<%=bean_id%>"	>
 	 <input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"	>
</FORM>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

