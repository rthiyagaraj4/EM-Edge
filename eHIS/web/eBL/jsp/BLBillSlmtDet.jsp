<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; ResultSet rs21 = null; ResultSet rscurr=null;
//	System.out.println("locale :"+locale);
//	String strdfltslmttypecode = "";
	String		ext_acc_interface_yn=""; 	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= ""; 	String		str_ext_dept_ind = "";	String		str_ext_dept_code     = "";
	String		str_single_service_grp_yn = ""; 	String		str_service_grp		= ""; 	String		str_acc_episode_type= "";
	String		str_acc_category_code	= ""; 	String		str_acc_serv_grp_used_yn	= ""; 	String		str_reln_code		= "";
	String		str_episode_type		= "";	
	String sqlStr = "";
	
	//String str_sys_message_id="";String billdoctype =  ""; 	String strrectype ="";String strbillslmtamtdet =""; 	
	//String str_part_rcpt_cntr_allowed_yn="";String str_part_rfnd_cntr_allowed_yn="";String str_part_rcpt_user_allowed_yn="";
	//String str_part_rfnd_user_allowed_yn="";
	String		str_error_text		= ""; 	String      strslmttype		=""; String		strfacilityid	=""; 	
	int noofdecimal=2;  	String strbilldoctypecode=""; 	String strbilldocnum=""; 
	String strbillpayableamt=""; double v_billpayableamt=0; 	  
	String strrectypedesc="";	 	//String stracccode ="";  	
	String stracccodedesc ="";
	//String strdept =""; 	
	String strdeptdesc =""; 	
	int total_records=0;String query_string="";	 
	String slmt_amt_disabled_YN="";	String strdfltcashbillslmtamt = "";String strslmtamt = "";String strchangereceiptamtind = "";
	String strrcptallowedyn = "",strroundingamt="";

	String called_frm="",alw_co_wit_bl_slmt_yn="N";
	String custId = BLReportIdMapper.getCustomerId();
	//KDAH-CRF-0318
	String addlChargeAmtForBill = "";
	String billLevelTax = "N";
	String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
	if(billAlreadyPrinted == null) billAlreadyPrinted="N";
 %>

<HTML>
<HEAD>
<!--	<TITLE> Bill Settlement Details  11 </TITLE> -->
		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
<!--
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language='javascript'>	
	/*function dfltslmt()
    {
	var dfltslmt = document.forms[0].dfltslmttypecode.value;	
	var billslmtamt = document.forms[0].billslmtamt.value;	
	if (billslmtamt == null || billslmtamt == 0 || billslmtamt == "")
		return;			
	try
	{
		for(i=0;i<document.forms[0].slmttype.options.length;i++)
		{									
			var cashSetValue = document.forms[0].slmttype.options[i].value;
					
			if (cashSetValue == null)
			{
				continue;
			}
			var len = cashSetValue.length;
			var subValue ="";

			if (len >0)
			{
				subValue = cashSetValue.substring(0,len-1);
			}
			if (subValue == dfltslmt)
			{								
				document.forms[0].slmttype.value = cashSetValue;
				calldfltslmt(cashSetValue);
			}									
		}				
	}
	catch(e)
	{
	}				
   }
   */

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		query_string=request.getQueryString();
		if(query_string==null || query_string.equals("")) query_string="";
//		System.out.println("query_string from det:" + query_string);
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";
//		System.out.println("strbilldoctypecode req:"+strbilldoctypecode);	
		strbilldocnum = request.getParameter("billdocnum");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="";
		if(!strbillpayableamt.equals(""))
		{
			v_billpayableamt=Double.parseDouble(strbillpayableamt);
		}
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";

		String strpatientid  = request.getParameter("patientid");	
		String strepisodetype = request.getParameter("episodetype");
		String strepisodeid = request.getParameter("episodeid");	
		String strvisitid = request.getParameter("visitid");	
		String strslmtpayername = request.getParameter("slmtpayername");
		String struser = request.getParameter("loggeduser");	
		String strslmtidno = request.getParameter("slmtidno");
		String strcashcounter = request.getParameter("cashcounter");
		String strrcptallowedynuser = "";
		String strchangereceiptalloweduser = "";
		//String strchangeyn	= "N";	
		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{strroundingamt ="";}
//		System.out.println("strroundingamt in DET" + strroundingamt);

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode ="";}
		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}
		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}
		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
		{strfacilityid = "";}
		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}
		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}
		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}
		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";
		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
		{strslmtpayername = "";}
		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";
		if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";
		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")) 
		strcashcounter ="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

/* Commented and added Request Parameter from Main.jsp for PE Changes
		try
		{				
			pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N'),nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id = '" + strfacilityid + "'");
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltcashbillslmtamt =  rs.getString(1);
				ext_acc_interface_yn =rs.getString("ext_acc_interface");
			}
			else
				strdfltcashbillslmtamt = "N";
				ext_acc_interface_yn = "N";
		
		rs.close();
		pstmt.close();
		}catch(Exception e) 
		{   e.printStackTrace();
			System.out.println("Exception in bl_parameters query:"+e);
		}
*/		
		strdfltcashbillslmtamt = request.getParameter("dfltcashbillslmtamt");
		if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
			strdfltcashbillslmtamt = "N";
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null || ext_acc_interface_yn.equalsIgnoreCase("null")) ext_acc_interface_yn="N";
		
		addlChargeAmtForBill = request.getParameter("addl_charge_amt");
		if(addlChargeAmtForBill == null || "null".equals(addlChargeAmtForBill)){
			addlChargeAmtForBill = "";
		}
/* Commented as the variable is not used @ all
	   try
		{				
			pstmt = con.prepareStatement(" select slmt_type_code from bl_visit_fin_dtls where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"'");
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltslmttypecode =  rs.getString(1);						
			}
			else
			{
				strdfltslmttypecode = "";
			}
		rs.close();
		pstmt.close();
		}

		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_visit_fin_dtls query:"+e);
		}
	
		if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
			strdfltslmttypecode = "";
*/
		try
		{		
			//pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = '" + strcashcounter + "' and operating_facility_id = '" + strfacilityid + "'");	

//			System.out.println("strbillpayableamt "+strbillpayableamt);
//			System.out.println("strcashcounter "+strcashcounter);
//			System.out.println("strfacilityid "+strfacilityid);


			sqlStr = "select decode(sign(?),'1', decode('E','O',nvl(op_applicable_ind,'N'),'E',nvl(op_applicable_ind,'N'),'R', nvl(REF_APPLICABLE_IND,'N')) ,'-1',decode('E','O',nvl(OP_REFUND_IND,'N'),'E',nvl(OP_REFUND_IND,'N'),'R', nvl(REF_REFUND_IND,'N')) ) op_ref_applicable,decode(sign(?),'1',nvl(change_receipt_amt_ind,'N'),'-1',nvl(CHANGE_REFUND_AMT_IND,'N')) op_ref_changea_amt_ind from  bl_cash_counter where cash_counter_code = ?  and operating_facility_id = ?  ";
			
			pstmt = con.prepareStatement(sqlStr);
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strcashcounter);
			pstmt.setString(4,strfacilityid);
			
			rs = pstmt.executeQuery();	

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedyn =  rs.getString(1);			
				strchangereceiptamtind =  rs.getString(2);			
			}
			else
			{
				strrcptallowedyn = "N";
				strchangereceiptamtind = "N";
			}		
			
			pstmt = null;
			rs = null;
			pstmt = con.prepareStatement("Select NVL(Bill_level_tax_yn,'N') Bill_level_tax_yn from bl_parameters");
			rs = pstmt.executeQuery();	
			if(rs != null && rs.next()){
				billLevelTax = rs.getString("Bill_level_tax_yn");
			}
			
			rs.close();
		pstmt.close();
		strrcptallowedyn="Y";
		strchangereceiptamtind="Y";
		}
		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_cash_counter query:"+e);
		}
		
		if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
			strrcptallowedyn = "N";
		if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
		    strchangereceiptamtind = "N";

		try	
		{		
			//pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");
			
			sqlStr = "select decode(sign(?),'1',nvl(receipt_auth_yn,'N'),'-1',nvl(REFUND_AUTH_YN,'N')) receipt_refund_auth_yn, decode(sign(?),'1',nvl(change_receipt_allowed_yn,'N'),'-1',nvl(CHANGE_REFUND_ALLOWED_YN,'N')) rec_ref_change_allowed_yn from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ?";
			pstmt = con.prepareStatement(sqlStr);
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strfacilityid);
			pstmt.setString(4,struser);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedynuser =  rs.getString(1);				
				strchangereceiptalloweduser =  rs.getString(2);						
			}
			else
			{
				strrcptallowedynuser = "N";
				strchangereceiptalloweduser = "N";
			}
			rs.close();
			pstmt.close();
		}		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_users_for_credit_auth query:"+e);
		}

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
			strrcptallowedynuser = "N";
		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		    strchangereceiptalloweduser = "N";	

/*
		if (strdfltcashbillslmtamt.equals("N") || strrcptallowedyn.equals("N") || strrcptallowedynuser.equals("N") )
		{
			strslmtamt = "";
			strchangeyn = "Y";
		}
		else
		{ 
			strslmtamt = strbillpayableamt;
			if (strchangereceiptalloweduser.equals("N") || strchangereceiptamtind.equals("N"))
				strchangeyn = "N";
			else
				strchangeyn = "Y";	
	    }	
*/
//		System.err.println("strrcptallowedyn:"+strrcptallowedyn);
//		System.err.println("strrcptallowedynuser:"+strrcptallowedynuser);
		if(strrcptallowedyn.equals("Y") && strrcptallowedynuser.equals("Y"))
		{
			if(strdfltcashbillslmtamt.equals("Y"))
			{
				strslmtamt = strbillpayableamt;
			}

			if(strchangereceiptalloweduser.equals("Y") && strchangereceiptamtind.equals("Y"))
			{
				slmt_amt_disabled_YN="N";
			}
			else
			{
				slmt_amt_disabled_YN="Y";
			}
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
		pstmt.close();
			}
			catch(Exception e)
			{    e.printStackTrace();
				System.out.println("3="+e.toString());
			}
/*
	if (!(strbillpayableamt.equals("")))		   
	{
		try
		{
			CallableStatement call = con.prepareCall("{ call blcommon.proc_chk_for_partial_rcpt_rfnd(?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,strfacilityid);
			call.setString(2,struser);
			call.setString(3,strcashcounter);
			call.registerOutParameter(4,java.sql.Types.VARCHAR); 
			call.registerOutParameter(5,java.sql.Types.VARCHAR); 
			call.registerOutParameter(6,java.sql.Types.VARCHAR); 
			call.registerOutParameter(7,java.sql.Types.VARCHAR); 
			call.registerOutParameter(8,java.sql.Types.VARCHAR); 
			call.registerOutParameter(9,java.sql.Types.VARCHAR); 
			call.execute();				

			str_part_rcpt_cntr_allowed_yn=call.getString(4);
			str_part_rfnd_cntr_allowed_yn=call.getString(5);
			str_part_rcpt_user_allowed_yn=call.getString(6);
			str_part_rfnd_user_allowed_yn=call.getString(7);

			str_sys_message_id	 = call.getString(8);		
			str_error_text		 = call.getString(8);		
			call.close();	
			
			if ( str_part_rcpt_cntr_allowed_yn == null ) str_part_rcpt_cntr_allowed_yn = "";
			if ( str_part_rfnd_cntr_allowed_yn == null ) str_part_rfnd_cntr_allowed_yn = "";
			if ( str_part_rcpt_user_allowed_yn == null ) str_part_rcpt_user_allowed_yn = "";
			if ( str_part_rfnd_user_allowed_yn == null ) str_part_rfnd_user_allowed_yn = "";
			if ( str_sys_message_id == null ) str_sys_message_id = "";
			if ( str_error_text == null ) str_error_text = "";

			System.out.println("str_part_rcpt_cntr_allowed_yn:"+str_part_rcpt_cntr_allowed_yn);
			System.out.println("str_part_rfnd_cntr_allowed_yn:"+str_part_rfnd_cntr_allowed_yn);
			System.out.println("str_part_rcpt_user_allowed_yn:"+str_part_rcpt_user_allowed_yn);
			System.out.println("str_part_rfnd_user_allowed_yn:"+str_part_rfnd_user_allowed_yn);
			System.out.println("str_sys_message_id:"+str_sys_message_id);
			System.out.println("str_error_text:"+str_error_text);
		}
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in blcommon.proc_chk_for_partial_rcpt_rfnd:"+e); 
		}
	}

	if(v_billpayableamt>0)
	{
		if(str_part_rcpt_cntr_allowed_yn.equals("Y") && str_part_rcpt_user_allowed_yn.equals("Y") && v_billpayableamt>0)
		{
			slmt_amt_disabled_YN="N";
		}
		else
		{	
			slmt_amt_disabled_YN="Y";
		}
	}

	if(v_billpayableamt<0)
	{
		if(str_part_rfnd_cntr_allowed_yn.equals("Y") && str_part_rfnd_user_allowed_yn.equals("Y") && v_billpayableamt<0)
		{
			slmt_amt_disabled_YN="N";
		}
		else
		{	
			slmt_amt_disabled_YN="Y";
		}	
	}

	if (strdfltcashbillslmtamt.equals("Y") && str_part_rcpt_cntr_allowed_yn.equals("Y") && str_part_rcpt_user_allowed_yn.equals("Y") )
	{
		strslmtamt = strbillpayableamt;
		if(strchangereceiptamtind.equals("Y"))
		{
			slmt_amt_disabled_YN="N";
		}
	}
*/
%>

	
	<script>		
			function ChkNumberInput1(fld, e, deci,sn)
			{
				var strCheck ="";
				if(document.forms[0].billpayableamt.value < 0)
				{
					if (parseInt(deci)>0)
						strCheck = '-.0123456789';
					else
						strCheck = '-0123456789';	
				}
				else
				{
					if (parseInt(deci)>0)
						strCheck = '.0123456789';
					else
						strCheck = '0123456789';	
				}
				var whichCode = (window.Event) ? e.which : e.keyCode;
				if (whichCode == 13) return true;  // Enter
				
				key = String.fromCharCode(whichCode);  // Get key value from key code

				if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
				if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char
				if(key == "-" && fld.value.indexOf(key) != -1) return false; // Not more than one '-' char
			}
/*			function checkslmtamt()
			{
				var v_billslmtamt = "";			
				var v_billpayableamt = "";

				v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;				
				v_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;			

				if ( parseFloat(v_billslmtamt) > parseFloat(v_billpayableamt))
				{
//					alert("Allocated amount is greater than outstanding amount");
					alert(getMessage("BL7085","BL"));
					parent.frames[0].document.forms[0].billslmtamt.select();
					parent.frames[0].document.forms[0].billslmtamt.focus();
					return false;
				}

				if ( parseFloat(v_billslmtamt) < 0 )
				{
//					alert(" Refund cannot be allowed");
					alert(getMessage("BL9536","BL"));
					parent.frames[0].document.forms[0].billslmtamt.select();
					parent.frames[0].document.forms[0].billslmtamt.focus();
					return false;
				}

				if ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == "" || v_billslmtamt == null )
				{
					document.forms[0].slmttype.value = "";
					calldfltslmt("");	
				}
			}

			function billslmtprocess()
			{	
				var v_slmttype		= "";
				var v_cashslmtflag	= "";
				var v_instref		= "";
				var v_instdate		= "";
				var v_instremark	= "";
				var v_slmtidno		= "";
				var v_slmtpayername = "";
				var v_billslmtamt = "";	
				var v_slmtapprrefno = "";

				var v_rectype ="";
				var v_ext_acc_facility_id = "";
				var v_ext_acc_code = "";
				var v_ext_acc_dept = "";
				var v_online_approval = "";
				var v_batch_no = "";
				var v_sale_draft_no = "";
				var v_ext_acc_interface_yn = "";

				v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;					
				v_slmttype = parent.frames[0].document.forms[0].slmttype.value;							

				parent.frames[0].document.forms[0].pagecloseind.value = "0";
				
				if (v_billslmtamt == null ) v_billslmtamt ="";
				if (v_slmttype == null ) v_slmttype = "";
	
				if (v_slmttype == "" && parseFloat(v_billslmtamt) > 0)
				{	
//					alert( "Settlement Type cannot be blank");
					alert(getMessage("BL9521","BL"));
					parent.frames[0].document.forms[0].slmttype.focus();
					return false;
				}

				if (v_slmttype != "" && parseFloat(v_billslmtamt) == 0)
				{	
//					alert( "Settlement Type cannot be selected for Zero amount");
					alert(getMessage("BL9522","BL"));
					parent.frames[0].document.forms[0].slmttype.focus();
					return false;
				}
				

				if (v_slmttype != "" &&  v_billslmtamt =="" )
				{	
//					alert( "Settlement Amount cannot be blank");
					alert(getMessage("BL9523","BL"));
					parent.frames[0].document.forms[0].billslmtamt.focus();
					return false;
				}

				var str = parent.frames[0].document.forms[0].slmttype.value;					
				v_cashslmtflag =str.charAt(2);		
				
				if (v_slmttype != "")
				{
					v_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;
					
				}
				
				if (v_ext_acc_interface_yn == "Y" && v_slmttype != "")

				{					
					v_rectype = parent.frames[1].document.forms[0].rectype.value;
					v_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;
					v_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;
					v_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;
					
					if ( v_rectype == "")
					{
//						alert("Receipt Type cannot be blank");
						alert(getMessage("BL9524","BL"));
						parent.frames[1].document.forms[0].rectype.focus();
						return false;
					}

					if ( v_ext_acc_code == "")
					{
//						alert("Account code cannot be blank");
						alert(getMessage("BL9525","BL"));
						parent.frames[1].document.forms[0].acccode.focus();
						return false;
					}

					if ( v_ext_acc_dept == "")
					{
//						alert("Accounting department cannot be blank");
						alert(getMessage("BL9526","BL"));
						parent.frames[1].document.forms[0].dept.focus();
						return false;
					}
				}				

				if (v_cashslmtflag != "Y" && v_slmttype != "")
				{
						v_instref = parent.frames[1].document.forms[0].instref.value;
						v_instdate = parent.frames[1].document.forms[0].instdate.value;
						v_instremark = parent.frames[1].document.forms[0].instremark.value;
						v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
						v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
						v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;
						if (parent.frames[1].document.forms[0].onlineapproval.checked)
							v_online_approval = 'Y';
						else
							v_online_approval = 'N';

						v_batch_no = parent.frames[1].document.forms[0].batchno.value;
						v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;

						if ( v_instref == "")
						{
//							alert("Instrument Ref cannot be blank");
							alert(getMessage("BL9527","BL"));
							parent.frames[1].document.forms[0].instref.focus();
							return false;
						}

						if ( v_instdate == "")
						{
//							alert("Instrument Date cannot be blank");
							alert(getMessage("BL9528","BL"));
							parent.frames[1].document.forms[0].instdate.focus();
							return false;
						}

						if (v_instremark == "" && (v_cashslmtflag == "A" || v_cashslmtflag == "B"))
						{
//							alert("Bank/Card Co. Name cannot be blank");
							alert(getMessage("BL9529","BL"));
							parent.frames[1].document.forms[0].instremark.focus();
							return false;
						}

						if (v_slmtapprrefno == "" && v_cashslmtflag == "A")
						{
//							alert("Approval code cannot be blank");
							alert(getMessage("BL9531","BL"));
							parent.frames[1].document.forms[0].apprrefno.focus();
							return false;						
						}				
							
						
						if (v_cashslmtflag == "B" && v_slmtpayername == "")
						{
//							alert("Payer's name cannot be blank");
							alert(getMessage("BL9532","BL"));
							parent.frames[1].document.forms[0].payername.focus();
							return false;
						}

						if (v_cashslmtflag == "B" && v_slmtpayername != "" && v_slmtidno == "")
						{
//							alert("Payer's Ref Id cannot be blank");
							alert(getMessage("BL9533","BL"));
							parent.frames[1].document.forms[0].recrefidno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_online_approval == "Y" && v_batch_no == "")
						{
//							alert("Batch No cannot be blank");
							alert(getMessage("BL9530","BL"));
							parent.frames[1].document.forms[0].batchno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_online_approval == "N" && v_batch_no != "")
						{
//							alert("Online Approved credit card transaction can only have batch number");
							alert(getMessage("BL9534","BL"));
							parent.frames[1].document.forms[0].batchno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_sale_draft_no == "")
						{
//							alert("Sale Draft No cannot be blank");
							alert(getMessage("BL9535","BL"));
							parent.frames[1].document.forms[0].saledraftno.focus();
							return false;
						}												
					}
					else
						if (v_cashslmtflag == "Y" && v_slmttype != "")
						{
						
						v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
						v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
						}			
					
				    
							
					parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt='+v_billslmtamt+'&slmttypecode='+v_slmttype.substring(0,2)+'&slmtdocref='+v_instref+'&slmtdocrefdate='+v_instdate+'&slmtdocrefremark='+v_instremark+'&slmtidno='+v_slmtidno+'&slmtpayername='+v_slmtpayername+'&slmtapprrefno='+v_slmtapprrefno+'&onlineapproval='+v_online_approval+'&batchno='+v_batch_no+'&saledraftno='+v_sale_draft_no+'&rectype='+v_rectype+'&extaccfacid='+v_ext_acc_facility_id+'&extacccode='+v_ext_acc_code+'&extaccdept='+v_ext_acc_dept; 
					
			}

			function billslmtprocessclose()
			{				

			if ( parent.frames[0].document.forms[0].pagecloseind.value != "1" )
				{	
				
				parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>'; 				

				/*
				var dialogHeight	= "1" ;
				var dialogWidth		= "1" ;
				var dialogTop		= "1";
				var center			= "1";														   
				var status			= "no";
				var features		= "dialogHeight:"  + dialogHeight + 
									  "; dialogWidth:" + dialogWidth + 	
									  "; center: "	   + center + 
									  "; status: "	   + status	+ 
									  "; dialogTop :"  + dialogTop;
				var arguments	= "" ;								

									
				var retVal = 			window.showModalDialog('../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>',arguments,features); 
				*/

/*				return;			

				}			
			}



			function calldfltslmt(val)
			{
				var str = val;
				var obj=str.substring(0,2);
				var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;								
											
				if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "")
				{				parent.frames[1].location.href='../../eBL/jsp/BLBillSlmtType.jsp?slmttype='+obj+'&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>';
				}
				else
				{parent.frames[1].location.href='../../eCommon/html/blank.html';
				}	

				if ( v_billslmtamt == "" && str != "")
				{
					parent.frames[0].document.forms[0].slmttype.value = "";
//					alert("Settlement Amount cannot be blank");					
					alert(getMessage("BL9523","BL"));					
					return false;
				}


				}

			function callslmt(Obj)
			{
				var str = Obj.value;
				var obj=str.substring(0,2);
				var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;								
											
				if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "")
				{				parent.frames[1].location.href='../../eBL/jsp/BLBillSlmtType.jsp?slmttype='+obj+'&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>';
				}
				else
				{parent.frames[1].location.href='../../eCommon/html/blank.html';
				}	

				if ( v_billslmtamt == "" && str != "")
				{
					parent.frames[0].document.forms[0].slmttype.value = "";
//					alert("Settlement Amount cannot be blank");					
					alert(getMessage("BL9523","BL"));					
					return false;
				}


		}*/
	function putdeci(object)
	{		
		
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
		
		
	}

function funServiceDet()
{
	
	var query_string=document.forms[0].query_string.value;
	var amt_sett=document.forms[0].billslmtamtdet.value;
	var pay_amt=document.forms[0].billpayableamt.value;
	var remOutStndAmt = parseFloat(pay_amt)-parseFloat(amt_sett);
	var custId = document.forms[0].custId.value;
	var sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;		
//	var slmt_amt_disabled_YN = parent.frames[3].document.forms[0].slmt_amt_disabled_YN.value;
		var slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;
	if(pay_amt < 0)
	{
		var temp=amt_sett.indexOf('-');
		if(temp != -1 ) 
		{
			if(temp != 0 ) 
			{				
				alert(getMessage("INVALID_NUMBER_FORMAT","common"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
		}
	}
	
	if(pay_amt>0 && amt_sett<0)
	{
		alert(getMessage("BL9863","BL"));
		document.forms[0].billslmtamtdet.select();	
		return false;
	}
	if(pay_amt<0 && amt_sett>0)
	{
		alert(getMessage("BL9863","BL"));
		document.forms[0].billslmtamtdet.select();	
		return false;
	}
		
		if(amt_sett!="")
		{
			if(sett_amt!=0)
			{
				if(parseFloat(amt_sett)<parseFloat(sett_amt) || parseFloat(amt_sett)>parseFloat(sett_amt))
				{
					 alert(getMessage("BL9782","BL"));
//					 document.forms[0].billslmtamtdet.select();
//					 return false;
				}
			}
		
			var out_standing_amt=document.forms[0].billpayableamt.value;
			if(amt_sett<0)
			{				
			
			//if(parseFloat(amt_sett)>parseFloat(out_standing_amt))
			if(parseFloat(out_standing_amt)>parseFloat(amt_sett))

			{			
				alert(getMessage("BL7085","BL"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
			}
			else
			if(amt_sett>0)
			{
			
			if(parseFloat(amt_sett)>parseFloat(out_standing_amt))

			{			
				alert(getMessage("BL7085","BL"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
			}
		}
				if(custId == 'MOHBR'){	
					if(amt_sett!=''){
							var remamt = document.forms[0].remOutStndAmt.value;
							var ttamt="0.0";
							 if(remamt!='' )
								  {
								 var blamtt = document.forms[0].billslmtamtdet.value;
								 var ttamt = parseFloat(blamtt) + parseFloat(remamt);						 
								  }
						if(parseFloat(pay_amt)>0){
							if(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(amt_sett)<parseFloat(pay_amt)){
								var resp = confirm("Partial settlement being processed \n  Do you want to continue? ");
								if(resp == true){
									document.forms[0].remOutStndAmt.value = remOutStndAmt;
									putdeci(document.forms[0].remOutStndAmt);
								}
								else{
									document.forms[0].billslmtamtdet.value = pay_amt;
									putdeci(document.forms[0].billslmtamtdet);
									document.forms[0].remOutStndAmt.value = '0.0';
									document.forms[0].billslmtamtdet.select();
									return false;
								}															
							}
							else{
								document.forms[0].remOutStndAmt.value = remOutStndAmt;
								putdeci(document.forms[0].remOutStndAmt)
							}	
						}
						else{
							if(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(pay_amt)<parseFloat(amt_sett)){							
								document.forms[0].billslmtamtdet.value = pay_amt;
								putdeci(document.forms[0].billslmtamtdet);
								document.forms[0].remOutStndAmt.value = '0.0';
								document.forms[0].billslmtamtdet.select();
								return false;																
							}
							else{
								document.forms[0].remOutStndAmt.value = remOutStndAmt;
								putdeci(document.forms[0].remOutStndAmt)
							}	
						}
						
					}
					else{
						document.forms[0].remOutStndAmt.value = '';
					}
									
				}
		document.forms[0].service_check.value='Y';
		//document.forms[0].submit();
		parent.frames[1].location.href="../../eBL/jsp/BLBillSlmtService.jsp?"+query_string+"&slmt_amt_disabled_YN="+slmt_amt_disabled_YN;
}

function funServiceDet_onLoad()
{
	var query_string=document.forms[0].query_string.value;
	var slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;
	var amt_sett=document.forms[0].billslmtamtdet.value;
//		var sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;	
		
		if(amt_sett!="")
		{
/*
		if(parseFloat(amt_sett)<parseFloat(sett_amt))
		{
			 alert(getMessage("BL9759","BL"));
			 document.forms[0].billslmtamtdet.select();
			 return false;
		}
*/		
		var out_standing_amt=document.forms[0].billpayableamt.value;
		if(parseFloat(amt_sett)>parseFloat(out_standing_amt))
		{			
			alert(getMessage("BL7085","BL"));
			 document.forms[0].billslmtamtdet.select();
			 return false;

		}
		}
	document.forms[0].service_check.value='Y';
	//document.forms[0].submit();
	parent.frames[1].location.href="../../eBL/jsp/BLBillSlmtService.jsp?"+query_string+"&slmt_amt_disabled_YN="+slmt_amt_disabled_YN;
	
}


function rectypelkup()
		{
		var msg="";
		var target				= document.forms[0].rectype;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";
		//Below line (v_facility_id) is added by muthu against IN:032615 on 10-5-12
		var v_facility_id =document.forms[0].strfacilityid.value;// '<%=strfacilityid%>';
		
		var v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//'<%=ext_acc_interface_yn%>';
		var	v_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//'<%=str_single_service_grp_yn%>';		
		var v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//'<%=str_acc_episode_type%>';	
		var v_acc_catg_code = document.forms[0].str_acc_category_code.value;//'<%=str_acc_category_code%>';		
		var v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//'<%=str_acc_serv_grp_used_yn%>';		
		var v_serv_grp = document.forms[0].str_service_grp.value;//'<%=str_service_grp%>';		
		var v_episode_type =document.forms[0].str_episode_type.value;// '<%=str_episode_type%>';		
		var v_reln_code =document.forms[0].str_reln_code.value;//'<%=str_reln_code%>';
		

		var locale = document.forms[0].locale.value;
		

// PE Changes			
//		sql = "select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`"+locale+"` and recpt_nature_code = `BI` and status is null and (( `"+v_ext_acc_interface_yn+"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`"+v_single_serv_grp+"`=`Y` and episode_type in (`"+v_acc_episode_type+"`,`U`) and category in (`UNRESTRICTED`,`"+v_acc_catg_code+"`) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and episode_type in (`U`,`"+v_episode_type+"`) and category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `"+v_ext_acc_interface_yn+"` = `N`    )";	

		sql = "select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`"+locale+"` and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=`"+v_facility_id+"`) and recpt_nature_code = `BI` and status is null and (( `"+v_ext_acc_interface_yn+"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`"+v_single_serv_grp+"`=`Y` and episode_type in (`"+v_acc_episode_type+"`,`U`) and category in (`UNRESTRICTED`,`"+v_acc_catg_code+"`) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and episode_type in (`U`,`"+v_episode_type+"`) and category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `"+v_ext_acc_interface_yn+"` = `N`)";			

		search_code="receipt_type_code";
		search_desc="long_desc";
//		tit="Receipt Types"; 
		tit=encodeURIComponent(getLabel("eBL.RECEIPT_TYPE.label","BL"));
		//tit=getLabel("eBL.RECEIPT_TYPE.label","BL");		
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();
		//alert("retVal" +retVal);
		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");
		
			document.forms[0].rectypedesc.value=arr[0];
		    document.forms[0].rectype.value=arr[1];
			
			document.forms[0].acccode.value='';
			document.forms[0].acccodedesc.value='';

			document.forms[0].dept.value='';
			document.forms[0].deptdesc.value='';

		}
		else
		{		
		
			document.forms[0].rectypedesc.value='';
			document.forms[0].rectype.value = '';						

			document.forms[0].acccode.value='';
			document.forms[0].acccodedesc.value='';

			document.forms[0].dept.value='';
			document.forms[0].deptdesc.value='';

			target.focus();
		}
	

	}

function acccodelkup()
		{
		var msg="";
		var target				= document.forms[0].acccode;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";
		
		var v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//'<%=ext_acc_interface_yn%>';
		var	v_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//'<%=str_single_service_grp_yn%>';		
		var v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//'<%=str_acc_episode_type%>';
		var v_acc_catg_code = document.forms[0].str_acc_category_code.value;//'<%=str_acc_category_code%>';		
		var v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//'<%=str_acc_serv_grp_used_yn%>';		
		var v_serv_grp = document.forms[0].str_service_grp.value;//'<%=str_service_grp%>';		
		var v_episode_type =document.forms[0].str_episode_type.value;// '<%=str_episode_type%>';		
		var v_reln_code =document.forms[0].str_reln_code.value;//'<%=str_reln_code%>';		
		var v_rec_type = document.forms[0].rectype.value;		
		var locale = document.forms[0].locale.value;

//PE Changes		
//		sql = "	select distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`"+locale+"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code  and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `"+v_rec_type+"` and a.status is null and ((`"+v_single_serv_grp+"`=`Y` and a.episode_type in (`U`, `"+v_acc_episode_type+"`) and a.category in (`UNRESTRICTED`,`"+v_acc_catg_code+"` ) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and a.blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  a.blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and a.episode_type in (`U`, `"+v_episode_type+"`) and a.category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))";	

	/*Commented by MuthuN against showing the Account code for National and Unrestricted on 06-06-12 & Updated Query is given below
			sql = "select distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`"+locale+"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `"+v_rec_type+"` and a.status is null and ((`"+v_single_serv_grp+"`=`Y` and a.episode_type in (`U`, `"+v_acc_episode_type+"`) and a.category in (`UNRESTRICTED`,`"+v_acc_catg_code+"` ) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and a.blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  a.blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and a.episode_type in (`U`,`"+v_episode_type+"`) and a.category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))";*/

	sql = "select account_code,long_desc from (select a.account_code, b.long_desc , decode(a.episode_type, `"+v_acc_episode_type+"`,`1`,`999`) order1, decode(a.category,`"+v_acc_catg_code+"`	,1,999) order2 from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`"+locale+"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `"+v_rec_type+"` and a.status is null and a.episode_type in (`U`, `"+v_acc_episode_type+"`) and a.category in(`UNRESTRICTED`,`"+v_acc_catg_code+"`) order by 3,4 ) where rownum=1";

			search_code="account_code"; 
			search_desc="long_desc";
			
			//search_code="a.account_code"; - Commented by Muthukumar on 6-6-12 against Account_code
			//search_desc="along_desc"; - Commented by Muthukumar on 6-6-12 against Account_code
//		tit="Account Codes"; 
		tit=encodeURIComponent(getLabel("eBL.ACCOUNT_CODE.label","BL"));
		//tit=getLabel("eBL.ACCOUNT_CODE.label","BL");
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();

		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");
		
			document.forms[0].acccodedesc.value=arr[0];
		    document.forms[0].acccode.value=arr[1];
			document.forms[0].acccode.focus();				
			
		}
		else
		{		
		
			document.forms[0].acccodedesc.value='';
			document.forms[0].acccode.value = '';									

			target.focus();
		}
	}
	function deptlkup()
	{
		var msg="";
		var target				= document.forms[0].dept;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features	= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";		
		var v_dept_code =document.forms[0].str_ext_dept_code.value;//'<%=str_ext_dept_code%>';
		var v_facility_id =document.forms[0].strfacilityid.value;// '<%=strfacilityid%>';
		var locale = document.forms[0].locale.value;		
		sql = "	select dept_code, long_desc from am_dept_lang_vw where language_id=`"+locale+"` and dept_code like nvl(`"+v_dept_code+"`,dept_code )";
		search_code="dept_code";
		search_desc="long_desc";
//		tit="Accounting Departments"; 
		tit=encodeURIComponent(getLabel("eBL.ACCOUNTING_DEPT.label","BL"));
		//tit=getLabel("eBL.ACCOUNTING_DEPT.label","BL");		
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();
		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");		
			document.forms[0].deptdesc.value=arr[0];
		    document.forms[0].dept.value=arr[1];
			document.forms[0].dept.focus();		
		}
		else
		{				
			document.forms[0].deptdesc.value='';
			document.forms[0].dept.value = '';						
			target.focus();
		}
	

	}	
function funCurStlmt()
{ 
	var total_records=document.forms[0].total_records.value;
	var v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;

		for(var j=0;j<total_records;j++)
	{
		var pend_amt=eval("document.forms[0].pend_set"+j);
		var curr_set=eval("document.forms[0].curr_set"+j);
		if(curr_set.value=="")
		{
			curr_set.value=0.00;
			putdeci(curr_set);
			//curr_set.focus();
			curr_set.select();
			return false;
		}


		if ( parseFloat(curr_set.value) > parseFloat(pend_amt.value))
		{
			 alert(getMessage("BL9658","BL"));
			//alert("Current Settlements should not be greater then Pending Settlements");
			//curr_set.value="";		
			curr_set.select();
		}
		totCurrSlmt();
		
		
	
	if(parseFloat(curr_set.value) >parseFloat(v_tot_curr_stlmt))
		{
		//alert('Testing 1');
			alert(getMessage("BL9621","BL"));
			curr_set.value=0.00;
			putdeci(curr_set);
			//curr_set.focus();
			curr_set.select();
			return false;
		}
	}
}

	/*var settled_amt_det=document.forms[0].billslmtamtdet.value;
	var a1=new Array();
	var total=0.0;
	for(var j=0;j<total_records;j++)
	{
		var v_curr_set=eval("document.forms[0].curr_set"+j);	
		a1[j]=v_curr_set.value;
		total=parseFloat(total)+parseFloat(a1[j]);
		alert("total :"+total);

		if(parseFloat(total)!=parseFloat(settled_amt_det))
			{
		alert("Allocated Amt Must Be Equal To Settled Amt");
		//v_curr_set.focus();
		return false;
	}
	}*/




function funCurrMultSlmt()
		{
	      var s_amt=document.forms[0].billslmtamtdet.value;		  
		  var total_records=document.forms[0].total_records.value;	
		  if(total_records>0)
			{
		  for(var j=0;j<total_records;j++)
			{
			  var pend_amt=eval("document.forms[0].pend_set"+j);			  
			  var v_pend_amt=pend_amt.value;
			  var curr_set=eval("document.forms[0].curr_set"+j);
			  if(parseFloat(s_amt)> parseFloat(pend_amt.value))
				{				  		 
				  curr_set.value=v_pend_amt;				  
				  putdeci(curr_set);
				}
				else{					
					if(parseFloat(s_amt)>0)
					{					 
					 curr_set.value=s_amt;
					 putdeci(curr_set);
					}
					else{curr_set.value=0;
					putdeci(curr_set);
						}

				 }
				s_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);					

			totCurrSlmt();
			}
			}
		}

	function totCurrSlmt()
		{
			var tot_curr_set=0.0;
			var v_curr_set="";
			var a1=new Array();
			var s_amt=document.forms[0].billslmtamtdet.value;
			var total_records=document.forms[0].total_records.value;		  
			for(var j=0;j<total_records;j++)
			{
				v_curr_set=eval("document.forms[0].curr_set"+j);
				a1[j]=v_curr_set.value;
				 if(a1[j]==""){a1[j]="0.0";}
				tot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);
				
			}
			document.forms[0].tot_curr_stlmt.value=tot_curr_set;
			var total_curr_stlmt=eval("document.forms[0].tot_curr_stlmt");
			putdeci(total_curr_stlmt);
			
		}

	function slmt_amt_disabled_YN()
	{
		var alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;
		var called_frm=document.forms[0].called_frm.value;
		var str_episode_type=document.forms[0].episode_type.value;
		var slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;

		if(alw_co_wit_bl_slmt_yn == "Y" && called_frm=="CHECKOUT_VISIT" && str_episode_type == "E")
		{
			document.forms[0].billslmtamtdet.disabled=true;
		}
		else
		{
			if(slmt_amt_disabled_YN=="Y")
			{
				document.forms[0].billslmtamtdet.disabled=true;
			}
			else
			{
				document.forms[0].billslmtamtdet.disabled=false;
			}
		}
	}
	
	//Added for KDAH-CRF-0318
	function fnDispBillTaxDesc(){
		var billLevelTax = document.BillSlmtDetForm.billLevelTax.value;
		var addlChargeAmt = document.BillSlmtDetForm.addlChargeAmtForBill.value;
		if(addlChargeAmt == ''){
			addlChargeAmt = 0;
		}
		if(billLevelTax == 'Y' && addlChargeAmt > 0){
			document.getElementById('billLevelTaxDesc').innerText = '(Including Bill level Tax)';
			document.getElementById('billLevelTaxDesc').style.display = 'inline';			
		}
	}
	</script>	  
	<%
//String cash_slmt_flag = "";		
if( strslmttype == null) strslmttype="";
/* Commented and moved up for PE Changes
try{
		String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+strfacilityid+"'";

				stmt=con.createStatement();
				rs21=stmt.executeQuery(query_ext_acc);
				if(rs21 != null)
				{
					while(rs21.next())
					{
						ext_acc_interface_yn =rs21.getString("ext_acc_interface");
						System.out.println("ext_acc_interface_yn :"+ext_acc_interface_yn);
					}
				}
				
		   }
		   catch(Exception e )
				{
                   e.printStackTrace();

				out.println(e);} 
		   finally
			{
				if (rs21 != null)   rs21.close();
				if (stmt != null) stmt.close();		
			}	
*/
	try{
			
			CallableStatement call = 
			con.prepareCall("{ call blopin.proc_ext_acc_serv_group_check (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,strfacilityid);
			call.setString(2,strbilldoctypecode);
			call.setString(3,strbilldocnum);
			call.setString(4,"BI");//P_RECEIPT_NATURE_CODE
			call.registerOutParameter(5,java.sql.Types.VARCHAR);	
			call.registerOutParameter(6,java.sql.Types.VARCHAR);	
			call.registerOutParameter(7,java.sql.Types.VARCHAR);	
			call.registerOutParameter(8,java.sql.Types.VARCHAR);	
			call.registerOutParameter(9,java.sql.Types.VARCHAR);	
			call.registerOutParameter(10,java.sql.Types.VARCHAR);	
			call.registerOutParameter(11,java.sql.Types.VARCHAR);	
			call.registerOutParameter(12,java.sql.Types.VARCHAR);	
			call.registerOutParameter(13,java.sql.Types.VARCHAR);	
			call.registerOutParameter(14,java.sql.Types.VARCHAR);	
			call.registerOutParameter(15,java.sql.Types.VARCHAR);	
			call.registerOutParameter(16,java.sql.Types.VARCHAR);	
			call.registerOutParameter(17,java.sql.Types.VARCHAR);	
			
			call.execute();									

			str_receipt_type_code	 = call.getString(5);	
			//strrectype  = call.getString(5);	
			str_ext_acc_facility_id  	 = call.getString(6);	
			str_ext_account_code	 = call.getString(7);	
			str_ext_dept_ind		 = call.getString(8);	
			str_ext_dept_code     	 = call.getString(9);	
			str_single_service_grp_yn = call.getString(10);	
			str_service_grp		= call.getString(11);	
			str_acc_episode_type	= call.getString(12);	
			str_acc_category_code	= call.getString(13);	
			str_acc_serv_grp_used_yn	= call.getString(14);	
			str_reln_code		= call.getString(15);	
			str_episode_type		= call.getString(16);	
			//System.err.println("In Det Page str_episode_type:"+str_episode_type);
			str_error_text		= call.getString(17);	

			call.close();
	
			if (str_receipt_type_code == null) str_receipt_type_code = "";
			if (str_ext_acc_facility_id == null) str_ext_acc_facility_id = "";
			if (str_ext_account_code == null) str_ext_account_code = "";
			if (str_ext_dept_ind == null) str_ext_dept_ind = "";
			if (str_single_service_grp_yn == null) str_single_service_grp_yn = "";
			if (str_service_grp == null) str_service_grp = "";
			if (str_acc_episode_type == null) str_acc_episode_type = "";
			if (str_acc_category_code == null) str_acc_category_code = "";
			if (str_acc_serv_grp_used_yn == null) str_acc_serv_grp_used_yn = "";
			if (str_reln_code == null) str_reln_code = "";
			if (str_episode_type == null) str_episode_type = "";
			if (str_error_text == null) str_error_text = "";
			if (str_ext_dept_code == null) str_ext_dept_code = "";

		
			
	
			%> <script> 
				var v_error_text = '<%=str_error_text%>';					
				if ( v_error_text != '')
			    {
						alert(v_error_text);

						//return false;
						//window.close();	
				}
				</script>  
			<%

		}
		catch(Exception e )
			{
			 e.printStackTrace();
			 //out.println(e);
			} 


%>

</HEAD>

	<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onload='slmt_amt_disabled_YN();funServiceDet_onLoad();fnDispBillTaxDesc();' >	
	<FORM name='BillSlmtDetForm' id='BillSlmtDetForm' method='post'  action=''  scrolling='NO' >
<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->
<%
	try
		{
			String drug_penalty_yn ="";
			//int strdrugpenaltyamt =0;
			double strdrugpenaltyamt =0.0;
			CallableStatement call = con.prepareCall("{ call bl_addl_charge_for_bill.check_for_addl_charge(?,?,?,?,?)}");	
			call.setString(1,strfacilityid);
			call.setString(2,strbilldoctypecode);
			call.setString(3,strbilldocnum);
			call.registerOutParameter(4,java.sql.Types.VARCHAR); 
			call.registerOutParameter(5,java.sql.Types.INTEGER);
			call.execute();				
			drug_penalty_yn=call.getString(4);
			strdrugpenaltyamt=call.getDouble(5);
			//strdrugpenaltyamt=call.getInt(5);
			/*System.out.println("1. strfacilityid	  ==> "+strfacilityid);
			System.out.println("2. strbilldoctypecode ==> "+strbilldoctypecode);
			System.out.println("3. strbilldocnum      ==> "+strbilldocnum);
			System.out.println("4. drug_penalty_yn    ==> "+drug_penalty_yn);
			System.out.println("5. strdrugpenaltyamt  ==> "+strdrugpenaltyamt);*/
			call.close();			
			if ( drug_penalty_yn == null ) drug_penalty_yn = "N";
			/*System.out.println("11. strfacilityid	  ==> "+strfacilityid);
			System.out.println("12. strbilldoctypecode ==> "+strbilldoctypecode);
			System.out.println("13. strbilldocnum      ==> "+strbilldocnum);
			System.out.println("14. drug_penalty_yn    ==> "+drug_penalty_yn);
			System.out.println("15. strdrugpenaltyamt  ==> "+strdrugpenaltyamt);
			//if ( strdrugpenaltyamt ==  ) strdrugpenaltyamt = "";*/
%>
	<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->
		<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		 
		<tr><td class='columnHeader' colspan='16'><fmt:message key="Common.BillDetails.label" bundle="${common_labels}"/></td></tr>
		<tr>
<!--	<td class="label" width="25%">Bill No</td>	 -->
		<td class="label" width="25%"><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></td>	 
		<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="billdoctype" id="billdoctype" SIZE="7" MAXLENGTH="10" 				VALUE='<%=strbilldoctypecode%>'  style='text-align:left' READONLY> / <INPUT TYPE="TEXT" 
		 name="billdocnum" id="billdocnum" SIZE="8" MAXLENGTH="10"  VALUE='<%=strbilldocnum%>' style='text-align:right' READONLY></td>
	
<!--	<td class="label" width="25%">Payable Amount</td>	-->
		<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/> &nbsp;<span style='display: none;font-size: 9px;' id='billLevelTaxDesc' name='billLevelTaxDesc'></span></td>	
<!--
		<td>&nbsp;<INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="8" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;<INPUT TYPE="button"  class="BUTTON" VALUE="  OK  " onClick='billslmtprocess()'><td> 	-->	
		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;</td> 
<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->
<%
if(drug_penalty_yn.equals("Y"))
	{
%>	
	<td class="label" width="25%"><fmt:message key="eBL.DrugPenalty.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><INPUT TYPE="TEXT" name="drugpenality" id="drugpenality" SIZE="15" MAXLENGTH="20" VALUE='<%=strdrugpenaltyamt%>'  style='text-align:right' readOnly/> </td>
<%
	}
	}
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_addl_charge_for_bill.check_for_addl_charge:"+e); 
		}	
%>	
<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->
		</tr>
		<tr>
<!--added here by ram-->
<%	
		double remOutStnndAmt = 0.00;
		try{
			remOutStnndAmt = Double.parseDouble(strbillpayableamt) - Double.parseDouble(strslmtamt);			
		}
		catch(Exception e){
			remOutStnndAmt = 0.00;
		}
		if (ext_acc_interface_yn.equals("Y"))
		{
%>	
		<td class="label"  width="25%"><fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' readonly name="rectype" id="rectype" maxlength='3' size='3'  tabindex='1' value='<%=str_receipt_type_code%>'><input type='button' class='button' name="rectypebut" id="rectypebut" value='?' onClick="return rectypelkup()" tabindex='2'>
		<img src='../../eCommon/images/mandatory.gif'></td>
		<input type= hidden name="rectypedesc" id="rectypedesc"  value='<%=strrectypedesc%>'>	
			
		<td class="label" width="25%"><fmt:message key="eBL.ACCOUNT_CODE.label" bundle="${bl_labels}"/></td>	
		<td width="25%" class="fields"><input type='text' readonly name="acccode" id="acccode" maxlength='10' size='10'  tabindex='3' value='<%=str_ext_account_code%>'><input type='button' class='button' name="acccodebut" id="acccodebut" value='?' onClick="return acccodelkup()"  tabindex='4'><img src='../../eCommon/images/mandatory.gif'>&nbsp;</td>
		<input type= hidden name="acccodedesc" id="acccodedesc"  value='<%=stracccodedesc%>'>	
		<!-- <td class="fields" width="25%">
		<td class="fields" width="25%"> -->
		</tr>
		<tr>
		<td class="label" width="25%"><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><input type='text' readonly name="dept" id="dept" maxlength='6' size='6'  tabindex='5' value='<%=str_ext_dept_code%>'><input type='button' class='button' name="deptbut" id="deptbut" value='?' onClick="return deptlkup()" tabindex='6'><img src='../../eCommon/images/mandatory.gif'></td>
		<input type= hidden name="deptdesc" id="deptdesc"  value='<%=strdeptdesc%>'>	
		<td class="label" width="25%"><fmt:message key="eBL.SLMT_AMT.label" bundle="${bl_labels}"/>	
		<td width="25%" class="fields"><INPUT TYPE="TEXT" name="billslmtamtdet" id="billslmtamtdet" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2,1))' onBlur='putdeci(this);funServiceDet()'> </td>
<%
			if("MOHBR".equals(custId)){ %>
				</tr>
				<tr>
					<td class="label" width="25%"><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}"/>	
					<td width="25%" class="fields"><INPUT TYPE="TEXT" readonly name="remOutStndAmt" id="remOutStndAmt" SIZE="14" MAXLENGTH="10" 	VALUE='<%=remOutStnndAmt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2))' onBlur='putdeci(this);funServiceDet()'> </td>
					<td width="25%">&nbsp;</td>
					<td width="25%">&nbsp;</td>
			<%}
		}
		else
		{
%>
		<td class="label" width="25%"><fmt:message key="eBL.SLMT_AMT.label" bundle="${bl_labels}"/>	
		<td width="25%" class="fields"><INPUT TYPE="TEXT" name="billslmtamtdet" id="billslmtamtdet" SIZE="14" MAXLENGTH="10" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2))' onBlur='putdeci(this);funServiceDet()'> </td>
		<%
			if("MOHBR".equals(custId)){ %>
			<td class="label" width="25%"><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}"/>	
			<td width="25%" class="fields"><INPUT TYPE="TEXT" readonly name="remOutStndAmt" id="remOutStndAmt" SIZE="14" MAXLENGTH="10" 	VALUE='<%=remOutStnndAmt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2))' onBlur='putdeci(this);funServiceDet()'> </td>					
		<%}
			else{ %>
				<td width="25%">&nbsp;</td>
			<td width="25%">&nbsp;</td>	
			<%}
		}
%>		
<!--here end-->
	</tr>
	<tr>
	<td class="label" width="25%"><fmt:message key="eBL.RECD_THRU_MAIL.label" bundle="${bl_labels}"/>
	<td width="25%" class="fields" colspan='3'><input type='checkbox' name='recievedthrumail' id='recievedthrumail' ></td>
	</tr>
		<!-- <td class="label"> </td> -->
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
		</table> 

<INPUT TYPE="HIDDEN" name="pagecloseind" id="pagecloseind"   SIZE="50" MAXLENGTH="100" 	VALUE="0">		
<INPUT TYPE="HIDDEN" name="dfltslmttypecode" id="dfltslmttypecode" SIZE="50" MAXLENGTH="100" 	VALUE='' >	 	
<INPUT TYPE="HIDDEN" name="slmtdate" id="slmtdate"	   SIZE="20" MAXLENGTH="20" 	VALUE=""> 
<INPUT TYPE="HIDDEN" name="slmtdocrefdesc" id="slmtdocrefdesc" SIZE="50" MAXLENGTH="100"	VALUE="">	
<INPUT TYPE="HIDDEN" name="slmtdocref" id="slmtdocref"	   SIZE="50" MAXLENGTH="100" 	VALUE="">
<INPUT TYPE="HIDDEN" name="ext_acc_interface_yn" id="ext_acc_interface_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=ext_acc_interface_yn%>'>
<INPUT TYPE="HIDDEN" name="str_ext_acc_facility_id" id="str_ext_acc_facility_id" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_acc_facility_id%>'>
<INPUT TYPE="HIDDEN" name="str_ext_account_code" id="str_ext_account_code" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_account_code%>'>
<INPUT TYPE="HIDDEN" name="str_ext_dept_ind" id="str_ext_dept_ind"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_dept_ind%>'>
<INPUT TYPE="HIDDEN" name="str_ext_dept_code" id="str_ext_dept_code"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_dept_code%>'>
<INPUT TYPE="HIDDEN" name="str_single_service_grp_yn" id="str_single_service_grp_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_single_service_grp_yn%>'>
<INPUT TYPE="HIDDEN" name="str_service_grp" id="str_service_grp"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_service_grp%>'>
<INPUT TYPE="HIDDEN" name="str_acc_episode_type" id="str_acc_episode_type" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_episode_type%>'>

<INPUT TYPE="HIDDEN" name="str_acc_serv_grp_used_yn" id="str_acc_serv_grp_used_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_serv_grp_used_yn%>'>	
<INPUT TYPE="HIDDEN" name="str_acc_category_code" id="str_acc_category_code"  SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_category_code%>'>	
<INPUT TYPE="HIDDEN" name="str_reln_code" id="str_reln_code"      SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_reln_code%>'>	

<INPUT TYPE="HIDDEN" name="str_episode_type" id="str_episode_type"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_episode_type%>'>
<INPUT TYPE="HIDDEN" name="strfacilityid" id="strfacilityid"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=strfacilityid%>'>
<input type="hidden" name="locale" id="locale"  value='<%=locale%>'>
<input type="hidden" name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
<input type="hidden" name="service_check" id="service_check"  value=''>
<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>
<input type='hidden' name="query_string" id="query_string"  value="<%=query_string%>">
<input type='hidden' name="strroundingamt" id="strroundingamt"  value='<%=strroundingamt%>'>

<input type='hidden' name="slmt_amt_disabled_YN" id="slmt_amt_disabled_YN"  value='<%=slmt_amt_disabled_YN%>'>

<input type='hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
<input type='hidden' name="alw_co_wit_bl_slmt_yn" id="alw_co_wit_bl_slmt_yn"  value='<%=alw_co_wit_bl_slmt_yn%>'>
<input type='hidden' name="episode_type" id="episode_type"  value='<%=strepisodetype%>'>
<input type='hidden' name='custId' id='custId' value='<%=custId %>'>
<input type='hidden' name='addlChargeAmtForBill' id='addlChargeAmtForBill' id='addlChargeAmtForBill' value='<%=addlChargeAmtForBill %>'>
<input type='hidden' name='billLevelTax' id='billLevelTax' id='billLevelTax' value='<%=billLevelTax %>'>
<input type='hidden' name='billAlreadyPrinted' id='billAlreadyPrinted' id='billAlreadyPrinted' value='<%=billAlreadyPrinted %>'>
</FORM>	

</BODY>
<%
}catch(Exception e)
	{
	 e.printStackTrace();
	System.out.println("Exception in main detl="+e);}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}
%>
</HTML>

