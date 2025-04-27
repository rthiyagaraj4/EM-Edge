<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../ePH/js/PhLateAdminDetail.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id, bean_name , request) ;
	String  med_adm_yn			= bean.getMednAdmnList();
    ArrayList nursingList       = bean.getMednNursingList(locale);
	ArrayList dateList          = bean.getMednDateList();
	if(med_adm_yn.equals("N"))
		out.println("<script>GoBack()</script>");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload=""> <!--Removed onload focus // ML-BRU-SCF-0498 [IN035593]-->
		<form name="formPhLateAdminDtlCriteria" id="formPhLateAdminDtlCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="3" width="99%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<!--Commented and added the below  <td align="right" class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<SELECT name="p_nursing_unit" id="p_nursing_unit" >
					<OPTION VALUE=" "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
					<%	/*for (int i=0; i<nursingList.size(); i+=2) { */%>
					<OPTION VALUE="<%/*= nursingList.get(i)*/ %>"><%/*= nursingList.get(i+1)*/ %></OPTION>  -->
					<td class="label" width='15%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td class="label" width='15%'><select name="locn_type" id="locn_type" onChange="resetLocation()">
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<td class="label" width='15%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class="label" width='*'><input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;' disabled><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookup(locn_name)"> <!-- onfocus="locationLookup(locn_name)"  --><!-- Commenting onfocus for ML-BRU-SCF-2218 -->  <input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!-- scf ML-BRU-SCF-0498 [IN:035593] end -->
				</tr> 
				<tr> 
					<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
					<td class="label"><input type="text" size="13" name="dt_from_disp" id="dt_from_disp" value="" onBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from_disp',null,'hh:mm');" >&nbsp; <img src="../../eCommon/images/mandatory.gif"  align="center"> </td>
					<td  class="label" ><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/> </label></td>
					<td  class="label"><input type="text" size="13" name="dt_to_disp" id="dt_to_disp" value="<%=com.ehis.util.DateUtils.convertDate((String)dateList.get(0),"DMYHM","en",locale)%>"  onBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to_disp',null,'hh:mm');" > &nbsp; <img src="../../eCommon/images/mandatory.gif"  align="center"> </td>
				</tr>
				<tr>
					<td class="label">
					<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
					<td class="label" colspan='3'><select name="group_by" id="group_by">
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value="Y"><fmt:message key="ePH.IV.label" bundle="${ph_labels}"/></option>
						<option value="N"><fmt:message key="ePH.Non-IV.label" bundle="${ph_labels}"/></option>
						</select>&nbsp;
					</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" "><!--Added for SKR-SCF-0643.1[Inc:35781] -->
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" "><!--Added for SKR-SCF-0643.1[Inc:35781] -->
			<INPUT TYPE="hidden" name="p_ad_date" id="p_ad_date" VALUE="<%=dateList.get(2) %>">
			<INPUT TYPE="hidden" name="p_in_date" id="p_in_date" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="p_en_date" id="p_en_date" VALUE="<%=dateList.get(1) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRLATEADMIN">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>" >
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>" >
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>"><!--added for ML-BRU-SCF-0498 [IN:035593] -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"><!--added for ML-BRU-SCF-0498 [IN:035593] -->
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

