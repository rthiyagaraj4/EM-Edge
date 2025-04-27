<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>

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
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eOR/js/Dispense.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()"  onLoad="populateValues();">
<%
	

	/* Mandatory checks start */
	String mode	   			= request.getParameter( "mode" ) ;
	String function_id 		= request.getParameter( "function_id" ) ;
	String bean_id	   		= request.getParameter( "bean_id" ) ;
	String bean_name   		= request.getParameter( "bean_name" ) ;

	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");

	//String practitioner_name= (String)session.getValue("practitioner_name");
	//String practitioner_id	= (String)session.getValue("ca_practitioner_id");
	String practitioner_type= (String)session.getValue("practitioner_type");
	//String facility_id		= (String)session.getValue("facility_id");
	//String resp_id			= (String)session.getValue("responsibility_id");
	//if(resp_id	== null)		resp_id = "";
	boolean pract_type_is_PH = true;
/* Mandatory checks end */
	/* Initialize Function specific start */
	//DispenseBean bean = (DispenseBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	DispenseBean bean = (DispenseBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setLanguageId(localeName);

	bean.setMode( mode ) ;
	//String curr_sys_date = bean.getSysDate();
	if(practitioner_type == null) 	practitioner_type = "";
	else
	{
		if(practitioner_type.equals("PH"))
			pract_type_is_PH = true;
	}
	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();
	//ArrayList location=new ArrayList();
	ArrayList orderType = new ArrayList();
	try{
		// commented on 13/05/2003
		//if(!pract_type_is_PH)
		//	location =bean.getLocation(facility_id, practitioner_id, "");
		// Till here
		orderType=bean.getOrderType();
		//out.println(orderType+" --- ");
	}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}

	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	try{
		ArrayList sysdate = (ArrayList)bean.getSysDateTime();
		for(int i=0;i<sysdate.size();i++){
	
			last_week_date =  (String)sysdate.get(0);
			curr_week_date =  (String)sysdate.get(1);
			curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
		//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
		}
		if(last_week_date.equals("null")) last_week_date="";
if(curr_week_date.equals("null")) curr_week_date="";
if(curr_sys_date.equals("null")) curr_sys_date="";
if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_week_date = com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY","en",localeName);
	curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
	}
	} catch (Exception e) {
		out.println("<script>alert('here:"+e.getMessage()+"')</script>");
	}


/* Initialize Function specific end */
 // Added on 13/05/2003  -- To stop the function if the practitioner is not an Pharamacist
	//if((pract_type_is_PH) || ((patient_id != null) && (!patient_id.equals(""))))
	if((pract_type_is_PH) || (!(patient_id.equals("null"))))
	{
%>
<%--<script>alert('<%=patient_id%>,<%=pract_type_is_PH%>,<%=(!(patient_id.equals("null")))%>')</script>--%>
<form name="dispense_search" id="dispense_search"target="messageFrame" >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
	<td class=label colspan='6'>&nbsp;</td>
</tr>
<!-- Location Type -->
<tr>
		<td class=label><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<input type=hidden name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>



<!-- Location  -->
<%
// commented on 13/05/2003
/*if (!pract_type_is_PH)
{ */%>
		<!--<td>&nbsp;<SELECT name='location_type' id='location_type' onChange='populateLocation(this)'>
				<option value=''>All</option>
				<option value='C'>Clinic</option>
				<option value='W'>Nursing Unit</option>
		</td>
		<td class=label align='right' id='id_locn' >&nbsp;Location</td>
		<td>&nbsp;<SELECT name="locn" id="locn">
					<option value=''>All</option>
		-->
		<%
/*		for(int i=0; i<location.size(); i++){
					String[] location_i = new String[2];
					location_i = (String[])location.get(i);
*/
		%>
		<% //}
		%>
		<!-- </select> -->
		<!--<input type=hidden name='order_category' id='order_category' value='PH'>-->
		
<%/*}else{*/
%>
		<td class='fields'><input type=text name="location_type" id="location_type" value='<fmt:message key="eOR.DepartmentalService.label" bundle="${or_labels}"/>' onKeyPress='return CheckForSpecChars(event)' readOnly></td>
		<td class=label id="id_locn"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name="locn" id="locn" value='<fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/>' readOnly><input type=hidden name="order_category" id="order_category" value="PH"></td>
<%//}%>
		<td colspan=2></td>
	</tr>
	<tr>
<!--Priority/ORDER tYPE -->
<% //if (!pract_type_is_PH){
%>
		<!--<td class=label align='right'>Priority</td>
		<td>&nbsp;<SELECT name="priority" id="priority" >
				<option value=''>All</option>
				<option value='R'>Routine</option>
				<option value='S'>Stat</option>
				<option value='U'>Urgent</option>
			</SELECT>
			<input type=hidden name='single_multi' id='single_multi' value='S'>
		</td>
		<td class=label align='right'></td>
		<td colspan="3">&nbsp;</td> -->
<%
    //	}else{
%>		<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='fields'><%
			if(orderType.size() == 1){
				String[] ord_type = new String[2];
				ord_type = (String[])orderType.get(0);%>
			<input type=text name='order_type_disp' id='order_type_disp' value='<%=ord_type[1]%>'>
			<input type=hidden name='order_type' id='order_type' value='<%=ord_type[0]%>'>
			<input type=hidden name='single_multi' id='single_multi' value='S'>
			<%}else{
				out.print("<input type=hidden name='single_multi' id='single_multi' value='M'>");
				out.print("<select name=order_type><option value=''>All</option>");
				for(int i=0; i<orderType.size(); i++){
					String[] ord_type = new String[2];
						ord_type = (String[])orderType.get(i);
				%>
				<option value='<%=ord_type[0]%>'><%=ord_type[1]%></option>
				<%}%></select>
			<%} 
				
				
				
				%>
			</td>
			<!--Priority -->
	<td class=label><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='fields'><SELECT name="priority" id="priority">
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		  <option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		  <option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
			</td>
			
<% //}
%>
<td colspan=2></td>
</tr>
<!--Period -->
<tr>
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class=fields><input type="text" name="date_from" id="date_from" value="<%=curr_week_date%>" size="10" maxlength="10" onKeyPress='return OrAllowDateFormat()' onBlur="chckDate(this)"><img src="../../eCommon/images/CommonCalendar.gif" align=center onclick="return showCalendar('date_from');" style='cursor:pointer'><font size="4">-</font><input type=text name='date_to' id='date_to' value='<%=curr_sys_date%>' size='10' maxlength='10' onBlur="checkDateRange(this,'dispense_search')"><img src="../../eCommon/images/CommonCalendar.gif" align=center onclick="return showCalendar('date_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img></td>
<% 		if(patient_id==null || patient_id.equals("null")) { %>
		<td class=label ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class=fields ><SELECT name="patient_class" id="patient_class">
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/>
<%
			ArrayList patientClass=bean.getPatientClass();
			{
				for(int i=0; i<patientClass.size(); i++){
					String[] patient_class = new String[2];
					patient_class = (String[])patientClass.get(i);
%>
					<option value="<%=patient_class[0]%>"><%=patient_class[1]%></option> 
<%				}
			}
%>
			</select>
		</td>
<%		} else { %>
		<td class=label></td>
<%		} %>
		<td colspan=2></td>
</tr>

<% if(patient_id==null || patient_id.equals("null") || patient_id.equals("")){
		patient_id="";	encounter_id="";
%>

<!--Patient ID/Order ID -->
<tr>
		<td class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' width='16%' name='patient_id' id='patient_id' value='<%= patient_id %>' maxlength="<%=patient_id_length%>" nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='20' ><input  type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td class=label><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name='order_id' id='order_id' value='' size = "15" maxlength=15 onBlur='ChangeUpperCase(this)'></td>
		<td colspan=2></td>
</tr>

<!--Encounter ID -->
<tr>
		<td class=label><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name='encounter_id' id='encounter_id' value='<%=encounter_id%>' size = "12" maxlength=12  onBlur='OrCheckPositiveNumber1(this)' onKeyPress='return OrAllowPositiveNumber()' colspan=3></td>
		<td class=label></td>
		<td class=label><input type='hidden' name='patient_id_found' id='patient_id_found' value='no'></td>
		<td colspan=2></td>
</tr>

<%}else{%>
		<input type='hidden' name='patient_id_found' id='patient_id_found' value='yes'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%= patient_id %>'>
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		<input type='hidden' name='order_id' id='order_id' value=''>
		<input type='hidden' name='patient_class' id='patient_class' value=''>
<%}%>

<tr align='right'><td colspan=5 class='button'><input type=button class=button name='search' id='search' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  onClick='populateValues()'><input type=button name='clear' id='clear' class=button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick='clearValues()'></td>
<td colspan=2></td>
</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="function_id" id="function_id" value="">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
</form>
<%
 // Added on 13/05/2003
 }
 else
 {
	  	out.println("<script>alert(getMessage(\"USERACCESS\",'OR'))</script>");
 }
%>

</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

