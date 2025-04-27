<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String mode			= request.getParameter("mode") ;
	String source			="";
		
		if(mode.equals("2"))
		{
			String drugCode	= request.getParameter("drugCode");
			String ageGrpCode=request.getParameter("ageGrpCode");
			source="mode="+mode+"&drugCode="+drugCode+"&ageGrpCode="+ageGrpCode;
			
		}
		else
		source="mode="+mode;
		%>
	<iframe name="TDM_attribute_header" id="TDM_attribute_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TDMAttributesCriteria.jsp?<%=source%>" style="height:36vh;width:100vw"></iframe>
	<iframe name="TDM_attribute_catalog_header" id="TDM_attribute_catalog_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TDMAttributesTitle.jsp" style="height:3vh;width:100vw"></iframe>
	<iframe name="TDM_attributes_details" id="TDM_attributes_details" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:62vh;width:100vw"></iframe>
	  </HTML>

