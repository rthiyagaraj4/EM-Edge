<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat,eXH.InterfaceUtil,java.io.*,java.util.*,java.net.*,java.lang.*" contentType="text/html;charset=UTF-8"  %>
<html>
<head>
<title> <%= request.getParameter("title")%></title>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String calling_module_id= request.getParameter("calling_module_id");
		if(calling_module_id==null) calling_module_id="";
		String package_enabled_yn= request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null) package_enabled_yn="N";
		String rows="*,0%,0%,0%,0%";
		String moduleIdCheck = InterfaceUtil.checkModuleIdForPayerEligibility(calling_module_id);
		if(package_enabled_yn.equals("Y") && (calling_module_id.equals("OP") || calling_module_id.equals("IP") || "Y".equals(moduleIdCheck)) ){
			rows="85%,0%,0%,5%,5%,5%";		
		}
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!--<frameset rows='100%,0%,0%' border=0>-->
<frameset rows='<%=rows%>' border=0>
		
		<frame  src="../../eBL/jsp/AddModifyPatFinDetailsInsBodyEdit.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling="auto">
	
<!--		<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize> -->
		<FRAME SRC="../../eBL/jsp/BLInsuranceValidations.jsp" frameborder=0 name='ValidFrame' id='ValidFrame' scrolling='no' noresize> 
		<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize>
		<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='PayerDtls' id='PayerDtls' scrolling='auto' noresize>
		<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='PkgDtls' id='PkgDtls' scrolling='auto' noresize>
		<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='PkgDiscDtls' id='PkgDiscDtls' scrolling='auto' noresize>
</frameset>
</head>

</html>

