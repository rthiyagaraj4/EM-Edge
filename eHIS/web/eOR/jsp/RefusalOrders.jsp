<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- RefusalOrders.jsp -->
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/09/2012    IN034904        Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal
19/02/2013	  IN037939		vijayakumark	System is not allowing the user to perform the Record Refusal operation for the Pharmacy Order Catalog with Consent Form
---------------------------------------------------------------------------------------------------------------
--> 
<%-- JSP Page specific attributes start --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page  import="eOR.* ,eOR.Common.* , javax.servlet.*,java.io.*,java.util.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 
<jsp:useBean id="bean1" scope="page" class="eOR.ExistingOrder"/>

<% bean1.setLanguageId(localeName);%>
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
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<%

	

String colval1 = request.getParameter("colval1")==null?"":request.getParameter("colval1");
String body_load="";
if(colval1.equals("Refusal"))
	body_load="onLoadRefusalOrders()";

	
%>
<body onLoad="<%=body_load%>" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

     
//onLoad="document.formRefusalOrders.patientId.focus();"
	/* Mandatory checks start */
	//String mode	   = request.getParameter("mode") ;
	//String reason = ((request.getParameter("reason")==null)? "":request.getParameter("reason"));
	String refusal_type = ((request.getParameter("refusal_type")==null)? "":request.getParameter("refusal_type"));
	//String datetime = ((request.getParameter("datetime")==null)? "":request.getParameter("datetime"));
//out.println("<script>alert('bean_id="+request.getParameter( "bean_id" )+"');</script>");
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	
	String login_user = (String) session.getValue( "login_user" );
	
	String patient_class = (request.getParameter("patient_class")==null) ? "":request.getParameter("patient_class");

	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");

	String encounter_id = (request.getParameter("encounter_id")==null)? "":request.getParameter("encounter_id");
 
//	String sex = (request.getParameter("sex")==null) ? "":request.getParameter("sex");

	String orderId = (request.getParameter("orderId")==null) ? "":request.getParameter("orderId");
	String ord_line_num = (request.getParameter("ord_line_num")==null) ? "":request.getParameter("ord_line_num");
	
	String consentLinenum = (request.getParameter("consentLinenum")==null) ? "":request.getParameter("consentLinenum");//--[IN034904]
	String order_type_code = (request.getParameter("order_type_code")==null) ? "":request.getParameter("order_type_code");
	String location_type = (request.getParameter("location_type")==null) ? "":request.getParameter("location_type");
	String location_code = (request.getParameter("location_code")==null) ? "":request.getParameter("location_code");
	String priority = (request.getParameter("priority")==null) ? "":request.getParameter("priority");
	String from_val = "";//--[IN034904]
	String orderableCatalogDesc = ""; // IN037939

	//String pracLookup = OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP");
	String pracLookup = OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP");
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);

	bean.clear();
	bean.clearBean();
	//out.println("====="+bean.getSelectedCatalog());
	Properties properties	= (Properties) session.getValue( "jdbc" );
	String curr_sys_date			= "";
	//String last_month_date			= "";
	//String sys_time_sec				= "";

	ArrayList sysdate = (ArrayList)bean1.getSysDateTime(properties);
	//out.println("sysdate :" +sysdate);
	for(int i=0;i<sysdate.size();i++){
		curr_sys_date	= (String)sysdate.get(2);
		//out.println("curr_sys_date :" +curr_sys_date);
		//last_month_date = (String)sysdate.get(4);
		//sys_time_sec	 = (String)sysdate.get(5);
		//curr_sys_date	= (String)sysdate.get(2);
		//last_month_date = (String)sysdate.get(3);
		
	}

	if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";     
	String date_time= bean.getSysDate1()==null?"":(String) bean.getSysDate1();	
	if(!localeName.equals("en"))
	{
		curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);	
		//Added by Uma on 12/1/2010 for 25333
		date_time = com.ehis.util.DateUtils.convertDate(date_time,"DMYHM","en",localeName);		
	}

	String temp_curr_sys_date = curr_sys_date;
	//out.println("temp_curr_sys_date="+temp_curr_sys_date);
	if(encounter_id==null || encounter_id.equals("null")) encounter_id = "";
 	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();
	//out.println("<script>alert('patient_id="+patient_id+"')</script>");
	//String id_locn_style="bottom-margin:0;display:visible";
	String id_locn_style="bottom-margin:0;display:none";
	if(patient_id.equals("") || orderId.equals(""))
	id_locn_style="bottom-margin:0;display:none";
	
//out.println("<script>alert('colval1="+colval1+"');</script>");
 	//if(patient_id.equals(""))
	if(colval1.equals(""))
	{
	//out.println("<script>alert('orderId11111="+orderId+"');</script>");

%>
<form name='formRefusalOrders' id='formRefusalOrders' id="" target='' action=''>
	<table cellpadding=3 cellspacing=10 border=0 width="100%" height="83%" align="center">
		
		<tr style="<%=id_locn_style%>" >	
				<td  class='label' id='id_locn'   width='25%' nowrap  style="<%=id_locn_style%>"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>  </td>
				<td class='fields' width="25%" style="<%=id_locn_style%>">
					<input type='text'  name='patientId' id='patientId' value='<%= patient_id %>' nowrap onKeyPress='return CheckForSpecChars(event)' size="20" maxlength="<%= patient_id_length %>" onBlur="ChangeUpperCase(this);populatePatientAgeValue(this,'refusal');populateResultScreen(this);"><input align='right' class='button' type=button name=search id=search value='?'   tabIndex="4" onClick="callPatientSearch()" >
						<img src="../../eCommon/images/mandatory.gif"></img>
					
				</td>
							<td class='label' style="<%=id_locn_style%>"></td>
							<td class='label' style="<%=id_locn_style%>"></td>
	</tr>
	<!-- start -->
	
	<tr style="<%=id_locn_style%>">
			
			<td  class='label' id='short_name_id'  colspan="0" width='25%' nowrap  style="<%=id_locn_style%>"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='label' colspan=3 ><label id="result_name" style="<%=id_locn_style%>"></label></td>

	</tr>

	<tr>	
				<td  class='label' id='id_locn'  width='25%' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
				<td class='fields' width="25%">
					<input type='text'  name='encounterid' id='encounterid' value='<%=encounter_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  readonly size="20" ><input align='right' class='button' type=button name=search1 id=search1 value='?'   tabIndex="4" onClick="patientEncounterDetail('<%=patient_id%>','refusal')">
				</td>
							<td class='label'></td>
							<td class='label'></td>
	</tr>
	<tr >	
				<td  class='label' id='id_locn'  width='25%' nowrap ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/> </td>
				<td class='fields' width="28%">
					<input type='text'  name='neworderid' id='neworderid' value='<%=orderId%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' readonly size="20" ><input align='right' class='button' type=button name=search11  value='?'   tabIndex="4" onClick='patientOrderDetails(patientId.value);'>
					
				</td>
							<td class='label'></td>
							<td class='label'></td>
	</tr>
	<tr>
			<!-- 3  Referal Type -->
			<td  class='label' id='referal_type_id'  width='25%' nowrap ><fmt:message key="eOR.RefusalType.label" bundle="${or_labels}"/> </td>
			<td class='fields'>
			 
			 <select name='refeusal_type1' id='refeusal_type1' OnChange='displayOrderNonOrderDefault()'>
			 <option value='' align='center'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			 <option value="O" <%=eOR.Common.eHISFormatter.select(refusal_type,"O")%>><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option>
			 <option value="N" <%=eOR.Common.eHISFormatter.select(refusal_type,"N")%>><fmt:message key="eOR.NonOrderable.label" bundle="${or_labels}"/></option>
			 </select><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
						<td class='label' colspan="1"></td>
						<td class='label' colspan="1"></td>
	</tr>

	<tr>
				<!-- 4 Orderable-->
			<td class='label' id='ordlabel' width='25%' ></td>	<td class='label' id='ordtext'></td><td class='label'></td><td class='label'></td>
	</tr>

    <tr >
				<!-- 5 Reason-->
			<td  class='label' id=''  width='25%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td class='fields' height="20%" width="60%" colspan="3"><textarea cols="45"   rows="5" name="reason" id=""  onBlur="makeValidString(this);SPCheckMaxLen('Reason',this,255,'')"  onkeyPress='return checkMaxLimit(this,255)' ></textarea><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
						
	</tr>
<%//out.println("<script>alert('111111curr_sys_date="+curr_sys_date+"');</script>");%>

    <tr >
	<td  class='label' id=''  width='25%' nowrap ><fmt:message key="eOR.RefusalDateTime.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='text' name='datetime' id='datetime' value="<%=curr_sys_date%>" maxlength="16" size="16" onkeyPress='return allowDateFormat();return checkMaxLimit(this,16)' onBlur="checkDate(this,'<%=localeName%>')"><img SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar"  onclick="showCalendar('datetime',null,'hh:mm');document.formRefusalOrders.datetime.focus();return false;"><img src="../../eCommon/images/mandatory.gif"></img></td>
					<td class='label' width="1%"></td>
						<td class='label'></td>
	</tr>

		<%
		String[] defPrac = bean.getDefPractitioner(login_user);
		String practitioner_name = defPrac[0];
		String func_role_id = defPrac[1];
		%>
	<tr>
				<!-- 6 Practitioner -->
			<td  class='label' id=''  width='25%' nowrap ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='practitioner' id='practitioner' size="20" 
			onblur="show_practitioner_code_window(this)" value="<%=practitioner_name%>"><input class='button' type=button name=search2 id=search2 value='?'  class='button'  onClick="show_practitioner_code_window1(document.formRefusalOrders.practitioner)"><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
						<td class='label'></td>
									<td class='label'></td>
	</tr>
	<%
			//Vector refusalList = bean.getRefusalForm();
			 ArrayList 	refusalList = bean.getRefusalForm();
	%>
	<tr>
				<!-- 6 Practitioner -->
			<td  class='label' id=''  width='25%' nowrap ><fmt:message key="eOR.RefusalID.label" bundle="${or_labels}"/></td>
			<td class='fields'><select name="refusal_form" id="refusal_form" onchange="showRefusalText(this)">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						for(int i=0;i<refusalList.size();i++)
						{
							String[] record = (String[])refusalList.get(i);
							// System.out.println("===="+record[0]);
					%>
						<option  value="<%=(String )record[0]%>"> <%=(String )record[1]%></option>
					<%
						}
					%>
					</select><img src="../../eCommon/images/mandatory.gif"></img>
			<label class='label' id='refusal_text'></label>	
			</td>
						<td class='label'></td>
						<td class='label'></td>
	</tr>
	<tr align='right'>
		<td class='label'  colspan=2></td>
						<td class="button" colspan=2>
							<input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name="record" class='button' onClick="recordOrders('refusal');"><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name="clear" class='button' onClick='clearScreen()'></td>
	</tr>
	</table>
				 <input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=pracLookup%>">
				<input type="hidden" name="practitioner_code_sql2" id="practitioner_code_sql2" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2")%>"> 
				 <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
				<input type="hidden" name="mode" id="mode" value="1">
				<input type="hidden" name="ordercode" id="ordercode" value="">
				<input type='hidden' name='admissionDate' id='admissionDate' value=''>
				<input type='hidden' name='practitionerId' id='practitionerId' value='<%=func_role_id%>'>
				<input type='hidden' name='srlno' id='srlno' value="1">
				<input type="hidden" name='curr_sys_date' id='curr_sys_date' value="<%=date_time %>">
				<input type='hidden' name='patient_class' id='patient_class' value="<%= patient_class %>">
				<input type='hidden' name='order_type_code' id='order_type_code' value="">
				<input type='hidden' name='location_code' id='location_code' value="">
				<input type='hidden' name='location_type' id='location_type' value="">
				<input type="hidden" name="order_Line_num" id="order_Line_num" value="">
				<input type="hidden" name="facility_id" id="facility_id" value="<%= session.getAttribute("facility_id") %>">
				<input type="hidden" name="hidd_ord_id" id="hidd_ord_id" value="">
				<input type="hidden" name="consent_content" id="consent_content" value="">
				<input type="hidden" name="priority" id="priority" value="">
				<input type="hidden" name="func_role_id" id="func_role_id" value="<%= func_role_id %>">
				<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">

				<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
				<input type="hidden" name="from_val" id="from_val" value="">
				
				
</form>
<%
	}else
		{

				//out.println("<script>alert('orderId222222222="+orderId+"');</script>");
				//out.println("<script>alert('==="+request.getQueryString()+"===');</script>");
		
		String[] ordText = bean.getOrderCatalog(orderId, ord_line_num);

		String order_line_num = ordText[0];
 		String order_catalog_code = ordText[1];
		String catalog_synonym_dc = ordText[2];
		String style="display:none";
		String disabled="";
		String record_val = "refusal";
		String on_change="displayOrderNonOrderDefault1()";
		//--[IN034904] - Modified - Start
		if((catalog_synonym_dc.equals("")&&!(orderId.equals(""))&& !(ord_line_num.equals(""))) || (!consentLinenum.equals("1")) )
		{
			String ordTextDesc = bean.getOrderCatalogDesc(orderId, ord_line_num);
			catalog_synonym_dc = ordTextDesc;
			if(catalog_synonym_dc.indexOf("!~!<br />")!=-1)
			{
				catalog_synonym_dc = catalog_synonym_dc.replace("!~!<br />",",");
			}//--[IN034904] - Modified - End
			//IN037939 starts
			if(catalog_synonym_dc.indexOf("<br />")!=-1)
			{
				catalog_synonym_dc = catalog_synonym_dc.replace("<br />",",");
			}
			//IN037939 ends
		}
		//IN037939 starts
		if(!(orderId.equals("")))
			orderableCatalogDesc = bean.getOrderableCatalogDesc(orderId);
		//IN037939 ends
		if(colval1.equals("Refusal"))
		{
			style = "display:";
			disabled="disabled";
			on_change="";
			record_val = "consent";
		}
		//--[IN034904] - Start
		if(!consentLinenum.equals(""))
		{
			from_val = "multi_catalog_consent";
		}
		//--[IN034904] - End
		//out.println("<script>alert('catalog_synonym_dc="+catalog_synonym_dc+"')</script>");
		//out.println("<script>alert('orderId="+orderId+"')</script>");
		//out.println("<script>alert('patient_id="+patient_id+"=')</script>");
 	%>
	
	<form name='formRefusalOrders' id='formRefusalOrders' id="" target='' action=''>
<br>
	<table cellpadding=3 cellspacing=0 border=0 width="94%" height="93%" align="center">
		
		 <tr style='<%=style%>'>	
				<td  class='label' id='id_locn'  width='25%' nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
				<td class='fields' width="25%">
					<input type='text'  name='patientId' id='patientId' value='<%=patient_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' size="20" maxlength="<%=patient_id_length%>" onfocus="ChangeUpperCase(this);populatePatientAgeValue(this,'consent');makeDisable();" readonly><input align='right' class='button' type=button name=search id=search value='?'   tabIndex="4" disabled> <!-- onClick="callPatientSearch()" -->
					<img src="../../eCommon/images/mandatory.gif"></img>
				</td>
							<td class='label'></td>
							<td class='label'></td>
	</tr>  
	<!-- start -->
	
	<!-- <input type='hidden'  name='patientId' id='patientId' value='<%=patient_id%>' > -->
	<tr style='<%=style%>'>
			
			<td  class='label' id='short_name_id'  colspan="0" width='25%' nowrap > <fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='data' colspan=3 ><label id="result_name"></label></td>

	</tr>

	<tr >	
				<td  class='label' id='id_locn'  width='25%' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<!-- <td class='label' width="14%">
					&nbsp;&nbsp;<input type='text'  name='encounterid' id='encounterid' value='<%=encounter_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  readonly size="20" ><input align='right' class='button' type=button name=search1  value='?'   tabIndex="4" onClick="patientEncounterDetail(patientId.value,'consent')">
				</td> -->
				<td class='fields' width="25%">
					<input type='text'  name='encounterid' id='encounterid' value='<%=encounter_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  readonly size="20" ><input align='right' class='button' type=button name=search1 id=search1 value='?' <%=disabled%>  tabIndex="4" onClick="patientEncounterDetail(patientId.value,'consent')">
				</td>
							<td class='label'></td>
							<td class='label'></td>
	</tr>
	<tr >	
				<td  class='label' id='id_locn'  width='25%' nowrap ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
				<td class='fields' width="14%">
					<input type='text'  name='neworderid' id='neworderid' value='<%=orderId%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' readonly size="20" ><input align='right' class='button' type=button name=search11 id=search11 value='?'  <%=disabled%> tabIndex="4" onClick='patientOrderDetails(patientId.value);'>
					
				</td>
							<td class='label'></td>
							<td class='label'></td>
	</tr>
	<tr>
			<!-- 3  Referal Type -->
			<td  class='label' id='referal_type_id'  width='25%' nowrap ><fmt:message key="eOR.RefusalType.label" bundle="${or_labels}"/> </td>
			<td class='fields'>
			 
			 <select name='refeusal_type1' id='refeusal_type1' OnChange='<%=on_change%>'>
			 <option value='' align='center'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			 <option value="O" selected><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option>
			 <option value="N"<fmt:message key="eOR.NonOrderable.label" bundle="${or_labels}"/></option>
			 </select>
			 <img src="../../eCommon/images/mandatory.gif"></img>
			</td>
						<td class='label' colspan="1"></td>
						<td class='label' colspan="1"></td>
	</tr>

	<tr>
				<!-- 4 Oderable-->
			<td class='label' id='ordlabel' width='25%' ><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td>
			<td class='fields' id='ordtext'>
			<!-- IN037939 starts -->
			<!--<input type='text' name='orderable' id='orderable' value="<% //=catalog_synonym_dc %>" size=50 <% //=disabled %>>-->
			<input type='text' name='orderable' id='orderable' value="<%=orderableCatalogDesc%>" size=43 <%=disabled%>>
			<!-- IN037939 ends -->
			<input type='button' value='?' class='button' <%=disabled%> onClick='callRefusalOrderOrderable(orderable)'><img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td class='label'></td>
			<td class='label'></td>
	</tr>

    <tr >
				<!-- 5 Reason-->
			<td  class='label' id=''  width='25%' nowrap ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td class='fields' height="20%"width="60%" colspan="3"><textarea cols="45"   rows="5" name="reason" id=""  onBlur="makeValidString(this);SPCheckMaxLen('Reason',this,255,'')"    onkeyPress='return checkMaxLimit(this,255)' ></textarea><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
						
	</tr>
<%//out.println("<script>alert('2222curr_sys_date="+curr_sys_date+"');</script>");%>
    <tr >
	<td  class='label' id=''  width='25%' nowrap ><fmt:message key="eOR.RefusalDateTime.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='text' name='datetime' id='datetime' value="<%=curr_sys_date%>" maxlength="16" size="16" onkeyPress='return allowDateFormat();checkMaxLimit(this,16)' onBlur="checkDate(this,'<%=localeName%>')">
	<INPUT TYPE="image" name="image11" id="image11" SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar"  onclick="showCalendar('datetime',null,'hh:mm');document.formRefusalOrders.datetime.focus();return false;" > 
			<img src="../../eCommon/images/mandatory.gif"></img></td>
					<td class='label' width="1%"></td>
						<td class='label'></td>
	</tr>

		<%
		String[] defPrac = bean.getDefPractitioner(login_user);
		String practitioner_name = defPrac[0];
		String func_role_id = defPrac[1];
		%>
	<tr>
				<!-- 6 Practitioner -->
			<td  class='label' id=''  width='25%' nowrap ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='practitioner' id='practitioner' size="20" 
			onblur="show_practitioner_code_window(this)" value="<%=practitioner_name%>">
			<input align='right' class='button' type=button name='search2' id='search2' value='?'  class='button'  onClick="show_practitioner_code_window1(document.formRefusalOrders.practitioner)">
			<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
						<td class='label'></td>
									<td class='label'></td>
	</tr>
	<%
			//Vector refusalList = bean.getRefusalForm();
			  ArrayList refusalList = bean.getRefusalForm();
	%>
	<tr>
				<!-- 6 Practitioner -->
			<td  class='label' id=''  width='25%' nowrap ><fmt:message key="eOR.RefusalID.label" bundle="${or_labels}"/></td>
			<td class='fields'><select name="refusal_form" id="refusal_form" onchange="showRefusalText(this)">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						for(int i=0;i<refusalList.size();i++)
						{
						  String[] record = (String[])refusalList.get(i);
						  //System.out.println("===="+record[0]);
					%>
						
						<option  value="<%=(String)record[0]%>"> <%=(String)record[1] %></option>
					<%
						}
					%>

					</select> <img src="../../eCommon/images/mandatory.gif"></img>
			<label class='label' id='refusal_text'></label>	
			</td>
						<td class='label'></td>
						<td class='label'></td>
	</tr>
	<tr align='right'>
		<td class='button' colspan=2 ></td><td colspan=2 class='button' align="right" ><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name="record" class='button' onClick="recordOrders('<%=record_val%>');"><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name="clear" class='button' onClick="clearScreen1('consent')"></td></tr>
	</table>

				<input type="hidden" name="orderable1" id="orderable1" value="<%=catalog_synonym_dc%>">
				<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
				<input type="hidden" name="order_catalog_desc" id="order_catalog_desc" value="<%=catalog_synonym_dc%>">
               <input type="hidden" name="practitioner_code_sql2" id="practitioner_code_sql2" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2")%>">
				 <input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=pracLookup%>">
				 <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type='hidden' name='practitionerId' id='practitionerId' value='<%=func_role_id%>'>
				<input type="hidden" name="mode" id="mode" value="1">
				<input type="hidden" name="ordercode" id="ordercode" value="">
				<input type='hidden' name='admissionDate' id='admissionDate' value=''>
				<input type='hidden' name='srlno' id='srlno' value="1">
				<input type="hidden" name='curr_sys_date' id='curr_sys_date' value="<%=date_time%>">
				<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
				<input type='hidden' name='order_type_code' id='order_type_code' value="<%=order_type_code%>">
				<input type='hidden' name='location_code' id='location_code' value="<%=location_code%>">
				<input type='hidden' name='location_type' id='location_type' value="<%=location_type%>">
				<input type="hidden" name="priority" id="priority" value="<%=priority%>">
				<input type="hidden" name="order_Line_num" id="order_Line_num" value="<%=order_line_num%>">
				<input type="hidden" name="facility_id" id="facility_id" value="<%=session.getAttribute("facility_id")%>">
				<input type="hidden" name="hidd_ord_id" id="hidd_ord_id" value="">
				<input type="hidden" name="consent_content" id="consent_content" value="">
				<input type="hidden" name="func_role_id" id="func_role_id" value="<%=func_role_id%>">
		    	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
				<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">	
				<input type="hidden" name="from_val" id="from_val" value="<%=from_val %>">	
						
</form>



	<%

		//}
}//end of else
	%>
</body>
</html>
<!-- <script>showCurrDate();</script>
 -->
<%
putObjectInBean(bean_id,bean,request);
%>

