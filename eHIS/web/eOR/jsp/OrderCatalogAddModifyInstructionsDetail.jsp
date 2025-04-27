<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name				R.Name			R.date				Description		
--------------------------------------------------------------------------------------------------------------
?				100					?           	?				?					created
18/11/2012		IN031304		Karthi L		new checkbox field Visit type and fucntionality introduced(IN035976) 
17/07/2018		IN064543		Kamalakannan 		Ramesh G		17/07/2018			ML-MMOH-CRF-0776
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
07/08/2018		IN064543		Kamalakannan 		Ramesh G		07/08/2018				ML-MMOH-CRF-0776
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Mandatory declarations end --%>


<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language='javascript'   src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/OrderCatalog.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<!--IN064543-->
	
<script>

/**************For Text Area**************************************/
function checkMaxLimitLocal(obj,maxSize){

		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}
function checkBoxStatus(oa_integ_param, order_category){ //IN031304

	if( document.detailUpperForm.appt_reqd_yn.checked == false){
		document.detailUpperForm.appt_reqd_yn.value = "N" ;
		document.detailUpperForm.routine_appt_reqd_yn.value = "N" ;
		document.detailUpperForm.urgent_appt_reqd_yn.value = "N" ;
		document.detailUpperForm.stat_appt_reqd_yn.value = "N" ;
		if(oa_integ_param == "Y" && order_category=="RD") //IN031304
		{
			document.detailUpperForm.follow_visit_type_yn.checked = false; //IN031304
		}
				
		document.detailUpperForm.routine_appt_reqd_yn.checked = false ;
		document.detailUpperForm.urgent_appt_reqd_yn.checked = false ;
		document.detailUpperForm.stat_appt_reqd_yn.checked = false ;
		document.detailUpperForm.appt_prep_time.value = "";
		document.detailUpperForm.appt_time.value = "";
		document.detailUpperForm.appt_prep_time_type.selectedIndex = 0 ;
		document.detailUpperForm.appt_action_for_prep.selectedIndex=0;
		document.detailUpperForm.routine_appt_reqd_yn.disabled = true ;
		document.detailUpperForm.urgent_appt_reqd_yn.disabled = true ;
		document.detailUpperForm.stat_appt_reqd_yn.disabled = true ;
		document.detailUpperForm.appt_prep_time.disabled = true ;
		document.detailUpperForm.appt_time.disabled = true ;
		document.detailUpperForm.appt_prep_time_type.disabled = true ;
		document.detailUpperForm.appt_action_for_prep.disabled = true ;
		if(oa_integ_param == "Y" && order_category=="RD") //IN031304
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = true; //IN031304
		}
		

	}else if(document.detailUpperForm.appt_reqd_yn.checked == true){
		document.detailUpperForm.appt_reqd_yn.value = "Y" ;
		document.detailUpperForm.routine_appt_reqd_yn.value = "Y" ;
		document.detailUpperForm.urgent_appt_reqd_yn.value = "Y" ;
		document.detailUpperForm.stat_appt_reqd_yn.value = "Y" ;
		document.detailUpperForm.routine_appt_reqd_yn.checked = true ;
		document.detailUpperForm.urgent_appt_reqd_yn.checked = true ;
		document.detailUpperForm.stat_appt_reqd_yn.checked = true ;
		document.detailUpperForm.routine_appt_reqd_yn.disabled = false ;
		document.detailUpperForm.urgent_appt_reqd_yn.disabled = false ;
		document.detailUpperForm.stat_appt_reqd_yn.disabled = false ;
		document.detailUpperForm.appt_prep_time.disabled = false ;
		document.detailUpperForm.appt_time.disabled = false ;
		document.detailUpperForm.appt_prep_time_type.disabled = false ;
		document.detailUpperForm.appt_action_for_prep.disabled = false ;
		if(oa_integ_param == "Y" && order_category=="RD") //IN031304
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = false; //IN031304
		}	
	}

}
function checkBoxValidate(order_category)
{	
	if(order_category=="OH")
	{
		if(document.detailUpperForm.appt_reqd_yn.checked == true)
		{
			document.detailUpperForm.appt_reqd_yn.value = "Y" ;
			document.detailUpperForm.routine_appt_reqd_yn.value = "Y" ;
			document.detailUpperForm.urgent_appt_reqd_yn.value = "Y" ;
			document.detailUpperForm.stat_appt_reqd_yn.value = "Y" ;
			document.detailUpperForm.routine_appt_reqd_yn.checked = true ;
			document.detailUpperForm.urgent_appt_reqd_yn.checked = true ;
			document.detailUpperForm.stat_appt_reqd_yn.checked = true ;
			document.detailUpperForm.routine_appt_reqd_yn.disabled = true ;
			document.detailUpperForm.urgent_appt_reqd_yn.disabled = true ;
			document.detailUpperForm.stat_appt_reqd_yn.disabled = true ;
		}
	}
	else
	{
		if(document.detailUpperForm.appt_reqd_yn!=null){
			if(document.detailUpperForm.routine_appt_reqd_yn.checked == false && document.detailUpperForm.urgent_appt_reqd_yn.checked == false && document.detailUpperForm.stat_appt_reqd_yn.checked == false)
			{
				document.detailUpperForm.appt_reqd_yn.value = "N" ;
				document.detailUpperForm.routine_appt_reqd_yn.value = "N" ;
				document.detailUpperForm.urgent_appt_reqd_yn.value = "N" ;
				document.detailUpperForm.stat_appt_reqd_yn.value = "N" ;
				document.detailUpperForm.appt_reqd_yn.checked = false ;
				document.detailUpperForm.routine_appt_reqd_yn.disabled = true ;
				document.detailUpperForm.urgent_appt_reqd_yn.disabled = true ;
				document.detailUpperForm.stat_appt_reqd_yn.disabled = true ;
				document.detailUpperForm.appt_prep_time.disabled = true ;
				document.detailUpperForm.appt_time.disabled = true ;
				document.detailUpperForm.appt_prep_time_type.disabled = true ;
				document.detailUpperForm.appt_action_for_prep.disabled = true ;
				//document.detailUpperForm.appt_prep_time.value = "";
				document.detailUpperForm.appt_prep_time_type.selectedIndex = 0 ;
				document.detailUpperForm.appt_action_for_prep.selectedIndex=0;

			}
			else if(document.detailUpperForm.routine_appt_reqd_yn.checked == true || document.detailUpperForm.urgent_appt_reqd_yn.checked == true || document.detailUpperForm.stat_appt_reqd_yn.checked == true)
			{
				document.detailUpperForm.appt_reqd_yn.value = "Y" ;
				document.detailUpperForm.appt_reqd_yn.checked = true ;
			
			}
		}
	}

}
function visiTypeValidate() //added for IN031304
{ 
	if(document.detailUpperForm.follow_visit_type_yn.checked == false)
	{
		document.detailUpperForm.follow_visit_type_yn.value = "N"; 	
		document.detailUpperForm.appt_time.disabled = false;
	}
	else if(document.detailUpperForm.follow_visit_type_yn.checked == true)
	{
		document.detailUpperForm.follow_visit_type_yn.value = "Y"; 	
		document.detailUpperForm.appt_time.value = "";
		document.detailUpperForm.appt_time.disabled = true;
	}
}
function apptTimeValidate(oa_integ_param, order_category){ //added for IN031304
	if(oa_integ_param == "Y"  && order_category=="RD")  
	{
		if(document.detailUpperForm.appt_time.value != null && document.detailUpperForm.appt_time.value != "") 
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = true;
		}
		else 
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = false;
		}
	}
}
</script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String order_category					=	request.getParameter("order_category")==null?"":request.getParameter("order_category");
String order_catalog_code				=   request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
String instructionsEditor ="";
if(order_catalog_code.indexOf(".")!=-1)
instructionsEditor ="disabled";
%>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onLoad='checkBoxValidate("<%=order_category%>");'>
<!-- STYLE="overflow-y:hidden;overflow-X:hidden" -->
<form name='detailUpperForm' id='detailUpperForm' >

<%!
	/***UPDATABLE***********/
	//String consent_reqd_yn_updatable	   ="Y";
	//String consent_form_id_updatable	   ="N";
	String prompt_alert_yn_updatable	   ="Y";
	String prompt_alert_msg_updatable	   ="N";
	String appt_reqd_yn_updatable		   ="Y";
	String routine_appt_reqd_yn_updatable  ="Y";
	String urgent_appt_reqd_yn_updatable   ="Y";
	String stat_appt_reqd_yn_updatable	   ="Y";
	String appt_time_updatable			   ="N";
	String pat_instrn_age_sex_yn_updatable ="Y";
	String pat_preps_or_instrns_txt_pr_updatable ="y";
	String pat_preps_or_instrns_txt_dr_updatable ="y";
	String prep_duration_updatable			   ="Y";
	String act_prep_duration_updatable		   ="Y";
	String clin_cmts_reqd_yn_updatable	   ="Y";
	String splty_speci_reqd_yn_updatable	   ="Y";
	String primary_speciality_updateble	   ="N";
	String invoke_instrn_window_yn_updatable  = "Y";//IN064543
	String instrn_content_type = "T";//IN64543
	String instrn_content_type_updatable  = "Y";//IN64543

	public void updatableIntialisation()	{
	 prompt_alert_yn_updatable	       ="Y";
	 prompt_alert_msg_updatable	       ="N";
	 appt_reqd_yn_updatable			   ="Y";
     routine_appt_reqd_yn_updatable	   ="Y";
	 urgent_appt_reqd_yn_updatable	   ="Y";
	 stat_appt_reqd_yn_updatable	   ="Y";
	 appt_time_updatable			   ="N";
	 pat_instrn_age_sex_yn_updatable   ="Y";
	 pat_preps_or_instrns_txt_pr_updatable ="y";
 	 pat_preps_or_instrns_txt_dr_updatable ="y";
	 prep_duration_updatable			   ="Y";
	 act_prep_duration_updatable		   ="Y";
	 clin_cmts_reqd_yn_updatable	       ="Y";
	 splty_speci_reqd_yn_updatable	   ="Y";
	 primary_speciality_updateble	       ="N";
	 invoke_instrn_window_yn_updatable	= "Y";//IN064543
	 instrn_content_type	       ="T";//IN64543
	 instrn_content_type_updatable = "Y";//IN64543
	}


%>



<%

try{

	/* Mandatory checks start */
    

	String mode			 = request.getParameter( "mode" ) ;
	//String function_id	 = request.getParameter( "function_id" ) ;
	String bean_id		 = "Or_OrderCatalog" ;
	String bean_name	 = "eOR.OrderCatalogBean";
	//String disabled		 = "" ;
	String eff_status	 = "Y" ;


	updatableIntialisation();


	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;

	bean.setMode( mode ) ;

	ArrayList  instructionsRecStr =  bean.getInstructionsRecStr();


	//Prompt
	String prompt_alert_yn_def		 =
	bean.getdefaultArrListValue(instructionsRecStr,0,"prompt_alert_yn","N") ;
	String clin_cmts_reqd_yn_def		 =
	bean.getdefaultArrListValue(instructionsRecStr,0,"clin_cmts_reqd_yn","N") ;
	String splty_speci_reqd_yn_def		 =
	bean.getdefaultArrListValue(instructionsRecStr,0,"splty_speci_reqd_yn","N") ;
	String invoke_instrn_window_yn_def		 =
	bean.getdefaultArrListValue(instructionsRecStr,0,"invoke_instrn_window_yn","N") ;//
	//String prompt_alert_msg_def		 =
	bean.getdefaultArrListValue(instructionsRecStr,0,"prompt_alert_msg","") ;

	String pat_preps_or_instrns_id_def =
	bean.getdefaultArrListValue(instructionsRecStr,0,"pat_preps_or_instrns_id","IS") ;
	String pat_instrns_free_fmt_id_def =
			bean.getdefaultArrListValue(instructionsRecStr,0,"pat_instrns_free_fmt_id","IS");//IN64543


	prompt_alert_msg_updatable	   = eHISFormatter.chkReturn("Y",prompt_alert_yn_def,"Y","N");
	primary_speciality_updateble	   = eHISFormatter.chkReturn("Y",splty_speci_reqd_yn_def,"Y","N");

	String rd_oa_integration_yn = bean.getOaIntegrationKey(); // //added for IN031304
	//Appointment
	String appt_reqd_yn_def	   =
	bean.getdefaultArrListValue(instructionsRecStr,0,"appt_reqd_yn","N") ;
	
	String routine_appt_reqd_yn_def	   =
	bean.getdefaultArrListValue(instructionsRecStr,0,"routine_appt_reqd_yn","N") ;
	String urgent_appt_reqd_yn_def	   =
	bean.getdefaultArrListValue(instructionsRecStr,0,"urgent_appt_reqd_yn","N") ;
	String stat_appt_reqd_yn_def	   =
	bean.getdefaultArrListValue(instructionsRecStr,0,"stat_appt_reqd_yn","N") ;
	//String appt_time_def	   =
	bean.getdefaultArrListValue(instructionsRecStr,0,"appt_time","") ;

	//appt_time_updatable	   = eHISFormatter.chkReturn("Y",appt_reqd_yn_def,"Y","N");


	String follow_visit_type_yn_def = bean.getdefaultArrListValue(instructionsRecStr,0,"follow_visit_type_yn","N") ; //added for IN031304


	//String order_catalog_code				=   bean.checkForNull(request.getParameter("order_catalog_code" ));
	//String long_desc						=	bean.checkForNull(request.getParameter("long_desc"));
	//String short_desc						=	bean.checkForNull(request.getParameter("short_desc"));
	
	String module_id						=	bean.checkForNull(request.getParameter("module_id"));
	String display_text="";
//IN64543, starts
	String instrn_content_type = bean.getdefaultArrListValue(instructionsRecStr,0,"instrn_content_type","T") ;
	String l_pat_preps_or_instrns_free_fmt_pr = bean.getdefaultArrListValue(instructionsRecStr,1,"pat_preps_or_instrns_free_fmt_pr","") ;	
	String l_pat_preps_or_instrns_free_fmt_dr = bean.getdefaultArrListValue(instructionsRecStr,1,"pat_preps_or_instrns_free_fmt_dr","") ;
	String l_pat_preps_or_instrns_free_fmt_is = bean.getdefaultArrListValue(instructionsRecStr,2,"pat_preps_or_instrns_free_fmt_is","");//IN64543
	
	String showHidTxtInstrn="display:table-row";
	String showHidEditorInstrn = "display:none";
	
	if ("E".equals(instrn_content_type))
	{
		showHidTxtInstrn = "display:none";
		showHidEditorInstrn = "display:inline";		
	}
//IN64543, ends
	//String order_type_code					=   "";
	//String security_level					=	"";



	//int size								=  0;

	//if( order_category.trim().equalsIgnoreCase("RD")||order_category.trim().equalsIgnoreCase("RX"))
   //		appt_reqd_yn_updatable = "N";

	//if( order_category.trim().equalsIgnoreCase("RD")||order_category.trim().equalsIgnoreCase("RX"))
   	//	appt_reqd_yn_updatable = "N";
	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
		if(eff_status.equalsIgnoreCase("D")){
			// consent_reqd_yn_updatable		   ="N";
			// consent_form_id_updatable		   ="N";
			 prompt_alert_yn_updatable	       ="N";
			 prompt_alert_msg_updatable	       ="N";
			 appt_reqd_yn_updatable			   ="N";
			 routine_appt_reqd_yn_updatable	   ="N";
			 urgent_appt_reqd_yn_updatable	   ="N";
			 stat_appt_reqd_yn_updatable	   ="N";
			 appt_time_updatable			   ="N";
			 pat_instrn_age_sex_yn_updatable   ="N";
			 pat_preps_or_instrns_txt_pr_updatable ="N";
 			 pat_preps_or_instrns_txt_dr_updatable ="N";
			 prep_duration_updatable			   ="N";
			 act_prep_duration_updatable		   ="N";
			 clin_cmts_reqd_yn_updatable	       ="N";
			 splty_speci_reqd_yn_updatable	       ="N";
			 primary_speciality_updateble	       ="N";
			 invoke_instrn_window_yn_updatable	   ="N";//IN064543
			 instrn_content_type_updatable = "N";//IN64543
		}
		if(appt_reqd_yn_def.equalsIgnoreCase("N")){
			routine_appt_reqd_yn_updatable	   ="N";
			urgent_appt_reqd_yn_updatable	   ="N";
			stat_appt_reqd_yn_updatable		   ="N";
		}
	}
	
        HashMap time_type =	bean.getSqlResult("SQL_OR_CATALOG_DURATIONS");

        Integer	noOfRecordsTemp = (Integer)time_type.get("noRec");
        int noOfRecords   = noOfRecordsTemp.intValue() ;       		
        //IN064543 start
        ArrayList rowValues = null;
        HashMap valuesFromBean = null;
        if(bean.getInstructionsRecStr()!=null && bean.getInstructionsRecStr().size()>0)
        {
		valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);
		
		if(!valuesFromBean.isEmpty()){
			rowValues = (ArrayList)valuesFromBean.get("records");
		}
		}
        //IN064543 end
%>

<table align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>

<tr>
	 <td  class="label" width="25%"><fmt:message key="eOR.PromptAlert.label" bundle="${or_labels}"/></td>

	 <td class="fields" colspan='3' width="25%"><input type='checkbox' value='Y' onClick="parent.parent.parent.chkPrompt(this)"	name='prompt_alert_yn' id='prompt_alert_yn'
	 <%=eHISFormatter.chkReturn("y",prompt_alert_yn_updatable,"","disabled")%>
	 <%=eHISFormatter.ChkBoxChecked("y",prompt_alert_yn_def)%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 <textarea name="prompt_alert_msg" rows="2" cols="50"
	 <%=eHISFormatter.chkReturn("y",prompt_alert_msg_updatable,"","disabled")%>
	 onkeypress="checkMaxLimitLocal(this,225)" onBlur="SPCheckMaxLen('Prompt Message',this,225);makeValidString(this);" ><%=bean.getdefaultArrListValue(instructionsRecStr,0,"prompt_alert_msg","")%></textarea>
    </td>

</tr>

<% 
		
	/*String order_type_code[]				=   {bean.checkForNull(request.getParameter("order_type_code" ))};
	HashMap temp_appt_reqd_yn=bean.getSqlResultParam("SQL_OR_ORDER_CATALOG_REGN_REQD_YN_SELECT",order_type_code);
	String appt_reqd_yn_style=temp_appt_reqd_yn.get("REGN_REQD_YN1")==null?"":(String)temp_appt_reqd_yn.get("REGN_REQD_YN1");
	if(appt_reqd_yn_style.equals("Y")){
		 appt_reqd_yn_updatable="N";
		 appt_reqd_yn_def="N";
	}*/
	
	if(order_category.trim().equalsIgnoreCase("OH")) 
	{ 
		appt_reqd_yn_def="y";
		appt_reqd_yn_updatable="N";		
	}
	if(!order_category.trim().equalsIgnoreCase("PH")) { 
		String appt_time=bean.getdefaultArrListValue(instructionsRecStr,0,"appt_time","");
		if(appt_time.trim().equals("0"))
			appt_time = ""; 

	%>
 <tr>
	<td class="label" width="25%"><fmt:message key="eOR.ScheduleApplicable.label" bundle="${or_labels}"/></td>
	<td class='fields'  width="25%"><input type='checkbox' value="<%=appt_reqd_yn_def%>" onclick="checkBoxStatus('<%=rd_oa_integration_yn%>', '<%=order_category%>')" name='appt_reqd_yn'	
	<%=eHISFormatter.chkReturn("y",appt_reqd_yn_updatable,"","disabled")%>
 	<%=eHISFormatter.ChkBoxChecked("y",appt_reqd_yn_def)%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- added for IN031304 -->
	<% if((rd_oa_integration_yn.equalsIgnoreCase("Y")) && ( order_category.trim().equalsIgnoreCase("RD"))) { %>
			<fmt:message key="eOR.FollowVisitType.label" bundle="${or_labels}"/> 
			<input type ='checkbox' value = "<%=follow_visit_type_yn_def%>" name='follow_visit_type_yn'  onclick = 'visiTypeValidate();'  
			<%=eHISFormatter.ChkBoxChecked("y",follow_visit_type_yn_def)%> >
			
	<%
	}
	%>
	
	</td>
	<!-- added for IN031304 -END -->
	<td class="label"  width="25%"><fmt:message key="eOR.ScheduleTime.label" bundle="${or_labels}"/></td>
	<td width="25%"> <input type='text' name='appt_time' id='appt_time' value='<%=appt_time%>' onBlur='checktime(this)' onChange="apptTimeValidate('<%=rd_oa_integration_yn%>', '<%=order_category%>')" class='NUMBER'  size='5' maxlength='5' <%=eHISFormatter.chkReturn("y",prep_duration_updatable,"","disabled")%>></td></tr>
	<tr><td class="label" width="25%"><fmt:message key="eOR.OrderPriorityApplicable.label" bundle="${or_labels}"/></td>
<!--onClick="parent.parent.parent.chkApptReq(this)"-->
	 <td class='label' onclick="checkBoxValidate('')" width="25%"><fmt:message key="Common.routine.label" bundle="${common_labels}"/><input type='checkbox' value="<%=routine_appt_reqd_yn_updatable%>" 	name='routine_appt_reqd_yn'  <%=eHISFormatter.chkReturn("y",routine_appt_reqd_yn_updatable,"","disabled")%>
 	 <%=eHISFormatter.ChkBoxChecked("y",routine_appt_reqd_yn_def)%>>
		 <fmt:message key="Common.urgent.label" bundle="${common_labels}"/><input type='checkbox' value="<%=urgent_appt_reqd_yn_updatable%>"	name='urgent_appt_reqd_yn' 
	 <%=eHISFormatter.chkReturn("y",urgent_appt_reqd_yn_updatable,"","disabled")%>
 	 <%=eHISFormatter.ChkBoxChecked("y",urgent_appt_reqd_yn_def)%>>
		 <fmt:message key="Common.Stat.label" bundle="${common_labels}"/><input type='checkbox' value="<%=stat_appt_reqd_yn_updatable%>" name='stat_appt_reqd_yn' 
	 <%=eHISFormatter.chkReturn("y",stat_appt_reqd_yn_updatable,"","disabled")%>
 	 <%=eHISFormatter.ChkBoxChecked("y",stat_appt_reqd_yn_def)%>><!--&nbsp;&nbsp;Appointment Duration&nbsp;&nbsp;&nbsp;<input type=text size='5' maxlength='5'
	 <%=eHISFormatter.chkReturn("y",appt_time_updatable,"","disabled")%>  name='appt_time' onBlur="parent.parent.parent.timeChk(this)" value="<%=bean.getdefaultArrListValue(instructionsRecStr,0,"appt_time","")
	 %>">-->
	 </td>
	 <td  class="label" wrap width="25%"><fmt:message key="eOR.ClinicalCommentMandatory.label" bundle="${or_labels}"/></td>
	<td class="fields" width="25%"><input type='checkbox' value='Y' name='clin_cmts_reqd_yn' id='clin_cmts_reqd_yn'
	 <%=eHISFormatter.chkReturn("y",clin_cmts_reqd_yn_updatable,"","disabled")%>
	 <%=eHISFormatter.ChkBoxChecked("y",clin_cmts_reqd_yn_def)%>></td>

</tr>
<%}%>
<tr>
<td class="label" wrap width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.specific.label" bundle="${common_labels}"/></td>
<td class="fields" width="25%"><input type='checkbox' value='Y' name='splty_speci_reqd_yn' id='splty_speci_reqd_yn'
	 <%=eHISFormatter.chkReturn("y",splty_speci_reqd_yn_updatable,"","disabled")%>
	 <%=eHISFormatter.ChkBoxChecked("y",splty_speci_reqd_yn_def)%> onClick="parent.parent.parent.chkSplty(this)">
</td>
<% 
if (!bean.getdefaultArrListValue(instructionsRecStr,0,"pri_splty_code","").equals("")) 
{ 		
		  display_text=bean.get_pri_splty_desc(bean.getdefaultArrListValue(instructionsRecStr,0,"pri_splty_code",""
		  ));
}
%>
<td class="label" wrap width="25%"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></td>
<td class="fields" width="25%"><input type='text'  name='primary_speciality_desc' id='primary_speciality_desc'  <%=eHISFormatter.chkReturn("y",primary_speciality_updateble,"","disabled")%> value='<%=display_text%>' size=23 maxlength=30 onBlur="parent.parent.parent.show_primary_speciality();"><input type='button' name='appl_button' id='appl_button' class='button' <%=eHISFormatter.chkReturn("y",primary_speciality_updateble,"","disabled")%> value='?' onclick="parent.parent.parent.show_primary_speciality();"><input type='hidden'  name='pri_splty_code' id='pri_splty_code' value='<%=bean.getdefaultArrListValue(instructionsRecStr,0,"pri_splty_code","")%>'>
</td>
</tr>
<%if(!order_category.trim().equalsIgnoreCase("PH")) { 
 	
	 String appt_prep_time=bean.getdefaultArrListValue(instructionsRecStr,0,"appt_prep_time","");
	 if(appt_prep_time.trim().equals("0"))
			appt_prep_time = ""; 

	String appt_prep_time_type=bean.getdefaultArrListValue(instructionsRecStr,0,"appt_prep_time_type","");

	String appt_action_for_prep=bean.getdefaultArrListValue(instructionsRecStr,0,"appt_action_for_prep","");
	  %>

<tr>
<td  class="label" width="25%"><fmt:message key="eOR.PreparationDuration.label" bundle="${or_labels}"/></td>
<td class="fields" colspan="3" width="25%"><input type='text' name='appt_prep_time' id='appt_prep_time' onBlur='checkDecimal(this)' value='<%=appt_prep_time%>' class='NUMBER'  size='4' maxlength='4' <%=eHISFormatter.chkReturn("y",prep_duration_updatable,"","disabled")%>>&nbsp;&nbsp;<SELECT name='appt_prep_time_type' id='appt_prep_time_type' <%=eHISFormatter.chkReturn("y",prep_duration_updatable,"","disabled")%>>
	<option value='' <%=(appt_prep_time_type.equals("")? "selected":"")%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
     <% if (noOfRecords > 0) {%>
               <%for (int i = 0; i < noOfRecords; i++) { 
	String durn_type=(String)time_type.get("DURN_TYPE"+(i+1));
	String durn_desc=(String)time_type.get("DURN_DESC"+(i+1));
	%>
      <option value='<%=durn_type%>' <%=(appt_prep_time_type.equals(durn_type)? "selected":"")%>><%=durn_desc%></option>
            <%}
           } %>	
</SELECT> </td>
</tr>
			   

<tr>
<td  class="label" width="25%"><fmt:message key="eOR.ActionwhenPreparationDurationnotmet.label" bundle="${or_labels}"/></td>
<td class="fields" colspan=3 width="25%"><select name='appt_action_for_prep' id='appt_action_for_prep' <%=eHISFormatter.chkReturn("y",act_prep_duration_updatable,"","disabled")%>>
<option value='' <%=(appt_action_for_prep.equals("")? "selected":"")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<option value='W' <%=(appt_action_for_prep.equals("W")? "selected":"")%>><fmt:message key="eOR.WarnOnAppt.label" bundle="${or_labels}"/></option>
<option value='S' <%=(appt_action_for_prep.equals("S")? "selected":"")%>><fmt:message key="eOR.StopOnAppt.label" bundle="${or_labels}"/></option>
</select></td>
</tr> 

<% } %>
<%--
<INPUT TYPE="hidden"  value='N'  name='appt_reqd_yn' id='appt_reqd_yn' >
<INPUT TYPE="hidden"  value=' '   name='appt_time' id='appt_time'  >--%>

<!--IN064543 start-->
<tr>

	 <td  class="label" wrap width="25%"><fmt:message key="eOR.InvokeInstructionWindow.label" bundle="${or_labels}"/></td>
	<td class="fields" width="25%"><input type='checkbox' value='Y' name='invoke_instrn_window_yn' id='invoke_instrn_window_yn'
	 <%=eHISFormatter.chkReturn("y",invoke_instrn_window_yn_updatable,"","disabled")%>
	 <%=eHISFormatter.ChkBoxChecked("y",invoke_instrn_window_yn_def)%>></td>

</tr>		   
<!--IN064543 end-->
<!--IN64543, starts-->
<td class="label">
<fmt:message key="eOR.InstrnContentType.label" bundle="${or_labels}"/>
</td>
	<td class="fields">
		<fmt:message key="eOR.Text.label" bundle="${or_labels}"/> <input type='radio' name='instrn_content_type' id='instrn_content_type' id = "instrn_content_type" value ='T' <%=eHISFormatter.chkReturn("T",instrn_content_type,"checked","")%> <%=eHISFormatter.chkReturn("y",instrn_content_type_updatable,"","disabled")%> onclick = 'instrnRadioButton()'/>
		<fmt:message key="eOR.Editor.label" bundle="${or_labels}"/> <input type='radio' name='instrn_content_type' id='instrn_content_type' id = "instrn_content_type"  value ='E' <%=eHISFormatter.chkReturn("E",instrn_content_type,"checked","")%> <%=eHISFormatter.chkReturn("y",instrn_content_type_updatable,"","disabled")%>  <%=instructionsEditor %>  onclick='instrnRadioButton()'/>
	</td>
</tr><!--IN64543, ends-->
<!--<tr>--><!--IN64543-->
<tr id = 'prep_instrn_td' style='<%=showHidTxtInstrn%>'>
	  <td class="label" width="25%">
	  	<fmt:message key="eOR.Preps.label" bundle="${or_labels}"/>
	  </td>
	  <td class="fields" colspan='3' width="25%"><textarea name="pat_preps_or_instrns_txt_pr" width='78%' rows="2" cols="50" <%=eHISFormatter.chkReturn("y",pat_preps_or_instrns_txt_pr_updatable,"","disabled")%>
	  onkeypress="checkMaxLimitLocal(this,2000)" onBlur="SPCheckMaxLen('Preps',this,2000);makeValidString(this);" ><%=bean.getdefaultArrListValue(instructionsRecStr,1,"pat_preps_or_instrns_txt_pr","")%></textarea>
	 </td>
</tr>
<!--<tr>--><!--IN64543-->
<tr id = 'dept_instrn_td' style='<%=showHidTxtInstrn%>'><!--IN64543-->
	 <td class="label" width="25%">
	 	<fmt:message key="eOR.DepartmentInstruction.label" bundle="${or_labels}"/>
	 </td>
	 <td class="fields" colspan='3' width="25%"><textarea name="pat_preps_or_instrns_txt_dr" rows="2" width='78%' cols="50" <%=eHISFormatter.chkReturn("y",pat_preps_or_instrns_txt_dr_updatable,"","disabled")%>
	 onkeypress="checkMaxLimitLocal(this,500)" onBlur="SPCheckMaxLen('Department Instruction',this,500);makeValidString(this);" ><%=bean.getdefaultArrListValue(instructionsRecStr,1,"pat_preps_or_instrns_txt_dr","")%></textarea>
	 </td>
</tr>
<!--<tr>--><!--IN64543-->
<tr id = 'pat_instrn_td' style='<%=showHidTxtInstrn%>'><!--IN64543-->
	<td class="label" width="25%">
		<fmt:message key="Common.PatientInstruction.label" bundle="${common_labels}"/>
	</td>
	<%--<td  class="label"  colspan=2 width="25%">
		<INPUT TYPE="radio" name="pat_preps_or_instrns_id" id="pat_preps_or_instrns_id" onclick="" value="IS" <%=eHISFormatter.chkReturn("IS",pat_preps_or_instrns_id_def,"checked","")%> <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/>
		<INPUT TYPE="radio" name="pat_preps_or_instrns_id" id="pat_preps_or_instrns_id" onclick="" value="IM" <%=eHISFormatter.chkReturn("IM",pat_preps_or_instrns_id_def,"checked","")%> <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message  key="eOR.ByAgeSex.label" bundle="${or_labels}"/>
	</td>--%>
	<td class="label"  colspan=2 width="25%">
		<INPUT TYPE="radio" name="pat_preps_or_instrns_id" id="pat_preps_or_instrns_id" onclick="textAgeSexClearAllValues()" value="IS" <%=eHISFormatter.chkReturn("IS",pat_preps_or_instrns_id_def,"checked","")%> <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/>
		<INPUT TYPE="radio" name="pat_preps_or_instrns_id" id="pat_preps_or_instrns_id" onclick="textAgeSexClearAllValues()" value="IM" <%=eHISFormatter.chkReturn("IM",pat_preps_or_instrns_id_def,"checked","")%> <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message  key="eOR.ByAgeSex.label" bundle="${or_labels}"/>
	</td>
	<td class='button'>
		<input type='button' name='' id='' class='button'  value='<fmt:message key="Common.Instructions.label" bundle="${common_labels}"/>' onClick='parent.parent.parent.showDialogInstruction(pat_preps_or_instrns_id)' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>>
	</td>
</tr>
</table><!--IN64543-->

<!--IN64543, starts-->
<table width='100%' style='<%=showHidEditorInstrn%>' id='instrnEditorTabs'>
	<tr>		
		<td id = 'prepInstrnTab' width='20%' name = 'prepInstrnTab' class="clicked" style='cursor:pointer' onclick="loadEditorContent(document.getElementById("pat_preps_or_instrns_free_fmt_pr"),this,'<%=instrn_content_type_updatable%>');openEditorOnLoad();"><!-- IN064543 -->
			<b><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></b>
		</td>
		<td id = 'deptInstrnTab' width='20%' name = 'deptInstrnTab' class="normal" style='cursor:pointer' onclick="loadEditorContent(document.getElementById("pat_preps_or_instrns_free_fmt_dr"),this,'<%=instrn_content_type_updatable%>');openEditorOnLoad();"><!-- IN064543 -->
			<b><fmt:message key="eOR.DepartmentInstruction.label" bundle="${or_labels}"/></b>
		</td>
		<td id = 'patInstrnTab'  width='30%' name = 'patInstrnTab' class="normal" style='cursor:pointer' onclick="loadEditorContent(document.getElementById("pat_preps_or_instrns_free_fmt_is"),this,'<%=instrn_content_type_updatable%>');hideEditorOnLoad('<%=instrn_content_type_updatable%>');"><!-- IN064543 -->
			<b><fmt:message key="Common.PatientInstruction.label" bundle="${common_labels}"/></b>
		</td>
		<td colspan='5' width='30%'>&nbsp;
		</td>
	</tr>
<!--IN64543, ends-->
<!-- <INPUT TYPE="hidden" name="pat_preps_or_instrns_txt_is" id="pat_preps_or_instrns_txt_is" value="<%=bean.getdefaultArrListValue(instructionsRecStr,0,"pat_preps_or_instrns_txt_is","")%>">
 -->
</table><!--IN64543-->
<!--IN64543, starts-->
<table  style = 'display:none' width='100%' height='100%'><!--clob hidden textarea for storing the content from frame-->
	<tr>
		<td><textarea id='pat_preps_or_instrns_free_fmt_pr' name='pat_preps_or_instrns_free_fmt_pr'><%=l_pat_preps_or_instrns_free_fmt_pr%></textarea></td>
	</tr>
	<tr>
		<td><textarea id='pat_preps_or_instrns_free_fmt_dr' name='pat_preps_or_instrns_free_fmt_dr'><%=l_pat_preps_or_instrns_free_fmt_dr%></textarea></td>
	</tr>
	<tr>
		<td><textarea id='pat_preps_or_instrns_free_fmt_is' name='pat_preps_or_instrns_free_fmt_is'><%=l_pat_preps_or_instrns_free_fmt_is%></textarea></td>
	</tr>	
<!--IN64543, ends-->
</table>

<input type="hidden" name="pri_splty_sql" id="pri_splty_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY")%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="I">
<input type="hidden" name="categ_code" id="categ_code" value = "<%=order_category%>"> <!-- //added for IN031304 -->
<input type="hidden" name="oa_integration_param" id="oa_integration_param" value = "<%=rd_oa_integration_yn%>"> <!-- //added for IN031304 -->
<input type="hidden" name="currSelectedTab" id="currSelectedTab" value = "prepInstrnTab"><!--IN64543-->
<input type="hidden" name="prevSelectedTab" id="prevSelectedTab" value = "prepInstrnTab"><!--IN64543-->
<input type="hidden" name="instrn_content_type_editor_updatable" id="instrn_content_type_editor_updatable" value = "<%=instrn_content_type_updatable%>"><!--IN64543-->

<!--IN64543, starts-->
<table cellpadding=3 cellspacing=0 border=0 width='100%' id='pat_instrn_details_table' style='display:none'>
	<tr>
		<td class="label" colspan='8'>
			<INPUT TYPE="radio" name="pat_instrns_free_fmt_id" id="pat_instrns_free_fmt_id" onclick="stdOrMult()" value="IS"  <%=eHISFormatter.chkReturn("IS",pat_instrns_free_fmt_id_def,"Checked","")%> <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/><!--IN064543 onclick function added-->
			<INPUT TYPE="radio" name="pat_instrns_free_fmt_id" id="pat_instrns_free_fmt_id" onclick="stdOrMult()" value="IM"  <%=eHISFormatter.chkReturn("IM",pat_instrns_free_fmt_id_def,"Checked","")	%> 	<%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><fmt:message  key="eOR.ByAgeSex.label" bundle="${or_labels}"/><!--IN064543 onclick function added-->
		</td>
	</tr>
	<!-- IN064543 start -->
	<tr>
		<td id='result_instrn' style='display:none'>		
			<table id='inn_table' border='1' cellpadding='3' cellspacing='0' width='70%' align='left' class="grid">
				<tr>
					<td class='COLUMNHEADER'>&nbsp;</td>
					<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>----------></b></td>
					<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>----------></b></td>
					<td class='COLUMNHEADER'>&nbsp;</td>
				</tr>
				<tr>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>					
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>					
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
					<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></td>
   				</tr>
   				 <%
   				 if(rowValues!=null){
   				 for(int start=0; start<rowValues.size();start++){ 
   				 	HashMap rowValHash = (HashMap)rowValues.get(start);
   				    String sex_spec_ind = "";
   				 %>
   				<tr id='<%=start%>'>
   					<%if("F".equals(rowValHash.get("sex_spec_ind"))){
   						 sex_spec_ind = "Female";
   					}else if("M".equals(rowValHash.get("sex_spec_ind"))){
   						 sex_spec_ind = "Male";
   					}else if("N".equals(rowValHash.get("sex_spec_ind"))){
   					 	 sex_spec_ind = "Both";
   					}
   					%>   					
   					<td  class="fields" ><a href="javascript:moveValuesToEditor('<%=start%>')"><font class=''><%=sex_spec_ind%></font></td>	
   					<td  class="fields" ><font class=''><%=rowValHash.get("min_age_in_yrs")%></font></td>
   					<td  class="fields" ><font class=''><%=rowValHash.get("min_age_in_mths")%></font></td>
   					<td  class="fields" ><font class=''><%=rowValHash.get("min_age_in_days")%></font></td>
   					<td  class="fields" ><font class=''><%=rowValHash.get("max_age_in_yrs")%></font></td>
   					<td  class="fields" ><font class=''><%=rowValHash.get("max_age_in_mths")%></font></td>
   					<td  class="fields" ><font class=''><%=rowValHash.get("max_age_in_days")%></font></td>
   					<td  class="fields" ><font class=''><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></font></a></td>
				</tr>
			<%}
			}%>
   			</table>
		</td>
	</tr>
	<tr>
		<td  id='input_instrn' style='display:none'>
			<table border='1' cellpadding='3' cellspacing='0' width='70%' align='left' class="grid">
				<tr>
					<td class='COLUMNHEADER'>&nbsp;</td>
					<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>----------></b></td>
					<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>----------></b></td>
					<td class='COLUMNHEADER'>&nbsp;</td>
				</tr>
				<tr>
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>			
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>					
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>					
					<td class='CAHIGHER_LEVEL_COLOR'>&nbsp;</td>
				</tr>
				<tr>
					<td class="fields"><select name='sex_spec_ind' id='sex_spec_ind' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>><option value='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/><option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/><option value='N' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></select></td>
					<td class="fields"><input type='text' value='' name='min_age_in_yrs' id='min_age_in_yrs' size='3'  class='number' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td class="fields"><input type='text' value=''  name='min_age_in_mths' id='min_age_in_mths' size='2' maxlength='2'  onBlur='chkMonths(this)' class='number' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td class="fields"><input type='text' value='' name='min_age_in_days' id='min_age_in_days' size='3' maxlength='3'  onBlur='chkDaysVal(this)'  class='number' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td class="fields"><input type='text' value='' name='max_age_in_yrs' id='max_age_in_yrs' size='3'  class='number' maxlength='3'  	onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td class="fields"><input type='text' value='' name='max_age_in_mths' id='max_age_in_mths' size='4' maxlength='4' onBlur='chkMonths(this)'  class='number' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td class="fields" ><input type='text' value='' name='max_age_in_days' id='max_age_in_days' size='2' maxlength='2' onBlur='chkDaysVal(this)'   class='number' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%>></td>
					<td  class='label'><A class='IMAGELINK' name='aaa' href='javascript:openEditorBoard();getSelectedCommentsToEditor()'><b><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></A></td>
		
					<INPUT TYPE="hidden" name="pat_preps_or_instrns_txt_im" id="pat_preps_or_instrns_txt_im" value="">
					<INPUT TYPE="hidden" name="temp_pat_preps_or_instrns_txt_im" id="temp_pat_preps_or_instrns_txt_im" value="">
					<input type="hidden" name="temp_sex_spec_ind" id="temp_sex_spec_ind" value="">
					<input type="hidden" name="temp_min_age_in_yrs" id="temp_min_age_in_yrs" value="">
					<input type="hidden" name="temp_min_age_in_mths" id="temp_min_age_in_mths" value="">
					<input type="hidden" name="temp_min_age_in_days" id="temp_min_age_in_days" value="">
					<input type="hidden" name="temp_max_age_in_yrs" id="temp_max_age_in_yrs" value="">
					<input type="hidden" name="temp_max_age_in_mths" id="temp_max_age_in_mths" value="">
					<input type="hidden" name="temp_max_age_in_days" id="temp_max_age_in_days" value="">
					<input type="hidden" name="temp_index_holder" id="temp_index_holder" value="">
					<input type="hidden" name="temp_comments_holder" id="temp_comments_holder" value="">
	 			</tr>				
			</table>			
		</td>
	</tr>
	<tr id='input_instrn_btn' style='display:none'>
		<td>
			<table border='0' cellpadding='3' cellspacing='0' width='70%' align='left' >
				<tr>
					<td colspan='8' align='right'>
						<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%> onClick='selectValues()'>
						<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%> onClick='cancelValues()'>
						<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' <%=eHISFormatter.chkReturn("y",pat_instrn_age_sex_yn_updatable,"","disabled")%> onClick='clearValues()'>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- IN064543 end -->
</table>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td> 
			<div id = 'contentEditor' style='<%=showHidEditorInstrn%>'>
				<div style="width:70%;height:50vh;overflow:auto">	
					<jsp:include page = '../../eOR/jsp/RTEditor.jsp' flush="true">
					<jsp:param name="readOnly" value = "<%=pat_instrn_age_sex_yn_updatable%>"/>
					</jsp:include>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td align='left' class="fields" id="saveMsg" colspan='11'>&nbsp;</td>		    	
						</tr>
					</table>
				</div>
			</div>
		</td>
	</tr>
</table>
<!--IN64543, ends-->
</form>
<%
putObjectInBean(bean_id,bean,request);	
}catch(Exception e){
System.out.println(e);
e.printStackTrace();
}%>
</body>
</html>
<script>	
	document.onreadystatechange = waitForCompleteLoad;//IN64543
	
	//added for IN031304
	if((document.detailUpperForm.categ_code.value=="RD" && document.detailUpperForm.oa_integration_param.value == "Y")) 
	{ 
		if(document.detailUpperForm.appt_reqd_yn.checked == true) 
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = false;
		}
		else 
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = true;
		}
		if(document.detailUpperForm.follow_visit_type_yn.checked == true) 
		{
			document.detailUpperForm.appt_time.disabled = true ;
		}
		if(document.detailUpperForm.appt_time.value != null && document.detailUpperForm.appt_time.value != "") 
		{
			document.detailUpperForm.follow_visit_type_yn.disabled = true;
		}
	} //END
</script>

