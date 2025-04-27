<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD>  
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>

<script language='javascript' src='../../eXI/js/AmendNewInterfaced.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script> 
function funSearchOption()
{
	parent.frames[3].document.location.href='../../eCommon/jsp/MstCodeError.jsp'; 
var item=document.forms[0].item_code.value;
var search_criteria=document.forms[0].search_criteria.value;
parent.f_query_add_mod.document.location.href='../../eXI/jsp/AmendNewinterfaceItemQueryResultPage.jsp?item_code='+item+'&search_criteria='+search_criteria;
}
 
</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form" target='appltablecode' >

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
		<td width='25%'></td>
		<td width='45%'></td> 
	
</tr>
<tr>
<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="item_code"  name =item_code style="width:200" maxlength=20 value='' > 
 <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
        </select>
</td> 
<td>
<input type=button class='button'  name='butt_select' id='butt_select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearchOption();'>
</td>


</tr>
<tr>
<td></td>
<td> </td>
<td></td>
</tr>
</table>


</form>

</BODY>
</HTML

