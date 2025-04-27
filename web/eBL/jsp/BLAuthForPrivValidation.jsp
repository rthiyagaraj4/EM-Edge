<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection con = null;
	CallableStatement cstmt =null;
	PreparedStatement stmt=null;
	ResultSet rs1=null;
	String usr_id="",pass_wd="",remarks="",valid_user_rec_found_YN="N",pass_word="";	
	String  query_elgb_user="", valid_eligible_user="";		
	String priv_code = "";
	String  p_privilege_val="";
	String  p_allowed_yn="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		usr_id	= 	(String) hash.get( "usr_id");
		pass_wd	= 	(String) hash.get( "pass_wd");
 		priv_code	= 	(String) hash.get( "priv_code");
		
		if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
		if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();		
		if(priv_code==null)priv_code="";
		priv_code=priv_code.trim();
		
		String functionID = request.getParameter("functionID");
		if(functionID==null) functionID="";
		
		String prespid = request.getParameter("prespid");
		if(prespid==null) prespid="";
		
		String payer_group = request.getParameter("payer_group");
		if(payer_group==null) payer_group="";
		
		String payer = request.getParameter("payer");
		if(payer==null) payer="";
		
		String policy = request.getParameter("policy");
		if(policy==null) policy="";
		
		String currentdate = request.getParameter("currentdate");
		if(currentdate==null) currentdate="";
		
		
		try{
			cstmt = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, usr_id);
			cstmt.setString(3, prespid);
			cstmt.setString(4, functionID);
			cstmt.setString(5, payer_group);
			cstmt.setString(6, payer);
			cstmt.setString(7, policy);
			cstmt.setString(8, priv_code);
			cstmt.setString(9, currentdate);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.execute();	
			p_privilege_val = cstmt.getString(10);
			p_allowed_yn = cstmt.getString(11);
			System.err.println("password check in BLAuthForPrivValidation.jsp"+p_privilege_val+"::"+p_allowed_yn);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}		
			
			
		String query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id='"+usr_id+"' ";
		System.err.println("	query_pass_wd:"+query_pass_wd);
		
		//Added V190828-Gomathi/GHL-SCF-1436 Starts
		query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= '"+usr_id+"' and facility_id = '"+facility_id+"' ";
		System.err.println("	query_elgb_user:"+query_elgb_user);
		
		
		stmt = con.prepareStatement(query_elgb_user);	
		rs1 = stmt.executeQuery();
		while(rs1!=null && rs1.next())
		{	
			valid_eligible_user = rs1.getString(1);
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Ends

		if(p_privilege_val.equals("Y") &&  p_allowed_yn.equals("Y"))
		{
			valid_user_rec_found_YN = "Y";
			stmt = con.prepareStatement(query_pass_wd);
			rs1 = stmt.executeQuery();
			while((rs1.next()))
			{
				pass_word = rs1.getString("pass_wd");
			}
			pass_word=pass_word.trim();
		}
		else
		{
			valid_user_rec_found_YN="N";
		}
		
		
		pass_word=pass_word.toUpperCase();
		pass_wd=pass_wd.toUpperCase();
		
		if(valid_eligible_user.equals("E")){
			if(valid_user_rec_found_YN.equals("Y"))
			{
				if(pass_word.equals(pass_wd)){			
					out.println("Y:::"+valid_eligible_user);	//valid user					
				}
				else{
					out.println("P:::"+valid_eligible_user);	//Invalid pin						
				}
			}
			else{
					out.println("A:::"+valid_eligible_user);	//Invalid priv		
				}
		}else{
			out.println("U:::"+valid_eligible_user);	//Invalid user	
		}
			
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if (rs1 != null)   rs1.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
