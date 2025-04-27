<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.DiscreteMeasureSearch.label" bundle="${ca_labels}"/></title>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 09/12/2009  */
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
		{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}
		/** ends here*/
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language='javascript' src='../js/ChartComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
		String searchText = request.getParameter("searchText") ==null ? "" : request.getParameter("searchText") ;
		String chart_id = request.getParameter("chart_id")==null ? "" : request.getParameter("chart_id");
%>
		<form name="panelSearchCriteriaForm" id="panelSearchCriteriaForm">
		<br>
			<table align="center"  border="0" width="100%" cellspacing="0" cellpadding="3">
				<tr>
					<td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> <input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  colspan='2'>&nbsp;</td>
					<td  class='fields' ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
						<select name="search_criteria" id="search_criteria" onChange="loadFrames()">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
						<td   colspan=4>&nbsp;</td>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/><input type="text" name="search_text" id="search_text" size='30' maxlength='8' value="" OnKeyPress ="return CheckForSpecChars(event)"></td>
					<td  ><input type="button"  name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="searchPanelValues()"></td>
					<td   colspan=4>&nbsp;</td>
					<td >

					</td>
				</tr>
			</table>
			<!-- added by kishore kumar n on 09/12/2009  -->
			<%if(!imgUrl.equals("")){ %>
			<img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
			<!--ends here -->
			<input type='hidden' name='chartId' id='chartId' value="<%=chart_id%>">
			<%
			if(!searchText.equals(""))
			{%>
			<script>
			document.panelSearchCriteriaForm.search_text.value="<%=searchText%>"
			searchPanelValues()
			document.panelSearchCriteriaForm.Search.disabled = true;
			</script>
				
			<%}
			%>
		</form>
	</body>
</html>

