<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217             14612          MMS-DM-CRF-0100.1               Shikha Seth
2            V210218             14630          MMS-DM-CRF-0100.1               Shikha Seth
3            V210222             14742          MMS-DM-CRF-0100.1               Shikha Seth
4  		     V220323	    	 27763			MMS-ME-SCF-0052 				Mohana Priya K
 -->
<%@ page    import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PolicyDefinition.js"></script>
	<script language="javascript" src="../js/BillingInterimBillScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con = null;
	//V210217 start
	Statement stmt=null;
	Statement stmt1=null;
	Statement stmt2 = null;
	ResultSet rs=null;
	//V210217 end
	ResultSet rs1=null;
	String usr_id="";
	String functionID = "";
	String previlage = "";
	String valid_eligible_user=""; //V210222
	String valid_user_rec_found_YN="N";
	String pass_wd="";
	String remarks="";
	String err_msg="";
	String Reason_code="";
	String pass_word = "";
	String query_usr_id ="";
	String query_pass_wd="";
	String facility_id  =  (String) session.getValue("facility_id") ;
try
{
	con	=	ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");
	usr_id	= 	request.getParameter("usr_id");
	pass_wd	= 	request.getParameter("pass_wd");
	Reason_code=request.getParameter("Reason_code");
	functionID	= 	"INTERIM_BILL_AUTH";
	previlage	= 	"BILL_AUTHORIZATION";
	if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
	if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();
	
%>
	<body onLoad="return call_pass_valid();">
	<form id="BLUserRightsPasswrdCheck" name="BLUserRightsPasswrdCheck" id="BLUserRightsPasswrdCheck">
	<%		//V210217 start	
		stmt = con.createStatement();
		stmt1 = con.createStatement();
		stmt2 = con.createStatement();		
		String responsibility_id=(String)session.getAttribute("responsibility_id");		
		String p_privilege_val="";
		String p_allowed_yn="";
	
		query_usr_id ="select EFF_STATUS from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= '"+usr_id+"' and facility_id = '"+facility_id+"' "; //V210218	
	
		query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id='"+usr_id+"' ";
	
		rs = stmt1.executeQuery(query_usr_id);
		if(rs.next())
		{
			valid_eligible_user = rs.getString(1);  //V210222
			System.err.println("103, valid_eligible_user==>"+valid_eligible_user);
			rs1 = stmt2.executeQuery(query_pass_wd);
			while((rs1.next()))
			{
				pass_word = rs1.getString("pass_wd");
			}
			pass_word=pass_word.trim();			
		}
		else
		{
			valid_eligible_user="N"; //V210222
		}
			//V210217 end
	try
		{
			if (valid_eligible_user.equals("E")) { 	//V210217  //V210222
				CallableStatement cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
				cstmt1.setString(1, facility_id);			
				cstmt1.setString(2, usr_id);			
				cstmt1.setString(3, responsibility_id);			
				cstmt1.setString(4, functionID);			
				cstmt1.setString(5, previlage);	
				cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
				cstmt1.execute();	
				p_privilege_val = cstmt1.getString(6);
				p_allowed_yn = cstmt1.getString(7);
				System.err.println("102, p_privilege_val==>"+p_privilege_val);
				System.err.println("103, p_allowed_yn==>"+p_allowed_yn);
				if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
				{
					valid_user_rec_found_YN = "Y";
				}
				else
				{			
					valid_user_rec_found_YN="N";
				}
			} 	//V210217 
			System.err.println("99, valid_user_rec_found_YN==>"+valid_user_rec_found_YN);
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			
		//V220323 Starts
		System.err.println("124,valid_eligible_user-"+valid_eligible_user);
		if(valid_eligible_user.equals("D"))	
			{
				err_msg="BL1025";
				
			}
		else if(valid_eligible_user.equals("N"))	
			{
				err_msg="BL9539";
			}
		if(valid_user_rec_found_YN.equals("N"))
		{
			err_msg="BL9539";
		}
		else if(!(pass_word.toUpperCase()).equals(pass_wd.toUpperCase()))
			{
				err_msg="BL1232";
			}
			//V220323 ends
	%>
	<input type='hidden' name='user' id='user' value="<%=usr_id%>">
	<input type='hidden' name='err_msg' id='err_msg' value="<%=err_msg%>">
	<input type='hidden' name='Reason_code' id='Reason_code' value="<%=Reason_code%>">
	<input type='hidden' name='valid_user_rec_found_YN' id='valid_user_rec_found_YN' value="<%=valid_user_rec_found_YN%>">
	<input type='hidden' name='valid_eligible_user' id='valid_eligible_user' value="<%=valid_eligible_user%>">	
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		out.println("Exception BLUserRightsPasswrdCheck.jsp : "+e);
		e.printStackTrace();
	}
	finally
	{
		//if (rs != null)   rs.close();
		if (rs1 != null)   rs1.close();
		//if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

