<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.Map" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text" %>
<%
String qryEven="QRYEVEN";
			String qryOdd="QRYODD";
			%>
<script type="text/javascript">
<!--
	function getRowDtls(key, value){

		arr =new Array();
		arr[0]=key
		arr[1]=value
		top.returnValue=arr
		top.close()
	}
//-->
</script>

<ibaHTML:html locale="true">
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
			String style="";
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	
<script type="text/javascript">
<!--
				function doNext() {
				var pageNum=document.getElementById("vo.page.pageNo")
					pageNum.value=parseInt(pageNum.value)+1
					document.LookupForm.submit()
				}
				function doPrev() {
					var pageNum=document.getElementById("vo.page.pageNo")
					pageNum.value=parseInt(pageNum.value)-1
					document.LookupForm.submit()

				}			
		</script>
</head>
<body>
	<ibaHTML:form action="/LookupAction.do">

	<table cellpadding=0 cellspacing=0 width="100%" align="center" border=0>
			<tr style="">
				<td align="right" class="white">
				&nbsp;
				</td>
				<td align="right" class="white">
				<table>
				<tr>
				<td>
				<ibaLogic:equal name="LookupForm" property="vo.page.previousPage"
					value="true">
					
						<a href="javascript:doPrev()">Previous </a>
					
				</ibaLogic:equal>
				</td>
				<td>
				<ibaLogic:equal name="LookupForm" property="vo.page.nextPage"
					value="true">
					
						<a href="javascript:doNext()">Next </a>
					
				</ibaLogic:equal>
				</td>
				</tr>
				</table>
				</td>
			</tr>
			</table>
		<table cellpadding=0 cellspacing=0 width="100%" align="center" border=1>
			<tr>
			<ibaBean:define id="linkId" name="LookupForm"
						property="vo.lookupParameters(displayLink)"></ibaBean:define>
						
						<ibaLogic:equal name="LookupForm"
						property="vo.lookupParameters(displayOrder)" value="CODE_DESC">
						<th>
					
							<ibaBean:message bundle="commonLabels"
								key="com.iba.ehis.core.code" />
						</th>
						<th>
							<ibaBean:message bundle="commonLabels"
								key="com.iba.ehis.core.description" />
						</th>
					</ibaLogic:equal>
					
					<ibaLogic:equal name="LookupForm"
						property="vo.lookupParameters(displayOrder)" value="DESC_CODE">
						<th>
							<ibaBean:message bundle="commonLabels"
								key="com.iba.ehis.core.description" />
						</th>
						<th	>
							<ibaBean:message bundle="commonLabels"
								key="com.iba.ehis.core.code" />
						</th>
					</ibaLogic:equal>
			</tr>
			<ibaLogic:iterate id="result" name="LookupForm"
				property="vo.lookupResults" indexId="rowId">
				<%
				   style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				%>
				<tr>
				
					<ibaLogic:equal name="LookupForm"
						property="vo.lookupParameters(displayOrder)" value="CODE_DESC" >
						<td class="<%=style %>">
						<% if(linkId !=null ) {if(linkId.equals("CODE_LINK")|| linkId.equals("CODE_DESC_LINK")){%><A HREF="javascript:getRowDtls(`<ibaBean:write name="result" property="key" />','<ibaBean:write name="result" property="value" />')"><%}}%>
							<ibaBean:write name="result" property="key" />
						<% if(linkId !=null ) {if(linkId.equals("CODE_LINK")|| linkId.equals("CODE_DESC_LINK")){%></A><%}}%>
						</td>
						<td class="<%=style %>">
						<% if(linkId !=null ) {if(linkId.equals("DESC_LINK")|| linkId.equals("CODE_DESC_LINK")){%><A HREF="javascript:getRowDtls('<ibaBean:write name="result" property="key" />','<ibaBean:write name="result" property="value" />')"><%}}%>
							<ibaBean:write name="result" property="value" />
							<% if(linkId !=null ) {if(linkId.equals("DESC_LINK")|| linkId.equals("CODE_DESC_LINK")){%></A><%}}%>
						</td>
					</ibaLogic:equal>

					<ibaLogic:equal name="LookupForm"
						property="vo.lookupParameters(displayOrder)" value="DESC_CODE">
						<td class="<%=style %>">
							<% if(linkId !=null ) {if(linkId.equals("DESC_LINK")|| linkId.equals("CODE_DESC_LINK")){%><A HREF="javascript:getRowDtls('<ibaBean:write name="result" property="key" />','<ibaBean:write name="result" property="value" />')"><%}}%>
							<ibaBean:write name="result" property="value" />
							<% if(linkId !=null ) {if(linkId.equals("DESC_LINK")|| linkId.equals("CODE_DESC_LINK")){%></A><%}}%>
						</td>
						<td class="<%=style %>"	>
							<% if(linkId !=null ) {if(linkId.equals("CODE_LINK")|| linkId.equals("CODE_DESC_LINK")){%><A HREF="javascript:getRowDtls('<ibaBean:write name="result" property="key" />','<ibaBean:write name="result" property="value" />')"><%}}%>
							<ibaBean:write name="result" property="key" />
							<% if(linkId !=null ) {if(linkId.equals("CODE_LINK")|| linkId.equals("CODE_DESC_LINK")){%></A><%}}%>
						</td>

					</ibaLogic:equal>
				</tr>
			</ibaLogic:iterate>
		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="vo.queryId" />
		<ibaLogicEl:iterate id="result" name="LookupForm"
			property="vo.lookupParameters" indexId="rowId">
			<%
							String key = "vo.lookupParameters("
							+ ((Map.Entry) result).getKey() + ")";
			%>

			<ibaHTMLEl:hidden property="<%=key%>" />
		</ibaLogicEl:iterate>
	</ibaHTML:form>
	<ibaLogic:empty name="LookupForm"
				property="vo.lookupResults" >
	<script type="text/javascript">
	alert('<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.noRecord" />')
						</script>
		</ibaLogic:empty>
</body>
</ibaHTML:html>

