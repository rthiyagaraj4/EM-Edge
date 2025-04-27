<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>  
	<head>
<!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
 <%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<!-- 	    <script language="JavaScript" src="../js/PhMessages.js"></script>
 -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>-->
		<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="amendPreviewForm" id="amendPreviewForm">
<%
			String patient_id	= request.getParameter("patient_id");
			String encounter_id	= request.getParameter("encounter_id");
			String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name	= "ePH.PrescriptionBean_1";
			String drug_db_interface_yn = (String)request.getParameter("drug_db_interface_yn")==null?"":(String)request.getParameter("drug_db_interface_yn");
			PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(locale);
			//added for ml-bru-crf-0469
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
			String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
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
			String billable_item_yn = "";
			String preview_rx_yn=bean.getPreviewRxYN(); //added for ML-MMOH-CRF-0341 [IN:057179] start
			String previewManDisp = "none", previewReleaseDisp="inline";

			 boolean displayGrossAmtYn = presBean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
			if(preview_rx_yn.equals("Y")){
				previewManDisp = "inline";
				previewReleaseDisp = "none";
			}//added for ML-MMOH-CRF-0341 [IN:057179] end
			ArrayList presDetails	= new ArrayList();
			presDetails				=(ArrayList) bean.getpresDetails();
			HashMap drug_detail = null;
			if(presDetails.size()>0){
				for(int i=0;i<presDetails.size();i++){			
					drug_detail=(HashMap) presDetails.get(i);
					billable_item_yn = (String)drug_detail.get("BILLABLE_ITEM_YN")==null?"Y":(String)drug_detail.get("BILLABLE_ITEM_YN");
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						tot_payable = (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0f":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
						tot_gross_payable = (String)drug_detail.get("BL_GROSS_CHARGE_AMT")==null?"0.0f":(String)drug_detail.get("BL_GROSS_CHARGE_AMT");//ADDED FOR ML-BRU-CRF-0469
						pat_payable = (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0f":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
						decimalFormatString = (String)drug_detail.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drug_detail.get("BL_DECIMAL_FORMAT_STRING");
						if(tot_payable.equals(""))
							tot_payable = "0.0f";
						if(tot_gross_payable.equals(""))//ADDED FOR ML-BRU-CRF-0469
							tot_gross_payable = "0.0f";
						if(pat_payable.equals(""))
							pat_payable = "0.0f";
						if(billable_item_yn.equals("Y")){
							tot_payable_sum += Float.parseFloat(tot_payable);
							tot_gross_payable_sum += Float.parseFloat(tot_gross_payable);//ADDED FOR ML-BRU-CRF-0469
							pat_payable_sum += Float.parseFloat(pat_payable);
						}
					}
				}
%>
				<table border="0" width="100%" height="90%" cellspacing="0" cellpadding="0" >
				<tr>
					<td colspan="3" class="white">
						<table  width='100%' border="2" bordercolor="black">
							<tr>
<%
							if(drug_db_interface_yn.equals("Y")){
%>
									<td WRAP width="5%" class="SHIFTTOTAL"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td width="5%" WRAP style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/></td>
<%
							}
%>
								<td WRAP width="5%" class="ALLERGY"><img src='../../ePH/images/exceed1.gif' ></img></td>
								<td WRAP  width="5%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td>
								<td  WRAP width="5%" class="DOSELIMIT"  border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
								<td  WRAP  width="5%" style="font-size:7pt" class="white" border="0" bordercolor="white" ><fmt:message key="ePH.BeyondDoseLimit.label" bundle="${ph_labels}"/></td>
								<td  WRAP width="5%" class="CURRENTRX"
								border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
								<td  WRAP width="5%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
								<TD class="white"></TD>
								<!--added for aakh-crf-0140 -->
								<td  WRAP width="5%" style="BACKGROUND-COLOR:purple;" class="DOSELIMIT"
									border="1" bordercolor="purple"></td>
								<td  WRAP width="5%" style="font-size:7pt" class="white" border="0" bordercolor="white">Drug Abuse</td>
								</tr>
								
							</tr>
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
%>
						<tr>
							<%if(displayGrossAmtYn){ %>
							
							<td class="label" WRAP width='35%' style="font-size:9pt;TEXT-ALIGN:right;"  ><fmt:message key="ePH.Total.label" bundle="${ph_labels}"/> <fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" WRAP width='35%' style="font-size:9pt;TEXT-ALIGN:right;"  ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" WRAP width='35%' style="font-size:9pt;TEXT-ALIGN:right;"  ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
							</td>
							
							
							<%} else{ %>
						     <td class="label" WRAP width='50%' style="font-size:9pt;TEXT-ALIGN:right;"  ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>
							</td>
						      <td class="label" WRAP width='50%' style="font-size:9pt;TEXT-ALIGN:right;"  ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
							</td>
							
						
							<%} %>
							
						</tr>
						<tr>
							<%if(displayGrossAmtYn){ %>
							
							<td   class="data" width='35%' align='right' style="font-size:9pt;TEXT-ALIGN:right;"><%=tot_gross_payable_sum_str%>&nbsp;&nbsp;
							</td><!-- ADDED FOR ML-BRU-CRF-0469 -->
							<td   class="data" width='35%' align='right' style="font-size:9pt;TEXT-ALIGN:right;"><%=tot_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<td   class="data" width='35%' align='right' style="font-size:9pt;TEXT-ALIGN:right;"><%=pat_payable_sum_str%>&nbsp;&nbsp;
							</td>
							
							
							<%} else{ %>
							<td   class="data" width='45%' align='left' style="font-size:9pt;TEXT-ALIGN:right;"><%=tot_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<td   class="data" width='45%' align='left' style="font-size:9pt;TEXT-ALIGN:right;"><%=pat_payable_sum_str%>&nbsp;&nbsp;
							</td>
							<TD class="white"></TD>
							<%} %>
						</tr>
<%
					}
%>
					<tr id='trPreviewRelease' style='display:<%=previewReleaseDisp%>' ><!--style //added for ML-MMOH-CRF-0341 [IN:057179] -->
							<%if(displayGrossAmtYn){ %>
							<td width="35%" class="white"><input type="button"   class="button" value='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>'  name="preview_butt" onClick="javascript:callPreviewOrdersAmend();" style="cursor:pointer" disabled></input>
						</td>
						<td width="35%" class="white"> <input type="button" class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_butt" onclick="releaseRx()" disabled></input>
						</td>
						<TD class="white"></TD>
						<%} else{ %><td width="45%" class="white"><input type="button"   class="button" value='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>'  name="preview_butt" onClick="javascript:callPreviewOrdersAmend();" style="cursor:pointer" disabled></input>
						</td>
						<td width="45%" class="white"> <input type="button" class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_butt" onclick="releaseRx()" disabled></input>
						</td>
						<TD class="white"></TD>
						<%} %>
					</tr>
					<tr id='trPreviewMand' style='display:<%=previewManDisp%>'><!--tr //added for ML-MMOH-CRF-0341 [IN:057179] -->
						<td  class="white"  width='50%' align='center' colspan="2"><input type="button" class="button" name="previewReleaseRx" id="previewReleaseRx" value='Preview & Release RX' onClick="javascript:callPreviewOrdersAmend();" style="cursor:pointer" disabled></input>
						</td>	
					</tr>
				</table> 
<%
			}
%>
			<input type='hidden' name='preview_rx_yn' id='preview_rx_yn' value='<%=preview_rx_yn%>'>
		</form>
<%
		putObjectInBean(bean_id,bean,request);
       putObjectInBean(presBean_id,presBean,request);
%>
	</body>
	<script>
		setTimeout("enableAmendRelease();",1000);
	</script>
</html>

