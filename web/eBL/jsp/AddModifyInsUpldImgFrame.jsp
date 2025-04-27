<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eBL.*" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String params = request.getQueryString();
	String strInsPatientId	= (String)session.getAttribute("ins_patient_id");
	strInsPatientId=(strInsPatientId==null)?"":strInsPatientId;

	String strPatientId = request.getParameter("patient_id");
	//ADDED FOR GHL-CRF-0550 STARTS
	String function_id =request.getParameter("function_id");
	String strModuleId =request.getParameter("strModuleId");
	//ADDED FOR GHL-CRF-0550 ENDS
	strPatientId=(strPatientId==null)?"":strPatientId;

	BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	BLInsuranceImage	blInsuranceImage = null;	
	String bean_id ="";
	String bean_name="";

	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request);

	if(strPatientId.length() > 0 && strInsPatientId.length() >0 &&!(strPatientId.equals(strInsPatientId)))
		blInsuranceImageBean.clearBean();
		//ADDED FOR GHL-CRF-0550 STARTS
		session.setAttribute("ins_patient_id",strPatientId);
		session.setAttribute("calling_module_id", strModuleId);
		session.setAttribute("calling_function_id", function_id);
		//ADDED FOR GHL-CRF-0550 ENDS
%>
	<HTML>
	<HEAD>
	<TITLE>Insurance Documents Upload Window </TITLE>
	</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src='../../eBL/js/InsUpldImage.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<iframe name='baseDateDtl' id='baseDateDtl'	src='../../eBL/jsp/AddModifyInsUpldImgHdr.jsp?<%=params%>'  frameborder='0' noresize scrolling='auto'style='height:50vh;width:100vw'></iframe>
		<iframe name='basedtl1' id='basedtl1' src="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp?<%=params%>" frameborder='0' noresize style='height:40vh;width:100vw'></iframe>
		<!--<iframe name='messageFrame' id='messageFrame'		src='../../eBL/html/blank.html' frameborder=0 noresize scrolling='auto' noresize></iframe> -->
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe> 
		<iframe name='messageFrame1' id='messageFrame1'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
	
	</HTML>

