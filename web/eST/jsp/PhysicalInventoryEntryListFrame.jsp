<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" eST.*,eST.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
			
		PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean)getBeanObject("physicalInventoryEntryBean","eST.PhysicalInventoryEntryBean",request);
		bean.setLanguageId(locale);
		//String index=request.getParameter("index");
%>
<html>
	<head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	</head>
<%
	putObjectInBean("physicalInventoryEntryBean",bean,request);
%>
		<iframe name='framePhysicalInventoryEntryListHeader' id='framePhysicalInventoryEntryListHeader'	src="../../eST/jsp/PhysicalInventoryEntryApplyValues.jsp?fromDB=yes&<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:60vh;width:100vw'></iframe>
		<iframe name='framePhysicalInventoryListDetail' id='framePhysicalInventoryListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:35vh;width:100vw'></iframe>
 
	
</html>

