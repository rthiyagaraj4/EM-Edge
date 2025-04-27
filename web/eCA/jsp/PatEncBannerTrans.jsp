<!DOCTYPE html>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<style>		

		/*TD.DECEASEDPAT
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
		}*/

		TD.NORMPAT
		{
			BACKGROUND-COLOR: #FFF791;  
		}

		SPAN.legendClassRow1
		{
			font-family: Verdana;
			font-size: 12pt;
			padding-bottom:4px;
			padding-left:4px;
			padding-right:4px; 
		}

		SPAN.valueClassRow1
		{
			font-family: Verdana;
			font-size: 12pt; 
			font-weight: bold;
			padding-bottom:4px;
		}

		SPAN.legendClassRow2
		{
			font-family: Verdana;
			font-size: 8pt;
			padding-bottom:4px;
			padding-left:4px;
			padding-right:4px; 
		}

		SPAN.valueClassRow2
		{
			font-family: Verdana;
			font-size: 8pt; 
			font-weight: bold;
			padding-bottom:4px;
		}
	</style>
		<script>		
		</script>
	</head>
	<form>
		<table align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>
		
		</table>
		<div id='testTableID'></div>
<SCRIPT>
	var testArgs = unescape(top.dialogArguments);
	testArgs = "<table align='center' cellpadding=0 cellspacing=0 border=0 width='100%'>" + testArgs + "</table>";
	document.getElementById("testTableID").innerHTML = testArgs;
	document.getElementById("tdLine1").className = 'NORMPAT';
	document.getElementById("tdLine2").className = 'NORMPAT';

	parent.patEncBannerTransButtonsFrame.location.href = '../../eCA/jsp/PatEncBannerTools.jsp';
</SCRIPT>
	</form>
</html>

