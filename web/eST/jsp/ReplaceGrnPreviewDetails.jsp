<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title><fmt:message key="eST.ReplacementGRNPreviewDetails.label" bundle="${st_labels}"/> </title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	// pmd 29/01/05
//	String function_id;

	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)	mode			=		"1";
	//function_id					=		request.getParameter( "function_id" ) ;
	
	bean_id							=		"replacementGRNBean" ;
	bean_name						=		"eST.ReplacementGRNBean";

	ReplacementGRNBean bean			=		(ReplacementGRNBean) getBeanObject( bean_id,bean_name, request );
	//ArrayList alDetailData		=		bean.getDtlRecords();//bean.getDetailValues();
	bean.setLanguageId(locale);
	String classValue="";
	String store_code				=		request.getParameter("store_code");
	String store_desc				=		bean.getStore_desc(store_code);
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_type_desc			=		bean.getDoc_type_desc(doc_type_code);
	String supplier					=		request.getParameter("supplier");
	String current_item				=		"";
	String previous_item			=		"";
//	String curr_item_cost_val		=		"";
//	String pre_item_cost_val		=		"";
	
%>
	</head>
<body>
<form name='formGrnPreviewDetails' id='formGrnPreviewDetails' >
	
	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20 align="center">
	<td class=ITEMSELECT  >
	
	<!--<th align=center>Doc Type</th>
	<th align=center>Doc Date</th>
	<th align=center>Store</th>
	<th align=center>Supplier</th>-->
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
	<fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b><%=doc_type_desc%>&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b><%=bean.getDoc_date()%>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<b><fmt:message key="Common.Store.label"  bundle="${common_labels}"/>:</b><%=store_desc%>&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
	<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>:</b><%=supplier%>&nbsp;
	</table>
	<br>
	<div id='patinsID' style='width:710;height:230;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align="center">
	<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
	<th   ><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/></th>
	<th  ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
	<th  ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
	</tr>
	<%
	int size = ((HashMap)bean.getExpRecords()).size();
	HashMap   alData			= null;
	HashMap   ht				= null;
	HashMap   ht2				= null;
	ArrayList alDetailData		= null;
	for(i=0;i<size;i++)
	{
		alData			=		(HashMap)bean.getDtlRecord(i);
		alDetailData		=		(ArrayList)bean.getExpRecords(i);
		if(i%2==0)classValue		=		"QRYEVEN";
		else	  classValue		=		"QRYODD";

		for(int j=0;j<alDetailData.size();j++){
				ht			=		(HashMap)alDetailData.get(j);
				ht2			=		(HashMap)bean.getDtlRecord(i);
				current_item		=		(String)ht2.get("item_desc");
		//		curr_item_cost_val  =		(String)ht2.get("item_cost_value");
		//		ArrayList batch_detail =	(ArrayList)bean.getExpRecords(i);
		//		HashMap ht2			=		(HashMap)batch_detail.get(0);
		String no_deci = (String)ht2.get("no_deci");
		String allow_deci_yn = (String)ht2.get("allow_deci_yn");
		if(allow_deci_yn.equals("N"))
			no_deci ="0";
	%>
	<tr>
			<%if(current_item.equals(previous_item)){
			%>
			<td class="<%=classValue%>"  >&nbsp;</td>
			<%}else{%>
			<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" ><%=ht2.get("item_desc")%></td>
			<%}%>
			<td class="<%=classValue%>" ><%=bean.setNumber((String)ht.get("grn_item_qty"),Integer.parseInt(no_deci))%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=ht.get("batch_id")%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=ht.get("expiry_date_or_receipt_date")%>&nbsp;</td>
			<%
				String value =  (((Double.parseDouble((String)ht.get("grn_item_qty")) ) * (Double.parseDouble((String)alData.get("grn_unit_cost_in_pur_uom")))))+"";
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
				String item_value = bean.setNumber(value,noOfDecimalsForCost);

			%>
			<td class="<%=classValue%>" >
			<%=item_value%></td>
			
			<td class="<%=classValue%>" ><%=ht.get("trade_id")%>&nbsp;</td>
			<td class="<%=classValue%>" > <%=bean.getBinLocation_desc((String)ht.get("bin_location_code"))%>&nbsp;</td>
	</tr>
	<%
		previous_item		= current_item;
//		pre_item_cost_val	= curr_item_cost_val;
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

