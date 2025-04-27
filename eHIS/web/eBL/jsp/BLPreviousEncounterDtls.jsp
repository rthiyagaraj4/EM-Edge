<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"  %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null; 
	ResultSet rsdt=null;ResultSet rs1=null;ResultSet rs2=null;ResultSet rs3=null;
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	//CurrencyFormat cf = new CurrencyFormat();
	String classval="";		
	String strEpisodeType="";String strPatientId="";String strEncounterDate="";
	String strFacilityId="";String sqlPrevEnctr="";
	String strEpisodeId="";String strVisitId="";String strEncRegnDateTime="";String strBlngGrpId="";String strStlmtInd="";String strCustcode="";String strPriority="";String strPolicyTypeCode="";String strPolicyNum="";String strPolicyStartDate="";String strPolicyExpiryDate="";String strCreditAuthRef="";String strCreditAuthDate="";String strEffectiveFrom="";String strEffectiveTo="";
	String strAppAmt="";String strAppDays="";String strAdjRuleInd="";String strAdjPercAmtInd="";String strAdjPercAmtValue="";String strPmntDiffAdjInt="";String strDrgPmntDiffAdjInt="";String strSplServPmntDiffInt="";String currEpiId="";
	//	String currVstId="";
	String prevEpiId="",system_date="",query_string="",calling_module_id="",str_epi_type="";
	String strModifiedDate="", strPatRegnDateTime = "";
	//prevVstId="",system_date="",query_string="",calling_module_id="",str_epi_type="";
	String strPolicyDesc="",strCustDesc="",strBlngDesc;
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		strFacilityId=request.getParameter("facility_id");
		if(strFacilityId==null || strFacilityId.equals("")) strFacilityId="";
		strPatientId = request.getParameter("patient_id");
		if(strPatientId==null) strPatientId="";	
		strEpisodeType = request.getParameter("episode_type");
		if(strEpisodeType==null) strEpisodeType="";	

		calling_module_id=request.getParameter("calling_module_id");
		if(calling_module_id==null) calling_module_id="";	

		query_string=request.getQueryString();
		if(query_string==null) query_string="";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rsdt = stmt.executeQuery(query_date) ;
			if( rsdt != null ) 
			{
				while( rsdt.next() )
				{  
					system_date = rsdt.getString(1);
				}
			}
			stmt.close();
			rsdt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
		}
		
//		System.out.println("system_date :"+system_date);
		strEncounterDate=request.getParameter("encounter_date");
		if(strEncounterDate==null || strEncounterDate.equals("")) strEncounterDate=system_date;
%>
<script>
/*
	function callPrevEnctr(strFacilityId,strPatientId,strEpisodeType,strEpisodeId,strVisitId)
	{		
		var calling_module_id=document.forms[0].calling_module_id.value;
		var query_string=document.forms[0].query_string.value;	parent.frames[2].location.href='../../eBL/jsp/BLFinDetHiddenFlds.jsp?selected_from_prev_enc_YN=Y&strFacilityId='+strFacilityId+'&patient_id='+strPatientId+"&calling_module="+calling_module_id+'&episode_type='+strEpisodeType+'&episode_id='+strEpisodeId+'&visit_id='+strVisitId+'&query_string='+query_string;
	}
*/
</script>

<html>
<head>
<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>	
			<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
			<script language="javascript" src="../../eBL/js/BLPrevEncounterDtls.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
			
			<style>
				thead td, thead td.locked	{
				background-color: navy;
				color: white;
				position:relative;}	
				thead td {
				top: expression(document.getElementById("tbl-container").scrollTop-5); 
				z-index: 20;}
				thead td.locked {z-index: 30;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
			</style>
</head>

<body onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
		try
		{
/*			if(strEpisodeType.equals("O") || strEpisodeType.equals("E"))
			{
				sqlPrevEnctr="Select a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1 from BL_ENCOUNTER_PAYER_PRIORITY a, bl_visit_fin_dtls  b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and   a.EPISODE_TYPE= b.episode_type and   a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and   a.episode_id= b.episode_id and   a.visit_id= b.visit_id and   a.EPISODE_TYPE = '"+strEpisodeType+"' and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and   a.patient_id= '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS') order by ENC_REGN_DATE_TIME desc";
			
				System.out.println("sqlPrevEnctr ID: "+sqlPrevEnctr);
			}
			else if(strEpisodeType.equals("I") || strEpisodeType.equals("D"))
			{
				sqlPrevEnctr="Select a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1 from BL_ENCOUNTER_PAYER_PRIORITY a,bl_episode_fin_dtls b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and a.EPISODE_TYPE = b.episode_type and a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.episode_id= b.episode_id and   a.EPISODE_TYPE = '"+strEpisodeType+"'  and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and a.patient_id = '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS')  order by ENC_REGN_DATE_TIME desc";

				System.out.println("sqlPrevEnctrEO: "+sqlPrevEnctr);
			} 
*/
			sqlPrevEnctr="Select a.ACCT_SEQ_NO ACCT_SEQ_NO1,a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1,b.episode_type episode_type,ENC_REGN_DATE_TIME from BL_ENCOUNTER_PAYER_PRIORITY a, bl_visit_fin_dtls  b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and   a.EPISODE_TYPE= b.episode_type and   a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and   a.episode_id= b.episode_id and   a.visit_id= b.visit_id and   a.EPISODE_TYPE in ('E','O') and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and   a.patient_id= '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS') union Select a.ACCT_SEQ_NO ACCT_SEQ_NO1,a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1, b.episode_type episode_type,ENC_REGN_DATE_TIME from BL_ENCOUNTER_PAYER_PRIORITY a,bl_episode_fin_dtls b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and a.EPISODE_TYPE = b.episode_type and a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.episode_id= b.episode_id and   a.EPISODE_TYPE in ('I','D')  and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and a.patient_id = '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS')order by ENC_REGN_DATE_TIME desc,EPISODE_ID1,VISIT_ID1,PRIORITY1";

//			System.out.println("sqlPrevEnctr: "+sqlPrevEnctr);
					
			HashMap sqlMap = new HashMap();						
			sqlMap.put("sqlData",sqlPrevEnctr);						
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("EPISODE_ID1");
			displayFields.add("VISIT_ID1");
			displayFields.add("ENC_REGN_DATE_TIME1");
			displayFields.add("BLNG_GRP_ID1");
			displayFields.add("SETTLEMENT_IND1");
			displayFields.add("CUST_CODE1");
			displayFields.add("PRIORITY1");
			displayFields.add("POLICY_TYPE_CODE1");
			displayFields.add("POLICY_NUMBER1");
			displayFields.add("POLICY_START_DATE1");
			displayFields.add("POLICY_EXPIRY_DATE1");
			displayFields.add("CREDIT_AUTH_REF1");
			displayFields.add("CREDIT_AUTH_DATE1");
			displayFields.add("EFFECTIVE_FROM1");
			displayFields.add("EFFECTIVE_TO1");
			displayFields.add("APPROVED_AMT1");
			displayFields.add("APPROVED_DAYS1");
			displayFields.add("ADJ_RULE_IND1");
			displayFields.add("ADJ_PERC_AMT_IND1");
			displayFields.add("ADJ_PERC_AMT_VALUE1");
			displayFields.add("PMNT_DIFF_ADJ_INT1");
			displayFields.add("DRG_PMNT_DIFF_ADJ_INT1");
			displayFields.add("SPL_SRV_PMNT_DIFF_ADJ_INT1");
			displayFields.add("episode_type");
			displayFields.add("ACCT_SEQ_NO1");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("resutl==>"+result);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
%>
<form name='prev_enctr_dtls' id='prev_enctr_dtls' method='post' >			
<div>
	<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
			<td width="80%" class='label'>&nbsp;</td>		
			<td width="20%" class='label'>&nbsp;
<%		// For display the previous/next link
			out.println(result.get(1));		
%>			</td></tr>
	</table>
</div>
		<div id="tbl-container" STYLE="overflow: auto; min-height: 165px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3'  align = 'center' id='enctr_fin_det' width='100%'>			
				<thead>
					<tr>
						<td class='COLUMNHEADER' colspan=10 align='left'><fmt:message key="eBL.ENCOUNTER_FIN_DTLS.label" bundle="${bl_labels}"/></td>
					</tr>
					<tr>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='2%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>		
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
					</tr>
				</thead>
<%					//int i=0;
			int rowflag=0;
			String rec_chk_flag="N";
			ArrayList records=new ArrayList();
			System.out.println("Result Size:"+result);
			for(int j=2; j<result.size(); j++)
			{					
						
				/*if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}*/

				records=(ArrayList) result.get(j);							
				strEpisodeId=(String)records.get(0);						
				if ( strEpisodeId== null || strEpisodeId.equalsIgnoreCase("null")){
					strEpisodeId="";}						
				strVisitId=(String)records.get(1);
				if ( strVisitId== null || strVisitId.equalsIgnoreCase("null")){
					strVisitId="";}
				if(j==2)
				{
					rec_chk_flag="Y";
					prevEpiId=strEpisodeId+strVisitId;
					rowflag=0;
					classval	=	"QRYODD";
//							prevVstId=strVisitId;
				}

				strEncRegnDateTime=(String)records.get(2);						
				if ( strEncRegnDateTime== null || strEncRegnDateTime.equalsIgnoreCase("null")){
					strEncRegnDateTime="";}						
				strBlngGrpId=(String)records.get(3);
				if ( strBlngGrpId== null || strBlngGrpId.equalsIgnoreCase("null")){
					strBlngGrpId="";}
				strStlmtInd=(String)records.get(4);						
				if ( strStlmtInd== null || strStlmtInd.equalsIgnoreCase("null")){
					strStlmtInd="";}			
				strCustcode=(String)records.get(5);
				if ( strCustcode== null || strCustcode.equalsIgnoreCase("null")){
					strCustcode="";}
//					System.out.println("strCustcode :"+strCustcode);
				strPriority=(String)records.get(6);						
				if ( strPriority== null || strPriority.equalsIgnoreCase("null")){
					strPriority="";}
				strPolicyTypeCode=(String)records.get(7);
				if ( strPolicyTypeCode== null || strPolicyTypeCode.equalsIgnoreCase("null")){
					strPolicyTypeCode="";}
//					System.out.println("strPolicyTypeCode :"+strPolicyTypeCode);
				strPolicyNum=(String)records.get(8);
				if ( strPolicyNum== null || strPolicyNum.equalsIgnoreCase("null")){
					strPolicyNum="";}
				strPolicyStartDate=(String)records.get(9);						
				if ( strPolicyStartDate== null || strPolicyStartDate.equalsIgnoreCase("null")){
					strPolicyStartDate="";}						
				strPolicyExpiryDate=(String)records.get(10);
				if ( strPolicyExpiryDate== null || strPolicyExpiryDate.equalsIgnoreCase("null")){
					strPolicyExpiryDate="";}
				strCreditAuthRef=(String)records.get(11);						
				if ( strCreditAuthRef== null || strCreditAuthRef.equalsIgnoreCase("null")){
					strCreditAuthRef="";}							
				strCreditAuthDate=(String)records.get(12);
				if ( strCreditAuthDate== null || strCreditAuthDate.equalsIgnoreCase("null")){
					strCreditAuthDate="";}
				strEffectiveFrom=(String)records.get(13);						
				if ( strEffectiveFrom== null || strEffectiveFrom.equalsIgnoreCase("null")){
					strEffectiveFrom="";}							
				strEffectiveTo=(String)records.get(14);
				if ( strEffectiveTo== null || strEffectiveTo.equalsIgnoreCase("null")){
					strEffectiveTo="";}
				strAppAmt=(String)records.get(15);						
				if ( strAppAmt== null || strAppAmt.equalsIgnoreCase("null")){
					strAppAmt="";}
				strAppDays=(String)records.get(16);
				if ( strAppDays== null || strAppDays.equalsIgnoreCase("null")){
					strAppDays="";}
				strAdjRuleInd=(String)records.get(17);
				if ( strAdjRuleInd== null || strAdjRuleInd.equalsIgnoreCase("null")){
				strAdjRuleInd="";}
				strAdjPercAmtInd=(String)records.get(18);
				if ( strAdjPercAmtInd== null || strAdjPercAmtInd.equalsIgnoreCase("null")){
					strAdjPercAmtInd="";}
				strAdjPercAmtValue=(String)records.get(19);						
				if ( strAdjPercAmtValue== null || strAdjPercAmtValue.equalsIgnoreCase("null")){
						strAdjPercAmtValue="";}								
				strPmntDiffAdjInt=(String)records.get(20);
				if ( strPmntDiffAdjInt== null || strPmntDiffAdjInt.equalsIgnoreCase("null")){
					strPmntDiffAdjInt="";}						
				strDrgPmntDiffAdjInt=(String)records.get(21);
				if ( strDrgPmntDiffAdjInt== null || strDrgPmntDiffAdjInt.equalsIgnoreCase("null")){
					strDrgPmntDiffAdjInt="";}
				strSplServPmntDiffInt=(String)records.get(22);
				if ( strSplServPmntDiffInt== null || strSplServPmntDiffInt.equalsIgnoreCase("null")){
					strSplServPmntDiffInt="";}
					currEpiId=strEpisodeId+strVisitId;

					strEpisodeType=(String)records.get(23);
				if ( strEpisodeType== null || strEpisodeType.equalsIgnoreCase("null")){
					strEpisodeType="";}

							
				if(strEpisodeType.equals("I")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");}
				if(strEpisodeType.equals("O")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");}
				if(strEpisodeType.equals("D")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");}
				if(strEpisodeType.equals("E")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");}	
					
					
			String	acctSeqNo=(String)records.get(24);
			if ( acctSeqNo== null || acctSeqNo.equalsIgnoreCase("null")){
				acctSeqNo="";}
			System.out.println("ACCT_SEQ_NO"+acctSeqNo);

				String sqlCustDesc="Select long_name from ar_customer_lang_vw where cust_code ='"+strCustcode+"' and language_id ='"+locale+"' and acc_entity_code =( Select acc_entity_code from sy_acc_entity where acc_entity_id = '"+strFacilityId+"')";
			

//				System.out.println("sqlCustDesc :"+sqlCustDesc);

				pstmt = con.prepareStatement(sqlCustDesc);
				strCustDesc="";
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					strCustDesc  =  rs1.getString(1);
					if ( strCustDesc== null || strCustDesc.equalsIgnoreCase("null")){
						strCustDesc="";}								
				}				
						rs1.close();
						pstmt.close();


				strPolicyDesc="";
				String sqlPolDesc="Select long_desc from bl_ins_policy_types_lang_vw where policy_type_code = '"+strPolicyTypeCode+"' and language_id = '"+locale+"' and Operating_facility_id = '"+strFacilityId+"' ";
//				System.out.println("sqlPolDesc :"+sqlPolDesc);
				pstmt = con.prepareStatement(sqlPolDesc);
				
				rs2 = pstmt.executeQuery();	
				while(rs2.next())
				{
					strPolicyDesc  =  rs2.getString(1);	
					if ( strPolicyDesc== null || strPolicyDesc.equalsIgnoreCase("null")){
						strPolicyDesc="";}								
				}				
						rs2.close();
						pstmt.close();

				strBlngDesc="";
				String sqlBlngDesc="select SHORT_DESC from BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID ='"+strBlngGrpId+"' and language_id='"+locale+"' ";
//				System.out.println("sqlBlngDesc :"+sqlBlngDesc);
				pstmt = con.prepareStatement(sqlBlngDesc);						
				rs3 = pstmt.executeQuery();	
				while(rs3.next())
				{
					strBlngDesc  =  rs3.getString(1);	
					if ( strBlngDesc== null || strBlngDesc.equalsIgnoreCase("null")){
						strBlngDesc="";}								
				}				
						rs3.close();
						pstmt.close();


//							currVstId=strVisitId;
				strEncRegnDateTime = com.ehis.util.DateUtils.convertDate(strEncRegnDateTime,"DMYHMS","en",locale);
				strEffectiveFrom = com.ehis.util.DateUtils.convertDate(strEffectiveFrom,"DMY","en",locale);
				strEffectiveTo = com.ehis.util.DateUtils.convertDate(strEffectiveTo,"DMY","en",locale);
%>		
				<tbody>
<%	
				if(!currEpiId.equals(prevEpiId))
				{
					rec_chk_flag="Y";
					if(rowflag==0)	rowflag=1;
					else			rowflag=0;

					if(j==2) rowflag=0;
					classval	=	"QRYODD";
//					if(rowflag==0)	classval	=	"QRYODD";
//					else			classval	=	"QRYEVEN";
							
%>

					<tr>
					   <td class='QRYEVEN' colspan='10'>&nbsp;</td>								
					</tr>							

<%														
				}
				if(strCustcode.equals("")) strCustcode="&nbsp;";
				if(strPriority.equals("")) strPriority="&nbsp;";
				if(strPolicyTypeCode.equals("")) strPolicyTypeCode="&nbsp;";
				if(strPolicyNum.equals("")) strPolicyNum="&nbsp;";
				if(strEffectiveFrom.equals("")) strEffectiveFrom="&nbsp;";
				if(strEffectiveTo.equals("")) strEffectiveTo="&nbsp;";
				if(strCustDesc.equals("")) strCustDesc="&nbsp;";
				if(strPolicyDesc.equals("")) strPolicyDesc="&nbsp;";
				if(strBlngDesc.equals("")) strBlngDesc="&nbsp;";

%>
				<tr style='background-color:white'>			
<%
				if(rec_chk_flag.equals("Y"))
				{
%>
					<td class=<%=classval%> width='10%'><%=str_epi_type%></td>	 
					<td class=<%=classval%> width='15%'><a name='' href="#" onClick="callPrevEnctrPlcyActSeq('<%=(strPolicyNum.equals("&nbsp;")?"":strPolicyNum)%>','<%=acctSeqNo%>','<%=strFacilityId%>','<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncRegnDateTime%>','E')"><%=strEncRegnDateTime%></a></td>	 
<%

					if(strVisitId!=null && !strVisitId.equals(""))
					{
%>
						<td class=<%=classval%> width='10%'><%=strEpisodeId%> / <%=strVisitId%></td>	 
<%
					}
					else
					{
%>
						<td class=<%=classval%> width='10%'><%=strEpisodeId%></td>	 
<%
					}
				}
				else
				{
%>
					<td class=<%=classval%> width='10%'>&nbsp;</td>
					<td class=<%=classval%> width='15%'>&nbsp;</td>
					<td class=<%=classval%> width='10%'>&nbsp;</td>
<%
				}
%>
					<td class=<%=classval%> width="12%" ><%=strBlngDesc%></td>
					<td class=<%=classval%> width='14%'><%=strCustDesc%></td>	 
					<td class=<%=classval%> width="2%" style='text-align:right'><%=strPriority%></td>
					<td class=<%=classval%> width="17%"><%=strPolicyDesc%></td>		
					<td class=<%=classval%> width="10%"><%=strPolicyNum%></td>					
					<td class=<%=classval%> width="10%"><%=strEffectiveFrom%></td> 			
					<td class=<%=classval%> width="10%"><%=strEffectiveTo%></td>			
				</tr>
				</tbody>
<%				//i++;			
 				prevEpiId = currEpiId;
				rec_chk_flag="N";
//				prevVstId = currVstId;

			}//while
			out.flush();
			}
%>
			</table>
			</div>
			<input type='hidden' name='calling_module_id' id='calling_module_id' value='<%=calling_module_id%>'>
			<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>	
			</form>
<%
		}
		catch(Exception ee)
		{
			System.out.println("Exception in qry" +ee); 
		}
	}
	catch(Exception eee)
	{
		System.out.println("Exception main"+ eee);
	}
	finally 
	{				
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLPreviousEncounterDtls.jsp",searched));%>
</body>
</html>

