<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script src='../../eMO/js/MOManageDeceased.js' language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>prevTabObj='mndec';</script>
</head>
 <body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="MOManagePatTabsForm" id="MOManagePatTabsForm"  onLoad="" OnMouseDown="CodeArrest()"> 

<table cellspacing=0 cellpadding=0 align="center" width="100%" border="0">
<tr>
		<td align='left' class='white' width='15%'>
		<!--	 <a name="tab1"   onFocus='javascript:ManageDeceasedView(1);'></a><table width='95%' cellpadding='0' cellspacing='0'  BORDER='0' ><tr><td  class='BODYCOLORFILLED'></td><td  class='BODYCOLORFILLED' ><a align ='left'  href="javascript:ManageDeceasedView(1)" style="cursor:pointer;" ><img src='../../eMO/images/Deceased_Patients.gif' id='mndec' border=0 ></a><a align='left' href="javascript:ManageDeceasedView(3)"   ><img src="../../eMO/images/Body_Parts_Click.gif"  id='bprt' border=0> -->
			
			 <ul id="tab1" class="tablist" >
			<li class="tablistitem" title='Deceased Patients'>
				<a onclick="ManageDeceasedView(1)" class="tabClicked" id="mndec" >
					<span class="tabSpanclicked" id="mndecspan"><fmt:message key="eMO.DeceasedPatients.label" bundle="${mo_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='Body Parts'>
				<a onclick="ManageDeceasedView(3)" class="tabA" id="bprt">
					<span class="tabAspan" id="bprtspan"><fmt:message key="Common.BodyParts.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			</ul>
		</td>
</tr>
</table>
<input type='hidden' name='ct_tab_name' id='ct_tab_name'  >
<input type='hidden' name='toggle_wait_patman' id='toggle_wait_patman'  value="char_tab">
</form>
</body>
</html>

