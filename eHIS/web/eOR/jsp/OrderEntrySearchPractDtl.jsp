
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	// Pass it to all Files
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String patient_id	= request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id");
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	String patient_class 	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//	OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	String  sql_or_order_entry_medical_attend_pract = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MEDICAL_ATTEND_PRACT");
	String  sql_or_order_entry_medical_attend_pract_sql2 = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MEDICAL_ATTEND_PRACT_SQL2");
	String  sql_or_order_entry_medical_other_pract_sql2 	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MEDICAL_OTHER_PRACT");
	String  sql_or_order_entry_medical_other_pract 	= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MEDICAL_OTHER_PRACT_SQL2");
	String  sql_or_order_entry_location_clinic 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_CLINIC");
	String  sql_or_order_entry_location_clinics 		= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_CLINICS");
	String  sql_or_order_entry_location_nu 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_NU");
	String  sql_or_order_entry_location_nu_pract_sql2 			= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_NU_PRACT_SQL2");
	String  sql_or_order_entry_location_pract		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_PRACT");
	String  sql_or_order_entry_location_pract_sql2		= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_PRACT_SQL2");
	String  sql_or_order_entry_location_nu_pract 	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_NU_PRACT");
	String  sql_or_order_entry_speciality			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY");
	//String  sql_or_order_entry_speciality_pract		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY_PRACT");
	String  sql_or_order_entry_speciality_pract		= OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP");
	String  sql_or_order_entry_pract				= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACT");
	String  sql_or_order_entry_pract_sql2				= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACT_SQL2");

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
%>

<html>
<head><title><fmt:message key="eOR.SearchForPractitioner.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	<%
		String label		= "";
		String search_by 	= request.getParameter("search_by");
		if(search_by == null) search_by = "";

		if(search_by.equals("AT"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels");
			
		}
		else if(search_by.equals("MT"))
		{
			label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.medicalteam.label","common_labels");
		}
		else if(search_by.equals("LO"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
		}
		else if(search_by.equals("SP"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
		}
		else if(search_by.equals("SF"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.self.label","common_labels");
		}
		else if(search_by.equals("AL"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		}
	
	%>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="formPractDtl" id="formPractDtl">
<%
	String practitioner_id 	 = "";
  	String practitioner_name = "";
%>
<table border='0' cellpadding="0" cellspacing="0" align="center" width="100%">
<th colspan="4" align="left"><%=label%></th>
	<%
	if(search_by.equals("MT"))
	{
	%>
		<tr>
		<td class="fields"><input type="radio" name="medical_team" id="medical_team" value="AT" onClick='setMedicalTeam(this)'><fmt:message key="eOR.TeamsofAttendingPractitioner.label" bundle="${or_labels}"/><td class="fields"><input type="radio" name="medical_team" id="medical_team" value="OT" onClick='setMedicalTeam(this)'> <fmt:message key="eOR.OtherTeam.label" bundle="${or_labels}"/></td>
		</tr>
	<%
	}
	else if(search_by.equals("LO"))
	{
	%>
		<tr>
			<td class="label" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class="label" ><% if(bean.getLocationType().equals("W")) { %><select name='location_code_val' id='location_code_val' onChange='getLocation(this)'>
	     	    <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
	     	    <%
					 ArrayList Location = beanQueryObj.getLocation(properties);
					 for(int i=0; i<Location.size(); i++)
					 {
						String[] record = (String[])Location.get(i);
						out.println("<option value = '"+record[0]+"::"+record[2]+"'> "+record[1]+" ");
					 }
				} 
				else 
				{ 
				%>
						<input type="text" name="location" id="location" value='' onblur='callLocSearch(location,location_code);' onmouseout="clearPractForLocn(location,location_code)"><input type="button" class="button" name="location_search" id="location_search" value="?" onClick='callSearch(location);'>
				<% 
				} 
				%>
			<input type="hidden" name="open_to_all_pract_yn" id="open_to_all_pract_yn" value=''><input type="hidden" name="location_code" id="location_code" value=''><img src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
<%
	}
	else if(search_by.equals("SP"))
	{
	%>
		<tr>
			<td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="label" ><input type="text" name="speciality" id="speciality" maxlength='30' size='20' onblur='callSpecialitySplSearch(speciality,speciality_code)'><input type="button" class="button" name="sp_search" id="sp_search" value="?" onClick='callSpeciality(speciality)'><input type="hidden" name="speciality_code" id="speciality_code" value=''><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
	<%
	}
	%>	
	<tr>
		<td  class="label"><%if(bean.getAmendOrder().equalsIgnoreCase("existing_order")) out.print(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Amend.label","common_labels")+""); else out.print(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ordering.label","common_labels")+" "); %><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<%
		  if(search_by.equals("AT") || search_by.equals("MT"))
		  {
		  	StringTokenizer stAttendPract = new StringTokenizer(beanQueryObj.getAttendPractitioner(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"~~");
		  	while(stAttendPract.hasMoreTokens())
		  	{
		  		practitioner_id 	= beanQueryObj.checkForNull(stAttendPract.nextToken(),"");
		  		practitioner_name 	= beanQueryObj.checkForNull(stAttendPract.nextToken(),"");
		  	}
			if(practitioner_id==null || practitioner_id.equals("N"))
				practitioner_id = "";
			if(practitioner_name==null || practitioner_name.equals("N"))
				practitioner_name = "";
		  }
		  else if(search_by.equals("SF"))
		  {
				practitioner_id 	=  beanQueryObj.checkForNull((String) session.getValue("ca_practitioner_id"),"");
				practitioner_name	=  beanQueryObj.checkForNull((String) session.getValue("practitioner_name"),"");
				String login_user	=  beanQueryObj.checkForNull((String) session.getValue("login_user"),"");
			    if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
				{
         			String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
        			if (practitioner_details.length == 2) 
					{
        				practitioner_id		= beanQueryObj.checkForNull(practitioner_details[0],"");
        				practitioner_name	= beanQueryObj.checkForNull(practitioner_details[1],"");
				   }
				}
			 }
		%>
		<td  class="label"><input type='hidden' name='practitioner_id_val' id='practitioner_id_val' value='<%=practitioner_id%>'>
		<input type='hidden' name='practitioner_id_value' id='practitioner_id_value' value='<%=practitioner_id%>'>		
<%
			if(search_by.equals("MT"))
			{
				practitioner_id="";practitioner_name = "";
			}
%>
			<input type="text" size="30" maxlength="60" name="practitioner_name" id="practitioner_name"  onmousedown="clearPractForLocn()" value='<%=practitioner_name%>'  onblur='callSearch(this,"B");' <%= (search_by.equals("AL"))?"":"readOnly" %>><%if(!(search_by.equals("AT") || search_by.equals("SF") ) ){%><input type="button" class="button" name="pract_search" id="pract_search" value="?" onClick='callSearch(practitioner_name,"C");'><%}%><input type="hidden" size="30" maxlength="60" name="practitioner_id" id="practitioner_id" value='<%=practitioner_id%>'><img src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
<%	if(!search_by.equals("SF")) {%> <%--If it not self, then display --%>
	<tr><td colspan="2"></td></tr>
	<tr>
		<td class="Label" ><fmt:message key="eOR.InstructionMode.label" bundle="${or_labels}"/></td>
		<td class="label" ><select name="order_mode" id="order_mode" onChange="getOrderDesc(this)">
   	    <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
			 ArrayList OrderMode = beanQueryObj.getOrderMode(properties);
			 for(int i=0; i<OrderMode.size(); i++)
			 {
				String[] record = (String[])OrderMode.get(i);
				out.println("<option value = '"+record[0]+"::"+record[1]+"'> "+record[2]+" ");
			 }
%>
		</select></td><td><TEXTAREA cols="30" rows="3" name="order_mode_desc" value="" size="20" readOnly></TEXTAREA></td></tr>
<% } %>

	<input type="hidden" name="order_mode_value" id="order_mode_value" value="">
	</table>
	<table border='0' cellpadding="3" cellspacing="0" width="100%">
	<%
	if(search_by.equals("AT")||search_by.equals("AL")||search_by.equals("SF"))
	{
	%>
		<tr rowspan="11"><td class="label" colspan='2'></td></tr>
	<%
	}
	if(search_by.equals("SF"))
	{
	%>
		<tr rowspan="15"><td class="label" colspan='2'></td></tr>
	<%
	}
	%>
	<tr>
		<td class="button"  colspan="2" align='right'>
		<input type="button" class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%> " onClick="callOnModal(this,'<%=search_by%>');"><input type="button" class="button" name="cancel" id="cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="callOnModal(this);" ></td>
	</tr>
	</table>
		<input type="hidden" name="medical_team_val" id="medical_team_val" value="">
		<input type="hidden" name="search_by" id="search_by" value="<%=search_by%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="location_type" id="location_type" value="<%=bean.getLocationType()%>">
		<input type="hidden" name="sql_or_order_entry_medical_attend_pract" id="sql_or_order_entry_medical_attend_pract" value="<%=sql_or_order_entry_medical_attend_pract%>">
		<input type="hidden" name="sql_or_order_entry_medical_attend_pract_sql2" id="sql_or_order_entry_medical_attend_pract_sql2" value="<%=sql_or_order_entry_medical_attend_pract_sql2%>">
		<input type="hidden" name="sql_or_order_entry_medical_other_pract" id="sql_or_order_entry_medical_other_pract" value="<%=sql_or_order_entry_medical_other_pract%>">
		<input type="hidden" name="sql_or_order_entry_medical_other_pract_sql2" id="sql_or_order_entry_medical_other_pract_sql2" value="<%=sql_or_order_entry_medical_other_pract_sql2%>">
		<input type="hidden" name="sql_or_order_entry_location_clinic" id="sql_or_order_entry_location_clinic" value="<%=sql_or_order_entry_location_clinic%>">
		<input type="hidden" name="sql_or_order_entry_location_clinics" id="sql_or_order_entry_location_clinics" value="<%=sql_or_order_entry_location_clinics%>">
		<input type="hidden" name="sql_or_order_entry_location_nu" id="sql_or_order_entry_location_nu" value="<%=sql_or_order_entry_location_nu%>">
		<input type="hidden" name="sql_or_order_entry_location_pract" id="sql_or_order_entry_location_pract" value="<%=sql_or_order_entry_location_pract%>">
		<input type="hidden" name="sql_or_order_entry_location_pract_sql2" id="sql_or_order_entry_location_pract_sql2" value="<%=sql_or_order_entry_location_pract_sql2%>">
		<input type="hidden" name="sql_or_order_entry_location_nu_pract" id="sql_or_order_entry_location_nu_pract" value="<%=sql_or_order_entry_location_nu_pract%>">
		<input type="hidden" name="sql_or_order_entry_location_nu_pract_sql2" id="sql_or_order_entry_location_nu_pract_sql2" value="<%=sql_or_order_entry_location_nu_pract_sql2%>">
		<input type="hidden" name="sql_or_order_entry_speciality" id="sql_or_order_entry_speciality" value="<%=sql_or_order_entry_speciality%>">
		<input type="hidden" name="sql_or_order_entry_speciality_pract" id="sql_or_order_entry_speciality_pract" value="<%=sql_or_order_entry_speciality_pract%>">
		<input type="hidden" name="sql_or_order_entry_pract" id="sql_or_order_entry_pract" value="<%=sql_or_order_entry_pract%>">
		<input type="hidden" name="sql_or_order_entry_pract_sql2" id="sql_or_order_entry_pract_sql2" value="<%=sql_or_order_entry_pract_sql2%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	</form>
</body>
</html>

<%
	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>

