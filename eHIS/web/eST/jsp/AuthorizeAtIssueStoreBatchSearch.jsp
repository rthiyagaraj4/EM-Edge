<!DOCTYPE html>
 <%
/*
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
24/07/2018						Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
08/10/2018       68642          B. Haribabu                             TTM-SCF-0198
16/11/2018		 69074			Shazana Hasan							GHL-ICN-0032
-----------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
 
 
 <%@ page import="eST.BatchSearchBean,eST.Common.StUtilities, eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,java.lang.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> <%//modified for GHL-CRF-0499 %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<title><fmt:message key="eST.ViewBatchDetails.label" bundle="${st_labels}"/></title>
		<%
	
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		AuthorizeAtIssueStoreBean bean						=		(AuthorizeAtIssueStoreBean) getBeanObject("authorizeAtIssueStoreBean","eST.AuthorizeAtIssueStoreBean",request);
		bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr	=		(eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		beanHdr.setLanguageId(locale);
		int i								=		0;
		int no_of_decimals_temp			=			bean.getNoOfDecimals();
		int no_of_decimals				=			0;
		String index						=		bean.checkForNull(request.getParameter("index"),"-1");
		//String doc_srl_no					=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function						=		bean.checkForNull(request.getParameter("function"));
		String fnction						=		bean.checkForNull(request.getParameter("function"));
		String remarks						=		bean.checkForNull(request.getParameter("remarks"));
		String remarks_code					=		bean.checkForNull(request.getParameter("remarks_code"));

		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		String item_code					=		bean.checkForNull(request.getParameter("item_code"));
		String store_code					=		bean.checkForNull(request.getParameter("store_code"));
		String to_store_code				=		bean.checkForNull(beanHdr.getTo_store_code());
		String item_qty						=		bean.checkForNull(request.getParameter("item_qty"));
		String iss_uom_qty_chk						=		bean.checkForNull(request.getParameter("iss_uom_qty_chk"));
		//String function_id				=		bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn					=		bean.checkForNull(request.getParameter("expiry_yn"));
		
		String doc_no						=		bean.checkForNull(request.getParameter("doc_no"));
		String doc_type_code				=		bean.checkForNull(request.getParameter("doc_type_code"));
		String trn_type						=		bean.checkForNull(request.getParameter("trn_type"));
		
		String addToList					=		request.getParameter("addToList");
		String kit							=		(String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		//Date d							=		new Date();
		bean.setRemarks(remarks);
		ArrayList alBatchRecords			=		new ArrayList();
		HashMap hmBatchRecord				=		new HashMap();
		//String BatchKey					=		"";
		String className					=		"";
		String decimal_allowed_yn			=		"N";
		//String date_legend				=		"Expiry Dt";
		String date_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		String includeSuspendedBatches		=		"N";
		HashMap hmRecord					=		new HashMap();
		int EWDays							=		0;
		int expired_batch					=		0;
		//Added for GHL-CRF-0499 starts 
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_DISPLAY_CHALLAN_NO");
		bean.setSite_spec_yn(site_main);
		//Added for GHL-CRF-0499 ends
		try { 
			EWDays							=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
		if(expiry_yn.equals("N")) {
			//date_legend					=		"Receipt Dt";
			date_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
		}
			String defaultBinLocationCode	=		bean.getDefaultBinLocationCode(to_store_code,item_code);	

		String Qty_disabled = "";
		String mode = bean.getMode();
		
		String facilityid	=		(String)session.getValue("facility_id");
		String batchChangeEnabled = "";
		ArrayList alParameters = new ArrayList();
		alParameters.add(facilityid);
		String allow_batch_search =		bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_AND_REMARKS_SELECT"),alParameters).get("ALLOW_BATCH_CHANGE_ON_AUTH"));
		if(allow_batch_search.equals("Y")){
			batchChangeEnabled = "enabled";
		}else{
			batchChangeEnabled = "disabled";
		}
		
		
		System.out.println("function in batch search = "+function);


			if (function.equals("changebatch"))
			{	//System.out.println("BatchSearchBean in AuthorizeAtIssueStoreBatchSearch.jsp");
				if(allow_batch_search.equals("Y")){
				if(bean.getExpRecords(item_code) != null)
					alBatchRecords				= bean.getExpRecords(item_code);
				else if(bean.getTempRecords(item_code) != null)
					alBatchRecords				= bean.getTempRecords(item_code);
				else	
					alBatchRecords				=		bean.getBatchDetails(item_code,store_code,iss_uom_qty_chk);
				System.out.println("alBatchRecords-----batchsearch--- if--->"+alBatchRecords);
				}else{
						alBatchRecords				=		bean.getBatchDetails(item_code,store_code,item_qty);
						System.out.println("alBatchRecords-----batchsearch---else--->"+alBatchRecords);
				}
				
			}
			else 
			{	//System.out.println("BatchSearchBean in AuthorizeAtIssueStoreBatchSearch.jsp");
				BatchSearchBean bean2		=		(BatchSearchBean)getBeanObject("batchSearchBean",  "eST.BatchSearchBean",request);
				bean2.setLanguageId(locale);
				alBatchRecords				=		bean2.getSelectedList();
				// System.out.println("alBatchRecords-----batchsearch------>"+alBatchRecords);
				 includeSuspendedBatches		=		bean2.getIncludeSuspendedBatches();
				if (alBatchRecords.size() >0)
				{
					for(i=0;i<alBatchRecords.size();i++){
							hmBatchRecord	=		(HashMap)alBatchRecords.get(i);
							hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
							hmBatchRecord.put("RET_ITEM_QTY",	"0");
					}
				}
				
					putObjectInBean("batchSearchBean",bean2,request);

			}
			
		
		%>
	<body onunload='exitBatchSearch1();'> <!--Added for TTM-SCF-0198-->
		<form name='formAuthorizeAtIssueStoreBatchSearch' id='formAuthorizeAtIssueStoreBatchSearch'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align=center> 
	<tr id="tr_<%=i%>">
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<!-- ADDED FOR GHL-CRF-0499 START -->
				<% if(site_main){ %>
				<th><fmt:message key="eST.ChallanNo.label" bundle="${common_labels}"/></th>
				<% } %>
				<!-- ADDED FOR GHL-CRF-0499 END -->
				
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ToStoreBin.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.AuthQty.label" bundle="${st_labels}"/></th>
			</tr>
			<%
			
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(HashMap)alBatchRecords.get(i);
			
 	
					if((bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"))).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
				
				//added for GHL-CRF-0499 START
				String challanNo= "";
				String itemCd = (String)hmBatchRecord.get("ITEM_CODE");
				String batchID = (String)hmBatchRecord.get("BATCH_ID");
				String expDate = (String)hmBatchRecord.get("EXPIRY_DATE");
				String storeCd = (String)hmBatchRecord.get("STORE_CODE");// ADDED for GHL-ICN-0032
				//added for GHL-CRF-0499 end
								
			%>
			<tr id="tr_<%=i%>">
				<%
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					expired_batch = expired_batch + 1;    %>
           <%
					 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
					String exp_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					String exp_status_days = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
				
			%>
					<td  class="<%=className%>" nowrap   name="expiry_date_or_receipt_date_<%=i%>" ><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%>
					<font class="DATAHIGHLIGHT"><center><%=exp_status+(String)hmBatchRecord.get("NOD")+exp_status_days%>
						</center></font>
					</td>
			<%	}else
						{
                      // String stTempStatus = "Expired";
					   String stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					   if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C")){
						   //stTempStatus ="Exp./Notified" ;
						   stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Notified.label","st_labels");
						   %>
                  				<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
						   <%
							 } else if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S")){
							//stTempStatus ="Exp./Suspnd" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Suspend.label","st_labels");
					   %>
<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
<%                  } else {	%> 
		<td  class="<%=className%>" nowrap    name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
		<%
               }
					} 
					  	} else {
						 
					  		if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C"))
				{ %>
				 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >				<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></font></center>
                 </td>
				<%
				}
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{ 	%>
							 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >		<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></font></center>	</td>
						<% 
				} 
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("A"))
				{ 
				
				%>
				     <td  class="<%=className%>"  >
						<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%></center>
                     </td>
                 <% 
				       }
			                } %>
					<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					
					<!-- added for GHL-CRF-0499 START -->
					<% if( site_main){ 
						challanNo = bean.getChallanNo(itemCd, batchID, expDate,storeCd); //MODIFIED FOR ghl-icn-0032
					%>
					<td class="<%=className%>" nowrap  name="challan_no_<%=i%>" ><%=bean.checkForNull(challanNo,"&nbsp;")%></td>
					<% } %>
					<!-- added for GHL-CRF-0499 END-->
					
					<td class="<%=className%>" ><%=bean.checkForNull((String)hmBatchRecord.get("TRADE_NAME"),(String)hmBatchRecord.get("TRADE_ID"))%></td>
					<td class="<%=className%>"  ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<td class="<%=className%>" nowrap  name="avail_qty" style="TEXT-ALIGN:right"><span id="id_stock_avail_<%=i%>"><%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_of_decimals)%></span>&nbsp;</td>
					<td class="<%=className%>" nowrap ><select class="STSMALL" name="to_bin_location_code_<%=i%>" id="to_bin_location_code_<%=i%>"><%=bean.getSTITBin_location_code_List(to_store_code,(String)hmBatchRecord.get("ITEM_CODE"),(String)hmBatchRecord.get("TO_BIN_LOCATION_CODE"),locale)%></select></td>
					<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=8 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="return CheckDtlQuantity('<%=i%>');" value="<%=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals)%>"  <%=Qty_disabled%> <%=batchChangeEnabled%> >
					<input type="hidden" value="<%=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals)%>" name="Batchqty<%=i%>" /><!--Added for TTM-SCF-0198-->
					
					</td>
			</tr>
					
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_DATE")%>">
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="trade_name_<%=i%>" id="trade_name_<%=i%>" value="<%=hmBatchRecord.get("TRADE_NAME")%>">
					<input type="hidden" name="avail_qty_<%=i%>" id="avail_qty_<%=i%>" value="<%=hmBatchRecord.get("AVAIL_QTY")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
					<input type="hidden" name="bin_desc_<%=i%>" id="bin_desc_<%=i%>" value="<%=hmBatchRecord.get("BIN_DESC")%>">
                    <input type="hidden" name="manufacturer_name_<%=i%>" id="manufacturer_name_<%=i%>" value="<%=hmBatchRecord.get("MANUFACTURER_NAME")%>">
					<input type="hidden" name="nod_<%=i%>" id="nod_<%=i%>" value="<%=hmBatchRecord.get("NOD")%>">
					<input type="hidden" name="expiry_yn_<%=i%>" id="expiry_yn_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_YN")%>">
                    <input type="hidden" name="batch_status_<%=i%>" id="batch_status_<%=i%>" value="<%=hmBatchRecord.get("BATCH_STATUS")%>">
					
			<%  
				decimal_allowed_yn = bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"));
				
				}	%>
			<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=decimal_allowed_yn%>">
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			
			<input type="hidden" name="expired_batch" id="expired_batch" value="<%=expired_batch%>">
			<input type="hidden" name="ex_param_days" id="ex_param_days" value="<%=EWDays%>">
			<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>">
			<input type="hidden" name="remarks" id="remarks" value="<%=remarks%>">
			<input type="hidden" name="remarks_code" id="remarks_code" value="<%=remarks_code%>">
			
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
			<input type="hidden" name="issuing_qty" id="issuing_qty" value="<%=item_qty%>">
			<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
			<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
			<input type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
			<input type="hidden" name="index" id="index"	 value="<%=index%>">
			<input type="hidden"		name="total_batch_qty" id="total_batch_qty"			 value="">
		
		</table>
		<br>
		<table border='0' width='100%' cellpadding='0' cellspacing='0' align=center> 
		<tr align=right>
		<td>
			<input class="button" type="button" name="batch_search" id="batch_search" value='<fmt:message key="eST.ChangeBatch.label" bundle="${st_labels}"/>' <%=batchChangeEnabled%> onClick="callBatchSearch();">
			&nbsp;&nbsp;
			<input align=right class="button" type="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="exitBatchSearch();">
		</td>	
		</tr>	
		</table>	
		
		</form>
			
	
<% 		
}catch (eST.Common.InsufficientBatchException insufficientBatchException){ %>
		<!--Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg-->
			<script>alert(getMessage("INSUFFICIENT_BATCH_QTY","ST")); 
			window.close();
			</script>
		<!--Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end-->
			<% insufficientBatchException.printStackTrace();
		}
		 catch (Exception exception) {
			exception.printStackTrace();
			}
		//added for ghl-crf-0499
		finally{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}
		%>
		<%
putObjectInBean("authorizeAtIssueStoreBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);
%>		
	</body>
</html>

