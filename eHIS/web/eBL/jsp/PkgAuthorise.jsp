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
	
	String priv_code = request.getParameter("priv_code");
	if(priv_code==null) priv_code="";	
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
	<script language="javascript" src='../../eBL/js/MaintainTreamentPackage.js'></script> 
	<script language='javascript'>
			function retModal(obj)
			{		
				var returnArray = "N";
				parent.window.returnValue = returnArray;
				
			}

			function confirmPasswdchk(obj)
			{				
				validateUserPassForPriv(obj);
			}
			
			function validateUserPassForPriv(obj)
			{		
					var usr_id=document.forms[0].user_id.value;
					var pass_wd=document.forms[0].passwd.value;
					//var rmks=document.forms[0].remarks.value;
					var rmks='';
					var called_frm = document.forms[0].called_frm.value;
					var priv_code = document.forms[0].priv_code.value;	
					var auth_resn = document.forms[0].auth_resn.value;	
					var auth_resn_code = document.forms[0].auth_resn_code.value;	
				
					if(usr_id=="")
						{
//							alert(getMessage("BL9112"));
							alert(getMessage("BL9112","BL"));
							document.forms[0].user_id.focus();
							return false;
						}
					if(pass_wd=="")
					{
//							alert(getMessage("BL9113"));
						alert(getMessage("BL9113","BL"));
						document.forms[0].passwd.focus();
						return false;
					}
					
					if(auth_resn == "")
					{
						alert("Authorization Reason Cannot be Blank");
						document.forms[0].auth_resn.focus();
						return false;
					}
						
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "usr_id=\"" + usr_id + "\" " ;		
					xmlStr+= "pass_wd=\"" + pass_wd + "\" " ;
					xmlStr+= "rmks=\"" + rmks + "\" " ;	
					xmlStr+= "priv_code=\"" + priv_code + "\" " ;						
					xmlStr +=" /></root>";
					var temp_jsp="PkgAuthValidation.jsp?func_mode=PASSWD_CHECK";					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var responseText=trimString(xmlHttp.responseText);	
					//Added V190828-Gomathi/GHL-SCF-1436 Starts
					responseText = responseText.split(":::");	
					if(responseText[1]=="D")		
						{
							alert(getMessage('BL1025','BL'));
							return false;
						} 
					//Added V190828-Gomathi/GHL-SCF-1436 Ends
					if(responseText[0]=="Y")		//Added array[] for split the values
					{
						var usrPrivListForManagePatPack = responseText[2];
						window.parent.returnValue="Y"+"~"+usrPrivListForManagePatPack+"~"+usr_id+"~"+auth_resn_code; // added for CRF-076.2
						window.close();
					}
					else if(responseText[0]=="U"){		//Added array[] for split the values
						alert(getMessage('BL9539','BL'));
					}else{
						alert(getMessage('BL1232','BL'));
					}				
				}
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
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return makeUpperCase()'><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
 <tr>
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='21' maxlength='64'><img src='../../eCommon/images/mandatory.gif'></td> </tr>
<!--	
<tr>
	<td width="50%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><textarea name='remarks' rows="2" cols="25" onKeyPress='checkMaxLimit(this,50)'></textarea></td>
 </tr>
-->
 <tr>
	<td width="50%"class="label" ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields">
		<input type="text" name="auth_resn" id="auth_resn" id="auth_resn" value='' onBlur="funAuthReasonLkup()" />
		<input type='button' value='?' class='button' onClick="funAuthReasonLkup()" />
		<img src='../../eCommon/images/mandatory.gif'>
		<input type= 'hidden' name="auth_resn_code" id="auth_resn_code"  value=''>
	</td>
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
<input type= 'hidden' name="priv_code" id="priv_code"  value='<%=priv_code%>'>
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

