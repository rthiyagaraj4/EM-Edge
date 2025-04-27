<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	 

		<iframe name='cust_charge_based_dtl_hdr' id='cust_charge_based_dtl_hdr'	src='../../eBL/jsp/PkgDefCustChargeBasedHdr.jsp?<%=params%>'  frameborder=0 noresize scrolling='no' style='height:24vh;width:100vw'> 
		<iframe name='cust_charge_based_dtl' id='cust_charge_based_dtl'	src='PkgDefCustChargeBased.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:27vh;width:100vw'></iframe>
		<iframe name='cust_charge_based_btn' id='cust_charge_based_btn' src="../../eBL/jsp/PkgDefCustBtn.jsp?<%=params%>&table_name=cust_charge_based_tbl&func_mode=CUST_CHARGE_BASED" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'>
		<iframe name='cust_charge_based_excl_hdr' id='cust_charge_based_excl_hdr'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'> 
		<iframe name='cust_charge_based_excl' id='cust_charge_based_excl'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' style='height:33vh;width:100vw'> 
		<iframe name='cust_charge_based_excl_btn' id='cust_charge_based_excl_btn' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'>
			
			<!-- <iframe name='ChargeBasedExCln' id='ChargeBasedExCln'	src='PkgDefChargeBasedExclusion.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize></iframe>  -->
		

</HTML>

