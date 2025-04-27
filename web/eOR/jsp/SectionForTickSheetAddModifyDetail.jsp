<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/SectionForTickSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";
	int totalRecords=0;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	
%>
<form name='tick_sheet_section_dtl' id='tick_sheet_section_dtl' target='messageFrame' >

	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Tick_Sheet_Section">
	<input type="hidden" name="order_category_id" id="order_category_id" value="">
	<input type="hidden" name="tick_sheet_id" id="tick_sheet_id" value="">

<table class='grid' width='100%'>

<tr><th class=columnheadercenter colspan=4><fmt:message key="Common.Section.label" bundle="${common_labels}"/></th></tr>
<tr>
<th class='columnheader' width='15%' align=left><fmt:message key="Common.code.label" bundle="${common_labels}"/></th> 
<th class='columnheader' width='35%' align=left><fmt:message key="Common.description.label" bundle="${common_labels}"/></th> 
<th class='columnheader' width='20%' align=left> <fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th> 
<th class='columnheader' width='10%' align=left><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 
</tr>

<%
int i = 0;
while(i < totalRecords){

	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
		  %>
<tr >
	<td class='<%=classValue%>'>
		  <input type=text name="tick_sheet_section_sec<%=i%>" id="tick_sheet_section_sec<%=i%>" onBlur="ChangeUpperCase(this);resetColorCode(this);" onkeypress="return CheckForSpecChars(event)"  size=4 maxlength=4 value=""
		>
			  <%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%></td>

	<td class='<%=classValue%>'>
	<input type="text" name="tick_sheet_section_dsec<%=i%>" id="tick_sheet_section_dsec<%=i%>" onBlur = "resetColorCode(this); return makeValidString(this); "  size=30 maxlength=30 value="">
		<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%></td>

	<td class='<%=classValue%>'>
	<input type=text name="seq_no<%=i%>" id="seq_no<%=i%>" value="" size=2 maxlength=2 onKeyPress='return OrAllowPositiveNumber()' onBlur="checkPositiveNumber(this); resetColorCode(this)">
		<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%></td>

	<td class='<%=classValue%>'>
	<input type="checkbox" name="eff_status<%=i%>" id="eff_status<%=i%>" value="E" checked  ></td>
</tr >
<%
		i++;
	}
	%>
 </table>
<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
  </form>
 </body>
</html>

