<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencemodule.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form" target='applnontablecode' action='../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='40%'></td>
		<td width='30%'></td>
</tr>
<tr><td class=label><fmt:message key="eXH.NonTableValues.Label" bundle="${xh_labels}"/></td>
<%
Connection con=null;
XHSelectQuery xhSelect = null;
ArrayList arrRow = null,arrCol = null;
HashMap hashmpParams = null;
String applicationid = request.getParameter("application");
String sql = " SELECT  a.element_name, a.element_id element_id "+
" FROM xh_element_crossref_lang_vw a, xh_appl_element b "+
" WHERE a.element_id = b.element_id "+
" AND b.application_id = '"+applicationid+"'" +
" AND a.table_ID IS NOT NULL "+
" AND b.in_use_yn = 'Y'  "+
" AND crossref_type = 'S' "+
" AND a.in_use_yn = 'Y' "+
" AND a.LANGUAGE_ID='"+locale+"' "+
" ORDER BY 1 ";
 
try
{
con=ConnectionManager.getConnection(request);
xhSelect = new XHSelectQuery();
hashmpParams = new HashMap(5);
hashmpParams.put("connection",con);
hashmpParams.put("sql",sql);
hashmpParams.put("col","2");
arrRow = xhSelect.getResults(hashmpParams);
arrCol = null;	
xhSelect = null;
hashmpParams.clear();


}catch(Exception e1)
{
	System.out.println(" (DataElementCrossRefNonTableSelection.jsp : Exception-1 ) "+e1.toString());
}
%>
<td class='fields'>
<select name='nontabelementid' id='nontabelementid' >
<option value="N">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------</option>
<%
for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);
%>

	<option  value='<%=arrCol.get(1)+""%>'><%=arrCol.get(0)+""%></option>
<%
}
%>
</select> <img src='../../eCommon/images/mandatory.gif' align=middle> </td>
<td class='label'>
</td>
<td >
<input type=button class='button' name='butt_select' id='butt_select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funMasterCode()'>
</td>
<%
try
{
arrRow.clear();
arrCol.clear();

ConnectionManager.returnConnection(con);
}catch(Exception e1)
{
	System.out.println(" (DataElementCrossRefNonTableSelection.jsp : Exception-2 ) "+e1.toString());
}
%>
</tr>
<tr>
<td></td>
<td> </td>
<td></td>
</tr>
</table>
<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
</form>
</BODY>
</HTML>

