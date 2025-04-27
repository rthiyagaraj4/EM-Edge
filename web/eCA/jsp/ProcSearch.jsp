<!DOCTYPE html>
<%@ page import="java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript" src='../js/ProcedureList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String queryString=request.getQueryString();
	String search_text="";
%>
</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<script>
function valtext(comp)
 {
var scheme_val = document.forms[0].qry_string.value;
	  var txt=comp.value
	 if (comp.value=="" || comp.value==null)
		alert(getMessage("SEARCH_TEXT_BLANK","Common"));
	  	 else
		CallDescFrame(this);
}

 function valtext1(comp)
 {
	 var txt=comp;
		CallDescFrame(this);
}
	
function CallDescFrame()
{
	var listval=document.forms[0].search_criteria.options.value;
	var txtbox=document.forms[0].search_text.value;

parent.code_desc.location.href='../../eCA/jsp/ProcSearchResult.jsp?<%=queryString%>&search_by='+radioval+'&search_criteria='+listval+'&search_text='+txtbox
 }


</script>

<form name="proc" id="proc">
<table align='center'  border="0" width='100% cellspacing='0' cellpadding='3'>
	<tr width='100'>
		<td>&nbsp;&nbsp;</td>
		<td colspan=2  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'>Description
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/> <fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		<select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		</select>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;</td>
		<td class='label' colspan=2  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		<input type="text"  name="search_text" id="search_text" value='<%=search_text%>' width=30%  size='40' maxlength='70'  onkeypress="return CheckForSpecChars(event)">
		<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td class ="fields"><input type="button" width='20%'  name="Search" id="Search" value="Search" onClick="valtext(search_text); " class='button' >
		</td>
	</tr>
</table>
<BR>
<BR>
<input type='hidden' name='qry_string' id='qry_string' value='<%=queryString%>'></input>
</form>
</body>
</html>

