<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eBL/js/BLFutOrdInsApprTrackResult.js' language='javascript'></script>
<script src='../../eBL/js/BLFutOrdInsApprTrack.js' language='javascript'></script>

<HTML>
<HEAD>
	<style>
		div.tableContainer {
			width: 100%;		/* table width will be 99% of this*/
			height: 160px; 	/* must be greater than tbody*/
			overflow: auto;
			margin: 0 auto;
		}
		
		table {
			width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
			border: none;
			background-color: #f7f7f7;
			}
			
		table>tbody	{  /* child selector syntax which IE6 and older do not support*/
			overflow: auto; 
			height: 120x;
			overflow-x: hidden;
			}
			
		thead tr	{
			position:relative; 
			top: expression(offsetParent.scrollTop); /*IE5+ only*/
			}
				
				div.tableContainer {
				width: 100%;		/* table width will be 99% of this*/
				height: 140px; 	/* must be greater than tbody*/
				overflow: scroll;
				margin: 0 auto;
			}	
				TD.YELLOW 
				{			
					BACKGROUND-COLOR: yellow ;
					FONT-SIZE: 8pt ;
					border-style: dashed;
					border-left-color: #D5E2E5;
					border-right-color: #D5E2E5;
					border-top-color: #D5E2E5;
					border-bottom-color: #D5E2E5; 
				}
				
				.LocalYellow
				{
					COLOR:#444444;
					BACKGROUND-COLOR: yellow ;
					FONT-SIZE: 8pt ;
					border: 1x;
					border-style: dashed;
					border-left-color: #D5E2E5;
					border-right-color: #D5E2E5;
					border-top-color: #D5E2E5;
					border-bottom-color: #D5E2E5; 
					PADDING-LEFT:7px;
		  			PADDING-RIGHT:7px
				}
		SPAN.LABEL
		{
		  COLOR:#444444;
		  /*background-color:#FFFFFF;*/
		  background-color:#FFFFFF;
		  FONT-SIZE: 8pt;
		  TEXT-ALIGN: LEFT;
		  /*TEXT-ALIGN: RIGHT;*/
		  PADDING-LEFT:7px;
		  PADDING-RIGHT:7px
		}
		
		SPAN.LABEL1
		{
		  COLOR:#444444;
		  /*background-color:#FFFFFF;*/
		  background-color:#FFFFFF;
		  FONT-SIZE: 8pt;
		  /*TEXT-ALIGN: LEFT;*/
		  TEXT-ALIGN: RIGHT;
		  PADDING-LEFT:7px;
		  PADDING-RIGHT:7px
		}
		
		SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
			PADDING-RIGHT:7px
		}
	</style>
</HEAD>
<%
	System.err.println("In BLFutOrdInsApprTrackResultFrame.jsp");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>

<%!	
	private String checkForNull(String inputString, String dfltVal)
	{
		return (inputString == null) ? dfltVal : inputString;
	}
%>

<%
	Connection con=null;
	PreparedStatement pstmt = null;
	BLHelper blHelper = null;
	CallableStatement callStmt=null;
	ResultSet rst=null;
	Map servStatusList = new HashMap();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String qry_enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String qry_spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));	
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_order_status = checkForNull(request.getParameter("order_status"));
	String qry_serviceGroupCode = checkForNull(request.getParameter("serviceGroupCode"));
	String qry_serviceClassificationCode = checkForNull(request.getParameter("serviceClassificationCode"));
	String qry_coding_status = checkForNull(request.getParameter("coding_status"));
	String qry_billingGrpCode = checkForNull(request.getParameter("billingGrpCode"));
	String qry_policy_no = checkForNull(request.getParameter("policy_no"));
	String prevActionID = checkForNull(request.getParameter("prevActionID"));
	
	System.err.println("URL Parameters :- Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Enc_frm_date="+qry_enc_frm_date+", Enc_to_date="+qry_enc_to_date+", Spec_nursing_unit_code="+qry_spec_nursing_unit_code+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Order_status="+qry_order_status+", ServiceGroupCode="+qry_serviceGroupCode+", ServiceClassificationCode="+qry_serviceClassificationCode+", Coding_status="+qry_coding_status+", BillingGrpCode="+qry_billingGrpCode);
%>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="BLFutOrdInsApprTrackResultFrame" id="BLFutOrdInsApprTrackResultFrame">

<table cellpadding=3 cellspacing=0  width="100%" border="1">
<div id="tableContainer">

<%	

	
	try
	{
		System.err.println("Query String in inerror.jsp:"+request.getQueryString());
		System.err.println("from date:"+new Date(sdf.parse(qry_enc_frm_date).getTime()));
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		String sql = "";
		int row_count = 0;
		int column_count = 1;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		System.err.println("locale in BLFutOrdInsApprTrackResultFrame.jsp:"+locale);
		
		
		con=ConnectionManager.getConnection(request);
		
		servStatusList = (Map) BLHelper.getListOfItems(con, "BL", "L_SERVICE_STATUS", locale);

		sql = "{call BL_POPULATE_FUTURE_ORD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.err.println(sql);
		callStmt = con.prepareCall(sql);
		callStmt.setString(1,facilityId);						//v_operating_facility_id
		callStmt.setString(2,qry_patient_id);						//v_patient_id
		callStmt.setString(3,"");						//v_patient_name
		callStmt.setString(4,qry_spec_nursing_unit_code);		//v_speciality_code	
		callStmt.setString(5, qry_episode_type);				//v_episode_type
		callStmt.setString(6, qry_encounter_id);				//v_encounter_id
		callStmt.setDate(7, new Date(sdf.parse(qry_enc_frm_date).getTime()));				//v_encounter_date_from
		callStmt.setDate(8, new Date(sdf.parse(qry_enc_to_date).getTime()));			//v_encounter_date_to
		callStmt.setString(9, qry_insurance_Status);				//v_ins_status
		callStmt.setString(10, qry_payer_grp_code);		//v_cust_group_code
		callStmt.setString(11, qry_payer_code);			//v_cust_code
		callStmt.setString(12, qry_policy_no);			//v_policy_number
		callStmt.setString(13, qry_order_status);				//v_order_line_status
		callStmt.setString(14, qry_serviceGroupCode);								//v_serv_grp_code
		callStmt.setString(15, qry_serviceClassificationCode);								//v_serv_classification_code
		callStmt.setString(16, qry_billingGrpCode);								//v_blng_grp_id
		callStmt.setString(17, qry_coding_status);								//v_coder_status

		callStmt.execute();
		
		sql = "select a.PATIENT_ID as PATIENT_ID , (select short_name from mp_patient_mast where patient_id =  a.PATIENT_ID) as patient_name , "+
 			"decode(a.episode_type,'O','OP','I','IP','E','EM','D','DC') patient_class , "+
			"a.ENCOUNTER_ID as ENCOUNTER_ID  , "+
 			"(select long_name from ar_customer_lang_vw where cust_code = a.CUST_CODE and language_id = '"+locale+"') payer_desc, "+
			"a.CUST_CODE as payer_code, "+
 			"a.POLICY_NUMBER as POLICY_NUMBER , "+
			"to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') as VISIT_ADM_DATE_TIME , "+
 			"a.PHYSICIAN_ID as PHYSICIAN_ID , "+
			"(select PRACTITIONER_NAME from am_practitioner_lang_vw where practitioner_id = a.PHYSICIAN_ID and language_id = '"+locale+"') PHYSICIAN_NAME , "+
			"a.SPECIALITY_CODE as SPECIALITY_CODE , "+
			"(case WHEN a.episode_type = 'I' OR a.episode_type ='D' THEN (SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = 'SA' AND NVL(EFF_STATUS,'D') = 'E' and NURSING_UNIT_CODE = a.SPECIALITY_CODE) WHEN a.episode_type = 'O' OR a.episode_type ='E' THEN (select short_desc from am_speciality_lang_vw where language_id='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' and speciality_code = a.SPECIALITY_CODE) end) as SPECIALTY_DESC, "+
 			"to_char(a.SIGNED_DATE,'dd/mm/yyyy') as SIGNED_DATE , "+
			"a.ORDER_CATALOG_CODE as ORDER_CATALOG_CODE , "+
 			"to_char(a.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') as ORD_DATE_TIME , "+
 			"a.ORDER_BY_ID , "+
 			"a.ORDER_LINE_STATUS , "+
 			"(select short_desc from OR_ORDER_STATUS_CODE where order_status_code = a.ORDER_LINE_STATUS ) as order_status_desc, "+
 			"to_char(a.FUTURE_ORD_LINK_DATE,'dd/mm/yyyy HH24:MI:SS') as FUTURE_ORD_LINK_DATE , "+
 			"a.CODER_ID         , "   +
 			"a.CODER_REMARKS             , "+
 			"a.ORDER_CATEGORY            , "+
			"(SELECT SHORT_DESC FROM OR_ORDER_CATEGORY_lang_vw b WHERE a.ORDER_CATEGORY = b.ORDER_CATEGORY and LANGUAGE_ID = '"+locale+"') ORDER_CAT_DESC, "+
 			"a.CODER_STATUS              , "+
			"DECODE(a.CODER_STATUS,'*A','All','NW','New','DQ','Doctor Query','SQ','Supervisor Query','HD','Hold','PC','Partially Completed','CO','Completed','SC','Supervisor Clearance Completed') CODER_STATUS_DESC , "+
 			"NVL((select LIST_ELMT_LABEL from SM_LIST_ITEM WHERE LIST_ELMT_VALUE = a.ins_status and module_id = 'BL' AND LIST_REF = 'L_REC_APPROVAL_STATUS' ),'') INS_STATUS , "+
 			"a.INS_APPR_REMARKS          , "+
 			"a.INS_APPR_AUTH_BY_ID , "+
 			"to_char(a.APPR_START_DATE,'dd/mm/yyyy') as APPR_START_DATE , to_char(a.APPR_EXPIRE_DATE,'dd/mm/yyyy') as APPR_EXPIRE_DATE , "+
 			"a.OPERATING_FACILITY_ID, a.PRIMARY_KEY_MODULE_ID, a.PRIMARY_KEY_MAIN, a.PRIMARY_KEY_LINE_NO, a.SERV_ITEM_CODE, a.BLNG_SERV_CODE BLNG_SERV_CODE , "+
 			"a.APPR_INFO_TO_PAT_YN , a.APPR_INFO_BY_ID , to_char(a.APPR_INFO_DATE,'dd/mm/yyyy') as APPR_INFO_DATE , to_char(a.SERVICE_PERFORM_DATE,'dd/mm/yyyy') as SERVICE_PERFORM_DATE , a.SERVICE_STATUS  , a.SERVICE_REMARKS  , "+
 			"a.FOLLOW_UP_VISIT_APPT_YN , to_char(a.APPT_DATE_TIME,'dd/mm/yyyy') as APPT_DATE_TIME , a.FOLLOW_UP_VIST_ADM "+
 			"from BL_FUTURE_ORD_INS_APPR_TRK a "+
 			"where OPERATING_FACILITY_ID = '"+facilityId+"'  and "+
			"a.trx_status IS NULL and "+
			"a.patient_id = nvl(?,a.PATIENT_ID) and "+
 			"a.episode_type = nvl(?,a.episode_type) and  "+
	 		"a.ENCOUNTER_ID = nvl(?,a.ENCOUNTER_ID) and "+			
			"a.SPECIALITY_CODE = NVL(?,a.SPECIALITY_CODE) and "+
			"a.ORDER_LINE_STATUS = nvl(?,a.ORDER_LINE_STATUS) and "+
			"a.SERV_GRP_CODE = nvl(?,a.SERV_GRP_CODE) and "+
			"a.SERV_CLASSIFICATION_CODE = nvl(?,a.SERV_CLASSIFICATION_CODE) and "+
			"a.BLNG_GRP_ID = nvl(?,a.BLNG_GRP_ID) and "+
			"a.CUST_CODE IS NOT NULL AND "+
			"trunc(a.VISIT_ADM_DATE_TIME) between "+
			"to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')";							 
			
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + " and a.CUST_GROUP_CODE = nvl(?,a.CUST_GROUP_CODE) ";
		}
		
		if(!"".equals(qry_payer_code)){
			sql = sql + " and a.CUST_CODE = nvl(?,a.CUST_CODE) ";
		}
		
		if(!"".equals(qry_policy_type_code)){
			sql = sql + " and a.policy_type_code = nvl(?,a.policy_type_code) ";
		}
		
		if(!"".equals(qry_coding_status) && !"*A".equals(qry_coding_status))
			sql = sql + " and (a.CODER_STATUS = nvl(?,a.CODER_STATUS)) ";
		
		if(!"".equals(qry_insurance_Status))
			sql = sql + " and (a.INS_STATUS = nvl(?,a.INS_STATUS)) ";
		
		System.err.println("sql to load data :"+sql);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(column_count,qry_patient_id);						
		pstmt.setString(++column_count,qry_episode_type);						
		pstmt.setString(++column_count,qry_encounter_id);						
		pstmt.setString(++column_count, qry_spec_nursing_unit_code);	
		pstmt.setString(++column_count, qry_order_status);
		pstmt.setString(++column_count, qry_serviceGroupCode);								
		pstmt.setString(++column_count, qry_serviceClassificationCode);	
		pstmt.setString(++column_count, qry_billingGrpCode);		
		pstmt.setString(++column_count, qry_enc_frm_date);				
		pstmt.setString(++column_count, qry_enc_to_date);			

		System.err.println("sql to load data column_count:"+column_count);
		if(!"".equals(qry_payer_grp_code))
			pstmt.setString(++column_count,qry_payer_grp_code);			
		
		if(!"".equals(qry_payer_code))
			pstmt.setString(++column_count, qry_payer_code);
		
		if(!"".equals(qry_policy_type_code))
			pstmt.setString(++column_count, qry_policy_type_code);
		
		if(!"".equals(qry_coding_status) && !"*A".equals(qry_coding_status))
			pstmt.setString(++column_count, qry_coding_status);
		
		if(!"".equals(qry_insurance_Status))
			pstmt.setString(++column_count, qry_insurance_Status);		

		System.err.println("sql to load data column_count:"+column_count);
		
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			String patient_id = checkForNull(rst.getString("PATIENT_ID"));
			String patient_name = checkForNull(rst.getString("patient_name"));
			String encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
			String pat_class = checkForNull(rst.getString("patient_class"));
			String payer_code = checkForNull(rst.getString("payer_code"));
			String payer_grp_desc = checkForNull(rst.getString("payer_desc"));
			String policy_no = checkForNull(rst.getString("POLICY_NUMBER"));
			String visit_date = checkForNull(rst.getString("VISIT_ADM_DATE_TIME"));
			String physician_id = checkForNull(rst.getString("PHYSICIAN_ID"));
			String Physician_name = checkForNull(rst.getString("PHYSICIAN_NAME"));
			String Speciality_code = checkForNull(rst.getString("SPECIALITY_CODE"));
			String specialty_desc = checkForNull(rst.getString("SPECIALTY_DESC"));
			String signed_date = checkForNull(rst.getString("SIGNED_DATE"));
			String order_catalog_code = checkForNull(rst.getString("ORDER_CATALOG_CODE"));
			String ord_date_time = checkForNull(rst.getString("ORD_DATE_TIME"));
			String ordered_by = checkForNull(rst.getString("ORDER_BY_ID"));
			String order_status = checkForNull(rst.getString("ORDER_LINE_STATUS"));
			String order_status_desc = checkForNull(rst.getString("order_status_desc"));
			String future_ord_link_date = checkForNull(rst.getString("FUTURE_ORD_LINK_DATE"));
			String coder_id = checkForNull(rst.getString("CODER_ID"));
			String coder_remarks = checkForNull(rst.getString("CODER_REMARKS"));
			String order_category = checkForNull(rst.getString("ORDER_CATEGORY"));
			String order_cat_desc = checkForNull(rst.getString("ORDER_CAT_DESC"));			
			String coder_status = checkForNull(rst.getString("CODER_STATUS"));
			String coder_status_desc = checkForNull(rst.getString("CODER_STATUS_DESC"));			
			String insurance_status = checkForNull(rst.getString("INS_STATUS"));
			String ins_remarks = checkForNull(rst.getString("INS_APPR_REMARKS"));
			String ins_appr_auth_by_id = checkForNull(rst.getString("INS_APPR_AUTH_BY_ID"));
			String appr_start_date = checkForNull(rst.getString("APPR_START_DATE"));
			String appr_expire_date = checkForNull(rst.getString("APPR_EXPIRE_DATE"));
			String operating_facility_id = checkForNull(rst.getString("OPERATING_FACILITY_ID"));
			String primary_key_module_id = checkForNull(rst.getString("PRIMARY_KEY_MODULE_ID"));
			String primary_key_main =  checkForNull(rst.getString("PRIMARY_KEY_MAIN"));
			String primary_key_line_no = checkForNull(rst.getString("PRIMARY_KEY_LINE_NO"));
			String serv_item_code = checkForNull(rst.getString("SERV_ITEM_CODE"));
			String blng_serv_code = checkForNull(rst.getString("BLNG_SERV_CODE"));		
			String appr_info_to_pat_yn = checkForNull(rst.getString("APPR_INFO_TO_PAT_YN"));
			String appr_info_by_id = checkForNull(rst.getString("APPR_INFO_BY_ID"));
			String appr_info_date = checkForNull(rst.getString("APPR_INFO_DATE"));	
			String service_perform_date = checkForNull(rst.getString("SERVICE_PERFORM_DATE"));	
			String service_status = checkForNull(rst.getString("SERVICE_STATUS"));		
			String service_remarks = checkForNull(rst.getString("SERVICE_REMARKS"));
			String follow_up_visit_appt_yn = checkForNull(rst.getString("FOLLOW_UP_VISIT_APPT_YN"));		
			String appt_date_time =  checkForNull(rst.getString("APPT_DATE_TIME"));		
			String follow_up_vist_adm = checkForNull(rst.getString("FOLLOW_UP_VIST_ADM"));
			
 			row_count++;

%>
	
<%
		if(row_count == 1)
		{
%>			
<thead>
	<tr><td class="COLUMNHEADER" align='left' colspan="26">Details</td></tr>
	<tr>
		<td class='COLUMNHEADER' nowrap width = "2%"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Signed_Date.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'  width = "5%"><fmt:message key="eBL.Fut_Ord_Li_Da_Ti.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.Coder_Name.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>		
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.Coding_Status.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.INS_Status.label" bundle="${bl_labels}"/></td>		
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>			
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Approval_inf_to_Patient.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Approval_inf_By.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Approval.label" bundle="${bl_labels}"/> <fmt:message key="Common.InformedDate/Time.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Approval.label" bundle="${bl_labels}"/> <fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>		
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Approval_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.Service_Performed_Date.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.Service_Status.label" bundle="${bl_labels}"/></td>		
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>			
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.followup.label" bundle="${common_labels}"/> <fmt:message key="Common.Visit.label" bundle="${common_labels}"/> - <fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></td>	 
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.APPT_DATE_TIME.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.followup.label" bundle="${common_labels}"/> <fmt:message key="Common.Visit.label" bundle="${common_labels}"/> / <fmt:message key="Common.admission.label" bundle="${common_labels}"/></td> 
	</tr>
</thead>
<tbody>
<%
		}
%>		

	<tr id='row<%=row_count%>' >
		<td class="fields">
			&nbsp;<label><%=row_count%></label>
			<input type="hidden" name = 'OPERATING_FACILITY_ID_<%=row_count%>' id = 'OPERATING_FACILITY_ID_<%=row_count%>' value ='<%=operating_facility_id%>' />
			<input type="hidden" name = 'PRIMARY_KEY_MODULE_ID_<%=row_count%>' id = 'PRIMARY_KEY_MODULE_ID_<%=row_count%>' value ='<%=primary_key_module_id%>' />
			<input type="hidden" name = 'PRIMARY_KEY_MAIN_<%=row_count%>' id = 'PRIMARY_KEY_MAIN_<%=row_count%>' value ='<%=primary_key_main%>' />
			<input type="hidden" name = 'PRIMARY_KEY_LINE_NO_<%=row_count%>' id = 'PRIMARY_KEY_LINE_NO_<%=row_count%>' value ='<%=primary_key_line_no%>' />
			<input type="hidden" name = 'SERV_ITEM_CODE_<%=row_count%>' id = 'SERV_ITEM_CODE_<%=row_count%>' value ='<%=serv_item_code%>' />
			<input type="hidden" name = 'BLNG_SERV_CODE_<%=row_count%>' id = 'BLNG_SERV_CODE_<%=row_count%>' value ='<%=blng_serv_code%>' />
		</td>
		
		 <td class="field" nowrap>
         	&nbsp;<label name="encounter_id_<%=row_count%>" id="encounter_id_<%=row_count%>"><%=encounter_id%></label>
         </td>
		
		<td class="field" nowrap>
        	&nbsp;<label name="order_catalog_<%=row_count%>" id="order_catalog_<%=row_count%>"><%=order_catalog_code%></label>
        	<input type="hidden" id="order_catalog_code_<%=row_count%>" name="order_catalog_code_<%=row_count%>" value="<%=order_catalog_code%>">
		</td>
		
		<td class="field" nowrap>
        	&nbsp;<label name="order_date_time_<%=row_count%>" id="order_date_time_<%=row_count%>"><%=ord_date_time%></label>
		</td>
		
		<td class="field" nowrap>
		     &nbsp;<label name="signed_date_<%=row_count%>" id="signed_date_<%=row_count%>"><%=signed_date%></label>
		</td>
		
		<td class="field" nowrap>
        	&nbsp;<label name="order_by_<%=row_count%>" id="order_by_<%=row_count%>"><%=ordered_by%></label>
        	<input type="hidden" id="ordered_by_code_<%=row_count%>" name="ordered_by_code_<%=row_count%>" value="<%=ordered_by%>">
		</td>
		
		<td class="field" nowrap>
		    &nbsp;<label name="order_status_<%=row_count%>" id ="order_status_<%=row_count%>"><%=order_status_desc%></label>
		</td>
		
		<td class="field" nowrap> 
       		&nbsp;<label name="fut_ord_link_date_time_<%=row_count%>" id="fut_ord_link_date_time_<%=row_count%>"><%=future_ord_link_date%></label>
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="coder_name_<%=row_count%>" id="coder_name_<%=row_count%>"><%=coder_id%>
			</label><input type="hidden" id="coder_id_<%=row_count%>" name="coder_id_<%=row_count%>" value="<%=coder_id%>">
		</td>
		
		<td class="field" >
			&nbsp;<label name="remarks_<%=row_count%>" id="remarks_<%=row_count%>"><%=coder_remarks%></label>
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="category_desc_<%=row_count%>" id="category_desc_<%=row_count%>"><%=order_cat_desc%></label>
			<input type="hidden" id="category_<%=row_count%>" name="category_<%=row_count%>" value="<%=order_category%>">
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="coding_status_desc_<%=row_count%>" id="coding_status_desc_<%=row_count%>"><%=coder_status_desc%></label>
			<input type="hidden" id="coding_status_<%=row_count%>" name="coding_status_<%=row_count%>" value="<%=coder_status%>">
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="insurance_status_<%=row_count%>" id="insurance_status_<%=row_count%>"><%=insurance_status%></label>
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="ins_remarks_<%=row_count%>" id="ins_remarks_<%=row_count%>"><%=ins_remarks%></label>
		</td>
		
		<td class="field" nowrap>
			&nbsp;<label name="authorized_by_<%=row_count%>" id="authorized_by_<%=row_count%>"><%=ins_appr_auth_by_id%></label>
			<input type="hidden" id="ins_appr_auth_by_id_<%=row_count%>" name="ins_appr_auth_by_id_<%=row_count%>" value="<%=ins_appr_auth_by_id%>">
		</td>
		
		<td class="fields" nowrap>&nbsp;
		              <Select name="APPR_INFO_TO_PAT_YN_<%=row_count%>" id="APPR_INFO_TO_PAT_YN_<%=row_count%>" id="APPR_INFO_TO_PAT_YN_<%=row_count%>">
		                             <option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
		                             <option value="Y" <%= "Y".equals(appr_info_to_pat_yn)?"selected":""%>>Yes</option>
		                             <option value="N" <%= "N".equals(appr_info_to_pat_yn)?"selected":""%>>No</option>
		              </Select>
		              
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="APPR_INFO_BY_ID_<%=row_count%>" id="APPR_INFO_BY_ID_<%=row_count%>" id="APPR_INFO_BY_ID_<%=row_count%>" maxlength = '50' value="<%=appr_info_by_id%>" />
				
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="APPR_INFO_DATE_<%=row_count%>" id="APPR_INFO_DATE_<%=row_count%>" id="APPR_INFO_DATE_<%=row_count%>" size = "12" maxlength="10" onblur='' value="<%=appr_info_date%>">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('APPR_INFO_DATE_<%=row_count%>');"  onKeyPress="return lockbackSpace();">
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="APPR_START_DATE_<%=row_count%>" id="APPR_START_DATE_<%=row_count%>" id="APPR_START_DATE_<%=row_count%>" readonly size = "12" maxlength="10" onblur='' value="<%=appr_start_date%>">
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="APPR_EXPIRE_DATE_<%=row_count%>" id="APPR_EXPIRE_DATE_<%=row_count%>" id="APPR_EXPIRE_DATE_<%=row_count%>" readonly size = "12" maxlength="10" onblur='' value="<%=appr_expire_date%>">
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="SERVICE_PERFORM_DATE_<%=row_count%>" id="SERVICE_PERFORM_DATE_<%=row_count%>" id="SERVICE_PERFORM_DATE_<%=row_count%>" size = "12" maxlength="10" onblur='' value="<%=service_perform_date%>">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('SERVICE_PERFORM_DATE_<%=row_count%>');"  onKeyPress="return lockbackSpace();">
		</td>
		
		<td class="fields" nowrap>
        &nbsp;<select name="SERVICE_STATUS_<%=row_count%>" id="SERVICE_STATUS_<%=row_count%>" id="SERVICE_STATUS_<%=row_count%>">
					<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
					<% if(servStatusList != null){
						Iterator it = servStatusList.keySet().iterator();%>

						<% while(it.hasNext()){
							String key=(String)it.next(); %>  
							<option value='<%=key%>' <%= key.equals(service_status)?"selected":""%>><%=servStatusList.get(key) %></option>
					<% }} %>				  
        </select>
		</td>
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="SERVICE_REMARKS_<%=row_count%>" id="SERVICE_REMARKS_<%=row_count%>" id="SERVICE_REMARKS_<%=row_count%>" maxlength = '100' value="<%=service_remarks%>" />
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<Select name="FOLLOW_UP_VISIT_APPT_YN_<%=row_count%>" id="FOLLOW_UP_VISIT_APPT_YN_<%=row_count%>" id="FOLLOW_UP_VISIT_APPT_YN_<%=row_count%>">
		                         <option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
		                         <option value="Y" <%= "Y".equals(follow_up_visit_appt_yn)?"selected":""%>>Yes</option>
		                     	 <option value="N" <%= "N".equals(follow_up_visit_appt_yn)?"selected":""%>>No</option>
		              </Select>
		</td>
		
		<td class="fields" nowrap>
		              &nbsp;<input type="text" name="APPT_DATE_TIME_<%=row_count%>" id="APPT_DATE_TIME_<%=row_count%>" id="APPT_DATE_TIME_<%=row_count%>" size = "12" maxlength="10" onblur='' value="<%=appt_date_time%>">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('APPT_DATE_TIME_<%=row_count%>');"  onKeyPress="return lockbackSpace();">
		</td>   
		
		<td class="fields" nowrap>
		&nbsp;<Select name="FOLLOW_UP_VIST_ADM_<%=row_count%>" id="FOLLOW_UP_VIST_ADM_<%=row_count%>" id="FOLLOW_UP_VIST_ADM_<%=row_count%>">
			<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
			<option value="V"  <%= "V".equals(follow_up_vist_adm)?"selected":""%>><fmt:message key="Common.Visit.label" bundle="${common_labels}"/></option>
			<option value="A"  <%= "A".equals(follow_up_vist_adm)?"selected":""%>><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
		</Select>
		</td>
		 
		
	</tr>	
<%
		}
%>		

	</tbody>

<%					
		
		if(row_count == 0){
%>	
<Script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
<%
		}
%>
	
	</tbody>
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type="hidden" name="rowCount" id="rowCount" id="rowCount" value="<%=row_count%>"/> 
	<input type="hidden" id="p_action_id" name="p_action_id" id="p_action_id"	value="">	
	<input type="hidden" id="prevActionID" name="prevActionID" id="prevActionID"	value="<%=prevActionID%>">	
	
	
	<input type="hidden" id="p_facility_id" name="p_facility_id" id="p_facility_id"	value="<%=facilityId%>">
	<input type="hidden" id="p_patient_id" name="p_patient_id" id="p_patient_id"	value="<%=qry_patient_id%>">
	<input type="hidden" id="p_episode_type" name="p_episode_type" id="p_episode_type"	value="<%=qry_episode_type%>">
	<input type="hidden" id="p_encounter_id" name="p_encounter_id" id="p_encounter_id"	value="<%=qry_encounter_id%>">
	<input type="hidden" id="p_speciality_code" name="p_speciality_code" id="p_speciality_code"	value="<%=qry_spec_nursing_unit_code%>">
	<input type="hidden" id="p_payer_grp_code" name="p_payer_grp_code" id="p_payer_grp_code"	value="<%=qry_payer_grp_code%>">
	<input type="hidden" id="p_payer_code" name="p_payer_code" id="p_payer_code"	value="<%=qry_payer_code%>">
	<input type="hidden" id="p_policy_type_code" name="p_policy_type_code" id="p_policy_type_code"	value="<%=qry_policy_type_code%>">
	<input type="hidden" id="p_blng_grp_id" name="p_blng_grp_id" id="p_blng_grp_id"	value="<%=qry_billingGrpCode%>">	
	<input type="hidden" id="p_serv_grp_code" name="p_serv_grp_code" id="p_serv_grp_code"	value="<%=qry_serviceGroupCode%>">
	<input type="hidden" id="p_serv_class_code" name="p_serv_class_code" id="p_serv_class_code"	value="<%=qry_serviceClassificationCode%>">
	<input type="hidden" id="p_order_line_status" name="p_order_line_status" id="p_order_line_status"	value="<%=qry_order_status%>">
	<input type="hidden" id="p_coding_status" name="p_coding_status" id="p_coding_status"	value="<%=qry_coding_status%>">
	<input type="hidden" id="p_ins_status" name="p_ins_status" id="p_ins_status"	value="<%=qry_insurance_Status%>">
	<input type="hidden" id="p_enc_frm_date" name="p_enc_frm_date" id="p_enc_frm_date"	value="<%=qry_enc_frm_date%>">
	<input type="hidden" id="p_enc_to_date" name="p_enc_to_date" id="p_enc_to_date"	value="<%=qry_enc_to_date%>">
	
<%					
		if(row_count > 0){
%>	
<Script>
displayQeuryButtons();
</script>
<%
		}
%>
	
</table>	
</div>	
<%
	}catch(Exception e){
		out.println("Exception in BLFutOrdInsApprTrackResultFrame.jsp: "+e);
		System.err.println("Exception in BLFutOrdInsApprTrackResultFrame.jsp: "+e);
	}finally{
		if(callStmt!=null)	callStmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 
%>
</form>
</BODY>
<script>
var prevActionID = document.forms[0].prevActionID.value;
prevActionCall(prevActionID);
</script>
</HTML>

