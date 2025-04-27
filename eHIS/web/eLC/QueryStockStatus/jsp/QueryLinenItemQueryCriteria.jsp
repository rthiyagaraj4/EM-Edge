<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>

<html>
<head>
	<%	
		session.setAttribute("functionId","LC_LINENITEMSTOCKSTATUS");
		session.setAttribute("moduleId","LC");
		request.setAttribute("linen","LinenItem");
		String locale=(String)session.getAttribute("LOCALE");
		String moduleId=(String)session.getAttribute("moduleId");
		String facilityId=(String)session.getAttribute("facility_id");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
	%>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/QueryStockStatus/js/QueryStockStatus.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/QueryStockStatus.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br>
	<ibaHTML:form action="/QueryAction.do" target="stockStatusResult">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
				<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				<td width="60%" nowrap="nowrap" >
				<ibaHTML:hidden property="vo.criteriaItems[0].itemValue" />
				<ibaHTML:hidden property="vo.criteriaItems[0].property" value="linenItem" />
				<input type=text name="linenItemDesc" id="linenItemDesc" onblur="linenItemLookup();"/>
				<input type='button' class="BUTTON"  value='?' onclick="linenItemLookup();" />
				<img src='<%=request.getContextPath()%>/framework/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td colspan='6' align='right'>
					<input type="button" class='BUTTON' name="linenItemButton" id="linenItemButton" value="Search" onclick="linenItemChk();"/>
				</td>
			</tr>
				<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="QueryLinenItemQueryResult">
				<input type="hidden" name="vo.functionId" id="vo.functionId" value="LC_LINENITEMSTOCKSTATUS">
				<input type="hidden" name="vo.moduleId" id="vo.moduleId" value="LC">
				<input type="hidden" name="languageId" id="languageId" value="<%=locale%>">
				<input type="hidden" name="vo.facilityId" id="vo.facilityId" value="<%=facilityId%>">
				<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="QueryStockStatusLinenPageAction">
				<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>"/>
				<!--  modified By DhanasekarV for weblogic server -->
			</table>
		</ibaHTML:form>
	</body>
</html>

