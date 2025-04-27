<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page   import="eOT.*, eOT.Common.*,eCommon.XSSRequestWrapper, eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<% String locale = (String)session.getAttribute("LOCALE"); %>


<html>
<head>
		
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language="JavaScript" src="../../eOT/js/WardChkOut.js"></script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String facility_id	= (String) session.getValue("facility_id");
String mode			= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
String params		= request.getQueryString() ;
String refresh_flag	= request.getParameter("refresh_flag");
String called_from	= request.getParameter("called_from");
String surgery_date	= "";
String nursing_unit	= "";
String nursing_unit_name	= "";
String patient_id = "";
String patient_name = "";
String bean_id		= "WardChkOutBean";
String bean_name	= "eOT.WardChkOutBean";
WardChkOutBean   bean  = (WardChkOutBean)mh.getBeanObject(bean_id, request, bean_name);
if(refresh_flag!=null && !refresh_flag.equals("null") && !refresh_flag.equals("")){
	surgery_date	=	checkForNull(request.getParameter("surgery_date"));
	nursing_unit	=	request.getParameter("nursing_unit");
	patient_id		=	request.getParameter("patient_id");
}
 if(surgery_date.equals(""))
	surgery_date = com.ehis.util.DateUtils.convertDate(bean.getSysDateTime(),"DMY","en",locale);

%>
<body  onKeyDown = 'lockKey()' >
<form name="WardChkOutSearchForm" id="WardChkOutSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<%
	if(called_from.equals("CA")){
%>
	<tr id="slate_results_table_row1">
	<td class="CAGROUPHEADING" align="left" nowrap colspan="4">
		<fmt:message key="eOT.CheckOutFromWard.Label" bundle="${ot_labels}"/>
	</td>
	</tr>
<%
	}
%>
<tr>
	<td class="label" width="25%" >
		<fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text" name="surgery_date" id="surgery_date" size="10" maxlength=10 value="<%=surgery_date%>" onblur="isValidDate(this)" >
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('surgery_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>

	<td class="label" width="25%"  >
		<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
	</td>
	
	<td class='fields' width="25%" colspan="4">
	<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type="text"  name="nursing_unit_name" id="nursing_unit_name" size='36' value="<%=nursing_unit_name%>" onBlur="if(this.value!='')searchWard(nursing_unit_name);">
		<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=nursing_unit%>">
		<input type="button" class="button" name="nursing_unit_search" id="nursing_unit_search" value="?" onclick="if(nursing_unit_name.value=='')searchWard(nursing_unit_name);"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class="label"width="25%"  >
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	
	<td class='fields' width="25%" >
		<input type="text" name="patient_id" id="patient_id" size='10' maxlength='10'value="<%=patient_id%>" onkeypress="return CheckForSpecChars(event)" onblur="if(this.value!='')checkPatientId(this)">
		<input type="button" class="button" name="patient_search" id="patient_search" value="?" onclick="localSearchPatient(document.WardChkOutSearchForm.patient_name);">
	</td>
	<td class="label"width="25%"  >
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" colspan="2" >	
		<input type="text"  name="patient_name" id="patient_name" size='30' value="<%=patient_name%>" disabled>
	</td>
	
</tr>

<tr>
	<td class="label" width="25%" >
		<fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/>
	</td>
	
	<td class='fields' width="25%" >
		<select name="view_by" id="view_by">
			<option value="S" selected>
			<fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/>
			</option>
			<option value="U">
			<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/>
			</option>
			<option value="A">
			<fmt:message key="Common.all.label" bundle="${common_labels}"/>
			</option>
		</select>
	</td>
	<td class="label" width="25%" >
		<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<select name="bookings_type" id="bookings_type">
			<option value="S" selected><fmt:message key="eOT.SurgeryBookings.Label" bundle="${ot_labels}"/></option>
<!-- 			<option value="R"><fmt:message key="eOA.RadiologyBookings.label" bundle="${oa_labels}"/></option> -->
		</select>
	</td>
</tr>	

<tr>	
	<td  class='label' width="25%" nowrap>
	<fmt:message key="eOT.WardCheckOutSearchCheckBox.Label" bundle="${ot_labels}"/>
	</td>

	<td  class='fields' width="25%" >
		<input type="checkbox"  name="current_ip_ward_yn" id="current_ip_ward_yn" value='Y' onclick="assignChkBoxVal(this)"  checked>
	</td>
<td  class='fields' width="25%" ></td>
	<td  class='fields' width="25%" >
		<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchWardChkOutDetails();">
	</td>
</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' >
	<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
</form>
</body>
</html>

