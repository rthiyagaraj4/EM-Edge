<!DOCTYPE html>
<%
/*
Sr No        Version            Incident          SCF/CRF             Developer Name
1           V232504							SKR-SCF-1731-TF         Namrata Charate
*/
%>

<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,eXH.InterfaceUtil,java.text.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs4				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;

	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
//		System.err.println("querstring  in grpbody.jsp page:"+request.getQueryString());
		String sys_date="";
		int totalRecords=0;
		int selected_index=0;
		String total_records="";
		String checked_row="";
		String classval="";
		String facility_id = (String)httpSession.getValue("facility_id");

//		String queryString=(request.getQueryString());
//		System.out.println("queryString in multi:"+queryString);

		String valid_payer_YN="";
		String valid_policy_type_code_YN="";
		String cust_group_code="", cust_group_name="";;
		String policy_coverage_basis_ind="";
		String policy_coverage_basis_gbl_ind="";
		String policy_coverage_basis_gbl_ind_from_main="";

		String policy_start_date_conv="";
		String policy_exp_date_conv="";
		String credit_auth_date_conv="";
		String policy_eff_frm_date_conv="";
		String policy_eff_to_date_conv="";

		String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
		String v_display_hide_cred_auth="";
		String cred_auth_req_yn = "", dflt_auth_ref_as_pol_no_yn = "",cred_auth_mand_capt_yn="";

		String pol_validity_chk_date="";

		String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";

		String cust_valid_from_date = "" ,cust_valid_to_date = "";

		String fin_class_flag_YN="N",autoFinChk="N",class_code="";

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";

		ArrayList existing_records_array=new ArrayList();

		policy_coverage_basis_gbl_ind_from_main=request.getParameter("policy_coverage_basis_gbl_ind_from_main");
		if(policy_coverage_basis_gbl_ind_from_main==null) policy_coverage_basis_gbl_ind_from_main="";

		String billing_group=request.getParameter("billing_group");
		if(billing_group==null) billing_group="";

		String p_patient_class  = request.getParameter("patient_class");
		String strModuleId = "",episode_type="";

		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";

		String rec_edited_YN="N", payer_suspended_YN="", policy_suspended_YN="";

		strModuleId=request.getParameter("calling_module_id");
		if(strModuleId==null) strModuleId="";

		String str_max_priority=request.getParameter("max_priority");
//		System.out.println("str_max_priority:"+str_max_priority);
		if(str_max_priority == null || str_max_priority.equals("")) str_max_priority="0";

		int max_priority=Integer.parseInt(str_max_priority);

		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("EM")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}

		if(strModuleId.equals("MP")) episode_type="R";
		else if(strModuleId.equals("AE")) episode_type="E";
		else if(strModuleId.equals("OP")) episode_type="O";
		else if(strModuleId.equals("IP")) episode_type="I";
		else if(strModuleId.equals("DC")) episode_type="D";

		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy') from dual";

		//	stmt = con.createStatement();
			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
			rs = pstmt.executeQuery() ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
					sys_date = rs.getString(2);
				}
			}
			if (rs != null)   rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
		if(sys_date == null) sys_date="";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		
		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		if(!encounter_date_aft_trunc.equals(""))
		{
			if(!locale.equals("en"))
			{
				encounter_date_aft_trunc=com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale);
			}
		}
/*
		if(autoFinChk.equals("Y"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				System.err.println("Inside Class Loop in insbody.jsp");
				class_code = ((String)bl_data.get("class_code")).trim();
			}
		}
*/
//		System.out.println("Encounter Date in MultiBlngGrpBody.jsp after Trunc of Time:"+encounter_date_aft_trunc);

		String remove_check=request.getParameter("remove_check");
		if(remove_check==null) remove_check="";

		if(remove_check.equals("remove"))
		{
			total_records=request.getParameter("total_records");
			if(total_records==null) total_records="0";

			totalRecords=Integer.parseInt(total_records);
			
			checked_row=request.getParameter("checked_row");
			if(checked_row==null) checked_row="0";
			selected_index=Integer.parseInt(checked_row);

//			System.out.println("total_records:"+total_records);
//			System.out.println("selected_index:"+selected_index);

			for(int i=0;i<totalRecords;i++)
			{
				if(!(i==selected_index))
				{
					policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
				
					policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
						if(policy_exp_date_conv==null) policy_exp_date_conv="";

					credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
						if(credit_auth_date_conv==null) credit_auth_date_conv="";

					policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
						if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	
					policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
						if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";

					if(!locale.equals("en"))
					{
						if(!policy_start_date_conv.equals(""))
							policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
		
						if(!policy_exp_date_conv.equals(""))
							policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
	
						if(!credit_auth_date_conv.equals(""))
							credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
				
						if(!policy_eff_frm_date_conv.equals(""))
							policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");

						if(!policy_eff_to_date_conv.equals(""))
							policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
					}

					//String[] records=new String[35];
					//String[] records=new String[45];
					String[] records=new String[53]; //V232504
					records[0]=request.getParameter("blng_grp_code"+i);
					records[1]=request.getParameter("payer_desc"+i);
					records[2]=request.getParameter("cust_3"+i);
					records[3]=request.getParameter("priority"+i);
					records[4]=request.getParameter("policy_type_desc"+i);
					records[5]=request.getParameter("policy_type_code"+i);
					records[6]=request.getParameter("policy_no"+i);
//					records[7]=request.getParameter("policy_start_date"+i);
					records[7]=policy_start_date_conv;
//					records[8]=request.getParameter("policy_exp_date"+i);
					records[8]=policy_exp_date_conv;
					records[9]=request.getParameter("credit_auth_ref"+i);
//					records[10]=request.getParameter("credit_auth_date"+i);
					records[10]=credit_auth_date_conv;
					records[11]=request.getParameter("credit_apprd_amt"+i);
					records[12]=request.getParameter("credit_apprd_days"+i);
//					records[13]=request.getParameter("policy_eff_frm_date"+i);
					records[13]=policy_eff_frm_date_conv;
//					records[14]=request.getParameter("policy_eff_to_date"+i);
					records[14]=policy_eff_to_date_conv;
					records[15]=request.getParameter("adj_rule_ind"+i);
					records[16]=request.getParameter("adj_perc_amt_ind"+i);
					records[17]=request.getParameter("adj_perc_amt_value"+i);
					records[18]=request.getParameter("pmnt_diff_adj_int"+i);
					records[19]=request.getParameter("drg_pmnt_diff_adj_int"+i);
					records[20]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
					records[21]=request.getParameter("restrict_check"+i);
					records[22]=request.getParameter("valid_payer_YN"+i);
					records[23]=request.getParameter("valid_policy_type_code_YN"+i);
					records[24]=request.getParameter("ins_cust_group_code"+i);
					records[25]=request.getParameter("policy_coverage_basis_ind"+i);
					records[26]=request.getParameter("apprd_amt_restrict_check"+i);
					records[27]=request.getParameter("apprd_days_restrict_check"+i);
					records[28]=request.getParameter("cred_auth_req_yn"+i);
					records[29]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
					records[30]=request.getParameter("cust_valid_from_date"+i);
					records[31]=request.getParameter("cust_valid_to_date"+i);
					records[32]=request.getParameter("ins_cust_group_name"+i);
					records[33]=request.getParameter("rec_edited_YN"+i);
					records[34]=request.getParameter("cred_auth_mand_capt_yn"+i);
					
					records[35]=request.getParameter("payerEligibilityParam"+i);
					records[36]=request.getParameter("responseCode"+i);
					records[37]=request.getParameter("responseCodeDesc"+i);
					records[38]=request.getParameter("statuDescription"+i);
					records[39]=request.getParameter("validityPeriod"+i);
					records[40]=request.getParameter("validityPeriodDesc"+i);
					records[41]=request.getParameter("eligibilityCode"+i);
					records[42]=request.getParameter("transactionId"+i);
					records[43]=request.getParameter("responseDateTime"+i);
					records[51]=request.getParameter("mcn_for_policy"+i);  //V232504					
					records[52]=request.getParameter("reg_ref_id"+i);  //V232504					
				 

					existing_records_array.add(records);
				}
			}
		}
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
				}
			}
			if(rs4 != null) rs4.close();
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception :"+e);
		}
*/
%>
<head>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#tbl-container {
width: 100%;
height: 360px;
overflow: auto;
}

thead td, thead td.locked	{
position:relative;
}

thead td {
top: expression(document.getElementById("tbl-container").scrollTop-2); 
z-index: 20;
}

</STYLE>
<script>


function selected(i)
{
	var selected_row=eval("document.forms[0].selected_row"+i);

	if(selected_row.checked==false)
	{
		selected_row.checked=false;
		document.forms[0].checked_row.value="";
	}
	else
	{
		var total_records=document.forms[0].total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("document.forms[0].selected_row"+j);
			temp.checked=false;
		}
		selected_row.checked=true;
		document.forms[0].checked_row.value=i;
	}
}

function check(i)
{
		document.forms[0].focussed_row.value=i;
}

function policy_coverage_basis_ind()
{
	var totalRecords=document.forms[0].total_records.value;

	if(totalRecords!=0)
	{
		for(var i=0;i<totalRecords;i++)
		{
			var policy_cov_basis_ind=eval(document.getElementById("policy_coverage_basis_"+i));
			var policy_cov_basis_ind_val=eval("document.forms[0].policy_coverage_basis_ind"+i);
			if(policy_cov_basis_ind_val.value=="P")
			{
				policy_cov_basis_ind.innerText=getLabel("eBL.PATIENT_BASED.label","BL");
			}
			else if(policy_cov_basis_ind_val.value=="I")
			{
				policy_cov_basis_ind.innerText=getLabel("eBL.PAYER_BASED.label","BL");
			}
		}
	}
}

function dflt_pol_validity_date()
{
	var locale=document.forms[0].locale.value;
	var module_id = document.forms[0].calling_module_id.value;
	var total_records= document.forms[0].total_records.value;

	if(module_id != 'MP')
	{
		for(var i=0;i<total_records;i++)
		{
			var policy_eff_frm_date = eval("document.forms[0].policy_eff_frm_date"+i);
			var credit_apprd_days = eval("document.forms[0].credit_apprd_days"+i);
			var apprd_days_restrict_check = eval("document.forms[0].apprd_days_restrict_check"+i);
			var pol_validity_chk_date = eval("document.forms[0].pol_validity_chk_date"+i);

			if(policy_eff_frm_date.value != "" && credit_apprd_days.value != "" && apprd_days_restrict_check.value=='R')
			{
				var pol_validity_chk_date_val = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(credit_apprd_days.value)-1,'d');

				pol_validity_chk_date.value=pol_validity_chk_date_val;
			}
		}
	}
}
</script>

</head>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="policy_coverage_basis_ind();dflt_pol_validity_date();">

<form name='' id='' method='post' >
<!--
<table cellpadding=3 cellspacing=0  width="100%" align='left'  border=1 id='ins_data'>
-->
<div id='tbl-container'>
<table cellpadding=3 cellspacing=0  width="100%" align='left'  border=1 id='ins_data'>
<thead>
<tr><td class='COLUMNHEADER' colspan='9' align='left'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td></tr>
<tr>
	<td class='COLUMNHEADER' width='14%'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>
	</tr>
</thead>
<tbody>
<%
if(remove_check.equals("remove"))
{
		//String[] output1=new String[34];
		System.out.println("remove check...prithivi...");
	//	String[] output1=new String[44];
		String[] output1=new String[53]; //V232504
		
		totalRecords=0;
	
		for(int i=0;i<existing_records_array.size();i++)
		{
			
			output1=(String[])existing_records_array.get(i);

			System.out.println("remove check...prithivi...output1.get(i) size..."+output1.length);

			policy_coverage_basis_ind=output1[25];	

			if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";

			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}

			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			String billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = ? AND LANGUAGE_ID = ?";
		
			String blng_grp_long_desc="";
			pstmt = con.prepareStatement(billing_grp_qry);
			pstmt.setString(1,output1[0]);
			pstmt.setString(2,locale);
			rs2=pstmt.executeQuery();
			if( rs2 != null ) 
			{
				while(rs2.next())
				{
					blng_grp_long_desc=rs2.getString(1);
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();
//			System.out.println("output1[32]:"+output1[32]);
%>
<tr id=row<%=i%>>
<input type=hidden name='billing_group_desc<%=i%>' id='billing_group_desc<%=i%>' value="<%=blng_grp_long_desc%>">
<input type=hidden name='blng_grp_code<%=i%>' id='blng_grp_code<%=i%>' value="<%=output1[0]%>">

<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=i%>' id='ins_cust_group_name<%=i%>'  value="<%=output1[32]%>" onFocus='check(<%=i%>);'  readonly></td>

<td class=<%=classval%> width='12%' ><input maxlength='15' size='13' type=text name='payer_desc<%=i%>' id='payer_desc<%=i%>'  value="<%=output1[1]%>"  readonly></td><input type='hidden' name='cust_3<%=i%>' id='cust_3<%=i%>' value="<%=output1[2]%>">
<!--
<input type='hidden' name='ins_cust_group_name<%=i%>' id='ins_cust_group_name<%=i%>' value='<%=output1[32]%>'>
-->
<input type='hidden' name='ins_cust_group_code<%=i%>' id='ins_cust_group_code<%=i%>' value="<%=output1[24]%>"><input type='hidden' name='valid_payer_YN<%=i%>' id='valid_payer_YN<%=i%>' value="<%=output1[22]%>"><input type='hidden' name='cust_valid_from_date<%=i%>' id='cust_valid_from_date<%=i%>' value="<%=output1[30]%>"><input type='hidden' name='cust_valid_to_date<%=i%>' id='cust_valid_to_date<%=i%>' value="<%=output1[31]%>">
<input type='hidden' name='payer_suspended_YN<%=i%>' id='payer_suspended_YN<%=i%>' value="<%=payer_suspended_YN%>">

<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=i%>' id='priority<%=i%>' style='text-align:right'  value='<%=output1[3]%>'  readonly></td> 

<td class=<%=classval%> width='12%' ><input maxlength='15' size='13' type=text name='policy_type_desc<%=i%>' id='policy_type_desc<%=i%>'  value="<%=output1[4]%>"  readonly></td><input type='hidden' name='policy_type_code<%=i%>' id='policy_type_code<%=i%>' value="<%=output1[5]%>" ><input type='hidden' name='valid_policy_type_code_YN<%=i%>' id='valid_policy_type_code_YN<%=i%>' value='<%=output1[23]%>' >
<input type='hidden' name='policy_suspended_YN<%=i%>' id='policy_suspended_YN<%=i%>' value="<%=policy_suspended_YN%>">

<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=i%>' id='policy_no<%=i%>'   value="<%=output1[6]%>"  readonly></td>

<%
	policy_start_date_conv=(String)output1[7];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=i%>' id='policy_start_date<%=i%>' size='10' maxlength='10' value='<%=policy_start_date_conv%>'  readonly></td>

<%
	policy_exp_date_conv=(String)output1[8];	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=i%>' id='policy_exp_date<%=i%>' size='10' maxlength='10' value='<%=policy_exp_date_conv%>'   readonly></td>

<%
//	System.out.println("In output1[28]:"+output1[28]);
//	System.out.println("In output1[29]:"+output1[29]);
	if(output1[28].equals("Y"))
	{
		if(output1[29].equals("Y"))
		{
			String temp_str=output1[6];
			if(!temp_str.equals("") && output1[9].equals(""))
			{
				if(temp_str.length() <= 20)
				{
					output1[9] = temp_str.substring(0,temp_str.length());
				}
				else
				{
					output1[9] = temp_str.substring(0,20);
				}
			}
		}
//		System.out.println("In here:"+output1[10]);
		output1[10] = encounter_date_aft_trunc;
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
		output1[9] = "";
		output1[10] = "";
	}
%>
<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=i%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=i%>' id='credit_auth_ref<%=i%>'   value="<%=output1[9]%>"  readonly></div></td>

<%
	credit_auth_date_conv=(String)output1[10];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=i%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=i%>' id='credit_auth_date<%=i%>' size='10' maxlength='10' value='<%=credit_auth_date_conv%>' readonly></div></td>

</tr>

<tr id=row<%=i%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=i%>"></b></td>
<%
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	
	if(output1[21].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[21].equals("R"))
	{
		if(output1[26].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[27].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
%>

<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=i%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=i%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=i%>' id='credit_apprd_amt<%=i%>' style='text-align:right'  value='<%=output1[11]%>'  readonly></div></td>

<td  class=<%=classval%> width='12%'  ><div id="apprd_days_leg_disp<%=i%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=i%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=i%>' id='credit_apprd_days<%=i%>' style='text-align:right'  value='<%=output1[12]%>'  readonly></div></td>
	
<%
	policy_eff_frm_date_conv=(String)output1[13];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=i%>' id='policy_eff_frm_date<%=i%>' size='10' maxlength='10' value='<%=policy_eff_frm_date_conv%>' readonly></td>

<%
	policy_eff_to_date_conv=(String)output1[14];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}
%>
<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=i%>' id='policy_eff_to_date<%=i%>' size='10' maxlength='10' value='<%=policy_eff_to_date_conv%>' readonly></td>
</tr>

<input type='hidden' name='adj_rule_ind<%=i%>' id='adj_rule_ind<%=i%>' value="<%=output1[15]%>">
<input type='hidden' name='adj_perc_amt_ind<%=i%>' id='adj_perc_amt_ind<%=i%>' value="<%=output1[16]%>">
<input type='hidden' name='adj_perc_amt_value<%=i%>' id='adj_perc_amt_value<%=i%>' value="<%=output1[17]%>">
<input type='hidden' name='pmnt_diff_adj_int<%=i%>' id='pmnt_diff_adj_int<%=i%>' value="<%=output1[18]%>">
<input type='hidden' name='drg_pmnt_diff_adj_int<%=i%>' id='drg_pmnt_diff_adj_int<%=i%>' value="<%=output1[19]%>">
<input type='hidden' name='spl_srv_pmnt_diff_adj_int<%=i%>' id='spl_srv_pmnt_diff_adj_int<%=i%>' value="<%=output1[20]%>">
<input type='hidden' name='restrict_check<%=i%>' id='restrict_check<%=i%>' value="<%=output1[21]%>">
<input type='hidden' name='apprd_amt_restrict_check<%=i%>' id='apprd_amt_restrict_check<%=i%>' value='<%=output1[26]%>'>
<input type='hidden' name='apprd_days_restrict_check<%=i%>' id='apprd_days_restrict_check<%=i%>' value='<%=output1[27]%>'>
<input type='hidden' name='policy_coverage_basis_ind<%=i%>' id='policy_coverage_basis_ind<%=i%>' value="<%=output1[25]%>">
<input type='hidden' name='cred_auth_req_yn<%=i%>' id='cred_auth_req_yn<%=i%>' value='<%=output1[28]%>'>
<input type='hidden' name='cred_auth_mand_capt_yn<%=i%>' id='cred_auth_mand_capt_yn<%=i%>' value='<%=output1[34]%>'>
<input type='hidden' name='dflt_auth_ref_as_pol_no_yn<%=i%>' id='dflt_auth_ref_as_pol_no_yn<%=i%>' value='<%=output1[29]%>'>
<input type='hidden' name='pol_validity_chk_date<%=i%>' id='pol_validity_chk_date<%=i%>' value="<%=pol_validity_chk_date%>">
<input type='hidden' name='rec_edited_YN<%=i%>' id='rec_edited_YN<%=i%>' value='<%=output1[33]%>'>

<input type='hidden' name='payerEligibilityParam<%=totalRecords%>' id='payerEligibilityParam<%=totalRecords%>' value="<%=output1[35]%>">

<input type='hidden' name='responseCode<%=totalRecords%>' id='responseCode<%=totalRecords%>' value="<%=output1[36]%>">
<input type='hidden' name='responseCodeDesc<%=totalRecords%>' id='responseCodeDesc<%=totalRecords%>' value="<%=output1[37]%>">
<input type='hidden' name='statuDescription<%=totalRecords%>' id='statuDescription<%=totalRecords%>' value="<%=output1[38]%>">
<input type='hidden' name='validityPeriod<%=totalRecords%>' id='validityPeriod<%=totalRecords%>' value="<%=output1[39]%>">
<input type='hidden' name='validityPeriodDesc<%=totalRecords%>' id='validityPeriodDesc<%=totalRecords%>' value="<%=output1[40]%>">
<input type='hidden' name='eligibilityCode<%=totalRecords%>' id='eligibilityCode<%=totalRecords%>' value="<%=output1[41]%>">
<input type='hidden' name='transactionId<%=totalRecords%>' id='transactionId<%=totalRecords%>' value="<%=output1[42]%>">
<input type='hidden' name='responseDateTime<%=totalRecords%>' id='responseDateTime<%=totalRecords%>' value="<%=output1[43]%>">

<input type='hidden' name='mcn_for_policy<%=totalRecords%>' id='mcn_for_policy<%=totalRecords%>' value='<%=output1[51]%>'>  <!-- V232504 -->
<input type='hidden' name='reg_ref_id<%=totalRecords%>' id='reg_ref_id<%=totalRecords%>' value='<%=output1[52]%>'>  <!-- V232504 -->
<%
		totalRecords++;
	}
}
else
{
//	System.out.println("Checking");
	int priority_count=max_priority;

	String billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = ? AND LANGUAGE_ID = ?";
	String blng_grp_long_desc="";
	pstmt = con.prepareStatement(billing_grp_qry);
	pstmt.setString(1,billing_group);
	pstmt.setString(2,locale);
	rs2=pstmt.executeQuery();
	if( rs2 != null ) 
	{
		while(rs2.next())
		{
			blng_grp_long_desc=rs2.getString(1);
			if(blng_grp_long_desc == null) blng_grp_long_desc="";
		}
	}
	if(rs2 != null) rs2.close();
	pstmt.close();

//	String sql_default="SELECT DISTINCT a.cust_code cust_code,DECODE(a.cust_code,'**',NULL, c.short_name) cust_short_name,a.policy_type_code policy_type_code,b.short_desc policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,c.cust_group_code cust_group_code,d.policy_coverage_basis,e.short_desc FROM bl_payers_priority_by_bg a, bl_ins_policy_types_lang_vw b,ar_customer_lang_vw c,bl_ins_policy_type_hdr d,ar_cust_group_lang_vw E,bl_cust_by_cust_group f WHERE a.operating_facility_id ='"+facility_id+"' AND a.blng_grp_id ='"+billing_group+"' AND a.patient_class ='"+p_patient_class+"' AND b.language_id = '"+locale+"' AND b.operating_facility_id = a.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND b.policy_type_code = a.policy_type_code AND b.policy_type_code = d.policy_type_code AND c.language_id = b.language_id AND b.language_id = e.language_id ORDER BY a.priority_no";	

//New Query for CRF-134 ( Multiple Cust Group for single Customer
//interface column Added in sql_default by prithivi on 03/05/2017 for mms-qh-crf-0085. bupa payer eligibility check
	String sql_default="";

	if(autoFinChk.equals("Y"))
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null  policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,BL_APPL_BG_BY_CLASSFCTN g"
		+" WHERE a.operating_facility_id =? " 
		+" AND a.blng_grp_id =? "
		+" AND a.blng_grp_id =g.APPL_BLNG_GRP_ID"
		+" AND g.CLASSIFICATION_CODE=? "
		+" AND a.patient_class =?" 
//		+" AND b.language_id = ?"
		+" and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE"
		+" and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE"
		+" AND a.operating_facility_id = b.operating_facility_id" 
		+" AND a.operating_facility_id = d.operating_facility_id" 
		+" AND a.operating_facility_id = g.operating_facility_id" 
		+" AND (c.cust_code = a.cust_code OR a.cust_code='**')" 
		+" AND c.cust_code=f.cust_code"
		+" AND f.cust_code=g.APPL_CUST_CODE"
		+" AND a.policy_type_code = b.policy_type_code" 
		+" AND a.policy_type_code = d.policy_type_code" 
		+" AND a.cust_group_code=f.cust_group_code"
		+" AND a.cust_group_code=d.cust_group_code" 
		+" AND d.cust_group_code=e.cust_group_code" 
		+" AND d.cust_group_code=g.APPL_CUST_GROUP_CODE"
//		+" AND c.language_id = b.language_id" 
//		+" AND b.language_id = e.language_id" 
		+" ORDER BY a.priority_no";
	}
	else
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null  policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,bl_blng_grp g "
		+" WHERE a.operating_facility_id =? " 
		+" AND a.blng_grp_id =? "
		+" AND g.dflt_payer_dtls_during_regn_yn ='Y' and  nvl(a.status,'E') = 'E'" // Karthik added
		+" AND a.patient_class =? " 
//		+" AND b.language_id = ? "
		+" and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE"
		+" and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE"		
		+" AND a.operating_facility_id = b.operating_facility_id" 
		+" AND a.operating_facility_id = d.operating_facility_id" 
		+" AND (c.cust_code = a.cust_code OR a.cust_code='**')" 
		+" AND c.cust_code=f.cust_code"
		+" AND a.policy_type_code = b.policy_type_code" 
		+" AND a.policy_type_code = d.policy_type_code" 
		+" AND a.cust_group_code=f.cust_group_code"
		+" AND a.cust_group_code=d.cust_group_code" 
		+" AND d.cust_group_code=e.cust_group_code" 
//		+" AND c.language_id = b.language_id" 
//		+" AND b.language_id = e.language_id" 
		+" ORDER BY a.priority_no";
	}
	System.err.println("sql_default in Sec Ins BG:"+sql_default);
	pstmt = con.prepareStatement(sql_default);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,billing_group);
		
	if(autoFinChk.equals("Y")){
		pstmt.setString(3,class_code);
		pstmt.setString(4,p_patient_class);
	}else{
		pstmt.setString(3,p_patient_class);
	}
	
	rs2 = pstmt.executeQuery() ;
	if( rs2 != null ) 
	{
		int i=0;

		while( rs2.next() )
		{
			//Added by prithivi on 03/05/2017 for mms-qh-crf-0085. This param is used for payer eligibility check
			String payerEligibilityParam="9";

			String cust_code=rs2.getString(1);
			if(cust_code==null || cust_code.equals("")) cust_code="";
			String cust_short_name="";
//			String cust_short_name=rs2.getString(2);
//			if(cust_short_name==null || cust_short_name.equals("")) cust_short_name="";
			String policy_type_code=rs2.getString(3);
			if(policy_type_code==null || policy_type_code.equals("")) policy_type_code="";
			String policy_short_desc="";
//			String policy_short_desc=rs2.getString(4);
//			if(policy_short_desc==null || policy_short_desc.equals("")) policy_short_desc="";
			String priority_no=rs2.getString(5);
			if(priority_no==null || priority_no.equals("")) priority_no="";

			String adj_rule_ind=rs2.getString(6);
			if(adj_rule_ind==null || adj_rule_ind.equals("")) adj_rule_ind="";
			String adj_perc_amt_ind=rs2.getString(7);
			if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals("")) adj_perc_amt_ind="";
			String adj_perc_amt_value=rs2.getString(8);
			if(adj_perc_amt_value==null || adj_perc_amt_value.equals("")) adj_perc_amt_value="";
			String pmnt_diff_adj_int=rs2.getString(9);
			if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals("")) pmnt_diff_adj_int="";
			String drg_pmnt_diff_adj_int=rs2.getString(10);
			if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals("")) drg_pmnt_diff_adj_int="";
			String spl_srv_pmnt_diff_adj_int=rs2.getString(11);
			if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals("")) spl_srv_pmnt_diff_adj_int="";

			cust_group_code=rs2.getString(12);
			if(cust_group_code==null || cust_group_code.equals("")) cust_group_code="";

//			cust_group_name=rs2.getString(14);
//			if(cust_group_name==null || cust_group_name.equals("")) cust_group_name="";

			policy_coverage_basis_ind=rs2.getString(13);
			if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals("")) policy_coverage_basis_ind="";

			String interfaceYNcustgroup = rs2.getString(15);
			if(interfaceYNcustgroup==null || interfaceYNcustgroup.equals("")) interfaceYNcustgroup="";

			System.out.println("AddmodifyPatFinDetailsMultiBlngGrpBody.jsp...interfaceYNcustgroup...."+interfaceYNcustgroup);

			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}

			priority_count++;

			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}

			String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and cust_group_code = '"+cust_group_code+"'";

			try
			{
				pstmt = con.prepareStatement(cust_grp_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						cust_group_name = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(cust_group_name == null) cust_group_name="";

			String cust_desc_qry = "select DECODE('"+cust_code+"','**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id='"+locale+"' and cust_code = '"+cust_code+"'";
			System.err.println("Exception in ref_src_code_qry:"+cust_desc_qry);
			try
			{
				pstmt = con.prepareStatement(cust_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						cust_short_name = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(cust_short_name == null) cust_short_name="";

			String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id='"+locale+"' and policy_type_code = '"+policy_type_code+"'";

			try
			{
				pstmt = con.prepareStatement(policy_type_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						policy_short_desc = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(policy_short_desc == null) policy_short_desc="";
%>
<%
	if(i==0)
	{
%>
<input type=hidden name='billing_group_desc<%=i%>' id='billing_group_desc<%=i%>' value="<%=blng_grp_long_desc%>">
<%
	}
	else
	{
%>
<input type=hidden name='billing_group_desc<%=i%>' id='billing_group_desc<%=i%>' value="<%=blng_grp_long_desc%>">
<%
	}

//Added by prithivi on 29/12/2016 for mms-qh-crf-0085. bupa payer eligibility check
	String check_profileId="ELCPROF1";
	String profile_id_exists="N";
	String moduleIdCheck = InterfaceUtil.checkModuleIdForPayerEligibility(strModuleId);

    profile_id_exists = InterfaceUtil.isInterfaceProfileExisting(check_profileId);
    
	if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck) )
	{ 
		System.out.println("AddmodifyPatfindetailsmultiblnggrpbody.jsp...in loop interfaceYNcustgroup,..."+interfaceYNcustgroup);
		if("Y".equals(interfaceYNcustgroup))
		{
		  payerEligibilityParam="0";
		}
		else
		{
          payerEligibilityParam="9";
		}
	}
	System.out.println("AddmodifyPatfindetailsmultiblnggrpbody.jsp...payerEligibilityParam.."+i+".."+payerEligibilityParam);
%>

<tr id=row<%=i%>>


<input type=hidden name='blng_grp_code<%=i%>' id='blng_grp_code<%=i%>' value="<%=billing_group%>">

<input type= "hidden" name="payerEligibilityParam<%=i%>" id="payerEligibilityParam<%=i%>"  value="<%=payerEligibilityParam%>">

<input type= "hidden" name="responseCode<%=i%>" id="responseCode<%=i%>" value="">
<input type= "hidden" name="responseCodeDesc<%=i%>" id="responseCodeDesc<%=i%>" value="">
<input type= "hidden" name="statuDescription<%=i%>" id="statuDescription<%=i%>" value="">
<input type= "hidden" name="validityPeriod<%=i%>" id="validityPeriod<%=i%>" value="">
<input type= "hidden" name="validityPeriodDesc<%=i%>" id="validityPeriodDesc<%=i%>" value="">
<input type= "hidden" name="eligibilityCode<%=i%>" id="eligibilityCode<%=i%>" value="">
<input type= "hidden" name="transactionId<%=i%>" id="transactionId<%=i%>" value="">
<input type= "hidden" name="responseDateTime<%=i%>" id="responseDateTime<%=i%>" value="">

<td class=<%=classval%> width='14%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)">&nbsp;&nbsp;<input maxlength='15' size='12' type=text name='ins_cust_group_name<%=i%>' id='ins_cust_group_name<%=i%>'  value="<%=cust_group_name%>" onFocus='check(<%=i%>);'  readonly></td>

<%
	try
	{
		String empty_sql_check="N";
//		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_ins_policy_type_hdr d,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and c.acc_entity_id = d.operating_facility_id and a.patient_flag = 'Y' 	and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and d.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and d.cust_group_code = e.cust_group_code and (('"+strModuleId+"' in ('OP','AE') and nvl(d.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(d.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(d.external_covered,'N') = 'Y'))	AND d.CUST_CODE ='"+cust_code+"' and d.cust_group_code='"+cust_group_code+"'";

		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,a.status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' 	and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' /*and a.status is null*/ and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and a.CUST_CODE =? and b.cust_group_code=? ";

//		System.out.println("valid_payer_YN_sql:"+valid_payer_YN_sql);
		pstmt = con.prepareStatement(valid_payer_YN_sql);
		
		pstmt.setString(1,strModuleId);
		pstmt.setString(2,strModuleId);
		pstmt.setString(3,strModuleId);
		pstmt.setString(4,cust_code);
		pstmt.setString(5,cust_group_code);
		
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			valid_payer_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_payer_YN=rs.getString(1);
				cust_valid_from_date = rs.getString(2);
				cust_valid_to_date = rs.getString(3);
				payer_suspended_YN = rs.getString(4);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_payer_YN_sql:"+e);
	}
	if(valid_payer_YN.equals("")) valid_payer_YN="N";
	if(cust_valid_from_date == null) cust_valid_from_date= "";
	if(cust_valid_to_date == null) cust_valid_to_date= "";

%>

<td class=<%=classval%> width='12%' ><input maxlength='15' size='13' type=text name='payer_desc<%=i%>' id='payer_desc<%=i%>'  value="<%=cust_short_name%>"readonly></td>
<input type='hidden' name='cust_3<%=i%>' id='cust_3<%=i%>' value="<%=cust_code%>">
<!--
<input type='hidden' name='ins_cust_group_name<%=i%>' id='ins_cust_group_name<%=i%>' value='<%=cust_group_name%>'>
-->
<input type='hidden' name='ins_cust_group_code<%=i%>' id='ins_cust_group_code<%=i%>' value="<%=cust_group_code%>">
<input type='hidden' name='valid_payer_YN<%=i%>' id='valid_payer_YN<%=i%>' value='<%=valid_payer_YN%>'>
<input type='hidden' name='cust_valid_from_date<%=i%>' id='cust_valid_from_date<%=i%>' value="<%=cust_valid_from_date%>">
<input type='hidden' name='cust_valid_to_date<%=i%>' id='cust_valid_to_date<%=i%>' value="<%=cust_valid_to_date%>">
<input type='hidden' name='payer_suspended_YN<%=i%>' id='payer_suspended_YN<%=i%>' value="<%=payer_suspended_YN%>">

<td class=<%=classval%> width='7%'><input type="text" maxlength='2' size="3" name='priority<%=i%>' id='priority<%=i%>' style='text-align:right'  value='<%=priority_count%>'  readonly></td> 

<%
	try
	{
		String empty_sql_check="N";
		String valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=? and  a.operating_facility_id=? /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code=? and b.cust_group_code=? and c.cust_group_code = b.cust_group_code and b.cust_code=c.cust_code and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) and b.policy_type_code=? ";
//		System.out.println("valid_policy_type_code_YN_sql:"+valid_policy_type_code_YN_sql);
		pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
		
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,cust_code);
		pstmt.setString(4,cust_group_code);
		pstmt.setString(5,strModuleId);
		pstmt.setString(6,strModuleId);
		pstmt.setString(7,strModuleId);
		pstmt.setString(8,policy_type_code);
		
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			valid_policy_type_code_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_policy_type_code_YN=rs.getString(1);
				policy_suspended_YN = rs.getString(2);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();

		if(empty_sql_check.equals("Y"))
		{
			valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=? and  a.operating_facility_id=? /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and  b.cust_group_code=? and c.cust_group_code = b.cust_group_code and b.cust_code = '**' and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) and b.policy_type_code=?";
//			System.out.println("valid_policy_type_code_YN_sql when no data found:"+valid_policy_type_code_YN_sql);
			pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
			
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,cust_group_code);
			pstmt.setString(4,strModuleId);
			pstmt.setString(5,strModuleId);
			pstmt.setString(6,strModuleId);
			pstmt.setString(7,policy_type_code);
				
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{	
				empty_sql_check="Y";
				valid_policy_type_code_YN="";
				while(rs.next())
				{
					valid_policy_type_code_YN=rs.getString(1);
					policy_suspended_YN = rs.getString(2);
				}
			}
			if(rs != null) rs.close();
			pstmt.close();
		}	
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_policy_type_code_YN_sql:"+e);
	}
	if(valid_policy_type_code_YN.equals("")) valid_policy_type_code_YN="N";

	if(!(policy_type_code.equals("") && cust_code.equals("")))
	{
	String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_code+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
//	System.out.println("restrict_check_sql:"+restrict_check_sql);
	String empty_sql_check="N";
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";

//	System.out.println("restrict_check_sql:"+restrict_check_sql);
	pstmt = con.prepareStatement(restrict_check_sql);
	rs=pstmt.executeQuery();
	if( rs != null ) 
	{
		empty_sql_check="Y";
		while(rs.next())
		{
			restrict_check=rs.getString(1);
			apprd_amt_restrict_check = rs.getString(2); 
			apprd_days_restrict_check = rs.getString(3); 
			cred_auth_req_yn = rs.getString(4); 
			dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
			cred_auth_mand_capt_yn = rs.getString(6);
			empty_sql_check="N";
		}
	}
	if(rs != null) rs.close();
	pstmt.close();
	if(empty_sql_check.equals("Y"))
	{
		restrict_check="";
		apprd_amt_restrict_check ="";
		apprd_days_restrict_check ="";
		restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code='"+cust_group_code+"'";

//		System.out.println("restrict_check_sql1:"+restrict_check_sql);
	
		pstmt = con.prepareStatement(restrict_check_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{
			while(rs.next())
			{
				restrict_check=rs.getString(1);
				apprd_amt_restrict_check = rs.getString(2); 
				apprd_days_restrict_check = rs.getString(3); 
				cred_auth_req_yn = rs.getString(4); 
				dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
				cred_auth_mand_capt_yn = rs.getString(6);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
	}
	}
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";

	if(restrict_check.equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (restrict_check.equals("R"))
	{
		if(apprd_amt_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(apprd_days_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
	
	if(cred_auth_req_yn.equals("Y"))
	{
		encounter_date = encounter_date_aft_trunc;
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		encounter_date = "";
		v_display_hide_cred_auth = "display:none";
	}
%>

<td class=<%=classval%> width='12%' ><input maxlength='15' size='13' type=text name='policy_type_desc<%=i%>' id='policy_type_desc<%=i%>'  value="<%=policy_short_desc%>" readonly></td>
<input type='hidden' name='policy_type_code<%=i%>' id='policy_type_code<%=i%>' value="<%=policy_type_code%>" ><input type='hidden' name='valid_policy_type_code_YN<%=i%>' id='valid_policy_type_code_YN<%=i%>' value='<%=valid_policy_type_code_YN%>' >
<input type='hidden' name='policy_suspended_YN<%=i%>' id='policy_suspended_YN<%=i%>' value="<%=policy_suspended_YN%>">

<td class=<%=classval%> width='12%'><input type="text" maxlength='30' size="13" name='policy_no<%=i%>' id='policy_no<%=i%>'   value=""  readonly></td>

<td class=<%=classval%> width='10%' ><input type='text'  name='policy_start_date<%=i%>' id='policy_start_date<%=i%>' size='10' maxlength='10' value=''   readonly></td>

<td class=<%=classval%> width='10%'><input type='text'  name='policy_exp_date<%=i%>' id='policy_exp_date<%=i%>' size='10' maxlength='10' value='' readonly></td>

<td class=<%=classval%> width='12%'><div id="credit_auth_val_disp<%=i%>" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="13" name='credit_auth_ref<%=i%>' id='credit_auth_ref<%=i%>'   value=""   readonly></div></td>

<td class=<%=classval%> width='11%'><div id="credit_auth_date_val_disp<%=i%>" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date<%=i%>' id='credit_auth_date<%=i%>' size='10' maxlength='10' value='<%=encounter_date_aft_trunc%>' readonly></div></td>

</tr>

<tr id=row<%=i%>>
<td class=<%=classval%> width='14%'><b id="policy_coverage_basis_<%=i%>"></b></td>
<td class=<%=classval%> width='12%' ><div id="apprd_amt_leg_disp<%=i%>" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='7%'><div id="apprd_amt_val_disp<%=i%>" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="7" name='credit_apprd_amt<%=i%>' id='credit_apprd_amt<%=i%>' style='text-align:right'  value=''  readonly></div></td>

<td  class=<%=classval%> width='12%'  ><div id="apprd_days_leg_disp<%=i%>" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
<td class=<%=classval%> width='12%'><div id="apprd_days_val_disp<%=i%>" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days<%=i%>' id='credit_apprd_days<%=i%>' style='text-align:right'  value=''  readonly></div></td>
	
<td class=<%=classval%> width='10%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='10%'><input type='text'  name='policy_eff_frm_date<%=i%>' id='policy_eff_frm_date<%=i%>' size='10' maxlength='10' value='' readonly></td>

<td class=<%=classval%> width='12%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
<td class=<%=classval%> width='11%'><input type='text'  name='policy_eff_to_date<%=i%>' id='policy_eff_to_date<%=i%>' size='10' maxlength='10' value='' readonly></td>
</tr>
<input type=hidden name='adj_rule_ind<%=i%>' id='adj_rule_ind<%=i%>' value="<%=adj_rule_ind%>">
<input type=hidden name='adj_perc_amt_ind<%=i%>' id='adj_perc_amt_ind<%=i%>' value="<%=adj_perc_amt_ind%>">
<input type=hidden name='adj_perc_amt_value<%=i%>' id='adj_perc_amt_value<%=i%>' value="<%=adj_perc_amt_value%>">
<input type=hidden name='pmnt_diff_adj_int<%=i%>' id='pmnt_diff_adj_int<%=i%>' value="<%=pmnt_diff_adj_int%>">
<input type=hidden name='drg_pmnt_diff_adj_int<%=i%>' id='drg_pmnt_diff_adj_int<%=i%>' value="<%=drg_pmnt_diff_adj_int%>">
<input type=hidden name='spl_srv_pmnt_diff_adj_int<%=i%>' id='spl_srv_pmnt_diff_adj_int<%=i%>' value="<%=spl_srv_pmnt_diff_adj_int%>">
<input type=hidden name='restrict_check<%=i%>' id='restrict_check<%=i%>' value="<%=restrict_check%>">
<input type=hidden name='apprd_amt_restrict_check<%=i%>' id='apprd_amt_restrict_check<%=i%>' value='<%=apprd_amt_restrict_check%>'>
<input type=hidden name='apprd_days_restrict_check<%=i%>' id='apprd_days_restrict_check<%=i%>' value='<%=apprd_days_restrict_check%>'>
<input type=hidden name='policy_coverage_basis_ind<%=i%>' id='policy_coverage_basis_ind<%=i%>' value='<%=policy_coverage_basis_ind%>'>
<input type=hidden name='cred_auth_req_yn<%=i%>' id='cred_auth_req_yn<%=i%>' value='<%=cred_auth_req_yn%>'>
<input type=hidden name='cred_auth_mand_capt_yn<%=i%>' id='cred_auth_mand_capt_yn<%=i%>' value='<%=cred_auth_mand_capt_yn%>'>
<input type=hidden name='dflt_auth_ref_as_pol_no_yn<%=i%>' id='dflt_auth_ref_as_pol_no_yn<%=i%>' value='<%=dflt_auth_ref_as_pol_no_yn%>'>
<input type=hidden name='pol_validity_chk_date<%=i%>' id='pol_validity_chk_date<%=i%>' value="<%=pol_validity_chk_date%>">
<input type='hidden' name='rec_edited_YN<%=i%>' id='rec_edited_YN<%=i%>' value='<%=rec_edited_YN%>'>
<input type='hidden' name='mcn_for_policy<%=i%>' id='mcn_for_policy<%=i%>' value=''>  <!-- V232504 -->
<input type='hidden' name='reg_ref_id<%=i%>' id='reg_ref_id<%=i%>' value=''>  <!-- V232504 -->

<%
		i++;
		}
		totalRecords=i;
		if(rs2 != null) rs2.close();
		pstmt.close();	
	}
}
%>



<input type='hidden' name='total_records' id='total_records' value='<%=totalRecords%>'>
<input type='hidden' name='checked_row' id='checked_row' value='' >
<input type='hidden' name='focussed_row' id='focussed_row' value='' >
<input type='hidden' name='billing_group' id='billing_group' value="<%=billing_group%>" >
<input type="hidden" name="policy_coverage_basis_gbl_ind" id="policy_coverage_basis_gbl_ind" value='<%=policy_coverage_basis_gbl_ind%>' >
<input type="hidden" name="policy_coverage_basis_gbl_ind_from_main" id="policy_coverage_basis_gbl_ind_from_main"  value='<%=policy_coverage_basis_gbl_ind_from_main%>'>
<input type="hidden" name='max_priority' id='max_priority' value='<%=max_priority%>' >
<input type="hidden" name='locale' id='locale' value='<%=locale%>' >
<input type="hidden" name='calling_module_id' id='calling_module_id' value='<%=strModuleId%>' >

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>

<input type='hidden' name='mcn_for_policy' id='mcn_for_policy' value=''>  <!-- V232504 -->
<input type='hidden' name='reg_ref_id' id='reg_ref_id' value=''>  <!-- V232504 -->


</tbody>
</table>
</div>
</form>

</body>
</html>

<%
	}
	catch(Exception e )
	{ 
		System.out.println("Main Exception:"+e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

