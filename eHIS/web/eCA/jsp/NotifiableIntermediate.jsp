<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
12/05/2015	IN053733		Ramesh G		When a notifiable recorded against a notifiable diagnosis is marked in error, 
											the notification to be de-linked from the parent diagnosis								 
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.io.*,java.sql.*,com.lowagie.text.*,com.lowagie.text.html.simpleparser.*,com.lowagie.text.pdf.*,org.w3c.dom.Document,org.w3c.tidy.Tidy,org.xhtmlrenderer.pdf.ITextRenderer,org.xml.sax.SAXException,com.lowagie.text.DocumentException,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
String sessionNFKey =  request.getParameter( "sessionNFKey" )==null?"":request.getParameter( "sessionNFKey" );;
try{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		
		System.out.println("-------------------------------->"+request.getSession().getAttribute(sessionNFKey));
		out.println(request.getSession().getAttribute(sessionNFKey));
		
	}catch(Exception e){		
		e.printStackTrace();
	}
%>
