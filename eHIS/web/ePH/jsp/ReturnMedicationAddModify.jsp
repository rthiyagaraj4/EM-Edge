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
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  	String login_user	=	(String)session.getValue("login_user");
		String facility_id   = (String)session.getValue( "facility_id" );

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../js/PhCommon.js"></script>
			<script language="JavaScript" src="../js/ReturnMedication.js"></script>
			<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
			<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 </head>

		<!-- <body> -->
		<body onMouseDown="" onKeyDown="lockKey()">
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
	try{
		 /* Mandatory checks start */
		 con				= ConnectionManager.getConnection(request);
		boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
		// Added for MOHE-CRF-0074 - END
		String mode			= request.getParameter("mode");
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
		String bean_name	= "ePH.ReturnMedicationBean";
	   
		String order_facility_id=""; 
		String order_facility_name=""; 
		String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
		String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); //added for MMS-QH-CRF-0201 [IN:052255]
		String dispSwitchLogin = ""; //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		if(homepage.equals("Y") || homepage.equals("dispmed") )
			dispSwitchLogin ="display:none;"; //Added for Bru-HIMS-CRF-073.1 [IN:047222] -end
	/*	if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
			return ;
			*/

		/* Mandatory checks end */

		/* Initialize Function specific start */
		ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
	    bean.clear() ;
	    
	    String trade_flag=bean.getEffectiveFlag("WARDRETN_RETN_MEDN","DISP_TRADE_NAME");// added for AMS-SCF-0190-IN038440  -start
	    if(!trade_flag.equals("")){
	    	bean.setTradeName_Flag(trade_flag);
	    } 	    // added for AMS-SCF-0190-IN038440  -end
	    
	   // bean.setMode( mode ) ;
		//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
		String FacilityFlag=bean.getEffectiveFlag("RETNMEDN","RETNMEDNMF");// AMS-SCF-0190 IN-38440 Changed to Parameterized method.
		if(FacilityFlag.equals(""))	{
			FacilityFlag="N";	
		}
		bean.setFacility_Flag(FacilityFlag);
		//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
		String patientClass=CommonBean.checkForNull(request.getParameter("patientcat"));
		String dispLocn=request.getParameter("dispLocn");
		String medn_rtn_after_bill_gen=bean.getMednRtnBillGen(dispLocn,patientClass);//code added for FD-JD-CRF-0178[IN039208] --End
		String opEnc_display = "";
		if(patientClass.equals("O") && medn_rtn_after_bill_gen.equals(""))
			opEnc_display = "visibility:hidden;";
		bean.setLoginDispLocnCode(dispLocn);
		bean.setPatientCategory(patientClass);
		String password=request.getParameter("password");
		String cutoff=bean.getCutOff();
		String dispBillNoYN=bean.getEffectiveFlag("RETNMEDN","BILL_NO_BASED_RETURN_MEDN");// added for MMS-DM-CRF-0039 [IN:055958] -start
		String dispBillNo = "display:none";
		if("Y".equals(dispBillNoYN) && "O".equals(patientClass) && !medn_rtn_after_bill_gen.equals("N") ){
			dispBillNo = "display:inline";
			dispBillNoYN = "Y";
		}
		else
			dispBillNoYN = "N";	// added for MMS-DM-CRF-0039 [IN:055958] - end
				
		//	ArrayList disp_duration		= bean.validateDispenseDuration();
		StringTokenizer cutoffTmp = new StringTokenizer(cutoff, " ");
		String onlyDate=cutoffTmp.nextToken();
		String Ward_Date_From_hidden=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale);	
		ArrayList fromStoredispLocn=new ArrayList();
		fromStoredispLocn=bean.getDispLocn(patientClass,locale);
		ArrayList OrderingFacility=bean.getOrderingFacilityId(login_user);
		String ward_returns_check_yn ="", dispRejQty="visibility:hidden;";
		if(patientClass.equals("I")){
			ward_returns_check_yn ="checked";
			dispRejQty="";
			cutoff = ""; // patient_class= IP, cutoff date is not required AMS-CRF-0172
		}

	   //String SQL_PH_MED_ADMIN_SELECT17=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT17");
	   //String SQL_PH_MED_ADMIN_SELECT18=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT18");
	   String SQL_PH_IP_LOCATION_SELECT="SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW A WHERE A.NURSING_UNIT_CODE IN ( SELECT LOCN_CODE FROM AM_LOCN_FOR_OPER_STN B,AM_USER_FOR_OPER_STN C WHERE B.OPER_STN_ID=C.OPER_STN_ID AND B.FACILITY_ID=C.FACILITY_ID AND C.FACILITY_ID='#' AND C.APPL_USER_ID='#' AND TRUNC(SYSDATE) BETWEEN NVL(C.EFF_DATE_FROM,SYSDATE) AND NVL(C.EFF_DATE_TO,SYSDATE) AND TRUNC(SYSDATE) BETWEEN NVL(B.EFF_DATE_FROM,TRUNC(SYSDATE)) AND NVL(B.EFF_DATE_TO,TRUNC(SYSDATE)) ) AND EFF_STATUS='E' AND A.FACILITY_ID='#' AND A.LANGUAGE_ID ='#' and NURSING_UNIT_CODE LIKE UPPER(?) AND Upper(LONG_DESC) like upper(?) order by 2";
	   String SQL_PH_OP_LOCATION_SELECT="SELECT   CLINIC_CODE code, long_desc description FROM op_clinic_lang_vw a WHERE a.CLINIC_CODE IN ( SELECT locn_code FROM am_locn_for_oper_stn b, am_user_for_oper_stn c WHERE b.oper_stn_id = c.oper_stn_id AND b.facility_id = c.facility_id AND c.facility_id = '#' AND c.appl_user_id = '#' AND TRUNC (SYSDATE) BETWEEN NVL (c.eff_date_from, SYSDATE) AND NVL (c.eff_date_to, SYSDATE) AND TRUNC (SYSDATE) BETWEEN NVL (b.eff_date_from,TRUNC (SYSDATE)) AND NVL (b.eff_date_to,TRUNC (SYSDATE))) AND eff_status = 'E' AND a.facility_id = '#' AND a.language_id = '#' AND CLINIC_CODE LIKE UPPER (?) AND UPPER (long_desc) LIKE UPPER (?) ORDER BY 2";	
	   String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	   ArrayList region_code_check = bean.getRegionCheck(login_user,region_code); //Added for MOHE-CRF-0074
%>
		<form name="FormReturnMedicationQueryCriteria" id="FormReturnMedicationQueryCriteria" >
			<table cellpadding='0' cellspacing='0' width="100%"  align="center" border="0" >
				<tr>
<%
				if(!(FacilityFlag.equals("Y"))){ 
%>
					<td align="right" class="label" width='15%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" colspan='2' ><select name="OrderingFacility" id="OrderingFacility" onChange="">
<%
				//MOHE-CRF-0074-Start 
				if(region_check){
				for (int i=0;i<region_code_check.size();i+=2){
					order_facility_id=(String)region_code_check.get(i);
					order_facility_name=(String)region_code_check.get(i+1);
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
				}else{  //MOHE-CRF-0074-End
					for (int i=0;i<OrderingFacility.size();i+=2){
						order_facility_id=(String)OrderingFacility.get(i);
						order_facility_name=(String)OrderingFacility.get(i+1);
						if(facility_id.equals(order_facility_id))	{
%>
							<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
<%
						}
						else{
%>
					   	  <option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
						}
					}
				} //Added for MOHE-CRF-0074
%>
					</SELECT>
					</td>
					<td align="left" width='15%'>&nbsp;</td>
					<td align="left" width='18%'>&nbsp;</td>
					<td align="left" width='17%'>&nbsp;</td>
<%
				}
%>
				</tr>
				<tr>									
					<td align="right" class="label" class="label" width='15%'><fmt:message key="ePH.WardReturns.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label" class="label" width='20%'><input type="checkbox" name="eff_status" id="eff_status" value=""   onClick=" check_Status(this);"<%=ward_returns_check_yn%>></td>
					<td align="right" class="label" class="label" width='15%' style='<%=dispRejQty%>'><fmt:message key="ePH.RejectedQty.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label" class="label" width='15%'  style='<%=dispRejQty%>'><input type="checkbox" name="rej_qty" id="rej_qty" value="E"  <%=ward_returns_check_yn%> onClick="setRej_Qty(this)"> </td><!-- Added for GHL-SCF-790 [IN:046481] -->
					<!-- FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility -->
<%
					if(!(FacilityFlag.equals("Y"))){ 
%>
						<td align="left" class="label" nowrap ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td align="left" class="label"><input type='text' name='nursing_unit_desc' id='nursing_unit_desc' value=''><input type="button" name="location_search" id="location_search" id ='location_search' value="?" class="button" onfocus="FromlocationSearch(nursing_unit,'<%=login_user%>','<%=patientClass%>');"			  onClick="FromlocationSearch(nursing_unit,'<%=login_user%>','<%=patientClass%>');">
						<input type='hidden' value='' name='nursing_unit' id='nursing_unit'>
						</td>
<%
					}
					else{
%>
						<td colspan='2'>&nbsp;</td>
<%
					}
%>
 					<!-- FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility -->
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="ePH.WardReturned.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" ><input type=text  name="Ward_Date_From" id="Ward_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');validateDate1();"value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>"> <!--validateDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for SRR-SRR20056-SCF-9374 [IN 56956] -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar2" onclick="return showCalendar('Ward_Date_From');"></td>
					<td align="left"class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
					<input type=text  name="ward_Date_To" id="ward_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');validateDate1();" value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>"">&nbsp;<!--validateDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for SRR-SRR20056-SCF-9374 [IN 56956] -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar3"  onclick="return showCalendar('ward_Date_To');">
					</td>	
					<td colspan='3'>&nbsp;</td>
				</tr>
				<!-- FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility -->
				<tr>	
					<td align="right" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="Patient_Id" id="Patient_Id" size="20"  value='<%=patient_id%>' maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" onBlur="populateEncounter(document.FormReturnMedicationQueryCriteria.Patient_Id.value)" >
					<INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.FormReturnMedicationQueryCriteria.Patient_Id)" ></td>
<% 
					if (patientClass.equals("I")) { 
%> <!--AMS-CRF-0172-->
						<td align="left"class="label" ><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/>
							<input type='checkbox' name='CurrentEncounter' id='CurrentEncounter' value='Y' checked onclick="populateEncounter(document.FormReturnMedicationQueryCriteria.Patient_Id.value)"></td>
						<td align="left"class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
							<select name="encounterId" id="encounterId">
							<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
							</select>
						</td>
<%  
					}  
					else {//code added for FD-JD-CRF-0178[IN039208] --Start
%>
						<td align="left"class="label" >
							<label id='encounter_lable' style='<%=opEnc_display%>'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></label>
						</td>
						<td  align="left"class="label">
							<select name="encounterId" id="encounterId" style='<%=opEnc_display%>'>
							<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
							</select>
							<input type="hidden" name="CurrentEncounter" id="CurrentEncounter" value="">
						</td>
<% 
					}
%>
						<td  style='<%=dispBillNo%>' align="left"class="label" > <!-- // added for MMS-DM-CRF-0039 [IN:055958] -->
							<fmt:message key="ePH.BillNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;
							<input type='text' name='blDocType' id='blDocType' size='6' value="" maxlength='6' onKeyPress="changeToUpper();"><b>&nbsp/</b>
							<input type='text' name='blDocNo' id='blDocNo' size='7' value="" maxlength='8' onKeyPress="changeToUpper();return(ChkNumberInput(this,event,'0'));" onchange="checkValidNum(this);">
						</td>
<%
					//FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility-->
					if((FacilityFlag.equals("Y"))){
%>
						<td align="left" class="label" nowrap width='15%'><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;
						<input type='text' name='nursing_unit_desc' id='nursing_unit_desc' value=''><input type="button" name="location_search" id="location_search" id ='location_search' value="?" class="button" onfocus="FromlocationSearch(nursing_unit,'<%=login_user%>','<%=patientClass%>');"			  onClick="FromlocationSearch(nursing_unit,'<%=login_user%>','<%=patientClass%>');">
						<input type='hidden' value='' name='nursing_unit' id='nursing_unit'>
						</td>
<%
					}
					if(!(FacilityFlag.equals("Y"))){ //FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility 
%>
						<td align="right" class="label" ><fmt:message key="ePH.DispensedFrom.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
						<select name="FromStore" id="FromStore" onChange="FromStoreSelect(this);">
						<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/>
<%
						if (fromStoredispLocn.size()>0){
							for (int i=0;i<fromStoredispLocn.size();i=i+2){
								if ((fromStoredispLocn.get(i)).equals(dispLocn)){
									out.println("<option  value=\""+fromStoredispLocn.get(i)+"\">"+fromStoredispLocn.get(i+1)+"</option>");
								}
								else{
									out.println("<option value=\""+fromStoredispLocn.get(i)+"\">"+fromStoredispLocn.get(i+1)+"</option>");
								}
							}
						}
%>
					</select>
					</td>
<%
				}
%>		
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="Drug_Name" id="Drug_Name" size="30" maxlength="20" onBlur="clearDrug(Drug_Name);"><INPUT TYPE="button" name="Drug_Name_Button" id="Drug_Name_Button" VALUE="?" CLASS="button"  onClick="drugsearch(document.FormReturnMedicationQueryCriteria);" ></td>
					</td>
					
					<td align="right" class="label" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" name="Dispense_No" id="Dispense_No" size="15"  maxlength="15" >
					</td>
					<td align="right" class="label" colspan='2'>
<% 					
 					if (patientClass.equals("O")) { 
%>
						<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
						<input type="text" name="Order_Id" id="Order_Id" size="15"  maxlength="15"></td>
<%
					}
					else{
%>
						<input type="hidden" name="Order_Id" id="Order_Id" value=""> 
						&nbsp;</td>
<%
					}
								
%>			
				</tr>
				<tr><td colspan='6' style="background-color:white"></td></tr>
				<tr><td colspan='6' style="background-color:white"></td></tr>
				<tr>
<% 
				if (patientClass.equals("O")) { 
%>  
					<td align="right" class="label" ><fmt:message key="Common.CutOffDate.label" bundle="${common_labels}"/></td>
					<td align="left"  class="label" >&nbsp;&nbsp;<b><%=com.ehis.util.DateUtils.convertDate(onlyDate,"DMY","en",locale)%></b></td>
<%
				}
				else{ 
%> <!--AMS-CRF-0172 -->
					<td align="right" class="label" colspan="2">&nbsp;&nbsp;</td>
<%
				}
%>
				<td align="right" class="button" colspan="4">
					<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="ePH.SwitchLogin.label" bundle="${ph_labels}"/>' onclick="switchLogin('<%=password%>','<%=patientClass%>','<%=homepage%>')" style='<%=dispSwitchLogin%>'>&nbsp;&nbsp;&nbsp;
					<input type="button" class="button" name="Search1" id="Search1" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onclick="callResultPage('<%=patientClass%>','<%=FacilityFlag%>');" >&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="Drug_Code" id="Drug_Code" value="">
		<input type="hidden" name="CutOff" id="CutOff" value="<%=cutoff%>">
		<input type="hidden" name="dispLocn" id="dispLocn" value=<%=dispLocn%> >
		<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%> >
		<input type="hidden" name="locale" id="locale" value=<%=locale%> >
		<input type="hidden" name="Ward_Date_From_hidden" id="Ward_Date_From_hidden" value=<%=Ward_Date_From_hidden%> >
		<input type="hidden" name="FormStore" id="FormStore" value="" >
		<input type="hidden" name="eff_status_value" id="eff_status_value" value="E" >
		<input type="hidden" name="patientClass" id="patientClass" value=<%=patientClass%> >    <!--AMS-CRF-0172-->
		<input type="hidden" name="SQL_PH_IP_LOCATION_SELECT" id="SQL_PH_IP_LOCATION_SELECT"	value="<%=SQL_PH_IP_LOCATION_SELECT%>">
		<input type="hidden" name="SQL_PH_OP_LOCATION_SELECT" id="SQL_PH_OP_LOCATION_SELECT"	value="<%=SQL_PH_OP_LOCATION_SELECT%>">		
		<input type="hidden" name="bill_gen_yn" id="bill_gen_yn" value="N" >
		<input type="hidden" name="medn_rtn_after_bill_gen" id="medn_rtn_after_bill_gen" value="<%=medn_rtn_after_bill_gen%>" >
		<input type="hidden" name="dispBillNoYN" id="dispBillNoYN" value="<%=dispBillNoYN%>" > <!-- added for MMS-DM-CRF-0039 [IN:055958] -->
		<input type="hidden" name="encounterIdCount" id="encounterIdCount" value="" > <!-- added for MMS-DM-CRF-0039 [IN:055958] -->
		<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>" > <!-- added for MMS-DM-CRF-0039 [IN:055958] -->
<% 
		putObjectInBean(bean_id,bean,request); 
%>
		</form>
		<script>
<%
			if(!(FacilityFlag.equals("Y"))){%>
				document.forms[0].OrderingFacility.focus();
<%
			}
			if( !patient_id.equals("") && "dispmed".equals(homepage)){//added for MMS-QH-CRF-0201 [IN:052255] - start
				String	bean_id_1		=	"DispMedicationAllStages" ;
				String	bean_name_1		=	"ePH.DispMedicationAllStages";
				DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request);
				bean.setDispTranSeqNo(bean_2.getDispTranSeqNo());
%>
				callResultPage('<%=patientClass%>','<%=FacilityFlag%>');
<%
			}else if( !patient_id.equals("") && "directDisp".equals(homepage)){
				String	bean_id_2	=	"DirectDispensingBean" ;
				String	bean_name_2		=	"ePH.DirectDispensingBean";
				DirectDispensingBean bean_2	= (DirectDispensingBean)getBeanObject( bean_id_2, bean_name_2, request);
				bean.setDirectDispTranSeqNo(bean_2.getDispTranSeqNo());
%>
				callResultPage('<%=patientClass%>','<%=FacilityFlag%>');	
<%
			}//added for MMS-QH-CRF-0201 [IN:052255] - end
%>
			check_Status(document.FormReturnMedicationQueryCriteria.eff_status);
		 </script>
<%
		}
		catch(Exception e){
			e.printStackTrace();
		}
	finally{  //Added for MOHE-CRF-0074
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}	//Added for MOHE-CRF-0074
%>
	</body>
</html>

