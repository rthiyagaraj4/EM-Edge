<!DOCTYPE html>

<%@page contentType="text/html;charset=UTF-8"  import=" eST.SplitBatchBean,eST.Common.*,java.util.ArrayList,java.util.HashMap"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title> </title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/SplitBatch.js"></script>
<%
		int i						=		0;
		String mode;
		String bean_id;
		String bean_name;
		String function_id;
		String store_code			=		"";
		String display_flag			=		"visibility:hidden";
		String index                =     request.getParameter("index");  

		mode						=		request.getParameter( "mode" ) ;
		store_code					=		request.getParameter("store_code")==null?"":request.getParameter("store_code");
		if(mode==null)	mode		=		"1";
		function_id					=		request.getParameter( "function_id" ) ;
		
		bean_id						=		"splitBatchBean" ;
		bean_name					=		"eST.SplitBatchBean";

		SplitBatchBean bean			=		(SplitBatchBean) getBeanObject( "splitBatchBean",  "eST.SplitBatchBean", request  );
		bean.setLanguageId(locale);

		ArrayList ALDetailData		=		bean.getDetailValues();
		if(!(store_code.equals(""))){
			if(((String)bean.getAccessCostDetails()).equals("Y"))
				display_flag		=		"visibility:visible";
		}

		/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	String bar_code = request.getParameter("bar_code")==null?"":request.getParameter("bar_code");
	//System.out.println("bar_code===55==rels=>" +bar_code);
	String Barcode_yn = request.getParameter("barcode_yn")==null?"":request.getParameter("barcode_yn");
	//System.out.println("Barcode_yn===56 RELS===>" +Barcode_yn);
	
%>
	</head>
<body>
<form name='formOpeningStockDetail' id='formOpeningStockDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align="center">
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>
	<%
	HashMap ht						=		null;
	for(i=0;i<ALDetailData.size();i++)
	{
		String classValue			=		"";
		ht							=		(HashMap)ALDetailData.get(i);
		if(i%2==0)	classValue		=		"QRYEVEN";
		else		classValue		=		"QRYODD";

		
		/**
			* @Name - Priya
			* @Date - 20/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - the temporary variable no_of_decimals_temp is used to set the no of decimals after the decimal point based on the item set up for "Allow decimals"
			*/

		
			int no_of_decimals_temp =0;
			if(((String)ht.get("dec_allowed_yn")).equals("Y")){
				no_of_decimals_temp = no_of_decimals;
			}
		%>
	<tr id="tr_<%=i%>">
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>

		<!-- @Name - Priya
				* @Date - 17/02/2010
				* @Inc# - 19404 
				* @Desc - value of 'Value' & 'Cost' is checked with 'checkForNull' function as it is throwing number format exception.
		-->
		<td width='230' class="<%=classValue%>"style="WORD-BREAK:BREAK-ALL;">
		<font size=1><a name="a_<%=i%>" id='a_<%=i%>'  href="javascript:populateData('<%=ht.get("item_code")%>','<%=ht.get("doc_srl_no")%>','<%=ht.get("expiry_yn")%>','<%=ht.get("batch_id_applicable_yn")%>','<%=ht.get("trade_id_applicable_yn")%>','<%=ht.get("uom")%>','<%=Barcode_yn%>','<%=bar_code%>',<%=index%>);"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(bean.checkForNull((String)ht.get("adj_item_qty"),"0"),no_of_decimals_temp)%>&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=bean.checkForNull((bean.checkForNull((String)ht.get("item_cost_value")).trim()),"0")%>&nbsp;&nbsp;<fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:<%=bean.checkForNull((bean.checkForNull((String)ht.get("item_unit_cost")).trim()),"0")%></span></font></a></td>
	</tr>
	<%}%>
	</table>
		<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
		<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">

</form>
<%
	putObjectInBean("splitBatchBean",bean,request);
%>
</body>
<%if (request.getParameter("index")!=null) {%>
<script language="JavaScript">
	document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html>


