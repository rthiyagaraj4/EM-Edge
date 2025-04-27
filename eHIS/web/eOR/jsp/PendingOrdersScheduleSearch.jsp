
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanQuery" scope="page" class="eOR.QueryBean"/>


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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>--><!-- used for date validation-->
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/PendingOrdersSchedule.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	/* Mandatory checks start */
		

	String mode	   = request.getParameter( "mode" ) ;
	
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id	 = "Or_PatOrderByPrivRelnBean" ;
	String bean_name = "eOR.PatOrderByPrivRelnBean";

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 

	String patient_id		= request.getParameter("can_patient_id")==null?"":request.getParameter("can_patient_id");
	String practitioner_id  = (String)session.getValue("ca_practitioner_id");
	String resp_id			= (String)session.getValue("responsibility_id");

	if(resp_id == null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
	
	//bean.clear() ;
	
	//String sys_date_time = "";
	//String last_week_date  = "";
	String curr_date	  = "";
	String next_week_date = "";

	//int patient_id_length	 = bean.getPatientIdLength();
 	//ArrayList sysdate		 = (ArrayList)bean.getSysDateTime();
    beanQuery.setLanguageId(localeName);
	int patient_id_length	 = beanQuery.getPatientIdLength(properties);
 	ArrayList sysdate		 = (ArrayList)beanQuery.getSysDateTime(properties);

	for(int i=0;i<sysdate.size();i++){
		curr_date =  (String)sysdate.get(0);
		
	//	last_week_date =  (String)sysdate.get(1);
 	//	sys_date_time =   (String)sysdate.get(2);
		next_week_date =  (String)sysdate.get(3);

		
	}

	if(curr_date.equals("null") || curr_date.equals(" ")) curr_date="";
	if(next_week_date.equals("null") || next_week_date.equals(" ")) next_week_date="";
         curr_date = com.ehis.util.DateUtils.convertDate(curr_date,"DMY","en",localeName);
        next_week_date = com.ehis.util.DateUtils.convertDate(next_week_date,"DMY","en",localeName);
	
	String temp_curr_date=curr_date;
	String temp_next_week_date=next_week_date;
	//out.print("<script>alert('last_week_date:"+last_week_date+",curr_week_date-"+curr_week_date+"-curr_sys_date-"+curr_sys_date+"');</script>");	
	//ArrayList order_category = bean.getOrderCategory();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="populateListItems('ord_cat');populateListItems('order_type');populateListItems('patient_class');populateListItems('perform_locn');">
<form name='pendingOrder_schedule' id='pendingOrder_schedule' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="98%" align=center >
	<tr>
        <td class=label  id='id_locn' width='' nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td ><select name="order_category" id="order_category" onChange="populateListItems('order_type');"><option value=''>---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
		</select><%--<img src="../../eCommon/images/mandatory.gif"></img>--%></td>
		<td class=label  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td ><select name=order_type onChange="populateListItems('activity_type');"><!-- <option value=''>All</option> --></Select></td>
		
	</tr>
	
	<tr>

       <td class=label  nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td><select name="activity_type" id="activity_type"></select></td>

		<td class=label  colspan=''><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/> </td>
		<td><input type='text' name='orderable' id='orderable' value='' nowrap  onBlur='if(this.value != ""){ callOrderable(this)}'><input align='right' type=button name=search value='?'  class=button onClick="callOrderable(orderable)" ></td>
		<input type="hidden" name="ordercode" id="ordercode" value="">
		
	</tr>

	<tr>
			<td class=label  nowrap><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/> </td>
		<td><select name="performing_locn" id="performing_locn"><option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></SELECT></td>
		<td class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td><select name="priority" id="priority">
				<option value='' >----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option> 
				<option value='R' ><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S' ><fmt:message key="Common.Stat.label" bundle="${common_labels}"/>  </option>
				<option value='U' ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/> </option>
			</select></td>



		
	</tr>

<tr>

<td class=label  colspan=''><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td><input type='text' width='' name='patient_id' id='patient_id' value='<%=patient_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' maxlength='<%=patient_id_length%>' size='<%=patient_id_length%>' ><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td class=label  nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class="fields"><select name="patient_class" id="patient_class"><option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select></td>
</tr>




	<tr>
	
		<td class='label' ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td ><input type="text" name="date_from" id="date_from" value="<%=curr_date%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>-<input type=text name='date_to' id='date_to' value='<%=next_week_date%>' size="10" maxlength="10" onBlur="checkDateRange(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img></td>
		
	
	
	
		<td  colspan="2" align="right" >
		<input type=button class=button name='search_result' id='search_result' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='populateValues()'><input type=button name='clear' id='clear' class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'></td>

	</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_date" id="temp_curr_date" value="<%=temp_curr_date %>">
<input type="hidden" name="temp_next_week_date" id="temp_next_week_date" value="<%=temp_next_week_date %>">
</form>
</body>
</html>
<%
//	putObjectInBean(bean_id,bean,request);
%>

