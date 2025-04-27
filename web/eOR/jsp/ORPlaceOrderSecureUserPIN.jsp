<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?           created
20/01/2012	IN029143	  Menaka V	  <JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in
									  EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.
25/01/2012	  IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.			

27/01/2012	IN030633	Ramesh G	When the Pin No. is prompted, do not enter the Pin No>Press Enter>A new Window opens.
31/01/2012	IN030711	Menaka V	When the User is not assigned any Pin No. and he enters any Pin
									No.,Wrong prompt message is displayed
31/01/2012	IN030846	Menaka V	In the Prompt Message to enter Pin No. the Cancel Button Caption is aligned 
									to the right.	
-----------------------------------------------------------------------
-->
<%@ page  import="eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>


<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	String called_frm = request.getParameter("called_frm");
	if(called_frm == null) called_frm="";
	//String user_id	= (String)session.getValue("login_user");
	
	String user_id		= request.getParameter("pract_id");
	String user_name = request.getParameter("pract_name");
	String bean_id		= "@OrderEntryBean";
	String bean_name	= "eOR.OrderEntryBean";
	String keyObj	= request.getParameter("keyObj");		//[IN030566]
	String patientId = request.getParameter("patient_id");		//[IN030566]
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<title>
		<fmt:message key="Common.PIN.label" bundle="${common_labels}"/>
	</title>
	<script language="javascript">
	function makeUpperCase()
	{
		if( (event.keyCode > 96) && (event.keyCode < 123) )
		{
			event.keyCode = event.keyCode - 32;
		}
		return true;
	}
	function retModal(obj)
	{
		var called_frm = document.forms[0].called_frm.value;
		if(called_frm == "")
		{
			var returnArray = new Array ("N")
			parent.window.returnValue = returnArray;
		}
	}
	function confirmPasswdchk(obj)
	{	
		/*alert("50 document.forms[0].user_id.value==========="+document.forms[0].user_id.value)
		if(document.forms[0].user_id.value=="")
		{
			alert("Please enter the user name");
			document.forms[0].user_id.focus();
			return false;
		}*/
		if(document.forms[0].passwd.value=="")
		{
			//alert("Please enter the Password");
			alert(getMessage("ENTER_PIN","OR"));
			document.forms[0].passwd.focus();
			return false;
		}
		//var called_frm = document.forms[0].called_frm.value;
		
		var usr_id=document.forms[0].user_id.value;
		var usr_name=document.forms[0].user_name.value;
		
		var pass_wd=document.forms[0].passwd.value;
		var formObj = document.forms[0];
		bean_id 			= formObj.bean_id.value;
		bean_name 			= formObj.bean_name.value;
		var keyObj			= formObj.key_obj.value;		//[IN030566]
		var patient_id		= formObj.patient_id.value;		//[IN030566]
		var query_string ="";
		query_string	= "bean_id="+bean_id+"&bean_name="+bean_name+"&usr_id="+usr_id+"&pass_wd="+pass_wd+"&usr_name="+usr_name+"&func_mode=validatePIN";
		
					
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr  = "<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ORPlaceOrderSecurePINValidation.jsp?"+query_string, false ) ;
		xmlHttp.send(xmlDoc);
		if(trimString(xmlHttp.responseText)=="Y")
		{
			//[IN030566] Start
			//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			//var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest();
			xmlStr			= "<root><SEARCH " ;
			xmlStr 			+=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Set&keyObj="+keyObj+"&keyValue="+pass_wd+"&patient_id="+patient_id, false ) ;
			xmlHttp.send( xmlDoc ) ;
			if(trimString(xmlHttp.responseText)!="false")
			{
				//window.returnValue = "true";			
			//	window.close();
			if(parent.document.getElementById('dialog-body'))
			{
				let dialogBody = parent.document.getElementById('dialog-body');
			    dialogBody.contentWindow.returnValue = "true";	
			    
			    const dialogTag = parent.document.getElementById("dialog_tag");    
			    dialogTag.close(); 
			}
			else
				{
				let dialogBody = parent.parent.document.getElementById('dialog-body');
			    dialogBody.contentWindow.returnValue = "true";	
			    
			    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			    dialogTag.close(); 
				}
			}
			//window.returnValue = "true";			
			//window.close();
			//[IN030566] Ends
		}
		else if(trimString(xmlHttp.responseText)=="E")//IN030711 starts
		{
			alert(getMessage("PIN_NOT","OR"));
			return false;
		}//IN030711 Ends
		else
		{
			//alert("INVALID USER NAME OR PIN NO");
			alert(getMessage("INVALID_PIN","OR"));
			//window.close();
			return false;
		}
		
	}
	//[IN030633] Start.
	function keyHandel(e)
	{
		var keynum		
		if(window.event) // IE	
			keynum = e.keyCode	
		else if(e.which) // Netscape/Firefox/Opera	
			keynum = e.which
		
		if(keynum==13){
			confirmPasswdchk(this);
			return false;
		}
		return true;
	}
	//[IN030633] Ends.
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body >
	<form name="PlaceOrderUserPINForm1" id="PlaceOrderUserPINForm1">
		<table  border='0' align="center" width='103%' cellpadding='3'  cellspacing='3'>
			<tr>
				<td width="50%" class="label">
					<fmt:message key="eOR.PractitionerName.label" bundle="${common_labels}"/>
				</td>
				<td width="50%" class="fields">
					<input type='text' name='user_name' id='user_name' size='26' maxlength='64' onKeyPress='return makeUpperCase()' value='<%=user_name%>' disabled="disabled" ><img src='../../eCommon/images/mandatory.gif'><!--30846-->
				</td>
			</tr>
			<tr>
				<td width="50%" class="label">
					<fmt:message key="Common.PIN.label" bundle="${common_labels}"/>
				</td>
				<td width="50%" class="fields">
					<!-- [IN030633]
					<input type='password' name='passwd' id='passwd' size='21' maxlength='64'> -->
					<input type='password' name='passwd' id='passwd' size='27' maxlength='64' onkeypress="return keyHandel(event)" ><!-- [IN030633]  --><img src='../../eCommon/images/mandatory.gif'><!--30846-->
				</td>
			</tr>
			
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>"   >
		<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>" >
		<input type= 'hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
		<input type="hidden" name="user_id" id="user_id"			value="<%=user_id%>"   >
		<input type= 'hidden' name="key_obj" id="key_obj"  value='<%=keyObj%>'>				<!-- [IN030566]  -->
		<input type="hidden" name="patient_id" id="patient_id"			value="<%=patientId%>"   >	<!-- [IN030566]  -->
		<!--<input type="hidden" name="user_id" id="user_id"			value="<%=user_id%>"   >-->
			</form>
			<tr>
				<td width="50%"></td>
				<td width="50%" align='right'><!--IN030846-->
					<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='return confirmPasswdchk(this);' size='50%'><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='parent.window.close(); return retModal(this);' size='50%'>
				</td>
			</tr>
			<!--<script>
				//document.forms[0].user_id.focus();
				usr_id.focus();
			</script>-->
		</table>
		
		
	
</body>
</html>
<script language="javascript">
	//document.getElementById("checklist_user_pin").focus();
</script>

