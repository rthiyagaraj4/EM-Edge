<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";

			%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	
	<script>
	function resetResult()
	{
		parent.lookupResult.location.href = contextPath + "/core/jsp/blank.jsp"
	}
	</script>
</head>
<body>
	<ibaHTML:form action="/LookupAction.do" target="lookupResult">
		<table border="0" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<td class="label">
					<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.searchBy" />
				</td>
				<td class="label">
	<ibaHTML:radio
		property="vo.lookupParameters(searchBy)" value="code">
	</ibaHTML:radio>
	<%System.out.println("request Header===="+request.getParameter("code"));%>
	<c:choose>
		<c:when test='<%=request.getParameter("code")!=null %>'>
		 <%=request.getParameter("code") %>
		</c:when>
		<c:otherwise>
		<ibaBean:message bundle="commonLabels"
				key="com.iba.ehis.core.code" />
		</c:otherwise>
		</c:choose>


		<!-- <ibaHTML:radio
		property="vo.lookupParameters(searchBy)" value="description" >
		</ibaHTML:radio>-->
		 <input type="radio" name="vo.lookupParameters(searchBy)" id="vo.lookupParameters(searchBy)" value="description"  checked="checked"/>
	
		<c:choose>
		<c:when test='<%=request.getParameter("desc")!=null %>'>
		 <%=request.getParameter("desc") %>
		</c:when>
		<c:otherwise>
		<ibaBean:message bundle="commonLabels"
				key="com.iba.ehis.core.description" />
		</c:otherwise>
		</c:choose>
				</td>
				<td class="label">
					<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.searchCriteria" />
				</td>
				<td class="label">
					<ibaHTML:select property="vo.lookupParameters(searchCriteria)">
						<ibaHTML:option value="601">
							<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.startsWith" />
						</ibaHTML:option>
						<ibaHTML:option value="602">
							<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.endsWith" />
						</ibaHTML:option>
						<ibaHTML:option value="603">
							<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.contains" />
						</ibaHTML:option>
					</ibaHTML:select>
				</td>
			</tr>
			<tr>
				<td class="label">
					<ibaBean:message bundle="commonLabels" key="com.iba.ehis.core.searchText" />
				</td>
				<td class="label">
					<ibaHTML:text property="vo.lookupParameters(searchText)" size="40" maxlength="70"></ibaHTML:text>

				</td>
				<td>
					&nbsp;
				</td>
				<td>
					<input type="Button" value='<ibaBean:message bundle="commonLabels"	key="com.iba.ehis.core.execute" />' onClick="this.form.submit()" class="button" name="search" />
					<input type="reset" value='<ibaBean:message bundle="commonLabels"	key="com.iba.ehis.core.reset" />' class="button" name="reset" onClick="return resetResult()" />
				</td>
			</tr>

		</table>

		<script type="text/javascript">
		
						document.writeln("<input type='hidden' name='vo.queryId' id='vo.queryId' value='"+top.dialogArguments[0]+"'>");
					for(i=0;i<top.dialogArguments[1].length;i++){
						
						document.writeln("<input type='hidden' name='vo.lookupParameters("+top.dialogArguments[1][i]+")' id='vo.lookupParameters("+top.dialogArguments[1][i]+")' value='"+top.dialogArguments[2][i]+"'>");
					}
					
					document.writeln("<input type='hidden' name='vo.lookupParameters(displayOrder)' id='vo.lookupParameters(displayOrder)' value='"+top.dialogArguments[3]+"'>");
					document.writeln("<input type='hidden' name='vo.lookupParameters(displayLink)' id='vo.lookupParameters(displayLink)' value='"+top.dialogArguments[4]+"'>");
					
					if(dialogArguments[5] =="**")	top.dialogArguments[5]="";
										
					document.LookupForm["vo.lookupParameters(searchText)"].value=top.dialogArguments[5];
					if(top.dialogArguments[5])
					
					
					//kumar added
			
					if(top.dialogArguments["DESC"]!=undefined && top.dialogArguments["CODE"]!=undefined){
						
					document.writeln("<input type='hidden' name='vo.lookupParameters(DESC)' id='vo.lookupParameters(DESC)' value='"+top.dialogArguments["DESC"]+"'>");
					document.writeln("<input type='hidden' name='vo.lookupParameters(CODE)' id='vo.lookupParameters(CODE)' value='"+top.dialogArguments["CODE"]+"'>");
						}
					
					if(dialogArguments[7] != undefined){
						for(i=0;i<top.dialogArguments[7].length;i++){
							document.writeln("<input type='hidden' name='vo.lookupResultHeaders' id='vo.lookupResultHeaders' value='"+top.dialogArguments[7][i]+"'>");
						}
					}
					document.LookupForm["search"].click();

			</script>
	</ibaHTML:form>
</body>
</ibaHTML:html>

