<%@page  import=" eST.AdjustStockBean,eST.Common.*,java.util.ArrayList,java.util.HashMap, java.text.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>		<title> </title>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/AdjustStock.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String max_stk_qty			=		"";
	String min_stk_qty			=		"";
	String avl_qty				=		"";
	String item_code			=		request.getParameter("item_code");
	mode						=		request.getParameter( "mode" ) ;
	String adj_item_qty			=		"";
	if(mode==null)	mode		=		"1";
	function_id					=		request.getParameter( "function_id" ) ;
	
	bean_id						=		"adjustStockBean" ;
	bean_name					=		"eST.AdjustStockBean";

	AdjustStockBean bean		=		(AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
	bean.setLanguageId(locale);

	ArrayList ALDetailData		=		bean.getDetailValues();

	/**
	* @Name - Priya
	* @Date - 18/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();	
	%>
	</head>
<body>
<form name='formAdjustStockDetail' id='formAdjustStockDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=250 align=center>
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>
	<%
	for(i=0;i<ALDetailData.size();i++)
	{
		String classValue		=		"";
		String alt_text			=		"";
		HashMap ht				=		new HashMap();
		ht						=		(HashMap)ALDetailData.get(i);
		System.out.println("ht = "+ht);

		max_stk_qty				=		bean.checkForNull((String)ht.get("max_stk_qty"));	
		min_stk_qty				=		bean.checkForNull((String)ht.get("min_stk_qty"));	
		avl_qty					=		bean.checkForNull((String)ht.get("avl_qty"),"0");	

		if(i%2==0)	classValue	=		"QRYEVEN";
		else		classValue	=		"QRYODD";

		if (item_code!=null) {
			if (item_code.equals((String)ht.get("item_code"))) {
				classValue		=		"STLIGHTPINK";
			}

		}
			
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
	<tr>
		<td align='center' width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
		<%
						if ( !( min_stk_qty == null ||(min_stk_qty.equals(""))))
						{
						   /**
							* @Name - Priya
							* @Date - 19/01/2010
							* @Inc# - 15496 (SRR20056-CRF-0537.2)
							* @Desc - the variables 'avl_qty','adj_item_qty','min_stk_qty' are changed from integer to double as it is having decimal values
							*/

							if ( (Double.parseDouble(bean.checkForNull((String)ht.get("avl_qty"),"0"))) + 	(Double.parseDouble((String)ht.get("adj_item_qty"))) <  Double.parseDouble(min_stk_qty))
							{
								
								alt_text	=	alt_text + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.BelowMinStockLevel.label","st_labels");
							%>
								<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
							<%}
						}

						if ( !( max_stk_qty == null ||(max_stk_qty.equals(""))))
						{

							/**
							* @Name - Priya
							* @Date - 19/01/2010
							* @Inc# - 15496 (SRR20056-CRF-0537.2)
							* @Desc - the variables 'avl_qty','adj_item_qty','max_stk_qty' are changed from integer to double as it is having decimal values
							*/
							if ( (Double.parseDouble(bean.checkForNull((String)ht.get("avl_qty"),"0"))) + (Double.parseDouble((String)ht.get("adj_item_qty"))) >  Double.parseDouble(max_stk_qty))
							{

								alt_text	=	alt_text + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels");
							%>
								<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
							<%}
						}
					DecimalFormat dfTest	=		new DecimalFormat("##.000");
					String item_cost_value	=		"";
					String item_unit_cost	=		"";
					System.out.println("item_cost_value==="+ht.get("item_cost_value"));
					
					double item_cost_val = Double.parseDouble((String)ht.get("item_cost_value"));
					
					item_cost_value			=		String.valueOf(item_cost_val)+"";
					item_cost_value			=		dfTest.format(Double.parseDouble(item_cost_value));
					
					
					if(!((String)ht.get("item_unit_cost")).isEmpty())
					{
					  double item_unit_cost_val		=		Double.parseDouble((String)ht.get("item_unit_cost"));
					  item_unit_cost			=		item_unit_cost_val+"";
					  item_unit_cost			=		dfTest.format(Double.parseDouble(item_unit_cost));
					  adj_item_qty=(String)ht.get("adj_item_qty");
					}
					else
					{
						item_unit_cost			=	"";
						//item_unit_cost			=	dfTest.format(item_unit_cost);
						adj_item_qty=(String)ht.get("adj_item_qty");
					}
						 
					
						
					//System.out.println(bean.setNumber(bean.checkForNull((String)adj_item_qty,"0"),no_of_decimals_temp));
					
				%>
		<font size=1> <a href="javascript:populateData('<%=mode%>','<%=ht.get("item_code")%>','<%=ht.get("doc_srl_no")%>','<%=ht.get("expiry_yn")%>','<%=ht.get("batch_id_applicable_yn")%>','<%=ht.get("trade_id_applicable_yn")%>','<%=ht.get("uom")%>','<%=ht.get("mode")%>','<%=ht.get("itemlastcost")%>','<%=ht.get("storecost")%>');"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(bean.checkForNull((String)adj_item_qty,"0"),no_of_decimals_temp).replace(".", "")%>&nbsp;&nbsp;<span style="visibility:hidden"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=item_cost_value%> &nbsp;&nbsp;<fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:<%=item_unit_cost%></span></font></a>
		</td>
	</tr>
	<%}%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="lastcost_1" id="lastcost_1"				value="<%=i%>">
	<input type="hidden" name="store_last_cost_1" id="store_last_cost_1"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="finalized" id="finalized">
	<input type="hidden" name="print_yn" id="print_yn">
	<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts  -->
	<input type="hidden" name="disposable_yn" id="disposable_yn"			value="<%=bean.getDisposable_yn()%>"> 
<%
	putObjectInBean("adjustStockBean",bean,request);
%>
</form>
</body>

</html>


