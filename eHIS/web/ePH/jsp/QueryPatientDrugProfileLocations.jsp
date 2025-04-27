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
		<title><fmt:message key="ePH.DispLocn(s).label" bundle="${ph_labels}"/></title>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="queryPatientDrugProfileDetails" id="queryPatientDrugProfileDetails" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%
			String	bean_id			=	"QueryPatientDrugProfileBean" ;
			String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);
			String order_id			=	request.getParameter("order_id");
			String order_line_no			=	request.getParameter("order_line_no");
			String patient_id = request.getParameter("patient_id"); //Added for ML-BRU-SCF-0430 IN[035169]
			String classValue		=	"";
			String alt_drug_remarks = "", status="", disp_date, stkey="";   //added for  Bru-HIMS-CRF-082 [IN:029948]
			String line_status_text =request.getParameter("line_status_text"); //Added for Bru-HIMS-CRF-082 [IN:029948]
			bean.setFacilityParamValues();//added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_ind = bean.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String flag = request.getParameter("flag")==null?"":request.getParameter("flag");//Added for Medical Tab
			String allocate_remarks1	=	request.getParameter("allocate_finding")==null?"":request.getParameter("allocate_finding");
			String fill_remarks1		=	request.getParameter("fill_finding")==null?"":request.getParameter("fill_finding");
			String allocate_remarks_code1	=	request.getParameter("allocate_remarks_code")==null?"":request.getParameter("allocate_remarks_code");
			String fill_remarks_code1		=	request.getParameter("fill_remarks_code")==null?"":request.getParameter("fill_remarks_code");
			String verify_remarks		=	request.getParameter("verify_remarks")==null?"":request.getParameter("verify_remarks"); //Added for ML-MMOH-SCF-0327 [IN:058772] 
			HashMap	result		= null;//code added for ML-BRU-SCF-0971[IN042220]-- Start
			boolean find_flag 	= false;
		//added for mms-icn-0115
			String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
		if(ReqDb.equals("undefined"))
		    ReqDb="";
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		if(enc_id1.equals("undefined"))
		    enc_id1="";
			if(flag.equalsIgnoreCase("MI")){//Added for Medical Tab--start
				String  disp_locn_desc="", item_name="", dispense_Qty="", ordered_By="", med_Status="", order_quantity_uom="";
				ArrayList all_locations = null;
%>
				<th><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.DispenseItem.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.DispenseQty.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.DispenseBy.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.DispenseStatus.label" bundle="${ph_labels}"/></th>
<%
				if(!order_id.equals("")){
					all_locations	=	bean.getAllLocations(order_id,order_line_no);
					for(int i=0; i<all_locations.size(); i+=13){
						disp_date	=	(String)all_locations.get(i);
						item_name	=	(String)all_locations.get(i+1);
						disp_locn_desc	=(String)all_locations.get(i+2);
						dispense_Qty	=	(String)all_locations.get(i+3);
						ordered_By	=	(String)all_locations.get(i+4);
						med_Status	=	(String)all_locations.get(i+5);
%>
						<tr>
						<td class="QRYEVEN"><%=DateUtils.convertDate(disp_date,"DMYHM","en",locale)%></td>
						<td class="QRYEVEN"><%=item_name%></td>
						<td class="QRYEVEN"><%=disp_locn_desc%></td> 
						<td class="QRYEVEN"><%=dispense_Qty%></td> 
						<td class="QRYEVEN"><%=ordered_By%></td> 
						<td class="QRYEVEN">
<%
						if(med_Status.equals("D")){
%>
							<fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>
<%
						}
						else{
							med_Status	=	request.getParameter("Status")==null?"":request.getParameter("Status");
%>
							<%=med_Status%>
<%
						}
%>
						</td>
						</tr>
<%
					}
				}
				if(all_locations==null || all_locations.size()==0){
					disp_date	=	request.getParameter("disp_date")==null?"":request.getParameter("disp_date");
					disp_locn_desc	=	request.getParameter("disp_locn_desc")==null?"":request.getParameter("disp_locn_desc");
					item_name	=	request.getParameter("item_name")==null?"":request.getParameter("item_name");
					dispense_Qty	=	request.getParameter("dispense_Qty")==null?"":request.getParameter("dispense_Qty");
					ordered_By	=	request.getParameter("ordered_By")==null?"":request.getParameter("ordered_By");
					med_Status	=	request.getParameter("Status")==null?"":request.getParameter("Status");
					order_quantity_uom	=	request.getParameter("order_quantity_uom")==null?"":request.getParameter("order_quantity_uom");
%>
					<tr>
					<td class="QRYEVEN"><%=DateUtils.convertDate(disp_date,"DMYHM","en",locale)%></td>
					<td class="QRYEVEN"><%=item_name%></td>
					<td class="QRYEVEN"><%=disp_locn_desc%></td> 
					<td class="QRYEVEN"><%=dispense_Qty+" "+order_quantity_uom%></td> 
					<td class="QRYEVEN"><%=ordered_By%></td> 
					<td class="QRYEVEN"><%=med_Status%></td>
					</tr>
<%	
				}
			}
			else if( !flag.equals("return") && ! flag.equals("reissue")){//Added for Medical Tab--end //if condition Added for ML-BRU-SCF-1394[IN0501010]
				ArrayList all_locations	=	bean.getAllLocations(order_id,order_line_no);
				if(all_locations!=null && all_locations.size()>0 ){
%>
					<th><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.DispenseDrug.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.DispenseQty.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.DispenseBy.label" bundle="${ph_labels}"/></th><!-- Added for Scf : ML-BRU-SCF-0430.INC :[35169] -->
					<th><fmt:message key="ePH.DispenseStatus.label" bundle="${ph_labels}"/></th><!-- Added for Bru-HIMS-CRF-082 [IN:029948] -->
					<th><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></th><!-- Added for Bru-HIMS-CRF-082 [IN:029948] -->
<% 
					int count = 0;
					String allocate_remarks ="",allocate_remarks_code="", fill_remarks="",fill_remarks_code="", delivery_remarks="", delivery_remarks_code=""; //added for ML-BRU-SCF-0971[IN042220]
					int totRec = all_locations.size()/13;
					int recCount=0;
					for(int i=0; i<all_locations.size(); i+=13) { //changed i+4 to i+5  for ML-BRU-SCF-0430 IN[035169] 7 -> 10
						recCount ++;
						if(count%2==0) 
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";
						status =(String) all_locations.get(i+5);
						alt_drug_remarks = (String)all_locations.get(i+6);
						disp_date = (String)all_locations.get(i);
						stkey = order_id+"~"+order_line_no+"~"+disp_date;
						allocate_remarks_code=(String)all_locations.get(i+7); //added for ML-BRU-SCF-0971[IN042220] -Start
						allocate_remarks=(String)all_locations.get(i+8);
						fill_remarks_code=(String)all_locations.get(i+9);
						fill_remarks=(String)all_locations.get(i+10);
						delivery_remarks_code=(String)all_locations.get(i+11);
						delivery_remarks=(String)all_locations.get(i+12);
						find_flag 	= false;
						if( !allocate_remarks.equals("") || !fill_remarks.equals("") || !delivery_remarks.equals("")  )
							find_flag = true;
						if(find_flag && recCount == totRec ){//modified for ml-mmoh-scf-1008
							if( !allocate_remarks1.equals("") || !fill_remarks1.equals("")  ){
								allocate_remarks = allocate_remarks1;
								fill_remarks = fill_remarks1;
								allocate_remarks_code = allocate_remarks_code1;
								fill_remarks_code = fill_remarks_code1;
								find_flag = true;
							}
						}
							
						if(!allocate_remarks.equals("")){
							allocate_remarks_code = bean.getTransacrionReason(allocate_remarks_code,"A",ReqDb,enc_id1);//ReqDb,enc_id1 added for mms-icn-0115
							allocate_remarks_code=allocate_remarks_code.replaceAll(" ","%20");
							allocate_remarks_code=	java.net.URLEncoder.encode(allocate_remarks_code,"UTF-8");

							allocate_remarks_code=allocate_remarks_code.replaceAll("%2520","%20");
							allocate_remarks=allocate_remarks.replaceAll(" ","%20");
							allocate_remarks=	java.net.URLEncoder.encode(allocate_remarks,"UTF-8");
							allocate_remarks=allocate_remarks.replaceAll("%2520","%20");
						}
						if(!fill_remarks.equals("")){
							fill_remarks_code = bean.getTransacrionReason(fill_remarks_code,"F",ReqDb,enc_id1);//ReqDb,enc_id1 added for mms-icn-0115
							fill_remarks_code=fill_remarks_code.replaceAll(" ","%20");
							fill_remarks_code=	java.net.URLEncoder.encode(fill_remarks_code,"UTF-8");
							fill_remarks_code=fill_remarks_code.replaceAll("%2520","%20");

							fill_remarks=fill_remarks.replaceAll(" ","%20");
							fill_remarks=	java.net.URLEncoder.encode(fill_remarks,"UTF-8");
							fill_remarks=fill_remarks.replaceAll("%2520","%20");
						}				
						if(!delivery_remarks.equals("")){
							delivery_remarks_code = bean.getTransacrionReason(delivery_remarks_code,"D",ReqDb,enc_id1);//ReqDb,enc_id1 added for mms-icn-0115
							delivery_remarks_code=delivery_remarks_code.replaceAll(" ","%20");
							delivery_remarks_code=	java.net.URLEncoder.encode(delivery_remarks_code,"UTF-8");
							delivery_remarks_code=delivery_remarks_code.replaceAll("%2520","%20");

							delivery_remarks=delivery_remarks.replaceAll(" ","%20");
							delivery_remarks=	java.net.URLEncoder.encode(delivery_remarks,"UTF-8");
							delivery_remarks=delivery_remarks.replaceAll("%2520","%20");
						}// code added for ML-BRU-SCF-0971[IN042220]--End	
%>
					   <tr>
							<!-- <td class="<%=classValue%>" nowrap><%=all_locations.get(i)%></td> Commented By Sandhya for conversion of date regarding inc num:25007-->
							<td class="<%=classValue%>" nowrap><%=DateUtils.convertDate((String)all_locations.get(i),"DMYHM","en",locale)%></td>
							<td class="<%=classValue%>"><%=all_locations.get(i+1)%></td> 
							<td class="<%=classValue%>"><%=all_locations.get(i+2)%></td>
							<td class="<%=classValue%>"><%=all_locations.get(i+3)%></td>
							<td class="<%=classValue%>"><%=all_locations.get(i+4)%></td> <!-- Added for ML-BRU-SCF-0430 IN[035169] -->
							<td class="<%=classValue%>"><!-- Added for Bru-HIMS-CRF-082 [IN:029948] -->
<%
							if(status.equals("D")){
%>
								<fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>
<%
							}
							else{
%>
								<%=line_status_text%>
<%
							}
							if(find_flag){   //code added for ML-BRU-SCF-0971 [IN042220]--Start					
%>
								&nbsp;&nbsp;<label style="cursor:pointer;color:blue;font-size:9;"  onClick="showFinding('<%=allocate_remarks%>','<%=fill_remarks%>','<%=delivery_remarks%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '<%=delivery_remarks_code%>', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>')" > <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>							
<%							} //code added for ML-BRU-SCF-0971 [IN042220]--End				
						 
%>                     
							</td> 
							<td class="<%=classValue%>">
<%
							if(!alt_drug_remarks.equals("")){
%>
								<font class="HYPERLINK" style="cursor:pointer"onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></font>
<%
							}
%>
							&nbsp;</td> <!-- Added for Bru-HIMS-CRF-082 [IN:029948] -->
						</tr>
<%			 
						count++;
					}
				}
				String complete_order_reason = bean.getCompOrdRemarks(order_id,order_line_no,ReqDb,enc_id1);//ReqDb,enc_id1 added for mms-icn-0115
				if(!complete_order_reason.equals("")){
%>
					<tr>
						<td colspan ='7'>&nbsp;</td>
					</tr>
					<tr>
					<th colspan ='7'><fmt:message key="ePH.CompleteOrderReason.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td class="label" colspan ='7'>&nbsp;&nbsp;<%=complete_order_reason%></td>
					</tr>
<% 
				}
			}
			else if(flag.equals("return")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
				ArrayList return_records			=	bean.getReturnMedicationRecords(order_id,order_line_no);
				if(return_records!=null && return_records.size()>0){
%>
					<th><fmt:message key="ePH.ReturnDate.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.ReturnedDrug.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReturnDispenselocation.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReturnedQuantity.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReturnBy.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReturnStatus.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></th>
				
<%
					int count = 0;
					int totRec = return_records.size()/7;
					int recCount=0;
					String return_status="";
					for(int i=0; i<return_records.size(); i+=7) { 
						recCount ++;
						if(count%2==0) 
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";
						return_status =(String) return_records.get(i+4);
%>
						<tr>
							<td class="<%=classValue%>" nowrap><%=DateUtils.convertDate((String)return_records.get(i),"DMYHM","en",locale)%></td>
							<td class="<%=classValue%>" nowrap><%=return_records.get(i+1)%></td> 
							<td class="<%=classValue%>"><%=return_records.get(i+6)%></td>
							<td class="<%=classValue%>"><%=return_records.get(i+2)%></td>
							<td class="<%=classValue%>"><%=return_records.get(i+3)%></td> 
							<td class="<%=classValue%>">
<%
							if(return_status.equals("R")){
%>
								<fmt:message key="ePH.ReturnedMedication.label" bundle="${ph_labels}"/>
<%
							}
%>
							</td> 
							<td class="<%=classValue%>" nowrap><%=return_records.get(i+5)%></td> 
						</tr>
<%
						count++;
					}
				}
			}
			else if(flag.equals("reissue")){
				ArrayList reissue_records			=	bean.getReIssueMedicationRecords(order_id,order_line_no);
				if(reissue_records!=null && reissue_records.size()>0){
%>
					<th><fmt:message key="ePH.ReissuedDate.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.ReissueDrug.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.Reissuedlocation.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReissueQuantity.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.Reissuedby.label" bundle="${ph_labels}"/></th>
					<th nowrap><fmt:message key="ePH.ReIssueStatus.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></th>
<%
					int count = 0;
					int totRec = reissue_records.size()/7;
					int recCount=0;
					String reissue_status="";
					for(int i=0; i<reissue_records.size(); i+=7) { 
						recCount ++;
						if(count%2==0) 
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";
						reissue_status =(String) reissue_records.get(i+4);
%>
						<tr>
							<td class="<%=classValue%>" nowrap><%=DateUtils.convertDate((String)reissue_records.get(i),"DMYHM","en",locale)%></td>
							<td class="<%=classValue%>" nowrap><%=reissue_records.get(i+1)%></td> 
							<td class="<%=classValue%>"><%=reissue_records.get(i+6)%></td>
							<td class="<%=classValue%>"><%=reissue_records.get(i+2)%></td>
							<td class="<%=classValue%>"><%=reissue_records.get(i+3)%></td> 
							<td class="<%=classValue%>">
<%
							if(reissue_status.equals("R")){
%>
								<fmt:message key="ePH.Reissue.label" bundle="${ph_labels}"/>
<%
							}
%>
							</td> 
							<td class="<%=classValue%>" nowrap><%=reissue_records.get(i+5)%></td> 
						</tr>
<%			 
						count++;
					}
				}
			}//Added for ML-BRU-SCF-1394[IN0501010]-End
			if(!order_id.equals("") && !order_line_no.equals("") && !order_line_no.equals("0")){
%>
				<tr align="right"><!-- added for ML-BRU-SCF-0430 IN[035169] - start -->
					<td colspan="7" class="button">
					<input class="button" type="button" name="AuditTrail" id="AuditTrail" value='<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>' onClick="callAuditTrail('<%=order_id%>','<%=patient_id%>');">&nbsp;&nbsp;&nbsp;
					</td>
				</tr> <!-- added for ML-BRU-SCF-0430 IN[035169] - end -->
<%
			}//Added for Medical Tab
%>	
			</table>
		</form>
<% 
		putObjectInBean(bean_id,bean,request); 
%>
	</body>
</html>

