<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhRepOPRxHandledStatistics.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
    ArrayList facilityList       = bean.getFacilitys();
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	String user_name  =  (String) session.getValue( "login_user" ) ;
	String sysdate =com.ehis.util.DateUtils.convertDate(bean.getSysDate(), "DMY","en",locale);
%>
	<BODY onMouseDown="" onKeyDown="">
		<form name="formRepOPRXHandledStatCriteria" id="formRepOPRXHandledStatCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="2" cellspacing="0" width="90%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}" /></TH>
				<tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3"><SELECT name="p_sel_facility_id" id="p_sel_facility_id" onChange="populateDispLocn(this.value)">
					<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
<%
					if (facilityList.size() > 0 ){
						for (int i=0; i<facilityList.size(); i+=2) {
							if(facilityList.get(i).equals(facility_id)){
%>
								<OPTION VALUE="<%= facilityList.get(i) %>" selected="selected"><%= facilityList.get(i+1) %></OPTION>
<%							
							}
							else{
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 	
							}
						}
					}
%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.reporttype.label" bundle="${ph_labels}"/></td>
					<td colspan="3" class="label">
						<select name="p_cal_by_type" id="p_cal_by_type" onChange="validate_date()" >
							<option value="D" selected><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
							<option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						</select><img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label" width='15%'><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
					<td class='label' width='25%'>
						<input type="text" name="frm_date" id="frm_date" size=10 maxlength=10 class="DATE" value="<%=sysdate%>" onChange="if(CheckDateT(this)) dateCheckWithCurrDate('F');" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('frm_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label" width='10%' align='right'><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/></td>
					<td class='label' ><input type="text" name="to_date" id="to_date" size=10 maxlength=10 class="DATE" value="<%=sysdate%>" onChange="if(CheckDateT(this) && dateCheckWithCurrDate('T')) validateProcessDt();" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td COLSPAN="3">
						<select name="p_disp_locn_code" id="p_disp_locn_code" >
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
						ArrayList arraylist		=	bean.getOPDispLocations(facility_id);
						int arrLength		=	arraylist.size();
						for(int i=0;i<arrLength; i+=2){
%>
							<option value="<%=(String)arraylist.get(i)%>"  ><%=(String)arraylist.get(i+1)%></option> 	
<% 
						}
%>
						</select>
					</td>
				</tr>
			</table>
			
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_frm_date" id="p_frm_date" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHROPOFWL">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		</form>
	</body>
</html>

