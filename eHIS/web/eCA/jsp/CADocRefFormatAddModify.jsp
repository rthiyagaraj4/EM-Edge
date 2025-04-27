<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;

StringBuffer sql = new StringBuffer();
String doc_type	=	"";
String refno_logic	=	"";
String doc_type_desc = "";


try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/CADocRefFormat.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >
<form name="CADocRefFormatModify_form" id="CADocRefFormatModify_form" action="../../servlet/eCA.CADocRefFormatServlet" method="post" target="messageFrame">

<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
	<table cellpadding='10' cellspacing='0' border='0' width='80%' align='center'>

<tr>
	<td class=label><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
	<td class='fields'  colspan='3'><select name='document_type' id='document_type' onchange='showRefNum(this)'>
		<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>	
	<%
	    sql = new StringBuffer();	
		sql.append("select DOC_TYPE,DOC_TYPE_DESC,DOC_TYPE_REF_FORMAT from CA_DOC_REFERENCE");

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			doc_type = rs.getString("DOC_TYPE") == null ? "" : rs.getString("DOC_TYPE");
			doc_type_desc = rs.getString("DOC_TYPE_DESC") == null ? "" : rs.getString("DOC_TYPE_DESC");			
			refno_logic = rs.getString("DOC_TYPE_REF_FORMAT") == null ? " " : rs.getString("DOC_TYPE_REF_FORMAT");			
		%>
			<option value='<%=doc_type%>' id='<%=refno_logic%>'><%=doc_type_desc%></option>
		<%}
			
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
	</table>
	<table cellpadding='10' cellspacing='0' border='0' width='80%' align='center'>
	<tr>
		<td class='label' colspan='4'>
		<a href='javascript:defineFormat("~encounter_id`")'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>(12)</a>&nbsp;&nbsp;
		<a href='javascript:defineFormat("~practitioner_id`")'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>(15)</a>&nbsp;&nbsp;
		<a href='javascript:defineFormat("~accession_num`")'><fmt:message key="eCA.AccessionNum.label" bundle="${ca_labels}"/>(24)</a>&nbsp;&nbsp;
		<a href='javascript:defineFormat("~date_and_time`")'><fmt:message key="eCA.DateAndTime.label" bundle="${ca_labels}"/>(12)</a></td>
	</tr>
</table>
<table cellpadding='10' cellspacing='0' border='0' width='80%' align='center'>
<tr>
 <td class="label"><fmt:message key="eCA.RefNumLogic.label" bundle="${ca_labels}"/></td>
    <td class='fields' colspan=4> 
    <input type="text" name="refno_logic" id="refno_logic" value="" width="30%" size="60" maxlength = '100' onkeypress='return chkTildeAndGA()' ><img src='../../eCommon/images/mandatory.gif'>
    </td>
</tr>
</table>	
</form>

</body>
</html>
<%
	
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

