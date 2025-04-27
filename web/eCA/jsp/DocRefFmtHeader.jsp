<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/DocRefFmt.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

	Connection con=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();
    String doc_type	=	"";
    String refno_logic	=	"";
    String doc_type_desc = "";


	try
	{
		con = ConnectionManager.getConnection();

%>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
     <form name='DocRefFmtHdrfrm' id='DocRefFmtHdrfrm' >

	 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
	 <tr>
        <td class=label><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		<td class='fields'  colspan='3'><select name='document_type' id='document_type' onchange='ShowListType()'>
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

<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
			catch(Exception e)
			{
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181		
			}
	
			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>	
</form>
</body>
</html>

