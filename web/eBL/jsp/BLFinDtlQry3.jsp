<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.Common.BLHelper"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* ,webbeans.op.CurrencyFormat,java.io.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	CallableStatement call =null;
	String facility_id = "";
	String login_user = "";
	String episodetype=""; 	String episodeid =""; String visitid=""; String patientid=""; 
	String serv_disc_amt=""; String other_disc_amt=""; 	String unbilled_amt = ""; 	String outst_amt =  "";
	String deposit_amt =  ""; 	String prepay_amt =  ""; 	String refundable_deposit_amt =  "";
	String surgery_deposit_amt =  ""; 	String pkg_deposit_amt =  ""; 	String strSetInd = "";
	String strAdmFlag = ""; 	String strFamIn = ""; 	String strFamAss  = ""; 	String strNoDep = "";
	String strNonInsBlGrId = ""; String strNonInsCustCode = ""; String strGLHol  = ""; 	String strPatRel  = "";
	String strBillGrp = ""; String strPatRelGL = ""; String strCrdDocRef = ""; 	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = ""; String strResPay  = ""; String strPatRelnRespPers=""; //String strAllParam = "";
	String short_desc=""; String customerid=""; String customergroup="";
	String gross_amt="";
	String noninsbillinggroup="";  String noninssettlementind=""; String noninsadmrecflag="";
    String noninscustomername=""; String strslmttypecode="";
	String strcustcode ="";
	String str_non_ins_referral_source_code_flag ="N", str_non_ins_ref_src_main_desc = "", str_non_ins_ref_src_sub_desc = "";
	
	String str_non_ins_ref_src_main_code="", str_non_ins_ref_src_sub_code="";
	String str_non_ins_ref_src_main_lng_name="", str_non_ins_ref_src_sub_lng_name="";
	
//	int intNoDep=0; 
	int noofdecimal = 2;
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ResultSet rs3 = null;
	String sql1=""; String sql2="";
	String sqlchrdet1=""; String sqlchrdet2=""; String sqlchrdet3=""; String sqlchrdet4=""; String sqlcust="";
	
	String outstAmtAllEnc = ""; //Variables created by Subha on V07022018 for ML-MMOH-CRF-0757
	String unbilledAmtAllEnc = ""; //Variables created by Subha on V07022018 for ML-MMOH-CRF-0757
	String siteId = BLReportIdMapper.getCustomerId();
	String locale	= (String)session.getAttribute("LOCALE");

	
	request.setCharacterEncoding("UTF-8");

	try
	{
		con = ConnectionManager.getConnection(request);

		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		episodetype =request.getParameter("episodetype");
		if(episodetype==null) episodetype="";
		episodeid = request.getParameter("episodeid");
		if(episodeid==null) episodeid="";
		visitid = request.getParameter("visitid");
		if(visitid==null) visitid="";
		patientid = request.getParameter("patientid");
		if(patientid==null) patientid="";
		strBillGrp = request.getParameter("strBillGrp");		
		if(strBillGrp==null) strBillGrp="";
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		strAdmFlag = request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="";
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
		if (strCrdDocRef == null) strCrdDocRef = "";
		
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null ) strCrDocRefStDate="";
		if(!strCrDocRefStDate.equals(""))
		{
			strCrDocRefStDate=com.ehis.util.DateUtils.convertDate(strCrDocRefStDate,"DMY","en",locale);
		}

		strCrDocRefEndDate = request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null ) strCrDocRefEndDate="";
		if(!strCrDocRefEndDate.equals(""))
		{
			strCrDocRefEndDate=com.ehis.util.DateUtils.convertDate(strCrDocRefEndDate,"DMY","en",locale);
		}

		strResPay =	request.getParameter("strResPay");
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		strslmttypecode = request.getParameter("strslmttypecode");
		strcustcode = 	request.getParameter("strcustcode");

		str_non_ins_referral_source_code_flag =	request.getParameter("non_ins_referral_source_code_flag");
		if( str_non_ins_referral_source_code_flag == null) str_non_ins_referral_source_code_flag="";

//		str_non_ins_ref_src_main_desc =	request.getParameter("non_ins_ref_src_main_desc");
//		if( str_non_ins_ref_src_main_desc == null) str_non_ins_ref_src_main_desc="";

//		str_non_ins_ref_src_sub_desc = request.getParameter("non_ins_ref_src_sub_desc");
//		if( str_non_ins_ref_src_sub_desc == null) str_non_ins_ref_src_sub_desc="";

		str_non_ins_ref_src_main_code = request.getParameter("non_ins_ref_src_main_code");
		if( str_non_ins_ref_src_main_code == null) str_non_ins_ref_src_main_code="";

		str_non_ins_ref_src_sub_code  = request.getParameter("non_ins_ref_src_sub_code");
		if( str_non_ins_ref_src_sub_code == null) str_non_ins_ref_src_sub_code="";

		episodetype=episodetype.trim();
		visitid=visitid.trim();
		episodeid=episodeid.trim();
		patientid=patientid.trim();

//		intNoDep=Integer.parseInt(strNoDep);		
		
		if(!str_non_ins_ref_src_main_code.equals(""))
		{
			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_non_ins_ref_src_main_code);
			call.setString(3,locale);
			call.setString(4,"1");

			call.execute();							
			str_non_ins_ref_src_main_desc = call.getString(1);				
			call.close();
			if ( str_non_ins_ref_src_main_desc == null ) str_non_ins_ref_src_main_desc = "";

			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_non_ins_ref_src_main_code);
			call.setString(3,locale);
			call.setString(4,"3");

			call.execute();							
			str_non_ins_ref_src_main_lng_name = call.getString(1);				
			call.close();
			if ( str_non_ins_ref_src_main_lng_name == null ) str_non_ins_ref_src_main_lng_name = "";
		}

		if(!str_non_ins_ref_src_sub_code.equals(""))
		{
			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_non_ins_ref_src_sub_code);
			call.setString(3,locale);
			call.setString(4,"1");

			call.execute();							
			str_non_ins_ref_src_sub_desc = call.getString(1);				
			call.close();
			if ( str_non_ins_ref_src_sub_desc == null ) str_non_ins_ref_src_sub_desc = "";

			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_non_ins_ref_src_sub_code);
			call.setString(3,locale);
			call.setString(4,"3");

			call.execute();							
			str_non_ins_ref_src_sub_lng_name = call.getString(1);				
			call.close();
			if ( str_non_ins_ref_src_sub_lng_name == null ) str_non_ins_ref_src_sub_lng_name = "";
		}

		try
		{
			if(!strNonInsBlGrId.equals(""))
			{	
				sql1="SELECT short_desc non_ins_billing_group, "+
			 		 "settlement_ind non_ins_settlement_ind, "+             		
					 "adm_rec_flag non_ins_adm_rec_flag		"+
					 "FROM bl_blng_grp_lang_vw "+
					 "WHERE blng_grp_id = '"+strNonInsBlGrId+"' "+
					 "AND language_id = '"+locale+"' ";

				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery() ;

				while(rs.next())
				{
					noninsbillinggroup=rs.getString(1);
					noninssettlementind=rs.getString(2);
					noninsadmrecflag=rs.getString(3);
				}
				rs.close();
				pstmt.close();
			}	//closing if 
			
		}	//closing try
		catch(Exception e)
		{
			System.out.println("Exception in Non ins blng_grp Query:"+e.toString());
		}

		try
		{
			if (!strNonInsCustCode.equals(""))
			{	
				sql2="SELECT short_name non_ins_customer_name "+
					 " FROM ar_customer_lang_vw "+
			  		 " WHERE cust_code = '"+strNonInsCustCode+"' "+
					 " AND language_id = '"+locale+"' "; 
		
				pstmt = con.prepareStatement(sql2);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					noninscustomername=rs.getString(1);
				}
				rs.close();
				pstmt.close();
			}// closing if
			
		}//closing  try
		catch(Exception e)
		{
			System.out.println("Exception in non_ins_cust_code query:"+e.toString());
		}

		try
		{
			sqlchrdet1="SELECT SUM(a.upd_gross_charge_amt) gross_amt, "+          
					   "  SUM(a.upd_disc_amt) serv_disc_amt,  "+
					   "  SUM(NVL(a.bill_level_disc_dstrbtn_amt,0))+  "+           
					   " SUM(NVL(a.line_level_disc_dstrbtn_amt,0)) other_disc_amt  "+
					   " FROM bl_patient_charges_folio a   "+
					   " WHERE a.operating_facility_id =  '"+facility_id+"' "+
					   " AND a.episode_type =  '"+episodetype+"'  "+
					   " AND ((a.patient_id = '"+facility_id+"' AND a.episode_type = 'R') OR  "+
					   " (a.episode_id = '"+episodeid+"' AND a.visit_id = '"+visitid+"' AND a.episode_type IN ('O','E')) OR "+
					   " (a.episode_id =  '"+episodeid+"' AND a.episode_type IN ('I','D')))";
//			System.err.println("sqlchrdet1:"+sqlchrdet1);
			pstmt = con.prepareStatement(sqlchrdet1);
			rs = pstmt.executeQuery() ;
			while(rs.next())
			{
				gross_amt = rs.getString(1);
				serv_disc_amt = rs.getString(2);
				other_disc_amt = rs.getString(3);
	
			}
			if (gross_amt == null) gross_amt = "";
			if (serv_disc_amt == null) serv_disc_amt = "";
			if (other_disc_amt == null) other_disc_amt = "";
//			System.out.println("gross_amt:"+gross_amt);

			rs.close();
			pstmt.close();
		}//try
		catch(Exception e)
		{
			System.out.println("Exception in gross amt query:"+e.toString());
		}

		try
		{
			if(episodetype.equals("R")) 
			{
				sqlchrdet2 = "SELECT NVL(tot_unbld_op_amt,0)+NVL(tot_unbld_ip_amt,0)+NVL(tot_unbld_ref_amt,0) unbilled_amt,"+"NVL(tot_outst_op_amt,0)+NVL(tot_outst_ip_amt,0)+ NVL(tot_outst_ref_amt,0) outst_amt,"+"NVL(tot_unadj_dep_op_amt,0)+NVL(tot_unadj_dep_ip_amt,0)+NVL(tot_unadj_dep_ref_amt,0) deposit_amt,"+"NVL(tot_unadj_prep_op_amt,0)+NVL(tot_unadj_prep_ip_amt,0)+NVL(tot_unadj_prep_ref_amt,0) prepay_amt,"+"NVL(tot_refund_dep_op_amt,0)+NVL(tot_refund_dep_ip_amt,0)+NVL(tot_refund_dep_ref_amt,0)refundable_deposit_amt,"+"0 surgery_deposit_amt,"+"0 pkg_deposit_amt"+" FROM bl_patient_fin_dtls"+" WHERE patient_id  = '"+patientid+"'";

				pstmt = con.prepareStatement(sqlchrdet2);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					unbilled_amt = rs.getString(1);
					outst_amt = rs.getString(2);
					deposit_amt = rs.getString(3);
					prepay_amt = rs.getString(4);
					refundable_deposit_amt = rs.getString(5);
					surgery_deposit_amt = rs.getString(6);
					pkg_deposit_amt = rs.getString(7);
				}

				if (unbilled_amt == null) unbilled_amt = "";
				if (outst_amt == null) outst_amt = "";
				if (deposit_amt == null) deposit_amt = "";
				if (prepay_amt == null) prepay_amt = "";
				if (refundable_deposit_amt == null) refundable_deposit_amt = "";
				if (surgery_deposit_amt == null) surgery_deposit_amt = "";
				if (pkg_deposit_amt == null) pkg_deposit_amt = "";
				rs.close();
				pstmt.close();
			}//closing if
			
		}	//try
		catch(Exception e) 
		{
			System.out.println("Exception in Amount Query with MP flag:"+e.toString());
		}

		try
		{
			if((episodetype.equals("O")) ||(episodetype.equals("E")) )
			{
				sqlchrdet3="SELECT NVL(tot_unbld_amt,0) unbilled_amt,      "+          
						   " NVL(tot_outst_amt,0)  outst_amt, "+
						   "  NVL(tot_unadj_dep_amt,0) deposit_amt, "+
						   " NVL(tot_unadj_prep_amt,0) prepay_amt, "+
		    			   " NVL(tot_refund_dep_amt,0) refundable_deposit_amt, "+
						   "  0 surgery_deposit_amt, "+
						   "  0 pkg_deposit_amt "+
					       " FROM bl_visit_fin_dtls  "+
				           " WHERE operating_facility_id = '"+facility_id+"' "+
				           " AND episode_type = '"+episodetype+"'  "+
				           " AND episode_id = '"+episodeid+"' "+
				           " AND visit_id ='"+visitid+"' ";
	
				pstmt = con.prepareStatement(sqlchrdet3);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					unbilled_amt = rs.getString(1);
	 				outst_amt = rs.getString(2);
			 		deposit_amt = rs.getString(3);
	 				prepay_amt = rs.getString(4);
			 		refundable_deposit_amt = rs.getString(5);
	 				surgery_deposit_amt = rs.getString(6);
			 		pkg_deposit_amt = rs.getString(7);
				}

				if (unbilled_amt == null) unbilled_amt = "";
				if (outst_amt == null) outst_amt = "";
				if (deposit_amt == null) deposit_amt = "";
				if (prepay_amt == null) prepay_amt = "";
				if (refundable_deposit_amt == null) refundable_deposit_amt = "";
				if (surgery_deposit_amt == null) surgery_deposit_amt = "";
				if (pkg_deposit_amt == null) pkg_deposit_amt = "";

				rs.close();
				pstmt.close();
			}//if
			
		}//try
		catch(Exception e)
		{
			System.out.println("Exception in Amount Query with OP AE flag:"+e.toString());
		}
	
		try
		{
			if((episodetype.equals("I")) ||(episodetype.equals("D")))
			{
				sqlchrdet4="SELECT NVL(tot_unbld_amt,0) unbilled_amt,  "+              
						   " NVL(tot_outst_amt,0)  outst_amt,  "+
						   " NVL(tot_unadj_dep_amt,0) deposit_amt,"+
						   " NVL(tot_unadj_prep_amt,0) prepay_amt,"+
						   " NVL(tot_refund_dep_amt,0) refundable_deposit_amt,"+
						   " 0 surgery_deposit_amt,"+
						   " 0 pkg_deposit_amt"+
						   " FROM bl_episode_fin_dtls "+
						   " WHERE operating_facility_id = '"+facility_id+"'"+
						   " AND episode_type = '"+episodetype+"'  "+
						   " AND episode_id =  '"+episodeid+"' "; 
		
				pstmt = con.prepareStatement(sqlchrdet4);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					unbilled_amt = rs.getString(1);
					outst_amt = rs.getString(2);
					deposit_amt = rs.getString(3);
					prepay_amt = rs.getString(4);
					refundable_deposit_amt = rs.getString(5);
					surgery_deposit_amt = rs.getString(6);
					pkg_deposit_amt = rs.getString(7);
				}

				if (unbilled_amt == null) unbilled_amt = "";
				if (outst_amt == null) outst_amt = "";
				if (deposit_amt == null) deposit_amt = "";
				if (prepay_amt == null) prepay_amt = "";
				if (refundable_deposit_amt == null) refundable_deposit_amt = "";
				if (surgery_deposit_amt == null) surgery_deposit_amt = "";
				if (pkg_deposit_amt == null) pkg_deposit_amt = "";
		
				rs.close();
				pstmt.close();
			}//if
			
		}//try
		catch(Exception e)
		{
			System.out.println("Exception in Amount Query with IP DC flag:"+e.toString());
		}
		
		//Added by Subha on V12022018 for ML-MMOH-CRF-0757
		try {
			outstAmtAllEnc = BLHelper.getTotalOutstAmt(con, patientid, facility_id);
		} catch(Exception e) {
			System.out.println("Exception in OUTSTANDING_AMT_ALL_ENCOUNTERS:"+e);
		}
		
		//Added by Subha on V12022018 for ML-MMOH-CRF-0757
		try {
 			unbilledAmtAllEnc = BLHelper.getTotalUnbilledAmt(con, facility_id, patientid, siteId);
 		} catch(Exception e) {
 			System.out.println("Exception in UNBILLED_AMT_ALL_ENCOUNTERS:"+e);
 		}
 
 
		try
		{
			if (!strNonInsCustCode.equals(""))
			{
				sqlcust="select b.SHORT_DESC groupdesc,a.CUST_CODE customer ,a.SHORT_NAME custname "+
						" from ar_customer_lang_vw a, AR_CUST_GROUP_lang_vw b, bl_cust_by_cust_group c  "+
						" where b.cust_group_code = c.cust_group_code "+
						" AND a.cust_code = c.cust_code "+
						" AND a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE "+
						" AND a.LANGUAGE_ID = b.LANGUAGE_ID "+
						" AND a.LANGUAGE_ID = '"+locale+"' "+
						" and a.cust_code = '"+strNonInsCustCode+"' "; 

				pstmt = con.prepareStatement(sqlcust);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					customergroup = rs.getString(1);
					customerid = rs.getString(2);
					short_desc = rs.getString(3);
				} 
				System.out.println("Customer id 2:"+customerid);
				rs.close();
				pstmt.close();
			}
			else if  (!strcustcode.equals(""))
			{
				sqlcust="select b.SHORT_DESC groupdesc,a.CUST_CODE customer ,a.SHORT_NAME custname "+
						" from ar_customer_lang_vw a, AR_CUST_GROUP_lang_vw b, bl_cust_by_cust_group c "+
						" where b.cust_group_code = c.cust_group_code "+
						" AND a.cust_code = c.cust_code "+
						" AND a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE "+
						" AND a.LANGUAGE_ID = b.LANGUAGE_ID "+
						" AND a.LANGUAGE_ID = '"+locale+"' "+
						" and a.cust_code = '"+strcustcode+"' "; 

				pstmt = con.prepareStatement(sqlcust);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					customergroup = rs.getString(1);
					customerid = rs.getString(2);
					short_desc = rs.getString(3);
				} 
				System.out.println("Customer id 3:"+customerid);
				rs.close();
				pstmt.close();
			}
			
		}//try
		catch(Exception e) 
		{
			System.out.println("Exception in Customer Group query:"+e.toString());
		}
	
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				noofdecimal  =  rs3.getInt(1);		
			}
	
			CurrencyFormat cf = new CurrencyFormat();
			outst_amt = cf.formatCurrency(outst_amt, noofdecimal);
			unbilled_amt = cf.formatCurrency(unbilled_amt, noofdecimal);
			deposit_amt = cf.formatCurrency(deposit_amt, noofdecimal);
			prepay_amt = cf.formatCurrency(prepay_amt, noofdecimal);
			refundable_deposit_amt = cf.formatCurrency(refundable_deposit_amt, noofdecimal);
			surgery_deposit_amt = cf.formatCurrency(surgery_deposit_amt, noofdecimal);
			refundable_deposit_amt = cf.formatCurrency(refundable_deposit_amt, noofdecimal);
			pkg_deposit_amt = cf.formatCurrency(pkg_deposit_amt, noofdecimal);
			refundable_deposit_amt = cf.formatCurrency(refundable_deposit_amt, noofdecimal);
			serv_disc_amt = cf.formatCurrency(serv_disc_amt, noofdecimal);
			other_disc_amt = cf.formatCurrency(other_disc_amt, noofdecimal);
			gross_amt = cf.formatCurrency(gross_amt, noofdecimal);
			outstAmtAllEnc = cf.formatCurrency(outstAmtAllEnc, noofdecimal); //Added by Subha on V12022018 for ML-MMOH-CRF-0757
			unbilledAmtAllEnc = cf.formatCurrency(unbilledAmtAllEnc, noofdecimal); //Added by Subha on V12022018 for ML-MMOH-CRF-0757
		}
		catch(Exception e)
		{
			System.out.println("Exception in Currenct Conversion:"+e.toString());
		}
%>

<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language='javascript' src='../js/BLAmount.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


	
<head>
<script>

function scrollTitle()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById('divTitleTable').style.position = 'relative';
		document.getElementById('divTitleTable').style.posTop  = 0;
	}
	else
	{
		document.getElementById('divTitleTable').style.position = 'relative';
		document.getElementById('divTitleTable').style.posTop  = x-2;
	}
}
 
</script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<%
	if(((strSetInd.equals("C"))||(strSetInd.equals("R")))|| ((strSetInd.equals("X"))&&(strAdmFlag.equals("1"))))
	{

%>

	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>

	<tr>
		<td width='25%'class='COLUMNHEADER'><fmt:message key="eBL.SLMT_DTL_DOC_REF.label" bundle="${bl_labels}"/>
	</tr>
	
	</table>

<%
	}
  else
  {
	if(((strSetInd.equals("X")) && (strAdmFlag.equals("2"))) || ((noninssettlementind.equals("C"))&&(strCrdDocRef.equals("")))|| (!strCrdDocRef.equals("")))
	{
%>
	
	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>

	<tr>
		<td width='25%' class='label'><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
<!--
		<td  width='25%' class="data"><input type='text' name='noninsbillgrp' id='noninsbillgrp' readonly maxlength='25' size='15' tabindex='0' value='<%=noninsbillinggroup%>'> </td>	
-->
		<td  width='25%' class='data'><%=noninsbillinggroup%></td>	
		<td width='25%' class="data"></td>
		<td width='25%' class="data"></td>
	</tr>

<%	
	if(str_non_ins_referral_source_code_flag.equals("Y"))
	{
%>
	<tr>
		<td width='25%' class='label'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/></td>
		<td width='25%' class="data">
<%
		if(!str_non_ins_ref_src_main_lng_name.equals(""))
		{
%>	
		<%=str_non_ins_ref_src_main_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=str_non_ins_ref_src_main_lng_name%>'>
<%
		}
		else
		{
%>
		<%=str_non_ins_ref_src_main_desc%>
<%
		}
%>
		</td>

		<td width='25%' class='label'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/></td>
		<td width='25%' class="data">
<%
		if(!str_non_ins_ref_src_sub_lng_name.equals(""))
		{
%>	
		<%=str_non_ins_ref_src_sub_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=str_non_ins_ref_src_sub_lng_name%>'>
<%
		}
		else
		{
%>
		<%=str_non_ins_ref_src_sub_desc%>
<%
		}
%>
		</td>
	</tr>
<%
	}
%>

	<tr>
		<td width='25%'class='COLUMNHEADER' colspan="4"><fmt:message key="eBL.NON_INS_FRAME_TITLE.label" bundle="${bl_labels}"/></td>
	</tr>
	
	</table>
<%
}
else
{	
	%>
	
	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>

	<tr>
		<td  width='25%' class='label'><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='noninsbillgrp' id='noninsbillgrp' readonly maxlength='25' size='15' tabindex='0' value='<%=noninsbillinggroup%>'> </td>	
-->
		<td width='25%' class='data'><%=noninsbillinggroup%></td>	
		<td width='25%' class="data"></td>
		<td width='25%' class="data"></td>
	</tr>
<%	
	if(str_non_ins_referral_source_code_flag.equals("Y"))
	{
%>
	<tr>
		<td width='25%' class='label'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/></td>
		<td width='25%' class="data"><%=str_non_ins_ref_src_main_desc%></td>

		<td width='25%' class='label'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/></td>
		<td width='25%' class="data"><%=str_non_ins_ref_src_sub_desc%></td>
	</tr>
<%
	}
%>
	<tr>
		<td width='25%'class='COLUMNHEADER' colspan="4"><fmt:message key="eBL.NON_INS_FRAME_TITLE.label" bundle="${bl_labels}"/></td>
	</tr>
	
	</table>
<%
	}
}
  
  %>
  <script>

</script>

	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>
<%
	if(((strSetInd.equals("C")) && (strCrdDocRef.equals(""))) || ((noninssettlementind.equals("C")) && (strCrdDocRef.equals(""))))
	{
%>
	<tr>
		<td width='25%'  class='label'><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='setind' id='setind' readonly maxlength='25' size='10' tabindex='0' value='<%=strslmttypecode%>'> </td>	
-->
		<td width='25%' class='data'><%=strslmttypecode%></td>
		<td width='25%'></td>
		<td width='25%'></td>
	</tr>
<%
	}

	if(((strSetInd.equals("C")) && (!strCrdDocRef.equals(""))) ||													((noninssettlementind.equals("C")) && (!strCrdDocRef.equals(""))))
	{
%>
	<tr>
		<td width='25%'  class='label'><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='setind' id='setind' readonly maxlength='25' size='15' tabindex='0' value='<%=strslmttypecode.equals("null")?"":strslmttypecode%>'> </td>	
-->
		<td width='25%' class='data'><%=strslmttypecode%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='docref' id='docref' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrdDocRef.equals("null")?"":strCrdDocRef%>'> </td>
-->
		<td width='25%' class='data'><%=strCrdDocRef%></td>
	</tr>
	
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>
<!--		
		<td width='25%' class="data"><input type='text' name='docstartdate' id='docstartdate' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrDocRefStDate.equals("null")?"":strCrDocRefStDate%>'> </td>
-->
		<td width='25%' class='data'><%=strCrDocRefStDate%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='docenddate' id='docenddate' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrDocRefEndDate.equals("null")?"":strCrDocRefEndDate%>'> </td>
-->
		<td width='25%' class='data'><%=strCrDocRefEndDate%></td>
	</tr>
<%
	}

	if((strSetInd.equals("R"))|| ((strSetInd.equals("X")) && (strAdmFlag.equals("1"))) || ((noninssettlementind.equals("R"))|| ((noninssettlementind.equals("X")) && (noninsadmrecflag.equals("1")))))
	{
%>
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='custgrp' id='custgrp' readonly maxlength='25' size='15' tabindex='0' value='<%=customergroup%>'> </td>
-->
		<td width='25%' class='data'><%=customergroup%></td>
		<td width='25%'  class='label'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='cust' id='cust' readonly maxlength='25' size='15' tabindex='0' value='<%=customerid%>'> </td>	
-->
		<td width='25%' class='data'><%=short_desc%></td>
	</tr>

	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='docref' id='docref' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrdDocRef%>'> </td>
-->
		<td width='25%' class='data'><%=strCrdDocRef%></td>
		<td width='25%' class="fields"></td>
		<td width='25%' class="fields"></td>
	</tr>
	
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='docstartdate' id='docstartdate' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrDocRefStDate%>'> </td>
-->	
		<td width='25%' class='data'><%=strCrDocRefStDate%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='docenddate' id='docenddate' readonly maxlength='25' size='15' tabindex='0' value='<%=strCrDocRefEndDate%>'> </td>
-->
		<td width='25%' class='data'><%=strCrDocRefEndDate%></td>
	</tr>
<%
	   }
   
%>
	</table>

	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>

	<tr  id='divTitleTable'>
		<td width='25%'class='COLUMNHEADER'><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>
	</tr>
	
	</table>

	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>
	
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='grossamt' id='grossamt' readonly maxlength='25' size='15' tabindex='0' value='<%=gross_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=gross_amt%></td>
		<td width='25%' class="data"></td>
		<td width='25%' class="data"></td>
	</tr>

	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.SERVICE_DISC_AMT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='servdiscamt' id='servdiscamt' readonly maxlength='25' size='15' tabindex='0' value='<%=serv_disc_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=serv_disc_amt%></td>
	    <td width='25%'  class='label'><fmt:message key="eBL.OTHER_DISC_AMT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='otherdiscamt' id='otherdiscamt' readonly maxlength='25' size='15' tabindex='0' value='<%=other_disc_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=other_disc_amt%></td>
	
	 <tr>
		<td width='25%'  class='label'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/> (<fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/>)</td>
<!--		
		<td width='25%' class="data"><input type='text' name='outstdamt' id='outstdamt' readonly maxlength='25' size='15' tabindex='0' value='<%=outst_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=outst_amt%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/> (<fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/>)</td>
<!--
		<td width='25%' class="data"><input type='text' name='unbillamt' id='unbillamt' readonly maxlength='25' size='15' tabindex='0' value='<%=unbilled_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=unbilled_amt%></td>
	</tr> 
	
	<!-- Added on V06022018 by Subha for ML-MMOH-CRF-0757 -->
	<tr>
		<td width='25%'  class='label'>
			<fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/> (<fmt:message key="Common.patient.label" bundle="${common_labels}"/>)
		</td>
		<td width='25%' class='data'><%=outstAmtAllEnc%></td>
		<td width='25%'  class='label'>
			<fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/> (<fmt:message key="Common.patient.label" bundle="${common_labels}"/>)
		</td>
		<td width='25%' class='data'><%=unbilledAmtAllEnc%></td>
	</tr>
	
	</table>
	
	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center' scrolling='yes'>	

	<tr>
		<td width='25%'class='COLUMNHEADER'><fmt:message key="eBL.UNADJUSTED_DEPOSIT_PREPAYMENT.label" bundle="${bl_labels}"/>
	</tr>
	
	<table>
   
	<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>	
	
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.DEPOSIT_AMT.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='deposit_amt' id='deposit_amt' maxlength='25' size='15' tabindex='0' value='<%=deposit_amt%>' style='text-align:right' readonly> </td>
-->
		<td width='25%' class='data'><%=deposit_amt%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.REFUNDABLE_DEPOSIT_AMT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='refundable_deposit' id='refundable_deposit' readonly maxlength='25' size='15' tabindex='0' value='<%=refundable_deposit_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=refundable_deposit_amt%></td>

	</tr>
<!--	
	<tr>
		
		<td width='25%'  class='label'><fmt:message key="eBL.PACKAGE_DEPOSIT_AMT.label" bundle="${bl_labels}"/></td>
		<td width='25%' class='data'><%=pkg_deposit_amt%></td>

		<td width='25%'  class='label'><fmt:message key="eBL.SURGERY_DEPOSIT_AMT.label" bundle="${bl_labels}"/></td>
		<td width='25%' class='data'><%=surgery_deposit_amt%></td>
	</tr>
-->	
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.PREPAYMENT_AMT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='pre_pay_amt' id='pre_pay_amt' readonly maxlength='25' size='15' tabindex='0' value='<%=prepay_amt%>' style='text-align:right'> </td>
-->
		<td width='25%' class='data'><%=prepay_amt%></td>
		<td width='25%'  class='label'>&nbsp;</td>
		<td width='25%'  class='label'>&nbsp;</td>
    </tr>
	
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
<input type='hidden' name='strslmttypecode' id='strslmttypecode' value='<%=strslmttypecode%>'>
<input type='hidden' name='strcustcode' id='strcustcode' value="<%=strcustcode%>">
<input type='hidden' name='strNonInsBlGrId' id='strNonInsBlGrId' value="<%=strNonInsBlGrId%>">
<input type='hidden' name='strNonInsCustCode' id='strNonInsCustCode' value="<%=strNonInsCustCode%>">
<input type='hidden' name='strCrDocRefStDate' id='strCrDocRefStDate' value="<%=strCrDocRefStDate%>">
<input type='hidden' name='strCrDocRefEndDate' id='strCrDocRefEndDate' value='<%=strCrDocRefEndDate%>'>
 
</form>
</body>

<%
	}
	catch(Exception eX)
	{
		out.println("Main Error= "+eX);
	}
	
	finally
	{ 
		if (rs3 != null)   rs3.close();
		if (pstmt != null) pstmt.close();
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

