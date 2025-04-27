<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description 
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

12/24/2015    IN058157      ManojKumar KV      Task list - currently the task list is displaying by one day. Users want to view by a range of dates
--------------------------------------------------------------------------------------------------------------- 
-------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------
20/01/2017		IN061898		Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
22/03/2019	    IN069244		Ramya Maddena	25/01/2019		Ramesh Goli	        MMS-KH-CRF-0005.1
14/10/2019     IN071315	        Nijitha S       14/10/2019  	Ramesh G		GHL-CRF-0607
13/04/2020		IN072674		Ramesh Goli		13/04/2020		Ramesh G			MMS-KH-CRF-0032
26/10/2020	IN067210		SIVABAGYAM M	26/10/2020	RAMESH G	ML-MMOH-CRF-1144
31/05/2021     IN017999         Chandrashekar a                                 AAKH-CRF-0132.1 
26/07/2021   IN020763        Chandrashekar a									AAKH-CRF-0132.1
08/06/2022           			Ramesh G										MMS-QF-SCF-0653 
02-12-2023    32779          Srinivasa                           Ramesh         AAKH-CRF-0165
-------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/** added by kishore kumar n on 28/11/2009  */
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%	
//eCA.PatTaskListRepository patTask = (eCA.PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
String bean_id			= "Ca_PatTaskListRepository" ;
String bean_name		= "eCA.PatTaskListRepository";
//Connection con			=	null;
//PreparedStatement pstmt	=	null;
//ResultSet rset			=	null; 
Properties property = null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
//String sysdate = "";
//String fromDate = "";
property = (java.util.Properties) session.getValue( "jdbc" );
//sysdate = patTask.getSysdateTime();
//fromDate = patTask.getSysdateFromTime();
//fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM","en",locale);
//sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale);
LinkedHashMap hash_values			= new LinkedHashMap();
hash_values=patTask.get_hash();
ArrayList<String> tasklist =patTask.getTasklist();//IN067210
//String c_taskSelect=(String)hash_values.get("c_taskSelect");
String c_OrderCategory=(String)hash_values.get("c_OrderCategory");
String c_OrderType=(String)hash_values.get("c_OrderType");
String c_Groupby=(String)hash_values.get("c_Groupby");
String c_onclickS=(String)hash_values.get("c_onclickS");
String c_clickdate=(String)hash_values.get("c_clickdate");
String c_fromdate =(String)hash_values.get("c_From_date");
String c_todate =(String)hash_values.get("c_To_date");
String c_pat_discharge =(String)hash_values.get("c_pat_discharge");
String c_status_code=(String)hash_values.get("c_status_code");
String c_chkAll=(String)hash_values.get("c_chkAll");
String c_ckhDue=(String)hash_values.get("c_ckhDue");
String c_chkOverdue=(String)hash_values.get("c_chkOverdue");
String c_chkElapsed=(String)hash_values.get("c_chkElapsed");
String c_chkPerformed=(String)hash_values.get("c_chkPerformed");
String c_chkFuture=(String)hash_values.get("c_chkFuture");
String c_chkReg=(String)hash_values.get("c_chkReg");
String c_chkUnclassify=(String)hash_values.get("c_chkUnclassify") == null ? "" : (String)hash_values.get("c_chkUnclassify");
String c_ckhDue1="Y";
String c_chkOverdue1="Y";
String c_chkUnclassify1="Y";

if (c_ckhDue.equals("N"))
	c_ckhDue1="N";
if (c_chkOverdue.equals("N"))
	c_chkOverdue1="N";
if (c_chkUnclassify.equals("N"))
	c_chkUnclassify1 = "N";

if (c_chkAll.equals("") && c_ckhDue.equals("") && c_chkOverdue.equals("") && c_chkElapsed.equals("") && c_chkPerformed.equals("") && c_chkFuture.equals("") && c_chkReg.equals("") && c_chkUnclassify.equals(""))
{
	c_chkOverdue1="Y";
	c_ckhDue1="Y";
	c_chkUnclassify1="Y";
}

if(c_status_code.equals("")) c_status_code="TASK_RESULT_LIST";

//String patient_id = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id"); //IN058157
//String encounter_id = request.getParameter("episode_id")==null ? "" : request.getParameter("episode_id");
//String patient_class =request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
String from =request.getParameter("from")==null ? "" : request.getParameter("from");
String locn_code =request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
String relationship_id =request.getParameter("relationship_id")==null ? "" : request.getParameter("relationship_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");//IN069244 
String c_task_Select = request.getParameter("c_task_Select")==null?"":request.getParameter("c_task_Select");//IN069244 
String p_called_from_ca  = request.getParameter("p_called_from_ca ")==null?"":request.getParameter("p_called_from_ca ");//IN071315
ArrayList<String> functionIds = new ArrayList<String>();//Adding start for IN017999
functionIds.add("VITAL_SEARCH_BY_BED");
patTask.adapter.setSiteSpecific(functionIds,"CA");
boolean isVitalSearchByBedNo = patTask.adapter.isSiteSpecific("VITAL_SEARCH_BY_BED");
String enc_change_flag  ="N";//Adding end for IN017999

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onload='populateOrderType1("OrderCategory")'>
<form name='TaskListFilterForm' id='TaskListFilterForm'>


<table cellpadding='3' cellspacing='0' border='0' width="100%" align=center>
<tr>
<td class='label' colspan="4" nowrap>
<%
ArrayList OrderCatData = patTask.getOrderCategory(property) ;
			%>

<select name='OrderCategory' id='OrderCategory' OnChange='populateOrderType(this)' style="height: 22px; width: 150px">
					<option value='' <%=c_OrderCategory.equals("")?"selected":""%>><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<%for( int i=0 ; i< OrderCatData.size() ; i++ ) {
				String[] record = (String[])OrderCatData.get(i);
				if(tasklist.size()>8){//IN067210 STARTS
				%>
				<option value='<%=record[1]%>' <%=tasklist.get(8).equals(record[1])?"selected":""%>><%=record[0]%></option>
				
			<%}
				else{
					%>
					<option value='<%=record[1]%>' <%=(c_OrderCategory.equals(record[1]))?"selected":""%>><%=record[0]%></option>
					
				<%}
					}//IN067210 ENDS
				%>
</select>	

<select name='OrderType' id='OrderType' style="height: 22px; width: 150px">
					<option value='' <%=c_OrderType.equals("")?"selected":""%>><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
</select>
<%
	ArrayList AdminRoute = patTask.getAdminRoute(property) ;
%>
<select name='AdminRoute' id='AdminRoute' style="height:22px; width:150px; display:none">
					<option value=''><fmt:message key="eCA.RouteOfAdmin.label" bundle="${ca_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<%for( int i=0 ; i< AdminRoute.size() ; i++ ) {
				String[] record = (String[])AdminRoute.get(i);
%>
				<option value='<%=record[1]%>'><%=record[0]%></option>
				
			<%}
			%>
</select>
<select name='bt_status' id='bt_status' style="height: 22px; width: 150px; display:none">
		<option value=''>---------<fmt:message key="Common.all.label" bundle="${common_labels}"/>----------</option>
		<option value='URN'><fmt:message key="eCA.ReserveNotRequest.label" bundle="${ca_labels}"/></option>
		<option value='UR'><fmt:message key="eCA.ReserveAndRequest.label" bundle="${ca_labels}"/></option>
		<option value='UI'><fmt:message key="eCA.Issued.label" bundle="${ca_labels}"/></option>
		<option value='UT'><fmt:message key="eCA.Transfused.label" bundle="${ca_labels}"/></option>
</select>
<select name='definition' id='definition' OnChange='populateInterventionType(this)' style="height: 22px; width: 150px; display:none">
		<option value=''><fmt:message key="eCA.DefinitionType.label" bundle="${ca_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="eCA.SystemDefined.label" bundle="${ca_labels}"/></option>
		<option value='U'><fmt:message key="eCA.UserDefined.label" bundle="${ca_labels}"/></option>
</select>
<select name='interventionType' id='interventionType' style="height: 22px; width: 150px; display:none">
		<option value=''><fmt:message key="eCA.InterventionType.label" bundle="${ca_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
</select>
<%
   if(isVitalSearchByBedNo){//Adding start for IN017999
	   
%>
<div id="enc_id" style="display:none">
<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
<select name='en_id' id='en_id' id = 'en_id' style="height:22px; width:150px; "onchange ="setChangeFlag()">
</select><img src="../../eCommon/images/mandatory.gif" ></input>
<input type="label" class="label" style="height: 22px; width: 150px;display:none"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>
<input type="text" id= "bed_no" name="bed_no" id="bed_no" onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)"  value="">	</input><!-- Added onblur and keypress for IN20763 -->
</div>
<%}else{//Adding end for IN017999
%>
<input type='hidden' name='en_id' id='en_id' id='en_id' value=''>
<!--IN069244 starts-->
<div id="enc_id" style="display:none">
<input type="label" class="label" style="height: 22px; width: 150px;display:none"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif" ></input>
<input type="text" id= "encounter_id" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	
</div>
<!--IN069244 ends-->
<%}%>
<input class='button' type='button' name='go' id='go' value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' onclick='populateValues();'>
<input type='hidden' name='c_OrderType' id='c_OrderType' value='<%=c_OrderType%>'>

<!-- <select name='statusCode' id='statusCode' OnChange='checkTask(this)' style="height: 22px; width: 150px">
	<option value='TASK_ALL' <%=c_status_code.equals("TASK_ALL")?"selected":""%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='TASK_DUE' <%=c_status_code.equals("TASK_DUE")?"selected":""%>><fmt:message key="eCA.Due.label" bundle="${ca_labels}"/></option>
	<option value='TASK_OVERDUE' <%=c_status_code.equals("TASK_OVERDUE")?"selected":""%>><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
	<option value='TASK_ELAPSED' <%=c_status_code.equals("TASK_ELAPSED")?"selected":""%>><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>
	<option value='TASK_PERFORMED' <%=c_status_code.equals("TASK_PERFORMED")?"selected":""%>><fmt:message key="eCA.Performed.label" bundle="${ca_labels}"/></option>
	<option value='TASK_FUTURE' <%=c_status_code.equals("TASK_FUTURE")?"selected":""%>><fmt:message key="eCA.Future.label" bundle="${ca_labels}"/></option>
	<option value='TASK_REG' <%=c_status_code.equals("TASK_REG")?"selected":""%>><fmt:message key="eCA.Registered.label" bundle="${ca_labels}"/></option>
</select> 	 -->
<input type='hidden' name='status_code' id='status_code' value='TASK_RESULT_LIST'>
<input type='hidden' name='statusCode' id='statusCode' value='TASK_RESULT_LIST'>
<!-- IN058157 start -->
<% //if(!patient_id.equals("")){  %>
<!-- IN058157 End  -->
&nbsp;&nbsp;&nbsp;<a href='javascript:openFilterWindow("To_date","From_date","pat_discharge","onclickS","selectedSubFunciton")'>&nbsp;<fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/></a> <!-- selectedSubFunciton added for IN072674 -->
<!-- IN058157 Start. --> 
<%//}else{%>
<!-- <fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/> -->
<%//}%>
<!-- IN058157 End  -->
</td>
</td>
</tr>
<tr>  
<td class='fields' colspan="3" nowrap width="40%">
	<!-- <select name='statusCode' id='statusCode' OnChange='checkTask(this)' style="height: 22px; width: 150px"> -->
	<input type = "checkbox" name="chkAll" id="chkAll" value='TASK_RESULT_LIST' <%=c_chkAll.equals("Y")?"checked":""%> onclick="checkAll(this)"><fmt:message key="Common.all.label" bundle="${common_labels}"/>
	<input type = "checkbox" name="ckhDue" id="ckhDue" value='TASK_DUE' <%=(c_ckhDue.equals("Y") || c_ckhDue1.equals("Y")) ?"checked":""%> onclick="checkAll(this)"><fmt:message key="Common.Due.label" bundle="${common_labels}"/>
	<input type = "checkbox" name="chkOverdue" id="chkOverdue" value='TASK_OVERDUE' <%=c_chkOverdue.equals("Y") || c_chkOverdue1.equals("Y")?"checked":""%> onclick="checkAll(this)"><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/>
	<input type = "checkbox" name="chkElapsed" id="chkElapsed" value='TASK_ELAPSED' <%=c_chkElapsed.equals("Y")?"checked":""%> onclick="checkAll(this)"><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/>
	<input type = "checkbox" name="chkPerformed" id="chkPerformed" value='TASK_PERFORMED' <%=c_chkPerformed.equals("Y")?"checked":""%> onclick="checkAll(this)"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>
	<input type = "checkbox" name="chkFuture" id="chkFuture" value='TASK_FUTURE' <%=c_chkFuture.equals("Y")?"checked":""%> onclick="checkAll(this)"><fmt:message key="eCA.Future.label" bundle="${ca_labels}"/>
	<input type = "checkbox" name="chkUnclassify" id="chkUnclassify" value='UN_CLASSIFY' <%=(c_chkUnclassify.equals("Y") || c_chkUnclassify1.equals("Y")) ?"checked":""%> onclick="checkAll(this)"><fmt:message key="eCA.Unclassified.label" bundle="${ca_labels}"/>
	<!--<input type = "checkbox" name="chkReg" id="chkReg" value='TASK_REG' <%=c_chkReg.equals("TASK_REG")?"checked":""%>><fmt:message key="eCA.Registered.label" bundle="${ca_labels}"/></option> -->
<!-- </select> --> 
<!--<td class='fields'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<select name='Groupby' id='Groupby' OnChange='checkgroupby()' style="height: 22px; width: 150px"><!--IN069244-->
<td class='fields'id="Group_by"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<select name='Groupby' id='Groupby' OnChange='checkgroupby()' style="height: 22px; width: 150px"><!--IN069244-->
					<option value='P' <%=c_Groupby.equals("P")?"selected":""%>><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>	
					<option value='T' <%=c_Groupby.equals("T")?"selected":""%>><fmt:message key="eCA.TimeInterval.label" bundle="${ca_labels}"/></option>	
</select>
</td>
</td>

</tr>
</table>
<!-- added by kishore kumar n on 28/11/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<input type="hidden" name="localeName" id="localeName" value="<%=locale%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="To_date" id="To_date" value="<%=c_todate.equals("")?"":c_todate%>">
<input type="hidden" name="From_date" id="From_date" value="<%=c_fromdate.equals("")?"":c_fromdate%>">
<input type="hidden" name="pat_discharge" id="pat_discharge" value="<%=c_pat_discharge.equals("")?"":c_pat_discharge%>">
<input type="hidden" name="isOTInstalled_yn" id="isOTInstalled_yn" value="">
<Input type="hidden" name="isRDInstalled_yn" id="isRDInstalled_yn" value="">
<input type="hidden" name="clickdate" id="clickdate" value="<%=c_clickdate%>">
<input type="hidden" name="onclickS" id="onclickS" value='<%=c_onclickS.equals("")?"N":c_onclickS%>'>
<input type="hidden" name="locn_code" id="locn_code" value='<%=locn_code%>'>
<input type="hidden" name="relationship_id" id="relationship_id" value='<%=relationship_id%>'>
<input type="hidden" name="encounter_id" id="encounter_id" value='<%=encounter_id%>'><!--IN069244-->
<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value='<%=p_called_from_ca%>'><!--IN071315-->
<input type="hidden" name="selectedSubFunciton" id="selectedSubFunciton" value=""> <!-- IN072674 -->
<input type="hidden" name="isVitalSearchByBedNo" id="isVitalSearchByBedNo" value='<%=isVitalSearchByBedNo%>'><!-- IN017999 -->
<input type="hidden" name="patient_id" id="patient_id" value=""><!-- IN017999 -->
<input type="hidden" name="enc_change_flag" id="enc_change_flag" value='<%=enc_change_flag%>'><!-- IN017999 -->
<input type="hidden" name="interval" id="interval"><!-- 32779 -->
</form>
<!-- Commented for IN061898
<%if (from.equals("TaskList")){%> 
<script>		
	setTimeout('populateValues();',500);
</script>
<%}%>
-->
<!-- IN061898 starts -->
<script>		
	setTimeout('populateValues();',500);
</script>
<!--IN061898 Ends -->
</body>
</html>
<%putObjectInBean("patTask",patTask,session);%>

