<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*,java.net.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
	<%--<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>--%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
/* Mandatory checks end */

/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name ,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;

	//Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	//hash = (Hashtable)hash.get( "SEARCH" ) ;
/* Initialize Function specific end */
   
	String templateText = request.getParameter("templateText");
	//System.out.println("======="+templateText);
	String row_index = request.getParameter("row_index");%>
	<!--<script>alert("Template text <%=templateText%>");</script>-->
	<%
	//String templateText = (String)hash.get("templateText");
	//String row_index = (String)hash.get("row_index");

	if(templateText==null)	templateText = "";
	if(row_index==null)	row_index="";
	//System.out.println(templateText);
	//System.out.println(templateText.length());
	//boolean check = bean.setResultData(row_index, templateText);
	//bean.setResultData(row_index,  java.net.URLDecoder.decode(templateText),"UTF-8");
	bean.setResultData(row_index,  templateText);
	//String val = bean.getResultData(row_index);
	out.println("<script>parent.window.returnValue = 'B';parent.window.close();</script>");
	putObjectInBean(bean_id,bean,request);
%>
