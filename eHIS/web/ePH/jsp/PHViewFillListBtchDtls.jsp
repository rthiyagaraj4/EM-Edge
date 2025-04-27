<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IPFill.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<title><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></title>
<%
String batch_dtls   = request.getParameter("batch_dtls");
String params		= request.getQueryString();
String item_code    = request.getParameter("drug_code");
String store_code   = request.getParameter("store_code");
String exp_date		= "";
String btch_id		= "";
String trade_name	= "";
String dflt_bin		= "";						   
String btch_qty		= "";
String end_date		= request.getParameter("end_date_time");

%>
<FORM name="formPHViewFillListBtch" id="formPHViewFillListBtch"  TARGET="messageFrame" >
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
<tr>										 
	<Th ALIGN="center" width="20%" nowrap><b><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></b> &nbsp;</Th>
	<Th ALIGN="center" width="20%" nowrap><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b>&nbsp;</Th>
	<Th ALIGN="center" width="20%" nowrap><b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></b> &nbsp;</Th>
	<Th ALIGN="center" width="20%" nowrap><b><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></b></Th>
	<Th ALIGN="center" width="20%" nowrap><b><fmt:message key="Common.Batch.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></b> &nbsp;</Th> 
</tr>
<%
	StringTokenizer btch_dtls = new StringTokenizer(batch_dtls,"*");
   	

	while(btch_dtls.hasMoreTokens()){
		StringTokenizer ind_b_dtl = new StringTokenizer(btch_dtls.nextToken(),"^");
		  int Batchcount=ind_b_dtl.countTokens();
		 if(Batchcount==5)	{
			while(ind_b_dtl.hasMoreTokens()){
			exp_date	= ind_b_dtl.nextToken();
			btch_id		= ind_b_dtl.nextToken();
			trade_name  = ind_b_dtl.nextToken();
			dflt_bin	= ind_b_dtl.nextToken();
			btch_qty	= ind_b_dtl.nextToken();
		   }
		}
	
%>
<tr>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap ><font size="1" ><label id="exp_date" ><%=exp_date%></label></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1" ><label id="btch_id" ><%=btch_id%></label></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1"><label id="trade_name" ><%=trade_name%></label></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1"><label id="dflt_bin" ><%=dflt_bin%></label></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1"><label id="btch_qty" ><%=btch_qty%></label></TD>	
</tr>
<% }%>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
<tr>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1" ></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1"></TD>
	<TD class="BODYCOLORFILLED" ALIGN="center" width = "20%" nowrap><font size="1"></TD>
	<TD class="BODYCOLORFILLED" ALIGN="right" width = "10%" nowrap><font size="1"><input type="button" class="button" value='<fmt:message key="Common.change.label" bundle="${common_labels}"/><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>' onClick="callBatchSearch('<%=java.net.URLEncoder.encode(params)%>','<%=item_code%>','<%=store_code%>','<%=end_date%>','<%=btch_qty%>')"></TD>
	<TD class="BODYCOLORFILLED" ALIGN="left" width = "10%" nowrap><font size="1" >&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="window.close();"></TD>
								 
</tr>
</table>
</FORM>
</BODY>
</HTML>

