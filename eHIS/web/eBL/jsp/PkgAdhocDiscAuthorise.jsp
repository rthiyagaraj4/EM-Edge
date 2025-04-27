<!DOCTYPE html>
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	Connection con = null;
//	PreparedStatement pstmt = null ;	
	Statement stmt = null; 
	ResultSet rs1=null;	

	try
	{
	String disable_chk_box = "", str_existing_reason_desc="",str_existing_reason_code="";

	con	=	ConnectionManager.getConnection(request);

	String include=request.getParameter("mode");
	if(include==null) include="N";
	include="N";
	
//	System.err.println("str_existing_reason_code:"+str_existing_reason_code);
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";

	
%>
<html>
<head>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src='../../eBL/js/PkgAdhocDiscount.js'></script> 
	<script language='javascript'>
			function retModal(obj)
			{		
				var returnArray = "N";
				parent.window.returnValue = returnArray;
				
			}

			function confirmPasswdchk(obj)
			{				
				confirmPasswdchk1(obj);
			}
		/*	{		
				
					var usr_id=document.forms[0].user_id.value;
					var pass_wd=document.forms[0].passwd.value;
					var rmks=document.forms[0].remarks.value;
					var called_frm = document.forms[0].called_frm.value;				
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "usr_id=\"" + usr_id + "\" " ;		
					xmlStr+= "pass_wd=\"" + pass_wd + "\" " ;
					xmlStr+= "rmks=\"" + rmks + "\" " ;					
					xmlStr +=" /></root>";
					var temp_jsp="PkgConfirmPassWdValidation.jsp?func_mode=PASSWD_CHECK";					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var responseText=trimString(xmlHttp.responseText);		
					//alert(responseText)
					eval(responseText);

						
					
			}*/


		

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title> 
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<center>
<form name='AuthForm' id='AuthForm'>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>

<tr>
	<td colspan=15>&nbsp;</td>
</tr>


 <tr>
<!--	<td width="35%" align="right" class="label">User ID</td> -->
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return makeUpperCase()'><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
 <tr>
<!--	<td width="35%" align="right" class="label">Pin No</td> -->
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='21' maxlength='64'><img src='../../eCommon/images/mandatory.gif'></td> </tr>

	 <tr>
<!--	<td width="35%" align="right" class="label">Remarks</td> -->
	<td width="50%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><textarea name='remarks' rows="2" cols="25" onKeyPress='checkMaxLimit(this,50)'></textarea></td>
 </tr>


<tr>
	<td width="50%"></td>
	<td width="50%">
	<input type='button' class='button' name='auth_ok' id='auth_ok' value="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>    " onClick ='return confirmPasswdchk(this);'><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>    " onClick='parent.window.close(); return retModal(this);'>
	</td>
	
</tr>

<tr>
	<td colspan=15>&nbsp;</td>
</tr>
<tr>
	<td colspan=15>&nbsp;</td>
</tr>

	<script>
		document.forms[0].user_id.focus();
	</script>
</table>
<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type= 'hidden' name="called_frm" id="called_frm"  value='pkg_billing'>



</form>
</center>

</body>
</html>

<%
	}
	catch(Exception ee)
	{
	  System.err.println("Error in BLFinDetailsAuthorise.jsp: " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

