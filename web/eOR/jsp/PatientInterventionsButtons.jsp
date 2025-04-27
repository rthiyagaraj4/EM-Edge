<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 								 
-----------------------------------------------------------------------
*/
%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<html>
	<head>
	<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function printit() 
			{	
				WSHShell=new ActiveXObject("WScript.Shell");
				myheader=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
				myfooter=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");	
				WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header", myheader);
				WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer", myfooter);
					
				parent.frames[0].focus();
				if (document.all) 
				{
					var i = 0;
					
						while( i < document.applets.length ) 
						{
							var j = 0 ;
							while ( !document.applets[i].isActive() && j++ <=75000 ) 
							window.status = i;
							i++;
						}
					window.print();	
				}
				
			}
		</script>
	</head>
	<body>
		<form name="PatientInterventionsButtonForm" id="PatientInterventionsButtonForm">
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>
					<td width="100%" align='RIGHT' style="padding-right:30px">
						<input type='button' class='button' name='print' id='print'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick='printit();'>&nbsp;
						<input type='button' class='button' name='close' id='close'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='parent.window.close();'>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

