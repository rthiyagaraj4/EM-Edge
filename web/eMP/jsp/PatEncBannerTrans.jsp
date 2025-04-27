<!DOCTYPE html>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eMP/js/PatEncBanner.js"></script>
		<style>
		TD.NORMPAT
		{
		    BACKGROUND-COLOR: #FFF794;  
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
			text-align:LEFT;
		}

		TD.DECEASEDPAT
		{
		    BACKGROUND-COLOR: #D5D5D5;  
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
			text-align:LEFT;
		}

		SPAN.valueClass
		{
			FONT-SIZE: 11pt;
			FONT-WEIGHT: bolder;
			FONT-FAMILY: verdana;
		}

		SPAN.legendClass
		{
			FONT-SIZE: 9pt;
			FONT-FAMILY: verdana;
		}
		</style>

	</head>
	<form>
		<table align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>
		
		</table>
		<div id='testTableID'></div>
<SCRIPT>

	var testArgs = unescape(parent.dialogArguments);
    testArgs = "<table align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>" + testArgs + "</table>";
	document.getElementById("testTableID").innerHTML = testArgs;
	
	/* parent.parent.patEncBannerDetailsFrame.document.getElementById("tdLine1").className = 'NORMPAT';
	parent.parent.patEncBannerDetailsFrame.document.getElementById("tdLine2").className = 'NORMPAT';  */
	parent.window[0].document.getElementById('tdLine1').className = 'NORMPAT';
	parent.window[0].document.getElementById("tdLine2").className = 'NORMPAT';
	
	parent.patEncBannerTransButtonsFrame.location.href = '../../eMP/jsp/PatEncBannerTools.jsp';
</SCRIPT>
	</form>
</html>

