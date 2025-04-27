
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 
	</STYLE>

</head>
<iframe name="ordercataegorydtls_copyfrom" id="ordercataegorydtls_copyfrom" src='../../eOR/jsp/PrivilegeGroupCopyFrom.jsp?<%=request.getQueryString()%>' framespacing="0" noresize frameborder="0"  scrolling="no" style='height:17vh;width:100vw'></iframe>
<iframe name="ordercataegorydtls_header" id="ordercataegorydtls_header" src='../../eOR/jsp/PrivilegeGroupCategoryHeader.jsp?<%=request.getQueryString()%>' framespacing="0" noresize frameborder="0"  scrolling="no" style='height:33vh;width:100vw'></iframe>
<iframe name="ordercataegorydtls_result" id="ordercataegorydtls_result" src='../../eOR/jsp/PrivilegeGroupCategoryResult.jsp?<%=request.getQueryString()%>' framespacing="0" noresize frameborder="0"  scrolling="auto" style='height:54vh;width:100vw'></iframe>


</html>

