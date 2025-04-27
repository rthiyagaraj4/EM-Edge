<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 		 Developer Name
--------------------------------------------------------------------------------------------------------
1		    V220323	    		27763			  MMS-ME-SCF-0052 					   Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/
%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src='../js/PkgDef.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>

<%
Connection con = null;
ResultSet rs=null;
ResultSet rs1=null;
String usr_id="";
String valid_user_rec_found_YN="N";
String pass_wd="";
String remarks="";
String pass_word = "";
String err_val="";//V220323
String query_usr_id ="";
String query_pass_wd="";
String query_elgb_user="", valid_eligible_user="";	
PreparedStatement pstmt = null;
try
{
	con	=	ConnectionManager.getConnection(request);
	String facility_id  =  (String) session.getValue("facility_id") ;
	request.setCharacterEncoding("UTF-8");
	usr_id	= 	request.getParameter("usr_id");
	pass_wd	= 	request.getParameter("pass_wd");
	remarks	= 	request.getParameter("remarks");
	if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
	if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();
	if(remarks==null)remarks="";
		remarks=remarks.trim();
%>
	<body onLoad="call_pass_valid();">
	<form>
	<%
		query_usr_id ="Select 'X' from bl_users_for_credit_auth where operating_facility_id = ? and ((nvl(package_definition_change_yn,'N')='Y') or (nvl(credit_auth_yn,'N')='Y' )) and credit_auth_user_id=?";
	
		query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id=? ";
		
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(query_usr_id);
		pstmt.setString(1, facility_id);
		pstmt.setString(2, usr_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			valid_user_rec_found_YN = "Y";
			pstmt = con.prepareStatement(query_pass_wd);
			pstmt.setString(1, usr_id);
			rs1 = pstmt.executeQuery();
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
		//Added V190828-Gomathi/GHL-SCF-1436 Starts
		query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= ? and facility_id = ? ";
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(query_elgb_user);
		pstmt.setString(1, usr_id);
		pstmt.setString(2, facility_id);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next())
		{	
			valid_eligible_user = rs1.getString(1);
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Ends
		
		//V220323 Starts
		System.err.println("124,valid_eligible_user-"+valid_eligible_user);
		if(valid_eligible_user.equals("D"))	
			{
				err_val="BL1025";
				
			}
		
		if(valid_user_rec_found_YN.equals("N"))
		{
			err_val="BL9539";
		}
		else if(!(pass_word.toUpperCase()).equals(pass_wd.toUpperCase()))
			{
				err_val="BL1232";
			}
			//V220323 ends
	%>
	<input type='hidden' name='user' id='user' value="<%=usr_id%>">
	<input type='hidden' name='err_msg' id='err_msg' value="<%=err_val%>">
	<input type='hidden' name='remarks' id='remarks' value="<%=remarks%>">
	<input type='hidden' name='valid_user_rec_found_YN' id='valid_user_rec_found_YN' value="<%=valid_user_rec_found_YN%>">
	<input type='hidden' name='valid_eligible_user' id='valid_eligible_user' value="<%=valid_eligible_user%>">
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception PkgDefConfirmPassWd : "+e);
	}
	finally
	{
		if (rs != null)   rs.close();
		if (rs1 != null)   rs1.close();
		if(pstmt!=null)	pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

