<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<iframe name='' id=''	src=""  frameborder='0' noresize scrolling='no' style='height:0vh;width:100vw'>
	<!--FRAME name='basePriceHdrFrame'	src="../../eBL/jsp/PkgbasePriceHdr.jsp"  frameborder='0' noresize scrolling='no'>--></iframe>
	<iframe name='basePriceDtl' id='basePriceDtl'	src="../../eBL/jsp/PkgDefBasePrice.jsp?<%=params%>"  frameborder='0' noresize scrolling='auto' style='height:69vh;width:100vw'></iframe>
		<!--</iframe>
		<iframe name='basePriceBtn' id='basePriceBtn' src="../../eBL/jsp/PkgDefBasePriceBtn.jsp?<%=params%>' &table_name=pkgPrice&func_mode=PACKAGE_PRICE" frameborder='0' noresize scrolling='no'>--></iframe>
		<iframe name='basePriceBtn' id='basePriceBtn' src="../../eBL/jsp/PkgDefBasePriceBtn.jsp?<%=params%> &table_name=pkg_base_tbl&func_mode=PACKAGE_PRICE" frameborder='0' noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
</HTML>

