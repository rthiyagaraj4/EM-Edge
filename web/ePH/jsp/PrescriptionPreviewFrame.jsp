<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
22-05-2022                                      prathyusha                                               AAKH-CRF-0140         
--------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%


 		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/FDBDrugInfo.js"></script>
	</head>
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin	-->
	<!--<script language="VBScript">
		Function vbConfirm(msg)
		   butVal = 32 + 4 + 0 + 0
		   vbConfirm = MsgBox(msg,butVal,"Duplicate Drug") 
		End Function
	</script>-->
	<script language="Javascript">

function jsConfirm(msg) {        
return confirm(msg); 
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end	-->

	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="preview" id="preview">
<%
			String patient_id	= request.getParameter("patient_id");
			String encounter_id	= request.getParameter("encounter_id");
			String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name	= "ePH.PrescriptionBean_1";
			String drug_db_interface_yn = (String)request.getParameter("drug_db_interface_yn")==null?"":(String)request.getParameter("drug_db_interface_yn");
			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
			String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
			
			String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
			String consumable_bean_name				= "ePH.ConsumableOrderBean";
			ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
					
			PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request ) ;
			bean.setLanguageId(locale);
			ArrayList presDetails	= new ArrayList();
			presDetails				=(ArrayList) bean.getpresDetails();
			HashMap drug_detail = null;
			String tot_payable = "";
			String tot_gross_payable = "";//ADDED FOR ML-BRU-CRF-0469
			String pat_payable = "";
			double tot_payable_sum = 0.0;
			double tot_gross_payable_sum = 0.0;//ADDED FOR ML-BRU-CRF-0469
			double pat_payable_sum = 0.0;
			String tot_payable_sum_str = "";
			String tot_gross_payable_sum_str = "";//ADDED FOR ML-BRU-CRF-0469
			String pat_payable_sum_str = "";
			String decimalFormatString = "";
			String end_date = "";
			String durn_value = "";
			String repeat_durn_type = "";
			String no_refill = "";
			HashMap RefillDetail	=	null;
			String pat_brought_medn = "";
			String billable_item_yn = "";
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
			String drug_tapered = "N";
			String tappered_over = "N";
			String preview_rx_yn=bean.getPreviewRxYN(); //added for ML-MMOH-CRF-0341 [IN:057179]
			String chk_preview_rx="N";   //AAKH-CRF-0091 
			String previewManDisp = "none", previewReleaseDisp="";
			boolean displayGrossAmtYn = presBean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
			boolean drug_abuse_appl=presBean.isSiteSpecific("PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
			
			boolean patient_stock_required = presBean.isSiteSpecific("PH", "PATIENT_STOCK_REQUIRED");
			if(preview_rx_yn.equals("Y") && ( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals(""))){
				previewManDisp = "";
				previewReleaseDisp = "none";
				chk_preview_rx="Y";   //AAKH-CRF-0091 
			}
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
				if(presDetails!=null && presDetails.size()>0){
					for(int i=0;i<presDetails.size();i++){			
						drug_detail=(HashMap) presDetails.get(i);
						 pat_brought_medn = (String)drug_detail.get("BROUGHT_BY_PAT")==null?"N":(String)drug_detail.get("BROUGHT_BY_PAT");
						 if(pat_brought_medn.equals(""))
							  pat_brought_medn="N";
						tot_payable = (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0f":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
						tot_gross_payable = (String)drug_detail.get("BL_GROSS_CHARGE_AMT")==null?"0.0f":(String)drug_detail.get("BL_GROSS_CHARGE_AMT");//ADDED FOR ML-BRU-CRF-0469
						pat_payable = (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0f":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
						decimalFormatString = (String)drug_detail.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)drug_detail.get("BL_DECIMAL_FORMAT_STRING");
						billable_item_yn =  (String)drug_detail.get("BILLABLE_ITEM_YN")==null?"Y":(String)drug_detail.get("BILLABLE_ITEM_YN");
						drug_tapered = drug_detail.get("DRUG_TAPERED_YN")==null?"":(String)drug_detail.get("DRUG_TAPERED_YN");
						tappered_over = drug_detail.get("TAPPERED_OVER")==null?"":(String)drug_detail.get("TAPPERED_OVER");
						if(tot_payable.equals(""))
							tot_payable = "0.0f";
						if(tot_gross_payable.equals(""))//ADDED FOR ML-BRU-CRF-0469
							tot_gross_payable = "0.0f";
						if(pat_payable.equals(""))
							pat_payable = "0.0f";
						if(pat_brought_medn.equals("N") && billable_item_yn.equals("Y")){
							if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| !totalTaperQtyDisplay.equals("Y") || !drug_tapered.equals("Y")) {
								tot_payable_sum += Float.parseFloat(tot_payable);
								tot_gross_payable_sum += Float.parseFloat(tot_gross_payable);//ADDED FOR ML-BRU-CRF-0469
								pat_payable_sum += Float.parseFloat(pat_payable);
							}
						}

						//to add the Charge details of Refill orders
						no_refill			= (String)drug_detail.get("NO_REFILL");
						if(no_refill!=null && !no_refill.equals("")){
							end_date			= (String)drug_detail.get("END_DATE");	
							durn_value			= (String)drug_detail.get("DURN_VALUE");
							repeat_durn_type	= (String)drug_detail.get("REPEAT_DURN_TYPE");	
							drug_tapered = drug_detail.get("DRUG_TAPERED_YN")==null?"":(String)drug_detail.get("DRUG_TAPERED_YN");
							tappered_over = drug_detail.get("TAPPERED_OVER")==null?"":(String)drug_detail.get("TAPPERED_OVER");
							if(!locale.equals("en")){
								end_date =  DateUtils.convertDate(end_date, "DMYHM",locale,"en");
							}
							RefillDetail= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);
							for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { 		
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&pat_brought_medn.equals("N") && billable_item_yn.equals("Y")){
									tot_payable = (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
									tot_gross_payable = (String)drug_detail.get("BL_GROSS_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_GROSS_CHARGE_AMT");//ADDED FOR ML-BRU-CRF-0469
									pat_payable = (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
									decimalFormatString = ((String)drug_detail.get("BL_DECIMAL_FORMAT_STRING")==null || ((String)drug_detail.get("BL_DECIMAL_FORMAT_STRING")).equals(""))?"##.00":(String)drug_detail.get("BL_DECIMAL_FORMAT_STRING");
									if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| !totalTaperQtyDisplay.equals("Y") || !drug_tapered.equals("Y")) {
										tot_payable_sum += Float.parseFloat(tot_payable);
										tot_gross_payable_sum += Float.parseFloat(tot_gross_payable);//ADDED FOR ML-BRU-CRF-0469
										pat_payable_sum += Float.parseFloat(pat_payable);
									}
								}
							}
						}
					}
				}

				presDetails = consumable_bean.getPresItemList();
				if(presDetails!=null && presDetails.size()>0){
					for (int i=0; i<presDetails.size(); i++) {
						drug_detail	= (HashMap)presDetails.get(i);	
						drug_tapered = drug_detail.get("DRUG_TAPERED_YN")==null?"":(String)drug_detail.get("DRUG_TAPERED_YN");
						tappered_over = drug_detail.get("TAPPERED_OVER")==null?"":(String)drug_detail.get("TAPPERED_OVER");
						tot_payable = (String)drug_detail.get("BL_CHARGE_AMT")==null?"0.0f":(String)drug_detail.get("BL_CHARGE_AMT");
						tot_gross_payable = (String)drug_detail.get("BL_GROSS_AMT")==null?"0.0f":(String)drug_detail.get("BL_GROSS_AMT");//ADDED FOR ML-BRU-CRF-0469
						pat_payable = (String)drug_detail.get("BL_PATIENT_PAYABLE")==null?"0.0f":(String)drug_detail.get("BL_PATIENT_PAYABLE");
						decimalFormatString = (String)drug_detail.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)drug_detail.get("BL_DECIMAL_FORMAT_STRING");

						if(tot_payable.equals(""))
							tot_payable = "0.0f";
						if(tot_gross_payable.equals(""))//ADDED FOR ML-BRU-CRF-0469
							tot_gross_payable = "0.0f";
						if(pat_payable.equals(""))
							pat_payable = "0.0f";
							if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| !totalTaperQtyDisplay.equals("Y") || !drug_tapered.equals("Y")) {
							tot_payable_sum += Float.parseFloat(tot_payable);
							tot_gross_payable_sum += Float.parseFloat(tot_gross_payable);//ADDED FOR ML-BRU-CRF-0469
							pat_payable_sum += Float.parseFloat(pat_payable);
						}
					}	
				}
			}

%>
				<table border="0" width="98%" height="100%" cellspacing="0" cellpadding="0" >
					<tr><td width="35%" class="white"> 
					<tr>
					<%if(displayGrossAmtYn){ %>
						<td width='100%' colspan="3" class="white">
					<%} else{%>
					<td width='91%' colspan="2" class="white">
					<%} %>
							<table  border="2" bordercolor="black">
								<tr>
<%
									if(drug_db_interface_yn.equals("Y")){
%>
										<td WRAP width="5%"   class="SHIFTTOTAL"><img src='../../ePH/images/exceed1.gif' ></img></td><td WRAP  width="25%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/></td>
<%
									}
%>
									<td WRAP width="1%" class="ALLERGY" style= "background-color:red"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td WRAP  width="10%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td>
									<td  WRAP width="5%" style= "background-color:orange" class="DOSELIMIT"  border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td  WRAP  width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white" ><fmt:message key="ePH.BeyondDoseLimit.label" bundle="${ph_labels}"/></td>
									<td  WRAP width="5%" class="CURRENTRX"  style= "background-color:blue" 
									border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td  WRAP width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
									<td  WRAP width="5%" class="DOSELIMIT1" style= "background-color:pink" 
									border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td  WRAP width="25%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/></td>
								<!-- added for aakh-crf-0140 -->
								<%if(drug_abuse_appl){ %>
								<td  WRAP width="5%" style="BACKGROUND-COLOR:purple;" class="DOSELIMIT1"
									border="1" bordercolor="purple"><img src='../../ePH/images/exceed1.gif' ></img></td>
								<td  WRAP width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white">Drug Abuse</td>
								</tr>
								<%} %>
<%	//added for GHL-CRF-0482 -start
							if(patient_stock_required){
%>
								<tr height='25px' width="5%">
								<td WRAP width="5%" class="AMENDEDDRUGS"><img src='../../ePH/images/blank.gif'></td><td WRAP  width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="Common.confirm.label" bundle="${common_labels}"/></td>
								<td WRAP width="5%" class="NOTCONFIRM"><img src='../../ePH/images/blank.gif'></td><td WRAP  width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.NotConfirm.label" bundle="${ph_labels}"/></td>
								<td WRAP width="5%" class="PATIENTSTOCKAMEND"><img src='../../ePH/images/blank.gif'></td><td WRAP  width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.PatientStock.label" bundle="${ph_labels}"/></td>
								
								</tr>
<% 
}	//added for GHL-CRF-0482 -end
%>
								
							</table>
						</td>
					</tr>
<%
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
						//charge_amt = Double.parseDouble(patient_payable_amt)+"";
						tot_payable_sum_str = dfTest.format(tot_payable_sum);
						tot_gross_payable_sum_str = dfTest.format(tot_gross_payable_sum);//ADDED FOR ML-BRU-CRF-0469
						pat_payable_sum_str = dfTest.format(pat_payable_sum);
			
						/*if(pat_brought_medn.equals("Y")) //added for IN21314 --10/06/2010-- priya
							{
								tot_payable_sum_str = "--";
								pat_payable_sum_str = "--";
							} */

%>
						<tr>
						<%if(displayGrossAmtYn){ %>
							
							<td class="label" nowrap width='35%' style="font-size:10px;TEXT-ALIGN:right;" ><fmt:message key="ePH.Total.label" bundle="${ph_labels}"/> <fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/>
							</td>
						      <td class="label" nowrap width='20%' style="font-size:10px;TEXT-ALIGN:right;padding-right: 30px;"  ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" nowrap width='35%' style="font-size:10px;TEXT-ALIGN:right;"><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
							</td>
							<%} else{ %>
							  <td class="label" nowrap width='50%' style="font-size:10px;TEXT-ALIGN:right; padding-right: 30px;"  ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" nowrap width='50%' style="font-size:10px;TEXT-ALIGN:right;"  ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
							</td>
							<%} %>
						</tr>
						<tr>
					<%if(displayGrossAmtYn){ %>
								
					     	<td   class="data" id='gross_charge_amt'  width='35%' align='right' style="font-size:10px"><%=tot_gross_payable_sum_str%>&nbsp;&nbsp;<!-- ADDED FOR ML-BRU-CRF-0469 -->
							</td>
							<td   class="data" id='bl_total_charge_amt'  width='20%' align='right' style="font-size:10px; padding-right: 30px;"><%=tot_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<td   class="data" id='bl_patient_payable_amt'  width='35%' align='right' style="font-size:10px ;"><%=pat_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<%} else{ %>
							<td   class="data" width='50%' align='left' style="font-size:10px;TEXT-ALIGN:right; padding-right: 30px;"><%=tot_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<td   class="data" width='50%' align='left' style="font-size:10px;TEXT-ALIGN:right; "><%=pat_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<%} %>
						</tr>
<%
					}
%>
					<tr style='display:<%=previewReleaseDisp%>'><!-- style //added for ML-MMOH-CRF-0341 [IN:057179] -->
							<%if(displayGrossAmtYn){ %>
						<td   class="white" width='35%'>
						<input type="button" class="button" value='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>' onClick="javascript:callPreviewOrders();" style="cursor:pointer"></input></td>	

						<td width="35%" class="white"> 
							<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" onclick="record(this)"></input>
						</td>
						<td   class="white" width="35%" ></td>
						<%} else{ %>
						<td   class="white" width='50%'>
						<input type="button" class="button" value='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>' onClick="javascript:callPreviewOrders();" style="cursor:pointer"></input></td>	

						<td width="50%" class="white"> 
							<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" onclick="record(this)"></input>
						</td>
						<%} %>
					</tr>
					<tr style='display:<%=previewManDisp%>'><!-- style //added for ML-MMOH-CRF-0341 [IN:057179] -->
						<td  class="white" width='50%' align='center' colspan="2"><input type="button" class="button" value='Preview & Release RX' onClick="javascript:callPreviewOrders();" style="cursor:pointer"></input></td>	
						<input type=hidden name="chk_preview_rx" id="chk_preview_rx" value='<%=chk_preview_rx%>'/>	<!--AAKH-CRF-0091 -->
					</tr>
				</table> 
<%
		//	}
%>
			<input type='hidden' name='beanid' id='beanid' value='<%=bean_id%>'>
			<input type='hidden' name='rx_button_disable' id='rx_button_disable' value='<%=bean.DisableNormalRxButton()%>'><!-- Added for KDAH-SCF-0382 -->
		</form>
<%
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(presBean_id,presBean,request);
%>
	</body>
</html>



