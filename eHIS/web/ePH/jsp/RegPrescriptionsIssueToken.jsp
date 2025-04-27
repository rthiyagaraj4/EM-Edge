<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>
			<fmt:message key="ePH.IssueToken.label" bundle="${ph_labels}"/>
		</title>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
		<form name="regprescriptionsissuetokenfooter" id="regprescriptionsissuetokenfooter" >
<%
		try{
			String	mode			=	CommonRepository.getCommonKeyValue("MODE_MODIFY");
			String	bean_id			=	"RegPrescriptionsBean" ;
			String	bean_name		=	"ePH.RegPrescriptionsBean";
			
			/* Initialize Function specific start */
			RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
			//bean.setLanguageId(locale);

			ArrayList result = bean.getNationalityDetails();
			
			String disp_locn_code		=	request.getParameter("disp_locn_code");
			String patient_id			=	request.getParameter("patient_id");
			String patient_name			=	request.getParameter("patient_name");

			patient_name                = java.net.URLDecoder.decode(patient_name,"UTF-8");
			String gender				=	request.getParameter("gender");
			String sex					=	request.getParameter("sex");
			String encounter_id			=	request.getParameter("encounter_id");
			String nationality			=	request.getParameter("nationality");
			String nationalityDesc		=	request.getParameter("nationalityDesc");
			String orders_selected		=	request.getParameter("orders_selected");
			String order_id				=	request.getParameter("order_id");
			String print_pres			=	request.getParameter("print_pres");
			String print_pres_orders	=	request.getParameter("print_pres_orders");
			String token_series_desc    =   "";
			String token_series_code    =   "";
			String generatetokenyn      =   "Y";
			String disp					=   "Style=Display:none";
			ArrayList genTokenDtls = null;
			String QMS_required_yn="", QMS_edit_token_yn="";

			ArrayList result1 = null;
			if (patient_name!=null){
				result1 = bean.getTokenDetails(patient_id.trim(),disp_locn_code.trim(),gender.trim(),nationality.trim());	
			}
			String defTokenSeries= bean.getDefaultTokenSeries();
			String hidedisp="Style=Display:none";	//Added for Bru-HIMS-CRF-142 [IN:030195] - Start
			String facility_id          = (String)session.getValue( "facility_id" );	
			ArrayList patarrv = bean.getPatientArrivalDet(facility_id,disp_locn_code.trim());
			String mark_patient_arrive_yn = (String)patarrv.get(0);
			String generate_actual_token_yn =  (String)patarrv.get(1); //Added for Bru-HIMS-CRF-142 [IN:030195] -End
			if(mark_patient_arrive_yn.equals("Y")){
                hidedisp="Style=Display";
			}	
%>
			<table cellpadding="2" cellspacing="0"  align="left" border="0" width="100%" id="regPrescriptionsIssueTokentable">
				<tr>
					<td colspan="2">
						<table>
							<tr>
								<td class="label"  nowrap width="50%"><fmt:message key="ePH.PatientCollectingMedication.label" bundle="${ph_labels}"/></td>
								<td  width="50%">&nbsp;<input type="checkbox" name="pat_coll_med" id="pat_coll_med"   onClick="clearIssueTokenForNonPatient(this)" checked value="E"></td>		
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th style="font-size:xx-small"  colspan="2"><fmt:message key="ePH.MedicationCollectorDetails.label" bundle="${ph_labels}"/></th>
				</tr>
				<tr height="10%">
					<td class="label" nowrap width="20%" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td  width="80%" >&nbsp;<label id="lbl_med_pat_name" class="label"><B><%=patient_name%></B></label><input type="text" name="med_pat_name" id="med_pat_name" value="" size="40" style="display:none" maxlength="40">&nbsp;<img src="../../eCommon/images/mandatory.gif"  id="mand_img_name" style="visibility:hidden"></img></td>
				</tr>
				<tr height="10%">
					<td class="label"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td > &nbsp;<label id="lbl_med_pat_gender" class="label"><B><%=gender%></B></label><select name="med_pat_gender" id="med_pat_gender" style="display:none" onChange="assignTokenSeriesDetailsForNonPatient()"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="M" ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value="F" ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="B" ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option></select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  id="mand_img_gender" style="visibility:hidden"></img></td>
				</tr>
				<tr height="10%">
					<td class="label"  nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;<label id="lbl_med_pat_nationality_code" class="label" style="display:none"><%=nationality%></label>
					<label id="lbl_med_pat_nationality" class="label" ><B><%=nationalityDesc%></B></label>
					<select name="med_pat_nationality" id="med_pat_nationality" style="display:none" onChange="assignTokenSeriesDetailsForNonPatient()">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						for (int i=0;i<result.size();i++){
%>
							<option value="<%=result.get(i)%>"><%=result.get(++i)%></option>
<%
						}
%>
					</select>&nbsp;
					<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_nationality" style="visibility:hidden"></img>
					</td>
				</tr>	
		
				<tr height="10%" id="pat_arriv" <%=hidedisp%>>	<!--  Added for Bru-HIMS-CRF-142 [IN:030195] - start-->	
					<td class="label" align="right" nowrap><fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td align="left"><input type="checkbox" name="patient_arrived" id="patient_arrived" checked value="Y" 
					onclick="ChkPatArrival();"></td>
				</tr>	<!-- Added for Bru-HIMS-CRF-142 [IN:030195] - End -->
			
				<tr height="10%">
					<td class="label"  nowrap ><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td  class="label" >
					<select name="token_series_code" id="token_series_code" onChange="" style="display:none"></select>
					<select name="token_series_code_for_patient" id="token_series_code_for_patient" onChange="assignSelTokenSeriesForPatient(this);ChkPatArrival();" >				
<%
					if(result1 ==null || result1.size()<2){
%>
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
					}
					if(result1 !=null && result1.size()>2){
						token_series_code = (String)result1.get(0);
						token_series_desc = (String)result1.get(1);
						for (int i=0;i<result1.size();i=i+3){
							if(defTokenSeries.equals((String)result1.get(i))){
								token_series_code = (String)result1.get(i);
								token_series_desc = (String)result1.get(i+1);
%>
								<option value="<%=result1.get(i)%>" selected><%=result1.get(i+1)%></option>
<%
							}
							else{
%>
								<option value="<%=result1.get(i)%>"><%=result1.get(i+1)%></option>
<%
							}
						}
					}
%>
					</select>				
					</td>
				</tr>
<%
				String QMSiconDisp = "", QMS_edit="";
				if(!token_series_code.equals("")){
					genTokenDtls=bean.getGenerateTokenYN(disp_locn_code,token_series_code);	
					if(genTokenDtls!=null && genTokenDtls.size()>2){
						generatetokenyn = (String)genTokenDtls.get(0);
						QMS_required_yn = (String)genTokenDtls.get(1);
						QMS_edit_token_yn = (String)genTokenDtls.get(2);
					}
					if(generatetokenyn.equals("N")){
						disp="Style=Display";
					}
					if(!QMS_required_yn.equals("Y"))
						QMSiconDisp="display:none;";
					if(!QMS_edit_token_yn.equals("Y"))
						QMS_edit="readOnly";
					if(generatetokenyn.equals("N") && !(QMS_required_yn.equals("Y") || QMS_edit_token_yn.equals("Y")))
                        QMS_edit="";
				}	 
%>
				 <tr height="10%" id="gen_token"  <%=disp%>>
					<td class="label"  nowrap ><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td >&nbsp;<INPUT TYPE="text" name="token_no" id="token_no" SIZE="6" MAXLENGTH="6"  onkeyPress='return allowValidNumber(this,event,6,0)' oncopy="return false" onpaste="return false" class="NUMBER" <%=QMS_edit%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" onblur=''></img>
					&nbsp;
					<img src="../../ePH/images/GenerateToken.png" align="center" title='Generate QMS Token' style='<%=QMSiconDisp%>' id='QMS_gen_token' onclick='getQMSToken();'></img>
					</td>
				</tr> 

				<tr height="10%">
					<td class="label"  nowrap><fmt:message key="ePH.PrintToken.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td ><input type="checkbox" name="print_token_series" id="print_token_series" ></td>
				</tr>
				<tr>
					<td colspan="2"  align="right">
<%
						if(!QMS_required_yn.equals("Y")){
%>

							<input type="button" name="btnGenerateToken" id="btnGenerateToken" value='<fmt:message key="ePH.GenerateToken.label" bundle="${ph_labels}"/> ' class="button" onClick="generateToken()" >
<%
						}
						else{
%>
							<input type="button" name="btnGenerateToken" id="btnGenerateToken" value='<fmt:message key="Common.Register.label" bundle="${common_labels}"/> ' class="button" onClick="generateToken()" >
<%
						}
%>
					&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="patient_name" id="patient_name" value="<%=java.net.URLEncoder.encode(patient_name,"UTF-8")%>">
			<input type="hidden" name="gender" id="gender" value="<%=sex%>">
			<input type="hidden" name="nationality" id="nationality" value="<%=nationality%>">
			<input type="hidden" name="hidden_token_series_desc" id="hidden_token_series_desc" value="<%=token_series_desc%>">
			<input type="hidden" name="hidden_token_series_code" id="hidden_token_series_code" value="<%=token_series_code%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="orders_selected" id="orders_selected" value="<%=orders_selected%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="print_pres" id="print_pres" value="<%=print_pres%>">
			<input type="hidden" name="gen_token_yn" id="gen_token_yn" value="<%=generatetokenyn%>">
			<input type="hidden" name="print_pres_orders" id="print_pres_orders" value="<%=print_pres_orders%>">
			<input type="hidden" name="QMS_required_yn" id="QMS_required_yn" value="<%=QMS_required_yn%>">
			<input type="hidden" name="QMS_edit_token_yn" id="QMS_edit_token_yn" value="<%=QMS_edit_token_yn%>">
			<input type="hidden" name="generate_actual_token_yn" id="generate_actual_token_yn" value="<%=generate_actual_token_yn%>">
		</form>
<%
		// putObjectInBean(bean_id,bean,request); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	</body>
</html>

