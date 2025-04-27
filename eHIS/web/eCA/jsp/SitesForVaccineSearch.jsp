<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
        request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end
	%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/SitesForVaccine.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
     <form name="sitesForVaccineSearchForm" id="sitesForVaccineSearchForm" >
	 <table  align='center' cellpadding='3' cellspacing=0 border=0 width='100%'>
		<tr><th class='columnheader' width='100%'  colspan='6' align="left"><fmt:message key="eCA.SelectSite.label" bundle="${ca_labels}"/></th></tr>
		<tr>
				<td class='gridData' width="20%"><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				<td class='fields' width="20%"><input type='text' name='searchtext' id='searchtext' size='20' maxlength='15' value="" OnKeyPress ="return CheckForSpecChars(event)">
				</input></td>
				<td class='fields' width="20%"></td>
				<td class='fields' width="20%"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		        <td class='fields' width="20%"><select name='search_criteria' id='search_criteria'>
			    <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			    <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			    <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			
			    </select></td>
				<td align=right><input type='button' name='search' id='search' class='Button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' OnClick="populateValues()"></input>&nbsp;
				</td>
		</tr>
	</table>
	<!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
	
	</form>
</body>
</html>


