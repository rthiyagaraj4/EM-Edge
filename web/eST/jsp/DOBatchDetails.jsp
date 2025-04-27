<!DOCTYPE html>
<%@ page import="eST.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eST.DelieveryOrderDetails.label" bundle="${st_labels}"/></title>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	 (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<%
	String do_no			=	(String)request.getParameter("do_no");
	String po_no			=	(String)request.getParameter("po_no");
	String po_srl_no		=	(String)request.getParameter("po_srl_no");
	String item_code		=	(String)request.getParameter("item_code");
	String req_no			=	(String)request.getParameter("req_no");
	String item_desc		=	(String)request.getParameter("item_desc");

	GoodsReceivedNoteBean bean			=	(GoodsReceivedNoteBean) getBeanObject("goodsReceivedNoteBean","eST.GoodsReceivedNoteBean",request); 
	bean.setLanguageId(locale);
	
	ArrayList al_do_details			=	new ArrayList();	
	HashMap	  hm_do_detail			=   new HashMap();

	String[] alParameters	= {locale,locale,do_no,po_no,req_no,item_code,po_srl_no};

	int no_of_decimals = 0;
	%>

		<table border="1" cellspacing="0" width="100%">
		<tr>
				<td class="label" class="QRYODD" ><B><fmt:message key="eST.DoNo.label" bundle="${st_labels}"/>:&nbsp;&nbsp;&nbsp;</B></td>
				<td class="label" class="QRYODD" colspan = 2><%=do_no%></td>
				<td class="label" class="QRYODD" ><b><fmt:message key="Common.item.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;</b></td>
				<td class="label" class="QRYODD"  colspan = 5><%=item_desc%></td>
			</tr>
			<tr>				
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="Common.uom.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="eST.ScheduleDate.label" bundle="${st_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="eST.ItemQuantity.label" bundle="${st_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="eST.BonusQuantity.label" bundle="${st_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center" width='10%'><b><fmt:message key="eST.SampleQuantity.label" bundle="${st_labels}"/></b></td>
		
			</tr>
		<table>

 <%
	try{


		al_do_details = (ArrayList)bean.fetchRecords("SELECT HDR.DO_NO,HDR.DO_DATE,ITEM_CODE,TO_CHAR(SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE,PO_NO,BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE,DIST_FACILITY_ID,DIST_STORE_CODE,DO_QTY_NORMAL,DO_QTY_BONUS,DO_QTY_SAMPLE,DO_UOM ,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = DTL.DO_UOM AND LANGUAGE_ID= ? ) DO_UOM_DESC, (SELECT SHORT_DESC FROM MM_STORE_LANG_VW WHERE STORE_CODE = DTL.DIST_STORE_CODE AND LANGUAGE_ID= ? ) STORE_DESC  FROM PO_DELV_ORD_HDR HDR ,PO_DELV_ORD_DTL_BAT DTL WHERE HDR.DO_NO = DTL.DO_NO AND HDR.DO_STATUS IN ('FN','PR') AND HDR.DO_NO=?  AND DTL.PO_NO=? AND  NVL(DTL.REQ_NO,'*A') = NVL(?,'*A') AND DTL.ITEM_CODE LIKE ?	AND DTL.PO_SRL_NO = ? ",alParameters);
		
		for(int i=0;i< al_do_details.size();i++){
			hm_do_detail = (HashMap)al_do_details.get(i);

			if((bean.getAllowDecimalsYN((String)hm_do_detail.get("ITEM_CODE"))).equals("Y")){
				no_of_decimals = bean.getNoOfDecimals();
			}

	%>
		<table border="1" cellspacing="0" width="100%">
				<tr>
				<td class="QRYODD" style="TEXT-ALIGN:left" width='10%'><%=bean.checkForNull((String)hm_do_detail.get("STORE_DESC"))%></td>
				<td class="QRYODD" style="TEXT-ALIGN:left" width='10%'><%=bean.checkForNull((String)hm_do_detail.get("DO_UOM_DESC"))%></td>
				<td class="QRYODD" style="TEXT-ALIGN:left" width='10%'><%=bean.checkForNull((String)hm_do_detail.get("BATCH_ID"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:left" width='10%'><%=bean.checkForNull((String)hm_do_detail.get("EXPIRY_DATE"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:left" width='10%'><%=bean.checkForNull((String)hm_do_detail.get("SCH_DELV_DATE"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right" width='10%'><%=bean.setNumber(bean.checkForNull((String)hm_do_detail.get("DO_QTY_NORMAL"),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right" width='10%'><%=bean.setNumber(bean.checkForNull((String)hm_do_detail.get("DO_QTY_BONUS"),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right" width='10%'><%=bean.setNumber(bean.checkForNull((String)hm_do_detail.get("DO_QTY_SAMPLE"),"0"),no_of_decimals)%>&nbsp;</td>
			</tr>
		</table>

	<%}
	}
	catch(Exception e){
			e.printStackTrace();
			%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));window.close();</script>
		<%}
	%>
</body>
</html>

