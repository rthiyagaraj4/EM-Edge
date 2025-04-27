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
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	 

		<iframe name='blng_grp_charge_based_dtl_hdr' id='blng_grp_charge_based_dtl_hdr'	src='../../eBL/jsp/PkgDefBlngGrpChargeBasedHdr.jsp?<%=params%>'  frameborder=0 noresize scrolling='no' style='height:24vh;width:100vw'></iframe> 
		<iframe name='blng_grp_charge_based_dtl' id='blng_grp_charge_based_dtl'	src='PkgDefBlngGrpChargeBased.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:27vh;width:100vw'></iframe>
		<iframe name='blng_grp_charge_based_btn' id='blng_grp_charge_based_btn' src="../../eBL/jsp/PkgDefBlngGrpBtn.jsp?<%=params%>&table_name=blng_grp_charge_based_tbl&func_mode=BLNG_GRP_CHARGE_BASED" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='blng_grp_charge_based_excl_hdr' id='blng_grp_charge_based_excl_hdr'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'> </iframe>
		<iframe name='blng_grp_charge_based_excl' id='blng_grp_charge_based_excl'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' style='height:33vh;width:100vw'> </iframe>
		<iframe name='blng_grp_charge_based_excl_btn' id='blng_grp_charge_based_excl_btn' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
			
			<!-- <iframe name='ChargeBasedExCln' id='ChargeBasedExCln'	src='PkgDefChargeBasedExclusion.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize></iframe>  -->
		

</HTML>

