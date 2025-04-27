<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	ResultSet rscurr = null;	

	try
	{
//		System.err.println("Values in BLEnterReceiptRefundValidation.jsp:"+request.getQueryString());
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int noofdecimal=2;
		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.err.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	

		String rcpt_nat_code = request.getParameter("rcpt_nat_code");	
		if(rcpt_nat_code==null) rcpt_nat_code="";	

		String rcpt_type_code = request.getParameter("rcpt_type_code");	
		if(rcpt_type_code==null) rcpt_type_code="";	

		String ext_acc_interface_yn="", str_ext_acc_facility_id = "";
		String str_ext_account_code	= "", str_ext_dept_ind = "", str_ext_dept_code = "", str_ext_dept_desc="";
		String str_reln_code		= "";

		String str_error_level = "", str_sys_message_id="", str_error_text = "";

		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{	
			noofdecimal  =  rscurr.getInt(1);
		}	
		if(rscurr != null) rscurr.close();
		pstmt.close();

		try
		{
			String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+facilityid+"'";

			stmt=con.createStatement();
			rs=stmt.executeQuery(query_ext_acc);
			if(rs != null)
			{
				while(rs.next())
				{
					ext_acc_interface_yn =rs.getString("ext_acc_interface");
//					System.err.println("ext_acc_interface_yn :"+ext_acc_interface_yn);
				}
			}
			if (rs != null)   rs.close();
			if (stmt != null) stmt.close();	
		}
		catch(Exception e )
		{
			out.println(e);
		} 

		try
		{
			CallableStatement call = 
			con.prepareCall("{ call blopin.proc_ext_acc_dtls_for_adm_dep (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,facilityid);
			call.setString(2,patient_id);
			call.setString(3,rcpt_nat_code);
			call.setString(4,rcpt_type_code);
			call.setString(5,episode_type);
			call.setString(6,episode_id);
			call.setString(7,visit_id);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);	
			call.registerOutParameter(9,java.sql.Types.VARCHAR);	
			call.registerOutParameter(10,java.sql.Types.VARCHAR);	
			call.registerOutParameter(11,java.sql.Types.VARCHAR);	
			call.registerOutParameter(12,java.sql.Types.VARCHAR);	
			call.registerOutParameter(13,java.sql.Types.VARCHAR);	
			call.registerOutParameter(14,java.sql.Types.VARCHAR);	
			call.registerOutParameter(15,java.sql.Types.VARCHAR);	
			
			call.execute();									

			str_ext_acc_facility_id  	 = call.getString(8);	
			str_ext_account_code	 = call.getString(9);	
//			System.err.println("In validation Page str_ext_account_code:"+str_ext_account_code);
			str_ext_dept_ind		 = call.getString(10);	
//			System.err.println("In validation Page str_ext_dept_ind:"+str_ext_dept_ind);
			str_ext_dept_code     	 = call.getString(11);	
//			System.err.println("In validation Page str_ext_dept_code:"+str_ext_dept_code);
			str_reln_code		= call.getString(12);	
//			System.err.println("In validation Page str_reln_code:"+str_reln_code);			
			str_error_level		= call.getString(13);	
			str_sys_message_id	= call.getString(14);	
			str_error_text		= call.getString(15);	

			call.close();
	
			if (str_ext_acc_facility_id == null) str_ext_acc_facility_id = "";
			if (str_ext_account_code == null) str_ext_account_code = "";
			if (str_ext_dept_ind == null) str_ext_dept_ind = "";
			if (str_ext_dept_code == null) str_ext_dept_code = "";
			if (str_reln_code == null) str_reln_code = "";
			if (str_error_level == null) str_error_level = "";
			if (str_sys_message_id == null) str_sys_message_id = "";
			if (str_error_text == null) str_error_text = "";

			if((str_error_level.equals("10") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
			{
				if(str_error_level.equals("10") && !str_error_text.equals(""))
				{
					out.println("E"+"&^&"+str_error_text);
				}
				else if(!str_sys_message_id.equals(""))
				{
					out.println("M"+"&^&"+str_sys_message_id);
				}
			}
			else
			{
				if(str_ext_dept_ind.equals("S"))
				{
					try
					{
						String query_ext_acc="select short_desc from sy_dept_LANG_VW where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and operating_facility_id = '"+facilityid+"' and dept_code ='"+str_ext_dept_code+"'";

						stmt=con.createStatement();
						rs=stmt.executeQuery(query_ext_acc);
						if(rs != null)
						{
							while(rs.next())
							{
								str_ext_dept_desc =rs.getString(1);
//								System.err.println("str_ext_dept_desc :"+str_ext_dept_desc);
							}
						}
						if (rs != null)   rs.close();
						if (stmt != null) stmt.close();	
					}
					catch(Exception e )
					{
						out.println(e);
					}
				}
				out.println("Y"+"&^&"+str_ext_acc_facility_id+"&^&"+str_ext_account_code+"&^&"+str_ext_dept_ind+"&^&"+str_ext_dept_code+"&^&"+str_ext_dept_desc);
			}

		}
		catch(Exception e )
		{
			//System.err.println("Exception while calling proc_ext_acc_dtls_for_adm_dep:"+e);
			//out.println(e);
			e.printStackTrace();
		}
	}
	catch(Exception e )
	{ 
		System.err.println("BLEnterServiceSerachResult:"+e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 
