<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	try
	{
		//Added V190821-MuthuN/NMC-JD-SCF-0015
		Connection con	= null;
		boolean siteSpecNMC = false;
		con	=	ConnectionManager.getConnection(request);
		siteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");
		//Added V190821-MuthuN/NMC-JD-SCF-0015
		String params = request.getQueryString();
%>
<%if(siteSpecNMC){%>
	<title><fmt:message key="eBL.VAT_SERV_CHAGE_DTLS.label" bundle="${bl_labels}"/></title>
<%} else {%>
	<title><fmt:message key="eBL.ADDL_SERV_CHAGE_DTLS.label" bundle="${bl_labels}"/></title>
<%}%>
	
		<iFRAME name='addl_serv_charge_dtl' id='addl_serv_charge_dtl' SRC="../../eBL/jsp/BLAddlServChargeDtls.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:75vh;width:98vw'></iFRAME>  
<!--		
		<FRAME name='addl_serv_charge_dtl_btn' id='addl_serv_charge_dtl_btn' SRC="../../eBL/jsp/BLAddlServChargeDtlsBtn.jsp" frameborder=0 scrolling='no' noresize> 	
-->
		<iFRAME SRC="../../eCommon/html/blank.html"	  name="addl_serv_charge_dtl_btn" id="addl_serv_charge_dtl_btn" frameborder=0 noresize scrolling='no' style='height:20vh;width:98vw'></iFRAME> 	
		<iFRAME SRC="../../eCommon/html/blank.html"	  name="validation_frame" id="validation_frame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iFRAME> 
	

<%
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		out.println("from main :"+ee);
	}
%>
</HTML>

