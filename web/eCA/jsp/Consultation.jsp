<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String queryString=request.getQueryString();
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

%>
<script>
 function Call_custom(id) {
	selectTab(id);
	document.getElementById("search_tab").className = "tabA";
	document.getElementById("search_tabspan").className = "tabAspan";
	document.getElementById("select_tab").className = "tabA";
	document.getElementById("select_tabspan").className = "tabAspan";
	var mode=document.getElementById("mode").value;
	if(!(mode=="pat_search"))
	{
	document.getElementById("comp_tab").className = "tabA";
	document.getElementById("comp_tabspan").className = "tabAspan";
	}
	
	parent.frames[1].location.href='PaintConsultation.jsp?<%=queryString%>'
	
 }

 function Call_Search(id) {
	selectTab(id); 
	document.getElementById("custom_tab").className = "tabA";
	document.getElementById("custom_tabspan").className = "tabAspan";
	
	document.getElementById("select_tab").className = "tabA";
	document.getElementById("select_tabspan").className = "tabAspan";
	var mode=document.getElementById("mode").value;
	if(!(mode=="pat_search"))
	{
	document.getElementById("comp_tab").className = "tabA";
	document.getElementById("comp_tabspan").className = "tabAspan";
	}
	parent.frames[1].location.href='PaintSearchProblem.jsp?<%=queryString%>'
	
 }

 function Call_Select(id) {
	 selectTab(id); 
	document.getElementById("custom_tab").className = "tabA";
	document.getElementById("custom_tabspan").className = "tabAspan";
	document.getElementById("search_tab").className = "tabA";
	document.getElementById("search_tabspan").className = "tabAspan";
	var mode=document.getElementById("mode").value;
	if(!(mode=="pat_search"))
	{
	document.getElementById("comp_tab").className = "tabA";
	document.getElementById("comp_tabspan").className = "tabAspan";
	}
		parent.frames[1].location.href='CASearchScreenFrmes.jsp?<%=queryString%>'
 }
function Call_SearchCompalint(id)
{
	selectTab(id);
	document.getElementById("custom_tab").className = "tabA";
	document.getElementById("custom_tabspan").className = "tabAspan";
	document.getElementById("search_tab").className = "tabA";
	document.getElementById("search_tabspan").className = "tabAspan";
	document.getElementById("select_tab").className = "tabA";
	document.getElementById("select_tabspan").className = "tabAspan";
	parent.frames[1].location.href='RecPatChiefComplaintViewAllDiagResult.jsp?<%=queryString%>'
}

function dfltTab(mode)
{
	document.getElementById("search_tab").className = "tabA";
	document.getElementById("search_tabspan").className = "tabAspan";
	document.getElementById("select_tab").className = "tabA";
	document.getElementById("select_tabspan").className = "tabAspan";
	if(!(mode=="pat_search"))
	{
	document.getElementById("comp_tab").className = "tabA";
	document.getElementById("comp_tabspan").className = "tabAspan";
	}

}



</script>

<!--<body onload="tab_click('demogrp_tab')">-->
<body onLoad ="dfltTab('<%=mode%>')" onKeyDown="lockKey()">
 <table  width='100%' cellspacing='0%' cellpadding='3%'>
<tr>
<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="Common.CustomList.label" bundle="${common_labels}"/>'>
	<a onclick="Call_custom('custom_tab')" class="tabClicked" id='custom_tab' >
	<span class="tabSpanclicked" id="custom_tabspan"><fmt:message key="Common.CustomList.label" bundle="${common_labels}"/> </span></a>
</li>
<li class="tablistitem" title='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'>
<a onclick="Call_Search('search_tab')" class="tabClicked"  id='search_tab' >
<span class="tabSpanclicked" id="search_tabspan"><fmt:message key="Common.search.label" bundle="${common_labels}"/></span>
</a>
</li>
<li class="tablistitem" title='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' >
<a onclick="Call_Select('select_tab')" class="tabClicked" id='select_tab'>
<span class="tabSpanclicked" id="select_tabspan" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></span></a>
	</li>

<%
	if(!mode.equals("pat_search"))
	{
%>
	<li class="tablistitem" title='<fmt:message key="eCA.ComplaintBased.label" bundle="${ca_labels}"/>' >
<a onclick="Call_SearchCompalint('comp_tab')" class="tabClicked" id='comp_tab'>
<span class="tabSpanclicked" id="comp_tabspan"><fmt:message key="eCA.ComplaintBased.label" bundle="${ca_labels}"/></span></a>
	</li>
<%
	}	
%>
</ul>
</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>


</BODY>
</html>

