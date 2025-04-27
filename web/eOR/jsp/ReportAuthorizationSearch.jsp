<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ReportAuthorization.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()"  onLoad="populateLocnOrdType('location_type');populateLocnOrdType('locn');loadMainScreenData();">
<%
	
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReportAuthorization" ;
	String bean_name = "eOR.ReportAuthorizationBean";
	//String tempdate1="";

	String patient_id		 = request.getParameter("patient_id");	//
	String encounter_id		 = request.getParameter("encounter_id");	//
	String header_values		 = request.getParameter("header_values");	//
	String CancelFlag		 = request.getParameter("CancelFlag");	//
	//String practitioner_name = (String)session.getValue("practitioner_name");
	String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
	String practitioner_type = (String)session.getValue("practitioner_type");

   // String isLabInstalled_yn = "",
	String isRDInstalled_yn = "";
	String facility_id		 = (String)session.getValue("facility_id");
	String resp_id			 = (String)session.getValue("responsibility_id");
	/*Added by Uma on 2/17/2010 for CRF 804 to get the Filter parameter IN016226*/
	String filter=request.getParameter("filter")==null?"":request.getParameter("filter");	
	boolean pract_type_is_NS = false;

	if(resp_id	== null)		resp_id = "";

	if(practitioner_type == null)
		practitioner_type = "";
	//else
	//{
		//if(practitioner_type.equals("NS"))
		//	pract_type_is_NS = true;
	//}

/* Mandatory checks end */

	/* Initialize Function specific start */
	//ReportAuthorizationBean bean = (ReportAuthorizationBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ReportAuthorizationBean bean = (ReportAuthorizationBean)getBeanObject( bean_id, bean_name , request) ;
	
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.setLanguageId(localeName);	
	bean.clear() ;
	bean.setMode( mode ) ;
	
	String header_location_type			= "";
	String header_locn					= "";
	String header_priority			= "";
	String header_order_type			= "";
	String header_activity_type	= "";
	String header_date_from			= "";
	String header_date_to				= "";
	String header_patient_id		= "";
	String header_order_id			= "";
	String header_encounter_id	= "";
	
	if(header_values!=null && !header_values.equals("") && !header_values.equals("null"))
	{
		StringTokenizer st = new StringTokenizer(header_values,"~~~");
		while(st.hasMoreElements())
		{
			header_location_type			= st.nextToken();
			header_locn						= st.nextToken();
			header_priority				= st.nextToken();
			header_order_type				= st.nextToken();
			header_activity_type			= st.nextToken();
			header_date_from				= st.nextToken();
			header_date_to			= st.nextToken();
			header_patient_id		= st.nextToken();
			header_order_id		= st.nextToken();
			header_encounter_id		= st.nextToken();
			
		}
	}

	int patient_id_length = bean.getPatientIdLength();
	//String curr_sys_date = bean.getSysDate();
	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	try{
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();

	}
	/* Thai date validations start 14/02/2007*/
	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";
	if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";
	
	if(localeName!="en"){
	last_week_date		= com.ehis.util.DateUtils.convertDate(last_week_date,"DMYHM","en",localeName);
	curr_week_date	= com.ehis.util.DateUtils.convertDate(curr_week_date,"DMYHM","en",localeName);
	curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
	}
	
	/* Thai date validations start 14/02/2007*/
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	ArrayList location=new ArrayList();
	String[] order_category = new String[2];
	//ArrayList orderType = new ArrayList();
	try{

		order_category	= bean.getOrdercategory(practitioner_id, resp_id);

		if(pract_type_is_NS)
		location =bean.getLocation(facility_id, practitioner_id, "");

		//orderType=bean.getOrderType(order_category[0], practitioner_id, resp_id);

	}catch(Exception e){
		e.printStackTrace();
	}

try{
	//String isLabInstalled_yn = "";
	//if(order_category[0].equals("LB")){
		//isLabInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RL");
		/*if((isLabInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getMessage('LAB_MODULE_INSTALLED','OR')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}
	//if(order_category[0].equals("RD")){
		isRDInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RD");
		/*if((isRDInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}
}catch(Exception e){
	e.printStackTrace();
}
/* Initialize Function specific end */

%>

<form name='report_authorization_search' id='report_authorization_search' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%"  align=center>
<!-- Location Type -->
<tr>
		

<!-- Location  -->
<%
if (pract_type_is_NS)
{%>
		<td class=label colspan=1><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<input type=hidden name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
		<td class='fields' colspan=2><SELECT name="location_type" id="location_type" onChange='SelectLocation(this)'>
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		</SELECT><input type="text" value='' name="locn_desc" id="locn_desc" onblur='populateLocation1(locn_desc,locn);'><input type=button name=LocnSearch value='?'  class=button tabIndex="4" onClick="populateLocation(locn_desc,locn);" disabled><input type="hidden" name="locn" id="locn" value="">
		<input type=hidden name='order_category' id='order_category' value='NC'>
		</td>
<%}else{%>
		<input type='hidden' name='location_type' id='location_type' value='Departmental Service' >
		<td class=label  id='id_locn' colspan=1><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<TD class='fields' colspan=2><Select name="locn" id="locn" onChange="populateLocnOrdType('locn');"><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></Select><img src="../../eCommon/images/mandatory.gif"></img>
		<input type=hidden name='order_category' id='order_category' value=''>
		</TD>

<%}

if (pract_type_is_NS){%>
		<input type=hidden name='single_multi' id='single_multi' value='S'>
		<td class=label colspan=3>&nbsp;</td>
		<td class=fields colspan=4>&nbsp;</td>
		
<%}else{%>
	<td class=label colspan=3><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<TD class='fields' colspan=4><select name=order_type onChange='populateLocnActivityType()'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></Select><input type=hidden name='single_multi' id='single_multi' value='M'></TD>	
	<%}%>
	</tr>
	<tr>
<!--Priority -->
<td class='label' colspan=1><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
<td class='fields' colspan=2><input type="text" name="activity_type_desc" id="activity_type_desc" value="" onblur='callActivitySearch1(activity_type_desc,activity_type);'><input type=button name=ActSearch value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type);"><input type="hidden" name="activity_type" id="activity_type" value=""></td>
<td class='label' colspan=3><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=4><SELECT name="priority" id="priority">
					<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					</SELECT>
		</td>
</tr>
<!--Period -->
<tr>
		
		<td class='label' colspan=1><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2><input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="<%=curr_week_date%>" onBlur=" chckDate(this,'<%=localeName%>')" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from',null,'hh:mm');" style='cursor:pointer'>-<input type=text name='date_to' id='date_to'  size=16 maxlength=16 value="<%=last_week_date%>" onBlur="checkDateRange(this,'report_authorization_search','DMYHM','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to',null,'hh:mm');" style='cursor:pointer'></td>
		<td class=label colspan=3><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=4><input type=text name='order_id' id='order_id' value='' maxlength=15 onBlur='ChangeUpperCase(this)'></td>
		
		
</tr>


<!--Patient ID/Order ID -->
<tr>
		<% if(patient_id==null || patient_id.equals("null") || patient_id.equals("")){
		patient_id="";
		encounter_id="";

		}else{%>
		<input type='hidden' name='patient_id_found' id='patient_id_found' value='yes'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		<input type='hidden' name='order_id' id='order_id' value=''>
		<%}%>
		<td class=label colspan=1><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2><input type='text' width='16%' name='patient_id' id='patient_id' value='<%= patient_id %>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td class=label colspan=3><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=4><input type=text name='encounter_id' id='encounter_id' value='<%=encounter_id%>' maxlength=12 onKeyPress='return OrAllowPositiveNumber()'><input type='hidden' name='patient_id_found' id='patient_id_found' value='no'></td>
	
</tr>
<!-- Added by Uma on 2/17/2010 for CRF 804 for the Filter display IN016226 -->
<tr>
	<td class='label'  ><fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/></td>
		<td  class="fields">
			<select name="filter_name" id="filter_name" id="filter_name_id">				
					<option value="MP" <%=filter.equalsIgnoreCase("MP")?"selected":""%>><fmt:message key="eOR.MyPatients.label" bundle="${or_labels}"/></option>
					<option value="OP" <%=filter.equalsIgnoreCase("OP")?"selected":""%>><fmt:message key="eOR.OrderedPatients.label" bundle="${or_labels}"/></option>
					<option value="RP"  <%=filter.equalsIgnoreCase("RP")?"selected":""%>><fmt:message key="eOR.MyRelatedPatients.label" bundle="${or_labels}"/></option>					
					<option value="AL" <%=filter.equalsIgnoreCase("AL")?"selected":""%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
</tr>
<!--Ends Here -->
<tr>
<td id='performing_locn_lbl_show' class='label' colspan=1></td>
<td id='performing_locn_show' class='fields' colspan=2></td>

<td class='label' colspan=3></td>
<td  class='button' colspan=4>
<input type=button class=button name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='populateValues()'><input type=button name='clear' id='clear' class=button value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td>
</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<Input type="hidden" name="isRDInstalled_yn" id="isRDInstalled_yn" value="<%=isRDInstalled_yn%>">

<Input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<Input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<Input type="hidden" name="header_values" id="header_values" value="<%=header_values%>">
<input type="hidden" name="header_location_type" id="header_location_type" value="<%=header_location_type%>">
<input type="hidden" name="header_locn" id="header_locn" value="<%=header_locn%>">
<input type="hidden" name="header_priority" id="header_priority" value="<%=header_priority%>">
<input type="hidden" name="header_order_type" id="header_order_type" value="<%=header_order_type%>">
<input type="hidden" name="header_activity_type" id="header_activity_type" value="<%=header_activity_type%>">
<Input type="hidden" name="header_date_from" id="header_date_from" value="<%=header_date_from%>">
<Input type="hidden" name="header_date_to" id="header_date_to" value="<%=header_date_to%>">
<Input type="hidden" name="header_patient_id" id="header_patient_id" value="<%=header_patient_id%>">
<Input type="hidden" name="header_order_id" id="header_order_id" value="<%=header_order_id%>">
<Input type="hidden" name="header_encounter_id" id="header_encounter_id" value="<%=header_encounter_id%>">
<Input type="hidden" name="CancelFlag" id="CancelFlag" value="<%=CancelFlag%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">


</form>
<%
		putObjectInBean(bean_id,bean,request);
%>

</body>

</html>

