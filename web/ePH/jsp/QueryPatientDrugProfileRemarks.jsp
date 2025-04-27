<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		String called_frm     = request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
		if(called_frm == null || called_frm.equals("")){
%>
			<title> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </title>
<%
		}
		else{
%>
			<title> <fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/> </title>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		}
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String order_id				= request.getParameter("order_id");
	String order_line_num		= request.getParameter("order_line_num");
	String sr_no				= request.getParameter("sr_no")==null?"":request.getParameter("sr_no");
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String line_status			= request.getParameter("line_status")==null?"":request.getParameter("line_status");
	String split_dos_yn			= request.getParameter("split_dose_yn")==null?"":request.getParameter("split_dose_yn");
	String sliding_scale_yn     = request.getParameter("sliding_scale_yn")==null?"N":request.getParameter("sliding_scale_yn");
	/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
	String amended_by_id			= request.getParameter("amended_by_id")==null?"":request.getParameter("amended_by_id");
	String amended_date			= request.getParameter("amended_date")==null?"":request.getParameter("amended_date");
	String amend_remarks		= request.getParameter("amend_reason")==null?"":request.getParameter("amend_reason");
	String amend_reason_code	= request.getParameter("amend_reason_code")==null?"":request.getParameter("amend_reason_code");
	/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
	String allocate_finding		= request.getParameter("allocate_finding")==null?"":request.getParameter("allocate_finding");//code added for ML-BRU-SCF-0971[IN042220] --Start
	String fill_finding			= request.getParameter("fill_finding")==null?"":request.getParameter("fill_finding");
	String delivery_finding		= request.getParameter("delivery_finding")==null?"":request.getParameter("delivery_finding");
	String allocate_remarks_code	=	request.getParameter("allocate_remarks_code")==null?"":request.getParameter("allocate_remarks_code");
	String fill_remarks_code		=	request.getParameter("fill_remarks_code")==null?"":request.getParameter("fill_remarks_code");
	String delivery_remarks_code	=	request.getParameter("delivery_remarks_code")==null?"":request.getParameter("delivery_remarks_code");
	String ref_sent_remarks  =	request.getParameter("ref_sent_remarks")==null?"":request.getParameter("ref_sent_remarks");//Added for HSA-CRF-0155 [IN048487]
	String verify_remarks	 =	request.getParameter("verify_remarks")==null?"":request.getParameter("verify_remarks");//Added for ML-MMOH-SCF-0327 [IN:058772] 
	String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
	String ivprep = request.getParameter("ivprep")==null?"":request.getParameter("ivprep");//Added for SKR-SCF-1370 

		if(ReqDb.equals("undefined"))
		    ReqDb="";
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		if(enc_id1.equals("undefined"))
		    enc_id1="";
    String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
	String	bean_id		  =	"QueryPatientDrugProfileBean" ;
	String	bean_name	  =	"ePH.QueryPatientDrugProfileBean";
	QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);

	String title		=	"";
	String pract_id     =   "";
	String pract_desc    =   "";
	String date_time     =   "";
	String date_time1     =   "";
	String complete_order_reason = "";
	boolean record_flag	= false;  //Added on 11/OCt/2010 for the incident num:24075--By Sandhya
	HashMap	result		= null;
	ArrayList remarks	= null;
	HashMap hold_dtl	= null;
	String	amend_detail= ""; //Added for ML-BRU-SCF-0098[IN031837]
	String ivfluidRemarks = "";//added for SKR-SCF-1370
	String alt_drug_remarks ="", pregnancy_override_reason="";
	String drug_indication_remarks="";	
	if(!verify_remarks.equals("")){ //if block Added for ML-MMOH-SCF-0327 [IN:058772]
		verify_remarks=verify_remarks.replaceAll(" ","%20");
		verify_remarks=	java.net.URLEncoder.encode(verify_remarks,"UTF-8");
		verify_remarks=verify_remarks.replaceAll("%2520","%20");
	}
	if(called_frm == null || called_frm.equals("")){
		if(line_status==null)
			line_status		=	"";
		//out.println("sr_no--->"+sr_no);
		result		= bean.getRemarks(order_id,order_line_num,patient_id,sr_no,ReqDb,enc_id1);
		remarks	= bean.getPresRemarks(order_id,order_line_num,ReqDb,enc_id1);
		drug_indication_remarks=bean.getdrugIntaractions(order_id,order_line_num,patient_id,sr_no,ReqDb,enc_id1);
		//added for SKR-SCF-1370
			if(ivprep!=null && !ivprep.equals("") && ivprep.equals("5")){
				ivfluidRemarks = bean.getMFRfluidRemarks(order_id,order_line_num); 
				remarks.add(ivfluidRemarks);
			//	System.out.println("remarks: "+remarks);  
			}
			//added for SKR-SCF-1370
			
		hold_dtl	= bean.getHoldRemarks(order_id,order_line_num,ReqDb,enc_id1);
		complete_order_reason = bean.getCompOrdRemarks(order_id,order_line_num,ReqDb,enc_id1);
		if( amend_reason_code != null && !amend_reason_code.equals("") )
			amend_detail = bean.getTransacrionReason(amend_reason_code, "O",ReqDb,enc_id1); //Added for ML-BRU-SCF-0098[IN031837]
		if(result!=null && result.containsKey("ALT_DRUG_REMARKS") )
			alt_drug_remarks=(String)result.get("ALT_DRUG_REMARKS")==null?"":(String)result.get("ALT_DRUG_REMARKS");// checked null for incident 40750
		/*out.println("result"+result);
		out.println("<script>alert('"+order_id+"')</script>");
		out.println("<script>alert('"+order_line_num+"')</script>");
		out.println("<script>alert('"+patient_id+"')</script>");
		out.println("<script>alert('"+sr_no+"')</script>");
		out.println("<script>alert('"+result+"')</script>");*/
		if(line_status.equals("HD")||line_status.equals("HC")) {
			title	=	"Held";
			pract_id	=	(String)hold_dtl.get("HOLD_PRACT_ID");
			pract_desc	=	(String)hold_dtl.get("HOLD_PRACT_DESC");
			//Date Conversion Done for the incident num:24456  on 14/OCt/2010 ===By Sandhya
			date_time	=	com.ehis.util.DateUtils.convertDate((String)hold_dtl.get("HOLD_DATE_TIME"),"DMYHM","en",locale);
		} 
		else if(line_status.equals("DC")) {
			title	=	"DisContinued";
			pract_id	=	(String)hold_dtl.get("DISC_PRACT_ID");
			pract_desc	=	(String)hold_dtl.get("DISC_PRACT_DESC");
			//Date Conversion Done for the incident num:24456  on 14/OCt/2010 ===By Sandhya
			date_time	=	com.ehis.util.DateUtils.convertDate((String)hold_dtl.get("DISC_DATE_TIME"),"DMYHM","en",locale);
		} 
		else if(line_status.equals("CN")){
			title	=	"Canceled";
			pract_id	=	(String)hold_dtl.get("CAN_PRACT_ID");
			pract_desc	=	(String)hold_dtl.get("CAN_PRACT_DESC");
			//Date Conversion Done for the incident num:24456  on 14/OCt/2010 ===By Sandhya
			date_time	=	com.ehis.util.DateUtils.convertDate((String)hold_dtl.get("CAN_DATE_TIME"),"DMYHM","en",locale); 
			//out.println("date_time======80===>" +date_time);
		}	
	}
%>
	<form name="queryPatientDrugProfileRemarks" id="queryPatientDrugProfileRemarks" >
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<% 
			if(called_frm == null || called_frm.equals("")){
				if(remarks.size()!=0 ) { 
%>
					<th><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></th>
<% 
					for(int i=0; i<remarks.size(); i++){ 
						if(remarks.get(i)!=null && !((String)remarks.get(i)).equals("")) {
%>
							<tr>
								<td class="label">&nbsp;&nbsp;<%=(String)remarks.get(i)%></td>
							</tr>
<%
						}
					}
					record_flag=true;
				}	
				if(result!=null && !result.get("SPLIT_DOSE_PREVIEW").equals("")) { 
%>
					<th><fmt:message key="ePH.DosageDetails.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;	
<%				
							if(sliding_scale_yn.equals("Y")){
%>
								<label style='color:red'> <fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></label>
<%				
							}
							else{
%>
								<%=result.get("SPLIT_DOSE_PREVIEW")%>
<%
								if(split_dos_yn.equals("Y")){
%>	
									<label style='color:red'>( <fmt:message key="ePH.Divided.label" bundle="${ph_labels}"/>)</label>
<%					
								}
						   }
%>	
						</td>
					</tr>
<% 
					record_flag=true;
				}	 
				if(result!=null &&  !result.get("ALLERGY_REASON").equals("")) { 
%>
					<th><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=result.get("ALLERGY_REASON")%></td>
					</tr>
<% 
					record_flag=true;
				}
				if(result!=null &&  !result.get("OVERRIDE_REASON").equals("")) { 
%>
					<th><fmt:message key="ePH.DosageOverrideReason.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=result.get("OVERRIDE_REASON")%></td>
					</tr>
<% 
					record_flag=true;
				}
				if(result!=null &&  !result.get("DUPLICATE_REASON").equals("")) { 
%>
					<th><fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=result.get("DUPLICATE_REASON")%></td>
					</tr>
<% 
					record_flag=true;
				}
				if(result!=null &&  !result.get("PREGNANCY_OVERRIDE_REASON").equals("")) { 
%>
					<th><fmt:message key="ePH.pregnancy.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.OverrideReasons.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=result.get("PREGNANCY_OVERRIDE_REASON")%></td>
					</tr>
<% 
					record_flag=true;
				}
				
				if(result!=null &&  !result.get("PRN_REMARKS").equals("")) { 
%>
					<th><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=result.get("PRN_REMARKS")%></td>
					</tr>
<% 
					record_flag=true;
				}
				if(result!=null &&  !result.get("DISCONT_ID").equals("")) { 
%>
					<!-- <th align="left">Discontinued Detail</th>
					<tr>
						<td class="label">Discontinued By:&nbsp;&nbsp;<b><%=result.get("DISCONT_ID")%></b></td>
					</tr>
					<tr>
						<td class="label">Discontinued Date:&nbsp;&nbsp;<b><%=result.get("DICONT_DATE")%></b></td>
					</tr> -->
<%
					record_flag=true;
				}
				// Add this condition for ML-BRU-SCF-0037[030949]  -Start
				if(result!=null &&  !result.get("RETURN_REASON_CODE").equals("")) {   
					String reason_code	= (result.get("RETURN_REASON_CODE")).toString();
					String	reason_desc	= bean.getReasonDesc("T",reason_code,ReqDb,enc_id1)==null?"":bean.getReasonDesc("T",reason_code,ReqDb,enc_id1);			
%>
					<th><fmt:message key="ePH.Returnreason.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=reason_desc%></td>
					</tr>
<% 
					record_flag=true;
				}
				// Add this condition for ML-BRU-SCF-0037[030949]  -End
				if(!hold_dtl.get("CAN_REASON").equals("") && (line_status.equals("CN") || line_status.equals("DC")  || line_status.equals("HD") || line_status.equals("HC"))){	
%>
					<th><%=title%> Detail</th>
					<tr>
						<td class="label"><%=title%>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<b><%=pract_desc%></b></td>
					</tr>
					<tr>
						<td class="label"><%=title%>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<b><%=date_time%></b></td>
					</tr>
					<tr>
						<td class="label"><%=title%>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<b><%=hold_dtl.get("CAN_REASON")%></b></td>
					</tr>
<%
					record_flag=true;
				} 
				else if(result!=null &&  !result.get("CANCEL_BY_ID").equals("")){	
%>
					<th><fmt:message key="Common.CancelledDetail.label" bundle="${common_labels}"/></th>
					<tr>
						<td class="label"><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<b><%=result.get("CANCEL_BY_ID")%></b></td>
					</tr>

					<tr>

					 <td class="label"> Cancelled Date:&nbsp;&nbsp;<b><%=result.get("CANCEL_DATE_TIME")%></b></td>
					</tr>
<%
					record_flag=true;	
				} 
				else if(!complete_order_reason.equals("")){
%>
					<th><fmt:message key="ePH.CompleteOrderReason.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=complete_order_reason%></td>
					</tr>
<% 
					record_flag=true;
				}
				else if(!alt_drug_remarks.equals("")){// Added if condition for Bru-HIMS-CRF-082 [IN:029948]
					//alt_drug_remarks = java.net.URLEncoder.encode(alt_drug_remarks,"UTF-8");
					alt_drug_remarks=alt_drug_remarks.replaceAll(" ","%20");
					alt_drug_remarks = java.net.URLEncoder.encode(alt_drug_remarks,"UTF-8");
					alt_drug_remarks=alt_drug_remarks.replaceAll("%2520"," ");
%>
					<th><fmt:message key="ePH.AltDrugRemarks.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label" id='alt_drug_remarks' wrap></td>
						<script>
							document.getElementById("alt_drug_remarks").innerText= decodeURIComponent('<%=alt_drug_remarks%>',"UTF-8") ;
						</script>
					</tr>
<% 
					record_flag=true;
				}				
				if(!verify_remarks.equals("")) { //Added for ML-MMOH-SCF-0327 [IN:058772] 
%>
					<th><fmt:message key="ePH.VerificationRemarks.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" id='verify_remarks' ></td>						
					</tr>
					<script>
						var verify_remark = decodeURIComponent('<%=verify_remarks%>','UTF-8');
						document.getElementById("verify_remarks").innerText = verify_remark ;
					</script>
<%
					record_flag=true;
				}
				
				if(!allocate_finding.equals("")) { //Code added for ML-BRU-SCF-0971[IN042220] --Start
					allocate_remarks_code = bean.getTransacrionReason(allocate_remarks_code,"A",ReqDb,enc_id1);
%>
					<th align="left"><fmt:message key="ePH.AllocateStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=allocate_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="80" rows="3"  readonly > <%=allocate_finding%></textarea>
						</td>						
					</tr>
<% 					record_flag=true;
				}
				if(!fill_finding.equals("")) { 
					fill_remarks_code = bean.getTransacrionReason(fill_remarks_code,"F",ReqDb,enc_id1);
%>
					<th align="left"><fmt:message key="ePH.FillingStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=fill_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="80" rows="3"  readonly > <%=fill_finding%></textarea>
						</td>						
					</tr>
<% 					record_flag=true;
				}
				if(!delivery_finding.equals("")) { 
					delivery_remarks_code = bean.getTransacrionReason(delivery_remarks_code,"D",ReqDb,enc_id1);
%>
					<th align="left"><fmt:message key="ePH.DeliveryStageFindings.label" bundle="${ph_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<%=delivery_remarks_code%></td>						
					</tr>
					<tr>												
						<td  class="label" ><textarea cols="80" rows="3"  readonly > <%=delivery_finding%></textarea>
						</td>						
					</tr>
<% 					record_flag=true;
				}//Code added for ML-BRU-SCF-0971[IN042220] --End
			   if(!ref_sent_remarks.equals("")){//Added if condition for HSA-CRF-0155 [IN048487]
%>
				<th><fmt:message key="ePH.EXTERNALREMARKS.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label">&nbsp;&nbsp;<%=ref_sent_remarks%></td>
					</tr>
<%
				 record_flag=true;
			   }
			   if(!drug_indication_remarks.equals("")) {  
				   %>
				   					<th>Drug Indications</th>
				   					<tr>												
				   						<td  class="label" id='drug_indication_remarks' ></td>						
				   					</tr>
				   					<script>
				   						var drug_indication_remarks = decodeURIComponent('<%=drug_indication_remarks%>','UTF-8');
				   						document.getElementById("drug_indication_remarks").innerText = drug_indication_remarks ;
				   					</script>
				   <%
				   					record_flag=true;
				   				}
				   	
			}
			//Added Else-If Condition for the incident num:24075 on 11/OCT/2010===By Sandhya
			// Added the if Block for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- Start
			if(sliding_scale_yn.equals("Y")){ 
				ArrayList sliding_scale_details =   bean.getSlidingScaleTemplateDetails(order_id,order_line_num,ReqDb,enc_id1);
				if(sliding_scale_details.size()>0 && (called_frm == null || called_frm.equals(""))){
					String dosage_dtls = sliding_scale_details.get(0)==null?"":(String)sliding_scale_details.get(0);
					if( dosage_dtls!=null && !dosage_dtls.equals("") && !dosage_dtls.equals("$")){ 
						String [] timing_dsg_dtls = dosage_dtls.split("Dosage");
						String timing_dtls = timing_dsg_dtls[0];
						dosage_dtls =  timing_dsg_dtls[1];
%>
						<tr>
							<td class="label">&nbsp;&nbsp;</td>
						</tr>
						<tr> 
							<td>
								<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" name='tbDosage_dtl' id='tbDosage_dtl'>
									<th align="left" style="font-size:9"><fmt:message key="ePH.ScheduledFrequency.label" bundle="${ph_labels}"/></th>
									<tr><td class="QRYEVENSMALL"><%=timing_dtls%></td></tr>
									<tr><td class="QRYEVENSMALL"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/><%=dosage_dtls%></td></tr>
								</table>
<% 	
					}
				}
				if(sliding_scale_details.size()>1){
					record_flag = true;
%>
					</td>
					<tr>
						<td class="label">&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td class="label">
							<table cellpadding="1" cellspacing="0" width="90%" align="center" border="1" name='tbSlidingScale_Dtls' id='tbSlidingScale_Dtls'>
							<tr>
								<th style="font-size:13 border-bottom:1px solid white;" colspan=6><%=(String)sliding_scale_details.get(9)%></th>		
							</tr>
							<tr>
								<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/></th>
								<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/></th>
								<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
								<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/></th>
								<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
								<th align="left" style="font-size:9"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
							</tr>
<%
							String sRemarks="&nbsp;";
							String toRan="";
							String admUnit="";
							for(int sl=1;sl<sliding_scale_details.size();sl+=9){
								toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
								admUnit=(String)sliding_scale_details.get(sl+4);
								if(admUnit!=null && !admUnit.equals("")){
									float admUnitValue=Float.parseFloat(admUnit);
									if(admUnitValue>0.0 && admUnitValue<1.0)
										admUnit=Float.parseFloat(admUnit)+"";
								}
								if(sliding_scale_details.get(sl+7) ==null || ((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") )
									sRemarks = "&nbsp;";
								else
									sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");
%>
								<tr>
									<td nowrap><%=(String)sliding_scale_details.get(sl+2)%></td>
									<td nowrap><%=toRan%></td>	
									<td nowrap><%=(String)sliding_scale_details.get(sl+5)%></td>	
									<td nowrap><%=admUnit%></td>	
									<td nowrap><%=(String)sliding_scale_details.get(sl+6)%></td>
									<td><%=sRemarks%></td>	
								</tr>
<%
							}
%>
							</table>
						</td>
					</tr>
<%
					}
				}
	%>			
			 <tr>
		<% 
		/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
		   if ( amended_by_id != null && !amended_by_id.equals("") ){
			       record_flag=true; //Added for ML-MMOH-SCF-0754
		%>
					<th><fmt:message key="ePH.AmendedBy.label" bundle="${ph_labels}"/></th>
					<tr>
							<td class="label">&nbsp;&nbsp;<%=amended_by_id%></td>
					</tr>
					<th><fmt:message key="ePH.AmendedDate.label" bundle="${ph_labels}"/></th>
					<tr>
							<td class="label">&nbsp;&nbsp;<%=amended_date%></td>
						</tr>
<%
				}
				if( amend_detail != null && !amend_detail.equals("") )	{
					    record_flag=true;//Added for ML-MMOH-SCF-0754
%>	
					<th><fmt:message key="ePH.ReasonforAmend.label" bundle="${ph_labels}"/></th>
					<tr>
							<td class="label">&nbsp;&nbsp;<%=amend_detail%></td>
					</tr>
<%	
					if( amend_remarks != null && !amend_remarks.equals("") ){
%>	
							<th><fmt:message key="ePH.AmendRemarks.label" bundle="${ph_labels}"/></th>
							<tr>
									<td class="label">&nbsp;&nbsp;<%=amend_remarks%></td>
							</tr>
<%	
						}
			  }
								
					
				/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
%>
			</tr>
				
<%		
				// Added the if Block for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
				if(record_flag==false){
%>
					<script>alert("NO DATA FOUND FOR THIS ORDER");history.go(-1);window.close();</script>
<%
				}
%>
				<tr align="right">
					<td class="button">
						<input type="button" class="button" name="close" id="close" value="Close" onClick="closeRemarks()">
					</td>
				</tr>
			</table>	
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

