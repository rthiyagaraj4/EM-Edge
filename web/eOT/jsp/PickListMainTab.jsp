<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<%@ page import="java.util.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title>
<fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>

</head>
<script language="javascript">
function changeTab(objStr)
{
	var frmObj=document.forms[0];
	/*var obj1=document.getElementById("generate_tab");
	obj1.className="tabA";
	obj1=document.getElementById("review_tab");
	obj1.className="tabA";
	obj1=document.getElementById("report_tab");
	obj1.className="tabA";
	obj1=document.getElementById(objStr);
	obj1.className="tabA";*/
	var param=frmObj.param.value;
	selectTab(objStr);
	if(objStr=='Generate'){
		parent.frames[1].location.href="../../eOT/jsp/PickGenByDate.jsp?"+param;
	}else if(objStr=='Review'){
		parent.frames[1].location.href="../../eOT/jsp/PickListReviewMainFrame.jsp?"+param;
	}
	if(objStr=='Report'){
		param ="flag=PRINT";
		parent.frames[1].location.href="../../eOT/jsp/PickGenByDate.jsp?"+param;
	}

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<form name="OrCommonForm" id="OrCommonForm">
<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>
<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" style='padding-left:0px'>
		<li class="tablistitem" title='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>' >
			<a  class="tabClicked"  onclick="changeTab('Generate');" id="Generate"> 
				<span class="tabSpanclicked" id="Generatespan"><fmt:message key="Common.Generate.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
		<li class="tablistitem" title='<fmt:message key="Common.Review.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('Review');" id="Review"> 
				<span class="tabAspan" id="Reviewspan"><fmt:message key="Common.Review.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('Report');" id="Report"> 
				<span class="tabAspan" id="Reportspan"><fmt:message key="Common.print.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
	</ul>
	</td>
</tr>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='Generate'</script>

</table>
<input type='hidden' name='param' id='param' value="">
</form>
</body>
</html>

