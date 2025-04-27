<!DOCTYPE html>
 <%@page  import=" eST.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
	 request.setCharacterEncoding("UTF-8");
	 String locale			=	(String)session.getAttribute("LOCALE");
	 String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/OpeningStock.js"></script>
<%
	int i=0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String max_stk_qty ="";
	mode	= request.getParameter( "mode" ) ;
	if(mode==null)mode="1";
	function_id	= request.getParameter( "function_id" ) ;
	
	bean_id = "openingStockBean" ;
	bean_name = "eST.OpeningStockBean";

	OpeningStockBean bean = (OpeningStockBean)getBeanObject( "openingStockBean", "eST.OpeningStockBean" ,request );
	bean.setLanguageId(locale);

	ArrayList ALDetailData=bean.getDetailValues();
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
<form name='formOpeningStockDetail' id='formOpeningStockDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></th>
	<%
	HashMap ht=null;
	for(i=0;i<ALDetailData.size();i++)
	{
		String classValue="";
		String alt_text="";
		ht=(HashMap)ALDetailData.get(i);
		max_stk_qty= bean.checkForNull((String)ht.get("max_stk_qty"));	
	
		if(i%2==0)classValue="QRYEVEN";
		else classValue="QRYODD";
		%>
	<tr id="tr_<%=i%>">
		<td align='center' width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		<td width='230' class="<%=classValue%>">
		<%
			if ( !( max_stk_qty == null ||((String)ht.get("max_stk_qty")).equals("")))
				{
		  /** 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Integer.paseInt is changed to Double.parseDouble as Quantity accepts decimal values
			*/
					if ( (Double.parseDouble((String)ht.get("adj_item_qty")))  >  Double.parseDouble(max_stk_qty))
					{
						alt_text = alt_text + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels");%>
						<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
					<%}
				}
				%>

			<%
				String strAllowDecYN="N";
				 if(!(bean.checkForNull((String)ht.get("item_code"))).equals("")){
					  strAllowDecYN	= bean.getAllowDecimalsYN(((String)ht.get("item_code")));
				 }
				int no_of_decimals_temp =0; 		
				if(strAllowDecYN.equals("Y")){
					no_of_decimals_temp = no_of_decimals;
				}
			
			%>

			<!-- Commented by Rabbani #Inc no:43124 (RUT-SCF-0290) on 11-sep-2013
			<font size=1><a name="a_<%=i%>" id="a_<%=i%>" href="javascript:populateData('<%=ht.get("item_code")%>','<%=ht.get("doc_srl_no")%>','<%=ht.get("expiry_yn")%>','<%=ht.get("batch_id_applicable_yn")%>','<%=ht.get("trade_id_applicable_yn")%>','<%=ht.get("uom")%>');"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(bean.checkForNull(((String)ht.get("adj_item_qty")),"0"),no_of_decimals_temp)%>&nbsp;&nbsp;<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_cost_value")%>&nbsp;&nbsp;<fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_unit_cost")%></font></a> -->
			
		 <font size=1><a name="a_<%=i%>" id="a_<%=i%>" href="javascript:populateData('<%=ht.get("item_code")%>','<%=ht.get("doc_srl_no")%>','<%=ht.get("expiry_yn")%>','<%=ht.get("batch_id_applicable_yn")%>','<%=ht.get("trade_id_applicable_yn")%>','');"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(bean.checkForNull(((String)ht.get("adj_item_qty")),"0"),no_of_decimals_temp)%>&nbsp;&nbsp;<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_cost_value")%>&nbsp;&nbsp;<fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_unit_cost")%></font></a>
		 
		</td>
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
	putObjectInBean( "openingStockBean",bean,request);
%>
</body>
<%if (request.getParameter("index")!=null && request.getParameter("index") != "-1") {%>
<script language="JavaScript">
document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>

</html>


