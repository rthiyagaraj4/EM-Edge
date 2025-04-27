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
	
	con	=	ConnectionManager.getConnection(request);

	
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	
	String functionID = request.getParameter("functionID");
	if(functionID==null) functionID="";
	
	String facility_id = request.getParameter("facility_id");
	if(facility_id==null) facility_id="";
	
	String userid = request.getParameter("userid");
	if(userid==null) userid="";
	
	String prespid = request.getParameter("prespid");
	if(prespid==null) prespid="";
	
	String payer_group = request.getParameter("payer_group");
	if(payer_group==null) payer_group="";
	
	String payer = request.getParameter("payer");
	if(payer==null) payer="";
	
	String policy = request.getParameter("policy");
	if(policy==null) policy="";
	
	String priv_code = request.getParameter("previlage");
	if(priv_code==null) priv_code="";
	
	String currentdate = request.getParameter("currentdate");
	if(currentdate==null) currentdate="";
		
	String reason_code = request.getParameter("reason_code");
	if(reason_code==null) reason_code="";
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
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src='../js/PkgAdhocDiscount.js'></script> 
	
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
				var auth_resn=document.forms[0].auth_resn.value;
				var auth_resn_code=document.forms[0].auth_resn_code.value;
				var priv_code = document.forms[0].priv_code.value;	
				var functionID = document.forms[0].functionID.value;
				var facility_id = document.forms[0].facility_id.value;
				var prespid = document.forms[0].prespid.value;;
				var payer_group = document.forms[0].payer_group.value;;
				var payer = document.forms[0].payer.value;
				var policy = document.forms[0].policy.value;
				var currentDt = document.forms[0].currentdate.value;
					
				if(usr_id=="")
				{
//					alert(getMessage("BL9112"));
					alert(getMessage("BL9112","BL"));
					document.forms[0].user_id.focus();
					return false;
				}
				if(pass_wd=="")
				{
//					alert(getMessage("BL9113"));
					alert(getMessage("BL9113","BL"));
					document.forms[0].passwd.focus();
					return false;
				}
					
				if(auth_resn == "")
				{
					alert(getMessage("BL0986","BLEXT"));
					document.forms[0].auth_resn.focus();
					return false;
				}
						
				var xmlStr ="<root><SEARCH ";
				xmlStr+= "usr_id=\"" + usr_id + "\" " ;		
				xmlStr+= "pass_wd=\"" + pass_wd + "\" " ;
				xmlStr+= "priv_code=\"" + priv_code + "\" " ;						
				xmlStr +=" /></root>";
				var temp_jsp="BLAuthForPrivValidation.jsp?functionID=" + functionID+"&facility_id="+facility_id+"&prespid="+prespid+"&payer_group="+payer_group+"&payer="+payer+"&policy="+policy+"&currentdate="+currentDt;					
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
					window.parent.returnValue="Y"+"~"+usr_id+"~"+auth_resn_code; // added for CRF-076.2
					window.close();
				}
				else if(responseText[0]=="U"){		//Added array[] for split the values
					alert(getMessage('BL9539','BL'));
				}else if(responseText[0]=="A"){		//Added array[] for split the values
					alert(getMessage('BL0968','BLEXT'));
				}else{
					alert(getMessage('BL1232','BL'));
				}				
			}
			
			function funAuthReasonLkup()
			{
				var dialogTop			= "40";
				var dialogHeight		= "10" ;
				var dialogWidth			= "40" ;
				var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var title=getLabel("eBL.ListOfReasons.label","BL"); 
				title=encodeURIComponent(title);
				var column_sizes = escape("70%,30%");               
				var reasons=getLabel("eBL.Reasons.label","common");
				cashcntrcode=encodeURIComponent(reasons);
				var desc=getLabel("Common.description.label","common");
				desc=encodeURIComponent(desc);
				var column_descriptions = desc+","+reasons;
				var locale = document.getElementById('locale').value;
				var reason_code = document.getElementById("reason_code").value;
				var sql = "" ; 
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"&srch_by_clmn_index=2"+"&col_show_hide=YY"+"&called_for=PRIV_AUTH_REASON_LKUP&locale="+locale+"&target="+document.getElementById("auth_resn").value+"&reason_code="+reason_code;
				
				retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
				var arr=new Array();

				if(retVal == null) retVal='';
					
				if (retVal != null || retVal!='')
				{	
					var retVal=unescape(retVal);
					if(retVal != null && retVal.length>0)
					{
						arr=retVal.split("^~^");
						document.getElementById("auth_resn").value=arr[0];
						document.getElementById("auth_resn_code").value=arr[1];			
					} else {
						alert(getMessage("BL0987","BLEXT"));
						document.getElementById("auth_resn").focus();	
					}
						
				} else {
					alert(getMessage("BL0987","BLEXT"));
					document.getElementById("auth_resn").focus();	
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
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='21' maxlength='64'><img src='../../eCommon/images/mandatory.gif'></td> 
 </tr>
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
	<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='return confirmPasswdchk(this);'>
	<input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='parent.window.close(); return retModal(this);'>
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

<input type= 'hidden' name="functionID" id="functionID"  value='<%=functionID%>'>
<input type= 'hidden' name="facility_id" id="facility_id"  value='<%=facility_id%>'>
<input type= 'hidden' name="userid" id="userid"  value='<%=userid%>'>
<input type= 'hidden' name="prespid" id="prespid"  value='<%=prespid%>'>
<input type= 'hidden' name="payer_group" id="payer_group"  value='<%=payer_group%>'>
<input type= 'hidden' name="payer" id="payer"  value='<%=payer%>'>
<input type= 'hidden' name="policy" id="policy"  value='<%=policy%>'>
<input type= 'hidden' name="priv_code" id="priv_code"  value='<%=priv_code%>'>
<input type= 'hidden' name="currentdate" id="currentdate"  value='<%=currentdate%>'>
<input type= 'hidden' name="reason_code" id="reason_code" value='<%=reason_code%>'>

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

