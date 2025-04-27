<!DOCTYPE html>

<%@ page import="webbeans.eCommon.*,java.sql.*,blipin.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<!--
	<script src='../../eCommon/js/messages.js' language='Javascript'></script>
-->
<%
//The following changes are done for Internationalisation Process
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
String user = request.getParameter("user");
user=user.toUpperCase();
String pin = request.getParameter("pin");
String facilityId			=	(String)session.getValue("facility_id");
int userflag		=	0;
int pinflag			=	0;
Connection			con		=	null;
PreparedStatement	stmt	=	null;
ResultSet			rs		=	null;
PreparedStatement	stmt1	=	null;
ResultSet			rs1		=	null;
//con							=	ConnectionManager.getConnection(request);
String				sql		=   "select count(*) from bl_users_for_hosp_req_tfr where operating_facility_id = '"+facilityId+"' and auth_user_id = '"+user+"'";
try
{
		
		// Added con inside the try in Bangalore on 13/10/2005

		con							=	ConnectionManager.getConnection(request);

		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			userflag = rs.getInt(1);
		}

		if (rs != null)   rs.close();
		if (stmt != null)   stmt.close();

		if(userflag == 1)
		{
			String sql1 = "select nvl(app_password.decrypt(pin_no),'~!@') pass_wd from sm_appl_user where appl_user_id='"+user+"'";
			stmt1 = con.prepareStatement(sql1);
			rs1 = stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					String rpin = rs1.getString(1);
					rpin = rpin.trim();
					if(rpin.equalsIgnoreCase(pin))
						pinflag = 1;
				}
			}
			if (rs1 != null)   rs1.close();
			if (stmt1 != null)   stmt1.close();
		}
		else
		{
//			out.println("<script>alert(\"Invalid User\");</script>");
			out.println("<script>alert(getMessage('BL2095','BL'));</script>");
		}
		if(userflag==1 && pinflag==0)
//			out.println("<script>alert(\"Invalid Pin No\");</script>");
			out.println("<script>alert(getMessage('BL1232','BL'));</script>");
		
		if(userflag==1 && pinflag==1)
			out.println("<script>window.returnValue='1';parent.window.close();</script>");
}catch(Exception ee)
{
	System.out.println("Exception :"+ee.getMessage());
}

finally
{	// Added in Bangalore on 13/10/2005
	if (con != null)
    {
		ConnectionManager.returnConnection(con,request);
	}
}

%>

