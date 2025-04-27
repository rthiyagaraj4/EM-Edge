<!DOCTYPE html>
<%@page import="java.io.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<!-- ****  Modified by Ambiga--CSS @02-02-09 **** -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/EmailRepBodyTxt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<center>
<form name='EmailRepBodyTxtListForm' id='EmailRepBodyTxtListForm'>
<%
	String code				=	"";
	String desc			=	"";	
	String module_id				=	"",report_id="",source_id="",			classValue				=	"";
	int i=0;

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet	rs = null;
	ResultSet	rs1 = null;
	module_id=request.getParameter("module_id");
	report_id=request.getParameter("report_id");
	

	try
	{
		con = ConnectionManager.getConnection(request);	
		%>	
		<table  class='grid' width="100%" align=center >
		<tr>
			<td class ='columnheader'><fmt:message key="eCA.EmailReportBodyText.label" bundle="${ca_labels}"/></td>			
		</tr>

	
<%
		String sql = "select qry_source_id from SM_REPORT_MAIL_INFO where module_id=? and report_id=?";
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,module_id);
		pstmt.setString(2,report_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			source_id=rs.getString("qry_source_id");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		String sqlStr = "select 'D_'||db_column_name col_code,nvl(user_col_desc,sys_col_desc) col_desc,2 ord_seq from sm_data_source_dtl where source_id=? UNION ALL select field_mnemonic col_code , field_mnemonic_desc col_desc,1 ord_seq from ca_mnemonic where FIELD_MNEMONIC_TYPE='MBC' order by 3,2 ";
		pstmt1	=	con.prepareStatement(sqlStr);
		pstmt1.setString(1,source_id);
		rs1 = pstmt1.executeQuery();
		%>
		<tr VALIGN="top">
		<td width="25%" class="label">
		<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<%
		
		while(rs1.next())
		{
			i++;
			/*if(i%2 != 0)
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";	*/

			classValue = "gridData";	
			code							=	rs1.getString("col_code")==null?"":rs1.getString("col_code");
			desc						=	rs1.getString("col_desc")==null?"":rs1.getString("col_desc");
			
			%>	
			
			<tr><td class="label"><a href='javascript:setPrevTemplate("<%=code%>")' class="gridLink"><%=replaceSpecialChar(desc)%></a></td>
				<td>(<%=code%>)</td>
			</tr>
		<%} %>
		</table></td>
			</tr>
		<%		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		if(rs1!=null)rs1.close();
		if(pstmt1!=null)pstmt1.close();
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

