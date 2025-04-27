<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String title = request.getParameter("title")==null?"":request.getParameter("title");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><%=title%></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="DispMedicationFillingRemarks" id="DispMedicationFillingRemarks" >
			<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
<%
			String called_frm			=   request.getParameter("called_frm")==null?"OK":request.getParameter("called_frm");
			if(called_frm.equals("VIEW")){ //view from patient drig profile
				String allocate_finding		=	request.getParameter("allocate_remarks")==null?"":request.getParameter("allocate_remarks");
				String fill_finding			=	request.getParameter("fill_remarks")==null?"":request.getParameter("fill_remarks");
				String delivery_finding		=   request.getParameter("delivery_remarks")==null?"":request.getParameter("delivery_remarks");				
				String allocate_remarks_code	=	request.getParameter("allocate_remarks_code")==null?"":request.getParameter("allocate_remarks_code");
				String fill_remarks_code		=	request.getParameter("fill_remarks_code")==null?"":request.getParameter("fill_remarks_code");
				String delivery_remarks_code		=	request.getParameter("delivery_remarks_code")==null?"":request.getParameter("delivery_remarks_code");
				String verify_remarks =	request.getParameter("verify_remarks")==null?"":request.getParameter("verify_remarks"); //Added for ML-MMOH-SCF-0327 [IN:058772] -start
				if(!verify_remarks.equals("")){ //if block Added for ML-MMOH-SCF-0327 [IN:058772]
					verify_remarks=verify_remarks.replaceAll(" ","%20");
					verify_remarks=	java.net.URLEncoder.encode(verify_remarks,"UTF-8");
					verify_remarks=verify_remarks.replaceAll("%2520","%20");
				}
				if(!verify_remarks.equals("")) { //Added for ML-MMOH-SCF-0327 [IN:058772] 
%>
					<th align="left"><fmt:message key="ePH.VerificationRemarks.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" id='verify_remarks' ></td>						
					</tr>
					<script>
						var verify_remark = decodeURIComponent('<%=verify_remarks%>','UTF-8');
						document.getElementById("verify_remarks").innerText = verify_remark ;
					</script>
<%
				} //Added for ML-MMOH-SCF-0327 [IN:058772] end
				if(!allocate_finding.equals("")) { 
%>
					<th align="left"><fmt:message key="ePH.AllocateStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=allocate_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="50" rows="3"  readonly > <%=allocate_finding%></textarea>
						</td>						
					</tr>
<% 
				}
				if(!fill_finding.equals("")) { 
%>
					<th align="left"><fmt:message key="ePH.FillingStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=fill_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="50" rows="3"  readonly > <%=fill_finding%></textarea>
						</td>						
					</tr>
<% 
				}
				if(!delivery_finding.equals("")) { 
%>
					<th align="left"><fmt:message key="ePH.DeliveryStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=delivery_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="50" rows="3"  readonly > <%=delivery_finding%></textarea>
						</td>						
					</tr>
<% 
				}
%>	
				<tr> 
					<td class='button'  align="center"><br>
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
<%
			}
			else{
				String reason_code			=	"";
				String reason_desc			=	"";
				String chk_field			=   "";
				String recno				=	request.getParameter("recno");
				String drug_code			=	request.getParameter("drug_code");
				String order_line_no		=	request.getParameter("order_line_no");
				String order_id				=	request.getParameter("order_id");
				String chk					=	(request.getParameter("chk")).trim();
				String bean_id_1			=	"";
				String bean_name_1			=	"";
				String patient_id			=	request.getParameter("patient_id");
				String encounter_id			=	request.getParameter("encounter_id");
				title				=	"";
				if(chk.equals("O")){     
					//title	= "Amend Reason";
					title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AmendReason.label","ph_labels");
				}
				else{
					//title	= "Findings";
					title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Findings.label","common_labels");
				}

				if(chk.equals("F") )
					chk_field	= "F";
				else if(chk.equals("D"))
					chk_field	= "D";
				else if(chk.equals("A"))
					chk_field	= "A";
				else if(chk.equals("O"))
					chk_field	= "O";
				else if(chk.equals("C")){
					chk_field	= "C";
				}
				else if(chk.equals("N")){
					chk_field	= "N";
				}

				String	bean_id				=	"DispMedicationAllStages" ;
				String	bean_name			=	"ePH.DispMedicationAllStages";
				ArrayList fill				=	new ArrayList();
				ArrayList fill_data			=	new ArrayList();

				DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
				bean.setLanguageId(locale);

				bean_id_1						= "@PrescriptionBean_1"+patient_id+encounter_id;
				bean_name_1						= "ePH.PrescriptionBean_1";
				PrescriptionBean_1 bean_1		= (PrescriptionBean_1)getBeanObject( bean_id_1, bean_name_1, request );
				//bean_1.setLanguageId(locale);
				boolean flag = false, reason_flag = false; //code added for ML-BRU-SCF-0971[IN042220]--Start	
				String	bean_id1			=	"DispMedicationBean" ;
				String	bean_name1			=	"ePH.DispMedicationBean";
				DispMedicationBean bean1 = (DispMedicationBean)getBeanObject( bean_id1, bean_name1, request);//code added for ML-BRU-SCF-0971[IN042220] --End		
				if(chk.equals("F")){
					fill			=	bean.loadFillRemarks(chk_field);
					fill_data		=	bean.getFillReason(order_id+"_"+order_line_no);
				}
				else if(chk.equals("D")){
					fill			=	bean.loadFillRemarks(chk_field);
					fill_data		=	bean.getDeliveryFillReason(order_id+"_"+order_line_no);
				}
				else if(chk.equals("A")){
					fill			=	bean.loadFillRemarks(chk_field);
					fill_data		=	bean.getAllocateFillReason(order_id+"_"+order_line_no);
				}
				else if(chk.equals("O")){
					fill			=	bean.loadFillRemarks(chk_field);
					fill_data		=	bean_1.getAmendReason(order_id+"_"+order_line_no);
				}
				else if(chk.equals("C")){
					fill			=	bean.loadFillRemarks(chk_field);
				}
				else if(chk.equals("N")){
					fill			=	bean.loadFillRemarks(chk_field);
				}

				String		fill_remarks	= "";
				String		reason			= "";
				if( chk.equals("A") || chk.equals("F") || chk.equals("D") ){ //code added for ML-BRU-SCF-0971[IN042220]-- Start
					if(fill_data == null || fill_data.contains("") ){ 
						fill_data		=	bean1.getFillReasons(order_id+"_"+order_line_no);
						flag = true;			
					 }
				 }	
				if(fill_data != null && fill_data.size() > 0){//code added for ML-BRU-SCF-0971[IN042220] --Start
					if(flag){
						reason			=	((String)fill_data.get(0)).trim();
						fill_remarks	=   ((String)fill_data.get(1)).trim();
					}
					else{//code added for ML-BRU-SCF-0971[IN042220]--End
						reason			=	((String)fill_data.get(1)).trim();
						fill_remarks	=   ((String)fill_data.get(2)).trim();
					}		
				}//code added for ML-BRU-SCF-0971[IN042220]   
%>
				<tr>
					<td  class="label"><%=title%>&nbsp;&nbsp;</td>
					<td >&nbsp;&nbsp;<select name="reason" id="reason" onChange="setFocusRem(DispMedicationFillingRemarks);setAmendRemarks(DispMedicationFillingRemarks)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
					for(int i=0; i<fill.size(); i+=2) {
						reason_code	=	(String)fill.get(i);
						reason_desc	=	(String)fill.get(i+1); 
						if( (reason_code).equals(reason) ){
							if(flag)//code added for ML-BRU-SCF-0971[IN042220]
								reason_flag = true;//code added for ML-BRU-SCF-0971[IN042220]
%>
							<option value="<%=reason_code%>" selected><%=reason_desc%></option>
<%
						}
						else{
%>
							<option value="<%=reason_code%>" ><%=reason_desc%></option> 
<%
						}
					}
					if(flag && !reason_flag)//code added for ML-BRU-SCF-0971[IN042220]
						fill_remarks ="";//code added for ML-BRU-SCF-0971[IN042220]
%>
					</select>
					<img src="../../eCommon/images/mandatory.gif" >
					</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td >&nbsp;&nbsp;<textarea rows="7" cols="40" name="remarks" maxLength="500"  onKeyPress="return(parent.parent.ChkMaxLen('Remarks',this,500));" ><%=fill_remarks%></textarea><img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
				<tr>
<%
					if(chk!=null && (chk.equals("C")||chk.equals("N"))){
%>
						<td  colspan='2'>
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="callDiscCancel('<%=order_id%>','<%=order_line_no%>',DispMedicationFillingRemarks,'<%=chk%>','<%=called_frm%>');window.returnValue='<%=called_frm%>'">
						<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button"  onClick="window.close();">
						</td>
<%
					}
					else{
%>
						<td  colspan='2'>
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button"  onClick="callFillVal(DispMedicationFillingRemarks);parent.window.retVal='OK'">

<%
						if(chk.equals("O")){
%>
							<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button"  onClick="callAmendReason(DispMedicationFillingRemarks);parent.window.close();">
<%
						}
						else{
%>
							<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button"  onClick="callCancelFillVal(DispMedicationFillingRemarks);">
<%
						}
					}
%>
					</td>
				</tr>
				<input type="hidden" name="recno" id="recno" value="<%=recno%>">
				<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
				<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
				<input type="hidden" name="chk" id="chk"		 value="<%=chk%>" >
				<input type="hidden" name="patient_id" id="patient_id"		 value="<%=patient_id%>" >
				<input type="hidden" name="encounter_id" id="encounter_id"		 value="<%=encounter_id%>" >
				<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id_1%>">
				<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name_1%>">
<%
				putObjectInBean(bean_id,bean,request);
			}
%>
			</table>

		</form>
	</body>
</html>

