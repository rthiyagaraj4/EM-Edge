<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>


<html>
<head>
<link rel="StyleSheet" type="text/css" href="../../eOT/html/AnaesthesiaHistoryStyle.css"/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eOT/js/AT_AnaesthesiaHistory.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body class="HEADER" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<table cellpadding=3 cellspacing=0 border=0 width='100%' height='100%'>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" style='padding-left:0px'>
		<li class="tablistitem" title='<fmt:message key="eOT.PreAnaesthesiaNotes.Label" bundle="${ot_labels}"/>'>
			<a onclick="changeTab('PRE_NOTES');" 
			class="tabclicked" id="PRE_NOTES">
				<span class="tabSpanclicked" id="PRE_NOTESspan">
					<fmt:message key="eOT.PreAnaesthesiaNotes.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	
		
		 <li class="tablistitem" title='<fmt:message key="eOT.IntraAnaesthesiaNotes.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('INTRA_NOTES');" id="INTRA_NOTES"> 
				<span class="tabAspan" id="INTRA_NOTESspan">
				<fmt:message key="eOT.IntraAnaesthesiaNotes.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
		<li class="tablistitem" title='<fmt:message key="eOT.PostAnaesthesiaNotes.Label" bundle="${ot_labels}"/>'>
			<a  class="tabA"  onclick="changeTab('POST_NOTES');" id="POST_NOTES"> 
				<span class="tabAspan" id="POST_NOTESspan">
				<fmt:message key="eOT.PostAnaesthesiaNotes.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li> 

		</ul>		
		</td>	
	</tr>
</table>
<script>

changeTab('PRE_NOTES') ;
prevTabObj='PRE_NOTES' 
</script> 	
</form>
</body>
</html>


