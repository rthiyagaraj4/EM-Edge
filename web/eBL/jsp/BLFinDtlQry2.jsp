<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
/* karthik added the below function to provide the link for RecordApproval for insurance cases - starts*/
async function callRecordApprovalPolicyDetails(patientId,payerGroup,payer,policy,startDate,endDate,visitId,acctSeq,priority,policyNo,episodeType,episodeId){

	var dialogHeight= "70vh" ;
	var dialogWidth	= "80vw" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;	
	
	/*var queryParams='mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+
	'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+
	'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth=N';*/
	
	var queryParams='mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+
	'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&visitId='+visitId+'&acctSeq=&priority='+priority+
	'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth=N';
	
	var retVal = await top.window.showModalDialog('../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?'+queryParams,arguments,features);
}
/* karthik added the below function to provide the link for RecordApproval - ends*/
</script>
<%
	HttpSession httpSession = request.getSession(false);  
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String locale	= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection(request);
	CallableStatement call =null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;ResultSet rs3 = null;

	String facility_id = "";
	String login_user = "";
	String strepisodetype=""; 
	String strepisodeid ="";
	String strvisitid="";
	String strpatientid=""; 
//Unused Var's
/*
	String gross_amt="";
	String serv_disc_amt="";
	String other_disc_amt="";
	String unbilled_amt = "";
	String outst_amt =  "";
	String deposit_amt =  "";
	String prepay_amt =  "";
	String refundable_deposit_amt =  "";
	String surgery_deposit_amt =  "";
	String pkg_deposit_amt =  "";
	String strAllParam = "";
*/
	String strSetInd = "";
	String strAdmFlag = "";
	String strFamIn = "";
	String strFamAss  = "";
	String strNoDep = "";
	String strNonInsBlGrId = "";
	String strNonInsCustCode = "";
	String strGLHol  = "";
	String strPatRel  = "";
	String strBillGrp = "";
	String strPatRelGL = "";
	String strCrdDocRef = "";
	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = "";
	String strResPay  = "";
	String strPatRelnRespPers=""; 	 
	
//	int intNoDep=0;
//	String short_desc="";
//	String customerid="";
//	String customergroup="";
	String blng_grp_id="";
	String blng_grp_desc="";
	String cust_group_code= "";
	String cust_group_desc= "";
    String cust_code ="";
	String customer_name = "";
	String priority = "";
	String policy_type_code = "";
	String policy_type_desc = "";
	String policy_number = "";
	String policy_start_date = "";
	String policy_expiry_date = "";
	String credit_auth_ref = "";
	String credit_auth_date = "";
	String effective_from = "";
	String effective_to = "";
	String approved_amt = "";
	String approved_days = "";
	String adj_rule_ind = "";
	String adj_rule_desc = "";
	String adj_perc_amt_ind = "";
	String adj_perc_amt_ind2 = "";
	String adj_perc_amt_value = "";
	String pmnt_diff_adj_int = "";
	String drg_pmnt_diff_adj_int= "";
	String spl_srv_pmnt_diff_adj_int = "";
	String ins_ref_src_main_code="",ins_ref_src_main_desc="",ins_ref_src_sub_code="",ins_ref_src_sub_desc="";
	String ins_referral_source_code_flag="N";

	String ins_ref_src_main_lng_name="", ins_ref_src_sub_lng_name="";
//	String non_ins_customer_name ="";
//	String strnoninsbillinggroup ="";
//	String strnoninsbillinggroup1 = "";
	String strCurrAcctSeqNo="";
	int noofdecimal = 2;
	String classval="";
	int i=0;
	String desc="", tempDesc="";

	String  strCharge_logic="";
//	String sql1="";
//	String sqlnoncust="";
	String sqlpayerdet="";

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id==null) facility_id="";

		login_user =  p.getProperty("login_user");
		if(login_user==null) login_user="";
		
		strepisodetype = request.getParameter("episodetype");
		if(strepisodetype==null) strepisodetype="";
		
		strepisodeid  = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		
		strpatientid= request.getParameter("patientid");
		if(strpatientid==null) strpatientid="";
		
		strBillGrp =	request.getParameter("strBillGrp");		
		if(strBillGrp==null) strBillGrp="";
		
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		
		strAdmFlag =	request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="0";
		
		strNonInsBlGrId =	request.getParameter("strNonInsBlGrId");	
		if(strNonInsBlGrId==null) strNonInsBlGrId="";
		
		strNonInsCustCode =	request.getParameter("strNonInsCustCode");	
		if(strNonInsCustCode==null) strNonInsCustCode="";
		
		strGLHol =	request.getParameter("strGLHol");
		if(strGLHol==null) strGLHol="";
		
		strPatRel =	request.getParameter("strPatRel");	
		if(strPatRel==null) strPatRel="";
		
		strPatRelGL =	request.getParameter("strPatRelGL");	
		if(strPatRelGL==null) strPatRelGL="";
		
		strCrdDocRef =	request.getParameter("strCrdDocRef");
		if(strCrdDocRef==null) strCrdDocRef="";
		
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null) strCrDocRefStDate="";
		
		strCrDocRefEndDate =	request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null) strCrDocRefEndDate="";
		
		strResPay =	request.getParameter("strResPay");
		if(strResPay==null) strResPay="";
		
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		if(strPatRelnRespPers==null) strPatRelnRespPers="";

		strCurrAcctSeqNo=request.getParameter("strCurrAcctSeqNo");
		if(strCurrAcctSeqNo==null) strCurrAcctSeqNo="";
		
//		intNoDep=Integer.parseInt(strNoDep);		

/*		
		try
		{
			if(!strNonInsBlGrId.equals(""))
			{
				sql1="SELECT short_desc non_ins_billing_group, "+
				" a.settlement_ind non_ins_billing_group1, "+      		
				" b.adm_rec_flag non_ins_adm_rec_flag,	"+
				" FROM bl_blng_grp_lang_vw  "+
				" WHERE blng_grp_id = '"+strNonInsBlGrId+"' "+
				" AND language_id = '"+locale+"' ";

				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					strnoninsbillinggroup = rs.getString(1);
					strnoninsbillinggroup1 = rs.getString(2);
				}
			}//closing if
		}//try
		catch(Exception e)
		{
			System.out.println("Exception in Non ins blng_grp Query:"+e.toString());
		}
*/		
		//to get non ins cust code
/*
		try
		{
			if (!strNonInsCustCode.equals(""))
			{
				sqlnoncust="SELECT short_name non_ins_customer_name "+
					" FROM ar_customer_lang_vw "+
					" WHERE cust_code = '"+strNonInsCustCode+"' "+
					" AND language_id = '"+locale+"' ";
 
				pstmt = con.prepareStatement(sqlnoncust);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					non_ins_customer_name = rs.getString(1);	
				}
			}//closing if
		}//closing try 
		catch(Exception e)
		{
			System.out.println("Exception in non_ins_cust_code query:"+e.toString());
		}
*/
/*
		try
		{
			if (!strNonInsBlGrId.equals(""))
			{
				sqlpayerdet="SELECT a.cust_code cust_code,    "+                                          
				" b.short_name customer_name, "+
				" a.priority priority,          "+                                     
				" a.policy_type_code policy_type_code, "+                                       
				" c.short_desc policy_type_desc, "+
				" a.policy_number policy_number,   "+ 
				" TO_CHAR(a.policy_start_date,'DD/MM/YYYY') policy_start_date , "+ 
				" TO_CHAR(a.policy_expiry_date,'DD/MM/YYYY') policy_expiry_date , "+ 
				" a.credit_auth_ref credit_auth_ref,   "+                               
				" TO_CHAR(a.credit_auth_date,'DD/MM/YYYY') credit_auth_date,  "+  
				" TO_CHAR(a.effective_from,'DD/MM/YYYY') effective_from,     "+     
				" TO_CHAR(a.effective_to,'DD/MM/YYYY') effective_to,         "+    
				" a.approved_amt approved_amt,     "+  
				" a.approved_days approved_days,   "+                      
				" a.adj_rule_ind adj_rule_ind,  "+                   
				" DECODE(a.adj_rule_ind,'A','Automatic','Not Applicable') adj_rule_desc,"+      
			    " a.adj_perc_amt_ind adj_perc_amt_ind,  "+	 
				" DECODE(a.adj_perc_amt_ind,'A','Amount','P','Percentage') adj_perc_amt_ind, "+    
				" a.adj_perc_amt_value adj_perc_amt_value,        "+
				" a.pmnt_diff_adj_int pmnt_diff_adj_int,             "+
				" a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,        "+  
				" a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int  "+   
				" FROM bl_encounter_payer_priority a, "+
				" ar_customer_lang_vw b, "+
				" bl_ins_policy_types_lang_vw c "+
				" WHERE a.operating_facility_id = '"+facility_id+"'  "+
				 " AND a.episode_type = '"+strepisodetype+"'  "+
				 " AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
				 " (a.episode_id = '"+strepisodeid +"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
				" (a.episode_id = '"+strepisodeid +"' AND a.episode_type IN ('I','D'))) "+
				 " AND b.cust_code = a.cust_code "+
				 " AND b.language_id = '"+locale+"' "+
				" AND c.operating_facility_id = a.operating_facility_id "+
				" AND c.policy_type_code = a.policy_type_code "+
				 " AND c.language_id = '"+locale+"' ";
				pstmt = con.prepareStatement(sqlpayerdet);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					cust_code = rs.getString(1);
					customer_name = rs.getString(2);
					priority = rs.getString(3);
					policy_type_code = rs.getString(4);
					policy_type_desc = rs.getString(5);
					policy_number = rs.getString(6);
					policy_start_date = rs.getString(7);
					policy_expiry_date = rs.getString(8);
					credit_auth_ref = rs.getString(9);
					credit_auth_date = rs.getString(10);
					effective_from = rs.getString(11);
					effective_to = rs.getString(12);
					approved_amt = rs.getString(13);
					approved_days = rs.getString(14);
					adj_rule_ind = rs.getString(15);
					adj_rule_desc = rs.getString(16);
					adj_perc_amt_ind = rs.getString(17);
					adj_perc_amt_ind2 = rs.getString(18);	
					adj_perc_amt_value = rs.getString(19);
					pmnt_diff_adj_int = rs.getString(20);
					drg_pmnt_diff_adj_int= rs.getString(21);
					spl_srv_pmnt_diff_adj_int = rs.getString(22);
				}
				if (cust_code == null) cust_code = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_type_code == null) policy_type_code = "";
				if (policy_type_desc == null) policy_type_desc = "";
				if (policy_number == null) policy_number = "";
				if (policy_start_date == null) policy_start_date = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_expiry_date == null) policy_expiry_date = "";
				if (credit_auth_ref == null) credit_auth_ref = "";
				if (credit_auth_date == null) credit_auth_date = "";
				if (effective_from == null) effective_from = "";
				if (effective_to == null) effective_to = "";
				if (priority == null) priority = "";
				if (approved_amt == null) approved_amt = "";
				if (approved_days == null) approved_days = "";
				if (adj_rule_desc == null) adj_rule_desc = "";
				if (adj_perc_amt_ind == null) adj_perc_amt_ind = "";
				if (adj_perc_amt_ind2 == null) adj_perc_amt_ind2 = "";
				if (adj_perc_amt_value == null) adj_perc_amt_value = "";
				if (pmnt_diff_adj_int == null) pmnt_diff_adj_int = "";
				if (drg_pmnt_diff_adj_int == null) drg_pmnt_diff_adj_int = "";
				if (spl_srv_pmnt_diff_adj_int == null) spl_srv_pmnt_diff_adj_int = "";

			}	//closing if
		}	//closing try
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}
*/
		
%>

	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> -->
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<head>
<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#tbl-container {
/* width: 1020px; */
height: 200px;
overflow: auto;
}

thead th, thead th.locked	{
position:relative;
}

thead th {
top: expression(document.getElementById("tbl-container").scrollTop-2); 
z-index: 20;
}

div#tbl-container table#tbl th#payer_id {
width: 28px;
}

div#tbl-container table#tbl th#priority_id {
width: 8px;
}

div#tbl-container table#tbl th#policy_id {
width: 30px;
}

div#tbl-container table#tbl th#pol_no_id {
width: 20px;
}

div#tbl-container table#tbl th#strt_date_id {
width: 8px;
}

div#tbl-container table#tbl th#exp_date_id {
width: 8px;
}

div#tbl-container table#tbl th#cred_auth_id {
width: 30px;
}

div#tbl-container table#tbl th#cred_auth_date_id {
width: 8px;
}

div#tbl-container table#tbl th#appr_amt_id {
width: 10px;
}

div#tbl-container table#tbl th#appr_days_id {
width: 10px;
}

div#tbl-container table#tbl th#eff_frm_id {
width: 8px;
}

div#tbl-container table#tbl th#eff_to_id {
width: 8px;
}
</STYLE>
<SCRIPT>
function displayToolTip(ref_src_main_desc,ref_src_sub_desc)
{		
	buildTable(ref_src_main_desc,ref_src_sub_desc);
	resizeWindow();
}


function buildTable(ref_src_main_desc,ref_src_sub_desc)
{
	var ref_src_main_label='<fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>';
	var ref_src_sub_label='<fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>';

	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='1'   class='columnHeader' width='100%' height='100%' align='center'>"

	tab_dat		+= "<td class='columnHeader' width='50%'>"+ref_src_main_label+"</td>";
	tab_dat		+= "<td class='columnHeader' width='50%'>"+ref_src_sub_label+"</td>";

	tab_dat     += "<tr>";

	//tab_dat     += "<td class='fields' width='20%'>"+strDepAdjust+"</td>";
	tab_dat     += "<td class='fields' width='50%'>"+ref_src_main_desc+"</td>";
	tab_dat     += "<td class='fields' width='50%'>"+ref_src_sub_desc+"</td>";
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
	document.getElementById("t").innerHTML = tab_dat;
}

function resizeWindow()
{
	bodwidth = parent.frames[0].document.body.offsetWidth;
	bodheight = parent.frames[0].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth);
	y = y + (document.getElementById("tooltiplayer").offsetHeight);

	if(x<bodwidth)
	{
		x =event.x;
	}
	else
	{
		x = x - (document.getElementById("tooltiplayer").offsetWidth);
	}

	if(y<bodheight)
	{
		 y =event.y;
	}
	else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight);
	}
	
	y+=document.body.scrollTop;
	x+=document.body.scrollLeft;


	document.getElementById("tooltiplayer").style.posLeft= x+20;
	document.getElementById("tooltiplayer").style.posTop = y-220;
	document.getElementById("tooltiplayer").style.visibility='visible';
}

function hideToolTip()	
{
	  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

	
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form>
<div id='tbl-container'>
<table cellpadding=3 cellspacing=0  width="100%" align='left' id='ins_data' border=1>
<thead>
<tr>
	<th class='COLUMNHEADER' colspan='20' align='left'><fmt:message key="eBL.INS_DTL_DOC_REF.label" bundle="${bl_labels}"/></td>
</tr>

<tr >
<!--
	<td class='COLUMNHEADER' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
-->
	<th class='COLUMNHEADER' id='payer_id'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/> / <fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<th class='COLUMNHEADER' id='priority_id'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<th class='COLUMNHEADER' id='policy_id'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<th class='COLUMNHEADER' id='pol_no_id'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<th class='COLUMNHEADER' id='strt_date_id'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
	<th class='COLUMNHEADER' id='exp_date_id'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
	<th class='COLUMNHEADER' id='cred_auth_id'><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></td>
	<th class='COLUMNHEADER' id='cred_auth_date_id'><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>
	<th class='COLUMNHEADER' id='appr_amt_id'><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/> </td>
	<th class='COLUMNHEADER' id='appr_days_id'><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/> </td>
	<th class='COLUMNHEADER' id='eff_frm_id'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<th class='COLUMNHEADER' id='eff_to_id'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
</tr>
</thead>
<tbody>
<!--</table>
<table cellpadding=3 cellspacing=0  width="100%" align='left' id='ins_data' border=1>-->
<%

		if (!strNonInsBlGrId.equals(""))
		{		
			
			try
			{
			String policyValidQry="select NVL(charge_logic_yn,'N') from bl_parameters  where operating_facility_id ='"+facility_id+"'";

			
				pstmt = con.prepareStatement(policyValidQry);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{
					while(rs.next())
					{
						strCharge_logic=rs.getString(1);					
						
					}
				}
				if(rs != null) rs.close();		if(pstmt != null) pstmt.close();
			}catch(Exception ee)	{}
			
			
			sqlpayerdet="SELECT a.blng_grp_id blng_grp_id,"+
						"d.long_desc long_desc,    "+                                          
						"a.cust_code cust_code,    "+                                          
						" b.short_name customer_name, "+
						" a.priority priority,          "+                                     
						" a.policy_type_code policy_type_code, "+                                       
						" c.short_desc policy_type_desc, "+
						" a.policy_number policy_number,   "+ 
						" TO_CHAR(a.policy_start_date,'DD/MM/YYYY') policy_start_date , "+ 
						" TO_CHAR(a.policy_expiry_date,'DD/MM/YYYY') policy_expiry_date , "+ 
						" a.credit_auth_ref credit_auth_ref,   "+                               
						" TO_CHAR(a.credit_auth_date,'DD/MM/YYYY') credit_auth_date,  "+  
						" TO_CHAR(a.effective_from,'DD/MM/YYYY') effective_from,     "+     
						" TO_CHAR(a.effective_to,'DD/MM/YYYY') effective_to,         "+    
						" a.approved_amt approved_amt,     "+  
						" a.approved_days approved_days,   "+                      
						" a.adj_rule_ind adj_rule_ind,  "+                   
						" DECODE(a.adj_rule_ind,'A','Automatic','Not Applicable') adj_rule_desc,"+      
					    " a.adj_perc_amt_ind adj_perc_amt_ind,  "+	 
						" DECODE(a.adj_perc_amt_ind,'A','Amount','P','Percentage') adj_perc_amt_ind, "+    
						" a.adj_perc_amt_value adj_perc_amt_value,        "+
						" a.pmnt_diff_adj_int pmnt_diff_adj_int,             "+
						" a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,        "+  
						" a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,  "+ 
						" a.referral_source_code_main referral_source_code_main,  "+ 
						" a.referral_source_code_sub referral_source_code_sub,  "+ 
						" a.cust_group_code cust_group_code,  "+ 
						" e.short_desc cust_group_desc "+
						" FROM bl_encounter_payer_priority a, "+
						" ar_customer_lang_vw b, "+
						" bl_ins_policy_types_lang_vw c, "+
						" bl_blng_grp_lang_vw d, "+
						" ar_cust_group_lang_vw e "+
						" WHERE a.operating_facility_id = '"+facility_id+"'  "+
						" AND a.episode_type = '"+strepisodetype+"'  ";
						if(!strpatientid.equals(""))
						{
							sqlpayerdet=sqlpayerdet+" AND a.patient_id = '"+strpatientid+"'";
						}
						sqlpayerdet=sqlpayerdet+" AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
						" (a.episode_id = '"+strepisodeid +"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
						" (a.episode_id = '"+strepisodeid +"' AND a.episode_type IN ('I','D'))) "+
						" AND a.blng_grp_id = d.blng_grp_id "+
						" AND b.cust_code = a.cust_code "+
						" AND a.cust_group_code = e.cust_group_code "+
						" AND b.language_id = '"+locale+"' "+
						" AND a.ACCT_SEQ_NO = '"+strCurrAcctSeqNo+"' "+
						" AND c.operating_facility_id = a.operating_facility_id "+
						" AND c.policy_type_code = a.policy_type_code "+
						" AND c.language_id = '"+locale+"'"+
						" AND d.language_id = '"+locale+"'"+
						" AND e.language_id = '"+locale+"'"+
						" ORDER BY priority ";
			
//			System.out.println("sqlpayerdet;"+sqlpayerdet);
			pstmt = con.prepareStatement(sqlpayerdet);
			rs = pstmt.executeQuery() ;
			
			while(rs.next())
			{
				blng_grp_id=rs.getString(1);
				blng_grp_desc=rs.getString(2);
				cust_code = rs.getString(3);
				customer_name = rs.getString(4);
				priority = rs.getString(5);
				policy_type_code = rs.getString(6);
				policy_type_desc = rs.getString(7);
				policy_number = rs.getString(8);

				policy_start_date = rs.getString(9);
				if(policy_start_date==null) policy_start_date="";
				if(!policy_start_date.equals(""))
					policy_start_date=com.ehis.util.DateUtils.convertDate(policy_start_date,"DMY","en",locale);

				policy_expiry_date = rs.getString(10);
				if(policy_expiry_date==null) policy_expiry_date="";
				if(!policy_expiry_date.equals(""))
					policy_expiry_date=com.ehis.util.DateUtils.convertDate(policy_expiry_date,"DMY","en",locale);

				credit_auth_ref = rs.getString(11);
				
				credit_auth_date = rs.getString(12);
				if(credit_auth_date==null) credit_auth_date="";
				if(!credit_auth_date.equals(""))
					credit_auth_date=com.ehis.util.DateUtils.convertDate(credit_auth_date,"DMY","en",locale);
		
				effective_from = rs.getString(13);
				if(effective_from==null) effective_from="";
				if(!effective_from.equals(""))
					effective_from=com.ehis.util.DateUtils.convertDate(effective_from,"DMY","en",locale);
				
				effective_to = rs.getString(14);
				if(effective_to==null) effective_to="";
				if(!effective_to.equals(""))
					effective_to=com.ehis.util.DateUtils.convertDate(effective_to,"DMY","en",locale);

				approved_amt = rs.getString(15);
				approved_days = rs.getString(16);
				adj_rule_ind = rs.getString(17);
				adj_rule_desc = rs.getString(18);
				adj_perc_amt_ind = rs.getString(19);
				adj_perc_amt_ind2 = rs.getString(20);	
				adj_perc_amt_value = rs.getString(21);
				pmnt_diff_adj_int = rs.getString(22);
				drg_pmnt_diff_adj_int= rs.getString(23);
				spl_srv_pmnt_diff_adj_int = rs.getString(24);

				ins_ref_src_main_code= rs.getString(25);
				ins_ref_src_sub_code= rs.getString(26);

				cust_group_code = rs.getString(27);
				cust_group_desc = rs.getString(28);

				if(blng_grp_id == null) blng_grp_id="";
				if(blng_grp_desc == null) blng_grp_desc="";
				if (cust_code == null) cust_code = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_type_code == null) policy_type_code = "";
				if (policy_type_desc == null) policy_type_desc = "";
				if (policy_number == null) policy_number = "";
				if (policy_start_date == null) policy_start_date = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_expiry_date == null) policy_expiry_date = "";

				if (credit_auth_ref == null || credit_auth_ref.equals("")) credit_auth_ref = "&nbsp;";
				if (credit_auth_date == null || credit_auth_date.equals("")) credit_auth_date = "&nbsp;";
				if (effective_from == null) effective_from = "";
				if (effective_to == null || effective_to.equals("")) effective_to = "&nbsp;";
				if (priority == null) priority = "";
				if (approved_amt == null || approved_amt.equals("")) approved_amt = "&nbsp;";
				if (approved_days == null || approved_days.equals("")) approved_days = "&nbsp;";
				if (adj_rule_desc == null) adj_rule_desc = "";
				if (adj_perc_amt_ind == null) adj_perc_amt_ind = "";
				if (adj_perc_amt_ind2 == null) adj_perc_amt_ind2 = "";
				if (adj_perc_amt_value == null) adj_perc_amt_value = "";
				if (pmnt_diff_adj_int == null) pmnt_diff_adj_int = "";
				if (drg_pmnt_diff_adj_int == null) drg_pmnt_diff_adj_int = "";
				if (spl_srv_pmnt_diff_adj_int == null) spl_srv_pmnt_diff_adj_int = "";
				if (ins_ref_src_main_code == null) ins_ref_src_main_code = "";
				if (ins_ref_src_main_desc == null) ins_ref_src_main_desc = "";
				if (ins_ref_src_sub_code == null) ins_ref_src_sub_code = "";
				if (ins_ref_src_sub_desc == null) ins_ref_src_sub_desc = "";
				if (cust_group_code == null) cust_group_code = "";
				if (cust_group_desc == null) cust_group_desc = "";

				desc = blng_grp_desc;

				if(!ins_ref_src_main_code.equals(""))
				{
					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_main_code);
					call.setString(3,locale);
					call.setString(4,"1");

					call.execute();							
					ins_ref_src_main_desc = call.getString(1);				
					call.close();
					if ( ins_ref_src_main_desc == null ) ins_ref_src_main_desc = "&nbsp;";

					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_main_code);
					call.setString(3,locale);
					call.setString(4,"3");

					call.execute();							
					ins_ref_src_main_lng_name = call.getString(1);				
					call.close();
					if ( ins_ref_src_main_lng_name == null ) ins_ref_src_main_lng_name = "";
				}
				else
				{
					ins_ref_src_main_desc = "&nbsp;";
					ins_ref_src_main_lng_name = "";
				}

				if(!ins_ref_src_sub_code.equals(""))
				{
					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_sub_code);
					call.setString(3,locale);
					call.setString(4,"1");

					call.execute();							
					ins_ref_src_sub_desc = call.getString(1);				
					call.close();
					if ( ins_ref_src_sub_desc == null ) ins_ref_src_sub_desc = "&nbsp;";

					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_sub_code);
					call.setString(3,locale);
					call.setString(4,"3");

					call.execute();							
					ins_ref_src_sub_lng_name = call.getString(1);				
					call.close();
					if ( ins_ref_src_sub_lng_name == null ) ins_ref_src_sub_lng_name = "";
				}
				else
				{
					ins_ref_src_sub_desc = "&nbsp;";
					ins_ref_src_sub_lng_name = "";
				}

				String ins_ref_src_code_valid_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+blng_grp_id+"'";
		
				try
				{
					pstmt = con.prepareStatement(ins_ref_src_code_valid_qry);
					rs3 = pstmt.executeQuery() ;
					if( rs3 != null ) 
					{	
						while( rs3.next() )
						{  
							ins_referral_source_code_flag = rs3.getString(1);
						}
					}
					if (rs3 != null) rs3.close();
					pstmt.close();	
				}
				catch(Exception e)
				{
					System.out.println("Exception in ref_src_code_valid_qry:"+e);
				}
				if(ins_referral_source_code_flag == null) ins_referral_source_code_flag="N";

				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}

				try
				{
					pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
					rs3		= pstmt.executeQuery();	
					while(rs3.next())
					{
						noofdecimal  =  rs3.getInt(1);		
					}
					rs3.close();
					pstmt.close();
		
					CurrencyFormat cf = new CurrencyFormat();
					if(!approved_amt.equals("") && !approved_amt.equals("&nbsp;"))
					{
						approved_amt = cf.formatCurrency(approved_amt, noofdecimal);
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception in currency format query:"+e.toString());
				}

	if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
	{
%>
<tr>
			<td class='PATIENTLINECOLOR' colspan=2><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='PATIENTLINECOLOR' colspan=2><%=desc%></td>

			<td class='PATIENTLINECOLOR' colspan=2><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/></td>
			<td class='PATIENTLINECOLOR' colspan=2>
<%
			if(!ins_ref_src_main_lng_name.equals(""))
			{
%>
			<%=ins_ref_src_main_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=ins_ref_src_main_lng_name%>'>
<%
			}
			else
			{
%>
			<%=ins_ref_src_main_desc%>
<%
			}
%>
			</td>
			<td class='PATIENTLINECOLOR' colspan=2><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/></td>
			<td class='PATIENTLINECOLOR' colspan=2>
<%
			if(!ins_ref_src_sub_lng_name.equals(""))
			{
%>
			<%=ins_ref_src_sub_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=ins_ref_src_sub_lng_name%>'>
<%
			}
			else
			{
%>
			<%=ins_ref_src_sub_desc%>
<%
			}

%>			
			</td>
</tr>
<%
	}
%>
		<tr id=row<%=i%>>
<!--
			<td class=<%=classval%> ><a href='#' onMouseOver='displayToolTip("<%=ins_ref_src_main_desc%>","<%=ins_ref_src_sub_desc%>")' onMouseOut='hideToolTip()' onFocus='displayToolTip("<%=ins_ref_src_main_desc%>","<%=ins_ref_src_sub_desc%>")'
			onBlur='hideToolTip()' ><%=blng_grp_desc.equals("null")?"":blng_grp_desc%></a></td>
-->
			<input type=hidden name='blng_grp_id<%=i%>' id='blng_grp_id<%=i%>' value="<%=blng_grp_id%>">
			<td class=<%=classval%> ><%=cust_group_desc.equals("null")?"":cust_group_desc%> / <%=customer_name.equals("null")?"":customer_name%></td>
			<input type=hidden name='cust_3<%=i%>' id='cust_3<%=i%>' value=''><input type=hidden name='cust_3_group_name<%=i%>' id='cust_3_group_name<%=i%>' value="<%=customer_name.equals("null")?"":customer_name%>">
			<td class=<%=classval%> ><%=priority.equals("null")?"":priority%></td>
			<td class=<%=classval%>  ><!-- Karthik added link here -->			
			<%=policy_type_desc.equals("null")?"":policy_type_desc%>
			</a>
			</td>
			<input type=hidden name='policy_type_code<%=i%>' id='policy_type_code<%=i%>' value="<%=policy_type_code.equals("null")?"":policy_type_code%>">
			<td class=<%=classval%> ><%=policy_number.equals("null")?"":policy_number%>
			
			<%if(strCharge_logic.equals("Y")){ %> 
			<a name='' href="#" onClick="callRecordApprovalPolicyDetails('<%=strpatientid%>','<%=cust_group_code%>','<%=cust_code%>','<%=policy_type_code%>','<%=effective_from%>','<%=effective_to%>','<%=strvisitid%>','<%=strCurrAcctSeqNo%>','<%=priority%>','<%=policy_number%>','<%=strepisodetype%>','<%=strepisodeid%>')">
			(dtls)
			<%} %>
			</td>
			
			<td class=<%=classval%> ><%=policy_start_date.equals("null")?"":policy_start_date%></td>
			<td class=<%=classval%> ><%=policy_expiry_date.equals("null")?"":policy_expiry_date%></td>
			<td class=<%=classval%> ><%=credit_auth_ref.equals("null")?"":credit_auth_ref%></td>
			<td class=<%=classval%> ><%=credit_auth_date.equals("null")?"":credit_auth_date%></td>
			<td class=<%=classval%> ><%=approved_amt.equals("null")?"":approved_amt%></td>
			<td  class=<%=classval%> ><%=approved_days.equals("null")?"":approved_days%></td>
			<td class=<%=classval%> ><%=effective_from.equals("null")?"":effective_from%></td>
			<td class=<%=classval%> ><%=effective_to.equals("null")?"":effective_to%></td>
</tr>
	<%
				i++;
				tempDesc=desc;
			}//closing WHILE
			rs.close();
			pstmt.close();
	%>
</tbody>
</table>
</div>	
</table>


<input type= 'hidden' name="strBillGrp" id="strBillGrp"  value="<%=strBillGrp%>">
<input type='hidden' name='strFamIn' id='strFamIn' value='<%=strFamIn%>'>
<input type='hidden' name='NoDep' id='NoDep' value='<%=strNoDep%>'>
<input type='hidden' name='strPatRel' id='strPatRel' value="<%=strPatRel%>">
<input type='hidden' name='strGLHol' id='strGLHol' value="<%=strGLHol%>">
<input type='hidden' name='strResPay' id='strResPay' value="<%=strResPay%>">
<input type='hidden' name='strPatRelGL' id='strPatRelGL' value="<%=strPatRelGL%>">
<input type='hidden' name='strAdmFlag' id='strAdmFlag' value='<%=strAdmFlag%>'>
<input type='hidden' name='strCrdDocRef' id='strCrdDocRef' value="<%=strCrdDocRef%>">
<input type='hidden' name='strSetInd' id='strSetInd' value='<%=strSetInd%>'>
<input type='hidden' name='strFamAss' id='strFamAss' value='<%=strFamAss%>'>
<input type='hidden' name='strNonInsBlGrId' id='strNonInsBlGrId' value="<%=strNonInsBlGrId%>">
<input type='hidden' name='strNonInsCustCode' id='strNonInsCustCode' value="<%=strNonInsCustCode%>">
<input type='hidden' name='strCrDocRefStDate' id='strCrDocRefStDate' value="<%=strCrDocRefStDate%>">
<input type='hidden' name='strCrDocRefEndDate' id='strCrDocRefEndDate' value='<%=strCrDocRefEndDate%>'>

	<div name='tooltiplayer' id='tooltiplayer' style='position:relative; width:75%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
			</tr>
		</table>
	</div>
</form>
</body>
<%
		}
	}
	catch(Exception eX)
	{
			System.out.println("Error in Qry2.jsp= "+eX);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

