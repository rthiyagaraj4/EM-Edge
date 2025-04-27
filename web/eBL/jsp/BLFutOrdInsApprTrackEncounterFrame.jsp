<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eBL/js/BLFutOrdInsApprTrackResult.js' language='javascript'></script>
<script src='../../eBL/js/BLFutOrdInsApprTrack.js' language='javascript'></script>

<html>
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
	System.err.println("In BLFutOrdInsApprTrackEncounterFrame.jsp");
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
	ResultSet rst=null;
	
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
	String prevActionID = checkForNull(request.getParameter("prevActionID"));
	String prevEncounterId = checkForNull(request.getParameter("prevEncounterId"));
	
	System.err.println("URL Parameters :- Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Enc_frm_date="+qry_enc_frm_date+", Enc_to_date="+qry_enc_to_date+", Spec_nursing_unit_code="+qry_spec_nursing_unit_code+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Order_status="+qry_order_status+", ServiceGroupCode="+qry_serviceGroupCode+", ServiceClassificationCode="+qry_serviceClassificationCode+", Coding_status="+qry_coding_status+", BillingGrpCode="+qry_billingGrpCode+", prevActionID= "+prevActionID);
%>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="BLFutOrdInsApprTrackEncounterFrame" id="BLFutOrdInsApprTrackEncounterFrame">
<table cellpadding=3 cellspacing=0  width="100%" border="1">
<div id="tableContainer">

<%	

	
	try
	{
		System.err.println("Query String in inerror.jsp:"+request.getQueryString());
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		String sql = "";
		int row_count = 0;
		int column_count = 1;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		System.err.println("locale in BLFutOrdInsApprTrackEncounterFrame.jsp: "+locale);
		
		
		con=ConnectionManager.getConnection(request);
		
		sql = "SELECT DISTINCT b.short_name patient_name, a.patient_id PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, "+
			  "(select long_name from ar_customer_lang_vw where cust_code = c.CUST_CODE and language_id = 'en') as Payer, "+
			  "POLICY_NUMBER as PolicyNumber, "+
			  "to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH:MI:SS') VISIT_ADMN_DATE_TIME, "+
			  "(select PRACTITIONER_NAME from am_practitioner_lang_vw where practitioner_id = (DECODE(PATIENT_CLASS,'IP',ADMIT_PRACTITIONER_ID,'DC',ADMIT_PRACTITIONER_ID,'OP',ATTEND_PRACTITIONER_ID,'EM',ATTEND_PRACTITIONER_ID)) and language_id = 'en') as Practitioner, "+
			  "(select short_desc from am_speciality_lang_vw where language_id='en' AND NVL(EFF_STATUS,'D') = 'E' and speciality_code = a.SPECIALTY_CODE)  as SPECIALTY, "+
			  "DECODE(PATIENT_CLASS,'IP','I','DC','D','OP','O','EM','E') EPISODE_TYPE, "+
			  "a.EPISODE_ID, "+
			  "a.OP_EPISODE_VISIT_NUM VisitID, "+
			  "a.SPECIALTY_CODE, "+
			  "DECODE(PATIENT_CLASS,'IP',ADMIT_PRACTITIONER_ID,'DC',ADMIT_PRACTITIONER_ID,'OP',ATTEND_PRACTITIONER_ID,'EM',ATTEND_PRACTITIONER_ID) PRACTITIONER_ID, "+
			  "CUST_GROUP_CODE, "+
			  "CUST_CODE, "+
			  "POLICY_TYPE_CODE, "+
			  "c.BLNG_GRP_ID "+
			  "FROM PR_ENCOUNTER a, MP_PATIENT_MAST b, BL_PRV_ENC_SELECT_INS_BG_VW c "+
			  "WHERE TRUNC(VISIT_ADM_DATE_TIME) BETWEEN to_date(?,'DD/MM/YYYY') AND to_date(?,'DD/MM/YYYY') "+
			  "AND FACILITY_ID = NVL(?,FACILITY_ID) "+
			  "AND a.PATIENT_ID = NVL(?,a.PATIENT_ID) "+
			  "AND ENCOUNTER_ID = NVL(?,ENCOUNTER_ID) "+
			  "AND SPECIALTY_CODE = NVL(?,SPECIALTY_CODE)  "+
			  "AND a.patient_id = b.patient_id "+
			  "AND a.PATIENT_CLASS = DECODE(NVL(?,a.PATIENT_CLASS),'I','IP','D','DC','O','OP','E','EM',a.PATIENT_CLASS) "+
			  "AND a.patient_id = c.patient_id "+
			  "AND a.episode_id = c.episode_id "+
			  "AND c.priority = 1 "+
			  "AND ((a.PATIENT_CLASS IN ('OP','EM') and a.OP_EPISODE_VISIT_NUM = c.visit_id) OR a.PATIENT_CLASS IN ('IP','DC')) "+
			  "AND C.BLNG_GRP_ID = NVL(?,c.BLNG_GRP_ID) ";
			  
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + " and a.CUST_GROUP_CODE = nvl(?,a.CUST_GROUP_CODE) ";
		}
		
		if(!"".equals(qry_payer_code)){
			sql = sql + " and a.CUST_CODE = nvl(?,a.CUST_CODE) ";
		}
		
		if(!"".equals(qry_policy_type_code)){
			sql = sql + " and a.policy_type_code = nvl(?,a.policy_type_code) ";
		}
				
				
		System.err.println("sql to load data :"+sql);
		
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(column_count, qry_enc_frm_date);				
		pstmt.setString(++column_count, qry_enc_to_date);		
		pstmt.setString(++column_count, facilityId);
		pstmt.setString(++column_count,qry_patient_id);							
		pstmt.setString(++column_count,qry_encounter_id);						
		pstmt.setString(++column_count, qry_spec_nursing_unit_code);					
		pstmt.setString(++column_count, qry_episode_type);
		pstmt.setString(++column_count, qry_billingGrpCode);
		
		System.err.println("sql to load data column_count:"+column_count);
		if(!"".equals(qry_payer_grp_code))
			pstmt.setString(++column_count,qry_payer_grp_code);			
		
		if(!"".equals(qry_payer_code))
			pstmt.setString(++column_count, qry_payer_code);
		
		if(!"".equals(qry_policy_type_code))
			pstmt.setString(++column_count, qry_policy_type_code);	


		System.err.println("sql to load data column_count:"+column_count);
				
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			String patient_id = checkForNull(rst.getString("PATIENT_ID"));
			String patient_name = checkForNull(rst.getString("patient_name"));
			String encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
			String pat_class = checkForNull(rst.getString("PATIENT_CLASS"));
			String episode_type = checkForNull(rst.getString("EPISODE_TYPE"));
			String payer_code = checkForNull(rst.getString("CUST_CODE"));
			String payer_desc = checkForNull(rst.getString("Payer"));
			String policy_no = checkForNull(rst.getString("PolicyNumber"));
			String visit_date = checkForNull(rst.getString("VISIT_ADMN_DATE_TIME"));
			String physician_id = checkForNull(rst.getString("PRACTITIONER_ID"));
			String physician_name = checkForNull(rst.getString("Practitioner"));
			String speciality_code = checkForNull(rst.getString("SPECIALTY_CODE"));
			String specialty_desc = checkForNull(rst.getString("SPECIALTY"));
			String payer_group_code = checkForNull(rst.getString("CUST_GROUP_CODE"));
			String policy_type_code = checkForNull(rst.getString("POLICY_TYPE_CODE"));
			String blng_grp_id = checkForNull(rst.getString("BLNG_GRP_ID"));
						
 			row_count++;

%>
	
<%
		if(row_count == 1)
		{
%>			
<thead>
	<tr><td class="COLUMNHEADER" align='left' colspan="9">Patient Data</td></tr>
	<tr>
		<td class='COLUMNHEADER' nowrap width = "2%"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.VISIT_ADMN_DATE_TIME.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	</tr>
</thead>
<tbody id="BLFutOrdInsApprTrackEncTable" name="BLFutOrdInsApprTrackEncTable">
<%
		}
%>		

	<tr id='row<%=row_count%>' >
		<td class="field">
			&nbsp;<label name='srl_no_<%=row_count%>' id='srl_no_<%=row_count%>'><%=row_count%></label>
		</td>
		
		<td class="field" nowrap>
        	<a href="#" name="patient_name_<%=row_count%>" id="patient_name_<%=row_count%>" onclick="callDemographic(this)" style="text-decoration: underline;" ><%=patient_name%></a>
        	<input type="hidden" name = "patient_id_<%=row_count%>" id = "patient_id_<%=row_count%>" value="<%=patient_id%>" />
         </td>
		 
		 <td class="field" nowrap>
         	&nbsp;<a href="#" name="encounter_id_<%=row_count%>" id="encounter_id_<%=row_count%>" onclick="placeFutureOrder(this)" style="text-decoration: underline;" ><%=encounter_id%></a>
         		  <input type="button" name="search_btn" id="search_btn" id="search_btn" value="D" class="button" onClick="changeFieldColor(<%=row_count%>); displayServiceData(this);" />
         		  <input type="hidden" 	id="rowbgColorYN_<%=row_count%>" name="rowbgColorYN_<%=row_count%>"  value="" />
         </td>
		 <td class="field" nowrap>
          	&nbsp;<label name="patient_class_<%=row_count%>" id="patient_class_<%=row_count%>"><%=pat_class%></label>
          	<input type="hidden" id="episode_type_<%=row_count%>" name="episode_type_<%=row_count%>"	value="<%=episode_type%>">
         </td>
		<td class="field" nowrap>
         	&nbsp;<label name="payer_<%=row_count%>" id="payer_<%=row_count%>"><%=payer_desc%></label>
			<input type="hidden" id="payer_code_<%=row_count%>" name="payer_code_<%=row_count%>" value="<%=payer_code%>">
			<input type="hidden" id="payer_grp_code_<%=row_count%>" name="payer_grp_code_<%=row_count%>"	value="<%=payer_group_code%>">
			<input type="hidden" id="blng_grp_id_<%=row_count%>" name="blng_grp_id_<%=row_count%>"	value="<%=blng_grp_id%>">	
         </td>
		 
		 <td class="field" nowrap>
         	&nbsp;<label name="policy_<%=row_count%>" id="policy_<%=row_count%>"><%=policy_no%></label>
         	 <input type="hidden" name = "policy_type_code_<%=row_count%>" id = "policy_type_code_<%=row_count%>" value="<%=policy_type_code%>" />
         </td>
		 
		 <td class="field" nowrap>
             <label name="visit_adm_date_<%=row_count%>" id="visit_adm_date_<%=row_count%>"><%=visit_date%></label>
         </td>
		 
         <td class="field" nowrap>
         	&nbsp;<label name="physician_name_<%=row_count%>" id="physician_name_<%=row_count%>"><%=physician_name%></label>
         	<input type="hidden" id="physician_id_<%=row_count%>" name="physician_id_<%=row_count%>" value="<%=physician_id%>">
         </td>
		 
		 <td class="field" nowrap>
         	&nbsp;<label name="speciality_<%=row_count%>" id="speciality_<%=row_count%>"><%=specialty_desc%></label>
         	<input type="hidden" id="speciality_code_<%=row_count%>" name="speciality_code_<%=row_count%>" value="<%=speciality_code%>">
         </td>
		 	
	</tr>	
<%
		}
%>		

	</tbody>

<%					
		
		if(row_count == 0){
%>	
<Script>
//document.getElementById("patient_sec").style.display = "none";
alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
<%
		}
%>
	
	</tbody>
	<input type='hidden' name='prevClicked' id='prevClicked' value="" />
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type="hidden" name="rowCount" id="rowCount" id="rowCount" value="<%=row_count%>"/> 
	<input type="hidden" id="p_action_id" name="p_action_id" id="p_action_id"	value=""/>	
	<input type="hidden" id="prevActionID" name="prevActionID" id="prevActionID"	value="<%=prevActionID%>"/>
	<input type="hidden" id="prevEncounterId" name="prevEncounterId" id="prevEncounterId"	value="<%=prevEncounterId%>">
	
	<input type="hidden" id="p_serv_grp_code" name="p_serv_grp_code" id="p_serv_grp_code"	value="<%=qry_serviceGroupCode%>">
	<input type="hidden" id="p_serv_class_code" name="p_serv_class_code" id="p_serv_class_code"	value="<%=qry_serviceClassificationCode%>">
	<input type="hidden" id="p_order_line_status" name="p_order_line_status" id="p_order_line_status"	value="<%=qry_order_status%>">
	<input type="hidden" id="p_coding_status" name="p_coding_status" id="p_coding_status"	value="<%=qry_coding_status%>">
	<input type="hidden" id="p_ins_status" name="p_ins_status" id="p_ins_status"	value="<%=qry_insurance_Status%>">
	<input type="hidden" id="p_enc_frm_date" name="p_enc_frm_date" id="p_enc_frm_date"	value="<%=qry_enc_frm_date%>">
	<input type="hidden" id="p_enc_to_date" name="p_enc_to_date" id="p_enc_to_date"	value="<%=qry_enc_to_date%>">
</table>	
</div>	
<%
	}catch(Exception e){
		out.println("Exception in BLFutOrdInsApprTrackEncounterFrame.jsp: "+e);
		System.err.println("Exception in BLFutOrdInsApprTrackEncounterFrame.jsp: "+e);
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 
%>
</form>
</body>
<script type="text/javascript"> 
		//var prevEncounterId = document.forms[0].prevEncounterId.value;
		 
		var prevEncounterId = document.getElementById('prevEncounterId').value;
		if(prevEncounterId != ""){
			reloadResultFrame(prevEncounterId); 
		}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>

