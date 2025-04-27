<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepRePrintDispLabelSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="frmRePrintDispLabelSheetResult" id="frmRePrintDispLabelSheetResult" >
<%
		try {
			String bean_id = "RePrintDispLabelSheetBean" ;
			String bean_name = "ePH.RePrintDispLabelSheetBean";

			RePrintDispLabelSheetBean bean = (RePrintDispLabelSheetBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);

			String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
			String disp_no = CommonBean.checkForNull(request.getParameter("disp_no"));
			String disp_stage = CommonBean.checkForNull(request.getParameter("disp_stage"));
			String disp_date = CommonBean.checkForNull(request.getParameter("disp_date"));
			String pres_practitioner_id = CommonBean.checkForNull(request.getParameter("pres_practitioner_id"));
			//String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
			//String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
			String patient_class = CommonBean.checkForNull(request.getParameter("patient_class"));
			String facility_id=(String) session.getValue( "facility_id" );
			String from = CommonBean.checkForNull(request.getParameter("from"));
			String to = CommonBean.checkForNull(request.getParameter("to"));
			String prev_pat_id="", prev_pat_name="", prev_disp_no="", prev_ord_id="", curr_pat_id, curr_pat_name, curr_disp_no, curr_ord_id;
			String report_type=CommonBean.checkForNull(request.getParameter("report_type"));//Added for Bru-HIMS-CRF-417 [IN045565] Liked INC 50453
			String noOfCpoiesDisp = "";
			if(!report_type.equals("L"))
				noOfCpoiesDisp = "display:none";
			int recCount	= 0;

			ArrayList result =null; 
			//result = bean.getResult(patient_id,locn_type,locn_code,disp_stage,disp_date,disp_no);
			result = bean.getResult(patient_id,patient_class,disp_stage,disp_date,disp_no,report_type); //modified for GHL-CRF-0627
			if( result == null || result.size()==0){
%>
				<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>
<%
			}
			else{
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" >
					<tr>
						<th>&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th>&nbsp;<fmt:message key="ePH.OrderedPractitioner.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th style='<%=noOfCpoiesDisp%>'>&nbsp;<fmt:message key="ePH.No.OfCopies.label" bundle="${ph_labels}"/>&nbsp;</th><!--Added for Bru-HIMS-CRF-417[IN045565]-->
						<th>&nbsp;<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> &nbsp;<input type="checkbox" name="chkSelectAll" id="chkSelectAll" value="" checked onClick="selectAll(this)">&nbsp;</th>
					</tr>
<%
					for( int i = 0; i < result.size(); i=i+12){
						curr_pat_id = (String)result.get(i);
						curr_pat_name=(String)result.get(i+1);
						curr_disp_no=(String)result.get(i+2);
						curr_ord_id=(String)result.get(i+4);
						if(!curr_pat_id.equals(prev_pat_id)){
							prev_pat_id=curr_pat_id;
							prev_pat_name=curr_pat_name;
						}
						else {
							curr_pat_id = "";
							curr_pat_name = "";
						}
						if(!curr_disp_no.equals(prev_disp_no))
							prev_disp_no=curr_disp_no;
						else 
							curr_disp_no = "";
						if(!curr_ord_id.equals(prev_ord_id))
							prev_ord_id=curr_ord_id;
						else 
							curr_ord_id = "";
%>
						<tr id = "row_'<%=i%>'">
							<td style="font-size=9" nowrap>&nbsp;<%=curr_pat_id%>&nbsp;</td>
							<td style="font-size=9" nowrap>&nbsp;<%=curr_pat_name%>&nbsp;</td>
							<td style="font-size=9" nowrap >&nbsp;<%=curr_disp_no%>&nbsp;
								<input type = 'hidden' id='disp_no_<%=recCount%>' value='<%=(String)result.get(i+2)%>'>
								<input type = 'hidden' id='disp_srl_no_<%=recCount%>' value='<%=(String)result.get(i+3)%>'>
							</td>
							<td style="font-size=9" nowrap >&nbsp;<%=curr_ord_id%>&nbsp;</td>			
							<td style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+7)%>&nbsp;</td>	
							<td style="font-size=9" nowrap >&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)result.get(i+8),"DMYHM","en",locale)%>&nbsp;</td>	<!-- added convertdate for SKR-SCF-1005[IN048684] -->
							<td style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+9)%>&nbsp;</td>	
							<td style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+10)%>&nbsp;</td>	
							<td style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+11)%>&nbsp;</td>	
							<td style='<%=noOfCpoiesDisp%>'>&nbsp;<input type="text" name="no_of_copies_<%=recCount%>" id="no_of_copies_<%=recCount%>" size="2" class="NUMBER" maxlength="2" onKeyPress="return allowValidNumber(this,event,2,0);  " onblur="updatenofCopies('<%=recCount%>')" oncopy="return false" onpaste="return false" value="1"></td><!--Added for Bru-HIMS-CRF-417[IN045565]-->
							<td style='text-align:center;'><input type="checkbox" name="select_<%=recCount%>" id="select_<%=recCount%>" value="" checked onClick="updateSelection('<%=(String)result.get(i+2)%>', '<%=(String)result.get(i+3)%>',this, <%=recCount%>)"> </td>
							<input type="hidden" name="curr_disp_no_<%=recCount%>" id="curr_disp_no_<%=recCount%>" value="<%=(String)result.get(i+2)%>"><!--Added for Bru-HIMS-CRF-417[IN045565]-->
						</tr>
<%
						recCount++;
					}
%>
					<script>
						parent.f_query_add_mod.document.frmRePrintDispLabelSheetCriteria.btnPrint.disabled = false;
						parent.f_query_add_mod.document.frmRePrintDispLabelSheetCriteria.viewReport.disabled = false;
					</script>
<%
				}
%>
				</table>
				<input type="hidden" name="recCount" id="recCount" value="<%=recCount%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="from" id="from" value="">
				<input type="hidden" name="to" id="to" value="">
				<input type="hidden" name="patient_id" id="patient_id" value="">
				<input type="hidden" name="order_id" id="order_id" value="">
				<input type="hidden" name="order_date_from" id="order_date_from" value="">
				<input type="hidden" name="order_date_to" id="order_date_to" value="">
				<input type="hidden" name="encounter_id" id="encounter_id" value="">
				<input type="hidden" name="pres_practitioner_id" id="pres_practitioner_id" value="">
<% 
				putObjectInBean(bean_id,bean,request);	
			}
			catch (Exception e) {
				e.printStackTrace() ;
			}
%>
		</form>
	</body>
</html>

