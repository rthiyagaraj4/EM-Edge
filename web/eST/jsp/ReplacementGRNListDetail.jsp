<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javaScript" src="../../eST/js/ReplacementGRN.js"></script>
	<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	ReplacementGRNBean bean = (ReplacementGRNBean) getBeanObject("replacementGRNBean",   "eST.ReplacementGRNBean", request);
 	bean.setLanguageId(locale);
	ArrayList alExpRecords	=	new ArrayList();
	String	sys_date		=	bean.getSysDate();
	// pmd 29/01/05
//	String	store_code		=	bean.getStore_code();

	//To set values in ReplacementGRNBean

	String	item_code = request.getParameter("item_code");
	String	index = bean.checkForNull(request.getParameter("index"),"-1");
	if (item_code==null) {
		return;
	}
	String allow_deci_yn = "";
    String no_deci    = "";
    allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";


	HashMap hmItemRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_FOR_GRN"),item_code);
	String  batch_id_applicable_yn	=(String)hmItemRecord.get("BATCH_ID_APPLICABLE_YN");
	String	trade_id_applicable_yn	=(String)hmItemRecord.get("TRADE_ID_APPLICABLE_YN");
	String	expiry_yn				=(String)hmItemRecord.get("EXPIRY_YN");	
	// default batch_id to be fetched from mm_parameter
	String disable_batch_id="";
	String disable_expiry_date="";
	String expiry_date="";
	String default_batch_id="";
	String default_trade_id="";
//	String default_bin_location_code=(String)bean.getMm_parameter().get("BIN_LOCATION_CODE");	
//	String date_legend="Expiry Dt";
    String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
//	int x=0;
//	int y=0;
//	expiry_date = sys_date;
	HashMap hmTemp	=	(HashMap)bean.fetchRecord("select LESSER_SALE_PRICE_YN,SALE_PRICE_APPL_YN from st_acc_entity_param");
	
	String  lesser_sale_price_yn	=	(String)hmTemp.get("LESSER_SALE_PRICE_YN");
	String  sale_price_appl_yn		=	(String)hmTemp.get("SALE_PRICE_APPL_YN");
	HashMap hmTmpExpRecords			=	new HashMap();
	if(expiry_yn.equals("N")) {
		expiry_date = sys_date;
		disable_expiry_date="disabled";
		date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
	}		
	
	if(trade_id_applicable_yn.equals("N")) {
		default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
	}

	if(batch_id_applicable_yn.equals("N")) {
		disable_batch_id="disabled";
		default_batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
	}
	else if(batch_id_applicable_yn.equals("E")) {
		if(expiry_yn.equals("Y")) {
			if (!expiry_date.equals("")) {
				default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			}
		}
		disable_batch_id="disabled";			
	}
	if(!index.equals("-1")){
		ArrayList alTmpExpRecords=(ArrayList)bean.getExpRecords(Integer.parseInt(index.trim()));
		hmTmpExpRecords=(HashMap)alTmpExpRecords.get(0);
	}
	
	
	String shelf_life	=	bean.checkForNull((String)bean.fetchRecord("select SHELF_LIFE from MM_ITEM_LANG_VW where ITEM_CODE = ? and LANGUAGE_ID= ?",new String[]{item_code,locale}).get("SHELF_LIFE"),"N");
	String shelf_life_no = "";
	String shelf_life_time = "";
	if(shelf_life != null && shelf_life.length() > 0){
		 shelf_life_time = shelf_life.substring(shelf_life.length() - 1);
		 shelf_life_no = shelf_life.substring(0,shelf_life.length() - 1);
	}
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String shelfLifeDate	       = "";
	int s_life = 0 ;
	if(!shelf_life_no.equals(""))
		s_life = Integer.parseInt(shelf_life_no);
	if(shelf_life_time.equals("D")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"d");
	}else if(shelf_life_time.equals("M")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"M");
	}else if(shelf_life_time.equals("Y")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"Y");
	}

	
	
%>

<body>
<form name="formGoodsReceivedNoteListDetail" id="formGoodsReceivedNoteListDetail">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align="center">
	<tr>
		<th><%=date_legend%></th>
		<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<%if(sale_price_appl_yn.equals("Y")){%>
			<th nowrap>Sale Price/<%=bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)hmTmpExpRecords.get("gen_uom_desc")))%></th>
		<%}%>
	<%
	
	if(!index.equals("-1"))	
		alExpRecords=bean.getExpRecords(Integer.parseInt(index.trim()));
	
	for(int i=0;i<alExpRecords.size()||i<10;i++) {
		HashMap hmExpRecords=new HashMap();
		
		
		if(expiry_yn.equals("N")) {
			hmExpRecords.put("batch_id",default_batch_id);
			hmExpRecords.put("expiry_date_or_receipt_date",expiry_date);
		}
		if (i<alExpRecords.size()) 
			hmExpRecords	=	(HashMap)alExpRecords.get(i);
			
	 %>
	 <tr>
		<td class='fields'>
			<input class="STSMALL" type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" <%=disable_expiry_date%>  value="<%=com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmExpRecords.get("expiry_date_or_receipt_date")),"DMY","en",locale)%>" size=10 maxlength='10' onBlur="getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>);">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal  ('expiry_date_or_receipt_date_<%=i%>');" <%=disable_expiry_date%>></img>
		</td>
		<td class='fields' >
			&nbsp;
			<input type='text' class="UPPER" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=bean.checkForNull((String)hmExpRecords.get("batch_id"))%>"size=24 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" >
		</td>
		<td class='fields' >
			<select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>" >
			<%
				if(trade_id_applicable_yn.equals("Y")) {
			%>
				<%=bean.getTrade_id_List(item_code,(String)hmExpRecords.get("trade_id"))%>
			<%
				}
				else if(trade_id_applicable_yn.equals("N")) {
			%>
				<%=bean.getTrade_id_Default_List(bean.checkForNull((String)hmExpRecords.get("trade_id"),default_trade_id))%>
			<%
				}
			%>
			</select>
		</td>
		<td class='fields'>
			<select class="STSMALL" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>">
				<%=bean.getBin_location_code_List(bean.getStore_code(),bean.checkForNull((String)hmExpRecords.get("bin_location_code")),item_code)%>
			</select>
		</td>
			<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
				<%String grn_item_qty				=	(bean.checkForNull((String)hmExpRecords.get("grn_item_qty")).equals(""))?"":bean.setNumber((String)hmExpRecords.get("grn_item_qty"),Integer.parseInt(no_deci));%>
		<td class='fields' >
			<input class="STSMALL" type='text' name="grn_item_qty_<%=i%>" id="grn_item_qty_<%=i%>" value="<%=grn_item_qty%>"  style="text-align:right" onKeyPress="return isValidNumber(this,event,7,<%=Integer.parseInt(no_deci)%>);" onblur="checkDoubleFormat(this);" size=12 maxlength=12>
		</td>
		<%if(sale_price_appl_yn.equals("Y")){%>
<!-- 			<td class='fields' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input class="STSMALL" type='text' name="sale_price_<%=i%>" id="sale_price_<%=i%>" value="<%=bean.checkForNull((String)hmExpRecords.get("sale_price"))%>"  style="text-align:right" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);checkUnitCost(this);" size=8 maxlength=8>
			</td>
 -->		
			<%/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());%>
			<td  class='fields'>&nbsp;&nbsp;<input type=text name="sale_price_<%=i%>" id="sale_price_<%=i%>" size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="checkUnitCost(this);checkDoubleFormat(this, false);"  value="<%=bean.checkForNull((String)hmExpRecords.get("sale_price"))%>"></td>
		<%}%>
	</tr>
	<%	
		}
	%>

</table>
	<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
	<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=bean.getStore_code()%>">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn" value="<%=batch_id_applicable_yn%>">
	<input type="hidden" name="gen_uom_desc" id="gen_uom_desc" value="<%=bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)hmTmpExpRecords.get("gen_uom_desc")))%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">
	<input type="hidden" name="sale_price_appl_yn" id="sale_price_appl_yn" value="<%=sale_price_appl_yn%>">
	<input type="hidden" name="lesser_sale_price_yn" id="lesser_sale_price_yn" value="<%=lesser_sale_price_yn%>">
	<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
	<input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
	<input type="hidden" name="shelfLifeDate" id="shelfLifeDate"			value="<%=shelfLifeDate%>" >
	<script>
		if(document.getElementById('trade_id_0').length==1)
		{
			alert(getMessage("TRADE_NOT_ASS_FOR_ITEM","ST"));
			parent.frameGoodsReceivedNoteListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
		else if(document.getElementById('bin_location_code_0').length==1)
		{
			
			alert(getMessage("BIN_LOCN_NOT_ASS_FOR_STORE","ST"));
			parent.frameGoodsReceivedNoteListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
	</script>
</form>
		<%
//putObjectInBean("replacementGRNBean",bean,request);
		%>
</body>
</html>
	<% 
		}
		catch(Exception e) {
			e.printStackTrace();
					}
	%>

