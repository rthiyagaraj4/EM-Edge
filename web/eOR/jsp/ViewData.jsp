<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Item Narration</title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--  added for IN051127 -->
	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
<%
String bean_id = "Or_ViewOrder" ;
String bean_name = "eOR.ViewOrder";
//String line = request.getParameter( "line" ) ; - Commented for IN049419
ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(localeName);
String l_order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
String l_order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
String l_action_seq_num = request.getParameter( "action_seq_num" )==null?"":request.getParameter( "action_seq_num" ) ;
String l_action = request.getParameter( "action" )==null?"":request.getParameter( "action" ) ;
java.sql.Connection			con		=	null;
java.sql.PreparedStatement	stmt		=	null;
java.sql.ResultSet rset = null;
String sql = "";

if("OLD_DTL".equals(l_action))
	sql = "select FIELD_VALUE_OLD_FREE_FMT CLOB_DTL from or_order_action where order_id = ? and order_line_num = ? and ACTION_SEQ_NUM =?";
else if("NEW_DTL".equals(l_action))
	sql = "select FIELD_VALUE_NEW_FREE_FMT CLOB_DTL from or_order_action where order_id = ? and order_line_num = ? and ACTION_SEQ_NUM =?";

StringBuffer displaydata = null;
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(sql);
	stmt.setString(1, l_order_id);
	stmt.setString(2, l_order_line_num);
	stmt.setString(3, l_action_seq_num);
	
	rset = stmt.executeQuery();

	if(rset.next())
	{
		Clob note=rset.getClob("CLOB_DTL");

		displaydata = new StringBuffer();
		if(note!=null)
		{
			java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) 
				displaydata.append(line+"\n");
		}	
	}
}
catch(Exception e)
{
	e.printStackTrace();	
}
finally
{
	if(stmt!=null)
		stmt.close();
	if(rset!=null)
		rset.close();
	if(con!=null)	
		ConnectionManager.returnConnection(con,request);
}
%>
 <div class="outer-container" style='width:640px;height:435px'>
    <div class="top-section" style='width:640px;height:435px;overflow:auto'>
		<table cellpadding='3' cellspacing='0' border='0' align='center' width="100%">			
			<tr>
			  <td>
				<%=displaydata%>
			  </td>
			</tr>
		</table>
    </div>
 </div>
<table  cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<tr>
<td class='button' colspan='2' align='right'>
<INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'>
</td>
</tr>
</table>
</FORM>
</BODY>
</HTML>

