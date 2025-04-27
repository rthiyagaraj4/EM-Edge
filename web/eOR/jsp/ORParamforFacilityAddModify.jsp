
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?			100				?           ?			?				created
03/04/2013	IN035929		Karthi L	?			?				When user Place in OR/CA, user should not see Service charges. 
16/01/2014	IN046429		Nijitha S	16/01/2014	Ramesh G		SS_BETA_0002.When billing module is not installed, 	script error occurs "disp_bill_info undefined".
26/02/2014	IN047204		Karthi L	07/03/2014	Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
23/10/2014	IN031504		Karthi L	23/10/2014	Akbar 			System displays Parameters related BL module in OR>OR Parameter for Facility for customers without BL module.
30/01/2015	IN052649		Ramesh G	04/02/2015	Akbar			Previous orders - Default filter to be filtered by All or by specialty
02/01/2017	IN061888		Karthi L									To record collection all at 1 go
31/10/2017	IN061892		Prakash C	31/10/2017	Ramesh G		Time alert frame for ML-MMOH-CRF_0544 (Pending Lab Order Specimen)
26/02/2018	IN066119		Raja S		26/02/2018	Ramesh G		ML-MMOH-CRF-1024 
25/04/2020	IN071618		Ramesh G	25/04/2020		Ramesh G		PMG2019-MMS-CRF-0004
13/10/2022  37018           Venkat S                                     PMG2021-COMN-CRF-0080-US001
---------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>

<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrParamForFacility.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onLoad ="loadEnableDisable()"  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//String readOnly = "" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String facility_id = request.getParameter( "facility_id" ) ;
	if(facility_id == null){
		facility_id = (String)session.getValue("facility_id") ;
	}

	String bean_id = "Or_or_parameter_facility" ;
	String bean_name = "eOR.OrParameterForFacilityBean";
	//IN061892 start
	boolean isSiteSpecific  = false;
	Connection con = null;
	try{
	con = ConnectionManager.getConnection();
	isSiteSpecific = CommonBean.isSiteSpecific(con, "OR","DISPATCH_SPECIMEN_NOT_REG");
	}
	 catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
	finally {
		if(con != null)
			con.close();
	}
	//IN061892 ends
	//String[] allValues = new String[34]; //  commented for 35929 
	//String[] allValues = new String[35]; //  modified for 35929
	//String[] allValues = new String[36]; //  modified for //IN043081
  //  String[] allValues = new String[37]; // modified for IN047204	
	//String[] allValues = new String[40]; // modified for ML-MMOH-CRF-0540 [IN061888]
	  //String[] allValues = new String[41]; // modified for IN061892	
	//  String[] allValues = new String[43]; // modified for IN066119
	   String[] allValues = new String[44]; // modified for 37018
	//String operating_facility_id		  =  "";
	//String print_cons_yn			  = 	 "";
//	String print_cons_at_src_yn  = "";
	String print_ord_at_dest_yn		  = 	 "";
	String print_ord_at_src_yn		  = 	 "";
	String limit_catalog_to_loc      ="N";//IN043081
	String hide_specimentype      ="N";//IN066119
	String hide_reportingprac      ="N";//IN066119	
	String applyOrderingRulesByPractitionerType      ="N";//37018	
//	String print_refu_at_dest_yn	="";
	String print_refu_at_src_yn	="";
//	String print_referral_at_src_yn	="";
//	String print_referral_at_dest_yn	="";
	
	String print_res_at_dept_yn		  = 	 "";
	String print_res_at_othloc		  = 	 "";
	String othloc_queue_name		=  		 "";
	String print_res_for_disch_pat		  =  "";
	String disch_pat_queue_name		  = 	 "";
	String single_cont_renew_hrs_behind	  =  "";
	String single_cont_renew_hrs_ahead	   = "";
	String single_cont_react_hrs_ahead 	   = "";
	String single_cont_exp_grace_hrs	 = 	  "";
	String single_cont_disc_grace_hrs	   =  "";
	//String bl_module_yn			   =		    "";
	String no_of_days_ahead_to_bill	 = 		    "";
//	String PRINT_REFU_AT_DEST_LOCN="";
	//String PRINT_REFERRAL_AT_DEST_LOCN="";
	String specimen_behind_hrs	  =  "";
	String specimen_ahead_hrs	   = "";

	String billDisable = "";
	String billValue = "";
	String facility_name = "";
	String checkBillingInstalled = "";
	String billChecked = "";
	int recordExists =0;
	String[] record=null;
	String ext_order_referral_code="";
	String ext_order_referral_desc="";
	/* Added By Uma, For the CRF 640*/
	String BilledButNotReceipted = "N";
	String PostedToFolioButNotBilledReceipted = "N";
	String MaxAllowedPeriod = "";
	/* Added By Uma, For the SRR10056- CRF 195*/
	String dfltDiscontinue = "";
	
	/* Ends here.*/
	String invkForExtOrder = "";
	String invkForOPOrder = "";
	String invkForEMOrder = "";
	String invkPrintRepForBilling = "";
	String dispBillInfo = ""; // added for 35929 by LK
	String dispBillChecked = ""; // added for 35929 by LK
	String dispDmsExtLink = ""; // IN047204
	String dmsExtLinkChecked = ""; // IN047204
	String select_all_for_rec_collect_yn = ""; //ML-MMOH-CRF-0540 [IN061888]
	String select_all_for_rec_collect_chkd = ""; //ML-MMOH-CRF-0540 [IN061888]
	String time_alert_for_lab_spec_not_registered="";//IN061892
	String DefaultPeriodCopyPreviousOrders = "";
	String orderingspecialitycopypreviousorder = "N";  //IN052649
	String splitUnbilledOrders ="";//IN071618
	String select_split_unbilled_orders_yn_chkd = "";//IN071618
//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */

	/* Initialize Function specific start */
	//OrParameterForFacilityBean bean = (OrParameterForFacilityBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 OrParameterForFacilityBean bean = (OrParameterForFacilityBean)getBeanObject( bean_id, bean_name, request ) ;

	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	recordExists = bean.checkForMode(facility_id);
	//checkBillingInstalled = bean.checkBillingInstalled();
	checkBillingInstalled	= bean.checkBillingInstalled(facility_id);
	if (checkBillingInstalled == null) checkBillingInstalled = "";
	facility_name = bean.getFacilityName(facility_id);

	if(!(checkBillingInstalled.trim()).equalsIgnoreCase("Y")){
		billDisable = " disabled ";
		billValue = "N";
	}else{
		billChecked = " checked ";
	}
	if(recordExists == 0){
		mode = "1";
	}


	if(mode.equals("2")){
		allValues  = bean.getValues(facility_id);
		//operating_facility_id			=   allValues[0] 	;
		//print_cons_yn					=   allValues[1] 	;
		print_ord_at_dest_yn					=bean.checkForNull(allValues[2]);
		print_ord_at_src_yn					=bean.checkForNull(allValues[3]);
		print_res_at_dept_yn					=bean.checkForNull(allValues[4]);
		print_res_at_othloc					=bean.checkForNull(allValues[5]);
		othloc_queue_name					=bean.checkForNull(allValues[6]);
		print_res_for_disch_pat			=bean.checkForNull(allValues[7]);
		disch_pat_queue_name				=bean.checkForNull(allValues[8]);
		single_cont_renew_hrs_behind	=bean.checkForNull(allValues[9]);
		single_cont_renew_hrs_ahead	=bean.checkForNull(allValues[10]);
		single_cont_react_hrs_ahead	=bean.checkForNull(allValues[11]);
		single_cont_exp_grace_hrs		=bean.checkForNull(allValues[12]);
		single_cont_disc_grace_hrs		=bean.checkForNull(allValues[13]);
		billValue										=bean.checkForNull(allValues[14]);
		no_of_days_ahead_to_bill		=bean.checkForNull(allValues[15]);
		specimen_behind_hrs					=bean.checkForNull(allValues[16]);
		specimen_ahead_hrs					=bean.checkForNull(allValues[17]);
//		print_cons_at_src_yn            =  allValues[18];
//		print_refu_at_dest_yn			= allValues[19];
		print_refu_at_src_yn					=bean.checkForNull(allValues[20]);
		ext_order_referral_code			=bean.checkForNull(allValues[24]);
		ext_order_referral_desc				=bean.checkForNull(allValues[25]);
		/*Added by Uma on 8/28/2009 for PMG20089 - CRF 641*/
		PostedToFolioButNotBilledReceipted				= bean.checkForNull(allValues[26]);		
		BilledButNotReceipted				= bean.checkForNull(allValues[27]);
		MaxAllowedPeriod				= bean.checkForNull(allValues[28]);
		/* Added By Uma, For the SRR10056- CRF 195*/

		dfltDiscontinue				= bean.checkForNull(allValues[29]);			
		
		/*Ends Here*/
		invkForExtOrder				= bean.checkForNull(allValues[30]);
		invkPrintRepForBilling		= bean.checkForNull(allValues[31]);
		invkForOPOrder				= bean.checkForNull(allValues[32]);
		invkForEMOrder				= bean.checkForNull(allValues[33]);
		dispBillInfo				= bean.checkForNull(allValues[34]); // added for 35929 by LK
		limit_catalog_to_loc		= bean.checkForNull(allValues[35]);//IN043081
		dispDmsExtLink				= bean.checkForNull(allValues[36]);//IN047204
		orderingspecialitycopypreviousorder	= bean.checkForNull(allValues[37]);//IN052649
		DefaultPeriodCopyPreviousOrders 	= bean.checkForNull(allValues[38]);//IN052649
		select_all_for_rec_collect_yn		= bean.checkForNull(allValues[39]);//ML-MMOH-CRF-0540 [IN061888]
		time_alert_for_lab_spec_not_registered = bean.checkForNull(allValues[40]);//IN061892 
		hide_specimentype		= bean.checkForNull(allValues[41]);//IN066119
		hide_reportingprac		= bean.checkForNull(allValues[42]);//IN066119
		splitUnbilledOrders= bean.checkForNull(allValues[43]);//IN071618
		applyOrderingRulesByPractitionerType= bean.checkForNull(allValues[44]);//37018
		/* End Here*/
//		PRINT_REFU_AT_DEST_LOCN			=allValues[21];//bean.getPRINT_REFU_AT_DEST_LOCN();
//		print_referral_at_dest_yn		= allValues[22];
//		print_referral_at_src_yn			=allValues[23];
		
		//PRINT_REFERRAL_AT_DEST_LOCN=allValues[24];//bean.getPRINT_REFERRAL_AT_DEST_LOCN();
		
		if(no_of_days_ahead_to_bill		==	null	)		no_of_days_ahead_to_bill	= "";
		if(single_cont_renew_hrs_behind ==	null	)		single_cont_renew_hrs_behind= "";
		if(single_cont_renew_hrs_ahead	==	null	)		single_cont_renew_hrs_ahead = "";
		if(single_cont_react_hrs_ahead	==	null	)		single_cont_react_hrs_ahead = "";
		if(single_cont_exp_grace_hrs	==	null	)		single_cont_exp_grace_hrs	= "";
		if(single_cont_disc_grace_hrs	==	null	)		single_cont_disc_grace_hrs	= "";
		if(hide_specimentype	==	null	)		hide_specimentype	= "N";//IN066119
		if(hide_reportingprac	==	null	)		hide_reportingprac	= "N";//IN066119

		if(specimen_behind_hrs	        ==	null	)		specimen_behind_hrs	= "";
		if(specimen_ahead_hrs	        ==	null	)		specimen_ahead_hrs	= "";
//		if(print_refu_at_dest_yn	== null)			print_refu_at_dest_yn = "";
		if(print_refu_at_src_yn	== null)			print_refu_at_src_yn = "";
//		if(print_referral_at_dest_yn	== null)			print_referral_at_dest_yn = "";
//		if(print_referral_at_src_yn	== null)		print_referral_at_src_yn = "";
//		if(PRINT_REFU_AT_DEST_LOCN	==	null)		PRINT_REFU_AT_DEST_LOCN	= "";
		//if(PRINT_REFERRAL_AT_DEST_LOCN	        ==	null	)		PRINT_REFERRAL_AT_DEST_LOCN	= "";	
		if(time_alert_for_lab_spec_not_registered==null) time_alert_for_lab_spec_not_registered="";//IN061892 
		if((billValue.trim()).equals("Y")){
			billChecked = " checked ";
		}else{
			billChecked = "";
		}
		if((dispBillInfo.trim()).equals("Y")){ //  added for 35929 by LK
			dispBillChecked = " checked ";
		}else{
			dispBillChecked = "";
		}
		//  added for IN047204 - Start
		if((dispDmsExtLink.trim()).equals("Y")){ 
			dmsExtLinkChecked = " checked ";
		}else{
			dmsExtLinkChecked = "";
		}
		//  added for IN047204 - End
		//ML-MMOH-CRF-0540 [IN061888] - Start
		if(select_all_for_rec_collect_yn.equals("Y")){ 
			select_all_for_rec_collect_chkd = "checked";
		}else{
			select_all_for_rec_collect_chkd = "";
		}
		//ML-MMOH-CRF-0540 [IN061888] - End
		
		//IN071618 Start.
		if(splitUnbilledOrders.equals("Y")){ 
			select_split_unbilled_orders_yn_chkd = "checked";
		}else{
			select_split_unbilled_orders_yn_chkd = "";
		}
		//IN071618 End.
	}
	allValues=null;

	bean.setMode( mode ) ;
	ArrayList oth_specific_loc_name_values = new ArrayList();
	ArrayList dischg_specific_loc_name_values = new ArrayList();

    oth_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,null);
    dischg_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,null);
	//out.println(dischg_specific_loc_name_values);
	/* Initialize Function specific end */


			
%>
	
<form name="or_parameter_for_facility" id="or_parameter_for_facility" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="100%" border=0 align=center>
<tr style="line-height:2pt">
<td colspan=2></td>
</tr>
<tr>
	<td  class="label"  width='35%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name="facility_disp" id="facility_disp" value="<%=facility_name%>" readonly><input type=hidden name="facility" id="facility" value="<%=facility_id%>"></td>
</tr>
<tr>
	<td colspan=2>
	<table cellpadding=3 cellspacing=0 width="100%" border=0 align=center>
	<tr>
	<td class='columnheader'  width="28%" height="5" nowrap ><fmt:message key="eOR.OrderForms.label" bundle="${or_labels}"/></td><td class='columnheader' width="24%" nowrap><fmt:message key="eOR.PrintatDestination.label" bundle="${or_labels}"/></td><td class='columnheader' nowrap><fmt:message key="eOR.PrintatSource.label" bundle="${or_labels}"/></td>
	</tr>
	</table>
	</td>
   
</tr>
<!--<tr>
	<td  class="label" align=right width='35%'>Consent Forms  </td>
	<td align=right width="171"><INPUT TYPE="checkbox" name="consenet_form_prnt" id="consenet_form_prnt"  <%//if(print_cons_yn.equals("Y")){out.println(" checked");}%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="consenet_form_source" id="consenet_form_source" <%//if(print_cons_at_src_yn.equals("Y")){out.println(" checked ");}%>></td>
</tr>
-->
<tr>
	<td colspan=2>
		<table cellpadding=3 cellspacing=0 border=0 width='100%' align=center>

		<tr>
		 	<td  class="label" width='35%'><fmt:message key="eOR.OrderForms.label" bundle="${or_labels}"/></td>
			<td class="fields"  width="24%"><INPUT TYPE="checkbox" name="prnt_at_destination" id="prnt_at_destination" <%if(print_ord_at_dest_yn.equals("Y")){out.println(" checked ");}%>></td><td><INPUT TYPE="checkbox" name="prnt_at_source" id="prnt_at_source" <%if(print_ord_at_src_yn.equals("Y")){out.println(" checked ");}%>></td>
		</tr>
		</table>
	</td>
</tr>
<!--<tr>
	<td colspan=2>
		<table cellpadding=0 cellspacing=0 border=0 width='100%'>

		<tr>
		 	<td  class="label" width='35%' align=right >Refusal Forms </td>
			
			<td class="label" align=left width="172" nowrap><INPUT TYPE="checkbox" name="refusal_destination" id="refusal_destination" onclick="func()" <%//if(print_refu_at_dest_yn.equals("Y")){out.println(" checked ");}%> 
			>
			&nbsp;&nbsp;<input type="text" name="refusal_text" id="refusal_text" size="6" value=''
			"//PRINT_REFU_AT_DEST_LOCN"
 			maxlength="6">
			<script>if(document.forms[0].refusal_destination.checked)
						{
							document.forms[0].refusal_text.style.visibility="visible";
						}
						else
						{
				
							document.forms[0].refusal_text.style.visibility="hidden";
							
						}
				</script>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT TYPE="checkbox" name="refusal_source" id="refusal_source" <%//if(print_refu_at_src_yn.equals("Y")){out.println(" checked ");}%>></td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan=2>
		<table cellpadding=0 cellspacing=0 border=0 width='100%'>

		<tr>
			<td  class="label" width='35%' align=right >Referral Forms </td>
			<td class="label" align=right width="172"><INPUT TYPE="checkbox" name="referral_destination" id="referral_destination" <%//if(print_referral_at_dest_yn.equals("Y")){out.println(" checked ");}
			%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT TYPE="checkbox" name="referral_source" id="referral_source" <%//if(print_referral_at_src_yn.equals("Y")){out.println(" checked ");}
			%>></td>
		</tr>
		</table>
	</td>
</tr>
-->
<tr>
	<!-- If consent form is not there -->
	<input type="hidden" name="consenet_form_prnt" id="consenet_form_prnt" value="N">		
	<input type="hidden" name="consenet_form_source" id="consenet_form_source" value="N">
	<!-- If refusal form is not there -->
	<input type="hidden" name="refusal_destination" id="refusal_destination" value="N">		
	<input type="hidden" name="refusal_text" id="refusal_text" value="">
	<input type="hidden" name="refusal_source" id="refusal_source" value="N">
	<!-- If referral form is not there -->
	
	<input type="hidden" name="referral_destination" id="referral_destination" value="N">		
	<input type="hidden" name="referral_source" id="referral_source" value="N">		
 
	<td class='columnheader' colspan=2><fmt:message key="eOR.ResultReports.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label" ><fmt:message key="eOR.PrintatDepartment.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="prnt_at_dept" id="prnt_at_dept" <%if(print_res_at_dept_yn.equals("Y")){out.println(" checked ");}%>></td>
</tr>
<tr>
	<td colspan=2>
		<table cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr><td  class="label" width='35%' nowrap><fmt:message key="eOR.PrintatOtherLocation.label" bundle="${or_labels}"/></td><td class='fields'><SELECT name="oth_loc_print" id="oth_loc_print" onChange="populateDetails(this)"><option value='P' <%if((print_res_at_othloc.trim()).equals("P")) out.println(" selected ");%>><fmt:message key="eOR.PatientLoc.label" bundle="${or_labels}"/></option><option value='S' <%if((print_res_at_othloc.trim()).equals("S")){ out.println(" selected "); }%>><fmt:message key="eOR.SpecificLoc.label" bundle="${or_labels}"/></option><option value='X' <%if((print_res_at_othloc.trim()).equals("X")) out.println(" selected ");else if(mode.equals("1")) out.println(" selected ");%>><fmt:message key="eOR.DonotPrint.label" bundle="${or_labels}"/></option>
		</SELECT></td>
		<%if(mode.equals("1")){%>
		<td id='location_type' ></td>
		<td id='oth_specific_locn'></td>
		<%}else if (mode.equals("2") && (print_res_at_othloc.trim()).equals("S")){
			//oth_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,null);
			String strSelected="";
			for(int i=0; i<oth_specific_loc_name_values.size(); i++){
				record = (String [])oth_specific_loc_name_values.get(i);
				if((othloc_queue_name.trim()).equals(record[0])){
					strSelected=record[2];
					oth_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,record[2]);
				}
			}
			%>
			<td id='location_type' class='fields'>&nbsp;<Select name='loctype' id='loctype' onchange="populateLocationTypeDetails(this);"><Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option><Option value='C' <%if (strSelected.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option><Option value='N' <%if (strSelected.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
    			</Select>
    		</TD>
			<td id='oth_specific_locn' class='fields'><SELECT name="oth_specific_loc_name" id="oth_specific_loc_name">
				<option value = "">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option>
			<%
					//oth_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,null);

						
					for(int i=0; i<oth_specific_loc_name_values.size(); i++){
						record = (String [])oth_specific_loc_name_values.get(i);
			%>
					<option value="<%=record[0]%>" <%if((othloc_queue_name.trim()).equals(record[0])){out.println(" selected ");}%>  ><%=record[1]%></option>
			<%
					}oth_specific_loc_name_values=null;
			%>
			</SELECT><img align='center'src="../../eCommon/images/mandatory.gif" align=center></img></td>
		<%
		}else{
		%>
		<td id='location_type'></TD>
		<td id='oth_specific_locn'></td>
		<%}%>

		</tr>
		</Table>
		</td>
	<tr>
		<td colspan=2>
		<table cellpadding=3 cellspacing=0 border=0 width='100%' align=center>
		<tr><td  class="label"  width='35%' nowrap><fmt:message key="eOR.PrintLocationforDischargedPatients.label" bundle="${or_labels}"/></td><td class='fields'><SELECT name="dischg_pat_prnt" id="dischg_pat_prnt" onChange="populateDischgPatDetails(this)"><option value='P' <%if((print_res_for_disch_pat.trim()).equals("P")) out.println(" selected ");%>><fmt:message key="eOR.PatientLoc.label" bundle="${or_labels}"/></option><option value='S' <%if((print_res_for_disch_pat.trim()).equals("S")) out.println(" selected ");%>><fmt:message key="eOR.SpecificLoc.label" bundle="${or_labels}"/></option><option value='X'  <%if((print_res_for_disch_pat.trim()).equals("X")) out.println(" selected ");else if(mode.equals("1")) out.println(" selected ");%>><fmt:message key="eOR.DonotPrint.label" bundle="${or_labels}"/></option></SELECT>
		</td>
		<%if(mode.equals("1")){%>
		<td id='location_type1' ></TD>
		<td id='dischg_specific_locn'></td>
		<%}else if((mode.equals("2"))&&(print_res_for_disch_pat.trim()).equals("S")){
			String strSelected="";
			for(int i=0; i<dischg_specific_loc_name_values.size(); i++){
				record = (String [])dischg_specific_loc_name_values.get(i);
				if((disch_pat_queue_name.trim()).equals(record[0])){
					strSelected=record[2];
					dischg_specific_loc_name_values =(ArrayList) bean.getOtherLocationPrint(facility_id,record[2]);
				}
			}
		%>
		<td id='location_type1' class='fields'>&nbsp;<Select name='loctype1' id='loctype1' onchange="populateLocationTypeDetails1(this);"><Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option><Option value='C' <%if (strSelected.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option><Option value='N' <%if (strSelected.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
    		</Select>
    	</TD>
		<td id='dischg_specific_locn' class='fields'><SELECT name="dischg_specific_loc_name" id="dischg_specific_loc_name">
				<option value = "">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<%
				try{
					//dischg_specific_loc_name_values =(ArrayList) bean.getDischgPatientPrint(facility_id);
					for(int i=0; i<dischg_specific_loc_name_values.size(); i++){
						record = (String [])dischg_specific_loc_name_values.get(i);
			%>
					<option value="<%=record[0]%>" <%if((disch_pat_queue_name.trim()).equals(record[0])){out.println(" selected ");}%>  ><%=record[1]%></option>
			<%
					}dischg_specific_loc_name_values=null;
				}catch(Exception e){
					System.out.println(e);
				}
			%>
			</SELECT><img align='center'src="../../eCommon/images/mandatory.gif" align=center></img></td>
		<%}else{%>
		<td id='location_type1'></TD>
		<td id='dischg_specific_locn'></td>
		<%}%>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.ParametersforSingleContinuingOrders.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label" width='35%'><fmt:message key="eOR.RenewPeriodBehind.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='behind_hrs' id='behind_hrs' size=3 maxlength=3 value="<%=single_cont_renew_hrs_behind%>" onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)'  class='NUMBER' ><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label"> <fmt:message key="eOR.PeriodAhead.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='ahead_hrs' id='ahead_hrs' size=3 maxlength=3 value="<%=single_cont_renew_hrs_ahead%>"  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)'  class='NUMBER' > <fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eOR.ReactivateonHoldPeriodAhead.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='reactivate_hrs' id='reactivate_hrs' size=3 maxlength=3 value="<%=single_cont_react_hrs_ahead%>"  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)'  class='NUMBER' ><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class='columnheader'colspan=2><fmt:message key="eOR.GraceTimeforInclusioninActiveOrders.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eOR.ExpiredOrders.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='expired_hrs' id='expired_hrs' size=3 maxlength=3  value="<%=single_cont_exp_grace_hrs%>"  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)' class='NUMBER' > <fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eOR.DiscontinuedOrders.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='discontinued_hrs' id='discontinued_hrs' size=3 maxlength=3  value="<%=single_cont_disc_grace_hrs%>"  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)' class='NUMBER' > <fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/>
	</td>
</tr>

<tr>
	<td class='columnheader' colspan=2><fmt:message key="Common.SpecimenCollection.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eOR.PeriodBehind.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='specimen_behind_hrs' id='specimen_behind_hrs' size=3 maxlength=3 value="<%=specimen_behind_hrs%>" onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)'  class='NUMBER' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eOR.PeriodAhead.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='specimen_ahead_hrs' id='specimen_ahead_hrs' size=3 maxlength=3 value="<%=specimen_ahead_hrs%>"  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)'  class='NUMBER' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></td> 
</tr>
<tr>
	<td  class="label">Select all option for Record Collection</td>
	<td  class="fields"  ><INPUT TYPE="checkbox" name="select_all_for_rec_collect_yn" id="select_all_for_rec_collect_yn" value = "<%=select_all_for_rec_collect_yn%>" <%=select_all_for_rec_collect_chkd%>  onclick='enableRecordCollection(this)'></td>	
</tr>
<%--<Script>alert('<%=checkBillingInstalled%>')</Script>--%>
<%if(!(checkBillingInstalled.trim()).equalsIgnoreCase("Y")){%>
 <%--<tr>
	<th align=left colspan=2>Interface Particulars</th>
</tr>--%>

<tr>
	<td  class="label"></td>			<%--Interface to Billing </td>--%>
	<td  class="label"><input type=hidden name='intf_to_billing' id='intf_to_billing' value='' ></td>	 			<!--value="<%=billValue%>" <%=billDisable%> <%=billChecked%> onClick="enableDisable()"></td> -->
	<input type=hidden name='disp_bill_info' id='disp_bill_info' value='' > <!-- IN046429 Fix -->
</tr>
<tr>
	<td  class="label"></td>				<!-- No. of days ahead upto which to bill on order </td> -->
	<td  class="label"><input type=hidden  name='intf_to_billing_days' id='intf_to_billing_days' value="<%=no_of_days_ahead_to_bill%>"  size=2 maxlength=2></td>
	<!--  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)' <%=billDisable%>> days</td> -->
</tr>
<%} else {%>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.InterfaceParticulars.label" bundle="${or_labels}"/></td>
</tr>
<%--<tr>
<td colspan=2>&nbsp;</td>
</tr>--%>
<tr>
	<td  class="label" ><fmt:message key="Common.Billing.label" bundle="${common_labels}"/></td>	<%--</td>--%>
	<td  class="fields"><input type='checkbox' name='intf_to_billing' id='intf_to_billing' value="<%=billValue%>" <%=billDisable%> <%=billChecked%> onClick="enableDisable()">
	&nbsp; <fmt:message key="eOR.dispbillinginfo.label" bundle="${or_labels}"/><input type='checkbox' name='disp_bill_info' id='disp_bill_info' value="<%=dispBillInfo%>" <%=dispBillChecked%> onClick="setBillDispStauts(this)"> <!--  added for IN035929-->
	</td> 	<%--value='N' ></td>--%>
	</tr><tr>
	<td  class="label" ><fmt:message key="eOR.DefaultRefundOptionForDiscontinueOrder.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
		<Select name='DefRefundOptDiscOrder' id='DefRefundOptDiscOrder'>
			<Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<Option value='Y' <%if(dfltDiscontinue.equals("Y")) {out.println("selected");}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></Option>
			<Option value='N' <%if(dfltDiscontinue.equals("N")) {out.println("selected");}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></Option>
		</Select>
	</td>
	</tr>
	<tr>	
	<td  class="label" ><fmt:message key="eOR.InvokeSettlementScreenForPatClass.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
		XT <input type='checkbox' name='InvokeSetScreenForExtOrders' id='InvokeSetScreenForExtOrders' value="<%=invkForExtOrder%>" <%if(invkForExtOrder.equals("Y")) {out.println("checked");}else{out.println("");}%> onclick='stlmtExtOrders(this)'> OP <input type='checkbox' name='InvokeSetScreenForOPOrders' id='InvokeSetScreenForOPOrders' value="<%=invkForOPOrder%>" <%if(invkForOPOrder.equals("Y")) {out.println("checked");}else{out.println("");}%> onclick='stlmtOPOrders(this)'> EM <input type='checkbox' name='InvokeSetScreenForEMOrders' id='InvokeSetScreenForEMOrders' value="<%=invkForEMOrder%>" <%if(invkForEMOrder.equals("Y")) {out.println("checked");}else{out.println("");}%> onclick='stlmtEMOrders(this)'>
	</td>
</tr>
<tr>	
	<td  class="label" ><fmt:message key="eOR.InvokePrintReportForBilling.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
		<Select name='InvokePrintRepForBilling' id='InvokePrintRepForBilling'>
		<Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
			<Option value='Y' <%if(invkPrintRepForBilling.equals("Y")) {out.println("selected");}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></Option>
			<Option value='N' <%if(invkPrintRepForBilling.equals("N")) {out.println("selected");}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></Option>
		</Select>
	</td>
</tr>
<tr style="line-height:1pt">
	<td  class="label"></td>				<!-- No. of days ahead upto which to bill on order </td> -->
	<td  class="fields"><input type=hidden  name='intf_to_billing_days' id='intf_to_billing_days' value="<%=no_of_days_ahead_to_bill%>"  size=2 maxlength=2></td>
	<!--  onKeyPress="return OrAllowTime()" onBlur='return OrCheckTime(this)' <%=billDisable%>> days</td> -->
</tr>
<!-- IN071618 Start -->
<tr>
	<td  class="label">Split Unbilled orders and create New ID During Register order</td>
	<td  class="fields"  ><INPUT TYPE="checkbox" name="splitUnbilledOrders" id="splitUnbilledOrders" value = "<%=splitUnbilledOrders%>" <%=select_split_unbilled_orders_yn_chkd%>  onclick='enableSplitUnbilledOrders(this)'></td>	
</tr>
<!-- IN071618 End -->
<%}%>
<!-- IN047204 Start -->
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.ExternalLink.label" bundle="${or_labels}"/></td>
</tr>
<tr>	
	<td  class="label" ><fmt:message key="eOR.ExternalLink.label" bundle="${or_labels}"/></td>
	<td  class="fields"  ><INPUT TYPE="checkbox" name="dms_ext_link_yn" id="dms_ext_link_yn" value = "<%=dispDmsExtLink%>" <%=dmsExtLinkChecked%>  onclick='enableExtLink(this)'></td>	
</tr>	
<!-- IN047204 End -->
<tr>
<td class='columnheader' colspan=2><fmt:message key="eOR.ExternalPatientOrder.label" bundle="${or_labels}"/></td>
</tr>
<tr>
     <td class="label" ><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
	 <td class="fields"><input type="text" size=30 maxlength=30 name="ext_order_referral_desc" id="ext_order_referral_desc" value="<%=ext_order_referral_desc%>" onblur='callreferral(this,ext_order_referral_code)'><input type="button" value="?" onclick="Lookupwindow(ext_order_referral_desc,ext_order_referral_code)">	 
	 </td>	 
</tr>
<tr>
<%/*Added by Uma on 8/28/2009 for CRF PMG20089 - CRF 640*/%>
<td class='columnheader' colspan=2><fmt:message key="eOR.FutureOrderLinking.label" bundle="${or_labels}"/></td>
</tr>
<%if(checkBillingInstalled.trim().equalsIgnoreCase("Y")){%> <!--  added for IN031504 -->
<tr>
     <td class="label" ><fmt:message key="eOR.PostedToFolioButNotBilledReceipted.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='checkbox' name='PostedToFolioButNotBilledReceipted' id='PostedToFolioButNotBilledReceipted' value='<%=PostedToFolioButNotBilledReceipted%>' onclick='validatePostedNotBilledReceipted(this)' <%if(PostedToFolioButNotBilledReceipted.equals("Y")){%> checked<%}%>></td>
</tr>
<tr>
     <td class="label" ><fmt:message key="eOR.BilledButNotReceipted.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='checkbox' name='BilledButNotReceipted' id='BilledButNotReceipted' value='<%=BilledButNotReceipted%>' onclick='validateBilledButNotReceipted(this)' <%if(BilledButNotReceipted.equals("Y")){%> checked <%}%>></td>
</tr>
<% } %>  <!--  added for IN031504 -->
<tr>
     <td class="label" ><fmt:message key="eOR.MaxAllowedPeriodFromCurrentDay.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='text' name='MaxAllowedPeriod' id='MaxAllowedPeriod' value='<%=MaxAllowedPeriod%>' onkeypress='return validNumber(event);' size="4" maxlength="2"><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
</tr>
<!-- IN043081 Starts  -->
<tr>
<td class="label" >Limit Order Catalog To Location</td>
	<td class="fields"  width="24%"><INPUT TYPE="checkbox" name="limit_catalog_to_loc" id="limit_catalog_to_loc" value ="<%=limit_catalog_to_loc%>" <%if(limit_catalog_to_loc.equals("Y")){out.println(" checked ");}%> onclick='return setLimitCatalogToLocChk(this);'></td>
			
</tr>
<!-- IN043081 Ends  -->
<%/*End Here*/%>

<%/*IN052649 Start.*/%>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.others.label" bundle="${or_labels}"/></td>
</tr>

<tr>	
	<td  class="label" ><fmt:message key="eOR.orderingspecialitycopypreviousorder.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
		<Select name='OrderingSpecialityCopyPreviousOrder' id='OrderingSpecialityCopyPreviousOrder'>			
			<Option value='N' <%if(orderingspecialitycopypreviousorder.equals("N")) {out.println("selected");}%>><fmt:message key="eOR.notapplicable.label" bundle="${or_labels}"/></Option>
			<Option value='A' <%if(orderingspecialitycopypreviousorder.equals("A")) {out.println("selected");}%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
			<Option value='P' <%if(orderingspecialitycopypreviousorder.equals("P")) {out.println("selected");}%>><fmt:message key="eOR.primaryspeciality.label" bundle="${or_labels}"/></Option>
			<Option value='E' <%if(orderingspecialitycopypreviousorder.equals("E")) {out.println("selected");}%>><fmt:message key="eOR.encounterspeciality.label" bundle="${or_labels}"/></Option>
		</Select>
	</td>
</tr>

<tr>	
	<td  class="label" ><fmt:message key="eOR.defaultperiodincopypreviousorders.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
		<input type='text' name='DefaultPeriodCopyPreviousOrders' id='DefaultPeriodCopyPreviousOrders' value='<%=DefaultPeriodCopyPreviousOrders%>' onkeypress='return validNumber(event);' size="4" maxlength="3" onblur='validateForZero(this)'><fmt:message key="Common.days.label" bundle="${common_labels}"/>
	</td>
</tr>
<%/*IN052649 End.*/%>
<!-- IN066119 starts -->
<tr style='display:none'>
<td class="label" ><fmt:message key="eOR.HideSpecimenTypeInResults.label" bundle="${or_labels}"/></td>
	<td class="fields"  width="24%"><INPUT TYPE="checkbox" name="hide_specimentype" id="hide_specimentype" value ="<%=hide_specimentype%>" <%if(hide_specimentype.equals("Y")){out.println(" checked ");}%> onclick='return setHideSpecimenType(this);'></td>
			
</tr>
<tr>
<td class="label" ><fmt:message key="eOR.HideReportingPractitioner.label" bundle="${or_labels}"/></td>
	<td class="fields"  width="24%"><INPUT TYPE="checkbox" name="hide_reportingprac" id="hide_reportingprac" value ="<%=hide_reportingprac%>" <%if(hide_reportingprac.equals("Y")){out.println(" checked ");}%> onclick='return setHideReportingPrac(this);'></td>
			
</tr>
<!--  IN066119 Ends -->
<!--  37018 begin -->	
<tr>
<td class="label" ><fmt:message key="eOR.ApplyOrderingRulesByPractitionerType.label" bundle="${or_labels}"/></td>
<td class="fields"  width="24%"><INPUT TYPE="checkbox" name="applyOrderingRulesByPractitionerType" id="applyOrderingRulesByPractitionerType" value ="<%=applyOrderingRulesByPractitionerType%>" <%if(applyOrderingRulesByPractitionerType.equals("Y")){out.println(" checked ");}%> onclick='return setApplyOrderingRulesByPractitionerType(this);'></td>
			
</tr>
<!--  37018 Ends -->

<!--IN061892 start ML-MMOH-CRF-0544-->
<%if(isSiteSpecific) { %>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.LabSpecimenNotRegister.label" bundle="${or_labels}"/></td>
</tr><tr>
<td  class="label" ><fmt:message key="eOR.TimeFrameAlertForLab.label" bundle="${or_labels}"/></td>	
	<td  class="fields">
	<input id="lab_not_registered" type='text' name="alrt_time_for_not_reg_lab_spec" id="alrt_time_for_not_reg_lab_spec" value='<%=time_alert_for_lab_spec_not_registered%>' onkeypress='return validNumber(event);' size="4" maxlength="4" onblur='emptyValidate(this);OrCheckTime(this)'><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>	
</td></tr><!--IN061892 end ML-MMOH-CRF-0544-->
<%}%></table>
<%
//out.println("call"+ bean.tempChk);

%>
<input type="hidden" value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_REFERRAL")%>" name="referral_sql">	
<input type="hidden" value="<%=ext_order_referral_code%>" name="ext_order_referral_code">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value ="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="checkBillingInstalled" id="checkBillingInstalled" value="<%=checkBillingInstalled%>">
<input type="hidden" name="dispBillChecked" id="dispBillChecked" value="<%=dispBillChecked%>">

<%
 
	putObjectInBean(bean_id,bean,request);

}catch(Exception ex)
{
	System.out.println(ex);
	ex.printStackTrace();
}
%>
</form>
</body>

</html>


