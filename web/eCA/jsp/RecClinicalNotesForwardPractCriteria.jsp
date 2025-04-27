<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }			
			String speciality_id = request.getParameter("speciality_id")==null?"":request.getParameter("speciality_id");			
			String clinician_id = request.getParameter("clinician_id")==null?"":request.getParameter("clinician_id");
			String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
			String search_text = request.getParameter("search_text")==null?"":request.getParameter("search_text");
			String search_by = request.getParameter("search_by")==null?"D":request.getParameter("search_by");
			String search_criteria = request.getParameter("search_criteria")==null?"S":request.getParameter("search_criteria");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
   <script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
</head>
<body onKeyDown = 'lockKey()' onload='chk_spl_char()'>

<form name="CriteriaForm" id="CriteriaForm"  >
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr >
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"  ><fmt:message key="Common.code.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>

		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nosplchars(this);"  name="search_text" id="search_text" value="<%=search_text%>" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="onClickSearch(); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<input type="hidden" name="speciality_id" id="speciality_id" value="<%=speciality_id%>">
<input type="hidden" name="clinician_id" id="clinician_id" value="<%=clinician_id%>">
<input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
<br>
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
</form>
</body>
</html>

