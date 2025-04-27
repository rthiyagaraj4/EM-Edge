<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
%>

<html>
	<head>
		<title><fmt:message key="eST.RTVPreviewDetails.label" bundle="${st_labels}"/> </title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
			String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i							=			0;
	String mode;
	String bean_id;
	String bean_name;
//	String function_id;

	mode								=			request.getParameter( "mode" ) ;
	if(mode==null)	mode				=			"1";
//	function_id							=			request.getParameter( "function_id" ) ;
	
	bean_id								=			"goodsReturnToVendorBean" ;
	bean_name							=			"eST.GoodsReturnToVendorBean";

	GoodsReturnToVendorBean bean		=			(GoodsReturnToVendorBean) getBeanObject( bean_id, bean_name, request  );
	ArrayList alDetailData1				=			bean.getDtlRecords();
	HashMap hmexpyn						=			(HashMap)alDetailData1.get(0);    
	String itemcode						=			(String)hmexpyn.get("item_code");
	String classValue					=			"";
	String store_code					=			request.getParameter("store_code");
	String store_desc					=			bean.getStore_desc(store_code);
	String doc_type_code				=			request.getParameter("doc_type_code");
	String doc_type_desc				=			bean.getDoc_type_desc(doc_type_code);
	String supplier						=			request.getParameter("supplier");
	String expiry_yn					=			bean.getExpYN(itemcode);
	String current_item					=			"";
	String previous_item				=			"";
	String EXPIRY_DATE_OR_RECEIPT_DATE	=			"";
	String doc_date						=			bean.getDoc_date();
   if(!locale.equals("en"))
   {
	   doc_date							=			com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
   }
   else
   {
		doc_date						=			doc_date;
   }
	//String curr_item_cost_val			=			"";
	//String pre_item_cost_val			=			"";
	
%>
	</head>
<body>
<form name='formGrnPreviewDetails' id='formGrnPreviewDetails' >
	<br>
	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20 align=center>
	<!--<th align=center>Doc Type</th>
	<th align=center>Doc Date</th>
	<th align=center>Store</th>
	<th align=center>Supplier</th>-->
	<tr>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b><%=doc_type_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b><%=doc_date%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b><%=store_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>:</b><%=supplier%></td>
	</tr>
	</table>
	<br>
	<div id='patinsheaderID'style='width:705 ;overflow-y:no;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
	<th align=center style="WORD-BREAK:BREAK-ALL;"  width="30%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	<th align=center width="10%"><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></th>
	<th align=center width="10%"><fmt:message key="eST.RTVQuantity.label" bundle="${st_labels}"/></th>
	 <%if(expiry_yn.equals("Y")){%> 
    <th align=center width="10%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
	 <%}else{%>
	<th align=center width="10%"><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></th>
 	<%}%> 
	<th align=center width="10%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<th align=center width="10%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
	<th align=center width="10%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th align=center width="10%"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
		</table>
</div>
	<div id='patinsID' style='width:715;height:210;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >

	<%
	int size = ((HashMap)bean.getExpRecords()).size();

	HashMap ht							=		null;
	HashMap ht2							=		null;
	ArrayList alDetailData				=		null;
	for(i=0;i<size;i++)
	{
		alDetailData					=		(ArrayList)bean.getExpRecords(i);
 
		ht2 =   (HashMap)bean.getDtlRecord(i);

		if(ht2!=null){	
			String no_deci = (String)ht2.get("no_deci");
			String allow_deci_yn = (String)ht2.get("allow_deci_yn");
			if(allow_deci_yn.equals("N"))
				no_deci ="0";
			for(int j=0;j<alDetailData.size();j++){
				ht								=		(HashMap)alDetailData.get(j);
			
				if(j%2==0)	classValue			=		"QRYEVEN";
				else		classValue			=		"QRYODD";
			current_item					=		(String)ht.get("ITEM_DESC");
		  

   				if(!locale.equals("en")){
					EXPIRY_DATE_OR_RECEIPT_DATE		=		(String) ht.get("EXPIRY_DATE_OR_RECEIPT_DATE");
					EXPIRY_DATE_OR_RECEIPT_DATE		=		com.ehis.util.DateUtils.convertDate(EXPIRY_DATE_OR_RECEIPT_DATE,"DMY","en",locale);
				}else{
					EXPIRY_DATE_OR_RECEIPT_DATE		=		(String) ht.get("EXPIRY_DATE_OR_RECEIPT_DATE");
				//EXPIRY_DATE_OR_RECEIPT_DATE		=		com.ehis.util.DateUtils.convertDate(EXPIRY_DATE_OR_RECEIPT_DATE,"DMY",locale,"en");

				}
	%>

	<tr>
			<%if(current_item.equals(previous_item)){
			%>
			<td class="<%=classValue%>" align='left'  width="30%">&nbsp;</td>
			<%}else{%>
			<td class="<%=classValue%>" align='left' style="WORD-BREAK:BREAK-ALL;"  width="30%"><%=ht.get("ITEM_DESC")%></td>
			<%}%>
			<td class="<%=classValue%>" align='left' width="10%"><%=(String)ht.get("SHORT_DESC")%>&nbsp;</td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align RTV Qty, Value.				
					-->
			<td class="<%=classValue%>" style="TEXT-ALIGN:right" width="10%"><%=bean.setNumber((String)ht.get("RTV_ITEM_QTY"),Integer.parseInt(no_deci))%>&nbsp;</td>

            <td class="<%=classValue%>" align='left' width="10%"><%=EXPIRY_DATE_OR_RECEIPT_DATE%>&nbsp;</td>
			<td class="<%=classValue%>" align='left' width="10%"><%=ht.get("BATCH_ID")%>&nbsp;</td>
			<%
				/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
				String value		=  (((Double.parseDouble((String)ht.get("RTV_ITEM_QTY")) ) * (Double.parseDouble(bean.setNumber((String)ht.get("GRN_UNIT_COST_IN_PUR_UOM"),noOfDecimalsForCost)))))+"";
				String item_value	= bean.setNumber(value,noOfDecimalsForCost);
			%>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right" width="10%"><%=item_value%>&nbsp;</td>
			<td class="<%=classValue%>" align='left' width="10%"><%=ht.get("TRADE_NAME")%>&nbsp;</td>
			<td class="<%=classValue%>" align='left' width="10%"><%=ht.get("BIN_LOCATION_DESC")%>&nbsp;</td>
	</tr>
	<%
				previous_item		=		current_item;
	//		pre_item_cost_val	=	curr_item_cost_val;
			
			}
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

