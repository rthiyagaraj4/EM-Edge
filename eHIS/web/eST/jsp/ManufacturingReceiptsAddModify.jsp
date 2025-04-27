
<%@ page import="eST.BatchSearchBean, eST.Common.*,eST.*,java.util.*, com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="javascript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language="javascript" src="../../eST/js/ManufacturingReceipts.js"></script>
</head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
		ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject("ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean",request);
		bean.setLanguageId(locale);
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		//String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
	//	String function_id = bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	//	String stock_item_yn = bean.checkForNull(request.getParameter("stock_item_yn"));
		String short_desc = bean.checkForNull(request.getParameter("short_desc"));
		String mode = bean.checkForNull(request.getParameter("mode"));
	//	String addToList = request.getParameter("addToList");
		ArrayList alBatchRecords = new ArrayList();
		HashMap hmBatchRecord = null;
	
	//	String BatchKey = "";
		String className	=	"";
	//	String date_legend="Expiry Dt";
		String date_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		String indicators="";
		String allow_deci_yn        =       "";
		int no_deci              =       0;
		allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =      bean.getNoOfDecimals();
			else
            no_deci   = 0;
	

		int EWDays = 0;
		int expired_batch = 0;
		int nod_expiry       = 0;
		try { 
			//out.println(function);

			EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
			if(function.equals("modify"))	{
				ArrayList ALDtlData=bean.getExpDetailsList();
				int size = ALDtlData.size();
				for(int j=0;j<size;j++) {
					if(bean.getDoc_type_code().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_TYPE_CODE"))) &&  bean.getDoc_no().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_NO"))) && item_code.equals((String)(((HashMap)ALDtlData.get(j)).get("ITEM_CODE"))) ) {
						alBatchRecords.add(ALDtlData.get(j));
					}
				}
			}
			else if(function.equals("edit"))	{
				StUtilities bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
				bean.setRefreshList(alBatchRecords);
				putObjectInBean("stUtilities",bean1,request);

			}
			else if(function.equals("default")){
      				//ArrayList alRecords1 =bean.getExpDetailsList();
					ArrayList alRecords=new ArrayList();
						 alRecords =bean.getExpDetailsList();
      			
				      			
				ArrayList al123Exptemp	=	new ArrayList();
				ArrayList al123	= null;
				HashMap  hashMap= null;
				for (int k=0;k<alRecords.size();k++){
			
					al123	=(ArrayList)	alRecords.get(k);
	
					for (int l=0;l<al123.size();l++){
							hashMap=(HashMap)al123.get(l);
						
							if(item_code.equals((String)(hashMap.get("ITEM_CODE"))) &&  
								store_code.equals((String)(hashMap.get("STORE_CODE")))) {
								al123Exptemp.add(al123.get(l));
							}
					}
				}
				alBatchRecords=al123Exptemp;

			}
			else
			{
				BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				bean.setRefreshList(alBatchRecords);
						if (alBatchRecords==null) {
							throw new Exception("No batch selected..");
						}
						if(alBatchRecords.size()==0)
		{
				ArrayList alRecords =bean.getExpDetailsList();

				ArrayList al123Exptemp	=	new ArrayList();
				ArrayList al123	= null;
				HashMap  hashMap= null;
				for (int k=0;k<alRecords.size();k++){
							al123	=(ArrayList)	alRecords.get(k);
							for (int l=0;l<al123.size();l++){
									hashMap=(HashMap)al123.get(l);
									if(item_code.equals((String)(hashMap.get("ITEM_CODE"))) &&  
										store_code.equals((String)(hashMap.get("STORE_CODE")))) {
										al123Exptemp.add(al123.get(l));
									}
							}
				}
				alBatchRecords=al123Exptemp;
			}
			putObjectInBean("batchSearchBean",bean2,request);

			}

			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				 date_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}
	%>
	<body >
		<form name='formListDetail' id='formListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align=center >
 			<tr>
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
			</tr>
			<%
		
				for(i=0;i<alBatchRecords.size();i++){

					hmBatchRecord=(HashMap)alBatchRecords.get(i);
					className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";

			%>
				<tr>
					<td class="<%=className%>" nowrap  name="expiry_date_or_receipt_date_<%=i%>" ><%=DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%>

					<%//change made on 26/08 to include the nod to expire 
					indicators = "";
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					      //Added by Rabbani #Inc no:29950 on 28/MAR/2013 Starts
					       if(Integer.parseInt((String)hmBatchRecord.get("NOD")) < nod_expiry){
						    nod_expiry = Integer.parseInt((String)hmBatchRecord.get("NOD"));
						   }
						expired_batch = expired_batch + 1;
						 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
							String exp_leg= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
							String days_leg= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
								indicators =	exp_leg+(String)hmBatchRecord.get("NOD")+days_leg ;
						}
						else{
							indicators = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
						}
					}
					
					if ( ((String)hmBatchRecord.get("BATCH_STATUS")) != null &&   ((String)hmBatchRecord.get("BATCH_STATUS")).equals("C") ) {
						indicators = indicators + " / "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Notified.label","st_labels");

						}
						//Added by Rabbani #Inc no:29950 on 01/MAR/2013 Starts
						if(nod_expiry == 0){
						  nod_expiry = Integer.parseInt((String)hmBatchRecord.get("NOD"));
						 }
					%>	
					
					<br><font class="DATAHIGHLIGHT"><%=indicators%></font>

					</td>
					<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>" ><%=hmBatchRecord.get("TRADE_NAME")%></td>
					<td class="<%=className%>" ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align AVAIL_QTY.				
					-->
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=hmBatchRecord.get("AVAIL_QTY")%>&nbsp;</td>
					<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=12 maxlength=11 class="NUMBER" value="<%=bean.checkForNull(bean.setNumber((String)hmBatchRecord.get("QTY"),no_deci))%>" onKeyPress="allow_restrict_decimals1(this,event);" onBlur="CheckQty(this,'<%=bean.checkForNull((String)hmBatchRecord.get("QTY"))%>',available_qty_<%=i%>.value);"></td>
				</tr>
					<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_deci)%>">
			<%	}
			%>
			<input type="hidden" name="item_qty_parent" id="item_qty_parent" value="">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="index" id="index" value="<%=index%>">
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
			<input type='hidden' name='preptype' id='preptype' >
			<input type='hidden' name='prepmode' id='prepmode' >
			<input type="hidden" name="expired_batch" id="expired_batch" value="<%=expired_batch%>">
			<input type="hidden" name="ex_param_days" id="ex_param_days" value="<%=EWDays%>">
			<input type="hidden" name="allow_deci_yn" id="allow_deci_yn" 	value="<%=allow_deci_yn%>">
	        <input type="hidden" name="no_deci" id="no_deci" value="<%=no_deci%>">
			<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="Y">
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_deci%>">
			<input type="hidden" name="nod_expiry" id="nod_expiry" value="<%=nod_expiry%>"> 
	</form>
	<script language="JavaScript">
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
					out.println("<script>parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=APP-ST0040 Insufficient batch quantity for item: "+short_desc+"';parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
					insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
		}
%>
<%
putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
	</body>
</html>

