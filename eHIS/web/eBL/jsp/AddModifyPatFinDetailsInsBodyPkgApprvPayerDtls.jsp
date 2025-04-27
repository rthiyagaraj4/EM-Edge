<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<%
try
	{
		
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src='../../eBL/js/AddModifyPatFinDetailsInsBodyPkgApprvDtls.js'></script> 
<script language="javascript" src='../../eBL/js/AddModifyPatFinDetailsInsPkgDiscDtls.js'></script> 
<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
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

<% 
		Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
			System.err.println("Query String="+request.getQueryString());
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		= (String) session.getValue( "facility_id" ) ;
		int totRec=1;
		String patient_id = request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;	
		String calling_module_id = request.getParameter("calling_module_id") == null ? "" :request.getParameter("calling_module_id");	
		String encounter_date = request.getParameter("encounter_date") == null ? "" :request.getParameter("encounter_date") ;	
		String encounter_date_time = request.getParameter("encounter_date_time") == null ? "" :request.getParameter("encounter_date_time") ;	
		String encounter_date_aft_trunc = request.getParameter("encounter_date_aft_trunc") == null ? "" :request.getParameter("encounter_date_aft_trunc") ;	
		String action= request.getParameter("action") == null ? "" :request.getParameter("action") ;	
		String payer_grp_code= request.getParameter("payer_grp_code") == null ? "" :request.getParameter("payer_grp_code") ;	
		String payer_code= request.getParameter("payer_code") == null ? "" :request.getParameter("payer_code") ;	
		String blng_grp_code= request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;	
		String policy_type_code= request.getParameter("policy_type_code") == null ? "" :request.getParameter("policy_type_code") ;	
		String policy_no= request.getParameter("policy_no") == null ? "" :request.getParameter("policy_no") ;	
		String policy_eff_frm_date= request.getParameter("policy_eff_frm_date") == null ? "" :request.getParameter("policy_eff_frm_date") ;	
		String priority= request.getParameter("priority") == null ? "" :request.getParameter("priority") ;	
	
		String hdr_appr_seq_no= request.getParameter("hdr_appr_seq_no") == null ? "1" :request.getParameter("hdr_appr_seq_no") ;	// IN 20964
		String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		String sysDate="",noofdecimal="";
			try{
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getString(1);		
			}			
		}catch(Exception e)
			{
				System.out.println("Exception no. of decimal :"+e);
				e.printStackTrace();
			}
			if(rs!=null) rs=null;
			if(pstmt!=null)pstmt=null;
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			pstmt = con.prepareStatement(query_date);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				if( rs.next() )
					sysDate = rs.getString(1); 
			}
		if (rs != null)   rs.close();
		if (pstmt != null)   pstmt.close();
		}		
		catch(Exception e)
		{
			System.out.println("Exception @ sysdate  :"+e);
			e.printStackTrace();
		}
%>
	
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
	<form name='PayerDtls' id='PayerDtls' action="" method="post" target="messageFrame" >	
	<table class='grid' width='100%' id="PayerDtls_tbl">
	<tr >
		<td  class='COLUMNHEADER' >&nbsp;</td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.packageApprovals.label" bundle="${bl_labels}"/></td>	
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Add.label" bundle="${common_labels}"/></td>
	</tr>
<%

		String appr_seq_no="";// added for IN 20964
		String credit_auth_ref="";
		String credit_auth_date="";
		String credit_apprd_amt="";
		String episode_type="";
		String restrict_check_sql="";
		String empty_sql_check="N";
		String restrict_check="";
		String apprd_amt_restrict_check = "";
		String apprd_days_restrict_check = "";
		String cred_auth_req_yn = "";
		String	dflt_auth_ref_as_pol_no_yn = "";
		String	disable_credit_auth = "";
		String	disable_credit_apprd_days = "";
		String	disable_credit_apprd_amt = "";
		String	credit_apprd_days="";
		String	pol_validity_chk_date="";
		String	pkg_dtls_yn="";					
		payer_grp_code=request.getParameter("payer_grp_code");
		payer_code=request.getParameter("payer_code");

		if(calling_module_id.equals("MP")) episode_type="R";
		else if(calling_module_id.equals("AE")) episode_type="E";
		else if(calling_module_id.equals("OP")) episode_type="O";
		else if(calling_module_id.equals("IP")) episode_type="I";
		else if(calling_module_id.equals("DC")) episode_type="D";
		try
			{
				restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U') , DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = ? and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code=?";
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(restrict_check_sql);
				pstmt.setString(1, episode_type);
				pstmt.setString(2, episode_type);
				pstmt.setString(3, episode_type);
				pstmt.setString(4, episode_type);
				pstmt.setString(5, episode_type);
				pstmt.setString(6, facility_id);
				pstmt.setString(7, policy_type_code);
				pstmt.setString(8, payer_grp_code);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{	
					empty_sql_check="Y";
					while(rs.next())
					{
						restrict_check = rs.getString(1);
						apprd_amt_restrict_check = rs.getString(2); 
						apprd_days_restrict_check = rs.getString(3); 
						cred_auth_req_yn = rs.getString(4); 
						dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
						empty_sql_check="N";
					}
				}
			if (rs != null)   rs.close();
			pstmt.close();

			if(empty_sql_check.equals("Y"))
			{
				restrict_check="";
				restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = '**' and a.cust_group_code =?";

				pstmt = con.prepareStatement(restrict_check_sql);
				pstmt.setString(1, episode_type);
				pstmt.setString(2, episode_type);
				pstmt.setString(3, episode_type);
				pstmt.setString(4, episode_type);
				pstmt.setString(5, episode_type);
				pstmt.setString(6, facility_id);
				pstmt.setString(7, policy_type_code);
				pstmt.setString(8, payer_grp_code);
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
					}
				}
				if (rs != null)   rs.close();
				pstmt.close();
			}
		}
		catch(Exception e)
		{
			out.println("Exception in restrict_check_sql:"+e);
			e.printStackTrace();
		}
	if(con!=null) ConnectionManager.returnConnection(con);
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";
	//String currMapKey=blng_grp_code+"~~"+payer_grp_code+"~~"+payer_code+"~~"+priority+"~~"+policy_type_code+"~~"+policy_no+"~~"+policy_eff_frm_date;
	String oldMapKey=request.getParameter("oldMapKey") == null ? "" :request.getParameter("oldMapKey") ;	
		/*
			String mapKey=blng_grp_code+"~~"+payer_grp_code+"~~"+payer_code+"~~"+priority+"~~"+policy_type_code+"~~"+policy_no+"~~"+policy_eff_frm_date
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
	ArrayList payer=(ArrayList)payerDtls.get(mapKey);//'details' member in bean contains this value
		HashMap hdrDtls=	(HashMap)payer.get(0);//contains Hdr dtls
		HashMap authDtls=	(HashMap)payer.get(1);// contains Credit_auth_ref dtls,appr_seq_no is key
		HashMap pkgApprovals=	(HashMap)payer.get(2);// contains pkg approvals for each appr_seq_no
		authDtls ==>;appr_seq_no as key, value is a record[] =>appr_seq_no(String), credit_auth_ref(String),credit_auth_date(String),credit_auth_amt(String),credit_apprd_days(String),pkg_approval_yn(String),pol_validity_chk_date(String)
		pkgApprovals; // appr_seq_no is key and Arraylist =>each value is a String[]=>pkg_seq_no(String),pkg_code(String),pkg_desc(String), appv_amt(String)
	*/
	HashMap payerDtls=(HashMap)bean.getPayerDtls();
	ArrayList payer=new ArrayList();
	payer=(ArrayList)bean.getDetails();
	HashMap authDtls=new HashMap();
	ArrayList	creditAuthDtls=new ArrayList();
	Set<String> authDtlsSet;
	if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(oldMapKey)){		
		payer=bean.getPayerCopy((ArrayList)payerDtls.get(oldMapKey));
		bean.setDetails(payer);
	}
	if(payer!=null && payer.size()>0){
		authDtls=	(HashMap)payer.get(1);	
	}

	
	authDtlsSet=(Set<String>)authDtls.keySet();
	
	Iterator<String> authIt=authDtlsSet.iterator();
	if(authDtls!=null && authDtls.size() >0){
			totRec = authDtls.size();		
		//if(!authDtlsSet.contains(hdr_credit_auth_ref))//IN 20964
		if(!authDtlsSet.contains(hdr_appr_seq_no))//IN 20964
		{
			totRec++;
		}
	}
	String authKey="";
	for(int i=0; i<totRec; i++)
	{	
		/**************************/
	//	if(i==0 && (authDtls==null || authDtls.size()==0) )				
		if(authDtls==null || authDtls.size()==0 ){		
			appr_seq_no		=hdr_appr_seq_no; // IN 20964 , this will always be 1
			credit_auth_ref=request.getParameter("credit_auth_ref");
			if(credit_auth_ref==null || credit_auth_ref.equals(" ")) credit_auth_ref="";

			credit_auth_date=request.getParameter("credit_auth_date");
			if(credit_auth_date==null || credit_auth_date.equals(" ")) credit_auth_date="";
			
			credit_apprd_amt=request.getParameter("credit_apprd_amt");
			if(credit_apprd_amt==null || credit_apprd_amt.equals(" ")) credit_apprd_amt="";
			
			credit_apprd_days=request.getParameter("credit_apprd_days");
			if(credit_apprd_days==null || credit_apprd_days.equals(" ")) credit_apprd_days="";
			
			pol_validity_chk_date=request.getParameter("pol_validity_chk_date");
			if(pol_validity_chk_date==null || pol_validity_chk_date.equals(" ")) pol_validity_chk_date="";
		}else if(authDtls!=null && authDtls.size()>0 ){
			if(i==0){		
			//	authKey=hdr_credit_auth_ref;//IN 20964
				authKey=hdr_appr_seq_no;// IN 20964
					if(authDtlsSet.contains(authKey)){
						creditAuthDtls=(ArrayList)authDtls.get(authKey);
						/*pkg_dtls_yn=(String)creditAuthDtls.get(4);
						pol_validity_chk_date=(String)creditAuthDtls.get(5);*///IN 20964
						pkg_dtls_yn=(String)creditAuthDtls.get(5);// IN 20964
						pol_validity_chk_date=(String)creditAuthDtls.get(6);// IN 20964
					}else{						
						pkg_dtls_yn="N";
						pol_validity_chk_date="";
					}
				appr_seq_no=hdr_appr_seq_no;// IN 20964, this will always be 1
				credit_auth_ref=request.getParameter("credit_auth_ref");
				if(credit_auth_ref==null || credit_auth_ref.equals(" ")) credit_auth_ref="";

				credit_auth_date=request.getParameter("credit_auth_date");
				if(credit_auth_date==null || credit_auth_date.equals(" ")) credit_auth_date="";
			
				credit_apprd_amt=request.getParameter("credit_apprd_amt");
				if(credit_apprd_amt==null || credit_apprd_amt.equals(" ")) credit_apprd_amt="";
			
				credit_apprd_days=request.getParameter("credit_apprd_days");
				if(credit_apprd_days==null || credit_apprd_days.equals(" ")) credit_apprd_days="";
			
				pol_validity_chk_date=request.getParameter("pol_validity_chk_date");
				if(pol_validity_chk_date==null || pol_validity_chk_date.equals(" ")) pol_validity_chk_date="";

			}else{			
				if(authIt.hasNext()){
					authKey=(String)authIt.next();	
				//	if(authKey.equals(hdr_credit_auth_ref)) //IN 20964
					if(authKey.equals(hdr_appr_seq_no))//IN 20964
					{
						if(authIt.hasNext()){
							authKey=(String)authIt.next();
						}else{
							break;
						}
					}
				}
				creditAuthDtls=(ArrayList)authDtls.get(authKey);
				appr_seq_no=(String)creditAuthDtls.get(0);
				credit_auth_ref=(String)creditAuthDtls.get(1);
				credit_auth_date=(String)creditAuthDtls.get(2);
				credit_apprd_amt=(String)creditAuthDtls.get(3);
				credit_apprd_days=(String)creditAuthDtls.get(4);	
				pkg_dtls_yn=(String)creditAuthDtls.get(5);
				pol_validity_chk_date=(String)creditAuthDtls.get(6);				
			}
				
		
			
		}


	if(restrict_check.equals("R"))
	{
		disable_credit_apprd_amt="";
		
		if(apprd_amt_restrict_check.equals("U"))
		{
			disable_credit_apprd_amt = "disabled";
			credit_apprd_amt="";
		}
		if(apprd_days_restrict_check.equals("U"))
		{
			disable_credit_apprd_days = "disabled";
			credit_apprd_days="";
		}
		
	}
	else if(restrict_check.equals("U"))
	{
		disable_credit_apprd_amt="disabled";
		credit_apprd_amt="";
		disable_credit_apprd_days = "disabled";
		credit_apprd_days="";

	}
	if(cred_auth_req_yn.equals("Y"))
	{
		disable_credit_auth = "";
		if(dflt_auth_ref_as_pol_no_yn.equals("Y"))
		{
			if(!policy_no.equals("") && credit_auth_ref.equals(""))
			{
				int policy_no_len = policy_no.length();
				if(policy_no_len <=20 )
					credit_auth_ref = policy_no.substring(0,policy_no_len);
				else
					credit_auth_ref = policy_no.substring(0,20);
			}
		}
		if(credit_auth_date.equals(""))
		{
			credit_auth_date = encounter_date_aft_trunc;
		}
	}
	else
	{
		disable_credit_auth = "disabled";
		credit_auth_ref = "";
		credit_auth_date = "";
	}
	/*String readOnly="";
	String disabled="";
	if(i==0){
	readOnly="readonly";
	disabled="disabled";
	}*/

%>
			<tr >				
	<td class='fields'><%=appr_seq_no%><input type='hidden' name="appr_seq_no<%=i%>" id="appr_seq_no<%=i%>" value="<%=appr_seq_no%>"></td>
	
	<td class='fields'><input type="text" maxlength='20' size="17" name='credit_auth_ref<%=i%>' id='credit_auth_ref<%=i%>' value="<%=credit_auth_ref%>" onBlur="chkCreditAuthRef(this,'<%=i%>');" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event);'  <%=disable_credit_auth%>><input type="hidden" name="temp_credit_auth_ref<%=i%>" id="temp_credit_auth_ref<%=i%>" value="<%=credit_auth_ref%>"></td>

	<td class='fields' ><input type='text'  name='credit_auth_date<%=i%>' id='credit_auth_date<%=i%>' size='10' maxlength='10' value='<%=credit_auth_date%>' onBlur="return chkPayerCreditAuthDate(this,'<%=i%>');"   <%=disable_credit_auth%> ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('credit_auth_date<%=i%>',credit_auth_date<%=i%>);"  <%=disable_credit_auth%> ></td>

	<td class='fields' ><input type="text" maxlength='10' size="15" name='credit_apprd_amt<%=i%>' id='credit_apprd_amt<%=i%>' style='text-align:right'  value='<%=credit_apprd_amt%>'  onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='return CheckPayerSplApprAmt(this,"<%=i%>")'  <%=disable_credit_apprd_amt%>></td>

	<td class='fields'><input type="text" maxlength='2' size="3" name='credit_apprd_days<%=i%>' id='credit_apprd_days<%=i%>' style='text-align:right'  value='<%=credit_apprd_days%>' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckSplApprDays(this,"<%=i%>")' <%=disable_credit_apprd_days%>></td>
	<td  class='fields' ><input type="checkbox" name='pkg_dtls_yn<%=i%>' id='pkg_dtls_yn<%=i%>' value='<%=pkg_dtls_yn%>' onClick="getPkgDtls(this,'<%=i%>');" <%=pkg_dtls_yn.equals("Y")?"checked":""%> >
	<%if(pkg_dtls_yn.equals("Y")){%>
	<a name='pkg_apprv_dtls<%=i%>' href='#' onClick='showPkgApprvDtls("<%=i%>");'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
	<%}%>
	</td>
	<td  class='fields'  ><%if(i==0){%><a name='addRow<%=i%>'  href='#' onClick="addRow('PayerDtls');">+</a><%}%><input type='hidden' name='pol_validity_chk_date<%=i%>' id='pol_validity_chk_date<%=i%>' value='<%=pol_validity_chk_date%>' ></td>	

</tr>
		<%} %>
		</table>	
		<input type=hidden name='restrict_check' id='restrict_check' value='<%=restrict_check%>' >
		<input type=hidden name='apprd_amt_restrict_check' id='apprd_amt_restrict_check' value='<%=apprd_amt_restrict_check%>' >
		<input type=hidden name='apprd_days_restrict_check' id='apprd_days_restrict_check' value='<%=apprd_days_restrict_check%>' >
		<input type=hidden name='cred_auth_req_yn' id='cred_auth_req_yn' value='<%=cred_auth_req_yn%>' >
		<input type=hidden name='dflt_auth_ref_as_pol_no_yn' id='dflt_auth_ref_as_pol_no_yn' value='<%=dflt_auth_ref_as_pol_no_yn%>' >
			
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='total_records' id='total_records' value="<%=totRec%>" >
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
		<input type='hidden' name='sysDate' id='sysDate' value="<%=sysDate%>" >
		<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
		<input type='hidden' name='calling_module_id' id='calling_module_id' value="<%=calling_module_id%>" >
		<input type='hidden' name='encounter_date' id='encounter_date' value="<%=encounter_date%>" >
		<input type='hidden' name='encounter_date_time' id='encounter_date_time' value="<%=encounter_date_time%>" >
		<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value="<%=encounter_date_aft_trunc%>" >
		<input type='hidden' name='payer_grp_code' id='payer_grp_code' value="<%=payer_grp_code%>" >
		<input type='hidden' name='payer_code' id='payer_code' value="<%=payer_code%>" >
		<input type='hidden' name='action' id='action' value="<%=action%>" >
		<input type='hidden' name='form_name' id='form_name' value="PayerDtls" >
		<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" >
		<input type='hidden' name='policy_type_code' id='policy_type_code' value="<%=policy_type_code%>" >
		<input type='hidden' name='policy_no' id='policy_no' value="<%=policy_no%>" >
		<input type='hidden' name='policy_eff_frm_date' id='policy_eff_frm_date' value="<%=policy_eff_frm_date%>" >
		<input type='hidden' name='priority' id='priority' value="<%=priority%>" >
		<input type='hidden' name='oldMapKey' id='oldMapKey' value="<%=oldMapKey%>" >


</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from AddModifyPatFinDetailsInsBodyPkgApprvPayerDtls.jsp  :"+e);
	e.printStackTrace();
}

%>



