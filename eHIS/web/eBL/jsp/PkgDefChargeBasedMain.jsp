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
		
	 
<iframe name='ChargeBasedDtlHdr' id='ChargeBasedDtlHdr'	src='PkgDefChargeBasedHdr.jsp?'  frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='ChargeBasedDtl' id='ChargeBasedDtl'	src='PkgDefChargeBased.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:33vh;width:100vw'></iframe>
		<iframe name='ChargeBasedBtn' id='ChargeBasedBtn' src="../../eBL/jsp/PkgDefChargeBasedBtn.jsp?<%=params%>' &table_name=pkgCbased&func_mode=CHARGE_BASED" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='ChargeBasedExCln' id='ChargeBasedExCln'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='auto' style='height:40vh;width:100vw'> </iframe>
		<iframe name='ChargeBasedItemBtn' id='ChargeBasedItemBtn' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
			
			<!-- <iframe name='ChargeBasedExCln' id='ChargeBasedExCln'	src='PkgDefChargeBasedExclusion.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize></iframe>  -->
		

</HTML>

