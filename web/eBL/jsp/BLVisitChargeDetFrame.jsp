<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@  page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
	String calling_module_id = request.getParameter("calling_module_id");
	if(calling_module_id == null) calling_module_id="";
//System.err.println("calling_module_id frame :"+calling_module_id);
	if(calling_module_id.equals("MP"))
	{
%>
<title><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></title>
<%
	}
	else
	{
%>
<title><fmt:message key="eBL.VISIT_CHARGE_DTL.label" bundle="${bl_labels}"/></title>
<%
	}
%>


	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/* Added V190403-Aravindh/GHL-CRF-0525/Starts */
		Connection con = null;
		boolean chkOrderCtlgAmt = false;
		try {
			con = ConnectionManager.getConnection(request);
			chkOrderCtlgAmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_CALC_AMT_ORD_CTLG_YN");
		} catch(Exception ex) {
			System.err.println("Error in BLVisitChargeDetFrame.jsp: "+ex);
			ex.printStackTrace();
		} finally {
			if(con != null) {
				ConnectionManager.returnConnection(con);
			}
		}
		/* Added V190403-Aravindh/GHL-CRF-0525/Ends */
	%>



	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<% if(chkOrderCtlgAmt && "OP".equals(calling_module_id)) {%>
<iframe  src='../../eBL/jsp/BLVisitChargeDetGHL.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling=auto style='height:100vh;width:100vw'></iframe>
	<% } else { %> 
	<iframe  src='../../eBL/jsp/BLVisitChargeDet.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling=no  style='height:100vh;width:100vw'></iframe>
	<% } %>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame1' id='DummyFrame1' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</head>

</html>

