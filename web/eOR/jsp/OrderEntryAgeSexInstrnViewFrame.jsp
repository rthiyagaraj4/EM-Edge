<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
*/
%>
<%@page import="eOR.*, java.sql.*,webbeans.eCommon.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
<% 
	request.setCharacterEncoding("UTF-8");
	eOR.OrderEntryQueryBean queryBean = (eOR.OrderEntryQueryBean)getObjectFromBean("instrn","eOR.OrderEntryQueryBean",session);
	String catalogCode =  request.getParameter("catalogCode");
	String key =  request.getParameter("key");
	String indexStr = request.getParameter("index");
	int index = Integer.parseInt(indexStr);
	LinkedHashMap<String, LinkedHashMap<String,ArrayList>> allValues= queryBean.getTextInstruction();
	ArrayList getDetails = allValues.get(catalogCode).get(key);
	String tableValues[] = (String[])getDetails.get(index);
	String textComments = tableValues[8];
%>
<table cellpadding=3 cellspacing=0 border=0 width='100%' style="border-top-style:solid;border-top-color:grey;border-width: thin;margin-top:10px;">
	<tr>
		<%
		if("".equals(textComments))
		{
		%>
			<td class='label'>APP-000052 No Records Found....</td>
		<%
		}
		else
		{
		%>
			<td><%=textComments%></td>
		<%
		}
		%>		
	</tr>
</table>
