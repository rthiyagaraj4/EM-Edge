<!DOCTYPE html>
<%
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201008                         NMC-JD-CRF-0066         Ram Kumar S
2            V201021                         NMC-JD-CRF-0066         Ram Kumar S
*/
%>
<%@ page import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%	
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt = null;	
	ResultSet rs1=null;
	//Added V200326-MuthuN/NMC-JD-CRF-050
	PreparedStatement pst5=null;
	ResultSet rst5=null;
	PreparedStatement pst6=null;
	ResultSet rst6=null;
	PreparedStatement pstmt_bl_visit=null;
	ResultSet rst_bl_visit=null;
	PreparedStatement pstmt_bl_epd=null;
	ResultSet rst_bl_epd=null;
	PreparedStatement pstmt_bl_pat=null;
	ResultSet rst_bl_pat=null;
	
	String settlement_ind_visit="";
	String settlement_ind_epd ="";
	String settlement_ind_pat="";
	String allow_cash_copay_disc_op_yn="";
	String allow_cash_copay_disc_ip_yn="";
	String allow_cash_copay_disc_ex_yn="";
	String pat_deduct_amount="0";
	boolean preConfigDiscAmt_YN=false;
	String preConfigDiscAmt="";
	String org_disc_amt="";
	//Added V200326-MuthuN/NMC-JD-CRF-050

	String str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="";

	String blng_serv_code="",serv_item_code="", serv_item_desc="",blng_grp_id="",policy_type_code="",cust_code="",disc_amt="",disc_perc="",currdate="",discount_allowed_yn="",user_pasword="",act_gross_amt="",trx_doc_ref_line_no="",trx_doc_ref_seq_no="",addl_charge_amt="",trx_doc_ref="",serv_desc="";

	String str_serv_max_disc_per="",str_serv_max_disc_amt="",str_payer_max_disc_per="",str_payer_max_disc_amt="";

	String upd_net_charge_amt="",upd_gross_charge_amt="",upd_disc_amt="", str_existing_reason_code="", str_existing_reason_desc="";
	/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
	String str_default_reason_code="", str_default_reason_desc="";
			
	int noofdecimal=2;

	String disable_chk_box="", str_called_frm_frame="", trx_doc_ref_seq_num_count="";
	String strNull="";
	String loggd_user_valid_for_disc_YN="N", str_trx_ind="1";	
%>	
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../js/BLAdhocDisc.js'></script>		
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		

</head>
<%
	try
	{
		con	=	ConnectionManager.getConnection(request);
		//Added V200323-MuthuN/NMC-JD-CRF-050
		preConfigDiscAmt_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ADDITIONAL_ADHOC");
		if(preConfigDiscAmt_YN){
			preConfigDiscAmt="Y";
		}
		else{
			preConfigDiscAmt="N";
		}
		//Added V200323-MuthuN/NMC-JD-CRF-050
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		
		String locale = (String)session.getAttribute("LOCALE");			
		if(locale==null || locale.equals("")) locale="en";		
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String module_id = request.getParameter("module_id");	
		if(module_id==null) module_id="";	

		blng_serv_code = request.getParameter("blng_serv_code");	
		if(blng_serv_code==null) blng_serv_code="";	

		serv_item_code = request.getParameter("serv_item_code");	
		if(serv_item_code==null) serv_item_code="";	

		serv_item_desc = request.getParameter("serv_item_desc");	
		if(serv_item_desc==null) serv_item_desc="";	

		blng_grp_id = request.getParameter("blng_grp_id");	
		if(blng_grp_id==null) blng_grp_id="";	

		policy_type_code = request.getParameter("policy_type_code");	
		if(policy_type_code==null) policy_type_code="";	
		
		cust_code = request.getParameter("cust_code");	
		if(cust_code==null) cust_code="";	
		
		upd_net_charge_amt = request.getParameter("upd_net_charge_amt");	
		if(upd_net_charge_amt==null) upd_net_charge_amt="";		
		
		act_gross_amt = request.getParameter("act_gross_amt");	
		if(act_gross_amt==null) act_gross_amt="0";	

		upd_gross_charge_amt = request.getParameter("upd_gross_charge_amt");	
		if(upd_gross_charge_amt==null) upd_gross_charge_amt="";	
		
		//Added V200323-MuthuN/NMC-JD-CRF-050
		//if(preConfigDiscAmt_YN){//074331
			org_disc_amt = request.getParameter("org_disc_amt");
				
		//}//074331
		if(org_disc_amt==null || org_disc_amt=="") org_disc_amt="0";//074331
		//Added V200323-MuthuN/NMC-JD-CRF-050		
		//V201008 Starts
		//Finding Discount percent from Upd_Gross_Charge_amount and org_discount_amount
		float DiscounPercentage;
		float GrossAmt;
		float DiscountAmt;
		double DisPercent=0.0d;
		DiscountAmt =Float.parseFloat(org_disc_amt);
		GrossAmt = Float.parseFloat(act_gross_amt);  //V201021 Modified

		DiscounPercentage = (float)((DiscountAmt / GrossAmt) * 100);
		DisPercent=Math.round(DiscounPercentage * 100.0) / 100.0;
		//V201008 Ends
		upd_disc_amt = request.getParameter("upd_disc_amt");	
		if(upd_disc_amt==null) upd_disc_amt="";

		trx_doc_ref_line_no = request.getParameter("trx_doc_ref_line_no");	
		if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";

		trx_doc_ref_seq_no = request.getParameter("trx_doc_ref_seq_no");	
		if(trx_doc_ref_seq_no==null) trx_doc_ref_seq_no="";	

		trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(trx_doc_ref==null) trx_doc_ref="";

		str_patient_id = request.getParameter("patient_id");	
		if(str_patient_id==null) str_patient_id="";	

		str_episode_type = request.getParameter("episode_type");	
		if(str_episode_type==null) str_episode_type="";	

		str_episode_id = request.getParameter("episode_id");	
		if(str_episode_id==null) str_episode_id="";			

		str_visit_id = request.getParameter("visit_id");	
		if(str_visit_id==null) str_visit_id="";	

		str_existing_reason_code = request.getParameter("existing_reason_code");	
		if(str_existing_reason_code==null) str_existing_reason_code="";	

		str_called_frm_frame = request.getParameter("called_frm_frame");	
		if(str_called_frm_frame==null) str_called_frm_frame="";		
		
		if(cust_code.length()==0)	str_called_frm_frame = "S";
		else	str_called_frm_frame = "P";		
		
		trx_doc_ref_seq_num_count =  request.getParameter("trx_doc_ref_seq_num_count");	
		if(trx_doc_ref_seq_num_count==null) trx_doc_ref_seq_num_count="";

		str_trx_ind =  request.getParameter("trx_ind");	
		if(str_trx_ind==null) str_trx_ind="1";
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				currdate = rscurr.getString(2);
			}		
			if(rscurr != null ) rscurr.close();
			if(pstmt != null ) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit sm_acc_entity_param===>"+e.toString());
		}
		//Added V200326-MuthuN/NMC-JD-CRF-050
		if(preConfigDiscAmt.equals("Y")){
			/* Below query for taking 3 columns from bl_parameters */
			try
			{		
				String sql_blparameter="SELECT NVL (allow_cash_copay_disc_op_yn, 'N') allow_cash_copay_disc_op_yn, NVL (allow_cash_copay_disc_ip_yn, 'N') allow_cash_copay_disc_ip_yn, NVL (allow_cash_copay_disc_ex_yn, 'N') allow_cash_copay_disc_ex_yn FROM bl_parameters where operating_facility_id = '"+str_facility_id+"'";
				pst5=con.prepareStatement(sql_blparameter);
				rst5 = pst5.executeQuery();
				if (rst5!=null)
				{
				   if (rst5.next())
				   {
					allow_cash_copay_disc_op_yn = rst5.getString(1);
					allow_cash_copay_disc_ip_yn = rst5.getString(2);
					allow_cash_copay_disc_ex_yn = rst5.getString(3);
				   }
				}
				if (rst5 != null)   rst5.close();
				if (pst5 != null)   pst5.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("Error BLAdhocDiscDtlsEdit bl_parameters==>"+e);
			}
			
			/* Below query for taking settlement_ind for all episode type */
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_visit = "select settlement_ind from bl_visit_fin_dtls where operating_facility_id = ? and episode_id = ?  and visit_id = ? ";
			pstmt_bl_visit = con.prepareStatement(sql_bl_visit);
			pstmt_bl_visit.setString(1, str_facility_id);
			pstmt_bl_visit.setString(2, str_episode_id);
			pstmt_bl_visit.setString(3, str_visit_id);
			rst_bl_visit = pstmt_bl_visit.executeQuery();
			if(rst_bl_visit !=null && rst_bl_visit.next())
			{
				settlement_ind_visit=checkForNull(rst_bl_visit.getString(1));
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_epd = "select settlement_ind from bl_episode_fin_dtls where operating_facility_id = ? and episode_id = ? ";
			pstmt_bl_epd = con.prepareStatement(sql_bl_epd);
			pstmt_bl_epd.setString(1, str_facility_id);
			pstmt_bl_epd.setString(2, str_episode_id);
			rst_bl_epd = pstmt_bl_epd.executeQuery();
			if(rst_bl_epd !=null && rst_bl_epd.next())
			{
				settlement_ind_epd=checkForNull(rst_bl_epd.getString(1));
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_pat = "select settlement_ind from bl_patient_fin_dtls where patient_id=?";
			pstmt_bl_pat = con.prepareStatement(sql_bl_pat);
			pstmt_bl_pat.setString(1, str_patient_id);
			rst_bl_pat=pstmt_bl_pat.executeQuery();
			if(rst_bl_pat !=null && rst_bl_pat.next())
			{
				settlement_ind_pat=checkForNull(rst_bl_pat.getString(1));
			}
			
			if((!settlement_ind_visit.equals("C") && ((str_episode_type.equals("O") || str_episode_type.equals("E")) && allow_cash_copay_disc_op_yn.equals("N")))
			|| (!settlement_ind_epd.equals("C") && ((str_episode_type.equals("I") || str_episode_type.equals("D") ) && allow_cash_copay_disc_ip_yn.equals("N")))
			|| (!settlement_ind_pat.equals("C") && (str_episode_type.equals("R") && allow_cash_copay_disc_ex_yn.equals("N")))) {
			/* Below query for taking PATIENT_DEDUCTIBLE_AMT from bl_patient_charges_folio */
			try
			{		
				String sql_patdeductAmt="select nvl(sum(nvl(PATIENT_DEDUCTIBLE_AMT,0)),0) patient_deductible_amt from bl_patient_charges_folio where trx_doc_ref = ?  and trx_doc_Ref_line_num = ? and settlement_ind <> 'C' and nvl(trx_status,'X') <> 'C'";
				/* Fixed SQL Injection for Common-ICN-0222 */
			
				pst6=con.prepareStatement(sql_patdeductAmt);
				pst6.setString(1, trx_doc_ref);
				pst6.setString(2, trx_doc_ref_line_no);
				rst6 = pst6.executeQuery();
				if (rst6!=null)
				{
				   if (rst6.next())
				   {
						 pat_deduct_amount = checkForNull(rst6.getString(1));
				   }
				}
				if (rst6 != null)   rst6.close();
				if (pst6 != null)   pst6.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Error BLAdhocDiscDtlsEdit pat_deduct_amount==>"+e);
				}
			}//If Closure
		}//SiteSpecific If Closure
		//Added V200326-MuthuN/NMC-JD-CRF-050

		try
		{
			CallableStatement  call = 
			con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,str_facility_id);
			call.setString(3,blng_serv_code);
			call.setString(4,strloggeduser);
			call.setString(5,currdate);
			if(module_id.equals("PH") || module_id.equals("ST") || module_id.equals("PS") || module_id.equals("MM"))
			{
				call.setString(6,serv_item_code);
			}
			else
			{
				call.setString(6,strNull);
			}
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.execute();		
			
			discount_allowed_yn = call.getString(1);
			if(discount_allowed_yn==null) discount_allowed_yn="";

			str_serv_max_disc_per = call.getString(7);
			if(str_serv_max_disc_per == null) str_serv_max_disc_per="";

			str_serv_max_disc_amt = call.getString(8);
			if(str_serv_max_disc_amt == null) str_serv_max_disc_amt="";

			str_payer_max_disc_per = call.getString(9);
			if(str_payer_max_disc_per == null) str_payer_max_disc_per="";

			str_payer_max_disc_amt = call.getString(10);
			if(str_payer_max_disc_amt == null) str_payer_max_disc_amt="";
			
			call.close();
		}
		catch(Exception ul)
		{
			ul.printStackTrace();
			System.err.println("Exception BLAdhocDiscDtlsEdit Check_Service_discount==>"+ul);
		}

		try
		{	
			if(discount_allowed_yn.equals("Y"))
			{
				String query_pswd="select upper(app_password.decrypt(APPL_USER_PASSWORD)) as password from sm_appl_user where appl_user_id='"+ strloggeduser + "'";
				PreparedStatement pst3=con.prepareStatement(query_pswd);
				ResultSet rst3 = pst3.executeQuery();
				if (rst3!=null)
				{
				   if (rst3.next())
				   {
						 user_pasword = rst3.getString(1);
				   }
				}
				if(user_pasword==null) user_pasword="";
				loggd_user_valid_for_disc_YN = "Y";
				if (rst3 != null)   rst3.close();
				if (pst3 != null)   pst3.close();
			}
			else
			{
				user_pasword="";
				strloggeduser="";
				loggd_user_valid_for_disc_YN = "N";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit pwd===>" +e);
		}
		
		try
		{	
			String query_addl_amt="";
			if(str_called_frm_frame.equals("P"))
			{
				query_addl_amt="Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where Trx_Doc_Ref=?  And Trx_Doc_Ref_Line_Num=? And Trx_Doc_Ref_Seq_Num =? and operating_facility_id=?";
			}
			else if(str_called_frm_frame.equals("S"))
			{
				query_addl_amt="Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where Trx_Doc_Ref=?  And Trx_Doc_Ref_Line_Num=? and operating_facility_id=?";
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			PreparedStatement pst4=con.prepareStatement(query_addl_amt);
			pst4.setString(1, trx_doc_ref);
			pst4.setString(2, trx_doc_ref_line_no);
			if(str_called_frm_frame.equals("P"))
			{
				pst4.setString(3, trx_doc_ref_seq_no);
				pst4.setString(4, str_facility_id);
			}
			else if(str_called_frm_frame.equals("S"))
			{
				pst4.setString(3, str_facility_id);
			}
			
			ResultSet rst4 = pst4.executeQuery();
			if (rst4!=null)
			{
			   if (rst4.next())
			   {
				 addl_charge_amt = rst4.getString(1);
			   }
			}
			if(addl_charge_amt==null || addl_charge_amt.equals("")) addl_charge_amt="0";
			addl_charge_amt = cf1.formatCurrency(addl_charge_amt, noofdecimal);
			if (rst4 != null)   rst4.close();
			if (pst4 != null)   pst4.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit addl_charge_amt===>" +e);
		}

		try
		{
			String sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE= ? and LANGUAGE_ID = ? ";
			/* Fixed SQL Injection for Common-ICN-0222 */
		 	pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, blng_serv_code);
			pstmt.setString(2, locale);
			rs1 = pstmt.executeQuery();	
			while(rs1.next())
			{
			   serv_desc  =  rs1.getString(1);	
			}	
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit bl_blng_serv===>"+e.toString());
		}
		
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts */		
		str_default_reason_code= (String)session.getAttribute("str_default_reason_code");
		if(str_default_reason_code==null || str_default_reason_code.equals(""))
		{
		str_default_reason_code="";
		str_default_reason_desc="";
		}
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 ends */

		try
		{
			String exist_act_reason_code_qry= " select replace(a.action_reason_desc,chr(10),'') description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper(?) AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = ? and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";

//			System.out.println("exist_act_reason_code_qry:"+exist_act_reason_code_qry);
			/* Fixed SQL Injection for Common-ICN-0222 */
		 	pstmt = con.prepareStatement(exist_act_reason_code_qry);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_existing_reason_code);
			rs1 = pstmt.executeQuery();	
		
			while(rs1.next())
			{
			   str_existing_reason_desc  =  rs1.getString(1);	
//			   System.out.println("str_existing_reason_desc :"+str_existing_reason_desc);
			}	
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
			if(str_existing_reason_desc == null) str_existing_reason_desc="";
			
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts */
		if(!(str_default_reason_code==null || str_default_reason_code.equals("")))
		{
			String default_act_reason_code_qry = " select replace(a.action_reason_desc,chr(10),'') description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper(?) AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = ? and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";
			//stmt = con.createStatement();
			
			pstmt = con.prepareStatement(default_act_reason_code_qry);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_default_reason_code);
			rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				str_default_reason_desc  =  rs1.getString(1);	
			}	
		}
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 ends */
			
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit default_act_reason_code_qry===>"+e.toString());
		}

		if(str_existing_reason_code.equals(""))
		{
			disable_chk_box="DISABLED";
		}		
%>		
<script>
function cancel()
{
	//parent.window.close();
	parent.parent.document.getElementById('dialog_tag').close();
}

async function searchReason(clng_evnt)
{
	if(clng_evnt == 'B')
	{
		if(document.forms[0].disc_reason_desc.value == "")
		{
			document.forms[0].disc_reason_desc.value="";
			document.forms[0].disc_reason_code.value="";	
			return;
		}
	}
	var target			= document.forms[0].disc_reason_desc;
	var retVal			=  new String();
	var dialogTop	 = "10";
	var dialogHeight = "10" ;
	var dialogWidth	 = "30" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
//		var title = encodeURIComponent(title);		
	var locale  = document.forms[0].locale.value;		
	
	var sql2="select  a.action_reason_code code,replace(a.action_reason_desc,chr(10),'') description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper('"+locale+"') AND exists (select b.action_reason_code from bl_action_reason_by_type b  where b.action_reason_code = a.action_reason_code   and b.active_yn = 'Y' and  ACTION_TYPE='SD') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql2;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray =await CommonLookup( title, argArray );		
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray !="")
	{				
		document.forms[0].disc_reason_code.value=arr[0];
		document.forms[0].disc_reason_desc.value=arr[1];						
	}
	else
	{			
		document.forms[0].disc_reason_desc.value="";
		document.forms[0].disc_reason_code.value="";		
	}
}

async function finalize_disc_amt()
{
	var adhoc_disc_amt = document.forms[0].adhoc_disc_amt.value;
	var adhoc_user_id = document.forms[0].adhoc_user_id.value;
	var user_password = document.forms[0].user_password.value;
	var disc_reason_desc = document.forms[0].disc_reason_desc.value;
	var trx_doc_ref_seq_num_count = document.forms[0].trx_doc_ref_seq_num_count.value;
	var called_frm_frame = document.forms[0].called_frm_frame.value;
	var trx_ind = document.forms[0].trx_ind.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050
	var preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;
	var upd_disc_amt = document.forms[0].disc_amt.value;
	var org_disc_amt = document.forms[0].org_disc_amt.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050

	if(adhoc_user_id == "")
	{
		alert(getMessage("BL9112","BL"));
		document.forms[0].adhoc_user_id.focus();
		return false;
	}

	if(user_password == "")
	{
		alert(getMessage("BL9541","BL"));
		document.forms[0].user_password.focus();
		return false;
	}

	if(adhoc_disc_amt == "")
	{
		alert(getMessage("BL6322","BL"));
		document.forms[0].adhoc_disc_amt.focus();
		return false;
	}

	if(disc_reason_desc == "")
	{
		alert(getMessage("BL6268","BL"));
		document.forms[0].disc_reason_desc.focus();
		return false;
	}
	var retVal= true;
	
	if(retVal)
	{		
		retVal = await userValidation(document.forms[0].adhoc_user_id.value,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,"U");//User Validation
		if(retVal)
		{
			retVal = await userValidation(document.forms[0].user_password.value,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,"P");//Password Validation

			if(retVal)
			{
				retVal  =await disc_amt_valiation(document.forms[0].adhoc_disc_amt.value,document.forms[0].act_gross_amt.value,document.forms[0].serv_max_disc_per.value,document.forms[0].serv_max_disc_amt.value,document.forms[0].payer_max_disc_per.value,document.forms[0].payer_max_disc_amt.value,called_frm_frame);
			}
		}
	}

	if(retVal == true)
	{
		document.forms[0].called_butt.value = "SUBMIT_BUTTON";
		document.forms[0].target='validation_frame';
		document.forms[0].action="../../eBL/jsp/BLAdhocDiscSubmit.jsp";
		document.forms[0].submit();
	}
}

function dflt_prev_reason()
{
	if(document.forms[0].sel_frm_prev_reason.checked)
	{
		document.forms[0].disc_reason_desc.value = document.forms[0].existing_reason_desc.value;
		document.forms[0].disc_reason_code.value = document.forms[0].existing_reason_code.value;
/* Change added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
		document.forms[0].sel_frm_default_reason.checked=false;
	}
	else
	{
		document.forms[0].disc_reason_desc.value = "";
		document.forms[0].disc_reason_code.value = "";
	}
}
/* Function dflt_load added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
function dflt_load(str_default_reason_code,str_default_reason_desc)
{
		document.forms[0].sel_frm_default_reason.checked=true;
		document.forms[0].disc_reason_desc.value = str_default_reason_desc;
		document.forms[0].disc_reason_code.value = str_default_reason_code;			
		document.forms[0].sel_frm_prev_reason.checked=false;

}

/* Function dflt_reason added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
function dflt_reason(str_default_reason_code,str_default_reason_desc)
{
	if(document.forms[0].sel_frm_default_reason.checked)
	{
		document.forms[0].disc_reason_desc.value = str_default_reason_desc;
		document.forms[0].disc_reason_code.value = str_default_reason_code;			
		document.forms[0].sel_frm_prev_reason.checked=false;
	}
	else
	{
		document.forms[0].disc_reason_desc.value = "";
		document.forms[0].disc_reason_code.value = "";			
	}
}

/* Function put_focus modified by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
function put_focus(str_default_reason_code,str_default_reason_desc)
{
	
	if(document.forms[0].loggd_user_valid_for_disc_YN.value == "Y")
	{
		if(document.forms[0].adhoc_user_id.value != "" && document.forms[0].user_password.value != "")
		{
//				document.forms[0].adhoc_disc_perc.disabled=false;
			document.forms[0].adhoc_disc_amt.disabled=false;				
//				document.forms[0].adhoc_disc_perc.focus();
		}
	}
	else
	{
		if(document.forms[0].adhoc_user_id.value == "")
		{
			document.forms[0].adhoc_user_id.focus();
//				document.forms[0].adhoc_disc_perc.disabled=true;
			document.forms[0].adhoc_disc_amt.disabled=true;
		}
	}
	/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */			
	dflt_load(str_default_reason_code,str_default_reason_desc);
}

function ChkNumberInputWithMinus(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '-.0123456789';
	else
	   var strCheck = '0123456789';
		
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter

	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

	if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char
	if(key == "-" && fld.value.indexOf(key) != -1) return false;// Not more than one '-' char
}
	
function validate_disc_amt(Obj)
{
	var no_of_decimal = document.forms[0].noofdecimal.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050
	var preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;
	var pat_deduct_amount = document.forms[0].pat_deduct_amount.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050
	if(Obj.value != "")
	{
		var flag = CheckForChar(Obj);

		if(flag)
		{
			if(chk_for_sign_loc(Obj))
			{
				putdeci(Obj);
				if(Math.abs(Obj.value) == 0) 
				{
					Obj.value="0"; 
					putdeci(Obj);
				}
				if(chk_negative_entry_allow_YN())
				{
					if(chkDiscAmt())
					{
						var disc_amt = document.forms[0].adhoc_disc_amt.value;
						var act_gross_amt = document.forms[0].act_gross_amt.value;
						//Added V200327-MuthuN/NMC-JD-CRF-050
						var final_act_gross_amt = act_gross_amt;
						if (preConfigDiscAmt=="Y" && pat_deduct_amount!=0)
						{
							final_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);
						}				
						//Added V200327-MuthuN/NMC-JD-CRF-050
						
						//var cal_disc_perc = (Math.abs(disc_amt)*100)/Math.abs(act_gross_amt);//Commented against V200327-MuthuN/NMC-JD-CRF-050

						var cal_disc_perc = (Math.abs(disc_amt)*100)/Math.abs(final_act_gross_amt);
						//Added V200327-MuthuN/NMC-JD-CRF-050

						cal_disc_perc = Math.round(cal_disc_perc*Math.pow(10,no_of_decimal))/Math.pow(10,no_of_decimal);
						cal_disc_perc = roundNumber(cal_disc_perc,no_of_decimal);

						document.forms[0].adhoc_disc_perc.value = cal_disc_perc;
						putdeci(document.forms[0].adhoc_disc_perc);
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}

function validate_disc_perc(Obj)
{
	var no_of_decimal = document.forms[0].noofdecimal.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050
	var preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;
	var pat_deduct_amount = document.forms[0].pat_deduct_amount.value;
	//Added V200327-MuthuN/NMC-JD-CRF-050
	if(Obj.value != "")
	{
		var act_gross_amt = document.forms[0].act_gross_amt.value;
		var final_act_gross_amt = act_gross_amt;//Added V200327-MuthuN/NMC-JD-CRF-050
		var flag = CheckForChar_withoutMinusSign(Obj);
		if(flag)
		{
			//Added V200327-MuthuN/NMC-JD-CRF-050
			if (preConfigDiscAmt=="Y" && pat_deduct_amount!=0)
			{
				final_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);
			}				
			//Added V200327-MuthuN/NMC-JD-CRF-050

			putdeci(Obj);

			//var disc_amt_conv = (Math.abs(act_gross_amt) * Math.abs(Obj.value))/100;//Commented against V200327-MuthuN/NMC-JD-CRF-050

			var disc_amt_conv = (Math.abs(final_act_gross_amt) * Math.abs(Obj.value))/100;
			//Added V200327-MuthuN/NMC-JD-CRF-050

			disc_amt_conv = Math.round(disc_amt_conv*Math.pow(10,no_of_decimal))/Math.pow(10,no_of_decimal);
			disc_amt_conv = roundNumber(disc_amt_conv,no_of_decimal);

			document.forms[0].adhoc_disc_amt.value = disc_amt_conv;
			putdeci(document.forms[0].adhoc_disc_amt);
			if(!validate_disc_amt(Obj))
			{
				document.forms[0].adhoc_disc_perc.value="";
				document.forms[0].adhoc_disc_amt.value="";
				document.forms[0].adhoc_disc_perc.select();
			}
		}
	}
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.-';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

function CheckForChar_withoutMinusSign(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.-';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

function chk_for_sign_loc(Obj)
{
	var adhoc_disc_amt = Obj.value;
	var act_gross_amt = document.forms[0].act_gross_amt.value;

	var index_of_neg_sign = adhoc_disc_amt.indexOf('-');
	
	if(act_gross_amt != "" && act_gross_amt <0)
	{
		if(index_of_neg_sign != 0 && index_of_neg_sign != -1)
		{
			alert(getMessage("INVALID_NUMBER_FORMAT","common"));
			Obj.select();
			return false;
		}
	}
	return true;
}

function chk_negative_entry_allow_YN()
{
	var adhoc_disc_amt = document.forms[0].adhoc_disc_amt.value;
	var act_gross_amt = document.forms[0].act_gross_amt.value;

	if((act_gross_amt) < 0)
	{
		if((adhoc_disc_amt) > 0)
		{
			alert(getMessage("BL6281","BL"));
			document.forms[0].adhoc_disc_amt.select();
			return false;
		}
	}
	else if((act_gross_amt) > 0)
	{
		if((adhoc_disc_amt) < 0)
		{
			alert(getMessage("BL6281","BL"));
			document.forms[0].adhoc_disc_amt.select();
			return false;
		}
	}
	else if((act_gross_amt) == 0)
	{
		alert(getMessage("BL6281","BL"));
		document.forms[0].adhoc_disc_amt.select();
		return false;
	}
	return true;
}

async function chkDiscAmt()
{
	if(document.forms[0].adhoc_disc_amt.value != '')
	{
		var disc_amt = document.forms[0].adhoc_disc_amt.value;
		var act_gross_amt = document.forms[0].act_gross_amt.value;
		var serv_max_disc_per = document.forms[0].serv_max_disc_per.value;
		var serv_max_disc_amt = document.forms[0].serv_max_disc_amt.value;
		var payer_max_disc_per = document.forms[0].payer_max_disc_per.value;
		var payer_max_disc_amt = document.forms[0].payer_max_disc_amt.value;
		var called_frm_frame = document.forms[0].called_frm_frame.value;		
		
		//Added V200325-MuthuN/NMC-JD-CRF-050			
		var upd_gross_charge_amt = document.forms[0].gross_amt.value;
		var preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;
		var upd_disc_amt = document.forms[0].disc_amt.value;
		/*var allow_cash_copay_disc_op_yn = document.forms[0].allow_cash_copay_disc_op_yn.value;
		var allow_cash_copay_disc_ip_yn = document.forms[0].allow_cash_copay_disc_ip_yn.value;
		var allow_cash_copay_disc_ex_yn = document.forms[0].allow_cash_copay_disc_ex_yn.value;*/
		var pat_deduct_amount = document.forms[0].pat_deduct_amount.value;
		var final_act_gross_amt =act_gross_amt;
		//Added V200325-MuthuN/NMC-JD-CRF-050				

		//Added V200325-MuthuN/NMC-JD-CRF-050
		if (preConfigDiscAmt=="Y" && pat_deduct_amount!=0)
			{
				final_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);
			}			
		
		if(preConfigDiscAmt=="Y"){				
			if(serv_max_disc_amt=='' && serv_max_disc_per !=0)
			{				
				serv_max_disc_amt=
				((Math.abs(parseFloat(upd_gross_charge_amt)))*(Math.abs(parseFloat(serv_max_disc_per)))/100);				
			}
		}
		//Added V200325-MuthuN/NMC-JD-CRF-050

		if(Math.abs(parseFloat(act_gross_amt)) < Math.abs(parseFloat(disc_amt)))	
		{
			alert(getMessage("BL6269","BL"));
			document.forms[0].adhoc_disc_amt.select();		
			return false;
		}		

		//Added V200404-MuthuN/NMC-JD-CRF-050
		if((Math.abs(parseFloat(upd_disc_amt))+Math.abs(parseFloat(disc_amt))) > (Math.abs(parseFloat(act_gross_amt))))
			{
				alert(getMessage("BL6269","BL"));
				document.forms[0].adhoc_disc_amt.select();		
				return false;
			}
		
		if(preConfigDiscAmt=="Y"){
			if(((Math.abs(parseFloat(final_act_gross_amt))) < (Math.abs(parseFloat(disc_amt)))) || ((Math.abs(parseFloat(serv_max_disc_amt))) < (Math.abs(parseFloat(disc_amt))+Math.abs(parseFloat(upd_disc_amt)))))
			{
				//alert(getMessage("BL6269","BL"));
				alert("APP-BL0860 Sum of service discount and adhoc discount cannot exceed the maximum allowed discount amount");
				document.forms[0].adhoc_disc_amt.select();		
				return false;
			}
		}
		//Added V200325-MuthuN/NMC-JD-CRF-050
		
		/*Added by karthik to validate based on customer code
		if cust_code is null then pass "S" to the validation procedure
		if cust_code is not null then pass "P" to the validation procedure
		*/
		var cust_code = document.forms[0].cust_code.value;			
		
		if(cust_code==''){
			called_frm_frame='S';				
		}else{
			called_frm_frame='P';	
		}
		
		var retVal= await disc_amt_valiation(disc_amt,final_act_gross_amt,serv_max_disc_per,serv_max_disc_amt,payer_max_disc_per,payer_max_disc_amt,called_frm_frame);//Added V200325-MuthuN/NMC-JD-CRF-050
		return retVal;
	}
}

</script>
<html>	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="put_focus('<%=str_default_reason_code%>','<%=str_default_reason_desc%>');" >
<form name='' id=''  ACTION='' method='post' target=''>
	<table cellpadding=3 cellspacing=0 border='0' width="100%" align='right'>	
		<tr>
			<td width='25%' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='service' id='service' size='40'  maxlength='40'  value="<%=serv_desc%>" onBlur='' readonly></td>
<%
			if(!serv_item_code.equals(""))
			{
%>
			<td width='25%' class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='item' id='item' size='40' value="<%=serv_item_desc%>" onBlur='' readonly></td>
<%
			}
			else
			{
			//V201008 Starts
%>			

			<!--Discount Percent-->
			<td width='25%' class='label'><fmt:message key="eBL.DISC_PERC.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><input type='text' style='text-align:right' name='DiscPercent' id='DiscPercent' size='15' value="<%=DisPercent%>" readonly></td>
<%
			//V201008 Ends
			}
%>

		</tr>
	<!--Discount Percent-->
	<%
	//V201008 Starts
	if(!serv_item_code.equals(""))
	{
%>
		<tr>
		<td width='25%' class='label'>&nbsp;</td>
			<td width='25%' class='label'>&nbsp;</td>
			<td width='25%' class='label'><fmt:message key="eBL.DISC_PERC.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><input type='text' style='text-align:right' name='DiscPercent' id='DiscPercent' size='15' value="<%=DisPercent%>" readonly></td>
		</tr>
			<%}
			//V201008 Ends%>
		<tr>
			<td width='25%' class='label'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='gross_amt' id='gross_amt' size='15'  maxlength='30'  value="<%=upd_gross_charge_amt%>" style='text-align:right' readonly></td>

			<td width='25%' class='label'><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
		<%if(preConfigDiscAmt_YN){%>
			<td width='25%' class="fields"><input type='text' name='disc_amt' id='disc_amt' size='15'  maxlength='30'  value="<%= Float.parseFloat(org_disc_amt)%>" readonly style='text-align:right'></td><!--//V201008 added-->
		<%}else{%>
			<td width='25%' class="fields"><input type='text' name='disc_amt' id='disc_amt' size='15'  maxlength='30'  value="<%=upd_disc_amt%>" readonly style='text-align:right'></td>
		<%}%>
		</tr>
		<tr>
			<td width='25%' class='label'><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='net_amt' id='net_amt' size='15'  maxlength='30'  value="<%=upd_net_charge_amt%>" style='text-align:right' readonly></td>	
			<td width='25%' class='label'><fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='addl_charges' id='addl_charges' size='15'  maxlength='30'  value="<%=addl_charge_amt%>" readonly style='text-align:right'></td>
		</tr>
		<tr>
			<td width='25%' class='label'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='adhoc_user_id' id='adhoc_user_id' size='15'  maxlength='30'  value="<%=strloggeduser%>"  onkeypress ="changeToUpper()" onBlur ="userValidation(this,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,'U');" tabIndex='1'></td>	<td width='25%' class='label'><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
			<td width='25%' class="fields"><input type='password' name='user_password' id='user_password' size='15'  maxlength='30'  value="<%=user_pasword%>"  onblur="userValidation(this,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,'P');" tabIndex='2' autocomplete="off"><!--V230508-41626 --> </td>						
		</tr>
<!--
			<td width='25%' class='label'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></td>
-->
<!--
			<td width='25%' class="fields"><input type='text' name='adhoc_disc_amt' id='adhoc_disc_amt' size='15'  maxlength='15'  value="<%=disc_amt%>" style='text-align:right' onKeyPress='return(ChkNumberInputWithMinus(this,event,document.forms[0].noofdecimal.value));' onblur="putdeci(this);chkDiscAmt()" tabIndex='3'></td>		
-->
		<tr>
			<td width='25%' class='label'><fmt:message key="eBL.ACT_GROSS_AMT.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><input type='text' name='act_gross_amt' id='act_gross_amt' size='15'  maxlength='30'  value="<%=act_gross_amt%>" readonly style='text-align:right'></td>
			<td width="25%"  class="label">&nbsp;</td>
			<td width="25%"  class="label">&nbsp;</td>
		</tr>
		
		<tr>
			<td width='25%' class='label'><fmt:message key="eBL.ADHOC_DISC_PERC.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields">
				<input type='text' name='adhoc_disc_perc' id='adhoc_disc_perc' size='3'  maxlength='4'  value="<%=disc_perc%>" style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));' onblur="validate_disc_perc(this);" tabIndex='3'>
			</td>		
			<td width='25%' class='label'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields">
				<input type='text' name='adhoc_disc_amt' id='adhoc_disc_amt' size='15'  maxlength='15'  value="<%=disc_amt%>" style='text-align:right' onKeyPress='return(ChkNumberInputWithMinus(this,event,document.forms[0].noofdecimal.value));' onblur="validate_disc_amt(this);" tabIndex='4'>
			</td>
		</tr>
		<tr>
	<!--
	Incident No - IN017099
	Date/Time - 17/12/2009
	Developer Name - Manivel N
	Brief Description about the modification - Key for the Legend is changed from USE_PREV_DISC_REASON to USE_PREV_REASON to generalize the message
	-->
	<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts -->
			<td width="25%"  class="label">
			<fmt:message key="eBL.USE_DEFAULT_REASON.label" bundle="${bl_labels}"/><br><br>
			<fmt:message key="eBL.USE_PREV_REASON.label" bundle="${bl_labels}"/>
			</td>		
			<td width="25%"  class="label">
			<INPUT TYPE="checkbox" name="sel_frm_default_reason" id="sel_frm_default_reason" onClick="dflt_reason('<%=str_default_reason_code%>','<%=str_default_reason_desc%>');" checked=true tabIndex='5'><br><br>
			<INPUT TYPE="checkbox" name="sel_frm_prev_reason" id="sel_frm_prev_reason" onClick="dflt_prev_reason();" <%=disable_chk_box%> tabIndex='5'>
			</td>
			<td width='25%' class='label'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></td>
			<td width='25%' class="fields"><textarea style="resize:none;" name="disc_reason_desc" id="disc_reason_desc" rows="5" cols="20" value="" tabIndex='6' onBlur="searchReason('B')"></textarea><input type="button" class="Button" name="lookup" id="lookup" value="?" onClick="searchReason('C')" tabIndex='7'><input type="hidden" name="disc_reason_code" id="disc_reason_code" value="" ></td>			
	<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  ends-->
	</tr>
		<td width="25%"  class="label">&nbsp;</td>
		<td width="25%"  class="label">&nbsp;</td>
		<td width="25%"  class="label">&nbsp;</td>				
		<td width="25%"  class='labels'><INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="finalize_disc_amt()" tabIndex='8'><input type='button' class="BUTTON" name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()' tabIndex='9'></td>
	</tr>
	</table>
	<input type="hidden" name="blng_serv_code" id="blng_serv_code"	value="<%=blng_serv_code%>" >
	<input type="hidden" name="serv_item_code" id="serv_item_code"	value="<%=serv_item_code%>" >
	
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="trx_ind" id="trx_ind"	value="<%=str_trx_ind%>" >
	
	<input type="hidden" name="logged_user" id="logged_user"	value="<%=strloggeduser%>" >
	<input type="hidden" name="client_ip_addr" id="client_ip_addr"	value="<%=strclientip%>" >
	<input type="hidden" name="locale" id="locale"	value="<%=locale%>" >
	<input type="hidden" name="module_id" id="module_id"	value="<%=module_id%>" >
	
	<input type="hidden" name="called_butt" id="called_butt"	value="" >	
	<input type="hidden" name="called_frm_frame" id="called_frm_frame" value="<%=str_called_frm_frame%>">	
	<input type="hidden" name="loggd_user_valid_for_disc_YN" id="loggd_user_valid_for_disc_YN" value="<%=loggd_user_valid_for_disc_YN%>">		

	<input type="hidden" name="trx_doc_ref" id="trx_doc_ref"	value="<%=trx_doc_ref%>" >
	<input type="hidden" name="trx_doc_ref_line_no" id="trx_doc_ref_line_no"	value="<%=trx_doc_ref_line_no%>" >
	<input type="hidden" name="trx_doc_ref_seq_no" id="trx_doc_ref_seq_no"	value="<%=trx_doc_ref_seq_no%>" >

	<input type="hidden" name="patient_id" id="patient_id"	value="<%=str_patient_id%>" >
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >
	<input type="hidden" name="episode_id" id="episode_id"	value="<%=str_episode_id%>" >
	<input type="hidden" name="visit_id" id="visit_id"	value="<%=str_visit_id%>" >
		
	<input type="hidden" name="default_reason_code" id="default_reason_code" value="<%=str_default_reason_code%>">
	<input type="hidden" name="default_reason_desc" id="default_reason_desc" value="<%=str_default_reason_desc%>">
	<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 -->
	<input type="hidden" name="existing_reason_code" id="existing_reason_code" value="<%=str_existing_reason_code%>">
	<input type="hidden" name="existing_reason_desc" id="existing_reason_desc" value="<%=str_existing_reason_desc%>">
	<input type="hidden" name="trx_doc_ref_seq_num_count" id="trx_doc_ref_seq_num_count"	value="<%=trx_doc_ref_seq_num_count%>" >
	<input type="hidden" name="discount_allowed_yn" id="discount_allowed_yn"	value="<%=discount_allowed_yn%>" >
	<input type="hidden" name="serv_max_disc_per" id="serv_max_disc_per"	value="<%=str_serv_max_disc_per%>" >
	<input type="hidden" name="serv_max_disc_amt" id="serv_max_disc_amt"	value="<%=str_serv_max_disc_amt%>" >
	<input type="hidden" name="payer_max_disc_per" id="payer_max_disc_per"	value="<%=str_payer_max_disc_per%>" >
	<input type="hidden" name="payer_max_disc_amt" id="payer_max_disc_amt"	value="<%=str_payer_max_disc_amt%>" >
	<input type="hidden" name="org_disc_amt" id="org_disc_amt"	value="<%=org_disc_amt%>" >
	<input type="hidden" name="cust_code" id="cust_code"	value="<%=cust_code%>" >

	<!-- Added V200326-MuthuN/NMC-JD-CRF-050 -->
	<input type="hidden" name="preConfigDiscAmt" id="preConfigDiscAmt"	value="<%=preConfigDiscAmt%>" >
	<input type="hidden" name="allow_cash_copay_disc_op_yn" id="allow_cash_copay_disc_op_yn"	value="<%=allow_cash_copay_disc_op_yn%>" >
	<input type="hidden" name="allow_cash_copay_disc_ip_yn" id="allow_cash_copay_disc_ip_yn"	value="<%=allow_cash_copay_disc_ip_yn%>" >
	<input type="hidden" name="allow_cash_copay_disc_ex_yn" id="allow_cash_copay_disc_ex_yn"	value="<%=allow_cash_copay_disc_ex_yn%>" >
	<input type="hidden" name="pat_deduct_amount" id="pat_deduct_amount" value="<%=pat_deduct_amount%>" >
	<!-- Added V200326-MuthuN/NMC-JD-CRF-050 -->	

</form>
</body>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>
<%
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		System.out.println("Error in final BLAdhocDiscDtlsEdit===>" +ee);
	}
	finally 
	{
		try{
			if(rst_bl_visit!=null)		rst_bl_visit.close();
			if(pstmt_bl_visit!=null)	pstmt_bl_visit.close();
			if(rst_bl_epd!=null)        rst_bl_epd.close();
			if(pstmt_bl_epd!=null)		pstmt_bl_epd.close();
			if(rst_bl_pat!=null)		rst_bl_pat.close();
			if(pstmt_bl_pat!=null)		pstmt_bl_pat.close();
			if(con!=null)
			{
				ConnectionManager.returnConnection(con, request);
			}
		 }catch(Exception es){es.printStackTrace();}
	}
%>

