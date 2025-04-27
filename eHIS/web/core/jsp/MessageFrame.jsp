<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.ehis.core.vo.AppVO"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page import="com.iba.framework.cache.pojo.business.CacheManager"%>

<%
			String error=request.getParameter("error");
			if(error!=null)
			out.println(error);//out.clear();
			try{
			//This code is to refresh the page only when user operations like insert,update,delete are success
			int status=((Integer)request.getAttribute("status")).intValue();
			if (status == Constants.SUCCESS)
			out.println("<script>parent.reset()</script>");
			}catch(Exception e){}
		%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
	<%
        String queryString = (String) session.getValue( "queryString" ) ;
        String contextPath = request.getContextPath();
        if ( queryString == null ) queryString = "" ;
        out.println( "<script language='JavaScript'>if(parent.commontoolbarFrame!=null){ parent.commontoolbarFrame.location.href='"+contextPath+"/eCommon/jsp/commonToolbar.jsp?" + queryString +"' }</script>");
        
        %>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<title>MessageFrame</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

</head>
<body CLASS="MESSAGE">
	<ul>
		<ibaHTML:messages message="true" id="message" bundle="commonMesages">
			<li>
				<ibaBean:write name="message" />
			</li>
		</ibaHTML:messages>
	</ul>
</body>
</ibaHTML:html>

