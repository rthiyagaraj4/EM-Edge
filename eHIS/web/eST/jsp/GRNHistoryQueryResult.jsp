<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

23/04/2022	23925			Ramesh Goli		23/04/2022		RAMESH G    	MO-CRF-20171
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*,java.text.NumberFormat"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
 		<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
<!--		<script language="Javascript" src="../../eST/js/ItemMaster.js"> </script>-->
		<script language="Javascript" src="../../eST/js/GRNHistoy.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String doc_type_code="";
	String sap_doc_type_code="";
	String doc_no="";
	String sap_doc_no="";
	String doc_date="";
	String ext_doc_no = "";
	String po_no="";
	String supp_code="";
	String item_qty_normal="";
	String item_qty_sample="";
	String item_qty_bonus="";
	String replace_on_expiry_yn="";
	String grn_unit_cost_in_pur_uom="";
	String store_code="";
	String classvalue ="" ;      
	String batch_id ="" ;      
	String stlightgreen = "";
	String expiry_date_or_receipt_date = "";
	String grn_val = "";
	String item_code = "";
	String item_desc = "";
	String pur_uom_code = "";
	String item_code_temp = "";
	String doc_no_temp = "";
	String grn_rtv_cnt = "";
	int maxRec = 0;
	int displaySize = 0;
	int start  = 0;
	int end  = 0;
	int count   = 0;
	String sale_price="";   //Added by Padmapriya
	String sale_value="";   //Added by Padmapriya
	String pur_uom_desc = "";//Added by Rabbani #Inc no:43683(ML-BRU-SCF-1029) on 03-OCT-2013
	String batch_item_qty="";   //Added by suresh.r 28-11-2013 against MMS-SCF-0166
	//Added by sakti against EMR# 2390
	String grn_unit_cost_in_stk_uom = "";
	String stk_uom_desc = "";
	String item_qty_normal_pur_uom = "";
	String item_qty_bonus_pur_uom = "";
	String item_qty_sample_pur_uom = "";
	String grn_val_stk_uom  ="";
	String batch_item_qty_pur_uom = "";
	String batch_imageRef = ""; //23925
	String stk_uom_code = "";
	// Added ends
	
	String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String bean_id = "GRNHistoryBean";
	String bean_name = "eST.GRNHistoryBean";
	GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList result=new ArrayList();	
	HashMap dataList	= null;
	try{
		/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		int no_of_decimals=bean.getNoOfDecimals();

		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	String site_id=bean.getCustomerID();
	String sap_legend="";
	if(site_id.equals("MC")){
		sap_legend="SAP " ;
	
	}

		result=bean.getDataList();
		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize=Integer.parseInt("12");
		if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		%>
			<form name='GRNResultForm' id='GRNResultForm'>
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
			
				<th>&nbsp;</th>
				<th><%=sap_legend%><fmt:message key="eST.DocType/No.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ExtRefNo.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/> </th>
				<th colspan=6> In Purchase UOM </th>
				<th colspan=6> In Stock UOM </th>
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/> </th>
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.Replonexpiry.label" bundle="${st_labels}"/></th>
				<th colspan=2 nowrap>In Purchase UOM</th>
				<th colspan=2 nowrap>In Stock UOM</th>
				<th><fmt:message key="eST.SalePrice.label" bundle="${st_labels}"/></th>   <!-- //Added by Padmapriya -->
				<th><fmt:message key="eST.SaleValue.label" bundle="${st_labels}"/></th>   <!-- //Added by Padmapriya -->
				<th><fmt:message key="Common.Document.label" bundle="${common_labels}"/></th>   <!-- //23925 -->
			<tr>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>

				<th>UOM</th>
				<th><fmt:message key="eST.NormalQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.BonusQuantity.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.SampleQuantity.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.GRNValue.label" bundle="${st_labels}"/></th>

				<th>UOM</th>
				<th><fmt:message key="eST.NormalQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.BonusQuantity.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.SampleQuantity.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.GRNValue.label" bundle="${st_labels}"/></th>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<th>UOM</th>
			<th>Batch Qty</th>
			<th>UOM</th>
			<th>Batch Qty</th>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>
			<td class="ITEMSELECT">&nbsp;</td>	 <!--  //23925  -->		
			
			</tr>
		<%			
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				
				doc_type_code=CommonBean.checkForNull((String)dataList.get("DOC_TYPE_CODE"));
				doc_no=CommonBean.checkForNull((String)dataList.get("DOC_NO"),"");
				sap_doc_type_code=CommonBean.checkForNull((String)dataList.get("EXT_DOC_TYPE_CODE"),doc_type_code);
				sap_doc_no=CommonBean.checkForNull((String)dataList.get("EXT_DOC_NO"),doc_no);
				doc_date=CommonBean.checkForNull((String)dataList.get("DOC_DATE"));
				 ext_doc_no = CommonBean.checkForNull((String)dataList.get("EXT_DOC_NO"),"");
				po_no=CommonBean.checkForNull((String)dataList.get("PO_NO"),"");
				supp_code=CommonBean.checkForNull((String)dataList.get("SUPP_NAME"),"");
				item_qty_normal=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_NORMAL"),"");
				item_qty_sample=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_SAMPLE"),"");
				item_qty_bonus=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_BONUS"),"");
				replace_on_expiry_yn=CommonBean.checkForNull((String)dataList.get("REPLACE_ON_EXPIRY_YN"),"");
				sale_price=bean.setNumber(bean.checkForNull((String)dataList.get("SALE_PRICE"),"0"),noOfDecimalsForCost);  // Added by Padmapriya 
				sale_value=bean.setNumber(bean.checkForNull((String)dataList.get("SALE_VALUE"),"0"),noOfDecimalsForCost);  // Added by Padmapriya 
			 	batch_item_qty=CommonBean.checkForNull((String)dataList.get("GRN_ITEM_QTY"),"");   //Added by suresh.r 28-11-2013 against MMS-SCF-0166


		
				grn_unit_cost_in_pur_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_UNIT_COST_IN_PUR_UOM"),"0"),noOfDecimalsForCost);
				//Added by sakti unit cost changed to pur_uom cost to stk_uom cost against inc#48949	MMS-SCF-0337
				grn_unit_cost_in_stk_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_UNIT_COST_IN_STK_UOM"),"0"),noOfDecimalsForCost);
				store_code=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"");
				expiry_date_or_receipt_date=CommonBean.checkForNull((String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE"),"");
				batch_id=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"");
				//grn_val=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL"),"0"),noOfDecimalsForCost);
				grn_val=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL_PUR_UOM"),"0"),noOfDecimalsForCost);
				item_code=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"");
				item_desc=CommonBean.checkForNull((String)dataList.get("SHORT_DESC"),"");
				pur_uom_code=CommonBean.checkForNull((String)dataList.get("PUR_UOM_CODE"),"");
				grn_rtv_cnt=CommonBean.checkForNull((String)dataList.get("GRN_RTV_CNT"),"");
				pur_uom_desc = CommonBean.checkForNull((String)dataList.get("PUR_UOM_DESC"));//Added by Rabbani #Inc no:43683(ML-BRU-SCF-1029) on 01-OCT-2013
				//Added by sakti against EMR# 2390
				stk_uom_code = CommonBean.checkForNull((String)dataList.get("DEF_ISSUE_UOM"));
				stk_uom_desc = CommonBean.checkForNull((String)dataList.get("STK_UOM_DESC"));
				grn_val_stk_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL_STK_UOM"),"0"),noOfDecimalsForCost);
				
				if(!pur_uom_code.equals(stk_uom_code)) {
					item_qty_normal_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_NORMAL_PUR_UOM"),"");
					item_qty_sample_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_SAMPLE_PUR_UOM"),"");
					item_qty_bonus_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_BONUS_PUR_UOM"),"");
					batch_item_qty_pur_uom=CommonBean.checkForNull((String)dataList.get("GRN_ITEM_QTY_PUR_UOM"),"");
				}else{
					item_qty_normal_pur_uom = item_qty_normal;
					item_qty_sample_pur_uom = item_qty_sample;
					item_qty_bonus_pur_uom = item_qty_bonus;
					batch_item_qty_pur_uom = batch_item_qty;
				}
				batch_imageRef =CommonBean.checkForNull((String)dataList.get("IMAGE_REF"),""); //23925
				//Added ends
				if(!locale.equals("en"))
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				}else 
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				}
				
				stlightgreen = classvalue;
				String tool ="";
				String description = "";
				String finalized_yn = (String)dataList.get("FINALIZED_YN");
				String rtv_dtl = (String)dataList.get("RTV_DTL");
				int flag = 0;
				String dispflag = "";
				if ((finalized_yn).equals("Y")&& (rtv_dtl.equals("0"))) 
					{
							stlightgreen = "STLIGHTCREAM";
							tool = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalized.label","common_labels");
							description = "F";
				}
				else if (finalized_yn.equals("N"))
					{
						stlightgreen = "STLIGHTCREAM";
						tool =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnFinalized.label","common_labels");
						description ="U";												
					}				
				else if((finalized_yn).equals("Y") && (! rtv_dtl.equals("0")))
				{
						stlightgreen = "STLIGHTCREAM";
						tool =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.FinalizedandRTVExists.label","st_labels");
						description ="R";
						flag = 1;
				}
				dispflag = "N";
				if( !item_code_temp.equals((String)dataList.get("ITEM_CODE")))
				{
						item_code_temp = (String)dataList.get("ITEM_CODE") ;
						doc_no_temp = "";
						out.println("<tr><td class='ITEMSELECT' align='left' colspan='29' <th>Item Code :</th><b>"+item_code_temp+"</b>"+             com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels") +": <b>"+item_desc+"</b>  "+            com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")  +": <b>"+stk_uom_desc+"</b></td></tr>");
				}

				if( !doc_no_temp.equals((String)dataList.get("DOC_NO")))
				{
						dispflag = "Y";
						doc_no_temp = (String)dataList.get("DOC_NO") ;
				}
		%>
				<td class="<%=stlightgreen%>" 
				<%	String tool_tip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ReplacementGRN.label","st_labels");
					if (flag == 1) 
					{
					 if (dispflag.equals("Y"))
						{
				%>
					style="cursor:pointer" onClick="displayPending('<%=item_code%>','<%=doc_type_code%>','<%=doc_no%>');" style ="color=blue"
				<%
						}}
				%>
				 title= "<%=tool%>"   align="center"><font align = "center" size = 1 ><B><%=description%></B></font></td>
				<td  class="<%=classvalue%>" 
				<%
					if (Integer.parseInt(grn_rtv_cnt)!=0) 
					{
				%>
					  style ="color=blue ;cursor:pointer "  title= "<%=tool_tip%>" onClick="displayRtvReplPending('<%=item_code%>','<%=doc_type_code%>','<%=doc_no%>');"  align="left"  style ="color=blue"
				<%}
				%>
				<%if(site_id.equals("MC")){%>
				 ><font align = "center" size = 1 ><%=(dispflag=="Y"?sap_doc_type_code+"/"+sap_doc_no:"")%>&nbsp;</B></font></td>
				<% }else{%>
				 ><font align = "center" size = 1 ><%=(dispflag=="Y"?doc_type_code+"/"+doc_no:"")%>&nbsp;</B></font></td>
				<%}%>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?doc_date:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?ext_doc_no:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?po_no:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?supp_code:"")%>&nbsp;</td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Unit Cost, Normal Qty, Bonus Quantity, Sample Quantity, GRN Value.				
					-->

					<!-- 

						//Modified by Sakti against inc#49354 swapped item_quantity to item_qty_normal_pur_uom and vice versa
					-->
				<td class="<%=classvalue%>"   style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=pur_uom_desc%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_normal,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_bonus,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_sample,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"   style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?grn_unit_cost_in_pur_uom:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?grn_val:"")%>&nbsp;</td>

				<td class="<%=classvalue%>"   style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=stk_uom_desc%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_normal_pur_uom,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_bonus_pur_uom,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_sample_pur_uom,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"   style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap title="<%= dataList.get("GRN_UNIT_COST_IN_STK_UOM")%>"><%=(dispflag=="Y"?grn_unit_cost_in_stk_uom:"")%>&nbsp;</td><!--Modified by suresh.r on 06-08-2014 against MMS-SCF-0387 added title to display grn_unit_cost_in_stk_uom without fraction-->
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?grn_val_stk_uom:"")%>&nbsp;</td>
				
				
				
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?store_code:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=expiry_date_or_receipt_date%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=batch_id%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left' onclick="disableClick(event);" nowrap><%=replace_on_expiry_yn%>&nbsp;</td>
				
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=pur_uom_desc%></td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=batch_item_qty%></td>

				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=stk_uom_desc%></td>   <!-- Added by suresh.r 28-11-2013 against MMS-SCF-0166 -->
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=batch_item_qty_pur_uom%></td>   <!-- Added by suresh.r 28-11-2013 against MMS-SCF-0166 -->

				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=sale_price%>&nbsp;</td>   <!-- //Added by Padmapriya -->
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" onclick="disableClick(event);" nowrap><%=sale_value%>&nbsp;</td>  <!-- //Added by Padmapriya -->			
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:center" onclick="" nowrap><%if(!"".equals(batch_imageRef)){%><a href="javascript:getFile('<%=batch_imageRef%>')">View</a><%}%>&nbsp;</td> <!-- //23925 -->
			</tr>
	<%
				count++;
			chkCount++;
			}
	%>
			</table>
			<input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
			<input type="hidden" name="count" id="count" value="1">
		<%
			out.flush();
		} else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>

</body>
</form>
<script>activeLink();</script>
</html>
<%!

public String replaceNewLineChar(String message) {
		
		String changed = "";

        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\'");	

        return changed;
}
 
   /*  Modified on 5/9/2006  as per TSG request

   public String replaceNewLineChar(String message) {

	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};

        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
                            continue upper;
                        }
                    }
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    }*/
%>

