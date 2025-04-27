<!DOCTYPE html>
 <!--
	Author		 		:	Prakash.S
	Created on 			:										
	Last Modified on	:	
	Module/Function		:	
	Purpose				:	
	
-->

<%@ page import ="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!--
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
-->
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<%
Connection con=null ;
CallableStatement cstmt	= null;
PreparedStatement pstmt		= null;
ResultSet rs				= null;
try
{
	con	=	ConnectionManager.getConnection(request);	
	//con = (Connection) session.getValue("connection");
//The following changes are done for Internationalisation Process
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//unused variable, commented on 09/06/05
	String /*err_mesg = "", */ fm_nur_code="",to_nur_code="",fm_bed_no="",to_bed_no="",fm_bed_class="";
	String fm_bed_type ="", to_bed_type="";
	String to_bed_class="",trans_code="",encount_id="",str_facility_id="";
	String charge_yn="",addl_dep_yn="",trn_dep_amt="",perc_amt_ind="",transfer_serv_charge="",episode_id="";
	String bill_type_code = "",blng_class_code = "",serv_panel_ind="",blng_serv_code="",dly_serv_panel_ind="",dly_blng_serv_code="";
	String sys_message_id="", error_code="";

	String str_blng_grp_id = "", str_cust_code = "", str_non_ins_blng_grp_id = "", str_non_ins_cust_code = "", str_settlement_ind = "";
	String str_function_id = "", str_module_id="", str_patient_id ="", str_episode_type="", str_physician_id="", str_user_id="",str_ws_no="";

	fm_nur_code= request.getParameter("fm_nur_code");
	to_nur_code= request.getParameter("to_nur_code");
	fm_bed_no= request.getParameter("fm_bed_no");
	to_bed_no= request.getParameter("to_bed_no");
	fm_bed_type= request.getParameter("from_bed_type");
	to_bed_type= request.getParameter("to_bed_type");
	fm_bed_class= request.getParameter("fm_bed_class");
	to_bed_class= request.getParameter("to_bed_class");
	trans_code= request.getParameter("trans_code");
	encount_id= request.getParameter("encount_id");
	str_facility_id=request.getParameter("facility_id");
	str_function_id=request.getParameter("function_id");
	str_module_id=request.getParameter("module_id");
	str_patient_id=request.getParameter("patient_id");
	str_episode_type=request.getParameter("episode_type");
	str_physician_id=request.getParameter("physician_id");
	str_user_id = p.getProperty( "login_user" ) ;
	str_ws_no = p.getProperty("client_ip_address");

	if((fm_nur_code==null) || fm_nur_code.equals("null") || fm_nur_code.equals("undefined"))fm_nur_code="";
	if((to_nur_code==null) || to_nur_code.equals("null") || to_nur_code.equals("undefined")) to_nur_code="";
	if((fm_bed_no==null) || fm_bed_no.equals("null") || fm_bed_no.equals("undefined")) fm_bed_no="";
	if((to_bed_no==null) || to_bed_no.equals("null") || to_bed_no.equals("undefined"))to_bed_no="";
	if((fm_bed_class==null) || fm_bed_class.equals("null") || fm_bed_class.equals("undefined"))fm_bed_class="";
	if((to_bed_class==null) || to_bed_class.equals("null") || to_bed_class.equals("undefined"))to_bed_class="";
	if((trans_code==null) || trans_code.equals("null") || trans_code.equals("undefined"))trans_code="";
	if((encount_id==null) || encount_id.equals("null") || encount_id.equals("undefined"))encount_id="";
	if((str_facility_id==null) || str_facility_id.equals("null") || str_facility_id.equals("undefined")) str_facility_id="";
	if((str_function_id==null) || str_function_id.equals("null") || str_function_id.equals("undefined")) str_function_id="";
	if((str_module_id==null) || str_module_id.equals("null") || str_module_id.equals("undefined")) str_module_id="";
	if((str_patient_id==null) || str_patient_id.equals("null") || str_patient_id.equals("undefined")) str_patient_id="";
	if((str_episode_type==null) || str_episode_type.equals("null") || str_episode_type.equals("undefined")) str_episode_type="";
	if((str_physician_id==null) || str_physician_id.equals("null") || str_physician_id.equals("undefined")) str_physician_id="";

	if(!trans_code.equals(""))
	{
		trans_code=trans_code.substring(0,2);
	}
	try
	{
		episode_id		= encount_id;
		if (episode_id == null) episode_id = "";
/*		if(!(episode_id.equals("")))
		{
			episode_id = episode_id.substring(4);
		}
*/
	}
	catch(Exception eee)
	{
		out.println("<script>alert('"+eee+"');</script>");
	}

//	System.out.println("episode_id:"+episode_id);

	String enc_dtls_qry="select blng_grp_id,cust_code,NON_INS_BLNG_GRP_ID,NON_INS_CUST_CODE ,SETTLEMENT_IND	from bl_episode_fin_dtls	where operating_facility_id = '"+str_facility_id+"' and	episode_id = '"+episode_id+"'";

	pstmt = con.prepareStatement(enc_dtls_qry);
	rs = pstmt.executeQuery() ;
	if( rs != null ) 
	{
		while( rs.next() )
		{  
			str_blng_grp_id = rs.getString(1);
			if(str_blng_grp_id == null) str_blng_grp_id="";
			str_cust_code = rs.getString(2);
			if(str_cust_code == null) str_cust_code="";
			str_non_ins_blng_grp_id = rs.getString(3);
			if(str_non_ins_blng_grp_id == null) str_non_ins_blng_grp_id="";
			str_non_ins_cust_code = rs.getString(4);
			if(str_non_ins_cust_code == null) str_non_ins_cust_code="";
			str_settlement_ind = rs.getString(5);
			if(str_settlement_ind == null) str_settlement_ind="";
		}
	}
	if(rs != null ) rs.close();
	pstmt.close();	

//	System.out.println("str_blng_grp_id:"+str_blng_grp_id);
//	System.out.println("str_cust_code:"+str_cust_code);
//	System.out.println("str_non_ins_blng_grp_id:"+str_non_ins_blng_grp_id);
//	System.out.println("str_non_ins_cust_code:"+str_non_ins_cust_code);
//	System.out.println("str_settlement_ind:"+str_settlement_ind);

	/*
	out.println("<script>alert('"+fm_nur_code+"');</script>");
	out.println("<script>alert('"+to_nur_code+"');</script>");
	out.println("<script>alert('"+fm_bed_no+"');</script>");
	out.println("<script>alert('"+to_bed_no+"');</script>");
	out.println("<script>alert('"+fm_bed_class+"');</script>");
	out.println("<script>alert('"+to_bed_class+"');</script>");
	out.println("<script>alert('"+trans_code+"');</script>");
	out.println("<script>alert('"+encount_id+"');</script>");
	out.println("<script>alert('"+episode_id+"');</script>");
	out.println("<script>alert(parent.frames[1].document.forms[0].name);</script>");
	*/

	try 
	{
//		System.out.println("check 1");

//		cstmt = con.prepareCall("{call BL_CALCULATE_TRN_DEP_AMT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt = con.prepareCall("{call BL_IP_INTERFACE.BL_CALCULATE_TRN_DEP_AMT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, str_facility_id);
		cstmt.setString(2, episode_id); 
		cstmt.setString(3, fm_nur_code);
		cstmt.setString(4, to_nur_code);
		cstmt.setString(5, fm_bed_type);
		cstmt.setString(6, to_bed_type);
		cstmt.setString(7, fm_bed_class);
		cstmt.setString(8, to_bed_class);
		cstmt.setString(9, trans_code);
		cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);//FLOAT
		cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);//FLOAT
		cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
		cstmt.execute() ;
     	//
		
		bill_type_code = cstmt.getString(10);
		if(bill_type_code == null) bill_type_code="";
		blng_class_code = cstmt.getString(11);
		if(blng_class_code == null) blng_class_code="";
		addl_dep_yn = cstmt.getString(12);
		if(addl_dep_yn == null) addl_dep_yn="N";
		trn_dep_amt = cstmt.getString(13);
		if(trn_dep_amt == null) trn_dep_amt="0";
		charge_yn = cstmt.getString(14);
		if(charge_yn == null) charge_yn="N";
		perc_amt_ind=cstmt.getString(15);
		if(perc_amt_ind == null) perc_amt_ind="";
		transfer_serv_charge = cstmt.getString(16);
		if(transfer_serv_charge == null) transfer_serv_charge="0";
		serv_panel_ind = cstmt.getString(17);
		if(serv_panel_ind == null) serv_panel_ind="";
		blng_serv_code = cstmt.getString(18);
		if(blng_serv_code == null) blng_serv_code="";
		dly_serv_panel_ind = cstmt.getString(19);
		if(dly_serv_panel_ind == null) dly_serv_panel_ind="";
		dly_blng_serv_code = cstmt.getString(20);
		if(dly_blng_serv_code == null) dly_blng_serv_code="";
		sys_message_id = cstmt.getString(21);		
		if(sys_message_id == null) sys_message_id="";
		error_code = cstmt.getString(22);		
		if(error_code == null) error_code="";
		
		if(cstmt != null)cstmt.close();

		if (error_code.equals("") && sys_message_id.equals(""))
		{		
//			System.out.println("check 3");

			if(charge_yn.equals("Y"))
			{
//				System.out.println("check 4");
				cstmt = con.prepareCall("{call BL_IP_INTERFACE.proc_calculate_charge(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				cstmt.setString(1, "D");
				cstmt.setString(2, str_function_id);
				cstmt.setString(3, str_facility_id);
				cstmt.setString(4, str_module_id);
				cstmt.setString(5, to_nur_code);
				cstmt.setString(6, str_patient_id);
				cstmt.setString(7, str_episode_type);
				cstmt.setString(8, episode_id);
				cstmt.setString(9, str_physician_id);
				cstmt.setString(10, str_blng_grp_id);
				cstmt.setString(11, blng_class_code);
				cstmt.setString(12, serv_panel_ind);
				cstmt.setString(13, blng_serv_code);
				cstmt.setString(14, perc_amt_ind);
				cstmt.setString(15, transfer_serv_charge);
				cstmt.setString(16, bill_type_code);
				cstmt.setString(17, to_bed_class);
				cstmt.setString(18, str_cust_code);
				cstmt.setString(19, str_non_ins_blng_grp_id);
				cstmt.setString(20, str_non_ins_cust_code);
				cstmt.setString(21, str_user_id);
				cstmt.setString(22, str_ws_no);
				cstmt.registerOutParameter(23, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
				cstmt.execute() ;

				transfer_serv_charge = cstmt.getString(23);
				if(transfer_serv_charge == null) transfer_serv_charge="";
//				System.out.println("transfer_serv_charge:"+transfer_serv_charge);
				sys_message_id = cstmt.getString(24);		
				if(sys_message_id == null) sys_message_id="";
				error_code = cstmt.getString(25);		
				if(error_code == null) error_code="";
//				System.out.println("sys_message_id:"+sys_message_id);
//				System.out.println("error_code:"+error_code);

				if(cstmt != null)cstmt.close();
			}

			if (error_code.equals("") && sys_message_id.equals(""))
			{
				CurrencyFormat cf1 = new CurrencyFormat();
				trn_dep_amt = cf1.formatCurrency(trn_dep_amt, 2);
				transfer_serv_charge = cf1.formatCurrency(transfer_serv_charge, 2);

				if(charge_yn.equals("Y"))
				{
					out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.disabled=false;</script>");	out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.checked=true;</script>");
					out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.disabled=true;</script>");	
				}
				else
				{
					out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.disabled=false;</script>");		out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.checked=false;</script>");
					out.println("<script>parent.frames[1].document.forms[0].transfer_chargeable_yn.disabled=true;</script>");	
				}
				if(addl_dep_yn.equals("Y"))
				{
					out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.disabled=false;</script>");	out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.checked=true;</script>");
					out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.disabled=true;</script>");
				}
				else
				{
					out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.disabled=false;</script>");		out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.checked=false;</script>");
					out.println("<script>parent.frames[1].document.forms[0].surgery_reqd_yn.disabled=true;</script>");
				}
				out.println("<script>parent.frames[1].document.forms[0].transfer_serv_charge.value='"+transfer_serv_charge+"'</script>");
				out.println("<script>parent.frames[1].document.forms[0].addnl_dep_amt.value='"+trn_dep_amt+"'</script>"); 

				out.println("<script>parent.frames[1].document.forms[0].bill_type_code.value='"+bill_type_code+"'</script>"); 
				out.println("<script>parent.frames[1].document.forms[0].blng_class_code.value='"+blng_class_code+"'</script>"); 
				out.println("<script>parent.frames[1].document.forms[0].blng_serv_code.value='"+blng_serv_code+"'</script>"); 
			}
			else
			{
				if(!error_code.equals(""))
				{
					out.println("<script>alert('"+error_code+"');</script>");
				}
				if(!sys_message_id.equals(""))
				{
					out.println("<script>alert(getMessage('"+sys_message_id+"','BL'));</script>");
				}
			}
		}
		else
		{
/*			String chk_err_code=error_code.substring(0,2);
			System.out.println("chk_err_code after substring:"+chk_err_code);
			if(chk_err_code.equals("**"))
			{
				out.println("<script>alert("+error_code+");</script>");
			}
			else
			{
				out.println("<script>alert(getMessage('"+error_code+"','BL'));</script>");
			}
*/
			if(!error_code.equals(""))
			{
				out.println("<script>alert("+error_code+");</script>");
			}
			if(!sys_message_id.equals(""))
			{
				out.println("<script>alert(getMessage('"+sys_message_id+"','BL'));</script>");
			}
		}

	} // end of try
	
	catch(Exception e)
	{
		System.out.println("<script>alert('"+e+"');</script>");
		
	}
}
catch(Exception ee)
{
	//out.println("Error"+ee.toString();)
	String err_msg  = ee.toString();
	out.println("<script>alert('"+err_msg+"');</script>");
}
finally
{
	if(cstmt != null)cstmt.close();
	ConnectionManager.returnConnection(con, request);
}
%>

