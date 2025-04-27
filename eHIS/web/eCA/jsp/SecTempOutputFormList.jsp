<!DOCTYPE html>
<%@page import="java.io.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Arvind @ 08-12-08 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/SecTempOutputForm.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<center>
<form name='SecTempOutputFormListForm' id='SecTempOutputFormListForm'>
<%
	String compSrl				=	"";
	String comp_type				=	"";
	String section				=	"",					classValue				=	"";
	//String update_sql				=	"";		
	String prompt_text			=	"";	
	String contentType			=	"";
	
	int i=0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;
	section=request.getParameter("section");
	contentType=request.getParameter("contentType");

	try
	{
		con = ConnectionManager.getConnection(request);	
		%>	
		<table  class='grid' cellpadding=3 cellspacing=0 border=1 width="100%" align=center >
		<tr align="left">
			<th class ='columnheader'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></th>			
		</tr>

	
<%
		String sql = "select COMP_ID||SRL_NO compSrl,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT,COMP_TYPE from CA_SECTION_DISCR_MSR_VW where ITEM_TYPE='C' and SEC_HDG_CODE=?";
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,section);
		rs = pstmt.executeQuery();
		%>
		<tr VALIGN="top">
		<td width="25%" class="label">
		<table  cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<%
		while(rs.next())
		{
			i++;
			if(i%2 != 0)
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";	
			
			compSrl							=	rs.getString("compSrl")==null?"":rs.getString("compSrl");
			
			prompt_text						=	rs.getString("PROMPT_TEXT")==null?"":rs.getString("PROMPT_TEXT");
			comp_type						=	rs.getString("COMP_TYPE")==null?"":rs.getString("COMP_TYPE");
			compSrl="C_"+comp_type+"_"+compSrl;
			
			%>	
			
			<tr><td class="gridData"><a class='gridLink'  href='javascript:setPrevTemplate("<%=compSrl%>")'><%=replaceSpecialChar(prompt_text)%></a></td>
				<td class="gridData">(<%=compSrl%>)</td>
			</tr>
		<%} %>
		</table></td>
			</tr>
		<%		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	} // end of try
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>
</table>
</form>
</center>
</body>
</html>
<%!		
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","&quot;");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","&#39;");
		if(resultStr.indexOf("<")!=-1)
			resultStr = resultStr.replaceAll("<","&lt;");
		if(resultStr.indexOf(">")!=-1)
			resultStr = resultStr.replaceAll("<","&gt;");
		
		return resultStr;
	}
%>

