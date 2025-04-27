<!DOCTYPE html>
<head>
	<script language="JavaScript" src="../js/MedicationAdministrationFixedTime.js"></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<script language="JavaScript">
		function onApply() {
			parent.apply() ;
			parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		}
	</script>
</head>

<!-- <body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0> -->
<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onMouseDown="" onKeyDown="lockKey()">

<%
	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	
	if ( module_id		== null ) module_id 	= "" ;
	if ( function_id		== null ) function_id 	= "" ;
	if ( function_name	== null ) function_name	= "" ;
	if ( function_type	== null ) function_type	= "F" ;
%>

<form name="MARheaderForCA_form" id="MARheaderForCA_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<%= function_name %>
		</td>
	</tr>
	<tr class="COMMON_TOOLBAR">
		<td class="COMMON_TOOLBAR">
			<table width="100%" cellspacing='0' cellpading='0'>
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" align="left" width="50%">
						<table cellspacing='0' cellpading='0'>
							<tr class="COMMON_TOOLBAR">
							<td class="COMMON_TOOLBAR">
								<input type='button' onclick="onApply();" value='Apply' name='apply' id='apply' class='BUTTON'></input>
							</td>
							<td class="COMMON_TOOLBAR">
								<input type='button' onclick="closeFunction();" value='Close' name='home' id='home' class='BUTTON' ></input>
							</td>
							</tr>
						</table>
					</td>

					<td class="COMMON_TOOLBAR" align="right" width="50%">
					
				</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

