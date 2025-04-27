<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*,ePH.Common.* ,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/PhMessages.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String drug_name	= request.getParameter("drug_name");
		String from_disp    = request.getParameter("from_disp")==null?"N":request.getParameter("from_disp");
%>
		<title> <fmt:message key="ePH.RemarksFor.label" bundle="${ph_labels}"/> <%=drug_name%> </title>
	</head>
<%
	try{
		String order_id							= request.getParameter("order_id");
		String order_line_no					= request.getParameter("order_line_no");

		String bean_id							= "DispMedicationAllStages";
		String bean_name						= "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean			= (DispMedicationAllStages)getBeanObject( bean_id,bean_name, request );
		bean.setLanguageId(locale);
		
		String style_prn						= "display:none";
		String style_pres						= "display:none";
		String style_drug						= "display:none";
		String style_pharm						= "display:none";
		String style_sliding					= "display:none"; 	
		String style_verification				= "display:none"; 
		String style_nonMfrFluidRemarks			= "display:none"; 
		String style_abuse= "display:none"; //added for aakh-crf-0140
		String style_drug_indication_remarks= "display:none";//added for jd-crf-0220
		String pres_remarks						= bean.getPrescriptionInstructions(order_id);
		String drug_remarks						= bean.getDrugInstructions(order_id,order_line_no);
		String prn_remarks						= bean.getPRNInstructions(order_id,order_line_no);
		String pharm_remarks					= bean.getPharmacistInstructions(order_id,order_line_no,from_disp);
		String slidingscaleremarks		= bean.getSlidingScaleRemarks(order_id,order_line_no);
		String verificationremarks		= bean.getVerificationRemarks(order_id,order_line_no);
		String abuse_remarks=bean.getAbueRemarks(order_id, order_line_no);
		String drug_indication_remarks=bean.getdrugIntaractions(order_id,order_line_no);
    String strDrugsRemarks="";//abuse_remarks.replaceAll(" ","%20");
		strDrugsRemarks = URLDecoder.decode(abuse_remarks);
		String override_rem				= "";
		HashMap Override_remarks		= bean.getOverrideremarks(order_id,order_line_no);	
		String nonMfrFluidRemarks		= bean.getNonMFRfluidRemarks(order_id,order_line_no);
		verificationremarks				= verificationremarks.replaceAll("@@","\n");
		if(pres_remarks == null)
			pres_remarks	 = "";
		if(drug_remarks == null)
			drug_remarks	 = "";
		if(prn_remarks == null)
			prn_remarks		 = "";
		if(pharm_remarks == null)
			pharm_remarks	 = "";
		if(slidingscaleremarks == null)
			slidingscaleremarks	 = "";
		if(nonMfrFluidRemarks == null || nonMfrFluidRemarks.equals("null"))
			nonMfrFluidRemarks	 = "";
if(abuse_remarks == null){//added for aakh-crf-0140
	abuse_remarks="";
}
if(drug_indication_remarks == null){//added for jd-crf-0220
	drug_indication_remarks="";
}
		if(!pres_remarks.equals(""))
			style_pres		 = "display";
		if(!drug_remarks.equals(""))
			style_drug		 = "display";
		if(!prn_remarks.equals("")){
			style_prn		 = "display";
		}
		if(!pharm_remarks.trim().equals(""))
			style_pharm		 = "display";

		if(!slidingscaleremarks.trim().equals(""))
			style_sliding		 = "display";

		if(!nonMfrFluidRemarks.trim().equals(""))
			style_nonMfrFluidRemarks	= "display";
		
		if(!verificationremarks.trim().equals(""))
			style_verification	 = "display";
		
		if(!abuse_remarks.trim().equals(""))//added for aakh-crf-0140
			style_abuse	 = "display";
		if(!drug_indication_remarks.equals(""))
			style_drug_indication_remarks="display";
%>
		<body onMouseDown="" onKeyDown="lockKey()">
			<form name="formDrugRemarks" id="formDrugRemarks" style="max-height: 90vh; overflow: overlay;">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<th align="left" style="<%=style_pres%>"><fmt:message key="ePH.PrescriptionInstructions.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_pres%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=pres_remarks%></textarea>
						</td>
					</tr>
					<th align="left" style="<%=style_sliding%>"><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_sliding%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=slidingscaleremarks%></textarea>
						</td>
					</tr>		
 <%	
					if( (Override_remarks.containsKey("DRUG_DB_PRODUCT_ID") && Override_remarks.size()>1) ||(!Override_remarks.containsKey("DRUG_DB_PRODUCT_ID") &&Override_remarks.size()>0)){  
						if(Override_remarks.containsKey("DRUG_DB_PRODUCT_ID")){
%>
						    <th align="left" ><fmt:message key="ePH.OverrideReasons.label" bundle="${ph_labels}"/></th>
<%
						}
						else{
%>
							<th align="left" ><fmt:message key="ePH.OverrideReasons.label" bundle="${ph_labels}"/></th>
<%
						}   
						if(Override_remarks.containsKey("ALLERGY_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("ALLERGY_OVERRIDE_REASON");
							/*override_rem = java.net.URLDecoder.decode(override_rem,"UTF-8");
							override_rem = override_rem.replaceAll("%26","&");
							override_rem = override_rem.replaceAll("%40","@");
							override_rem = override_rem.replaceAll("%20"," ");*/
%>		
							<tr><td align="left" class="label"><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;
									<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<%
						}
						if(Override_remarks.containsKey("DOSAGE_LIMIT_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							/*override_rem = java.net.URLDecoder.decode(override_rem,"UTF-8");
							override_rem = override_rem.replaceAll("%26","&");
							override_rem = override_rem.replaceAll("%40","@");
							override_rem = override_rem.replaceAll("%20"," ");*/
%>

							<tr>
								<td align="left" class="label"><b><fmt:message key="ePH.DosageOverrideReason.label" bundle="${ph_labels}"/></b></td>
							</tr>
							<tr >
								<td>&nbsp;&nbsp;
									<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<%
						}
						if(Override_remarks.containsKey("DUPLICATE_DRUG_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							/*override_rem = java.net.URLDecoder.decode(override_rem,"UTF-8");
							override_rem = override_rem.replaceAll("%26","&");
							override_rem = override_rem.replaceAll("%40","@");
							override_rem = override_rem.replaceAll("%20"," ");*/ //commented for SKR-SCF-0693[Inc:36052]
							if(Override_remarks.containsKey("DRUG_DB_PRODUCT_ID")){
%>
								<tr><td  align="left" class="label"><b><fmt:message key="ePH.DuplicateTheraphyOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
<%
							}
							else{
%>
								<tr><td align="left" class="label"><b><fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
<%
							}
%>

							<tr >
								<td>&nbsp;&nbsp;<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<%
						}
							//added for MMS-KH-CRF-0029 - start
						if(Override_remarks.containsKey("INTERACTION_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("INTERACTION_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("INTERACTION_OVERRIDE_REASON");
							/*override_rem = java.net.URLDecoder.decode(override_rem,"UTF-8");
							override_rem = override_rem.replaceAll("%26","&");
							override_rem = override_rem.replaceAll("%40","@");
							override_rem = override_rem.replaceAll("%20"," ");*///commented for SKR-SCF-0693[Inc:36052]
%>
							<tr><td  align="left" class="label"><b><fmt:message key="ePH.Drug-DrugInteractionOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<% 
						}
						if(Override_remarks.containsKey("LAB_INTERACT_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("LAB_INTERACT_OVERRIDE_REASON");
							
%>
							<tr><td  align="left" class="label"><b><fmt:message key="ePH.Drug-LabInteractionOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<% 
						}
						if(Override_remarks.containsKey("FOOD_INTERACT_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("FOOD_INTERACT_OVERRIDE_REASON");
							 
%>
							<tr><td  align="left" class="label"><b><fmt:message key="ePH.Drug-FoodInteractionOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<% 
						} //added for MMS-KH-CRF-0029 - end
                if(Override_remarks.containsKey("DISEASE_INTER_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("DISEASE_INTER_OVERRIDE_REASON");
							 
%>
							<tr><td  align="left" class="label"><b><fmt:message key="ePH.Drug-DiseaseOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<% 
						}
						if(Override_remarks.containsKey("CONTRAIND_OVERRIDE_REASON")){
							override_rem = (String)Override_remarks.get("CONTRAIND_OVERRIDE_REASON")==null?"":(String)Override_remarks.get("CONTRAIND_OVERRIDE_REASON");
							/*override_rem = java.net.URLDecoder.decode(override_rem,"UTF-8");
							override_rem = override_rem.replaceAll("%26","&");
							override_rem = override_rem.replaceAll("%40","@");
							override_rem = override_rem.replaceAll("%20"," ");	*/ //commented for SKR-SCF-0693[Inc:36052]
%> 
							<tr><td  align="left" class="label"><b><fmt:message key="ePH.ContraIndicationOverrideReason.label" bundle="${ph_labels}"/></b></td></tr>
							<tr >
								<td>&nbsp;&nbsp;
									<textarea cols="120" rows=3 readOnly><%=override_rem%></textarea>
								</td>
							</tr>
<% 
						} 
					}
%>
					<th align="left" style="<%=style_drug%>"><fmt:message key="ePH.DrugInstructions.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_drug%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=drug_remarks%></textarea>
						</td>
					</tr>
					<th align="left" style="<%=style_prn%>" ><fmt:message key="ePH.PRNInstructions.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_prn%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly> <%=prn_remarks%> </textarea>
						</td>
					</tr>
					<th align="left"  style="<%=style_pharm%>"><fmt:message key="ePH.PharmacistsInstructions.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_pharm%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=pharm_remarks%></textarea>
						</td>
					</tr>
					<th align="left"  style="<%=style_verification%>"><fmt:message key="ePH.VerificationRemarks.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_verification%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=verificationremarks%></textarea>
						</td>
					</tr>
					<th align="left"  style="<%=style_nonMfrFluidRemarks%>"><fmt:message key="ePH.FluidRemarks.label" bundle="${ph_labels}"/></th>
					<tr style="<%=style_nonMfrFluidRemarks%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=nonMfrFluidRemarks%></textarea>
						</td>
					</tr>
					<!-- added for aakh-crf-0140 start -->
					<th align="left"  style="<%=style_abuse%>">Drug Abuse Remarks</th>
					<tr style="<%=style_abuse%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=strDrugsRemarks%></textarea>
						</td>
					</tr>
					<!-- added for aakh-crf-0140 end -->
					<!-- added for jd-crf-0220 start --> 
					<th align="left"  style="<%=style_drug_indication_remarks%>">Drug Indications</th>
					<tr style="<%=style_drug_indication_remarks%>">
						<td>&nbsp;&nbsp;
							<textarea cols="120" rows=3 readOnly><%=drug_indication_remarks%></textarea>
						</td>
					</tr>
					
					<!-- added for jd-crf-0220 end -->
				</table>
			</form>
			<table width="99%">
				<tr>
				  <td align="right">
				  	<input type="button" name="btnClose" id="btnClose" value="Close" class="button" onClick="window.close(); ">			
				  </td>
				</tr>		
			</table>
		</body >
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e){
		e.printStackTrace();
	}
%>
</html>

