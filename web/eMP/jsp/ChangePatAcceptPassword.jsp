<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	//Added for this CRF HSA-CRF-0222 [IN:050567]
	String title=checkForNull(request.getParameter("tit")); 
	String received_witnessid=checkForNull(request.getParameter("received_witnessid"));
	String received_pract_name=checkForNull(request.getParameter("received_pract_name"));
	//End CRF HSA-CRF-0222 [IN:050567]
%>
<html>
<head>
<title><%if(!title.equals("")){out.println(title);}else{%><fmt:message key="eMP.EnterPassword.label" bundle="${mp_labels}"/><%}%></title>  
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Properties p;
p = (java.util.Properties) session.getValue( "jdbc" ) ;
String UserId = p.getProperty( "login_user" ) ;

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
String active_dir_id = (String)session.getAttribute("active_dir_id")==null?"":(String)session.getAttribute("active_dir_id");
active_dir_id = java.net.URLEncoder.encode(active_dir_id,"UTF-8");

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
<script src='../../eXH/js/ExternalApplication.js' language="javascript"></script>
<script src="../../eCommon/js/jquery-3.6.3.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript">
function validate()
{
	var db_password = document.getElementById("db_password").value;
	var password = document.getElementById("password").value;

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var active_dir_id = document.getElementById("active_dir_id").value;
	active_dir_id = decodeURIComponent(active_dir_id);

	if(active_dir_id != ""){

			retValApi = callSingleSignOnAuth('AUTH',active_dir_id,password);

			retValApi = retValApi.split("$!^");

			retValApi = trimString(retValApi[0]);

			if(retValApi != "Success"){
				alert("APP-SM0164 "+retValApi);
				document.getElementById('password').value="";
				document.getElementById('password').focus();
			}else{
				window.returnValue=true;
				window.close();
				/* let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = true;
					
				const dialogTag = parent.parent.document.getElementById	("dialog_tag");    
				dialogTag.close(); */
			}
	}else{

		if(db_password == password)
		{
			window.returnValue=true;
			window.close();
			/* let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = true;
				
			const dialogTag = parent.document.getElementById("dialog_tag");    
			dialogTag.close(); */
		}
		else
		{
			var msg = getMessage('INVALID_VALUE','common');
			msg = msg.replace('#',getLabel('Common.password.label','common'));
			alert(msg);
			document.getElementById('password').value="";
			document.getElementById('password').focus();
		}
	}
}

function cancel1()
{
	window.close();
	/* const dialogTag = parent.parent.document.getElementById	("dialog_tag");    
    dialogTag.close();  */
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<%
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
	String CASE_SENSITIVE_PASSWORD_YN="";//Maheshwaran added for the MMS-QH-CRF-0149
try{
	conn = ConnectionManager.getConnection(request);
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		String sql3="select CASE_SENSITIVE_PASSWORD_YN from sm_site_param";
		pstmt = conn.prepareStatement(sql3);
		rset = pstmt.executeQuery();
		if(rset.next())
			{
			CASE_SENSITIVE_PASSWORD_YN=rset.getString("CASE_SENSITIVE_PASSWORD_YN");
			}
		if(pstmt!=null)pstmt.close();	
		if(rset!=null)rset.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	//Below query modified for this CRF HSA-CRF-0222 [IN:050567]	
	StringBuffer sbQuery = new StringBuffer("select app_password.decrypt(APPL_USER_PASSWORD) as password from sm_appl_user where appl_user_id='");
	if(!received_witnessid.equals(""))
	sbQuery.append(received_witnessid);
	else
	sbQuery.append(UserId);
	sbQuery.append("'");
	pstmt = conn.prepareStatement(sbQuery.toString());

	String password = "" ;

	rset = pstmt.executeQuery();
	try
	{
	rset.next();
	if ( rset != null ) 
	{
		password = rset.getString( "password" ) ;
		//Maheshwaran added for the MMS-QH-CRF-0149
		if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))
		{
		password=password.toUpperCase();
		}
	}
	}
	catch(Exception e)
		{
		System.err.println(e.toString());
		}
%>
<form method=post action="" name='accept_password' id='accept_password' action="../../eMP/jsp/ChangePatAcceptPassword.jsp" target="messageFrame" method="post">
<table border='0' cellpadding='3' cellspacing='0' width="100%">
<!--Added for this CRF HSA-CRF-0222 [IN:050567]-->
<%if(!received_witnessid.equals("")){%>
<tr>
<td class='label' width="20%"><%=title%></td>
<td class='label' width="80%"><%=received_pract_name%></td>
</tr>
<%}%>
<tr>
	<td class='label' width="20%"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<!--<td class='fields'><input type="password" onBlur="ChangeUpperCase(this);" onkeypress='JavaScrip:if(event.keyCode==13)return false;' name="password" id="password"></td>-->
	<!--//Maheshwaran modified for the MMS-QH-CRF-0149-->
	<!--Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
	<td class='fields' width="80%"><input type="password"  onBlur="<%if(active_dir_id.equals("")){if(CASE_SENSITIVE_PASSWORD_YN.equals("N")) {%> ChangeUpperCase(this); <%}}%>" onkeypress='JavaScript:if(event.keyCode==13)return false;' name="password" id="password"></td>
</tr>
<tr>
	<td class='button' width="20%">&nbsp;</td>
	<td width="80%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='button' type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='validate()'><input class='button' type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='cancel1();'><td>
</tr>
</table>
<input type="hidden" name='db_password' id='db_password' value="<%=password%>">

<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2--> 
<input type="hidden" name='active_dir_id' id='active_dir_id' value="<%=active_dir_id%>">

</form>

<%
	if(pstmt != null)
	pstmt.close();

	if(rset != null)
		rset.close();
}catch(Exception e)
{
	
	e.printStackTrace();
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

