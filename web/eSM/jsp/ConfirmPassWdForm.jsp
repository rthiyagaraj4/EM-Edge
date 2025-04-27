<!DOCTYPE html>

<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head><%
	Connection con = null;
	PreparedStatement stmt		 = null;
	//Statement stmt=null;
	ResultSet rs=null;
	String err_msg="";
	String usr_id="",pass_wd="", resp_id="", func_id="", a="", b="";//Modified by Ajay for MMS-DM-CRF-0209.4
	String valid_user_rec_found_YN = "NULL";
	//String temp_pwd = "";
	int check = 0;	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		usr_id	= 	request.getParameter("usr_id");
		pass_wd	= 	request.getParameter("pass_wd");	
		resp_id	= 	request.getParameter("resp_id");
		func_id	= 	request.getParameter("func_id");
		
%>
<script>
	function call_pass_valid()
	{ 
	<%
	//Modified by Ajay H. for MMS-DM-CRF-0209.4
	if(func_id.equals("PROCESS_REF")){
		String	query_usr_id = "select count(1) from sm_appl_user A where A.appl_user_id = ? and lower(APP_PASSWORD.DECRYPT(A.PIN_NO)) = lower(?) and A.EFF_STATUS = 'E'";
	stmt = con.prepareStatement(query_usr_id);	
	try{ 
	stmt.setString(1,usr_id);
	stmt.setString(2,pass_wd);
	rs = stmt.executeQuery();	
	if(rs.next())
	{
		check =rs.getInt(1);
		if(check>0)
		{
			valid_user_rec_found_YN="Y";

		}
		else
		{
			valid_user_rec_found_YN="N";
		}
	}
	else
	{
		valid_user_rec_found_YN="N";
	}
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception occurred in ConfirmPassWdForm.jsp : "+e);	
	}
	}else{
	
	String	query_usr_id = "select count(1) from sm_appl_user A inner join mr_user_access_rights B on A.APPL_USER_ID = B.APPL_USER_ID where A.appl_user_id = ? and B.ENABLE_EMIRATES_ID_YN = 'Y' and lower(APP_PASSWORD.DECRYPT(A.PIN_NO)) = lower(?)";
	stmt = con.prepareStatement(query_usr_id);	
	try{ 
	stmt.setString(1,usr_id);
	stmt.setString(2,pass_wd);
	rs = stmt.executeQuery();	
	if(rs.next())
	{
		check =rs.getInt(1);
		if(check>0)
		{
			valid_user_rec_found_YN="Y";		
		}
		else
		{
			valid_user_rec_found_YN="N";
		}
	}
	else
	{
		valid_user_rec_found_YN="N";
	}
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception occurred in ConfirmPassWdForm.jsp : "+e);	
	}
	}
%>
	var pin_check = "<%=valid_user_rec_found_YN%>";	
	var returnArray=false;	
	if(pin_check =='Y')
	{
		returnArray = true;
		parent.window.returnValue=returnArray;
		parent.window.close();
	}
	else
		{
		alert(getMessage('INVALID_USER_PIN','SM')); 
		parent.window.returnValue=returnArray;
		}
	}
</script>
<body onLoad="call_pass_valid();">
<form>	
	<input type='hidden' name='user' id='user' value="<%=usr_id%>">
	<input type='hidden' name='err_msg' id='err_msg' value="<%=err_msg%>">
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (rs != null)   rs.close();
		if(stmt!=null)	stmt.close();	
		ConnectionManager.returnConnection(con, request);
	}
%>

