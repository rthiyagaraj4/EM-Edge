<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ --> 

 <%--This file is saved on 04/06/2007 --%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name      = (String) session.getValue( "login_user" ) ; //Added for MOHE-CRF-0074
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id				= "ReRoutePrescriptionsBean";
		String bean_name			= "ePH.ReRoutePrescriptionsBean";
		ReRoutePrescriptionsBean bean		= (ReRoutePrescriptionsBean)getBeanObject( bean_id,bean_name,request);
		String sql_Re_Route_select1			=PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_DISP_LOCN_SELECT_LOOKUP");
		//String sql_Re_Route_select1=" select a.disp_locn_code code, a.short_desc description from ph_disp_locn_lang_vw a where  upper(a.disp_locn_code) like upper(?) and upper(a.short_desc) like upper(?) AND a.eff_status = 'E' ";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/ReRoutePrescription.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formReRoutePrescriptionsResult" id="formReRoutePrescriptionsResult" >
<%
			Connection con			= null;  // Added for MOHE-CRF-0074 - start
			try{
			  con				= ConnectionManager.getConnection(request);
			  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
			// Added for MOHE-CRF-0074 - END
			//Search Criteria's from Query Criteria page
			//	String dt_from		= request.getParameter("dt_from");
			String disp_locn	= request.getParameter("disp_locn")==null?"":request.getParameter("disp_locn");
			String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String facility_id	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			//	String dt_to		= request.getParameter("dt_to");
			//newly added by manickam --start
			String re_route_via_reg_ord = request.getParameter("re_route_via_reg_ord")==null?"":request.getParameter("re_route_via_reg_ord");
			String disp_locn_code = request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
			String height			= "";
			String weight			= "";
			String ht_uom			= "";
			String wt_uom			= "";
			String age				= "";
			String sex				= "";
			String patient_class	= "";
			String encounter_id		= "";
			// added for Bru-HIMS-CRF-090 [IN:029956]--start
			int medication_rec				= 0;
			String take_medication_yn_chk	= "";
			String take_medication_yn_dis	= "";
			String take_medication_yn_val	= "";
			String take_medication_yn	= "";
			// for Bru-HIMS-CRF-090 [IN:029956]--end
			ArrayList ht_wt			= bean.getHtWt(patient_id);
			if(ht_wt.size()!=0 ) {
				height			=	(String)ht_wt.get(0);
				ht_uom			=	(String)ht_wt.get(1);
				weight			=	(String)ht_wt.get(2);
				wt_uom			=	(String)ht_wt.get(3);
				patient_class			=	(String)ht_wt.get(4);  // added for Bru-HIMS-CRF-090 [IN:029956]
				encounter_id			=	(String)ht_wt.get(5); // added for Bru-HIMS-CRF-090 [IN:029956]
			}
			// added for Bru-HIMS-CRF-090 [IN:029956]--start
			//validation for Home Medication
			if(patient_class!=null && patient_class.equals("OP")){
				take_medication_yn_chk	= "";
				take_medication_yn_dis	= "disabled";
				take_medication_yn_val = "";
			}
			else{
				if(!patient_class.equals("XT")){			
					medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
				}
				if(medication_rec>0){
					//take_medication_yn_chk	= "checked";
					take_medication_yn = "Y";
					take_medication_yn_dis	= "";
					//take_medication_yn_val  = "D" ;
					//patient_class="OP";
				}
				else{
					take_medication_yn_chk	= "";
					take_medication_yn_dis	= "";
					take_medication_yn_val="";
				}
			}
		// Bru-HIMS-CRF-090 [IN:029956]--end
			ArrayList age_sex	= bean.getAgeSex(patient_id);
			if(age_sex.size()!=0){
				age=(String)age_sex.get(0);
				sex=(String)age_sex.get(1);
			}
			String pndng_ord_count  = bean.getPendngOrderCnt(patient_id);
			//newly added by manickam --end
			
			// Added by Shaiju H for the incident 24180 Starts
			
			/* commented  for Bru-HIMS-CRF-090 [IN:029956] -- start
			if(!dt_from.equals("")&&!locale.equals("en")){
				dt_from = com.ehis.util.DateUtils.convertDate(dt_from,"DMY",locale,"en");
			}
			if(!dt_to.equals("")&&!locale.equals("en"))	{
				dt_to = com.ehis.util.DateUtils.convertDate(dt_to,"DMY",locale,"en");
			} */// Added by Shaiju H for the incident 24180 Ends
			//commented for Bru-HIMS-CRF-090 [IN:029956] ---end
			String mode	= request.getParameter("mode");
			String login_user	= (String)session.getValue("login_user");
			String classValue  =  "";
			String OrderId     =  CommonBean.checkForNull(request.getParameter("OrderId"));
			//	ArrayList result		=	bean.getResult(patient_id,dt_from,dt_to,disp_locn,OrderId,locale);
			ArrayList result		=	bean.getResultMultiFacility(patient_id,OrderId,locale);
			//    ArrayList FacilityList	=	bean.getFacilityList(facility_id,locale);
			ArrayList FacilityList	=	bean.getMultiFacilityList(login_user,locale);
			ArrayList ReasonList	=	bean.getReasonList(locale);
			String display_style=""; //Added for HSA-CRF-0155 [IN048487]
			bean.setMode(CommonRepository.getCommonKeyValue("MODE_INSERT"));
			bean.setLanguageId(locale);
			String order_facility_id ="", order_facility_name=""; //Added for MOHE-CRF-0074
			String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
			ArrayList region_code_check = bean.getRegionCheckExt(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074
					
			if(result.size()<=1) {
%>
				<script language="javascript">
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>

<%
				return;
			}
%>
			<!--the below details are added for Bru-HIMS-CRF-090 [IN:029956] --- start -->
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<table border="1" cellpadding="0" cellspacing="0" width="100%" >
				<tr>
					<td class='COLUMNHEADER' width="75%">
						<font style="font-size:9">&nbsp;<%=(String)bean.getPatientName(patient_id)%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%></td><td  class='COLUMNHEADER' width="25%"><font style="font-size:9"><fmt:message key="Common.height.label" bundle="${common_labels}"/>:&nbsp; <%=height%>&nbsp;<%=ht_uom%>&nbsp;,&nbsp;<fmt:message key="Common.weight.label" bundle="${common_labels}"/>:&nbsp;<%=weight%>&nbsp;<%=wt_uom%></font>

					</td>
				</tr>

			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" >
				<tr>
					<td colspan="2" align="center">
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showAllergicDrug('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></font>
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showActiveProblems('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Problems.label" bundle="${common_labels}"/></font>
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showDemographics('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/></font>
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showCurrentRx('<%=patient_id%>','','','')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></font>
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showDrugProfile('<%=patient_id%>','','','','<%=encounter_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></font> <!--  '' and encounter_id added for AAKH-CRF-0088.2 -->
						<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showDispDrugs('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Disp.Drugs.label" bundle="${ph_labels}"/></font>
<%
						if(Integer.parseInt(pndng_ord_count)>0){
%>
							<font style="font-size:13;cursor:pointer;color:#ff0000;" id="pending_ordrs" class="HYPERLINK" onClick="showPendingOrders('<%=patient_id%>','')"><b>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/><b></font>
							<script>
								XX1=new blinkText("XX1",'pending_ordrs',500,500,'darkred','#ff0000');
							</script>
<%
						}
						else{
%>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showPendingOrders('<%=patient_id%>','')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></font>
<%
						} 
%>
						<label id='lblPatHistory' style='display:none;'><font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callPatientHistory('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></font></label>
					</td>
				</tr>
			</table>
			<!--added for Bru-HIMS-CRF-090 [IN:029956] --- end-->
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<th class='COLUMNHEADER' align="center"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
					<th class='COLUMNHEADER' align="center"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th>
					<th class='COLUMNHEADER' align="center"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></th>
					<th class='COLUMNHEADER'align="center" ><fmt:message key="ePH.CurrentFacility.label" bundle="${ph_labels}"/></th><!--  added for Bru-HIMS-CRF-090 [IN:029956]-->
					<th class='COLUMNHEADER'align="center" > <fmt:message key="ePH.CurrentDispenseLocation.label" bundle="${ph_labels}"/></th><!--  added for Bru-HIMS-CRF-090 [IN:029956]-->
					<th class='COLUMNHEADER'align="center"> <fmt:message key="ePH.PrescriptionType.label" bundle="${ph_labels}"/></th><!--Added for HSA-CRF-0155 [IN048487] -->
					<th class='COLUMNHEADER'align="center" ><fmt:message key="ePH.ReRouteFacility.label" bundle="${ph_labels}"/></th>
					<th class='COLUMNHEADER' align="center" ><fmt:message key="ePH.ReRouteDispenseLocation.label" bundle="${ph_labels}"/></th>
					<th class='COLUMNHEADER' align="center"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
					<th class='COLUMNHEADER' align="center"><fmt:message key="ePH.DischargeMedications.label" bundle="${ph_labels}"/></th> <!--  added for Bru-HIMS-CRF-090 [IN:029956]-->
					<th class='COLUMNHEADER' align="center"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
<%	
				int row_val		=	0;
				StringBuffer sbDispLocn = new StringBuffer();
				Set<String> setDispLocn = new HashSet<String>();
				String disc_ind = "", facility_name="", currFacilityID="";
				for(int i=0; i<result.size(); i+=11) {//Increase the Size from 9 To 11 For HSA-CRF-0155 [IN048487]
					if(row_val%2==0)
					   classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";
					row_val++;
					currFacilityID = (String)result.get(i+6);
					if(currFacilityID.equals(""))
						facility_name = (String)result.get(i+10);
					else
						facility_name = bean.getFacilityName((String)result.get(i+6),locale);
					disc_ind = (String)result.get(i+8)==null?"":(String)result.get(i+8);//added  for Bru-HIMS-CRF-090 [IN:029956] -- start
					if(disc_ind.equals("D")){// Condition changed for ML-BRU-SCF-1312 [IN:048819]
					   take_medication_yn_chk="checked";
					   take_medication_yn_dis	= "disabled";
					   take_medication_yn_val = "D";
					}
					else{
					   take_medication_yn_chk="";
					   take_medication_yn_dis	= "";
					   take_medication_yn_val = "";
					}//for Bru-HIMS-CRF-090 [IN:029956] -- end
					setDispLocn.add("'"+(String)result.get(i+7)+"'");

					if(((String)result.get(i+9)).equals("IP")){//Added if and else conditions for HSA-CRF-0155 [IN048487]
						display_style	= "disabled";
					}
					else{
						display_style="";
					}
%>
					<tr >
						<td class="<%=classValue%>" onmouseover="changeCursor(this);" align="center" onClick="Modify('<%=(String)result.get(i)%>')" nowrap><font class='HYPERLINK'><%=(String)result.get(i)%></font></td>
						<td class="<%=classValue%>" align="center" nowrap><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+1),"DMYHM","en",locale)%></td>
						<td class="<%=classValue%>" align="center" nowrap><%=(String)result.get(i+2)%></td>
						
						<input type="hidden" name="OrderId_<%=row_val%>" id="OrderId_<%=row_val%>" value="<%=(String)result.get(i)%>">
						<input type="hidden" name="OrderDate_<%=row_val%>" id="OrderDate_<%=row_val%>" value="<%=(String)result.get(i+1)%>">
						<input type="hidden" name="OrderStatus_<%=row_val%>" id="OrderStatus_<%=row_val%>" value="<%=(String)result.get(i+4)%>">
						<input type="hidden" name="P_BMS_ORDER_YN_<%=row_val%>" id="P_BMS_ORDER_YN_<%=row_val%>" value="<%=(String)result.get(i+5)%>">
						<input type="hidden" name="patient_class_<%=row_val%>" id="patient_class_<%=row_val%>" value="<%=(String)result.get(i+9)%>"><!--Added for HSA-CRF-0155 [IN048487]-->
						<td class="<%=classValue%>" align="center" nowrap><%=facility_name%>&nbsp;</td>  <!-- added for Bru-HIMS-CRF-090 [IN:029956]-->
						<td class="<%=classValue%>" align="center" nowrap><%=(String)result.get(i+3)%>&nbsp;</td>  <!-- added for Bru-HIMS-CRF-090 [IN:029956]-->
						<td class="<%=classValue%>" align="center" <%=display_style%>><!--Added for HSA-CRF-0155 [IN048487]-Start -->
							<select name="prescription_type_<%=row_val%>" id="prescription_type_<%=row_val%>" style="width:150px" onchange="removeIn_Exlist(this,'<%=row_val%>','<%=(String)result.get(i+9)%>');">
							<option value ="I"><fmt:message key="Common.Internal.label" bundle="${common_labels}"/></option>
							<option value ="E"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
							</select>
						</td><!--Added for HSA-CRF-0155 [IN048487]-End-->
						
						<td class="<%=classValue%>" align="center" nowrap>
						<select name="rcode_<%=row_val%>" id="rcode_<%=row_val%>" onchange="removeDispLocnDescList('<%=row_val%>');getDispLoc(this,'<%=login_user%>','<%=row_val%>');">	
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
						//MOHE-CRF-0074-Start 
 						if(region_check){ 
						for (int j=0;j<region_code_check.size();j+=2){
							order_facility_id=(String)region_code_check.get(j);
							order_facility_name=(String)region_code_check.get(j+1);
							if(facility_id.equals(order_facility_id))	{
%>
							<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
<%
							}
							else{
%>
							<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
								}
							}
 						}else{ //MOHE-CRF-0074-end
							String facility_val="";
							for(int j=0;j<FacilityList.size();j+=2){
								facility_val=(String)FacilityList.get(j); // added for Bru-HIMS-CRF-090 [IN:029956]--start
								if(facility_id.equals(facility_val)){ //if else added for Bru-HIMS-CRF-090 [IN:029956]
%>	
									<option value="<%=(String)FacilityList.get(j)%>" selected><%=(String)FacilityList.get(j+1)%></option>
<%
								}
								else{
%>
									<option value="<%=(String)FacilityList.get(j)%>"><%=(String)FacilityList.get(j+1)%></option>
<%
								}
							}
 						} //Added for MOHE-CRF-0074
%>
						</select>
						</td>
						<td class="<%=classValue%>" align="center" nowrap>
							<input type="hidden" name="ReRouteDisp_Name_<%=row_val%>" id="ReRouteDisp_Name_<%=row_val%>" maxlength="" onKeyPress="return CheckForSpecChars(event)" size="20"  value="">
							<select name="dispLocnDesc_<%=row_val%>" id="dispLocnDesc_<%=row_val%>" id="dispLocnDesc_<%=row_val%>" onchange="assignDispLocDesc(this,<%=row_val%>)">
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
							<!--<input valign='top' type='button' name='ReRouteDisp_but<%=row_val%>' id='ReRouteDisp_but<%=row_val%>' value='?' class='button' onclick="searchReRouteDisp(this,'<%=row_val%>');">  commented for Bru-HIMS-CRF-090 [IN:029956]--> 
							<input type="hidden" name="ReRouteDisp_Id_<%=row_val%>" id="ReRouteDisp_Id_<%=row_val%>" value="">
				
						</td>
						<td class="<%=classValue%>" align="center" nowrap>
						<select name="Reason_<%=row_val%>" id="Reason_<%=row_val%>">	
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
							for(int k=0;k<ReasonList.size();k+=2){
%>
								<option value="<%=(String)ReasonList.get(k)%>"><%=(String)ReasonList.get(k+1)%></option>
<%
							}
%>
							</select>
							<img id='ReasonMand_<%=row_val%>' style='visibility:hidden;' src="../../eCommon/images/mandatory.gif">
						</td>
						<td class="<%=classValue%>" align="center">
							<input type="checkbox" id="dis_mend_<%=row_val%>" name="dis_mend_<%=row_val%>" onclick="AssignValueDisMedn(this,'<%=row_val%>')" value="<%=take_medication_yn_val%>" <%=take_medication_yn_chk%> <%=take_medication_yn_dis%> > <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
						</td>
						<td class="<%=classValue%>" align="center">
						<input type="checkbox" id="check_id<%=row_val%>" name="chk_<%=row_val%>" onclick="AssignValue(this,'<%=row_val%>')" value="">
						<input type="hidden" id="disp_locn_<%=row_val%>" name="disp_locn_<%=row_val%>" value="<%=(String)result.get(i+7)%>"> <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
						<input type="hidden" name="facility_id_<%=row_val%>" id="facility_id_<%=row_val%>" maxlength=""  value="<%=(String)result.get(i+6)%>"> <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
						<input type="hidden" name="take_medication_yn_<%=row_val%>" id="take_medication_yn_<%=row_val%>" value="<%=take_medication_yn%>"> <!-- added for [IN:033888]-->
						<!--<input type="hidden" name="curr_disp_loc_<%=row_val%>" id="curr_disp_loc_<%=row_val%>" value="<%=(String)result.get(i+3)%>">  -->
						</td>
					</tr>
					<!-- added for Bru-HIMS-CRF-090 [IN:029956] start -->
					<script>
						getDispLoc(eval('document.formReRoutePrescriptionsResult.facility_id'),'<%=login_user%>','<%=row_val%>','<%=disp_locn_code%>');	
					</script><!-- for Bru-HIMS-CRF-090 [IN:029956] end -->
<%	
				} 
%>
			</table>
			<input type="hidden" name="tot_record_count" id="tot_record_count" value="<%=row_val%>">
			<input type="hidden" name="tot_records" id="tot_records" value="<%=result.size()%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="disp_locn" id="disp_locn" value="<%=disp_locn%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="re_route_via_reg_ord" id="re_route_via_reg_ord" value="<%=re_route_via_reg_ord%>"> <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
			<input type="hidden" name="sql_Re_Route_select_lookup" id="sql_Re_Route_select_lookup" value="<%=sql_Re_Route_select1%>">
		</form>
	</body>
<%
	if(disp_locn.equals("")){ //Added for ML-BRU-SCF-1113 [IN:044717]-start setDispLocn
		Iterator iter =  setDispLocn.iterator();
		while(iter.hasNext()){
			if(sbDispLocn.length()>0)
				sbDispLocn.append(", "+(String)iter.next());
			else
				sbDispLocn.append((String)iter.next());
		}
		disp_locn = sbDispLocn.toString();
	}
	if(bean.getViewPatientHistoryYN(login_user,disp_locn,facility_id).equals("Y")){ //Commented if condition for 33798 //Uncommented for ML-BRU-SCF-1113 [IN:044717]
%>
		<script>
			document.getElementById("lblPatHistory").style.display='inline';
		</script>
<%
	} //Added for ML-BRU-SCF-1113 [IN:044717] -end
	putObjectInBean(bean_id,bean,request); 
} // Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>  <!--  Added for MOHE-CRF-0074 - End -->
</html>

