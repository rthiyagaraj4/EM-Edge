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
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	 

		<iframe name='blng_grp_base_price_dtl_hdr' id='blng_grp_base_price_dtl_hdr'	src='PkgDefBlngGrpBasePriceHdr.jsp?<%=params%>'  frameborder='0' noresize scrolling='AUTO' style='height:20vh;width:100vw'></iframe>
		<iframe name='blng_grp_base_price_dtl' id='blng_grp_base_price_dtl'	src='PkgDefBlngGrpBasePrice.jsp?<%=params%>'  frameborder='0' noresize scrolling='auto' style='height:62vh;width:100vw'></iframe>
		<iframe name='blng_grp_base_price_btn' id='blng_grp_base_price_btn' src="../../eBL/jsp/PkgDefBlngGrpBtn.jsp?<%=params%>&table_name=blng_grp_base_price_tbl&func_mode=BLNG_GRP_PRICE" frameborder='0' noresize scrolling='no' style='height:18vh;width:100vw'></iframe>

</HTML>

