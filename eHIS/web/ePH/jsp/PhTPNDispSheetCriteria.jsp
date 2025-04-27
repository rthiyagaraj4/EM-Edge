<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		           Name		          Rev.Date		        Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2024	  	ML-MMOH-CRF-2042     Keerti 								 TPN Standard â?? A new offline report will be introduced as "TPN Dispense Sheet". 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>

	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhTPNDispSheet.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    ArrayList displocation  = bean.getDispLocation();

	String bean_id1				= "PHRepDispStatisByDispBean" ;
	String bean_name1			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean1	= (PHRepDispStatisByDispBean)getBeanObject( bean_id1,bean_name1, request) ;
	bean1.setLanguageId(locale);
	String sys_date=bean1.getSysdate();
	 Connection connection				= null;
	    connection						= ConnectionManager.getConnection(request);
	boolean siteTpn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PH_TPN_DISPENSE_SHEET");
try{
%>

<BODY onMouseDown="" onKeyDown="lockKey()">
<form name="formPhTPNDispSheetCriteria" id="formPhTPNDispSheetCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
					<td class="label" width="20%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width="25%" >&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onchange="populateWorksheetNo();" onKeyPress="changeToUpper()">	<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhTPNDispSheetCriteria.p_patient_id)">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>
					<td  class="label" width="20%" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
					<td width="8%"><input type="text" name="p_dispense_date" id="p_dispense_date" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="if(CheckDateT(this)) populateWorksheetNo();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_dispense_date');document.formPhTPNDispSheetCriteria.p_dispense_date.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>    
					<td class="label" width="25%" ></td>
					<td width="20%">
					</td>
				</tr>
	 <tr COLSPAN="6" height="4">
	 <td COLSPAN="6"></td>
	 </tr>
	 <tr>
	 <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
					<td align="Left">
						<select name="stage" id="stage" onchange="populateWorksheetNo();" >
						<option value="F"><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
						<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
						</select></td>
        <td class="label"><fmt:message key="ePH.WorksheetID.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<SELECT name="p_worksheet_id" id="p_worksheet_id">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
	
	  </SELECT>
		<td class="label" ></td>

</tr>		
	 <tr COLSPAN="6" height="4"></tr>
	
	</table>
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDISSHTPNSTD">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</form>

<%//Added  for ML-MMOH-CRF-0977 start
}

		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}
		finally{
			

			if(connection != null)
				ConnectionManager.returnConnection(connection,request);
		
		}
		//Added  for ML-MMOH-CRF-0977
		 %>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

