<!DOCTYPE html>
  <%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title><fmt:message key="eST.StockItemConsumptionPreviewDetails.label" bundle="${st_labels}"/> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StockItemConsumption.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i								=		0;
	String mode;
	String bean_id;
	String bean_name;
	//String function_id;

	mode								=		 request.getParameter( "mode" ) ;
	if(mode==null)			mode		=		"1";
	//function_id						=		request.getParameter( "function_id" ) ;
	
	bean_id								=		"stockItemConsumptionBean" ;
	bean_name							=		"eST.StockItemConsumptionBean";

	StockItemConsumptionBean bean		=		(StockItemConsumptionBean) getBeanObject( bean_id,bean_name,request);
	String classValue					=		"";
	bean.setLanguageId(locale);
	String store_code					=		request.getParameter("store_code");
	String store_desc					=		bean.getStore_desc(store_code);
	String doc_type_code				=		request.getParameter("doc_type_code");
	String doc_type_desc				=		bean.getDoc_type_desc(doc_type_code);
	String patient_id					=		request.getParameter("patient_id");
	String patient_name					=		request.getParameter("patient_name");
	String encounter					=		request.getParameter("encounter");
	String current_item					=		"";
	String previous_item				=		"";

	//String pre_item_cost_val			=		"";
 %>
	</head>
<body>
<form name='formGrnPreviewDetails' id='formGrnPreviewDetails' >
	<br>
	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20 align="center">
	<tr>
		<td class=ITEMSELECT   width ="20%" nowrap> &nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b><%=doc_type_desc%> </td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b><%=com.ehis.util.DateUtils.convertDate((String)bean.getDoc_date(),"DMY","en",locale)%></td><!-- bean.getDoc_date() changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015 -->
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b><%=store_desc%> 	</td>
	</tr>
	<tr>
		<td class=ITEMSELECT   width ="20%" nowrap> &nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</b><%=patient_id%> </td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>: </b> <%=patient_name%></td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>:  </b><%=encounter%>
		</td>
	</tr>
	</table><br>
	<div id='patinsheaderID'style='width:945 ;overflow-y:no;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align="center">
	<th style="WORD-BREAK:BREAK-ALL;" width="30%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	 <th wrap width="10%"><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></th> 
	<th width="10%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
			</table>
</div>
	<div id='patinsID' style='width:950;height:210;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >

	<%
	boolean site = bean.isSite_spec_yn();//Modified for GHL-CRF-0413 starts
	int size;
	if(site)
		 size					=		((HashMap)bean.getExpRecordsforBarCode()).size();
	else
		size					=		((HashMap)bean.getExpRecords()).size();
	int flag					=		0;
	HashMap   alData			=	null;
	HashMap   ht				=	null;
	HashMap   ht2				=	null;
	ArrayList alDetailData		=	null;
	for(i=0;i<size;i++)
	{
		if(site)
		{
			alData			=		(HashMap)bean.getDtlRecordforBarCode(i);
			alDetailData	=		(ArrayList)bean.getExpRecordsforBarCode(i);
		}
		else{
		alData			=		(HashMap)bean.getDtlRecord(i);
		alDetailData	=		(ArrayList)bean.getExpRecords(i);
		}
	//Modified for GHL-CRF-0413 ends
		for(int j=0;j<alDetailData.size();j++)
		{
			ht			=		(HashMap)alDetailData.get(j);
			if(site)
				ht2			=		(HashMap)bean.getDtlRecordforBarCode(i);
			else
			ht2			=		(HashMap)bean.getDtlRecord(i);
			current_item		=		(String)ht2.get("item_desc");
		
	
			if(flag%2==0)	classValue		=		"QRYEVEN";
			else			classValue		=		"QRYODD";
					%>
			<tr>
				<%if(current_item.equals(previous_item))
					{
					%>
					<td class="<%=classValue%>" width="31%">&nbsp;</td>
					<td class="<%=classValue%>" width="11%">&nbsp;</td> 
				<%}
				else{%>

					<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" width="31%" ><%=ht2.get("item_desc")%></td>
				<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" width="11%" ><%=ht2.get("stock_available")%></td> 
				<%}%>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Qty, Value.				
					-->
			<td class="<%=classValue%>" width="10%" style="TEXT-ALIGN:right"><%=ht.get("QTY")%>&nbsp;
			</td>
			<td class="<%=classValue%>" width="11%"><%=ht.get("BATCH_ID")%>&nbsp;
			</td>
			<%
				String value			=	(((Double.parseDouble((String)ht.get("QTY")) ) * (Double.parseDouble((String)alData.get("item_unit_cost")))))+"";
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
				String item_value		=	bean.setNumber(value,noOfDecimalsForCost);
				
				
			%>
			<td class="<%=classValue%>" width="10%" style="TEXT-ALIGN:right">
			<%=item_value%>&nbsp;
			</td>
			<td class="<%=classValue%>" width="10%"> 
				<%=ht.get("TRADE_NAME")%>&nbsp;
			</td>
			<td class="<%=classValue%>" width="10%">
				<%=ht.get("BIN_DESC")%>&nbsp;
			</td>
	
	</tr>
	<%
		previous_item		= current_item;
	//	pre_item_cost_val	= curr_item_cost_val;
		flag++;		
		}
			
	}
	%>
	
	</table>
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

