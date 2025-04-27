<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
01/08/2013    IN042027		 Chowminya G  Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached
---------------------------------------------------------------------------------------------------------------
--> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="eOR.RefusalText.label" bundle="${or_labels}"/>
	</title>

</head>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" >
<%
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
//	String temp = "false";
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(localeName);
		
	String consent_form_id = request.getParameter("id");
 	//String readChk = null;
	String textSelected = request.getParameter("textSelected");
	if(textSelected==null)textSelected = "";
	String target = request.getParameter("target");
	if(target==null)target = "";
 	String facility_id = (String)session.getValue("facility_id");


	String encounter_id = (String) request.getParameter("encounter_id");
	if(encounter_id==null) encounter_id = "";
	String order_id = (String) request.getParameter("order_id");
	if(order_id==null) order_id = "";
	//IN042027 - Start
	String cat_code = "";
	if("".equals(order_id))
		cat_code = (String) request.getParameter("ordercode");
	//IN042027 - end
 	String consent_text = "";
     //if(!target.equalsIgnoreCase(""))/////
	//{
 	
		String patient_id = (String) request.getParameter("patient_id");
		if(patient_id==null) patient_id = "";

		String srl_no = (String) request.getParameter("srl_no");
		if(srl_no==null) srl_no = "";
  		//consent_text = (String ) bean.getConsentFormContent(consent_form_id,patient_id,order_id);
		
		consent_text = (String) bean.getConsentContent();
		if(consent_text==null) consent_text="";
		/*************************************************/
		if(!consent_text.equals("")){
		String bean_consent_form_id=(String) bean.getRefusalFormID();
		if (!bean_consent_form_id.equals(consent_form_id)){
			consent_text="";
			bean.setConsentContent("");
			bean.setRefusalFormID("");
		}
		}
		/*************************************************/
		if(consent_text.equals("") && srl_no.equals("")) 
		{ //&& patient_id.equals("") && 
 			//consent_text = (String) bean.getConsentContent(consent_form_id, patient_id, facility_id, encounter_id, order_id);  
			consent_text = (String) bean.getConsentContent(consent_form_id, patient_id, facility_id, encounter_id, order_id, cat_code);  //IN042027
		}

		//if(consent_text==null) consent_text="";
 		if(consent_text.equals("") && !patient_id.equals("") && !srl_no.equals("")) {
 			//consent_text = (String) bean.getConsentFormContent(consent_form_id,patient_id,srl_no, facility_id, encounter_id, order_id);
			consent_text = (String) bean.getConsentFormContent(consent_form_id,patient_id,srl_no, facility_id, encounter_id, order_id, cat_code);//IN042027
  		}
 		//textSelected = "true";
		//temp = "true";
	//}
 	/*else
	{
		if(textSelected.equalsIgnoreCase("true"))
			consent_text = (String ) bean.getConsentContent();
		else
 			consent_text = (String ) bean.getConsentContent(consent_form_id);
	}*/
    if(consent_text==null)	consent_text ="";
%>
<form name='formRefusalText' id='formRefusalText'  target='' action=''>
	

	<table border="0" cellpadding="0" cellspacing="0" width="100%" id='test'>
		<tr>
			<td class="LABEL"><jsp:include page="EditorButton.jsp" ><jsp:param name="flush" value="true" />
							  <jsp:param name ="p_ok_button" value= "" /> 
							  </jsp:include>
			</td>
 		</tr>
		<tr>
			<td colspan="3" class='fields'><textarea rows="0" cols="25" name="RTEText" style="visibility:hidden"><%=consent_text%></textarea></td>
		</tr>
  		<script>setTimeout("setContent()",200);</script>
		<input type="hidden" name ="consent_form_id" id="consent_form_id" value="<%=consent_form_id%>">
		<input type="hidden" name ="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name ="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
   	</table>
 	 </form>
   </body>
</html>
 

