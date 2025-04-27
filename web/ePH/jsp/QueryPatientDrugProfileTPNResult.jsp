<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes st art --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id					= (String) session.getValue("facility_id");//added for ml-mmoh-scf-1303
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>

<script type="text/javascript">
			function initScroll() {
				var rightDivSize = document.body.offsetWidth-300;//ML-MMOH-SCF-2005 slight changed
				var leftDiv = document.getElementById('table_container_left');
				var rightDiv = document.getElementById('table_container_right');
				if(rightDiv!=undefined && leftDiv!=undefined){
					rightDiv.style.width=rightDivSize+'px';
					rightDiv.onscroll = function() {
						leftDiv.scrollTop = this.scrollTop;
						leftDiv.scrollTop = this.scrollTop;
					};
				}
			}
		</script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="initScroll();">
<%
	//Search Criteria's from Query Criteria page
	String patient_id	= request.getParameter("patient_id");
	String dt_from		= request.getParameter("dt_from");
	String dt_to		= request.getParameter("dt_to");
	//String drug_name	= request.getParameter("drug_name");
	String drug_code	= request.getParameter("drug_code");
	String pat_class	= request.getParameter("pat_class");
	String status		=	request.getParameter("status");
	String called_frm  = request.getParameter("called_frm");
	String disp_locn_code = request.getParameter("disp_locn_code");

	String	bean_id			=	"QueryPatientDrugProfileBean" ;
	String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

	QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;

	String bean_id_2		= "@PrescriptionBean_1"+patient_id;
	String bean_name_2		= "ePH.PrescriptionBean_1";

	PrescriptionBean_1 bean_2	= (PrescriptionBean_1)getBeanObject( bean_id_2,bean_name_2,request);	

	HashMap disc_cancel         = new HashMap();

	String discontinued_link_yn = "N";
	String cancel_link_yn       = "N";
	String disc_cancel_style	= "";
	String on_click				= "";

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;


	try{
		String classvalue			=	"";
		//String details				=	"";
		//String strength				=	"";
		//int count					=	0;
		patient_id	 = CommonBean.checkForNull( patient_id );
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		drug_code	 = CommonBean.checkForNull( drug_code );
		pat_class	 = CommonBean.checkForNull( pat_class );
	
		
	String sql_append	=	"";
	
	
	HashMap sqlMap = new HashMap();

	int index = 2;
	
	if((pat_class.equals("IP") || pat_class.equals("DC")) && status.equals("A")) {
		sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
	} else if((pat_class.equals("OP") || pat_class.equals("EM") || pat_class.equals("XT")) && status.equals("A")) {
		sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))!=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL')";
	} else if(status.equals("A")) {
		sql_append	=	" AND (A.PATIENT_CLASS = NVL('IP',A.PATIENT_CLASS) AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC') OR A.PATIENT_CLASS = NVL('OP',A.PATIENT_CLASS) AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL'))";

	} else if(status.equals("F")) {
		sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
	} else if(status.equals("C")) {
		sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";

	} else	if(status.equals("DC")) {
		sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";
		index = 3;
	} else if(status.equals("HD") || status.equals("HC")) {
		sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";
		index = 3;
	} else if(status.equals("R")) {
		sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
		index = 3;
	} else if(status.equals("CN")) {
		sql_append	=	" AND A.CANCEL_YN='Y' ";
		index = 3;
	} 	else {
			index = 3;
	}

/*
	if (!sql_append.equals("")){
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT2C") +  sql_append + " ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");		
	}else{
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT2C")+" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
	}
*/

    // T.SHORT_DESC LINE_STATUS_DESC added to below query by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

	String s1="SELECT distinct A.ORIG_ORDER_ID ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO ORIG_ORDER_LINE_NO, A.SRL_NO, Q.IV_PREP_YN IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.LONG_NAME,  A.DOSAGE || CHR (13) || DECODE (A.SPLIT_YN, 'N', NULL, H.FREQ_DESC || ' , ') || CHR (13) || DURATION || ' ' || I.DURN_DESC DOSAGE_DETAILS, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE, 'DD/MM/YYYY HH24:MI')  END_DATE, A.PATIENT_CLASS, D.PATIENT_NAME, E.PRACTITIONER_NAME, J.FACILITY_NAME, DECODE (P.ASSIGN_CARE_LOCN_TYPE, 'N', L.SHORT_DESC, 'C', K.SHORT_DESC ) LOCATION, (CASE WHEN Q.CAN_REASON IS NOT NULL THEN 'HOLD' WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL'  WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL  THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0  THEN 'ACTIVE' ELSE 'INACTIVE'  END ) STATUS, C.PRES_BASE_UNIT, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, O.ORDER_UOM, R.ROUTE_CODE, R.ROUTE_DESC ,A.END_DATE ENDING_DATE,T.SHORT_DESC LINE_STATUS_DESC FROM PH_PATIENT_DRUG_PROFILE A, PH_TPN_REGIMEN_LANG_VW C, MP_PATIENT D, AM_PRACTITIONER_LANG_VW E, AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J, OP_CLINIC_LANG_VW K, IP_NURSING_UNIT_LANG_VW L, OR_ORDER_LINE O, PR_ENCOUNTER P, OR_ORDER Q, PH_ROUTE_LANG_VW R, PH_PARAM_LANG_VW S,OR_ORDER_STATUS_CODE_LANG_VW T WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.START_DATE BETWEEN TO_DATE( NVL(?,'01/01/1472') , 'DD/MM/YYYY') AND TO_DATE( NVL (?,'31/12/5000') , 'DD/MM/YYYY') + 0.99999 AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.TPN_REGIMEN_CODE AND E.PRACTITIONER_ID = A.PRES_PRACTITIONER_ID AND H.FREQ_CODE = A.FREQ_CODE AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+) = A.LOCN_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM  AND P.ENCOUNTER_ID = A.ENCOUNTER_ID AND P.FACILITY_ID = A.ORIG_FACILITY_ID AND R.ROUTE_CODE = S.DFLT_IV_ROUTE_CODE AND Q.IV_PREP_YN IN ('7', '8') AND O.ORDER_LINE_STATUS = T.ORDER_STATUS_CODE AND C.LANGUAGE_ID = E.LANGUAGE_ID  AND C.LANGUAGE_ID = H.LANGUAGE_ID AND C.LANGUAGE_ID = I.LANGUAGE_ID AND C.LANGUAGE_ID = J.LANGUAGE_ID AND C.LANGUAGE_ID = R.LANGUAGE_ID AND C.LANGUAGE_ID = S.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ?    ";
	
	if (!sql_append.equals("")){
		sqlMap.put( "sqlData", s1+  sql_append + " ORDER BY ENDING_DATE DESC ,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO");		

	}else{
		sqlMap.put( "sqlData", s1+" ORDER BY ENDING_DATE DESC ,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO");
	}


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("DRUG_CODE");  //0
	displayFields.add("LONG_NAME");
	displayFields.add("ROUTE_CODE");
	displayFields.add("ROUTE_DESC");
	displayFields.add("DOSAGE_DETAILS");
	displayFields.add("START_DATE");    //5
	displayFields.add("END_DATE");
	displayFields.add("PATIENT_CLASS");
	displayFields.add("PRESCRIBED_QTY");
	displayFields.add("TOT_ISSUED_QTY");
	displayFields.add("TOT_ADMINISTERED_QTY");//10
	displayFields.add("PRACTITIONER_NAME");
	displayFields.add("LOCATION");
	displayFields.add("FACILITY_NAME");

	displayFields.add("INFUSE_OVER");
	displayFields.add("TRN_TYPE_IND");  //15
	displayFields.add("STATUS");
	displayFields.add("ORIG_ORDER_ID");
	displayFields.add("ORIG_ORDER_LINE_NO");
	displayFields.add("SRL_NO");
	displayFields.add("HEIGHT");  //20
	displayFields.add("HEIGHT_UOM");
	displayFields.add("WEIGHT");
	displayFields.add("WEIGHT_UOM");
	displayFields.add("BSA");
	displayFields.add("BMI");  //25
	displayFields.add("DISCHARGE_IND");
	displayFields.add("IV_PREP_YN");  
	displayFields.add("ORDER_UOM");
	displayFields.add("ORDER_LINE_STATUS");
	displayFields.add("CHILD_ORDER_YN");    //30
	displayFields.add("DOSAGE_UOM_CODE");
	displayFields.add("LINE_STATUS_DESC");//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]
 
	ArrayList chkFields = new ArrayList();

	chkFields.add( patient_id.trim() );
	chkFields.add( pat_class.trim() );
	chkFields.add( pat_class.trim() );
	chkFields.add( dt_from.trim() );
	chkFields.add( dt_to.trim() );
	chkFields.add( drug_code.trim() );
	chkFields.add( drug_code.trim() );
	
	chkFields.add(locale);
	chkFields.add(locale);
	chkFields.add(locale);

	
	


// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);




	if( (result.size()>=index) && ( !( ((String) result.get(0)).equals("0")) )){

		result = bean.getAllDisplayedRecords(result);

		
		if (result.size()<index){
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script>
	<%
		return;
		}
	%>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));

	%>
		</td></tr>
		</table>
		<%
					//Retriving the records from result arraylist
		ArrayList records	=new ArrayList();

		String ht_wt_title	=	"";
		String order_line_no	=	"";
		String line_iv_prep_yn	=	"";
		String dtls				=	"";
		String discharge_med	=	"";
		String pres_qty			=	"";
		String disp_qty			=	"";
		String qty_uom			=	"";
		String disp_uom			=	"";
		//String ret_uom			=	"";
		String tot_admin_qty	=	"";
		String admin_uom		=	"";
		String ret_diff			=	"";
		String line_status		=	"";
		String child_order		=	"";		
		String classVal			=	"";
		String pres_uom			=	"";
		String patient_class	=	"";
		String line_status_text			= "";//SRR20056-SCF-7782 [IN:028179]
		//String reissue_uom		=	"";
		//String strength_per_pres_uom = "";
		//String content_in_pres_base_uom = "";
		//String reissue_date_time = "";
		//String dosage_details = "";
		String Rx = "Rx";
        String font_color="";
		int	   PPNIOrderValues  = 0;
		%>
		<!-- <div id='table_container_left' style='overflow:hidden;width:250px;height:358px;position:relative;float:left;'>
		<table   border="1" width=" 100%" cellpadding="0" cellspacing="0" align="left" style='border-collapse:collapse; position:absolute;'>

		
		<th colspan="3" ><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/></th> -->


           <div id='table_container_left' style='overflow:hidden;width:250px;height:342px;position:relative;float:left;'>
			<table   border="1" cellpadding="0" cellspacing="0" width="100%" align="left" style='border-collapse:collapse; position:absolute;'>
				<tr style='height:30px;'>
			   <td class='COLUMNHEADER' style="border:none">&nbsp;</td>
			 <td class='COLUMNHEADER' style="border:none">&nbsp;</td>
					<td class='COLUMNHEADER' colspan="2"><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/></td>
				</tr>
			
			<%
		for(int recCount=2; recCount<result.size(); recCount++) {

			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;

			records=(ArrayList) result.get(recCount);

			ht_wt_title		=	"";

			
			if(records.get(20)!=null)
				
			{
				ht_wt_title	=	"Height:"+CommonBean.checkForNull((String)records.get(20));
				ht_wt_title	+=	";  Weight:"+CommonBean.checkForNull((String)records.get(22));
				ht_wt_title	+=	";  BSA:"+CommonBean.checkForNull((String)records.get(24));
				ht_wt_title	+=	";  BMI:"+CommonBean.checkForNull((String)records.get(25));
			}	

		//	dosage_details =  CommonBean.checkForNull((String)records.get(4));
			patient_class	= CommonBean.checkForNull((String)records.get(7));
			order_line_no   = CommonBean.checkForNull((String)records.get(18));
			line_iv_prep_yn = CommonBean.checkForNull((String)records.get(27));
			discharge_med	= CommonBean.checkForNull((String)records.get(26));
			pres_qty		= CommonBean.checkForNull((String)records.get(8));
			disp_qty		= CommonBean.checkForNull((String)records.get(9));

			qty_uom			= CommonBean.checkForNull((String)records.get(28));
			admin_uom		= CommonBean.checkForNull((String)records.get(31));
			tot_admin_qty	= CommonBean.checkForNull((String)records.get(10));
			line_status		= CommonBean.checkForNull((String)records.get(29));
			child_order		= CommonBean.checkForNull((String)records.get(30));
			line_status_text= CommonBean.checkForNull((String)records.get(32));//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

			disp_uom		=	qty_uom;
		//	ret_uom			=	qty_uom+"  - ";
			admin_uom		=	qty_uom;
		//	reissue_uom		=	disp_uom+"  - ";
			pres_uom    = qty_uom;

			if(pres_qty.equals("0")){pres_qty =""; pres_uom="";}
			if(disp_qty.equals("")) {
				disp_uom	=	"";
			}
			if(line_status.equals("IP")) {
				//disp_qty	="ALLOCATED";
				disp_qty	="";
				disp_uom	="";
			}

			if(tot_admin_qty.equals("")) {
				admin_uom	=	"";
			}

			if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
				if(order_line_no.equals("1")){
					classVal="STANDARD";
				}else{
					classVal="NONSTANDARD";
				}
			}
			else if(discharge_med.equals("D")){
				classVal="DISCHARGEMED1";
			}
		%>		
		<tr style='height:27px;'>
		<%
			
			String drug_status = "";
			String order_id    = "";	
			String order_line_num	= "";
			String sr_no			= "";
			String future_yn		=	"";
			String expiry_yn		=	"";

			
			for(int colCount=0; colCount<records.size(); colCount++){
				/*
					 0	--->    
					 1	--->	LONG_NAME
					 2	--->	ROUTE_CODE
					 3	--->	ROUTE_DESC
					 4	--->	START_DATE
					 6	--->	END_DATE
					 11	--->	PREACTITIONER NAME
				*/
				if (colCount>13)
				{ 
					continue;

				}
				if (colCount ==0 ){
					drug_status = "";

					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 17 ),(String)records.get( 18 ));	
					
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					future_yn	=	bean.compareDate((String)records.get(5));
					expiry_yn	=	bean.compareDate((String)records.get(6));
					
	
					 if (line_status.equals("CN")){
							
						drug_status = "#990000";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "CANCEL";
						}
						
					}else if (line_status.equals("DC")){
						drug_status = "#C40062";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "DIS-CONTINUED";
						}
					}else if( ((((String)records.get( 16 )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
						if(future_yn.equals("Y")) { 
							drug_status = "#99FFCC";
							classVal	= "FUTURE_Rx";
						}else{
							drug_status = "#FF5E5E";
							if(expiry_yn.equals("N")){
								classVal	= "EXPIRED_MEDICATION";
							}else {
								classVal	= "ACTIVE";
							}
						}
					}else if(child_order.equals("Y")){
						drug_status = "#B6BC8B";
						if(future_yn.equals("Y")) { 
							classVal	= "FUTURE_Rx";
						}else{
							classVal	= "Refill_Rx";
						}
		       		}else if(future_yn.equals("Y")) { 
						drug_status = "#99FFCC";
						classVal	= "FUTURE_Rx";						
					} else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("")) )  {
						drug_status = "#8204FF";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "YET_TO_BE_DISPENSED";
						}
					}else if (line_status.equals("HD") || line_status.equals("HC")){
						if(expiry_yn.equals("N")){
							drug_status = "#D9B86C";
						}else{
							drug_status = "#F0F000";
						}
						classVal	= "HOLD";
					
					} else if(expiry_yn.equals("N")){
						drug_status = "#D9B86C";
						classVal	= "EXPIRED_MEDICATION";
					}else {
						drug_status = "";
						classVal	= classvalue;
					}

				if(line_status.equals("PO") || line_status.equals("PS")){
					ht_wt_title	+= " / Pending for Approval";
				}

				if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
						if(order_line_no.equals("1")){
							drug_status="#478F8F";
						}else{
							drug_status="#92C9C9";
						}
				}

				if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF")) ) && expiry_yn.equals("N")){
					drug_status="#D9B86C";
					classVal	= "EXPIRED_MEDICATION";
				}

				if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y")){
					drug_status="#D9B86C";
				}

	 order_id=(String)records.get( 17 );
	if(line_iv_prep_yn.equals("7")){Rx = "";drug_status="#478F8F";}else {Rx = "Rx"; drug_status="#92C9C9";}			
	%>          
			
	<td style="cursor:pointer;font-size:9;color:blue;background-color:<%=drug_status%>"  title="<%=ht_wt_title%>" colspan="2"  onClick="showTPNDetails('<%=order_id%>','<%=patient_id%>','<%=(String)records.get(0)%>');"><%=Rx%></td>
<%   }else if(colCount==1){
			PPNIOrderValues=0;
			if(line_iv_prep_yn.equals("7")){
				PPNIOrderValues  = bean.getPPNIOrderValues(order_id,patient_id);
			}
		if(classVal.equals("CANCEL")){font_color="white";}else{font_color="none";}
		%>
	<td style="font-size:10;color:<%=font_color%>" class="<%=classVal%>" title="<%=ht_wt_title%>" nowrap><%=(String)records.get(colCount)%>
	<%
			//out.println(PPNIOrderValues);
			if(PPNIOrderValues >0){
	%>
		<img  src='../../ePH/images/AddedIngredient.gif' style="cursor:pointer" height='15' width='15' onclick="openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=disp_locn_code%>','<%=discharge_med%>')"></img>	
	<%
		   }
		
		%>
	
	</td>

	<%

	}
			}
			%>
			</tr>	
			<%
	}%>
			
	
		</table>
				</div>
		<div id='table_container_right' style='overflow:scroll;height:358px;position:relative;float:left;'>
		<table   border="1" cellpadding="0" cellspacing="0" align="left" valign="top" style='border-collapse:collapse; position:absolute;'>

		<tr style='height:30px;'>
							
	
		<td class='COLUMNHEADER' nowrap style='border-left:0'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<!--  added status label by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]-->
		<td class='COLUMNHEADER' ><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td> 
	
		<td class='COLUMNHEADER' ><fmt:message key="ePH.Drug/DosageDetail.label" bundle="${ph_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="ePH.AdminQuantity.label" bundle="${ph_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	</tr>	
		<%
	
		  
		for(int recCount=2; recCount<result.size(); recCount++) {

			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;

			records=(ArrayList) result.get(recCount);

			ht_wt_title		=	"";

			
			if(records.get(20)!=null)
				
			{
				ht_wt_title	=	"Height:"+CommonBean.checkForNull((String)records.get(20));
				ht_wt_title	+=	";  Weight:"+CommonBean.checkForNull((String)records.get(22));
				ht_wt_title	+=	";  BSA:"+CommonBean.checkForNull((String)records.get(24));
				ht_wt_title	+=	";  BMI:"+CommonBean.checkForNull((String)records.get(25));
			}	

		//	dosage_details =  CommonBean.checkForNull((String)records.get(4));
			patient_class	= CommonBean.checkForNull((String)records.get(7));
			order_line_no   = CommonBean.checkForNull((String)records.get(18));
			line_iv_prep_yn = CommonBean.checkForNull((String)records.get(27));
			discharge_med	= CommonBean.checkForNull((String)records.get(26));
			pres_qty		= CommonBean.checkForNull((String)records.get(8));
			disp_qty		= CommonBean.checkForNull((String)records.get(9));

			qty_uom			= CommonBean.checkForNull((String)records.get(28));
			admin_uom		= CommonBean.checkForNull((String)records.get(31));
			tot_admin_qty	= CommonBean.checkForNull((String)records.get(10));
			line_status		= CommonBean.checkForNull((String)records.get(29));
			child_order		= CommonBean.checkForNull((String)records.get(30));
			line_status_text= CommonBean.checkForNull((String)records.get(32));//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

			disp_uom		=	qty_uom;
		//	ret_uom			=	qty_uom+"  - ";
			admin_uom		=	qty_uom;
		//	reissue_uom		=	disp_uom+"  - ";
			pres_uom    = qty_uom;

			if(pres_qty.equals("0")){pres_qty =""; pres_uom="";}
			if(disp_qty.equals("")) {
				disp_uom	=	"";
			}
			if(line_status.equals("IP")) {
				//disp_qty	="ALLOCATED";
				disp_qty	="";
				disp_uom	="";
			}

			if(tot_admin_qty.equals("")) {
				admin_uom	=	"";
			}

			if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
				if(order_line_no.equals("1")){
					classVal="STANDARD";
				}else{
					classVal="NONSTANDARD";
				}
			}
			else if(discharge_med.equals("D")){
				classVal="DISCHARGEMED1";
			}
		%>		
		<tr style='height:48px;'>
		<%
			
			String drug_status = "";
			String order_id    = "";	
			String order_line_num	= "";
			String sr_no			= "";
			String future_yn		=	"";
			String expiry_yn		=	"";

			
			for(int colCount=3; colCount<records.size(); colCount++){
				/*
					 0	--->    DRUG_CODE
					 1	--->	LONG_NAME
					 2	--->	ROUTE_CODE
					 3	--->	ROUTE_DESC
					 4	--->	START_DATE
					 6	--->	END_DATE
					 11	--->	PREACTITIONER NAME
				*/
				if (colCount>13)
				{ 
					continue;

				}
				if (colCount ==0 ){
					drug_status = "";

					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 17 ),(String)records.get( 18 ));	
					
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					future_yn	=	bean.compareDate((String)records.get(5));
					expiry_yn	=	bean.compareDate((String)records.get(6));
					
	
					 if (line_status.equals("CN")){
							
						drug_status = "#990000";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "CANCEL";
						}
						
					}else if (line_status.equals("DC")){
						drug_status = "#C40062";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "DIS-CONTINUED";
						}
					}else if( ((((String)records.get( 16 )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
						if(future_yn.equals("Y")) { 
							drug_status = "#99FFCC";
							classVal	= "FUTURE_Rx";
						}else{
							drug_status = "#FF5E5E";
							if(expiry_yn.equals("N")){
								classVal	= "EXPIRED_MEDICATION";
							}else {
								classVal	= "ACTIVE";
							}
						}
					}else if(child_order.equals("Y")){
						drug_status = "#B6BC8B";
						if(future_yn.equals("Y")) { 
							classVal	= "FUTURE_Rx";
						}else{
							classVal	= "Refill_Rx";
						}
		       		}else if(future_yn.equals("Y")) { 
						drug_status = "#99FFCC";
						classVal	= "FUTURE_Rx";						
					} else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("")) )  {
						drug_status = "#8204FF";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "YET_TO_BE_DISPENSED";
						}
					}else if (line_status.equals("HD") || line_status.equals("HC")){
						if(expiry_yn.equals("N")){
							drug_status = "#D9B86C";
						}else{
							drug_status = "#F0F000";
						}
						classVal	= "HOLD";
					
					} else if(expiry_yn.equals("N")){
						drug_status = "#D9B86C";
						classVal	= "EXPIRED_MEDICATION";
					}else {
						drug_status = "";
						classVal	= classvalue;
					}

				if(line_status.equals("PO") || line_status.equals("PS")){
					ht_wt_title	+= " / Pending for Approval";
				}

				if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
						if(order_line_no.equals("1")){
							drug_status="#478F8F";
						}else{
							drug_status="#92C9C9";
						}
				}

				if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF")) ) && expiry_yn.equals("N")){
					drug_status="#D9B86C";
					classVal	= "EXPIRED_MEDICATION";
				}

				if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y")){
					drug_status="#D9B86C";
				}

	 order_id=(String)records.get( 17 );
	if(line_iv_prep_yn.equals("7")){Rx = "";drug_status="#478F8F";}else {Rx = "Rx"; drug_status="#92C9C9";}			
	%>          
			
	<td style="cursor:pointer;font-size:9;color:blue;background-color:<%=drug_status%>"  title="<%=ht_wt_title%>" colspan="2"  onClick="showTPNDetails('<%=order_id%>','<%=patient_id%>','<%=(String)records.get(0)%>');"><%=Rx%></td>
<%   }//added below if else condition by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]
				else if (colCount==3){
					dtls = CommonBean.checkForNull((String)records.get( colCount ));
					if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
						if(!order_line_no.equals("1")){
							dtls = "&nbsp;";  
						}
					}
%>
					<td class="<%=classvalue%>" style='width:0px;border-left:0' title="<%=ht_wt_title%>" nowrap><%=line_status_text%></td>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap><%=dtls%>
                     <!-- if else condition end  -->
<%
				}else if (colCount==4){	
	%>			
				
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap> <%=(String)records.get(colCount)%></td>
	
	<%
	}else if (colCount==5){
	%>
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap> <%=(String)records.get(colCount)%></td>
	<%

	}else if (colCount==6){
	%>
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap> <%=(String)(records.get(colCount))%></td>
	<%

	}else if (colCount==7 ){
					order_id=(String)records.get( 17 );
					order_line_num=(String)records.get( 18 );
					sr_no         =(String)records.get( 19 );

	%>	
	
	
	<td class="<%=classvalue%>" align="center" title="<%=ht_wt_title%>">
	
	<%
					
			if ( !(((String)records.get(16)).trim()).equals("CANCEL") && !(((String)records.get(16)).trim()).equals("HOLD"))	{
	%>
	
				<font >&nbsp;</font>				
	<%	
		}
				
		 else  {	
	
	 %>		
		 
	 <font class="HYPERLINK" style="cursor:pointer" onClick="showRemarks('<%=order_id%>','<%=order_line_num%>','<%=sr_no%>','<%=line_status%>')">	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </font>

	 <%
		 }
	 
	 %>
		
	 </td>			
		<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( colCount) 
	 %> </td>			
	<% 
		}else if (colCount==8){
	%>
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_uom))%></td><!-- modfied FOR ML-MMOH-SCF-1303 -->
	<%

	}else if (colCount==9){
	%>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=disp_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))%></td><!-- modified FOR ML-MMOH-SCF-1303 -->
	<%

	}else if (colCount==10){
	%>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=tot_admin_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))%><!-- modified FOR ML-MMOH-SCF-1303 -->
						</td>		
	<%

	}else if(colCount==15){  
		 dtls = CommonBean.checkForNull((String)records.get( colCount ));
					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 12 ),(String)records.get( 13 ));	
					 
					discontinued_link_yn = (String)disc_cancel.get("DISCONTINUE");
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					if(disp_locn_code==null || disp_locn_code.equals("null"))
						disp_locn_code	=	"";

					if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
						disc_cancel_style = "cursor:pointer;color:blue";
					}else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
						disc_cancel_style = "cursor:pointer;color:blue";
					}else{
						disc_cancel_style = "";
					}
					if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
						on_click = "discontinueTheDrug('"+(String)records.get( 12 )+"','"+(String)records.get( 13 )+"','"+called_frm+"')";
					}else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
						on_click = "cancelTheDrug('"+(String)records.get( 12 )+"','"+(String)records.get( 13 )+"','"+called_frm+"')";
					}else{
						on_click = "";
					}
					if(called_frm==null)called_frm="";
					if(called_frm!=null && called_frm.equals("Dispense")){						
						if( ( ( (bean.isDiscontinuedAllowed(disp_locn_code)).equals("Y") || disp_locn_code.equals(""))  && discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || (  cancel_link_yn.equals("Y")) ) {
	%>
						<td class="<%=classvalue%>" title="<%=ht_wt_title%>" style="<%=disc_cancel_style%>" onMouseOver="showDiscCancelLink(this,'<%=discontinued_link_yn%>','<%=cancel_link_yn%>','<%=(String)records.get( 12 )%>','<%=(String)records.get( 13 )%>')" id="disc_cancel_id" onMouseOut="hideDiscCancelLink(this)" onClick="<%=on_click%>"><%=dtls%></td>
	<%
						}else{
	%>
						<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%></td>
	<%
						}
					}else if(called_frm!=null && !called_frm.equals("QUERY")){
						if( (discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || ( cancel_link_yn.equals("Y")) ) {
	%>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>" style="<%=disc_cancel_style%>" onMouseOver="showDiscCancelLink(this,'<%=discontinued_link_yn%>','<%=cancel_link_yn%>','<%=(String)records.get( 12 )%>','<%=(String)records.get( 13)%>')" id="disc_cancel_id" onMouseOut="hideDiscCancelLink(this)" onClick="<%=on_click%>"><%=dtls%></td>
	<%					} else {	

	%>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%></td>
	<%					}
					}else{
	%>
					<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%>
		</td>
	<%
					}
				}else{
					dtls = CommonBean.checkForNull((String)records.get( colCount ));
					if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
						if(!order_line_no.equals("1")){
							if(colCount==3 || colCount==11 || colCount==12 || colCount==13 )
								dtls = "&nbsp;";  
						}
					}
				
	%>
	
	<% if(colCount==11){ %>
					
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap	><%=(String)records.get(colCount)%></td>
	<%}else if(colCount==12){
		%>
			<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap	><%=(String)records.get(colCount)%>
							<br><br></td>
	<%}else {%>
						
	
	<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap><%=dtls%>
	<%           
							}	
				}
			}
			
	%>
		</tr>
	<%
		}
	%>
		</table>
		</div>
		<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
	<tr><td width="100%" id="t"></td></tr>
</table>
</div>
	<%
		out.flush();
	%>
	<script language="javascript">
		parent.parent.f_query_status.location.href="../../ePH/jsp/QueryTPNPatientDrugProfileStatus.jsp";
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
	} else{
	%>
	<script>
		parent.parent.f_query_status.location.href="../../eCommon/html/blank.html";
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPatientDrugProfileTPNResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}
%>
</body>
<% 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_2,bean_2,request); 
%>
</html>

