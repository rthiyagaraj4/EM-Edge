<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History               Name                        Description
--------------------------------------------------------------------------------------------------------------------
25/07/2024    45057      Gunasekar      M.f.mohamed Ali        ML-MMOH-CRF-1704
--------------------------------------------------------------------------------------------------------------------
-->

<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String item_code = request.getParameter("item_code") == null ? "" : request.getParameter("item_code");
    String fm_store_code = request.getParameter("fm_store_code") == null ? "" : request.getParameter("fm_store_code");
	String move_year = request.getParameter("move_year") == null ? "" : request.getParameter("move_year");
	String move_year1 = request.getParameter("move_year1") == null ? "" : request.getParameter("move_year1");
	String move_month = request.getParameter("move_month") == null ? "" : request.getParameter("move_month");
	String language_id = request.getParameter("language_id") == null ? "" : request.getParameter("language_id");
	String store_code_from = request.getParameter("store_code_from") == null ? "": request.getParameter("store_code_from");
	String store_code_to = request.getParameter("store_code_to") == null ? "": request.getParameter("store_code_to");
	String cost_access = request.getParameter("cost_access") == null ? "" : request.getParameter("cost_access");
	String validate = request.getParameter("validate") == null ? "" : request.getParameter("validate");
	String dflt_facility_id	      =		request.getParameter("dflt_facility_id")==null?"":request.getParameter("dflt_facility_id");		
%>

<html>

<head>
<%
	request.setCharacterEncoding("UTF-8");

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/StCommon.js"></script>
<script language="JavaScript" src="../js/StockStatusByItem.js"></script>
<title>
<%if(validate.equals("DisplyFromStores")){%>
<fmt:message key="eST.StorewiseFloorStockConsumption.label" bundle="${st_labels}"/> <%=move_month%>/<%=move_year%></title>
<%} else if(validate.equals("DisplyToStores")){%>
<fmt:message key="eST.FloorStockStoreWise.label" bundle="${st_labels}"/></title>	
<%}%>
</head>

<frameset rows="0,*">
	<frame name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0">
	<%if(validate.equals("DisplyFromStores")){%>
	<frame name="detailsFrame" id="detailsFrame" noresize src='../../eST/jsp/StockStatusByItemFloorStockFromStoreList.jsp?item_code=<%=item_code%>&move_month=<%=move_month%>&move_year=<%=move_year%>&language_id=<%=language_id%>&store_code_from=<%=store_code_from%>&store_code_to=<%=store_code_to%>&cost_access=<%=cost_access%>&dflt_facility_id=<%=dflt_facility_id%>' frameborder="0" scrolling="no">
    <%} else if(validate.equals("DisplyToStores")){%>
    <frame name="detailsFrame" id="detailsFrame" noresize src='../../eST/jsp/StockStatusByItemFloorStockToStoreList.jsp?item_code=<%=item_code%>&fm_store_code=<%=fm_store_code%>&move_month=<%=move_month%>&move_year=<%=move_year%>&language_id=<%=language_id%>&store_code_from=<%=store_code_from%>&store_code_to=<%=store_code_to%>&cost_access=<%=cost_access%>&dflt_facility_id=<%=dflt_facility_id%>'' frameborder="0" scrolling="no">
    <%} %>
</frameset>

</html>

