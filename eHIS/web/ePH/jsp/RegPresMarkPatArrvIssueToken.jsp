<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %> <!-- // charset=UTF-8 Added for TTM-SCF-0170-->
<%-- JSP Page specific attributes end --%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title>
			<fmt:message key="ePH.IssueToken.label" bundle="${ph_labels}"/>
		</title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%      request.setCharacterEncoding("UTF-8"); // Added for TTM-SCF-0170
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
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
			String	mode			=	CommonRepository.getCommonKeyValue("MODE_MODIFY");
			String	bean_id			=	"RegPrescriptionsBean" ;
			String	bean_name		=	"ePH.RegPrescriptionsBean";
			
			/* Initialize Function specific start */
			RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
			ArrayList result = bean.getNationalityDetails();
			
			String facility_id          = (String)session.getValue( "facility_id" );
			String disp_locn_code		=	request.getParameter("disp_locn_code");
			String patient_id			=	request.getParameter("patient_id");
			String patient_name			=	request.getParameter("patient_name");
			String gender				=	request.getParameter("gender");
			String len	=	request.getParameter("len");
			String nationality			=	request.getParameter("nationality");
			String nationality_code		=	request.getParameter("nationality_code");
			//String orders_selected		=	request.getParameter("orders_selected");
			//String order_id				=	request.getParameter("order_id");
			String print_pres			=	"N";
			String print_pres_orders	=	"";
			String actualtoken	=	"";

			String token_series_desc = "";
			String token_series_code = "";
			ArrayList generatetokenyn1   = null;
			String generatetokenyn   = null;
			String disp="Style=Display:none";
			//String hidedisp="Style=Display:none";
			ArrayList result1 = null;
			if (patient_name!=null){
				result1 = bean.getTokenDetails(patient_id.trim(),disp_locn_code.trim(),gender.trim(),nationality_code.trim());	
			}
			String defTokenSeries= bean.getDefaultTokenSeries();
			ArrayList patarrv = null;
			patarrv = bean.getPatientArrivalDet(facility_id,disp_locn_code.trim());
			String generate_actual_token_yn =  (String)patarrv.get(1);
			if(generate_actual_token_yn.equals("Y")){
				actualtoken = bean.getActualToken(patient_id);
			}
%>
			<table cellpadding="0" cellspacing="0"  align="left" border="0" width="103%" id="regPrescriptionsIssueTokentable">
				<tr>
					<td colspan="2">
						<table>
							<tr>
								<td class="label" align="right" nowrap width="50%"><fmt:message key="ePH.PatientCollectingMedication.label" bundle="${ph_labels}"/></td>
								<td align="left" width="50%">&nbsp;<input type="checkbox" name="pat_coll_med" id="pat_coll_med"   onClick="clearIssueTokenForNonPatient(this)" checked value="E"></td>		
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th style="font-size:xx-small" align="left" colspan="2"><fmt:message key="ePH.MedicationCollectorDetails.label" bundle="${ph_labels}"/></th>
				</tr>
				<tr height="10%">
					<td class="label" align="right" nowrap width="20%" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td align="left" width="80%" >&nbsp;<label id="lbl_med_pat_name" class="label"><B><%=patient_name%></B></label><input type="text" name="med_pat_name" id="med_pat_name" value="" size="40" style="display:none" maxlength="40">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_name" style="visibility:hidden"></img></td>
				</tr>
				<tr height="10%">
					<td class="label" align="right" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td align="left"> &nbsp;<label id="lbl_med_pat_gender" class="label"><B><%=gender%></B></label><select name="med_pat_gender" id="med_pat_gender" style="display:none" onChange="assignTokenSeriesDetailsForNonPatient()"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="M" ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value="F" ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="B" ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_gender" style="visibility:hidden"></img></td>
				</tr>
				<tr height="10%">
					<td class="label" align="right" nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
					<td align="left" >&nbsp;<label id="lbl_med_pat_nationality_code" class="label" style="display:none"><%=nationality_code%></label><label id="lbl_med_pat_nationality" class="label" ><B><%=nationality%></B></label><select name="med_pat_nationality" id="med_pat_nationality" style="display:none" onChange="assignTokenSeriesDetailsForNonPatient()">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						for (int i=0;i<result.size();i++){
%>
							<option value="<%=result.get(i)%>"><%=result.get(++i)%></option>
<%
						}
%>
						</select>&nbsp;
						<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_nationality" style="visibility:hidden"></img></td>
					</tr>	
					<tr height="10%">
						<td class="label" align="right" nowrap ><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/>&nbsp;</td>
						<td align="left" class="label" ><select name="token_series_code" id="token_series_code" onChange="" style="display:none">
							</select><select name="token_series_code_for_patient" id="token_series_code_for_patient" onChange="assignSelTokenSeriesForPatient(this);disabletoken();" >				
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
										<option value="<%=result1.get(i)%>"><%=result1.get(i+1)%></option>
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
					if(!token_series_code.equals("")){
						 generatetokenyn1=bean.getGenerateTokenYN(disp_locn_code,token_series_code);
						 generatetokenyn=(String)generatetokenyn1.get(0);
						 if(generatetokenyn.equals("N")){
							disp="Style=Display:display";
						 }
					}	 
%>
					 <tr height="10%" id="gen_token" name="gen_token"  <%=disp%>>
						<td class="label" align="right" nowrap ><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/>&nbsp;</td>
						<td class="label" align="left"><INPUT TYPE="text" name="token_no" id="token_no" SIZE="4" MAXLENGTH="4"  onkeyPress='return allowValidNumber(this,event,4,0)' class="NUMBER" value="">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" ></img></td>
					</tr> 
					<tr height="10%">
						<td class="label" nowrap><fmt:message key="ePH.PrintToken.label" bundle="${ph_labels}"/></td>
						<td class="label" ><input type="checkbox" name="print_token_series" id="print_token_series" ></td>
					</tr>
					
					<tr>
						<td colspan="2" align="right">
							<table>
								<tr >
									<td align="right" colspan="2"><input type="button" name="btnGenerateToken" id="btnGenerateToken" value="Generate Token" class="button" onClick="generateTokenonPatArrival()" >&nbsp;&nbsp;&nbsp;</td>
								</tr>
							</table>
						</td>
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
				<input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>">
				<input type="hidden" name="gender" id="gender" value="<%=gender%>">
				<input type="hidden" name="nationality_code" id="nationality_code" value="<%=nationality_code%>">
				<input type="hidden" name="hidden_token_series_desc" id="hidden_token_series_desc" value="<%=token_series_desc%>">
				<input type="hidden" name="hidden_token_series_code" id="hidden_token_series_code" value="<%=token_series_code%>">
				<input type="hidden" name="gen_token_yn" id="gen_token_yn" value="<%=generatetokenyn%>">
				<input type="hidden" name="print_pres_orders" id="print_pres_orders" value="<%=print_pres_orders%>">
				<input type="hidden" name="print_pres" id="print_pres" value="<%=print_pres%>">
				<input type="hidden" name="generate_actual_token_yn" id="generate_actual_token_yn" value="<%=generate_actual_token_yn%>">
				<input type="hidden" name="actualtoken" id="actualtoken" value="<%=actualtoken%>">
				<input type="hidden" name="flagval" id="flagval" value="patarrival">
				<input type="hidden" name="len" id="len" value="<%=len%>">
				<input type="hidden" name="patient_arrived" id="patient_arrived" value="Y">
			</form>
			<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>
<script language="Javascript">
	function disabletoken(){
<%
	if(generate_actual_token_yn.equals("Y")){
%>
		if(document.getElementById("gen_token").style.display=="display"){
			document.regprescriptionsissuetokenfooter.token_no.disabled=true;
			document.regprescriptionsissuetokenfooter.token_no.value=document.regprescriptionsissuetokenfooter.actualtoken.value;
		}
<%
		}
%>
	}
</script>

