<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.util.HashMap, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<LINK REL="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></LINK>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" SRC="../../ePH/js/PhRepMARLabel.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script src='../../eCA/js/CAMessages.js' language='javascript'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="frmphREPMARLabelCriteria" id="frmphREPMARLabelCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"> 
<%
		try{
			String p_patient_id	=	"";
			String bean_id		= "PhRepMARLabelBean" ;
			String bean_name	= "ePH.PhRepMARLabelBean";
			PhRepMARLabelBean bean = (PhRepMARLabelBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);
			SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date_time	 	= new java.util.Date();
			String Sysdate 				= dtSystemFormat.format(date_time); 
			
			HashMap hmRecord = bean.getOrderTypePHParam();
			String iv_with_additives = CommonBean.checkForNull((String)hmRecord.get("IV_DRUG_FLUID_CONTINUOUS_LG"),"");
			String iv_without_additives = CommonBean.checkForNull((String)hmRecord.get("IV_WITHOUT_ADDITIVES_LG"),"");
			String iv_intermittent = CommonBean.checkForNull((String)hmRecord.get("IV_DRUG_FLUID_INTERMITTENT_LG"),"");
%>
			<table cellpadding="0" cellspacing="0" width="99%" align="center" border="0" id="tblphREPMARLabelCriteria">
				<TH COLSPAN="7" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
				</tr>
					<TR>
						<td class="label" width='15%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td> 
						<td class="label" width='15%' ><select name="locn_type" id="locn_type" onChange="resetLocation()">
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>
						</td>
						<TD CLASS="label" width='15%' ><label id='lbl_locn_from' name='lbl_locn_from'><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></label></TD>
						<TD CLASS="label" width='20%' ><INPUT TYPE="text" STYLE='overflow:visible;' name="location_from" id="location_from"  disabled ><!-- maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
						<INPUT TYPE="button" CLASS="button" VALUE="?" onClick="locationLookup(location_from)">
						<input type="hidden" name="p_fm_locn_code" id="p_fm_locn_code" value=""> </TD>
						<TD CLASS="label" width='10%'  ><label id='lbl_locn_to' name='lbl_locn_to'><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></TD>
						<TD CLASS="label" width='25%' ><INPUT TYPE="text" STYLE='overflow:visible;' name="location_to" id="location_to" disabled><!-- maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
						<INPUT TYPE="button" CLASS="button" VALUE="?" onClick="locationLookup(location_to)">
						<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" value=""></td>
					</tr>
					<tr >
						<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="label"><input type=text size="18" name="p_patient_id" id="p_patient_id"  maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" onblur="Duplicatecheck();" ><INPUT TYPE="button" name="Patient_Id_Button" id="Patient_Id_Button" VALUE="?" CLASS="button" onClick="callPatientSearch(document.frmphREPMARLabelCriteria.p_patient_id)" ><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
						</td>
						<td class="label"><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></td>
						<td class="label"><input type="text" name="order_date" id="order_date"  size="10" Onblur="CheckDateT(this); " value='<%=Sysdate%>'>
							<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date');"></td>
						</td>
						<td class="label" ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
						<td class="label"><select name="order_type" id="order_type" onChange="">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="ePH.NormalRx.label" bundle="${ph_labels}"/></option>
						<option value="WA"><%=iv_with_additives%></option>
						<option value="WO"><%=iv_without_additives%></option>
						<option value="I"><%=iv_intermittent%></option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="5" align="right"> &nbsp;</td>
					<td class='button'> 
						<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()">
						<input type="button" disabled class="button" name="btnPrint" id="btnPrint" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="showReport('P')">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>

			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">  
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
			<input type="hidden" name="mar_label_print_yn" id="mar_label_print_yn" value="<%=bean.getMarLabelPrintyn()%>">
<%
			putObjectInBean(bean_id,bean,request); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>

