<!DOCTYPE html>
<%@ page import="eBL.*,oracle.sql.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
		String docNumList=request.getParameter("docNumList");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<HTML>
<HEAD>
<TITLE>
</TITLE>
</HEAD>
</HEAD>
<BODY>
<FORM name='BillSlmtServiceSelectedListForm' id='BillSlmtServiceSelectedListForm' id='BillSlmtServiceSelectedListForm'>
<table> 
<tr width='100%'>
	<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.IRBBillNo.label" bundle="${bl_labels}"/></td>
</tr>

<% 
StringTokenizer st=new StringTokenizer(docNumList,","); 
while(st.hasMoreTokens()){
%>
<tr>
<td class="fields"  width='10%'><%=st.nextToken()%></td>
</tr>
<%} %>
</table>

</FORM>
</BODY>
</HTML>
</div>

