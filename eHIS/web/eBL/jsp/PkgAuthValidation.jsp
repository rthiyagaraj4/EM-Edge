<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection con = null;
	CallableStatement call =null;
	Statement stmt=null;
	ResultSet rs=null;
	Statement stmt1=null;
	ResultSet rs1=null;
	String usr_id="",pass_wd="",remarks="",valid_user_rec_found_YN="N",pass_word="";	
	String  query_elgb_user="", valid_eligible_user="";		
	String priv_code = "";
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		usr_id	= 	(String) hash.get( "usr_id");
		pass_wd	= 	(String) hash.get( "pass_wd");
 		remarks	= 	(String) hash.get( "rmks");
		priv_code	= 	(String) hash.get( "priv_code");
		
		String calenderPrivileageYN = "N", modifyPractPrivYN = "N", assDeassEncPrivYN = "N", pkgServLmtDtlsPrivYN = "N", adhocDiscPrivYN = "N", cancelPkgPrivYN = "N", usrPrivListForManagePatPack = "";
		String function_id = "EBL_TRAN_PACKAGE_MAINTAIN";

		if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
		if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();		
		if(remarks==null)remarks="";
		remarks=remarks.trim();
		if(priv_code==null)priv_code="";
		priv_code=priv_code.trim();
		stmt = con.createStatement();
		stmt1 = con.createStatement();
	
		String query_usr_id = "select NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + usr_id
			+ "' and function_id = 'EBL_TRAN_PACKAGE_MAINTAIN' and privlege_code = '" +priv_code+ "' and OPERATING_FACILITY_ID = '" + facility_id+ "' and sysdate <= NVL(eff_to_date,sysdate)";
		System.err.println("	query_usr_id:"+query_usr_id);			
		
		String query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id='"+usr_id+"' ";
		System.err.println("	query_pass_wd:"+query_pass_wd);
		
		//Added V190828-Gomathi/GHL-SCF-1436 Starts
		query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= '"+usr_id+"' and facility_id = '"+facility_id+"' ";
		System.err.println("	query_elgb_user:"+query_elgb_user);
		
		rs1 = stmt1.executeQuery(query_elgb_user);
		while(rs1!=null && rs1.next())
		{	
			valid_eligible_user = rs1.getString(1);
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Ends

		rs = stmt.executeQuery(query_usr_id);
		if(rs.next() && "Y".equals(rs.getString(1)))
		{
			valid_user_rec_found_YN = "Y";

			rs1 = stmt1.executeQuery(query_pass_wd);
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
		
		try 
		{
			String sql = "select privlege_code, NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + usr_id
					+ "' and function_id = '" + function_id + "' and sysdate <= NVL(eff_to_date,sysdate) ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if("MODIFY_EFF_FROM_MTPKG".equals(rs.getString(1)))
					calenderPrivileageYN = rs.getString(2);
				else if("MODIFY_PRAC_NAME_MTPKG".equals(rs.getString(1)))
					modifyPractPrivYN = rs.getString(2);
				else if("MODIFY_ASSOC_DEASSOC_MTPKG".equals(rs.getString(1)))
					assDeassEncPrivYN = rs.getString(2);
				else if("MODIFY_PKG_SERV_LMT_DTLS_MTPKG".equals(rs.getString(1)))
					pkgServLmtDtlsPrivYN = rs.getString(2);	
				else if("ALLOW_ADHOC_DISC_ENTRY_MTPKG".equals(rs.getString(1)))
					adhocDiscPrivYN = rs.getString(2);	
				else if("ALLOW_CANCEL_PACKAGE_MTPKG".equals(rs.getString(1)))
					cancelPkgPrivYN = rs.getString(2);						
			}
		} catch (Exception e) {
			System.err.println(e);
		}			
		
		usrPrivListForManagePatPack = calenderPrivileageYN+"/"+modifyPractPrivYN+"/"+assDeassEncPrivYN+"/"+adhocDiscPrivYN+"/"+cancelPkgPrivYN+"/"+pkgServLmtDtlsPrivYN+"/";		
	
		pass_word=pass_word.toUpperCase();
		pass_wd=pass_wd.toUpperCase();
		if(valid_user_rec_found_YN.equals("Y"))
		{
			if(pass_word.equals(pass_wd)){			
				out.println("Y:::"+valid_eligible_user+":::"+usrPrivListForManagePatPack);	//Added eff_status					
			}
			else{
				out.println("P:::"+valid_eligible_user+":::"+usrPrivListForManagePatPack);	//Added eff_status						
			}
		}
		else{
				out.println("U:::"+valid_eligible_user+":::"+usrPrivListForManagePatPack);	//Added eff_status		
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if (rs != null)   rs.close();
		if (rs1 != null)   rs1.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
