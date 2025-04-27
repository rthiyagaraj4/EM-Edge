<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" eST.AdjustStockBean, eST.Common.* , eCommon.Common.*, java.util.HashMap, java.util.ArrayList" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> 
		</title>
	<%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js">	</script>
 -->		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javaScript" src="../../eST/js/AdjustStock.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<style type="text/css">
			input{
				font-size: 10px;
			}
			select{
				font-size: 10px;
			}
		</style>
		
	<%
		try{
			AdjustStockBean bean = (AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
			bean.setLanguageId(locale);
			StHeaderBean beanHdr = (StHeaderBean) bean.getStHeaderBean();
			beanHdr.setLanguageId(locale);
//			StHeaderBean beanHdr = (StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean",request );
		
			HashMap hashDtl=new HashMap();
			String sys_date=bean.getSysDate();
			String store_code=beanHdr.getStore_code();
			String doc_date=beanHdr.getDoc_date();
			String doc_type_code=beanHdr.getDoc_type_code();
			String doc_no=beanHdr.getDoc_no();
			String doc_ref=beanHdr.getDoc_ref();
			String trn_type=beanHdr.getTrn_type();
			String dflt_trade_id="";
			//To set values in AdjustStockBean
//			bean.setAdjustStockHeaderBean(beanHdr);
			String item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
			String item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
			String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
			String batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
			String trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
			trade_id_applicable_yn = trade_id_applicable_yn.trim();
			String uom = bean.checkForNull(request.getParameter("uom"));
			// default batch_id to be fetched from mm_parameter
			String disable_batch_id="";
			String disable_expiry_date="";
			String expiry_date="";
			String default_batch_id="";	
		//	String default_trade_id="";	
			String default_bin_location_code="";
			String expiry_date_or_receipt_date="";
			String item_qty1="";
			String dec_allowed_yn="N";

			//String date_legend="Expiry Dt";
			String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
//			int x=0;
			int y=0;
            //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013
			HashMap HMData = new HashMap();
			String next_batch_id = "";
			String batch_id_series = ""; 
           //ends
			default_bin_location_code=bean.getDefaultBinLocationCode(item_code);
			dflt_trade_id=(String)bean.getDefault_trade_id();

			if(expiry_yn.equals("N")) {
				expiry_date = doc_date;
				disable_expiry_date="disabled";
				//date_legend="Receipt Dt";
				date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}		
			
		/*	if(trade_id_applicable_yn.equals("N")) {
				default_trade_id = (String)bean.getDefault_trade_id();
			}*/

			if(batch_id_applicable_yn.equals("N")) {
				disable_batch_id="disabled";
				default_batch_id = (String)bean.getDefault_batch_id();
			}
			else if(batch_id_applicable_yn.equals("E")) {
				if(expiry_yn.equals("N")) {
					default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
				}

				disable_batch_id="disabled";			
			}
			//fetch item params from bean
			String doc_srl_no = request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
			String mode = request.getParameter("mode");
			
			  /**
				* @Name - Priya
				* @Date - 13/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
				*/
			int no_of_decimals = bean.getNoOfDecimals();
			/**END**/
		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {

			}

			String bin_location_code_List=bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale);
			
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013
			String disposable_yn = request.getParameter("disposable_yn")==null?"N":request.getParameter("disposable_yn");
			 if(disposable_yn.equals("Y")){
			 if((doc_srl_no.equals("-1"))) {
			  HMData  = bean.getDisp_batch(store_code);
			       default_batch_id     =   bean.checkForNull((String)HMData.get("NEXT_BATCH_ID"));
				   next_batch_id         =  bean.checkForNull((String)HMData.get("NEXT_BATCH_ID"));
			       batch_id_series       =  bean.checkForNull((String)HMData.get("BATCH_ID_SERIES"));
		    String dflt_batch_id         =  bean.checkForNull(bean.getDflt_batch_id(),"");
				   System.out.println("dflt_batch_id"+dflt_batch_id);
				   if(!dflt_batch_id.equals("") && Integer.parseInt(dflt_batch_id) >= Integer.parseInt(default_batch_id)){
				   default_batch_id       =  "";
				   int dflt_btch_id       =  Integer.parseInt(dflt_batch_id);
				   dflt_btch_id           =   dflt_btch_id+1;
				   dflt_batch_id           =   ""+dflt_btch_id;
				   default_batch_id        =   dflt_batch_id;
				   next_batch_id           =    dflt_batch_id;
				   }
                }
			   default_batch_id       =   batch_id_series+default_batch_id;
		       expiry_date            =   bean.checkForNull((String)bean.getDisp_Expdate());
			   disable_batch_id       =   "disabled";
			   disable_expiry_date    =   "disabled";
			 expiry_date	=  com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
			/* if(default_batch_id.equals("")){
			 expiry_date = "";
			 default_batch_id = "";
		      disable_batch_id="disabled";
			 disable_expiry_date="disabled";
			  }*/
			}
			 //ends
	%>
	</head>
	<body onLoad="reloadTheBatchDetails();">
		<form name=formAdjustStockListDetail>
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center>
				<th>
					<%=date_legend%>
				</th>
				<th>
					<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
				</th>
				<th>
					<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>
				</th>
				<th>
					<fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/>
				</th>
				<th>
					<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
				</th>
	<%
	dec_allowed_yn=bean.getAllowDecimalsYN(item_code);
	if(!(doc_srl_no.equals("-1"))) {
		/**
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		
		if(dec_allowed_yn.equals("N")){
			no_of_decimals = 0;
		}
		/**END**/
		ArrayList ALExp=new ArrayList();
		ALExp=bean.getExpList(doc_srl_no);

	
	
		for(int i=0;i<ALExp.size();i++) {
			hashDtl=(HashMap)ALExp.get(i);
	expiry_date_or_receipt_date=   (String)hashDtl.get("expiry_date_or_receipt_date");
	   if(!locale.equals("en"))
			{
	//	out.println(	expiry_date_or_receipt_date);	
			expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
		//	out.println(	expiry_date_or_receipt_date);	
			}
			
	
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013
	default_batch_id =   (String)hashDtl.get("batch_id");
	 if(disposable_yn.equals("Y")){
    String chk_batch_id     =  bean.checkForNull(bean.getDflt_batch_id(),"");
    int dflt_len    =   default_batch_id.length();
	int chk_batch  =  chk_batch_id.length();
	int total_diff = dflt_len -chk_batch;
	next_batch_id = default_batch_id.substring(total_diff); 
	 }
	//ends
	 %>
	 

	 <tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" <%=disable_expiry_date%>  value="<%=expiry_date_or_receipt_date%>" size=10 maxlength=10 
			onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>','<%=locale%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CheckDateLeap(this,'DMY','<%=locale%>');" <%=disable_expiry_date%>>
			
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="if ('<%=disable_expiry_date%>' !== 'disabled') { return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>'); }"<%=disable_expiry_date%>></img>
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=default_batch_id%>" oninput="this.value = this.value.toUpperCase()" size=20 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" >
		</td>
		<td class='fields'>
	<%
			
			if(trade_id_applicable_yn.equals("Y")) {
	%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" > 	
					<%=bean.getTradeList(item_code,(String)hashDtl.get("trade_id"))%>		
				</select>
	<%
			}
			else if(trade_id_applicable_yn.equals("N")) {
	%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled> 	
					<%=bean.getTradeListDflt((String)hashDtl.get("trade_id"))%>
				</select>
	<%
			}
	%>
		</td>
		<td class='fields'>
			<select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>">
				<%=bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)%>
			</select>
		</td>
		<%
		String adjustment_type=(String)hashDtl.get("adjustment_type");
		 item_qty1=(String)hashDtl.get("item_qty");
		String  first=(String)hashDtl.get("first");

		 if(!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) && first.equals("Y")))
		 if(adjustment_type.equals("N")){
			 item_qty1=Double.parseDouble(item_qty1)*(-1)+"";
		 }
	%>
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" value="<%=bean.setNumber(bean.checkForNull((String)item_qty1,"0"),no_of_decimals).replace(".", "")%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkDoubleFormatForAllNumbers(this);checkAvlQty(this,'<%=i%>')" size=12 maxlength=12>
		</td>
	</tr>
	<%	
			y=i;
		}
		y++;
		ALExp.clear();
		for(int j=y;j<10;j++) {
			
	%>	 
	<tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=j%>" id="expiry_date_or_receipt_date_<%=j%>" value="<%=expiry_date%>" size=10 maxlength=10 <%=disable_expiry_date%>  
			onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=j%>,<%=j%>,'<%=batch_id_applicable_yn%>','<%=locale%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CheckDateLeap(this,'DMY','<%=locale%>');" <%=disable_expiry_date%>><!--Added CheckDateLeap and locale by B.Badmavathi for SRR20056-SCF-14071 on 22/7/2015-->

			<%-- <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=j%>');" <%=disable_expiry_date%>></img> --%>
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="if ('<%=disable_expiry_date%>' !== 'disabled') { return showCalendarLocal('expiry_date_or_receipt_date_<%=j%>'); }"<%=disable_expiry_date%>></img>
				
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=j%>" id="batch_id_<%=j%>" value="<%=default_batch_id%>" oninput="this.value = this.value.toUpperCase()" size=20 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" >
		</td>
		<td class='fields'>
				<%if(trade_id_applicable_yn.equals("Y")){%>
			<select name="trade_id_<%=j%>" id="trade_id_<%=j%>" ><%=bean.getTradeList(item_code,dflt_trade_id)%>		</select>
				<%}else if(trade_id_applicable_yn.equals("N")){ %>
			<select name="trade_id_<%=j%>" id="trade_id_<%=j%>"  disabled ><%=bean.getTradeListDflt(dflt_trade_id)%></select>
				<%}%>
		</td>
		<td class='fields'>
			<select name="bin_location_code_<%=j%>" id="bin_location_code_<%=j%>">
				<%=bin_location_code_List%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=j%>" id="item_qty_<%=j%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkAvlQty(this,'<%=j%>')" size=12 maxlength=12>
		</td>
	</tr>
	<%
		}
	}
	else {

		
		for(int i=0;i<10;i++) {
	%>
	<tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=expiry_date%>" size=10 maxlength=10 onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>','<%=locale%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CheckDateLeap(this,'DMY','<%=locale%>');" <%=disable_expiry_date%>>
			<%-- <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');" <%=disable_expiry_date%>> --%></img>						   <!-- Added CheckDateLeap and Locale  by B.Badmavathi for SRR20056-SCF-14071 on 22/7/2015--> 
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="if ('<%=disable_expiry_date%>' !== 'disabled') { return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>'); }"<%=disable_expiry_date%>></img>
		
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=i%>" id="batch_id_<%=i%>" oninput="this.value = this.value.toUpperCase()" value="<%=default_batch_id%>" size=20 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" >
		</td>
		<td class='fields'>
			<%

				if((trade_id_applicable_yn.trim()).equals("Y")) {
			%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>">
					<%=bean.getTradeList(item_code,dflt_trade_id)%>		
				</select>
			<%
				}
				else if((trade_id_applicable_yn.trim()).equals("N")) {
			%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled > 
					<%=bean.getTradeListDflt(dflt_trade_id.trim())%>
				</select>
			<%
				}
			%>
		</td>
		<td class='fields'><select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>">				<%=bin_location_code_List%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" class="NUMBER"onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkAvlQty(this,'<%=i%>')" size=12 maxlength=12>
		</td>
	</tr>

	<%

		}
	}
	%>

	<%
		if(! (doc_srl_no.equals("-1") )) {
	%>
	<tr>
		<td colspan=7 class=WHITE>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=3 class=WHITE></td>
		<td  colspan=2 class=WHITE><input type=button name=Modify value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' class=button onclick="if(issueUOMQtyChk()) addToList('modify');"><input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class=button onclick="cancel_me();"></td>
	</tr>
	<%}else{%>
	<tr>
		<td colspan=7 class=WHITE>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=3 class=WHITE></td>
		<td  colspan=2 class=WHITE><input type=button name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class=button onclick="if(issueUOMQtyChk()) addToList('add');"><input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
	</tr>
	<%}%>
	
</table>
    <input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="finalized" id="finalized" value="N">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
	<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
	<input type="hidden" name="item_desc" id="item_desc" value="<%=item_desc%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="doc_date" id="doc_date" value="<%=doc_date%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="doc_ref" id="doc_ref" value="<%=doc_ref%>">
	<input type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
	<input type="hidden" name="expiry_yn" id="expiry_yn" value="<%=expiry_yn%>">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn" value="<%=batch_id_applicable_yn%>">
	<input type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn" value="<%=trade_id_applicable_yn%>">
	<input type="hidden" name="uom" id="uom" value="<%=uom%>">
	<input type="hidden" name="doc_srl_no" id="doc_srl_no" value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">

	<!-- code added for batch checking -->
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="AdjustStockBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eST.AdjustStockBean">
	<input type="hidden" name="function_id" id="function_id" value="ST_ADJUST_STOCK">
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="0">
	<input type="hidden" name="records_to_delete" id="records_to_delete" value="0">
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
	<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 -->
	<input type="hidden" name="next_batch_id" id="next_batch_id" value="<%=next_batch_id%>">

	<!-- <input type="hidden" name="adjustment_type" id="adjustment_type" value="P"> -->
	<!-- code ended -->

	<script>
		if(document.forms[0].trade_id_0) {
			if(document.forms[0].trade_id_0.length==1) {
				alert(getMessage("TRADE_NOT_ASS_FOR_ITEM","ST"));
				parent.frameAdjustStockListHeader.location.reload();
				self.location.href="../../eCommon/html/blank.html";
			}
			else if(document.forms[0].bin_location_code_0.length==1) {
				
				alert(getMessage("BIN_LOCN_NOT_ASS_FOR_STORE","ST"));
				parent.frameAdjustStockListHeader.location.reload();
				self.location.href="../../eCommon/html/blank.html";
			}
		}
	</script>
</form>
		<%
//putObjectInBean("adjustStockBean",bean,request);
//putObjectInBean("stHeaderBean",beanHdr,request);
%>
</body>
</html>
	<%
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	%>
	

