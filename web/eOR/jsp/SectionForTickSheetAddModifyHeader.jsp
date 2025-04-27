<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
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
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOR/js/SectionForTickSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()">

<%
	
	/* Mandatory checks start TickSheetForSectionAddModifyHeader.jsp */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";
	//String readOnly = "" ;
	//String disabled = "" ;
	
	// out.println("add modify");
	
	/* Mandatory checks end */
	
/*	Initialize Function specific start */
	SectionForTickSheet  bean = (SectionForTickSheet)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;   
	ArrayList orderCategory=new ArrayList();
 /*Initialize Function specific end */

%>
		
<form name="formTickSheetSectionheader" id="formTickSheetSectionheader" method="post"  target="messageFrame">
<table border="0" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">
<tr>
	<td class="label" width='50%' ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td> 

	<td class=fields width='50%'><select name="order_category" id="order_category"   onChange="parent.parent.resetLower();fillTickSheetSection(this);">
	<option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%
	orderCategory=bean.getTickSheetSectionOrderCategory();
	String[] record=null;
	for(int i=0;i<orderCategory.size(); i++){
		record = (String [])orderCategory.get(i);
		%>	
		<option value="<%=record[0]%>" ><%=record[1]%> </option>  
	<%
	}orderCategory=null;
	%> 
	 </select><img src="../../eCommon/images/mandatory.gif" align=center></img>
	  </td>
 </tr>
 <tr>
	<td class="label" width='50%'><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td> 
	<td class='fields' width='50%'>
	<select name="tick_sheet" id="tick_sheet">
	<option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>

</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="function_id" id="function_id" value="Tick_sheet_Section">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

