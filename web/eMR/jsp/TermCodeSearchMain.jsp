<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
 <style>
        .tablistitem {
            margin-right: 10px;
        }
    </style>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String queryString=request.getQueryString();
	String term_set_id = request.getParameter("term_set_id");
	String speciality_code	= checkForNull(request.getParameter("speciality_code"));
	String dfltSearchYn	= request.getParameter("dfltSearchYn")==null?"C":request.getParameter("dfltSearchYn");
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
%>
<script>
function Call() 
{
	//parent.TermCodeSearchByFrame.location.href='TermCodeSearchByCL.jsp?<%=queryString%>'
	parent.frames[1].location.href='PaintConsultation.jsp?<%=queryString%>'
}

function CallSearch() 
{
//	parent.TermCodeSearchByFrame.location.href='TermCodeSearchByKW.jsp?<%=queryString%>'
	parent.TermCodeSearchByFrame.location.href='PaintSearch.jsp?<%=queryString%>'
}      

function CallSelect() 
{
	
	var p_diag_code = '1';
	if('<%=term_set_id%>'=='ICD10')
		parent.TermCodeSearchByFrame.location.href='../../eMR/jsp/MRSearchScreenFrmes.jsp?<%=queryString%>&term_set_id=<%=term_set_id%>&p_diag_code='+p_diag_code;
	else
		parent.TermCodeSearchByFrame.location.href='../../eMR/jsp/SelectTermCode.jsp?<%=queryString%>&p_diag_code='+p_diag_code;
	parent.top.document.getElementById("TermCodeSearchMain").rows = "7%,*";

}

//var currentTab = new String();
//currentTab = "cmodeaddr_tab";

function tab_click(objName) 
{
	// FIRST CHANGE THE CURRENT SELECTED TAB
	changeTab(objName);
}

function changeTab(TabName)	
{
		

	if (TabName == 'demogrp_tab')
	{
		var p_diag_code = '1';
		document.getElementById("demogrp_tab").scrollIntoView(); //customlist
		parent.frames[1].location.href='PaintConsultation.jsp?<%=queryString%>&p_diag_code='+p_diag_code+'&function_id=ca_diagnosis';

		//setTimeout("parent.frames[1].location.href='PaintConsultation.jsp?<%=queryString%>&p_diag_code='+p_diag_code+'&function_id=ca_diagnosis'",400);

		
		
	}
	else if(TabName == 'cmodeaddr_tab')
	{

		document.getElementById("cmodeaddr_tab").scrollIntoView(); //search
		parent.TermCodeSearchByFrame.location.href='PaintSearch.jsp?<%=queryString%>';
	}
	else if(TabName == 'rlcnts_tab')
	{
		document.getElementById("rlcnts_tab").scrollIntoView(); //select
		var p_diag_code = '1';
		//if('<%=term_set_id%>'=='ICD10')
			parent.TermCodeSearchByFrame.location.href='../../eMR/jsp/MRSearchScreenFrmes.jsp?<%=queryString%>&p_diag_code='+p_diag_code;
		//else
			//parent.TermCodeSearchByFrame.location.href='../../eMR/jsp/SelectTermCode.jsp?<%=queryString%>&p_diag_code='+p_diag_code;
		//parent.top.document.getElementById("TermCodeSearchMain").rows = "4%,*";
	}
	else if(TabName == 'level_tab')
	{
		
		parent.document.getElementById("TermCodeSearchToolbarFrame").style.visibility = "hidden" ;
		document.getElementById("level_tab").scrollIntoView();//level
		parent.TermCodeSearchByFrame.location.href='../../eMR/jsp/SelectTermCode.jsp?<%=queryString%>&p_diag_code='+p_diag_code;
		//parent.top.document.getElementById("TermCodeSearchMain").rows = "4%,*";
	}
}

</script>
<%
	if(dfltSearchYn.equals("S")){
		%><body onload="tab_click('cmodeaddr_tab')" onKeyDown='lockKey()'><%
	}else{%>	
	<body onload="tab_click('demogrp_tab')" onKeyDown='lockKey()'>
<%}
	
	%>
 <table  width='100%' cellspacing='0%' cellpadding='0%'>
<tr>
<td align='left' class='BODYCOLORFILLED'>

<a name='customlist' ></a>
<ul id='tablist' class='tablist' style="padding-left:0px">
			<li class='tablistitem' title='Custom List'>
				<a class='tabClicked' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<li class='tablistitem' title='Search'>
				<a class='tabClicked' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' title='Level'>
				<a class='tabClicked' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' title='Select'>
				<a class='tabClicked' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>		
	<BR><BR>
	<a name="search" ></a> 
	<ul id="tablist" class="tablist">	
		<li class='tablistitem' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>	
		<li class='tablistitem' title='Search'>
				<a class='tabClicked' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' title='Level'>
				<a class='tabA' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabAspan'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' title='Select'>
				<a class='tabA' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabAspan'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
	<BR><BR>
	<% if(term_set_id !=null && term_set_id.equals("ICD10")){%>
	<a name="select" ></a> 
	<ul id="tablist" class="tablist">	
		<li class='tablistitem' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
	 
		<li class='tablistitem' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<li class='tablistitem' title='Select'>
				<a class='tabClicked' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
	<%}else{%>
	<a name="level" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>	
		<li class='tablistitem' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' title='Level'>
				<a class='tabClicked' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
		</li>
		<li class='tablistitem' title='Select'>
				<a class='tabA' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabAspan'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
		</li>
		</ul>
		<BR><BR>
		<a name="select" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>	
		<li class='tablistitem' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' title='Level'>
				<a class='tabA' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabAspan'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
		</li>
		<li class='tablistitem' title='Select'>
				<a class='tabClicked' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
		</li>
		</ul>
	<%}%>
</tr>
</table>
</BODY>
</html>
<script> CallSearch()</script>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

