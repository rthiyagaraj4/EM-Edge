<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*" %><!-- Modified for IN:071539 -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.GRNPreviewDetails.label" bundle="${st_labels}"/> </title>
		<%
		request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i=0;
	String mode;
	String bean_id;
	String bean_name;
	mode	= request.getParameter( "mode" ) ;
	if(mode==null)mode="1";
	bean_id = "goodsReceivedNoteBean" ;
	bean_name = "eST.GoodsReceivedNoteBean";
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String classValue="";
	String store_code		  = request.getParameter("store_code");
	String store_desc		  = bean.getStore_desc(store_code);
	String doc_type_code	  = request.getParameter("doc_type_code");
	String doc_type_desc	  = bean.getDoc_type_desc(doc_type_code);
	String supplier			  = request.getParameter("supplier");

	String current_item		  = "";
	String previous_item	  = "";
	String trade_name = "";
	String bin_desc ="";
	//String pre_item_cost_val  = "";
String doc_date=bean.getDoc_date();
//Added for IN:071539 start
Connection con				= null;
 
boolean exp_date_disp_appl = false;

try 
{
	con						= ConnectionManager.getConnection(request);
	exp_date_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_PRW_EXP_DATE");
	
} 
catch (Exception e) 
{
	e.printStackTrace(System.err);
	System.out.println(" Error in Criteria Page " + e.getMessage());
} 
finally 
{
	if (con != null) ConnectionManager.returnConnection(con, request);
}
//Added for IN:071539 end
if(!locale.equals("en"))
	{
	doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
	}else
	{
	doc_date=doc_date;
	}

	/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
%>
	</head>
<body>
<form name='formGrnPreviewDetails' id='formGrnPreviewDetails' >
	<br>
	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20 align=center>
	<tr>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b><%=doc_type_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b><%=doc_date%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b><%=store_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>:</b><%=supplier%></td>
	</tr>
	</table><br>
	<div id='patinsID' style='width:710;height:230;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align="center">
	<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
	<th  ><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	<th  ><fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/></th>
	<th ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<%if(exp_date_disp_appl) {%>
	<th ><fmt:message key="eST.ExpiryReceiptDate.label" bundle="${st_labels}"/></th><!-- Added for IN:071539 -->
	<%} %>
	<th ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
 </tr>
	<%
	int size = ((HashMap)bean.getExpRecords()).size();
	HashMap   alData	   = null;
	ArrayList alDetailData = null;
	HashMap	  ht		   = null;
	HashMap   ht2		   = null;
	for(i=0;i<size;i++)
	{
		alData=(HashMap)bean.getDtlRecord(i);
		alDetailData = (ArrayList)bean.getExpRecords(i);
		for(int j=0;j<alDetailData.size();j++){
			ht	=	(HashMap)alDetailData.get(j);
			ht2 =   (HashMap)bean.getDtlRecord(i);
			String no_deci = (String)ht2.get("no_deci");
		String allow_deci_yn = (String)ht2.get("allow_deci_yn");
		if(allow_deci_yn.equals("N"))
			no_deci ="0";
			current_item = (String)ht2.get("item_desc");
		//	curr_item_cost_val = (String)ht2.get("item_cost_value");
		if(j%2==0)classValue="QRYEVEN";
		else classValue="QRYODD";
	%>
<tr>
			<%if(current_item.equals(previous_item)){
			%>
			<td class="<%=classValue%>"  >&nbsp;</td>
			<%}else{%>
			<td class="<%=classValue%>"  ><%=ht2.get("item_desc")%></td>
			<%}%>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align GRN Qty, Value.				
					-->
			<td class="<%=classValue%>" style="TEXT-ALIGN:right" ><%=bean.setNumber((String)ht.get("grn_item_qty"),Integer.parseInt(no_deci))%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=ht.get("batch_id")%>&nbsp;</td>
			<!-- Added for IN:071539 START-->
			<%if(exp_date_disp_appl){ %>
			<td class="<%=classValue%>" > <%=ht.get("expiry_date_or_receipt_date")%>&nbsp;</td>
			<%} %>
			<!-- Added for IN:071539 END -->
			<%
				String value =  (((Double.parseDouble((String)ht.get("grn_item_qty")) ) * (Double.parseDouble(bean.setNumber((String)alData.get("grn_unit_cost_in_pur_uom"),noOfDecimalsForCost)))))+"";
				String item_value = bean.setNumber(value,noOfDecimalsForCost);
				trade_name=bean.checkForNull((String)bean.fetchRecord("SELECT SHORT_NAME FROM AM_TRADE_NAME_LANG_VW  WHERE TRADE_ID=? AND LANGUAGE_ID=? ",new String[]{(String)ht.get("trade_id"),locale}).get("SHORT_NAME"));
				if (trade_name.length()==0){
				trade_name=(String)ht.get("trade_id");
				
				}
				bin_desc =bean.checkForNull((String)bean.fetchRecord("SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW  WHERE BIN_LOCATION_CODE=? AND LANGUAGE_ID=? AND STORE_CODE=? ",new String[]{(String)ht.get("bin_location_code"),locale,(String)ht.get("store_code")}).get("SHORT_DESC"));
			%>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right">
			<%=item_value%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=trade_name %>&nbsp;</td>
			<td class="<%=classValue%>" > <%=bin_desc%>&nbsp;</td>
	</tr>
	<%
		previous_item		= current_item;
	//	pre_item_cost_val	= curr_item_cost_val;
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

