<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- modified for AAKH-CRF-0117-->
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	    <!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!--	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
-->		<script language="JavaScript" src="../js/ReissueMed.js"></script>
	    <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
	<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->
	<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown="" onKeyDown="lockKey()">
		<form name="FormReissueMedicationResult" id="FormReissueMedicationResult" >
<%
			Connection con			= null; //AAKH-CRF-0117
try{		
			con				= ConnectionManager.getConnection(request);//AAKH-CRF-0117
			String bean_id			= request.getParameter("bean_id");
			String bean_name		= request.getParameter("bean_name");	
			String Patientid		= request.getParameter("PatientId");
			String DrugCode			= request.getParameter("DrugCode");
			String Disp_date_from	= request.getParameter("Disp_date_from");
			String Disp_date_to		= request.getParameter("Disp_date_to");		
			String ordering_facility_id	= request.getParameter("ordering_facility_id");		
			String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
			String facility_id		= (String) session.getValue("facility_id");
			String reissue_type_ind  ="";//Added for Bru-HIMS-CRF-405[IN 044830]
			String reissue_count_by_ind = "";//Added for Bru-HIMS-CRF-405[IN 044830]
			String reissue_count    = "";//Added for Bru-HIMS-CRF-405[IN 044830]
			HashMap result = new HashMap();
			ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(locale);
			bean.clear() ;
			bean.getTokenSeries();
			bean.setBillingParams(); //added for SRR20056-SCF-7639 ICN027720 -start
            bean.setOrderingFacilityID(ordering_facility_id);
			String disp_cash_coll_stage =bean.getDispCashCollStage();
			String bl_interface_yn  = bean.checkforbillinginterface();
   			result = bean.getReissueResult(DrugCode,Disp_date_from,Disp_date_to,Patientid);
			//AAKH-CRF-0117 - start
			boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117

		  	String approval_no_app_for_patient_class = "N";
			/*if(approval_no_flag){ //commented and moved to down for AAKH-CRF-0117
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass((String)othdetails.get(16));
			} //AAKH-CRF-0117 - end */
			if(result.size() > 0){
				ArrayList Reasons = new ArrayList();
				ArrayList othdetails = new ArrayList();
				Reasons = (ArrayList)result.get("REASON");
				othdetails = (ArrayList)result.get("DETAIL");
				if (othdetails.size() > 0  ) {
					bean.setPatientClass((String)othdetails.get(16));
					String colval = ((String)othdetails.get(5));
					String gender_String="";
					String clval="";
					StringBuffer sb=new StringBuffer();
					String comp_str ="";
					java.util.StringTokenizer st = new java.util.StringTokenizer(colval,",");
					while( st.hasMoreTokens()) {
						comp_str = st.nextToken();
						if((! (comp_str.trim().equals("female") || comp_str.trim().equals("male") || comp_str.trim().equals("unknown") )))
							sb.append(comp_str.trim()+" ");
						if(comp_str.trim().equals("female"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						if(comp_str.trim().equals("male"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						if(comp_str.trim().equals("unknown"))
							gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						clval=sb.toString()+" "+gender_String;
					}
%>
					<table  cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="disptab">
					<tr>
						<td  class="data" colspan="2">&nbsp&nbsp<%=clval%></td>
						<td align="right" class="label"><fmt:message key="ePH.DispensedAt.label" bundle="${ph_labels}"/></td>
						<td class="data" >&nbsp&nbsp<%=othdetails.get(0)%></td>
					</tr>
					</table>
					<input type="hidden"  name="loc_code" id="loc_code"      value =<%=othdetails.get(1)%>>
					<input type="hidden"  name="patient_class" id="patient_class" value =<%=othdetails.get(16)%>>
					<input type="hidden"  name="order_id" id="order_id"      value =<%=othdetails.get(12)%>>
					<input type="hidden"  name="fill_period" id="fill_period"   value =<%=othdetails.get(17)%>>
					<input type="hidden"  name="fill_unit" id="fill_unit"     value =<%=othdetails.get(18)%>>
					<input type="hidden" name="patient_id" id="patient_id"     value='<%=Patientid%>'>
					<input type="hidden" name="Disp_date_from" id="Disp_date_from" value='<%=Disp_date_from%>'>
					<input type="hidden" name="Disp_date_to" id="Disp_date_to"   value='<%=Disp_date_to%>'>
					<table width='100%' border="1" id="Tdispensingdetails" name="Tdispensingdetails" id="Tdispensingdetails">
					<tr>
						<th colspan="10" align="left"><fmt:message key="ePH.IssuedDetails.label" bundle="${ph_labels}"/></th> <!-- modified for AAKH-CRF-0117-->
					</tr>
					<tr>
						<th width="15%"><fmt:message key="ePH.DispensedDrug.label" bundle="${ph_labels}"/></th> 
                      <th width="15%"><fmt:message key="ePH.Dispensedfacility.label" bundle="${ph_labels}"/></th> <!-- Added for FD-BRU-CRF-092 -->
                        <th width="10%"><fmt:message key="ePH.DispensedLocation.label" bundle="${ph_labels}"/></th> <!-- Added for FD-BRU-CRF-092 -->
						<th width="10%"><fmt:message key="ePH.IssuedQuantity/UOM.label" bundle="${ph_labels}"/></th>  <!-- Re-issuedQuantity changed to IssuedQuantity for  HSA-SCF-019 [IN:048416] -->
						<th width="5%"><fmt:message key="ePH.Reissue.label" bundle="${ph_labels}"/>? </th>
						 <%if(bl_interface_yn.equals("Y")){%>							
							<th width="10%"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></th>
							<th width="10%"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></th>
							<th width="5%"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>?</th>
						<%}%>

						<th width="13%"><fmt:message key="ePH.ReissueReason.label" bundle="${ph_labels}"/></th>
					<%if(approval_no_flag){ //added for AAKH-CRF-0117 
					%>
					<th width="15%" nowrap> <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</th>
					<%} %>
					</tr>
<%
					String classvalue="";
					int j=0;
					boolean approval_flag = false; //AAKH-CRF-0117
					String	disabled	  = "disabled"; //AAKH-CRF-0117
					for(int recCount=0; recCount<othdetails.size()-1; recCount+=37){//27 to 37 for [IN052983]//Increase size from 24 to 27 for Bru-HIMS-CRF-405[IN 044830]
						if ( j % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;
						reissue_type_ind	 =(String)othdetails.get( recCount+24)==null?"":(String)othdetails.get( recCount+24);//Added for Bru-HIMS-CRF-405[IN 044830]
						reissue_count_by_ind=(String)othdetails.get( recCount+25)==null?"":(String)othdetails.get( recCount+25);//Added for Bru-HIMS-CRF-405[IN 044830]
						reissue_count      =(String)othdetails.get( recCount+26)==null?"":(String)othdetails.get( recCount+26);//Added for Bru-HIMS-CRF-405[IN 044830]
						approval_no_app_for_patient_class = "N";
						if(approval_no_flag){
					  approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass((String)othdetails.get(recCount+16));
					} //AAKH-CRF-0117
%>
							<tr id="row_<%=j%>">
<%								
								if(  ((String)othdetails.get( recCount+11)).equals("Y")){	
%>
									<td class="<%=classvalue%>" onmouseover="changeCursor(this);" >
									<font class='HYPERLINK'  id="drug_name<%=j%>"  onclick="callBatchDetails('<%=(String)othdetails.get( recCount+9)%>','<%=(String)othdetails.get( recCount+10)%>','<%=(String)othdetails.get( recCount+8 )%>','<%=j%>','<%=Patientid%>','<%=(String)othdetails.get( recCount+12)%>','<%=(String)othdetails.get( recCount+13)%>','<%=(String)othdetails.get( recCount+6)%>','<%=(String)othdetails.get( recCount+14)%>','<%=j%>','<%=(String)othdetails.get( recCount+2)%>','<%=(String)othdetails.get( recCount+22)%>',document.FormReissueMedicationResult.durg_name<%=j%>)"><%=(String)othdetails.get( recCount+7)%></font></td>
                                     <!-- <%=(String)othdetails.get( recCount+22)%> added for passing Disp_facility_id -->
									<input type="hidden" name="drugcode_<%=j%>" id="drugcode_<%=j%>" value ='<%=(String)othdetails.get( recCount+6)%>' >
									<input type="hidden" name="OrderId<%=j%>" id="OrderId<%=j%>" value ='<%=(String)othdetails.get(recCount+12)%>'><!-- Modified for ICN_ADHOC_016 -->
									<input type="hidden" name="OrderLine_<%=j%>" id="OrderLine_<%=j%>" value ='<%=(String)othdetails.get(recCount+13)%>'>
									<input type="hidden" name="DispLocCode_<%=j%>" id="DispLocCode_<%=j%>" value ='<%=(String)othdetails.get(recCount+1)%>'>
									<input type="hidden" name="end_date_<%=j%>" id="end_date_<%=j%>" value ='<%=(String)othdetails.get( recCount+14)%>'>
									<input type="hidden" name="Uom_<%=j%>" id="Uom_<%=j%>" value ='<%=(String)othdetails.get( recCount+15)%>'>
									<input type="hidden" name="UnitCost_<%=j%>" id="UnitCost_<%=j%>" value ='<%=(String)othdetails.get( recCount+19)%>'>
									<input type="hidden" name="encounter_id_<%=j%>" id="encounter_id_<%=j%>" value ='<%=(String)othdetails.get( recCount+20)%>'>
									<input type="hidden" name="disp_no<%=j%>" id="disp_no<%=j%>" value ='<%=(String)othdetails.get( recCount+2)%>' >
									<input type="hidden" name="reissuableqty<%=j%>" id="reissuableqty<%=j%>" value ='<%=(String)othdetails.get( recCount+8)%>' >
									<input type="hidden" name="discharge_ind<%=j%>" id="discharge_ind<%=j%>" value ='<%=(String)othdetails.get( recCount+21)%>' >
									<input type="hidden" name="durg_name<%=j%>" id="durg_name<%=j%>" value ='<%=java.net.URLEncoder.encode((String)othdetails.get( recCount+7),"UTF-8")%>' > <!-- added for ML-BRU-SCF-1073 by Ganga -->
									<input type="hidden" name="reissue_type_ind<%=j%>" id="reissue_type_ind<%=j%>"	   value ='<%=reissue_type_ind%>'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->
									<input type="hidden" name="reissue_count_by_ind<%=j%>" id="reissue_count_by_ind<%=j%>" value ='<%=reissue_count_by_ind%>'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->
									<input type="hidden" name="reissue_count<%=j%>" id="reissue_count<%=j%>" value ='<%=reissue_count%>' ><!--Added for Bru-HIMS-CRF-405[IN 044830] -->
									<input type="hidden" name="label_cau_instrn1_eng<%=j%>" id="label_cau_instrn1_eng<%=j%>" value ='<%=(String)othdetails.get(recCount+27)%>' ><!--Added for [IN:052983] start-->
									<input type="hidden" name="label_cau_instrn2_eng<%=j%>" id="label_cau_instrn2_eng<%=j%>" value ='<%=(String)othdetails.get(recCount+28)%>' >
									<input type="hidden" name="label_spl_instrn1_eng<%=j%>" id="label_spl_instrn1_eng<%=j%>" value ='<%=(String)othdetails.get(recCount+29)%>' >
									<input type="hidden" name="label_spl_instrn2_eng<%=j%>" id="label_spl_instrn2_eng<%=j%>" value ='<%=(String)othdetails.get(recCount+30)%>' >
									<input type="hidden" name="label_pat_instrn1_eng<%=j%>" id="label_pat_instrn1_eng<%=j%>" value ='<%=(String)othdetails.get(recCount+31)%>' >
									<input type="hidden" name="label_cau_instrn1_loc<%=j%>" id="label_cau_instrn1_loc<%=j%>" value ='<%=(String)othdetails.get(recCount+32)%>' >
									<input type="hidden" name="label_cau_instrn2_loc<%=j%>" id="label_cau_instrn2_loc<%=j%>" value ='<%=(String)othdetails.get(recCount+33)%>' >
									<input type="hidden" name="label_spl_instrn1_loc<%=j%>" id="label_spl_instrn1_loc<%=j%>" value ='<%=(String)othdetails.get(recCount+34)%>' >
									<input type="hidden" name="label_spl_instrn2_loc<%=j%>" id="label_spl_instrn2_loc<%=j%>" value ='<%=(String)othdetails.get(recCount+35)%>' >
									<input type="hidden" name="label_pat_instrn1_loc<%=j%>" id="label_pat_instrn1_loc<%=j%>" value ='<%=(String)othdetails.get(recCount+36)%>' ><!--Added for [IN:052983] end-->

                                   <input type="hidden" name="batch_ids_<%=j%>" id="batch_ids_<%=j%>" value ='' >
								   <input type="hidden" name="binlocation_codes_<%=j%>" id="binlocation_codes_<%=j%>" value ='' >
								   <input type="hidden" name="expiary_dates_<%=j%>" id="expiary_dates_<%=j%>" value ='' >
								   <input type="hidden" name="issued_qty_<%=j%>" id="issued_qty_<%=j%>" value ='' >
                                     <td class="<%=classvalue%>" align="left"><%=(String)othdetails.get(recCount+23) %> </td> <!-- Added for FD-BRU-CRF-092 -->
                                     <td class="<%=classvalue%>" align="left"><%=(String)othdetails.get(recCount)%></td> <!-- Added for FD-BRU-CRF-092 -->
									<!-- <td class="<%=classvalue%>"><%= (String)othdetails.get( recCount+8 )%>/
									<%=(String)othdetails.get( recCount+15)%></td><!-- Modified for Issuee 11510 commented on 8/10/09--> 
									<td class="<%=classvalue%>"><%= (String)othdetails.get( recCount+8 )%>&nbsp;&nbsp;  
									<%=bean.getUomDisplay(facility_id,othdetails.get(recCount+15).toString())%></td><!-- Modified for Issuee 11510 -->
									<td class="<%=classvalue%>" align="left">
										<label id="reissueqty_<%=j%>">&nbsp;</label>
										<label id="reissueunit_<%=j%>">&nbsp;</label>
										&nbsp;<input style='text-align:right;' type='checkbox' id="reissue_vis_<%=j%>" name="reissue_vis_<%=j%>" onClick="updateRecords(this,'<%=(String)othdetails.get( recCount+6)%>','<%=(String)othdetails.get( recCount+2)%>','<%=j%>')">
									</td>
<%
									if(bl_interface_yn.equals("Y")){
%>
                                         <td class="<%=classvalue%>" id='gross_charge_amount_display_<%=j%>' ><label ></label>&nbsp;</td>
										 <td class="<%=classvalue%>" id='groos_pat_payable_display_<%=j%>'><label ></label>&nbsp;</td>
										 <td class="<%=classvalue%>" id='inc_exec_<%=j%>'><label ></label>&nbsp;</td>   
										 <input type="hidden" name="gross_charge_amount_<%=j%>" id="gross_charge_amount_<%=j%>" value="">
										 <input type="hidden" name="groos_pat_payable_<%=j%>" id="groos_pat_payable_<%=j%>"   value="">
<%
									}
%>
									<td class="<%=classvalue%>" align="center">&nbsp;&nbsp;
										<select name='reasons<%=j%>' id='reasons<%=j%>'  onChange = "updateReason(this,'<%=j%>');">
<% 
											for(int i=0; i < Reasons.size();i+=2){	
%>
												<option value=<%=Reasons.get(i)%> ><%=Reasons.get(i+1)%></option>
<%  
											}
%>
										</select>&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif">
<%
									}
									else{ 
%>
										<td class="<%=classvalue%>" ><%=(String)othdetails.get( recCount+7)%></td>
										<input type="hidden" name="drugcode_<%=j%>" id="drugcode_<%=j%>" value ='<%=(String)othdetails.get( recCount+6)%>' >
										<td class="<%=classvalue%>" align="center"><%=(String)othdetails.get( recCount+3)%></td>
										<input type="hidden" name="disp_no<%=j%>" id="disp_no<%=j%>" value ='<%=(String)othdetails.get( recCount+2)%>' >
										<td class="<%=classvalue%>" ><label id="reissueqty_<%=j%>"></label> &nbsp;&nbsp<label id="reissueunit_<%=j%>"></label></td>
<%
										if(bl_interface_yn.equals("Y")){
%>
											 <td class="<%=classvalue%>" id='gross_charge_amount_display_<%=j%>' ><label ></label>&nbsp;</td>
										     <td class="<%=classvalue%>" id='groos_pat_payable_display_<%=j%>'><label ></label>&nbsp;</td>
											 <td class="<%=classvalue%>" id='inc_exec_<%=j%>'><label ></label>&nbsp;</td>
											 <input type="hidden" name="gross_charge_amount_<%=j%>" id="gross_charge_amount_<%=j%>" value="">
											 <input type="hidden" name="groos_pat_payable_<%=j%>" id="groos_pat_payable_<%=j%>"   value="">					 
<%
										}
%>
                                   <input type="hidden" name="batch_ids_<%=j%>" id="batch_ids_<%=j%>" value ='' >
								   <input type="hidden" name="binlocation_codes_<%=j%>" id="binlocation_codes_<%=j%>" value ='' >
								   <input type="hidden" name="expiary_dates_<%=j%>" id="expiary_dates_<%=j%>" value ='' >
								   <input type="hidden" name="issued_qty_<%=j%>" id="issued_qty_<%=j%>" value ='' >
								   <input type="hidden" name="reissue_type_ind<%=j%>" id="reissue_type_ind<%=j%>"	   value ='<%=reissue_type_ind%>'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->
								   <input type="hidden" name="reissue_count_by_ind<%=j%>" id="reissue_count_by_ind<%=j%>"  value ='<%=reissue_count_by_ind%>'><!--Added for Bru-HIMS-CRF-405[IN 044830] -->
								   <input type="hidden" name="reissue_count<%=j%>" id="reissue_count<%=j%>"		   value ='<%=reissue_count%>' ><!--Added for Bru-HIMS-CRF-405[IN 044830] -->

										<td class="<%=classvalue%>">&nbsp;&nbsp;
											<select name='reasons<%=j%>' id='reasons<%=j%>' disabled>
												<option selected value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${ph_labels}"/>---&nbsp;&nbsp;</option>
											</select>	
										</td>
<%
									}
						 
						if(approval_no_flag) { //added for AAKH-CRF-0117
%>
						<td class="<%=classvalue%>" nowrap>    
					 <input type="text" value="" maxlength="20"  name="approval_no_<%=j%>" id="approval_no_<%=j%>" <%=disabled%> onchange="getApprovalNumForDrug(this,<%=j%>)" onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'R',<%=j%>)"/> <!--MODIFIED FOR AAKH-CRF-0117 -->
					 <% //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y")){ %>
						<img id="imgForWithin" src="../../eCommon/images/mandatory.gif" align="center" style="visibility:visible"></img>	
						<%}
						
					%>
					 <input type="hidden" name="order_id_<%=j%>" id="order_id_<%=j%>" value ='<%=othdetails.get(recCount+12)%>' ><!-- AAKH-CRF-0117 modified again for AAKH-CRF-0117-->
					<input type="hidden" name="order_line_no_<%=j%>" id="order_line_no_<%=j%>" value ='<%=othdetails.get(recCount+13)%>' ><!-- AAKH-CRF-0117 modified again for AAKH-CRF-0117-->
					<input type="hidden" name="approval_no_app_for_patient_class_<%=j%>" id="approval_no_app_for_patient_class_<%=j%>" value="<%=approval_no_app_for_patient_class%>"> <!-- AAKH-CRF-0117-->
					
					 </td> 
<%
					} %>
								</tr>
<%
							j=j+1;
						}
						// if(bl_interface_yn.equals("Y")){
%>
							<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="">
							<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable"   value="">
							<input type="hidden" name="tot_rec" id="tot_rec"   value="<%=j%>">
							
							
<%						//}	
}
					else{
%>
						<script>
							alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA',"Common")); 
		//window.close();
						</script>
<%
					}
				}
%>
				<input type="hidden" name="bean_id" id="bean_id"                value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"              value="<%=bean_name%>">
				<INPUT TYPE="hidden" name="mode" id="mode"                   VALUE="<%= mode %>">
				<INPUT TYPE="hidden" name="querytext" id="querytext"              VALUE="">
				<input type="hidden" name="bl_interface_yn" id="bl_interface_yn"        value="<%=bl_interface_yn%>">
				<input type="hidden" name="disp_cash_coll_stage" id="disp_cash_coll_stage"   value="<%=disp_cash_coll_stage%>">
				<input type="hidden" name="approval_no_flag" id="approval_no_flag" value="<%=approval_no_flag%>"><!-- AAKH-CRF-0117-->
				<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=approval_no_app_for_patient_class%>"> <!-- AAKH-CRF-0117-->
			</table>
		</form>
<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{  //AAKH-CRF-0117
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%>
	</body>
</html>
	<script>
		if(document.getElementById("drug_name0")){
			document.getElementById("drug_name0").click();
			for(var i=0;i<document.getElementById("row_0").cells.length;i++)
				document.getElementById("row_0").cells[i].style.backgroundColor	= "#fde6d0";
		}
</script>

