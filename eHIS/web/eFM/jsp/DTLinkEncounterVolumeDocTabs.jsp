<!DOCTYPE html>
<%@page session="true" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Script>
		function tab_click1(id) 
		{
			selectTab(id);
			objClick(id);
		}
	</Script>
</head>

<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='DocumentTabs' id='DocumentTabs'>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
<tr>
 <td width='100%' class='BODYCOLORFILLED'>
 <!-- <a href="javascript:objClick('first_tab'); "  ><img id='first_tab' border='0' src='../../eFM/images/Encounters.gif' alt='Encounters' ></img></a><a href="javascript:objClick('second_tab');"  ><img id='second_tab' border='0' src='../../eFM/images/Documents_click.gif' alt='Documents' ></img></a>
 --> <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Encounters">
				<a onclick="tab_click1('first_tab')" class="tabClicked" id="first_tab" >
					<span class="tabSpanclicked" id="first_tabspan"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Documents">
				<a onclick="tab_click1('second_tab')" class="tabA" id="second_tab" >
					<span class="tabAspan" id="second_tabspan"><fmt:message key="Common.documents.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
		<script>prevTabObj='first_tab'</script>
 </td></tr>
</table>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

