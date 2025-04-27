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
<%@page  import="java.util.*, webbeans.eCommon.ConnectionManager,eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
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

	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/ReprintForms.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='populateLocation()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <%-- onLoad="populateLocation(document.register_order_search.location_type);populateLocnOrdType('order_category');" --%>
<%
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	
	String bean_id = "Or_ReprintFormsBean" ;
	String bean_name = "eOR.ReprintFormsBean";
	/* Mandatory checks end */

	ReprintFormsBean bean 	= (ReprintFormsBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	int patient_id_length 	= 10;
	patient_id_length		= bean.getPatientIdLength();
	

	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(1);
		last_week_date = last_week_date.substring(0,last_week_date.length() - 6);
		curr_week_date =  (String)sysdate.get(0);	
		curr_week_date = curr_week_date.substring(0,curr_week_date.length() - 6);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}
	if ( !localeName.equals("en") )
{ 
if (last_week_date== null || last_week_date== "null") last_week_date="";
if (curr_week_date== null || curr_week_date== "null") curr_week_date="";
if (curr_sys_date== null || curr_sys_date== "null") curr_sys_date="";

	last_week_date=com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_week_date=com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY","en",localeName);
	curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
}
%>
<form name='reprint_forms_search' id='reprint_forms_search' target='messageFrame'>
	<table cellpadding=3 cellspacing=0 border=0 width="101.5%" align=center >
			<TR>
			<TD class='label' ><fmt:message key="Common.report.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select name='report' id='report' onChange='populateOrderCategory(this)'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option>
			<Option value='C'><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></Option>
			<Option value='O'><fmt:message key="eOR.OrderForm.label" bundle="${or_labels}"/></Option>
			<Option value='X'><fmt:message key="eOR.ReferralForm.label" bundle="${or_labels}"/> </Option>
			<Option value='S'><fmt:message key="eOR.RefusalForm.label" bundle="${or_labels}"/> </Option>
			<Option value='R'><fmt:message key="eOR.Results.label" bundle="${or_labels}"/> </Option>
			<Option value='L'><fmt:message key="eOR.CollectionList.label" bundle="${or_labels}"/> </Option>
			
			</Select><img src="../../eCommon/images/mandatory.gif" align=center></img></TD><TD class='label' ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><input type=text name='order_id' id='order_id' value='' maxlength=15  onBlur='ChangeUpperCase(this)' ></TD></tr>
			<tr>
			<TD class='label' ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select name='ord_cat' id='ord_cat' onChange='populateOrderType(this)'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select></TD>
			<TD class='label' ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select name='order_type' id='order_type'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select></TD>
		</TR>
		<TR>
			
			<TD class='label' ><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Input name='date_from' id='date_from' type='text' value='<%=last_week_date%>' maxlength='10' size='10' onBlur="chckDate(this,'<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img></TD>
			<TD class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Input name='date_to' id='date_to' type='text' value='<%=curr_week_date%>' maxlength='10' size='10' onBlur="checkDateRange(this,'reprint_forms_search','DMY','<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'></TD>
		</TR>
		<TR>
			<TD class='label' ><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select name='source_type' id='source_type' onChange='populateLocation()'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option>
			<Option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
			<Option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
			</Select></TD>
			<TD class='label' ><fmt:message key="eOR.SourceFrom.label" bundle="${or_labels}"/></TD>
			<TD class='fields'><Select name='source_from' id='source_from'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select><fmt:message key="Common.to.label" bundle="${common_labels}"/><Select name='source_to' id='source_to'><Option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select></TD>
		</TR>
		<TR>
			<TD class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><input type='text' width='16%' name='patientId' id='patientId' value='' nowrap   maxlength='<%=patient_id_length%>' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></TD>
			<TD class=label ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><input type=text name='encntr_id' id='encntr_id' value='' maxlength=12 onKeyPress='return OrAllowPositiveNumber()'  onBlur='OrCheckPositiveNumber(this)'></TD>
			
		</TR>
		<TR>
			<TD class='label'  id="print_at_label"><fmt:message key="Common.PrintAt.label" bundle="${common_labels}"/></TD>
			<TD colspan='3' id='print_locn' class='fields'><Select name='print_at' id='print_at' onChange='fillPrintLocation(this)'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option>
				<Option value='L'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></Option>
				<Option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
				<Option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
			</Select><Select name='print_at_locn' id='print_at_locn'><Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select><img src="../../eCommon/images/mandatory.gif"></img></TD>
			
		</TR>
		<TR>
			<TD colspan=4 align=right><input type="button" class="button" name="search_btn" id="search_btn" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='populateValues()'></TD>
		</TR>
	</table>
	<%if(!imgUrl.equals("")){ %>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%= curr_sys_date %>">
	<input type="hidden" name="localeName" id="localeName" value="<%= localeName %>">
	<input type="hidden" name="tempfromdate" id="tempfromdate" value="<%= last_week_date %>">

	
</form>

</body>

</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

