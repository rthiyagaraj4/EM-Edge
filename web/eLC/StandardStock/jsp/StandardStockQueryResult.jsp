<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="com.iba.framework.core.pojo.web.MessageReader"%>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.framework.core.pojo.web.BaseForm" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.ehis.lc.standardStock.vo.StandardStockVO"%>
<%@ page  import="com.iba.ehis.dobj.LcStdLinenQtyVw"%>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html>
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
			String style;

	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
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
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
</head>

<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTMLEl:form action="/StandardStockPageAction">
			
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
					parent.content.location.href=contextPath+"/StandardStockAction.do?method="+queryMethod+"&vo.functionId="+'<%=request.getParameter("vo.functionId")%>'
			</script>
			</ibaLogic:equal>
	
		<table border="1" width="100%" cellspacing='0' cellpadding='2' align='center'>	
			
		
			<ibaLogic:notEqual name="PageForm" value="0"
				property="vo.dataObjectsSize">
				
				<tr>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.standardStock.source"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.linenItem"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.standardStock.stdStock"
							bundle="lcLabels" />
					</th>
				</tr>

			</ibaLogic:notEqual>

			
			<ibaLogic:iterate id="result" name="PageForm"
				property="vo.dataObjects" indexId="rowId">
				<%
				  style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //  out.println(result);
				  try{
				  if(result!=null){ 	MessageReader mr=new MessageReader();
				%>
		<tr>
					<td class="<%=style %>"> 
					<a href="javascript:parent.loadResult('<%=((LcStdLinenQtyVw)result).getId().getLinenItem()%>','<%=((LcStdLinenQtyVw)result).getId().getOperatingFacilityId()%>','<%=((LcStdLinenQtyVw)result).getId().getSourceCode()%>','<%=((LcStdLinenQtyVw)result).getId().getSourceType()%>')">
						<% if (((LcStdLinenQtyVw)result).getId().getSourceType().equals("W")){
						%>
						<script>getServerMessage("com.iba.ehis.lc.ward");document.write(dwrMessage)</script>
						<%
						}else if (((LcStdLinenQtyVw)result).getId().getSourceType().equals("C")){
						String str=mr.getMessage(request,"com.iba.ehis.lc.clinic");
						%>
						<script>getServerMessage("com.iba.ehis.lc.clinic");document.write(dwrMessage)</script>
						<%
						}else if (((LcStdLinenQtyVw)result).getId().getSourceType().equals("D")){
					    %>
						<script>getServerMessage("com.iba.ehis.lc.department");document.write(dwrMessage)</script>
						<%} %>
					</a>
					</td>
					<td class="<%=style %>">
						<%=((LcStdLinenQtyVw)result).getId().getSourceDesc()%>
					</td>
					<td class="<%=style %>">
						<%=((LcStdLinenQtyVw)result).getId().getShortDesc()%>
					</td>
					<td class="<%=style %>">
						<%=((LcStdLinenQtyVw)result).getId().getStdQty()%>
					</td>
					</tr> 
					<% }}catch(Exception e){e.printStackTrace();} %>
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

