<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<TITLE><fmt:message key="eST.ItemsMovementStatus.label" bundle="${st_labels}"/>----</TITLE>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->		<%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY >
<P>
<div name='HeaderLabels' id='HeaderLabels' style='width:100%;overflow-x:no;overflow-y:no'>
<TABLE cellpadding=0 cellspacing=0 width="100%" border=0 align=center>
  
  <TR>
    <TD width='25%'>&nbsp;</TD>
    <TD width='25%'>&nbsp;</TD>
    <TD width='25%'>&nbsp;</TD>
    <TD width='25%'>&nbsp;</TD></TR>
  <TR>
    <TD class="label">&nbsp;&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/></TD>
    <TD class='label'><b><font size="1"><%=request.getParameter("item")%></font></b></TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD></TR>
  <TR>
    <TD class="label">&nbsp;&nbsp;<fmt:message key="Common.Store.label" bundle="${common_labels}"/></TD>
    <TD class='label'><b><font size="1"><%=request.getParameter("store")%></font></b></TD>
    <TD class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></TD>
    <TD class='label'><b><font size="1"><%=request.getParameter("period")%></font></b></TD></TR>
  <TR>
  <TR>
    <TH  width='25%'>&nbsp;&nbsp;<b><fmt:message key="eST.Particular.label" bundle="${st_labels}"/></b></TH>
    <TH   ><b><fmt:message key="eST.Inflow.label" bundle="${st_labels}"/></b></TH>
    <TH   ><b><fmt:message key="eST.Outflow.label" bundle="${st_labels}"/></b></TH>
    <TH   ><b><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></b></TH></TR>
   <TR>
   </table>
</div>
<div name='RecordsDtl' id='RecordsDtl' style='width:100%;height:250;overflow-x:auto;overflow-y: auto'>
<TABLE cellpadding=0 cellspacing=0 width="100%" border=0 align=center>
	
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp<fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></TD>
    <TD width='14%' >&nbsp;</TD>
    <TD width='14%'>&nbsp;</TD>
    <TD  width='14%' ><font size="1"><%=request.getParameter("op_bal")%></font></TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.GRN.label" bundle="${st_labels}"/></TD>
    <TD width='14%'><font size="1"><%=request.getParameter("rgn")%></font></TD>
    <TD width='14%'>&nbsp;&nbsp;----</TD>
    <TD  width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.RTV.label" bundle="${st_labels}"/></TD>
    <TD width='14%'>&nbsp;&nbsp;----</TD>
    <TD width='14%'><font size="1"><%=request.getParameter("rtv")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.InventoryIssues.label" bundle="${st_labels}"/></TD>
    <TD width='14%'><font size="1"><%=request.getParameter("in_inv_iss")%></font></TD>
    <TD width='14%'><font size="1"><%=request.getParameter("out_inv_iss")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.NonStockIssues.label" bundle="${st_labels}"/></TD>
    <TD width='14' ><font size="1"><%=request.getParameter("in_ns_iss")%></font></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("out_ns_iss")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.InventoryReturns.label" bundle="${st_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("in_inv_ret")%></font></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("out_inv_ret")%></font></TD>
    <TD width='15%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%'' class="label">&nbsp;&nbsp;<fmt:message key="eST.NonStockReturns.label" bundle="${st_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("in_ns_ret")%></font></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("out_ns_ret")%></font></TD>
    <TD width='14%' >&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.MFGReceipts.label" bundle="${st_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("in_mfg_rec")%></font></TD>
    <TD width='14%'  ><font size="1"><%=request.getParameter("out_mfg_rec")%></font></TD>
    <TD width='15%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.Sales.label" bundle="${st_labels}"/></TD>
    <TD width='14%' >&nbsp;&nbsp;----</TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("sales")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD  width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></TD>
    <TD width='14%'  ><font size="1"><%=request.getParameter("sales_ret")%></font></TD>
    <TD width='14%' >&nbsp;&nbsp;----</TD>
    <TD width='15%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("in_trans")%></font></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("out_trans")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
 <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("IN_TFR_s")%></font></TD>
    <TD width='14%'  ><font size="1"><%=request.getParameter("OUT_TFR_s")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("in_adj")%></font></TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("out_adj")%></font></TD>
    <TD width='14%'>&nbsp;</TD></TR>
  <TR>
    <TD width='14%' class="label">&nbsp;&nbsp;<fmt:message key="eST.ClosingBalance.label" bundle="${st_labels}"/></TD>
    <TD width='14%'>&nbsp;</TD>
    <TD width='14%'>&nbsp;</TD>
    <TD width='14%' ><font size="1"><%=request.getParameter("close_bal")%></font></TD>
 </TR>
	<TD width='10%'>&nbsp;</TD>
    <TD width='10%'>&nbsp;</TD>
    <TD width='10%'>&nbsp;</TD>
    <TD width='10%'>&nbsp;</TD></TR>
	</TABLE></P>
<div>
</BODY>
</HTML>

