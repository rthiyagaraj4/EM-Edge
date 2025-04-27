<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<!--<title><fmt:message key="eCA.RecordingClinicalNotesTabs.label" bundle="${ca_labels}"/></title>-->
		<!--<title>IPConsultationListTabs</title> -->
		
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/IPConsultationList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	function tab_clickNew(id) 
	{
		selectTab1(id);
		callNewList();
	}

	function tab_clickExist(id) 
	{
						
		selectTab1(id);
		callExistingList();
	} 

	function dfltTab()
	{
		document.getElementById("existinglist_tab").className = "tabA";
		document.getElementById("existinglist_tabspan").className = "tabAspan";
	}

</script>
	
	
	
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onLoad ="dfltTab()">
	<center>
	<form name='IPConsultationListTabsForm' id='IPConsultationListTabsForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
			<td width= "100%" class="white">
			<ul id="tablist" class="tablist" style="padding-left:0px" >
				<li class="tablistitem" title='New List'>
				<a onclick="tab_clickNew('newList_tab')" class="tabClicked" id="newList_tab" >
					<span class="tabSpanclicked" id="newList_tabspan"><fmt:message key="eCA.NewList.label" bundle="${ca_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='Existing List' >
				<a onclick="tab_clickExist('existinglist_tab')" class="tabClicked" id="existinglist_tab" >
					<span class="tabSpanclicked" id="existinglist_tabspan"><fmt:message key="eCA.ExistingList.label" bundle="${ca_labels}"/></span>
				</a>
			</li>
			</ul>
			</td>
		</tr>
	</table>

	</form>
	</center>
	</body>
</html>

