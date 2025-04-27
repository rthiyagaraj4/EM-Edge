<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.TasksSearch.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");	%>
		<%
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
					/** added by kishore kumar n on 08/12/2009  */
			String imgUrl="";

			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
			 /** ends here*/
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src='../js/ApplicationTask.js'				language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>	
	<form name="TaskSearchForm" id="TaskSearchForm">
	<br>
			<table align="center"  border="0" width="100%" cellspacing="0" cellpadding="3">
				<tr>
				<td  class='label' ><fmt:message key="Common.Tasks.label" bundle="${common_labels}"/></td>
				<td  class ='fields'>
						<select name="search_criteria" id="search_criteria" onChange="loadFrames()">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class ='label'><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="search_text" id="search_text" size='13' maxlength='8' value="" OnKeyPress ="return CheckForSpecChars(event)"></td>
					<td colspan=2></td>
					</tr>
					<tr>
					<td class='label' ><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name="applicable" id="applicable" onChange="loadFrames()">
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="A"><fmt:message key="eCA.Checked.label" bundle="${ca_labels}"/></option>
							<option value="X"><fmt:message key="eCA.Unchecked.label" bundle="${ca_labels}"/></option>
						</select>
					</td>
					<td colspan=2></td>
					<td >
						<input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="selectValues()">
					</td>
				</tr>
			</table>
			<!-- added by kishore kumar n on 08/12/2009  -->
			<%if(!imgUrl.equals("")){ %>
				 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
				<!--ends here -->	
		</form>
	</body>
</html>

