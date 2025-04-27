<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script Language="VBScript">

'Set WshShell33 = CreateObject("WScript.Shell")
'WshShell33.SendKeys "{F11}"

</Script>
<script language="JavaScript">

    function showInNewWindow() {
		if(homeForm.called_from.value=='CA'){
			homeForm.validLogin.value="N";
			var myBars = 'directories=no,location=no,menubar=no,status=no' ;
			//var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
			// edge new window 
			var myOptions = 'width=' + screen.width + ', height=' + screen.height + ', resizable=no, fullscreen=yes' ;
			var myFeatures = myBars + ', ' + myOptions ;
			
			
			
			//var ecisWindow = open( 'eHIS.jsp', 'eHISMain1', myFeatures ) ;
			var ecisWindow = window.open( 'eHIS.jsp', 'eHISMain1', myFeatures ) ;
			if(window.name =="eHISMain" || window.name == "eHISMain2")
				window.close();
			ecisWindow.focus() ;
		}else{
		
			if(homeForm.validLogin.value=="Y"){
				homeForm.validLogin.value="N";
				var myBars = 'directories=no,location=no,menubar=no,status=no' ;	
				//var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
				//var myOptions = 'width=' + screen.width + ', height=' + screen.height + ',top=0, left=0, fullscreen=yes' ;
			
				// edge new window  			
				var myOptions = 'width=' + screen.width + ', height=' + screen.height + ',top=0, left=0, fullscreen=yes' ;
				//var myOptions = 'width=' + window.screen.availwidth + ', height='+document.body.clientHeight+', resizable=no, fullscreen=yes' ;
				var myFeatures = myBars + ', ' + myOptions ;
				//var ecisWindow = open( 'eHIS.jsp', 'eHISMain1', myFeatures ) ;
				var ecisWindow = window.open( 'eHIS.jsp', 'eHISMain1', myFeatures ) ;
				
				if(window.name =="eHISMain" || window.name == "eHISMain2")
					window.close();
				ecisWindow.focus() ;
			}else{
				//if(window.confirm("Do you want to login")){
					location.href = '../../eSM/jsp/login.jsp';
				//}else{
					//window.opener="SOMETHING";
					//window.close();
				//}
			}
		}
    }
</script>
</head>
<% 
String validLogin=(String) session.getValue( "Login" ) ;
String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
session.putValue("Login","N");
%>
<body onKeyDown = 'lockKey()' onload="showInNewWindow()">
	<form name="homeForm" id="homeForm">
	<input type="hidden" name="validLogin" id="validLogin" value="<%=validLogin%>">
	<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
	</form>
</body>

