<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhDispSheet.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	//Added for GHL-CRF-0627 - Start
	Connection con			= null;
	boolean disp_sheet = false;
	try {	
		con				= ConnectionManager.getConnection(request);
		disp_sheet = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_SHEET_CHECK");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally{ 	
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
	//Added for GHL-CRF-0627 - End
	
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysdate();
	String display_doc_no = bean.getDocNoDisplay();//code added for GHL-CRF-0323[IN:040527] 
	String display_doc_no_mc = bean.getDocNoForMc();//added  for GHL-SCF-1069 [IN:060605]
	String dispDocNo = "display:none", dispPatientMand="display:inline";//added for AMS-CRF-0079 [IN:050762] -start
	String dispDocNoSelect = "display:none";
	if(display_doc_no_mc.equals("Y")){//added if condition  DISP_DOC_NO_MC for GHL-SCF-1069 [IN:060605]
		dispDocNoSelect="display:inline";
		
	}else if(display_doc_no.equals("Y")){
		dispDocNo="display:inline";
		dispPatientMand="display:none";
	}//added for AMS-CRF-0079 [IN:050762] -end
	
	//Added for GHL-CRF-0627 - Start
	String dispense_sheet="N";
	if(disp_sheet==true)
	{
		dispense_sheet="Y";
	}
	//Added for GHL-CRF-0627 - End
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhDispSheetCriteria.p_patient_id.focus()"> 
						
		<form name="formPhDispSheetCriteria" id="formPhDispSheetCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
				<TH COLSPAN="6" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr><td colspan='6'>&nbsp;</td></tr>
				<tr>
					<td class="label" width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="feild" width='15%'><input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onBlur="Duplicatecheck();populateDispNo()" onKeyPress="changeToUpper()"><!-- onblur="Duplicatecheck();"   added for ML-BRU-SCF-0621[IN036565]-->
					<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhDispSheetCriteria.p_patient_id)">&nbsp;<img  src="../../eCommon/images/mandatory.gif" style='<%=dispPatientMand%>'></td>
					<%if((display_doc_no.equals("Y")&&!display_doc_no_mc.equals("Y"))||(display_doc_no.equals("N")&&display_doc_no_mc.equals("N"))){//added if condition and DISP_DOC_NO_MC for GHL-SCF-1069 [IN:060605] %>
					<td  class="label" width='15%' style='<%=dispDocNo%>'><!-- code added for GHL-CRF-0323[IN:040527]  --> 
						<fmt:message key="Common.documentno.label"	bundle="${common_labels}" />&nbsp; 
					</td>
					<td class="feild"  width='15%' style='<%=dispDocNo%>'><INPUT TYPE="text" name="p_doc_no" id="p_doc_no" VALUE="" maxlength='8' onKeyPress="return(ChkNumberInput(this,event,'0'))" onchange='validateDocNo(this);'>
						</select> <!--  code added for GHL-CRF-0323[IN:040527] --End changed to text box for //added for AMS-CRF-0079 [IN:050762]  -->
					</td>
					<%} %>
					<td class="label" width='15%'><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
					<td class="feild" width='10%'><input type="text" name="p_dispense_date" id="p_dispense_date" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="if(CheckDateT(this)) populateDispNo();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_dispense_date');document.formPhDispSheetCriteria.p_dispense_date.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td> 
				</tr>
				<tr><td colspan='6'>&nbsp;</td></tr>
				<tr>
					<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class="feild">
						<select name="p_pat_class" id="p_pat_class" onChange="setStage(this);populateDispNo(); ">
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<%if(disp_sheet){//if condtion added for skr-scf-1696
								%>
							<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option> <!--added for GHL-CRF-0627.2-->
							<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option><!--added for GHL-CRF-0627.2-->
							<%} %>
							<option value="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class="label"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
					<td class="feild" width='10%'>
						<select name="stage" id="stage" onChange="populateDispNo()">
							<option value="F"><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
							<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
					<td class="label"  width='10%'>
						<fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}" />
					</td>
					<td class="feild"  width='10%'>
						<select name="p_disp_no" id="p_disp_no" >
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />---&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<!-- value="All" removed for [IN:035576]--> <!-- code added for GHL-CRF-0323[IN:040527]--Start -->
						</select> 
					</td>
					<%if(display_doc_no_mc.equals("Y")){ //added if condition and DISP_DOC_NO_MC for GHL-SCF-1069 [IN:060605]%>
					<td  class="label"  width='10%'><!-- code added for GHL-CRF-0323[IN:040527]  --> 
						<label class="label" style='<%=dispDocNoSelect%>'><fmt:message key="Common.documentno.label"	bundle="${common_labels}" /></label>&nbsp; 
					</td>
					<td class="feild">
						<select name="p_doc_no" id="p_doc_no"  style='<%=dispDocNoSelect%>'>
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />---&nbsp;&nbsp;&nbsp;&nbsp;</option>	
						</select> <!--  code added for GHL-CRF-0323[IN:040527] --End -->
					</td>
					<%} %>
				</tr> 
			</table>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRDISSH">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_disp_fm_no" id="p_disp_fm_no" value="">
			<input type="hidden" name="p_disp_to_no" id="p_disp_to_no" value="">
			<input type="hidden" name="p_patient_class" id="p_patient_class" >
			<input type="hidden" name="order_type" id="order_type" value="RX">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
			<INPUT TYPE="hidden" name="p_reprint_yn" id="p_reprint_yn" VALUE="Y">
			<INPUT TYPE="hidden" name="P2MULDISP" id="P2MULDISP" VALUE=""><!-- added for SKR-SCF-1278-->
			<INPUT TYPE="hidden" name="disp_nos" id="disp_nos" VALUE=""><!-- added for SKR-SCF-1278-->
			<INPUT TYPE="hidden" name="sys_date" id="sys_date" VALUE="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>"> <!--  added for AMRI-SCF-0453 -->
			<INPUT TYPE="hidden" name="p_disp_sheet" id="p_disp_sheet" VALUE="<%=dispense_sheet%>"> <!-- Added for GHL-CRF-0627 -->
			<INPUT TYPE="hidden" name="display_doc_no" id="display_doc_no" VALUE="<%=display_doc_no_mc%>"> <!-- code added for GHL-CRF-0323[IN:040527] changed to   display_doc_no_mc from display_doc_no for GHL-SCF-1069 [IN:060605]  -->
		</form>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

