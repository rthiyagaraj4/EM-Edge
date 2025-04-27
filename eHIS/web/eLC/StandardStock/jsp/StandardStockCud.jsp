<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page  import="com.iba.framework.core.util.Constants"%>

<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>
<head>
	<%		String facilityId=(String)session.getAttribute("facility_id");
			String functionId=(String)request.getParameter("functionId");
			String moduleId=(String)request.getParameter("moduleId");
			String locale=(String)session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	%>
	
	
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>		
	<Script type='text/javascript' src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script type='text/javascript' src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/Stock.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<Script type='text/javascript' src="<%=request.getContextPath()%>/eLC/StandardStock/js/StandardStock.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
<script>
function hideLabel()
{
	if( document.getElementById("method").value==2)
	{
	 var scode=document.getElementById("vo.sourceCode").value;
	 var stype=document.getElementById("vo.sourceType").value;
	 document.getElementById("vo.sourceCode").disabled=true;
	 document.getElementById("vo.sourceType").disabled=true;
     document.getElementById("search").disabled=true;
	 document.getElementById("lookup").disabled=true;
//	 alert("<%=locale%>"+"=="+"<%=facilityId%>"+" "+stype+" "+scode)
	LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",stype,scode,callBackDate1);
						function callBackDate1(data){
							for(prop in data)
							{
							val=data[prop];
							document.getElementById("sourceDesc").value=val;
							document.getElementById("sourceDesc").disabled=true;
							}
						}
	}
	else
	{
	document.getElementById("vo.sourceCode").disabled=false;
	document.getElementById("vo.sourceType").disabled=false;
	document.getElementById("search").disabled=false;
	document.getElementById("lookup").disabled=false;
	}
 document.getElementById("listContentLayer").style.visibility="hidden";
 document.getElementById("tableid").style.visibility="hidden";
}
function showLabel()
{
 document.getElementById("listContentLayer").style.visibility="visible";
 document.getElementById("tableid").style.visibility="visible";
}
</script>
</head>

<body onload="hideLabel();getStock();showLabel();"  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/StandardStockAction.do" target="messageFrame">

		<table border='0' cellpadding='2' cellspacing='0' width='75%'
			align='center'>
			<tr>
				<td>
					<table border='0' cellpadding='2' cellspacing='0' width='50%'
						align='center'>
						<tr>
							<td align="left" width="30%" CLASS='label'>
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
							</td>
							<td width="70%">
							<ibaHTML:select property="vo.sourceType" >
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
							</ibaHTML:option>
							</ibaHTML:select>
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
							<td align="left" width="30%" CLASS='label'>
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.source"
									bundle="lcLabels" />
							</td>
							<td width="70%" nowrap="nowrap">
							<input type="text" name="sourceDesc" id="sourceDesc" maxlength='40' onblur="showLabel();showLookup()" />
							<ibaHTML:hidden property="vo.sourceCode" />
							<input type='button' class='button' value='?' id="lookup" onclick='showLookup()' />
							<img src="framework/images/mandatory.gif"></img>
							&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type='button' id="search" class='button' value='Search' onclick='getStock();' />
							</td>

						</tr>
						
					</table>
				</td>
			</tr>
		</table>
	<br><br>
	
		

<center>
<%--	<div id="next" --%>
<%--			STYLE="position:absolute;right:200;top:68;color:blue;visibility:hidden;" align="right">--%>
<%--			<a href="javascript:Next()"><ibaBean:message key="com.iba.ehis.lc.next"bundle="lcLabels" /></a>--%>
<%--		</div>--%>
<%--	<div id="prev" --%>
<%--			STYLE="position:absolute;right:250;top:68;color:blue;visibility:hidden;">--%>
<%--			<a href="javascript:Prev()"><ibaBean:message key="com.iba.ehis.lc.previous"bundle="lcLabels" /></a>--%>
<%--		</div>--%>

		
	<table border='1' cellpadding='2' cellspacing='0' width='75%' id="tableid" >
						 <tr>
						 	<th align="left" colspan=2>
								<ibaBean:message key="com.iba.ehis.lc.standardStock.stdLinenItem&Qty"
									bundle="lcLabels" />
							</th>
						 </tr>
						<tr>

							<th align="center" width="50%">
								<ibaBean:message key="com.iba.ehis.lc.linenItem"
									bundle="lcLabels" />
							</th>
							<th align="center"  width="50%">
								<ibaBean:message key="com.iba.ehis.lc.stdStock"
									bundle="lcLabels" />
							</th>

						</tr>
		</table>
	<div id="listContentLayer" style="overflow: auto;height: 400px; width: 1020px;align:left">
		
					<table border='1' cellpadding='2' cellspacing='0' width='75%'
						 id="contentTable" >
						 
					</table>
				</div>
</center>	
		<ibaHTML:hidden property="method" />
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
	</ibaHTML:form>
</body>
</ibaHTML:html>


