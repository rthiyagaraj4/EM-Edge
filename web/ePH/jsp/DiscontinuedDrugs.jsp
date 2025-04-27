<!DOCTYPE html>
 <%-- saved on saved on 07.01.2009 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	//
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
		<script language="javascript" src="../../ePH/js/PhRepAdministrationNotRecorded.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>   
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>	
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	 
</head>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id, bean_name , request) ;
	String  med_adm_yn			= bean.getMednAdmnList();
    ArrayList nursingList       = bean.getMednNursingList(locale);
	ArrayList dateList          = bean.getMednDateList();
    String currentdate			= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	if(med_adm_yn.equals("N"))
	out.println("<script>GoBack()</script>");
%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhRepAdministrationNotRecordedCriteria.P_NURSING_UNIT.focus();">

<form name="formPhRepAdministrationNotRecordedCriteria" id="formPhRepAdministrationNotRecordedCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<table cellpadding="0" cellspacing="4" width="100%" align="center" border="0">
<TH COLSPAN="6" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>
        <td align="right" class="label" width="18%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td align="left" >&nbsp;&nbsp;<SELECT name="P_NURSING_UNIT" id="P_NURSING_UNIT" >
		   	<OPTION VALUE=" "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
			<%	for (int i=0; i<nursingList.size(); i+=2) { %>
			<OPTION VALUE="<%= nursingList.get(i) %>"><%= nursingList.get(i+1) %></OPTION>

	<% 	} %>
		  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>
			<td colspan='4'>&nbsp;</td>
</tr>
<tr>
	
		<td align="right" class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
		<td class="label">&nbsp;<input type="text" name="P_DATE_FROM1" id="P_DATE_FROM1"  value="<%=currentdate%>"
		 onBlur='checkDate(this);DateCheck(this,P_DATE_TO1)' maxlength="10" size="10" />
       <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_FROM1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><td align="right" class="label" ><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
        <td><input type="text" name="P_DATE_TO1" id="P_DATE_TO1" value="<%=currentdate%>" onBlur='checkDate(this);DateCheck(P_DATE_FROM1,this)' maxlength="10" size="10" >
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_TO1')"; >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td> </td> 
			<td class="label" colspan=2>&nbsp;</td>
		<tr>
        <td  align="right" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td align="left">&nbsp;&nbsp;<input type="text" name="P_PATIENT_ID" id="P_PATIENT_ID" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()"  ><input type="button" class="button" value="?" name="pat_search" id="pat_search"
		  onfocus="callPatientSearch(document.formPhRepAdministrationNotRecordedCriteria.P_PATIENT_ID)" onClick="callPatientSearch(document.formPhRepAdministrationNotRecordedCriteria.P_PATIENT_ID)">&nbsp;</td>

		<td align="right" class="label"><fmt:message key="ePH.FromBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td><td align ='left' ><input type="text" name="P_FROM_BED_NO" id="P_FROM_BED_NO" value="" size="8">&nbsp;&nbsp;&nbsp; </td><td align="right" class="label" ><fmt:message key="ePH.ToBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td><td><input type="text" value="" name="P_TO_BED_NO" id="P_TO_BED_NO" size="8"></td>
 </tr>
&nbsp;
 <tr valign="middle">
 <td align="right" class="label"><fmt:message key="ePH.AdministrationStatus.label" bundle="${ph_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<select name="P_ADMIN_STATUS" id="P_ADMIN_STATUS">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                    <option value="E"><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.Due.label" bundle="${common_labels}"/></option>
					<option value="F"><fmt:message key="Common.Future.label" bundle="${common_labels}"/></option>
					</select>
		</td>
		<td colspan='4'>&nbsp;</td>
		</tr>
</table>
	<INPUT TYPE="hidden" name="p_ad_date" id="p_ad_date" VALUE="<%=dateList.get(2) %>">
	<INPUT TYPE="hidden" name="p_in_date" id="p_in_date" VALUE="<%=dateList.get(0) %>">
	<INPUT TYPE="hidden" name="p_en_date" id="p_en_date" VALUE="<%=dateList.get(1) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
     <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRADMINNOTREC">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>" >
	<INPUT TYPE="hidden" name="P_DATE_FROM" id="P_DATE_FROM" VALUE="">
	<INPUT TYPE="hidden" name="P_DATE_TO" id="P_DATE_TO" VALUE="">


</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

