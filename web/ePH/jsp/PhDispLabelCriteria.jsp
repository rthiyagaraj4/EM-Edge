<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhDispLabel.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysdate();
	ArrayList localLang1 = new ArrayList();	//Code Added For FD-Bru-HIMS-CRF-074 - Start
	String newLocalLanguage ="";
	String localLang ="";
	String sDefaultLocLang = "";
	if(!locale.equals("en")){
		localLang1 = bean.getLangNameAndId(locale);
		newLocalLanguage =(String)localLang1.get(0);
		sDefaultLocLang ="selected";
	}
	else{
     	newLocalLanguage=bean.getSMLOcalLanguageID();
		localLang1 = bean.getLangNameAndId(newLocalLanguage);
		//localLang =(String)localLang1.get(1);
	}
	if(localLang1 !=null && localLang1.size()>0)
		localLang =(String)localLang1.get(1);
	//Code Added For FD-Bru-HIMS-CRF-074 - End
	String LocalLanguage=bean.getSMLOcalLanguageID();
%>


	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhDispLabelCriteria.p_patient_id.focus();"> 
		<form name="formPhDispLabelCriteria" id="formPhDispLabelCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="6" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td class="label" width="20%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width="25%" >&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onBlur="Duplicatecheck();populateDispNo()" onKeyPress="changeToUpper()"><!-- onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->	<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhDispLabelCriteria.p_patient_id)">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>
					<td  class="label" width="20%" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
					<td width="8%"><input type="text" name="p_dispense_date" id="p_dispense_date" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="if(CheckDateT(this)) populateDispNo();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_dispense_date');document.formPhDispLabelCriteria.p_dispense_date.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>    
					<td class="label" width="25%" ></td>
					<td width="20%">
					</td>
				</tr>
				<tr>
					<td class="label" nowrap><fmt:message key="Common.patientclass.label" 	bundle="${common_labels}"/></td>
				
					<td align="Left">&nbsp;&nbsp;<select name="p_pat_class" id="p_pat_class"					                             										onChange="showLabelDetail(this);setStage(this);populateDispNo();">
					<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
					<td align="Left">
						<select name="stage" id="stage" onchange="populateDispNo()">
						<option value="F"><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
						<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
						</select>

					</td>

					<!-- <td ><label class="label"style="display:none"><fmt:message key="ePH.LabelLanguage.label" bundle="${ph_labels}"/></label>&nbsp<select name="label_language" id="label_language" style="display:none">
						 <option value="E"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
						
						< <option value="L"><fmt:message key="ePH.LocalLanguage.label" bundle="${ph_labels}"/></option>  
					<!-- 	<option value="B">Both</option> -->
					<!-- </select> -->
					<!-- </td> --> 
					<td width="20%" colspan='2'>&nbsp;&nbsp;
					</td>
				</tr>
				<tr  id="lbl_dtls">
					<td class="label" id="lbl_disp_no"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td id="lst_disp_no">&nbsp;&nbsp;<select name="p_disp_no" id="p_disp_no" onChange="populateLabelNo()">
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
					</td>
					<!-- starts label -->
					<!-- Code Added For FD-Bru-HIMS-CRF-074 -Start -->
					<td colspan='2' class="label">&nbsp&nbsp;&nbsp;<label class="label"style="display:Visible"><fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;&nbsp;</label>&nbsp;<select name="label_language" id="label_language" style="display:visible" onchange="changeLanguage(this)"/> <!-- onchange="changeLanguage(this)" Added for IN031262  -->
						<option value="E"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option> 
<%
						if(localLang != null && !localLang.equals("")){
%>
							<option value="L"<%=sDefaultLocLang%>><%= localLang%></option>  
<%
						}
%>
						</select>
						</td> 
					<!-- Code Added For FD-Bru-HIMS-CRF-074 -Start -->
					<td class="label"><label style="visibility:hidden" id="lbl_fm_no"><fmt:message key="ePH.LabelNoFrom.label" bundle="${ph_labels}"/></label></td> 
					<td id="lst_fm_no">&nbsp;&nbsp;<select name="p_lbl_fm_no" id="p_lbl_fm_no" style="visibility:hidden">
					<option value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</option>
					</select>&nbsp;<label class="label" id="lbl_to_no"><fmt:message key="ePH.LabelNoTo.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;<select name="p_lbl_to_no" id="p_lbl_to_no" style="visibility:hidden">
					<option value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</option>
					</select>
					</td>
				</tr>
				<tr>
				<td></td><td></td><td></td><td></td>
					<td class="button" colspan="2" ><input type="button" class="button" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' name="print_report" id="print_report" onClick="printReports()">&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' name="view_report" onClick="viewLabels()">
					</td> 
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_disp_fm_no" id="p_disp_fm_no" value="">
			<input type="hidden" name="p_disp_to_no" id="p_disp_to_no" value="">
			<input type="hidden" name="p_patient_class" id="p_patient_class" value="IP">
			<input type="hidden" name="order_type" id="order_type" value="RX">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="label_language1" id="label_language1" VALUE="<%=LocalLanguage%>"> 
			<INPUT TYPE="hidden" name="alter_label_language" id="alter_label_language" VALUE="<%=newLocalLanguage%>"> <!-- Code Added for FD-Bru-HIMS-CRF-074 Start -->
			<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
		</form>
	</body>
	<script>
		parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
		populateDispNo();
		showLabelDetail(document.formPhDispLabelCriteria.p_pat_class);
	</script>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

