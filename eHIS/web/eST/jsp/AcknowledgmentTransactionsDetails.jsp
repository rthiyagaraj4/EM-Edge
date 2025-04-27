<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.text.NumberFormat" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<title>Remarks/Batch Details</title>
	<head>
	<%   String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
		
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="JavaScript" src="../../eST/js/AcknowledgmentTransactions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		ArrayList alParam = new ArrayList();
		alParam.add((String)request.getParameter("doc_no"));
		alParam.add((String)request.getParameter("doc_type_code"));
		//alParam.add((String)request.getParameter("pending_qty"));
		alParam.add((String)request.getParameter("item_code"));
		alParam.add(locale);
		alParam.add(locale);
		alParam.add(locale);
		alParam.add((String)request.getParameter("ack_date"));
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
		String item_code = "";
		String classvalue = "QRYODD" ;
		ArrayList alResult =  new ArrayList();
		HashMap	  hmResult =  new HashMap();
		/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		int no_of_decimals=bean.getNoOfDecimals();
		try{
			

			//alResult =  (ArrayList)bean.fetchRecords("SELECT MM.SHORT_DESC ITEM_DESC,AM.SHORT_DESC UOM_DESC,BIN.SHORT_DESC BIN_LOCATION,LOG.RECEIVED_QTY,LOG.REJECTED_QTY,LOG.ITEM_CODE, LOG.BATCH_ID, LOG.BIN_LOCATION_CODE, LOG.REMARKS,TO_CHAR(LOG.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXP_DATE FROM ST_ACKNOWLEDGE_TRN_DTL_LOG LOG,MM_ITEM_LANG_VW MM,AM_UOM_LANG_VW AM,MM_BIN_LOCATION_LANG_VW BIN WHERE DOC_NO = ? AND DOC_TYPE_CODE = ? /*AND PENDING_QTY = ? */AND LOG.ITEM_CODE = ? AND LOG.ITEM_CODE = MM.ITEM_CODE AND LOG.BIN_LOCATION_CODE =  BIN.BIN_LOCATION_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND BIN.LANGUAGE_ID = ? AND LOG.ISSUING_STORE = BIN.STORE_CODE AND TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:MI:SS') = TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') AND (REJECTED_QTY+RECEIVED_QTY) > 0 ORDER BY EXP_DATE",alParam);
			//Modified by suresh.r on 17-09-2014 against Perf tuning Inc 51157
			alResult =  (ArrayList)bean.fetchRecords(bean.getStRepositoryValue("ST_SQL_ST_ACKNOWLEDGE_TRN_DETAIL_QUERY"),alParam);
			//out.println(alResult);
		}catch(Exception e){
			System.err.println("Error in Acknowledgment Transaction Details");
			e.printStackTrace();
		}

				for(int i=0;i<alResult.size();i++){
				if (i % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
					hmResult = (HashMap)alResult.get(i);
					if(!item_code.equals((String)hmResult.get("ITEM_CODE"))){
			%>		
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td colspan="6" class="label">&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="6" class="label">
							<%=hmResult.get("ITEM_DESC")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<fmt:message key="Common.uom.label" bundle="${common_labels}"/>:<%=hmResult.get("UOM_DESC")%>
						</td>
					</tr>
					<tr>
						<td colspan="6" class="label">&nbsp;&nbsp;</td>
					</tr>
					
					</table>
					<table border="1" cellpadding="0" cellspacing="0" width="100%">
					<!--
				* @Name - Priya
				* @Date - 04/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - As length of 'batch_id' is max 20 chars to align the table properly TR has been moved under this table
				-->
					<tr>
						<th width="12%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
						<th width="12%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
						<th width="15%"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
						<th width="12%"><fmt:message key="eST.ReceivedQty.label" bundle="${st_labels}"/></th>
						<th width="12%"><fmt:message key="eST.RejectedQty.label" bundle="${st_labels}"/></th>
						<th width="40%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					</tr>
					<%}%>
					<tr>
						<td class="<%=classvalue%>" width="12%"><%=bean.checkForNull((String)hmResult.get("BATCH_ID"))%></td>
						<td class="<%=classvalue%>" width="12%"><%=com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmResult.get("EXP_DATE")),"DMY","en",locale)%></td>
						<td class="<%=classvalue%>" width="15%"><%=bean.checkForNull((String)hmResult.get("BIN_LOCATION"))%></td>
						<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Received Qty, Rejected Qty.				
					-->
						<td class="<%=classvalue%>" style="TEXT-ALIGN:right" width="12%"><%=bean.setNumber(bean.checkForNull((String)hmResult.get("RECEIVED_QTY"),"0"),no_of_decimals)%>&nbsp;</td>
						<td class="<%=classvalue%>" style="TEXT-ALIGN:right" width="12%"><%=bean.setNumber(bean.checkForNull((String)hmResult.get("REJECTED_QTY"),"0"),no_of_decimals)%>&nbsp;</td>
						<td class="<%=classvalue%>" align="left" width="40%">&nbsp;<%=bean.checkForNull((String)hmResult.get("REMARKS"))%></td>
					</tr>
			<%
				item_code = (String)hmResult.get("ITEM_CODE");
				}
			%>
		</table>
	</body>
</html>

