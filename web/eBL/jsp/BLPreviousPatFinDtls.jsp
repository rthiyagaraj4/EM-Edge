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
	String classval="QRYODD";		
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
				top: expression(document.getElementById("tbl-container").scrollTop-2); 
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
<form name='pat_fin_dtls' id='pat_fin_dtls' method='post' >
<%
		try
		{
			sqlPrevEnctr="Select 'R' EPISODE_TYPE, to_char(c.REGN_DATE,'DD/MM/YYYY HH24:MI:SS') REGN_DATE, a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1, to_char(a.MODIFIED_DATE,'dd/mm/yyyy HH24:MI:SS') MODIFIED_DATE from BL_ENCOUNTER_PAYER_PRIORITY a, bl_patient_fin_dtls b, mp_patient c where a.patient_id=b.patient_id and b.patient_id=c.patient_id and a.ACCT_SEQ_NO= b.cur_acct_seq_no and a.patient_id= '"+strPatientId+"' and to_date(c.REGN_DATE,'dd/mm/yyyy HH24:MI:SS') < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS') and a.episode_type='R'  order by nvl(a.priority,9999)";

	//		System.out.println("sqlPrevEnctr: "+sqlPrevEnctr);
					
			HashMap sqlMap = new HashMap();						
			sqlMap.put("sqlData",sqlPrevEnctr);						
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("EPISODE_TYPE");
			displayFields.add("REGN_DATE");
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
			displayFields.add("MODIFIED_DATE");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
//			System.out.println("resutl==>"+result);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
%>
			<div id="tbl-container" style="overflow: auto;min-height: 165px;padding:3px;margin: 0px">
			<table border='1' cellpadding='3'  align = 'center' id='pat_fin_det' width='100%'>			
				<thead>
					<tr>
						<td class='COLUMNHEADER' colspan=9 align='left'><fmt:message key="eBL.PATIENT_FIN_DTLS.label" bundle="${bl_labels}"/></td>
					</tr>
					<tr>
						<td class='COLUMNHEADER' ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="eBL.LAST_MOD_DATE_TIME.label" bundle="${bl_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
						<td class='COLUMNHEADER' ><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>		
						<td class='COLUMNHEADER' ><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
					</tr>
				</thead>
<%
				int rowflag=0;
				int data_count = 0;
				String rec_chk_flag="Y";
				ArrayList records=new ArrayList();
//				System.out.println("Result Size:"+result.size());
				for(int j=2; j<result.size(); j++)
				{		
					records=(ArrayList) result.get(j);							
					strEpisodeType=(String)records.get(0);						
					if ( strEpisodeType == null) strEpisodeType="";

					strPatRegnDateTime=(String)records.get(1);
					if ( strPatRegnDateTime == null) strPatRegnDateTime="";

					strBlngGrpId=(String)records.get(2);
					if ( strBlngGrpId == null) strBlngGrpId="";

					strStlmtInd=(String)records.get(3);						
					if ( strStlmtInd == null) strStlmtInd="";

					strCustcode=(String)records.get(4);
					if ( strCustcode == null) strCustcode="";

					strPriority=(String)records.get(5);						
					if ( strPriority == null) strPriority="";

					strPolicyTypeCode=(String)records.get(6);
					if ( strPolicyTypeCode == null) strPolicyTypeCode="";

					strPolicyNum=(String)records.get(7);
					if ( strPolicyNum == null) strPolicyNum="";

					strPolicyStartDate=(String)records.get(8);						
					if ( strPolicyStartDate == null) strPolicyStartDate="";

					strPolicyExpiryDate=(String)records.get(9);
					if ( strPolicyExpiryDate == null) strPolicyExpiryDate="";

					strCreditAuthRef=(String)records.get(10);						
					if ( strCreditAuthRef == null) strCreditAuthRef="";

					strCreditAuthDate=(String)records.get(11);
					if ( strCreditAuthDate == null) strCreditAuthDate="";

					strEffectiveFrom=(String)records.get(12);						
					if ( strEffectiveFrom == null) strEffectiveFrom="";

					strEffectiveTo=(String)records.get(13);
					if ( strEffectiveTo == null) strEffectiveTo="";

					strAppAmt=(String)records.get(14);						
					if ( strAppAmt == null) strAppAmt="";

					strAppDays=(String)records.get(15);
					if ( strAppDays == null) strAppDays="";

					strAdjRuleInd=(String)records.get(16);
					if ( strAdjRuleInd == null) strAdjRuleInd="";

					strAdjPercAmtInd=(String)records.get(17);
					if ( strAdjPercAmtInd == null) strAdjPercAmtInd="";

					strAdjPercAmtValue=(String)records.get(18);						
					if ( strAdjPercAmtValue == null) strAdjPercAmtValue="";

					strPmntDiffAdjInt=(String)records.get(19);
					if ( strPmntDiffAdjInt == null) strPmntDiffAdjInt="";

					strDrgPmntDiffAdjInt=(String)records.get(20);
					if ( strDrgPmntDiffAdjInt == null) strDrgPmntDiffAdjInt="";

					strSplServPmntDiffInt=(String)records.get(21);
					if ( strSplServPmntDiffInt == null) strSplServPmntDiffInt="";

					strModifiedDate =(String)records.get(22);
					if ( strModifiedDate == null) strModifiedDate="";
								
					if(strEpisodeType.equals("R")){								str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");}

					String sqlCustDesc="Select long_name from ar_customer_lang_vw where cust_code ='"+strCustcode+"' and language_id ='"+locale+"' and acc_entity_code =( Select acc_entity_code from sy_acc_entity where acc_entity_id = '"+strFacilityId+"')";
	
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
//					System.out.println("sqlPolDesc :"+sqlPolDesc);
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
//					System.out.println("sqlBlngDesc :"+sqlBlngDesc);
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

					strPatRegnDateTime = com.ehis.util.DateUtils.convertDate(strPatRegnDateTime,"DMYHMS","en",locale);
					strEffectiveFrom = com.ehis.util.DateUtils.convertDate(strEffectiveFrom,"DMY","en",locale);
					strEffectiveTo = com.ehis.util.DateUtils.convertDate(strEffectiveTo,"DMY","en",locale);		
					
					if(strPriority.equals("")) strPriority="&nbsp;";
					if(strPolicyNum.equals("")) strPolicyNum="&nbsp;";
					if(strEffectiveFrom.equals("")) strEffectiveFrom="&nbsp;";
					if(strEffectiveTo.equals("")) strEffectiveTo="&nbsp;";
					if(strCustDesc.equals("")) strCustDesc="&nbsp;";
					if(strPolicyDesc.equals("")) strPolicyDesc="&nbsp;";
					if(strBlngDesc.equals("")) strBlngDesc="&nbsp;";
%>
				<tbody>
				<tr style='background-color:white'>			
<%
				if(rec_chk_flag.equals("Y"))
				{
%>
					<td class=<%=classval%> ><%=str_epi_type%></td>	 
					<td class=<%=classval%> ><a name='' href="#" onClick="callPrevEnctr('<%=strFacilityId%>','<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strModifiedDate%>','P')"><%=strModifiedDate%></a></td>	 
<%
				}
				else
				{
%>
					<td class=<%=classval%> >&nbsp;</td>
					<td class=<%=classval%> >&nbsp;</td>
<%
				}
%>
					<td class=<%=classval%> ><%=strBlngDesc%></td>
					<td class=<%=classval%> ><%=strCustDesc%></td>	 
					<td class=<%=classval%> style='text-align:right'><%=strPriority%></td>
					<td class=<%=classval%> ><%=strPolicyDesc%></td>		
					<td class=<%=classval%> ><%=strPolicyNum%></td>					
					<td class=<%=classval%> ><%=strEffectiveFrom%></td> 			
					<td class=<%=classval%> ><%=strEffectiveTo%></td>			
				</tr>
				</tbody>
<%
					rec_chk_flag = "N";
%>
					<input type='hidden' name='pat_fin_mod_date_<%=data_count%>' id='pat_fin_mod_date_<%=data_count%>' value='<%=strModifiedDate%>'>
<%
					data_count++;
				}
%>
			</table>
			</div>
<%
			}
		}
		catch(Exception ee)
		{
			System.out.println("Exception in qry" +ee); 
		}
%>
	<input type='hidden' name='calling_module_id' id='calling_module_id' value='<%=calling_module_id%>'>
	<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>	
	</form>
<%
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

