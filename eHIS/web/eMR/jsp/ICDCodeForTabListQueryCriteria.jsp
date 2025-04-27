<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*"   %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	 <%
		
        Connection conlConn = null;
		java.sql.Statement stmt = null;
		ResultSet rstlRs = null;
		
        
		
		
	try
	{
	   conlConn = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{
		//out.println("Exception @ ICDCodeForTabListQueryCriteria "+e.toString());
		e.printStackTrace();
	}finally{
            try
		{
            if(rstlRs != null){ rstlRs.close(); }	
			if(stmt != null){ stmt.close(); }
		}
		catch(Exception e){
			out.println("exception "+e.toString());
		}
		//ConnectionManager.returnConnection(conlConn,request);
     }
     
     
     %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eMR/js/ICDCodeForTabList.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'onload='FocusFirstElement();'>
    <form name='tabListCriteriaform' id='tabListCriteriaform' method="post" target='messageFrame'>
	<table  align='center' cellpadding='5' cellspacing=0 border='0' width='100%'>
	<tr>
		<td class='label'  ><fmt:message key="eMR.TabulationListType.label" bundle="${mr_labels}"/></td> 
		<td ><SELECT name='age_spec' id='age_spec' onChange='enbDispTablist(this)'>
		<OPTION value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</OPTION>
		<!-- <OPTION value='D'><fmt:message key="eMR.Disease.label" bundle="${mr_labels}"/></OPTION> -->
        <OPTION value='D'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></OPTION>
		<OPTION value='P'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></OPTION></SELECT><img src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' ></td>
		<td class='label' ></td>
	</tr>
	
	<tr>
		<td class='label' ><fmt:message key="eMR.TabulationList.label" bundle="${mr_labels}"/></td>
		<td class='fields'><TEXTAREA style="resize:none" type='text' ROWS="2" COLS='20' name='tabulation_list_desc' maxlength='30' onblur='call_searchCode();' disabled></TEXTAREA><input type='hidden' name='tabulation_list' id='tabulation_list' value=''><input type='button' class='button' value='?' name='search_button' id='search_button' onClick='searchCode(this,tabulation_list_desc)' disabled><img src='../../eCommon/images/mandatory.gif' id='tabulationlistgif' style='visibility:hidden'></img>
		<!-- <td class='label'> :</td> -->
        <td class='label' ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>

		<td>
		<!-- id='term_set_id'  -->
		<select name='term_set_id' id='diag_code_disp' onchange='clearPage(this)'disabled >
        <OPTION value='' selected>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
		</select><img src='../../eCommon/images/mandatory.gif' id='termsetgif' style='visibility:hidden'></img>
		</td>
	</tr>
	
	<tr><td class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td><td class='fields'><select name='searchby' id='searchby' ><option value='C'><fmt:message key="Common.code.label" bundle="${common_labels}"/></option><option value='D'><fmt:message key="Common.description.label" bundle="${common_labels}"/></option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.criteria.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<select name='searchcriteria' id='searchcriteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select></td>
	<td class='label' colspan='2'></td></tr>
	
	<tr><td class='label'><fmt:message key="eMR.SearchDesc.label" bundle="${mr_labels}"/><td class='fields' colspan='3'><input type='text' size='57' maxlength='70' name='alpha_desc' id='alpha_desc' ></td>
	</tr>
	
	<tr>
		<td class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class="fields" ><select name="orderBy" id="orderBy">
			<option value="short_desc" selected><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></option>
			<option value="term_code" ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></option>
			</select>		
		</td>
		<td class='label'></td>
		<td class='button'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search' onClick='populateResult()'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'></td>
	</tr>
	
	</table>
	<input type='hidden' name='flagvar' id='flagvar' value='querypg'>
	<!-- The following field should have value 1 for the comtrol to be passed to result page-->
	<input type='hidden' name='call_result' id='call_result' value='0'>
	<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value=''>
<!-- The New Hidden Vairables added on 3/3/2008  For passing Result Page-->
	<input type='hidden' name='Criteria_tabulation_list' id='Criteria_tabulation_list' value=''>
	<input type='hidden' name='Criteria_orderBy' id='Criteria_orderBy' value=''>
	<input type='hidden' name='Criteria_searchby' id='Criteria_searchby' value=''>
	<input type='hidden' name='Criteria_searchcrt' id='Criteria_searchcrt' value=''>
	<input type='hidden' name='Criteria_alphadescription' id='Criteria_alphadescription' value=''>
	<input type='hidden' name='Criteria_from' id='Criteria_from' value=''>
	<input type='hidden' name='Criteria_to' id='Criteria_to' value=''>
	<input type='hidden' name='Criteria_age_spec' id='Criteria_age_spec' value=''>
	<input type='hidden' name='Criteria_selectedAlpha' id='Criteria_selectedAlpha' value=''>
	<input type='hidden' name='Criteria_diag_code_scheme' id='Criteria_diag_code_scheme' value=''>

	</form>
	</body>
	</html> 

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

