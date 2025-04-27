<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
05/02/2021      TFS id:6938        B Haribabu          05/02/2021                     MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.AcknowledgmentBean,java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eST/js/Acknowledgment.js'></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String classvalue		= "";
		String temp_item_code	= "";
		String bin_disable		= "";
		String doc_no			= request.getParameter("doc_no");
		String seq_no			= request.getParameter("seq_no");
		String hdr_index		= request.getParameter("index");
		String fm_store_code	= request.getParameter("fm_store_code");
		String to_store_code	= request.getParameter("to_store_code");
		String visibility		= "visibility:hidden";
		String psuspended_yn = null; 
		String barcode_appl_for_ack_yn="N";//Added for TFS id:6938
		double pending_qty		= 0;
		double pending_qty_1   = 0;
		AcknowledgmentBean bean	=	(AcknowledgmentBean) getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
		bean.setToStore(to_store_code);
		if(((String)bean.getAction_type()).equals("C")){
			bin_disable			=	"disabled";
		}
 	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
	
	boolean validatebarcode		=	bean.isBarCodeApplicableForValidation("VALIDATEBARCODE",bean.getTrn_type());//Added for RUT-CRF-0079
	 barcode_appl_for_ack_yn = bean.getBarcodeApplForAckYN();//Added for TFS id:6938
	%>
	<body onload='copyVals()'>
	<form name="formAcknowledgeList" id="formAcknowledgeList">
	<%
		ArrayList result = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
//		out.println("result = > "+result);
		if(result.size()<=0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}else{
	%>
	<%
	if(validatebarcode && ((String)bean.getAction_type()).equals("A")){
	%>
	<table border='0' cellpadding='1' cellspacing='1' width=100% align=center>
		<tr>		
		<td class="label" width="55%" >&nbsp;&nbsp;<input style="font-family:verdana;" type="text" name="search_str" id="search_str" value="Scan Barcode" size=25 maxlength=50  title="Scan Barcode"  onclick = 'if(this.value=="Scan Barcode"){ this.value=""};else if(this.value!=""){this.select()};' onblur='if(this.value==""){ this.value="Scan Barcode"};'  onkeyPress="CallBarcodeVerifyItems(event,this,<%=doc_no%>,<%=seq_no%>)"></td>

		<td class="STLIGHTPINK" >&nbsp;&nbsp;</td>
		<td class="label" ><fmt:message key="eST.CurrentRecord.label" bundle="${st_labels}"/></td>		
		<td class="FOREDITOR">&nbsp;&nbsp;</td>
		<td class="label"><fmt:message key="eST.ScannedRecord.label" bundle="${st_labels}"/></td>
		<td bgcolor="WHITE" style='border: 1px solid;border-style:solid;border-color:lightblue;'>&nbsp;&nbsp;</td>
		<td class="label"><fmt:message key="eST.PendingForScanning.label" bundle="${st_labels}"/></td>
		</tr>
	</table>
	<%} %>
	<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
			<th width="20%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
			<!--commented BY Rabbani #inc no:29332 on 20/10/11-->
			<!--<th><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></th>-->
			<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
<%
if((bean.getTrn_type()).equals("ISS")){//Added For RUT-SCF-0079
%>
			<th colspan=5><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
<%
}else{
%>
			<th colspan=4><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
<%} %>
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
		<!-- Modified for TFS id:6938 start -->
		<%if((barcode_appl_for_ack_yn.equals("Y")) && ((String)bean.getAction_type()).equals("A")){ %>
		<td class=label colspan=2 nowrap><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type=text name=barcode id=barcode size=80  maxlength=100 value="" onkeyPress="CallBarcodeVerifyItemBatches(event,this,<%=doc_no%>,<%=seq_no%>,'<%=no_of_decimals%>')" ></td>
		<%}else{ %>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<%} %>
			<!-- Modified for TFS id:6938 end-->
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
<%
if((bean.getTrn_type()).equals("ISS")){//Added For RUT-SCF-0079
%>
			<th><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>	
<%
}
%>		
			<th><fmt:message key="Common.Issued.label" bundle="${common_labels}"/></th>
			<th>Pending for Ack.</th>
			<th><fmt:message key="Common.received.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></th>
			<td>&nbsp;</td>
		</tr>
	<%
	    ArrayList alTemp	= null;
		HashMap   hmTemp	= null;
		HashMap hmRecord = new HashMap();
		for(int i=0;i<result.size();i++){
			if (i % 2 == 0)
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			   hmRecord = (HashMap)result.get(i);
			     //Added By Rabbani,  #inc no:29537 on 15/11/11
				  //Starts Here
				   
			       String stItem_code =(String)hmRecord.get("ITEM_CODE");
				   String stBatch_id=(String)hmRecord.get("BATCH_ID");
				   String stExpiry_date=(String)hmRecord.get("EXPIRY_DATE");
					
				alTemp = bean.getBatchStatus(stItem_code,stBatch_id,stExpiry_date);
				hmTemp = (HashMap)alTemp.get(0) ;
                String stBatch_status =  (String)hmTemp.get("BATCH_STATUS") ;
				psuspended_yn = bean.ProcessSuspendedYN();
				  //Ends Here
				  
	%>
			<tr id="tr_<%=i%>">

			<%if(!temp_item_code.equals((String)hmRecord.get("ITEM_CODE"))){%>
				<td class="<%=classvalue%>"><%=hmRecord.get("ITEM_DESC")%></td>
			<%}else{%>
				<td class="<%=classvalue%>">&nbsp;</td>
			<%}
 	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.setNumber method is called wherever Quantity is used.
	*/
					//if((bean.getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE"))).equals("N")){
					if(((String)hmRecord.get("ALLOW_DECIMALS_YN")).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}
			%>
				<td class="<%=classvalue%>"><%=hmRecord.get("UOM")%></td>
				<!--Added By Rabbani for displaying Suspended Label on 15/11/11 Starts Here -->
				<%if(stBatch_status.equals("S")){%>
				<td class="<%=classvalue%>"><%=hmRecord.get("BATCH_ID")%><br><font class="DATAHIGHLIGHT"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></font></td>
				<%}else{%>
				<td class="<%=classvalue%>"><%=hmRecord.get("BATCH_ID")%></td>
				<%}%>
				<!-- Ends Here -->
				 <td class="<%=classvalue%>"><%=com.ehis.util.DateUtils.convertDate((String)hmRecord.get("EXPIRY_DATE"),"DMY","en",locale)%></td> 
				<!--<td class="<%=classvalue%>"><%=hmRecord.get("EXPIRY_DATE")%></td>-->
				<!--commented BY Rabbani #inc no:29332 on 20/10/11
				<td class="<%=classvalue%>"><%=hmRecord.get("TRADE_ID")%></td>-->
				<td class="<%=classvalue%>"><%=hmRecord.get("TRADE_NAME")%></td>
				
				<td class="<%=classvalue%>">
				<!-- Added by Rabbani #Inc no:40697(GHL-SCF-750) on  13-JUN-2013 -->
					<%
					if(((String)bean.getAction_type()).equals("C") || ((String)hmRecord.get("STOCK_ITEM_YN")).equals("N")){
					%>
					<select name="bin_location_<%=i%>" id="bin_location_<%=i%>" <%=bin_disable%>><%=bean.getBin_Location_List((String)hmRecord.get("NEW_BIN_LOCATION_CODE"),doc_no,(String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("STOCK_ITEM_YN"),seq_no)%></select>
                    <%}else{%>
					 <select name="bin_location_<%=i%>" id="bin_location_<%=i%>" <%=bin_disable%>><%=bean.getSTITBin_location_code_List(to_store_code,(String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("DFLT_BINLOCATION_CODE"),locale)%></select> 
					<%}%>
				</td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Issued Quantity.				
					-->
					
					<% //Added For RUT-SCF-0079
					if((bean.getTrn_type()).equals("ISS")){
						if(!temp_item_code.equals((String)hmRecord.get("ITEM_CODE"))){%>
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right" ><%=bean.setNumber((String)hmRecord.get("REQ_ITEM_QTY"),no_of_decimals)%>&nbsp;</td>
						<input type="hidden" name="barcode_item_exist_<%=i%>" id="barcode_item_exist_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("BARCODE_ITEM_EXIST"),"N")%>">
					<%}else{%>
						<td class="<%=classvalue%>">&nbsp;</td>
					<%}
					}
					%>					

				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" ><%=bean.setNumber((String)hmRecord.get("QTY"),no_of_decimals)%>&nbsp;</td>
				<%if(((String)bean.getAction_type()).equals("A")){ %>
					<td class="<%=classvalue%>">
						<input type="text" class ="NUMBER" size = 10 maxlength=15 name="pending_qty_<%=i%>" id="pending_qty_<%=i%>"  value="<%=(bean.checkForNull((String)hmRecord.get("PEN_RCD_QTY"))).equals("")?"":bean.setNumber((String)hmRecord.get("PEN_RCD_QTY"),no_of_decimals)%>" readonly>
					</td>
					<td class="<%=classvalue%>">
						<input type="text" class ="NUMBER" size = 10 maxlength=12 name="received_qty_<%=i%>" id="received_qty_<%=i%>" onblur="checkDoubleFormat(this,false);populateRejQuantity('<%=i%>','<%=no_of_decimals%>');CallBarcodeVerifyItems(event,'','','');" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>,'<%=(String)hmRecord.get("ALLOW_DECIMALS_YN")%>');" value="<%=(bean.checkForNull((String)hmRecord.get("TMP_RECEIVED_QTY_1"))).equals("")?"0":bean.setNumber((String)hmRecord.get("TMP_RECEIVED_QTY_1"),no_of_decimals)%>" ><!-- Modified for TFS id:6938 -->
					</td>
					<td class="<%=classvalue%>"><input type="text" class ="NUMBER" size = 8 maxlength=12 name="rejected_qty_<%=i%>" id="rejected_qty_<%=i%>" onblur="checkDoubleFormat(this,false);populateRejQuantity('<%=i%>','<%=no_of_decimals%>');showRemarksImg(img_<%=i%>,<%=i%>);CallBarcodeVerifyItems(event,'','','')" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>,'<%=(String)hmRecord.get("ALLOW_DECIMALS_YN")%>');" value="<%=(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_1"))).equals("")?"":bean.setNumber((String)hmRecord.get("TMP_REJECTED_QTY_1"),no_of_decimals)%>" ></td>
					 
				<%
				pending_qty = Double.parseDouble(bean.checkForNull((String)hmRecord.get("PEN_RCD_QTY"),"0"))+Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_RECEIVED_QTY_1"),"0"))+Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_1"),"0"));
					 
				%>
				
					<%}else{ %>
					<td class="<%=classvalue%>">
						<input type="text" class ="NUMBER" size = 10 maxlength="10" name="pending_qty_<%=i%>" id="pending_qty_<%=i%>"  value="<%=(bean.checkForNull((String)hmRecord.get("PEN_RCD_QTY"))).equals("")?"":bean.setNumber((String)hmRecord.get("PEN_RCD_QTY"),no_of_decimals)%>" readonly>
					</td>
					<td class="<%=classvalue%>">
						<input type="text" class ="NUMBER" size = 10 maxlength="10" name="received_qty_<%=i%>" id="received_qty_<%=i%>"  value="<%=(bean.checkForNull((String)hmRecord.get("TMP_RECEIVED_QTY_2"))).equals("")?"":bean.setNumber((String)hmRecord.get("TMP_RECEIVED_QTY_2"),no_of_decimals)%>" readonly>
					</td>
					<td class="<%=classvalue%>"><input type="text" class ="NUMBER" size = 8 maxlength=7 name="rejected_qty_<%=i%>" id="rejected_qty_<%=i%>"  value="<%=(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_2"))).equals("")?"":bean.setNumber((String)hmRecord.get("TMP_REJECTED_QTY_2"),no_of_decimals)%>" readonly></td>

				<!--Added by Rabbani for displaying Received Qty in confirmation,#inc no:29332 on 13/10/11-->
				<%
				pending_qty =  Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_RECEIVED_QTY_2"),"0")); 
				  
				 pending_qty_1 = Double.parseDouble(bean.checkForNull((String)hmRecord.get("PEN_RCD_QTY"),"0"))+Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_RECEIVED_QTY_1"),"0"))+Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_1"),"0"));
				}
				if(!((String)bean.getAction_type()).equals("C")){
					if(Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_1"),"0"))>0){
						visibility = "visibility:visible";
					}else{
						visibility = "visibility:hidden";
					}
					%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks(<%=i%>);"><font class="HYPERLINK"><fmt:message key="Common.Add.label" bundle="${common_labels}"/></font>
					<img id="img_<%=i%>" name="img_<%=i%>" src="../../eCommon/images/mandatory.gif" style="<%=visibility%>"/>
				<%}else{
					if(Double.parseDouble(bean.checkForNull((String)hmRecord.get("TMP_REJECTED_QTY_2"),"0"))>0){
						visibility = "visibility:visible";
					}else{
						visibility = "visibility:hidden";
					}
				%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks(<%=i%>);"><font class="HYPERLINK"><fmt:message key="eST.Show.label" bundle="${st_labels}"/></font>
					<img id="img_<%=i%>" src="../../eCommon/images/mandatory.gif" style="<%=visibility%>"/>
				<%}
				%>
				<input type=hidden name="issued_qty_<%=i%>" id="issued_qty_<%=i%>" value="<%=bean.setNumber((String)hmRecord.get("QTY"),no_of_decimals)%>">
				<input type=hidden name="pending_qty_temp_<%=i%>" id="pending_qty_temp_<%=i%>" value="<%=bean.setNumber(""+pending_qty,no_of_decimals)%>">
				 <input type=hidden name="pending_qty_1_<%=i%>" id="pending_qty_1_<%=i%>" value="<%=bean.setNumber(""+pending_qty_1,no_of_decimals)%>">
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("REMARKS"))%>">
				<input type="hidden" name="stock_item_yn_<%=i%>" id="stock_item_yn_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("STOCK_ITEM_YN"))%>">
				<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("ITEM_CODE"))%>">
				<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("ITEM_DESC"))%>">
				<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("BATCH_ID"))%>">
				<input type="hidden" name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("EXPIRY_DATE"))%>">
				<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("BIN_LOCATION_CODE"))%>">
				<input type="hidden" name="doc_type_code_<%=i%>" id="doc_type_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("DOC_TYPE_CODE"))%>">
				<input type="hidden" name="stBatch_status_<%=i%>" id="stBatch_status_<%=i%>" value="<%=stBatch_status%>">
				<input type="hidden" name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("BARCODE_ID"))%>">								
				</td>
			</tr>
	<%
		temp_item_code = (String)hmRecord.get("ITEM_CODE");
		}
	%>
		<table border='0' cellpadding='0' cellspacing='0' width=100% align=center>
			<%if(!((String)bean.getAction_type()).equals("C")){%>
				<tr>
					<td colspan=6 class="label" width="62%">&nbsp;</td>
					<td class="label" align="right"><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="checkbox" name="entry_completed_<%=doc_no%>" id="entry_completed_<%=doc_no%>" value='Y' onclick="checkAllValues(this)" <%=bean.getChecked(bean.checkForNull((String)hmRecord.get("ENTRY_COMPLETED"),"N"))%> checked></td>
					<td  style="display:none" class='fields'>&nbsp;<input type="button" class="button" name="copy" id="copy" value='<fmt:message key="eST.CopyValues.label" bundle="${st_labels}"/>'  onClick="copyVals();"></td>
					<td class='fields'>&nbsp;<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>'  onClick="saveVals();"></td>
				</tr>
			<%}else{%>
				<tr>
					<td colspan=8 class="label" width="90%">&nbsp;</td>
					<td class='fields'>&nbsp;<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>'  onClick="saveVals();"></td>
				</tr>
			<%}%>
		<table>
	<input type="hidden" name="total_records" id="total_records" value="<%=result.size()%>">
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="seq_no" id="seq_no" value="<%=seq_no%>">
	<input type="hidden" name="hdr_index" id="hdr_index" value="<%=hdr_index%>">
	<input type="hidden" name="fm_store_code" id="fm_store_code" value="<%=fm_store_code%>">
	<input type="hidden" name="to_store_code" id="to_store_code" value="<%=to_store_code%>">
	<input type="hidden" name="bean_id" id="bean_id" value="acknowledgmentBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eST.AcknowledgmentBean">
	<input type="hidden" name="process_suspended_yn_" id="process_suspended_yn_" value= "<%=bean.checkForNull(psuspended_yn,"N")%>">
	<input type="hidden" name="validatebarcode" id="validatebarcode" value="<%=validatebarcode%>">
	<input type="hidden" name="barcode_appl_for_ack_yn" id="barcode_appl_for_ack_yn" value="<%=barcode_appl_for_ack_yn%>"><!-- Added for TFS id:6938 -->
	
	 
	
	</table>
	<%}%>
	</form>
	</body>
</html>

