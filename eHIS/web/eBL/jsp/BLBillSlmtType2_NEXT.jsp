<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           	    Developer Name
-----------------------------------------------------------------------------------------------
1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth
2            V210224             8157          NMC-JD-CRF-0072               Shikha Seth
 -->
<%@ page import="eCommon.Common.CommonBean"%>
<%@ page import="eBL.BLReportIdMapper"%>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*, java.util.*, java.net.*, eXH.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<%

	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt		= null;
	CallableStatement call = null;
	ResultSet rs = null; 
	ResultSet rs21 = null; 
	ResultSet rs2= null; ResultSet rscurr=null;
	con	=	ConnectionManager.getConnection(request);
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	String		strfacilityid ="";String strscashcountercode="";
	int noofdecimal=2;

	String batch_no_reqd_yn="",slmt_doc_ref_date_reqd_yn="", readonly1="";

	//unused variable, commented on 09/06/05
	String      strloggeduser = "";
	String		strslmtidno = request.getParameter("slmtidno");	
	String		strslmtpayername = request.getParameter("slmtpayername");
	String		strbilldoctypecode = request.getParameter("billdoctypecode");	
	String		strbilldocnum = request.getParameter("billdocnum");	
	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= "";	String		str_ext_dept_ind = "";
	String		str_ext_dept_code     = "";	String		str_single_service_grp_yn = "";
	String		str_service_grp		= "";	String		str_acc_episode_type= "";
	String		str_acc_category_code	= "";	String		str_acc_serv_grp_used_yn	= "";
	String		str_reln_code		= "";	String		str_episode_type		= "";
	String		str_error_text		= "";	String		short_desc= "";
	String    action_ind="";
	String str_credit_card_machine_int_yn = "N";	String str_credit_card_machine_id= "";	String	 str_err_code= "";
	String	str_sys_message_id = "";String field_separator="";String piped_op="";String credit_card_approvd_YN="";
	String strApprovel="",strMerchant="",strTermIdentNo="",strExpiryDate="",strTransTime ="";
	String rec_ref="";
	
	String function_id = request.getParameter("function_id");
	String custId = BLReportIdMapper.getCustomerId();	
	if(function_id == null) function_id="";

	//Added by Sethu for GHL-CRF-0415 on 19/04/2017
	boolean isDebugYN = false; 
	String  strslmttype= request.getParameter("slmttype");
	String	strpatientid = request.getParameter("patientid");
	//V210113
	String 	strcoupon_yn = request.getParameter("coupon_yn");
	String  patMembershipID = "";
	String  coupon_yn = "";
	//V210113
	String couponcode="";//V210224
	String strApplicationID = "";
	String payTMOption = "B";

	Properties p;		
	String strClientIpAddress = "";
	//Added by Sethu for GHL-CRF-0415 on 19/04/2017

	String    billslmtamt=""; String    slmttype=""; String    cash_given=""; 
	String    cash_return=""; String    instref="";   String    instdate=""; String    creditcardco="";     String    instbankname=""; String   instbranch=""; String    batchno=""; String    apprrefno=""; 
	String    saledraftno="";   String    onlineapproval="checked";
	String temp_bank_credit=""; String p_instremarkcode=""; String sys_date="";String billslmtamtdet2="",slmt_change="",slmt_flag="",cashier_cheque_yn="";
	String readonly_fld="",disabled_fld="";
	String sale_draft_reqd_yn="",payer_name_reqd_yn="",payer_ref_reqd_yn="",error_level="",sys_message_id="",error_text="";
	String credit_card_num_yn="";
	String credit_card_co_yn="";
	String approval_code_yn="";
	String credit_card_check_yn="";
	String val_crCard="";
	double billslmtamtdetDb=0.00;
	String locale	= (String)session.getAttribute("LOCALE");	
	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) 
	{strslmtidno = "";}

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
	{strslmtpayername = "";}
	
	/* ML-MMOH-CRf-0527 - Rajesh V */
	boolean chequeCategorize = CommonBean.isSiteSpecific(con, "BL", "CHEQUE_TYPE_ENABLED");
	//Added for ML-MMOH-CRF-1088 - Rajesh V
	boolean chequeLengthChange = CommonBean.isSiteSpecific(con, "BL", "CHEQUE_OTHERS_MAX_CHARS");
	//Added against ML-MMOH-SCF-1576
	boolean isSiteSpec = false;
	String siteSettletypeYN = "N";	
	try {
			isSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "GST_FOR_CREDIT_CARD");
			if (isSiteSpec)
				siteSettletypeYN = "Y";
			else
				siteSettletypeYN = "N";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in isSiteSpec_GHL " + e);
		}
	//Added against ML-MMOH-SCF-1576

	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
	String sqlStatement = "";
	int ccAppletCount = 0;

	//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
	String slmt_check_status = "N";
	String standard_code = "", segment_id = "";

	boolean siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	//V210113
	String coupons=""; //V210224
	String couponAndAmts=""; //V210224
	//Added by Sethu for GHL-CRF-0415 on 01/09/2017
	try
	{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		if(isDebugYN)
			System.err.println("***Inside Settlement Type 2 - Patient ID... "+strpatientid+" ***Settlement Type... "+strslmttype+" strcoupon_yn="+strcoupon_yn);

		String queryApplicationID="select NVL(APPLICATION_ID,'') from XH_FILTER_DMS_VW where KEY_1 = ?";
		pstmt = con.prepareStatement(queryApplicationID);
		pstmt.setString(1,strslmttype);
		rs = pstmt.executeQuery() ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				strApplicationID = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
	}		
	catch(Exception e)
	{
		out.println("Exception while fetching APPLICATION_ID from XH_FILTER_DMS_VW :"+e);
	}
	
	if(isDebugYN)
		System.out.println("***Inside Settlement Type 2 - Application ID... "+strApplicationID);	
	 
	try
	{
		String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				sys_date = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		stmt.close();
	}		
	catch(Exception e)
	{
		out.println("Exception :"+e);
	}
	//V210113 start
	try
	{
		String membershipIDQuery="select nvl(ALT_ID4_NO,'') from mp_patient where patient_id = '"+strpatientid+"'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(membershipIDQuery) ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				patMembershipID = checkForNull(rs.getString(1));
			}
		}
		if(rs != null) rs.close();
		stmt.close();
	}		
	catch(Exception e)
	{
		out.println("Exception patMembershipID:"+e);
		e.printStackTrace();
	}
	//V210113 end
  	try
  	{	
		
		

		//con	=	ConnectionManager.getConnection(request);			
		strfacilityid	=  (String) session.getValue("facility_id");
		//unused variable, commented on 09/06/05
		strloggeduser	=  (String) session.getValue("login_user");		
		
		//Added by Sethu for GHL-CRF-0415 on 19/04/2017
		p = (java.util.Properties)session.getValue("jdbc");
		strClientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");

		String cash_slmt_flag = "";				
		String ext_acc_interface_yn = "";
		String querystring=(String)request.getQueryString();
		if( strslmttype == null) strslmttype="";
		billslmtamtdet2=request.getParameter("billslmtamt");		
		if(billslmtamtdet2==null)  billslmtamtdet2="";
		billslmtamtdetDb=Double.parseDouble(billslmtamtdet2);
		if(strcoupon_yn == null) strcoupon_yn ="";//V210113
		rec_ref=request.getParameter("rec_ref");
		if(rec_ref==null || rec_ref.equals("")) rec_ref="";
		
		action_ind=request.getParameter("action");	
		if(action_ind==null || action_ind.equals("")) action_ind="";


		strscashcountercode=request.getParameter("strscashcountercode");
		if(strscashcountercode==null || strscashcountercode.equals("")) strscashcountercode="";


		credit_card_approvd_YN=request.getParameter("credit_card_approvd_YN");
		if(credit_card_approvd_YN==null || credit_card_approvd_YN.equals("")) credit_card_approvd_YN="N";

		slmt_change=request.getParameter("slmt_change");
		if(slmt_change==null || slmt_change.equals("undefined")) slmt_change="N";

		if(action_ind.equals("modify") && !slmt_change.equals("Y"))
		{	
			//V210113 start
			coupon_yn = request.getParameter("coupon_yn");
			if(coupon_yn.equals("")) coupon_yn = "";
			//V210113 end
			//V210224 start
			coupons = request.getParameter("couponcode");
			if(coupons.equals("")) coupons = "";
			System.err.println("coupons="+coupons);
			couponAndAmts = request.getParameter("couponAndAmt");
			if(couponAndAmts.equals("")) couponAndAmts="";
			//V210224 end
			billslmtamt=request.getParameter("billslmtamt");
			if(billslmtamt.equals("")) billslmtamt="";	
			slmttype=request.getParameter("slmttype");
			if(slmttype.equals("")) slmttype="";
			cash_given=request.getParameter("cash_given");
			if(cash_given.equals("")) cash_given="";
			cash_return=request.getParameter("cash_return");
			if(cash_return.equals("")) cash_return="";
			instref=request.getParameter("instref");
			if(instref==null) instref="";		
			instdate=request.getParameter("instdate");
			if(instdate==null) instdate="";
			creditcardco=request.getParameter("creditcardco");
			if(creditcardco.equals("")) creditcardco="";
			instbankname=request.getParameter("instbankname");
			if(instbankname.equals("")) instbankname="";
			p_instremarkcode=request.getParameter("instremarkcode");
			if(p_instremarkcode.equals("")) p_instremarkcode="";

			slmt_flag=request.getParameter("slmt_flag");
			if(slmt_flag.equals("")) slmt_flag="";
						if(!slmt_flag.equals("A"))
			{
				temp_bank_credit=instbankname;
			}
			else{
				temp_bank_credit=creditcardco;
				}
			instbranch=request.getParameter("instbranch");
			if(instbranch.equals("")) instbranch="";
			batchno=request.getParameter("batchno");
			if(batchno.equals("")) batchno="";
			apprrefno=request.getParameter("apprrefno");
			if(apprrefno.equals("")) apprrefno="";
			saledraftno=request.getParameter("saledraftno");
			if(saledraftno.equals("")) saledraftno="";
			strslmtpayername=request.getParameter("payername");
			if(strslmtpayername.equals("")) strslmtpayername="";
			strslmtidno=request.getParameter("recrefidno");
			if(strslmtidno.equals("")) strslmtidno="";
			onlineapproval=request.getParameter("onlineapproval");
			if(onlineapproval.equals("")) onlineapproval="";		
		}	
	
//cc interface logic
		try
		{
			piped_op=request.getParameter("piped_op");
			if(piped_op==null || piped_op.equals("")) piped_op="";
			field_separator=request.getParameter("field_separator");
			if(field_separator==null || field_separator.equals("")) field_separator="";
			StringTokenizer st=new StringTokenizer(piped_op,field_separator);
			//int i=0;
			while(st.hasMoreTokens())
			{	
				strApprovel = st.nextToken();
				apprrefno = st.nextToken();
				saledraftno = st.nextToken();
				strMerchant  = st.nextToken();
				strTermIdentNo  = st.nextToken();						
				temp_bank_credit  = st.nextToken();
				instref  = st.nextToken();
				//instdate  = st.nextToken();						
				instdate  = st.nextToken();
				batchno  = st.nextToken();
				strExpiryDate  = st.nextToken();													
				strTransTime  = st.nextToken();
				strslmtidno  = st.nextToken();
				p_instremarkcode  = st.nextToken();
				strslmtpayername  = st.nextToken();
				//i++;
			}
			//for validating credit card num
			
				String strqry = "{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS('"+strslmttype+"','"+instref+"',?,?,?,?,?,?,?,?,?,?,?,?) }";
				
			call = con.prepareCall(strqry);							
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);
				call.registerOutParameter(10,java.sql.Types.VARCHAR);
				call.registerOutParameter(11,java.sql.Types.VARCHAR);
				call.registerOutParameter(12,java.sql.Types.VARCHAR);

			call.execute();
			sale_draft_reqd_yn=call.getString(1);
			if(sale_draft_reqd_yn == null) sale_draft_reqd_yn="";
			payer_name_reqd_yn=call.getString(2);
			if(payer_name_reqd_yn == null) payer_name_reqd_yn="";
			payer_ref_reqd_yn=call.getString(3);
			if(payer_ref_reqd_yn == null) payer_ref_reqd_yn="";

			/***  Added against CRF  AAKH-CRF-0014   37864				*/
			batch_no_reqd_yn=call.getString(4);	
			if(batch_no_reqd_yn == null) batch_no_reqd_yn="";			
  
			slmt_doc_ref_date_reqd_yn=call.getString(5);
			if(slmt_doc_ref_date_reqd_yn == null) slmt_doc_ref_date_reqd_yn="";			

				credit_card_num_yn=call.getString(6);
				if(credit_card_num_yn == null) credit_card_num_yn="";
				credit_card_co_yn=call.getString(7);
				if(credit_card_co_yn == null) credit_card_co_yn="";
				approval_code_yn=call.getString(8);
				if(approval_code_yn == null) approval_code_yn="";
				credit_card_check_yn=call.getString(9);
				if(credit_card_check_yn == null) credit_card_check_yn="";
				
				error_level=call.getString(10);
				if(error_level == null) error_level="";
				sys_message_id=call.getString(11);
				if(sys_message_id == null) sys_message_id="";
				error_text=call.getString(12);
				if(error_text == null) error_text="";


				call.close();	


			if ((error_level.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))
			{
				if (error_level.equals("10") ||(!error_text.equals("")))
				{
%>			
					<script>					
						var v_error = '<%=error_text%>';												
						alert(v_error);				 						
					</script>
<%				
				}
				if(!sys_message_id.equals(""))
				{
%>
					<script>
						alert(getMessage('<%=sys_message_id%>','BL'));
						//alert("Invalid Credit Card Number");						
						document.forms[0].instref.value="";
						document.forms[0].batchno.value="";
						document.forms[0].saledraftno.value="";
						document.forms[0].payername.value="";
					</script>
<%				
				}
			}
			//end CC validation
			if(credit_card_approvd_YN.equals("Y"))
			{
%>					
				<script>							
					parent.frames[0].document.forms[0].billslmtamt.disabled=true;
					parent.frames[0].document.forms[0].slmttype.disabled=true;
				</script>
<%
			}
		}
		catch(Exception cc)
		{
			System.err.println("Exception  cc"+cc);
			
		}
		//end cc

		try 
		{
			pstmt = con.prepareStatement("select SHORT_DESC  from bl_slmt_type_lang_vw where SLMT_TYPE_CODE='"+strslmttype+"' and LANGUAGE_ID='"+locale+"' ");
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{						
				while( rs2.next() ) 
				{												
					short_desc = rs2.getString( "short_desc" ) ;							
					if ( short_desc == null ) short_desc ="";
		 		}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			out.println(e.toString());	
		}
	
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null) ext_acc_interface_yn="N";
/* Commented and added getparameter for PE Changes
		String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+strfacilityid+"'";
		try
		{
			stmt=con.createStatement();
			rs21=stmt.executeQuery(query_ext_acc);
			if(rs21 != null)
			{
				while(rs21.next())
				{
					ext_acc_interface_yn =rs21.getString("ext_acc_interface");
				}
			}
			if(rs21 != null) rs21.close();
			stmt.close();
		}  
		catch(Exception e )
		{	
			out.println(e);
		} 
*/		   	
	//Package depoist restricted call below packages  modified on 18/11/2014
		if(!function_id.equals("rcpt_rfnd") && !function_id.equals("PKG_BILLING"))
		{
			try
			{
				call =  con.prepareCall("{ call blopin.proc_ext_acc_serv_group_check (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
				call.setString(1,strfacilityid);
				call.setString(2,strbilldoctypecode);
				call.setString(3,strbilldocnum);
				call.setString(4,"BI");
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
	
%>			
				<script> 
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
				out.println(e);
			}
		}

		String query_cash_slmt_type="Select cash_slmt_flag,CASHIER_CHEQUE_YN,nvl(coupon_yn,'N') from bl_slmt_type where slmt_type_code='"+strslmttype+"'"; //V210113

		try
		{
			stmt=con.createStatement();
			rs21=stmt.executeQuery(query_cash_slmt_type);
			if(rs21 != null)
			{
				while(rs21.next())
				{
					cash_slmt_flag=rs21.getString(1);
					cashier_cheque_yn=rs21.getString(2);
					coupon_yn = rs21.getString(3); //V210113
				}
			}
		}
		catch(Exception e )
		{	
			out.println(e);
		} 
		   	
		//for credit card machine dtl		
		try
		{
			if(cash_slmt_flag.equals("A") ||  cash_slmt_flag.equals("D") && (cash_slmt_flag.equals("D") && coupon_yn.equals("N"))) //V210113
			{
				String ccCheck="{ call BLCOMMON.GET_CREDIT_CARD_INT_DTL ('"+strfacilityid+"','"+strscashcountercode+"','"+strslmttype+"',?,?,?,?,?)}";
				call =	con.prepareCall(ccCheck);				
				call.registerOutParameter(1,java.sql.Types.VARCHAR);				
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.execute();

				str_credit_card_machine_int_yn = call.getString(1);
				if(str_credit_card_machine_int_yn == null) str_credit_card_machine_int_yn="";

				str_credit_card_machine_id=call.getString(2);
				if(str_credit_card_machine_id == null) str_credit_card_machine_id="";

				str_err_code= call.getString(3);
				if(str_err_code == null) str_err_code="";

				str_error_text= call.getString(4);
				if(str_error_text == null) str_error_text="";

				str_sys_message_id = call.getString(5);
				if(str_sys_message_id == null) str_sys_message_id="";
				
				if(str_credit_card_machine_int_yn.equals("Y"))
				{
					readonly_fld="readonly";
					disabled_fld="disabled";
					onlineapproval="checked";

				}
				
				call.close();

				//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype);

				String stdQuery = "select SEGMENT_ID, STANDARD_CODE from XH_STANDARD_CONTROL_SEG where ELEMENT_ID = 'SETTLEMENT_TYPE' and DEFAULT_VALUE = ? ";

				if (strslmttype.length() >0)
				{
					try{	
						pstmt = con.prepareStatement(stdQuery);						
						pstmt.setString(1, strslmttype);
						rs = pstmt.executeQuery() ;

						if( rs != null ) 
						{							
							while( rs.next() ) 
							{
								segment_id = rs.getString( "SEGMENT_ID" ) ;
								standard_code = rs.getString( "STANDARD_CODE" ) ;																
							}
						}
						if(rs != null) rs.close();
						pstmt.close();
					}
					catch(Exception ee)
					{
						System.out.println("***Inside Settlement Type 2 - Exception in checking the segment, standard code for the payemnt type... "+ee.getMessage());
					}
					
					if(isDebugYN)
						System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype+ " ***Segment ID... "+segment_id+" ***Standard Code... "+standard_code);

					if (segment_id.length()>0 && standard_code.length()>0)
					{
						stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'CHECK_TRN_STATUS' and STANDARD_CODE = ? ";

						try{								
							pstmt = con.prepareStatement(stdQuery);
							
							pstmt.setString(1, segment_id);
							pstmt.setString(2, standard_code);
							rs = pstmt.executeQuery() ;

							if( rs != null ) 
							{							
								while( rs.next() ) 
								{
									slmt_check_status = rs.getString( "DEFAULT_VALUE" ) ;
								}
							}	
							
							
						}
						catch(Exception ee)
						{
							System.out.println("***Inside Settlement Type 2 - Exception in checking the payment type check status flag for the Payment Type... "+ee.getMessage());
						}							

					}
				}
				
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype+ " ***Segment ID... "+segment_id+" ***Standard Code... "+standard_code+" ***Settlement Stattus Check... "+slmt_check_status);	

			}

		}
		catch(Exception ee)
		{
			System.out.println("***Inside Settlement Type 2 - Exception... "+ee);
		}
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			System.out.println("***Inside Settlement Type 2 - Exception in getting the Decimal places... "+e.toString());
		}

		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic			
		ccAppletCount = 0;

		try {
			sqlStatement = "select count(*) applet_count from SM_FUNCTION_CONTROL a, sm_site_param b "
								+ "	where a.MODULE_ID = ? and a.FUNCTIONALITY_ID like '%CREDITCARD%' and a.SITE_ID = b.customer_id "
								+ "	and a.KEY_1 = ? AND VALUE_1 = 'Y' ";
			pstmt = con.prepareStatement(sqlStatement);
			pstmt.setString(1,"XH");
			pstmt.setString(2,strslmttype);

			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					ccAppletCount = rs2.getInt("applet_count");
				}
			}
			
			if(isDebugYN)
				System.out.println("***Inside Settlement Type 2 - Credit Card applet query... "+sqlStatement+" ***Applet Count... "+ccAppletCount);
		}
		catch (Exception e){
			System.out.println("***Inside Settlement Type 2 - Exception in fetching CC Applet "+e.getMessage() );
		}
		finally 
		{
			if (rs2 != null)   rs2.close();
			if (pstmt != null) pstmt.close();		
			ConnectionManager.returnConnection(con, request);
			
		}
		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic
%>
	<html>
  		<head>
		<!--<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eBL/js/AddModifyPatFinDetails.js"></script>
<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			
			<script language='javascript' ></script>		
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
				<!--Added by Sethu for GHL-CRF-0415 on 19/04/2017-->
			<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
			<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
			<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
<script>	
$(document).ready(function(){
	var cash_slmt_tpe = $('#cashslmtflag').val();
	var chequeLengthChange = $('#chequeLengthChange').val();

	if((chequeLengthChange == true || chequeLengthChange == 'true') && cash_slmt_tpe == 'D'){
		$('#instref').attr('maxlength',100);
		$('#tdChqCarfBankNo').text('<fmt:message key="eBL.CHQ_CARD_BANK_NO_OTH.label" bundle="${bl_labels}"/>');
	}
	var action_ind = $('#action_ind').val();
	if (action_ind == "add" || action_ind == "modify"){
		disp_valid_button();
	}
});
	function validate_py_tranx(trans)
	{
		var returnData = "";
		var patientID = "";
		var payTMUserCode = "";
		var payAmount = "";
		var payTMPromoCode = "";
		var merchantOrderID = "";
		
		var payTMReturnStr = "";
		var payTMData = "";

		var errMessage = "";

		var payTMTransDate = "";

		var payTransStatus = "";
		var loggedUser = "";
		var facilityid = "";

		var frm = document.BillSlmtTypeForm;
		var rad = frm.PayTMOption;
		var selection = '';
		for(var i=0;i<rad.length;i++){
			if(rad[i].checked){
				selection = rad[i].value;
			}
		}

		var otp = "";

		var errMess = "";

		parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;

		if(parent.frames[0].document.forms[0].billpayableamt.value != "")
		{
			patientID = document.forms[0].patientid.value;			
			payTMUserCode = document.forms[0].instref.value;
			payAmount = parent.frames[0].document.forms[0].billpayableamt.value;
			payTMPromoCode = document.forms[0].batchno.value;

			merchantOrderID = document.forms[0].saledraftno.value;

			loggedUser = document.forms[0].LoggedUser.value;
			facilityid = document.forms[0].facilityid.value;	
			clientIpAddress = document.forms[0].clientIpAddress.value;
			
			if (selection == "T")
				otp = document.forms[0].paytmOtp.value;
			else
				otp = "";
			
			if (trans == "PAY") {

				if (selection == "B"){
					
					if (document.forms[0].instref.value == ""){
						alert(" PayTM User Code cannot be empty, kindly scan the PayTM user code.");
						return;
					}					
				}
				if (selection == "T"){

					if (document.forms[0].instref.value == ""){
						alert(" PayTM Phone Number cannot be empty, kindly enter the 10 digit phone number and the OTP.");
						return;
					}					
				}

				if (selection == "T"){
					if (document.forms[0].paytmOtp.value == ""){
						alert(" PayTM OTP cannot be empty, kindly enter the PayTM OTP.");
						return;
					}					
				}

				if (document.forms[0].instref.value != ""){

					payTMUserCode = document.forms[0].instref.value;

					//--l_req := '<PATIENT_ID>0924168$!^<PAYTM_CODE>281005028j8ym3yygE56E72c$!^<AMOUNT>0.01$!^<PROMO_CODE>$!^<REQUEST>WITHDRAW_MONEY$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>SETHU$!^<FACILITY_ID>DF$!^';
					returnData = "<PATIENT_ID>"+patientID+"$!^<PAYTM_CODE>"+payTMUserCode+"$!^<AMOUNT>"+payAmount+"$!^<PROMO_CODE>"+payTMPromoCode+"$!^<REQUEST>WITHDRAW_MONEY$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>"+loggedUser+"$!^<FACILITY_ID>"+facilityid+"$!^<PAYBY_OPTION>"+selection+"$!^<OTP>"+otp+"$!^<USER_WSNO>"+clientIpAddress+"$!^";
				}				
			}
			else if (trans == "CHECKSTATUS") {
				if (document.forms[0].saledraftno.value != ""){
					//l_req := '<PATIENT_ID>0924168$!^<PAYTM_CODE>281005028j8ym3yyg9019E2c$!^<AMOUNT>0.01$!^<PROMO_CODE>$!^<REQUEST>CHECK_STATUS$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>5009$!^<TRN_TYPE>withdraw$!^<TRN_GUID>9447270090$!^<SESSION_ID>REGPAT$!^<USER>SETHU$!^<FACILITY_ID>DF$!^';
					returnData = "<PATIENT_ID>"+patientID+"$!^<PAYTM_CODE>"+payTMUserCode+"$!^<AMOUNT>"+payAmount+"$!^<PROMO_CODE>"+payTMPromoCode+"$!^<REQUEST>CHECK_STATUS$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>"+merchantOrderID+"$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>"+loggedUser+"$!^<FACILITY_ID>"+facilityid+"$!^<PAYBY_OPTION>"+selection+"$!^<OTP>"+otp+"$!^<USER_WSNO>"+clientIpAddress+"$!^";
				}
				else
				{
					alert(" To check PayTM Transaction staus, Merchant Order ID cannot be empty, kindly enter the Merchant Order ID.");
					return;
				}

			}

			
			if (returnData.length > 0){

				payTMReturnStr = payTMTransaction(returnData);

				if (!(payTMReturnStr.indexOf("$!^") > 0))
				{
					if (payTMReturnStr.indexOf("ORA-12535")>0)
					{
						errMess = "<H5 style='color:blue'>EM Web Service Error - Issue with EM Web service Configuration, Kindly check with System Administrator. </H5>" +"<br>" ;
						parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
						return false; 
					}

					if (payTMReturnStr.indexOf("ORA-12541")>0)
					{
						errMess = "<H5 style='color:blue'>EM Web Service Error - EM Web Service is not running, Kindly check with System Administrator. </H5>" +"<br>" ;
						parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
						return false; 
					}

					errMess = "<H5 style='color:blue'>EM Application Error - "+payTMReturnStr+" </H5>" +"<br>" ;
					parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
					return false; 

				}

				payTMData = payTMReturnStr.split("$!^");

				var errMess = "" ;
				parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;

				if (payTMData.length > 0)
				{
					document.forms[0].saledraftno.disabled = false;
					document.forms[0].apprrefno.disabled = false;
					document.forms[0].instdate.disabled = false;

					if (payTMData[0] == "SUCCESS"){
						document.forms[0].instref.disabled = true;
						document.forms[0].paytmOtp.disabled = true;
						document.forms[0].batchno.disabled = true;
						document.forms[0].saledraftno.disabled = true;
						document.forms[0].apprrefno.disabled = true;
						document.forms[0].instdate.disabled = true;
						for(var i=0;i<rad.length;i++){							
							rad[i].disabled = true;							
						}

						document.forms[0].validate_paytm_pay.disabled = true;						

						document.forms[0].saledraftno.value = payTMData[3];
						document.forms[0].apprrefno.value = payTMData[4];
						document.forms[0].instdate.value = payTMData[5];

						if (trans == "PAY") {
							document.forms[0].PayTMTransDate.value = payTMData[5];
							payTransStatus = "Payment ";

						}
						
						if (trans == "CHECKSTATUS") 
						{
							payTransStatus = "Check Status ";
							payTMTransDate = document.forms[0].PayTMTransDate.value;	

							if (payTMTransDate.length > 0)
								document.forms[0].instdate.value = payTMTransDate;

						}											

						errMess = "<H5 style='color:green'>"+payTransStatus+"Transaction - Successful</H5>" +"<br>" ;
						parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
						return false; 
					}
					else 
					{
						for(var i=0;i<rad.length;i++){							
							rad[i].disabled = false;							
						}
						document.forms[0].instref.disabled = false;
						document.forms[0].paytmOtp.disabled = false;
						document.forms[0].batchno.disabled = false;
						document.forms[0].saledraftno.value = payTMData[3];						
						document.forms[0].apprrefno.value = "";
						document.forms[0].instdate.value = "";
						document.forms[0].PayTMTransDate.value = "";
						errMessage = payTMData[1] + " - " + payTMData[2];
						errMess = "<H5 style='color:red'>Transaction declined - "+errMessage+"</H5>" +"<br>" ;
						parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+errMess;
						return false; 
					}

				}


			}
		}			
	}
	//Added by Sethu for GHL-CRF-0415 on 19/04/2017

	function disp_valid_button()
	{	
		var str_credit_card_machine_int_yn=document.forms[0].str_credit_card_machine_int_yn.value;		

		parent.frames[0].document.getElementById('show_button').style.display='none';
		parent.frames[0].document.getElementById('show_button_status').style.display='none';

		if(document.forms[0].str_credit_card_machine_int_yn.value=="Y" && document.forms[0].application_id.value!="PAYTM") 
		{			
			if(parent.frames[0].document.forms[0].billpayableamt.value != "")
			{
				parent.frames[0].document.getElementById('show_button').style.display='inline';
				//Added by Sethu for KDAH-CRF-0504 on 14/08/2019
				if (document.forms[0].credit_card_status_yn.value=="Y")
				{
					parent.frames[0].document.getElementById('show_button_status').style.display='inline';
				}
			}
		}
		else
		{
			parent.frames[0].document.getElementById('show_button').style.display='none';
			parent.frames[0].document.getElementById('show_button_status').style.display='none';
		}


		if(document.forms[0].application_id.value=="PAYTM")
		{

			document.getElementById('show_payTM_field1').style.display='inline';
			document.getElementById('show_payTM_field2').style.display='inline';
			document.getElementById('show_payTM_field3').style.display='inline';
			document.getElementById('show_payTM_field4').style.display='inline';
			if(document.forms[0].str_credit_card_machine_int_yn.value=="Y")
			{
				document.getElementById('show_payTM_button1').style.display='inline';
				document.getElementById('show_payTM_button2').style.display='inline';
			}

		}
	}

	//Added by Sethu for GHL-CRF-0415.2 on 02/02/2018

	function fnChangePayTM()
	{	

		var frm = document.BillSlmtTypeForm;
		var rad = frm.PayTMOption;
		var selection = '';
		for(var i=0;i<rad.length;i++){
			if(rad[i].checked){
				selection = rad[i].value;
			}
		}

		var str_credit_card_machine_int_yn=document.forms[0].str_credit_card_machine_int_yn.value;	
		
		document.getElementById('show_payTM_field1').style.display='none';
		document.getElementById('show_payTM_field2').style.display='none';
		document.getElementById('show_payTM_field3').style.display='none';
		document.getElementById('show_payTM_field4').style.display='none';
	
		document.getElementById('show_payTM_phone1').style.display='none';
		//document.getElementById('show_payTM_phone2').style.display='none';
		document.getElementById('show_payTM_otp1').style.display='none';
		document.getElementById('show_payTM_otp2').style.display='none';

		document.getElementById("instref").value = "";
	
		if(selection == 'B'){		

			document.getElementById("instref").size = "30";

			parent.frames[0].document.getElementById('show_button').style.display='none';
			parent.frames[0].document.getElementById('show_button_status').style.display='none';

			if(document.forms[0].str_credit_card_machine_int_yn.value=="Y" && document.forms[0].application_id.value!="PAYTM") 
			{			
				if(parent.frames[0].document.forms[0].billpayableamt.value != "")
				{	
					parent.frames[0].document.getElementById('show_button').style.display='inline';
					//Added by Sethu for KDAH-CRF-0504 on 14/08/2019
					if (document.forms[0].credit_card_status_yn.value=="Y")
					{
						parent.frames[0].document.getElementById('show_button_status').style.display='inline';
					}
				}
			}
			else
			{
				parent.frames[0].document.getElementById('show_button').style.display='none';
				parent.frames[0].document.getElementById('show_button_status').style.display='none';
			}


			if(document.forms[0].application_id.value=="PAYTM")
			{

				document.getElementById('show_payTM_field1').style.display='inline';
				document.getElementById('show_payTM_field2').style.display='inline';
				document.getElementById('show_payTM_field3').style.display='inline';
				document.getElementById('show_payTM_field4').style.display='inline';
				if(document.forms[0].str_credit_card_machine_int_yn.value=="Y")
				{
					document.getElementById('show_payTM_button1').style.display='inline';
					document.getElementById('show_payTM_button2').style.display='inline';
				}

			}
		}
		if(selection == 'T'){	
			
			document.getElementById("instref").size = "14";

			parent.frames[0].document.getElementById('show_button').style.display='none';
			parent.frames[0].document.getElementById('show_button_status').style.display='none';

			if(document.forms[0].str_credit_card_machine_int_yn.value=="Y" && document.forms[0].application_id.value!="PAYTM") 
			{			
				if(parent.frames[0].document.forms[0].billpayableamt.value != "")
				{		
					parent.frames[0].document.getElementById('show_button').style.display='inline';
					//Added by Sethu for KDAH-CRF-0504 on 14/08/2019
					if (document.forms[0].credit_card_status_yn.value=="Y")
					{
						parent.frames[0].document.getElementById('show_button_status').style.display='inline';
					}
				}
			}
			else
			{
				parent.frames[0].document.getElementById('show_button').style.display='none';
				parent.frames[0].document.getElementById('show_button_status').style.display='none';
			}


			if(document.forms[0].application_id.value=="PAYTM")
			{

				document.getElementById('show_payTM_phone1').style.display='inline';
				document.getElementById('show_payTM_field2').style.display='inline';
				document.getElementById('show_payTM_otp1').style.display='inline';
				document.getElementById('show_payTM_otp2').style.display='inline';
				document.getElementById('show_payTM_field3').style.display='inline';
				document.getElementById('show_payTM_field4').style.display='inline';
				if(document.forms[0].str_credit_card_machine_int_yn.value=="Y")
				{
					document.getElementById('show_payTM_button1').style.display='inline';
					document.getElementById('show_payTM_button2').style.display='inline';
				}

			}
		}
	}
	function showCalendar_loc(Val1, Val2)
	{	
		if (Val2.disabled == true)		
		{
			return false;
		}
		else
		{
			return showCalendar(Val1);
		}
	}
/*function chkDateAftSysDate(instdate,sys_date)
{
	var locale=document.forms[0].locale.value;
	alert("date");
	alert("instdate "+instdate.value);
	
	if(instdate.value!="")
	{
		if((validDate(instdate.value,'DMY',locale)))
		{
			var instDate = instdate.value ;
			var sysDate = sys_date.value;
			if(isAfterNow(instDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9115",'BL'));
				instdate.select();
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
}*/
function ChkNumberInput2(fld, e, deci)
{ 
	
	var strCheck = '-1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}
function checkForNumber(obj){
	if(isNaN(obj.value)){
		document.forms[0].cash_return.value = '';
		alert(getMessage('BL8532','BL'));
		obj.select();
	}
	
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
		
		var v_ext_acc_interface_yn = "<%=ext_acc_interface_yn%>";
		var	v_single_serv_grp = "<%=str_single_service_grp_yn%>";
		var v_acc_episode_type = "<%=str_acc_episode_type%>";
		var v_acc_catg_code = "<%=str_acc_category_code%>";
		var v_acc_serv_grp_used_yn = "<%=str_acc_serv_grp_used_yn%>";
		var v_serv_grp = "<%=str_service_grp%>";
		var v_episode_type = "<%=str_episode_type%>";
		var v_reln_code ="<%=str_reln_code%>";

		var locale = document.forms[0].locale.value;

			
		sql = "select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`"+locale+"` and recpt_nature_code = `BI` and status is null and (( `"+v_ext_acc_interface_yn+"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`"+v_single_serv_grp+"`=`Y` and episode_type in (`"+v_acc_episode_type+"`,`U`) and category in (`UNRESTRICTED`,`"+v_acc_catg_code+"`) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and episode_type in (`U`,`"+v_episode_type+"`) and category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `"+v_ext_acc_interface_yn+"` = `N`    )";		

		search_code="receipt_type_code";
		search_desc="long_desc";
//		tit="Receipt Types"; 
		tit=getLabel("eBL.RECEIPT_TYPE.label","BL");		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();

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
		
		var v_ext_acc_interface_yn = "<%=ext_acc_interface_yn%>";
		var	v_single_serv_grp = "<%=str_single_service_grp_yn%>";
		var v_acc_episode_type = "<%=str_acc_episode_type%>";
		var v_acc_catg_code = "<%=str_acc_category_code%>";
		var v_acc_serv_grp_used_yn = "<%=str_acc_serv_grp_used_yn%>";
		var v_serv_grp = "<%=str_service_grp%>";
		var v_episode_type = "<%=str_episode_type%>";
		var v_reln_code ="<%=str_reln_code%>";
		var v_rec_type = document.forms[0].rectype.value;		

		var locale = document.forms[0].locale.value;
		
		sql = "	select distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`"+locale+"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code  and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `"+v_rec_type+"` and a.status is null and ((`"+v_single_serv_grp+"`=`Y` and a.episode_type in (`U`, `"+v_acc_episode_type+"`) and a.category in (`UNRESTRICTED`,`"+v_acc_catg_code+"` ) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and a.blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  a.blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and a.episode_type in (`U`, `"+v_episode_type+"`) and a.category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))";	

		search_code="a.account_code";
		search_desc="b.long_desc";
//		tit="Account Codes"; 
		tit=getLabel("eBL.ACCOUNT_CODE.label","BL");
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
		
		var v_dept_code = "<%=str_ext_dept_code%>";
		var v_facility_id = "<%=strfacilityid%>";

		var locale = document.forms[0].locale.value;

		
		sql = "	select dept_code, long_desc from am_dept_lang_vw where language_id=`"+locale+"` and dept_code like nvl(`"+v_dept_code+"`,dept_code )";

		search_code="dept_code";
		search_desc="long_desc";
//		tit="Accounting Departments"; 
		tit=getLabel("eBL.ACCOUNTING_DEPT.label","BL");		
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


	function bankcardlkup(clng_evnt)
	{
		var msg="";
		var target				= document.forms[0].instremark;

		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{
				target.value = "";
				document.forms[0].instbranch.value='';
				document.forms[0].instremarkcode.value = '';
				return;
			}
		}

		var retVal				= new String();
		
		var dialogTop			= "90";
		var dialogHeight		= "27" ;
		var dialogWidth			= "40" ;
		var features= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";		
		var tit					= "";		
		var v_cash_slmt_flag = document.forms[0].cashslmtflag.value; 
		var locale = document.forms[0].locale.value;
		/*ML-MMOH-0527 - Rajesh V*/
		var slmttype = parent.frames[0].document.forms[0].slmttype.value;
		var v_slmt_type_code=slmttype.substring(0,2);
		var v_cheque_type_enabled = 0;
		var chequeCategorize = document.forms[0].chequeCategorize.value;
		if(chequeCategorize == 'true'){
			v_cheque_type_enabled = 1;
		}

		/*ML-MMOH-0527 - Rajesh V*/
		//added "Y" in where clause in
		//sql = " select name bank_name, nvl(branch_name,' ') branch_name, code bank_code from bl_bank_credit_company_lang_vw where language_id='"+locale+"' and (('"+v_cash_slmt_flag+"' = 'A' and nvl(bank_credit_company_ind,'~') = 'C') or ('"+v_cash_slmt_flag+"' in( 'B','C','D','Y') and    nvl(bank_credit_company_ind,'~') = 'B')) and  nvl(status,'~') <> 'S'"; 		
		sql = "SELECT NAME bank_name, NVL (branch_name, ' ') branch_name, code bank_code "+
		  "FROM bl_bank_credit_company_lang_vw "+
		  "WHERE language_id = '"+locale+"' "+
		    "AND (   (    '"+v_cash_slmt_flag+"' = 'A' "+
		             "AND NVL (bank_credit_company_ind, '~') = 'C' "+
		            ") "+
		         "OR (    '"+v_cash_slmt_flag+"' IN ('B') "+
		             "AND NVL (bank_credit_company_ind, '~') IN ('B') "+
		             "AND (   (    EXISTS ( "+
		                             "SELECT b.bank_code "+
		                               "FROM bl_slmt_type a, bl_bank_name b "+
		                              "WHERE a.cheque_type = b.cheque_type "+
		                                "AND slmt_type_code = '"+v_slmt_type_code+"' "+
		                                "AND b.bank_code = code) "+
		                      "AND '"+v_cheque_type_enabled+"' > 0 "+
		                     ") "+
		                  "OR '"+v_cheque_type_enabled+"' = 0 "+
		                 ") "+
		            ") "+
		         "OR (    '"+v_cash_slmt_flag+"' IN ('B') "+
		             "AND NVL (bank_credit_company_ind, '~') IN ('B') "+
		             "AND (   (    EXISTS ( "+
		                             "SELECT b.bank_code "+
		                               "FROM bl_slmt_type a, bl_bank_name b "+
		                              "WHERE a.cheque_type = b.cheque_type "+
					                   //"WHERE a.cheque_type = b.cheque_type(plus) "+
		                                "AND a.slmt_type_code = '"+v_slmt_type_code+"' "+
		                                "AND a.cheque_type IS NULL "+
		                                "AND b.bank_code = code) "+
//										"AND b.bank_code(plus) = code) "+
		                      "AND '"+v_cheque_type_enabled+"' > 0 "+
		                     ") "+
		                  "OR '"+v_cheque_type_enabled+"' = 0 "+
		                 ") "+
		            ") "+
		         "OR (    '"+v_cash_slmt_flag+"' IN ('C', 'D', 'Y') "+
		             "AND NVL (bank_credit_company_ind, '~') = 'B' "+
		            ") "+
		        ") "+
		    "AND NVL (status, '~') <> 'S' ";
		sql = escape(sql);					

		var column_sizes = escape("30%,60%,10%");               

		if ( v_cash_slmt_flag == 'A' )
		{
//			tit = "Credit Card Company Names";		    
			//tit=getLabel("eBL.CREDIT_CARD_COMP_NAMES.label","BL");
			//var creditcardconame=getLabel("eBL.CREDIT_CARD_CO.label","BL");
			//var branchname=getLabel("eBL.BRANCH_NAME.label","BL");
			//var code=getLabel("Common.code.label","common");
			tit=encodeURIComponent(getLabel("eBL.CREDIT_CARD_COMP_NAMES.label","BL"));
			var creditcardconame=encodeURIComponent(getLabel("eBL.CREDIT_CARD_CO.label","BL"));
			var branchname=encodeURIComponent(getLabel("eBL.BRANCH_NAME.label","BL"));
			var code=encodeURIComponent(getLabel("Common.code.label","common"));

//			var column_descriptions = escape("Credit Card Co. Name,Branch Name,Code"); 
			var column_descriptions =creditcardconame+","+branchname+","+code;
		}
		else			
		{
		
//			tit="Bank Names"; 
			//tit=getLabel("eBL.BANK_NAME.label","BL");
		//	var bankname=getLabel("eBL.BANK_NAME.label","BL");
		//	var branchname=getLabel("eBL.BRANCH_NAME.label","BL");
		//	var code=getLabel("Common.code.label","common");
			
			tit=encodeURIComponent(getLabel("eBL.BANK_NAME.label","BL"));
			var bankname=encodeURIComponent(getLabel("eBL.BANK_NAME.label","BL"));
			var branchname=encodeURIComponent(getLabel("eBL.BRANCH_NAME.label","BL"));
			var code=encodeURIComponent(getLabel("Common.code.label","common"));
//			var column_descriptions = escape("Bank Name,Branch Name,Code"); 
			var column_descriptions =bankname+","+branchname+","+code;
		}
	

		var message = '';
		//ML-MMOH-CRF-0527 Added Called For
		var param = "title="+tit+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYY&called_for=BankAndBranch";
		retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		        
		var arr=new Array();
		if(retVal == null) retVal='';
		if (retVal != null || retVal!="")
		{	
			var retVal=unescape(retVal);
			//arr=retVal.split("::");
			arr=retVal.split("^~^");
		    	
			document.forms[0].instremark.value=arr[0];
			document.forms[0].instbranch.value=arr[1];
		    document.forms[0].instremarkcode.value=arr[2];		
			
	
			if (document.forms[0].instremark.value == 'undefined')
				document.forms[0].instremark.value = '';

			if (document.forms[0].instbranch.value == 'undefined')
				document.forms[0].instbranch.value = '';

			if (document.forms[0].instremarkcode.value == 'undefined')
				document.forms[0].instremarkcode.value = '';
//				document.forms[0].instremark.focus();		
		}
		else
		{		
			document.forms[0].instremark.value='';
			document.forms[0].instbranch.value='';
			document.forms[0].instremarkcode.value = '';						
//			target.focus();
		}	
	}	
	
	
	function fn_cash_check(){
		
		var setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;
		//alert("setld_amt 807 ==> "+setld_amt);//muthu
		
		var decimal=document.forms[0].noofdecimal.value;
		if(document.forms[0].cash_given.value=="")
		{
			document.forms[0].cash_return.value="";
		}
		else
		{
			var c_given=document.forms[0].cash_given.value;			  
			var c_return="";
			if(setld_amt<0)
			{
				
				
				//c_return=parseFloat(c_given)-(parseFloat(setld_amt));				  
				c_return=parseFloat(setld_amt)-parseFloat(c_given);
				c_return=c_return.toFixed(decimal);
				document.forms[0].cash_return.value=c_return;				  
			}
			else
			{	
				c_return=parseFloat(c_given)-parseFloat(setld_amt);
				c_return=c_return.toFixed(decimal);
				if(c_return<0)
				{			
					document.forms[0].cash_given.value="";
					document.forms[0].cash_return.value="";				  
				}
				else
				{
					document.forms[0].cash_return.value=c_return;
				}	
			}
			var temp_cash_given=eval("document.forms[0].cash_given");
			var temp_cash_return=eval("document.forms[0].cash_return");
			putdeci(temp_cash_given);
			putdeci(temp_cash_return);
		}

		
	}
	
	function fun_cash_check()
	{
		var setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;
		//alert("setld_amt 807 ==> "+setld_amt);//muthu
		var decimal=document.forms[0].noofdecimal.value;
		if(document.forms[0].cash_given.value=="")
		{
			document.forms[0].cash_return.value="";
		}
		else
		{
			var c_given=document.forms[0].cash_given.value;			  
			var c_return="";
			if(setld_amt<0)
			{
				c_return=parseFloat(c_given)+(-parseFloat(setld_amt));				  
				c_return=c_return.toFixed(decimal);
				
				document.forms[0].cash_return.value=-c_return;				  
			}
			else
			{	
				c_return=parseFloat(c_given)-parseFloat(setld_amt);
				c_return=c_return.toFixed(decimal);
				if(c_return<0)
				{			
					document.forms[0].cash_given.value="";
					document.forms[0].cash_return.value="";				  
				}
				else
				{
					document.forms[0].cash_return.value=c_return;
				}	
			}
			var temp_cash_given=eval("document.forms[0].cash_given");
			var temp_cash_return=eval("document.forms[0].cash_return");
			putdeci(temp_cash_given);
			putdeci(temp_cash_return);
		}
	}
	function putdeci(object)
	{	
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}
		
			
	function disableAllElements_billslmt_remove()
	{
		//var len = document.forms[0].elements.length;
		for(var i=0;i<10;i++)
		{
			document.forms[0].elements(i).disabled=true;
		}
	//document.forms[0].remove_button.disabled=false;
	//document.forms[0].cancel_button.disabled=false;
	}
	function fnCashcheck()
	{
		
		
		var amt_sett=parent.frames[0].document.forms[0].billslmtamt.value;
		//alert("amt_sett 866 ==> "+amt_sett);//muthu
		var cash_giv=document.forms[0].cash_given.value;
		if(cash_giv!='')
			{
		
		if(parseFloat(Math.abs(cash_giv))<parseFloat(Math.abs(amt_sett)))
		{
			//alert("Cash given is less than the Amount Settled");
			alert(getMessage("BL9618","BL"));
			document.forms[0].cash_given.select();			
			document.forms[0].cash_given.value='';
			return false;
		}
		
		if(cash_giv>0)
			{
				alert(getMessage("BL9863","BL"));
				document.forms[0].cash_given.value='';
				document.forms[0].cash_given.select();		
				return false;
			}

	/*  if(cash_giv=="")
		{
			//alert("cash given should not be blank");
			 alert(getMessage("BL9638","BL"));
			//document.forms[0].cash_given.focus();
			//return false;
		}*/
		
		 fn_cash_check()
	}
	
	}
	function funCashcheck()
	{
		var amt_sett=parent.frames[0].document.forms[0].billslmtamt.value;
		//alert("amt_sett 866 ==> "+amt_sett);//muthu
		var cash_giv=document.forms[0].cash_given.value;
		if(amt_sett<0){
			if((parseFloat(cash_giv)>parseFloat(amt_sett))&&(parseFloat(cash_giv)<0))
			{
				alert(getMessage("BL9618","BL"));
				document.forms[0].cash_given.select();			
				return false;
			}
			if(amt_sett<0 && parseFloat(cash_giv)>0 )
				{
				alert(getMessage("BL0623","BL"));
				document.forms[0].cash_given.focus();			
				return false;
				}
		}
		else{
		if(parseFloat(cash_giv)<parseFloat(amt_sett))
		{
			//alert("Cash given is less than the Amount Settled");
			alert(getMessage("BL9618","BL"));
			document.forms[0].cash_given.select();			
			return false;
		}
		}
	/*  if(cash_giv=="")
		{
			//alert("cash given should not be blank");
			 alert(getMessage("BL9638","BL"));
			//document.forms[0].cash_given.focus();
			//return false;
		}*/
		
		 fun_cash_check()
		}

	function disable_elements()
	{
		//Added V060618-Subha/IN67859/Starts
		if(eval("parent.frames[0]").value != "undefined" && eval("parent.frames[0]").value != undefined) {
			var slmttype = parent.frames[0].document.forms[0].slmttype.value;
			if(slmttype != "null" && slmttype != null) {
				var slmttypeflag = slmttype.charAt(2); 
				//Added V060618-Subha/IN67859/Ends
				if(slmttypeflag=="B" )
				{
//					document.forms[0].instbranch.value="";
					document.forms[0].batchno.value="";
					document.forms[0].apprrefno.value="";
					document.forms[0].saledraftno.value="";
				}
				if(slmttypeflag=="D")
				{
//					document.forms[0].instremark.value="";
//					document.forms[0].instbranch.value="";
					document.forms[0].batchno.value="";
					document.forms[0].apprrefno.value="";
					document.forms[0].saledraftno.value="";
				}	
			}
		}
	}
	function callCardNoValidation(obj)
	{
		var credit_card_num = obj.value;
		var slmttype = parent.frames[0].document.forms[0].slmttype.value;
		//alert("slmttype "+slmttype);
		var slmt_type_code=slmttype.substring(0,2);	
		//alert("slmt_type_code "+slmt_type_code); 
		var slmt_flag=slmttype.charAt(2);	
		var caldFormanualcc="MANUALCC";							
		 parent.frames[4].location.href="../../eBL/jsp/BLCreditCardInterfaceValidate.jsp?caldFormanualcc="+caldFormanualcc+"&slmt_type_code="+slmt_type_code+"&credit_card_num="+credit_card_num;
	}
	function setFocus(){			
		var cashGiv=document.forms[0].cash_given;		
			if(cashGiv != null && cashGiv !=""){			
				cashGiv.focus();
			}
	}

	function ValidateDateTimesp(obj)
	{
		if(!(obj.value==""))
		{
			if(!doDateTimeChk(obj)){
				var datemessage=getMessage('INVALID_VALUE','Common').replace('#','date time format')		
				alert(datemessage);
			}
			else{
				Checkcurrdate(obj);
			}
		 }
	}

	function Checkcurrdate(from) {
		var fromarray; var toarray;
		var fromdate = from.value ;
		var d =  new Date(); 
		if(fromdate.length > 0 ) {
																										 
				fromarray = fromdate.split("/");
				var year =  fromarray[2].split(" ");
				var hourmins=year[1].split(":");

				var fromdt = new Date(year[0],fromarray[1],fromarray[0],hourmins[0],hourmins[1]);			
			
				var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate(),d.getHours(),d.getMinutes());	
				if(Date.parse(todt) > Date.parse(fromdt)) {

				alert(getMessage('XH0073','XH'));
					from.focus();
					return false;
				}
				else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
		}	
		return true;
	}
	function doDateTimeChk(obj)  
	{
		if(obj.value.indexOf('.') !=-1)
		{
			retval= false
			obj.focus()
		}
		else
		{
			var comp=obj
			obj=obj.value
			var dttime = obj.split(" ");
			var dt
			var time
			var retval=true
			if(dttime.length>1)
			{
				dt=dttime[0]
				time=dttime[1]

				if(!checkDt(dt) )
				{
					retval= false
					comp.focus()
				}
				else
				{
					if(time==null || time=="")
					{
						retval= false;
						comp.focus()
					}
					else
					{							    
						if(!chkTime(time))
						{
							retval= false
							comp.focus()
						}
					}
				}
			}
			else
			{
				retval= false
				comp.focus()
			}

			if(retval)
			{
				//callDateFunction(comp)
			}
		}
		return retval
	}
	//V210113 start
	function couponcodelkup() {		
		var patientID = document.forms[0].patientid.value;
		var setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;
		var remainingAmt = parent.frames[0].document.forms[0].billpayableamt.value; //V210224
		var cash_given=document.forms[0].cash_given.value;		
		var decimal=document.forms[0].noofdecimal.value; //V210224
		var action_ind = document.forms[0].action_ind.value; //V210224
		var coupon='';
		var transactionid='';		
		var LoggedUser = document.forms[0].LoggedUser.value;		
		var clientIpAddress = document.forms[0].clientIpAddress.value;		
		var NuhdeekResponse = NuhdeekTransactions('COUPON',patientID,coupon,transactionid, LoggedUser, clientIpAddress);
		var NuhdeekResponseArr = NuhdeekResponse.split("$!^");
		if (NuhdeekResponseArr[0] == 'S') {		
			var couponStr =	NuhdeekResponseArr[2].replace(/#/g,"|");
			var center='1';
			var dialogTop = "200";
			var dialogHeight = "25" ; //V210224
			var dialogWidth = "25" ;
			var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
			var title=encodeURIComponent(getLabel("eBL.CouponCodes.Label","BL"));	
			var arguments = "" ;
			var column_sizes = escape("");               
			var column_descriptions ="";		
			var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&coupons="+couponStr+"&patientID="+patientID+"&LoggedUser="+LoggedUser+"&clientIpAddress="+clientIpAddress+"&setld_amt="+setld_amt+"&remainingAmt="+remainingAmt; //V210224
			var retVal=window.showModalDialog("../../eBL/jsp/BLSelectNuhdeekCoupon.jsp?"+param,arguments,features);
			if (retVal=='undefined' || retVal ==	 undefined || retVal=="") {
			//V210224start
				if(action_ind != 'modify') {  
					if(document.getElementById('couponcodeTA').value == 'undefined' || document.getElementById('couponcodeTA').value ==	 undefined || document.getElementById('couponcodeTA').value =="" ) { //V210224
						document.getElementById("couponcode").value = "";
						document.getElementById('couponcodeTA').value = "";
						//document.getElementById('cash_given').value = "";
						parent.frames[0].document.forms[0].billslmtamt.value="";
						document.getElementById('couponAndAmt').value = "";
					}
				} ////V210224 end				
			} else {
				var returnvalue = retVal.split("::");
				//V210224 start
				var couponcodeTA = document.getElementById('couponcodeTA').value;
				var couponCode = document.getElementById("couponcode").value;
				var cash_setl =parent.frames[0].document.forms[0].billslmtamt.value;
				//var cashgiven = document.getElementById('cash_given').value;
				var couponAndAmt = document.getElementById('couponAndAmt').value;				
				if(couponcodeTA=='undefined' || couponcodeTA ==	 undefined || couponcodeTA=="") {
					 couponCode = "";
					 couponcodeTA="";
					 //cashgiven = "";
					 cash_setl="";
					 couponAndAmt ="";
				}				
				if(couponcodeTA!=""){
					document.getElementById('couponcodeTA').value = couponcodeTA+", "+returnvalue[2];
					document.getElementById('couponAndAmt').value = couponAndAmt+", "+returnvalue[2];
					document.getElementById("couponcode").value = couponCode+","+returnvalue[0];
					//cashgiven = parseFloat(cashgiven)+parseFloat(returnvalue[1]);					
					cash_setl = parseFloat(cash_setl)+parseFloat(returnvalue[1]);
				}
				else{
					document.getElementById("couponcode").value = returnvalue[0];
					document.getElementById('couponcodeTA').value = returnvalue[2];
					document.getElementById('couponAndAmt').value =returnvalue[2];
					//cashgiven = parseInt(returnvalue[1]);
					cash_setl = parseFloat(returnvalue[1]);
				}				
				cash_setl=cash_setl.toFixed(decimal);				
				if(parseFloat(cash_setl) > parseFloat(remainingAmt)) {					
					parent.frames[0].document.forms[0].billslmtamt.value=remainingAmt;
				}
				else{
					parent.frames[0].document.forms[0].billslmtamt.value=cash_setl;
				}
				//V210224  end
				//cashgiven=cashgiven.toFixed(decimal);
				//document.getElementById('cash_given').value=cashgiven;
				
			}
		} else if (NuhdeekResponseArr[0]=='E') {
				alert(NuhdeekResponseArr[4]);
				return false;
		}		
	}
	//V210113 end
</script>
  	</head>
<%
	if(action_ind.equals("remove"))
	{
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="disableAllElements_billslmt_remove();setFocus()" >
<%
	}
	else if(action_ind.equals("modify"))
	{
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="disable_elements();setFocus()" >
<%
	}
	else
	{
%>
	<body onLoad="setFocus()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<%
	}
%>
	<form name='BillSlmtTypeForm' id='BillSlmtTypeForm' method='post' action=''  scrolling=no >	
<%
	if (ext_acc_interface_yn.equals("Y") && !cash_slmt_flag.equals(""))
	{
%>	
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>	
		<tr>
<!--			<td class="label" align="right" width="8%">Receipt Type</td> -->
			<!--ram	<td class="label"  width="25%"><fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
				<td width="25%" class="fields"><input type='text' readonly name="rectype" id="rectype" maxlength='3' size='3'  tabindex='1' value='<%=str_receipt_type_code%>'><input type='button' class='button' name="rectypebut" id="rectypebut" value='?' onClick="return rectypelkup()" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'></td>
				<input type= hidden name="rectypedesc" id="rectypedesc"  value='<%=str_receipt_type_code%>'>				
				<td width="25%"></td>
				<td width="25%"></td>

		</tr> ram-->
		<tr>
			<!--
				<td width="" align="left" colspan="1"></td>
				<td width="" align="right" class="label">Receipt Type</td>	
				<td width="" align="left">&nbsp;<input type='text' name='rectype' id='rectype' size='20' maxlength='3' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class="label" align="right" width="10%">Account Code</td> -->

			<!--ram	<td class="label" width="25%"><fmt:message key="eBL.ACCOUNT_CODE.label" bundle="${bl_labels}"/></td>	
				<td width="25%" class="fields"><input type='text' readonly name="acccode" id="acccode" maxlength='10' size='10'  tabindex='3' value='<%=str_ext_account_code%>'><input type='button' class='button' name="acccodebut" id="acccodebut" value='?' onClick="return acccodelkup()" tabindex='4'>
				<img src='../../eCommon/images/mandatory.gif'></td>
				<input type= hidden name="acccodedesc" id="acccodedesc"  value='<%=str_ext_account_code%>'>	ram-->
				
			<!--
				<td width="" align="right" class="label">Account Code</td>	
				<td width="" align="left" colsan="2">&nbsp;<input type='text' name='extacccode' id='extacccode' size='10' maxlength='10' value='<%=str_ext_account_code%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td> -->


<!--			<td class="label" align="right" width="6%">Dept</td> -->
			<!--ram	<td class="label" width="25%"><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
				<td width="25%" class="fields"><input type='text' readonly name="dept" id="dept" maxlength='6' size='6'  tabindex='5' value='<%=str_ext_dept_code%>'><input type='button' class='button' name="deptbut" id="deptbut" value='?' onClick="return deptlkup()" tabindex='6'>
				<img src='../../eCommon/images/mandatory.gif'></td>
				<input type= hidden name="deptdesc" id="deptdesc"  value=''>	
		</tr> ram-->
			   <!--
				<td width="" align="right" class="label">Dept</td>	
				<td width="" align="left">&nbsp;<input type='text' name='extacccode' id='extacccode' size='15' maxlength='6' value='<%=str_ext_dept_code%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>	-->	
		<!--
        <tr><td width="" align="left" colspan="10"></td></tr>			
		<tr><td width="" align="left" colspan="10"></td></tr>			
		<tr><td width="" align="left" colspan="10"></td></tr>			
		<tr><td width="" align="left" colspan="10"></td></tr>		
		-->
		</table> 
		
<%
	}
	
	if (cash_slmt_flag.equals("Y") || (siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y"))) //V210113
	{ 
%>
			<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>				
			<tr>		
<%
				if(billslmtamtdetDb<0)
				{
					if(rec_ref.equals("F")){
				
%>
					<td width="25%" class="label"><fmt:message key="eBL.CASH_REFUNDED.label" bundle="${bl_labels}"/></td>
					<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' onKeyPress='return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))' onBlur='fnCashcheck();checkFrNumber(this);'> </td>
					<%
					}
					else{ %>
					<td width="25%" class="label"><fmt:message key="eBL.CASH_REFUNDED.label" bundle="${bl_labels}"/></td>
					<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' onKeyPress='return(ChkNumberInput2(this,event,document.forms[0].noofdecimal.value))' onBlur='funCashcheck();checkForNumber(this);'> </td>
				<% 	}}
				else
				{
					if(custId.equals("GP"))
					{
					%>
					<td width="25%" class="label"><fmt:message key="eBL.AMOUNT_REND.label" bundle="${bl_labels}"/></td>
					<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onBlur='funCashcheck()'> </td>
					<%
					}else{
						if(rec_ref.equals("F")){
						%>
						<td width="25%" class="label"><fmt:message key="eBL.CASH_REFUNDED.label" bundle="${bl_labels}"/></td>
						<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' onKeyPress='return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))' onBlur='fnCashcheck();checkFrNumber(this);'> </td>
						<%}else
						{ %>
						<td width="25%" class="label"><fmt:message key="eBL.CASH_GIVEN.label" bundle="${bl_labels}"/></td>
							<% if(siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y")) { %>
						<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' readonly> </td>
							<% } else { %>
						<td width="25%" class="fields"><input type='text' name='cash_given' id='cash_given' size='14' maxlength='10' value="<%=cash_given%>" style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onBlur='funCashcheck()'> </td>
							<%}%>
						<% 	}						
				
						}
				}%>
			

			<td width="25%" class="label"><fmt:message key="eBL.CASH_RETURNED.label" bundle="${bl_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' name='cash_return' id='cash_return' id='cash_return'  size='14' maxlength='10' value="<%=cash_return%>" style='text-align:right' readonly > </td>
			</tr>
<%
			if(cashier_cheque_yn.equals("Y") && cash_slmt_flag.equals("Y"))
			{
%>
			<tr>		
			<td id='tdChqCarfBankNo' class="label" width="25%"><fmt:message key="eBL.CHQ_CARD_BANK_NO.label" bundle="${bl_labels}"/></td>		 
			<td class="fields" width="25%" ><input type='text' name='instref' id='instref' id='instref' size='20' maxlength='20' value="<%=instref%>" onKeyPress='return CheckForSpecChars_local(event)' <%=readonly_fld%> >
			<%if("Y".equals(credit_card_num_yn)){ %>
				<img src='../../eCommon/images/mandatory.gif'>
			<%} %>
			</td>		
			
			<td width="25%" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' name='instdate' id='instdate' size='15' maxlength='10' onBlur='return checkDateBL(this);' value='<%=instdate%>' <%=readonly_fld%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('instdate');" <%=disabled_fld%>>
	  <%
		if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
		{
		%>		
		<img src='../../eCommon/images/mandatory.gif'>
		<%} %>
			</td> 
			</tr>
			<tr>
			
			<td class="label" width="25%"><fmt:message key="eBL.BANK_NAME.label" bundle="${bl_labels}"/></td>
			<td width="25%" class="fields"><input type='text'  name="instremark" id="instremark" maxlength='100' size='20'  tabindex='0' value='<%=temp_bank_credit%>' onBlur="return bankcardlkup('B')" <%=readonly_fld%>><input type='button' class='button' name="bankcardbut" id="bankcardbut" value='?' onClick="return bankcardlkup('C')" tabindex='0' <%=disabled_fld%>>
			<img src='../../eCommon/images/mandatory.gif'>
			<td class="label"  width="25%"><fmt:message key="eBL.BRANCH_NAME.label" bundle="${bl_labels}"/></td>
			<td width="25%" class="fields"><input type='text' readonly name="instbranch" id="instbranch" maxlength='100' size='25' value="<%=instbranch%>" <%=readonly_fld%> ></td>  
				<input type= hidden name="instremarkcode" id="instremarkcode"  value="<%=p_instremarkcode%>">	        		
				
			</tr>
		<INPUT TYPE="HIDDEN" id="cashslmtflag" name="cashslmtflag" id="cashslmtflag" SIZE="1" MAXLENGTH="10" VALUE="<%=cash_slmt_flag%>"> 
<%
			}
%>
			<tr>
<!--		<td width="" align="right" class="label" colspan = '2'>Payer's Name</td>	-->
			<td width="25%" class="label" ><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' name='payername' id='payername' size='20' maxlength='100' value="<%=strslmtpayername%>" onKeyPress='return CheckForSpecChars_local(event)'></td>

<!--		<td width="" align="right" class="label">Payer's Ref ID</td>	-->
			<td width="25%" class="label"><fmt:message key="eBL.PAYER_DEP_REF_NO.label" bundle="${bl_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' name='recrefidno' id='recrefidno' size='20' maxlength='30' value="<%=strslmtidno%>" onKeyPress='return CheckForSpecChars(event)'> </td>
			</tr>
			<% //V210113 start
				if(siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y")) {					
			%>
			<tr>
			<td width="25%" class="label" ><fmt:message key="eBL.MembershipID.Label" bundle="${bl_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' readonly name='membershipID' id='membershipID' size='20' maxlength='100' value="<%=patMembershipID%>" onKeyPress='return CheckForSpecChars_local(event)'>
			<input type='button' class='button' name="couponButton" id="couponButton" value='Select' onClick="couponcodelkup()">
			</td>
			</tr>
			<tr>
			<td width="25%" class="label" ><fmt:message key="eBL.CouponCode.Label" bundle="${bl_labels}"/></td>	
			<% //V210224 start
				if(action_ind.equals("modify") && !slmt_change.equals("Y"))
				{ %>			
			<td width="25%" height="50" ><textarea readonly name="couponcodeTA" id="couponcodeTA" rows="4" cols="47"  maxlength = "155" value="" ><%=couponAndAmts %></textarea></td>
			<%
				}else {
			%>
			<td width="25%" height="50" ><textarea readonly name="couponcodeTA" id="couponcodeTA" rows="4" cols="47"  maxlength = "155" value="" ></textarea></td>
			<%}  //V210224 end
			%>
			</tr>			
			<% } else {  //V210113 end
			%>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<% } %>
			</table>
<%
	 }
%>

		<INPUT TYPE="HIDDEN" name="ext_acc_interface_yn" id="ext_acc_interface_yn" MAXLENGTH="10" VALUE='<%=ext_acc_interface_yn%>'>
		<INPUT TYPE="HIDDEN" name="ext_acc_fac_id" id="ext_acc_fac_id" MAXLENGTH="10" VALUE='<%=str_ext_acc_facility_id%>'>

<%
	if(isDebugYN)
		System.out.println("***Inside Settlement Type 2 - Cash Settlement Flag : "+cash_slmt_flag+" ***Settlement Type... "+strslmttype+" ***Reference No... "+instref);

	if(!(cash_slmt_flag.equals("Y")) && (!(strApplicationID.equals("PAYTM"))) && !(strcoupon_yn.equals("Y"))) //V210113
	{
		if(isDebugYN)
			System.out.println("***Inside Settlement Type 2 - INSIDE CREDIT CARD FUNCTION ");
%>
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>	
		<tr>		
<!--	<td align="right" class="label">Instrument Ref</td>		 -->
		<td id='tdChqCarfBankNo' class="label" width="25%"><fmt:message key="eBL.CHQ_CARD_BANK_NO.label" bundle="${bl_labels}"/></td>		 
		<td class="fields" width="25%" ><input type='text' name='instref' id='instref' id='instref' size='20' maxlength='20' value="<%=instref%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%> onblur="callCardNoValidation(this)">
		<%if("Y".equals(credit_card_num_yn)){ %>
		<img src='../../eCommon/images/mandatory.gif'>
		<%} %>
		</td>		
			
<!--	<td width="" align="right" class="label">Instrument Date</td>	onBlur='return CheckDate(this);'return 					chkDtGreaterEqualThanSysDateNew(document.forms[0].instdate,sys_date);'showCalendar_loc('instdate',document.forms[0].instdate);"-->
		<td width="25%" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>	
		<td width="25%" class="fields"><input type='text' name='instdate' id='instdate' size='15' maxlength='10' onBlur='return checkDateBL(this);' value='<%=instdate%>' <%=readonly_fld%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('instdate');" <%=disabled_fld%>>
		<%
		if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
		{
		%>		
		<img src='../../eCommon/images/mandatory.gif'>
		<%
		} 
		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	

		if (ccAppletCount>0)
		{
			if(isDebugYN)
				System.out.println("***Inside Settlement Type 2 - Inside Credit Card Applet.... ");
			
		%>		
			
		&nbsp;&nbsp;&nbsp;&nbsp;					
			<applet code="CreditCardApplet.class" name="CreditCardReader" 
					codebase="../CreditCard/" archive="CreditCardApplet.jar" width="10" height="10">
				<PARAM name="button_width" value="50" />
				<PARAM name="button_height" value="50" />
				<PARAM name="button_label" value="Credit Card" />	
				<PARAM name="input_data" value="" />
				<PARAM name="application_id" value="" />	
				<param name="separate_jvm" value="true" />
				Sorry, Your browser does not support Java applet!
			</applet> 
						
		<%			
		}	

		%>		
		</td> 
		<!--onClick="return showCalendar('instdate');"-->
		</tr> 			
		<tr>				
<% 
			if ( cash_slmt_flag.equals("A"))
			{
%>		
<!--			<td class="label" align="right" width="6%">Credit Card Co.</td> -->
				<td class="label"  width="25%"><fmt:message key="eBL.CREDIT_CARD_CO.label" bundle="${bl_labels}"/></td>
<% 
			}
			else 
			{
%>		
<!--			<td class="label" align="right" width="6%">Bank Name</td> -->
				<td class="label" width="25%"><fmt:message key="eBL.BANK_NAME.label" bundle="${bl_labels}"/></td>
<%
			}
%>
		
				<td width="25%" class="fields"><input type='text'  name="instremark" id="instremark" maxlength='100' size='20'  tabindex='0' value='<%=temp_bank_credit%>' onBlur="return bankcardlkup('B')" <%=readonly_fld%>><input type='button' class='button' name="bankcardbut" id="bankcardbut" value='?' onClick="return bankcardlkup('C')" tabindex='0' <%=disabled_fld%>>
<% 
//				if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("B") )
				if(!"Y".equals(cash_slmt_flag) && "Y".equals(credit_card_co_yn))
				{
%>		
					<img src='../../eCommon/images/mandatory.gif'>
<%
				}	
%>		
				</td>
<!--		<td class="label" align="right" width="">Branch Name</td> -->
			<td class="label"  width="25%"><fmt:message key="eBL.BRANCH_NAME.label" bundle="${bl_labels}"/></td>
			<td width="25%" class="fields"><input type='text' readonly name="instbranch" id="instbranch" maxlength='100' size='25' value="<%=instbranch%>" <%=readonly_fld%> ></td>  

   </tr>
		<input type= hidden name="instremarkcode" id="instremarkcode"  value="<%=p_instremarkcode%>">	        		
		<tr>
<!--	<td width="" align="right" class="label">Online Apprv.</td>	-->
		<td width="25%" class="label"><fmt:message key="eBL.ONLINE_APPROVAL.label" bundle="${bl_labels}"/></td>
<% 
			//added against ML-MMOH-SCF-1576
			if (cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D"))
			{
%>		
				<td width="25%" class="fields" ><input type='checkbox' name='onlineapproval' id='onlineapproval' <%=onlineapproval%> <%=disabled_fld%>></td>		
<%
			}
			else
			{
%>	
				<td width="25%"  class="fields"><input type='checkbox' name='onlineapproval' id='onlineapproval' disabled></td>				
<%
			}
		     //added against ML-MMOH-SCF-1576
			if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D")) 
			{
%>	
<!--	<td width="" align="right" class="label">Batch No</td>	 -->
		<td width="25%" class="label"><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></td> 
	    <td width="25%" class="fields"><input type='text' name='batchno' id='batchno' size='8' maxlength='8' value='<%=batchno%>' onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>
	    	<%if("Y".equals(batch_no_reqd_yn)){	 %>
	    		&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	    	<%} %>
	    	</td>
		</tr>		
		<tr>
<!-- 	<td width="" align="right" class="label">Approval Code</td>	 -->
	 	<td width="25%" class="label"><fmt:message key="eBL.APPROVAL_CODE.label" bundle="${bl_labels}"/></td>	
		<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->
	    <td width="25%" class="fields"><input type='text' name='apprrefno' id='apprrefno' size='20' maxlength='100' value="<%=apprrefno%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>
<% 
		  }
		else		 
		{	
%>			

<!--	<td width="" align="right" class="label">Batch No</td>	-->
		<td width="25%" class="label"><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></td>	
	    <td width="25%" class="fields" ><input type='text' name='batchno' id='batchno' size='8' maxlength='8' DISABLED value="<%=batchno%>" onKeyPress='return CheckForSpecChars(event)'></td>	

        </tr>
		
		<tr>

<!--	<td width="" align="right" class="label">Approval Code</td>	-->
		<td width="25%" class="label"><fmt:message key="eBL.APPROVAL_CODE.label" bundle="${bl_labels}"/></td>	
		<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->
		<%
		//added against ML-MMOH-SCF-1576
		if ( cash_slmt_flag.equals("D")) 
		{
		%>
	    <td width="25%" class="fields"><input type='text' name='apprrefno' id='apprrefno' size='20' maxlength='100' value="<%=apprrefno%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>
		<% } else {
		%>
		<td width="25%" class="fields"><input type='text' name='apprrefno' id='apprrefno' size='20' maxlength='100' DISABLED value="<%=apprrefno%>" onKeyPress='return CheckForSpecChars(event)'>
		<%
		}
		%>	
<%
		}

		if ( cash_slmt_flag.equals("A"))
		if("A".equals(cash_slmt_flag) && "Y".equals(approval_code_yn))	//Modified by Rajesh V
			{
%>		
			<img src='../../eCommon/images/mandatory.gif'>
<%
			}
%>		
		</td>    

<!--	<td width="" align="right" class="label">Sale Draft No</td>			-->
		<td width="25%" class="label"><fmt:message key="eBL.SALE_DRAFT_NO.label" bundle="${bl_labels}"/></td>
<% 
		//added against ML-MMOH-SCF-1576
		if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D")) 
		{
%>	
			<td width="25%" class="fields"><input type='text' name='saledraftno' id='saledraftno' size='20' maxlength='20' value="<%=saledraftno%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>
<%
		}
		else
		{
%>
			<td width="25%" class="fields"><input type='text' name='saledraftno' id='saledraftno' size='20' maxlength='20' value="<%=saledraftno%>" DISABLED onKeyPress='return CheckForSpecChars(event)'>
<% 
		}	
		/*Added By Muthukumar against Sale_Draft_No Mandatory (30025) on 13-12-11
		if (cash_slmt_flag.equals("A") && str_sale_draft_mandatory_yn.equals("Y")) */
		if (cash_slmt_flag.equals("A"))
		{
%>		
			<!-- Commented by Muthukumar against Sale_Draft_No Mandatory (30025) on 20-12-11
				<img src='../../eCommon/images/mandatory.gif'>-->
<%
		}
%>				
		</td>
		
		</tr>
<%		if(action_ind.equals("modify"))
		{
%>
			<tr>		
		<!--	<td width="" align="right" class="label">Payer's Name</td>	-->
				<td width="25%" class="label"><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>	
				<td width="25%" class="fields"><input type='text' name='payername' id='payername' size='20' maxlength='100' value="<%=strslmtpayername%>" onKeyPress='return CheckForSpecChars_local(event)'>
<% 
				if ( cash_slmt_flag.equals("B")==true &&  payer_name_reqd_yn.equals("Y")==true )
				{
	%>		
					<img src='../../eCommon/images/mandatory.gif'>
	<%
				}
%>					
				</td>

		<!--	<td width="" align="right" class="label">Payer's Ref ID</td>	-->
				<td width="25%"class="label"><fmt:message key="eBL.PAYER_DEP_REF_NO.label" bundle="${bl_labels}"/></td>	

				<td width="25%" class="fields"><input type='text' name='recrefidno' id='recrefidno' size='20' maxlength='30' value="<%=strslmtidno%>" onKeyPress='return CheckForSpecChars(event)'>

		<% 
				if ( "Y".equals(payer_ref_reqd_yn)==true )
				{
		%>		
					<img src='../../eCommon/images/mandatory.gif'>
		<%
				}
		%>					
				</td>      	   	
			</tr>	
<%
			}
		else{
%>
			<tr>		
	<!--	<td width="" align="right" class="label">Payer's Name</td>	-->
			<td width="25%" class="label"><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>	
			<td width="25%" class="fields"><input type='text' name='payername' id='payername' size='20' maxlength='100' value="<%=strslmtpayername%>" onKeyPress='return CheckForSpecChars_local(event)' <%=readonly_fld%>>
	<% 
		//	if ( cash_slmt_flag.equals("B"))
			
%>					
			</td>

	<!--	<td width="" align="right" class="label">Payer's Ref ID</td>	-->
			<td width="25%"class="label"><fmt:message key="eBL.PAYER_DEP_REF_NO.label" bundle="${bl_labels}"/></td>	

		<td width="25%" class="fields"><input type='text' name='recrefidno' id='recrefidno' size='20' maxlength='30' value="<%=strslmtidno%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>


<% 
			if ( "Y".equals(payer_ref_reqd_yn)==true )
			{
	%>		
				<img src='../../eCommon/images/mandatory.gif'>
	<%
			}
			
	%>
			</td>      	   	
			</tr>
			<tr><td colspan="4" >&nbsp;</td></tr>
			<!--<tr><td colspan="4" >&nbsp;</td></tr>
			<tr><td colspan="4" >&nbsp;</td></tr>-->
<%	
		}
%>
		<!--<tr><td colspan="4" >&nbsp;</td></tr>
		<tr><td colspan="4" >&nbsp;</td></tr>
		<tr><td colspan="4" >&nbsp;</td></tr>-->
	   </table>	
<INPUT TYPE='HIDDEN' id="cashslmtflag" name="cashslmtflag" id="cashslmtflag" SIZE="1" MAXLENGTH="10" VALUE="<%=cash_slmt_flag%>"> 
<!--  <input type="hidden" name="cashslmtflag" id="cashslmtflag" SIZE="1" MAXLENGTH="10" value="<%=cash_slmt_flag%>"> -->
			 
			
<% 	


	}	
	//Added by Sethu for GHL-CRF-0415 on 18/04/2017
	if(!(cash_slmt_flag.equals("Y")) && ((strApplicationID.equals("PAYTM"))))
	{
%>
			<table border='0' cellpadding='3' cellspacing='0' valign = 'left' width='60%'>
			<tr>
				<td class="label" width="25%">
					<div id='show_payTM_option' style='display:inline'><fmt:message key="eBL.PAYTM_PAYBY_OPTION.label" bundle="${bl_labels}"/></div>
				</td>
				<td width='25%' class="label">				
					<fmt:message bundle="${bl_labels }" key="eBL.PAYTM_PAYBY_BARCODE.label"></fmt:message>&nbsp;
					<input type="radio" id='PayTMOption' name='PayTMOption' id='PayTMOption' value='B' checked="checked" onclick="fnChangePayTM();">
				</td>
				<td width='25%' class="label">				
					<fmt:message bundle="${bl_labels }" key="eBL.PAYTM_PAYBY_TOTP.label"></fmt:message>&nbsp;
					<input type="radio" id='PayTMOption' name='PayTMOption' id='PayTMOption' value='T' onclick="fnChangePayTM();">
				</td>
			</tr>
			</table>
			<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>
				<tr>
					<td class="label" width="18%">
						<div id='show_payTM_field1' style='display:inline'><fmt:message key="eBL.PAYTM_USER_CODE.label" bundle="${bl_labels}"/></div>
						<div id='show_payTM_phone1' style='display:none'><fmt:message key="eBL.PAYTM_PHONE_NO.label" bundle="${bl_labels}"/></div>&nbsp;&nbsp;
						<!--<div id='show_payTM_phone2' style='display:none'><INPUT TYPE="TEXT" name="instref" id="instref" ID="instref" SIZE="14" style='text-align:left' value="<%=instref%>"></div>-->
					</td>
					<td class="fields" width="32%">
						<div id='show_payTM_field2' style='display:inline'><INPUT TYPE="TEXT" name="instref" id="instref" ID="instref" SIZE="30" maxlength="25" style='text-align:left' value="<%=instref%>"></div> &nbsp;&nbsp;
						<div id='show_payTM_otp1' style='display:none'><fmt:message key="eBL.PAYTM_OTP.label" bundle="${bl_labels}"/></div>&nbsp;&nbsp;
						<div id='show_payTM_otp2' style='display:none'><INPUT TYPE="TEXT" name="paytmOtp" id="paytmOtp" ID="paytmOtp" SIZE="10" maxlength="10" style='text-align:left'></div>
					</td>
					<td class="label" width="15%">
						<div id='show_payTM_field3' style='display:none'><fmt:message key="eBL.PAYTM_PROMO_CODE.label" bundle="${bl_labels}"/></div>
					</td>
					<td class="fields" width="15%">
						<div id='show_payTM_field4' style='display:none'><INPUT TYPE="TEXT" name="batchno" id="batchno" ID="batchno" SIZE="10" style='text-align:left' value='<%=batchno%>'></div>
					</td>
					<%
					if(str_credit_card_machine_int_yn.equals("Y"))
					{
					%>	
						<td class="fields" width="10%">
							<div id='show_payTM_button1' style='display:none'><input type='button' name='validate_paytm_pay' id='validate_paytm_pay' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYTM_PAY.label","bl_labels")%>" class='button' onClick='validate_py_tranx("PAY")' <%=readonly1%>></div>
						</td>
						<td class="fields" width="10%">
							<div id='show_payTM_button2' style='display:none'><input type='button' name='validate_paytm_check' id='validate_paytm_check' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYTM_CHECK_STATUS.label","bl_labels")%>" class='button' onClick='validate_py_tranx("CHECKSTATUS")' <%=readonly1%>></div>
						</td>
					<%
					}
					else
					{
					%>
						<td width="10%">&nbsp;</td>
						<td width="10%">&nbsp;</td>
					<%
					}
					%>

				</tr>
				<tr>	
					<% 

					if ( strslmtidno.length() > 0 )
						readonly_fld="readonly";
					else
						readonly_fld="";
					%>	
					<td width="18%"class="label"><fmt:message key="eBL.PAYTM_TXN_NO.label" bundle="${bl_labels}"/></td>	
					<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->
					<td width="32%" class="fields"><input type='text' name='apprrefno' id='apprrefno' size='20' maxlength='100' value="<%=apprrefno%>" onKeyPress='return CheckForSpecChars(event)' <%=readonly_fld%>>

						<% 

						if ( "Y".equals(payer_ref_reqd_yn)==true )
						{
						%>		
							<img src='../../eCommon/images/mandatory.gif'>
						<%
						}
						%>					
					</td>  
					<% 

					if ( strslmtidno.length() > 0 )
					{
						readonly_fld="readonly";
						disabled_fld="disabled";
					}
					else
					{
						readonly_fld="";
						disabled_fld="";
					}
					%>	
					<td width="15%" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>	
					<td width="15%" class="fields"><input type='text' name='instdate' id='instdate' size='15' maxlength='10' onBlur='return ValidateDateTimesp(this);' value='<%=instdate%>' <%=disabled_fld%>>&nbsp;&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" id="PayTMCal" onClick="return showCalendar('instdate',null,'hh:mm:ss');" <%=disabled_fld%>>
					<%
					if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
					{
					%>		
					<img src='../../eCommon/images/mandatory.gif'>
					<%} %>		
					</td> 
					<td width="10%">&nbsp;</td>
					<td width="10%">&nbsp;</td>
				</tr> 				
				<tr>
					<td width="18%" class="label"><fmt:message key="eBL.PAYTM_ORDER_NO.label" bundle="${bl_labels}"/></td>
			<% 
					if ( cash_slmt_flag.equals("A") )
					{
			%>	
						<td width="32%" class="fields"><input type='text' name='saledraftno' id='saledraftno' size='20' maxlength='20' value="<%=saledraftno%>" onKeyPress='return CheckForSpecChars(event)'>
			<%
					}
					else
					{
			%>
						<td width="30%" class="fields"><input type='text' name='saledraftno' id='saledraftno' size='20' maxlength='20' value="<%=saledraftno%>" onKeyPress='return CheckForSpecChars(event)'>
			<% 
					}					
			%>				
					</td>
					<td width="15%">&nbsp;</td>
					<td width="15%">&nbsp;</td>
					<td width="10%">&nbsp;</td>
					<td width="10%">&nbsp;</td>
				
				</tr>

		   </table>	
			<INPUT TYPE='HIDDEN' id="cashslmtflag" name="cashslmtflag" id="cashslmtflag" SIZE="1" MAXLENGTH="10" VALUE="<%=cash_slmt_flag%>"> 
			<!--  <input type="hidden" name="cashslmtflag" id="cashslmtflag" SIZE="1" MAXLENGTH="10" value="<%=cash_slmt_flag%>"> -->
				 
			
<% 

		}	
		//Added by Sethu for GHL-CRF-0415 on 18/04/2017 -- Ends here.
	
	}catch(Exception e )
		{
			//out.println(e);
			System.out.println("main :"+e);
		} 
		finally
		{
			if (rs21 != null)   rs21.close();			
			if(stmt != null)stmt.close();
			ConnectionManager.returnConnection(con, request);
		}		 
%> 
	<input type= hidden name="locale" id="locale"  value="<%=locale%>">
	<input type='hidden' name='short_desc' id='short_desc' value="<%=short_desc%>">
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type=hidden name='sys_date' id='sys_date' value="<%=sys_date%>">
	<input type=hidden name='str_credit_card_machine_int_yn' id='str_credit_card_machine_int_yn' value="<%=str_credit_card_machine_int_yn%>">
	<input type=hidden name='cashier_cheque_yn' id='cashier_cheque_yn' value="<%=cashier_cheque_yn%>">
	<input type=hidden name='sale_draft_reqd_yn' id='sale_draft_reqd_yn' value="<%=sale_draft_reqd_yn%>">
	<input type=hidden name='payer_name_reqd_yn' id='payer_name_reqd_yn' value="<%=payer_name_reqd_yn%>">
	<input type=hidden name='payer_ref_reqd_yn' id='payer_ref_reqd_yn' value="<%=payer_ref_reqd_yn%>">
	<input type=hidden name='credit_card_num_yn' id='credit_card_num_yn' value="<%=credit_card_num_yn%>">
	<input type=hidden name='credit_card_co_yn' id='credit_card_co_yn' value="<%=credit_card_co_yn%>">
	<input type=hidden name='approval_code_yn' id='approval_code_yn' value="<%=approval_code_yn%>">
	<input type=hidden name='credit_card_check_yn' id='credit_card_check_yn' value="<%=credit_card_check_yn%>">

	<input type=hidden name='batch_no_reqd_yn' id='batch_no_reqd_yn' value="<%=batch_no_reqd_yn%>">
	<input type=hidden name='slmt_doc_ref_date_reqd_yn' id='slmt_doc_ref_date_reqd_yn' value="<%=slmt_doc_ref_date_reqd_yn%>">

	<input type=hidden name='function_id' id='function_id' value="<%=function_id%>">
	<input type=hidden name='rec_ref' id='rec_ref' id='rec_ref' value="<%=rec_ref%>">
	<input type=hidden name='chequeCategorize' id='chequeCategorize' id='chequeCategorize' value="<%=chequeCategorize%>">
	<input type=hidden name='chequeLengthChange' id='chequeLengthChange' id='chequeLengthChange' value="<%=chequeLengthChange%>">

	<!--Added by Sethu for GHL-CRF-0415 on 19/04/2017-->
	<input type=hidden name='slmt_type' id='slmt_type' value="<%=strslmttype%>">
	<input type='hidden' name='patientid' id='patientid' value='<%=strpatientid%>'>
	<input type='hidden' name='PayTMTransDate' id='PayTMTransDate' value="<%=instdate%>">
	<input type='hidden' name='LoggedUser' id='LoggedUser' value="<%=strloggeduser%>">
	<input type=hidden name='application_id' id='application_id' value="<%=strApplicationID%>">
	<input type=hidden name='facilityid' id='facilityid' value="<%=strfacilityid%>">
	<input type=hidden name='clientIpAddress' id='clientIpAddress' value="<%=strClientIpAddress%>">
	<!--Added by Sethu for GHL-CRF-0373 on 05/06/2019-->
	<input type=hidden id='action_ind' name='action_ind' id='action_ind' value="<%=action_ind%>">
	<!--Added by Sethu for KDAH-CRF-0504 on 14/08/2019-->
	<input type=hidden id='credit_card_status_yn' name='credit_card_status_yn' id='credit_card_status_yn' value="<%=slmt_check_status%>">
	<input type=hidden id='credit_card_batch_id' name='credit_card_batch_id' id='credit_card_batch_id' value="">
	<input type=hidden id='credit_card_roc_no' name='credit_card_roc_no' id='credit_card_roc_no' value="">
	<input type=hidden id='credit_card_trn_no' name='credit_card_trn_no' id='credit_card_trn_no' value="">
	<input type=hidden id='credit_trn_status' name='credit_trn_status' id='credit_trn_status' value="N">
	<!--Added by Sethu for KDAH-CRF-0535 on 07/01/2020-->
	<input type=hidden id='cc_request_type' name='cc_request_type' id='cc_request_type' value="">
	<input type=hidden id='credit_card_urn_no' name='credit_card_urn_no' id='credit_card_urn_no' value="">
	
	<input type='hidden' name='coupon_yn' id='coupon_yn' value='<%=strcoupon_yn%>'>
	<input type='hidden' name='patMembershipID' id='patMembershipID' value='<%=patMembershipID%>'>	
	<input type='hidden' name='siteCouponInSlmt' id='siteCouponInSlmt' value='<%=siteCouponInSlmt%>'>
	<input type='hidden' name='couponAndAmt' id='couponAndAmt' value="<%=couponAndAmts %>" >		
	<input type='hidden' name='coupons' id='coupons' value='<%=coupons %>'>
	<input type='hidden' name='couponcode' id='couponcode' value='<%=coupons %>'>
	<!--Added by Sethu for KDAH-CRF-0535 on 07/01/2020-->
	<!--Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
	<input type=hidden id='cc_term_id_num' name='cc_term_id_num' id='cc_term_id_num' value="">
	<input type=hidden id='cc_issuing_bank' name='cc_issuing_bank' id='cc_issuing_bank' value="">
	<input type=hidden id='cc_trx_date_time' name='cc_trx_date_time' id='cc_trx_date_time' value="">	

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




