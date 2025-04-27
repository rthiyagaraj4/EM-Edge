<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth
2            V210224             8157          NMC-JD-CRF-0072               Shikha Seth
3				 15771	       NMC-JD-SCF-0164		     Sethuraman D
4	      	V220404			     27973				MMS-ME-SCF-0046-TF					Mohana Priya K
5			V220506				27018				NMC-JD-SCF-0262			Mohana Priya K
6			V220808				35014		BL-TH-KW-CRF-0017-US001/03-Other
												Settlement types				MohanaPriya K
 -->
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat,eCommon.XSSRequestWrapper, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eCommon.Common.CommonBean"%>
<%

	request.setCharacterEncoding("UTF-8");   
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220404
	System.err.println("BLBillSlmtDet2.jsp");
	String strdfltslmttypecode = "";
	String locale	= (String)session.getAttribute("LOCALE");
	String short_desc ="";String querystring="";
	String strbillpayableamt="";//String p_total_amt_payable="";
	int noofdecimal=2;	

	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rscurr            = null;

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip = p.getProperty("client_ip_address");
	con	=	ConnectionManager.getConnection(request);
	
	String sqlStmtType="", strbilldoctypecode="",strbilldocnum="",strfacilityid="",strpatientid="",strepisodetype="",strepisodeid="",strvisitid="",strslmtpayername="",struser="",strslmtidno="",strcashcounter="",total_settled_amt="",p_settled_amt_det="",action_ind="",rec_ref="";
	String str_v_payable_amt="0.00",strscashcountercode="",p_slmttype="",p_strslmtamt = "", str_remaining_amt="";			
	String strslmtamt = "",readonly1="", p_billdoctypecode="",str_v_mod_payable_amt="0.00";			
	double v_payable_amt=0; double v_mod_payable_amt=0;	
	String cc_type="",mess_const_for_cc_mc="",cc_approval_check_YN="N",cc_trx_approved_YN="N";
	String p_field_separator="",p_piped_op="",p_errtext="";
	String mesg_frm_cc_mc="",credit_card_approvd_YN="N";
	String str_credit_card_machine_int_yn="",str_credit_card_machine_id="",str_err_code="",str_error_text="",str_sys_message_id="";
	String cash_slmt_flag="";String slmt_type_code="";
	String coupon_yn = "";//V210113
	String warning_message_text = "";

	String function_id="";
	
	//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
	String slmt_check_status = "N";

	String standard_code = "", segment_id = "";
	boolean siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	//V210224
%>
<HTML>
<HEAD>
<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
<!--
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>-->
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<script language='javascript'>	
		function dfltslmt()
		{
			show_valid_button();				
			if(document.forms[0].cc_approval_check_YN.value=="N")
			{				
				var dfltslmt = document.forms[0].dfltslmttypecode.value;										
				var billslmtamt = document.forms[0].billslmtamt.value;	
				if (billslmtamt == null || billslmtamt == 0 || billslmtamt == "")
					return;						
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
						subValue = cashSetValue.substring(0,2);					
					}					
					if (subValue == dfltslmt)
					{					
						document.forms[0].slmttype.value = cashSetValue;
						//calldfltslmt(cashSetValue);//V220506
						callslmt("Y"); //V220506
					}
				}
			}
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	//Added by Manivel Natarajan on 10/Aug/2006	
	try
	{
		p_slmttype=request.getParameter("slmttype");	
		
		if ( p_slmttype == null || p_slmttype.equalsIgnoreCase("null")) 
			{p_slmttype ="";}
		//System.err.println("p_slmttype in Det2sp:"+p_slmttype);
		cc_approval_check_YN=request.getParameter("cc_approval_check_YN");
		if(cc_approval_check_YN == null) cc_approval_check_YN="N";		

		strbilldoctypecode = request.getParameter("billdoctypecode");
		strbilldocnum = request.getParameter("billdocnum");	
		strbillpayableamt = request.getParameter("billpayableamt");			
		strfacilityid = request.getParameter("facilityid");	
		strpatientid  = request.getParameter("patientid");	
 		strepisodetype = request.getParameter("episodetype");	
		strepisodeid = request.getParameter("episodeid");
		strvisitid = request.getParameter("visitid");				
		strslmtpayername = request.getParameter("slmtpayername");	
		struser = request.getParameter("loggeduser");	
		strslmtidno = request.getParameter("slmtidno");
		strcashcounter = request.getParameter("cashcounter");
		//String strdfltcashbillslmtamt = "";		String strrcptallowedyn = "";
		//String strchangereceiptamtind = "";		String strrcptallowedynuser = "";
		//String strchangereceiptalloweduser = "";	//String strslmttype= request.getParameter("slmttype");	
		querystring=(String)request.getQueryString();
		action_ind=request.getParameter("action");	
		if(action_ind==null || action_ind.equals("")) action_ind="";		
		p_settled_amt_det=request.getParameter("settled_amt_det");
		rec_ref=request.getParameter("rec_ref");
	
		if ( p_settled_amt_det == null || p_settled_amt_det.equalsIgnoreCase("null") || p_settled_amt_det.equals("")) 
			{p_settled_amt_det ="0.0";}		
		total_settled_amt=request.getParameter("total_settled_amt");
		if ( total_settled_amt == null || total_settled_amt.equalsIgnoreCase("null") || total_settled_amt.equals("")) 
			{total_settled_amt ="0.0";}
		v_payable_amt=Double.parseDouble(p_settled_amt_det)-Double.parseDouble(total_settled_amt);		
		str_v_payable_amt=String.valueOf(v_payable_amt);

		function_id = request.getParameter("function_id");
		if(function_id == null) function_id="";
		
//02-01-09
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
		{
			System.err.println("3 from det 2="+e.toString());
			e.printStackTrace();
		}

		CurrencyFormat cf = new CurrencyFormat();
		str_v_payable_amt = cf.formatCurrency(str_v_payable_amt, noofdecimal);	
		str_remaining_amt=str_v_payable_amt;
		
		if(action_ind.equals("modify")||action_ind.equals("remove"))
		{
			//if(p_slmttype.equals("CCA")) {readonly1="disabled";}		
			p_strslmtamt=request.getParameter("billslmtamt");
			if(p_strslmtamt.equals("")) p_strslmtamt="";		
			v_mod_payable_amt=Double.parseDouble(p_strslmtamt)+v_payable_amt;		
			str_v_mod_payable_amt=String.valueOf(v_mod_payable_amt);
			//CurrencyFormat cf = new CurrencyFormat();
			str_v_mod_payable_amt = cf.formatCurrency(str_v_mod_payable_amt, noofdecimal);
		}
		p_billdoctypecode=request.getParameter("billdoctypecode");
		if ( p_billdoctypecode == null || p_billdoctypecode.equalsIgnoreCase("null") || p_billdoctypecode.equals("")) 
				{p_billdoctypecode ="";}

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null") || p_billdoctypecode.equals("")) 
				{strbilldoctypecode ="";}

		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")|| strbilldocnum.equals("")) 
				{strbilldocnum = "";}

		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")|| strbillpayableamt.equals("")) 
				{strbillpayableamt = "";}

		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")|| strfacilityid.equals("")) 
				{strfacilityid = "";}

		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")|| strpatientid.equals("")) 
				{strpatientid = "";}

		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")|| strepisodetype.equals("")) 
				{strepisodetype = "";}


		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")|| strepisodeid.equals("")) 
				{strepisodeid = "";}

		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";

		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")|| strslmtpayername.equals(""))  
				{strslmtpayername = "";}

		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")|| strslmtidno.equals("")) strslmtidno = "";

		if ( struser == null || struser.equalsIgnoreCase("null") || struser.equals("")) struser = "";

		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")|| strcashcounter.equals("")) 
					strcashcounter ="";
		if(cc_approval_check_YN.equals("Y"))
		{
			str_v_payable_amt=request.getParameter("billslmtamt");
			if(str_v_payable_amt == null) str_v_payable_amt="";
			cc_trx_approved_YN=request.getParameter("cc_trx_approved_YN");
			if(cc_trx_approved_YN == null) cc_trx_approved_YN="N";
			mesg_frm_cc_mc=request.getParameter("mesg_frm_cc_mc");
			if(mesg_frm_cc_mc == null) mesg_frm_cc_mc="";
			strbillpayableamt = request.getParameter("billpayableamt");	
			if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
			{strbillpayableamt = "";}			
			action_ind=request.getParameter("action_ind");	
			if(action_ind==null || action_ind.equals("")) action_ind="";	

			//p_strslmtamt=request.getParameter("p_strslmtamt");	
			//if(p_strslmtamt==null || p_strslmtamt.equals("")) p_strslmtamt="";	
			p_strslmtamt=request.getParameter("billslmtamt");
			if(p_strslmtamt.equals("")) p_strslmtamt="";		

			str_v_mod_payable_amt=request.getParameter("billpayableamt");
			if(str_v_mod_payable_amt.equals("")) str_v_mod_payable_amt="";		
		}
			
		if(cc_trx_approved_YN.equals("Y"))
		{
			try
			{
				CallableStatement  call = con.prepareCall("{ call BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE(?,?,?,?,?,?) }");

				call.setString(1,mesg_frm_cc_mc);// Message recd from CC Machine
				call.setString(2,locale);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.setString(4,"J"); // Platform Type - J- Java					
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);

				call.execute();

				p_field_separator=call.getString(3);
				if(p_field_separator == null) p_field_separator="";

				p_piped_op=call.getString(5);					
				if(p_piped_op == null) p_piped_op="";
				p_errtext=call.getString(6);
				if(p_errtext == null) p_errtext="";

				call.close();
				if(!p_errtext.equals(""))
				{
					credit_card_approvd_YN="N";
%>
						<script>
							alert("<%=p_errtext%>");
						</script>
<%

				}
				else
				{
					credit_card_approvd_YN="Y";		
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception while calling BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE:"+e);
				e.printStackTrace();
			}

		}
		//end of credit card interface
		/*	
		try
		{				
			pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N') from bl_parameters where operating_facility_id = '" + strfacilityid + "'");

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltcashbillslmtamt =  rs.getString(1);						
			}
			else
					strdfltcashbillslmtamt = "N";
		}
		catch(Exception e) 
		{ }
		finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
		}	


		if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
		   strdfltcashbillslmtamt = "N";

		*/
   
		try
		{
			//pstmt = con.prepareStatement(" select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"' and patient_id='"+strpatientid+"'");	   
			//added by rammohan for defult slmt type 
			if(strepisodetype.equals("D") || strepisodetype.equals("I"))
			{
				//sqlStmtType="select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "'  and patient_id='"+strpatientid+"'";
				
				pstmt = con.prepareStatement("select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = ? and episode_type = ? and episode_id = ?  and patient_id=?");
				
				pstmt.setString(1,strfacilityid);
				pstmt.setString(2,strepisodetype);
				pstmt.setString(3,strepisodeid);
				pstmt.setString(4,strpatientid);
				
			}
			else if(strepisodetype.equals("O") || strepisodetype.equals("E"))
			{			
				//sqlStmtType="select slmt_type_code from BL_VISIT_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"' and patient_id='"+strpatientid+"'";
				
				pstmt = con.prepareStatement("select slmt_type_code from BL_VISIT_FIN_DTLS where operating_facility_id = ? and episode_type = ? and episode_id = ? and visit_id = ? and patient_id=?");
				
				pstmt.setString(1,strfacilityid);
				pstmt.setString(2,strepisodetype);
				pstmt.setString(3,strepisodeid);
				pstmt.setString(4,strvisitid);
				pstmt.setString(5,strpatientid);
				
			}
			else if(strepisodetype.equals("R"))
			{
			//	sqlStmtType="select slmt_type_code from BL_PATIENT_FIN_DTLS where patient_id='"+strpatientid+"'";
				pstmt = con.prepareStatement("select slmt_type_code from BL_PATIENT_FIN_DTLS where patient_id= ? ");
				pstmt.setString(1,strpatientid);
				
			}		
		//	pstmt = con.prepareStatement(sqlStmtType);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltslmttypecode =  rs.getString(1);						
			}
			else
			{
				strdfltslmttypecode = "";
			}
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();	
		}
		catch(Exception e) 
		{ }
		/*finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
		}*/	

		if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
				strdfltslmttypecode = "";

//end
		/*
		try
		{		
			pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = '" + strcashcounter + "' and operating_facility_id = '" + strfacilityid + "'");

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedyn =  rs.getString(1);			
				strchangereceiptamtind =  rs.getString(2);			
			}
			else
			{	strrcptallowedyn = "N";
				strchangereceiptamtind = "N";
			}		
		}

		catch(Exception e) 
		{}

		finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
		}	

		if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
		   strrcptallowedyn = "N";

		if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
		   strchangereceiptamtind = "N";
		*/

		/*
		try
		{		
			pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");

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
		}
		catch(Exception e) 
		{}
		finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
			//Moved here in Bangalore on 13/10/2005
			//ConnectionManager.returnConnection(con, request);	
		}	

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
		   strrcptallowedynuser = "N";

		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		   strchangereceiptalloweduser = "N";	
		*/

		/*	
		if (strdfltcashbillslmtamt.equals("N") || strrcptallowedyn.equals("N")
			|| strrcptallowedynuser.equals("N") )
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
		//COMMENTED ON 02/01/09 ADD AT LINE 132
		/*try{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			rscurr.close();
			pstmt.close();
		}catch(Exception e) {System.err.println("3 from det 2="+e.toString());}*/
		//COMMENT END

		/*p_total_amt_payable=request.getParameter("total_amt_payable");
		if ( p_total_amt_payable == null || p_total_amt_payable.equalsIgnoreCase("null")) 
		{p_total_amt_payable ="";}
		CurrencyFormat cf = new CurrencyFormat();
		p_total_amt_payable = cf.formatCurrency(p_total_amt_payable, noofdecimal);*/

%>	
	<script>		
			
		function checkslmtamt(val)
		{
			
			var v_billslmtamt = "";			
			var v_billpayableamt = "";

			var str = document.forms[0].slmttype.value;
			var v_cashslmtflag =str.charAt(2);	
			//V210224 start
			var v_couponflag = str.charAt(3);
			var siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;		
			// V210224 end
			if(v_cashslmtflag =="Y"){
				if(val.value<0){
					putdeci(val); //V220808
					parent.frames[1].document.forms[0].cash_given.value=val.value;
					parent.frames[1].document.forms[0].cash_given.focus();
				}else{
					parent.frames[1].document.forms[0].cash_given.value='';
				} //V220803
				parent.frames[1].document.forms[0].cash_return.value='';
			}

			v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;					
			v_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;
			
			if(v_billpayableamt < 0)
			{
				var temp=v_billslmtamt.indexOf('-');
				if(temp != -1 ) 
				{
					if(temp != 0 ) 
					{
						alert(getMessage("INVALID_NUMBER_FORMAT","common"));
						document.forms[0].billslmtamt.focus();
						return false;
					}
				}	
			}				
			
			if(v_billpayableamt>0 && v_billslmtamt<0 || v_billpayableamt<0 && v_billslmtamt>0 )
			{
				alert(getMessage("BL9863","BL"));
				document.forms[0].billslmtamt.select();
				return false;
			}
			

			var billslmtamt=document.forms[0].billslmtamt.value;
			//if(billslmtamt==0)	 //V210224 commented		
			if(billslmtamt==0 && !(siteCouponInSlmt =='true' && v_cashslmtflag == 'D' && v_couponflag=='Y')) //V210224
			{	if(parent.frames[0].document.forms[0].billslmtamt.readOnly == 'false') { //V210224
				//alert("Amount Settled must be greater than zero");
				alert(getMessage("BL9776","BL"));
				document.forms[0].billslmtamt.select();
				return false;
				} //V210224
			}

			if ( parseFloat(Math.abs(v_billslmtamt)) > parseFloat(Math.abs(v_billpayableamt)))
			{
				//alert("Allocated amount is greater than outstanding amount");
				alert(getMessage("BL7085","BL"));
				parent.frames[0].document.forms[0].billslmtamt.select();
				parent.frames[0].document.forms[0].billslmtamt.focus();
				return false;
			}

		/*	if ( parseFloat(v_billslmtamt) < 0 )
			{
				//alert(" Refund cannot be allowed");
				alert(getMessage("BL9536","BL"));
				parent.frames[0].document.forms[0].billslmtamt.select();
				parent.frames[0].document.forms[0].billslmtamt.focus();
				return false;
			}*/

			if ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == "" || v_billslmtamt == null )
			{
				if (!(siteCouponInSlmt =='true' && v_cashslmtflag == 'D' && v_couponflag=='Y')) { //V210224
					document.forms[0].slmttype.value = "";
					calldfltslmt("");	
				} //V210224
			}
			var temp_billslmtamt=eval("document.forms[0].billslmtamt");
			putdeci(temp_billslmtamt);
			if(document.forms[0].slmttype.value =="CAY")
			{
				//parent.frames[1].document.forms[0].cash_given.focus();
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

			//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
			var v_cc_term_id_num = "";
			var v_cc_instbranch = "";
			var v_cc_trx_date_time = "";

			v_billslmtamt = parent.frames[1].document.forms[0].billslmtamt.value;					
			v_slmttype = parent.frames[1].document.forms[0].slmttype.value;							

			parent.frames[0].document.forms[0].pagecloseind.value = "0";
			
			if (v_billslmtamt == null ) v_billslmtamt ="";
			if (v_slmttype == null ) v_slmttype = "";

			if (v_slmttype == "" && parseFloat(v_billslmtamt) > 0)
			{	
				//alert( "Settlement Type cannot be blank");
				alert(getMessage("BL9521","BL"));
				//parent.frames[1].document.forms[0].slmttype.focus();
				return false;
			}

			if (v_slmttype != "" && parseFloat(v_billslmtamt) == 0)
			{	
				//alert( "Settlement Type cannot be selected for Zero amount");
				alert(getMessage("BL9522","BL"));
				//parent.frames[1].document.forms[0].slmttype.focus();
				return false;
			}			

			if (v_slmttype != "" &&  v_billslmtamt =="" )
			{	
				//alert( "Settlement Amount cannot be blank");
				alert(getMessage("BL9523","BL"));
				//parent.frames[0].document.forms[0].billslmtamt.focus();
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
					//alert("Receipt Type cannot be blank");
					alert(getMessage("BL9524","BL"));
					parent.frames[1].document.forms[0].rectype.focus();
					return false;
				}

				if ( v_ext_acc_code == "")
				{
					//alert("Account code cannot be blank");
					alert(getMessage("BL9525","BL"));
					parent.frames[1].document.forms[0].acccode.focus();
					return false;
				}

				if ( v_ext_acc_dept == "")
				{
					//alert("Accounting department cannot be blank");
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
				//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
				v_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
				v_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;
				v_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;
			}
			else
			if (v_cashslmtflag == "Y" && v_slmttype != "")
			{
			
				v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
				v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
			}			
			
			
			//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->	
			//parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt='+v_billslmtamt+'&slmttypecode='+v_slmttype.substring(0,2)+'&slmtdocref='+v_instref+'&slmtdocrefdate='+v_instdate+'&slmtdocrefremark='+v_instremark+'&slmtidno='+v_slmtidno+'&slmtpayername='+v_slmtpayername+'&slmtapprrefno='+v_slmtapprrefno+'&onlineapproval='+v_online_approval+'&batchno='+v_batch_no+'&saledraftno='+v_sale_draft_no+'&rectype='+v_rectype+'&extaccfacid='+v_ext_acc_facility_id+'&extacccode='+v_ext_acc_code+'&extaccdept='+v_ext_acc_dept; 
			//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
			parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt='+v_billslmtamt+'&slmttypecode='+v_slmttype.substring(0,2)+'&slmtdocref='+v_instref+'&slmtdocrefdate='+v_instdate+'&slmtdocrefremark='+v_instremark+'&slmtidno='+v_slmtidno+'&slmtpayername='+v_slmtpayername+'&slmtapprrefno='+v_slmtapprrefno+'&onlineapproval='+v_online_approval+'&batchno='+v_batch_no+'&saledraftno='+v_sale_draft_no+'&rectype='+v_rectype+'&extaccfacid='+v_ext_acc_facility_id+'&extacccode='+v_ext_acc_code+'&extaccdept='+v_ext_acc_dept+'&cctermidnum='+v_cc_term_id_num+'&cctrxdatetime='+v_cc_trx_date_time+'&instbranch='+v_cc_instbranch; 
				
		}

		async function billslmtprocessclose()
		{				

			if ( parent.frames[0].document.forms[0].pagecloseind.value != "1" )
			{	
			    parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>'; 				

				/*
				var dialogHeight	= "50vh" ;
				var dialogWidth		= "50vw" ;
				var dialogTop		= "1";
				var center			= "1";														   
				var status			= "no";
				var features		= "dialogHeight:"  + dialogHeight + 
									  "; dialogWidth:" + dialogWidth + 	
									  "; center: "	   + center + 
									  "; status: "	   + status	+ 
									  "; dialogTop :"  + dialogTop;
				var arguments	= "" ;								

									
				var retVal = await window.showModalDialog('../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>',arguments,features); 
				*/

				return;			

			}			
		}

		function calldfltslmt(val)
		{
			show_valid_button();				
			var str = val;
			var obj=str.substring(0,2);								
			var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;
			var function_id = document.forms[0].function_id.value;
			var rec_ref=parent.frames[0].document.forms[0].rec_ref.value;
			var patientid = document.forms[0].patientid.value;	//Added by Sethu for GHL-CRF-0415 on 21/04/2017
			var coupon_yn = obj.charAt(3); //V210113
			if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "")
			{
				parent.frames[1].location.href="../../eBL/jsp/BLBillSlmtType2.jsp?slmttype="+obj+"&slmtidno=<%=strslmtidno%>&slmtpayername=<%=URLEncoder.encode(strslmtpayername)%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billslmtamt="+v_billslmtamt+"&function_id="+function_id+"&rec_ref="+rec_ref+"&patientid="+patientid+"&coupon_yn="+coupon_yn; //V210113 
				//patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017
			}
			else
			{
				parent.frames[1].location.href='../../eCommon/html/blank.html';
			}	

			if ( v_billslmtamt == "" && str != "")
			{
				parent.frames[0].document.forms[0].slmttype.value = "";
				//alert("Settlement Amount cannot be blank");					
				alert(getMessage("BL9523","BL"));					
				return false;
			}
		}

		function callslmt(val)
		{					
			//disp_valid_button();				
			var str =document.forms[0].slmttype.value;	
			var action_ind = document.forms[0].action_ind.value;
			var obj=str.substring(0,2);				
			var slmt_flag=str.charAt(2);					
			var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;					
			var querystring =document.forms[0].querystring.value;	
			strscashcountercode=document.forms[0].strscashcountercode.value;
			credit_card_approvd_YN=document.forms[0].credit_card_approvd_YN.value;
			field_separator=document.forms[0].field_separator.value;
			piped_op=document.forms[0].piped_op.value;
			//var warning_message_text = str.substring(3,str.length);	
			var warning_message_text = str.substring(4,str.length);	
			var function_id = document.forms[0].function_id.value;				
			var rec_ref=parent.frames[0].document.forms[0].rec_ref.value;
			var patientid = document.forms[0].patientid.value; //patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017
			var coupon_yn = str.charAt(3);					//V210113
			var siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value; //V210224
			var billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value; //V210224
			if(val=='Y' && warning_message_text != "")
			{
				alert(warning_message_text);
			}				

			//V210224 start
			 if (siteCouponInSlmt == "true" && coupon_yn == "Y" && slmt_flag == "D" && action_ind =="modify"){					
				 	parent.frames[0].document.forms[0].billslmtamt.readOnly = "true";
			}else if (siteCouponInSlmt == "true" && coupon_yn == "Y" && slmt_flag == "D" && action_ind =="add"){					
					parent.frames[0].document.forms[0].billslmtamt.value = "";									 
				 	parent.frames[0].document.forms[0].billslmtamt.readOnly = "true";
			}else {				
				parent.frames[0].document.forms[0].billslmtamt.value = billpayableamt;
				v_billslmtamt = billpayableamt;
				if(parent.frames[0].document.forms[0].billslmtamt.readOnly =='true')
				 	parent.frames[0].document.forms[0].billslmtamt.readOnly = "false";
			}
			// V210224 end
			if (obj.charAt(2) != "Y" && obj != "" && ((siteCouponInSlmt == "true" && coupon_yn == "Y" && slmt_flag == "D") || v_billslmtamt != ""  ))
			//if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "" ) //V210224 commented
			{
				parent.frames[1].location.href="../../eBL/jsp/BLBillSlmtType2.jsp?slmttype="+obj+"&slmtidno=<%=strslmtidno%>&slmtpayername=<%=URLEncoder.encode(strslmtpayername)%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&strscashcountercode="+strscashcountercode+"&billslmtamt="+v_billslmtamt+"&field_separator="+field_separator+"&piped_op="+piped_op+"&credit_card_approvd_YN="+credit_card_approvd_YN+"&slmt_change="+val+"&slmt_flag="+slmt_flag+"&function_id="+function_id+"&"+querystring+"&rec_ref="+rec_ref+"&patientid="+patientid+"&coupon_yn="+coupon_yn;
				//patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017
			}
			else
			{
				parent.frames[1].location.href='../../eCommon/html/blank.html';
			}	


			//if ( v_billslmtamt == "" && str != "") //V210224 commented
			if ( v_billslmtamt == "" && str != "" && !(siteCouponInSlmt == "true" && coupon_yn == "Y" && slmt_flag == "D")) //V210224
			{
				parent.frames[0].document.forms[0].slmttype.value = "";
				//alert("Settlement Amount cannot be blank");					
				alert(getMessage("BL9523","BL"));					
				return false;
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
			var action_ind=document.forms[0].action_ind.value;
			if(action_ind=="remove")
			{
				var len = document.forms[0].elements.length;
				for(var i=0;i<len;i++)
				{
					document.forms[0].elements(i).disabled=true;
				}
			}
		}

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
			//if(key == "-" && fld.value.indexOf(key) != -1) return false; // Not more than one '-' char
		}



		/*function disp_valid_button()
		{	
		
		var str = document.forms[0].slmttype.value; 					
		 var cashslmtflag =str.charAt(2)
			if(cashslmtflag=='A')
			{			
				if(document.forms[0].billpayableamt.value != '')
				{		
					document.getElementById('show_button').style.display='inline';
				}
			}
			else
				document.getElementById('show_button').style.display='none';
			

		}*/
		function show_valid_button()
		{		
			if(document.forms[0].cc_approval_check_YN.value == "Y")		
			{
				document.getElementById('show_button').style.display='inline';
				var mess_const_for_cc_mc=document.forms[0].mess_const_for_cc_mc.value;
				var slmttype = document.forms[0].slmttype.value;



				if(document.forms[0].cc_trx_approved_YN.value == "N")
				{
					parent.frames[4].location.href='../../eBL/jsp/BLCreditCardInterfaceValidation.jsp?mess_const_for_cc_mc='+encodeURIComponent(mess_const_for_cc_mc)+'&slmttype='+slmttype;
				}

			}
			
		}

		function validate_cc_tranx(obj)
		{
			parent.frames[5].location.href='../../eCommon/jsp/process.jsp';
			var str = document.forms[0].slmttype.value; 					
			var cashslmtflag =str.charAt(2);

			if (obj == "validate_cc_pymt"){

				creditCardForm=	parent.frames[1].document.forms[0];

				creditCardForm.credit_card_batch_id.value="";
				creditCardForm.credit_card_roc_no.value="";
				creditCardForm.credit_trn_status.value="N";
				
				//Added by Sethu for KDAH-CRF-0535 on 07/01/2020
				creditCardForm.cc_request_type.value="WITHDRAW_MONEY";

				var status_btn = parent.frames[0].document.getElementById("validate_cc_status");

				if (status_btn)
					status_btn.disabled = true;

				parent.frames[0].document.getElementById('show_button_status').style.display='inline';

			}
			
			//Added by Sethu for KDAH-CRF-0535 on 07/01/2020
			if (obj == "validate_cc_status"){
				creditCardForm=	parent.frames[1].document.forms[0];				
				creditCardForm.cc_request_type.value="CHECK_STATUS";	
			}

			if(document.forms[0].billslmtamt.value != '' && cashslmtflag == 'A')
			{			
				document.forms[0].cc_approval_check_YN.value='Y';								
				document.forms[0].submit();
			}		

		}

	</script>	   
</HEAD>

<%
	if(action_ind.equals("modify")||action_ind.equals("remove")||credit_card_approvd_YN.equals("Y"))	
	{
%>
		<BODY	onLoad="callslmt();show_valid_button();disableAllElements_billslmt_remove()"  onUnload="billslmtprocessclose();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
<%
	}
	else
	{
	%>
		
	<!--<BODY	onLoad="dfltslmt();callslmt('Y');"  onUnload="billslmtprocessclose();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >-->
		<BODY	onLoad="dfltslmt();"  onUnload="billslmtprocessclose();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
<%
	}

%>
			<FORM name='BillSlmtDetForm' id='BillSlmtDetForm' method='post'  action='../../eBL/jsp/BLBillSlmtDet2.jsp'  scrolling='NO' >
	
				<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		 
<!--
	<tr>
<!--	<td class="label" width="25%">Bill No</td>	 
	<td class="label" width="25%"><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></td>	 
	<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billdoctype" id="billdoctype" SIZE="7" MAXLENGTH="10" 				VALUE='<%=strbilldoctypecode%>'  style='text-align:left'> / <INPUT TYPE="TEXT" 
	READONLY name="billdocnum" id="billdocnum" SIZE="8" MAXLENGTH="10"  VALUE='<%=strbilldocnum%>' style='text-align:right'></td>
<!--	<td class="label" width="25%">Payable Amount</td>	
	<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/></td>	
	<!--
	<td>&nbsp;<INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="8" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;<INPUT TYPE="button"  class="BUTTON" VALUE="  OK  " onClick='billslmtprocess()'><td> 	
	

	<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'></td> 	
	</tr> -->

<%		if(action_ind.equals("modify"))
		{
		//p_total_amt_payable
%>
			<tr>
			<td class="label" width="25%"><fmt:message key="eBL.REM_SLMT_AMT.label" bundle="${bl_labels}"/></td>	
<!--		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="15" MAXLENGTH="20" 					VALUE='<%=str_v_mod_payable_amt%>'  style='text-align:right' ></td> -->	
			<td class="label" width="25%" ><div ><%=str_v_mod_payable_amt%></div></td>
			<INPUT TYPE="hidden"  name="billpayableamt" id="billpayableamt"	VALUE='<%=str_v_mod_payable_amt%>' >
			<td class="fields" width="25%"></td>
			<td class="fields" width="25%"></td>
			</tr>
<%
		}else{
%>
			<tr>
			<td class="label" width="25%"><fmt:message key="eBL.REM_SLMT_AMT.label" bundle="${bl_labels}"/></td>	
			<td class="label" width="25%"><div ><%=str_remaining_amt%></div></td>
			<INPUT TYPE="hidden"  name="billpayableamt" id="billpayableamt"	VALUE='<%=str_remaining_amt%>'>	
			<td class="fields" width="25%"></td>
			<td class="fields" width="25%"></td>
			</tr>
	
<%
			}
%>
			<tr>	
			<td class="label" width="25%"><fmt:message key="eBL.AMT_SETTLED.label" bundle="${bl_labels}"/></td>
<!--		<td class="label" width="25%">Amount Settled</td>	-->
			<%if(action_ind.equals("modify") || action_ind.equals("remove"))
			{
%>

<% 
/*
	if (strchangeyn.equals("Y"))
	{ 
*/		
%>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT" name="billslmtamt" id="billslmtamt" SIZE="14" MAXLENGTH="10" 	VALUE='<%=p_strslmtamt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2))' onBlur='return checkslmtamt(this);checkForNumber(this);' <%=readonly1%>> </td>	<!--V220803-->
<% 
/*
	} 
	 else
	 {*/
 %>
<!--
				<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billslmtamt" id="billslmtamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=p_strslmtamt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,2))' onBlur='return checkslmtamt();'> </td>	
-->
<% 
//	  } 
			}
			else{
%>
<% 
/*
	if (strchangeyn.equals("Y"))
	{ 
*/
%>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT" name="billslmtamt" id="billslmtamt" SIZE="14" MAXLENGTH="10" 	VALUE='<%=str_v_payable_amt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))' onBlur='return checkslmtamt(this);checkForNumber(this);'> </td>	<!--V220803-->
<% 
/*
	 } 
	 else
	 {
*/
     %>
<!--			<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billslmtamt" id="billslmtamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onBlur='return checkslmtamt();'> </td>	
-->
<% 
//	  }
			}%>
<!-- 	<td width="25%"  class="label" >Settlement Type<input type='hidden' name='Case' id='Case' value='1'></td> -->
 			<td width="25%"  class="label" ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/><input type='hidden' name='Case' id='Case' value='1'></td>
			<td width="25%" class="fields" ><select name='slmttype' id='slmttype' onChange='callslmt("Y")' <%=readonly1%>>
			<% //V210224
			if(!action_ind.equals("modify")) {%>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />---</option>
			<%} %>
<%

			try {
					//con	=	ConnectionManager.getConnection(request);

					// Cash Counter Check


					String temp_episodetype = "";
					if( strepisodetype.equals("O") || strepisodetype.equals("E"))
					{
						temp_episodetype = "O";
					}
					else if( strepisodetype.equals("I") || strepisodetype.equals("D"))
					{
						temp_episodetype = "I";					
					}
					else 
					{
						temp_episodetype = "R";					
					}

					CallableStatement call = 
					con.prepareCall("{ call bl_user_check_for_cash_counter (?,?,?,?,?,?,?)}");			
					call.setString(1,strfacilityid);
					call.setString(2,temp_episodetype);
					call.setString(3,struser);
					call.setString(4,strclientip);

					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					strscashcountercode	 = call.getString(5);	
					String strshiftid	  	     = call.getString(6);		
					String strsysmessageid		 = call.getString(7);		

					call.close();

					String strerrortext = "";

					if ( strscashcountercode == null ) strscashcountercode = "";
					if ( strshiftid == null ) strshiftid = "";
					if ( strsysmessageid == null ) strsysmessageid = "";


					if (!(strsysmessageid.equals("")))
					{
					/*try
					{			
						call = 
						con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,strsysmessageid);
						call.execute();				
						strerrortext = call.getString(1);			
						call.close();	
						if ( strerrortext == null ) strerrortext = ""; 
					}
					catch(Exception e)
					{ out.println(e.toString());}	*/
				
					if ( !(strerrortext.equals("")) )
					{
					%>
					<script>				
						//alert("eee");
						var v_error = '<%=strerrortext%>';
						alert(v_error);				 
					 </script>
					<%
					}		
			      }

				 

// PE Changes					pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text from bl_slmt_type_lang_vw where language_id='"+locale+"' and status is null and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where 		operating_facility_id =  '"+ strfacilityid + "' and cash_counter_code = '"+ strscashcountercode + "' and status is null) order by short_desc  " ) ;
			//V210224 start
				if(action_ind.equals("modify"))	{
					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text,coupon_yn from bl_slmt_type_lang_vw where language_id= ? and status is null and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id= ? ) and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code = ? and status is null) and  slmt_type_code = substr( ? ,0,2) and cash_slmt_flag= substr(? ,3) order by short_desc") ;
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					pstmt.setString(5,p_slmttype);
					pstmt.setString(6,p_slmttype);
					
				}else{
	//V210224 end
					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text,coupon_yn from bl_slmt_type_lang_vw where language_id= ? and status is null and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id= ? ) and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code = ? and status is null) order by short_desc") ; //V210113
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					

				} //V210224
				
					rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						
						while( rs2.next() ) 
						{
							short_desc="";
							slmt_type_code = rs2.getString( "slmt_type_code" ) ;
							//System.err.println("slmt_type_code121212 " +slmt_type_code);
							short_desc = rs2.getString( "short_desc" ) ;
							cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
//							System.err.println("slmt_type_code121212flag " +cash_slmt_flag);

							warning_message_text=rs2.getString("warning_message_text") ;
							coupon_yn = rs2.getString("coupon_yn"); //V210113
							if ( slmt_type_code == null ) slmt_type_code = "";
							if ( short_desc == null ) short_desc ="";
							if ( cash_slmt_flag == null ) cash_slmt_flag = "";
							if ( warning_message_text == null) warning_message_text = ""; 
							if ( coupon_yn == null) coupon_yn = ""; //V210113
	//						defaulting settlement type from visit fin dtls if exist...					    
							String temp_slmt_type_slmt_flag=slmt_type_code+cash_slmt_flag;
							
							boolean refundChkForCreditcardBlock=false;
							String totalAmtReq=request.getParameter("total_amt_payable");
							if(totalAmtReq==null) totalAmtReq="";
							String ccCheckTotalPayableAmt = ( totalAmtReq.equals("") ) ?"0.0":request.getParameter("total_amt_payable");
							float ccCheckTotalPayableAmtFloat=Float.parseFloat(ccCheckTotalPayableAmt);
							if(ccCheckTotalPayableAmtFloat<0){
								refundChkForCreditcardBlock=true;
							} 


							if( ( slmt_type_code.equals("CC") && refundChkForCreditcardBlock==true ) ){
								//Karthik added the logic to block Creditcard settlement for Refund Cases
							}
							else{

							if(temp_slmt_type_slmt_flag.equals(p_slmttype))
							{									
								out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+""+coupon_yn+""+warning_message_text+"\">"+short_desc+"</option>");	//V210113						
							}
							else
							{				

								out.println("<option  value=\""+slmt_type_code+""+cash_slmt_flag+""+coupon_yn+""+warning_message_text+"\">"+short_desc+"</option>");	//V210113		
							}
							
							}

	//						out.println("<input type=hidden name='slmt_type_short_desc' id='slmt_type_short_desc'  value='"+short_desc+"'>");
			//				out.println("<input type=hidden name='slmt_type_code' id='slmt_type_code'  value='"+slmt_type_code+"'>");
							
														
						}
					}
				
				
				
				}
				catch(Exception e) 
					{
						//out.println(e.toString());
						e.printStackTrace();	
					}



//added 23-10-2007
	try{
			if(cash_slmt_flag.equals("A")){
				//System.err.println("strscashcountercodeAAAA:"+strscashcountercode);
				String ccCheck="{ call BLCOMMON.GET_CREDIT_CARD_INT_DTL(?,?,?,?,?,?,?,?)}";
				//System.err.println("CC Check"+ccCheck);
				CallableStatement call =	con.prepareCall(ccCheck);
				call.setString(1, strfacilityid);  
				call.setString(2, strscashcountercode);  
				call.setString(3, slmt_type_code);  				
				call.registerOutParameter(4,java.sql.Types.VARCHAR);				
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.execute();

				str_credit_card_machine_int_yn = call.getString(4);
				if(str_credit_card_machine_int_yn == null) str_credit_card_machine_int_yn="";

				str_credit_card_machine_id=call.getString(5);
				if(str_credit_card_machine_id == null) str_credit_card_machine_id="";

				str_err_code= call.getString(6);
				if(str_err_code == null) str_err_code="";

				str_error_text= call.getString(7);
				if(str_error_text == null) str_error_text="";

				str_sys_message_id = call.getString(8);
				if(str_sys_message_id == null) str_sys_message_id="";
				
						call.close();
	
			}
		}catch(Exception ee)
		{
			System.err.println("error in CC check"+ee);
			ee.printStackTrace();
		}
		
//end 22-10-2007

				

			//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
			String stdQuery = "select SEGMENT_ID, STANDARD_CODE from XH_STANDARD_CONTROL_SEG where ELEMENT_ID = 'SETTLEMENT_TYPE' and DEFAULT_VALUE = ? ";

			if (slmt_type_code.length() >0)
			{
				try{						
					pstmt = con.prepareStatement(stdQuery);						
					pstmt.setString(1, slmt_type_code);
					rs2 = pstmt.executeQuery() ;

					if( rs2 != null ) 
					{							
						while( rs2.next() ) 
						{
							segment_id = rs2.getString( "SEGMENT_ID" ) ;
							standard_code = rs2.getString( "STANDARD_CODE" ) ;																
						}
					}					
				}
				catch(Exception ee)
				{
					System.err.println("Error in checking the segment, standard code for the payemnt type ::: "+ee.getMessage());
					ee.printStackTrace();
				}


				if (segment_id.length()>0 && standard_code.length()>0)
				{
					stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'CHECK_TRN_STATUS' and STANDARD_CODE = ? ";

					try{
							
						pstmt = con.prepareStatement(stdQuery);
						
						pstmt.setString(1, segment_id);
						pstmt.setString(2, standard_code);
						rs2 = pstmt.executeQuery() ;

						if( rs2 != null ) 
						{							
							while( rs2.next() ) 
							{
								slmt_check_status = rs2.getString( "DEFAULT_VALUE" ) ;
							}
						}	
						
						
					}
					catch(Exception ee)
					{
						System.err.println("Error in checking the payment type check status flag for the payemnt type::: "+ee.getMessage());
						ee.printStackTrace();
					}							

				}
			}


			try {

				if (rs2 != null)   rs2.close();
				if (pstmt != null) pstmt.close();		 	
				//Moved here in Bangalore on 13/10/2005
				ConnectionManager.returnConnection(con, request);	

			}
			catch(Exception e) {}
			finally 
			{
				if (rs2 != null)   rs2.close();
				if (pstmt != null) pstmt.close();		 	
				//Moved here in Bangalore on 13/10/2005
				ConnectionManager.returnConnection(con, request);	
			}
			
	

%>			
				</select>	
				<!-- <td class="label"> </td> -->
<!--
			
<%

			if (credit_card_approvd_YN.equals("Y"))
			{
%>
				<div id='show_button' style='display:inline'>
					<input type='button' name='validate_cc_pymt' id='validate_cc_pymt' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")%>" class='button' onClick='validate_cc_tranx()' disabled> 
				</div>				
				&nbsp;&nbsp;&nbsp;
				<div id='show_button_status' style='display:inline'>
				<input type='button' name='validate_cc_status' id='validate_cc_status' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick='validate_cc_tranx()' disabled>  
				</div>
				
<%			
			}
			else
			{						
%>

				<div id='show_button' style='display:none'>
					<input type='button' name='validate_cc_pymt' id='validate_cc_pymt' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")%>" class='button'onClick='validate_cc_tranx()' <%=readonly1%>>
				</div>
				&nbsp;&nbsp;&nbsp;
				<div id='show_button_status' style='display:none'>
				<input type='button' name='validate_cc_status' id='validate_cc_status' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick='validate_cc_tranx()' <%=readonly1%>>
				</div>
<%
			}
%>
-->
			</td>
			</tr>
			<tr>		
				<td width="25%" class="fields" >&nbsp;</td>
				<td width="25%" class="fields" >&nbsp;</td>
				<td width="25%" class="fields" colspan="2" align="">
<%
				if (credit_card_approvd_YN.equals("Y"))
				{
%>
					<div id='show_button' style='display:inline'>
						<input type='button' name='validate_cc_pymt' id='validate_cc_pymt' id='validate_cc_pymt' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")%>" class='button' onClick="validate_cc_tranx(this.id)" disabled> 
					</div>	
					&nbsp;&nbsp;&nbsp;
					<div id='show_button_status' style='display:inline'>
					<input type='button' name='validate_cc_status' id='validate_cc_status' id='validate_cc_status'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick="validate_cc_tranx(this.id)" disabled>  
					</div>		
<%			
				}
				else
				{						
%>
					<div id='show_button' style='display:none'>
						<input type='button' name='validate_cc_pymt' id='validate_cc_pymt' id='validate_cc_pymt' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")%>" class='button' onClick="validate_cc_tranx(this.id)" <%=readonly1%>>
					</div>	
					&nbsp;&nbsp;&nbsp;
					<div id='show_button_status' style='display:none'>
					<input type='button' name='validate_cc_status' id='validate_cc_status' id='validate_cc_status'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick="validate_cc_tranx(this.id)" disabled>
					</div>
<%
				}
%>
				</td>
	<!--
				<td width="25%" class="fields">
<%
				if (credit_card_approvd_YN.equals("Y"))
				{
%>					
					<div id='show_button_status' style='display:inline'>
					<input type='button' name='validate_cc_status' id='validate_cc_status' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick='validate_cc_tranx()' disabled>  
					</div>				
<%			
				}
				else
				{						
%>					
					<div id='show_button_status' style='display:none'>
					<input type='button' name='validate_cc_status' id='validate_cc_status' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")%>" class='button' onClick='validate_cc_tranx()' <%=readonly1%>>
					</div>
<%
				}
%>
				</td>
				-->
			</tr>
			<tr>		
				<td colspan="4" >&nbsp;</td>
			</tr>
			
			

		</table> 
	<INPUT TYPE="HIDDEN" name="pagecloseind" id="pagecloseind"   SIZE="50" MAXLENGTH="100" 	VALUE="0">		
	<INPUT TYPE="HIDDEN" name="dfltslmttypecode" id="dfltslmttypecode" SIZE="50" MAXLENGTH="100" 	VALUE='<%=strdfltslmttypecode%>' >	 
	<INPUT TYPE="HIDDEN" name="slmtdate" id="slmtdate"	   SIZE="20" MAXLENGTH="20" 	VALUE=""> 
	<INPUT TYPE="HIDDEN" name="slmtdocrefdesc" id="slmtdocrefdesc" SIZE="50" MAXLENGTH="100"	VALUE="">	
	<INPUT TYPE="HIDDEN" name="slmtdocref" id="slmtdocref"	   SIZE="50" MAXLENGTH="100" 	VALUE="">	 
	<!--<INPUT TYPE="HIDDEN" name="slmt_type_short_desc" id="slmt_type_short_desc"   SIZE="50" MAXLENGTH="100" 	VALUE="<%=short_desc%>">-->
	<INPUT TYPE="HIDDEN" name="querystring" id="querystring"   SIZE="50" MAXLENGTH="100" 	VALUE="<%=querystring%>">
	<INPUT TYPE="HIDDEN" name="total_amt_payable" id="total_amt_payable"   SIZE="50" MAXLENGTH="100" 	VALUE="<%=strbillpayableamt%>">
	<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' >
	<input type='hidden' name='rec_ref' id='rec_ref' id='rec_ref' value='<%=rec_ref%>' >
	
	<input type= hidden name="action_ind" id="action_ind"  value='<%=action_ind%>'>
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type= hidden name="strscashcountercode" id="strscashcountercode"  value='<%=strscashcountercode%>'>
	<input type='hidden' name='total_settled_amt' id='total_settled_amt' value='<%=total_settled_amt%>'>
	<input type='hidden' name='settled_amt_det' id='settled_amt_det' value='<%=p_settled_amt_det%>'>
	<input type='hidden' name='cashcounter' id='cashcounter' value='<%=strcashcounter%>'>
	<input type='hidden' name='slmtidno' id='slmtidno' value='<%=strslmtidno%>'>
	<input type='hidden' name='loggeduser' id='loggeduser' value='<%=struser%>'>
	<input type='hidden' name="slmtpayername" id="slmtpayername" value="<%=strslmtpayername%>">
	<input type='hidden' name='visitid' id='visitid' value='<%=strvisitid%>'>
	<input type='hidden' name='episodeid' id='episodeid' value='<%=strepisodeid%>'>
	<input type='hidden' name='episodetype' id='episodetype' value='<%=strepisodetype%>'>
	<input type='hidden' name='patientid' id='patientid' value='<%=strpatientid%>'>
	<input type='hidden' name='facilityid' id='facilityid' value='<%=strfacilityid%>'>
	<input type='hidden' name='billdocnum' id='billdocnum' value='<%=strbilldocnum%>'>
	<input type='hidden' name='billdoctypecode' id='billdoctypecode' value='<%=strbilldoctypecode%>'>
	<input type='hidden' name='mess_const_for_cc_mc' id='mess_const_for_cc_mc' value='<%=mess_const_for_cc_mc%>'>
	<input type='hidden' name='credit_card_approvd_YN' id='credit_card_approvd_YN' value='<%=credit_card_approvd_YN%>'>
	<input type='hidden' name='cc_approval_check_YN' id='cc_approval_check_YN' value='<%=cc_approval_check_YN%>'>
	<input type='hidden' name='cc_trx_approved_YN' id='cc_trx_approved_YN' value='<%=cc_trx_approved_YN%>'>
	<input type='hidden' name='mesg_frm_cc_mc' id='mesg_frm_cc_mc' value='<%=mesg_frm_cc_mc%>'>
	<input type='hidden' name='p_strslmtamt' id='p_strslmtamt' value='<%=p_strslmtamt%>'>
	<input type=hidden name='str_credit_card_machine_int_yn' id='str_credit_card_machine_int_yn' value='<%=str_credit_card_machine_int_yn%>'>

	<input type='hidden' name='field_separator' id='field_separator' value='<%=p_field_separator%>'>
	<input type='hidden' name='piped_op' id='piped_op' value='<%=p_piped_op%>'>

	<input type='hidden' name='warning_message_text' id='warning_message_text' value='<%=warning_message_text%>'>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<!-- 		GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->
	<% 
	String moduleid= request.getParameter("moduleid");
	String called_module_id=(String)session.getAttribute("called_module_id");	
	String responsibility_id=(String)session.getAttribute("responsibility_id");
	%>
	<input type='hidden' name='strclientip' id='strclientip' value='<%=strclientip%>'>
	<input type='hidden' name='moduleid' id='moduleid' value='<%=called_module_id%>'>
	<input type='hidden' name='responsibility_id' id='responsibility_id' value='<%=responsibility_id%>'>
	
	
	<%
	String pDocDate="";
	try{		

		con	=	ConnectionManager.getConnection(request);
		
		String docDateSql=	"SELECT to_char(DOC_DATE,'YYYYMMDDHH24MISS') FROM BL_BILL_HDR  "
				 + " WHERE  OPERATING_FACILITY_ID = ? AND PATIENT_ID  = ?     AND DOC_TYPE_CODE     = ?"
		         + " AND DOC_NUM  = ?     AND EPISODE_TYPE = ?       AND EPISODE_ID = ?"; 
		
		pstmt = con.prepareStatement(docDateSql) ;
		pstmt.setString(1, strfacilityid);
		pstmt.setString(2, strpatientid);
		pstmt.setString(3, strbilldoctypecode);
		pstmt.setString(4, strbilldocnum);
		pstmt.setString(5, strepisodetype);
		pstmt.setString(6, strepisodeid);
	
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{		
			if( rs.next() ) 
			{
				pDocDate=rs.getString(1);
			}
		}
	
	}catch(Exception ee)
	{
		System.err.println("error in CC check"+ee);
		ee.printStackTrace();
	}
	finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
			if (con!=null) ConnectionManager.returnConnection(con, request);	
		}
	%>

	<input type='hidden' name='p_doc_date' id='p_doc_date' value='<%=pDocDate%>'>	
	<input type='hidden' name='prepaid_card_number' id='prepaid_card_number' value=''>
	<input type='hidden' name='receipt_date' id='receipt_date' value=''>
	<input type='hidden' name='receipt_number' id='receipt_number' value=''>
	<input type='hidden' name='trn_type' id='trn_type' value=''>
	<input type='hidden' name='trn_number' id='trn_number' value=''>
	<input type='hidden' name='ext_input_key' id='ext_input_key' value=''>
	<input type='hidden' name='ext_application_id' id='ext_application_id' value=''>
	<input type='hidden' name='ext_function' id='ext_function' value=''>
	<input type='hidden' name='slmt_type_code' id='slmt_type_code' value='<%=slmt_type_code%>'>
<!-- 	GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->
	<input type='hidden' name='slmt_check_status' id='slmt_check_status' value='<%=slmt_check_status%>'>
	<input type='hidden' name='siteCouponInSlmt' id='siteCouponInSlmt' value='<%=siteCouponInSlmt%>'>
		
</FORM>	
<%
	}catch(Exception e)
	{
		System.err.println("Exception in main detl="+e);
		e.printStackTrace();
	}
	finally{					
		if(con!=null) {
		ConnectionManager.returnConnection(con, request);
					  }
	}
%>
</BODY>
</HTML>

