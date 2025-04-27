<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="bean"   scope="page"  class="eSS.AutoclavingBean"/>
<%

	String bean_id			=	request.getParameter("bean_id");
	String bean_name		=	request.getParameter("bean_name");
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	// AutoclavingBean bean	=	 (AutoclavingBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash			=	(Hashtable) XMLobj.parseXMLString(request);
    hash					=	(Hashtable) hash.get ("SEARCH");
	
	String autoclave_wash_unit_code = (String) hash.get("autoclave_wash_unit_code");
	
	if (autoclave_wash_unit_code.trim().equals("")) 
	{
		out.println("errorDisplay();");
		return;
	}

 try
   {
	HashMap hmRecord	= bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_UNIT_DETAILS"),autoclave_wash_unit_code);
	out.println("document.formAutoclavingHeader.temperature.value=\""+bean.checkForNull((String)hmRecord.get("TEMPERATURE"))+"\";");
	out.println("document.formAutoclavingHeader.sterile_type.value=\""+bean.checkForNull((String)hmRecord.get("STERILE_TYPE"))+"\";");
	 out.println("document.formAutoclavingHeader.service_location.value=\""+bean.checkForNull((String)hmRecord.get("SERVICE_LOC_DESC"))+"\";");
	 out.println("document.formAutoclavingHeader.sterilization_type.value=\""+bean.checkForNull((String)hmRecord.get("STERILE_TYPE_DESC"))+"\";");
	 
	 //Added by Sakti against  AAKH_CRF_0057  inc#52312
	 if(!bean.BiologicalIndicator_appl_yn(autoclave_wash_unit_code)) {
		 out.println("document.getElementById('id_b_indicator_label').style.visibility = 'hidden';");
		 out.println("document.getElementById('id_b_indicator').style.visibility = 'hidden';");
	 }else{
		 out.println("document.getElementById('id_b_indicator_label').style.visibility = 'visible';");
		 out.println("document.getElementById('id_b_indicator').style.visibility = 'visible';");
		 if(bean.getBIndicatorTestDone_yn().equals("Y")){
		 	out.println("document.getElementById('b_indicator_test_done_yn').selectedIndex = 0;");
		 }else{
			 out.println("document.getElementById('b_indicator_test_done_yn').selectedIndex = 1;");
		 }
	 }
	 if(!bean.Bms_appl_yn(autoclave_wash_unit_code)) {
		 out.println("document.getElementById('id_bms_pass_fail_label').style.visibility = 'hidden';");
		 out.println("document.getElementById('id_bms_pass_fail').style.visibility = 'hidden';");
	 }else{
		 out.println("document.getElementById('id_bms_pass_fail_label').style.visibility = 'visible';");
		 out.println("document.getElementById('id_bms_pass_fail').style.visibility = 'visible';");
		 if(bean.getBMSPassFail_yn().equals("P")){
		 	out.println("document.getElementById('bms_pass_fail').selectedIndex = 0;");
		 }else{
			 out.println("document.getElementById('bms_pass_fail').selectedIndex = 1;");
		 }
	 }
	 //Added ends


	hmRecord.get("SERVICE_LOC_CODE");
	out.println("refreshMessageFrame();");

   }catch(Exception e){

       out.println("checkRecord();");
       out.println("deletePreviousRecord();");
	   System.err.println(e);
	}
	putObjectInBean(bean_id,bean,request);
%>
