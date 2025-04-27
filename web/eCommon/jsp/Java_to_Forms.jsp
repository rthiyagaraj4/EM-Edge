<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, ,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<script>
function goHomePage()
{
	if (document.forms[0].report_server_3f.value=='N'){
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	}else{
		window.open(document.forms[0].appl_url_3tf.value,'eHIS','location=0,height=700,width=1050,top=0,left=0,resizable=yes');
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	}
}

function closePage()
{
	parent.window.close();
}
</script>
<%
Connection con=null ;
Statement stmt=null;
ResultSet rs=null;
con = ConnectionManager.getConnection(request);

Properties properties		= (Properties) session.getValue( "jdbc" );
String user_id				= (String) session.getAttribute( "login_user" ) ;
String 	user_password		= "";
String 	patient_id			= "";
String 	encounter_id		= "";
String 	function_id			= "";
String 	form_id				= "";
String 	call_func			= "";
String database_name		= "";
String new_url	="";
String report_server_3f = "N";
String appl_url_3tf="";

	patient_id=request.getParameter("patient_id");
	if (patient_id==null) patient_id = "";
	encounter_id=request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id = "";
	function_id=request.getParameter("function_id");
	if (function_id==null) function_id = "";
	call_func=request.getParameter("call_func");
	if (call_func==null) call_func = "";
 String build_form_string		= "";
try{
	stmt = con.createStatement();
	String query="select app_password.decrypt(appl_user_password) from sm_appl_user where appl_user_id ='"+user_id+"'";
	rs = stmt.executeQuery(query);
	while(rs.next())
	{
		user_password=rs.getString(1);
	}
	if(rs!=null) rs.close();

	String query1="select function_parameters from sm_function where function_id ='"+function_id+"'";
	rs = stmt.executeQuery(query1);
	while(rs.next())
	{
		form_id=rs.getString("function_parameters");
		if (form_id==null) form_id = "";
	}
	if(rs!=null) rs.close();	

	
	String query2="select report_connect_string ,NVL(REPORT_SERVER_3F,'N') REPORT_SERVER_3F from sm_Db_info";
	rs = stmt.executeQuery(query2);
	while(rs.next())
	{
		database_name=rs.getString(1);
		if (database_name==null) database_name = "";

		report_server_3f=rs.getString("REPORT_SERVER_3F");
		if (report_server_3f==null) report_server_3f = "N";
	}
	
	if(rs!=null) rs.close();

		// Query and take the database user_id and password

String facility_id			= (String)session.getValue("facility_id");
String ws_no				= properties.getProperty( "client_ip_address");
String responsibility_id	= (String)session.getValue("responsibility_id");
/*String jdbc_dns				= properties.getProperty( "ecis_jdbc_dns" );
	if(jdbc_dns!=null)
	database_name		= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());*/


//String user_details				= (user_id)+"/"+(user_password)+"@"+(database_name);

	//{  //Open the Forms window.

	if(report_server_3f.equals("N")){
		if ( function_id.equals("BL_IP_TR_CS_RCPTREF_ENT_J")) {

 			 build_form_string = "IFRUN60.exe "+form_id+" P_USER_ID="+user_id+" P_PWD="+user_password+" P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+" P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID="+function_id+" P_invoke=IBAEHIS P_PATIENT_ID="+patient_id+" P_RECPT_NATURE_CODE=AD P_EPISODE_ID="+encounter_id+" P_EPISODE_TYPE=I";
	//	} // End of !error_message
	}
	else if ( function_id.equals("INVOKE_FORMS_NAVIG"))
	{
		build_form_string = "IFRUN60.exe "+form_id+" P_USERID='"+user_id+"' P_PASSWORD='"+user_password+"' P_DOMAIN='"+database_name+"'";

		}
		else
		{
			 build_form_string = "IFRUN60.exe "+form_id+" P_USER_ID="+user_id+" P_PWD="+user_password+" P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+" P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID="+function_id+" P_invoke=IBAEHIS ";	
		}
	}else{
		query2="select APPL_URL_3TF from SM_FACILITY_PARAM where FACILITY_ID='"+facility_id+"'";

		rs = stmt.executeQuery(query2);
		while(rs.next())
		{
			appl_url_3tf=rs.getString("APPL_URL_3TF");
			if (appl_url_3tf==null) appl_url_3tf = "";
			
		}
		
		
		user_id=user_id+"@"+database_name;

		build_form_string="&form="+form_id+"&otherparams=+P_USER_ID="+user_id+"+P_LANGUAGE_ID="+locale+"+P_FACILITY_ID="+facility_id+"+P_WS_NO="+ws_no+"+P_RESP_ID="+responsibility_id+"+P_ACCESS_RIGHTS=YYYNN+P_FUNCTION_ID="+function_id+"+P_RGQUERY=IBAEHIS ";

		appl_url_3tf=appl_url_3tf+build_form_string;
		build_form_string="";
		
		if(rs!=null) rs.close();	

			//new_url="http://cscappche644:9005/forms/frmservlet?config=TEST_DUMMY&form=SMAFMRAD&otherparams=P_RESP_ID=SM_MANAGER+P_USER_ID=NAREN+P_PWD=NAREN+P_HOSTSTRING=SRDV+P_FACILITY_ID=HS+p_language_id=en+P_ACCESS_RIGHTS=YYYNN+P_WS_NO=INDCHN-NB409+P_INVOKE=iba+P_FUNCTION_ID=SM_ADMIN_FAX_MAIL";


	}

	
	if(stmt!=null) stmt.close();

}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();	
}
 finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
	%>

<BODY onKeyDown = 'lockKey()'>
</BODY>
<form name="dumy" id="dumy">
<input type="hidden" name="report_server_3f" id="report_server_3f" value='<%=report_server_3f%>'>
<input type="hidden" name="appl_url_3tf" id="appl_url_3tf" value='<%=appl_url_3tf%>'>

</form>
</HTML>
<script language="VBScript">
		Dim WSHShell
		Set WSHShell = CreateObject("WScript.Shell")
		WSHShell.Run "<%=build_form_string%>"		
</script> 
<script>

</script>
<%
if (!call_func.equals("ADMIT"))
{%>
	<script >
	goHomePage();
	</script>
<%
}else{
%>
	<script >
	closePage();
	</script>
<%
}
%>

