<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  page import="com.iba.framework.core.util.Page" %>
<%@  page import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@  page import="java.util.List" %>
<%@  page import="java.util.ArrayList" %>
<%@  page import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html>
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
			String style="";
	%>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

		<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script>
				function doNext() {
				var pageNum=document.getElementById("vo.page.pageNo")
					pageNum.value=parseInt(pageNum.value)+1
					document.PageForm.submit()
				}
				function doPrev() {
					var pageNum=document.getElementById("vo.page.pageNo")
					pageNum.value=parseInt(pageNum.value)-1
					document.PageForm.submit()

				}			
				
		</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTMLEl:form action="/AgencyCodePageAction">
	
			<div id="listContentLayer" align="right">
				<table><tr><td>
						<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">		
						<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
						</ibaLogic:equal>
						</td>
						<td>
						<ibaLogic:equal name="PageForm" property="vo.page.nextPage"	value="true">
						<a href="javascript:doNext()" >
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a></ibaLogic:equal>
						</td>
				</tr></table>
</div>
			<ibaLogic:equal name="PageForm" value="0"
				property="vo.dataObjectsSize">
				<script> 
					alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA'
							bundle='commonMesages' />");
		parent.content.location.href=contextPath+"/AgencyCodeAction.do?method="+queryMethod+"&vo.functionId="+'<%=request.getParameter("vo.functionId")%>'
			</script>
			</ibaLogic:equal>

			<ibaLogic:notEqual name="PageForm" value="0"
				property="vo.dataObjectsSize">
	<table align="center" border="1" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.agencyCode.agencyCode"
							bundle="lcLabels" />
					</th>
					
					<th>
						<ibaBean:message key="com.iba.ehis.lc.agencyCode.name"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.status"
							bundle="lcLabels" />
					</th>
										
				</tr>

			</ibaLogic:notEqual>

			
			<ibaLogic:iterate id="result" name="PageForm"
				property="vo.dataObjects" indexId="rowId">
				<%
				  style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>
				<tr >
					<td class="<%=style %>"> 
						<a
							href="javascript:parent.loadResult('<ibaBean:write name="result" property="agencyCode" />')"><ibaBean:write
								name="result" property="agencyCode" />
						</a>
					</td>
					<td class="<%=style %>">
						<ibaBean:write name="result" property="agencyName" />
					</td>
					<td class="<%=style %>" align="center">
						<ibaLogic:equal value="E" property="effStatus" name="result">
							<img src='framework/images/enabled.gif'></img>
						</ibaLogic:equal>
						<ibaLogic:equal value="D" property="effStatus" name="result">
							<img src='framework/images/RRnwd.gif'></img>
						</ibaLogic:equal>
					</td>	
				
				</tr>
			</ibaLogic:iterate>
		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="method" value="4" />

		<ibaLogicEl:iterate id="result" name="PageForm"
			property="vo.criteriaVo.criteriaItems" indexId="ind">
			<%
							String itemValProp = "vo.criteriaVo.criteriaItems["
							+ ind + "].itemValue";
					String prop = "vo.criteriaVo.criteriaItems[" + ind
							+ "].property";
			%>
			<ibaHTMLEl:hidden property="<%=itemValProp%>" />
			<ibaHTMLEl:hidden property="<%=prop%>" />

		</ibaLogicEl:iterate>

		<ibaHTML:hidden property="vo.criteriaVo.orderBySelected.itemValue" />
		<ibaHTML:hidden property="vo.functionId" />
		<ibaHTML:hidden property="vo.moduleId" />
		<ibaHTML:hidden property="vo.criteriaVo.queryResultPage" />
				
	</ibaHTMLEl:form>
</body>
</ibaHtmlEl:html>

