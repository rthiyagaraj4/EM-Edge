<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.MultiBatchDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body>
<%
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String delivery_qty						=				request.getParameter("order_qty");
	String tot_qty							=				request.getParameter("order_qty");	
	String item_desc						=				request.getParameter("item_desc");
	String item_code						=				request.getParameter("item_code");
	String delivery_uom_desc				=				request.getParameter("temp_uom");
	String delivery_uom_code				=				request.getParameter("temp_uom_code");
	String free_qty							=				request.getParameter("free_qty");
	String do_free_qty						=				request.getParameter("free_qty");
	String sample_qty						=				request.getParameter("sample_qty");
	String do_sample_qty					=				request.getParameter("sample_qty");
	String delivery_price					=				request.getParameter("delivery_price");
	String do_delivery_price				=				request.getParameter("delivery_price");
	String function_id						=				request.getParameter("function_id");
	String facility_id = "";
	String store_code = "";
	String delv_uom = "";
	String delv_uom_desc = "";
	String batch_id = "";
	String expiry_date = "";
	String trade_id = "";
	String item_disabled = "";
	DeliveryOrderBean bean					=				(DeliveryOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date							=				bean.getSystemDate();
	String po_no							=				bean.checkForNull(request.getParameter("po_no"));
	String delv_date							=				bean.checkForNull(request.getParameter("delv_date"));
	String request_no							=				bean.checkForNull(request.getParameter("request_no"));
	String po_srl_no							=				bean.checkForNull(request.getParameter("po_srl_no"));
	String str_cd							=				bean.checkForNull(request.getParameter("store_code"));
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
//	int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	int max_rows = 5;
	String item_code1 = "";
	ArrayList hmExpRecords		= new ArrayList();

		System.out.println("item_code in Batch details = "+item_code);
		System.out.println("getBatchRecords in dBatch details = "+bean.getBatchRecords());
		
		if(po_no!=""){
			item_code1 = item_code+po_no+delv_date+request_no;
			System.out.println("item_code1 in Batch details = "+item_code1);
		}else{
			item_code1 = item_code;
		}
	ArrayList alDelvRecords		= new ArrayList();	
	if(bean.getBatchRecords(item_code1) != null && bean.getBatchRecords(item_code1).size()>0){
		hmExpRecords = (ArrayList)bean.getBatchRecords(item_code1);
		System.out.println("hmExpRecords = "+hmExpRecords);
		max_rows  = hmExpRecords.size();		
	}
	else{
		
		alDelvRecords = bean.getBatchDetailsData(bean.getDoc_no(),item_code,po_no,delv_date,request_no);
		if(alDelvRecords.size() > 0)
			max_rows  =  alDelvRecords.size();
					
	}

	int y=0;
	
	HashMap hmRecord = bean.getUomDesc(delivery_uom_code);
			if(hmRecord.size()>0){
				delivery_uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
	
	HashMap hmItemRecord		=	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ITEM_SELECT_FOR_DO"),item_code);
	System.out.println("hmItemRecord = "+hmItemRecord);
	String  batch_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("BATCH_ID_APPLICABLE_YN"),"N");
	String	trade_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("TRADE_ID_APPLICABLE_YN"),"N");
	String	expiry_yn				=bean.checkForNull((String)hmItemRecord.get("EXPIRY_YN"),"N");	
	String disable_batch_id="";
	String disable_expiry_date="";
	String expiry_date1="";
	String default_batch_id="";
	String default_trade_id="";
	String default_trade_id_new ="";
	
	String fsDisabled = "";
	if((req_facility_id.equals("*A") || req_facility_id.equals("ALL") || req_facility_id.equals("")  ) && (str_cd.equals("*A") || str_cd.equals("ALL") || str_cd.equals("")) ){
		fsDisabled = "";
	}else{
		fsDisabled = "disabled";
	}
	
	
	ArrayList alRecord = new ArrayList();
	alRecord.add(str_cd);
	alRecord.add(item_code);
						
	String def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord).get("DEF_ISSUE_UOM");
	System.out.println("def_uom in do batch dtl = "+def_uom);
	String def_uom_desc = "";					 						 
	 if(def_uom != null && def_uom != ""){
		 def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
	}	
	

	System.out.println("mode in do batch details = "+mode);
	
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
	System.out.println("shelfLifeDate = "+shelfLifeDate);
		
%>
<form name="formDOBatchDetails" id="formDOBatchDetails">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes>
	<tr>
			<td class="label" colspan=4><b><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/></b>&nbsp;
				<%=item_code%>  &nbsp;&nbsp;  <%=item_desc%>
			</td>
			<td class="label" colspan=5><b>Total Delivered Quantity : </b><%=delivery_qty%> &nbsp;&nbsp; <%=delivery_uom_desc%>
			</td>
		</tr>
		
		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><tr>
		<tr>
			<th><fmt:message key="ePO.Facility.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.Store.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.DeliveryQty.label" bundle="${po_labels}"/></th>
			<!--<th><fmt:message key="ePO.StockUOM.label" bundle="${po_labels}"/></th> Commented by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 -->
			<th><fmt:message key="ePO.DoUOM.label" bundle="${po_labels}"/></th><!-- Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356  -->
			<th><fmt:message key="ePO.FreeQty.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.SampleQty.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.ExpiryDate.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.BatchId.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.TradeName.label" bundle="${po_labels}"/></th>
			
		</tr>
		<tr></tr>
		<%			
			int ct=0;
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				
				if(bean.getBatchRecords(item_code1) != null){
					HashMap hm = (HashMap)hmExpRecords.get(cnt);
					facility_id = bean.checkForNull((String)hm.get("FACILITY_CODE"));
					store_code = bean.checkForNull((String)hm.get("STORE_CODE"));
					delivery_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
					free_qty = bean.checkForNull((String)hm.get("FREE_QTY"));
					sample_qty = bean.checkForNull((String)hm.get("SAMPLE_QTY"));
					delv_uom =  bean.checkForNull((String)hm.get("DELV_UOM"));
					delivery_price = bean.checkForNull((String)hm.get("DELV_PRICE"));
					batch_id = bean.checkForNull((String)hm.get("BATCH_ID"));
					expiry_date = bean.checkForNull((String)hm.get("EXPIRY_DATE"));
					trade_id = bean.checkForNull((String)hm.get("TRADE_ID"));
				}
				
				
				if(alDelvRecords != null && alDelvRecords.size() > 0 ){
					
				//if(ct < max_rows){
				//	for(int i=0;i<alDelvRecords.size();i++){
						HashMap hm = (HashMap)alDelvRecords.get(cnt);
					System.out.println("hm = "+hm);
					facility_id = bean.checkForNull((String)hm.get("FACILITY_CODE"));
					store_code = bean.checkForNull((String)hm.get("STORE_CODE"));
					delivery_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
					free_qty = bean.checkForNull((String)hm.get("FREE_QTY"));
					sample_qty = bean.checkForNull((String)hm.get("SAMPLE_QTY"));
					delv_uom =  bean.checkForNull((String)hm.get("DELV_UOM"));
					delivery_price = bean.checkForNull((String)hm.get("DELV_PRICE"));
					batch_id = bean.checkForNull((String)hm.get("BATCH_ID"));
					expiry_date = bean.checkForNull((String)hm.get("EXPIRY_DATE"));
					trade_id = bean.checkForNull((String)hm.get("TRADE_ID"));
					
					
					if(max_rows==5 && cnt!=0 && facility_id == ""){
						facility_id = "";
						store_code = "";
						delivery_qty="";
						free_qty = "";
						sample_qty = "";
						delv_uom = "";
						delivery_price = "";
						batch_id = "";	
						expiry_date = "";
						trade_id = "";
					
					}
					
					
					
					
				

				//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end	



				
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,(String)hm.get("TRADE_ID"));
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull((String)hm.get("TRADE_ID"),default_trade_id));
				}	
					
			//	delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	 
			
				ArrayList alRecord1 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				System.out.println("str_cd if = "+str_cd);
				alRecord1.add(str_cd);
				alRecord1.add(item_code);
			}else{
				System.out.println("store_code else = "+store_code);
				alRecord1.add(store_code);
				alRecord1.add(item_code);
			}	
			System.out.println("alRecord1 = "+alRecord1);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord1).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 1 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}
			
				
		%>				
		<tr>
		<% if(facility_id != null && facility_id != "") {%>
				<td  align='left'>&nbsp;
						<select name="facility_id_<%=ct%>" id="facility_id_<%=ct%>" onchange="loadStore(this,'<%=ct%>');" <%=fsDisabled%>>
						<%=bean.getFacilityList(facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
						<select name="facility_id_<%=ct%>" id="facility_id_<%=ct%>" onchange="loadStore(this,'<%=ct%>');" <%=fsDisabled%> >
						<%=bean.getFacilityList(req_facility_id)%>
					</select>
			</td>
			<%}%>
			<% if(store_code != null && store_code != "" ) {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=ct%>" id="req_store_code_<%=ct%>" onchange="loadUOM(this,'<%=item_code%>','<%=ct%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=ct%>');" <%=fsDisabled%>>
						<%=bean.getRequestByStoreList(store_code,facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=ct%>" id="req_store_code_<%=ct%>" onchange="loadUOM(this,'<%=item_code%>','<%=ct%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=ct%>');" <%=fsDisabled%> >
						<%=bean.getRequestByStoreList(str_cd,req_facility_id)%>
					</select>
			</td>
			<%}%>
			
			<td  align="right">
				<input type="text"  name="delivery_qty_<%=ct%>" id="delivery_qty_<%=ct%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(delivery_qty)%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" > 
			</td>
			<%if(delv_uom_desc != null && delv_uom_desc != "") {%>
			<td  align="center"><label id='uom_label_<%=ct%>' class="label" ><%=bean.checkForNull(delv_uom_desc)%></label>
				<input type="hidden"  name="delivery_uom_<%=ct%>" id="delivery_uom_<%=ct%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(delv_uom)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<%} else {%>
			<td  align="center"><label id='uom_label_<%=ct%>' class="label" ><%=bean.checkForNull(delivery_uom_desc)%><!--bean.checkForNull(def_uom_desc) Modified by suresh.r on 04-06-2014 against ML-BRU-SCF-1356--></label>
				<input type="hidden"  name="delivery_uom_<%=ct%>" id="delivery_uom_<%=ct%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(def_uom)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<%}%>
					
			<td  align="right">
				<input type="text"  name="free_qty_<%=ct%>" id="free_qty_<%=ct%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(free_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<td  align="right">
				<input type="text"  name="sample_qty_<%=ct%>" id="sample_qty_<%=ct%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(sample_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			
			<td  align="right">
				<input type="text"  name="expiry_date_<%=ct%>" id="expiry_date_<%=ct%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(expiry_date)%>" <%=disable_expiry_date%>  onBlur="CheckMaxYearForExpiryDate(this,'<%=locale%>');getBatchIDFromExpiryDate(expiry_date_<%=ct%>,<%=ct%>);"> &nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_<%=ct%>');"  <%=disable_expiry_date%> ></img>
				
			</td>
			<td  align="right"><!--modified by B.Badmavathi against ML-BRU-SCF-1616 -->
				<input type="text"  name="batch_id_<%=ct%>" id="batch_id_<%=ct%>"  class=UPPER  size="20" maxlength="20"  value="<%=bean.checkForNull(batch_id)%>" onKeyPress="return  CheckForSpecialChars1(event);" <%=disable_batch_id%>  onBlur=""> 
			</td>
			<td  align="right">
				<select class="STSMALL" name="trade_id_<%=ct%>" id="trade_id_<%=ct%>" >
					<%=default_trade_id_new%>
				</select>	
			</td>
			
			<input type="hidden" 	name="dist_conv_fact_<%=ct%>" id="dist_conv_fact_<%=ct%>"	value="1">
			<input type="hidden" name="delivery_price_<%=ct%>" id="delivery_price_<%=ct%>" class='NUMBER' size="12" maxlength="12"  value="<%=bean.checkForNull(delivery_price)%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="">
			<input type=hidden name="shelf_life_exp_date_<%=ct%>" id="shelf_life_exp_date_<%=ct%>">  <!-- Added for #Inc no:40591 on 07-JUN-2013 -->
			
		</tr>
				
		<%
			ct++; 
			//		}
			//	}				
				} else {
				
					
								
					if(max_rows==5 && cnt!=0 && facility_id == ""){
						facility_id = "";
						store_code = "";
						delivery_qty="";
						free_qty = "";
						sample_qty = "";
						delv_uom = "";
						delivery_price = "";
						batch_id = "";
						expiry_date = "";
						trade_id = "";
					
					}
					
					
					
					
					
					
					//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end
					
					
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,trade_id);
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull(trade_id,default_trade_id));
				}	
				// delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	
				
			 
				 ArrayList alRecord2 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				alRecord2.add(str_cd);
				alRecord2.add(item_code);
			}else{
				alRecord2.add(store_code);
				alRecord2.add(item_code);
			}	
			
			System.out.println("alRecord2 = "+alRecord2);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord2).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 2 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}	
				 
				
		%>				
		<tr>
			<% if(facility_id != null && facility_id != "") {%>
				<td  align='left'>&nbsp;
						<select name="facility_id_<%=cnt%>" id="facility_id_<%=cnt%>" onchange="loadStore(this,'<%=cnt%>');" <%=fsDisabled%> >
						<%=bean.getFacilityList(facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
						<select name="facility_id_<%=cnt%>" id="facility_id_<%=cnt%>" onchange="loadStore(this,'<%=cnt%>');" <%=fsDisabled%> >
						<%=bean.getFacilityList(req_facility_id)%>
					</select>
			</td>
			<%}%>
			<% if(store_code != null && store_code != "") {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=cnt%>" id="req_store_code_<%=cnt%>" onchange="loadUOM(this,'<%=item_code%>','<%=cnt%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=cnt%>');" <%=fsDisabled%>>
						<%=bean.getRequestByStoreList(store_code,facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=cnt%>" id="req_store_code_<%=cnt%>" onchange="loadUOM(this,'<%=item_code%>','<%=cnt%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=cnt%>');"  <%=fsDisabled%>>
						<%=bean.getRequestByStoreList(str_cd,req_facility_id)%>
					</select>
			</td>
			<%}%>
			<td  align="right">
				<input type="text" name="delivery_qty_<%=cnt%>" id="delivery_qty_<%=cnt%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(delivery_qty)%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"> 
			</td>
			<%if(delv_uom_desc != null && delv_uom_desc != "") {%>
			<td  align="center"><label id='uom_label_<%=cnt%>' class="label" ><%=bean.checkForNull(delv_uom_desc)%></label>
				<input type="hidden"  name="delivery_uom_<%=cnt%>" id="delivery_uom_<%=cnt%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(delv_uom)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<%}else{%>
			<td  align="center"><label id='uom_label_<%=cnt%>' class="label" ><%=bean.checkForNull(delivery_uom_desc) %><!--bean.checkForNull(def_uom_desc) Modified by suresh.r on 04-06-2014 against ML-BRU-SCF-1356--> </label>
				<input type="hidden"  name="delivery_uom_<%=cnt%>" id="delivery_uom_<%=cnt%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(def_uom)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<%}%>
			<td  align="right">
				<input type="text" name="free_qty_<%=cnt%>" id="free_qty_<%=cnt%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(free_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<td  align="right">
				<input type="text" name="sample_qty_<%=cnt%>" id="sample_qty_<%=cnt%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(sample_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			
			<td  align="right">
				<input type="text"  name="expiry_date_<%=cnt%>" id="expiry_date_<%=cnt%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(expiry_date)%>" <%=disable_expiry_date%>  onBlur="CheckMaxYearForExpiryDate(this,'<%=locale%>');getBatchIDFromExpiryDate(expiry_date_<%=cnt%>,<%=cnt%>);" > &nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_<%=cnt%>');"  <%=disable_expiry_date%>></img>
				
			</td>
			<td  align="right"><!--modified by B.Badmavathi against ML-BRU-SCF-1616 -->
				<input type="text"  name="batch_id_<%=cnt%>" id="batch_id_<%=cnt%>"  class=UPPER size="20" maxlength="20"  value="<%=bean.checkForNull(batch_id)%>"   <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars1(event);" onBlur=""> 
			</td>
			<td  align="right">
				<select class="STSMALL" name="trade_id_<%=cnt%>" id="trade_id_<%=cnt%>" >
					<%=default_trade_id_new%>
				</select>	
			</td>
			
			<input type="hidden" 	name="dist_conv_fact_<%=cnt%>" id="dist_conv_fact_<%=cnt%>"	value="1">
			<input type="hidden" name="delivery_price_<%=cnt%>" id="delivery_price_<%=cnt%>" class='NUMBER' size="12" maxlength="12"  value="<%=bean.checkForNull(delivery_price)%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="">
			<input type=hidden name="shelf_life_exp_date_<%=cnt%>" id="shelf_life_exp_date_<%=cnt%>"> <!-- Added for #Inc no:40591 on 07-JUN-2013 -->
		</tr>
				
		<%
								
				}
					
				y =  cnt;
				
				%>
			
		 <%		
			}
			
				y++;
				for ( int j=y ; j<5; j++ ) {
					System.out.println("y = "+y);
					if(j!=0 ){
					facility_id = "";
					store_code = "";		
					delivery_qty = "";
					free_qty = "";
					sample_qty = "";
					delv_uom = "";
					delivery_price = "";
					batch_id = "";
					expiry_date = "";
					trade_id = "";
					
					}
					
					
					//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end
					
					
					
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,trade_id);
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull(trade_id,default_trade_id));
				}	

			//	delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	
			
			ArrayList alRecord3 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				alRecord3.add(str_cd);
				alRecord3.add(item_code);
			}else{
				alRecord3.add(store_code);
				alRecord3.add(item_code);
			}	
			
			System.out.println("alRecord3 = "+alRecord3);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord3).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 3 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}
			
		System.out.println("str_cd = "+str_cd);
		System.out.println("req_facility_id = "+req_facility_id);		
		%>				
		<tr>
		<% if(facility_id != null && facility_id != "") {%>
				<td  align='left'>&nbsp;
						<select name="facility_id_<%=j%>" id="facility_id_<%=j%>" onchange="loadStore(this,'<%=j%>');" <%=fsDisabled%>>
						<%=bean.getFacilityList(facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
						<select name="facility_id_<%=j%>" id="facility_id_<%=j%>" onchange="loadStore(this,'<%=j%>');" <%=fsDisabled%> >
						<%=bean.getFacilityList(req_facility_id)%>
					</select>
			</td>
			<%}%>
			<% if(store_code != null && store_code != "") {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=j%>" id="req_store_code_<%=j%>" onchange="loadUOM(this,'<%=item_code%>','<%=j%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=j%>');" <%=fsDisabled%>>
						<%=bean.getRequestByStoreList(store_code,facility_id)%>
					</select>
			</td>
			<%} else {%>
			<td  align='left'>&nbsp;
					<select name="req_store_code_<%=j%>" id="req_store_code_<%=j%>" onchange="loadUOM(this,'<%=item_code%>','<%=j%>','<%=delivery_uom_code%>');" onblur = "checkDelvUOM('<%=j%>');" <%=fsDisabled%> >
						<%=bean.getRequestByStoreList(str_cd,req_facility_id)%>
					</select>
			</td>
			<%}%>
			<td  align="right">
				<input type="text" name="delivery_qty_<%=j%>" id="delivery_qty_<%=j%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(delivery_qty)%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"> 
			</td>
			<%if(delv_uom_desc != null && delv_uom_desc != "") {%>		
			<td  align="center"><label id='uom_label_<%=j%>' class="label" ><%=bean.checkForNull(delv_uom_desc)%></label>
				<input type="hidden"  name="delivery_uom_<%=j%>" id="delivery_uom_<%=j%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(delv_uom)%>" onKeyPress="" onBlur=""> 
			</td>
			<%}else{%>
			<td  align="center"><label id='uom_label_<%=j%>' class="label" ><%=bean.checkForNull(delivery_uom_desc)%><!--bean.checkForNull(def_uom_desc) Modified by suresh.r on 04-06-2014 against ML-BRU-SCF-1356--></label>
				<input type="hidden"  name="delivery_uom_<%=j%>" id="delivery_uom_<%=j%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(def_uom)%>" onKeyPress="" onBlur=""> 
			</td>
			<%}%>
			<td  align="right">
				<input type="text" name="free_qty_<%=j%>" id="free_qty_<%=j%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(free_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			<td  align="right">
				<input type="text"  name="sample_qty_<%=j%>" id="sample_qty_<%=j%>" class='NUMBER' size="10" maxlength="8"  value="<%=bean.checkForNull(sample_qty)%>" onKeyPress="return isValidInteger();" onBlur=""> 
			</td>
			
			<td  align="right">
				<input type="text"  name="expiry_date_<%=j%>" id="expiry_date_<%=j%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(expiry_date)%>" <%=disable_expiry_date%>  onBlur="CheckMaxYearForExpiryDate(this,'<%=locale%>');getBatchIDFromExpiryDate(expiry_date_<%=j%>,<%=j%>);"> &nbsp;	<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_<%=j%>');"  <%=disable_expiry_date%> ></img>
				
			</td>
			<td  align="right"><!--modified by B.Badmavathi against ML-BRU-SCF-1616 -->
				<input type="text"  name="batch_id_<%=j%>" id="batch_id_<%=j%>"  class=UPPER size="20" maxlength="20"  value="<%=bean.checkForNull(batch_id)%>"  <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars1(event);" onBlur=""> 
			</td>
			<td  align="right">
				<select class="STSMALL" name="trade_id_<%=j%>" id="trade_id_<%=j%>">
					<%=default_trade_id_new%>
				</select>	
			</td>
			
				<input type="hidden" 	name="dist_conv_fact_<%=j%>" id="dist_conv_fact_<%=j%>"	value="1">
				<input type="hidden" name="delivery_price_<%=j%>" id="delivery_price_<%=j%>" class='NUMBER' size="12" maxlength="12"  value="<%=bean.checkForNull(delivery_price)%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="">
				<input type=hidden name="shelf_life_exp_date_<%=j%>" id="shelf_life_exp_date_<%=j%>"> <!-- Added for #Inc no:40591 on 07-JUN-2013 -->
		</tr>
				
		<%
				}
				
		%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td> 
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right">
				<input type="button" align="right" class="button" name="Ok" id="Ok" value="  Ok  "  onClick="exitBatchDetails();" <%=item_disabled%>>
				
			</td>
					
		</tr>
	</table>
	<input type="hidden" 	name="sys_date" id="sys_date"				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="totalRecords" id="totalRecords"        	value="5">
	<input type="hidden" 	name="item_code" id="item_code"			value="<%=item_code%>">
	<input type="hidden" 	name="po_no" id="po_no"				value="<%=po_no%>">
	<input type="hidden" 	name="delv_date" id="delv_date"			value="<%=delv_date%>">
	<input type="hidden" 	name="tot_qty" id="tot_qty"				value="<%=tot_qty%>">
	<input type="hidden" 	name="do_free_qty" id="do_free_qty"			value="<%=do_free_qty%>">
	<input type="hidden" 	name="do_sample_qty" id="do_sample_qty"		value="<%=do_sample_qty%>">
	<input type="hidden" 	name="do_delivery_price" id="do_delivery_price"	value="<%=do_delivery_price%>">
	<input type="hidden" 	name="delivery_qty" id="delivery_qty"			value="">
	<input type="hidden" 	name="free_qty" id="free_qty"				value="">
	<input type="hidden" 	name="sample_qty" id="sample_qty"			value="">
	<input type="hidden" 	name="po_srl_no" id="po_srl_no"			value="<%=po_srl_no%>">
	<input type="hidden" 	name="request_no" id="request_no"			value="<%=request_no%>">
	<input type="hidden" 	name="req_facility_id" id="req_facility_id"			value="<%=req_facility_id%>">
	<input type="hidden" 	name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" 	name="batch_id_applicable_yn" id="batch_id_applicable_yn" value="<%=batch_id_applicable_yn%>">
	<input type="hidden" 	name="delivery_uom_desc" id="delivery_uom_desc" 	value="<%=delivery_uom_code%>">
	<input type="hidden" name="shelfLifeDate" id="shelfLifeDate"			value="<%=shelfLifeDate%>" >
	
	
	
	
	
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

